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

    public static int[] getLayerPixels(Context cx, String file, int w, int h, Type type) {
        return getLayerPixels(cx, file, w, h, type, -1);
    }

    public static int[] getLayerPixels(Context cx, String file, int w, int h, Type type, int alpha) {
        Bitmap bm = getLayerImage(cx, file, w, h, type, alpha);
        int[] pixels = new int[w * h];
        bm.getPixels(pixels, 0, w, 0, 0, w, h);
        bm.recycle();
        return pixels;
    }

    public static Bitmap getLayerImage(Context cx, String file, int w, int h, Type type) {
        try {
            InputStream is = cx.getAssets().open(file);
            return getLayerImage(is, w, h, type, -1);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Bitmap getLayerImage(Context cx, String file, int w, int h, Type type, int alpha) {
        try {
            InputStream is = cx.getAssets().open(file);
            return getLayerImage(is, w, h, type, alpha);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Bitmap getLayerImage(Context cx, String file, int w, int h, Type type, int alpha, boolean scale) {
        try {
            InputStream is = cx.getAssets().open(file);
            return getLayerImage(is, w, h, type, alpha, scale);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Bitmap getLayerImage(InputStream is, int w, int h, Type type, int alpha) {
        return getLayerImage(is, w, h, type, alpha, true);
    }

    private static Bitmap getLayerImage(InputStream is, int w, int h, Type type, int alpha, boolean scale) {
        Bitmap bm;
        Bitmap bitmap;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = true;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inScaled = false;
        Bitmap original = BitmapFactory.decodeStream(is, null, options);
        if (type == Type.CROP && (original.getWidth() * h) / w < original.getHeight()) {
            bm = Bitmap.createBitmap(original, 0, 0, original.getWidth(), (original.getWidth() * h) / w);
            original.recycle();
        } else {
            bm = original;
        }
        Matrix m = new Matrix();
        if (type == Type.ROTATE_90) {
            m.postRotate(270.0f);
            Bitmap tmpBitmap = Bitmap.createBitmap(bm, 0, 0, bm.getWidth(), bm.getHeight(), m, true);
            if (bm != tmpBitmap) {
                bm.recycle();
            }
            bm = tmpBitmap;
        }
        if (w > h && type == Type.ROTATABLE) {
            m.postRotate(90.0f);
            m.postScale(-1.0f, 1.0f);
            Bitmap tmpBitmap2 = Bitmap.createBitmap(bm, 0, 0, bm.getWidth(), bm.getHeight(), m, true);
            if (bm != tmpBitmap2) {
                bm.recycle();
            }
            bm = tmpBitmap2;
        }
        if (scale) {
            float sx = w / bm.getWidth();
            float sy = h / bm.getHeight();
            Matrix m2 = new Matrix();
            m2.reset();
            m2.preScale(sx, sy);
            bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            Canvas c = new Canvas(bitmap);
            c.drawBitmap(bm, m2, new Paint());
        } else {
            bitmap = bm;
        }
        if (bitmap != bm) {
            bm.recycle();
        }
        if (alpha != -1) {
            Paint p = new Paint();
            p.setAlpha(alpha);
            p.setDither(true);
            Bitmap b = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas c2 = new Canvas(b);
            c2.drawBitmap(bitmap, 0.0f, 0.0f, p);
            bitmap.recycle();
            return b;
        }
        return bitmap;
    }
}
