package com.baidu.swan.apps.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.view.SimpleDraweeView;
import d.a.o0.a.e;
import d.a.o0.a.f;
import d.a.o0.a.g;
import d.a.o0.a.h;
import d.a.o0.a.k;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes3.dex */
public class BearLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f11567e;

    /* renamed from: f  reason: collision with root package name */
    public SimpleDraweeView f11568f;

    /* renamed from: g  reason: collision with root package name */
    public BdBaseImageView f11569g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f11570h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f11571i;
    public BdBaseImageView j;
    public boolean k;
    public d l;
    public Context m;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBearInfo f11572e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ BearLayout f11573f;

        public a(BearLayout bearLayout, SwanAppBearInfo swanAppBearInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bearLayout, swanAppBearInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11573f = bearLayout;
            this.f11572e = swanAppBearInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f11573f.j(this.f11572e.bearHomeUrl);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.w2.a f11574e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppBearInfo f11575f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ BearLayout f11576g;

        public b(BearLayout bearLayout, d.a.o0.a.w2.a aVar, SwanAppBearInfo swanAppBearInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bearLayout, aVar, swanAppBearInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11576g = bearLayout;
            this.f11574e = aVar;
            this.f11575f = swanAppBearInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!this.f11576g.k) {
                    this.f11576g.l();
                    this.f11574e.b();
                    return;
                }
                this.f11576g.j(this.f11575f.bearHomeUrl);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BearLayout f11577a;

        public c(BearLayout bearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bearLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11577a = bearLayout;
        }

        @Override // com.baidu.swan.apps.view.BearLayout.d
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f11577a.k = z;
                if (this.f11577a.j == null || this.f11577a.f11571i == null) {
                    return;
                }
                this.f11577a.j.clearAnimation();
                this.f11577a.j.setVisibility(4);
                this.f11577a.f11571i.setVisibility(0);
                TextView textView = this.f11577a.f11571i;
                BearLayout bearLayout = this.f11577a;
                textView.setText(z ? bearLayout.m.getText(h.aiapps_check_action_text) : bearLayout.m.getText(h.aiapps_follow_action_text));
                this.f11577a.f11571i.setTextColor(z ? -16777216 : -1);
                this.f11577a.f11570h.setBackgroundResource(z ? e.aiapps_bear_paw_enter_btn : e.aiapps_bear_paw_follow_btn);
            }
        }

        @Override // com.baidu.swan.apps.view.BearLayout.d
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (BearLayout.n) {
                    Log.d("BearLayout", str);
                }
                if (this.f11577a.j == null || this.f11577a.f11571i == null) {
                    return;
                }
                this.f11577a.j.clearAnimation();
                this.f11577a.j.setVisibility(4);
                this.f11577a.f11571i.setVisibility(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(boolean z);

        void b(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-349108992, "Lcom/baidu/swan/apps/view/BearLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-349108992, "Lcom/baidu/swan/apps/view/BearLayout;");
                return;
            }
        }
        n = k.f46335a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BearLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.k = false;
    }

    private void setVipLogo(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, this, str) == null) || this.f11569g == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.f11569g.setVisibility(8);
            return;
        }
        int i2 = e.aiapps_follow_vip_golden;
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 1567) {
            switch (hashCode) {
                case 49:
                    if (str.equals("1")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 50:
                    if (str.equals("2")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 51:
                    if (str.equals("3")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
        } else if (str.equals("10")) {
            c2 = 3;
        }
        if (c2 == 1) {
            i2 = e.aiapps_follow_vip_blue;
        } else if (c2 == 2) {
            i2 = e.aiapps_follow_vip_yellow;
        } else if (c2 == 3) {
            i2 = e.aiapps_follow_vip_authentication;
        }
        this.f11569g.setVisibility(0);
        this.f11569g.setImageDrawable(this.m.getResources().getDrawable(i2));
    }

    public d getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.l : (d) invokeV.objValue;
    }

    @SuppressLint({"BDOfflineUrl"})
    public final void j(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            try {
                str2 = URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                if (n) {
                    e2.printStackTrace();
                }
                str2 = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            SchemeRouter.invoke(getContext(), "baiduboxapp://v1/easybrowse/open?url=" + str + "&newbrowser=1&forbidautorotate=1");
        }
    }

    public void k(@NonNull Context context, @NonNull SwanAppBearInfo swanAppBearInfo, d.a.o0.a.w2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, swanAppBearInfo, aVar) == null) {
            this.m = context;
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(g.aiapps_bear_layout, this);
            linearLayout.setOnClickListener(new a(this, swanAppBearInfo));
            TextView textView = (TextView) linearLayout.findViewById(f.bear_account_name);
            this.f11567e = textView;
            textView.setText(swanAppBearInfo.bearName);
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(f.bear_account_logo);
            this.f11568f = simpleDraweeView;
            simpleDraweeView.setImageURI(swanAppBearInfo.bearLogo);
            this.f11569g = (BdBaseImageView) linearLayout.findViewById(f.bear_account_vip_logo);
            setVipLogo(swanAppBearInfo.bearVipType);
            this.f11570h = (FrameLayout) linearLayout.findViewById(f.bear_account_follow_background);
            TextView textView2 = (TextView) linearLayout.findViewById(f.bear_account_follow_btn);
            this.f11571i = textView2;
            textView2.setOnClickListener(new b(this, aVar, swanAppBearInfo));
            BdBaseImageView bdBaseImageView = (BdBaseImageView) linearLayout.findViewById(f.bear_account_loading_progress);
            this.j = bdBaseImageView;
            bdBaseImageView.setVisibility(8);
            this.l = new c(this);
        }
    }

    public final void l() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.j == null || (textView = this.f11571i) == null) {
            return;
        }
        textView.setVisibility(4);
        this.j.setVisibility(0);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setDuration(1000L);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        this.j.startAnimation(rotateAnimation);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.k = false;
    }
}
