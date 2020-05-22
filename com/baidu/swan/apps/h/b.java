package com.baidu.swan.apps.h;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
/* loaded from: classes11.dex */
public class b {
    public final String bQV;
    public final Map<String, String> bQW = new HashMap();
    public final long delta;
    public final long serverTime;

    public static b VC() {
        return new b(0L);
    }

    private b(long j) {
        this.delta = TimeUnit.MILLISECONDS.toSeconds(j);
        this.serverTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - j);
        this.bQV = Long.toHexString(iJ(this.serverTime + "#" + this.delta));
        this.bQW.put("timestamp", Long.toString(this.serverTime));
        this.bQW.put("delta", Long.toString(this.delta));
        this.bQW.put("rasign", this.bQV);
    }

    private long iJ(String str) {
        CRC32 crc32 = new CRC32();
        crc32.reset();
        crc32.update(str.getBytes());
        return crc32.getValue();
    }

    public String toString() {
        return super.toString() + " serverTime:" + this.serverTime + " delta:" + this.delta + " rasign:" + this.bQV;
    }

    public String aM(long j) {
        return Long.toHexString(iJ(j + "#smartapp_formid"));
    }

    public String aN(long j) {
        return Long.toHexString(iJ(j + "#payid"));
    }
}
