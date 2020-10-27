package com.baidu.swan.apps.adaptation.b.a;

import android.support.annotation.NonNull;
import android.util.Log;
/* loaded from: classes10.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public long cpM;
    public long cpN;
    public volatile long cpO;
    public long cpP;
    public long cpQ;
    private long cpR;
    public String cpS = "1";

    public long agu() {
        if (this.cpR > 0) {
            return this.cpR;
        }
        long[] jArr = {this.cpP, this.cpQ, this.cpN};
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
            this.cpR = j;
        }
        return this.cpR;
    }

    public final void agv() {
        if (this.cpO > 0 && this.cpO != this.cpP && this.cpO != this.cpQ && this.cpO != this.cpN) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: miss with real fmp=" + this.cpO);
            }
        } else if (this.cpP > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with ftp=" + this.cpP);
            }
            this.cpO = this.cpP;
            this.cpS = "2";
        } else if (this.cpQ > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fip=" + this.cpQ);
            }
            this.cpO = this.cpQ;
            this.cpS = "3";
        } else if (this.cpN > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fcp=" + this.cpN);
            }
            this.cpO = this.cpN;
            this.cpS = "1";
        } else if (DEBUG) {
            throw new RuntimeException("ftp fcp fip 至少收到上述一个回调才能校准 fmp \n" + toString());
        }
    }

    @NonNull
    public String agw() {
        String str = this.cpS;
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

    public String aX(long j) {
        if (j == this.cpP) {
            return "2";
        }
        if (j == this.cpQ) {
            return "3";
        }
        if (j != this.cpN && j == this.cpO) {
            return "0";
        }
        return "1";
    }

    public String toString() {
        return "WebViewPaintTiming{fp=" + this.cpM + ", fcp=" + this.cpN + ", fmp=" + this.cpO + ", ftp=" + this.cpP + ", fip=" + this.cpQ + ", mMinCache=" + this.cpR + ", fmpType='" + this.cpS + "', fmpTypeName='" + agw() + "'}";
    }
}
