package com.baidu.searchbox.ng.ai.apps.network;

import com.baidu.ar.constants.HttpConstants;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
/* loaded from: classes2.dex */
public class AntiReplayToken {
    public final long delta;
    public final Map<String, String> queryMap = new HashMap();
    public final String rasign;
    public final long serverTime;

    public static AntiReplayToken create() {
        return new AntiReplayToken(AiAppsRuntime.getConfigRuntime().getServerTimeDelta());
    }

    private AntiReplayToken(long j) {
        this.delta = TimeUnit.MILLISECONDS.toSeconds(j);
        this.serverTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - j);
        this.rasign = Long.toHexString(crc32(this.serverTime + "#" + this.delta));
        this.queryMap.put(HttpConstants.TIMESTAMP, Long.toString(this.serverTime));
        this.queryMap.put("delta", Long.toString(this.delta));
        this.queryMap.put("rasign", this.rasign);
    }

    private long crc32(String str) {
        CRC32 crc32 = new CRC32();
        crc32.reset();
        crc32.update(str.getBytes());
        return crc32.getValue();
    }

    public String toString() {
        return super.toString() + " serverTime:" + this.serverTime + " delta:" + this.delta + " rasign:" + this.rasign;
    }

    public String generateFormIdRasign(long j) {
        return Long.toHexString(crc32(j + "#smartapp_formid"));
    }
}
