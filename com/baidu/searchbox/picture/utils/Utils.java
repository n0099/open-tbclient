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
/* loaded from: classes13.dex */
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
        if (c.dly().P(Uri.parse(str))) {
            return true;
        }
        b<Boolean> Q = c.dly().Q(Uri.parse(str));
        if (Q != null) {
            z = Q.dld() && Q.getResult() != null && Q.getResult().booleanValue();
            Q.OB();
        } else {
            z = false;
        }
        return z;
    }

    public static String getFrescoCachedPath(String str, Context context) {
        if (TextUtils.isEmpty(str) || !inFrescoCache(str)) {
            return "";
        }
        a d = j.dpu().dpB().d(com.facebook.imagepipeline.c.j.dnX().c(ImageRequestBuilder.Y(Uri.parse(str)).dsA(), context.getApplicationContext()));
        if (d == null) {
            return "";
        }
        String absolutePath = ((com.facebook.a.b) d).getFile().getAbsolutePath();
        return !FileUtils.isExistFile(absolutePath) ? "" : absolutePath;
    }
}
