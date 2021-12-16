package com.baidu.android.lbspay.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.LBSPayBack;
import com.baidu.android.lbspay.LBSPayInner;
import com.baidu.android.lbspay.LBSPayResult;
import com.baidu.android.lbspay.beans.GetPayBean;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.payresult.datamodel.H5ResultParams;
import com.baidu.wallet.paysdk.payresult.presenter.H5LifeCycleCallback;
import com.baidu.wallet.paysdk.payresult.presenter.H5PayResultProcess;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.List;
/* loaded from: classes9.dex */
public class JuheH5PayResultProcess extends H5PayResultProcess {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mCallbackParam;
    public H5LifeCycleCallback mH5LifeCycleCb;
    public GetPayBean mPayBean;
    public String mUrlAndParams;

    public JuheH5PayResultProcess(Context context, String str, String str2, GetPayBean getPayBean, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, getPayBean, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mH5LifeCycleCb = null;
        this.mContext = context;
        this.mH5 = new H5ResultParams("-1", str, str2, "1", null);
        this.mPayBean = getPayBean;
        this.mCallbackParam = str3;
        this.mUrlAndParams = null;
    }

    private String getH5ResultPageParams() {
        InterceptResult invokeV;
        GetPayBean getPayBean;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            String str = this.mUrlAndParams;
            if (str != null) {
                return str;
            }
            if (this.mContext == null || (getPayBean = this.mPayBean) == null) {
                return null;
            }
            List<RestNameValuePair> requestParams = getPayBean.getRequestParams();
            this.mPayBean = null;
            if (requestParams == null) {
                return null;
            }
            if (!TextUtils.isEmpty(this.mH5.pay_result_params)) {
                for (String str2 : this.mH5.pay_result_params.split("&")) {
                    String[] split = str2.split("=");
                    requestParams.add(new RestNameValuePair(split[0], split[1]));
                }
            }
            String processedParams = H5PayResultProcess.getProcessedParams(requestParams, "UTF-8");
            if (TextUtils.isEmpty(processedParams)) {
                return null;
            }
            String str3 = this.mH5.pay_result_url + "?is_from_sdk=1&result_type=cashier&order_query=" + processedParams;
            this.mUrlAndParams = str3;
            return str3;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.H5PayResultProcess
    public void afterShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Intent intent = new Intent(LBSPayResult.ACTION_EXIT);
            LBSPayBack callBack = LBSPayInner.getInstance().getCallBack();
            if (callBack != null) {
                try {
                    if (this.mContext != null) {
                        StatisticManager.onEvent("#onPayResult");
                    }
                    callBack.onPayResult(0, this.mCallbackParam);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            LBSPayInner.getInstance().clearLbsPayBack();
            Context context = this.mContext;
            if (context != null) {
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.H5PayResultProcess
    public void beforeShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            PayRequestCache.getInstance().removeBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.H5PayResultProcess
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            String h5ResultPageParams = getH5ResultPageParams();
            this.mQueryResultString = h5ResultPageParams;
            if (h5ResultPageParams == null) {
                afterShow();
                return;
            }
            if (this.mH5LifeCycleCb == null) {
                H5LifeCycleCallback h5LifeCycleCallback = new H5LifeCycleCallback(this) { // from class: com.baidu.android.lbspay.presenter.JuheH5PayResultProcess.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ JuheH5PayResultProcess a;

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

                    @Override // com.baidu.wallet.paysdk.payresult.presenter.H5LifeCycleCallback, android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(Activity activity) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, activity) == null) {
                            BaiduWalletDelegate.getInstance().removeH5LifeCycleCb(activity, this);
                            this.a.afterShow();
                        }
                    }
                };
                this.mH5LifeCycleCb = h5LifeCycleCallback;
                h5LifeCycleCallback.push();
            }
            BaiduWalletDelegate.getInstance();
            Bundle bundle = new Bundle();
            bundle.putBoolean("with_anim", false);
            bundle.putBoolean("show_share", false);
            bundle.putString("url", this.mQueryResultString);
            bundle.putParcelable("lifecycleLsnr", this.mH5LifeCycleCb);
            BaiduWalletDelegate.getInstance().openH5Module(this.mContext, bundle);
        }
    }
}
