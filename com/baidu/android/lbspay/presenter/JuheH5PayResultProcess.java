package com.baidu.android.lbspay.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.android.lbspay.LBSPayBack;
import com.baidu.android.lbspay.LBSPayInner;
import com.baidu.android.lbspay.LBSPayResult;
import com.baidu.android.lbspay.beans.GetPayBean;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.payresult.datamodel.H5ResultParams;
import com.baidu.wallet.paysdk.payresult.presenter.H5LifeCycleCallback;
import com.baidu.wallet.paysdk.payresult.presenter.H5PayResultProcess;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.statistics.api.StatisticManager;
import java.util.List;
/* loaded from: classes2.dex */
public class JuheH5PayResultProcess extends H5PayResultProcess {
    public String mCallbackParam;
    public H5LifeCycleCallback mH5LifeCycleCb = null;
    public GetPayBean mPayBean;
    public String mUrlAndParams;

    public JuheH5PayResultProcess(Context context, String str, String str2, GetPayBean getPayBean, String str3) {
        this.mContext = context;
        this.mH5 = new H5ResultParams("-1", str, str2, "1", null);
        this.mPayBean = getPayBean;
        this.mCallbackParam = str3;
        this.mUrlAndParams = null;
    }

    private String getH5ResultPageParams() {
        GetPayBean getPayBean;
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

    @Override // com.baidu.wallet.paysdk.payresult.presenter.H5PayResultProcess
    public void afterShow() {
        Intent intent = new Intent(LBSPayResult.ACTION_EXIT);
        LBSPayBack callBack = LBSPayInner.getInstance().getCallBack();
        if (callBack != null) {
            try {
                if (this.mContext != null) {
                    StatisticManager.onEvent(StatServiceEvent.EVENT_API_ONPAYRESULT);
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

    @Override // com.baidu.wallet.paysdk.payresult.presenter.H5PayResultProcess
    public void beforeShow() {
        PayRequestCache.getInstance().removeBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.H5PayResultProcess
    public void show() {
        String h5ResultPageParams = getH5ResultPageParams();
        this.mQueryResultString = h5ResultPageParams;
        if (h5ResultPageParams == null) {
            afterShow();
            return;
        }
        if (this.mH5LifeCycleCb == null) {
            H5LifeCycleCallback h5LifeCycleCallback = new H5LifeCycleCallback() { // from class: com.baidu.android.lbspay.presenter.JuheH5PayResultProcess.1
                @Override // com.baidu.wallet.paysdk.payresult.presenter.H5LifeCycleCallback, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    BaiduWalletDelegate.getInstance().removeH5LifeCycleCb(activity, this);
                    JuheH5PayResultProcess.this.afterShow();
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
