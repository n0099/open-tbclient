package com.baidu.mobads.cid.cesium.d;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes2.dex */
public final class c {
    public static byte[] a(byte[] bArr) {
        try {
            MessageDigest a2 = d.a("1-AHS");
            if (a2 == null) {
                return null;
            }
            return a2.digest(bArr);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }
}
