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
import b.a.e0.b;
import b.a.e0.p.f;
import b.a.e0.r.g;
import b.a.e0.r.h;
import b.a.e0.r.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.poly.wallet.paychannel.IChannelAuth;
import com.baidu.poly.wallet.paychannel.IChannelPay;
import com.baidu.poly.widget.ChannelListView;
import com.baidu.poly.widget.CommonDialog;
import com.baidu.sapi2.activity.AuthWidgetForCashierActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
/* loaded from: classes7.dex */
public class PolyActivity extends Activity implements ChannelListView.m, b.a.e0.s.f.a {
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
    public static b.a.e0.s.g.c wechatSignAutoRenew;
    public transient /* synthetic */ FieldHolder $fh;
    public Bundle arguments;
    public ChannelListView mChannelListView;
    public b.a.e0.s.a mLaunchPaymentParamsCache;

    /* loaded from: classes7.dex */
    public class a extends CommonDialog.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PolyActivity f43001a;

        /* renamed from: com.baidu.poly.widget.PolyActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1687a implements CommonDialog.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f43002a;

            public C1687a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f43002a = aVar;
            }

            @Override // com.baidu.poly.widget.CommonDialog.f
            public void a(Dialog dialog) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialog) == null) {
                    dialog.dismiss();
                    if (this.f43002a.f43001a.mChannelListView != null) {
                        this.f43002a.f43001a.mChannelListView.resetPayStatus();
                        this.f43002a.f43001a.mChannelListView.onBackPressed();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43001a = polyActivity;
        }

        @Override // com.baidu.poly.widget.CommonDialog.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "我知道了" : (String) invokeV.objValue;
        }

        @Override // com.baidu.poly.widget.CommonDialog.e
        public CommonDialog.f b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new C1687a(this) : (CommonDialog.f) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CommonDialog.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PolyActivity f43003a;

        /* loaded from: classes7.dex */
        public class a implements CommonDialog.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f43004a;

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
                this.f43004a = bVar;
            }

            @Override // com.baidu.poly.widget.CommonDialog.f
            public void a(Dialog dialog) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialog) == null) {
                    dialog.dismiss();
                    if (this.f43004a.f43003a.mChannelListView != null) {
                        this.f43004a.f43003a.mChannelListView.resetPayStatus();
                        this.f43004a.f43003a.mChannelListView.onBackPressed();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43003a = polyActivity;
        }

        @Override // com.baidu.poly.widget.CommonDialog.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "取消" : (String) invokeV.objValue;
        }

        @Override // com.baidu.poly.widget.CommonDialog.e
        public CommonDialog.f b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this) : (CommonDialog.f) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CommonDialog.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.e0.s.a f43005a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PolyActivity f43006b;

        /* loaded from: classes7.dex */
        public class a implements CommonDialog.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f43007a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f43007a = cVar;
            }

            @Override // com.baidu.poly.widget.CommonDialog.f
            public void a(Dialog dialog) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialog) == null) {
                    c cVar = this.f43007a;
                    cVar.f43006b.jumpToPassAuthWidget(cVar.f43005a);
                    dialog.dismiss();
                }
            }
        }

        public c(PolyActivity polyActivity, b.a.e0.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {polyActivity, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43006b = polyActivity;
            this.f43005a = aVar;
        }

        @Override // com.baidu.poly.widget.CommonDialog.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "去验证" : (String) invokeV.objValue;
        }

        @Override // com.baidu.poly.widget.CommonDialog.e
        public CommonDialog.f b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this) : (CommonDialog.f) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CommonDialog.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PolyActivity f43008a;

        /* loaded from: classes7.dex */
        public class a implements CommonDialog.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f43009a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f43009a = dVar;
            }

            @Override // com.baidu.poly.widget.CommonDialog.f
            public void a(Dialog dialog) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialog) == null) {
                    dialog.dismiss();
                    if (this.f43009a.f43008a.mChannelListView != null) {
                        this.f43009a.f43008a.mChannelListView.resetPayStatus();
                        this.f43009a.f43008a.mChannelListView.onBackPressed();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43008a = polyActivity;
        }

        @Override // com.baidu.poly.widget.CommonDialog.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "取消" : (String) invokeV.objValue;
        }

        @Override // com.baidu.poly.widget.CommonDialog.e
        public CommonDialog.f b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this) : (CommonDialog.f) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CommonDialog.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PolyActivity f43010a;

        /* loaded from: classes7.dex */
        public class a implements CommonDialog.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f43011a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f43011a = eVar;
            }

            @Override // com.baidu.poly.widget.CommonDialog.f
            public void a(Dialog dialog) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialog) == null) {
                    PolyActivity polyActivity = this.f43011a.f43010a;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43010a = polyActivity;
        }

        @Override // com.baidu.poly.widget.CommonDialog.e
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "去验证" : (String) invokeV.objValue;
        }

        @Override // com.baidu.poly.widget.CommonDialog.e
        public CommonDialog.f b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this) : (CommonDialog.f) invokeV.objValue;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
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
            String a2 = b.a.e0.r.e.a(2, null, MSG_REPEAT_PAY);
            listener.a(2, a2);
            f.j(2, a2, "0");
        }
        currentActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToPassAuthWidget(b.a.e0.s.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, aVar) == null) {
            Intent a2 = g.a(this);
            if (a2 != null) {
                a2.putExtra("EXTRA_PARAM_AUTH_ID", aVar.f2698a.a("authId"));
                startActivityForResult(a2, 100);
                return;
            }
            ChannelListView channelListView = this.mChannelListView;
            if (channelListView != null) {
                channelListView.callPay(aVar);
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
                intent.addFlags(268435456);
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
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 != 200) {
                if (i2 == 100) {
                    int intExtra = intent.getIntExtra(AuthWidgetForCashierActivity.w, -1);
                    intent.getStringExtra(AuthWidgetForCashierActivity.x);
                    if (intExtra != 0) {
                        showAuthErrorDialog();
                        return;
                    }
                    ChannelListView channelListView = this.mChannelListView;
                    if (channelListView != null) {
                        channelListView.callPay(this.mLaunchPaymentParamsCache);
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
            if (i3 == -1) {
                b.a.e0.s.b.h().i(this, intent.getExtras(), this.mChannelListView, true);
                return;
            }
            ChannelListView channelListView2 = this.mChannelListView;
            if (channelListView2 != null) {
                channelListView2.payEnd(3, "pay canceled , back from H5. ", "1");
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
            if (!channelListView.onBackPressed()) {
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
            b.a.e0.s.d dVar = new b.a.e0.s.d(new b.a.e0.s.c(this, channelPay), this);
            dVar.s(wechatSignAutoRenew);
            this.mChannelListView.setWalletList(dVar);
            String string = this.arguments.getString(CHOSEN_CHANNEL_KEY);
            String string2 = this.arguments.getString(PANEL_TYPE_KEY);
            String string3 = this.arguments.getString(TRADE_TYPE);
            h.g("onWindowFocusChanged panelType=" + string2 + ", tradeType=" + string3);
            if (TextUtils.equals(string2, "NONE") && TextUtils.equals(string3, DIRECT_PAY_TRADE_TYPE)) {
                b.a.e0.r.d.e(this.arguments);
                this.mChannelListView.directPay(k.b(this, this.arguments), string);
            } else if (TextUtils.equals(string2, "NONE") && !TextUtils.isEmpty(string)) {
                this.mChannelListView.startFastPay(k.b(this, this.arguments), string);
            } else {
                this.mChannelListView.requestChannelList(k.b(this, this.arguments));
                this.mChannelListView.showChannelBoard();
            }
        }
    }

    public void showAuthErrorDialog() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.mLaunchPaymentParamsCache == null) {
            return;
        }
        CommonDialog.d dVar = new CommonDialog.d();
        dVar.e("验证失败提示");
        dVar.c("身份证验证未通过，请通过验证后再继续支付");
        dVar.b(new d(this), new e(this));
        CommonDialog a2 = dVar.a(this);
        a2.setCancelable(false);
        a2.show();
    }

    @Override // b.a.e0.s.f.a
    public void showBlockDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            CommonDialog.d dVar = new CommonDialog.d();
            dVar.e("账号风险提示");
            dVar.c("当前帐号存在比较高的风险，无法完成本次支付");
            dVar.d(new a(this));
            CommonDialog a2 = dVar.a(this);
            a2.setCancelable(false);
            a2.show();
        }
    }

    @Override // b.a.e0.s.f.a
    public void showNeedAuthDialog(b.a.e0.s.a aVar) {
        b.a.e0.l.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) || this.mChannelListView == null || aVar == null || (cVar = aVar.f2698a) == null) {
            return;
        }
        if (TextUtils.isEmpty(cVar.a("authId"))) {
            this.mChannelListView.callPay(aVar);
        } else if (g.a(this) == null) {
            this.mChannelListView.callPay(aVar);
        } else {
            this.mLaunchPaymentParamsCache = aVar;
            CommonDialog.d dVar = new CommonDialog.d();
            dVar.e("账号风险提示");
            dVar.c("当前账号存在风险，请完成本人身份验证后继续支付");
            dVar.b(new b(this), new c(this, aVar));
            CommonDialog a2 = dVar.a(this);
            a2.setCancelable(false);
            a2.show();
        }
    }

    public static void startPay(Context context, IChannelPay iChannelPay, IChannelAuth iChannelAuth, b.a.e0.s.g.c cVar, b.c cVar2, Bundle bundle) {
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
            b.a.e0.n.a.a().c((Activity) context);
            startPay(context, iChannelPay, cVar, bundle);
        }
    }
}
