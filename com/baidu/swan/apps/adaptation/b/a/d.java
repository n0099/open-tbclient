package com.baidu.swan.apps.adaptation.b.a;

import android.support.annotation.NonNull;
import android.util.Log;
/* loaded from: classes3.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public long bUX;
    public long bUY;
    public volatile long bUZ;
    public long bVa;
    public long bVb;
    private long bVc;
    public String bVd = "1";

    public long abO() {
        if (this.bVc > 0) {
            return this.bVc;
        }
        long[] jArr = {this.bVa, this.bVb, this.bUY};
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
            this.bVc = j;
        }
        return this.bVc;
    }

    public final void abP() {
        if (this.bUZ > 0 && this.bUZ != this.bVa && this.bUZ != this.bVb && this.bUZ != this.bUY) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: miss with real fmp=" + this.bUZ);
            }
        } else if (this.bVa > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with ftp=" + this.bVa);
            }
            this.bUZ = this.bVa;
            this.bVd = "2";
        } else if (this.bVb > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fip=" + this.bVb);
            }
            this.bUZ = this.bVb;
            this.bVd = "3";
        } else if (this.bUY > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fcp=" + this.bUY);
            }
            this.bUZ = this.bUY;
            this.bVd = "1";
        } else if (DEBUG) {
            throw new RuntimeException("ftp fcp fip 至少收到上述一个回调才能校准 fmp \n" + toString());
        }
    }

    @NonNull
    public String abQ() {
        String str = this.bVd;
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

    public String aN(long j) {
        if (j == this.bVa) {
            return "2";
        }
        if (j == this.bVb) {
            return "3";
        }
        if (j != this.bUY && j == this.bUZ) {
            return "0";
        }
        return "1";
    }

    public String toString() {
        return "WebViewPaintTiming{fp=" + this.bUX + ", fcp=" + this.bUY + ", fmp=" + this.bUZ + ", ftp=" + this.bVa + ", fip=" + this.bVb + ", mMinCache=" + this.bVc + ", fmpType='" + this.bVd + "', fmpTypeName='" + abQ() + "'}";
    }
}
