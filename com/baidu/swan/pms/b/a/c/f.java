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
    e bmB;
    File bmC;
    AtomicBoolean bmD = new AtomicBoolean(false);
    c bmE;
    T bmw;

    public f(e eVar, T t, c cVar) {
        this.bmB = eVar;
        this.bmw = t;
        this.bmE = cVar;
    }

    public void cS(boolean z) {
        if (this.bmD.get() != z) {
            this.bmD.set(z);
        }
    }

    public boolean h(f<T> fVar) {
        if (fVar == null) {
            return false;
        }
        return this.bmw.equals(fVar.bmw);
    }

    public com.baidu.swan.pms.a.a<T> RS() {
        return this.bmE;
    }

    public void a(c cVar) {
        this.bmE.a(cVar);
    }

    public T RT() {
        return this.bmw;
    }

    public int RU() {
        return this.bmB.bmA.state;
    }

    public void RV() {
        fg(1);
        this.bmE.F(this.bmw);
    }

    public void RW() {
        this.bmE.S(this.bmw);
    }

    public void RX() {
        fg(2);
        this.bmE.T(this.bmw);
    }

    public void RY() {
        fg(10);
        this.bmE.E(this.bmw);
    }

    public void RZ() {
        fg(3);
        this.bmE.a(this.bmw, this.bmB.bmz);
    }

    public boolean fg(int i) {
        if (this.bmB.bmA.state != i) {
            this.bmB.bmA.state = i;
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
            Log.d("ThunderInfoTask", "run:" + this.bmB.bmA.downloadUrl);
        }
        j jVar = new j(this);
        while (true) {
            if (this.bmB.bmz == null || this.bmB.bmz.errorNo != 2200) {
                if (this.bmD.get()) {
                    if (com.baidu.swan.pms.e.DEBUG) {
                        Log.d("ThunderInfoTask", "stopped:" + this.bmB.bmA.downloadUrl);
                    }
                    RX();
                    return;
                }
                jVar.Sc();
                if (this.bmB.bmz != null) {
                    switch (this.bmB.bmz.errorNo) {
                        case PushConstants.EXPIRE_NOTIFICATION /* 2200 */:
                            if (com.baidu.swan.pms.e.DEBUG) {
                                Log.d("ThunderInfoTask", "success download:" + this.bmB.bmA.downloadUrl);
                            }
                            RY();
                            a(this.bmB.bmz.errorNo, this.bmB.bmA);
                            return;
                        default:
                            if (com.baidu.swan.pms.e.DEBUG) {
                                Log.d("ThunderInfoTask", "retry download:" + this.bmB.bmA.downloadUrl);
                            }
                            this.bmE.mRetryCount++;
                            if (this.bmE.mRetryCount < 3) {
                                try {
                                    if (!this.bmD.get()) {
                                        Thread.sleep(this.bmE.mRetryCount * 1000);
                                        break;
                                    } else {
                                        break;
                                    }
                                } catch (InterruptedException e) {
                                    break;
                                }
                            } else {
                                RZ();
                                a(this.bmB.bmz.errorNo, this.bmB.bmA);
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
        if (TextUtils.isEmpty(this.bmB.bmA.filePath)) {
            this.bmC = com.baidu.swan.pms.d.c.bj(this.bmE.hp(), this.bmB.bmA.md5);
            if (this.bmC == null) {
                this.bmE.a(this.bmw, new com.baidu.swan.pms.model.b(2203, "download : path not available"));
                return false;
            }
            this.bmB.bmA.filePath = this.bmC.getAbsolutePath();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean T(long j) {
        boolean z = false;
        String hp = this.bmE.hp();
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
                    jSONObject.put("appId", fVar.blZ);
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
