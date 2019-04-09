package com.baidu.swan.pms.b.a.c;

import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f<T> implements Runnable {
    e bmC;
    File bmD;
    AtomicBoolean bmE = new AtomicBoolean(false);
    c bmF;
    T bmx;

    public f(e eVar, T t, c cVar) {
        this.bmC = eVar;
        this.bmx = t;
        this.bmF = cVar;
    }

    public void cS(boolean z) {
        if (this.bmE.get() != z) {
            this.bmE.set(z);
        }
    }

    public boolean h(f<T> fVar) {
        if (fVar == null) {
            return false;
        }
        return this.bmx.equals(fVar.bmx);
    }

    public com.baidu.swan.pms.a.a<T> RS() {
        return this.bmF;
    }

    public void a(c cVar) {
        this.bmF.a(cVar);
    }

    public T RT() {
        return this.bmx;
    }

    public int RU() {
        return this.bmC.bmB.state;
    }

    public void RV() {
        fg(1);
        this.bmF.F(this.bmx);
    }

    public void RW() {
        this.bmF.S(this.bmx);
    }

    public void RX() {
        fg(2);
        this.bmF.T(this.bmx);
    }

    public void RY() {
        fg(10);
        this.bmF.E(this.bmx);
    }

    public void RZ() {
        fg(3);
        this.bmF.a(this.bmx, this.bmC.bmA);
    }

    public boolean fg(int i) {
        if (this.bmC.bmB.state != i) {
            this.bmC.bmB.state = i;
            if (i == 2 || i == 3 || i == 10) {
                cS(true);
                return true;
            }
            cS(false);
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.swan.pms.e.DEBUG) {
            Log.d("ThunderInfoTask", "run:" + this.bmC.bmB.downloadUrl);
        }
        j jVar = new j(this);
        while (true) {
            if (this.bmC.bmA == null || this.bmC.bmA.errorNo != 2200) {
                if (this.bmE.get()) {
                    if (com.baidu.swan.pms.e.DEBUG) {
                        Log.d("ThunderInfoTask", "stopped:" + this.bmC.bmB.downloadUrl);
                    }
                    RX();
                    return;
                }
                jVar.Sc();
                if (this.bmC.bmA != null) {
                    switch (this.bmC.bmA.errorNo) {
                        case PushConstants.EXPIRE_NOTIFICATION /* 2200 */:
                            if (com.baidu.swan.pms.e.DEBUG) {
                                Log.d("ThunderInfoTask", "success download:" + this.bmC.bmB.downloadUrl);
                            }
                            RY();
                            a(this.bmC.bmA.errorNo, this.bmC.bmB);
                            return;
                        default:
                            if (com.baidu.swan.pms.e.DEBUG) {
                                Log.d("ThunderInfoTask", "retry download:" + this.bmC.bmB.downloadUrl);
                            }
                            this.bmF.mRetryCount++;
                            if (this.bmF.mRetryCount < 3) {
                                try {
                                    if (!this.bmE.get()) {
                                        Thread.sleep(this.bmF.mRetryCount * 1000);
                                        break;
                                    } else {
                                        break;
                                    }
                                } catch (InterruptedException e) {
                                    break;
                                }
                            } else {
                                RZ();
                                a(this.bmC.bmA.errorNo, this.bmC.bmB);
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
    public boolean Sa() {
        if (TextUtils.isEmpty(this.bmC.bmB.filePath)) {
            this.bmD = com.baidu.swan.pms.d.c.bj(this.bmF.hp(), this.bmC.bmB.md5);
            if (this.bmD == null) {
                this.bmF.a(this.bmx, new com.baidu.swan.pms.model.b(2203, "download : path not available"));
                return false;
            }
            this.bmC.bmB.filePath = this.bmD.getAbsolutePath();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean T(long j) {
        boolean z = false;
        String hp = this.bmF.hp();
        if (hp != null) {
            try {
                StatFs statFs = new StatFs(hp);
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

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i, com.baidu.swan.pms.model.f fVar) {
        int i2;
        if (fVar != null) {
            JSONObject jSONObject = new JSONObject();
            String str = "unknown";
            if (i == 2200) {
                i2 = 0;
            } else {
                try {
                    jSONObject.put("response", fVar.toString());
                    i2 = i;
                } catch (JSONException e) {
                    e = e;
                    i2 = i;
                    e.printStackTrace();
                    if (fVar.category == 0) {
                    }
                    com.baidu.swan.pms.e.Ru().a(str, "pkg_download", null, i2, jSONObject);
                }
            }
            try {
                if (fVar instanceof com.baidu.swan.pms.model.g) {
                    jSONObject.put("appId", fVar.bma);
                }
            } catch (JSONException e2) {
                e = e2;
                e.printStackTrace();
                if (fVar.category == 0) {
                }
                com.baidu.swan.pms.e.Ru().a(str, "pkg_download", null, i2, jSONObject);
            }
            if (fVar.category == 0) {
                str = "swan";
            } else if (fVar.category == 1) {
                str = "swangame";
            }
            com.baidu.swan.pms.e.Ru().a(str, "pkg_download", null, i2, jSONObject);
        }
    }
}
