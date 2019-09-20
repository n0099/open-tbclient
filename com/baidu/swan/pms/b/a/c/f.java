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
    File ayG;
    T btM;
    e btR;
    AtomicBoolean btS = new AtomicBoolean(false);
    c<T> btT;

    public f(e eVar, T t, c<T> cVar) {
        this.btR = eVar;
        this.btM = t;
        this.btT = cVar;
    }

    /* renamed from: do  reason: not valid java name */
    public void m17do(boolean z) {
        if (this.btS.get() != z) {
            this.btS.set(z);
        }
    }

    public boolean h(f<T> fVar) {
        if (fVar == null) {
            return false;
        }
        return this.btM.equals(fVar.btM);
    }

    public com.baidu.swan.pms.a.a<T> WD() {
        return this.btT;
    }

    public void a(c cVar) {
        this.btT.a(cVar);
    }

    public T WE() {
        return this.btM;
    }

    public int WF() {
        return this.btR.btQ.state;
    }

    public void WG() {
        fL(1);
        this.btT.F(this.btM);
    }

    public void WH() {
        this.btT.R(this.btM);
    }

    public void WI() {
        fL(2);
        this.btT.T(this.btM);
    }

    public void WJ() {
        fL(10);
        this.btT.E(this.btM);
    }

    public void WK() {
        fL(3);
        this.btT.a((c<T>) this.btM, this.btR.btP);
    }

    public boolean fL(int i) {
        if (this.btR.btQ.state != i) {
            this.btR.btQ.state = i;
            if (i == 2 || i == 3 || i == 10) {
                m17do(true);
                return true;
            }
            m17do(false);
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.swan.pms.e.DEBUG) {
            Log.d("ThunderInfoTask", "run:" + this.btR.btQ.downloadUrl);
        }
        j jVar = new j(this);
        while (true) {
            if (this.btR.btP == null || this.btR.btP.errorNo != 2200) {
                if (this.btS.get()) {
                    if (com.baidu.swan.pms.e.DEBUG) {
                        Log.d("ThunderInfoTask", "stopped:" + this.btR.btQ.downloadUrl);
                    }
                    WI();
                    return;
                }
                jVar.WN();
                if (this.btR.btP != null) {
                    switch (this.btR.btP.errorNo) {
                        case PushConstants.EXPIRE_NOTIFICATION /* 2200 */:
                            if (com.baidu.swan.pms.e.DEBUG) {
                                Log.d("ThunderInfoTask", "success download:" + this.btR.btQ.downloadUrl);
                            }
                            WJ();
                            a(this.btR.btP.errorNo, this.btR.btQ);
                            return;
                        default:
                            if (com.baidu.swan.pms.e.DEBUG) {
                                Log.d("ThunderInfoTask", "retry download:" + this.btR.btQ.downloadUrl);
                            }
                            this.btT.mRetryCount++;
                            if (this.btT.mRetryCount < 3) {
                                try {
                                    if (!this.btS.get()) {
                                        Thread.sleep(this.btT.mRetryCount * 1000);
                                        break;
                                    } else {
                                        break;
                                    }
                                } catch (InterruptedException e) {
                                    break;
                                }
                            } else {
                                WK();
                                a(this.btR.btP.errorNo, this.btR.btQ);
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
    public boolean WL() {
        if (TextUtils.isEmpty(this.btR.btQ.filePath)) {
            this.ayG = com.baidu.swan.pms.e.c.bn(this.btT.gs(), this.btR.btQ.md5);
            if (this.ayG == null) {
                this.btT.a((c<T>) this.btM, new com.baidu.swan.pms.model.a(2203, "download : path not available"));
                return false;
            }
            this.btR.btQ.filePath = this.ayG.getAbsolutePath();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ag(long j) {
        boolean z = false;
        String gs = this.btT.gs();
        if (gs != null) {
            try {
                StatFs statFs = new StatFs(gs);
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
                    com.baidu.swan.pms.c.a.a(eVar.avC, "pkg_download", null, i2, jSONObject);
                }
            }
            try {
                if (eVar instanceof com.baidu.swan.pms.model.f) {
                    jSONObject.put("appId", eVar.btp);
                }
            } catch (JSONException e3) {
                e = e3;
                e.printStackTrace();
                com.baidu.swan.pms.c.a.a(eVar.avC, "pkg_download", null, i2, jSONObject);
            }
            com.baidu.swan.pms.c.a.a(eVar.avC, "pkg_download", null, i2, jSONObject);
        }
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj instanceof f) {
            return this.btR.btQ.equals(((f) obj).btR.btQ);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.btR.btQ);
    }
}
