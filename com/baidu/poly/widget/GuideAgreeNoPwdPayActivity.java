package com.baidu.poly.widget;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.appsearchlib.Info;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.poly.wallet.paychannel.IChannelAuth;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.h81;
import com.repackage.n91;
import com.repackage.p81;
import com.repackage.q91;
import com.repackage.xa1;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GuideAgreeNoPwdPayActivity extends Activity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static IChannelAuth j;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public int d;
    public View e;
    public View f;
    public View g;
    public ProgressButton h;
    public View i;

    /* loaded from: classes2.dex */
    public class a extends h81<JSONObject> {
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

        @Override // com.repackage.h81
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, th, str) == null) {
                this.a.finish();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.h81
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                if (jSONObject.optBoolean("needAgreementGuide")) {
                    this.a.n();
                } else {
                    this.a.finish();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends h81<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GuideAgreeNoPwdPayActivity a;

        /* loaded from: classes2.dex */
        public class a extends h81<JSONObject> {
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
            @Override // com.repackage.h81
            /* renamed from: d */
            public void c(JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                    this.a.a.m(jSONObject);
                    this.a.a.k();
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

        @Override // com.repackage.h81
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, th, str) == null) {
                this.a.h.c();
                this.a.h.setEnable(true);
                this.a.h.setPressed(false);
                xa1.f(this.a.getApplicationContext(), "服务异常，请稍后重试");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.h81
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                this.a.h.c();
                this.a.h.setEnable(true);
                this.a.h.setPressed(false);
                String optString = jSONObject.optString("payChannel");
                String optString2 = jSONObject.optString("signUrl");
                if (TextUtils.equals(optString, "BAIDU-ALIPAY-WISE") && !TextUtils.isEmpty(optString2)) {
                    GuideAgreeNoPwdPayActivity.j.aLiAuth(this.a, optString2, new a(this));
                } else {
                    xa1.f(this.a.getApplicationContext(), "服务异常，请稍后重试");
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
                this.a.e.setVisibility(8);
                this.a.f.setVisibility(0);
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

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            k();
            finish();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            xa1.e(this, R.drawable.obfuscated_res_0x7f080628, "加载中");
            p81.j().k(this.a, this.c, this.b, new a(this));
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.e = findViewById(R.id.obfuscated_res_0x7f0919d5);
            this.f = findViewById(R.id.obfuscated_res_0x7f0919d6);
            this.g = findViewById(R.id.obfuscated_res_0x7f0919c1);
            this.h = (ProgressButton) findViewById(R.id.obfuscated_res_0x7f09015b);
            this.i = findViewById(R.id.obfuscated_res_0x7f0919c9);
            this.h.setText("立即开启小额免密支付");
            this.g.setOnClickListener(this);
            this.h.setOnClickListener(this);
            this.i.setOnClickListener(this);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                ((ActivityManager) getSystemService("activity")).moveTaskToFront(this.d, 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void l(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) {
            xa1.e(this, R.drawable.obfuscated_res_0x7f080628, "加载中");
            p81.j().l(str, str2, str3, new b(this));
        }
    }

    public final void m(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            if (jSONObject != null && TextUtils.equals(jSONObject.optString("code"), "10000")) {
                q91.e(new n91("202"));
                runOnUiThread(new c(this));
            } else if (jSONObject != null && TextUtils.equals(jSONObject.optString("code"), "60001")) {
                q91.e(new n91("203"));
                h();
                xa1.f(this, "开通失败，请重试");
            } else {
                h();
                xa1.f(this, "网络异常，请重试");
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.e.setVisibility(0);
            this.f.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f0919c1) {
                finish();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09015b) {
                this.h.b();
                this.h.setEnable(false);
                this.h.setPressed(true);
                q91.e(new n91(Info.kBaiduPIDValue));
                l(this.a, this.c, this.b);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0919c9) {
                finish();
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0038);
            j();
            PolyActivity.g = null;
            Intent intent = getIntent();
            this.a = intent.getStringExtra("key_bduss");
            this.b = intent.getStringExtra("key_app_key");
            this.c = intent.getStringExtra("key_pay_channel");
            j = (IChannelAuth) intent.getSerializableExtra("key_auth_channel");
            this.d = intent.getIntExtra("key_invoker_task_id", -100);
            if (j == null) {
                finish();
                LogUtil.logActivity(this, "onCreate");
                return;
            }
            i();
            LogUtil.logActivity(this, "onCreate");
        }
    }
}
