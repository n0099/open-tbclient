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
import c.a.b0.h0.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class BDSplashActionView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f36910e;

    /* renamed from: f  reason: collision with root package name */
    public View f36911f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36912g;

    /* renamed from: h  reason: collision with root package name */
    public int f36913h;

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public View.OnClickListener f36914b;

        /* renamed from: c  reason: collision with root package name */
        public int f36915c;

        /* renamed from: d  reason: collision with root package name */
        public int f36916d;

        /* renamed from: e  reason: collision with root package name */
        public int f36917e;

        /* renamed from: f  reason: collision with root package name */
        public int f36918f;

        /* renamed from: g  reason: collision with root package name */
        public int f36919g;

        /* renamed from: h  reason: collision with root package name */
        public Typeface f36920h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f36921i;

        /* renamed from: j  reason: collision with root package name */
        public int f36922j;

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
            this.f36914b = null;
            this.f36915c = -16777216;
            this.f36916d = 102;
            this.f36917e = 1000;
            this.f36918f = 18;
            this.f36919g = -1;
            this.f36920h = Typeface.DEFAULT;
            this.f36921i = true;
            this.f36922j = 39;
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
                this.f36922j = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a n(View.OnClickListener onClickListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, onClickListener)) == null) {
                this.f36914b = onClickListener;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a o(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.f36921i = z;
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
        this.f36910e = context;
        this.f36912g = aVar.f36921i;
        this.f36913h = aVar.f36922j;
        setBackgroundDrawable(a(aVar.f36915c, aVar.f36916d, aVar.f36917e));
        this.f36911f = c(this.f36910e, aVar);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.f36911f, layoutParams);
        setOnClickListener(aVar.f36914b);
    }

    public final GradientDrawable a(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(1048576, this, i2, i3, i4)) == null) ? b(i2, i3, i4, i4, i4, i4) : (GradientDrawable) invokeIII.objValue;
    }

    public void attachTo(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) {
            BaseActionLayout baseActionLayout = new BaseActionLayout(this.f36910e);
            viewGroup.addView(baseActionLayout, new ViewGroup.LayoutParams(-1, -1));
            int i2 = this.f36910e.getResources().getDisplayMetrics().widthPixels;
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
            if (this.f36912g) {
                layoutParams.bottomMargin = f.c.a(this.f36910e, this.f36913h);
            } else {
                layoutParams.bottomMargin = f.c.a(this.f36910e, this.f36913h);
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
            textView.setTextSize(aVar.f36918f);
            textView.setTextColor(aVar.f36919g);
            textView.setTypeface(aVar.f36920h);
            textView.setIncludeFontPadding(false);
            TextView textView2 = new TextView(context);
            textView2.setText(">>");
            textView2.setTextColor(aVar.f36919g);
            textView2.setTextSize((int) (aVar.f36918f * 1.2d));
            textView2.setIncludeFontPadding(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            linearLayout.addView(textView, layoutParams);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = f.c.a(this.f36910e, 10.0f);
            layoutParams2.gravity = 16;
            linearLayout.addView(textView2, layoutParams2);
            return linearLayout;
        }
        return (LinearLayout) invokeLL.objValue;
    }
}
