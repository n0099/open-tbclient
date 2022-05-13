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
import com.repackage.ba1;
import com.repackage.ca1;
import com.repackage.d81;
import com.repackage.da1;
import com.repackage.e91;
import com.repackage.ea1;
import com.repackage.g81;
import com.repackage.ha1;
import com.repackage.ka1;
import com.repackage.ma1;
import com.repackage.n91;
import com.repackage.s91;
import com.repackage.t91;
import com.repackage.v91;
import com.repackage.w91;
import com.repackage.z91;
/* loaded from: classes2.dex */
public class PolyActivity extends Activity implements ChannelListView.m, ha1 {
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
    public static d81.c listener;
    public static ka1 wechatSignAutoRenew;
    public transient /* synthetic */ FieldHolder $fh;
    public Bundle arguments;
    public ChannelListView mChannelListView;
    public ba1 mLaunchPaymentParamsCache;

    /* loaded from: classes2.dex */
    public class a extends ma1.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PolyActivity a;

        /* renamed from: com.baidu.poly.widget.PolyActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0121a implements ma1.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0121a(a aVar) {
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

            @Override // com.repackage.ma1.f
            public void a(Dialog dialog) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialog) == null) {
                    dialog.dismiss();
                    if (this.a.a.mChannelListView != null) {
                        this.a.a.mChannelListView.k0();
                        this.a.a.mChannelListView.Y();
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

        @Override // com.repackage.ma1.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "我知道了" : (String) invokeV.objValue;
        }

        @Override // com.repackage.ma1.e
        public ma1.f b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new C0121a(this) : (ma1.f) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b extends ma1.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PolyActivity a;

        /* loaded from: classes2.dex */
        public class a implements ma1.f {
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

