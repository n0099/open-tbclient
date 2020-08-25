package com.baidu.swan.apps.performance.a;

import android.text.TextUtils;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes8.dex */
public class b implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c cGR;
    private SimpleDateFormat cGS;
    private HashMap<String, List<a>> cGT;
    private String cGU;
    private boolean cGV;
    private boolean cGW;
    private long cGX;
    private long cfv;
    private final Object mLock = new Object();

    private void awa() {
        if (this.cGT == null) {
            synchronized (this.mLock) {
                if (this.cGT == null) {
                    this.cGT = new HashMap<>();
                    this.cGS = new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault());
                    this.cGR = new c() { // from class: com.baidu.swan.apps.performance.a.b.1
                        @Override // com.baidu.swan.apps.performance.a.c
                        public boolean a(a aVar) {
                            if (aVar == null || aVar.aij() < 0) {
                                return false;
                            }
                            if (b.DEBUG || !d.cGZ.contains(aVar.getApiName())) {
                                return b.this.bs(aVar.getStart());
                            }
                            return false;
                        }
                    };
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bs(long j) {
        return j >= this.cGX && j <= this.cGX + this.cfv;
    }

    public String format() {
        int i;
        int i2;
        if (!this.cGW) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("----- ").append("launch start time ").append(this.cGS.format(Long.valueOf(this.cGX))).append("\n");
        sb.append("----- ").append("launch end time ").append(this.cGS.format(Long.valueOf(this.cGX + this.cfv))).append("\n");
        sb.append("----- ").append("swan js version ").append(this.cGU).append("\n");
        int i3 = 0;
        int i4 = 0;
        synchronized (this.mLock) {
            for (Map.Entry<String, List<a>> entry : this.cGT.entrySet()) {
                List<a> value = entry.getValue();
                if (value != null && value.size() > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    int i5 = 0;
                    for (a aVar : value) {
                        if (this.cGR == null || this.cGR.a(aVar)) {
                            sb2.append("----- start time ").append(this.cGS.format(Long.valueOf(aVar.getStart()))).append("\n");
                            sb2.append("----- end time ").append(this.cGS.format(Long.valueOf(aVar.getEnd()))).append("\n");
                            sb2.append("----- cost time ").append(aVar.aij()).append("ms\n");
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
        awa();
        reset();
        this.cGX = j;
        log("launch start time-" + j);
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void bq(long j) {
        this.cGW = true;
        this.cfv = j;
        pp(format());
        log("launch end time-" + (this.cGX + this.cfv));
    }

    private void reset() {
        if (this.cGT.size() > 0) {
            synchronized (this.mLock) {
                this.cGT.clear();
            }
        }
        this.cGV = false;
        this.cGW = false;
        this.cfv = 0L;
        this.cGX = 0L;
        this.cGU = null;
        pp("===== loading... =====");
    }

    private void pp(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.am.e.dak.W(str);
        }
    }
}
