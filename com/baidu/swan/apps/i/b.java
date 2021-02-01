package com.baidu.swan.apps.i;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
/* loaded from: classes9.dex */
public class b {
    public final String cMH;
    public final Map<String, String> cMI = new HashMap();
    public final long delta;
    public final long serverTime;

    public static b alz() {
        return new b(0L);
    }

    private b(long j) {
        this.delta = TimeUnit.MILLISECONDS.toSeconds(j);
        this.serverTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - j);
        this.cMH = Long.toHexString(lQ(this.serverTime + "#" + this.delta));
        this.cMI.put("timestamp", Long.toString(this.serverTime));
        this.cMI.put("delta", Long.toString(this.delta));
        this.cMI.put("rasign", this.cMH);
    }

    private long lQ(String str) {
        CRC32 crc32 = new CRC32();
        crc32.reset();
        crc32.update(str.getBytes());
        return crc32.getValue();
    }

    public String toString() {
        return super.toString() + " serverTime:" + this.serverTime + " delta:" + this.delta + " rasign:" + this.cMH;
    }

    public String ca(long j) {
        return Long.toHexString(lQ(j + "#smartapp_formid"));
    }

    public String cb(long j) {
        return Long.toHexString(lQ(j + "#payid"));
    }
}
