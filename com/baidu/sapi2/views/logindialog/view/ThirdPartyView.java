package com.baidu.sapi2.views.logindialog.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.dto.WebSocialLoginDTO;
import com.baidu.sapi2.enums.LoginTypes;
import com.baidu.sapi2.shell.listener.ThirdLoginCallback;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.views.logindialog.QuickLoginDialog;
import com.baidu.sapi2.views.logindialog.bean.QuickLoginResult;
import com.baidu.sapi2.views.logindialog.enums.QuickLoginType;
import com.baidu.sapi2.views.logindialog.interf.ILoginConfirmCallback;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class ThirdPartyView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ImageView b;
    public ImageView c;
    public ImageView d;
    public ImageView e;
    public ImageView f;
    public ImageView g;
    public ImageView h;
    public ImageView i;
    public ImageView j;
    public LinearLayout k;
    public ILoginConfirmCallback l;
    public QuickLoginType m;
    public QuickLoginType n;

    /* loaded from: classes2.dex */
    public class a extends ThirdLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ ThirdPartyView b;

        public a(ThirdPartyView thirdPartyView, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {thirdPartyView, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = thirdPartyView;
            this.a = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webAuthResult) == null) {
                com.baidu.sapi2.views.logindialog.utils.a.a(this.b.m.getValue(), System.currentTimeMillis() - this.a, webAuthResult.getResultCode(), webAuthResult.getResultMsg());
                if (this.b.l == null) {
                    Log.e(QuickLoginDialog.STAG, "thirdlogin onFailure mWebAuthListener is null");
                    return;
                }
                QuickLoginResult quickLoginResult = new QuickLoginResult();
                quickLoginResult.setResultCode(webAuthResult.getResultCode());
                quickLoginResult.setResultMsg(webAuthResult.getResultMsg());
                quickLoginResult.mLoginType = this.b.m;
                this.b.l.onFailure(quickLoginResult);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, webAuthResult) == null) {
                com.baidu.sapi2.views.logindialog.utils.a.a(this.b.m.getValue(), System.currentTimeMillis() - this.a, webAuthResult.getResultCode(), webAuthResult.getResultMsg());
                if (this.b.l == null) {
                    Log.e(QuickLoginDialog.STAG, "thirdlogin onSuccess mWebAuthListener is null");
                    return;
                }
                QuickLoginResult quickLoginResult = new QuickLoginResult();
                quickLoginResult.setResultCode(webAuthResult.getResultCode());
                quickLoginResult.setResultMsg(webAuthResult.getResultMsg());
                quickLoginResult.mLoginType = this.b.m;
                this.b.l.onSuccess(quickLoginResult);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ ThirdPartyView b;

        public b(ThirdPartyView thirdPartyView, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {thirdPartyView, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = thirdPartyView;
            this.a = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webAuthResult) == null) {
                com.baidu.sapi2.views.logindialog.utils.a.a("more_login", System.currentTimeMillis() - this.a, webAuthResult.getResultCode(), webAuthResult.getResultMsg());
                if (this.b.l == null) {
                    Log.e(QuickLoginDialog.STAG, "otherlogin onSuccess mWebAuthListener is null");
                    return;
                }
                QuickLoginResult quickLoginResult = new QuickLoginResult();
                quickLoginResult.setResultCode(webAuthResult.getResultCode());
                quickLoginResult.setResultMsg(webAuthResult.getResultMsg());
                quickLoginResult.mLoginType = this.b.m;
                this.b.l.onFailure(quickLoginResult);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, webAuthResult) == null) {
                com.baidu.sapi2.views.logindialog.utils.a.a("more_login", System.currentTimeMillis() - this.a, webAuthResult.getResultCode(), webAuthResult.getResultMsg());
                if (this.b.l == null) {
                    Log.e(QuickLoginDialog.STAG, "otherlogin onSuccess mWebAuthListener is null");
                    return;
                }
                QuickLoginResult quickLoginResult = new QuickLoginResult();
                quickLoginResult.setResultCode(webAuthResult.getResultCode());
                quickLoginResult.setResultMsg(webAuthResult.getResultMsg());
                quickLoginResult.mLoginType = this.b.m;
                this.b.l.onSuccess(quickLoginResult);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class c {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1960555455, "Lcom/baidu/sapi2/views/logindialog/view/ThirdPartyView$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1960555455, "Lcom/baidu/sapi2/views/logindialog/view/ThirdPartyView$c;");
                    return;
                }
            }
            int[] iArr = new int[QuickLoginType.values().length];
            a = iArr;
            try {
                iArr[QuickLoginType.HISTORY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[QuickLoginType.SHARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[QuickLoginType.ONEKEY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ThirdPartyView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d04c7, this);
            this.b = (ImageView) findViewById(R.id.obfuscated_res_0x7f091cfb);
            this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f091cf9);
            this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f091cfa);
            this.e = (ImageView) findViewById(R.id.obfuscated_res_0x7f091cfd);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f091cf6);
            this.g = (ImageView) findViewById(R.id.obfuscated_res_0x7f091cf5);
            this.h = (ImageView) findViewById(R.id.obfuscated_res_0x7f091cfc);
            this.i = (ImageView) findViewById(R.id.obfuscated_res_0x7f091cf7);
            this.j = (ImageView) findViewById(R.id.obfuscated_res_0x7f091cf8);
            this.k = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091d01);
            this.b.setOnClickListener(this);
            this.c.setOnClickListener(this);
            this.d.setOnClickListener(this);
            this.e.setOnClickListener(this);
            this.f.setOnClickListener(this);
            this.g.setOnClickListener(this);
            this.h.setOnClickListener(this);
            this.i.setOnClickListener(this);
            this.j.setOnClickListener(this);
            List<FastLoginFeature> thirdPartyConfig = getThirdPartyConfig();
            int min = Math.min(thirdPartyConfig.size(), 5);
            for (int i = 0; i < min; i++) {
                FastLoginFeature fastLoginFeature = thirdPartyConfig.get(i);
                if (fastLoginFeature == FastLoginFeature.TX_WEIXIN_SSO) {
                    this.b.setVisibility(0);
                } else if (fastLoginFeature == FastLoginFeature.TX_QQ_SSO) {
                    this.c.setVisibility(0);
                } else if (fastLoginFeature == FastLoginFeature.SINA_WEIBO_SSO) {
                    this.d.setVisibility(0);
                } else if (fastLoginFeature == FastLoginFeature.YY_SSO) {
                    this.e.setVisibility(0);
                } else if (fastLoginFeature == FastLoginFeature.HUAWEI_LOGIN) {
                    this.f.setVisibility(0);
                } else if (fastLoginFeature == FastLoginFeature.XIAOMI_SSO) {
                    this.h.setVisibility(0);
                } else if (fastLoginFeature == FastLoginFeature.MEIZU_SSO) {
                    this.i.setVisibility(0);
                } else if (fastLoginFeature == FastLoginFeature.HONOR_LOGIN) {
                    this.g.setVisibility(0);
                }
            }
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            ILoginConfirmCallback iLoginConfirmCallback = this.l;
            if (iLoginConfirmCallback == null) {
                Log.e(QuickLoginDialog.STAG, "otherlogin mWebAuthListener is null");
            } else if (!iLoginConfirmCallback.onPreStart(false)) {
                Log.e(QuickLoginDialog.STAG, "otherlogin privacy is not agree");
            } else {
                WebLoginDTO webLoginDTO = new WebLoginDTO();
                webLoginDTO.config = null;
                QuickLoginType quickLoginType = this.n;
                if (quickLoginType != null) {
                    int i = c.a[quickLoginType.ordinal()];
                    if (i == 1) {
                        webLoginDTO.excludeTypes = LoginTypes.HISTORY;
                    } else if (i == 2) {
                        webLoginDTO.excludeTypes = LoginTypes.SHARE;
                    } else if (i == 3) {
                        webLoginDTO.excludeTypes = LoginTypes.ONE_KEY_LOGIN;
                    }
                }
                webLoginDTO.isAcceptBrowseModeAgreement = true;
                CoreViewRouter.getInstance().startLogin(new b(this, System.currentTimeMillis()), webLoginDTO);
            }
        }
    }

    private List<FastLoginFeature> getThirdPartyConfig() {
        InterceptResult invokeV;
        SapiConfiguration confignation;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            ArrayList arrayList = new ArrayList();
            SapiAccountManager sapiAccountManager = SapiAccountManager.getInstance();
            if (sapiAccountManager == null || (confignation = sapiAccountManager.getConfignation()) == null) {
                return arrayList;
            }
            arrayList.addAll(confignation.fastLoginFeatureList);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.k.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            WebSocialLoginDTO webSocialLoginDTO = new WebSocialLoginDTO();
            if (view2.getId() == R.id.obfuscated_res_0x7f091cfb) {
                this.m = QuickLoginType.WECHAT;
                webSocialLoginDTO.socialType = SocialType.WEIXIN;
                a(webSocialLoginDTO);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091cf9) {
                this.m = QuickLoginType.QQ;
                webSocialLoginDTO.socialType = SocialType.QQ_SSO;
                a(webSocialLoginDTO);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091cfd) {
                this.m = QuickLoginType.YY;
                webSocialLoginDTO.socialType = SocialType.YY;
                a(webSocialLoginDTO);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091cfa) {
                this.m = QuickLoginType.SINA;
                webSocialLoginDTO.socialType = SocialType.SINA_WEIBO_SSO;
                a(webSocialLoginDTO);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091cf6) {
                this.m = QuickLoginType.HUAWEI;
                webSocialLoginDTO.socialType = SocialType.HUAWEI;
                a(webSocialLoginDTO);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091cf5) {
                this.m = QuickLoginType.HONOR;
                webSocialLoginDTO.socialType = SocialType.HONOR;
                a(webSocialLoginDTO);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091cfc) {
                this.m = QuickLoginType.XIAOMI;
                webSocialLoginDTO.socialType = SocialType.XIAOMI;
                a(webSocialLoginDTO);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091cf7) {
                this.m = QuickLoginType.MEIZU;
                webSocialLoginDTO.socialType = SocialType.MEIZU;
                a(webSocialLoginDTO);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091cf8) {
                this.m = QuickLoginType.FULL_SCREEN;
                e();
            }
        }
    }

    public void setDialogLoginType(QuickLoginType quickLoginType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, quickLoginType) == null) {
            this.n = quickLoginType;
        }
    }

    public void setLoginCallback(ILoginConfirmCallback iLoginConfirmCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iLoginConfirmCallback) == null) {
            this.l = iLoginConfirmCallback;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ThirdPartyView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void a(WebSocialLoginDTO webSocialLoginDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, webSocialLoginDTO) == null) {
            ILoginConfirmCallback iLoginConfirmCallback = this.l;
            if (iLoginConfirmCallback == null) {
                Log.e(QuickLoginDialog.STAG, "thirdLogin mWebAuthListener is null");
            } else if (!iLoginConfirmCallback.onPreStart(false)) {
                Log.e(QuickLoginDialog.STAG, "thirdLogin privacy is not agree");
            } else {
                CoreViewRouter.getInstance().loadThirdPartyLogin(new a(this, System.currentTimeMillis()), webSocialLoginDTO);
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.k.setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThirdPartyView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.a = context;
        d();
    }
}
