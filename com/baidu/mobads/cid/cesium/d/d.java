package com.baidu.mobads.cid.cesium.d;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes2.dex */
public class d {
    public static MessageDigest a(String str) {
        try {
            return (MessageDigest) MessageDigest.class.getDeclaredMethod("getInstance", String.class).invoke(null, new StringBuilder(str).reverse().toString());
        } catch (Exception unused) {
            throw new NoSuchAlgorithmException();
        }
    }
}
