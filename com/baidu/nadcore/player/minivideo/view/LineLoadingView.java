package com.baidu.nadcore.player.minivideo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.d0.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\"\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u00104\u001a\u000203\u0012\b\u00106\u001a\u0004\u0018\u000105¢\u0006\u0004\b7\u00108J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0012¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u0012¢\u0006\u0004\b!\u0010 R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010&R\u0016\u0010(\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010)\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010&R\u0016\u0010*\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010&R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00100\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010&¨\u00069"}, d2 = {"Lcom/baidu/nadcore/player/minivideo/view/LineLoadingView;", "Landroid/view/View;", "", "color", "", "checkColor", "(Ljava/lang/String;)I", "measureSpec", "", "isWidth", "getValue", "(IZ)I", "value", "", "halfValue", "(I)F", "Landroid/graphics/Canvas;", "canvas", "", "onDraw", "(Landroid/graphics/Canvas;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "w", "h", "oldw", "oldh", "onSizeChanged", "(IIII)V", "start", "()V", IntentConfig.STOP, "com/baidu/nadcore/player/minivideo/view/LineLoadingView$counter$1", "counter", "Lcom/baidu/nadcore/player/minivideo/view/LineLoadingView$counter$1;", "curHeight", "I", "curWidth", "defaultHeight", "defaultWidth", "isStop", "Z", "minProgressWidth", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", WBConstants.TRANS_PROGRESS_COLOR, "Ljava/lang/String;", "progressWidth", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "lib-widget_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class LineLoadingView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f38262e;

    /* renamed from: f  reason: collision with root package name */
    public int f38263f;

    /* renamed from: g  reason: collision with root package name */
    public int f38264g;

    /* renamed from: h  reason: collision with root package name */
    public int f38265h;

    /* renamed from: i  reason: collision with root package name */
    public int f38266i;

    /* renamed from: j  reason: collision with root package name */
    public int f38267j;

    /* renamed from: k  reason: collision with root package name */
    public String f38268k;
    public Paint l;
    public boolean m;
    public final a n;
    public HashMap o;

    /* loaded from: classes10.dex */
    public static final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LineLoadingView f38269e;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(LineLoadingView lineLoadingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lineLoadingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38269e = lineLoadingView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f38269e.m) {
                return;
            }
            this.f38269e.invalidate();
            this.f38269e.post(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LineLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.f38268k = "#D3D3D3";
        this.l = new Paint();
        this.m = true;
        this.n = new a(this);
        this.f38262e = f.c.e(context);
        this.f38263f = f.c.a(context, 1.5f);
        int a2 = f.c.a(context, 100.0f);
        this.f38267j = a2;
        this.f38266i = a2;
        this.l.setStyle(Paint.Style.FILL_AND_STROKE);
        this.l.setAntiAlias(true);
    }

    public static /* synthetic */ int c(LineLoadingView lineLoadingView, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = true;
        }
        return lineLoadingView.b(i2, z);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (hashMap = this.o) == null) {
            return;
        }
        hashMap.clear();
    }

    public View _$_findCachedViewById(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (this.o == null) {
                this.o = new HashMap();
            }
            View view = (View) this.o.get(Integer.valueOf(i2));
            if (view == null) {
                View findViewById = findViewById(i2);
                this.o.put(Integer.valueOf(i2), findViewById);
                return findViewById;
            }
            return view;
        }
        return (View) invokeI.objValue;
    }

    public final int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            int parseColor = Color.parseColor(this.f38268k);
            if (str == null || str.length() == 0) {
                return parseColor;
            }
            try {
                return Color.parseColor(str);
            } catch (IllegalArgumentException unused) {
                return parseColor;
            }
        }
        return invokeL.intValue;
    }

    public final int b(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode != Integer.MIN_VALUE) {
                return mode != 0 ? mode != 1073741824 ? z ? this.f38262e : this.f38263f : size : z ? this.f38262e : this.f38263f;
            }
            return Math.min(z ? this.f38262e : this.f38263f, size);
        }
        return invokeCommon.intValue;
    }

    public final float d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? i2 / 2 : invokeI.floatValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            super.onDraw(canvas);
            int i2 = this.f38266i;
            if (i2 < this.f38264g) {
                this.f38266i = i2 + 30;
            } else {
                this.f38266i = this.f38267j;
            }
            int i3 = 255 - ((this.f38266i * 255) / this.f38264g);
            int i4 = i3 <= 255 ? i3 : 255;
            String hexString = Integer.toHexString(i4 >= 30 ? i4 : 30);
            Intrinsics.checkNotNullExpressionValue(hexString, "Integer.toHexString(currentColorValue)");
            String str = this.f38268k;
            int length = str.length();
            if (str != null) {
                String substring = str.substring(1, length);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                this.l.setColor(a('#' + hexString + substring));
                if (canvas != null) {
                    canvas.drawLine(d(this.f38264g) - d(this.f38266i), d(this.f38263f), d(this.f38264g) + d(this.f38266i), d(this.f38263f), this.l);
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            setMeasuredDimension(c(this, i2, false, 2, null), b(i3, false));
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048583, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            this.f38264g = i2;
            this.f38265h = i3;
            this.l.setStrokeWidth(i3);
        }
    }

    public final void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.m = false;
            post(this.n);
            setVisibility(0);
        }
    }

    public final void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.m = true;
            removeCallbacks(this.n);
            setVisibility(4);
        }
    }
}
