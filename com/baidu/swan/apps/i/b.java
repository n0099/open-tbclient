package com.baidu.swan.apps.i;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
/* loaded from: classes8.dex */
public class b {
    public final String cOh;
    public final Map<String, String> cOi = new HashMap();
    public final long delta;
    public final long serverTime;

    public static b alC() {
        return new b(0L);
    }

    private b(long j) {
        this.delta = TimeUnit.MILLISECONDS.toSeconds(j);
        this.serverTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - j);
        this.cOh = Long.toHexString(lX(this.serverTime + "#" + this.delta));
        this.cOi.put("timestamp", Long.toString(this.serverTime));
        this.cOi.put("delta", Long.toString(this.delta));
        this.cOi.put("rasign", this.cOh);
    }

    private long lX(String str) {
        CRC32 crc32 = new CRC32();
        crc32.reset();
        crc32.update(str.getBytes());
        return crc32.getValue();
    }

    public String toString() {
        return super.toString() + " serverTime:" + this.serverTime + " delta:" + this.delta + " rasign:" + this.cOh;
    }

    public String ca(long j) {
        return Long.toHexString(lX(j + "#smartapp_formid"));
    }

    public String cb(long j) {
        return Long.toHexString(lX(j + "#payid"));
    }
}
