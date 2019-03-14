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
    AtomicBoolean bmA = new AtomicBoolean(false);
    c bmB;
    T bmt;
    e bmy;
    File bmz;

    public f(e eVar, T t, c cVar) {
        this.bmy = eVar;
        this.bmt = t;
        this.bmB = cVar;
    }

    public void cS(boolean z) {
        if (this.bmA.get() != z) {
            this.bmA.set(z);
        }
    }

    public boolean h(f<T> fVar) {
        if (fVar == null) {
            return false;
        }
        return this.bmt.equals(fVar.bmt);
    }

    public com.baidu.swan.pms.a.a<T> RU() {
        return this.bmB;
    }

    public void a(c cVar) {
        this.bmB.a(cVar);
    }

    public T RV() {
        return this.bmt;
    }

    public int RW() {
        return this.bmy.bmx.state;
    }

    public void RX() {
        fh(1);
        this.bmB.F(this.bmt);
    }

    public void RY() {
        this.bmB.U(this.bmt);
    }

    public void RZ() {
        fh(2);
        this.bmB.V(this.bmt);
    }

    public void Sa() {
        fh(10);
        this.bmB.E(this.bmt);
    }

    public void Sb() {
        fh(3);
        this.bmB.a(this.bmt, this.bmy.bmw);
    }

    public boolean fh(int i) {
        if (this.bmy.bmx.state != i) {
            this.bmy.bmx.state = i;
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
            Log.d("ThunderInfoTask", "run:" + this.bmy.bmx.downloadUrl);
        }
        j jVar = new j(this);
        while (true) {
            if (this.bmy.bmw == null || this.bmy.bmw.errorNo != 2200) {
                if (this.bmA.get()) {
                    if (com.baidu.swan.pms.e.DEBUG) {
                        Log.d("ThunderInfoTask", "stopped:" + this.bmy.bmx.downloadUrl);
                    }
                    RZ();
                    return;
                }
                jVar.Se();
                if (this.bmy.bmw != null) {
                    switch (this.bmy.bmw.errorNo) {
                        case PushConstants.EXPIRE_NOTIFICATION /* 2200 */:
                            if (com.baidu.swan.pms.e.DEBUG) {
                                Log.d("ThunderInfoTask", "success download:" + this.bmy.bmx.downloadUrl);
                            }
                            Sa();
                            a(this.bmy.bmw.errorNo, this.bmy.bmx);
                            return;
                        default:
                            if (com.baidu.swan.pms.e.DEBUG) {
                                Log.d("ThunderInfoTask", "retry download:" + this.bmy.bmx.downloadUrl);
                            }
                            this.bmB.mRetryCount++;
                            if (this.bmB.mRetryCount < 3) {
                                try {
                                    if (!this.bmA.get()) {
                                        Thread.sleep(this.bmB.mRetryCount * 1000);
                                        break;
                                    } else {
                                        break;
                                    }
                                } catch (InterruptedException e) {
                                    break;
                                }
                            } else {
                                Sb();
                                a(this.bmy.bmw.errorNo, this.bmy.bmx);
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
    public boolean Sc() {
        if (TextUtils.isEmpty(this.bmy.bmx.filePath)) {
            this.bmz = com.baidu.swan.pms.d.c.bj(this.bmB.hp(), this.bmy.bmx.md5);
            if (this.bmz == null) {
                this.bmB.a(this.bmt, new com.baidu.swan.pms.model.b(2203, "download : path not available"));
                return false;
            }
            this.bmy.bmx.filePath = this.bmz.getAbsolutePath();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean T(long j) {
        boolean z = false;
        String hp = this.bmB.hp();
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
                    com.baidu.swan.pms.e.Rw().a(str, "pkg_download", null, i2, jSONObject);
                }
            }
            try {
                if (fVar instanceof com.baidu.swan.pms.model.g) {
                    jSONObject.put("appId", fVar.blW);
                }
            } catch (JSONException e2) {
                e = e2;
                e.printStackTrace();
                if (fVar.category == 0) {
                }
                com.baidu.swan.pms.e.Rw().a(str, "pkg_download", null, i2, jSONObject);
            }
            if (fVar.category == 0) {
                str = "swan";
            } else if (fVar.category == 1) {
                str = "swangame";
            }
            com.baidu.swan.pms.e.Rw().a(str, "pkg_download", null, i2, jSONObject);
        }
    }
}
