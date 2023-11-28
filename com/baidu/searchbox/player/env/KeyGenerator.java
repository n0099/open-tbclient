package com.baidu.searchbox.player.env;

import android.net.Uri;
import android.util.LruCache;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/player/env/KeyGenerator;", "Lcom/baidu/searchbox/player/env/IKeyGenerator;", "()V", "keyCache", "Landroid/util/LruCache;", "", "findKeyFromCache", "content", "generateFromString", "generateFromUrl", "url", "generateKey", "getUrlPath", "isPlayUrl", "", "md5", "value", "toHexString", "bytes", "", "toKey", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class KeyGenerator implements IKeyGenerator {
    public final LruCache<String, String> keyCache = new LruCache<>(50);

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
        if (r3 == true) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String findKeyFromCache(String str) {
        boolean z;
        if (isPlayUrl(str)) {
            String urlPath = getUrlPath(str);
            boolean z2 = true;
            if (urlPath != null) {
                if (urlPath.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
            }
            z2 = false;
            if (z2) {
                return this.keyCache.get(urlPath);
            }
        }
        return this.keyCache.get(str);
    }

    private final String generateFromString(String str) {
        String md5 = md5(str);
        this.keyCache.put(str, md5);
        return md5;
    }

    private final String generateFromUrl(String str) {
        boolean z;
        String urlPath = getUrlPath(str);
        if (urlPath != null && urlPath.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return generateFromString(str);
        }
        String md5 = md5(urlPath);
        this.keyCache.put(urlPath, md5);
        return md5;
    }

    private final String generateKey(String str) {
        if (isPlayUrl(str)) {
            return generateFromUrl(str);
        }
        return generateFromString(str);
    }

    private final String getUrlPath(String str) {
        try {
            return Uri.parse(str).getPath();
        } catch (NullPointerException unused) {
            return null;
        }
    }

    private final boolean isPlayUrl(String str) {
        if (StringsKt__StringsJVMKt.startsWith(str, "http://", true) || StringsKt__StringsJVMKt.startsWith(str, "https://", true)) {
            return true;
        }
        return false;
    }

    private final String md5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            Intrinsics.checkNotNullExpressionValue(digest, "digest.digest()");
            return toHexString(digest);
        } catch (NoSuchAlgorithmException unused) {
            return str;
        }
    }

    @Override // com.baidu.searchbox.player.env.IKeyGenerator
    public String toKey(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        String findKeyFromCache = findKeyFromCache(content);
        if (findKeyFromCache == null) {
            return generateKey(content);
        }
        return findKeyFromCache;
    }

    private final String toHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String str = Integer.toHexString(b & 255);
            Intrinsics.checkNotNullExpressionValue(str, "str");
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            String upperCase = str.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
            if (upperCase.length() == 1) {
                sb.append("0");
            }
            sb.append(upperCase);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "hexString.toString()");
        return sb2;
    }
}
