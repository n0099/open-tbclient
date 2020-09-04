package com.baidu.swan.apps.adaptation.b.a;

import android.support.annotation.NonNull;
import android.util.Log;
/* loaded from: classes8.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public long bSX;
    public long bSY;
    public volatile long bSZ;
    public long bTa;
    public long bTb;
    private long bTc;
    public String bTd = "1";

    public long abf() {
        if (this.bTc > 0) {
            return this.bTc;
        }
        long[] jArr = {this.bTa, this.bTb, this.bSY};
        int length = jArr.length;
        int i = 0;
        long j = Long.MAX_VALUE;
        while (i < length) {
            long j2 = jArr[i];
            if (j2 <= 0 || j2 >= j) {
                j2 = j;
            }
            i++;
            j = j2;
        }
        if (j != Long.MAX_VALUE) {
            this.bTc = j;
        }
        return this.bTc;
    }

    public final void abg() {
        if (this.bSZ > 0 && this.bSZ != this.bTa && this.bSZ != this.bTb && this.bSZ != this.bSY) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: miss with real fmp=" + this.bSZ);
            }
        } else if (this.bTa > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with ftp=" + this.bTa);
            }
            this.bSZ = this.bTa;
            this.bTd = "2";
        } else if (this.bTb > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fip=" + this.bTb);
            }
            this.bSZ = this.bTb;
            this.bTd = "3";
        } else if (this.bSY > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fcp=" + this.bSY);
            }
            this.bSZ = this.bSY;
            this.bTd = "1";
        } else if (DEBUG) {
            throw new RuntimeException("ftp fcp fip 至少收到上述一个回调才能校准 fmp \n" + toString());
        }
    }

    @NonNull
    public String abh() {
        String str = this.bTd;
        char c = 65535;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    c = 0;
                    break;
                }
                break;
            case 49:
                if (str.equals("1")) {
                    c = 1;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c = 2;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return "fmp";
            case 1:
                return "fcp";
            case 2:
                return "ftp";
            case 3:
                return "fip";
            default:
                return "unknown";
        }
    }

    public String aM(long j) {
        if (j == this.bTa) {
            return "2";
        }
        if (j == this.bTb) {
            return "3";
        }
        if (j != this.bSY && j == this.bSZ) {
            return "0";
        }
        return "1";
    }

    public String toString() {
        return "WebViewPaintTiming{fp=" + this.bSX + ", fcp=" + this.bSY + ", fmp=" + this.bSZ + ", ftp=" + this.bTa + ", fip=" + this.bTb + ", mMinCache=" + this.bTc + ", fmpType='" + this.bTd + "', fmpTypeName='" + abh() + "'}";
    }
}
