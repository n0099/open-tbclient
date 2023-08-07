package com.baidu.sdk.container.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.h61;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class BDSplashActionView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public View b;
    public boolean c;
    public int d;

    /* loaded from: classes3.dex */
    public static class BaseActionLayout extends RelativeLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseActionLayout(Context context) {
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
        }
    }

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public View.OnClickListener b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public Typeface h;
        public boolean i;
        public int j;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.b = null;
            this.c = -16777216;
            this.d = 102;
            this.e = 1000;
            this.f = 18;
            this.g = -1;
            this.h = Typeface.DEFAULT;
            this.i = true;
            this.j = 39;
        }

        public BDSplashActionView k(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                return new BDSplashActionView(context, this);
            }
            return (BDSplashActionView) invokeL.objValue;
        }

        public a l(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.a = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a m(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                this.j = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a n(View.OnClickListener onClickListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, onClickListener)) == null) {
                this.b = onClickListener;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a o(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.i = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1463862365, "Lcom/baidu/sdk/container/widget/BDSplashActionView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1463862365, "Lcom/baidu/sdk/container/widget/BDSplashActionView;");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BDSplashActionView(Context context, a aVar) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar};
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
        this.a = context;
        this.c = aVar.i;
        this.d = aVar.j;
        setBackgroundDrawable(b(aVar.c, aVar.d, aVar.e));
        this.b = d(this.a, aVar);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.b, layoutParams);
        setOnClickListener(aVar.b);
    }

    public final LinearLayout d(Context context, a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, aVar)) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            TextView textView = new TextView(context);
            textView.setText(aVar.a);
            textView.setTextSize(aVar.f);
            textView.setTextColor(aVar.g);
            textView.setTypeface(aVar.h);
            textView.setIncludeFontPadding(false);
            TextView textView2 = new TextView(context);
            textView2.setText(">>");
            textView2.setTextColor(aVar.g);
            textView2.setTextSize((int) (aVar.f * 1.2d));
            textView2.setIncludeFontPadding(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            linearLayout.addView(textView, layoutParams);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = h61.c.a(this.a, 10.0f);
            layoutParams2.gravity = 16;
            linearLayout.addView(textView2, layoutParams2);
            return linearLayout;
        }
        return (LinearLayout) invokeLL.objValue;
    }

    public void a(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
            BaseActionLayout baseActionLayout = new BaseActionLayout(this.a);
            viewGroup.addView(baseActionLayout, new ViewGroup.LayoutParams(-1, -1));
            int i = this.a.getResources().getDisplayMetrics().widthPixels;
            if (viewGroup.getMeasuredWidth() != 0) {
                i = viewGroup.getMeasuredWidth();
            }
            double d = i;
            int i2 = (int) (0.7d * d);
            int i3 = (int) (d * 0.15d);
            if (i2 == 0) {
                i2 = -2;
            }
            if (i3 == 0) {
                i3 = -2;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i3);
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            if (this.c) {
                layoutParams.bottomMargin = h61.c.a(this.a, this.d);
            } else {
                layoutParams.bottomMargin = h61.c.a(this.a, this.d);
            }
            baseActionLayout.addView(this, layoutParams);
        }
    }

    public final GradientDrawable b(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3)) == null) {
            return c(i, i2, i3, i3, i3, i3);
        }
        return (GradientDrawable) invokeIII.objValue;
    }

    public final GradientDrawable c(int i, int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            try {
                gradientDrawable.setAlpha(i2);
                gradientDrawable.setColor(i);
                float f = i3;
                float f2 = i4;
                float f3 = i5;
                float f4 = i6;
                gradientDrawable.setCornerRadii(new float[]{f, f, f2, f2, f3, f3, f4, f4});
            } catch (Throwable unused) {
            }
            return gradientDrawable;
        }
        return (GradientDrawable) invokeCommon.objValue;
    }
}
