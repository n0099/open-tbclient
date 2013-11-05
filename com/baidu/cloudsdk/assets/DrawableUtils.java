package com.baidu.cloudsdk.assets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.DisplayMetrics;
import com.baidu.cloudsdk.common.util.Validator;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes.dex */
public final class DrawableUtils {
    private DrawableUtils() {
    }

    private static Rect a(byte[] bArr) {
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.nativeOrder());
        Rect rect = new Rect();
        rect.left = order.getInt(12);
        rect.right = order.getInt(16);
        rect.top = order.getInt(20);
        rect.bottom = order.getInt(24);
        return rect;
    }

    public static int fix720px(Context context, int i) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return context.getResources().getConfiguration().orientation == 1 ? (int) (((displayMetrics.widthPixels * i) / 720.0f) + 0.5f) : (int) (((displayMetrics.heightPixels * i) / 720.0f) + 0.5f);
    }

    public static Bitmap getBitmap(Context context, String str) {
        Validator.notNull(context, "context");
        Validator.notNullOrEmpty(str, "filename");
        InputStream fileAsStream = AssetFileUtils.getFileAsStream(context, str);
        if (fileAsStream != null) {
            return BitmapFactory.decodeStream(fileAsStream);
        }
        return null;
    }

    public static Drawable getDrawable(Context context, String str) {
        Bitmap bitmap = getBitmap(context, str);
        if (bitmap == null) {
            return null;
        }
        byte[] ninePatchChunk = bitmap.getNinePatchChunk();
        return (ninePatchChunk == null || !NinePatch.isNinePatchChunk(ninePatchChunk)) ? new BitmapDrawable(context.getResources(), bitmap) : new NinePatchDrawable(context.getResources(), bitmap, ninePatchChunk, a(ninePatchChunk), null);
    }
}
