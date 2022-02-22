package com.baidu.poly.widget;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.i0.f;
import c.a.i0.g;
import c.a.i0.h;
import c.a.i0.n.c;
import c.a.i0.t.e.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
/* loaded from: classes11.dex */
public class WechatSignAutoRenewActivity extends Activity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_WECHAT_RECEIVER_CODE = "code";
    public static final long MIN_LOADING_TIME = 2000;
    public static long startTimeMillis;
    public transient /* synthetic */ FieldHolder $fh;
    public int actionStatus;
    public TextView backBusinessBtn;
    public View bottomBackView;
    public View querySignStatusActionLayout;
    public ProgressButton queryStatusBtn;
    public ProgressButton resultConfirmBtn;
    public ImageView signStatusImg;
    public TextView tvSignRenewNotice;
    public TextView tvSignRenewStatus;
    public TextView tvSignRenewSuccess;

    /* loaded from: classes11.dex */
    public class a implements c.a.i0.s.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ WechatSignAutoRenewActivity f38091b;

        /* renamed from: com.baidu.poly.widget.WechatSignAutoRenewActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class RunnableC1852a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f38092e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f38093f;

            public RunnableC1852a(a aVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f38093f = aVar;
                this.f38092e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f38093f.f38091b.processCheckOrderStatus(this.f38092e);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38091b = wechatSignAutoRenewActivity;
            this.a = z;
        }

        @Override // c.a.i0.s.g.a
        public void onResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                if (this.a) {
                    long currentTimeMillis = System.currentTimeMillis() - WechatSignAutoRenewActivity.startTimeMillis;
                    if (currentTimeMillis >= 2000) {
                        this.f38091b.processCheckOrderStatus(i2);
                        return;
                    } else {
                        new Handler(Looper.getMainLooper()).postDelayed(new RunnableC1852a(this, i2), 2000 - currentTimeMillis);
                        return;
                    }
                }
                this.f38091b.processCheckOrderStatus(i2);
            }
        }
    }

    public WechatSignAutoRenewActivity() {
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

    private void checkOrderStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, this, z) == null) {
            this.queryStatusBtn.setEnable(false);
            this.queryStatusBtn.setPressed(true);
            this.queryStatusBtn.startLoading();
            c.b().a(new a(this, z));
        }
    }

    private void moveInvokerTaskToFront() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            try {
                ((ActivityManager) getSystemService("activity")).moveTaskToFront(c.a.i0.n.a.a().b(), 1);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void payResultAndFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            moveInvokerTaskToFront();
            c.b c2 = c.b().c();
            c.b().e(null);
            if (c2 != null) {
                int i2 = this.actionStatus;
                if (i2 == 0) {
                    c2.onResult(0, EventAlias.PayEventAlias.PAY_SUCCESS);
                } else if (200 != i2 && 400 != i2) {
                    c2.onResult(3, EventAlias.PayEventAlias.PAY_FAIL);
                } else {
                    c2.onResult(1, "支付中");
                }
            }
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processCheckOrderStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, this, i2) == null) {
            this.actionStatus = i2;
            this.queryStatusBtn.setEnabled(true);
            this.queryStatusBtn.setPressed(false);
            this.queryStatusBtn.stopLoading();
            if (i2 == 0) {
                this.signStatusImg.setImageResource(f.wechat_sign_query_success);
                this.tvSignRenewStatus.setText(EventAlias.PayEventAlias.PAY_SUCCESS);
                this.tvSignRenewNotice.setVisibility(8);
                this.tvSignRenewSuccess.setVisibility(0);
                this.tvSignRenewSuccess.setText("你已开通自动续费。请稍后留意微信支付扣款信息，你可以在微信APP “我-支付-右上角更多-扣费服务”中管理自动续费服务。");
                this.querySignStatusActionLayout.setVisibility(8);
                this.resultConfirmBtn.setVisibility(0);
            } else if (400 == i2) {
                this.signStatusImg.setImageResource(f.wechat_sign_query_doing);
                this.tvSignRenewStatus.setText("未查询到开通结果");
                this.tvSignRenewNotice.setVisibility(0);
                this.tvSignRenewSuccess.setVisibility(8);
                this.querySignStatusActionLayout.setVisibility(0);
                this.resultConfirmBtn.setVisibility(8);
            } else if (200 == i2) {
                this.signStatusImg.setImageResource(f.wechat_sign_query_fail);
                this.tvSignRenewStatus.setText(EventAlias.PayEventAlias.PAY_FAIL);
                this.tvSignRenewNotice.setVisibility(8);
                this.tvSignRenewSuccess.setVisibility(0);
                this.tvSignRenewSuccess.setText("首期支付失败，自动续费开通成功，请稍后留意微信支付扣款信息，你可以在微信APP “我-支付-右上角-扣费服务”中管理自动续费服务。");
                this.querySignStatusActionLayout.setVisibility(8);
                this.resultConfirmBtn.setVisibility(0);
            } else if (119501 == i2) {
                this.signStatusImg.setImageResource(f.wechat_sign_query_fail);
                this.tvSignRenewStatus.setText("未查询到开通结果");
                this.tvSignRenewNotice.setVisibility(0);
                this.tvSignRenewSuccess.setVisibility(8);
                this.querySignStatusActionLayout.setVisibility(0);
                this.resultConfirmBtn.setVisibility(8);
                b.f(this, "网络错误，请重试");
            } else {
                this.signStatusImg.setImageResource(f.wechat_sign_query_fail);
                this.tvSignRenewStatus.setText("自动续费开通失败，请重试");
                this.tvSignRenewNotice.setVisibility(8);
                this.tvSignRenewSuccess.setVisibility(8);
                this.querySignStatusActionLayout.setVisibility(8);
                this.resultConfirmBtn.setVisibility(0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            payResultAndFinish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            if (view.getId() == g.poly_query_sign_renew_status) {
                checkOrderStatus(false);
            } else if (view.getId() == g.poly_back_business_page) {
                payResultAndFinish();
            } else if (view.getId() == g.poly_sign_renew_confirm) {
                payResultAndFinish();
            } else if (view.getId() == g.poly_sign_auto_renew_back_btn) {
                payResultAndFinish();
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(h.activity_sign_auto_renew);
            startTimeMillis = System.currentTimeMillis();
            PolyActivity.invokerActivity = null;
            if (getIntent().getIntExtra("code", 0) == -2) {
                moveInvokerTaskToFront();
                c.b c2 = c.b().c();
                c.b().e(null);
                if (c2 != null) {
                    c2.onResult(2, "支付取消");
                }
                finish();
                LogUtil.logActivity(this, "onCreate");
                return;
            }
            this.signStatusImg = (ImageView) findViewById(g.poly_sign_renew_status_img);
            this.tvSignRenewStatus = (TextView) findViewById(g.poly_sign_renew_status);
            this.tvSignRenewNotice = (TextView) findViewById(g.poly_sign_renew_notice);
            this.tvSignRenewSuccess = (TextView) findViewById(g.poly_sign_renew_success);
            this.querySignStatusActionLayout = findViewById(g.poly_sign_auto_renew_query_layout);
            this.queryStatusBtn = (ProgressButton) findViewById(g.poly_query_sign_renew_status);
            this.backBusinessBtn = (TextView) findViewById(g.poly_back_business_page);
            ProgressButton progressButton = (ProgressButton) findViewById(g.poly_sign_renew_confirm);
            this.resultConfirmBtn = progressButton;
            progressButton.setText("我知道了");
            this.bottomBackView = findViewById(g.poly_sign_auto_renew_back_btn);
            this.queryStatusBtn.setOnClickListener(this);
            this.queryStatusBtn.setText("查询开通结果");
            this.backBusinessBtn.setOnClickListener(this);
            this.resultConfirmBtn.setOnClickListener(this);
            this.bottomBackView.setOnClickListener(this);
            checkOrderStatus(true);
            LogUtil.logActivity(this, "onCreate");
        }
    }
}
