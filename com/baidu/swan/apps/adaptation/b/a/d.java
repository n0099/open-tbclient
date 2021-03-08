package com.baidu.swan.apps.adaptation.b.a;

import android.util.Log;
import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public long cES;
    public long cET;
    public volatile long cEU;
    public long cEV;
    public long cEW;
    private long cEX;
    public String cEY = "1";

    public long ajm() {
        if (this.cEX > 0) {
            return this.cEX;
        }
        long[] jArr = {this.cEV, this.cEW, this.cET};
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
            this.cEX = j;
        }
        return this.cEX;
    }

    public final void ajn() {
        if (this.cEU > 0 && this.cEU != this.cEV && this.cEU != this.cEW && this.cEU != this.cET) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: miss with real fmp=" + this.cEU);
            }
        } else if (this.cEV > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with ftp=" + this.cEV);
            }
            this.cEU = this.cEV;
            this.cEY = "2";
        } else if (this.cEW > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fip=" + this.cEW);
            }
            this.cEU = this.cEW;
            this.cEY = "3";
        } else if (this.cET > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fcp=" + this.cET);
            }
            this.cEU = this.cET;
            this.cEY = "1";
        } else if (DEBUG) {
            throw new RuntimeException("ftp fcp fip 至少收到上述一个回调才能校准 fmp \n" + toString());
        }
    }

    @NonNull
    public String ajo() {
        String str = this.cEY;
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
        if (j == this.cEV) {
            return "2";
        }
        if (j == this.cEW) {
            return "3";
        }
        if (j != this.cET && j == this.cEU) {
            return "0";
        }
        return "1";
    }

    public String toString() {
        return "WebViewPaintTiming{fp=" + this.cES + ", fcp=" + this.cET + ", fmp=" + this.cEU + ", ftp=" + this.cEV + ", fip=" + this.cEW + ", mMinCache=" + this.cEX + ", fmpType='" + this.cEY + "', fmpTypeName='" + ajo() + "'}";
    }
}
