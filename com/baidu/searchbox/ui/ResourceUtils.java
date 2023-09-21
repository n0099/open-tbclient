package com.baidu.searchbox.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.DisplayMetrics;
import com.baidu.android.util.media.NinePatchChunk;
import java.io.ByteArrayInputStream;
/* loaded from: classes4.dex */
public final class ResourceUtils {
    public static final int BASE_DENSITY = 320;
    public static final boolean DEBUG = false;
    public static final int DEFAULT_BG_COLOR = 16119285;
    public static final String TAG = "ResourceUtils";

    public static Drawable getDefaultImageStub(Context context) {
        if (context != null) {
            try {
                return context.getResources().getDrawable(com.baidu.tieba.R.drawable.obfuscated_res_0x7f080e24);
            } catch (Exception unused) {
                return new ColorDrawableEx(DEFAULT_BG_COLOR);
            }
        }
        return null;
    }

    public static Drawable loadDrawableFromBytes(Context context, byte[] bArr) {
        return loadDrawableFromBytes(context, bArr, 320);
    }

    public static Drawable loadDrawableFromBytes(Context context, byte[] bArr, int i) {
        Bitmap bitmap;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            options.inDensity = i;
            options.inTargetDensity = displayMetrics.densityDpi;
            options.inScreenDensity = displayMetrics.densityDpi;
            bitmap = BitmapFactory.decodeStream(new ByteArrayInputStream(bArr), null, options);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            bitmap = null;
        }
        if (bitmap == null) {
            return null;
        }
        byte[] ninePatchChunk = bitmap.getNinePatchChunk();
        if (NinePatch.isNinePatchChunk(ninePatchChunk)) {
            NinePatchChunk deserialize = NinePatchChunk.deserialize(ninePatchChunk);
            if (deserialize == null) {
                return null;
            }
            return new NinePatchDrawable(context.getResources(), bitmap, ninePatchChunk, deserialize.mPaddings, null);
        }
        return new BitmapDrawable(context.getResources(), bitmap);
    }
}
