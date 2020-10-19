package com.baidu.swan.apps.performance.a;

import android.text.TextUtils;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes10.dex */
public class b implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c cUY;
    private SimpleDateFormat cUZ;
    private HashMap<String, List<a>> cVa;
    private String cVb;
    private boolean cVc;
    private boolean cVd;
    private long cVe;
    private long ctS;
    private final Object mLock = new Object();

    private void azu() {
        if (this.cVa == null) {
            synchronized (this.mLock) {
                if (this.cVa == null) {
                    this.cVa = new HashMap<>();
                    this.cUZ = new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault());
                    this.cUY = new c() { // from class: com.baidu.swan.apps.performance.a.b.1
                        @Override // com.baidu.swan.apps.performance.a.c
                        public boolean a(a aVar) {
                            if (aVar == null || aVar.alE() < 0) {
                                return false;
                            }
                            if (b.DEBUG || !d.cVg.contains(aVar.getApiName())) {
                                return b.this.bB(aVar.getStart());
                            }
                            return false;
                        }
                    };
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bB(long j) {
        return j >= this.cVe && j <= this.cVe + this.ctS;
    }

    public String format() {
        int i;
        int i2;
        if (!this.cVd) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("----- ").append("launch start time ").append(this.cUZ.format(Long.valueOf(this.cVe))).append("\n");
        sb.append("----- ").append("launch end time ").append(this.cUZ.format(Long.valueOf(this.cVe + this.ctS))).append("\n");
        sb.append("----- ").append("swan js version ").append(this.cVb).append("\n");
        int i3 = 0;
        int i4 = 0;
        synchronized (this.mLock) {
            for (Map.Entry<String, List<a>> entry : this.cVa.entrySet()) {
                List<a> value = entry.getValue();
                if (value != null && value.size() > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    int i5 = 0;
                    for (a aVar : value) {
                        if (this.cUY == null || this.cUY.a(aVar)) {
                            sb2.append("----- start time ").append(this.cUZ.format(Long.valueOf(aVar.getStart()))).append("\n");
                            sb2.append("----- end time ").append(this.cUZ.format(Long.valueOf(aVar.getEnd()))).append("\n");
                            sb2.append("----- cost time ").append(aVar.alE()).append("ms\n");
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
        azu();
        reset();
        this.cVe = j;
        log("launch start time-" + j);
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void bz(long j) {
        this.cVd = true;
        this.ctS = j;
        qv(format());
        log("launch end time-" + (this.cVe + this.ctS));
    }

    private void reset() {
        if (this.cVa.size() > 0) {
            synchronized (this.mLock) {
                this.cVa.clear();
            }
        }
        this.cVc = false;
        this.cVd = false;
        this.ctS = 0L;
        this.cVe = 0L;
        this.cVb = null;
        qv("===== loading... =====");
    }

    private void qv(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.am.e.doA.aa(str);
        }
    }
}
