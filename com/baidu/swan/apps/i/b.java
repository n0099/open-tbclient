package com.baidu.swan.apps.i;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
/* loaded from: classes10.dex */
public class b {
    public final String czg;
    public final Map<String, String> czh = new HashMap();
    public final long delta;
    public final long serverTime;

    public static b aiJ() {
        return new b(0L);
    }

    private b(long j) {
        this.delta = TimeUnit.MILLISECONDS.toSeconds(j);
        this.serverTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - j);
        this.czg = Long.toHexString(ma(this.serverTime + "#" + this.delta));
        this.czh.put("timestamp", Long.toString(this.serverTime));
        this.czh.put("delta", Long.toString(this.delta));
        this.czh.put("rasign", this.czg);
    }

    private long ma(String str) {
        CRC32 crc32 = new CRC32();
        crc32.reset();
        crc32.update(str.getBytes());
        return crc32.getValue();
    }

    public String toString() {
        return super.toString() + " serverTime:" + this.serverTime + " delta:" + this.delta + " rasign:" + this.czg;
    }

    public String aY(long j) {
        return Long.toHexString(ma(j + "#smartapp_formid"));
    }

    public String aZ(long j) {
        return Long.toHexString(ma(j + "#payid"));
    }
}
