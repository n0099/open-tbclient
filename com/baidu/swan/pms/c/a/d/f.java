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
    File bVQ;
    e daT;
    T daU;
    AtomicBoolean daV = new AtomicBoolean(false);
    c<T> daW;
    private boolean daX;

    public f(e eVar, T t, c<T> cVar) {
        this.daT = eVar;
        this.daU = t;
        this.daW = cVar;
    }

    public void fY(boolean z) {
        if (this.daV.get() != z) {
            this.daV.set(z);
        }
    }

    public boolean k(f<T> fVar) {
        return (fVar == null || fVar.daT == null || fVar.daT.daS == null || this.daT == null || this.daT.daS == null || !this.daT.daS.equals(fVar.daT.daS)) ? false : true;
    }

    public com.baidu.swan.pms.a.c<T> aCj() {
        return this.daW;
    }

    public T aCk() {
        return this.daU;
    }

    public int aCl() {
        return this.daT.daS.state;
    }

    public void aCm() {
        iO(1);
        this.daW.K(this.daU);
    }

    public void aCn() {
        this.daW.J(this.daU);
    }

    public void aCo() {
        iO(2);
        this.daW.aa(this.daU);
    }

    public void aCp() {
        iO(10);
        this.daW.I(this.daU);
    }

    public void aCq() {
        iO(3);
        this.daW.a((c<T>) this.daU, this.daT.daR);
    }

    public boolean iO(int i) {
        if (this.daT.daS.state != i) {
            this.daT.daS.state = i;
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
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aBC().getProcessName() + ": run:" + this.daT.daS.downloadUrl);
        }
        j jVar = new j(this);
        while (true) {
            if (this.daT.daR == null || this.daT.daR.errorNo != 2200) {
                if (this.daV.get()) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aBC().getProcessName() + ": stopped:" + this.daT.daS.downloadUrl);
                    }
                    aCo();
                    return;
                }
                jVar.aCw();
                if (this.daT.daR != null) {
                    switch (this.daT.daR.errorNo) {
                        case PushConstants.EXPIRE_NOTIFICATION /* 2200 */:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aBC().getProcessName() + ": success download:" + this.daT.daS.downloadUrl);
                            }
                            aCp();
                            return;
                        default:
                            if (this.daV.get()) {
                                if (com.baidu.swan.pms.d.DEBUG) {
                                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aBC().getProcessName() + ": stopped:" + this.daT.daS.downloadUrl);
                                }
                                aCo();
                                return;
                            }
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aBC().getProcessName() + ": retry download:" + this.daT.daS.downloadUrl);
                            }
                            this.daW.mRetryCount++;
                            if (this.daW.mRetryCount < 3) {
                                try {
                                    if (!this.daV.get()) {
                                        Thread.sleep(this.daW.mRetryCount * 1000);
                                        break;
                                    } else {
                                        break;
                                    }
                                } catch (InterruptedException e) {
                                    break;
                                }
                            } else {
                                aCq();
                                a(this.daT.daR.errorNo, this.daT.daS);
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
        if (TextUtils.isEmpty(this.daT.daS.filePath)) {
            this.bVQ = com.baidu.swan.pms.f.c.cq(this.daW.M(this.daU), this.daT.daS.md5);
            if (this.bVQ == null) {
                this.daW.a((c<T>) this.daU, new com.baidu.swan.pms.model.a(2203, "download : path not available"));
                return false;
            }
            this.daT.daS.filePath = this.bVQ.getAbsolutePath();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bO(long j) {
        boolean z = false;
        String M = this.daW.M(this.daU);
        if (M != null) {
            try {
                StatFs statFs = new StatFs(M);
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
                    jSONObject.put("appId", eVar.dan);
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
        return Objects.hash(this.daT.daS);
    }

    public int aCr() {
        return new com.baidu.swan.pms.c.a.b.a().s(this.daW.aBE()).intValue();
    }

    public String toString() {
        return "downloadUrl:" + this.daT.daS.downloadUrl + ",versionName:" + this.daT.daS.versionName + ",versionCode:" + this.daT.daS.versionCode + "md5:" + this.daT.daS.md5 + "bundleId:" + this.daT.daS.dan;
    }

    public void aCs() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aBC().getProcessName() + ": onNotifyPending" + this);
        }
        this.daX = true;
        fY(true);
    }

    public boolean aCt() {
        return this.daX;
    }

    public void fZ(boolean z) {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aBC().getProcessName() + ": onResetPending" + this);
        }
        if (z) {
            this.daT.daS.currentSize = 0L;
        }
        iO(0);
        fY(false);
        this.daX = false;
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
