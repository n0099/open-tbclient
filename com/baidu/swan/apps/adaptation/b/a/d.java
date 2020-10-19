package com.baidu.swan.apps.adaptation.b.a;

import android.support.annotation.NonNull;
import android.util.Log;
/* loaded from: classes10.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public long chl;
    public long chm;
    public volatile long chn;
    public long cho;
    public long chp;
    private long chq;
    public String chr = "1";

    public long aeA() {
        if (this.chq > 0) {
            return this.chq;
        }
        long[] jArr = {this.cho, this.chp, this.chm};
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
            this.chq = j;
        }
        return this.chq;
    }

    public final void aeB() {
        if (this.chn > 0 && this.chn != this.cho && this.chn != this.chp && this.chn != this.chm) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: miss with real fmp=" + this.chn);
            }
        } else if (this.cho > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with ftp=" + this.cho);
            }
            this.chn = this.cho;
            this.chr = "2";
        } else if (this.chp > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fip=" + this.chp);
            }
            this.chn = this.chp;
            this.chr = "3";
        } else if (this.chm > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fcp=" + this.chm);
            }
            this.chn = this.chm;
            this.chr = "1";
        } else if (DEBUG) {
            throw new RuntimeException("ftp fcp fip 至少收到上述一个回调才能校准 fmp \n" + toString());
        }
    }

    @NonNull
    public String aeC() {
        String str = this.chr;
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

    public String aV(long j) {
        if (j == this.cho) {
            return "2";
        }
        if (j == this.chp) {
            return "3";
        }
        if (j != this.chm && j == this.chn) {
            return "0";
        }
        return "1";
    }

    public String toString() {
        return "WebViewPaintTiming{fp=" + this.chl + ", fcp=" + this.chm + ", fmp=" + this.chn + ", ftp=" + this.cho + ", fip=" + this.chp + ", mMinCache=" + this.chq + ", fmpType='" + this.chr + "', fmpTypeName='" + aeC() + "'}";
    }
}
