package com.baidu.swan.apps.performance.a;

import android.text.TextUtils;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes7.dex */
public class b implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private long cGz;
    private c dhK;
    private SimpleDateFormat dhL;
    private HashMap<String, List<a>> dhM;
    private String dhN;
    private boolean dhO;
    private boolean dhP;
    private long dhQ;
    private final Object mLock = new Object();

    private void aDg() {
        if (this.dhM == null) {
            synchronized (this.mLock) {
                if (this.dhM == null) {
                    this.dhM = new HashMap<>();
                    this.dhL = new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault());
                    this.dhK = new c() { // from class: com.baidu.swan.apps.performance.a.b.1
                        @Override // com.baidu.swan.apps.performance.a.c
                        public boolean a(a aVar) {
                            if (aVar == null || aVar.apr() < 0) {
                                return false;
                            }
                            if (b.DEBUG || !d.dhS.contains(aVar.getApiName())) {
                                return b.this.bZ(aVar.getStart());
                            }
                            return false;
                        }
                    };
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bZ(long j) {
        return j >= this.dhQ && j <= this.dhQ + this.cGz;
    }

    public String format() {
        int i;
        int i2;
        if (!this.dhP) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("----- ").append("launch start time ").append(this.dhL.format(Long.valueOf(this.dhQ))).append("\n");
        sb.append("----- ").append("launch end time ").append(this.dhL.format(Long.valueOf(this.dhQ + this.cGz))).append("\n");
        sb.append("----- ").append("swan js version ").append(this.dhN).append("\n");
        int i3 = 0;
        int i4 = 0;
        synchronized (this.mLock) {
            for (Map.Entry<String, List<a>> entry : this.dhM.entrySet()) {
                List<a> value = entry.getValue();
                if (value != null && value.size() > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    int i5 = 0;
                    for (a aVar : value) {
                        if (this.dhK == null || this.dhK.a(aVar)) {
                            sb2.append("----- start time ").append(this.dhL.format(Long.valueOf(aVar.getStart()))).append("\n");
                            sb2.append("----- end time ").append(this.dhL.format(Long.valueOf(aVar.getEnd()))).append("\n");
                            sb2.append("----- cost time ").append(aVar.apr()).append("ms\n");
                            sb2.append("----------------------------\n");
                            i4++;
                            i2 = i5 + 1;
                        } else {
                            i2 = i5;
                        }
                        i4 = i4;
                        i5 = i2;
                    }
                    if (i5 > 0) {
                        sb.append("\n===== ").append(entry.getKey()).append(" ").append(i5).append(" times\n");
                        sb.append((CharSequence) sb2);
                        i = i3 + 1;
                    } else {
                        i = i3;
                    }
                    i3 = i;
                }
            }
        }
        sb.append("===== total: ").append(i3).append(" apis, ").append(i4).append(" times");
        String sb3 = sb.toString();
        com.baidu.swan.apps.console.c.d("ApiCalledMarker", sb3);
        return sb3;
    }

    private void log(String str) {
        if (DEBUG) {
            Log.d("ApiCalledMarker", str);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void start(long j) {
        aDg();
        reset();
        this.dhQ = j;
        log("launch start time-" + j);
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void bX(long j) {
        this.dhP = true;
        this.cGz = j;
        qW(format());
        log("launch end time-" + (this.dhQ + this.cGz));
    }

    private void reset() {
        if (this.dhM.size() > 0) {
            synchronized (this.mLock) {
                this.dhM.clear();
            }
        }
        this.dhO = false;
        this.dhP = false;
        this.cGz = 0L;
        this.dhQ = 0L;
        this.dhN = null;
        qW("===== loading... =====");
    }

    private void qW(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.am.e.dBl.aa(str);
        }
    }
}
