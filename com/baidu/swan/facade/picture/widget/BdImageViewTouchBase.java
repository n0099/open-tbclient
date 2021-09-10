package com.baidu.swan.facade.picture.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class BdImageViewTouchBase extends ImageView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOG_TAG = "ImageViewTouchBase";
    public static final float ZOOM_INVALID = -1.0f;
    public transient /* synthetic */ FieldHolder $fh;
    public final int DEFAULT_ANIMATION_DURATION;

    /* renamed from: e  reason: collision with root package name */
    public float f46811e;

    /* renamed from: f  reason: collision with root package name */
    public float f46812f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f46813g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f46814h;

    /* renamed from: i  reason: collision with root package name */
    public int f46815i;

    /* renamed from: j  reason: collision with root package name */
    public int f46816j;
    public PointF k;
    public boolean l;
    public boolean m;
    public Matrix mBaseMatrix;
    public RectF mBitmapRect;
    public RectF mCenterRect;
    public final Matrix mDisplayMatrix;
    public e mEasing;
    public Handler mHandler;
    public Runnable mLayoutRunnable;
    public final float[] mMatrixValues;
    public Matrix mNextMatrix;
    public DisplayType mScaleType;
    public RectF mScrollRect;
    public Matrix mSuppMatrix;
    public boolean mUserScaled;
    public f n;
    public g o;
    public boolean p;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class DisplayType {
        public static final /* synthetic */ DisplayType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final DisplayType FIT_IF_BIGGER;
        public static final DisplayType FIT_TO_SCREEN;
        public static final DisplayType NONE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1680356732, "Lcom/baidu/swan/facade/picture/widget/BdImageViewTouchBase$DisplayType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1680356732, "Lcom/baidu/swan/facade/picture/widget/BdImageViewTouchBase$DisplayType;");
                    return;
                }
            }
            NONE = new DisplayType("NONE", 0);
            FIT_TO_SCREEN = new DisplayType("FIT_TO_SCREEN", 1);
            DisplayType displayType = new DisplayType("FIT_IF_BIGGER", 2);
            FIT_IF_BIGGER = displayType;
            $VALUES = new DisplayType[]{NONE, FIT_TO_SCREEN, displayType};
        }

        public DisplayType(String str, int i2) {
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

        public static DisplayType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DisplayType) Enum.valueOf(DisplayType.class, str) : (DisplayType) invokeL.objValue;
        }

        public static DisplayType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DisplayType[]) $VALUES.clone() : (DisplayType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Drawable f46817e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Matrix f46818f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ float f46819g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ float f46820h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ BdImageViewTouchBase f46821i;

        public a(BdImageViewTouchBase bdImageViewTouchBase, Drawable drawable, Matrix matrix, float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdImageViewTouchBase, drawable, matrix, Float.valueOf(f2), Float.valueOf(f3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46821i = bdImageViewTouchBase;
            this.f46817e = drawable;
            this.f46818f = matrix;
            this.f46819g = f2;
            this.f46820h = f3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46821i.setImageDrawable(this.f46817e, this.f46818f, this.f46819g, this.f46820h);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public double f46822e;

        /* renamed from: f  reason: collision with root package name */
        public double f46823f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ double f46824g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f46825h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ double f46826i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ double f46827j;
        public final /* synthetic */ BdImageViewTouchBase k;

        public b(BdImageViewTouchBase bdImageViewTouchBase, double d2, long j2, double d3, double d4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdImageViewTouchBase, Double.valueOf(d2), Long.valueOf(j2), Double.valueOf(d3), Double.valueOf(d4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = bdImageViewTouchBase;
            this.f46824g = d2;
            this.f46825h = j2;
            this.f46826i = d3;
            this.f46827j = d4;
            this.f46822e = 0.0d;
            this.f46823f = 0.0d;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                double min = Math.min(this.f46824g, System.currentTimeMillis() - this.f46825h);
                double a2 = this.k.mEasing.a(min, 0.0d, this.f46826i, this.f46824g);
                double a3 = this.k.mEasing.a(min, 0.0d, this.f46827j, this.f46824g);
                this.k.panBy(a2 - this.f46822e, a3 - this.f46823f);
                this.f46822e = a2;
                this.f46823f = a3;
                if (min < this.f46824g) {
                    this.k.mHandler.post(this);
                    return;
                }
                BdImageViewTouchBase bdImageViewTouchBase = this.k;
                RectF center = bdImageViewTouchBase.getCenter(bdImageViewTouchBase.mSuppMatrix, true, true);
                if (center.left == 0.0f && center.top == 0.0f) {
                    return;
                }
                this.k.scrollBy(center.left, center.top);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f46828e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f46829f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ float f46830g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ float f46831h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ float f46832i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ float f46833j;
        public final /* synthetic */ BdImageViewTouchBase k;

        public c(BdImageViewTouchBase bdImageViewTouchBase, float f2, long j2, float f3, float f4, float f5, float f6) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdImageViewTouchBase, Float.valueOf(f2), Long.valueOf(j2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = bdImageViewTouchBase;
            this.f46828e = f2;
            this.f46829f = j2;
            this.f46830g = f3;
            this.f46831h = f4;
            this.f46832i = f5;
            this.f46833j = f6;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                float min = Math.min(this.f46828e, (float) (System.currentTimeMillis() - this.f46829f));
                this.k.zoomTo(this.f46831h + ((float) this.k.mEasing.b(min, 0.0d, this.f46830g, this.f46828e)), this.f46832i, this.f46833j);
                if (min < this.f46828e) {
                    this.k.mHandler.post(this);
                    return;
                }
                BdImageViewTouchBase bdImageViewTouchBase = this.k;
                bdImageViewTouchBase.onZoomAnimationCompleted(bdImageViewTouchBase.getScale());
                this.k.center(true, true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BdImageViewTouchBase f46834a;

        public d(BdImageViewTouchBase bdImageViewTouchBase) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdImageViewTouchBase};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46834a = bdImageViewTouchBase;
        }

        @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase.e
        public double a(double d2, double d3, double d4, double d5) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5)})) == null) {
                double d6 = (d2 / d5) - 1.0d;
                return (d4 * ((d6 * d6 * d6) + 1.0d)) + d3;
            }
            return invokeCommon.doubleValue;
        }

        @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase.e
        public double b(double d2, double d3, double d4, double d5) {
            InterceptResult invokeCommon;
            double d6;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5)})) == null) {
                double d7 = d2 / (d5 / 2.0d);
                if (d7 < 1.0d) {
                    d6 = (d4 / 2.0d) * d7 * d7 * d7;
                } else {
                    double d8 = d7 - 2.0d;
                    d6 = (d4 / 2.0d) * ((d8 * d8 * d8) + 2.0d);
                }
                return d6 + d3;
            }
            return invokeCommon.doubleValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface e {
        double a(double d2, double d3, double d4, double d5);

        double b(double d2, double d3, double d4, double d5);
    }

    /* loaded from: classes6.dex */
    public interface f {
        void a(Drawable drawable);
    }

    /* loaded from: classes6.dex */
    public interface g {
        void a(boolean z, int i2, int i3, int i4, int i5);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdImageViewTouchBase(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void center(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || getDrawable() == null) {
            return;
        }
        RectF center = getCenter(this.mSuppMatrix, z, z2);
        if (center.left == 0.0f && center.top == 0.0f) {
            return;
        }
        postTranslate(center.left, center.top);
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setImageBitmap(null);
        }
    }

    public float computeMaxZoom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Drawable drawable = getDrawable();
            if (drawable == null) {
                return 1.0f;
            }
            return Math.max(drawable.getIntrinsicWidth() / this.f46815i, drawable.getIntrinsicHeight() / this.f46816j) * 8.0f;
        }
        return invokeV.floatValue;
    }

    public float computeMinZoom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (getDrawable() == null) {
                return 1.0f;
            }
            return Math.min(1.0f, 1.0f / getScale(this.mBaseMatrix));
        }
        return invokeV.floatValue;
    }

    public void doSetImageDrawable(Drawable drawable, Matrix matrix, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{drawable, matrix, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            if (drawable != null) {
                super.setImageDrawable(drawable);
            } else {
                this.mBaseMatrix.reset();
                super.setImageDrawable(null);
            }
            if (f2 != -1.0f && f3 != -1.0f) {
                float min = Math.min(f2, f3);
                float max = Math.max(min, f3);
                this.f46812f = min;
                this.f46811e = max;
                this.f46814h = true;
                this.f46813g = true;
            } else {
                this.f46812f = -1.0f;
                this.f46811e = -1.0f;
                this.f46814h = false;
                this.f46813g = false;
            }
            if (matrix != null) {
                this.mNextMatrix = new Matrix(matrix);
            }
            this.m = true;
            requestLayout();
        }
    }

    public void fireOnDrawableChangeListener(Drawable drawable) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, drawable) == null) || (fVar = this.n) == null) {
            return;
        }
        fVar.a(drawable);
    }

    public void fireOnLayoutChangeListener(int i2, int i3, int i4, int i5) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048582, this, i2, i3, i4, i5) == null) || (gVar = this.o) == null) {
            return;
        }
        gVar.a(true, i2, i3, i4, i5);
    }

    public RectF getBitmapRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? getBitmapRect(this.mSuppMatrix) : (RectF) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0061, code lost:
        if (r7 < r8) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RectF getCenter(Matrix matrix, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        float f2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{matrix, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (getDrawable() == null) {
                return new RectF(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.mCenterRect.set(0.0f, 0.0f, 0.0f, 0.0f);
            RectF bitmapRect = getBitmapRect(matrix);
            float height = bitmapRect.height();
            float width = bitmapRect.width();
            if (z2) {
                int i2 = this.f46816j;
                float f5 = i2;
                if (height < f5) {
                    f2 = ((f5 - height) / 2.0f) - bitmapRect.top;
                } else {
                    float f6 = bitmapRect.top;
                    if (f6 > 0.0f) {
                        f2 = -f6;
                    } else {
                        float f7 = bitmapRect.bottom;
                        if (f7 < f5) {
                            f2 = i2 - f7;
                        }
                    }
                }
                if (z) {
                    float f8 = this.f46815i;
                    if (width < f8) {
                        f8 = (f8 - width) / 2.0f;
                        f4 = bitmapRect.left;
                    } else {
                        float f9 = bitmapRect.left;
                        if (f9 <= 0.0f) {
                            f4 = bitmapRect.right;
                        } else {
                            f3 = -f9;
                            this.mCenterRect.set(f3, f2, 0.0f, 0.0f);
                            return this.mCenterRect;
                        }
                    }
                    f3 = f8 - f4;
                    this.mCenterRect.set(f3, f2, 0.0f, 0.0f);
                    return this.mCenterRect;
                }
                f3 = 0.0f;
                this.mCenterRect.set(f3, f2, 0.0f, 0.0f);
                return this.mCenterRect;
            }
            f2 = 0.0f;
            if (z) {
            }
            f3 = 0.0f;
            this.mCenterRect.set(f3, f2, 0.0f, 0.0f);
            return this.mCenterRect;
        }
        return (RectF) invokeCommon.objValue;
    }

    public float getDefaultScale(DisplayType displayType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, displayType)) == null) {
            if (displayType == DisplayType.FIT_TO_SCREEN) {
                return 1.0f;
            }
            if (displayType == DisplayType.FIT_IF_BIGGER) {
                return Math.max(1.0f, 1.0f / getScale(this.mBaseMatrix));
            }
            return 1.0f / getScale(this.mBaseMatrix);
        }
        return invokeL.floatValue;
    }

    public Matrix getDisplayMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new Matrix(this.mSuppMatrix) : (Matrix) invokeV.objValue;
    }

    public DisplayType getDisplayType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mScaleType : (DisplayType) invokeV.objValue;
    }

    public Matrix getImageViewMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? getImageViewMatrix(this.mSuppMatrix) : (Matrix) invokeV.objValue;
    }

    public float getMaxScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.f46811e == -1.0f) {
                this.f46811e = computeMaxZoom();
            }
            return this.f46811e;
        }
        return invokeV.floatValue;
    }

    public float getMinScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.f46812f == -1.0f) {
                this.f46812f = computeMinZoom();
            }
            return this.f46812f;
        }
        return invokeV.floatValue;
    }

    public void getProperBaseMatrix(Drawable drawable, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, drawable, matrix) == null) {
            float f2 = this.f46815i;
            float f3 = this.f46816j;
            float intrinsicWidth = drawable.getIntrinsicWidth();
            float intrinsicHeight = drawable.getIntrinsicHeight();
            matrix.reset();
            float min = Math.min(f2 / intrinsicWidth, f3 / intrinsicHeight);
            matrix.postScale(min, min);
            matrix.postTranslate((f2 - (intrinsicWidth * min)) / 2.0f, (f3 - (intrinsicHeight * min)) / 2.0f);
        }
    }

    public void getProperBaseMatrix2(Drawable drawable, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, drawable, matrix) == null) {
            float f2 = this.f46815i;
            float f3 = this.f46816j;
            float intrinsicWidth = drawable.getIntrinsicWidth();
            float intrinsicHeight = drawable.getIntrinsicHeight();
            matrix.reset();
            float min = Math.min(f2 / intrinsicWidth, f3 / intrinsicHeight);
            matrix.postScale(min, min);
            matrix.postTranslate((f2 - (intrinsicWidth * min)) / 2.0f, (f3 - (intrinsicHeight * min)) / 2.0f);
        }
    }

    @Override // android.view.View
    public float getRotation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    public float getScale(Matrix matrix) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, matrix)) == null) ? getValue(matrix, 0) : invokeL.floatValue;
    }

    public float getValue(Matrix matrix, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048599, this, matrix, i2)) == null) {
            matrix.getValues(this.mMatrixValues);
            return this.mMatrixValues[i2];
        }
        return invokeLI.floatValue;
    }

    public void init(Context context, AttributeSet attributeSet, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048600, this, context, attributeSet, i2) == null) {
            setScaleType(ImageView.ScaleType.MATRIX);
        }
    }

    public void onDrawableChanged(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, drawable) == null) {
            fireOnDrawableChangeListener(drawable);
        }
    }

    public void onImageMatrixChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (z) {
                int i8 = this.f46815i;
                int i9 = this.f46816j;
                int i10 = i4 - i2;
                this.f46815i = i10;
                int i11 = i5 - i3;
                this.f46816j = i11;
                i6 = i10 - i8;
                i7 = i11 - i9;
                PointF pointF = this.k;
                pointF.x = i10 / 2.0f;
                pointF.y = i11 / 2.0f;
            } else {
                i6 = 0;
                i7 = 0;
            }
            Runnable runnable = this.mLayoutRunnable;
            if (runnable != null) {
                this.mLayoutRunnable = null;
                runnable.run();
            }
            Drawable drawable = getDrawable();
            if (drawable != null) {
                if (z || this.l || this.m) {
                    float scale = getScale(this.mBaseMatrix);
                    float scale2 = getScale();
                    float min = Math.min(1.0f, 1.0f / scale);
                    if (this.p) {
                        getProperBaseMatrix(drawable, this.mBaseMatrix);
                    }
                    float scale3 = getScale(this.mBaseMatrix);
                    if (this.m || this.l) {
                        Matrix matrix = this.mNextMatrix;
                        if (matrix != null) {
                            this.mSuppMatrix.set(matrix);
                            this.mNextMatrix = null;
                            r12 = getScale();
                        } else {
                            this.mSuppMatrix.reset();
                        }
                        setImageMatrix(getImageViewMatrix());
                        if (r12 != getScale()) {
                            zoomTo(r12);
                        }
                    } else if (z) {
                        if (!this.f46814h) {
                            this.f46812f = -1.0f;
                        }
                        if (!this.f46813g) {
                            this.f46811e = -1.0f;
                        }
                        setImageMatrix(getImageViewMatrix());
                        postTranslate(-i6, -i7);
                        if (!this.mUserScaled) {
                            r12 = getDefaultScale(this.mScaleType);
                            zoomTo(r12);
                        } else {
                            r12 = ((double) Math.abs(scale2 - min)) > 0.001d ? (scale / scale3) * scale2 : 1.0f;
                            zoomTo(r12);
                        }
                    }
                    this.mUserScaled = false;
                    if (r12 > getMaxScale() || r12 < getMinScale()) {
                        zoomTo(r12);
                    }
                    center(true, true);
                    if (this.m) {
                        onDrawableChanged(drawable);
                    }
                    if (z || this.m || this.l) {
                        onLayoutChanged(i2, i3, i4, i5);
                    }
                    if (this.l) {
                        this.l = false;
                    }
                    if (this.m) {
                        this.m = false;
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.m) {
                onDrawableChanged(null);
            }
            if (z || this.m || this.l) {
                onLayoutChanged(i2, i3, i4, i5);
            }
            this.m = false;
            this.l = false;
        }
    }

    public void onLayoutChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048604, this, i2, i3, i4, i5) == null) {
            fireOnLayoutChangeListener(i2, i3, i4, i5);
        }
    }

    public void onZoom(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048605, this, f2) == null) {
        }
    }

    public void onZoomAnimationCompleted(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048606, this, f2) == null) {
        }
    }

    public void panBy(double d2, double d3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3)}) == null) {
            RectF bitmapRect = getBitmapRect();
            this.mScrollRect.set((float) d2, (float) d3, 0.0f, 0.0f);
            updateRect(bitmapRect, this.mScrollRect);
            RectF rectF = this.mScrollRect;
            postTranslate(rectF.left, rectF.top);
            center(true, true);
        }
    }

    public void postScale(float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            this.mSuppMatrix.postScale(f2, f2, f3, f4);
            setImageMatrix(getImageViewMatrix());
        }
    }

    public void postTranslate(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            if (f2 == 0.0f && f3 == 0.0f) {
                return;
            }
            this.mSuppMatrix.postTranslate(f2, f3);
            setImageMatrix(getImageViewMatrix());
        }
    }

    public void resetDisplay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.m = true;
            requestLayout();
        }
    }

    public void resetMatrix() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.mSuppMatrix = new Matrix();
            float defaultScale = getDefaultScale(this.mScaleType);
            setImageMatrix(getImageViewMatrix());
            if (defaultScale != getScale()) {
                zoomTo(defaultScale);
            }
            postInvalidate();
        }
    }

    public void scrollBy(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            panBy(f2, f3);
        }
    }

    public void setCalcBaseMatrix(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.p = z;
        }
    }

    public void setDisplayType(DisplayType displayType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, displayType) == null) || displayType == this.mScaleType) {
            return;
        }
        this.mUserScaled = false;
        this.mScaleType = displayType;
        this.l = true;
        requestLayout();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, bitmap) == null) {
            setImageBitmap(bitmap, null, -1.0f, -1.0f);
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, drawable) == null) {
            setImageDrawable(drawable, null, -1.0f, -1.0f);
        }
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, matrix) == null) {
            Matrix imageMatrix = getImageMatrix();
            boolean z = (matrix == null && !imageMatrix.isIdentity()) || !(matrix == null || imageMatrix.equals(matrix));
            super.setImageMatrix(matrix);
            if (z) {
                onImageMatrixChanged();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            setImageDrawable(getContext().getResources().getDrawable(i2));
        }
    }

    public void setMaxScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048622, this, f2) == null) {
            this.f46811e = f2;
        }
    }

    public void setMinScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048623, this, f2) == null) {
            this.f46812f = f2;
        }
    }

    public void setOnDrawableChangedListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, fVar) == null) {
            this.n = fVar;
        }
    }

    public void setOnLayoutChangeListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, gVar) == null) {
            this.o = gVar;
        }
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048626, this, scaleType) == null) && scaleType == ImageView.ScaleType.MATRIX) {
            super.setScaleType(scaleType);
        }
    }

    public void updateRect(RectF rectF, RectF rectF2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048627, this, rectF, rectF2) == null) || rectF == null) {
            return;
        }
        if (rectF.top >= 0.0f && rectF.bottom <= this.f46816j) {
            rectF2.top = 0.0f;
        }
        if (rectF.left >= 0.0f && rectF.right <= this.f46815i) {
            rectF2.left = 0.0f;
        }
        float f2 = rectF.top;
        if (rectF2.top + f2 >= 0.0f && rectF.bottom > this.f46816j) {
            rectF2.top = (int) (0.0f - f2);
        }
        float f3 = rectF.bottom;
        int i2 = this.f46816j;
        if (rectF2.top + f3 <= i2 + 0 && rectF.top < 0.0f) {
            rectF2.top = (int) ((i2 + 0) - f3);
        }
        float f4 = rectF.left;
        if (rectF2.left + f4 >= 0.0f) {
            rectF2.left = (int) (0.0f - f4);
        }
        float f5 = rectF.right;
        int i3 = this.f46815i;
        if (rectF2.left + f5 <= i3 + 0) {
            rectF2.left = (int) ((i3 + 0) - f5);
        }
    }

    public void zoomTo(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048628, this, f2) == null) {
            if (f2 > getMaxScale()) {
                f2 = getMaxScale();
            }
            if (f2 < getMinScale()) {
                f2 = getMinScale();
            }
            PointF center = getCenter();
            zoomTo(f2, center.x, center.y);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdImageViewTouchBase(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
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

    public RectF getBitmapRect(Matrix matrix) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, matrix)) == null) {
            Drawable drawable = getDrawable();
            if (drawable == null) {
                return null;
            }
            Matrix imageViewMatrix = getImageViewMatrix(matrix);
            this.mBitmapRect.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            imageViewMatrix.mapRect(this.mBitmapRect);
            return this.mBitmapRect;
        }
        return (RectF) invokeL.objValue;
    }

    public Matrix getImageViewMatrix(Matrix matrix) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, matrix)) == null) {
            this.mDisplayMatrix.set(this.mBaseMatrix);
            this.mDisplayMatrix.postConcat(matrix);
            return this.mDisplayMatrix;
        }
        return (Matrix) invokeL.objValue;
    }

    public float getScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? getScale(this.mSuppMatrix) : invokeV.floatValue;
    }

    public void scrollBy(float f2, float f3, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Double.valueOf(d2)}) == null) {
            this.mHandler.post(new b(this, d2, System.currentTimeMillis(), f2, f3));
        }
    }

    public void setImageBitmap(Bitmap bitmap, Matrix matrix, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{bitmap, matrix, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            if (bitmap != null) {
                setImageDrawable(new BitmapDrawable(getContext().getResources(), bitmap), matrix, f2, f3);
            } else {
                setImageDrawable(null, matrix, f2, f3);
            }
        }
    }

    public void setImageDrawable(Drawable drawable, Matrix matrix, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{drawable, matrix, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            if (getWidth() <= 0) {
                this.mLayoutRunnable = new a(this, drawable, matrix, f2, f3);
            } else {
                doSetImageDrawable(drawable, matrix, f2, f3);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdImageViewTouchBase(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mEasing = new d(this);
        this.mBaseMatrix = new Matrix();
        this.mSuppMatrix = new Matrix();
        this.mHandler = new Handler();
        this.mLayoutRunnable = null;
        this.mUserScaled = false;
        this.f46811e = -1.0f;
        this.f46812f = -1.0f;
        this.mDisplayMatrix = new Matrix();
        this.mMatrixValues = new float[9];
        this.f46815i = -1;
        this.f46816j = -1;
        this.k = new PointF();
        this.mScaleType = DisplayType.NONE;
        this.DEFAULT_ANIMATION_DURATION = 200;
        this.mBitmapRect = new RectF();
        this.mCenterRect = new RectF();
        this.mScrollRect = new RectF();
        this.p = true;
        init(context, attributeSet, i2);
    }

    public void zoomTo(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            PointF center = getCenter();
            zoomTo(f2, center.x, center.y, f3);
        }
    }

    public void zoomTo(float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048630, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            if (f2 > getMaxScale()) {
                f2 = getMaxScale();
            }
            postScale(f2 / getScale(), f3, f4);
            onZoom(getScale());
            center(true, true);
        }
    }

    public void zoomTo(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048631, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            if (f2 > getMaxScale()) {
                f2 = getMaxScale();
            }
            long currentTimeMillis = System.currentTimeMillis();
            float scale = getScale();
            Matrix matrix = new Matrix(this.mSuppMatrix);
            matrix.postScale(f2, f2, f3, f4);
            RectF center = getCenter(matrix, true, true);
            this.mHandler.post(new c(this, f5, currentTimeMillis, f2 - scale, scale, f3 + (center.left * f2), f4 + (center.top * f2)));
        }
    }

    public PointF getCenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.k : (PointF) invokeV.objValue;
    }
}
