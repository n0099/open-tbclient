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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.u.a;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class RoundCornerFrameLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RectF f4573e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f4574f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f4575g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f4576h;

    /* renamed from: i  reason: collision with root package name */
    public Bitmap f4577i;
    public int j;
    public ColorFilter k;
    public ColorFilter l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundCornerFrameLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f4574f = new float[8];
        this.f4576h = null;
        this.j = 3;
        b();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || getMeasuredHeight() <= 0 || getMeasuredWidth() <= 0) {
            return;
        }
        this.f4573e.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        try {
            this.f4577i = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
        } catch (OutOfMemoryError e2) {
            BdLog.e(e2);
            System.gc();
            TbadkCoreApplication.getInst().onLowMemory();
            try {
                this.f4577i = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
            } catch (OutOfMemoryError unused) {
                BdLog.e(e2);
                System.gc();
                TbadkCoreApplication.getInst().onLowMemory();
                return;
            }
        }
        Canvas canvas = new Canvas(this.f4577i);
        canvas.drawColor(-16777216);
        this.f4575g.setColor(-1);
        Path path = new Path();
        path.addRoundRect(this.f4573e, this.f4574f, Path.Direction.CW);
        canvas.drawPath(path, this.f4575g);
        this.f4576h.setImageBitmap(this.f4577i);
        if (this.f4576h.getParent() == null) {
            addView(this.f4576h);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            super.addView(view);
            ImageView imageView = this.f4576h;
            if (imageView == null || view == imageView) {
                return;
            }
            if (imageView.getParent() != null) {
                ((ViewGroup) this.f4576h.getParent()).removeView(this.f4576h);
            }
            super.addView(this.f4576h);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setWillNotDraw(false);
            this.f4573e = new RectF();
            this.f4574f = a.w(R.string.J_X05);
            Paint paint = new Paint();
            this.f4575g = paint;
            paint.setStrokeWidth(0.0f);
            this.f4575g.setStrokeCap(Paint.Cap.ROUND);
            this.f4575g.setAntiAlias(true);
            this.f4575g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            ImageView imageView = new ImageView(getContext());
            this.f4576h = imageView;
            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.f4576h == null || this.j == i2) {
            return;
        }
        this.j = i2;
        this.k = new SimpleColorFilter(SkinManager.getColor(R.color.CAM_X0201));
        this.l = new SimpleColorFilter(SkinManager.getColor(R.color.CAM_X0205));
        this.f4576h.setColorFilter(this.k);
    }

    public void d(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (imageView = this.f4576h) == null) {
            return;
        }
        imageView.setColorFilter(z ? this.l : this.k);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i2, i3, i4, i5) == null) {
            if (!(i2 == i4 && i3 == i5) && i2 > 0 && i3 > 0) {
                Bitmap bitmap = this.f4577i;
                if (bitmap != null && !bitmap.isRecycled()) {
                    this.f4577i.recycle();
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
            ImageView imageView = this.f4576h;
            if (imageView != null) {
                if (imageView.getParent() != null) {
                    ((ViewGroup) this.f4576h.getParent()).removeView(this.f4576h);
                }
                super.addView(this.f4576h);
            }
        }
    }

    public void setCorner(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
            Arrays.fill(this.f4574f, f2);
            Bitmap bitmap = this.f4577i;
            if (bitmap != null) {
                bitmap.recycle();
                a();
            }
        }
    }

    public void setCornerId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f4574f = a.w(i2);
            Bitmap bitmap = this.f4577i;
            if (bitmap != null) {
                bitmap.recycle();
                a();
            }
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f4574f = new float[8];
        this.f4576h = null;
        this.j = 3;
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i2) {
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
        this.f4574f = new float[8];
        this.f4576h = null;
        this.j = 3;
        b();
    }
}
