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
import c.a.o0.r.v.a;
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
import java.util.Arrays;
/* loaded from: classes3.dex */
public class RoundCornerFrameLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RectF a;

    /* renamed from: b  reason: collision with root package name */
    public float[] f25181b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f25182c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f25183d;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f25184e;

    /* renamed from: f  reason: collision with root package name */
    public int f25185f;

    /* renamed from: g  reason: collision with root package name */
    public ColorFilter f25186g;

    /* renamed from: h  reason: collision with root package name */
    public ColorFilter f25187h;

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
        this.f25181b = new float[8];
        this.f25183d = null;
        this.f25185f = 3;
        b();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || getMeasuredHeight() <= 0 || getMeasuredWidth() <= 0) {
            return;
        }
        this.a.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        try {
            this.f25184e = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
        } catch (OutOfMemoryError e2) {
            BdLog.e(e2);
            System.gc();
            TbadkCoreApplication.getInst().onLowMemory();
            try {
                this.f25184e = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
            } catch (OutOfMemoryError unused) {
                BdLog.e(e2);
                System.gc();
                TbadkCoreApplication.getInst().onLowMemory();
                return;
            }
        }
        Canvas canvas = new Canvas(this.f25184e);
        canvas.drawColor(-16777216);
        this.f25182c.setColor(-1);
        Path path = new Path();
        path.addRoundRect(this.a, this.f25181b, Path.Direction.CW);
        canvas.drawPath(path, this.f25182c);
        this.f25183d.setImageBitmap(this.f25184e);
        if (this.f25183d.getParent() == null) {
            addView(this.f25183d);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            super.addView(view);
            ImageView imageView = this.f25183d;
            if (imageView == null || view == imageView) {
                return;
            }
            if (imageView.getParent() != null) {
                ((ViewGroup) this.f25183d.getParent()).removeView(this.f25183d);
            }
            super.addView(this.f25183d);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setWillNotDraw(false);
            this.a = new RectF();
            this.f25181b = a.y(R.string.J_X05);
            Paint paint = new Paint();
            this.f25182c = paint;
            paint.setStrokeWidth(0.0f);
            this.f25182c.setStrokeCap(Paint.Cap.ROUND);
            this.f25182c.setAntiAlias(true);
            this.f25182c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            ImageView imageView = new ImageView(getContext());
            this.f25183d = imageView;
            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || this.f25183d == null || this.f25185f == i) {
            return;
        }
        this.f25185f = i;
        this.f25186g = new SimpleColorFilter(SkinManager.getColor(R.color.CAM_X0201));
        this.f25187h = new SimpleColorFilter(SkinManager.getColor(R.color.CAM_X0205));
        this.f25183d.setColorFilter(this.f25186g);
    }

    public void d(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (imageView = this.f25183d) == null) {
            return;
        }
        imageView.setColorFilter(z ? this.f25187h : this.f25186g);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i, i2, i3, i4) == null) {
            if (!(i == i3 && i2 == i4) && i > 0 && i2 > 0) {
                Bitmap bitmap = this.f25184e;
                if (bitmap != null && !bitmap.isRecycled()) {
                    this.f25184e.recycle();
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
            ImageView imageView = this.f25183d;
            if (imageView != null) {
                if (imageView.getParent() != null) {
                    ((ViewGroup) this.f25183d.getParent()).removeView(this.f25183d);
                }
                super.addView(this.f25183d);
            }
        }
    }

    public void setCorner(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
            Arrays.fill(this.f25181b, f2);
            Bitmap bitmap = this.f25184e;
            if (bitmap != null) {
                bitmap.recycle();
                a();
            }
        }
    }

    public void setCornerId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.f25181b = a.y(i);
            Bitmap bitmap = this.f25184e;
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
        this.f25181b = new float[8];
        this.f25183d = null;
        this.f25185f = 3;
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
        this.f25181b = new float[8];
        this.f25183d = null;
        this.f25185f = 3;
        b();
    }
}
