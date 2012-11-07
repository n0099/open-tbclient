package cn.jingling.lib.filters;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
/* loaded from: classes.dex */
public class ImageProcessUtils {
    public static Bitmap mergeBitmap(Bitmap bm1, Bitmap bm2, double ratio) {
        Bitmap rst = Bitmap.createBitmap(bm1.getWidth(), bm1.getHeight(), bm1.getConfig());
        Canvas c = new Canvas(rst);
        c.drawBitmap(bm1, 0.0f, 0.0f, new Paint());
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setAlpha((int) ((1.0d - ratio) * 255.0d));
        c.drawBitmap(bm2, 0.0f, 0.0f, paint);
        return rst;
    }

    public static Bitmap mergeBitmap(Bitmap bm1, Bitmap bm2) {
        Bitmap rst = Bitmap.createBitmap(bm1.getWidth(), bm1.getHeight(), bm1.getConfig());
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Canvas c = new Canvas(rst);
        c.drawBitmap(bm1, 0.0f, 0.0f, paint);
        c.drawBitmap(bm2, 0.0f, 0.0f, paint);
        return rst;
    }

    public static void mergeBitmap(Bitmap bm, Bitmap layer, ImageSelection sel) {
        int w = bm.getWidth();
        int h = bm.getHeight();
        int[] pixels = new int[w * h];
        int[] layerPixels = new int[w * h];
        bm.getPixels(pixels, 0, w, 0, 0, w, h);
        layer.getPixels(layerPixels, 0, w, 0, 0, w, h);
        CMTProcessor.mergeSelection(pixels, layerPixels, sel.getPixels(), w, h);
        bm.setPixels(pixels, 0, w, 0, 0, w, h);
    }

    public static int[] saturationPs(int[] pixels, int w, int h, int degree) {
        Bitmap bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        bm.setPixels(pixels, 0, w, 0, 0, w, h);
        saturationPs(bm, degree);
        bm.getPixels(pixels, 0, w, 0, 0, w, h);
        return pixels;
    }

    public static void saturationPs(Bitmap bm, int degree) {
        int d = (degree + 100) / 2;
        saturation(bm, d);
    }

    public static void saturation(Bitmap bm, int degree) {
        saturation(bm, (float) (degree / 50.0d), (float) (degree / 50.0d), (float) (degree / 50.0d));
    }

    public static void saturation(Bitmap bm, float red, float green, float blue) {
        applyColorMatrix(bm, getSaturationMatrix(red, green, blue));
    }

    public static void saturationAndBrightnessPs(Bitmap bm, int sat, int bright) {
        int d = (sat + 100) / 2;
        ColorMatrix mat = getSaturationMatrix(d / 50.0f, d / 50.0f, d / 50.0f);
        float[] m = mat.getArray();
        m[4] = bright;
        m[9] = bright;
        m[14] = bright;
        applyColorMatrix(bm, mat);
    }

    public static void redFace(Bitmap bm) {
        applyColorMatrix(bm, getRedFaceMatrix());
    }

    public static int[] colorZoom(int[] pixels, int w, int h, float ratio) {
        Bitmap bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        bm.setPixels(pixels, 0, w, 0, 0, w, h);
        colorZoom(bm, ratio);
        bm.getPixels(pixels, 0, w, 0, 0, w, h);
        return pixels;
    }

    public static void colorZoom(Bitmap bm, float ratio) {
        ColorMatrix matrix = new ColorMatrix();
        matrix.reset();
        matrix.setScale(ratio, ratio, ratio, 1.0f);
        applyColorMatrix(bm, matrix);
    }

    private static void applyColorMatrix(Bitmap bm, ColorMatrix matrix) {
        Canvas canvas = new Canvas();
        canvas.setBitmap(bm);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        ColorMatrixColorFilter cFilter = new ColorMatrixColorFilter(matrix);
        paint.setColorFilter(cFilter);
        canvas.drawBitmap(bm, 0.0f, 0.0f, paint);
        canvas.save();
    }

