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
    c bmA;
    T bms;
    e bmx;
    File bmy;
    AtomicBoolean bmz = new AtomicBoolean(false);

    public f(e eVar, T t, c cVar) {
        this.bmx = eVar;
        this.bms = t;
        this.bmA = cVar;
    }

    public void cS(boolean z) {
        if (this.bmz.get() != z) {
            this.bmz.set(z);
        }
    }

    public boolean h(f<T> fVar) {
        if (fVar == null) {
            return false;
        }
        return this.bms.equals(fVar.bms);
    }

    public com.baidu.swan.pms.a.a<T> RU() {
        return this.bmA;
    }

    public void a(c cVar) {
        this.bmA.a(cVar);
    }

    public T RV() {
        return this.bms;
    }

    public int RW() {
        return this.bmx.bmw.state;
    }

    public void RX() {
        fh(1);
        this.bmA.F(this.bms);
    }

    public void RY() {
        this.bmA.U(this.bms);
    }

    public void RZ() {
        fh(2);
        this.bmA.V(this.bms);
    }

    public void Sa() {
        fh(10);
        this.bmA.E(this.bms);
    }

    public void Sb() {
        fh(3);
        this.bmA.a(this.bms, this.bmx.bmv);
    }

    public boolean fh(int i) {
        if (this.bmx.bmw.state != i) {
            this.bmx.bmw.state = i;
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
            Log.d("ThunderInfoTask", "run:" + this.bmx.bmw.downloadUrl);
        }
        j jVar = new j(this);
        while (true) {
            if (this.bmx.bmv == null || this.bmx.bmv.errorNo != 2200) {
                if (this.bmz.get()) {
                    if (com.baidu.swan.pms.e.DEBUG) {
                        Log.d("ThunderInfoTask", "stopped:" + this.bmx.bmw.downloadUrl);
                    }
                    RZ();
                    return;
                }
                jVar.Se();
                if (this.bmx.bmv != null) {
                    switch (this.bmx.bmv.errorNo) {
                        case PushConstants.EXPIRE_NOTIFICATION /* 2200 */:
                            if (com.baidu.swan.pms.e.DEBUG) {
                                Log.d("ThunderInfoTask", "success download:" + this.bmx.bmw.downloadUrl);
                            }
                            Sa();
                            a(this.bmx.bmv.errorNo, this.bmx.bmw);
                            return;
                        default:
                            if (com.baidu.swan.pms.e.DEBUG) {
                                Log.d("ThunderInfoTask", "retry download:" + this.bmx.bmw.downloadUrl);
                            }
                            this.bmA.mRetryCount++;
                            if (this.bmA.mRetryCount < 3) {
                                try {
                                    if (!this.bmz.get()) {
                                        Thread.sleep(this.bmA.mRetryCount * 1000);
                                        break;
                                    } else {
                                        break;
                                    }
                                } catch (InterruptedException e) {
                                    break;
                                }
                            } else {
                                Sb();
                                a(this.bmx.bmv.errorNo, this.bmx.bmw);
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
        if (TextUtils.isEmpty(this.bmx.bmw.filePath)) {
            this.bmy = com.baidu.swan.pms.d.c.bj(this.bmA.hp(), this.bmx.bmw.md5);
            if (this.bmy == null) {
                this.bmA.a(this.bms, new com.baidu.swan.pms.model.b(2203, "download : path not available"));
                return false;
            }
            this.bmx.bmw.filePath = this.bmy.getAbsolutePath();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean T(long j) {
        boolean z = false;
        String hp = this.bmA.hp();
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
                    jSONObject.put("appId", fVar.blV);
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
