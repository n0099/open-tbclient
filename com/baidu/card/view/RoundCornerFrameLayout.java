package com.baidu.card.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.SimpleColorFilter;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.lv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes.dex */
public class RoundCornerFrameLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RectF a;
    public float[] b;
    public Paint c;
    public ImageView d;
    public Bitmap e;
    public int f;
    public ColorFilter g;
    public ColorFilter h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundCornerFrameLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new float[8];
        this.d = null;
        this.f = 3;
        b();
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && this.d != null && this.f != i) {
            this.f = i;
            this.g = new SimpleColorFilter(SkinManager.getColor(R.color.CAM_X0201));
            this.h = new SimpleColorFilter(SkinManager.getColor(R.color.CAM_X0205));
            this.d.setColorFilter(this.g);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new float[8];
        this.d = null;
        this.f = 3;
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.b = new float[8];
        this.d = null;
        this.f = 3;
        b();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && getMeasuredHeight() > 0 && getMeasuredWidth() > 0) {
            this.a.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
            try {
                this.e = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
            } catch (OutOfMemoryError e) {
                BdLog.e(e);
                System.gc();
                TbadkCoreApplication.getInst().onLowMemory();
                try {
                    this.e = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
                } catch (OutOfMemoryError unused) {
                    BdLog.e(e);
                    System.gc();
                    TbadkCoreApplication.getInst().onLowMemory();
                    return;
                }
            }
            Canvas canvas = new Canvas(this.e);
            canvas.drawColor(-16777216);
            this.c.setColor(-1);
            Path path = new Path();
            path.addRoundRect(this.a, this.b, Path.Direction.CW);
            canvas.drawPath(path, this.c);
            this.d.setImageBitmap(this.e);
            if (this.d.getParent() == null) {
                addView(this.d);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            super.addView(view2);
            ImageView imageView = this.d;
            if (imageView != null && view2 != imageView) {
                if (imageView.getParent() != null) {
                    ((ViewGroup) this.d.getParent()).removeView(this.d);
                }
                super.addView(this.d);
            }
        }
    }

    public void d(boolean z) {
        ImageView imageView;
        ColorFilter colorFilter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (imageView = this.d) != null) {
            if (z) {
                colorFilter = this.h;
            } else {
                colorFilter = this.g;
            }
            imageView.setColorFilter(colorFilter);
        }
    }

    public void setCorner(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f) == null) {
            Arrays.fill(this.b, f);
            Bitmap bitmap = this.e;
            if (bitmap != null) {
                bitmap.recycle();
                a();
            }
        }
    }

    public void setCornerId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.b = lv4.z(i);
            Bitmap bitmap = this.e;
            if (bitmap != null) {
                bitmap.recycle();
                a();
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setWillNotDraw(false);
            this.a = new RectF();
            this.b = lv4.z(R.string.J_X05);
            Paint paint = new Paint();
            this.c = paint;
            paint.setStrokeWidth(0.0f);
            this.c.setStrokeCap(Paint.Cap.ROUND);
            this.c.setAntiAlias(true);
            this.c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            ImageView imageView = new ImageView(getContext());
            this.d = imageView;
            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i, i2, i3, i4) == null) {
            if ((i != i3 || i2 != i4) && i > 0 && i2 > 0) {
                Bitmap bitmap = this.e;
                if (bitmap != null && !bitmap.isRecycled()) {
                    this.e.recycle();
                }
                a();
            }
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.removeAllViews();
            ImageView imageView = this.d;
            if (imageView != null) {
                if (imageView.getParent() != null) {
                    ((ViewGroup) this.d.getParent()).removeView(this.d);
                }
                super.addView(this.d);
            }
        }
    }
}
