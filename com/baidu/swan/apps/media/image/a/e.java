package com.baidu.swan.apps.media.image.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import java.io.InputStream;
import java.util.List;
/* loaded from: classes3.dex */
public class e implements c {
    @Override // com.baidu.swan.apps.media.image.a.c
    public Bitmap decode(Context context, Uri uri) throws Exception {
        Bitmap decodeStream;
        Resources resourcesForApplication;
        int i;
        InputStream inputStream = null;
        String uri2 = uri.toString();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        if (uri2.startsWith("android.resource://")) {
            String authority = uri.getAuthority();
            if (context.getPackageName().equals(authority)) {
                resourcesForApplication = context.getResources();
            } else {
                resourcesForApplication = context.getPackageManager().getResourcesForApplication(authority);
            }
            List<String> pathSegments = uri.getPathSegments();
            int size = pathSegments.size();
            if (size == 2 && pathSegments.get(0).equals("drawable")) {
                i = resourcesForApplication.getIdentifier(pathSegments.get(1), "drawable", authority);
            } else {
                if (size == 1 && TextUtils.isDigitsOnly(pathSegments.get(0))) {
                    try {
                        i = Integer.parseInt(pathSegments.get(0));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                i = 0;
            }
            decodeStream = BitmapFactory.decodeResource(context.getResources(), i, options);
        } else if (uri2.startsWith("file:///android_asset/")) {
            decodeStream = BitmapFactory.decodeStream(context.getAssets().open(uri2.substring("file:///android_asset/".length())), null, options);
        } else if (uri2.startsWith("file://")) {
            decodeStream = BitmapFactory.decodeFile(uri2.substring("file://".length()), options);
        } else {
            try {
                inputStream = context.getContentResolver().openInputStream(uri);
                decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            } finally {
                com.baidu.swan.c.d.closeSafely(inputStream);
            }
        }
        if (decodeStream == null) {
            throw new RuntimeException("Skia image region decoder returned null bitmap - image format may not be supported");
        }
        return decodeStream;
    }
}
