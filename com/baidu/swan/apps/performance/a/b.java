package com.baidu.swan.apps.performance.a;

import android.text.TextUtils;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes3.dex */
public class b implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c cIV;
    private SimpleDateFormat cIW;
    private HashMap<String, List<a>> cIX;
    private String cIY;
    private boolean cIZ;
    private boolean cJa;
    private long cJb;
    private long chA;
    private final Object mLock = new Object();

    private void awJ() {
        if (this.cIX == null) {
            synchronized (this.mLock) {
                if (this.cIX == null) {
                    this.cIX = new HashMap<>();
                    this.cIW = new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault());
                    this.cIV = new c() { // from class: com.baidu.swan.apps.performance.a.b.1
                        @Override // com.baidu.swan.apps.performance.a.c
                        public boolean a(a aVar) {
                            if (aVar == null || aVar.aiT() < 0) {
                                return false;
                            }
                            if (b.DEBUG || !d.cJd.contains(aVar.getApiName())) {
                                return b.this.bt(aVar.getStart());
                            }
                            return false;
                        }
                    };
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bt(long j) {
        return j >= this.cJb && j <= this.cJb + this.chA;
    }

    public String format() {
        int i;
        int i2;
        if (!this.cJa) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("----- ").append("launch start time ").append(this.cIW.format(Long.valueOf(this.cJb))).append("\n");
        sb.append("----- ").append("launch end time ").append(this.cIW.format(Long.valueOf(this.cJb + this.chA))).append("\n");
        sb.append("----- ").append("swan js version ").append(this.cIY).append("\n");
        int i3 = 0;
        int i4 = 0;
        synchronized (this.mLock) {
            for (Map.Entry<String, List<a>> entry : this.cIX.entrySet()) {
                List<a> value = entry.getValue();
                if (value != null && value.size() > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    int i5 = 0;
                    for (a aVar : value) {
                        if (this.cIV == null || this.cIV.a(aVar)) {
                            sb2.append("----- start time ").append(this.cIW.format(Long.valueOf(aVar.getStart()))).append("\n");
                            sb2.append("----- end time ").append(this.cIW.format(Long.valueOf(aVar.getEnd()))).append("\n");
                            sb2.append("----- cost time ").append(aVar.aiT()).append("ms\n");
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
        awJ();
        reset();
        this.cJb = j;
        log("launch start time-" + j);
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void br(long j) {
        this.cJa = true;
        this.chA = j;
        pJ(format());
        log("launch end time-" + (this.cJb + this.chA));
    }

    private void reset() {
        if (this.cIX.size() > 0) {
            synchronized (this.mLock) {
                this.cIX.clear();
            }
        }
        this.cIZ = false;
        this.cJa = false;
        this.chA = 0L;
        this.cJb = 0L;
        this.cIY = null;
        pJ("===== loading... =====");
    }

    private void pJ(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.am.e.dcq.X(str);
        }
    }
}