    private static ColorMatrix getSaturationMatrix(float red, float green, float blue) {
        ColorMatrix matrix = new ColorMatrix();
        matrix.reset();
        float[] m = matrix.getArray();
        float R = 0.213f * (1.0f - red);
        float G = 0.715f * (1.0f - green);
        float B = 0.072f * (1.0f - blue);
        m[0] = R + red;
        m[1] = G;
        m[2] = B;
        m[5] = R;
        m[6] = G + green;
        m[7] = B;
        m[10] = R;
        m[11] = G;
        m[12] = B + blue;
        return matrix;
    }

    private static ColorMatrix getRedFaceMatrix() {
        ColorMatrix matrix = new ColorMatrix();
        matrix.reset();
        float[] m = matrix.getArray();
        m[2] = 0.5f;
        return matrix;
    }

    public static void hue(Bitmap bm, int degreeHue) {
        float degree = (float) (((degreeHue - 180.0d) / 180.0d) * 3.141592653589793d);
        Canvas myCanvas = new Canvas();
        Paint myPaint = new Paint();
        myPaint.setAntiAlias(true);
        ColorMatrix myColorMatrix = new ColorMatrix();
        setHueMatrix(myColorMatrix, degree);
        ColorMatrixColorFilter myColorMatrixColorFilter = new ColorMatrixColorFilter(myColorMatrix);
        myPaint.setColorFilter(myColorMatrixColorFilter);
        myCanvas.setBitmap(bm);
        myCanvas.drawBitmap(bm, 0.0f, 0.0f, myPaint);
        myCanvas.save();
    }

    private static void setHueMatrix(ColorMatrix cm, float degree) {
        float hueNum = (float) Math.max(-3.141592653589793d, Math.min(degree, 3.141592653589793d));
        float cosNum = (float) Math.cos(hueNum);
        float sinNum = (float) Math.sin(hueNum);
        float[] hueMatr = {((1.0f - 0.213f) * cosNum) + 0.213f + ((-0.213f) * sinNum), ((-0.715f) * cosNum) + 0.715f + ((-0.715f) * sinNum), ((-0.072f) * cosNum) + 0.072f + ((1.0f - 0.072f) * sinNum), 0.0f, 0.0f, ((-0.213f) * cosNum) + 0.213f + (0.143f * sinNum), ((1.0f - 0.715f) * cosNum) + 0.715f + (0.14f * sinNum), ((-0.072f) * cosNum) + 0.072f + ((-0.283f) * sinNum), 0.0f, 0.0f, ((-0.213f) * cosNum) + 0.213f + ((-(1.0f - 0.213f)) * sinNum), ((-0.715f) * cosNum) + 0.715f + (sinNum * 0.715f), ((1.0f - 0.072f) * cosNum) + 0.072f + (sinNum * 0.072f), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        cm.set(hueMatr);
    }

    public static Bitmap rotate(Bitmap bm, int angle) {
        Matrix m = new Matrix();
        m.setRotate(angle);
        return Bitmap.createBitmap(bm, 0, 0, bm.getWidth(), bm.getHeight(), m, true);
    }

    public static Bitmap flip(Bitmap bm, boolean horizontal) {
        Matrix m = new Matrix();
        if (horizontal) {
            m.setScale(-1.0f, 1.0f);
        } else {
            m.setScale(1.0f, -1.0f);
        }
        return Bitmap.createBitmap(bm, 0, 0, bm.getWidth(), bm.getHeight(), m, true);
    }

    public static Bitmap createAlphaBitmap(Bitmap bm, int alpha) {
        Paint p = new Paint();
        p.setAlpha(alpha);
        p.setDither(true);
        Bitmap b = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        c.drawBitmap(bm, 0.0f, 0.0f, p);
        bm.recycle();
        return b;
    }

    public static byte[] getGrayImage(Bitmap bm) {
        int w = bm.getWidth();
        int h = bm.getHeight();
        int[] pixels = new int[w * h];
        bm.getPixels(pixels, 0, w, 0, 0, w, h);
        byte[] out = new byte[w * h];
        CMTProcessor.transToGray(pixels, out, w, h);
        return out;
    }
}
