package com.baidu.swan.apps.adaptation.b.a;

import android.support.annotation.NonNull;
import android.util.Log;
/* loaded from: classes7.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private long bNA;
    public String bNB = "1";
    public long bNv;
    public long bNw;
    public volatile long bNx;
    public long bNy;
    public long bNz;

    public long Va() {
        if (this.bNA > 0) {
            return this.bNA;
        }
        long[] jArr = {this.bNy, this.bNz, this.bNw};
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
            this.bNA = j;
        }
        return this.bNA;
    }

    public final void Vb() {
        if (this.bNx > 0 && this.bNx != this.bNy && this.bNx != this.bNz && this.bNx != this.bNw) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: miss with real fmp=" + this.bNx);
            }
        } else if (this.bNy > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with ftp=" + this.bNy);
            }
            this.bNx = this.bNy;
            this.bNB = "2";
        } else if (this.bNz > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fip=" + this.bNz);
            }
            this.bNx = this.bNz;
            this.bNB = "3";
        } else if (this.bNw > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fcp=" + this.bNw);
            }
            this.bNx = this.bNw;
            this.bNB = "1";
        } else if (DEBUG) {
            throw new RuntimeException("ftp fcp fip 至少收到上述一个回调才能校准 fmp \n" + toString());
        }
    }

    @NonNull
    public String Vc() {
        String str = this.bNB;
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

    public String aL(long j) {
        if (j == this.bNy) {
            return "2";
        }
        if (j == this.bNz) {
            return "3";
        }
        if (j != this.bNw && j == this.bNx) {
            return "0";
        }
        return "1";
    }

    public String toString() {
        return "WebViewPaintTiming{fp=" + this.bNv + ", fcp=" + this.bNw + ", fmp=" + this.bNx + ", ftp=" + this.bNy + ", fip=" + this.bNz + ", mMinCache=" + this.bNA + ", fmpType='" + this.bNB + "', fmpTypeName='" + Vc() + "'}";
    }
}
