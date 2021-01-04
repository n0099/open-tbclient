package com.baidu.swan.apps.adaptation.b.a;

import android.util.Log;
import androidx.annotation.NonNull;
/* loaded from: classes9.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public long cFI;
    public long cFJ;
    public volatile long cFK;
    public long cFL;
    public long cFM;
    private long cFN;
    public String cFO = "1";

    public long amE() {
        if (this.cFN > 0) {
            return this.cFN;
        }
        long[] jArr = {this.cFL, this.cFM, this.cFJ};
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
            this.cFN = j;
        }
        return this.cFN;
    }

    public final void amF() {
        if (this.cFK > 0 && this.cFK != this.cFL && this.cFK != this.cFM && this.cFK != this.cFJ) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: miss with real fmp=" + this.cFK);
            }
        } else if (this.cFL > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with ftp=" + this.cFL);
            }
            this.cFK = this.cFL;
            this.cFO = "2";
        } else if (this.cFM > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fip=" + this.cFM);
            }
            this.cFK = this.cFM;
            this.cFO = "3";
        } else if (this.cFJ > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fcp=" + this.cFJ);
            }
            this.cFK = this.cFJ;
            this.cFO = "1";
        } else if (DEBUG) {
            throw new RuntimeException("ftp fcp fip 至少收到上述一个回调才能校准 fmp \n" + toString());
        }
    }

    @NonNull
    public String amG() {
        String str = this.cFO;
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
        if (j == this.cFL) {
            return "2";
        }
        if (j == this.cFM) {
            return "3";
        }
        if (j != this.cFJ && j == this.cFK) {
            return "0";
        }
        return "1";
    }

    public String toString() {
        return "WebViewPaintTiming{fp=" + this.cFI + ", fcp=" + this.cFJ + ", fmp=" + this.cFK + ", ftp=" + this.cFL + ", fip=" + this.cFM + ", mMinCache=" + this.cFN + ", fmpType='" + this.cFO + "', fmpTypeName='" + amG() + "'}";
    }
}
