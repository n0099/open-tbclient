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
import c.a.c0.d0.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class BDSplashActionView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f39561e;

    /* renamed from: f  reason: collision with root package name */
    public View f39562f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f39563g;

    /* renamed from: h  reason: collision with root package name */
    public int f39564h;

    /* loaded from: classes10.dex */
    public static class BaseActionLayout extends RelativeLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseActionLayout(Context context) {
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
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public View.OnClickListener f39565b;

        /* renamed from: c  reason: collision with root package name */
        public int f39566c;

        /* renamed from: d  reason: collision with root package name */
        public int f39567d;

        /* renamed from: e  reason: collision with root package name */
        public int f39568e;

        /* renamed from: f  reason: collision with root package name */
        public int f39569f;

        /* renamed from: g  reason: collision with root package name */
        public int f39570g;

        /* renamed from: h  reason: collision with root package name */
        public Typeface f39571h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f39572i;

        /* renamed from: j  reason: collision with root package name */
        public int f39573j;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.f39565b = null;
            this.f39566c = -16777216;
            this.f39567d = 102;
            this.f39568e = 1000;
            this.f39569f = 18;
            this.f39570g = -1;
            this.f39571h = Typeface.DEFAULT;
            this.f39572i = true;
            this.f39573j = 39;
        }

        public BDSplashActionView k(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? new BDSplashActionView(context, this) : (BDSplashActionView) invokeL.objValue;
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

        public a m(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.f39573j = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a n(View.OnClickListener onClickListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, onClickListener)) == null) {
                this.f39565b = onClickListener;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a o(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.f39572i = z;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f39561e = context;
        this.f39563g = aVar.f39572i;
        this.f39564h = aVar.f39573j;
        setBackgroundDrawable(a(aVar.f39566c, aVar.f39567d, aVar.f39568e));
        this.f39562f = c(this.f39561e, aVar);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.f39562f, layoutParams);
        setOnClickListener(aVar.f39565b);
    }

    public final GradientDrawable a(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(1048576, this, i2, i3, i4)) == null) ? b(i2, i3, i4, i4, i4, i4) : (GradientDrawable) invokeIII.objValue;
    }

    public void attachTo(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) {
            BaseActionLayout baseActionLayout = new BaseActionLayout(this.f39561e);
            viewGroup.addView(baseActionLayout, new ViewGroup.LayoutParams(-1, -1));
            int i2 = this.f39561e.getResources().getDisplayMetrics().widthPixels;
            if (viewGroup.getMeasuredWidth() != 0) {
                i2 = viewGroup.getMeasuredWidth();
            }
            double d2 = i2;
            int i3 = (int) (0.7d * d2);
            int i4 = (int) (d2 * 0.15d);
            if (i3 == 0) {
                i3 = -2;
            }
            if (i4 == 0) {
                i4 = -2;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i4);
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            if (this.f39563g) {
                layoutParams.bottomMargin = f.c.a(this.f39561e, this.f39564h);
            } else {
                layoutParams.bottomMargin = f.c.a(this.f39561e, this.f39564h);
            }
            baseActionLayout.addView(this, layoutParams);
        }
    }

    public final GradientDrawable b(int i2, int i3, int i4, int i5, int i6, int i7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)})) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            try {
                gradientDrawable.setAlpha(i3);
                gradientDrawable.setColor(i2);
                float f2 = i4;
                float f3 = i5;
                float f4 = i6;
                float f5 = i7;
                gradientDrawable.setCornerRadii(new float[]{f2, f2, f3, f3, f4, f4, f5, f5});
            } catch (Throwable unused) {
            }
            return gradientDrawable;
        }
        return (GradientDrawable) invokeCommon.objValue;
    }

    public final LinearLayout c(Context context, a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, aVar)) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            TextView textView = new TextView(context);
            textView.setText(aVar.a);
            textView.setTextSize(aVar.f39569f);
            textView.setTextColor(aVar.f39570g);
            textView.setTypeface(aVar.f39571h);
            textView.setIncludeFontPadding(false);
            TextView textView2 = new TextView(context);
            textView2.setText(">>");
            textView2.setTextColor(aVar.f39570g);
            textView2.setTextSize((int) (aVar.f39569f * 1.2d));
            textView2.setIncludeFontPadding(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            linearLayout.addView(textView, layoutParams);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = f.c.a(this.f39561e, 10.0f);
            layoutParams2.gravity = 16;
            linearLayout.addView(textView2, layoutParams2);
            return linearLayout;
        }
        return (LinearLayout) invokeLL.objValue;
    }
}
