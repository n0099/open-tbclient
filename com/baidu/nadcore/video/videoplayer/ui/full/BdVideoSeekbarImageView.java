package com.baidu.nadcore.video.videoplayer.ui.full;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.l21;
/* loaded from: classes2.dex */
public class BdVideoSeekbarImageView extends View {
    public static /* synthetic */ Interceptable $ic;
    public static final int A;
    public static final int B;
    public static final int C;
    public static final int D;
    public static final int E;
    public static final int F;
    public static final int G;
    public static final int H;
    public static final int p;
    public static final int q;
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int u;
    public static final int v;
    public static final int w;
    public static final int x;
    public static final int y;
    public static final int z;
    public transient /* synthetic */ FieldHolder $fh;
    public BdThumbSeekBar a;
    public final Context b;
    public Paint c;
    public Paint d;
    public int e;
    public int f;
    public String g;
    public String h;
    public String i;
    public Drawable j;
    public Rect k;
    public int l;
    public int m;
    public Bitmap n;
    public boolean o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1158956266, "Lcom/baidu/nadcore/video/videoplayer/ui/full/BdVideoSeekbarImageView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1158956266, "Lcom/baidu/nadcore/video/videoplayer/ui/full/BdVideoSeekbarImageView;");
                return;
            }
        }
        p = l21.a(12.0f);
        q = l21.d(30.0f);
        r = l21.a(17.0f);
        s = l21.a(13.0f);
        t = l21.a(2.0f);
        l21.a(9.0f);
        u = l21.b(90.0f);
        v = l21.b(90.0f);
        w = l21.a(77.0f);
        x = l21.a(7.0f);
        y = l21.a(1.0f);
        z = l21.a(23.0f);
        A = l21.a(21.0f);
        B = l21.a(64.0f);
        C = l21.a(34.0f);
        D = l21.a(27.0f);
        E = l21.a(25.0f);
        F = l21.a(11.0f);
        G = l21.a(9.0f);
        H = l21.a(60.0f);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdVideoSeekbarImageView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public Bitmap a(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
            view2.setDrawingCacheEnabled(true);
            view2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view2.layout(0, 0, view2.getMeasuredWidth(), view2.getMeasuredHeight());
            view2.buildDrawingCache();
            Bitmap drawingCache = view2.getDrawingCache();
            int width = drawingCache.getWidth();
            int height = drawingCache.getHeight();
            int i = w;
            Matrix matrix = new Matrix();
            matrix.postScale(i / width, x / height);
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height, matrix, true);
        }
        return (Bitmap) invokeL.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Paint paint = new Paint();
            this.c = paint;
            paint.setAntiAlias(true);
            this.c.setTextSize(p);
            this.c.setColor(-1);
            Paint paint2 = new Paint();
            this.d = paint2;
            paint2.setAntiAlias(true);
            this.d.setTextSize(p);
            this.d.setColor(-7829368);
            this.k = new Rect();
            this.j = this.b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e29);
            BdThumbSeekBar bdThumbSeekBar = new BdThumbSeekBar(this.b, y);
            this.a = bdThumbSeekBar;
            bdThumbSeekBar.setDragable(false);
            this.a.setProgressBackgroundColor(-1);
            this.a.setThumbScaleVisible(false);
        }
    }

    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            setDuration(i2);
            setPosition(i);
            invalidate();
        }
    }

    public float d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.i.length() < 6) {
                return this.o ? D : E;
            }
            return this.o ? F : G;
        }
        return invokeV.floatValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            super.onDraw(canvas);
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            Drawable drawable = this.j;
            if (drawable != null) {
                this.k.set(0, 0, measuredWidth, measuredHeight);
                drawable.setBounds(this.k);
                drawable.draw(canvas);
            }
            if (this.n == null) {
                this.c.setTextSize(this.l);
                canvas.drawText(this.g, measuredWidth >> 1, r * 2, this.c);
            } else if (this.o) {
                canvas.drawBitmap(this.n, (measuredWidth - bitmap.getWidth()) / 2, r, this.c);
            }
            if (this.o) {
                i = (measuredHeight / 2) + s;
            } else {
                i = (measuredHeight / 2) - t;
            }
            this.c.setTextSize(this.m);
            float f = i;
            canvas.drawText(this.h + " ", d(), f, this.c);
            canvas.drawText("/ " + this.i, H, f, this.d);
            BdThumbSeekBar bdThumbSeekBar = this.a;
            if (bdThumbSeekBar != null) {
                Bitmap a = a(bdThumbSeekBar);
                if (this.o) {
                    canvas.drawBitmap(a, z, B, this.c);
                } else {
                    canvas.drawBitmap(a, A, C, this.c);
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            setMeasuredDimension(this.e, this.f);
        }
    }

    public void setBackground(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.j = this.b.getResources().getDrawable(i);
        }
    }

    public void setDuration(int i) {
        BdThumbSeekBar bdThumbSeekBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || (bdThumbSeekBar = this.a) == null) {
            return;
        }
        bdThumbSeekBar.setMax(i);
    }

    public void setHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.f = i;
        }
    }

    public void setIcon(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.n = BitmapFactory.decodeResource(this.b.getResources(), i);
        }
    }

    public void setIconVisible(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z2) == null) {
            this.o = z2;
        }
    }

    public void setMsg(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
            this.h = str;
            this.i = str2;
            invalidate();
        }
    }

    public void setMsgFontSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.m = i;
        }
    }

    public void setPosition(int i) {
        BdThumbSeekBar bdThumbSeekBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i) == null) || (bdThumbSeekBar = this.a) == null) {
            return;
        }
        bdThumbSeekBar.setProgress(i);
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.g = str;
        }
    }

    public void setTitleFontSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.l = i;
        }
    }

    public void setWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.e = i;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdVideoSeekbarImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.e = u;
        this.f = v;
        this.g = "";
        this.h = "";
        this.i = "";
        this.l = q;
        this.m = p;
        this.o = true;
        this.b = context;
        b();
    }
}
