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
/* loaded from: classes11.dex */
public class f<T> implements Runnable {
    File cgl;
    e dme;
    T dmf;
    AtomicBoolean dmg = new AtomicBoolean(false);
    c<T> dmh;
    private boolean dmi;

    public f(e eVar, T t, c<T> cVar) {
        this.dme = eVar;
        this.dmf = t;
        this.dmh = cVar;
    }

    public void gj(boolean z) {
        if (this.dmg.get() != z) {
            this.dmg.set(z);
        }
    }

    public boolean k(f<T> fVar) {
        return (fVar == null || fVar.dme == null || fVar.dme.dmd == null || this.dme == null || this.dme.dmd == null || !this.dme.dmd.equals(fVar.dme.dmd)) ? false : true;
    }

    public com.baidu.swan.pms.a.c<T> aGz() {
        return this.dmh;
    }

    public T aGA() {
        return this.dmf;
    }

    public int aGB() {
        return this.dme.dmd.state;
    }

    public void aGC() {
        jg(1);
        this.dmh.N(this.dmf);
    }

    public void aGD() {
        this.dmh.M(this.dmf);
    }

    public void aGE() {
        jg(2);
        this.dmh.ae(this.dmf);
    }

    public void aGF() {
        jg(10);
        this.dmh.L(this.dmf);
    }

    public void aGG() {
        jg(3);
        this.dmh.a((c<T>) this.dmf, this.dme.dmc);
    }

    public boolean jg(int i) {
        if (this.dme.dmd.state != i) {
            this.dme.dmd.state = i;
            if (i == 2 || i == 3 || i == 10) {
                gj(true);
                return true;
            }
            gj(false);
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aFP().getProcessName() + ": run:" + this.dme.dmd.downloadUrl);
        }
        j jVar = new j(this);
        while (true) {
            if (this.dme.dmc == null || this.dme.dmc.errorNo != 2200) {
                if (this.dmg.get()) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aFP().getProcessName() + ": stopped:" + this.dme.dmd.downloadUrl);
                    }
                    aGE();
                    return;
                }
                jVar.aGM();
                if (this.dme.dmc != null) {
                    switch (this.dme.dmc.errorNo) {
                        case PushConstants.EXPIRE_NOTIFICATION /* 2200 */:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aFP().getProcessName() + ": success download:" + this.dme.dmd.downloadUrl);
                            }
                            aGF();
                            return;
                        default:
                            if (this.dmg.get()) {
                                if (com.baidu.swan.pms.d.DEBUG) {
                                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aFP().getProcessName() + ": stopped:" + this.dme.dmd.downloadUrl);
                                }
                                aGE();
                                return;
                            }
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aFP().getProcessName() + ": retry download:" + this.dme.dmd.downloadUrl);
                            }
                            this.dmh.mRetryCount++;
                            if (this.dmh.mRetryCount < 3) {
                                try {
                                    if (!this.dmg.get()) {
                                        Thread.sleep(this.dmh.mRetryCount * 1000);
                                        break;
                                    } else {
                                        break;
                                    }
                                } catch (InterruptedException e) {
                                    break;
                                }
                            } else {
                                aGG();
                                a(this.dme.dmc.errorNo, this.dme.dmd);
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
    public boolean aGf() {
        if (TextUtils.isEmpty(this.dme.dmd.filePath)) {
            this.cgl = com.baidu.swan.pms.f.c.cN(this.dmh.P(this.dmf), this.dme.dmd.md5);
            if (this.cgl == null) {
                this.dmh.a((c<T>) this.dmf, new com.baidu.swan.pms.model.a(2203, "download : path not available"));
                return false;
            }
            this.dme.dmd.filePath = this.cgl.getAbsolutePath();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bM(long j) {
        boolean z = false;
        String P = this.dmh.P(this.dmf);
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
                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aFP().getProcessName() + ": path exception or no space left." + th.toString());
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
                    jSONObject.put("appId", eVar.dlx);
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
        return Objects.hash(this.dme.dmd);
    }

    public int aGH() {
        return new com.baidu.swan.pms.c.a.b.a().r(this.dmh.aFR()).intValue();
    }

    public String toString() {
        return "downloadUrl:" + this.dme.dmd.downloadUrl + ",versionName:" + this.dme.dmd.versionName + ",versionCode:" + this.dme.dmd.versionCode + "md5:" + this.dme.dmd.md5 + "bundleId:" + this.dme.dmd.dlx;
    }

    public void aGI() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aFP().getProcessName() + ": onNotifyPending" + this);
        }
        this.dmi = true;
        gj(true);
    }

    public boolean aGJ() {
        return this.dmi;
    }

    public void gk(boolean z) {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aFP().getProcessName() + ": onResetPending" + this);
        }
        if (z) {
            this.dme.dmd.currentSize = 0L;
        }
        jg(0);
        gj(false);
        this.dmi = false;
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
