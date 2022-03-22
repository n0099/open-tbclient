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
import c.a.a0.v.v0.d;
import c.a.a0.v.v0.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class BdThumbSeekBarView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdSeeBarStatus a;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f27621b;

    /* renamed from: c  reason: collision with root package name */
    public final int f27622c;

    /* renamed from: d  reason: collision with root package name */
    public final int f27623d;

    /* renamed from: e  reason: collision with root package name */
    public final int f27624e;

    /* renamed from: f  reason: collision with root package name */
    public final int f27625f;

    /* renamed from: g  reason: collision with root package name */
    public final int f27626g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f27627h;
    public final int i;
    public Bitmap j;
    public boolean k;
    public float l;
    public float m;
    public int n;
    public final Paint o;
    public final Paint p;
    public final BdSeekBarStyle q;
    public b r;
    public final RectF s;
    public SeekBarDirect t;
    public boolean u;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
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
    /* loaded from: classes4.dex */
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
    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public interface b {
        void a(BdThumbSeekBarView bdThumbSeekBarView);

        void b(BdThumbSeekBarView bdThumbSeekBarView, int i, boolean z);

        void c(BdThumbSeekBarView bdThumbSeekBarView);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdThumbSeekBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, BdSeekBarStyle.LINE, 1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], (BdSeekBarStyle) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i = a.a[this.q.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                this.s.top = (((getMeasuredHeight() - this.f27626g) + getPaddingTop()) - getPaddingBottom()) >> 1;
                RectF rectF = this.s;
                rectF.bottom = rectF.top + this.f27626g;
            } else if (this.t == SeekBarDirect.Horizontal) {
                this.s.left = getPaddingLeft();
                this.s.right = getMeasuredWidth() - getPaddingRight();
                this.s.top = (((getMeasuredHeight() - this.f27624e) + getPaddingTop()) - getPaddingBottom()) >> 1;
                RectF rectF2 = this.s;
                rectF2.bottom = rectF2.top + this.f27624e;
            } else {
                this.s.top = getPaddingTop();
                this.s.bottom = getMeasuredHeight() - getPaddingBottom();
                this.s.left = (((getMeasuredWidth() - this.f27624e) + getPaddingLeft()) - getPaddingRight()) >> 1;
                RectF rectF3 = this.s;
                rectF3.right = rectF3.left + this.f27624e;
            }
        }
    }

    public final int b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int height = this.f27627h.getHeight() + getPaddingTop() + getPaddingBottom();
            if (mode == Integer.MIN_VALUE) {
                if (height > size) {
                    d(((size - getPaddingTop()) - getPaddingBottom()) / this.f27627h.getHeight());
                    return size;
                }
            } else if (mode == 1073741824) {
                if (height > size) {
                    d(((size - getPaddingTop()) - getPaddingBottom()) / this.f27627h.getHeight());
                    return size;
                }
                return size;
            }
            return height;
        }
        return invokeI.intValue;
    }

    public final int c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int width = this.f27627h.getWidth() + getPaddingLeft() + getPaddingRight();
            int i2 = this.f27625f;
            int i3 = width + i2;
            if (mode == Integer.MIN_VALUE) {
                if (i3 - i2 > size) {
                    d(((size - getPaddingLeft()) - getPaddingRight()) / this.f27627h.getWidth());
                    return size;
                }
            } else if (mode == 1073741824) {
                if (i3 - i2 > size) {
                    d(((size - getPaddingLeft()) - getPaddingRight()) / this.f27627h.getHeight());
                    return size;
                }
                return size;
            }
            return i3;
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
        Bitmap bitmap = this.f27627h;
        this.j = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.f27627h.getHeight(), matrix, true);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int paddingLeft = getPaddingLeft();
            if (paddingLeft <= 0) {
                paddingLeft = this.f27622c;
            }
            int paddingTop = getPaddingTop();
            if (paddingTop <= 0) {
                paddingTop = this.f27622c;
            }
            int paddingRight = getPaddingRight();
            if (paddingRight <= 0) {
                if (this.k) {
                    paddingRight = this.f27622c + this.f27623d;
                } else {
                    paddingRight = this.f27622c;
                }
            }
            int paddingBottom = getPaddingBottom();
            if (paddingBottom <= 0) {
                paddingBottom = this.f27622c;
            }
            setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public float getMax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.l : invokeV.floatValue;
    }

    public int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (int) this.m : invokeV.intValue;
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
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
            int i = a.a[this.q.ordinal()];
            if (i == 1) {
                if (this.k) {
                    this.f27621b.setColor(com.baidu.searchbox.player.widget.BdThumbSeekBarView.UI_DRAG_TRACE_COLOR);
                }
                canvas.drawRect(this.s, this.f27621b);
                RectF rectF = this.s;
                float f2 = rectF.left;
                float abs = Math.abs(rectF.right - f2);
                RectF rectF2 = this.s;
                float abs2 = Math.abs(rectF2.top - rectF2.bottom);
                if (this.t == SeekBarDirect.Horizontal) {
                    float f3 = this.l > 0.1f ? (this.n * abs) / 100.0f : 0.0f;
                    RectF rectF3 = this.s;
                    rectF3.right = rectF3.left + f3;
                } else {
                    float f4 = this.l > 0.1f ? this.n : 0.0f;
                    RectF rectF4 = this.s;
                    rectF4.top = rectF4.bottom - f4;
                }
                canvas.drawRect(this.s, this.p);
                if (this.t == SeekBarDirect.Horizontal) {
                    float f5 = this.l;
                    r1 = f5 > 0.1f ? (this.m * abs) / f5 : 0.0f;
                    RectF rectF5 = this.s;
                    rectF5.right = rectF5.left + r1;
                } else {
                    float f6 = this.l;
                    r1 = f6 > 0.1f ? (this.m * abs2) / f6 : 0.0f;
                    RectF rectF6 = this.s;
                    rectF6.top = rectF6.bottom - r1;
                }
                canvas.drawRect(this.s, this.o);
                if (this.k) {
                    if (this.t == SeekBarDirect.Horizontal) {
                        int width2 = (int) (this.s.right - (this.f27627h.getWidth() >> 1));
                        int i2 = this.i;
                        if (width2 < (-i2) + f2) {
                            width = (-i2) + f2;
                        } else {
                            float f7 = abs + f2;
                            if ((this.f27627h.getWidth() + width2) - this.i > f7) {
                                width = (f7 - this.f27627h.getWidth()) + this.i;
                            }
                            if (this.a != BdSeeBarStatus.Seek) {
                                canvas.drawBitmap(this.j, width2, ((((getMeasuredHeight() - this.j.getHeight()) + getPaddingTop()) - getPaddingBottom()) >> 1) + ((int) (0 * 1.5f)), (Paint) null);
                            } else {
                                canvas.drawBitmap(this.f27627h, Math.max(width2, -this.i), ((((getMeasuredHeight() - this.f27627h.getHeight()) + getPaddingTop()) - getPaddingBottom()) >> 1) + 0, (Paint) null);
                            }
                        }
                        width2 = (int) width;
                        if (this.a != BdSeeBarStatus.Seek) {
                        }
                    } else {
                        int height = (int) (this.s.top - (this.f27627h.getHeight() >> 1));
                        if (this.a == BdSeeBarStatus.Seek) {
                            canvas.drawBitmap(this.j, (((getMeasuredWidth() - this.j.getWidth()) + getPaddingLeft()) - getPaddingRight()) >> 1, height, (Paint) null);
                        } else {
                            canvas.drawBitmap(this.f27627h, (((getMeasuredWidth() - this.f27627h.getWidth()) + getPaddingLeft()) - getPaddingRight()) >> 1, height, (Paint) null);
                        }
                    }
                }
            } else if (i == 2) {
                this.f27621b.setColor(com.baidu.searchbox.player.widget.BdThumbSeekBarView.UI_TRACE_COLOR);
                RectF rectF7 = this.s;
                int i3 = this.f27626g;
                canvas.drawRoundRect(rectF7, i3 >> 1, i3, this.f27621b);
                this.f27621b.setColor(com.baidu.searchbox.player.widget.BdThumbSeekBarView.UI_SELECT_COLOR_START);
                float f8 = this.l;
                if (f8 > 0.1f) {
                    float f9 = this.m;
                    RectF rectF8 = this.s;
                    r1 = (f9 * (rectF8.right - rectF8.left)) / f8;
                }
                RectF rectF9 = this.s;
                rectF9.right = rectF9.left + r1;
                int i4 = this.f27626g;
                canvas.drawRoundRect(rectF9, i4 >> 1, i4, this.f27621b);
                Bitmap bitmap = this.f27627h;
                canvas.drawBitmap(bitmap, this.s.right - (bitmap.getWidth() >> 1), (int) (this.s.top + ((this.f27626g - this.f27627h.getHeight()) >> 1)), (Paint) null);
            }
            a();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
            e();
            setMeasuredDimension(c(i), b(i2));
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            if (this.u) {
                if (this.t == SeekBarDirect.Horizontal) {
                    float x = motionEvent.getX();
                    RectF rectF = this.s;
                    float f2 = rectF.left;
                    if (x < f2) {
                        x = f2;
                    } else {
                        float f3 = rectF.right;
                        if (x > f3) {
                            x = f3;
                        }
                    }
                    RectF rectF2 = this.s;
                    float f4 = rectF2.left;
                    setProgress(((x - f4) * this.l) / (rectF2.right - f4));
                } else {
                    float y = motionEvent.getY();
                    RectF rectF3 = this.s;
                    float f5 = rectF3.top;
                    if (y < f5) {
                        y = f5;
                    } else {
                        float f6 = rectF3.bottom;
                        if (y > f6) {
                            y = f6;
                        }
                    }
                    RectF rectF4 = this.s;
                    float f7 = rectF4.bottom;
                    setProgress(((f7 - y) * this.l) / (f7 - rectF4.top));
                }
                b bVar = this.r;
                if (bVar != null) {
                    this.a = BdSeeBarStatus.Seek;
                    bVar.b(this, (int) this.m, true);
                }
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    b bVar2 = this.r;
                    if (bVar2 != null) {
                        bVar2.c(this);
                        this.a = BdSeeBarStatus.None;
                    }
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else {
                    b bVar3 = this.r;
                    if (bVar3 != null) {
                        bVar3.a(this);
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
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i) == null) || (paint = this.p) == null) {
            return;
        }
        paint.setColor(i);
    }

    public void setBufferingProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.n = i;
        }
    }

    public void setDragable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.u = z;
        }
    }

    public void setMax(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048589, this, f2) == null) {
            this.l = f2;
        }
    }

    public void setMaxDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            setMax(i);
        }
    }

    public void setOnSeekBarChangeListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            this.r = bVar;
        }
    }

    public void setProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            setProgress(i);
        }
    }

    public void setProgressBackgroundColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.f27621b.setColor(i);
        }
    }

    public void setProgressColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.o.setColor(i);
        }
    }

    public void setScaleThumbBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bitmap) == null) {
            this.j = bitmap;
        }
    }

    public void setSeekBarDirect(SeekBarDirect seekBarDirect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, seekBarDirect) == null) {
            this.t = seekBarDirect;
        }
    }

    public void setThumbBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bitmap) == null) {
            this.f27627h = bitmap;
        }
    }

    public void setThumbScaleVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.k = z;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdThumbSeekBarView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, BdSeekBarStyle.LINE, 1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (BdSeekBarStyle) objArr2[3], ((Integer) objArr2[4]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void setProgress(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f2) == null) {
            this.m = f2;
            invalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdThumbSeekBarView(Context context, AttributeSet attributeSet, BdSeekBarStyle bdSeekBarStyle, int i) {
        this(context, attributeSet, 0, bdSeekBarStyle, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, bdSeekBarStyle, Integer.valueOf(i)};
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdThumbSeekBarView(Context context, AttributeSet attributeSet, int i, BdSeekBarStyle bdSeekBarStyle, int i2) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), bdSeekBarStyle, Integer.valueOf(i2)};
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
        this.a = BdSeeBarStatus.None;
        this.k = true;
        this.t = SeekBarDirect.Horizontal;
        this.u = true;
        setClickable(true);
        this.q = bdSeekBarStyle;
        Paint paint = new Paint();
        this.f27621b = paint;
        paint.setAntiAlias(true);
        this.f27621b.setColor(getResources().getColor(R.color.obfuscated_res_0x7f0607e9));
        Paint paint2 = new Paint();
        this.o = paint2;
        paint2.setAntiAlias(true);
        this.o.setColor(getResources().getColor(R.color.obfuscated_res_0x7f0607eb));
        Paint paint3 = new Paint();
        this.p = paint3;
        paint3.setAntiAlias(true);
        this.p.setColor(getResources().getColor(R.color.obfuscated_res_0x7f0607ea));
        this.l = 100.0f;
        this.m = 0.0f;
        this.n = 0;
        if (this.f27627h == null) {
            this.f27627h = BitmapFactory.decodeResource(context.getResources(), R.drawable.obfuscated_res_0x7f080d82);
        }
        this.i = d.a(this, 0.0f);
        if (this.j == null) {
            d(1.5f);
        }
        this.s = new RectF();
        float f2 = getResources().getDisplayMetrics().density;
        this.f27622c = (int) (0.0f * f2);
        this.f27623d = (int) (5.0f * f2);
        this.f27624e = (int) ((i2 * f2) + 0.5d);
        this.f27625f = (int) (50.0f * f2);
        this.f27626g = (int) (f2 * 3.0f);
        h.b(com.baidu.searchbox.player.widget.BdThumbSeekBarView.TAG, "mUITraceHeight: " + this.f27624e);
    }
}
