package com.baidu.swan.apps.i;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
/* loaded from: classes8.dex */
public class b {
    public final String cci;
    public final Map<String, String> ccj = new HashMap();
    public final long delta;
    public final long serverTime;

    public static b adu() {
        return new b(0L);
    }

    private b(long j) {
        this.delta = TimeUnit.MILLISECONDS.toSeconds(j);
        this.serverTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - j);
        this.cci = Long.toHexString(kB(this.serverTime + "#" + this.delta));
        this.ccj.put("timestamp", Long.toString(this.serverTime));
        this.ccj.put("delta", Long.toString(this.delta));
        this.ccj.put("rasign", this.cci);
    }

    private long kB(String str) {
        CRC32 crc32 = new CRC32();
        crc32.reset();
        crc32.update(str.getBytes());
        return crc32.getValue();
    }

    public String toString() {
        return super.toString() + " serverTime:" + this.serverTime + " delta:" + this.delta + " rasign:" + this.cci;
    }

    public String aN(long j) {
        return Long.toHexString(kB(j + "#smartapp_formid"));
    }

    public String aO(long j) {
        return Long.toHexString(kB(j + "#payid"));
    }
}
