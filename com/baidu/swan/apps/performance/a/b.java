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
    private long cPQ;
    private c drg;
    private SimpleDateFormat drh;
    private HashMap<String, List<a>> dri;
    private String drj;
    private boolean drk;
    private boolean drl;
    private long drm;
    private final Object mLock = new Object();

    private void aEj() {
        if (this.dri == null) {
            synchronized (this.mLock) {
                if (this.dri == null) {
                    this.dri = new HashMap<>();
                    this.drh = new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault());
                    this.drg = new c() { // from class: com.baidu.swan.apps.performance.a.b.1
                        @Override // com.baidu.swan.apps.performance.a.c
                        public boolean a(a aVar) {
                            if (aVar == null || aVar.aqu() < 0) {
                                return false;
                            }
                            if (b.DEBUG || !d.dro.contains(aVar.getApiName())) {
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
        return j >= this.drm && j <= this.drm + this.cPQ;
    }

    public String format() {
        int i;
        int i2;
        if (!this.drl) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("----- ").append("launch start time ").append(this.drh.format(Long.valueOf(this.drm))).append("\n");
        sb.append("----- ").append("launch end time ").append(this.drh.format(Long.valueOf(this.drm + this.cPQ))).append("\n");
        sb.append("----- ").append("swan js version ").append(this.drj).append("\n");
        int i3 = 0;
        int i4 = 0;
        synchronized (this.mLock) {
            for (Map.Entry<String, List<a>> entry : this.dri.entrySet()) {
                List<a> value = entry.getValue();
                if (value != null && value.size() > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    int i5 = 0;
                    for (a aVar : value) {
                        if (this.drg == null || this.drg.a(aVar)) {
                            sb2.append("----- start time ").append(this.drh.format(Long.valueOf(aVar.getStart()))).append("\n");
                            sb2.append("----- end time ").append(this.drh.format(Long.valueOf(aVar.getEnd()))).append("\n");
                            sb2.append("----- cost time ").append(aVar.aqu()).append("ms\n");
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
        aEj();
        reset();
        this.drm = j;
        log("launch start time-" + j);
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void cD(long j) {
        this.drl = true;
        this.cPQ = j;
        qD(format());
        log("launch end time-" + (this.drm + this.cPQ));
    }

    private void reset() {
        if (this.dri.size() > 0) {
            synchronized (this.mLock) {
                this.dri.clear();
            }
        }
        this.drk = false;
        this.drl = false;
        this.cPQ = 0L;
        this.drm = 0L;
        this.drj = null;
        qD("===== loading... =====");
    }

    private void qD(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.al.e.dOg.ab(str);
        }
    }
}
