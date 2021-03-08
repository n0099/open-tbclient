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
    private long cRq;
    private c dsJ;
    private SimpleDateFormat dsK;
    private HashMap<String, List<a>> dsL;
    private String dsM;
    private boolean dsN;
    private boolean dsO;
    private long dsP;
    private final Object mLock = new Object();

    private void aEm() {
        if (this.dsL == null) {
            synchronized (this.mLock) {
                if (this.dsL == null) {
                    this.dsL = new HashMap<>();
                    this.dsK = new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault());
                    this.dsJ = new c() { // from class: com.baidu.swan.apps.performance.a.b.1
                        @Override // com.baidu.swan.apps.performance.a.c
                        public boolean a(a aVar) {
                            if (aVar == null || aVar.aqx() < 0) {
                                return false;
                            }
                            if (b.DEBUG || !d.dsR.contains(aVar.getApiName())) {
                                return b.this.cF(aVar.getStart());
                            }
                            return false;
                        }
                    };
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cF(long j) {
        return j >= this.dsP && j <= this.dsP + this.cRq;
    }

    public String format() {
        int i;
        int i2;
        if (!this.dsO) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("----- ").append("launch start time ").append(this.dsK.format(Long.valueOf(this.dsP))).append("\n");
        sb.append("----- ").append("launch end time ").append(this.dsK.format(Long.valueOf(this.dsP + this.cRq))).append("\n");
        sb.append("----- ").append("swan js version ").append(this.dsM).append("\n");
        int i3 = 0;
        int i4 = 0;
        synchronized (this.mLock) {
            for (Map.Entry<String, List<a>> entry : this.dsL.entrySet()) {
                List<a> value = entry.getValue();
                if (value != null && value.size() > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    int i5 = 0;
                    for (a aVar : value) {
                        if (this.dsJ == null || this.dsJ.a(aVar)) {
                            sb2.append("----- start time ").append(this.dsK.format(Long.valueOf(aVar.getStart()))).append("\n");
                            sb2.append("----- end time ").append(this.dsK.format(Long.valueOf(aVar.getEnd()))).append("\n");
                            sb2.append("----- cost time ").append(aVar.aqx()).append("ms\n");
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
        aEm();
        reset();
        this.dsP = j;
        log("launch start time-" + j);
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void cD(long j) {
        this.dsO = true;
        this.cRq = j;
        qK(format());
        log("launch end time-" + (this.dsP + this.cRq));
    }

    private void reset() {
        if (this.dsL.size() > 0) {
            synchronized (this.mLock) {
                this.dsL.clear();
            }
        }
        this.dsN = false;
        this.dsO = false;
        this.cRq = 0L;
        this.dsP = 0L;
        this.dsM = null;
        qK("===== loading... =====");
    }

    private void qK(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.al.e.dPH.ad(str);
        }
    }
}
