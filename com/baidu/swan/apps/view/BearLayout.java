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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.view.SimpleDraweeView;
import com.repackage.ef3;
import com.repackage.rg1;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes2.dex */
public class BearLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public SimpleDraweeView b;
    public BdBaseImageView c;
    public FrameLayout d;
    public TextView e;
    public BdBaseImageView f;
    public boolean g;
    public d h;
    public Context i;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppBearInfo a;
        public final /* synthetic */ BearLayout b;

        public a(BearLayout bearLayout, SwanAppBearInfo swanAppBearInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bearLayout, swanAppBearInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bearLayout;
            this.a = swanAppBearInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.j(this.a.bearHomeUrl);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ef3 a;
        public final /* synthetic */ SwanAppBearInfo b;
        public final /* synthetic */ BearLayout c;

        public b(BearLayout bearLayout, ef3 ef3Var, SwanAppBearInfo swanAppBearInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bearLayout, ef3Var, swanAppBearInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = bearLayout;
            this.a = ef3Var;
            this.b = swanAppBearInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!this.c.g) {
                    this.c.l();
                    this.a.b();
                    return;
                }
                this.c.j(this.b.bearHomeUrl);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BearLayout a;

        public c(BearLayout bearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bearLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bearLayout;
        }

        @Override // com.baidu.swan.apps.view.BearLayout.d
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.g = z;
                if (this.a.f == null || this.a.e == null) {
                    return;
                }
                this.a.f.clearAnimation();
                this.a.f.setVisibility(4);
                this.a.e.setVisibility(0);
                TextView textView = this.a.e;
                BearLayout bearLayout = this.a;
                textView.setText(z ? bearLayout.i.getText(R.string.obfuscated_res_0x7f0f0111) : bearLayout.i.getText(R.string.obfuscated_res_0x7f0f015c));
                this.a.e.setTextColor(z ? -16777216 : -1);
                this.a.d.setBackgroundResource(z ? R.drawable.obfuscated_res_0x7f080129 : R.drawable.obfuscated_res_0x7f08012a);
            }
        }

        @Override // com.baidu.swan.apps.view.BearLayout.d
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (BearLayout.j) {
                    Log.d("BearLayout", str);
                }
                if (this.a.f == null || this.a.e == null) {
                    return;
                }
                this.a.f.clearAnimation();
                this.a.f.setVisibility(4);
                this.a.e.setVisibility(0);
            }
        }
    }

    /* loaded from: classes2.dex */
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
        j = rg1.a;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = false;
    }

    private void setVipLogo(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, this, str) == null) || this.c == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.c.setVisibility(8);
            return;
        }
        int i = R.drawable.obfuscated_res_0x7f08015f;
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
            i = R.drawable.obfuscated_res_0x7f08015e;
        } else if (c2 == 2) {
            i = R.drawable.obfuscated_res_0x7f080160;
        } else if (c2 == 3) {
            i = R.drawable.obfuscated_res_0x7f08015d;
        }
        this.c.setVisibility(0);
        this.c.setImageDrawable(this.i.getResources().getDrawable(i));
    }

    public d getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.h : (d) invokeV.objValue;
    }

    @SuppressLint({"BDOfflineUrl"})
    public final void j(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            try {
                str2 = URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                if (j) {
                    e.printStackTrace();
                }
                str2 = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            SchemeRouter.invoke(getContext(), "baiduboxapp://v1/easybrowse/open?url=" + str + "&newbrowser=1&forbidautorotate=1");
        }
    }

    public void k(@NonNull Context context, @NonNull SwanAppBearInfo swanAppBearInfo, ef3 ef3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, swanAppBearInfo, ef3Var) == null) {
            this.i = context;
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0094, this);
            linearLayout.setOnClickListener(new a(this, swanAppBearInfo));
            TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090351);
            this.a = textView;
            textView.setText(swanAppBearInfo.bearName);
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090350);
            this.b = simpleDraweeView;
            simpleDraweeView.setImageURI(swanAppBearInfo.bearLogo);
            this.c = (BdBaseImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090352);
            setVipLogo(swanAppBearInfo.bearVipType);
            this.d = (FrameLayout) linearLayout.findViewById(R.id.obfuscated_res_0x7f09034b);
            TextView textView2 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f09034c);
            this.e = textView2;
            textView2.setOnClickListener(new b(this, ef3Var, swanAppBearInfo));
            BdBaseImageView bdBaseImageView = (BdBaseImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f09034f);
            this.f = bdBaseImageView;
            bdBaseImageView.setVisibility(8);
            this.h = new c(this);
        }
    }

    public final void l() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f == null || (textView = this.e) == null) {
            return;
        }
        textView.setVisibility(4);
        this.f.setVisibility(0);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setDuration(1000L);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        this.f.startAnimation(rotateAnimation);
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
        this.g = false;
    }
}
