package com.baidu.ar.arrender;

import android.content.Context;
import android.graphics.PointF;
import android.opengl.Matrix;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.ar.arrender.b$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation;
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] gG;
        public static final /* synthetic */ int[] gH;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1752735900, "Lcom/baidu/ar/arrender/b$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1752735900, "Lcom/baidu/ar/arrender/b$1;");
                    return;
                }
            }
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
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, rotationType, mirriorType)) == null) {
            PixelRotation pixelRotation = PixelRotation.NoRotation;
            int i2 = AnonymousClass1.gG[rotationType.ordinal()];
            if (i2 == 1) {
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
            } else if (i2 == 2) {
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
            } else if (i2 == 3) {
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
            } else if (i2 != 4) {
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
        return (PixelRotation) invokeLL.objValue;
    }

    public static PixelRotation a(boolean z, RotationType rotationType, MirriorType mirriorType) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Boolean.valueOf(z), rotationType, mirriorType})) == null) ? z ? PixelRotation.FlipVertical : a(rotationType, mirriorType) : (PixelRotation) invokeCommon.objValue;
    }

    public static OutputFillMode a(ScaleType scaleType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, scaleType)) == null) {
            int i2 = AnonymousClass1.gH[scaleType.ordinal()];
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    return OutputFillMode.KeepRatioFill;
                }
                return null;
            }
            return OutputFillMode.KeepRatioCrop;
        }
        return (OutputFillMode) invokeL.objValue;
    }

    public static Size a(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65539, null, i2, i3, i4, i5)) == null) {
            Size size = new Size(i2, i3);
            if (i2 > 0 && i3 > 0 && i4 > 0 && i5 > 0) {
                float f2 = i2;
                float f3 = i3;
                float f4 = f2 / f3;
                float f5 = i4 / i5;
                if (f4 < f5) {
                    size.setWidth((int) (f3 * f5));
                    size.setHeight(i3);
                } else if (f4 > f5) {
                    size.setWidth(i2);
                    size.setHeight((int) (f2 / f5));
                }
            }
            return size;
        }
        return (Size) invokeIIII.objValue;
    }

    public static HashMap a(Orientation orientation) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, orientation)) == null) {
            HashMap hashMap = new HashMap();
            int i2 = AnonymousClass1.$SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation[orientation.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    str = i2 == 3 ? "landscape_left" : "landscape_right";
                }
                hashMap.put("orient", str);
                return hashMap;
            }
            hashMap.put("orient", "portrait");
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0018, code lost:
        if (r5 != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001a, code lost:
        r4 = com.baidu.ar.arplay.core.pixel.PixelRotation.Rotate180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001d, code lost:
        r4 = com.baidu.ar.arplay.core.pixel.PixelRotation.NoRotation;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0037, code lost:
        if (r5 != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, boolean z, PixelReadParams pixelReadParams) {
        PixelRotation pixelRotation;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{context, Boolean.valueOf(z), pixelReadParams}) == null) {
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
    }

    public static void a(Context context, float[] fArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(AdIconUtil.BAIDU_LOGO_ID, null, context, fArr, z) == null) {
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
    }

    public static void a(PointF pointF, boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput, boolean z2) {
        float inputWidth;
        int inputHeight;
        float outputWidth;
        int outputHeight;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{pointF, Boolean.valueOf(z), duMixInput, duMixOutput, Boolean.valueOf(z2)}) == null) || pointF == null || duMixInput == null || duMixOutput == null || duMixOutput.getScaleType() == ScaleType.FIT_XY) {
            return;
        }
        if (z) {
            inputWidth = duMixInput.getInputHeight();
            inputHeight = duMixInput.getInputWidth();
        } else {
            inputWidth = duMixInput.getInputWidth();
            inputHeight = duMixInput.getInputHeight();
        }
        float f2 = inputWidth / inputHeight;
        if (z2) {
            outputWidth = duMixOutput.getOutputHeight();
            outputHeight = duMixOutput.getOutputWidth();
        } else {
            outputWidth = duMixOutput.getOutputWidth();
            outputHeight = duMixOutput.getOutputHeight();
        }
        float f3 = outputWidth / outputHeight;
        if (f2 == f3) {
            return;
        }
        float f4 = pointF.x;
        float f5 = pointF.y;
        if (f2 < f3) {
            if (AnonymousClass1.gH[duMixOutput.getScaleType().ordinal()] == 1) {
                float f6 = 1.0f / f3;
                f5 = ((((f5 * 2.0f) - 1.0f) * (1.0f / f2)) + f6) / (f6 * 2.0f);
            }
        } else if (AnonymousClass1.gH[duMixOutput.getScaleType().ordinal()] == 1) {
            f4 = ((((f4 * 2.0f) - 1.0f) * f2) + f3) / (f3 * 2.0f);
        }
        pointF.set(f4, f5);
    }

    public static Size b(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65544, null, i2, i3, i4, i5)) == null) {
            Size size = new Size(i2, i3);
            if (i2 > 0 && i3 > 0 && i4 > 0 && i5 > 0) {
                float f2 = i2;
                float f3 = i3;
                float f4 = f2 / f3;
                float f5 = i4 / i5;
                if (f4 > f5) {
                    size.setWidth((int) (f3 * f5));
                    size.setHeight(i3);
                } else if (f4 < f5) {
                    size.setWidth(i2);
                    size.setHeight((int) (f2 / f5));
                }
            }
            return size;
        }
        return (Size) invokeIIII.objValue;
    }
}
