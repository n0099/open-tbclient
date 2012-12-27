package cn.jingling.lib.filters;
/* loaded from: classes.dex */
public class CMTProcessor {
    static {
        System.loadLibrary("mtprocessor-jni");
    }

    public static native void alphaCompositeEffect(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void autoLevels(int[] iArr, int i, int i2);

    public static native void blueEffect(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int i, int i2);

    public static native void blur(int[] iArr, int i, int i2, int i3, int i4, int i5);

    public static native void blurBackgroundEffectByCircle(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6);

    public static native void blurBackgroundEffectByLine(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, float f);

    public static native void brightEffect(int[] iArr, int i, int i2, int i3);

    public static native void colorBurn(int[] iArr, int[] iArr2, int i, int i2);

    public static native void colorLevel(int[] iArr, int i, int i2, int i3, float f, int i4, int i5, int i6);

    public static native void contrastEffect(int[] iArr, int i, int i2, int i3);

    public static native void coverEffect(int[] iArr, int[] iArr2, int i, int i2);

    public static native void curveEffect(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int i, int i2);

    public static native void darken(int[] iArr, int[] iArr2, int i, int i2);

    public static native void dlomo(int[] iArr, int i, int i2, int i3, int i4, int i5);

    public static native void dreamy(int[] iArr, int i, int i2, int i3);

    public static native void emissionEffect(int[] iArr, int i, int i2);

    public static native void etocEffect(int[] iArr, int i, int i2);

    public static native void eyeEnlarge(int[] iArr, int i, int i2, int i3, int i4, int i5, float f);

    public static native void fastAverageBlur(int[] iArr, int i, int i2, int i3);

    public static native void fastAverageBlurWithThreshold(int[] iArr, int i, int i2, int i3, int i4);

    public static native void gaussBlur(int[] iArr, int i, int i2, int i3, float f);

    public static native void getDynamicFrame(int[] iArr, int[] iArr2, int i, int i2, int i3, int i4);

    public static native void gray(int[] iArr, int i, int i2);

    public static native void lightenEffect(int[] iArr, int[] iArr2, int i, int i2);

    public static native void linearBurn(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void linearDodgeEffect(int[] iArr, int[] iArr2, int i, int i2);

    public static native void llomo(int[] iArr, int i, int i2, int i3, int i4, int i5);

    public static native void lomo(int[] iArr, int i, int i2);

    public static native void mergeSelection(int[] iArr, int[] iArr2, int[] iArr3, int i, int i2);

    public static native void mergeWeight(int[] iArr, int[] iArr2, int i, int i2, int i3, int i4);

    public static native void multiplyEffect(int[] iArr, int[] iArr2, int i, int i2);

    public static native void overlayAlphaEffect(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void overlayEffect(int[] iArr, int[] iArr2, int i, int i2);

    public static native void popstyle(int[] iArr, int i, int i2, int i3);

    public static native void postivefilterEffect(int[] iArr, int i, int i2);

    public static native void redeyeEffect(int[] iArr, int i, int i2, int i3, int i4, int i5);

    public static native void relief(int[] iArr, int i, int i2, int i3);

    public static native void screenEffect(int[] iArr, int[] iArr2, int i, int i2);

    public static native void screenWithLimitedLayer(int[] iArr, int[] iArr2, int i, int i2, int i3, int i4);

    public static native void setVisibleArea(int[] iArr, int i, int i2, int[] iArr2, int i3);

    public static native void sharpenEffect(int[] iArr, int i, int i2, float f);

    public static native void singleColorEffect(int[] iArr, int i, int i2, float[] fArr, float f, float f2, float f3, float f4, float f5);

    public static native void sketchEffect(int[] iArr, int i, int i2);

    public static native void skinSmoothPointEffect(int[] iArr, int i, int i2, int i3, int i4, int i5);

    public static native void skinWhitePointEffect(int[] iArr, int[] iArr2, int i, int i2, int i3, int i4, int i5);

    public static native void skinWhiteTeethPointEffect(int[] iArr, int[] iArr2, int i, int i2, int i3, int i4, int i5);

    public static native void smileWholeMouth(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, float f);

    public static native void smoothEffect(int[] iArr, int i, int i2);

    public static native void softlightEffect(int[] iArr, int[] iArr2, int i, int i2);

    public static native void thinEffect(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, float f);

    public static native void thinEffectAuto(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, int i7);

    public static native void thinEffectWholeFace(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, float f);

    public static native void transToGray(int[] iArr, byte[] bArr, int i, int i2);

    public static native void unsharpEffect(int[] iArr, int[] iArr2, int i, int i2, int i3, int i4, float f);

    public static native void yuv420sp2rgb(int[] iArr, byte[] bArr, int i, int i2);

    public static native void yuv420sp2rgb2(byte[] bArr, int i, int i2, int i3, byte[] bArr2, int i4, byte[] bArr3, byte[] bArr4, byte[] bArr5);
}
