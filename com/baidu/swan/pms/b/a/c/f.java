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
    File aRE;
    T bLG;
    e bLL;
    AtomicBoolean bLM = new AtomicBoolean(false);
    c<T> bLN;

    public f(e eVar, T t, c<T> cVar) {
        this.bLL = eVar;
        this.bLG = t;
        this.bLN = cVar;
    }

    public void dF(boolean z) {
        if (this.bLM.get() != z) {
            this.bLM.set(z);
        }
    }

    public boolean h(f<T> fVar) {
        if (fVar == null) {
            return false;
        }
        return this.bLG.equals(fVar.bLG);
    }

    public com.baidu.swan.pms.a.a<T> abq() {
        return this.bLN;
    }

    public void a(c cVar) {
        this.bLN.a(cVar);
    }

    public T abr() {
        return this.bLG;
    }

    public int abs() {
        return this.bLL.bLK.state;
    }

    public void abt() {
        gF(1);
        this.bLN.D(this.bLG);
    }

    public void abu() {
        this.bLN.P(this.bLG);
    }

    public void abv() {
        gF(2);
        this.bLN.R(this.bLG);
    }

    public void abw() {
        gF(10);
        this.bLN.C(this.bLG);
    }

    public void abx() {
        gF(3);
        this.bLN.a((c<T>) this.bLG, this.bLL.bLJ);
    }

    public boolean gF(int i) {
        if (this.bLL.bLK.state != i) {
            this.bLL.bLK.state = i;
            if (i == 2 || i == 3 || i == 10) {
                dF(true);
                return true;
            }
            dF(false);
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.swan.pms.e.DEBUG) {
            Log.d("ThunderInfoTask", "run:" + this.bLL.bLK.downloadUrl);
        }
        j jVar = new j(this);
        while (true) {
            if (this.bLL.bLJ == null || this.bLL.bLJ.errorNo != 2200) {
                if (this.bLM.get()) {
                    if (com.baidu.swan.pms.e.DEBUG) {
                        Log.d("ThunderInfoTask", "stopped:" + this.bLL.bLK.downloadUrl);
                    }
                    abv();
                    return;
                }
                jVar.abA();
                if (this.bLL.bLJ != null) {
                    switch (this.bLL.bLJ.errorNo) {
                        case PushConstants.EXPIRE_NOTIFICATION /* 2200 */:
                            if (com.baidu.swan.pms.e.DEBUG) {
                                Log.d("ThunderInfoTask", "success download:" + this.bLL.bLK.downloadUrl);
                            }
                            abw();
                            a(this.bLL.bLJ.errorNo, this.bLL.bLK);
                            return;
                        default:
                            if (com.baidu.swan.pms.e.DEBUG) {
                                Log.d("ThunderInfoTask", "retry download:" + this.bLL.bLK.downloadUrl);
                            }
                            this.bLN.mRetryCount++;
                            if (this.bLN.mRetryCount < 3) {
                                try {
                                    if (!this.bLM.get()) {
                                        Thread.sleep(this.bLN.mRetryCount * 1000);
                                        break;
                                    } else {
                                        break;
                                    }
                                } catch (InterruptedException e) {
                                    break;
                                }
                            } else {
                                abx();
                                a(this.bLL.bLJ.errorNo, this.bLL.bLK);
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
    public boolean aby() {
        if (TextUtils.isEmpty(this.bLL.bLK.filePath)) {
            this.aRE = com.baidu.swan.pms.e.c.bu(this.bLN.getDownloadPath(), this.bLL.bLK.md5);
            if (this.aRE == null) {
                this.bLN.a((c<T>) this.bLG, new com.baidu.swan.pms.model.a(2203, "download : path not available"));
                return false;
            }
            this.bLL.bLK.filePath = this.aRE.getAbsolutePath();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ay(long j) {
        boolean z = false;
        String downloadPath = this.bLN.getDownloadPath();
        if (downloadPath != null) {
            try {
                StatFs statFs = new StatFs(downloadPath);
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
                    jSONObject.put("appId", eVar.bLj);
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
            return this.bLL.bLK.equals(((f) obj).bLL.bLK);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.bLL.bLK);
    }
}
