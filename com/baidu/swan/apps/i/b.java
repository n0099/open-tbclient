package com.baidu.swan.apps.i;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
/* loaded from: classes9.dex */
public class b {
    public final String cPf;
    public final Map<String, String> cPg = new HashMap();
    public final long delta;
    public final long serverTime;

    public static b aoU() {
        return new b(0L);
    }

    private b(long j) {
        this.delta = TimeUnit.MILLISECONDS.toSeconds(j);
        this.serverTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - j);
        this.cPf = Long.toHexString(mJ(this.serverTime + "#" + this.delta));
        this.cPg.put("timestamp", Long.toString(this.serverTime));
        this.cPg.put("delta", Long.toString(this.delta));
        this.cPg.put("rasign", this.cPf);
    }

    private long mJ(String str) {
        CRC32 crc32 = new CRC32();
        crc32.reset();
        crc32.update(str.getBytes());
        return crc32.getValue();
    }

    public String toString() {
        return super.toString() + " serverTime:" + this.serverTime + " delta:" + this.delta + " rasign:" + this.cPf;
    }

    public String bU(long j) {
        return Long.toHexString(mJ(j + "#smartapp_formid"));
    }

    public String bV(long j) {
        return Long.toHexString(mJ(j + "#payid"));
    }
}
