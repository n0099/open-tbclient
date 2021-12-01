package com.baidu.nadcore.video.videoplayer.ui.full;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.e0.a.d.b;
import c.a.b0.h0.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class BdVideoPopImageView extends View {
    public static /* synthetic */ Interceptable $ic;
    public static final int p;
    public static final int q;
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int u;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f37732e;

    /* renamed from: f  reason: collision with root package name */
    public int f37733f;

    /* renamed from: g  reason: collision with root package name */
    public int f37734g;

    /* renamed from: h  reason: collision with root package name */
    public String f37735h;

    /* renamed from: i  reason: collision with root package name */
    public String f37736i;

    /* renamed from: j  reason: collision with root package name */
    public Paint f37737j;

    /* renamed from: k  reason: collision with root package name */
    public Drawable f37738k;
    public Rect l;
    public int m;
    public int n;
    public Bitmap o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(318539596, "Lcom/baidu/nadcore/video/videoplayer/ui/full/BdVideoPopImageView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(318539596, "Lcom/baidu/nadcore/video/videoplayer/ui/full/BdVideoPopImageView;");
                return;
            }
        }
        p = b.a(12.0f);
        q = b.d(30.0f);
        r = b.a(16.0f);
        s = b.a(9.0f) + r;
        t = b.b(90.0f);
        u = b.b(90.0f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdVideoPopImageView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f37733f = t;
        this.f37734g = u;
        this.f37735h = "";
        this.f37736i = "";
        this.m = q;
        this.n = p;
        this.f37732e = context;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Paint paint = new Paint();
            this.f37737j = paint;
            paint.setAntiAlias(true);
            this.f37737j.setTextSize(p);
            this.f37737j.setColor(-1);
            this.f37737j.setTextAlign(Paint.Align.CENTER);
            this.l = new Rect();
            this.f37738k = this.f37732e.getResources().getDrawable(q.nad_videoplayer_play_pop_bg);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            Drawable drawable = this.f37738k;
            if (drawable != null) {
                this.l.set(0, 0, measuredWidth, measuredHeight);
                drawable.setBounds(this.l);
                drawable.draw(canvas);
            }
            Bitmap bitmap = this.o;
            if (bitmap != null) {
                canvas.drawBitmap(this.o, (measuredWidth - bitmap.getWidth()) / 2, r, this.f37737j);
            } else {
                this.f37737j.setTextSize(this.m);
                canvas.drawText(this.f37735h, measuredWidth >> 1, r * 2, this.f37737j);
            }
            int i2 = (measuredHeight / 2) + s;
            this.f37737j.setTextSize(this.n);
            canvas.drawText(this.f37736i, measuredWidth >> 1, i2, this.f37737j);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            setMeasuredDimension(this.f37733f, this.f37734g);
        }
    }

    public void setBackground(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f37738k = this.f37732e.getResources().getDrawable(i2);
        }
    }

    public void setHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f37734g = i2;
        }
    }

    public void setIcon(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.o = BitmapFactory.decodeResource(this.f37732e.getResources(), i2);
        }
    }

    public void setMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f37736i = str;
            invalidate();
        }
    }

    public void setMsgFontSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.n = i2;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f37735h = str;
        }
    }

    public void setTitleFontSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.m = i2;
        }
    }

    public void setWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f37733f = i2;
        }
    }

    public void setMsg(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f37736i = this.f37732e.getResources().getString(i2);
        }
    }
}
