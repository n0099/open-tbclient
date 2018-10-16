package com.baidu.android.bbalbs.common.security;

import com.baidu.searchbox.ng.ai.apps.util.AiAppEncryptUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes6.dex */
public final class c {
    public static byte[] a(byte[] bArr) {
        try {
            return MessageDigest.getInstance(AiAppEncryptUtils.ENCRYPT_SHA1).digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
