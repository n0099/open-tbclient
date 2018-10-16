package com.baidu.android.pushservice.k;

import com.baidu.searchbox.ng.ai.apps.util.AiAppEncryptUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes3.dex */
public final class h {
    public static byte[] a(byte[] bArr) {
        try {
            return MessageDigest.getInstance(AiAppEncryptUtils.ENCRYPT_SHA1).digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
