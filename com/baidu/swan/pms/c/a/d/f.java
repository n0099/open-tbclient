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
    File cet;
    e enC;
    T enD;
    AtomicBoolean enE = new AtomicBoolean(false);
    c<T> enF;
    private boolean enG;

    public f(e eVar, T t, c<T> cVar) {
        this.enC = eVar;
        this.enD = t;
        this.enF = cVar;
    }

    public void im(boolean z) {
        if (this.enE.get() != z) {
            this.enE.set(z);
        }
    }

    public boolean k(f<T> fVar) {
        return (fVar == null || fVar.enC == null || fVar.enC.enB == null || this.enC == null || this.enC.enB == null || !this.enC.enB.equals(fVar.enC.enB)) ? false : true;
    }

    public com.baidu.swan.pms.a.c<T> beh() {
        return this.enF;
    }

    public T bei() {
        return this.enD;
    }

    public int bej() {
        return this.enC.enB.state;
    }

    public void bek() {
        np(1);
        this.enF.S(this.enD);
    }

    public void bel() {
        this.enF.R(this.enD);
    }

    public void bem() {
        np(2);
        this.enF.ai(this.enD);
    }

    public void awf() {
        np(10);
        this.enF.Q(this.enD);
    }

    public void ben() {
        np(3);
        this.enF.a((c<T>) this.enD, this.enC.enA);
    }

    public boolean np(int i) {
        if (this.enC.enB.state != i) {
            this.enC.enB.state = i;
            if (i == 2 || i == 3 || i == 10) {
                im(true);
                return true;
            }
            im(false);
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bdz().getProcessName() + ": run:" + this.enC.enB.downloadUrl);
        }
        j jVar = new j(this);
        while (true) {
            if (this.enC.enA == null || this.enC.enA.errorNo != 2200) {
                if (this.enE.get()) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bdz().getProcessName() + ": stopped:" + this.enC.enB.downloadUrl);
                    }
                    bem();
                    return;
                }
                jVar.beu();
                if (this.enC.enA != null) {
                    switch (this.enC.enA.errorNo) {
                        case 2200:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bdz().getProcessName() + ": success download:" + this.enC.enB.downloadUrl);
                            }
                            awf();
                            return;
                        default:
                            if (this.enE.get()) {
                                if (com.baidu.swan.pms.d.DEBUG) {
                                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bdz().getProcessName() + ": stopped:" + this.enC.enB.downloadUrl);
                                }
                                bem();
                                return;
                            }
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bdz().getProcessName() + ": retry download:" + this.enC.enB.downloadUrl);
                            }
                            this.enF.mRetryCount++;
                            if (this.enF.mRetryCount < 3) {
                                try {
                                    if (!this.enE.get()) {
                                        Thread.sleep(this.enF.mRetryCount * 1000);
                                        break;
                                    } else {
                                        break;
                                    }
                                } catch (InterruptedException e) {
                                    break;
                                }
                            } else {
                                ben();
                                a(this.enC.enA.errorNo, this.enC.enB);
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
    public boolean beo() {
        if (TextUtils.isEmpty(this.enC.enB.filePath)) {
            this.cet = com.baidu.swan.pms.utils.d.dA(this.enF.U(this.enD), this.enC.enB.md5);
            if (this.cet == null) {
                this.enF.a((c<T>) this.enD, new com.baidu.swan.pms.model.a(2203, "download : path not available"));
                return false;
            }
            this.enC.enB.filePath = this.cet.getAbsolutePath();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: do  reason: not valid java name */
    public boolean m35do(long j) {
        boolean z = false;
        String U = this.enF.U(this.enD);
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
                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bdz().getProcessName() + ": path exception or no space left." + th.toString());
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
                    com.baidu.swan.pms.f.a.a(eVar.category, "pkg_download", null, i2, jSONObject);
                }
            }
            try {
                if (eVar instanceof com.baidu.swan.pms.model.f) {
                    jSONObject.put("appId", eVar.emZ);
                }
            } catch (JSONException e3) {
                e = e3;
                e.printStackTrace();
                com.baidu.swan.pms.f.a.a(eVar.category, "pkg_download", null, i2, jSONObject);
            }
            com.baidu.swan.pms.f.a.a(eVar.category, "pkg_download", null, i2, jSONObject);
        }
    }

    public int hashCode() {
        return Objects.hash(this.enC.enB);
    }

    public int bep() {
        return new com.baidu.swan.pms.c.a.b.a().B(this.enF.bdB()).intValue();
    }

    public String toString() {
        return "downloadUrl:" + this.enC.enB.downloadUrl + ",versionName:" + this.enC.enB.versionName + ",versionCode:" + this.enC.enB.versionCode + "md5:" + this.enC.enB.md5 + "bundleId:" + this.enC.enB.emZ;
    }

    public void beq() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bdz().getProcessName() + ": onNotifyPending" + this);
        }
        this.enG = true;
        im(true);
    }

    public boolean ber() {
        return this.enG;
    }

    public void in(boolean z) {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bdz().getProcessName() + ": onResetPending" + this);
        }
        if (z) {
            this.enC.enB.currentSize = 0L;
        }
        np(0);
        im(false);
        this.enG = false;
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
