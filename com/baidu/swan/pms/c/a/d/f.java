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
/* loaded from: classes9.dex */
public class f<T> implements Runnable {
    File bst;
    e cxs;
    T cxt;
    AtomicBoolean cxu = new AtomicBoolean(false);
    c<T> cxv;
    private boolean cxw;

    public f(e eVar, T t, c<T> cVar) {
        this.cxs = eVar;
        this.cxt = t;
        this.cxv = cVar;
    }

    public void eO(boolean z) {
        if (this.cxu.get() != z) {
            this.cxu.set(z);
        }
    }

    public boolean k(f<T> fVar) {
        return (fVar == null || fVar.cxs == null || fVar.cxs.cxr == null || this.cxs == null || this.cxs.cxr == null || !this.cxs.cxr.equals(fVar.cxs.cxr)) ? false : true;
    }

    public com.baidu.swan.pms.a.c<T> arn() {
        return this.cxv;
    }

    public T aro() {
        return this.cxt;
    }

    public int arp() {
        return this.cxs.cxr.state;
    }

    public void arq() {
        iq(1);
        this.cxv.G(this.cxt);
    }

    public void arr() {
        this.cxv.F(this.cxt);
    }

    public void ars() {
        iq(2);
        this.cxv.W(this.cxt);
    }

    public void art() {
        iq(10);
        this.cxv.E(this.cxt);
    }

    public void aru() {
        iq(3);
        this.cxv.a((c<T>) this.cxt, this.cxs.cxq);
    }

    public boolean iq(int i) {
        if (this.cxs.cxr.state != i) {
            this.cxs.cxr.state = i;
            if (i == 2 || i == 3 || i == 10) {
                eO(true);
                return true;
            }
            eO(false);
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aqG().getProcessName() + ": run:" + this.cxs.cxr.downloadUrl);
        }
        j jVar = new j(this);
        while (true) {
            if (this.cxs.cxq == null || this.cxs.cxq.errorNo != 2200) {
                if (this.cxu.get()) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aqG().getProcessName() + ": stopped:" + this.cxs.cxr.downloadUrl);
                    }
                    ars();
                    return;
                }
                jVar.arz();
                if (this.cxs.cxq != null) {
                    switch (this.cxs.cxq.errorNo) {
                        case PushConstants.EXPIRE_NOTIFICATION /* 2200 */:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aqG().getProcessName() + ": success download:" + this.cxs.cxr.downloadUrl);
                            }
                            art();
                            return;
                        default:
                            if (this.cxu.get()) {
                                if (com.baidu.swan.pms.d.DEBUG) {
                                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aqG().getProcessName() + ": stopped:" + this.cxs.cxr.downloadUrl);
                                }
                                ars();
                                return;
                            }
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aqG().getProcessName() + ": retry download:" + this.cxs.cxr.downloadUrl);
                            }
                            this.cxv.mRetryCount++;
                            if (this.cxv.mRetryCount < 3) {
                                try {
                                    if (!this.cxu.get()) {
                                        Thread.sleep(this.cxv.mRetryCount * 1000);
                                        break;
                                    } else {
                                        break;
                                    }
                                } catch (InterruptedException e) {
                                    break;
                                }
                            } else {
                                aru();
                                a(this.cxs.cxq.errorNo, this.cxs.cxr);
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
    public boolean aqW() {
        if (TextUtils.isEmpty(this.cxs.cxr.filePath)) {
            this.bst = com.baidu.swan.pms.f.c.bW(this.cxv.I(this.cxt), this.cxs.cxr.md5);
            if (this.bst == null) {
                this.cxv.a((c<T>) this.cxt, new com.baidu.swan.pms.model.a(2203, "download : path not available"));
                return false;
            }
            this.cxs.cxr.filePath = this.bst.getAbsolutePath();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bc(long j) {
        boolean z = false;
        String I = this.cxv.I(this.cxt);
        if (I != null) {
            try {
                StatFs statFs = new StatFs(I);
                if (Build.VERSION.SDK_INT >= 18) {
                    z = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong() > j;
                } else {
                    z = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()) > j;
                }
            } catch (Throwable th) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aqG().getProcessName() + ": path exception or no space left." + th.toString());
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
                    jSONObject.put("appId", eVar.cwO);
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
        return Objects.hash(this.cxs.cxr);
    }

    public int arv() {
        return new com.baidu.swan.pms.c.a.b.a().u(this.cxv.aqI()).intValue();
    }

    public String toString() {
        return "downloadUrl:" + this.cxs.cxr.downloadUrl + ",versionName:" + this.cxs.cxr.versionName + ",versionCode:" + this.cxs.cxr.versionCode + "md5:" + this.cxs.cxr.md5 + "bundleId:" + this.cxs.cxr.cwO;
    }

    public void arw() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aqG().getProcessName() + ": onNotifyPending" + this);
        }
        this.cxw = true;
        eO(true);
    }

    public boolean arx() {
        return this.cxw;
    }

    public void eP(boolean z) {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aqG().getProcessName() + ": onResetPending" + this);
        }
        if (z) {
            this.cxs.cxr.currentSize = 0L;
        }
        iq(0);
        eO(false);
        this.cxw = false;
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
