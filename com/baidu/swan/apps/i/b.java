package com.baidu.swan.apps.i;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
/* loaded from: classes25.dex */
public class b {
    public final String cKk;
    public final Map<String, String> cKl = new HashMap();
    public final long delta;
    public final long serverTime;

    public static b anJ() {
        return new b(0L);
    }

    private b(long j) {
        this.delta = TimeUnit.MILLISECONDS.toSeconds(j);
        this.serverTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - j);
        this.cKk = Long.toHexString(mQ(this.serverTime + "#" + this.delta));
        this.cKl.put("timestamp", Long.toString(this.serverTime));
        this.cKl.put("delta", Long.toString(this.delta));
        this.cKl.put("rasign", this.cKk);
    }

    private long mQ(String str) {
        CRC32 crc32 = new CRC32();
        crc32.reset();
        crc32.update(str.getBytes());
        return crc32.getValue();
    }

    public String toString() {
        return super.toString() + " serverTime:" + this.serverTime + " delta:" + this.delta + " rasign:" + this.cKk;
    }

    public String bT(long j) {
        return Long.toHexString(mQ(j + "#smartapp_formid"));
    }

    public String bU(long j) {
        return Long.toHexString(mQ(j + "#payid"));
    }
}
