package com.baidu.android.lbspay.channelpay;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.CallSuper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.LBSPayResult;
import com.baidu.android.lbspay.beans.GetPayBean;
import com.baidu.android.lbspay.channelpay.IChannelPay;
import com.baidu.android.lbspay.network.GetPayContent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.JsonUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
/* loaded from: classes10.dex */
public abstract class AbstractChannelPay implements IChannelPay {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<Context> mContext;
    public boolean mNotifyOnError;
    public GetPayBean mPayBean;
    public GetPayContent mPayResponse;
    public IChannelPay.State mState;

    public AbstractChannelPay() {
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
        this.mState = IChannelPay.State.Init;
    }

    public GetPayBean getPayBean() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mPayBean : (GetPayBean) invokeV.objValue;
    }

    @Override // com.baidu.android.lbspay.channelpay.IChannelPay
    public PayDataBean getPayData(GetPayContent getPayContent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, getPayContent)) == null) {
            String str = getPayContent.paydata;
            if (!TextUtils.isEmpty(str)) {
                String str2 = new String(Base64.decode(str, 0));
                String str3 = "decodeddata=" + str2;
                try {
                    return (PayDataBean) JsonUtils.fromJson(str2, PayDataBean.class);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }
        return (PayDataBean) invokeL.objValue;
    }

    public GetPayContent getPayResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mPayResponse : (GetPayContent) invokeV.objValue;
    }

    @Override // com.baidu.android.lbspay.channelpay.IChannelPay
    public IChannelPay.State getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mState : (IChannelPay.State) invokeV.objValue;
    }

    @Override // com.baidu.android.lbspay.channelpay.IChannelPay
    public void pay(Activity activity, Activity activity2, GetPayContent getPayContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, activity, activity2, getPayContent) == null) {
        }
    }

    @Override // com.baidu.android.lbspay.channelpay.IChannelPay
    @CallSuper
    public void pay(Activity activity, GetPayContent getPayContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, activity, getPayContent) == null) {
            this.mContext = new WeakReference<>(activity);
            this.mState = IChannelPay.State.Paying;
            this.mPayResponse = getPayContent;
        }
    }

    @Override // com.baidu.android.lbspay.channelpay.IChannelPay
    public void payCancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mState = IChannelPay.State.PayEnd;
            WeakReference<Context> weakReference = this.mContext;
            Context context = weakReference == null ? null : weakReference.get();
            if (this.mNotifyOnError) {
                LBSPayResult.payResult(context, 2, null);
            }
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
    }

    @Override // com.baidu.android.lbspay.channelpay.IChannelPay
    public void payError(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            this.mState = IChannelPay.State.PayEnd;
            WeakReference<Context> weakReference = this.mContext;
            Context context = weakReference == null ? null : weakReference.get();
            if (this.mNotifyOnError) {
                LBSPayResult.payResult(context, 2, null);
            }
            String orderId = StatHelper.getOrderId();
            List<String> collectData = StatHelper.collectData(orderId, StatHelper.getChannelId(), str + "", str2);
            HashMap hashMap = new HashMap();
            hashMap.put("pay_amount", StatHelper.getPayAmount());
            StatisticManager.onEventWithValues(PayStatServiceEvent.LBS_PAY_RESULT_ERROR, collectData, hashMap);
            if (context != null) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = EventAlias.PayEventAlias.PAY_FAIL;
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
    }

    @Override // com.baidu.android.lbspay.channelpay.IChannelPay
    @CallSuper
    public void paySuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.mState = IChannelPay.State.PayEnd;
            WeakReference<Context> weakReference = this.mContext;
            Context context = weakReference == null ? null : weakReference.get();
            LBSPayResult.payResult(context, 0, str, this);
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
    }

    @Override // com.baidu.android.lbspay.channelpay.IChannelPay
    public void paying() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.mState = IChannelPay.State.PayEnd;
            WeakReference<Context> weakReference = this.mContext;
            Context context = weakReference == null ? null : weakReference.get();
            LBSPayResult.payResult(context, 1, "");
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
    }

    public void setNotifyOnError(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.mNotifyOnError = z;
        }
    }

    public void setPayBean(GetPayBean getPayBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, getPayBean) == null) {
            this.mPayBean = getPayBean;
        }
    }
}
