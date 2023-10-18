package com.baidu.poly.widget;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.bd1;
import com.baidu.tieba.nd1;
import com.baidu.tieba.xb1;
import com.baidu.tieba.zb1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
/* loaded from: classes3.dex */
public class WechatSignAutoRenewActivity extends Activity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static long k;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public View e;
    public ProgressButton f;
    public TextView g;
    public ProgressButton h;
    public View i;
    public int j;

    /* loaded from: classes3.dex */
    public class a implements bd1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ WechatSignAutoRenewActivity b;

        /* renamed from: com.baidu.poly.widget.WechatSignAutoRenewActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0131a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ a b;

            public RunnableC0131a(a aVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.b.f(this.a);
                }
            }
        }

        public a(WechatSignAutoRenewActivity wechatSignAutoRenewActivity, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wechatSignAutoRenewActivity, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wechatSignAutoRenewActivity;
            this.a = z;
        }

        @Override // com.baidu.tieba.bd1
        public void onResult(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                if (this.a) {
                    long currentTimeMillis = System.currentTimeMillis() - WechatSignAutoRenewActivity.k;
                    if (currentTimeMillis < 2000) {
                        new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0131a(this, i), 2000 - currentTimeMillis);
                        return;
                    } else {
                        this.b.f(i);
                        return;
                    }
                }
                this.b.f(i);
            }
        }
    }

    public WechatSignAutoRenewActivity() {
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

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                ((ActivityManager) getSystemService("activity")).moveTaskToFront(xb1.a().b(), 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            e();
        }
    }

    public final void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f.setEnable(false);
            this.f.setPressed(true);
            this.f.b();
            zb1.b().a(new a(this, z));
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d();
            zb1.b c = zb1.b().c();
            zb1.b().e(null);
            if (c != null) {
                int i = this.j;
                if (i == 0) {
                    c.onResult(0, EventAlias.PayEventAlias.PAY_SUCCESS);
                } else if (200 != i && 400 != i) {
                    c.onResult(3, EventAlias.PayEventAlias.PAY_FAIL);
                } else {
                    c.onResult(1, "支付中");
                }
            }
            finish();
        }
    }

    public final void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.j = i;
            this.f.setEnabled(true);
            this.f.setPressed(false);
            this.f.c();
            if (i == 0) {
                this.a.setImageResource(R.drawable.obfuscated_res_0x7f081591);
                this.b.setText(EventAlias.PayEventAlias.PAY_SUCCESS);
                this.c.setVisibility(8);
                this.d.setVisibility(0);
                this.d.setText("你已开通自动续费。请稍后留意微信支付扣款信息，你可以在微信APP “我-支付-右上角更多-扣费服务”中管理自动续费服务。");
                this.e.setVisibility(8);
                this.h.setVisibility(0);
            } else if (400 == i) {
                this.a.setImageResource(R.drawable.obfuscated_res_0x7f08158f);
                this.b.setText("未查询到开通结果");
                this.c.setVisibility(0);
                this.d.setVisibility(8);
                this.e.setVisibility(0);
                this.h.setVisibility(8);
            } else if (200 == i) {
                this.a.setImageResource(R.drawable.obfuscated_res_0x7f081590);
                this.b.setText(EventAlias.PayEventAlias.PAY_FAIL);
                this.c.setVisibility(8);
                this.d.setVisibility(0);
                this.d.setText("首期支付失败，自动续费开通成功，请稍后留意微信支付扣款信息，你可以在微信APP “我-支付-右上角-扣费服务”中管理自动续费服务。");
                this.e.setVisibility(8);
                this.h.setVisibility(0);
            } else if (119501 == i) {
                this.a.setImageResource(R.drawable.obfuscated_res_0x7f081590);
                this.b.setText("未查询到开通结果");
                this.c.setVisibility(0);
                this.d.setVisibility(8);
                this.e.setVisibility(0);
                this.h.setVisibility(8);
                nd1.f(this, "网络错误，请重试");
            } else {
                this.a.setImageResource(R.drawable.obfuscated_res_0x7f081590);
                this.b.setText("自动续费开通失败，请重试");
                this.c.setVisibility(8);
                this.d.setVisibility(8);
                this.e.setVisibility(8);
                this.h.setVisibility(0);
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0055);
            k = System.currentTimeMillis();
            PolyActivity.g = null;
            if (getIntent().getIntExtra("code", 0) == -2) {
                d();
                zb1.b c = zb1.b().c();
                zb1.b().e(null);
                if (c != null) {
                    c.onResult(2, "支付取消");
                }
                finish();
                return;
            }
            this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f091d0f);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f091d0e);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f091d0d);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f091d10);
            this.e = findViewById(R.id.obfuscated_res_0x7f091d0b);
            this.f = (ProgressButton) findViewById(R.id.obfuscated_res_0x7f091cf6);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f091cec);
            ProgressButton progressButton = (ProgressButton) findViewById(R.id.obfuscated_res_0x7f091d0c);
            this.h = progressButton;
            progressButton.setText("我知道了");
            this.i = findViewById(R.id.obfuscated_res_0x7f091d0a);
            this.f.setOnClickListener(this);
            this.f.setText("查询开通结果");
            this.g.setOnClickListener(this);
            this.h.setOnClickListener(this);
            this.i.setOnClickListener(this);
            c(true);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f091cf6) {
                c(false);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091cec) {
                e();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091d0c) {
                e();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091d0a) {
                e();
            }
        }
    }
}
