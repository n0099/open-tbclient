package com.baidu.swan.apps.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ListView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.rg1;
import com.repackage.yd3;
/* loaded from: classes2.dex */
public class SwanAppRoundCornerListView extends ListView {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public static final float g;
    public transient /* synthetic */ FieldHolder $fh;
    public final Path a;
    public final Paint b;
    public final RectF c;
    public float[] d;
    public PorterDuffXfermode e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1950675992, "Lcom/baidu/swan/apps/view/SwanAppRoundCornerListView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1950675992, "Lcom/baidu/swan/apps/view/SwanAppRoundCornerListView;");
                return;
            }
        }
        f = rg1.a;
        g = yd3.h(11.0f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppRoundCornerListView(Context context) {
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
        this.a = new Path();
        this.b = new Paint(1);
        this.c = new RectF();
        float f2 = g;
        this.d = new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            super.dispatchDraw(canvas);
            canvas.save();
            this.b.setColor(-1);
            this.b.setXfermode(this.e);
            canvas.drawPath(this.a, this.b);
            this.b.setXfermode(null);
            canvas.restore();
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            this.c.set(0.0f, 0.0f, i, i2 + 1);
            this.a.reset();
            this.a.addRoundRect(this.c, this.d, Path.Direction.CW);
            this.e = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        }
    }

    public void setListViewRadius(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            setListViewRadius(new float[]{f2, f2, f3, f3, f4, f4, f5, f5});
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public void setListViewRadius(@NonNull float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fArr) == null) {
            if (fArr.length < 8) {
                if (f) {
                    throw new IllegalStateException("radii[] needs 8 values");
                }
                return;
            }
            this.d = new float[8];
            for (int i = 0; i < 8; i++) {
                this.d[i] = fArr[i];
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppRoundCornerListView(Context context, AttributeSet attributeSet) {
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
        this.a = new Path();
        this.b = new Paint(1);
        this.c = new RectF();
        float f2 = g;
        this.d = new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppRoundCornerListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = new Path();
        this.b = new Paint(1);
        this.c = new RectF();
        float f2 = g;
        this.d = new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f};
    }
}
