package com.baidu.android.lbspay.channelpay;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.CallSuper;
import com.baidu.android.lbspay.LBSPayResult;
import com.baidu.android.lbspay.beans.GetPayBean;
import com.baidu.android.lbspay.channelpay.IChannelPay;
import com.baidu.android.lbspay.network.GetPayContent;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.util.StatHelper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
/* loaded from: classes2.dex */
public abstract class AbstractChannelPay implements IChannelPay {
    public WeakReference<Context> mContext;
    public boolean mNotifyOnError;
    public GetPayBean mPayBean;
    public GetPayContent mPayResponse;
    public IChannelPay.State mState = IChannelPay.State.Init;

    public GetPayBean getPayBean() {
        return this.mPayBean;
    }

    @Override // com.baidu.android.lbspay.channelpay.IChannelPay
    public PayDataBean getPayData(GetPayContent getPayContent) {
        String str = getPayContent.paydata;
        if (!TextUtils.isEmpty(str)) {
            String str2 = new String(Base64.decode(str, 0));
            LogUtil.logd("decodeddata=" + str2);
            try {
                return (PayDataBean) JsonUtils.fromJson(str2, PayDataBean.class);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public GetPayContent getPayResponse() {
        return this.mPayResponse;
    }

    @Override // com.baidu.android.lbspay.channelpay.IChannelPay
    public IChannelPay.State getState() {
        return this.mState;
    }

    @Override // com.baidu.android.lbspay.channelpay.IChannelPay
    public void pay(Activity activity, Activity activity2, GetPayContent getPayContent) {
    }

    @Override // com.baidu.android.lbspay.channelpay.IChannelPay
    @CallSuper
    public void pay(Activity activity, GetPayContent getPayContent) {
        this.mContext = new WeakReference<>(activity);
        this.mState = IChannelPay.State.Paying;
        this.mPayResponse = getPayContent;
    }

    @Override // com.baidu.android.lbspay.channelpay.IChannelPay
    public void payCancel() {
        this.mState = IChannelPay.State.PayEnd;
        WeakReference<Context> weakReference = this.mContext;
        Context context = weakReference == null ? null : weakReference.get();
        if (this.mNotifyOnError) {
            LBSPayResult.payResult(context, 2, null);
        }
        List<String> collectData = StatHelper.collectData(StatHelper.getOrderId(), StatHelper.getChannelId());
        HashMap hashMap = new HashMap();
        hashMap.put(BaiduPay.AMOUNT, StatHelper.getPayAmount());
        StatisticManager.onEventWithValues(PayStatServiceEvent.LBS_PAY_RESULT_CANCEL, collectData, hashMap);
        if (context != null) {
            if (!this.mNotifyOnError) {
                GlobalUtils.toast(context, ResUtils.getString(context, "lbspay_pay_cancel"));
            }
            int channelId = getChannelId();
            if (channelId == 105) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_ALIPAY, "app_canncel");
            } else if (channelId == 107) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_FAST_PAY, "canncel");
            } else if (channelId == 126) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_BAIDU_PAY, "canncel");
            } else if (channelId == 158) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_WXPAY, "wxpay_canncel");
            } else if (channelId != 163) {
            } else {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_IPAY_PAY, "Ipaypay_canncel");
            }
        }
    }

    @Override // com.baidu.android.lbspay.channelpay.IChannelPay
    public void payError(String str, String str2) {
        this.mState = IChannelPay.State.PayEnd;
        WeakReference<Context> weakReference = this.mContext;
        Context context = weakReference == null ? null : weakReference.get();
        if (this.mNotifyOnError) {
            LBSPayResult.payResult(context, 2, null);
        }
        String orderId = StatHelper.getOrderId();
        List<String> collectData = StatHelper.collectData(orderId, StatHelper.getChannelId(), str + "", str2);
        HashMap hashMap = new HashMap();
        hashMap.put(BaiduPay.AMOUNT, StatHelper.getPayAmount());
        StatisticManager.onEventWithValues(PayStatServiceEvent.LBS_PAY_RESULT_ERROR, collectData, hashMap);
        if (context != null) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "支付失败";
            }
            GlobalUtils.toast(context, str2);
            int channelId = getChannelId();
            if (channelId == 105) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_ALIPAY, str);
            } else if (channelId == 107) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_FAST_PAY, str);
            } else if (channelId == 126) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_BAIDU_PAY, str);
            } else if (channelId == 158) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_WXPAY, str);
            } else if (channelId != 163) {
            } else {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_IPAY_PAY, str);
            }
        }
    }

    @Override // com.baidu.android.lbspay.channelpay.IChannelPay
    @CallSuper
    public void paySuccess(String str) {
        this.mState = IChannelPay.State.PayEnd;
        WeakReference<Context> weakReference = this.mContext;
        Context context = weakReference == null ? null : weakReference.get();
        LBSPayResult.payResult(context, 0, str, this);
        List<String> collectData = StatHelper.collectData(StatHelper.getOrderId(), StatHelper.getChannelId());
        HashMap hashMap = new HashMap();
        hashMap.put(BaiduPay.AMOUNT, StatHelper.getPayAmount());
        StatisticManager.onEventWithValues(PayStatServiceEvent.LBS_PAY_RESULT_SUCCESS, collectData, hashMap);
        if (context != null) {
            int channelId = getChannelId();
            if (channelId == 105) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_ALIPAY, "app_success");
            } else if (channelId == 107) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_FAST_PAY, "success");
            } else if (channelId == 126) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_BAIDU_PAY, "success");
            } else if (channelId == 158) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_WXPAY, "wxpay_success");
            } else if (channelId != 163) {
            } else {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_IPAY_PAY, "Ipaypay_success");
            }
        }
    }

    @Override // com.baidu.android.lbspay.channelpay.IChannelPay
    public void paying() {
        this.mState = IChannelPay.State.PayEnd;
        WeakReference<Context> weakReference = this.mContext;
        Context context = weakReference == null ? null : weakReference.get();
        LBSPayResult.payResult(context, 1, "");
        List<String> collectData = StatHelper.collectData(StatHelper.getOrderId(), StatHelper.getChannelId());
        HashMap hashMap = new HashMap();
        hashMap.put(BaiduPay.AMOUNT, StatHelper.getPayAmount());
        StatisticManager.onEventWithValues(PayStatServiceEvent.LBS_PAY_RESULT_PAYING, collectData, hashMap);
        if (context != null) {
            int channelId = getChannelId();
            if (channelId == 105) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_ALIPAY, "app_paying");
            } else if (channelId == 107) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_FAST_PAY, "paying");
            } else if (channelId == 126) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_BAIDU_PAY, "paying");
            } else if (channelId == 158) {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_WXPAY, "wxpay_paying");
            } else if (channelId != 163) {
            } else {
                StatisticManager.onEventWithValue(StatServiceEvent.LBS_IPAY_PAY, "Ipaypay_paying");
            }
        }
    }

    public void setNotifyOnError(boolean z) {
        this.mNotifyOnError = z;
    }

    public void setPayBean(GetPayBean getPayBean) {
        this.mPayBean = getPayBean;
    }
}
