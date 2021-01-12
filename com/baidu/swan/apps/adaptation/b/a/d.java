package com.baidu.swan.apps.adaptation.b.a;

import android.util.Log;
import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public long cAW;
    public long cAX;
    public volatile long cAY;
    public long cAZ;
    public long cBa;
    private long cBb;
    public String cBc = "1";

    public long aiL() {
        if (this.cBb > 0) {
            return this.cBb;
        }
        long[] jArr = {this.cAZ, this.cBa, this.cAX};
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
            this.cBb = j;
        }
        return this.cBb;
    }

    public final void aiM() {
        if (this.cAY > 0 && this.cAY != this.cAZ && this.cAY != this.cBa && this.cAY != this.cAX) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: miss with real fmp=" + this.cAY);
            }
        } else if (this.cAZ > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with ftp=" + this.cAZ);
            }
            this.cAY = this.cAZ;
            this.cBc = "2";
        } else if (this.cBa > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fip=" + this.cBa);
            }
            this.cAY = this.cBa;
            this.cBc = "3";
        } else if (this.cAX > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fcp=" + this.cAX);
            }
            this.cAY = this.cAX;
            this.cBc = "1";
        } else if (DEBUG) {
            throw new RuntimeException("ftp fcp fip 至少收到上述一个回调才能校准 fmp \n" + toString());
        }
    }

    @NonNull
    public String aiN() {
        String str = this.cBc;
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

    public String bT(long j) {
        if (j == this.cAZ) {
            return "2";
        }
        if (j == this.cBa) {
            return "3";
        }
        if (j != this.cAX && j == this.cAY) {
            return "0";
        }
        return "1";
    }

    public String toString() {
        return "WebViewPaintTiming{fp=" + this.cAW + ", fcp=" + this.cAX + ", fmp=" + this.cAY + ", ftp=" + this.cAZ + ", fip=" + this.cBa + ", mMinCache=" + this.cBb + ", fmpType='" + this.cBc + "', fmpTypeName='" + aiN() + "'}";
    }
}
