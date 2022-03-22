package com.baidu.poly.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import androidx.core.view.InputDeviceCompat;
import c.a.e0.b;
import c.a.e0.g.f;
import c.a.e0.i.g;
import c.a.e0.i.h;
import c.a.e0.i.k;
import c.a.e0.k.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.poly.wallet.paychannel.IChannelAuth;
import com.baidu.poly.wallet.paychannel.IChannelPay;
import com.baidu.poly.widget.ChannelListView;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.activity.AuthWidgetForCashierActivity;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
/* loaded from: classes4.dex */
public class PolyActivity extends Activity implements ChannelListView.m, c.a.e0.j.f.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AUTH_WIDGET_REQUEST_CODE = 100;
    public static final String CHOSEN_CHANNEL_KEY = "chosenChannel";
    public static final String DIRECT_PAY_TRADE_TYPE = "DIRECTPAY";
    public static final String EXTRA_PARAM_AUTH_ID = "EXTRA_PARAM_AUTH_ID";
    public static final String FULL_PANEL_TYPE = "FULL";
    public static final String HALF_PANEL_TYPE = "HALF";
    public static final String MSG_REPEAT_PAY = "repeat_pay_cancel";
    public static final String NONE_PANEL_TYPE = "NONE";
    public static final String PANEL_TYPE_KEY = "panelType";
    public static final String PAY_ARGUEMENTS = "pay_arguements";
    public static final int PAY_H5_WEB_REQUEST_CODE = 200;
    public static final String TRADE_TYPE = "tradeType";
    public static IChannelAuth channelAuth;
    public static IChannelPay channelPay;
    public static PolyActivity currentActivity;
    public static Activity invokerActivity;
    public static boolean isCashing;
    public static b.c listener;
    public static c.a.e0.j.g.c wechatSignAutoRenew;
    public transient /* synthetic */ FieldHolder $fh;
    public Bundle arguments;
    public ChannelListView mChannelListView;
    public c.a.e0.j.a mLaunchPaymentParamsCache;

    /* loaded from: classes4.dex */
    public class a extends b.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PolyActivity a;

        /* renamed from: com.baidu.poly.widget.PolyActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1780a implements b.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C1780a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // c.a.e0.k.b.f
            public void a(Dialog dialog) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialog) == null) {
                    dialog.dismiss();
                    if (this.a.a.mChannelListView != null) {
                        this.a.a.mChannelListView.j0();
                        this.a.a.mChannelListView.X();
                    }
                }
            }
        }

        public a(PolyActivity polyActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {polyActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = polyActivity;
        }

        @Override // c.a.e0.k.b.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "我知道了" : (String) invokeV.objValue;
        }

        @Override // c.a.e0.k.b.e
        public b.f b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new C1780a(this) : (b.f) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends b.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PolyActivity a;

        /* loaded from: classes4.dex */
        public class a implements b.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // c.a.e0.k.b.f
            public void a(Dialog dialog) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialog) == null) {
                    dialog.dismiss();
                    if (this.a.a.mChannelListView != null) {
                        this.a.a.mChannelListView.j0();
                        this.a.a.mChannelListView.X();
                    }
                }
            }
        }

        public b(PolyActivity polyActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {polyActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = polyActivity;
        }

        @Override // c.a.e0.k.b.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_CANCEL : (String) invokeV.objValue;
        }

        @Override // c.a.e0.k.b.e
        public b.f b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this) : (b.f) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends b.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.e0.j.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PolyActivity f28244b;

        /* loaded from: classes4.dex */
        public class a implements b.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // c.a.e0.k.b.f
            public void a(Dialog dialog) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialog) == null) {
                    c cVar = this.a;
                    cVar.f28244b.jumpToPassAuthWidget(cVar.a);
                    dialog.dismiss();
                }
            }
        }

        public c(PolyActivity polyActivity, c.a.e0.j.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {polyActivity, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28244b = polyActivity;
            this.a = aVar;
        }

        @Override // c.a.e0.k.b.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "去验证" : (String) invokeV.objValue;
        }

        @Override // c.a.e0.k.b.e
        public b.f b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this) : (b.f) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d extends b.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PolyActivity a;

        /* loaded from: classes4.dex */
        public class a implements b.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // c.a.e0.k.b.f
            public void a(Dialog dialog) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialog) == null) {
                    dialog.dismiss();
                    if (this.a.a.mChannelListView != null) {
                        this.a.a.mChannelListView.j0();
                        this.a.a.mChannelListView.X();
                    }
                }
            }
        }

        public d(PolyActivity polyActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {polyActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = polyActivity;
        }

        @Override // c.a.e0.k.b.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_CANCEL : (String) invokeV.objValue;
        }

        @Override // c.a.e0.k.b.e
        public b.f b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this) : (b.f) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e extends b.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PolyActivity a;

        /* loaded from: classes4.dex */
        public class a implements b.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // c.a.e0.k.b.f
            public void a(Dialog dialog) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialog) == null) {
                    PolyActivity polyActivity = this.a.a;
                    polyActivity.jumpToPassAuthWidget(polyActivity.mLaunchPaymentParamsCache);
                    dialog.dismiss();
                }
            }
        }

        public e(PolyActivity polyActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {polyActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = polyActivity;
        }

        @Override // c.a.e0.k.b.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "去验证" : (String) invokeV.objValue;
        }

        @Override // c.a.e0.k.b.e
        public b.f b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this) : (b.f) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1779253494, "Lcom/baidu/poly/widget/PolyActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1779253494, "Lcom/baidu/poly/widget/PolyActivity;");
        }
    }

    public PolyActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.mChannelListView = null;
            channelPay = null;
            this.arguments = null;
            listener = null;
            isCashing = false;
            currentActivity = null;
        }
    }

    private String getVersionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            try {
                return getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static void handleRepeatPay() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, null) == null) || currentActivity == null) {
            return;
        }
        if (listener != null) {
            String a2 = c.a.e0.i.e.a(2, null, MSG_REPEAT_PAY);
            listener.a(2, a2);
            f.j(2, a2, "0");
        }
        currentActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToPassAuthWidget(c.a.e0.j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, aVar) == null) {
            Intent a2 = g.a(this);
            if (a2 != null) {
                a2.putExtra("EXTRA_PARAM_AUTH_ID", aVar.a.a("authId"));
                startActivityForResult(a2, 100);
                return;
            }
            ChannelListView channelListView = this.mChannelListView;
            if (channelListView != null) {
                channelListView.L(aVar);
            }
        }
    }

    private void obtainPayParams() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.arguments = getIntent().getBundleExtra(PAY_ARGUEMENTS);
        }
    }

    private void setImmersive() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        Window window = getWindow();
        window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        window.getDecorView().setSystemUiVisibility(1024);
    }

    public static void startPay(Context context, IChannelPay iChannelPay, b.c cVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65547, null, context, iChannelPay, cVar, bundle) == null) {
            if (isCashing) {
                handleRepeatPay();
            }
            channelPay = iChannelPay;
            listener = cVar;
            Intent intent = new Intent(context, PolyActivity.class);
            intent.putExtra(PAY_ARGUEMENTS, bundle);
            if (!(context instanceof Activity)) {
                h.g("!context instanceof Activity");
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            context.startActivity(intent);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.finish();
            overridePendingTransition(0, 0);
            clear();
            f.f();
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i != 200) {
                if (i == 100) {
                    int intExtra = intent.getIntExtra(AuthWidgetForCashierActivity.w, -1);
                    intent.getStringExtra(AuthWidgetForCashierActivity.x);
                    if (intExtra != 0) {
                        showAuthErrorDialog();
                        return;
                    }
                    ChannelListView channelListView = this.mChannelListView;
                    if (channelListView != null) {
                        channelListView.L(this.mLaunchPaymentParamsCache);
                        return;
                    }
                    return;
                }
                return;
            }
            Bundle bundle = this.arguments;
            boolean z = false;
            if (bundle != null) {
                String string = bundle.getString(PANEL_TYPE_KEY);
                String string2 = this.arguments.getString(TRADE_TYPE);
                if (TextUtils.equals(string, "NONE") && TextUtils.equals(string2, DIRECT_PAY_TRADE_TYPE)) {
                    z = true;
                }
            }
            if (z) {
                return;
            }
            if (i2 == -1) {
                c.a.e0.j.b.h().i(this, intent.getExtras(), this.mChannelListView, true);
                return;
            }
            ChannelListView channelListView2 = this.mChannelListView;
            if (channelListView2 != null) {
                channelListView2.a0(3, "pay canceled , back from H5. ", "1");
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ChannelListView channelListView = this.mChannelListView;
            if (channelListView == null) {
                super.onBackPressed();
                return;
            }
            if (!channelListView.X()) {
                super.onBackPressed();
            }
            h.g("PolyActivity onBackPressed");
        }
    }

    @Override // com.baidu.poly.widget.ChannelListView.m
    public void onClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            setImmersive();
            isCashing = true;
            currentActivity = this;
            f.k();
            super.onCreate(bundle);
            overridePendingTransition(0, 0);
            obtainPayParams();
            h.g("PolyActivity onCreate");
            LogUtil.logActivity(this, "onCreate");
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            clear();
            super.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onPause();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onStop();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (!z || this.mChannelListView != null || isFinishing() || this.arguments == null) {
                return;
            }
            ChannelListView channelListView = new ChannelListView(this);
            this.mChannelListView = channelListView;
            setContentView(channelListView);
            this.mChannelListView.setResultListener(listener);
            this.mChannelListView.setCloseListener(this);
            this.mChannelListView.setChannelAuth(channelAuth);
            c.a.e0.j.d dVar = new c.a.e0.j.d(new c.a.e0.j.c(this, channelPay), this);
            dVar.s(wechatSignAutoRenew);
            this.mChannelListView.setWalletList(dVar);
            String string = this.arguments.getString(CHOSEN_CHANNEL_KEY);
            String string2 = this.arguments.getString(PANEL_TYPE_KEY);
            String string3 = this.arguments.getString(TRADE_TYPE);
            h.g("onWindowFocusChanged panelType=" + string2 + ", tradeType=" + string3);
            if (TextUtils.equals(string2, "NONE") && TextUtils.equals(string3, DIRECT_PAY_TRADE_TYPE)) {
                c.a.e0.i.d.e(this.arguments);
                this.mChannelListView.Q(k.b(this, this.arguments), string);
            } else if (TextUtils.equals(string2, "NONE") && !TextUtils.isEmpty(string)) {
                this.mChannelListView.p0(k.b(this, this.arguments), string);
            } else {
                this.mChannelListView.i0(k.b(this, this.arguments));
                this.mChannelListView.k0();
            }
        }
    }

    public void showAuthErrorDialog() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.mLaunchPaymentParamsCache == null) {
            return;
        }
        b.d dVar = new b.d();
        dVar.e("验证失败提示");
        dVar.c("身份证验证未通过，请通过验证后再继续支付");
        dVar.b(new d(this), new e(this));
        c.a.e0.k.b a2 = dVar.a(this);
        a2.setCancelable(false);
        a2.show();
    }

    @Override // c.a.e0.j.f.a
    public void showBlockDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            b.d dVar = new b.d();
            dVar.e("账号风险提示");
            dVar.c("当前帐号存在比较高的风险，无法完成本次支付");
            dVar.d(new a(this));
            c.a.e0.k.b a2 = dVar.a(this);
            a2.setCancelable(false);
            a2.show();
        }
    }

    @Override // c.a.e0.j.f.a
    public void showNeedAuthDialog(c.a.e0.j.a aVar) {
        c.a.e0.c.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) || this.mChannelListView == null || aVar == null || (cVar = aVar.a) == null) {
            return;
        }
        if (TextUtils.isEmpty(cVar.a("authId"))) {
            this.mChannelListView.L(aVar);
        } else if (g.a(this) == null) {
            this.mChannelListView.L(aVar);
        } else {
            this.mLaunchPaymentParamsCache = aVar;
            b.d dVar = new b.d();
            dVar.e("账号风险提示");
            dVar.c("当前账号存在风险，请完成本人身份验证后继续支付");
            dVar.b(new b(this), new c(this, aVar));
            c.a.e0.k.b a2 = dVar.a(this);
            a2.setCancelable(false);
            a2.show();
        }
    }

    public static void startPay(Context context, IChannelPay iChannelPay, IChannelAuth iChannelAuth, c.a.e0.j.g.c cVar, b.c cVar2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{context, iChannelPay, iChannelAuth, cVar, cVar2, bundle}) == null) {
            wechatSignAutoRenew = cVar;
            startPay(context, iChannelPay, iChannelAuth, cVar2, bundle);
        }
    }

    public static void startPay(Context context, IChannelPay iChannelPay, IChannelAuth iChannelAuth, b.c cVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65548, null, context, iChannelPay, iChannelAuth, cVar, bundle) == null) {
            channelAuth = iChannelAuth;
            if (context instanceof Activity) {
                invokerActivity = (Activity) context;
            }
            c.a.e0.e.a.a().c((Activity) context);
            startPay(context, iChannelPay, cVar, bundle);
        }
    }
}
