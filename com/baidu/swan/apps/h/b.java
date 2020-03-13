package com.baidu.swan.apps.h;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
/* loaded from: classes11.dex */
public class b {
    public final String bjD;
    public final Map<String, String> bjE = new HashMap();
    public final long delta;
    public final long serverTime;

    public static b Lb() {
        return new b(0L);
    }

    private b(long j) {
        this.delta = TimeUnit.MILLISECONDS.toSeconds(j);
        this.serverTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - j);
        this.bjD = Long.toHexString(gx(this.serverTime + "#" + this.delta));
        this.bjE.put("timestamp", Long.toString(this.serverTime));
        this.bjE.put("delta", Long.toString(this.delta));
        this.bjE.put("rasign", this.bjD);
    }

    private long gx(String str) {
        CRC32 crc32 = new CRC32();
        crc32.reset();
        crc32.update(str.getBytes());
        return crc32.getValue();
    }

    public String toString() {
        return super.toString() + " serverTime:" + this.serverTime + " delta:" + this.delta + " rasign:" + this.bjD;
    }

    public String ac(long j) {
        return Long.toHexString(gx(j + "#smartapp_formid"));
    }

    public String ad(long j) {
        return Long.toHexString(gx(j + "#payid"));
    }
}
