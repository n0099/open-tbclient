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
import com.baidu.mobads.container.util.CommonUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class BDSplashActionView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f45084e;

    /* renamed from: f  reason: collision with root package name */
    public View f45085f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f45086g;

    /* renamed from: h  reason: collision with root package name */
    public int f45087h;

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f45088a;

        /* renamed from: b  reason: collision with root package name */
        public View.OnClickListener f45089b;

        /* renamed from: c  reason: collision with root package name */
        public int f45090c;

        /* renamed from: d  reason: collision with root package name */
        public int f45091d;

        /* renamed from: e  reason: collision with root package name */
        public int f45092e;

        /* renamed from: f  reason: collision with root package name */
        public int f45093f;

        /* renamed from: g  reason: collision with root package name */
        public int f45094g;

        /* renamed from: h  reason: collision with root package name */
        public Typeface f45095h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f45096i;

        /* renamed from: j  reason: collision with root package name */
        public int f45097j;

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
            this.f45088a = null;
            this.f45089b = null;
            this.f45090c = -16777216;
            this.f45091d = 102;
            this.f45092e = 1000;
            this.f45093f = 18;
            this.f45094g = -1;
            this.f45095h = Typeface.DEFAULT;
            this.f45096i = true;
            this.f45097j = 39;
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
                this.f45088a = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a m(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.f45097j = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a n(View.OnClickListener onClickListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, onClickListener)) == null) {
                this.f45089b = onClickListener;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a o(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.f45096i = z;
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
        this.f45084e = context;
        this.f45086g = aVar.f45096i;
        this.f45087h = aVar.f45097j;
        setBackgroundDrawable(a(aVar.f45090c, aVar.f45091d, aVar.f45092e));
        this.f45085f = c(this.f45084e, aVar);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.f45085f, layoutParams);
        setOnClickListener(aVar.f45089b);
    }

    public final GradientDrawable a(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(1048576, this, i2, i3, i4)) == null) ? b(i2, i3, i4, i4, i4, i4) : (GradientDrawable) invokeIII.objValue;
    }

    public void attachTo(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) {
            BaseActionLayout baseActionLayout = new BaseActionLayout(this.f45084e);
            viewGroup.addView(baseActionLayout, new ViewGroup.LayoutParams(-1, -1));
            int i2 = this.f45084e.getResources().getDisplayMetrics().widthPixels;
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
            if (this.f45086g) {
                layoutParams.bottomMargin = CommonUtils.dip2px(this.f45084e, this.f45087h);
            } else {
                layoutParams.bottomMargin = CommonUtils.dip2px(this.f45084e, this.f45087h);
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
            textView.setText(aVar.f45088a);
            textView.setTextSize(aVar.f45093f);
            textView.setTextColor(aVar.f45094g);
            textView.setTypeface(aVar.f45095h);
            textView.setIncludeFontPadding(false);
            TextView textView2 = new TextView(context);
            textView2.setText(">>");
            textView2.setTextColor(aVar.f45094g);
            textView2.setTextSize((int) (aVar.f45093f * 1.2d));
            textView2.setIncludeFontPadding(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            linearLayout.addView(textView, layoutParams);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = CommonUtils.dip2px(this.f45084e, 10.0f);
            layoutParams2.gravity = 16;
            linearLayout.addView(textView2, layoutParams2);
            return linearLayout;
        }
        return (LinearLayout) invokeLL.objValue;
    }
}
