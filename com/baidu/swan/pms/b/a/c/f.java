package com.baidu.swan.pms.b.a.c;

import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f<T> implements Runnable {
    File axB;
    e bsD;
    AtomicBoolean bsE = new AtomicBoolean(false);
    c<T> bsF;
    T bsy;

    public f(e eVar, T t, c<T> cVar) {
        this.bsD = eVar;
        this.bsy = t;
        this.bsF = cVar;
    }

    public void dj(boolean z) {
        if (this.bsE.get() != z) {
            this.bsE.set(z);
        }
    }

    public boolean h(f<T> fVar) {
        if (fVar == null) {
            return false;
        }
        return this.bsy.equals(fVar.bsy);
    }

    public com.baidu.swan.pms.a.a<T> VG() {
        return this.bsF;
    }

    public void a(c cVar) {
        this.bsF.a(cVar);
    }

    public T VH() {
        return this.bsy;
    }

    public int VI() {
        return this.bsD.bsC.state;
    }

    public void VJ() {
        fG(1);
        this.bsF.F(this.bsy);
    }

    public void VK() {
        this.bsF.R(this.bsy);
    }

    public void VL() {
        fG(2);
        this.bsF.T(this.bsy);
    }

    public void VM() {
        fG(10);
        this.bsF.E(this.bsy);
    }

    public void VN() {
        fG(3);
        this.bsF.a((c<T>) this.bsy, this.bsD.bsB);
    }

    public boolean fG(int i) {
        if (this.bsD.bsC.state != i) {
            this.bsD.bsC.state = i;
            if (i == 2 || i == 3 || i == 10) {
                dj(true);
                return true;
            }
            dj(false);
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.swan.pms.e.DEBUG) {
            Log.d("ThunderInfoTask", "run:" + this.bsD.bsC.downloadUrl);
        }
        j jVar = new j(this);
        while (true) {
            if (this.bsD.bsB == null || this.bsD.bsB.errorNo != 2200) {
                if (this.bsE.get()) {
                    if (com.baidu.swan.pms.e.DEBUG) {
                        Log.d("ThunderInfoTask", "stopped:" + this.bsD.bsC.downloadUrl);
                    }
                    VL();
                    return;
                }
                jVar.VQ();
                if (this.bsD.bsB != null) {
                    switch (this.bsD.bsB.errorNo) {
                        case PushConstants.EXPIRE_NOTIFICATION /* 2200 */:
                            if (com.baidu.swan.pms.e.DEBUG) {
                                Log.d("ThunderInfoTask", "success download:" + this.bsD.bsC.downloadUrl);
                            }
                            VM();
                            a(this.bsD.bsB.errorNo, this.bsD.bsC);
                            return;
                        default:
                            if (com.baidu.swan.pms.e.DEBUG) {
                                Log.d("ThunderInfoTask", "retry download:" + this.bsD.bsC.downloadUrl);
                            }
                            this.bsF.mRetryCount++;
                            if (this.bsF.mRetryCount < 3) {
                                try {
                                    if (!this.bsE.get()) {
                                        Thread.sleep(this.bsF.mRetryCount * 1000);
                                        break;
                                    } else {
                                        break;
                                    }
                                } catch (InterruptedException e) {
                                    break;
                                }
                            } else {
                                VN();
                                a(this.bsD.bsB.errorNo, this.bsD.bsC);
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
    public boolean VO() {
        if (TextUtils.isEmpty(this.bsD.bsC.filePath)) {
            this.axB = com.baidu.swan.pms.e.c.bn(this.bsF.gj(), this.bsD.bsC.md5);
            if (this.axB == null) {
                this.bsF.a((c<T>) this.bsy, new com.baidu.swan.pms.model.a(2203, "download : path not available"));
                return false;
            }
            this.bsD.bsC.filePath = this.axB.getAbsolutePath();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean af(long j) {
        boolean z = false;
        String gj = this.bsF.gj();
        if (gj != null) {
            try {
                StatFs statFs = new StatFs(gj);
                if (Build.VERSION.SDK_INT >= 18) {
                    z = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong() > j;
                } else {
                    z = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()) > j;
                }
            } catch (Throwable th) {
                if (com.baidu.swan.pms.e.DEBUG) {
                    Log.d("ThunderInfoTask", "path exception or no space left." + th.toString());
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
                    jSONObject.put("response", eVar.toString());
                    i2 = i;
                } catch (JSONException e2) {
                    e = e2;
                    i2 = i;
                    e.printStackTrace();
                    com.baidu.swan.pms.c.a.a(eVar.category, "pkg_download", null, i2, jSONObject);
                }
            }
            try {
                if (eVar instanceof com.baidu.swan.pms.model.f) {
                    jSONObject.put("appId", eVar.bsc);
                }
            } catch (JSONException e3) {
                e = e3;
                e.printStackTrace();
                com.baidu.swan.pms.c.a.a(eVar.category, "pkg_download", null, i2, jSONObject);
            }
            com.baidu.swan.pms.c.a.a(eVar.category, "pkg_download", null, i2, jSONObject);
        }
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj instanceof f) {
            return this.bsD.bsC.equals(((f) obj).bsD.bsC);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.bsD.bsC);
    }
}
