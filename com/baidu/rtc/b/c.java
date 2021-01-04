package com.baidu.rtc.b;

import android.util.Log;
/* loaded from: classes10.dex */
class c {
    double cCa = 0.0d;
    long cCc = 0;
    long cCb = 0;

    public static int ky(String str) {
        int i = -1;
        if (str == null) {
            throw new IllegalArgumentException();
        }
        try {
            if (str.indexOf("Mbps") != -1) {
                i = (int) Math.round(Double.parseDouble(str.substring(0, str.indexOf("Mbps"))) * 1000000.0d);
            } else if (str.indexOf("Kbps") != -1) {
                i = (int) (Integer.parseInt(str.substring(0, str.indexOf("Kbps"))) * 1000.0d);
            } else if (str.indexOf("bps") != -1) {
                i = Integer.parseInt(str.substring(0, str.indexOf("bps")));
            } else {
                Log.e("BRTC", "illegal input num");
            }
        } catch (NumberFormatException e) {
            Log.e("RTCBitrateTracker", "bitrateToString dataFormat error: " + e);
        }
        return i;
    }

    public static String s(double d) {
        return d > 1000000.0d ? String.format("%.2fMbps", Double.valueOf(1.0E-6d * d)) : d > 1000.0d ? String.format("%.0fKbps", Double.valueOf(0.001d * d)) : String.format("%.0fbps", Double.valueOf(d));
    }

    public String aiN() {
        return s(this.cCa);
    }

    public void bQ(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - this.cCc;
        if (j2 <= 0) {
            return;
        }
        if (this.cCc != 0 && j > this.cCb) {
            this.cCa = (((j - this.cCb) * 8) * 1000) / j2;
        }
        this.cCb = j;
        this.cCc = currentTimeMillis;
    }
}
