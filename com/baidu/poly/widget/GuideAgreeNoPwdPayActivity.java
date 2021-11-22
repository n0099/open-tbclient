package com.baidu.poly.widget;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import b.a.e0.f;
import b.a.e0.g;
import b.a.e0.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.view.PayChannelController;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.poly.wallet.paychannel.IChannelAuth;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class GuideAgreeNoPwdPayActivity extends Activity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_APP_KEY = "key_app_key";
    public static final String KEY_AUTH_CHANNEL = "key_auth_channel";
    public static final String KEY_BDUSS = "key_bduss";
    public static final String KEY_INVOKER_TASK_ID = "key_invoker_task_id";
    public static final String KEY_PAY_CHANNEL = "key_pay_channel";
    public static IChannelAuth channelAuth;
    public transient /* synthetic */ FieldHolder $fh;
    public View agreeNoticeLayout;
    public View agreeResultLayout;
    public String appKey;
    public String bduss;
    public View closeNoticeBtn;
    public ProgressButton gotoAgreeBtn;
    public int invokerTaskId;
    public String payChannel;
    public View resultKnownBtn;

    /* loaded from: classes7.dex */
    public class a extends b.a.e0.l.a<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GuideAgreeNoPwdPayActivity f42981a;

        public a(GuideAgreeNoPwdPayActivity guideAgreeNoPwdPayActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guideAgreeNoPwdPayActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42981a = guideAgreeNoPwdPayActivity;
        }

        @Override // b.a.e0.l.a
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, th, str) == null) {
                this.f42981a.finish();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e0.l.a
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                if (jSONObject.optBoolean("needAgreementGuide")) {
                    this.f42981a.showGuideAgreeNoPwdPayNotice();
                } else {
                    this.f42981a.finish();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends b.a.e0.l.a<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GuideAgreeNoPwdPayActivity f42982a;

        /* loaded from: classes7.dex */
        public class a extends b.a.e0.l.a<JSONObject> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f42983a;

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
                this.f42983a = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.e0.l.a
            /* renamed from: d */
            public void c(JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                    this.f42983a.f42982a.processNoPwdAgreeResult(jSONObject);
                    this.f42983a.f42982a.moveInvokerTaskToFront();
                }
            }
        }

        public b(GuideAgreeNoPwdPayActivity guideAgreeNoPwdPayActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guideAgreeNoPwdPayActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42982a = guideAgreeNoPwdPayActivity;
        }

        @Override // b.a.e0.l.a
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, th, str) == null) {
                this.f42982a.gotoAgreeBtn.stopLoading();
                this.f42982a.gotoAgreeBtn.setEnable(true);
                this.f42982a.gotoAgreeBtn.setPressed(false);
                b.a.e0.t.e.b.f(this.f42982a.getApplicationContext(), "服务异常，请稍后重试");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e0.l.a
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                this.f42982a.gotoAgreeBtn.stopLoading();
                this.f42982a.gotoAgreeBtn.setEnable(true);
                this.f42982a.gotoAgreeBtn.setPressed(false);
                String optString = jSONObject.optString("payChannel");
                String optString2 = jSONObject.optString("signUrl");
                if (TextUtils.equals(optString, PayChannelController.ALIPAY_PAYCHANNEL) && !TextUtils.isEmpty(optString2)) {
                    GuideAgreeNoPwdPayActivity.channelAuth.aLiAuth(this.f42982a, optString2, new a(this));
                } else {
                    b.a.e0.t.e.b.f(this.f42982a.getApplicationContext(), "服务异常，请稍后重试");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GuideAgreeNoPwdPayActivity f42984e;

        public c(GuideAgreeNoPwdPayActivity guideAgreeNoPwdPayActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guideAgreeNoPwdPayActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42984e = guideAgreeNoPwdPayActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f42984e.agreeNoticeLayout.setVisibility(8);
                this.f42984e.agreeResultLayout.setVisibility(0);
            }
        }
    }

    public GuideAgreeNoPwdPayActivity() {
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

    private void checkNeedAgreeNoPwdPay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            b.a.e0.t.e.b.e(this, f.ic_loading_4_toast, "加载中");
            b.a.e0.l.h.b.j().k(this.bduss, this.payChannel, this.appKey, new a(this));
        }
    }

    private void initViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.agreeNoticeLayout = findViewById(g.poly_sdk_layout_agree_notice);
            this.agreeResultLayout = findViewById(g.poly_sdk_layout_agree_result);
            this.closeNoticeBtn = findViewById(g.poly_guide_agree_no_pwd_close);
            this.gotoAgreeBtn = (ProgressButton) findViewById(g.agree_no_pwd_pay_btn);
            this.resultKnownBtn = findViewById(g.poly_notice_known_single_btn);
            this.gotoAgreeBtn.setText("立即开启小额免密支付");
            this.closeNoticeBtn.setOnClickListener(this);
            this.gotoAgreeBtn.setOnClickListener(this);
            this.resultKnownBtn.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveInvokerTaskToFront() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            try {
                ((ActivityManager) getSystemService("activity")).moveTaskToFront(this.invokerTaskId, 1);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void processIsNeedAgreementGuide(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, this, str, str2, str3) == null) {
            b.a.e0.t.e.b.e(this, f.ic_loading_4_toast, "加载中");
            b.a.e0.l.h.b.j().l(str, str2, str3, new b(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processNoPwdAgreeResult(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, jSONObject) == null) {
            if (jSONObject != null && TextUtils.equals(jSONObject.optString("code"), "10000")) {
                b.a.e0.p.f.e(new b.a.e0.p.c(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE202));
                runOnUiThread(new c(this));
            } else if (jSONObject != null && TextUtils.equals(jSONObject.optString("code"), "60001")) {
                b.a.e0.p.f.e(new b.a.e0.p.c(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE203));
                authEnd();
                b.a.e0.t.e.b.f(this, "开通失败，请重试");
            } else {
                authEnd();
                b.a.e0.t.e.b.f(this, "网络异常，请重试");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showGuideAgreeNoPwdPayNotice() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.agreeNoticeLayout.setVisibility(0);
            this.agreeResultLayout.setVisibility(8);
        }
    }

    public void authEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            moveInvokerTaskToFront();
            finish();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            if (view.getId() == g.poly_guide_agree_no_pwd_close) {
                finish();
            } else if (view.getId() == g.agree_no_pwd_pay_btn) {
                this.gotoAgreeBtn.startLoading();
                this.gotoAgreeBtn.setEnable(false);
                this.gotoAgreeBtn.setPressed(true);
                b.a.e0.p.f.e(new b.a.e0.p.c("201"));
                processIsNeedAgreementGuide(this.bduss, this.payChannel, this.appKey);
            } else if (view.getId() == g.poly_notice_known_single_btn) {
                finish();
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(h.activity_guide_agree_no_pwd_pay);
            initViews();
            PolyActivity.invokerActivity = null;
            Intent intent = getIntent();
            this.bduss = intent.getStringExtra(KEY_BDUSS);
            this.appKey = intent.getStringExtra(KEY_APP_KEY);
            this.payChannel = intent.getStringExtra(KEY_PAY_CHANNEL);
            channelAuth = (IChannelAuth) intent.getSerializableExtra(KEY_AUTH_CHANNEL);
            this.invokerTaskId = intent.getIntExtra(KEY_INVOKER_TASK_ID, -100);
            if (channelAuth == null) {
                finish();
                LogUtil.logActivity(this, "onCreate");
                return;
            }
            checkNeedAgreeNoPwdPay();
            LogUtil.logActivity(this, "onCreate");
        }
    }
}
