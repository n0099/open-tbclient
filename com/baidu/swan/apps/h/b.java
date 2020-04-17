package com.baidu.swan.apps.h;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
/* loaded from: classes11.dex */
public class b {
    public final String bHY;
    public final Map<String, String> bHZ = new HashMap();
    public final long delta;
    public final long serverTime;

    public static b SS() {
        return new b(0L);
    }

    private b(long j) {
        this.delta = TimeUnit.MILLISECONDS.toSeconds(j);
        this.serverTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - j);
        this.bHY = Long.toHexString(hJ(this.serverTime + "#" + this.delta));
        this.bHZ.put("timestamp", Long.toString(this.serverTime));
        this.bHZ.put("delta", Long.toString(this.delta));
        this.bHZ.put("rasign", this.bHY);
    }

    private long hJ(String str) {
        CRC32 crc32 = new CRC32();
        crc32.reset();
        crc32.update(str.getBytes());
        return crc32.getValue();
    }

    public String toString() {
        return super.toString() + " serverTime:" + this.serverTime + " delta:" + this.delta + " rasign:" + this.bHY;
    }

    public String aG(long j) {
        return Long.toHexString(hJ(j + "#smartapp_formid"));
    }

    public String aH(long j) {
        return Long.toHexString(hJ(j + "#payid"));
    }
}
