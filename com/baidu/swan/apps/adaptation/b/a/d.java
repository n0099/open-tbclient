package com.baidu.swan.apps.adaptation.b.a;

import android.support.annotation.NonNull;
import android.util.Log;
/* loaded from: classes7.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public long ctY;
    public long ctZ;
    public volatile long cua;
    public long cub;
    public long cuc;
    private long cud;
    public String cue = "1";

    public long aim() {
        if (this.cud > 0) {
            return this.cud;
        }
        long[] jArr = {this.cub, this.cuc, this.ctZ};
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
            this.cud = j;
        }
        return this.cud;
    }

    public final void ain() {
        if (this.cua > 0 && this.cua != this.cub && this.cua != this.cuc && this.cua != this.ctZ) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: miss with real fmp=" + this.cua);
            }
        } else if (this.cub > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with ftp=" + this.cub);
            }
            this.cua = this.cub;
            this.cue = "2";
        } else if (this.cuc > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fip=" + this.cuc);
            }
            this.cua = this.cuc;
            this.cue = "3";
        } else if (this.ctZ > 0) {
            if (DEBUG) {
                Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fcp=" + this.ctZ);
            }
            this.cua = this.ctZ;
            this.cue = "1";
        } else if (DEBUG) {
            throw new RuntimeException("ftp fcp fip 至少收到上述一个回调才能校准 fmp \n" + toString());
        }
    }

    @NonNull
    public String aio() {
        String str = this.cue;
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
        if (j == this.cub) {
            return "2";
        }
        if (j == this.cuc) {
            return "3";
        }
        if (j != this.ctZ && j == this.cua) {
            return "0";
        }
        return "1";
    }

    public String toString() {
        return "WebViewPaintTiming{fp=" + this.ctY + ", fcp=" + this.ctZ + ", fmp=" + this.cua + ", ftp=" + this.cub + ", fip=" + this.cuc + ", mMinCache=" + this.cud + ", fmpType='" + this.cue + "', fmpTypeName='" + aio() + "'}";
    }
}
