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
    File cgq;
    private boolean esA;
    e esw;
    T esx;
    AtomicBoolean esy = new AtomicBoolean(false);
    c<T> esz;

    public f(e eVar, T t, c<T> cVar) {
        this.esw = eVar;
        this.esx = t;
        this.esz = cVar;
    }

    public void iC(boolean z) {
        if (this.esy.get() != z) {
            this.esy.set(z);
        }
    }

    public boolean k(f<T> fVar) {
        return (fVar == null || fVar.esw == null || fVar.esw.esv == null || this.esw == null || this.esw.esv == null || !this.esw.esv.equals(fVar.esw.esv)) ? false : true;
    }

    public com.baidu.swan.pms.a.c<T> bcK() {
        return this.esz;
    }

    public T bcL() {
        return this.esx;
    }

    public int getTaskState() {
        return this.esw.esv.state;
    }

    public void bcM() {
        lS(1);
        this.esz.S(this.esx);
    }

    public void bcN() {
        this.esz.R(this.esx);
    }

    public void bcO() {
        lS(2);
        this.esz.ak(this.esx);
    }

    public void atE() {
        lS(10);
        this.esz.Q(this.esx);
    }

    public void bcP() {
        lS(3);
        this.esz.a((c<T>) this.esx, this.esw.esu);
    }

    public boolean lS(int i) {
        if (this.esw.esv.state != i) {
            this.esw.esv.state = i;
            if (i == 2 || i == 3 || i == 10) {
                iC(true);
                return true;
            }
            iC(false);
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bcc().getProcessName() + ": run:" + this.esw.esv.downloadUrl);
        }
        j jVar = new j(this);
        while (true) {
            if (this.esw.esu == null || this.esw.esu.errorNo != 2200) {
                if (this.esy.get()) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bcc().getProcessName() + ": stopped:" + this.esw.esv.downloadUrl);
                    }
                    bcO();
                    return;
                }
                jVar.bcW();
                if (this.esw.esu != null) {
                    switch (this.esw.esu.errorNo) {
                        case 2200:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bcc().getProcessName() + ": success download:" + this.esw.esv.downloadUrl);
                            }
                            atE();
                            return;
                        default:
                            if (this.esy.get()) {
                                if (com.baidu.swan.pms.d.DEBUG) {
                                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bcc().getProcessName() + ": stopped:" + this.esw.esv.downloadUrl);
                                }
                                bcO();
                                return;
                            }
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bcc().getProcessName() + ": retry download:" + this.esw.esv.downloadUrl);
                            }
                            this.esz.mRetryCount++;
                            if (this.esz.mRetryCount < 3) {
                                try {
                                    if (!this.esy.get()) {
                                        Thread.sleep(this.esz.mRetryCount * 1000);
                                        break;
                                    } else {
                                        break;
                                    }
                                } catch (InterruptedException e) {
                                    break;
                                }
                            } else {
                                bcP();
                                a(this.esw.esu.errorNo, this.esw.esv);
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
    public boolean bcQ() {
        if (TextUtils.isEmpty(this.esw.esv.filePath)) {
            this.cgq = com.baidu.swan.pms.utils.d.dy(this.esz.U(this.esx), this.esw.esv.md5);
            if (this.cgq == null) {
                this.esz.a((c<T>) this.esx, new com.baidu.swan.pms.model.a(2203, "download : path not available"));
                return false;
            }
            this.esw.esv.filePath = this.cgq.getAbsolutePath();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dp(long j) {
        boolean z = false;
        String U = this.esz.U(this.esx);
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
                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bcc().getProcessName() + ": path exception or no space left." + th.toString());
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
                    jSONObject.put("appId", eVar.erV);
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
        return Objects.hash(this.esw.esv);
    }

    public int bcR() {
        return new com.baidu.swan.pms.c.a.b.a().C(this.esz.bce()).intValue();
    }

    public String toString() {
        return "downloadUrl:" + this.esw.esv.downloadUrl + ",versionName:" + this.esw.esv.versionName + ",versionCode:" + this.esw.esv.versionCode + "md5:" + this.esw.esv.md5 + "bundleId:" + this.esw.esv.erV;
    }

    public void bcS() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bcc().getProcessName() + ": onNotifyPending" + this);
        }
        this.esA = true;
        iC(true);
    }

    public boolean bcT() {
        return this.esA;
    }

    public void iD(boolean z) {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bcc().getProcessName() + ": onResetPending" + this);
        }
        if (z) {
            this.esw.esv.currentSize = 0L;
        }
        lS(0);
        iC(false);
        this.esA = false;
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
