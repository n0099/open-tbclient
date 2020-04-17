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
    File bVK;
    e daO;
    T daP;
    AtomicBoolean daQ = new AtomicBoolean(false);
    c<T> daR;
    private boolean daS;

    public f(e eVar, T t, c<T> cVar) {
        this.daO = eVar;
        this.daP = t;
        this.daR = cVar;
    }

    public void fY(boolean z) {
        if (this.daQ.get() != z) {
            this.daQ.set(z);
        }
    }

    public boolean k(f<T> fVar) {
        return (fVar == null || fVar.daO == null || fVar.daO.daN == null || this.daO == null || this.daO.daN == null || !this.daO.daN.equals(fVar.daO.daN)) ? false : true;
    }

    public com.baidu.swan.pms.a.c<T> aCj() {
        return this.daR;
    }

    public T aCk() {
        return this.daP;
    }

    public int aCl() {
        return this.daO.daN.state;
    }

    public void aCm() {
        iO(1);
        this.daR.J(this.daP);
    }

    public void aCn() {
        this.daR.I(this.daP);
    }

    public void aCo() {
        iO(2);
        this.daR.Z(this.daP);
    }

    public void aCp() {
        iO(10);
        this.daR.H(this.daP);
    }

    public void aCq() {
        iO(3);
        this.daR.a((c<T>) this.daP, this.daO.daM);
    }

    public boolean iO(int i) {
        if (this.daO.daN.state != i) {
            this.daO.daN.state = i;
            if (i == 2 || i == 3 || i == 10) {
                fY(true);
                return true;
            }
            fY(false);
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aBC().getProcessName() + ": run:" + this.daO.daN.downloadUrl);
        }
        j jVar = new j(this);
        while (true) {
            if (this.daO.daM == null || this.daO.daM.errorNo != 2200) {
                if (this.daQ.get()) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aBC().getProcessName() + ": stopped:" + this.daO.daN.downloadUrl);
                    }
                    aCo();
                    return;
                }
                jVar.aCw();
                if (this.daO.daM != null) {
                    switch (this.daO.daM.errorNo) {
                        case PushConstants.EXPIRE_NOTIFICATION /* 2200 */:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aBC().getProcessName() + ": success download:" + this.daO.daN.downloadUrl);
                            }
                            aCp();
                            return;
                        default:
                            if (this.daQ.get()) {
                                if (com.baidu.swan.pms.d.DEBUG) {
                                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aBC().getProcessName() + ": stopped:" + this.daO.daN.downloadUrl);
                                }
                                aCo();
                                return;
                            }
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aBC().getProcessName() + ": retry download:" + this.daO.daN.downloadUrl);
                            }
                            this.daR.mRetryCount++;
                            if (this.daR.mRetryCount < 3) {
                                try {
                                    if (!this.daQ.get()) {
                                        Thread.sleep(this.daR.mRetryCount * 1000);
                                        break;
                                    } else {
                                        break;
                                    }
                                } catch (InterruptedException e) {
                                    break;
                                }
                            } else {
                                aCq();
                                a(this.daO.daM.errorNo, this.daO.daN);
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
    public boolean aBS() {
        if (TextUtils.isEmpty(this.daO.daN.filePath)) {
            this.bVK = com.baidu.swan.pms.f.c.cq(this.daR.L(this.daP), this.daO.daN.md5);
            if (this.bVK == null) {
                this.daR.a((c<T>) this.daP, new com.baidu.swan.pms.model.a(2203, "download : path not available"));
                return false;
            }
            this.daO.daN.filePath = this.bVK.getAbsolutePath();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bO(long j) {
        boolean z = false;
        String L = this.daR.L(this.daP);
        if (L != null) {
            try {
                StatFs statFs = new StatFs(L);
                if (Build.VERSION.SDK_INT >= 18) {
                    z = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong() > j;
                } else {
                    z = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()) > j;
                }
            } catch (Throwable th) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aBC().getProcessName() + ": path exception or no space left." + th.toString());
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
                    jSONObject.put("appId", eVar.dai);
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
        return Objects.hash(this.daO.daN);
    }

    public int aCr() {
        return new com.baidu.swan.pms.c.a.b.a().s(this.daR.aBE()).intValue();
    }

    public String toString() {
        return "downloadUrl:" + this.daO.daN.downloadUrl + ",versionName:" + this.daO.daN.versionName + ",versionCode:" + this.daO.daN.versionCode + "md5:" + this.daO.daN.md5 + "bundleId:" + this.daO.daN.dai;
    }

    public void aCs() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aBC().getProcessName() + ": onNotifyPending" + this);
        }
        this.daS = true;
        fY(true);
    }

    public boolean aCt() {
        return this.daS;
    }

    public void fZ(boolean z) {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aBC().getProcessName() + ": onResetPending" + this);
        }
        if (z) {
            this.daO.daN.currentSize = 0L;
        }
        iO(0);
        fY(false);
        this.daS = false;
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
