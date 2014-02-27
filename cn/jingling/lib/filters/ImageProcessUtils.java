package cn.jingling.lib.filters;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
/* loaded from: classes.dex */
public class ImageProcessUtils {
    public static Bitmap mergeBitmap(Bitmap bitmap, Bitmap bitmap2, double d) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, new Paint());
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setAlpha((int) ((1.0d - d) * 255.0d));
        canvas.drawBitmap(bitmap2, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    public static Bitmap mergeBitmap(Bitmap bitmap, Bitmap bitmap2) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        canvas.drawBitmap(bitmap2, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    public static void mergeBitmap(Bitmap bitmap, Bitmap bitmap2, ImageSelection imageSelection) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        bitmap2.getPixels(iArr2, 0, width, 0, 0, width, height);
        CMTProcessor.mergeSelection(iArr, iArr2, imageSelection.getPixels(), width, height);
        bitmap.setPixels(iArr, 0, width, 0, 0, width, height);
    }

    public static int[] saturationPs(int[] iArr, int i, int i2, int i3) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
        saturationPs(createBitmap, i3);
        createBitmap.getPixels(iArr, 0, i, 0, 0, i, i2);
        return iArr;
    }

    public static void saturationPs(Bitmap bitmap, int i) {
        saturation(bitmap, (i + 100) / 2);
    }

    public static void saturation(Bitmap bitmap, int i) {
        saturation(bitmap, (float) (i / 50.0d), (float) (i / 50.0d), (float) (i / 50.0d));
    }

    public static void saturation(Bitmap bitmap, float f, float f2, float f3) {
        applyColorMatrix(bitmap, getSaturationMatrix(f, f2, f3));
    }

    public static void saturationAndBrightnessPs(Bitmap bitmap, int i, int i2) {
        int i3 = (i + 100) / 2;
        ColorMatrix saturationMatrix = getSaturationMatrix(i3 / 50.0f, i3 / 50.0f, i3 / 50.0f);
        float[] array = saturationMatrix.getArray();
        array[4] = i2;
        array[9] = i2;
        array[14] = i2;
        applyColorMatrix(bitmap, saturationMatrix);
    }

    public static void redFace(Bitmap bitmap) {
        applyColorMatrix(bitmap, getRedFaceMatrix());
    }

    public static int[] colorZoom(int[] iArr, int i, int i2, float f) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
        colorZoom(createBitmap, f);
        createBitmap.getPixels(iArr, 0, i, 0, 0, i, i2);
        return iArr;
    }

    public static void colorZoom(Bitmap bitmap, float f) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.reset();
        colorMatrix.setScale(f, f, f, 1.0f);
        applyColorMatrix(bitmap, colorMatrix);
    }

    private static void applyColorMatrix(Bitmap bitmap, ColorMatrix colorMatrix) {
        Canvas canvas = new Canvas();
        canvas.setBitmap(bitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        canvas.save();
    }

    private static ColorMatrix getSaturationMatrix(float f, float f2, float f3) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.reset();
        float[] array = colorMatrix.getArray();
        float f4 = 0.213f * (1.0f - f);
        float f5 = 0.715f * (1.0f - f2);
        float f6 = 0.072f * (1.0f - f3);
        array[0] = f4 + f;
        array[1] = f5;
        array[2] = f6;
        array[5] = f4;
        array[6] = f5 + f2;
        array[7] = f6;
        array[10] = f4;
        array[11] = f5;
        array[12] = f6 + f3;
        return colorMatrix;
    }

    private static ColorMatrix getRedFaceMatrix() {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.reset();
        colorMatrix.getArray()[2] = 0.5f;
        return colorMatrix;
    }

    public static void hue(Bitmap bitmap, int i) {
        Canvas canvas = new Canvas();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        ColorMatrix colorMatrix = new ColorMatrix();
        setHueMatrix(colorMatrix, (float) (((i - 180.0d) / 180.0d) * 3.141592653589793d));
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.setBitmap(bitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        canvas.save();
    }

    private static void setHueMatrix(ColorMatrix colorMatrix, float f) {
        float max = (float) Math.max(-3.141592653589793d, Math.min(f, 3.141592653589793d));
        float cos = (float) Math.cos(max);
        float sin = (float) Math.sin(max);
        colorMatrix.set(new float[]{0.213f + (0.787f * cos) + (sin * (-0.213f)), (cos * (-0.715f)) + 0.715f + (sin * (-0.715f)), ((-0.072f) * cos) + 0.072f + (0.928f * sin), 0.0f, 0.0f, 0.213f + (cos * (-0.213f)) + (0.143f * sin), (0.28500003f * cos) + 0.715f + (0.14f * sin), ((-0.072f) * cos) + 0.072f + ((-0.283f) * sin), 0.0f, 0.0f, 0.213f + (cos * (-0.213f)) + ((-0.787f) * sin), (cos * (-0.715f)) + 0.715f + (sin * 0.715f), (sin * 0.072f) + (cos * 0.928f) + 0.072f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f});
    }

    public static Bitmap rotate(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        matrix.setRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap flip(Bitmap bitmap, boolean z) {
        Matrix matrix = new Matrix();
        if (z) {
            matrix.setScale(-1.0f, 1.0f);
        } else {
            matrix.setScale(1.0f, -1.0f);
        }
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap createAlphaBitmap(Bitmap bitmap, int i) {
        Paint paint = new Paint();
        paint.setAlpha(i);
        paint.setDither(true);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawBitmap(bitmap, 0.0f, 0.0f, paint);
        bitmap.recycle();
        return createBitmap;
    }

    public static byte[] getGrayImage(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        byte[] bArr = new byte[width * height];
        CMTProcessor.transToGray(iArr, bArr, width, height);
        return bArr;
    }
}
