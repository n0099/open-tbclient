package com.baidu.swan.apps.i;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
/* loaded from: classes8.dex */
public class b {
    public final String ccm;
    public final Map<String, String> ccn = new HashMap();
    public final long delta;
    public final long serverTime;

    public static b adu() {
        return new b(0L);
    }

    private b(long j) {
        this.delta = TimeUnit.MILLISECONDS.toSeconds(j);
        this.serverTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - j);
        this.ccm = Long.toHexString(kC(this.serverTime + "#" + this.delta));
        this.ccn.put("timestamp", Long.toString(this.serverTime));
        this.ccn.put("delta", Long.toString(this.delta));
        this.ccn.put("rasign", this.ccm);
    }

    private long kC(String str) {
        CRC32 crc32 = new CRC32();
        crc32.reset();
        crc32.update(str.getBytes());
        return crc32.getValue();
    }

    public String toString() {
        return super.toString() + " serverTime:" + this.serverTime + " delta:" + this.delta + " rasign:" + this.ccm;
    }

    public String aN(long j) {
        return Long.toHexString(kC(j + "#smartapp_formid"));
    }

    public String aO(long j) {
        return Long.toHexString(kC(j + "#payid"));
    }
}
