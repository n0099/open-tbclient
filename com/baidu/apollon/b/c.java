package com.baidu.apollon.b;

import android.util.Base64;
import androidx.annotation.NonNull;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
/* loaded from: classes2.dex */
public class c {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final String f3508a;

    public c(@NonNull Certificate certificate) {
        try {
            this.f3508a = Base64.encodeToString(MessageDigest.getInstance("SHA-256").digest(certificate.getPublicKey().getEncoded()), 0).trim();
        } catch (NoSuchAlgorithmException unused) {
            throw new IllegalStateException("Should never happen");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return this.f3508a.equals(((c) obj).f3508a);
    }

    public int hashCode() {
        return this.f3508a.hashCode();
    }

    public String toString() {
        return "pin='" + this.f3508a + '\'';
    }

    public c(@NonNull String str) {
        if (Base64.decode(str, 0).length == 32) {
            this.f3508a = str.trim();
            return;
        }
        throw new IllegalArgumentException("Invalid pin: length is not 32 bytes");
    }
}
