package com.baidu.sofire.b;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
import com.tencent.connect.common.Constants;
import java.security.MessageDigest;
/* loaded from: classes2.dex */
public final class b {
    private static final String[] a = {"0", "1", "2", "3", "4", "5", "6", "7", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, "9", Config.APP_VERSION_CODE, "b", "c", "d", "e", BdStatsConstant.StatsKey.FROM};

    public static byte[] a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return MessageDigest.getInstance("MD5").digest(bArr);
        } catch (Throwable th) {
            return null;
        }
    }
}
