package com.baidu.sofire.b;

import com.baidu.mobstat.Config;
import com.baidu.searchbox.ugc.model.PublishType;
import java.security.MessageDigest;
/* loaded from: classes4.dex */
public final class b {
    private static final String[] a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", PublishType.TYPE_VIDEO_SHARE, Config.APP_VERSION_CODE, "b", "c", "d", "e", "f"};

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
