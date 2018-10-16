package com.baidu.searchbox.ng.ai.apps.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
/* loaded from: classes2.dex */
public final class AiAppImageUtils {
    private static final boolean DEBUG = false;
    public static final long DEFAULT_MAX_PIXELS = 131072;
    public static final int QUALITY = 100;
    public static final int ROTATE_0 = 0;
    public static final int ROTATE_180 = 180;
    public static final int ROTATE_270 = 270;
    public static final int ROTATE_90 = 90;
    private static final String TAG = "ImageUtils";

    public static Bitmap decodeBitmapFromString(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] decode = Base64.decode(str, 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public static String encodeBitmapAsString(Bitmap bitmap) {
        if (bitmap == null) {
            return "";
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        } catch (Exception e) {
            return "";
        }
    }

    public static Bitmap base64ToImg(String str, BitmapFactory.Options options) {
        byte[] bArr;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            bArr = Base64.decode(str, 0);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            bArr = null;
        }
        if (bArr != null) {
            try {
                return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
