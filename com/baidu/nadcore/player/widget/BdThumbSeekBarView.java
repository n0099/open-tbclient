package com.baidu.nadcore.player.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.h0.o;
import c.a.b0.h0.q;
import c.a.b0.s.v0.d;
import c.a.b0.s.v0.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class BdThumbSeekBarView extends View {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PLAYED_PAINT_COLOR = -16738561;
    public static final int UI_TRACE_COLOR = 1291845632;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdSeeBarStatus f37670e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f37671f;

    /* renamed from: g  reason: collision with root package name */
    public final int f37672g;

    /* renamed from: h  reason: collision with root package name */
    public final int f37673h;

    /* renamed from: i  reason: collision with root package name */
    public final int f37674i;

    /* renamed from: j  reason: collision with root package name */
    public final int f37675j;

    /* renamed from: k  reason: collision with root package name */
    public final int f37676k;
    public Bitmap l;
    public final int m;
    public boolean mIsDragable;
    public Bitmap n;
    public boolean o;
    public float p;
    public float q;
    public int r;
    public final Paint s;
    public final Paint t;
    public final BdSeekBarStyle u;
    public b v;
    public final RectF w;
    public SeekBarDirect x;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class BdSeeBarStatus {
        public static final /* synthetic */ BdSeeBarStatus[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BdSeeBarStatus None;
        public static final BdSeeBarStatus Seek;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1761427111, "Lcom/baidu/nadcore/player/widget/BdThumbSeekBarView$BdSeeBarStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1761427111, "Lcom/baidu/nadcore/player/widget/BdThumbSeekBarView$BdSeeBarStatus;");
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
    /* loaded from: classes8.dex */
    public static final class BdSeekBarStyle {
        public static final /* synthetic */ BdSeekBarStyle[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BdSeekBarStyle LINE;
        public static final BdSeekBarStyle ROUND_RECT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(220697781, "Lcom/baidu/nadcore/player/widget/BdThumbSeekBarView$BdSeekBarStyle;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(220697781, "Lcom/baidu/nadcore/player/widget/BdThumbSeekBarView$BdSeekBarStyle;");
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
    /* loaded from: classes8.dex */
    public static final class SeekBarDirect {
        public static final /* synthetic */ SeekBarDirect[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SeekBarDirect Horizontal;
        public static final SeekBarDirect Vertical;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1569533285, "Lcom/baidu/nadcore/player/widget/BdThumbSeekBarView$SeekBarDirect;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1569533285, "Lcom/baidu/nadcore/player/widget/BdThumbSeekBarView$SeekBarDirect;");
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

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1463817272, "Lcom/baidu/nadcore/player/widget/BdThumbSeekBarView$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1463817272, "Lcom/baidu/nadcore/player/widget/BdThumbSeekBarView$a;");
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

    /* loaded from: classes8.dex */
    public interface b {
        void a(BdThumbSeekBarView bdThumbSeekBarView);

        void b(BdThumbSeekBarView bdThumbSeekBarView, int i2, boolean z);

        void c(BdThumbSeekBarView bdThumbSeekBarView);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdThumbSeekBarView(Context context, int i2) {
        this(context, BdSeekBarStyle.LINE, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (BdSeekBarStyle) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i2 = a.a[this.u.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    return;
                }
                this.w.top = (((getMeasuredHeight() - this.f37676k) + getPaddingTop()) - getPaddingBottom()) >> 1;
                RectF rectF = this.w;
                rectF.bottom = rectF.top + this.f37676k;
            } else if (this.x == SeekBarDirect.Horizontal) {
                this.w.left = getPaddingLeft();
                this.w.right = getMeasuredWidth() - getPaddingRight();
                this.w.top = (((getMeasuredHeight() - this.f37674i) + getPaddingTop()) - getPaddingBottom()) >> 1;
                RectF rectF2 = this.w;
                rectF2.bottom = rectF2.top + this.f37674i;
            } else {
                this.w.top = getPaddingTop();
                this.w.bottom = getMeasuredHeight() - getPaddingBottom();
                this.w.left = (((getMeasuredWidth() - this.f37674i) + getPaddingLeft()) - getPaddingRight()) >> 1;
                RectF rectF3 = this.w;
                rectF3.right = rectF3.left + this.f37674i;
            }
        }
    }

    public final int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            int height = this.l.getHeight() + getPaddingTop() + getPaddingBottom();
            if (mode == Integer.MIN_VALUE) {
                if (height > size) {
                    d(((size - getPaddingTop()) - getPaddingBottom()) / this.l.getHeight());
                    return size;
                }
            } else if (mode == 1073741824) {
                if (height > size) {
                    d(((size - getPaddingTop()) - getPaddingBottom()) / this.l.getHeight());
                    return size;
                }
                return size;
            }
            return height;
        }
        return invokeI.intValue;
    }

    public final int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            int width = this.l.getWidth() + getPaddingLeft() + getPaddingRight();
            int i3 = this.f37675j;
            int i4 = width + i3;
            if (mode == Integer.MIN_VALUE) {
                if (i4 - i3 > size) {
                    d(((size - getPaddingLeft()) - getPaddingRight()) / this.l.getWidth());
                    return size;
                }
            } else if (mode == 1073741824) {
                if (i4 - i3 > size) {
                    d(((size - getPaddingLeft()) - getPaddingRight()) / this.l.getHeight());
                    return size;
                }
                return size;
            }
            return i4;
        }
        return invokeI.intValue;
    }

    public final void d(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048579, this, f2) == null) || f2 <= 0.0f) {
            return;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(f2, f2);
        Bitmap bitmap = this.l;
        this.n = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.l.getHeight(), matrix, true);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int paddingLeft = getPaddingLeft();
            if (paddingLeft <= 0) {
                paddingLeft = this.f37672g;
            }
            int paddingTop = getPaddingTop();
            if (paddingTop <= 0) {
                paddingTop = this.f37672g;
            }
            int paddingRight = getPaddingRight();
            if (paddingRight <= 0) {
                if (this.o) {
                    paddingRight = this.f37672g + this.f37673h;
                } else {
                    paddingRight = this.f37672g;
                }
            }
            int paddingBottom = getPaddingBottom();
            if (paddingBottom <= 0) {
                paddingBottom = this.f37672g;
            }
            setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public float getMax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.p : invokeV.floatValue;
    }

    public int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (int) this.q : invokeV.intValue;
    }

    public boolean isDragble() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mIsDragable : invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0182  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onDraw(Canvas canvas) {
        float width;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
            int i2 = a.a[this.u.ordinal()];
            if (i2 == 1) {
                if (this.o) {
                    this.f37671f.setColor(-2130706433);
                }
                canvas.drawRect(this.w, this.f37671f);
                RectF rectF = this.w;
                float f2 = rectF.left;
                float abs = Math.abs(rectF.right - f2);
                RectF rectF2 = this.w;
                float abs2 = Math.abs(rectF2.top - rectF2.bottom);
                if (this.x == SeekBarDirect.Horizontal) {
                    float f3 = this.p > 0.1f ? (this.r * abs) / 100.0f : 0.0f;
                    RectF rectF3 = this.w;
                    rectF3.right = rectF3.left + f3;
                } else {
                    float f4 = this.p > 0.1f ? this.r : 0.0f;
                    RectF rectF4 = this.w;
                    rectF4.top = rectF4.bottom - f4;
                }
                canvas.drawRect(this.w, this.t);
                if (this.x == SeekBarDirect.Horizontal) {
                    float f5 = this.p;
                    r1 = f5 > 0.1f ? (this.q * abs) / f5 : 0.0f;
                    RectF rectF5 = this.w;
                    rectF5.right = rectF5.left + r1;
                } else {
                    float f6 = this.p;
                    r1 = f6 > 0.1f ? (this.q * abs2) / f6 : 0.0f;
                    RectF rectF6 = this.w;
                    rectF6.top = rectF6.bottom - r1;
                }
                canvas.drawRect(this.w, this.s);
                if (this.o) {
                    if (this.x == SeekBarDirect.Horizontal) {
                        int width2 = (int) (this.w.right - (this.l.getWidth() >> 1));
                        int i3 = this.m;
                        if (width2 < (-i3) + f2) {
                            width = (-i3) + f2;
                        } else {
                            float f7 = abs + f2;
                            if ((this.l.getWidth() + width2) - this.m > f7) {
                                width = (f7 - this.l.getWidth()) + this.m;
                            }
                            if (this.f37670e != BdSeeBarStatus.Seek) {
                                canvas.drawBitmap(this.n, width2, ((((getMeasuredHeight() - this.n.getHeight()) + getPaddingTop()) - getPaddingBottom()) >> 1) + ((int) (0 * 1.5f)), (Paint) null);
                            } else {
                                canvas.drawBitmap(this.l, Math.max(width2, -this.m), ((((getMeasuredHeight() - this.l.getHeight()) + getPaddingTop()) - getPaddingBottom()) >> 1) + 0, (Paint) null);
                            }
                        }
                        width2 = (int) width;
                        if (this.f37670e != BdSeeBarStatus.Seek) {
                        }
                    } else {
                        int height = (int) (this.w.top - (this.l.getHeight() >> 1));
                        if (this.f37670e == BdSeeBarStatus.Seek) {
                            canvas.drawBitmap(this.n, (((getMeasuredWidth() - this.n.getWidth()) + getPaddingLeft()) - getPaddingRight()) >> 1, height, (Paint) null);
                        } else {
                            canvas.drawBitmap(this.l, (((getMeasuredWidth() - this.l.getWidth()) + getPaddingLeft()) - getPaddingRight()) >> 1, height, (Paint) null);
                        }
                    }
                }
            } else if (i2 == 2) {
                this.f37671f.setColor(1291845632);
                RectF rectF7 = this.w;
                int i4 = this.f37676k;
                canvas.drawRoundRect(rectF7, i4 >> 1, i4, this.f37671f);
                this.f37671f.setColor(-16366706);
                float f8 = this.p;
                if (f8 > 0.1f) {
                    float f9 = this.q;
                    RectF rectF8 = this.w;
                    r1 = (f9 * (rectF8.right - rectF8.left)) / f8;
                }
                RectF rectF9 = this.w;
                rectF9.right = rectF9.left + r1;
                int i5 = this.f37676k;
                canvas.drawRoundRect(rectF9, i5 >> 1, i5, this.f37671f);
                Bitmap bitmap = this.l;
                canvas.drawBitmap(bitmap, this.w.right - (bitmap.getWidth() >> 1), (int) (this.w.top + ((this.f37676k - this.l.getHeight()) >> 1)), (Paint) null);
            }
            a();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            e();
            setMeasuredDimension(c(i2), b(i3));
            a();
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, motionEvent)) == null) {
            if (this.mIsDragable) {
                if (this.x == SeekBarDirect.Horizontal) {
                    float x = motionEvent.getX();
                    RectF rectF = this.w;
                    float f2 = rectF.left;
                    if (x < f2) {
                        x = f2;
                    } else {
                        float f3 = rectF.right;
                        if (x > f3) {
                            x = f3;
                        }
                    }
                    RectF rectF2 = this.w;
                    float f4 = rectF2.left;
                    setProgress(((x - f4) * this.p) / (rectF2.right - f4));
                } else {
                    float y = motionEvent.getY();
                    RectF rectF3 = this.w;
                    float f5 = rectF3.top;
                    if (y < f5) {
                        y = f5;
                    } else {
                        float f6 = rectF3.bottom;
                        if (y > f6) {
                            y = f6;
                        }
                    }
                    RectF rectF4 = this.w;
                    float f7 = rectF4.bottom;
                    setProgress(((f7 - y) * this.p) / (f7 - rectF4.top));
                }
                b bVar = this.v;
                if (bVar != null) {
                    this.f37670e = BdSeeBarStatus.Seek;
                    bVar.b(this, (int) this.q, true);
                }
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    b bVar2 = this.v;
                    if (bVar2 != null) {
                        bVar2.c(this);
                        this.f37670e = BdSeeBarStatus.None;
                    }
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else {
                    b bVar3 = this.v;
                    if (bVar3 != null) {
                        bVar3.a(this);
                        this.f37670e = BdSeeBarStatus.Seek;
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
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (paint = this.t) == null) {
            return;
        }
        paint.setColor(i2);
    }

    public void setBufferingProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.r = i2;
        }
    }

    public void setDragable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.mIsDragable = z;
        }
    }

    public void setMax(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048590, this, f2) == null) {
            this.p = f2;
        }
    }

    public void setMaxDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            setMax(i2);
        }
    }

    public void setOnSeekBarChangeListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bVar) == null) {
            this.v = bVar;
        }
    }

    public void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            setProgress(i2);
        }
    }

    public void setProgressBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.f37671f.setColor(i2);
        }
    }

    public void setProgressColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.s.setColor(i2);
        }
    }

    public void setScaleThumbBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bitmap) == null) {
            this.n = bitmap;
        }
    }

    public void setSeekBarDirect(SeekBarDirect seekBarDirect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, seekBarDirect) == null) {
            this.x = seekBarDirect;
        }
    }

    public void setThumbBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bitmap) == null) {
            this.l = bitmap;
        }
    }

    public void setThumbScaleVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.o = z;
        }
    }

    public void syncPos(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048602, this, i2, i3, i4) == null) {
            setMax(i3);
            setBufferingProgress(i4);
            setProgress(i2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdThumbSeekBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, BdSeekBarStyle.LINE, 1);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], (BdSeekBarStyle) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void setProgress(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048593, this, f2) == null) {
            this.q = f2;
            invalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdThumbSeekBarView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, BdSeekBarStyle.LINE, 1);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (BdSeekBarStyle) objArr2[3], ((Integer) objArr2[4]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdThumbSeekBarView(Context context, BdSeekBarStyle bdSeekBarStyle, int i2) {
        this(context, null, bdSeekBarStyle, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdSeekBarStyle, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65541, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], (BdSeekBarStyle) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
    }

    public void syncPos(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048601, this, i2, i3) == null) {
            setBufferingProgress(i3);
            setProgress(i2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdThumbSeekBarView(Context context, AttributeSet attributeSet, BdSeekBarStyle bdSeekBarStyle, int i2) {
        this(context, attributeSet, 0, bdSeekBarStyle, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, bdSeekBarStyle, Integer.valueOf(i2)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (BdSeekBarStyle) objArr2[3], ((Integer) objArr2[4]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdThumbSeekBarView(Context context, AttributeSet attributeSet, int i2, BdSeekBarStyle bdSeekBarStyle, int i3) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2), bdSeekBarStyle, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f37670e = BdSeeBarStatus.None;
        this.o = true;
        this.x = SeekBarDirect.Horizontal;
        this.mIsDragable = true;
        setClickable(true);
        this.u = bdSeekBarStyle;
        Paint paint = new Paint();
        this.f37671f = paint;
        paint.setAntiAlias(true);
        this.f37671f.setColor(getResources().getColor(o.nad_bdvideoplayer_seek_bar_bg_color));
        Paint paint2 = new Paint();
        this.s = paint2;
        paint2.setAntiAlias(true);
        this.s.setColor(getResources().getColor(o.nad_bdvideoplayer_seek_bar_played_color));
        Paint paint3 = new Paint();
        this.t = paint3;
        paint3.setAntiAlias(true);
        this.t.setColor(getResources().getColor(o.nad_bdvideoplayer_seek_bar_buffered_color));
        this.p = 100.0f;
        this.q = 0.0f;
        this.r = 0;
        if (this.l == null) {
            this.l = BitmapFactory.decodeResource(context.getResources(), q.nad_bdvideoplayer_seekbar_thumb);
        }
        this.m = d.a(this, 0.0f);
        if (this.n == null) {
            d(1.5f);
        }
        this.w = new RectF();
        float f2 = getResources().getDisplayMetrics().density;
        this.f37672g = (int) (0.0f * f2);
        this.f37673h = (int) (5.0f * f2);
        this.f37674i = (int) ((i3 * f2) + 0.5d);
        this.f37675j = (int) (50.0f * f2);
        this.f37676k = (int) (f2 * 3.0f);
        h.b("BdThumbSeekBarView", "mUITraceHeight: " + this.f37674i);
    }
}
