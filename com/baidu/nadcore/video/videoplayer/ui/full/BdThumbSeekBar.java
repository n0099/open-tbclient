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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.widget.BdThumbSeekBarView;
import com.baidu.tieba.R;
import com.baidu.tieba.c41;
import com.baidu.tieba.p61;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class BdThumbSeekBar extends View {
    public static /* synthetic */ Interceptable $ic;
    public static final int y;
    public static final BdSeekBarStyle z;
    public transient /* synthetic */ FieldHolder $fh;
    public BdSeeBarStatus a;
    public final int b;
    public final Context c;
    public final Paint d;
    public float e;
    public final PorterDuffXfermode f;
    public final int g;
    public final int h;
    public int i;
    public final int j;
    public Bitmap k;
    public int l;
    public Bitmap m;
    public boolean n;
    public float o;
    public float p;
    public int q;
    public final Paint r;
    public final Paint s;
    public BdSeekBarStyle t;
    public b u;
    public final RectF v;
    public SeekBarDirect w;
    public boolean x;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
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

        public BdSeeBarStatus(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
    /* loaded from: classes2.dex */
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

        public BdSeekBarStyle(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
    /* loaded from: classes2.dex */
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

        public SeekBarDirect(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public interface b {
        void a(BdThumbSeekBar bdThumbSeekBar, int i, boolean z);

        void b(BdThumbSeekBar bdThumbSeekBar);

        void c(BdThumbSeekBar bdThumbSeekBar);
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
        y = c41.d(0.0f);
        z = BdSeekBarStyle.LINE;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdThumbSeekBar(Context context, int i) {
        this(context, z, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (BdSeekBarStyle) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void a(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            if (f < 0.0f) {
                f = 0.0f;
            }
            float f3 = this.o;
            if (f > f3) {
                f = f3;
            }
            if (this.w == SeekBarDirect.Horizontal) {
                float f4 = this.o;
                if (f4 > 0.1f) {
                    f = (f * f2) / f4;
                }
                RectF rectF = this.v;
                rectF.right = rectF.left + f;
                return;
            }
            float f5 = this.o;
            if (f5 > 0.1f) {
                f = (f * f2) / f5;
            }
            RectF rectF2 = this.v;
            rectF2.top = rectF2.bottom - f;
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.w == SeekBarDirect.Horizontal) {
                this.v.left = getPaddingLeft();
                this.v.right = getMeasuredWidth() - getPaddingRight();
                this.v.top = (((getMeasuredHeight() - this.i) + getPaddingTop()) - getPaddingBottom()) >> 1;
                RectF rectF = this.v;
                rectF.bottom = rectF.top + this.i;
                return;
            }
            this.v.top = getPaddingTop();
            this.v.bottom = getMeasuredHeight() - getPaddingBottom();
            this.v.left = (((getMeasuredWidth() - this.i) + getPaddingLeft()) - getPaddingRight()) >> 1;
            RectF rectF2 = this.v;
            rectF2.right = rectF2.left + this.i;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(Canvas canvas, float f, float f2) {
        float width;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{canvas, Float.valueOf(f), Float.valueOf(f2)}) != null) || !this.n) {
            return;
        }
        if (this.w == SeekBarDirect.Horizontal) {
            int width2 = (int) (this.v.right - (this.k.getWidth() >> 1));
            int i = this.l;
            if (width2 >= (-i) + f) {
                float f3 = f2 + f;
                if ((this.k.getWidth() + width2) - this.l > f3) {
                    width = f3 - this.k.getWidth();
                    f = this.l;
                }
                if (this.a != BdSeeBarStatus.Seek) {
                    canvas.drawBitmap(this.m, width2, ((((getMeasuredHeight() - this.m.getHeight()) + getPaddingTop()) - getPaddingBottom()) >> 1) + ((int) (this.b * 1.5f)), (Paint) null);
                    return;
                } else {
                    canvas.drawBitmap(this.k, Math.max(width2, -this.l), ((((getMeasuredHeight() - this.k.getHeight()) + getPaddingTop()) - getPaddingBottom()) >> 1) + this.b, (Paint) null);
                    return;
                }
            }
            width = -i;
            width2 = (int) (width + f);
            if (this.a != BdSeeBarStatus.Seek) {
            }
        } else {
            int height = (int) (this.v.top - (this.k.getHeight() >> 1));
            if (this.a == BdSeeBarStatus.Seek) {
                canvas.drawBitmap(this.m, (((getMeasuredWidth() - this.m.getWidth()) + getPaddingLeft()) - getPaddingRight()) >> 1, height, (Paint) null);
            } else {
                canvas.drawBitmap(this.k, (((getMeasuredWidth() - this.k.getWidth()) + getPaddingLeft()) - getPaddingRight()) >> 1, height, (Paint) null);
            }
        }
    }

    public final int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int height = this.k.getHeight() + getPaddingTop() + getPaddingBottom();
            if (mode == Integer.MIN_VALUE) {
                if (height > size) {
                    f(((size - getPaddingTop()) - getPaddingBottom()) / this.k.getHeight());
                    return size;
                }
            } else if (mode == 1073741824) {
                if (height > size) {
                    f(((size - getPaddingTop()) - getPaddingBottom()) / this.k.getHeight());
                    return size;
                }
                return size;
            }
            return height;
        }
        return invokeI.intValue;
    }

    public final int e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int width = this.k.getWidth() + getPaddingLeft() + getPaddingRight();
            int i2 = this.j;
            int i3 = width + i2;
            if (mode == Integer.MIN_VALUE) {
                if (i3 - i2 > size) {
                    f(((size - getPaddingLeft()) - getPaddingRight()) / this.k.getWidth());
                    return size;
                }
            } else if (mode == 1073741824) {
                if (i3 - i2 > size) {
                    f(((size - getPaddingLeft()) - getPaddingRight()) / this.k.getHeight());
                    return size;
                }
                return size;
            }
            return i3;
        }
        return invokeI.intValue;
    }

    public final void f(float f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048581, this, f) == null) || f <= 0.0f) {
            return;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(f, f);
        Bitmap bitmap = this.k;
        this.m = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.k.getHeight(), matrix, true);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int paddingLeft = getPaddingLeft();
            if (paddingLeft <= 0) {
                paddingLeft = this.g;
            }
            int paddingTop = getPaddingTop();
            if (paddingTop <= 0) {
                paddingTop = this.g;
            }
            int paddingRight = getPaddingRight();
            if (paddingRight <= 0) {
                if (this.n) {
                    paddingRight = this.g + this.h;
                } else {
                    paddingRight = this.g;
                }
            }
            int paddingBottom = getPaddingBottom();
            if (paddingBottom <= 0) {
                paddingBottom = this.g;
            }
            setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public float getMax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.o : invokeV.floatValue;
    }

    public int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (int) this.p : invokeV.intValue;
    }

    public void h(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048585, this, i, i2, i3) == null) {
            setMax(i2);
            setBufferingProgress(i3);
            setProgress(i);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float abs;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, canvas) == null) {
            RectF rectF = this.v;
            float f = rectF.left;
            if (this.w == SeekBarDirect.Horizontal) {
                abs = Math.abs(rectF.right - f);
            } else {
                abs = Math.abs(rectF.bottom - rectF.top);
            }
            int i = a.a[this.t.ordinal()];
            if (i == 1) {
                if (this.n) {
                    this.d.setColor(BdThumbSeekBarView.UI_DRAG_TRACE_COLOR);
                }
                canvas.drawRect(this.v, this.d);
                a(this.q, abs);
                canvas.drawRect(this.v, this.s);
                a(this.p, abs);
                canvas.drawRect(this.v, this.r);
                c(canvas, f, abs);
            } else if (i == 2) {
                if (this.n) {
                    this.d.setColor(BdThumbSeekBarView.UI_DRAG_TRACE_COLOR);
                }
                int i2 = this.i;
                int i3 = i2 >> 1;
                int i4 = i2 >> 1;
                if (i2 < 5) {
                    i3 = 0;
                    i4 = 0;
                }
                int save = canvas.save();
                float f2 = i3;
                float f3 = i4;
                canvas.drawRoundRect(this.v, f2, f3, this.d);
                a(this.q, abs);
                canvas.drawRoundRect(this.v, f2, f3, this.s);
                a(this.p, abs);
                this.r.setXfermode(this.f);
                canvas.drawRoundRect(this.v, f2, f3, this.r);
                canvas.restoreToCount(save);
                c(canvas, f, abs);
            }
            b();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
            g();
            setMeasuredDimension(e(i), d(i2));
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
            if (this.x) {
                if (this.w == SeekBarDirect.Horizontal) {
                    float x = motionEvent.getX();
                    RectF rectF = this.v;
                    float f = rectF.left;
                    if (x < f) {
                        x = f;
                    } else {
                        float f2 = rectF.right;
                        if (x > f2) {
                            x = f2;
                        }
                    }
                    RectF rectF2 = this.v;
                    float f3 = rectF2.left;
                    setProgress(((x - f3) * this.o) / (rectF2.right - f3));
                } else {
                    float y2 = motionEvent.getY();
                    RectF rectF3 = this.v;
                    float f4 = rectF3.top;
                    if (y2 < f4) {
                        y2 = f4;
                    } else {
                        float f5 = rectF3.bottom;
                        if (y2 > f5) {
                            y2 = f5;
                        }
                    }
                    RectF rectF4 = this.v;
                    float f6 = rectF4.bottom;
                    setProgress(((f6 - y2) * this.o) / (f6 - rectF4.top));
                }
                b bVar = this.u;
                if (bVar != null) {
                    this.a = BdSeeBarStatus.Seek;
                    bVar.a(this, (int) this.p, true);
                }
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    b bVar2 = this.u;
                    if (bVar2 != null) {
                        bVar2.b(this);
                        this.a = BdSeeBarStatus.None;
                    }
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else {
                    b bVar3 = this.u;
                    if (bVar3 != null) {
                        bVar3.c(this);
                        this.a = BdSeeBarStatus.Seek;
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

    public void setBufferColor(int i) {
        Paint paint;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i) == null) || (paint = this.s) == null) {
            return;
        }
        paint.setColor(i);
    }

    public void setBufferingProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.q = i;
        }
    }

    public void setDragable(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z2) == null) {
            this.x = z2;
        }
    }

    public void setMax(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f) == null) {
            this.o = f;
        }
    }

    public void setMaxDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            setMax(i);
        }
    }

    public void setOnSeekBarChangeListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            this.u = bVar;
        }
    }

    public void setProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            setProgress(i);
        }
    }

    public void setProgressBackgroundColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.d.setColor(i);
        }
    }

    public void setProgressColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.r.setColor(i);
        }
    }

    public void setScaleThumbBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bitmap) == null) {
            this.m = bitmap;
        }
    }

    public void setSeekBarDirect(SeekBarDirect seekBarDirect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, seekBarDirect) == null) {
            this.w = seekBarDirect;
        }
    }

    public void setStyle(@NonNull BdSeekBarStyle bdSeekBarStyle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bdSeekBarStyle) == null) {
            this.t = bdSeekBarStyle;
        }
    }

    public void setThumbBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bitmap) == null) {
            this.k = bitmap;
        }
    }

    public void setThumbScaleVisible(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z2) == null) {
            this.n = z2;
        }
    }

    public void setUiTraceHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.i = (int) ((i * this.e) + 0.5d);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdThumbSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, z, 1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], (BdSeekBarStyle) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public void setProgress(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048595, this, f) == null) {
            this.p = f;
            invalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdThumbSeekBar(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, z, 1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (BdSeekBarStyle) objArr2[3], ((Integer) objArr2[4]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdThumbSeekBar(Context context, BdSeekBarStyle bdSeekBarStyle, int i) {
        this(context, null, bdSeekBarStyle, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdSeekBarStyle, Integer.valueOf(i)};
            interceptable.invokeUnInit(65542, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], (BdSeekBarStyle) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65542, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdThumbSeekBar(Context context, AttributeSet attributeSet, BdSeekBarStyle bdSeekBarStyle, int i) {
        this(context, attributeSet, 0, bdSeekBarStyle, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, bdSeekBarStyle, Integer.valueOf(i)};
            interceptable.invokeUnInit(65541, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (BdSeekBarStyle) objArr2[3], ((Integer) objArr2[4]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdThumbSeekBar(Context context, AttributeSet attributeSet, int i, BdSeekBarStyle bdSeekBarStyle, int i2) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), bdSeekBarStyle, Integer.valueOf(i2)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.a = BdSeeBarStatus.None;
        this.b = y;
        this.n = true;
        this.w = SeekBarDirect.Horizontal;
        this.x = true;
        this.c = context;
        setClickable(true);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, p61.NadBdThumbSeekBar);
        int i5 = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
        if (i5 == 1) {
            this.t = BdSeekBarStyle.LINE;
        } else if (i5 != 2) {
            this.t = bdSeekBarStyle;
        } else {
            this.t = BdSeekBarStyle.ROUND_RECT;
        }
        Paint paint = new Paint();
        this.d = paint;
        paint.setAntiAlias(true);
        this.d.setColor(getResources().getColor(R.color.obfuscated_res_0x7f060882));
        Paint paint2 = new Paint();
        this.r = paint2;
        paint2.setAntiAlias(true);
        this.r.setColor(getResources().getColor(R.color.obfuscated_res_0x7f060884));
        Paint paint3 = new Paint();
        this.s = paint3;
        paint3.setAntiAlias(true);
        this.s.setColor(getResources().getColor(R.color.obfuscated_res_0x7f060883));
        this.o = 100.0f;
        this.p = 0.0f;
        this.q = 0;
        if (this.c != null) {
            if (this.k == null) {
                this.k = BitmapFactory.decodeResource(context.getResources(), R.drawable.obfuscated_res_0x7f080e26);
            }
            this.l = c41.a(0.0f);
        }
        if (this.m == null) {
            f(1.5f);
        }
        this.v = new RectF();
        this.e = 1.5f;
        Context context2 = this.c;
        if (context2 != null) {
            this.e = context2.getResources().getDisplayMetrics().density;
        }
        float f = this.e;
        this.g = (int) (0.0f * f);
        this.h = (int) (f * 5.0f);
        setUiTraceHeight(i2);
        this.j = (int) (this.e * 50.0f);
        this.f = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    }
}
