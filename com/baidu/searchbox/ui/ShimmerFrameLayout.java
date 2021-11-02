package com.baidu.searchbox.ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes7.dex */
public class ShimmerFrameLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final PorterDuffXfermode DST_IN_PORTER_DUFF_XFERMODE;
    public static final String TAG = "ShimmerFrameLayout";
    public transient /* synthetic */ FieldHolder $fh;
    public Paint mAlphaPaint;
    public boolean mAnimationStarted;
    public ValueAnimator mAnimator;
    public boolean mAutoStart;
    public int mDuration;
    public ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;
    public Mask mMask;
    public Bitmap mMaskBitmap;
    public int mMaskOffsetX;
    public int mMaskOffsetY;
    public Paint mMaskPaint;
    public MaskTranslation mMaskTranslation;
    public Bitmap mRenderMaskBitmap;
    public Bitmap mRenderUnmaskBitmap;
    public int mRepeatCount;
    public int mRepeatDelay;
    public int mRepeatMode;

    /* renamed from: com.baidu.searchbox.ui.ShimmerFrameLayout$3  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$ui$ShimmerFrameLayout$MaskAngle;
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$ui$ShimmerFrameLayout$MaskShape;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1222378955, "Lcom/baidu/searchbox/ui/ShimmerFrameLayout$3;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1222378955, "Lcom/baidu/searchbox/ui/ShimmerFrameLayout$3;");
                    return;
                }
            }
            int[] iArr = new int[MaskAngle.values().length];
            $SwitchMap$com$baidu$searchbox$ui$ShimmerFrameLayout$MaskAngle = iArr;
            try {
                iArr[MaskAngle.CW_0.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$ShimmerFrameLayout$MaskAngle[MaskAngle.CW_90.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$ShimmerFrameLayout$MaskAngle[MaskAngle.CW_180.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$ShimmerFrameLayout$MaskAngle[MaskAngle.CW_270.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[MaskShape.values().length];
            $SwitchMap$com$baidu$searchbox$ui$ShimmerFrameLayout$MaskShape = iArr2;
            try {
                iArr2[MaskShape.LINEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$ShimmerFrameLayout$MaskShape[MaskShape.RADIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$ShimmerFrameLayout$MaskShape[MaskShape.WHITE_LINEAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class Mask {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int BLACK = 0;
        public static final int WHITE = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public MaskAngle angle;
        public float dropoff;
        public int fixedHeight;
        public int fixedWidth;
        public float intensity;
        public float relativeHeight;
        public float relativeWidth;
        public MaskShape shape;
        public float tilt;

        public Mask() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public int[] getGradientColors() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = AnonymousClass3.$SwitchMap$com$baidu$searchbox$ui$ShimmerFrameLayout$MaskShape[this.shape.ordinal()];
                return i2 != 2 ? i2 != 3 ? new int[]{0, -16777216, -16777216, 0} : new int[]{-16777216, 0, 0, -16777216} : new int[]{-16777216, -16777216, 0};
            }
            return (int[]) invokeV.objValue;
        }

        public float[] getGradientPositions() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? AnonymousClass3.$SwitchMap$com$baidu$searchbox$ui$ShimmerFrameLayout$MaskShape[this.shape.ordinal()] != 2 ? new float[]{Math.max(((1.0f - this.intensity) - this.dropoff) / 2.0f, 0.0f), Math.max((1.0f - this.intensity) / 2.0f, 0.0f), Math.min((this.intensity + 1.0f) / 2.0f, 1.0f), Math.min(((this.intensity + 1.0f) + this.dropoff) / 2.0f, 1.0f)} : new float[]{0.0f, Math.min(this.intensity, 1.0f), Math.min(this.intensity + this.dropoff, 1.0f)} : (float[]) invokeV.objValue;
        }

        public int maskHeight(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                int i3 = this.fixedHeight;
                return i3 > 0 ? i3 : (int) (i2 * this.relativeHeight);
            }
            return invokeI.intValue;
        }

        public int maskWidth(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                int i3 = this.fixedWidth;
                return i3 > 0 ? i3 : (int) (i2 * this.relativeWidth);
            }
            return invokeI.intValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class MaskAngle {
        public static final /* synthetic */ MaskAngle[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final MaskAngle CW_0;
        public static final MaskAngle CW_180;
        public static final MaskAngle CW_270;
        public static final MaskAngle CW_90;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2011064001, "Lcom/baidu/searchbox/ui/ShimmerFrameLayout$MaskAngle;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2011064001, "Lcom/baidu/searchbox/ui/ShimmerFrameLayout$MaskAngle;");
                    return;
                }
            }
            CW_0 = new MaskAngle("CW_0", 0);
            CW_90 = new MaskAngle("CW_90", 1);
            CW_180 = new MaskAngle("CW_180", 2);
            MaskAngle maskAngle = new MaskAngle("CW_270", 3);
            CW_270 = maskAngle;
            $VALUES = new MaskAngle[]{CW_0, CW_90, CW_180, maskAngle};
        }

        public MaskAngle(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static MaskAngle valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (MaskAngle) Enum.valueOf(MaskAngle.class, str) : (MaskAngle) invokeL.objValue;
        }

        public static MaskAngle[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (MaskAngle[]) $VALUES.clone() : (MaskAngle[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class MaskShape {
        public static final /* synthetic */ MaskShape[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final MaskShape LINEAR;
        public static final MaskShape RADIAL;
        public static final MaskShape WHITE_LINEAR;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1774294605, "Lcom/baidu/searchbox/ui/ShimmerFrameLayout$MaskShape;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1774294605, "Lcom/baidu/searchbox/ui/ShimmerFrameLayout$MaskShape;");
                    return;
                }
            }
            LINEAR = new MaskShape("LINEAR", 0);
            RADIAL = new MaskShape("RADIAL", 1);
            MaskShape maskShape = new MaskShape("WHITE_LINEAR", 2);
            WHITE_LINEAR = maskShape;
            $VALUES = new MaskShape[]{LINEAR, RADIAL, maskShape};
        }

        public MaskShape(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static MaskShape valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (MaskShape) Enum.valueOf(MaskShape.class, str) : (MaskShape) invokeL.objValue;
        }

        public static MaskShape[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (MaskShape[]) $VALUES.clone() : (MaskShape[]) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class MaskTranslation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int fromX;
        public int fromY;
        public int toX;
        public int toY;

        public MaskTranslation() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void set(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i2, i3, i4, i5) == null) {
                this.fromX = i2;
                this.fromY = i3;
                this.toX = i4;
                this.toY = i5;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1556577500, "Lcom/baidu/searchbox/ui/ShimmerFrameLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1556577500, "Lcom/baidu/searchbox/ui/ShimmerFrameLayout;");
                return;
            }
        }
        DST_IN_PORTER_DUFF_XFERMODE = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShimmerFrameLayout(Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static float clamp(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? Math.min(f3, Math.max(f2, f4)) : invokeCommon.floatValue;
    }

    public static Bitmap createBitmapAndGcIfNecessary(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65547, null, i2, i3)) == null) {
            try {
                return Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError unused) {
                System.gc();
                return Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            }
        }
        return (Bitmap) invokeII.objValue;
    }

    private boolean dispatchDrawUsingBitmap(Canvas canvas) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, canvas)) == null) {
            Bitmap tryObtainRenderUnmaskBitmap = tryObtainRenderUnmaskBitmap();
            Bitmap tryObtainRenderMaskBitmap = tryObtainRenderMaskBitmap();
            if (tryObtainRenderUnmaskBitmap == null || tryObtainRenderMaskBitmap == null) {
                return false;
            }
            drawUnmasked(new Canvas(tryObtainRenderUnmaskBitmap));
            canvas.drawBitmap(tryObtainRenderUnmaskBitmap, 0.0f, 0.0f, this.mAlphaPaint);
            drawMasked(new Canvas(tryObtainRenderMaskBitmap));
            canvas.drawBitmap(tryObtainRenderMaskBitmap, 0.0f, 0.0f, (Paint) null);
            return true;
        }
        return invokeL.booleanValue;
    }

    private void drawMasked(Canvas canvas) {
        Bitmap maskBitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, this, canvas) == null) || (maskBitmap = getMaskBitmap()) == null) {
            return;
        }
        int i2 = this.mMaskOffsetX;
        canvas.clipRect(i2, this.mMaskOffsetY, maskBitmap.getWidth() + i2, this.mMaskOffsetY + maskBitmap.getHeight());
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        super.dispatchDraw(canvas);
        canvas.drawBitmap(maskBitmap, this.mMaskOffsetX, this.mMaskOffsetY, this.mMaskPaint);
    }

    private void drawUnmasked(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, canvas) == null) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            super.dispatchDraw(canvas);
        }
    }

    private ViewTreeObserver.OnGlobalLayoutListener getLayoutListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) ? new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: com.baidu.searchbox.ui.ShimmerFrameLayout.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ShimmerFrameLayout this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    boolean z = this.this$0.mAnimationStarted;
                    this.this$0.resetAll();
                    if (this.this$0.mAutoStart || z) {
                        this.this$0.startShimmerAnimation();
                    }
                }
            }
        } : (ViewTreeObserver.OnGlobalLayoutListener) invokeV.objValue;
    }

    private Bitmap getMaskBitmap() {
        InterceptResult invokeV;
        Shader radialGradient;
        int sqrt;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            Bitmap bitmap = this.mMaskBitmap;
            if (bitmap != null) {
                return bitmap;
            }
            int maskWidth = this.mMask.maskWidth(getWidth());
            int maskHeight = this.mMask.maskHeight(getHeight());
            this.mMaskBitmap = createBitmapAndGcIfNecessary(maskWidth, maskHeight);
            Canvas canvas = new Canvas(this.mMaskBitmap);
            if (AnonymousClass3.$SwitchMap$com$baidu$searchbox$ui$ShimmerFrameLayout$MaskShape[this.mMask.shape.ordinal()] != 2) {
                int i5 = AnonymousClass3.$SwitchMap$com$baidu$searchbox$ui$ShimmerFrameLayout$MaskAngle[this.mMask.angle.ordinal()];
                int i6 = 0;
                if (i5 != 2) {
                    if (i5 == 3) {
                        i6 = maskWidth;
                        i3 = 0;
                    } else if (i5 != 4) {
                        i4 = maskWidth;
                        i3 = 0;
                        i2 = 0;
                    } else {
                        i3 = maskHeight;
                    }
                    i4 = 0;
                    i2 = 0;
                } else {
                    i2 = maskHeight;
                    i3 = 0;
                    i4 = 0;
                }
                radialGradient = new LinearGradient(i6, i3, i4, i2, this.mMask.getGradientColors(), this.mMask.getGradientPositions(), Shader.TileMode.REPEAT);
            } else {
                radialGradient = new RadialGradient(maskWidth / 2, maskHeight / 2, (float) (Math.max(maskWidth, maskHeight) / Math.sqrt(2.0d)), this.mMask.getGradientColors(), this.mMask.getGradientPositions(), Shader.TileMode.REPEAT);
            }
            canvas.rotate(this.mMask.tilt, maskWidth / 2, maskHeight / 2);
            Paint paint = new Paint();
            paint.setShader(radialGradient);
            float f2 = -(((int) (Math.sqrt(2.0d) * Math.max(maskWidth, maskHeight))) / 2);
            canvas.drawRect(f2, f2, maskWidth + sqrt, maskHeight + sqrt, paint);
            return this.mMaskBitmap;
        }
        return (Bitmap) invokeV.objValue;
    }

    private Animator getShimmerAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
            ValueAnimator valueAnimator = this.mAnimator;
            if (valueAnimator != null) {
                return valueAnimator;
            }
            int width = getWidth();
            int height = getHeight();
            int i2 = AnonymousClass3.$SwitchMap$com$baidu$searchbox$ui$ShimmerFrameLayout$MaskShape[this.mMask.shape.ordinal()];
            int i3 = AnonymousClass3.$SwitchMap$com$baidu$searchbox$ui$ShimmerFrameLayout$MaskAngle[this.mMask.angle.ordinal()];
            if (i3 == 2) {
                this.mMaskTranslation.set(0, -height, 0, height);
            } else if (i3 == 3) {
                this.mMaskTranslation.set(width, 0, -width, 0);
            } else if (i3 != 4) {
                this.mMaskTranslation.set(-width, 0, width, 0);
            } else {
                this.mMaskTranslation.set(0, height, 0, -height);
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, (this.mRepeatDelay / this.mDuration) + 1.0f);
            this.mAnimator = ofFloat;
            ofFloat.setDuration(this.mDuration + this.mRepeatDelay);
            this.mAnimator.setRepeatCount(this.mRepeatCount);
            this.mAnimator.setRepeatMode(this.mRepeatMode);
            this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.baidu.searchbox.ui.ShimmerFrameLayout.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ShimmerFrameLayout this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator2) == null) {
                        float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator2.getAnimatedValue()).floatValue()));
                        ShimmerFrameLayout shimmerFrameLayout = this.this$0;
                        float f2 = 1.0f - max;
                        shimmerFrameLayout.setMaskOffsetX((int) ((shimmerFrameLayout.mMaskTranslation.fromX * f2) + (this.this$0.mMaskTranslation.toX * max)));
                        ShimmerFrameLayout shimmerFrameLayout2 = this.this$0;
                        shimmerFrameLayout2.setMaskOffsetY((int) ((shimmerFrameLayout2.mMaskTranslation.fromY * f2) + (this.this$0.mMaskTranslation.toY * max)));
                    }
                }
            });
            return this.mAnimator;
        }
        return (Animator) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            stopShimmerAnimation();
            resetMaskBitmap();
            resetRenderedView();
        }
    }

    private void resetMaskBitmap() {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65555, this) == null) || (bitmap = this.mMaskBitmap) == null) {
            return;
        }
        bitmap.recycle();
        this.mMaskBitmap = null;
    }

    private void resetRenderedView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            Bitmap bitmap = this.mRenderUnmaskBitmap;
            if (bitmap != null) {
                bitmap.recycle();
                this.mRenderUnmaskBitmap = null;
            }
            Bitmap bitmap2 = this.mRenderMaskBitmap;
            if (bitmap2 != null) {
                bitmap2.recycle();
                this.mRenderMaskBitmap = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetX(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65557, this, i2) == null) || this.mMaskOffsetX == i2) {
            return;
        }
        this.mMaskOffsetX = i2;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetY(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65558, this, i2) == null) || this.mMaskOffsetY == i2) {
            return;
        }
        this.mMaskOffsetY = i2;
        invalidate();
    }

    private Bitmap tryCreateRenderBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) {
            int width = getWidth();
            int height = getHeight();
            try {
                return createBitmapAndGcIfNecessary(width, height);
            } catch (OutOfMemoryError unused) {
                StringBuilder sb = new StringBuilder("ShimmerFrameLayout failed to create working bitmap");
                sb.append(" (width = ");
                sb.append(width);
                sb.append(", height = ");
                sb.append(height);
                sb.append(")\n\n");
                for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                    sb.append(stackTraceElement.toString());
                    sb.append(StringUtils.LF);
                }
                sb.toString();
                return null;
            }
        }
        return (Bitmap) invokeV.objValue;
    }

    private Bitmap tryObtainRenderMaskBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, this)) == null) {
            if (this.mRenderMaskBitmap == null) {
                this.mRenderMaskBitmap = tryCreateRenderBitmap();
            }
            return this.mRenderMaskBitmap;
        }
        return (Bitmap) invokeV.objValue;
    }

    private Bitmap tryObtainRenderUnmaskBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, this)) == null) {
            if (this.mRenderUnmaskBitmap == null) {
                this.mRenderUnmaskBitmap = tryCreateRenderBitmap();
            }
            return this.mRenderUnmaskBitmap;
        }
        return (Bitmap) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            if (this.mAnimationStarted && getWidth() > 0 && getHeight() > 0) {
                dispatchDrawUsingBitmap(canvas);
            } else {
                super.dispatchDraw(canvas);
            }
        }
    }

    public MaskAngle getAngle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mMask.angle : (MaskAngle) invokeV.objValue;
    }

    public float getBaseAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mAlphaPaint.getAlpha() / 255.0f : invokeV.floatValue;
    }

    public float getDropoff() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mMask.dropoff : invokeV.floatValue;
    }

    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mDuration : invokeV.intValue;
    }

    public int getFixedHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mMask.fixedHeight : invokeV.intValue;
    }

    public int getFixedWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mMask.fixedWidth : invokeV.intValue;
    }

    public float getIntensity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mMask.intensity : invokeV.floatValue;
    }

    public MaskShape getMaskShape() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mMask.shape : (MaskShape) invokeV.objValue;
    }

    public float getRelativeHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mMask.relativeHeight : invokeV.floatValue;
    }

    public float getRelativeWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mMask.relativeWidth : invokeV.floatValue;
    }

    public int getRepeatCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mRepeatCount : invokeV.intValue;
    }

    public int getRepeatDelay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mRepeatDelay : invokeV.intValue;
    }

    public int getRepeatMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mRepeatMode : invokeV.intValue;
    }

    public float getTilt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mMask.tilt : invokeV.floatValue;
    }

    public boolean isAnimationStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mAnimationStarted : invokeV.booleanValue;
    }

    public boolean isAutoStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mAutoStart : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onAttachedToWindow();
            if (this.mGlobalLayoutListener == null) {
                this.mGlobalLayoutListener = getLayoutListener();
            }
            getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            stopShimmerAnimation();
            if (this.mGlobalLayoutListener != null) {
                getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
                this.mGlobalLayoutListener = null;
            }
            super.onDetachedFromWindow();
        }
    }

    public void setAngle(MaskAngle maskAngle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, maskAngle) == null) {
            this.mMask.angle = maskAngle;
            resetAll();
        }
    }

    public void setAutoStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.mAutoStart = z;
            resetAll();
        }
    }

    public void setBaseAlpha(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048597, this, f2) == null) {
            this.mAlphaPaint.setAlpha((int) (clamp(0.0f, 1.0f, f2) * 255.0f));
            resetAll();
        }
    }

    public void setDropoff(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048598, this, f2) == null) {
            this.mMask.dropoff = f2;
            resetAll();
        }
    }

    public void setDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.mDuration = i2;
            resetAll();
        }
    }

    public void setFixedHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.mMask.fixedHeight = i2;
            resetAll();
        }
    }

    public void setFixedWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.mMask.fixedWidth = i2;
            resetAll();
        }
    }

    public void setIntensity(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048602, this, f2) == null) {
            this.mMask.intensity = f2;
            resetAll();
        }
    }

    public void setMaskShape(MaskShape maskShape) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, maskShape) == null) {
            this.mMask.shape = maskShape;
            resetAll();
        }
    }

    public void setRelativeHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.mMask.relativeHeight = i2;
            resetAll();
        }
    }

    public void setRelativeWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.mMask.relativeWidth = i2;
            resetAll();
        }
    }

    public void setRepeatCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            this.mRepeatCount = i2;
            resetAll();
        }
    }

    public void setRepeatDelay(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.mRepeatDelay = i2;
            resetAll();
        }
    }

    public void setRepeatMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.mRepeatMode = i2;
            resetAll();
        }
    }

    public void setTilt(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048609, this, f2) == null) {
            this.mMask.tilt = f2;
            resetAll();
        }
    }

    public void startShimmerAnimation() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || this.mAnimationStarted) {
            return;
        }
        Animator shimmerAnimation = getShimmerAnimation();
        shimmerAnimation.start();
        ((ValueAnimator) shimmerAnimation).setCurrentPlayTime(300L);
        this.mAnimationStarted = true;
    }

    public void stopShimmerAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            ValueAnimator valueAnimator = this.mAnimator;
            if (valueAnimator != null) {
                valueAnimator.end();
                this.mAnimator.removeAllUpdateListeners();
                this.mAnimator.cancel();
            }
            this.mAnimator = null;
            this.mAnimationStarted = false;
        }
    }

    public void useDefaults() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            setDuration(1200);
            setRepeatCount(-1);
            setRepeatDelay(0);
            setRepeatMode(1);
            Mask mask = this.mMask;
            mask.angle = MaskAngle.CW_0;
            mask.shape = MaskShape.LINEAR;
            mask.dropoff = 0.5f;
            mask.fixedWidth = 0;
            mask.fixedHeight = 0;
            mask.intensity = 0.0f;
            mask.relativeWidth = 1.0f;
            mask.relativeHeight = 1.0f;
            mask.tilt = 340.0f;
            this.mMaskTranslation = new MaskTranslation();
            setBaseAlpha(1.0f);
            resetAll();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        setWillNotDraw(false);
        this.mMask = new Mask();
        this.mAlphaPaint = new Paint();
        Paint paint = new Paint();
        this.mMaskPaint = paint;
        paint.setAntiAlias(true);
        this.mMaskPaint.setDither(true);
        this.mMaskPaint.setFilterBitmap(true);
        this.mMaskPaint.setXfermode(DST_IN_PORTER_DUFF_XFERMODE);
        useDefaults();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.android.common.loading.R.styleable.ShimmerFrameLayout, 0, 0);
            try {
                if (obtainStyledAttributes.hasValue(com.baidu.android.common.loading.R.styleable.ShimmerFrameLayout_auto_start)) {
                    setAutoStart(obtainStyledAttributes.getBoolean(com.baidu.android.common.loading.R.styleable.ShimmerFrameLayout_auto_start, false));
                }
                if (obtainStyledAttributes.hasValue(com.baidu.android.common.loading.R.styleable.ShimmerFrameLayout_base_alpha)) {
                    setBaseAlpha(obtainStyledAttributes.getFloat(com.baidu.android.common.loading.R.styleable.ShimmerFrameLayout_base_alpha, 0.0f));
                }
                if (obtainStyledAttributes.hasValue(com.baidu.android.common.loading.R.styleable.ShimmerFrameLayout_duration)) {
                    setDuration(obtainStyledAttributes.getInt(com.baidu.android.common.loading.R.styleable.ShimmerFrameLayout_duration, 0));
                }
                if (obtainStyledAttributes.hasValue(com.baidu.android.common.loading.R.styleable.ShimmerFrameLayout_repeat_count)) {
                    setRepeatCount(obtainStyledAttributes.getInt(com.baidu.android.common.loading.R.styleable.ShimmerFrameLayout_repeat_count, 0));
                }
                if (obtainStyledAttributes.hasValue(com.baidu.android.common.loading.R.styleable.ShimmerFrameLayout_repeat_delay)) {
                    setRepeatDelay(obtainStyledAttributes.getInt(com.baidu.android.common.loading.R.styleable.ShimmerFrameLayout_repeat_delay, 0));
                }
                if (obtainStyledAttributes.hasValue(com.baidu.android.common.loading.R.styleable.ShimmerFrameLayout_repeat_mode)) {
                    setRepeatMode(obtainStyledAttributes.getInt(com.baidu.android.common.loading.R.styleable.ShimmerFrameLayout_repeat_mode, 0));
                }
                if (obtainStyledAttributes.hasValue(com.baidu.android.common.loading.R.styleable.ShimmerFrameLayout_angle)) {
                    int i5 = obtainStyledAttributes.getInt(com.baidu.android.common.loading.R.styleable.ShimmerFrameLayout_angle, 0);
                    if (i5 == 90) {
                        this.mMask.angle = MaskAngle.CW_90;
                    } else if (i5 == 180) {
                        this.mMask.angle = MaskAngle.CW_180;
                    } else if (i5 != 270) {
                        this.mMask.angle = MaskAngle.CW_0;
                    } else {
                        this.mMask.angle = MaskAngle.CW_270;
                    }
                }
                if (obtainStyledAttributes.hasValue(com.baidu.android.common.loading.R.styleable.ShimmerFrameLayout_shape)) {
                    if (obtainStyledAttributes.getInt(com.baidu.android.common.loading.R.styleable.ShimmerFrameLayout_shape, 0) != 1) {
                        this.mMask.shape = MaskShape.LINEAR;
                    } else {
                        this.mMask.shape = MaskShape.RADIAL;
                    }
                }
                if (obtainStyledAttributes.hasValue(com.baidu.android.common.loading.R.styleable.ShimmerFrameLayout_dropoff)) {
                    this.mMask.dropoff = obtainStyledAttributes.getFloat(com.baidu.android.common.loading.R.styleable.ShimmerFrameLayout_dropoff, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(com.baidu.android.common.loading.R.styleable.ShimmerFrameLayout_fixed_width)) {
                    this.mMask.fixedWidth = obtainStyledAttributes.getDimensionPixelSize(com.baidu.android.common.loading.R.styleable.ShimmerFrameLayout_fixed_width, 0);
                }
                if (obtainStyledAttributes.hasValue(com.baidu.android.common.loading.R.styleable.ShimmerFrameLayout_fixed_height)) {
                    this.mMask.fixedHeight = obtainStyledAttributes.getDimensionPixelSize(com.baidu.android.common.loading.R.styleable.ShimmerFrameLayout_fixed_height, 0);
                }
                if (obtainStyledAttributes.hasValue(com.baidu.android.common.loading.R.styleable.ShimmerFrameLayout_intensity)) {
                    this.mMask.intensity = obtainStyledAttributes.getFloat(com.baidu.android.common.loading.R.styleable.ShimmerFrameLayout_intensity, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(com.baidu.android.common.loading.R.styleable.ShimmerFrameLayout_relative_width)) {
                    this.mMask.relativeWidth = obtainStyledAttributes.getFloat(com.baidu.android.common.loading.R.styleable.ShimmerFrameLayout_relative_width, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(com.baidu.android.common.loading.R.styleable.ShimmerFrameLayout_relative_height)) {
                    this.mMask.relativeHeight = obtainStyledAttributes.getFloat(com.baidu.android.common.loading.R.styleable.ShimmerFrameLayout_relative_height, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(com.baidu.android.common.loading.R.styleable.ShimmerFrameLayout_tilt)) {
                    this.mMask.tilt = obtainStyledAttributes.getFloat(com.baidu.android.common.loading.R.styleable.ShimmerFrameLayout_tilt, 0.0f);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void startShimmerAnimation(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048611, this, j) == null) || this.mAnimationStarted) {
            return;
        }
        Animator shimmerAnimation = getShimmerAnimation();
        shimmerAnimation.start();
        ((ValueAnimator) shimmerAnimation).setCurrentPlayTime(j);
        this.mAnimationStarted = true;
    }
}
