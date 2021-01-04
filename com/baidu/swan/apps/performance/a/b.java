package com.baidu.swan.apps.performance.a;

import android.text.TextUtils;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes9.dex */
public class b implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private long cSo;
    private c dtL;
    private SimpleDateFormat dtM;
    private HashMap<String, List<a>> dtN;
    private String dtO;
    private boolean dtP;
    private boolean dtQ;
    private long dtR;
    private final Object mLock = new Object();

    private void aHH() {
        if (this.dtN == null) {
            synchronized (this.mLock) {
                if (this.dtN == null) {
                    this.dtN = new HashMap<>();
                    this.dtM = new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault());
                    this.dtL = new c() { // from class: com.baidu.swan.apps.performance.a.b.1
                        @Override // com.baidu.swan.apps.performance.a.c
                        public boolean a(a aVar) {
                            if (aVar == null || aVar.atQ() < 0) {
                                return false;
                            }
                            if (b.DEBUG || !d.dtT.contains(aVar.getApiName())) {
                                return b.this.cz(aVar.getStart());
                            }
                            return false;
                        }
                    };
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cz(long j) {
        return j >= this.dtR && j <= this.dtR + this.cSo;
    }

    public String format() {
        int i;
        int i2;
        if (!this.dtQ) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("----- ").append("launch start time ").append(this.dtM.format(Long.valueOf(this.dtR))).append("\n");
        sb.append("----- ").append("launch end time ").append(this.dtM.format(Long.valueOf(this.dtR + this.cSo))).append("\n");
        sb.append("----- ").append("swan js version ").append(this.dtO).append("\n");
        int i3 = 0;
        int i4 = 0;
        synchronized (this.mLock) {
            for (Map.Entry<String, List<a>> entry : this.dtN.entrySet()) {
                List<a> value = entry.getValue();
                if (value != null && value.size() > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    int i5 = 0;
                    for (a aVar : value) {
                        if (this.dtL == null || this.dtL.a(aVar)) {
                            sb2.append("----- start time ").append(this.dtM.format(Long.valueOf(aVar.getStart()))).append("\n");
                            sb2.append("----- end time ").append(this.dtM.format(Long.valueOf(aVar.getEnd()))).append("\n");
                            sb2.append("----- cost time ").append(aVar.atQ()).append("ms\n");
                            sb2.append("----------------------------\n");
                            i4++;
                            i2 = i5 + 1;
                        } else {
                            i2 = i5;
                        }
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
        aHH();
        reset();
        this.dtR = j;
        log("launch start time-" + j);
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void cx(long j) {
        this.dtQ = true;
        this.cSo = j;
        rw(format());
        log("launch end time-" + (this.dtR + this.cSo));
    }

    private void reset() {
        if (this.dtN.size() > 0) {
            synchronized (this.mLock) {
                this.dtN.clear();
            }
        }
        this.dtP = false;
        this.dtQ = false;
        this.cSo = 0L;
        this.dtR = 0L;
        this.dtO = null;
        rw("===== loading... =====");
    }

    private void rw(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.al.e.dQO.ab(str);
        }
    }
}
