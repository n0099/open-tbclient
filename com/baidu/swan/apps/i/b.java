package com.baidu.swan.apps.i;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
/* loaded from: classes10.dex */
public class b {
    public final String cqF;
    public final Map<String, String> cqG = new HashMap();
    public final long delta;
    public final long serverTime;

    public static b agP() {
        return new b(0L);
    }

    private b(long j) {
        this.delta = TimeUnit.MILLISECONDS.toSeconds(j);
        this.serverTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - j);
        this.cqF = Long.toHexString(lH(this.serverTime + "#" + this.delta));
        this.cqG.put("timestamp", Long.toString(this.serverTime));
        this.cqG.put("delta", Long.toString(this.delta));
        this.cqG.put("rasign", this.cqF);
    }

    private long lH(String str) {
        CRC32 crc32 = new CRC32();
        crc32.reset();
        crc32.update(str.getBytes());
        return crc32.getValue();
    }

    public String toString() {
        return super.toString() + " serverTime:" + this.serverTime + " delta:" + this.delta + " rasign:" + this.cqF;
    }

    public String aW(long j) {
        return Long.toHexString(lH(j + "#smartapp_formid"));
    }

    public String aX(long j) {
        return Long.toHexString(lH(j + "#payid"));
    }
}
