package com.baidu.swan.apps.media.image.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;
/* loaded from: classes9.dex */
public class f implements d {
    private BitmapRegionDecoder decoder;
    private final Object decoderLock = new Object();

    @Override // com.baidu.swan.apps.media.image.a.d
    public Point init(Context context, Uri uri) throws Exception {
        Resources resourcesForApplication;
        int i;
        String uri2 = uri.toString();
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
            this.decoder = BitmapRegionDecoder.newInstance(context.getResources().openRawResource(i), false);
        } else if (uri2.startsWith("file:///android_asset/")) {
            this.decoder = BitmapRegionDecoder.newInstance(context.getAssets().open(uri2.substring("file:///android_asset/".length()), 1), false);
        } else if (uri2.startsWith("file://")) {
            this.decoder = BitmapRegionDecoder.newInstance(uri2.substring("file://".length()), false);
        } else {
            InputStream inputStream = null;
            try {
                inputStream = context.getContentResolver().openInputStream(uri);
                this.decoder = BitmapRegionDecoder.newInstance(inputStream, false);
            } finally {
                com.baidu.swan.c.d.closeSafely(inputStream);
            }
        }
        return new Point(this.decoder.getWidth(), this.decoder.getHeight());
    }

    @Override // com.baidu.swan.apps.media.image.a.d
    public Point a(Context context, Bitmap bitmap) throws Exception {
        InputStream inputStream = null;
        try {
            inputStream = n(bitmap);
            this.decoder = BitmapRegionDecoder.newInstance(inputStream, false);
            com.baidu.swan.c.d.closeSafely(inputStream);
            return new Point(this.decoder.getWidth(), this.decoder.getHeight());
        } catch (Throwable th) {
            com.baidu.swan.c.d.closeSafely(inputStream);
            throw th;
        }
    }

    public InputStream n(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        if (bitmap.hasAlpha()) {
            compressFormat = Bitmap.CompressFormat.PNG;
        }
        bitmap.compress(compressFormat, 100, byteArrayOutputStream);
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    @Override // com.baidu.swan.apps.media.image.a.d
    public Bitmap decodeRegion(Rect rect, int i) {
        Bitmap decodeRegion;
        synchronized (this.decoderLock) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = i;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            decodeRegion = this.decoder.decodeRegion(rect, options);
            if (decodeRegion == null) {
                throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
            }
        }
        return decodeRegion;
    }

    @Override // com.baidu.swan.apps.media.image.a.d
    public boolean isReady() {
        return (this.decoder == null || this.decoder.isRecycled()) ? false : true;
    }

    @Override // com.baidu.swan.apps.media.image.a.d
    public void recycle() {
        this.decoder.recycle();
    }
}