            @Override // com.repackage.ma1.f
            public void a(Dialog dialog) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialog) == null) {
                    dialog.dismiss();
                    if (this.a.a.mChannelListView != null) {
                        this.a.a.mChannelListView.k0();
                        this.a.a.mChannelListView.Y();
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

        @Override // com.repackage.ma1.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_CANCEL : (String) invokeV.objValue;
        }

        @Override // com.repackage.ma1.e
        public ma1.f b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this) : (ma1.f) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class c extends ma1.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba1 a;
        public final /* synthetic */ PolyActivity b;

        /* loaded from: classes2.dex */
        public class a implements ma1.f {
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

            @Override // com.repackage.ma1.f
            public void a(Dialog dialog) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialog) == null) {
                    c cVar = this.a;
                    cVar.b.jumpToPassAuthWidget(cVar.a);
                    dialog.dismiss();
                }
            }
        }

        public c(PolyActivity polyActivity, ba1 ba1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {polyActivity, ba1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = polyActivity;
            this.a = ba1Var;
        }

        @Override // com.repackage.ma1.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "去验证" : (String) invokeV.objValue;
        }

        @Override // com.repackage.ma1.e
        public ma1.f b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this) : (ma1.f) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class d extends ma1.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PolyActivity a;

        /* loaded from: classes2.dex */
        public class a implements ma1.f {
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

            @Override // com.repackage.ma1.f
            public void a(Dialog dialog) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialog) == null) {
                    dialog.dismiss();
                    if (this.a.a.mChannelListView != null) {
                        this.a.a.mChannelListView.k0();
                        this.a.a.mChannelListView.Y();
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

        @Override // com.repackage.ma1.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_CANCEL : (String) invokeV.objValue;
        }

        @Override // com.repackage.ma1.e
        public ma1.f b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this) : (ma1.f) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class e extends ma1.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PolyActivity a;

        /* loaded from: classes2.dex */
        public class a implements ma1.f {
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

            @Override // com.repackage.ma1.f
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

        @Override // com.repackage.ma1.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "去验证" : (String) invokeV.objValue;
        }

        @Override // com.repackage.ma1.e
        public ma1.f b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this) : (ma1.f) invokeV.objValue;
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
            String a2 = t91.a(2, null, MSG_REPEAT_PAY);
            listener.a(2, a2);
            n91.j(2, a2, "0");
        }
        currentActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToPassAuthWidget(ba1 ba1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, ba1Var) == null) {
            Intent a2 = v91.a(this);
            if (a2 != null) {
                a2.putExtra("EXTRA_PARAM_AUTH_ID", ba1Var.a.a("authId"));
                startActivityForResult(a2, 100);
                return;
            }
            ChannelListView channelListView = this.mChannelListView;
            if (channelListView != null) {
                channelListView.M(ba1Var);
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

    public static void startPay(Context context, IChannelPay iChannelPay, d81.c cVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65549, null, context, iChannelPay, cVar, bundle) == null) {
            if (isCashing) {
                handleRepeatPay();
            }
            channelPay = iChannelPay;
            listener = cVar;
            Intent intent = new Intent(context, PolyActivity.class);
            intent.putExtra(PAY_ARGUEMENTS, bundle);
            if (!(context instanceof Activity)) {
                w91.g("!context instanceof Activity");
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
            n91.f();
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
                        channelListView.M(this.mLaunchPaymentParamsCache);
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
                ca1.h().i(this, intent.getExtras(), this.mChannelListView, true);
                return;
            }
            ChannelListView channelListView2 = this.mChannelListView;
            if (channelListView2 != null) {
                channelListView2.b0(3, "pay canceled , back from H5. ", "1");
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
            if (!channelListView.Y()) {
                super.onBackPressed();
            }
            w91.g("PolyActivity onBackPressed");
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
            n91.k();
            super.onCreate(bundle);
            overridePendingTransition(0, 0);
            obtainPayParams();
            w91.g("PolyActivity onCreate");
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
            ea1 ea1Var = new ea1(new da1(this, channelPay), this);
            ea1Var.s(wechatSignAutoRenew);
            this.mChannelListView.setWalletList(ea1Var);
            String string = this.arguments.getString(CHOSEN_CHANNEL_KEY);
            String string2 = this.arguments.getString(PANEL_TYPE_KEY);
            String string3 = this.arguments.getString(TRADE_TYPE);
            w91.g("onWindowFocusChanged panelType=" + string2 + ", tradeType=" + string3);
            if (TextUtils.equals(string2, "NONE") && TextUtils.equals(string3, DIRECT_PAY_TRADE_TYPE)) {
                s91.e(this.arguments);
                this.mChannelListView.R(z91.b(this, this.arguments), string);
            } else if (TextUtils.equals(string2, "NONE") && !TextUtils.isEmpty(string)) {
                this.mChannelListView.q0(z91.b(this, this.arguments), string);
            } else {
                this.mChannelListView.j0(z91.b(this, this.arguments));
                this.mChannelListView.l0();
            }
        }
    }

    public void showAuthErrorDialog() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.mLaunchPaymentParamsCache == null) {
            return;
        }
        ma1.d dVar = new ma1.d();
        dVar.e("验证失败提示");
        dVar.c("身份证验证未通过，请通过验证后再继续支付");
        dVar.b(new d(this), new e(this));
        ma1 a2 = dVar.a(this);
        a2.setCancelable(false);
        a2.show();
    }

    @Override // com.repackage.ha1
    public void showBlockDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ma1.d dVar = new ma1.d();
            dVar.e("账号风险提示");
            dVar.c("当前帐号存在比较高的风险，无法完成本次支付");
            dVar.d(new a(this));
            ma1 a2 = dVar.a(this);
            a2.setCancelable(false);
            a2.show();
        }
    }

    @Override // com.repackage.ha1
    public void showNeedAuthDialog(ba1 ba1Var) {
        g81 g81Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, ba1Var) == null) || this.mChannelListView == null || ba1Var == null || (g81Var = ba1Var.a) == null) {
            return;
        }
        if (TextUtils.isEmpty(g81Var.a("authId"))) {
            this.mChannelListView.M(ba1Var);
        } else if (v91.a(this) == null) {
            this.mChannelListView.M(ba1Var);
        } else {
            this.mLaunchPaymentParamsCache = ba1Var;
            ma1.d dVar = new ma1.d();
            dVar.e("账号风险提示");
            dVar.c("当前账号存在风险，请完成本人身份验证后继续支付");
            dVar.b(new b(this), new c(this, ba1Var));
            ma1 a2 = dVar.a(this);
            a2.setCancelable(false);
            a2.show();
        }
    }

    public static void startPay(Context context, IChannelPay iChannelPay, IChannelAuth iChannelAuth, ka1 ka1Var, d81.c cVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{context, iChannelPay, iChannelAuth, ka1Var, cVar, bundle}) == null) {
            wechatSignAutoRenew = ka1Var;
            startPay(context, iChannelPay, iChannelAuth, cVar, bundle);
        }
    }

    public static void startPay(Context context, IChannelPay iChannelPay, IChannelAuth iChannelAuth, d81.c cVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65547, null, context, iChannelPay, iChannelAuth, cVar, bundle) == null) {
            channelAuth = iChannelAuth;
            if (context instanceof Activity) {
                invokerActivity = (Activity) context;
            }
            e91.a().c((Activity) context);
            startPay(context, iChannelPay, cVar, bundle);
        }
    }
}
