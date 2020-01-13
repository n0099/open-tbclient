package com.baidu.searchbox.picture.utils;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.util.io.FileUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.facebook.a.a;
import com.facebook.datasource.b;
import com.facebook.drawee.a.a.c;
import com.facebook.imagepipeline.d.j;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
/* loaded from: classes12.dex */
public final class Utils {
    private Utils() {
    }

    public static Uri getUri(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX) || str.startsWith("file://")) {
            return Uri.parse(str);
        }
        if (str.startsWith("/")) {
            return Uri.fromFile(new File(str));
        }
        return null;
    }

    public static boolean inFrescoCache(String str) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (c.dkj().O(Uri.parse(str))) {
            return true;
        }
        b<Boolean> P = c.dkj().P(Uri.parse(str));
        if (P != null) {
            z = P.djO() && P.getResult() != null && P.getResult().booleanValue();
            P.Mn();
        } else {
            z = false;
        }
        return z;
    }

    public static String getFrescoCachedPath(String str, Context context) {
        if (TextUtils.isEmpty(str) || !inFrescoCache(str)) {
            return "";
        }
        a d = j.dog().don().d(com.facebook.imagepipeline.c.j.dmI().c(ImageRequestBuilder.X(Uri.parse(str)).drm(), context.getApplicationContext()));
        if (d == null) {
            return "";
        }
        String absolutePath = ((com.facebook.a.b) d).getFile().getAbsolutePath();
        return !FileUtils.isExistFile(absolutePath) ? "" : absolutePath;
    }
}
