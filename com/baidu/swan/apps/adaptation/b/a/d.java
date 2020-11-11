package com.baidu.swan.apps.adaptation.b.a;

import android.support.annotation.NonNull;
import android.util.Log;
/* loaded from: classes10.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public long cvK;
    public long cvL;
    public volatile long cvM;
    public long cvN;
    public long cvO;
    private long cvP;
    public String cvQ = "1";

    public long aiU() {
        if (this.cvP > 0) {
            return this.cvP;
        }
        long[] jArr = {this.cvN, this.cvO, this.cvL};
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
            this.cvP = j;
        }
        return this.cvP;
    }

    public final void aiV() {
        if (this.cvM > 0 && this.cvM != this.cvN && this.cvM != this.cvO && this.cvM != this.cvL) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: miss with real fmp=" + this.cvM);
            }
        } else if (this.cvN > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with ftp=" + this.cvN);
            }
            this.cvM = this.cvN;
            this.cvQ = "2";
        } else if (this.cvO > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fip=" + this.cvO);
            }
            this.cvM = this.cvO;
            this.cvQ = "3";
        } else if (this.cvL > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fcp=" + this.cvL);
            }
            this.cvM = this.cvL;
            this.cvQ = "1";
        } else if (DEBUG) {
            throw new RuntimeException("ftp fcp fip 至少收到上述一个回调才能校准 fmp \n" + toString());
        }
    }

    @NonNull
    public String aiW() {
        String str = this.cvQ;
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

    public String bt(long j) {
        if (j == this.cvN) {
            return "2";
        }
        if (j == this.cvO) {
            return "3";
        }
        if (j != this.cvL && j == this.cvM) {
            return "0";
        }
        return "1";
    }

    public String toString() {
        return "WebViewPaintTiming{fp=" + this.cvK + ", fcp=" + this.cvL + ", fmp=" + this.cvM + ", ftp=" + this.cvN + ", fip=" + this.cvO + ", mMinCache=" + this.cvP + ", fmpType='" + this.cvQ + "', fmpTypeName='" + aiW() + "'}";
    }
}
