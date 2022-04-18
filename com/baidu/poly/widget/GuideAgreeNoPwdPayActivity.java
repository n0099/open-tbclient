package com.baidu.poly.widget;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.appsearchlib.Info;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.poly.wallet.paychannel.IChannelAuth;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b81;
import com.repackage.c91;
import com.repackage.ja1;
import com.repackage.t71;
import com.repackage.z81;
import org.json.JSONObject;
/* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public class a extends t71<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GuideAgreeNoPwdPayActivity a;

        public a(GuideAgreeNoPwdPayActivity guideAgreeNoPwdPayActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guideAgreeNoPwdPayActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = guideAgreeNoPwdPayActivity;
        }

        @Override // com.repackage.t71
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, th, str) == null) {
                this.a.finish();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t71
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                if (jSONObject.optBoolean("needAgreementGuide")) {
                    this.a.showGuideAgreeNoPwdPayNotice();
                } else {
                    this.a.finish();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends t71<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GuideAgreeNoPwdPayActivity a;

        /* loaded from: classes2.dex */
        public class a extends t71<JSONObject> {
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

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.t71
            /* renamed from: d */
            public void c(JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                    this.a.a.processNoPwdAgreeResult(jSONObject);
                    this.a.a.moveInvokerTaskToFront();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = guideAgreeNoPwdPayActivity;
        }

        @Override // com.repackage.t71
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, th, str) == null) {
                this.a.gotoAgreeBtn.c();
                this.a.gotoAgreeBtn.setEnable(true);
                this.a.gotoAgreeBtn.setPressed(false);
                ja1.f(this.a.getApplicationContext(), "服务异常，请稍后重试");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t71
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                this.a.gotoAgreeBtn.c();
                this.a.gotoAgreeBtn.setEnable(true);
                this.a.gotoAgreeBtn.setPressed(false);
                String optString = jSONObject.optString("payChannel");
                String optString2 = jSONObject.optString("signUrl");
                if (TextUtils.equals(optString, "BAIDU-ALIPAY-WISE") && !TextUtils.isEmpty(optString2)) {
                    GuideAgreeNoPwdPayActivity.channelAuth.aLiAuth(this.a, optString2, new a(this));
                } else {
                    ja1.f(this.a.getApplicationContext(), "服务异常，请稍后重试");
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GuideAgreeNoPwdPayActivity a;

        public c(GuideAgreeNoPwdPayActivity guideAgreeNoPwdPayActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guideAgreeNoPwdPayActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = guideAgreeNoPwdPayActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.agreeNoticeLayout.setVisibility(8);
                this.a.agreeResultLayout.setVisibility(0);
            }
        }
    }

    public GuideAgreeNoPwdPayActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void checkNeedAgreeNoPwdPay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            ja1.e(this, R.drawable.obfuscated_res_0x7f080638, "加载中");
            b81.j().k(this.bduss, this.payChannel, this.appKey, new a(this));
        }
    }

    private void initViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.agreeNoticeLayout = findViewById(R.id.obfuscated_res_0x7f09187b);
            this.agreeResultLayout = findViewById(R.id.obfuscated_res_0x7f09187c);
            this.closeNoticeBtn = findViewById(R.id.obfuscated_res_0x7f091867);
            this.gotoAgreeBtn = (ProgressButton) findViewById(R.id.obfuscated_res_0x7f090161);
            this.resultKnownBtn = findViewById(R.id.obfuscated_res_0x7f09186f);
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void processIsNeedAgreementGuide(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, this, str, str2, str3) == null) {
            ja1.e(this, R.drawable.obfuscated_res_0x7f080638, "加载中");
            b81.j().l(str, str2, str3, new b(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processNoPwdAgreeResult(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, jSONObject) == null) {
            if (jSONObject != null && TextUtils.equals(jSONObject.optString("code"), "10000")) {
                c91.e(new z81("202"));
                runOnUiThread(new c(this));
            } else if (jSONObject != null && TextUtils.equals(jSONObject.optString("code"), "60001")) {
                c91.e(new z81("203"));
                authEnd();
                ja1.f(this, "开通失败，请重试");
            } else {
                authEnd();
                ja1.f(this, "网络异常，请重试");
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
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f091867) {
                finish();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090161) {
                this.gotoAgreeBtn.b();
                this.gotoAgreeBtn.setEnable(false);
                this.gotoAgreeBtn.setPressed(true);
                c91.e(new z81(Info.kBaiduPIDValue));
                processIsNeedAgreementGuide(this.bduss, this.payChannel, this.appKey);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09186f) {
                finish();
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d003a);
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
