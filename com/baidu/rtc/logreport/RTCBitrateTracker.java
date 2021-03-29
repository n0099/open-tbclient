package com.baidu.rtc.logreport;

import android.util.Log;
/* loaded from: classes2.dex */
public class RTCBitrateTracker {
    public double mBitrate = 0.0d;
    public long mPreTimeMs = 0;
    public long mPreByteCount = 0;

    public static String bitrateStringForBitrate(double d2) {
        if (d2 > 1000000.0d) {
            return String.format("%.2fMbps", Double.valueOf(d2 * 1.0E-6d));
        }
        Object[] objArr = new Object[1];
        if (d2 > 1000.0d) {
            objArr[0] = Double.valueOf(d2 * 0.001d);
            return String.format("%.0fKbps", objArr);
        }
        objArr[0] = Double.valueOf(d2);
        return String.format("%.0fbps", objArr);
    }

    public static int bitrateToString(String str) {
        if (str != null) {
            try {
                if (str.indexOf("Mbps") != -1) {
                    return (int) Math.round(Double.parseDouble(str.substring(0, str.indexOf("Mbps"))) * 1000000.0d);
                }
                if (str.indexOf("Kbps") != -1) {
                    return (int) (Integer.parseInt(str.substring(0, str.indexOf("Kbps"))) * 1000.0d);
                }
                if (str.indexOf("bps") != -1) {
                    return Integer.parseInt(str.substring(0, str.indexOf("bps")));
                }
                Log.e("BRTC", "illegal input num");
                return -1;
            } catch (NumberFormatException e2) {
                Log.e("RTCBitrateTracker", "bitrateToString dataFormat error: " + e2);
                return -1;
            }
        }
        throw new IllegalArgumentException();
    }

    public String bitRateString() {
        return bitrateStringForBitrate(this.mBitrate);
    }

    public void updataBitrateWidhCurrentByteCount(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.mPreTimeMs;
        long j3 = currentTimeMillis - j2;
        if (j3 <= 0) {
            return;
        }
        if (j2 != 0) {
            long j4 = this.mPreByteCount;
            if (j > j4) {
                this.mBitrate = (((j - j4) * 8) * 1000) / j3;
            }
        }
        this.mPreByteCount = j;
        this.mPreTimeMs = currentTimeMillis;
    }
}
