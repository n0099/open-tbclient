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
import c.a.a0.i0.a.d.b;
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
public class BdVideoPopImageView extends View {
    public static /* synthetic */ Interceptable $ic;
    public static final int l;
    public static final int m;
    public static final int n;
    public static final int o;
    public static final int p;
    public static final int q;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public int f27687b;

    /* renamed from: c  reason: collision with root package name */
    public int f27688c;

    /* renamed from: d  reason: collision with root package name */
    public String f27689d;

    /* renamed from: e  reason: collision with root package name */
    public String f27690e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f27691f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f27692g;

    /* renamed from: h  reason: collision with root package name */
    public Rect f27693h;
    public int i;
    public int j;
    public Bitmap k;

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
        l = b.a(12.0f);
        m = b.d(30.0f);
        n = b.a(16.0f);
        o = b.a(9.0f) + n;
        p = b.b(90.0f);
        q = b.b(90.0f);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f27687b = p;
        this.f27688c = q;
        this.f27689d = "";
        this.f27690e = "";
        this.i = m;
        this.j = l;
        this.a = context;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Paint paint = new Paint();
            this.f27691f = paint;
            paint.setAntiAlias(true);
            this.f27691f.setTextSize(l);
            this.f27691f.setColor(-1);
            this.f27691f.setTextAlign(Paint.Align.CENTER);
            this.f27693h = new Rect();
            this.f27692g = this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e00);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            Drawable drawable = this.f27692g;
            if (drawable != null) {
                this.f27693h.set(0, 0, measuredWidth, measuredHeight);
                drawable.setBounds(this.f27693h);
                drawable.draw(canvas);
            }
            Bitmap bitmap = this.k;
            if (bitmap != null) {
                canvas.drawBitmap(this.k, (measuredWidth - bitmap.getWidth()) / 2, n, this.f27691f);
            } else {
                this.f27691f.setTextSize(this.i);
                canvas.drawText(this.f27689d, measuredWidth >> 1, n * 2, this.f27691f);
            }
            int i = (measuredHeight / 2) + o;
            this.f27691f.setTextSize(this.j);
            canvas.drawText(this.f27690e, measuredWidth >> 1, i, this.f27691f);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            setMeasuredDimension(this.f27687b, this.f27688c);
        }
    }

    public void setBackground(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.f27692g = this.a.getResources().getDrawable(i);
        }
    }

    public void setHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f27688c = i;
        }
    }

    public void setIcon(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.k = BitmapFactory.decodeResource(this.a.getResources(), i);
        }
    }

    public void setMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f27690e = str;
            invalidate();
        }
    }

    public void setMsgFontSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.j = i;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f27689d = str;
        }
    }

    public void setTitleFontSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.i = i;
        }
    }

    public void setWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.f27687b = i;
        }
    }

    public void setMsg(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.f27690e = this.a.getResources().getString(i);
        }
    }
}
