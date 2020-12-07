package com.baidu.swan.apps.adaptation.b.a;

import android.support.annotation.NonNull;
import android.util.Log;
/* loaded from: classes25.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public long cAS;
    public long cAT;
    public volatile long cAU;
    public long cAV;
    public long cAW;
    private long cAX;
    public String cAY = "1";

    public long alu() {
        if (this.cAX > 0) {
            return this.cAX;
        }
        long[] jArr = {this.cAV, this.cAW, this.cAT};
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
            this.cAX = j;
        }
        return this.cAX;
    }

    public final void alv() {
        if (this.cAU > 0 && this.cAU != this.cAV && this.cAU != this.cAW && this.cAU != this.cAT) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: miss with real fmp=" + this.cAU);
            }
        } else if (this.cAV > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with ftp=" + this.cAV);
            }
            this.cAU = this.cAV;
            this.cAY = "2";
        } else if (this.cAW > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fip=" + this.cAW);
            }
            this.cAU = this.cAW;
            this.cAY = "3";
        } else if (this.cAT > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fcp=" + this.cAT);
            }
            this.cAU = this.cAT;
            this.cAY = "1";
        } else if (DEBUG) {
            throw new RuntimeException("ftp fcp fip 至少收到上述一个回调才能校准 fmp \n" + toString());
        }
    }

    @NonNull
    public String alw() {
        String str = this.cAY;
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

    public String bS(long j) {
        if (j == this.cAV) {
            return "2";
        }
        if (j == this.cAW) {
            return "3";
        }
        if (j != this.cAT && j == this.cAU) {
            return "0";
        }
        return "1";
    }

    public String toString() {
        return "WebViewPaintTiming{fp=" + this.cAS + ", fcp=" + this.cAT + ", fmp=" + this.cAU + ", ftp=" + this.cAV + ", fip=" + this.cAW + ", mMinCache=" + this.cAX + ", fmpType='" + this.cAY + "', fmpTypeName='" + alw() + "'}";
    }
}
