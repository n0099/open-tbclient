package com.baidu.rtc.b;

import android.util.Log;
/* loaded from: classes9.dex */
class c {
    double cxo = 0.0d;
    long cxq = 0;
    long cxp = 0;

    public static int jn(String str) {
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

    public static String m(double d) {
        return d > 1000000.0d ? String.format("%.2fMbps", Double.valueOf(1.0E-6d * d)) : d > 1000.0d ? String.format("%.0fKbps", Double.valueOf(0.001d * d)) : String.format("%.0fbps", Double.valueOf(d));
    }

    public String aeU() {
        return m(this.cxo);
    }

    public void bQ(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - this.cxq;
        if (j2 <= 0) {
            return;
        }
        if (this.cxq != 0 && j > this.cxp) {
            this.cxo = (((j - this.cxp) * 8) * 1000) / j2;
        }
        this.cxp = j;
        this.cxq = currentTimeMillis;
    }
}
