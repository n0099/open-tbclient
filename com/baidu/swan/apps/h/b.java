package com.baidu.swan.apps.h;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
/* loaded from: classes7.dex */
public class b {
    public final String bWA;
    public final Map<String, String> bWB = new HashMap();
    public final long delta;
    public final long serverTime;

    public static b Xo() {
        return new b(0L);
    }

    private b(long j) {
        this.delta = TimeUnit.MILLISECONDS.toSeconds(j);
        this.serverTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - j);
        this.bWA = Long.toHexString(jb(this.serverTime + "#" + this.delta));
        this.bWB.put("timestamp", Long.toString(this.serverTime));
        this.bWB.put("delta", Long.toString(this.delta));
        this.bWB.put("rasign", this.bWA);
    }

    private long jb(String str) {
        CRC32 crc32 = new CRC32();
        crc32.reset();
        crc32.update(str.getBytes());
        return crc32.getValue();
    }

    public String toString() {
        return super.toString() + " serverTime:" + this.serverTime + " delta:" + this.delta + " rasign:" + this.bWA;
    }

    public String aM(long j) {
        return Long.toHexString(jb(j + "#smartapp_formid"));
    }

    public String aN(long j) {
        return Long.toHexString(jb(j + "#payid"));
    }
}
