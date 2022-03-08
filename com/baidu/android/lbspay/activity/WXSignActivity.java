package com.baidu.android.lbspay.activity;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.LBSPayResult;
import com.baidu.android.lbspay.beans.LbsPayBeanFactory;
import com.baidu.android.lbspay.beans.SignResultBean;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.dxmpay.apollon.statusbar.StatusBarUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.beans.BeanActivity;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.utils.StatHelper;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessWebview;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class WXSignActivity extends BeanActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SIGN_REQUEST_URL = "sign_request_url";
    public static final String TAG = "com.baidu.android.lbspay.activity.WXSignActivity";
    public static final String WX_PRE_SIGN_ID = "pre_entrustweb_id";
    public transient /* synthetic */ FieldHolder $fh;
    public AnimationDrawable mAnimationDrawable;
    public boolean mFromWX;
    public Handler mHandler;
    public int mQueryCount;

    public WXSignActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mHandler = new Handler();
        this.mQueryCount = 0;
        this.mFromWX = false;
    }

    private void polling() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.mHandler.postDelayed(new Runnable(this) { // from class: com.baidu.android.lbspay.activity.WXSignActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WXSignActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.signResultQuery();
                    }
                }
            }, 50L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void signResultQuery() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.mFromWX = false;
            SignResultBean signResultBean = (SignResultBean) LbsPayBeanFactory.getInstance().getBean((Context) this, 4, TAG);
            signResultBean.setUrl(getIntent().getStringExtra(SIGN_REQUEST_URL));
            signResultBean.setResponseCallback(this);
            signResultBean.execBean();
        }
    }

    private void startWXSign(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(this, null);
            createWXAPI.registerApp(PayDataCache.getInstance().getmWxAppId());
            WXOpenBusinessWebview.Req req = new WXOpenBusinessWebview.Req();
            req.businessType = 12;
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(WX_PRE_SIGN_ID, str);
            req.queryInfo = hashMap;
            if (createWXAPI.isWXAppInstalled()) {
                if (createWXAPI.sendReq(req)) {
                    this.mFromWX = true;
                    StatHelper.signServiceEvent(PayStatServiceEvent.LBS_WX_API_RESULT, "0", getString(R.string.lbspay_pay_wx_api_success));
                    return;
                }
                StatHelper.signServiceEvent(PayStatServiceEvent.LBS_WX_API_RESULT, "-1", getString(R.string.lbspay_pay_wx_api_fail));
                LBSPayResult.payResult(null, 3, getString(R.string.lbspay_pay_wx_api_fail));
                finish();
                return;
            }
            StatHelper.signServiceEvent(PayStatServiceEvent.LBS_WX_API_RESULT, "-1", getString(R.string.lbspay_pay_no_instll_wx));
            LBSPayResult.payResult(null, 3, getString(R.string.lbspay_pay_no_instll_wx));
            finish();
        }
    }

    @Override // com.dxmpay.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
            int i4 = this.mQueryCount + 1;
            this.mQueryCount = i4;
            if (i4 < 4) {
                polling();
                return;
            }
            hideLoading();
            StatHelper.signServiceEvent(PayStatServiceEvent.LBS_QUERY_SIGN_RESULT, "-1", str);
            LBSPayResult.payResult(null, 3, str);
            finish();
        }
    }

    @Override // com.dxmpay.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
            hideLoading();
            StatHelper.signServiceEvent(PayStatServiceEvent.LBS_QUERY_SIGN_RESULT, "0", getString(R.string.lbspay_pay_sign_result_query_success));
            LBSPayResult.payResult(null, 0, getString(R.string.lbspay_pay_sign_result_query_success));
            finish();
        }
    }

    public void hideLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.mAnimationDrawable == null) {
                this.mAnimationDrawable = (AnimationDrawable) ((ImageView) findViewById(ResUtils.id(getActivity(), "img_anim"))).getDrawable();
            }
            this.mAnimationDrawable.stop();
        }
    }

    @Override // com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, com.dxmpay.wallet.core.SDKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(ResUtils.layout(getActivity(), "wallet_juhe_layout_loading"));
            this.mAnimationDrawable = (AnimationDrawable) ((ImageView) findViewById(ResUtils.id(getActivity(), "img_anim"))).getDrawable();
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            BeanManager.getInstance().removeAllBeans(TAG);
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            AnimationDrawable animationDrawable = this.mAnimationDrawable;
            if (animationDrawable == null || !animationDrawable.isRunning()) {
                return;
            }
            this.mAnimationDrawable.stop();
        }
    }

    @Override // com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onResume();
            if (this.mFromWX) {
                showLoading();
                StatHelper.signServiceEvent(PayStatServiceEvent.LBS_QUERY_SIGN_ENTER, new String[0]);
                signResultQuery();
                return;
            }
            StatHelper.signServiceEvent(PayStatServiceEvent.LBS_WX_API_ENTER, new String[0]);
            startWXSign(getIntent().getStringExtra(WX_PRE_SIGN_ID));
        }
    }

    public void setImmersiveActivityMargeinTop() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || Build.VERSION.SDK_INT < 19 || getActivity() == null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(ResUtils.id(getActivity(), "welcome_page"));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.setMargins(0, StatusBarUtils.getStatusBarHeight(getActivity()), 0, 0);
        linearLayout.setLayoutParams(layoutParams);
    }

    public void showLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.mAnimationDrawable == null) {
                this.mAnimationDrawable = (AnimationDrawable) ((ImageView) findViewById(ResUtils.id(getActivity(), "img_anim"))).getDrawable();
            }
            this.mAnimationDrawable.start();
            setImmersiveActivityMargeinTop();
        }
    }
}
