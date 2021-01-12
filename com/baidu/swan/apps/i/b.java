package com.baidu.swan.apps.i;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
/* loaded from: classes8.dex */
public class b {
    public final String cKt;
    public final Map<String, String> cKu = new HashMap();
    public final long delta;
    public final long serverTime;

    public static b alb() {
        return new b(0L);
    }

    private b(long j) {
        this.delta = TimeUnit.MILLISECONDS.toSeconds(j);
        this.serverTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - j);
        this.cKt = Long.toHexString(ly(this.serverTime + "#" + this.delta));
        this.cKu.put("timestamp", Long.toString(this.serverTime));
        this.cKu.put("delta", Long.toString(this.delta));
        this.cKu.put("rasign", this.cKt);
    }

    private long ly(String str) {
        CRC32 crc32 = new CRC32();
        crc32.reset();
        crc32.update(str.getBytes());
        return crc32.getValue();
    }

    public String toString() {
        return super.toString() + " serverTime:" + this.serverTime + " delta:" + this.delta + " rasign:" + this.cKt;
    }

    public String bU(long j) {
        return Long.toHexString(ly(j + "#smartapp_formid"));
    }

    public String bV(long j) {
        return Long.toHexString(ly(j + "#payid"));
    }
}
