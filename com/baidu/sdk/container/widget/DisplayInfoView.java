package com.baidu.sdk.container.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class DisplayInfoView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public double f10164e;

    /* renamed from: f  reason: collision with root package name */
    public double f10165f;

    /* renamed from: g  reason: collision with root package name */
    public int f10166g;

    /* renamed from: h  reason: collision with root package name */
    public String f10167h;

    /* renamed from: i  reason: collision with root package name */
    public String f10168i;
    public final Context j;
    public d k;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DisplayInfoView f10169e;

        public a(DisplayInfoView displayInfoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {displayInfoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10169e = displayInfoView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f10169e.k == null) {
                return;
            }
            this.f10169e.k.onPrivacyClick();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DisplayInfoView f10170e;

        public b(DisplayInfoView displayInfoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {displayInfoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10170e = displayInfoView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f10170e.k == null) {
                return;
            }
            this.f10170e.k.onPermissionClick();
        }
    }

    /* loaded from: classes3.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public DisplayInfoView f10171a;

        public c(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10171a = new DisplayInfoView(context, null);
        }

        public c a(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                String str3 = "版本 " + str;
                if (str.indexOf("版本") == -1) {
                    str = str3;
                }
                this.f10171a.f10168i = str;
                this.f10171a.f10167h = str2;
                return this;
            }
            return (c) invokeLL.objValue;
        }

        public c b(d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar)) == null) {
                this.f10171a.k = dVar;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.f10171a.f10166g = i2;
                return this;
            }
            return (c) invokeI.objValue;
        }

        public DisplayInfoView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f10171a : (DisplayInfoView) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void onPermissionClick();

        void onPrivacyClick();
    }

    public /* synthetic */ DisplayInfoView(Context context, a aVar) {
        this(context);
    }

    public final TextView f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            TextView textView = new TextView(this.j);
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            textView.setText(str);
            textView.setTextColor(this.f10166g);
            textView.setTextSize(1, (int) ((this.f10164e * displayMetrics.widthPixels) / displayMetrics.density));
            addView(textView, g(this.f10165f));
            return textView;
        }
        return (TextView) invokeL.objValue;
    }

    public final LinearLayout.LayoutParams g(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d2)})) == null) {
            int i2 = (int) (d2 * getResources().getDisplayMetrics().widthPixels);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i2, 0, i2, 0);
            layoutParams.gravity = 17;
            return layoutParams;
        }
        return (LinearLayout.LayoutParams) invokeCommon.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            f(this.f10168i);
            f(this.f10167h);
            f(com.baidu.mobads.container.widget.DisplayInfoView.PRI_TEXT).setOnClickListener(new a(this));
            f(com.baidu.mobads.container.widget.DisplayInfoView.AUTH_TEXT).setOnClickListener(new b(this));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onAttachedToWindow();
            h();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisplayInfoView(Context context) {
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
        this.f10164e = 0.027777777777777776d;
        this.f10165f = 0.0196078431372549d;
        this.f10166g = -1728053248;
        setOrientation(0);
        this.j = context;
        removeAllViews();
    }
}
