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
    private c cGV;
    private SimpleDateFormat cGW;
    private HashMap<String, List<a>> cGX;
    private String cGY;
    private boolean cGZ;
    private boolean cHa;
    private long cHb;
    private long cfz;
    private final Object mLock = new Object();

    private void awa() {
        if (this.cGX == null) {
            synchronized (this.mLock) {
                if (this.cGX == null) {
                    this.cGX = new HashMap<>();
                    this.cGW = new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault());
                    this.cGV = new c() { // from class: com.baidu.swan.apps.performance.a.b.1
                        @Override // com.baidu.swan.apps.performance.a.c
                        public boolean a(a aVar) {
                            if (aVar == null || aVar.aij() < 0) {
                                return false;
                            }
                            if (b.DEBUG || !d.cHd.contains(aVar.getApiName())) {
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
        return j >= this.cHb && j <= this.cHb + this.cfz;
    }

    public String format() {
        int i;
        int i2;
        if (!this.cHa) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("----- ").append("launch start time ").append(this.cGW.format(Long.valueOf(this.cHb))).append("\n");
        sb.append("----- ").append("launch end time ").append(this.cGW.format(Long.valueOf(this.cHb + this.cfz))).append("\n");
        sb.append("----- ").append("swan js version ").append(this.cGY).append("\n");
        int i3 = 0;
        int i4 = 0;
        synchronized (this.mLock) {
            for (Map.Entry<String, List<a>> entry : this.cGX.entrySet()) {
                List<a> value = entry.getValue();
                if (value != null && value.size() > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    int i5 = 0;
                    for (a aVar : value) {
                        if (this.cGV == null || this.cGV.a(aVar)) {
                            sb2.append("----- start time ").append(this.cGW.format(Long.valueOf(aVar.getStart()))).append("\n");
                            sb2.append("----- end time ").append(this.cGW.format(Long.valueOf(aVar.getEnd()))).append("\n");
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
        this.cHb = j;
        log("launch start time-" + j);
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void bq(long j) {
        this.cHa = true;
        this.cfz = j;
        pq(format());
        log("launch end time-" + (this.cHb + this.cfz));
    }

    private void reset() {
        if (this.cGX.size() > 0) {
            synchronized (this.mLock) {
                this.cGX.clear();
            }
        }
        this.cGZ = false;
        this.cHa = false;
        this.cfz = 0L;
        this.cHb = 0L;
        this.cGY = null;
        pq("===== loading... =====");
    }

    private void pq(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.am.e.dao.W(str);
        }
    }
}
