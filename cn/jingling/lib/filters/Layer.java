package cn.jingling.lib.filters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class Layer {

    /* loaded from: classes.dex */
    public enum Type {
        NORMAL,
        ROTATABLE,
        CROP,
        ROTATE_90;

        /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static Type[] valuesCustom() {
            Type[] valuesCustom = values();
            int length = valuesCustom.length;
            Type[] typeArr = new Type[length];
            System.arraycopy(valuesCustom, 0, typeArr, 0, length);
            return typeArr;
        }
    }

    public static Bitmap getLayerImage(Context context, String str, int i, int i2, Type type) {
        try {
            return getLayerImage(context.getAssets().open(str), i, i2, type, -1);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Bitmap getLayerImage(Context context, String str, int i, int i2, Type type, int i3) {
        try {
            return getLayerImage(context.getAssets().open(str), i, i2, type, i3);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Bitmap getLayerImage(Context context, String str, int i, int i2, Type type, int i3, boolean z) {
        try {
            return getLayerImage(context.getAssets().open(str), i, i2, type, i3, z);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Bitmap getLayerImage(InputStream inputStream, int i, int i2, Type type, int i3) {
        return getLayerImage(inputStream, i, i2, type, i3, true);
    }

    private static Bitmap getLayerImage(InputStream inputStream, int i, int i2, Type type, int i3, boolean z) {
        Bitmap bitmap;
        Bitmap bitmap2;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = true;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inScaled = false;
        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
        if (type != Type.CROP || (decodeStream.getWidth() * i2) / i >= decodeStream.getHeight()) {
            bitmap = decodeStream;
        } else {
            bitmap = Bitmap.createBitmap(decodeStream, 0, 0, decodeStream.getWidth(), (decodeStream.getWidth() * i2) / i);
            decodeStream.recycle();
        }
        Matrix matrix = new Matrix();
        if (type == Type.ROTATE_90) {
            matrix.postRotate(270.0f);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (bitmap != createBitmap) {
                bitmap.recycle();
            }
            bitmap = createBitmap;
        }
        if (i > i2 && type == Type.ROTATABLE) {
            matrix.postRotate(90.0f);
            matrix.postScale(-1.0f, 1.0f);
            Bitmap createBitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (bitmap != createBitmap2) {
                bitmap.recycle();
            }
            bitmap = createBitmap2;
        }
        if (z) {
            float width = i / bitmap.getWidth();
            float height = i2 / bitmap.getHeight();
            Matrix matrix2 = new Matrix();
            matrix2.reset();
            matrix2.preScale(width, height);
            bitmap2 = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            new Canvas(bitmap2).drawBitmap(bitmap, matrix2, new Paint());
        } else {
            bitmap2 = bitmap;
        }
        if (bitmap2 != bitmap) {
            bitmap.recycle();
        }
        if (i3 != -1) {
            Paint paint = new Paint();
            paint.setAlpha(i3);
            paint.setDither(true);
            Bitmap createBitmap3 = Bitmap.createBitmap(bitmap2.getWidth(), bitmap2.getHeight(), Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap3).drawBitmap(bitmap2, 0.0f, 0.0f, paint);
            bitmap2.recycle();
            return createBitmap3;
        }
        return bitmap2;
    }

    public static int[] getLayerPixels(Context context, String str, int i, int i2, Type type) {
        return getLayerPixels(context, str, i, i2, type, -1);
    }

    public static int[] getLayerPixels(Context context, String str, int i, int i2, Type type, int i3) {
        Bitmap layerImage = getLayerImage(context, str, i, i2, type, i3);
        int[] iArr = new int[i * i2];
        layerImage.getPixels(iArr, 0, i, 0, 0, i, i2);
        layerImage.recycle();
        return iArr;
    }
}
