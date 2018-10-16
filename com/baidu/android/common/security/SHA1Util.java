package com.baidu.android.common.security;

import com.baidu.searchbox.ng.ai.apps.util.AiAppEncryptUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes.dex */
public final class SHA1Util {
    private SHA1Util() {
    }

    public static byte[] sha1(byte[] bArr) {
        try {
            return MessageDigest.getInstance(AiAppEncryptUtils.ENCRYPT_SHA1).digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
