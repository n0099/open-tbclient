package com.baidu.swan.apps.adaptation.b.a;

import android.support.annotation.NonNull;
import android.util.Log;
/* loaded from: classes8.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public long bST;
    public long bSU;
    public volatile long bSV;
    public long bSW;
    public long bSX;
    private long bSY;
    public String bSZ = "1";

    public long abf() {
        if (this.bSY > 0) {
            return this.bSY;
        }
        long[] jArr = {this.bSW, this.bSX, this.bSU};
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
            this.bSY = j;
        }
        return this.bSY;
    }

    public final void abg() {
        if (this.bSV > 0 && this.bSV != this.bSW && this.bSV != this.bSX && this.bSV != this.bSU) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: miss with real fmp=" + this.bSV);
            }
        } else if (this.bSW > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with ftp=" + this.bSW);
            }
            this.bSV = this.bSW;
            this.bSZ = "2";
        } else if (this.bSX > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fip=" + this.bSX);
            }
            this.bSV = this.bSX;
            this.bSZ = "3";
        } else if (this.bSU > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fcp=" + this.bSU);
            }
            this.bSV = this.bSU;
            this.bSZ = "1";
        } else if (DEBUG) {
            throw new RuntimeException("ftp fcp fip 至少收到上述一个回调才能校准 fmp \n" + toString());
        }
    }

    @NonNull
    public String abh() {
        String str = this.bSZ;
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
        if (j == this.bSW) {
            return "2";
        }
        if (j == this.bSX) {
            return "3";
        }
        if (j != this.bSU && j == this.bSV) {
            return "0";
        }
        return "1";
    }

    public String toString() {
        return "WebViewPaintTiming{fp=" + this.bST + ", fcp=" + this.bSU + ", fmp=" + this.bSV + ", ftp=" + this.bSW + ", fip=" + this.bSX + ", mMinCache=" + this.bSY + ", fmpType='" + this.bSZ + "', fmpTypeName='" + abh() + "'}";
    }
}
