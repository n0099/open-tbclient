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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ja1;
import com.repackage.t81;
import com.repackage.v81;
import com.repackage.x91;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
/* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public class a implements x91 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ WechatSignAutoRenewActivity b;

        /* renamed from: com.baidu.poly.widget.WechatSignAutoRenewActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0122a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ a b;

            public RunnableC0122a(a aVar, int i) {
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
                    this.b.b.processCheckOrderStatus(this.a);
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

        @Override // com.repackage.x91
        public void onResult(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                if (this.a) {
                    long currentTimeMillis = System.currentTimeMillis() - WechatSignAutoRenewActivity.startTimeMillis;
                    if (currentTimeMillis >= 2000) {
                        this.b.processCheckOrderStatus(i);
                        return;
                    } else {
                        new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0122a(this, i), 2000 - currentTimeMillis);
                        return;
                    }
                }
                this.b.processCheckOrderStatus(i);
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

    private void checkOrderStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, this, z) == null) {
            this.queryStatusBtn.setEnable(false);
            this.queryStatusBtn.setPressed(true);
            this.queryStatusBtn.b();
            v81.b().a(new a(this, z));
        }
    }

    private void moveInvokerTaskToFront() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            try {
                ((ActivityManager) getSystemService("activity")).moveTaskToFront(t81.a().b(), 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void payResultAndFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            moveInvokerTaskToFront();
            v81.b c = v81.b().c();
            v81.b().e(null);
            if (c != null) {
                int i = this.actionStatus;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void processCheckOrderStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, this, i) == null) {
            this.actionStatus = i;
            this.queryStatusBtn.setEnabled(true);
            this.queryStatusBtn.setPressed(false);
            this.queryStatusBtn.c();
            if (i == 0) {
                this.signStatusImg.setImageResource(R.drawable.obfuscated_res_0x7f081255);
                this.tvSignRenewStatus.setText(EventAlias.PayEventAlias.PAY_SUCCESS);
                this.tvSignRenewNotice.setVisibility(8);
                this.tvSignRenewSuccess.setVisibility(0);
                this.tvSignRenewSuccess.setText("你已开通自动续费。请稍后留意微信支付扣款信息，你可以在微信APP “我-支付-右上角更多-扣费服务”中管理自动续费服务。");
                this.querySignStatusActionLayout.setVisibility(8);
                this.resultConfirmBtn.setVisibility(0);
            } else if (400 == i) {
                this.signStatusImg.setImageResource(R.drawable.obfuscated_res_0x7f081253);
                this.tvSignRenewStatus.setText("未查询到开通结果");
                this.tvSignRenewNotice.setVisibility(0);
                this.tvSignRenewSuccess.setVisibility(8);
                this.querySignStatusActionLayout.setVisibility(0);
                this.resultConfirmBtn.setVisibility(8);
            } else if (200 == i) {
                this.signStatusImg.setImageResource(R.drawable.obfuscated_res_0x7f081254);
                this.tvSignRenewStatus.setText(EventAlias.PayEventAlias.PAY_FAIL);
                this.tvSignRenewNotice.setVisibility(8);
                this.tvSignRenewSuccess.setVisibility(0);
                this.tvSignRenewSuccess.setText("首期支付失败，自动续费开通成功，请稍后留意微信支付扣款信息，你可以在微信APP “我-支付-右上角-扣费服务”中管理自动续费服务。");
                this.querySignStatusActionLayout.setVisibility(8);
                this.resultConfirmBtn.setVisibility(0);
            } else if (119501 == i) {
                this.signStatusImg.setImageResource(R.drawable.obfuscated_res_0x7f081254);
                this.tvSignRenewStatus.setText("未查询到开通结果");
                this.tvSignRenewNotice.setVisibility(0);
                this.tvSignRenewSuccess.setVisibility(8);
                this.querySignStatusActionLayout.setVisibility(0);
                this.resultConfirmBtn.setVisibility(8);
                ja1.f(this, "网络错误，请重试");
            } else {
                this.signStatusImg.setImageResource(R.drawable.obfuscated_res_0x7f081254);
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
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f09186f) {
                checkOrderStatus(false);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091865) {
                payResultAndFinish();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091885) {
                payResultAndFinish();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091883) {
                payResultAndFinish();
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0054);
            startTimeMillis = System.currentTimeMillis();
            PolyActivity.invokerActivity = null;
            if (getIntent().getIntExtra("code", 0) == -2) {
                moveInvokerTaskToFront();
                v81.b c = v81.b().c();
                v81.b().e(null);
                if (c != null) {
                    c.onResult(2, "支付取消");
                }
                finish();
                LogUtil.logActivity(this, "onCreate");
                return;
            }
            this.signStatusImg = (ImageView) findViewById(R.id.obfuscated_res_0x7f091888);
            this.tvSignRenewStatus = (TextView) findViewById(R.id.obfuscated_res_0x7f091887);
            this.tvSignRenewNotice = (TextView) findViewById(R.id.obfuscated_res_0x7f091886);
            this.tvSignRenewSuccess = (TextView) findViewById(R.id.obfuscated_res_0x7f091889);
            this.querySignStatusActionLayout = findViewById(R.id.obfuscated_res_0x7f091884);
            this.queryStatusBtn = (ProgressButton) findViewById(R.id.obfuscated_res_0x7f09186f);
            this.backBusinessBtn = (TextView) findViewById(R.id.obfuscated_res_0x7f091865);
            ProgressButton progressButton = (ProgressButton) findViewById(R.id.obfuscated_res_0x7f091885);
            this.resultConfirmBtn = progressButton;
            progressButton.setText("我知道了");
            this.bottomBackView = findViewById(R.id.obfuscated_res_0x7f091883);
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
