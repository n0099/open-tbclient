package com.baidu.swan.pms.c.a.d;

import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.down.common.intercepter.IIntercepter;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class f<T> implements Runnable {
    e dwH;
    T dwI;
    AtomicBoolean dwJ = new AtomicBoolean(false);
    c<T> dwK;
    private boolean dwL;
    File dwf;

    public f(e eVar, T t, c<T> cVar) {
        this.dwH = eVar;
        this.dwI = t;
        this.dwK = cVar;
    }

    public void gJ(boolean z) {
        if (this.dwJ.get() != z) {
            this.dwJ.set(z);
        }
    }

    public boolean k(f<T> fVar) {
        return (fVar == null || fVar.dwH == null || fVar.dwH.dwG == null || this.dwH == null || this.dwH.dwG == null || !this.dwH.dwG.equals(fVar.dwH.dwG)) ? false : true;
    }

    public com.baidu.swan.pms.a.c<T> aLw() {
        return this.dwK;
    }

    public T aLx() {
        return this.dwI;
    }

    public int aLy() {
        return this.dwH.dwG.state;
    }

    public void aLz() {
        jK(1);
        this.dwK.N(this.dwI);
    }

    public void aLA() {
        this.dwK.M(this.dwI);
    }

    public void aLB() {
        jK(2);
        this.dwK.ae(this.dwI);
    }

    public void aLC() {
        jK(10);
        this.dwK.L(this.dwI);
    }

    public void aLD() {
        jK(3);
        this.dwK.a((c<T>) this.dwI, this.dwH.dwF);
    }

    public boolean jK(int i) {
        if (this.dwH.dwG.state != i) {
            this.dwH.dwG.state = i;
            if (i == 2 || i == 3 || i == 10) {
                gJ(true);
                return true;
            }
            gJ(false);
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aKM().getProcessName() + ": run:" + this.dwH.dwG.downloadUrl);
        }
        j jVar = new j(this);
        while (true) {
            if (this.dwH.dwF == null || this.dwH.dwF.errorNo != 2200) {
                if (this.dwJ.get()) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aKM().getProcessName() + ": stopped:" + this.dwH.dwG.downloadUrl);
                    }
                    aLB();
                    return;
                }
                jVar.aLJ();
                if (this.dwH.dwF != null) {
                    switch (this.dwH.dwF.errorNo) {
                        case PushConstants.EXPIRE_NOTIFICATION /* 2200 */:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aKM().getProcessName() + ": success download:" + this.dwH.dwG.downloadUrl);
                            }
                            aLC();
                            return;
                        default:
                            if (this.dwJ.get()) {
                                if (com.baidu.swan.pms.d.DEBUG) {
                                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aKM().getProcessName() + ": stopped:" + this.dwH.dwG.downloadUrl);
                                }
                                aLB();
                                return;
                            }
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aKM().getProcessName() + ": retry download:" + this.dwH.dwG.downloadUrl);
                            }
                            this.dwK.mRetryCount++;
                            if (this.dwK.mRetryCount < 3) {
                                try {
                                    if (!this.dwJ.get()) {
                                        Thread.sleep(this.dwK.mRetryCount * 1000);
                                        break;
                                    } else {
                                        break;
                                    }
                                } catch (InterruptedException e) {
                                    break;
                                }
                            } else {
                                aLD();
                                a(this.dwH.dwF.errorNo, this.dwH.dwG);
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
    public boolean aLc() {
        if (TextUtils.isEmpty(this.dwH.dwG.filePath)) {
            this.dwf = com.baidu.swan.pms.f.d.cS(this.dwK.P(this.dwI), this.dwH.dwG.md5);
            if (this.dwf == null) {
                this.dwK.a((c<T>) this.dwI, new com.baidu.swan.pms.model.a(2203, "download : path not available"));
                return false;
            }
            this.dwH.dwG.filePath = this.dwf.getAbsolutePath();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean cc(long j) {
        boolean z = false;
        String P = this.dwK.P(this.dwI);
        if (P != null) {
            try {
                StatFs statFs = new StatFs(P);
                if (Build.VERSION.SDK_INT >= 18) {
                    z = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong() > j;
                } else {
                    z = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()) > j;
                }
            } catch (Throwable th) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aKM().getProcessName() + ": path exception or no space left." + th.toString());
                }
            }
        }
        return z;
    }

    private void a(int i, com.baidu.swan.pms.model.e eVar) {
        JSONException e;
        int i2;
        if (eVar != null) {
            JSONObject jSONObject = new JSONObject();
            if (i == 2200) {
                i2 = 0;
            } else {
                try {
                    jSONObject.put(IIntercepter.TYPE_RESPONSE, eVar.toString());
                    i2 = i;
                } catch (JSONException e2) {
                    e = e2;
                    i2 = i;
                    e.printStackTrace();
                    com.baidu.swan.pms.d.a.a(eVar.category, "pkg_download", null, i2, jSONObject);
                }
            }
            try {
                if (eVar instanceof com.baidu.swan.pms.model.f) {
                    jSONObject.put("appId", eVar.dvZ);
                }
            } catch (JSONException e3) {
                e = e3;
                e.printStackTrace();
                com.baidu.swan.pms.d.a.a(eVar.category, "pkg_download", null, i2, jSONObject);
            }
            com.baidu.swan.pms.d.a.a(eVar.category, "pkg_download", null, i2, jSONObject);
        }
    }

    public int hashCode() {
        return Objects.hash(this.dwH.dwG);
    }

    public int aLE() {
        return new com.baidu.swan.pms.c.a.b.a().r(this.dwK.aKO()).intValue();
    }

    public String toString() {
        return "downloadUrl:" + this.dwH.dwG.downloadUrl + ",versionName:" + this.dwH.dwG.versionName + ",versionCode:" + this.dwH.dwG.versionCode + "md5:" + this.dwH.dwG.md5 + "bundleId:" + this.dwH.dwG.dvZ;
    }

    public void aLF() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aKM().getProcessName() + ": onNotifyPending" + this);
        }
        this.dwL = true;
        gJ(true);
    }

    public boolean aLG() {
        return this.dwL;
    }

    public void gK(boolean z) {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aKM().getProcessName() + ": onResetPending" + this);
        }
        if (z) {
            this.dwH.dwG.currentSize = 0L;
        }
        jK(0);
        gJ(false);
        this.dwL = false;
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
