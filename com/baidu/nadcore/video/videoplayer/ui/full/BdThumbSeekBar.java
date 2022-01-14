package com.baidu.nadcore.video.videoplayer.ui.full;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.k0.j;
import c.a.c0.k0.l;
import c.a.c0.k0.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.widget.BdThumbSeekBarView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class BdThumbSeekBar extends View {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int B;
    public static final BdSeekBarStyle C;
    public static final int PLAYED_PAINT_COLOR = -16738561;
    public static final int UI_TRACE_COLOR = 1291845632;
    public transient /* synthetic */ FieldHolder $fh;
    public SeekBarDirect A;

    /* renamed from: e  reason: collision with root package name */
    public BdSeeBarStatus f37140e;

    /* renamed from: f  reason: collision with root package name */
    public final int f37141f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f37142g;

    /* renamed from: h  reason: collision with root package name */
    public final Paint f37143h;

    /* renamed from: i  reason: collision with root package name */
    public float f37144i;

    /* renamed from: j  reason: collision with root package name */
    public final PorterDuffXfermode f37145j;
    public final int k;
    public final int l;
    public int m;
    public boolean mIsDragable;
    public final int n;
    public Bitmap o;
    public int p;
    public Bitmap q;
    public boolean r;
    public float s;
    public float t;
    public int u;
    public final Paint v;
    public final Paint w;
    public BdSeekBarStyle x;
    public b y;
    public final RectF z;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class BdSeeBarStatus {
        public static final /* synthetic */ BdSeeBarStatus[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BdSeeBarStatus None;
        public static final BdSeeBarStatus Seek;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(949655299, "Lcom/baidu/nadcore/video/videoplayer/ui/full/BdThumbSeekBar$BdSeeBarStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(949655299, "Lcom/baidu/nadcore/video/videoplayer/ui/full/BdThumbSeekBar$BdSeeBarStatus;");
                    return;
                }
            }
            None = new BdSeeBarStatus("None", 0);
            BdSeeBarStatus bdSeeBarStatus = new BdSeeBarStatus("Seek", 1);
            Seek = bdSeeBarStatus;
            $VALUES = new BdSeeBarStatus[]{None, bdSeeBarStatus};
        }

        public BdSeeBarStatus(String str, int i2) {
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

        public static BdSeeBarStatus valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BdSeeBarStatus) Enum.valueOf(BdSeeBarStatus.class, str) : (BdSeeBarStatus) invokeL.objValue;
        }

        public static BdSeeBarStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BdSeeBarStatus[]) $VALUES.clone() : (BdSeeBarStatus[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class BdSeekBarStyle {
        public static final /* synthetic */ BdSeekBarStyle[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BdSeekBarStyle LINE;
        public static final BdSeekBarStyle ROUND_RECT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1363187105, "Lcom/baidu/nadcore/video/videoplayer/ui/full/BdThumbSeekBar$BdSeekBarStyle;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1363187105, "Lcom/baidu/nadcore/video/videoplayer/ui/full/BdThumbSeekBar$BdSeekBarStyle;");
                    return;
                }
            }
            LINE = new BdSeekBarStyle("LINE", 0);
            BdSeekBarStyle bdSeekBarStyle = new BdSeekBarStyle("ROUND_RECT", 1);
            ROUND_RECT = bdSeekBarStyle;
            $VALUES = new BdSeekBarStyle[]{LINE, bdSeekBarStyle};
        }

        public BdSeekBarStyle(String str, int i2) {
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

        public static BdSeekBarStyle valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BdSeekBarStyle) Enum.valueOf(BdSeekBarStyle.class, str) : (BdSeekBarStyle) invokeL.objValue;
        }

        public static BdSeekBarStyle[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BdSeekBarStyle[]) $VALUES.clone() : (BdSeekBarStyle[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class SeekBarDirect {
        public static final /* synthetic */ SeekBarDirect[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SeekBarDirect Horizontal;
        public static final SeekBarDirect Vertical;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(271514235, "Lcom/baidu/nadcore/video/videoplayer/ui/full/BdThumbSeekBar$SeekBarDirect;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(271514235, "Lcom/baidu/nadcore/video/videoplayer/ui/full/BdThumbSeekBar$SeekBarDirect;");
                    return;
                }
            }
            Vertical = new SeekBarDirect("Vertical", 0);
            SeekBarDirect seekBarDirect = new SeekBarDirect("Horizontal", 1);
            Horizontal = seekBarDirect;
            $VALUES = new SeekBarDirect[]{Vertical, seekBarDirect};
        }

        public SeekBarDirect(String str, int i2) {
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

        public static SeekBarDirect valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SeekBarDirect) Enum.valueOf(SeekBarDirect.class, str) : (SeekBarDirect) invokeL.objValue;
        }

        public static SeekBarDirect[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SeekBarDirect[]) $VALUES.clone() : (SeekBarDirect[]) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1921788382, "Lcom/baidu/nadcore/video/videoplayer/ui/full/BdThumbSeekBar$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1921788382, "Lcom/baidu/nadcore/video/videoplayer/ui/full/BdThumbSeekBar$a;");
                    return;
                }
            }
            int[] iArr = new int[BdSeekBarStyle.values().length];
            a = iArr;
            try {
                iArr[BdSeekBarStyle.LINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BdSeekBarStyle.ROUND_RECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
        void onProgressChanged(BdThumbSeekBar bdThumbSeekBar, int i2, boolean z);

        void onStartTrackingTouch(BdThumbSeekBar bdThumbSeekBar);

        void onStopTrackingTouch(BdThumbSeekBar bdThumbSeekBar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-368949509, "Lcom/baidu/nadcore/video/videoplayer/ui/full/BdThumbSeekBar;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-368949509, "Lcom/baidu/nadcore/video/videoplayer/ui/full/BdThumbSeekBar;");
                return;
            }
        }
        B = c.a.c0.h0.a.d.b.d(0.0f);
        C = BdSeekBarStyle.LINE;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdThumbSeekBar(Context context, int i2) {
        this(context, C, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (BdSeekBarStyle) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void a(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            float f4 = this.s;
            if (f2 > f4) {
                f2 = f4;
            }
            if (this.A == SeekBarDirect.Horizontal) {
                float f5 = this.s;
                if (f5 > 0.1f) {
                    f2 = (f2 * f3) / f5;
                }
                RectF rectF = this.z;
                rectF.right = rectF.left + f2;
                return;
            }
            float f6 = this.s;
            if (f6 > 0.1f) {
                f2 = (f2 * f3) / f6;
            }
            RectF rectF2 = this.z;
            rectF2.top = rectF2.bottom - f2;
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.A == SeekBarDirect.Horizontal) {
                this.z.left = getPaddingLeft();
                this.z.right = getMeasuredWidth() - getPaddingRight();
                this.z.top = (((getMeasuredHeight() - this.m) + getPaddingTop()) - getPaddingBottom()) >> 1;
                RectF rectF = this.z;
                rectF.bottom = rectF.top + this.m;
                return;
            }
            this.z.top = getPaddingTop();
            this.z.bottom = getMeasuredHeight() - getPaddingBottom();
            this.z.left = (((getMeasuredWidth() - this.m) + getPaddingLeft()) - getPaddingRight()) >> 1;
            RectF rectF2 = this.z;
            rectF2.right = rectF2.left + this.m;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(Canvas canvas, float f2, float f3) {
        float width;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{canvas, Float.valueOf(f2), Float.valueOf(f3)}) != null) || !this.r) {
            return;
        }
        if (this.A == SeekBarDirect.Horizontal) {
            int width2 = (int) (this.z.right - (this.o.getWidth() >> 1));
            int i2 = this.p;
            if (width2 >= (-i2) + f2) {
                float f4 = f3 + f2;
                if ((this.o.getWidth() + width2) - this.p > f4) {
                    width = f4 - this.o.getWidth();
                    f2 = this.p;
                }
                if (this.f37140e != BdSeeBarStatus.Seek) {
                    canvas.drawBitmap(this.q, width2, ((((getMeasuredHeight() - this.q.getHeight()) + getPaddingTop()) - getPaddingBottom()) >> 1) + ((int) (this.f37141f * 1.5f)), (Paint) null);
                    return;
                } else {
                    canvas.drawBitmap(this.o, Math.max(width2, -this.p), ((((getMeasuredHeight() - this.o.getHeight()) + getPaddingTop()) - getPaddingBottom()) >> 1) + this.f37141f, (Paint) null);
                    return;
                }
            }
            width = -i2;
            width2 = (int) (width + f2);
            if (this.f37140e != BdSeeBarStatus.Seek) {
            }
        } else {
            int height = (int) (this.z.top - (this.o.getHeight() >> 1));
            if (this.f37140e == BdSeeBarStatus.Seek) {
                canvas.drawBitmap(this.q, (((getMeasuredWidth() - this.q.getWidth()) + getPaddingLeft()) - getPaddingRight()) >> 1, height, (Paint) null);
            } else {
                canvas.drawBitmap(this.o, (((getMeasuredWidth() - this.o.getWidth()) + getPaddingLeft()) - getPaddingRight()) >> 1, height, (Paint) null);
            }
        }
    }

    public final int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            int height = this.o.getHeight() + getPaddingTop() + getPaddingBottom();
            if (mode == Integer.MIN_VALUE) {
                if (height > size) {
                    f(((size - getPaddingTop()) - getPaddingBottom()) / this.o.getHeight());
                    return size;
                }
            } else if (mode == 1073741824) {
                if (height > size) {
                    f(((size - getPaddingTop()) - getPaddingBottom()) / this.o.getHeight());
                    return size;
                }
                return size;
            }
            return height;
        }
        return invokeI.intValue;
    }

    public final int e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            int width = this.o.getWidth() + getPaddingLeft() + getPaddingRight();
            int i3 = this.n;
            int i4 = width + i3;
            if (mode == Integer.MIN_VALUE) {
                if (i4 - i3 > size) {
                    f(((size - getPaddingLeft()) - getPaddingRight()) / this.o.getWidth());
                    return size;
                }
            } else if (mode == 1073741824) {
                if (i4 - i3 > size) {
                    f(((size - getPaddingLeft()) - getPaddingRight()) / this.o.getHeight());
                    return size;
                }
                return size;
            }
            return i4;
        }
        return invokeI.intValue;
    }

    public final void f(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048581, this, f2) == null) || f2 <= 0.0f) {
            return;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(f2, f2);
        Bitmap bitmap = this.o;
        this.q = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.o.getHeight(), matrix, true);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int paddingLeft = getPaddingLeft();
            if (paddingLeft <= 0) {
                paddingLeft = this.k;
            }
            int paddingTop = getPaddingTop();
            if (paddingTop <= 0) {
                paddingTop = this.k;
            }
            int paddingRight = getPaddingRight();
            if (paddingRight <= 0) {
                if (this.r) {
                    paddingRight = this.k + this.l;
                } else {
                    paddingRight = this.k;
                }
            }
            int paddingBottom = getPaddingBottom();
            if (paddingBottom <= 0) {
                paddingBottom = this.k;
            }
            setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public float getMax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.s : invokeV.floatValue;
    }

    public int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (int) this.t : invokeV.intValue;
    }

    public boolean isDragble() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mIsDragable : invokeV.booleanValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float abs;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, canvas) == null) {
            RectF rectF = this.z;
            float f2 = rectF.left;
            if (this.A == SeekBarDirect.Horizontal) {
                abs = Math.abs(rectF.right - f2);
            } else {
                abs = Math.abs(rectF.bottom - rectF.top);
            }
            int i2 = a.a[this.x.ordinal()];
            if (i2 == 1) {
                if (this.r) {
                    this.f37143h.setColor(BdThumbSeekBarView.UI_DRAG_TRACE_COLOR);
                }
                canvas.drawRect(this.z, this.f37143h);
                a(this.u, abs);
                canvas.drawRect(this.z, this.w);
                a(this.t, abs);
                canvas.drawRect(this.z, this.v);
                c(canvas, f2, abs);
            } else if (i2 == 2) {
                if (this.r) {
                    this.f37143h.setColor(BdThumbSeekBarView.UI_DRAG_TRACE_COLOR);
                }
                int i3 = this.m;
                int i4 = i3 >> 1;
                int i5 = i3 >> 1;
                if (i3 < 5) {
                    i4 = 0;
                    i5 = 0;
                }
                int save = canvas.save();
                float f3 = i4;
                float f4 = i5;
                canvas.drawRoundRect(this.z, f3, f4, this.f37143h);
                a(this.u, abs);
                canvas.drawRoundRect(this.z, f3, f4, this.w);
                a(this.t, abs);
                this.v.setXfermode(this.f37145j);
                canvas.drawRoundRect(this.z, f3, f4, this.v);
                canvas.restoreToCount(save);
                c(canvas, f2, abs);
            }
            b();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            g();
            setMeasuredDimension(e(i2), d(i3));
            b();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0076, code lost:
        if (r6 != 3) goto L23;
     */
    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, motionEvent)) == null) {
            if (this.mIsDragable) {
                if (this.A == SeekBarDirect.Horizontal) {
                    float x = motionEvent.getX();
                    RectF rectF = this.z;
                    float f2 = rectF.left;
                    if (x < f2) {
                        x = f2;
                    } else {
                        float f3 = rectF.right;
                        if (x > f3) {
                            x = f3;
                        }
                    }
                    RectF rectF2 = this.z;
                    float f4 = rectF2.left;
                    setProgress(((x - f4) * this.s) / (rectF2.right - f4));
                } else {
                    float y = motionEvent.getY();
                    RectF rectF3 = this.z;
                    float f5 = rectF3.top;
                    if (y < f5) {
                        y = f5;
                    } else {
                        float f6 = rectF3.bottom;
                        if (y > f6) {
                            y = f6;
                        }
                    }
                    RectF rectF4 = this.z;
                    float f7 = rectF4.bottom;
                    setProgress(((f7 - y) * this.s) / (f7 - rectF4.top));
                }
                b bVar = this.y;
                if (bVar != null) {
                    this.f37140e = BdSeeBarStatus.Seek;
                    bVar.onProgressChanged(this, (int) this.t, true);
                }
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    b bVar2 = this.y;
                    if (bVar2 != null) {
                        bVar2.onStopTrackingTouch(this);
                        this.f37140e = BdSeeBarStatus.None;
                    }
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else {
                    b bVar3 = this.y;
                    if (bVar3 != null) {
                        bVar3.onStartTrackingTouch(this);
                        this.f37140e = BdSeeBarStatus.Seek;
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                invalidate();
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setBufferColor(int i2) {
        Paint paint;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (paint = this.w) == null) {
            return;
        }
        paint.setColor(i2);
    }

    public void setBufferingProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.u = i2;
        }
    }

    public void setDragable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.mIsDragable = z;
        }
    }

    public void setMax(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f2) == null) {
            this.s = f2;
        }
    }

    public void setMaxDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            setMax(i2);
        }
    }

    public void setOnSeekBarChangeListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            this.y = bVar;
        }
    }

    public void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            setProgress(i2);
        }
    }

    public void setProgressBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.f37143h.setColor(i2);
        }
    }

    public void setProgressColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.v.setColor(i2);
        }
    }

    public void setScaleThumbBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bitmap) == null) {
            this.q = bitmap;
        }
    }

    public void setSeekBarDirect(SeekBarDirect seekBarDirect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, seekBarDirect) == null) {
            this.A = seekBarDirect;
        }
    }

    public void setStyle(@NonNull BdSeekBarStyle bdSeekBarStyle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bdSeekBarStyle) == null) {
            this.x = bdSeekBarStyle;
        }
    }

    public void setThumbBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bitmap) == null) {
            this.o = bitmap;
        }
    }

    public void setThumbScaleVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.r = z;
        }
    }

    public void setUiTraceHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.m = (int) ((i2 * this.f37144i) + 0.5d);
        }
    }

    public void syncPos(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048606, this, i2, i3, i4) == null) {
            setMax(i3);
            setBufferingProgress(i4);
            setProgress(i2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdThumbSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C, 1);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], (BdSeekBarStyle) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public void setProgress(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048595, this, f2) == null) {
            this.t = f2;
            invalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdThumbSeekBar(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, C, 1);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (BdSeekBarStyle) objArr2[3], ((Integer) objArr2[4]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdThumbSeekBar(Context context, BdSeekBarStyle bdSeekBarStyle, int i2) {
        this(context, null, bdSeekBarStyle, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdSeekBarStyle, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65542, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], (BdSeekBarStyle) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65542, newInitContext);
                return;
            }
        }
    }

    public void syncPos(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048605, this, i2, i3) == null) {
            setBufferingProgress(i3);
            setProgress(i2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdThumbSeekBar(Context context, AttributeSet attributeSet, BdSeekBarStyle bdSeekBarStyle, int i2) {
        this(context, attributeSet, 0, bdSeekBarStyle, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, bdSeekBarStyle, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65541, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (BdSeekBarStyle) objArr2[3], ((Integer) objArr2[4]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdThumbSeekBar(Context context, AttributeSet attributeSet, int i2, BdSeekBarStyle bdSeekBarStyle, int i3) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2), bdSeekBarStyle, Integer.valueOf(i3)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.f37140e = BdSeeBarStatus.None;
        this.f37141f = B;
        this.r = true;
        this.A = SeekBarDirect.Horizontal;
        this.mIsDragable = true;
        this.f37142g = context;
        setClickable(true);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, q.NadBdThumbSeekBar);
        int i6 = obtainStyledAttributes.getInt(q.NadBdThumbSeekBar_nad_ThumbSeekBarStyle, 0);
        obtainStyledAttributes.recycle();
        if (i6 == 1) {
            this.x = BdSeekBarStyle.LINE;
        } else if (i6 != 2) {
            this.x = bdSeekBarStyle;
        } else {
            this.x = BdSeekBarStyle.ROUND_RECT;
        }
        Paint paint = new Paint();
        this.f37143h = paint;
        paint.setAntiAlias(true);
        this.f37143h.setColor(getResources().getColor(j.nad_video_seek_bar_bg_color));
        Paint paint2 = new Paint();
        this.v = paint2;
        paint2.setAntiAlias(true);
        this.v.setColor(getResources().getColor(j.nad_video_seek_bar_played_color));
        Paint paint3 = new Paint();
        this.w = paint3;
        paint3.setAntiAlias(true);
        this.w.setColor(getResources().getColor(j.nad_video_seek_bar_buffered_color));
        this.s = 100.0f;
        this.t = 0.0f;
        this.u = 0;
        if (this.f37142g != null) {
            if (this.o == null) {
                this.o = BitmapFactory.decodeResource(context.getResources(), l.nad_videoplayer_new_player_seekbar_thumb);
            }
            this.p = c.a.c0.h0.a.d.b.a(0.0f);
        }
        if (this.q == null) {
            f(1.5f);
        }
        this.z = new RectF();
        this.f37144i = 1.5f;
        Context context2 = this.f37142g;
        if (context2 != null) {
            this.f37144i = context2.getResources().getDisplayMetrics().density;
        }
        float f2 = this.f37144i;
        this.k = (int) (0.0f * f2);
        this.l = (int) (f2 * 5.0f);
        setUiTraceHeight(i3);
        this.n = (int) (this.f37144i * 50.0f);
        this.f37145j = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    }
}
