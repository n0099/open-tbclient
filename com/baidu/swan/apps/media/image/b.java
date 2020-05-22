package com.baidu.swan.apps.media.image;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
/* loaded from: classes11.dex */
public final class b {
    private final Bitmap bitmap;
    private boolean cached;
    private final Integer resource;
    private int sHeight;
    private Rect sRegion;
    private int sWidth;
    private boolean tile;
    private final Uri uri;

    private b(Bitmap bitmap, boolean z) {
        this.bitmap = bitmap;
        this.uri = null;
        this.resource = null;
        this.tile = false;
        this.sWidth = bitmap.getWidth();
        this.sHeight = bitmap.getHeight();
        this.cached = z;
    }

    private b(Uri uri) {
        String uri2 = uri.toString();
        if (uri2.startsWith("file:///") && !new File(uri2.substring("file:///".length() - 1)).exists()) {
            try {
                uri = Uri.parse(URLDecoder.decode(uri2, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
            }
        }
        this.bitmap = null;
        this.uri = uri;
        this.resource = null;
        this.tile = true;
    }

    private b(int i) {
        this.bitmap = null;
        this.uri = null;
        this.resource = Integer.valueOf(i);
        this.tile = true;
    }

    public static b fQ(int i) {
        return new b(i);
    }

    public static b lL(String str) {
        if (str == null) {
            throw new NullPointerException("Asset name must not be null");
        }
        return lM("file:///android_asset/" + str);
    }

    public static b lM(String str) {
        if (str == null) {
            throw new NullPointerException("Uri must not be null");
        }
        if (!str.contains("://")) {
            if (str.startsWith("/")) {
                str = str.substring(1);
            }
            str = "file:///" + str;
        }
        return new b(Uri.parse(str));
    }

    public static b j(Bitmap bitmap) {
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        }
        return new b(bitmap, true);
    }

    public b ajl() {
        return ek(true);
    }

    public b ajm() {
        return ek(false);
    }

    public b ek(boolean z) {
        this.tile = z;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Uri getUri() {
        return this.uri;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Integer getResource() {
        return this.resource;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean getTile() {
        return this.tile;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getSWidth() {
        return this.sWidth;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getSHeight() {
        return this.sHeight;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Rect getSRegion() {
        return this.sRegion;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean ajn() {
        return this.cached;
    }
}
