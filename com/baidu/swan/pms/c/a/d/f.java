package com.baidu.swan.pms.c.a.d;

import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.down.common.intercepter.IIntercepter;
import java.io.File;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f<T> implements Runnable {
    File cld;
    e exj;
    T exk;
    AtomicBoolean exl = new AtomicBoolean(false);
    c<T> exm;
    private boolean exn;

    public f(e eVar, T t, c<T> cVar) {
        this.exj = eVar;
        this.exk = t;
        this.exm = cVar;
    }

    public void iG(boolean z) {
        if (this.exl.get() != z) {
            this.exl.set(z);
        }
    }

    public boolean k(f<T> fVar) {
        return (fVar == null || fVar.exj == null || fVar.exj.exi == null || this.exj == null || this.exj.exi == null || !this.exj.exi.equals(fVar.exj.exi)) ? false : true;
    }

    public com.baidu.swan.pms.a.c<T> bgD() {
        return this.exm;
    }

    public T bgE() {
        return this.exk;
    }

    public int getTaskState() {
        return this.exj.exi.state;
    }

    public void bgF() {
        ny(1);
        this.exm.S(this.exk);
    }

    public void bgG() {
        this.exm.R(this.exk);
    }

    public void bgH() {
        ny(2);
        this.exm.ak(this.exk);
    }

    public void axx() {
        ny(10);
        this.exm.Q(this.exk);
    }

    public void bgI() {
        ny(3);
        this.exm.a((c<T>) this.exk, this.exj.exh);
    }

    public boolean ny(int i) {
        if (this.exj.exi.state != i) {
            this.exj.exi.state = i;
            if (i == 2 || i == 3 || i == 10) {
                iG(true);
                return true;
            }
            iG(false);
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bfV().getProcessName() + ": run:" + this.exj.exi.downloadUrl);
        }
        j jVar = new j(this);
        while (true) {
            if (this.exj.exh == null || this.exj.exh.errorNo != 2200) {
                if (this.exl.get()) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bfV().getProcessName() + ": stopped:" + this.exj.exi.downloadUrl);
                    }
                    bgH();
                    return;
                }
                jVar.bgP();
                if (this.exj.exh != null) {
                    switch (this.exj.exh.errorNo) {
                        case 2200:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bfV().getProcessName() + ": success download:" + this.exj.exi.downloadUrl);
                            }
                            axx();
                            return;
                        default:
                            if (this.exl.get()) {
                                if (com.baidu.swan.pms.d.DEBUG) {
                                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bfV().getProcessName() + ": stopped:" + this.exj.exi.downloadUrl);
                                }
                                bgH();
                                return;
                            }
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bfV().getProcessName() + ": retry download:" + this.exj.exi.downloadUrl);
                            }
                            this.exm.mRetryCount++;
                            if (this.exm.mRetryCount < 3) {
                                try {
                                    if (!this.exl.get()) {
                                        Thread.sleep(this.exm.mRetryCount * 1000);
                                        break;
                                    } else {
                                        break;
                                    }
                                } catch (InterruptedException e) {
                                    break;
                                }
                            } else {
                                bgI();
                                a(this.exj.exh.errorNo, this.exj.exi);
                                return;
                            }
                    }
                }
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bgJ() {
        if (TextUtils.isEmpty(this.exj.exi.filePath)) {
            this.cld = com.baidu.swan.pms.utils.d.dz(this.exm.U(this.exk), this.exj.exi.md5);
            if (this.cld == null) {
                this.exm.a((c<T>) this.exk, new com.baidu.swan.pms.model.a(2203, "download : path not available"));
                return false;
            }
            this.exj.exi.filePath = this.cld.getAbsolutePath();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dp(long j) {
        boolean z = false;
        String U = this.exm.U(this.exk);
        if (U != null) {
            try {
                StatFs statFs = new StatFs(U);
                if (Build.VERSION.SDK_INT >= 18) {
                    z = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong() > j;
                } else {
                    z = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()) > j;
                }
            } catch (Throwable th) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bfV().getProcessName() + ": path exception or no space left." + th.toString());
                }
            }
        }
        return z;
    }

    private void a(int i, com.baidu.swan.pms.model.e eVar) {
        int i2;
        if (eVar != null) {
            JSONObject jSONObject = new JSONObject();
            if (i == 2200) {
                i2 = 0;
            } else {
                try {
                    jSONObject.put(IIntercepter.TYPE_RESPONSE, eVar.toString());
                    i2 = i;
                } catch (JSONException e) {
                    e = e;
                    i2 = i;
                    e.printStackTrace();
                    com.baidu.swan.pms.f.a.a(eVar.category, "pkg_download", null, i2, jSONObject);
                }
            }
            try {
                if (eVar instanceof com.baidu.swan.pms.model.f) {
                    jSONObject.put("appId", eVar.ewI);
                }
            } catch (JSONException e2) {
                e = e2;
                e.printStackTrace();
                com.baidu.swan.pms.f.a.a(eVar.category, "pkg_download", null, i2, jSONObject);
            }
            com.baidu.swan.pms.f.a.a(eVar.category, "pkg_download", null, i2, jSONObject);
        }
    }

    public int hashCode() {
        return Objects.hash(this.exj.exi);
    }

    public int bgK() {
        return new com.baidu.swan.pms.c.a.b.a().C(this.exm.bfX()).intValue();
    }

    public String toString() {
        return "downloadUrl:" + this.exj.exi.downloadUrl + ",versionName:" + this.exj.exi.versionName + ",versionCode:" + this.exj.exi.versionCode + "md5:" + this.exj.exi.md5 + "bundleId:" + this.exj.exi.ewI;
    }

    public void bgL() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bfV().getProcessName() + ": onNotifyPending" + this);
        }
        this.exn = true;
        iG(true);
    }

    public boolean bgM() {
        return this.exn;
    }

    public void iH(boolean z) {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bfV().getProcessName() + ": onResetPending" + this);
        }
        if (z) {
            this.exj.exi.currentSize = 0L;
        }
        ny(0);
        iG(false);
        this.exn = false;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj == null || !(obj instanceof f)) {
            return false;
        }
        return k((f) obj);
    }
}
