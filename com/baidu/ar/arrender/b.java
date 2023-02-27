package com.baidu.ar.arrender;

import android.content.Context;
import android.graphics.PointF;
import android.opengl.Matrix;
import com.baidu.ar.DuMixInput;
import com.baidu.ar.DuMixOutput;
import com.baidu.ar.arplay.core.engine.rotate.Orientation;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelRotation;
import com.baidu.ar.arplay.core.renderer.OutputFillMode;
import com.baidu.ar.bean.MirriorType;
import com.baidu.ar.bean.RotationType;
import com.baidu.ar.bean.ScaleType;
import com.baidu.ar.bean.Size;
import com.baidu.ar.h.q;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b {

    /* renamed from: com.baidu.ar.arrender.b$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation;
        public static final /* synthetic */ int[] gG;
        public static final /* synthetic */ int[] gH;

        static {
            int[] iArr = new int[ScaleType.values().length];
            gH = iArr;
            try {
                iArr[ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                gH[ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                gH[ScaleType.FIT_XY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[Orientation.values().length];
            $SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation = iArr2;
            try {
                iArr2[Orientation.PORTRAIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation[Orientation.LANDSCAPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation[Orientation.LANDSCAPE_REVERSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[RotationType.values().length];
            gG = iArr3;
            try {
                iArr3[RotationType.ROTATE_0.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                gG[RotationType.ROTATE_90.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                gG[RotationType.ROTATE_180.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                gG[RotationType.ROTATE_270.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public static PixelRotation a(RotationType rotationType, MirriorType mirriorType) {
        PixelRotation pixelRotation = PixelRotation.NoRotation;
        int i = AnonymousClass1.gG[rotationType.ordinal()];
        if (i == 1) {
            if (mirriorType == MirriorType.NO_MIRRIOR) {
                return PixelRotation.NoRotation;
            }
            if (mirriorType != MirriorType.VERTICAL_MIRRIOR) {
                if (mirriorType != MirriorType.HORIZONTAL_MIRRIOR) {
                    return pixelRotation;
                }
                return PixelRotation.FlipHorizontal;
            }
            return PixelRotation.FlipVertical;
        } else if (i == 2) {
            if (mirriorType == MirriorType.NO_MIRRIOR) {
                return PixelRotation.RotateRight;
            }
            if (mirriorType != MirriorType.VERTICAL_MIRRIOR) {
                if (mirriorType != MirriorType.HORIZONTAL_MIRRIOR) {
                    return pixelRotation;
                }
                return PixelRotation.RotateRightFlipHorizontal;
            }
            return PixelRotation.RotateRightFlipVertical;
        } else if (i == 3) {
            if (mirriorType == MirriorType.NO_MIRRIOR) {
                return PixelRotation.Rotate180;
            }
            if (mirriorType != MirriorType.VERTICAL_MIRRIOR) {
                if (mirriorType != MirriorType.HORIZONTAL_MIRRIOR) {
                    return pixelRotation;
                }
                return PixelRotation.FlipVertical;
            }
            return PixelRotation.FlipHorizontal;
        } else if (i != 4) {
            return pixelRotation;
        } else {
            if (mirriorType == MirriorType.NO_MIRRIOR) {
                return PixelRotation.RotateLeft;
            }
            if (mirriorType != MirriorType.VERTICAL_MIRRIOR) {
                if (mirriorType != MirriorType.HORIZONTAL_MIRRIOR) {
                    return pixelRotation;
                }
                return PixelRotation.RotateRightFlipVertical;
            }
            return PixelRotation.RotateRightFlipHorizontal;
        }
    }

    public static PixelRotation a(boolean z, RotationType rotationType, MirriorType mirriorType) {
        return z ? PixelRotation.FlipVertical : a(rotationType, mirriorType);
    }

    public static OutputFillMode a(ScaleType scaleType) {
        int i = AnonymousClass1.gH[scaleType.ordinal()];
        if (i != 1) {
            if (i == 2 || i == 3) {
                return OutputFillMode.KeepRatioFill;
            }
            return null;
        }
        return OutputFillMode.KeepRatioCrop;
    }

    public static Size a(int i, int i2, int i3, int i4) {
        Size size = new Size(i, i2);
        if (i > 0 && i2 > 0 && i3 > 0 && i4 > 0) {
            float f = i;
            float f2 = i2;
            float f3 = f / f2;
            float f4 = i3 / i4;
            if (f3 < f4) {
                size.setWidth((int) (f2 * f4));
                size.setHeight(i2);
            } else if (f3 > f4) {
                size.setWidth(i);
                size.setHeight((int) (f / f4));
            }
        }
        return size;
    }

    public static HashMap a(Orientation orientation) {
        String str;
        HashMap hashMap = new HashMap();
        int i = AnonymousClass1.$SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation[orientation.ordinal()];
        if (i != 1) {
            if (i != 2) {
                str = i == 3 ? "landscape_left" : "landscape_right";
            }
            hashMap.put("orient", str);
            return hashMap;
        }
        hashMap.put("orient", "portrait");
        return hashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0016, code lost:
        r1 = com.baidu.ar.arplay.core.pixel.PixelRotation.Rotate180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0019, code lost:
        r1 = com.baidu.ar.arplay.core.pixel.PixelRotation.NoRotation;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0033, code lost:
        if (r2 != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0014, code lost:
        if (r2 != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, boolean z, PixelReadParams pixelReadParams) {
        PixelRotation pixelRotation;
        if (q.gL()) {
            if (pixelReadParams.getIsPortrait()) {
                if (!z) {
                    pixelRotation = PixelRotation.RotateRight;
                }
                pixelRotation = PixelRotation.RotateRightFlipVertical;
            }
        } else if (!q.gM()) {
            if (!q.E(context) || !pixelReadParams.getIsPortrait() || !z) {
                return;
            }
            pixelRotation = PixelRotation.RotateRightFlipVertical;
        } else if (pixelReadParams.getIsPortrait()) {
            pixelRotation = z ? PixelRotation.RotateRightFlipHorizontal : PixelRotation.RotateLeft;
        }
        pixelReadParams.setPixelRotate(pixelRotation);
    }

    public static void a(Context context, float[] fArr, boolean z) {
        Matrix.setIdentityM(fArr, 0);
        if (q.gL() || q.E(context)) {
            Matrix.rotateM(fArr, 0, 90.0f, 0.0f, 0.0f, 1.0f);
            Matrix.translateM(fArr, 0, 0.0f, -1.0f, 0.0f);
            if (z) {
                return;
            }
            Matrix.rotateM(fArr, 0, 180.0f, 0.0f, 1.0f, 0.0f);
        } else if (q.gM()) {
            Matrix.rotateM(fArr, 0, 270.0f, 0.0f, 0.0f, 1.0f);
            Matrix.translateM(fArr, 0, -1.0f, 0.0f, 0.0f);
            if (z) {
                return;
            }
            Matrix.rotateM(fArr, 0, 180.0f, 0.0f, 1.0f, 0.0f);
        } else if (z) {
            Matrix.rotateM(fArr, 0, 270.0f, 0.0f, 0.0f, 1.0f);
        } else {
            Matrix.rotateM(fArr, 0, 90.0f, 0.0f, 0.0f, 1.0f);
            Matrix.translateM(fArr, 0, 0.0f, -1.0f, 0.0f);
            Matrix.rotateM(fArr, 0, 180.0f, 0.0f, 1.0f, 0.0f);
        }
        Matrix.translateM(fArr, 0, -1.0f, 0.0f, 0.0f);
    }

    public static void a(PointF pointF, boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput, boolean z2) {
        float inputWidth;
        int inputHeight;
        float outputWidth;
        int outputHeight;
        if (pointF == null || duMixInput == null || duMixOutput == null || duMixOutput.getScaleType() == ScaleType.FIT_XY) {
            return;
        }
        if (z) {
            inputWidth = duMixInput.getInputHeight();
            inputHeight = duMixInput.getInputWidth();
        } else {
            inputWidth = duMixInput.getInputWidth();
            inputHeight = duMixInput.getInputHeight();
        }
        float f = inputWidth / inputHeight;
        if (z2) {
            outputWidth = duMixOutput.getOutputHeight();
            outputHeight = duMixOutput.getOutputWidth();
        } else {
            outputWidth = duMixOutput.getOutputWidth();
            outputHeight = duMixOutput.getOutputHeight();
        }
        float f2 = outputWidth / outputHeight;
        if (f == f2) {
            return;
        }
        float f3 = pointF.x;
        float f4 = pointF.y;
        if (f < f2) {
            if (AnonymousClass1.gH[duMixOutput.getScaleType().ordinal()] == 1) {
                float f5 = 1.0f / f2;
                f4 = ((((f4 * 2.0f) - 1.0f) * (1.0f / f)) + f5) / (f5 * 2.0f);
            }
        } else if (AnonymousClass1.gH[duMixOutput.getScaleType().ordinal()] == 1) {
            f3 = ((((f3 * 2.0f) - 1.0f) * f) + f2) / (f2 * 2.0f);
        }
        pointF.set(f3, f4);
    }

    public static Size b(int i, int i2, int i3, int i4) {
        Size size = new Size(i, i2);
        if (i > 0 && i2 > 0 && i3 > 0 && i4 > 0) {
            float f = i;
            float f2 = i2;
            float f3 = f / f2;
            float f4 = i3 / i4;
            if (f3 > f4) {
                size.setWidth((int) (f2 * f4));
                size.setHeight(i2);
            } else if (f3 < f4) {
                size.setWidth(i);
                size.setHeight((int) (f / f4));
            }
        }
        return size;
    }
}
