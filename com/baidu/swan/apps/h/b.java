package com.baidu.swan.apps.h;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
/* loaded from: classes10.dex */
public class b {
    public final String bfn;
    public final Map<String, String> bfo = new HashMap();
    public final long delta;
    public final long serverTime;

    public static b IK() {
        return new b(0L);
    }

    private b(long j) {
        this.delta = TimeUnit.MILLISECONDS.toSeconds(j);
        this.serverTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - j);
        this.bfn = Long.toHexString(gh(this.serverTime + "#" + this.delta));
        this.bfo.put("timestamp", Long.toString(this.serverTime));
        this.bfo.put("delta", Long.toString(this.delta));
        this.bfo.put("rasign", this.bfn);
    }

    private long gh(String str) {
        CRC32 crc32 = new CRC32();
        crc32.reset();
        crc32.update(str.getBytes());
        return crc32.getValue();
    }

    public String toString() {
        return super.toString() + " serverTime:" + this.serverTime + " delta:" + this.delta + " rasign:" + this.bfn;
    }

    public String Y(long j) {
        return Long.toHexString(gh(j + "#smartapp_formid"));
    }

    public String Z(long j) {
        return Long.toHexString(gh(j + "#payid"));
    }
}
