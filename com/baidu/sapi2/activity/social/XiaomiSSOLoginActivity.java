package com.baidu.sapi2.activity.social;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.account.openauth.XiaomiOAuthFuture;
import com.xiaomi.account.openauth.XiaomiOAuthResults;
import com.xiaomi.account.openauth.XiaomiOAuthorize;
/* loaded from: classes7.dex */
public class XiaomiSSOLoginActivity extends BaseSSOLoginActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Thread n;
    public boolean o;
    public c p;

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ XiaomiOAuthFuture f42560a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ XiaomiSSOLoginActivity f42561b;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f42562a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f42562a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f42562a.f42561b.p.a();
                }
            }
        }

        /* renamed from: com.baidu.sapi2.activity.social.XiaomiSSOLoginActivity$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1657b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f42563a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f42564b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f42565c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ b f42566d;

            public RunnableC1657b(b bVar, String str, String str2, String str3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str, str2, str3};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f42566d = bVar;
                this.f42563a = str;
                this.f42564b = str2;
                this.f42565c = str3;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f42566d.f42561b.p.a(this.f42563a, this.f42564b, this.f42565c);
                }
            }
        }

        public b(XiaomiSSOLoginActivity xiaomiSSOLoginActivity, XiaomiOAuthFuture xiaomiOAuthFuture) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xiaomiSSOLoginActivity, xiaomiOAuthFuture};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42561b = xiaomiSSOLoginActivity;
            this.f42560a = xiaomiOAuthFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    XiaomiOAuthResults xiaomiOAuthResults = (XiaomiOAuthResults) this.f42560a.getResult();
                    if (xiaomiOAuthResults.hasError()) {
                        new Handler(Looper.getMainLooper()).post(new a(this));
                        return;
                    }
                    new Handler(Looper.getMainLooper()).post(new RunnableC1657b(this, xiaomiOAuthResults.getAccessToken(), xiaomiOAuthResults.getMacKey(), xiaomiOAuthResults.getMacAlgorithm()));
                } catch (Exception e2) {
                    Log.e(e2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a();

        void a(String str, String str2, String str3);
    }

    public XiaomiSSOLoginActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.finish();
            Thread thread = this.n;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.n.interrupt();
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setupViews();
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onResume();
            if (this.o) {
                this.p.a();
            }
            this.o = true;
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.setupViews();
            setTitleText(b.a.c0.a.j.a.sapi_sdk_title_login_xiaomi);
            RelativeLayout relativeLayout = this.rootView;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(4);
            }
            this.p = new a(this);
            d();
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            Thread thread = new Thread(new b(this, new XiaomiOAuthorize().setAppId(this.configuration.xiaomiAppID.longValue()).setUseSystemAccountLogin(true).setScope(new int[]{1, 3}).setRedirectUrl(this.configuration.xiaomiRedirectUri).startGetAccessToken(this)));
            this.n = thread;
            thread.start();
        }
    }

    /* loaded from: classes7.dex */
    public class a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ XiaomiSSOLoginActivity f42559a;

        public a(XiaomiSSOLoginActivity xiaomiSSOLoginActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xiaomiSSOLoginActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42559a = xiaomiSSOLoginActivity;
        }

        @Override // com.baidu.sapi2.activity.social.XiaomiSSOLoginActivity.c
        public void a(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3) == null) || this.f42559a.sapiWebView == null) {
                return;
            }
            SapiConfiguration sapiConfiguration = this.f42559a.configuration;
            SocialType socialType = SocialType.XIAOMI;
            this.f42559a.a(ParamsUtil.getUrlBind(sapiConfiguration, socialType, str, str2, this.f42559a.configuration.xiaomiAppID + ""), "小米授权登录中");
            this.f42559a.o = false;
        }

        @Override // com.baidu.sapi2.activity.social.XiaomiSSOLoginActivity.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                XiaomiSSOLoginActivity xiaomiSSOLoginActivity = this.f42559a;
                xiaomiSSOLoginActivity.a(((BaseSSOLoginActivity) xiaomiSSOLoginActivity).f42535g);
            }
        }
    }
}
