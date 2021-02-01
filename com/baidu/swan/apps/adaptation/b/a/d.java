package com.baidu.swan.apps.adaptation.b.a;

import android.util.Log;
import androidx.annotation.NonNull;
/* loaded from: classes9.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public long cDs;
    public long cDt;
    public volatile long cDu;
    public long cDv;
    public long cDw;
    private long cDx;
    public String cDy = "1";

    public long ajj() {
        if (this.cDx > 0) {
            return this.cDx;
        }
        long[] jArr = {this.cDv, this.cDw, this.cDt};
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
            this.cDx = j;
        }
        return this.cDx;
    }

    public final void ajk() {
        if (this.cDu > 0 && this.cDu != this.cDv && this.cDu != this.cDw && this.cDu != this.cDt) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: miss with real fmp=" + this.cDu);
            }
        } else if (this.cDv > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with ftp=" + this.cDv);
            }
            this.cDu = this.cDv;
            this.cDy = "2";
        } else if (this.cDw > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fip=" + this.cDw);
            }
            this.cDu = this.cDw;
            this.cDy = "3";
        } else if (this.cDt > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fcp=" + this.cDt);
            }
            this.cDu = this.cDt;
            this.cDy = "1";
        } else if (DEBUG) {
            throw new RuntimeException("ftp fcp fip 至少收到上述一个回调才能校准 fmp \n" + toString());
        }
    }

    @NonNull
    public String ajl() {
        String str = this.cDy;
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

    public String bZ(long j) {
        if (j == this.cDv) {
            return "2";
        }
        if (j == this.cDw) {
            return "3";
        }
        if (j != this.cDt && j == this.cDu) {
            return "0";
        }
        return "1";
    }

    public String toString() {
        return "WebViewPaintTiming{fp=" + this.cDs + ", fcp=" + this.cDt + ", fmp=" + this.cDu + ", ftp=" + this.cDv + ", fip=" + this.cDw + ", mMinCache=" + this.cDx + ", fmpType='" + this.cDy + "', fmpTypeName='" + ajl() + "'}";
    }
}
