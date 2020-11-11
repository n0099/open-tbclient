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
    private long cIj;
    private long djA;
    private c dju;
    private SimpleDateFormat djv;
    private HashMap<String, List<a>> djw;
    private String djx;
    private boolean djy;
    private boolean djz;
    private final Object mLock = new Object();

    private void aDO() {
        if (this.djw == null) {
            synchronized (this.mLock) {
                if (this.djw == null) {
                    this.djw = new HashMap<>();
                    this.djv = new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault());
                    this.dju = new c() { // from class: com.baidu.swan.apps.performance.a.b.1
                        @Override // com.baidu.swan.apps.performance.a.c
                        public boolean a(a aVar) {
                            if (aVar == null || aVar.apZ() < 0) {
                                return false;
                            }
                            if (b.DEBUG || !d.djC.contains(aVar.getApiName())) {
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
        return j >= this.djA && j <= this.djA + this.cIj;
    }

    public String format() {
        int i;
        int i2;
        if (!this.djz) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("----- ").append("launch start time ").append(this.djv.format(Long.valueOf(this.djA))).append("\n");
        sb.append("----- ").append("launch end time ").append(this.djv.format(Long.valueOf(this.djA + this.cIj))).append("\n");
        sb.append("----- ").append("swan js version ").append(this.djx).append("\n");
        int i3 = 0;
        int i4 = 0;
        synchronized (this.mLock) {
            for (Map.Entry<String, List<a>> entry : this.djw.entrySet()) {
                List<a> value = entry.getValue();
                if (value != null && value.size() > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    int i5 = 0;
                    for (a aVar : value) {
                        if (this.dju == null || this.dju.a(aVar)) {
                            sb2.append("----- start time ").append(this.djv.format(Long.valueOf(aVar.getStart()))).append("\n");
                            sb2.append("----- end time ").append(this.djv.format(Long.valueOf(aVar.getEnd()))).append("\n");
                            sb2.append("----- cost time ").append(aVar.apZ()).append("ms\n");
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
        aDO();
        reset();
        this.djA = j;
        log("launch start time-" + j);
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public void bX(long j) {
        this.djz = true;
        this.cIj = j;
        rc(format());
        log("launch end time-" + (this.djA + this.cIj));
    }

    private void reset() {
        if (this.djw.size() > 0) {
            synchronized (this.mLock) {
                this.djw.clear();
            }
        }
        this.djy = false;
        this.djz = false;
        this.cIj = 0L;
        this.djA = 0L;
        this.djx = null;
        rc("===== loading... =====");
    }

    private void rc(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.am.e.dCS.aa(str);
        }
    }
}
