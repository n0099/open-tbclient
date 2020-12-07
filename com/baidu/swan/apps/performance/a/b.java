package com.baidu.swan.apps.performance.a;

import android.text.TextUtils;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes25.dex */
public class b implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private long cNt;
    private c doM;
    private SimpleDateFormat doN;
    private HashMap<String, List<a>> doO;
    private String doP;
    private boolean doQ;
    private boolean doR;
    private long doS;
    private final Object mLock = new Object();

    private void aGo() {
        if (this.doO == null) {
            synchronized (this.mLock) {
                if (this.doO == null) {
                    this.doO = new HashMap<>();
                    this.doN = new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault());
                    this.doM = new c() { // from class: com.baidu.swan.apps.performance.a.b.1
                        @Override // com.baidu.swan.apps.performance.a.c
                        public boolean a(a aVar) {
                            if (aVar == null || aVar.asz() < 0) {
                                return false;
                            }
                            if (b.DEBUG || !d.doU.contains(aVar.getApiName())) {
                                return b.this.cy(aVar.getStart());
                            }
                            return false;
                        }
                    };
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cy(long j) {
        return j >= this.doS && j <= this.doS + this.cNt;
    }

    public String format() {
        int i;
        int i2;
        if (!this.doR) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("----- ").append("launch start time ").append(this.doN.format(Long.valueOf(this.doS))).append("\n");
        sb.append("----- ").append("launch end time ").append(this.doN.format(Long.valueOf(this.doS + this.cNt))).append("\n");
        sb.append("----- ").append("swan js version ").append(this.doP).append("\n");
        int i3 = 0;
        int i4 = 0;
        synchronized (this.mLock) {
            for (Map.Entry<String, List<a>> entry : this.doO.entrySet()) {
                List<a> value = entry.getValue();
                if (value != null && value.size() > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    int i5 = 0;
                    for (a aVar : value) {
                        if (this.doM == null || this.doM.a(aVar)) {
                            sb2.append("----- start time ").append(this.doN.format(Long.valueOf(aVar.getStart()))).append("\n");
                            sb2.append("----- end time ").append(this.doN.format(Long.valueOf(aVar.getEnd()))).append("\n");
                            sb2.append("----- cost time ").append(aVar.asz()).append("ms\n");
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
        aGo();
        reset();
        this.doS = j;
        log("launch start time-" + j);
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void cw(long j) {
        this.doR = true;
        this.cNt = j;
        rD(format());
        log("launch end time-" + (this.doS + this.cNt));
    }

    private void reset() {
        if (this.doO.size() > 0) {
            synchronized (this.mLock) {
                this.doO.clear();
            }
        }
        this.doQ = false;
        this.doR = false;
        this.cNt = 0L;
        this.doS = 0L;
        this.doP = null;
        rD("===== loading... =====");
    }

    private void rD(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.am.e.dIj.aa(str);
        }
    }
}
