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
    File ayi;
    T bto;
    e btt;
    AtomicBoolean btu = new AtomicBoolean(false);
    c<T> btv;

    public f(e eVar, T t, c<T> cVar) {
        this.btt = eVar;
        this.bto = t;
        this.btv = cVar;
    }

    /* renamed from: do  reason: not valid java name */
    public void m17do(boolean z) {
        if (this.btu.get() != z) {
            this.btu.set(z);
        }
    }

    public boolean h(f<T> fVar) {
        if (fVar == null) {
            return false;
        }
        return this.bto.equals(fVar.bto);
    }

    public com.baidu.swan.pms.a.a<T> Wz() {
        return this.btv;
    }

    public void a(c cVar) {
        this.btv.a(cVar);
    }

    public T WA() {
        return this.bto;
    }

    public int WB() {
        return this.btt.bts.state;
    }

    public void WC() {
        fK(1);
        this.btv.F(this.bto);
    }

    public void WD() {
        this.btv.R(this.bto);
    }

    public void WE() {
        fK(2);
        this.btv.T(this.bto);
    }

    public void WF() {
        fK(10);
        this.btv.E(this.bto);
    }

    public void WG() {
        fK(3);
        this.btv.a((c<T>) this.bto, this.btt.btr);
    }

    public boolean fK(int i) {
        if (this.btt.bts.state != i) {
            this.btt.bts.state = i;
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
            Log.d("ThunderInfoTask", "run:" + this.btt.bts.downloadUrl);
        }
        j jVar = new j(this);
        while (true) {
            if (this.btt.btr == null || this.btt.btr.errorNo != 2200) {
                if (this.btu.get()) {
                    if (com.baidu.swan.pms.e.DEBUG) {
                        Log.d("ThunderInfoTask", "stopped:" + this.btt.bts.downloadUrl);
                    }
                    WE();
                    return;
                }
                jVar.WJ();
                if (this.btt.btr != null) {
                    switch (this.btt.btr.errorNo) {
                        case PushConstants.EXPIRE_NOTIFICATION /* 2200 */:
                            if (com.baidu.swan.pms.e.DEBUG) {
                                Log.d("ThunderInfoTask", "success download:" + this.btt.bts.downloadUrl);
                            }
                            WF();
                            a(this.btt.btr.errorNo, this.btt.bts);
                            return;
                        default:
                            if (com.baidu.swan.pms.e.DEBUG) {
                                Log.d("ThunderInfoTask", "retry download:" + this.btt.bts.downloadUrl);
                            }
                            this.btv.mRetryCount++;
                            if (this.btv.mRetryCount < 3) {
                                try {
                                    if (!this.btu.get()) {
                                        Thread.sleep(this.btv.mRetryCount * 1000);
                                        break;
                                    } else {
                                        break;
                                    }
                                } catch (InterruptedException e) {
                                    break;
                                }
                            } else {
                                WG();
                                a(this.btt.btr.errorNo, this.btt.bts);
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
    public boolean WH() {
        if (TextUtils.isEmpty(this.btt.bts.filePath)) {
            this.ayi = com.baidu.swan.pms.e.c.bn(this.btv.gs(), this.btt.bts.md5);
            if (this.ayi == null) {
                this.btv.a((c<T>) this.bto, new com.baidu.swan.pms.model.a(2203, "download : path not available"));
                return false;
            }
            this.btt.bts.filePath = this.ayi.getAbsolutePath();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ag(long j) {
        boolean z = false;
        String gs = this.btv.gs();
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
                    com.baidu.swan.pms.c.a.a(eVar.ave, "pkg_download", null, i2, jSONObject);
                }
            }
            try {
                if (eVar instanceof com.baidu.swan.pms.model.f) {
                    jSONObject.put("appId", eVar.bsR);
                }
            } catch (JSONException e3) {
                e = e3;
                e.printStackTrace();
                com.baidu.swan.pms.c.a.a(eVar.ave, "pkg_download", null, i2, jSONObject);
            }
            com.baidu.swan.pms.c.a.a(eVar.ave, "pkg_download", null, i2, jSONObject);
        }
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj instanceof f) {
            return this.btt.bts.equals(((f) obj).btt.bts);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.btt.bts);
    }
}
