package com.baidu.mobstat;

import com.baidu.searchbox.ng.ai.apps.util.AiAppEncryptUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes3.dex */
public final class d {
    public static byte[] a(byte[] bArr) {
        try {
            return MessageDigest.getInstance(AiAppEncryptUtils.ENCRYPT_SHA1).digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
