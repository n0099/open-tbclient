package com.baidu.android.lbspay.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.util.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.CashierDataNew;
import com.baidu.android.lbspay.GetPayOrderListener;
import com.baidu.android.lbspay.LBSPayResult;
import com.baidu.android.lbspay.beans.GetPayBean;
import com.baidu.android.lbspay.beans.LbsPayBeanFactory;
import com.baidu.android.lbspay.channelpay.AbstractChannelPay;
import com.baidu.android.lbspay.channelpay.ChannelPayUtil;
import com.baidu.android.lbspay.channelpay.IChannelPay;
import com.baidu.android.lbspay.channelpay.alipay.ChannelAliPay;
import com.baidu.android.lbspay.channelpay.alipay.LBSPayAli;
import com.baidu.android.lbspay.channelpay.fast.ChannelFastPay;
import com.baidu.android.lbspay.network.GetPayContent;
import com.baidu.android.lbspay.statistics.LbsStatistics;
import com.baidu.android.lbspay.utils.PayMode;
import com.baidu.tbadk.core.atomData.WalletPayResultActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.dxmpay.apollon.beans.IBeanResponseCallback;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.NoProguard;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class PayChannelController implements IBeanResponseCallback, NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ALIPAY_PAYCHANNEL = "BAIDU-ALIPAY-WISE";
    public static final String BAIFUBAO_PAYCHANNEL = "BAIDU-BAIFUBAO-WISE";
    public static final String BAIFUBAO_PAYCHANNEL_CODE = "BAIFUBAO-WISE";
    public static final String BANKCARD_PAYCHANNEL = "BAIDU-BANK-CARD-PAY";
    public static final String BEAN_TAG = "ChannelListViewController";
    public static final String WXPAY_PAYCHANNEL = "BAIDU-SUPER-WECHAT-WISE";
    public transient /* synthetic */ FieldHolder $fh;
    public GetPayOrderListener getPayOrderListener;
    public Activity mAct;
    public Activity mAlipayActivity;
    public CashierDataNew mCashierData;
    public int mChannelId;
    public IChannelPay mChannelPay;
    public GetPayBean mGetPayBean;
    public Handler mHandler;

    /* loaded from: classes9.dex */
    public interface DoShowAllChannelClick {
        void doClick();
    }

    /* loaded from: classes9.dex */
    public interface GetPayModeListener {
        void getSelectPayMode(PayMode payMode);
    }

    /* loaded from: classes9.dex */
    public interface SelectChannelListener {
        void onSelectChannel(String str);
    }

    public PayChannelController(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAlipayActivity = null;
        this.mAct = activity;
        this.mHandler = new Handler(activity.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(InputDeviceCompat.SOURCE_TRACKBALL, this, i2, i3, str) == null) && i2 == 2) {
            LBSPayAli.getInstance().clearChannelPay();
            this.mChannelPay = null;
            if (!TextUtils.isEmpty(str)) {
                GlobalUtils.toast(this.mAct, str);
            }
            GetPayOrderListener getPayOrderListener = this.getPayOrderListener;
            if (getPayOrderListener != null) {
                getPayOrderListener.complete();
            }
            LBSPayResult.payResult(this.mAct, 2, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(65541, this, i2, obj, str) == null) && obj != null && i2 == 2) {
            GetPayContent getPayContent = obj instanceof GetPayContent ? (GetPayContent) obj : null;
            GetPayOrderListener getPayOrderListener = this.getPayOrderListener;
            if (getPayOrderListener != null) {
                getPayOrderListener.complete();
            }
            if (getPayContent != null) {
                int i3 = getPayContent.authorize_err_no;
                if (i3 == 100000) {
                    LBSPayResult.payResult(this.mAct, 0, getPayContent.authorize_return_data);
                } else if (i3 > 100000 && i3 <= 110000) {
                    doPay(getPayContent);
                } else {
                    doPay(getPayContent);
                }
            }
        }
    }

    public void doDirectCallThirdPay(GetPayOrderListener getPayOrderListener, CashierDataNew cashierDataNew, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, getPayOrderListener, cashierDataNew, str) == null) || TextUtils.isEmpty(str) || cashierDataNew == null) {
            return;
        }
        this.mCashierData = cashierDataNew;
        this.getPayOrderListener = getPayOrderListener;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("payChannel")) {
                String valueOf = String.valueOf(jSONObject.get("payChannel"));
                if (ALIPAY_PAYCHANNEL.equals(valueOf)) {
                    this.mChannelId = 105;
                    this.mChannelPay = ChannelPayUtil.getChannelPay(105);
                } else if (WXPAY_PAYCHANNEL.equals(valueOf)) {
                    this.mChannelId = 158;
                    this.mChannelPay = ChannelPayUtil.getChannelPay(158);
                } else if (BAIFUBAO_PAYCHANNEL.equals(valueOf)) {
                    this.mChannelId = 126;
                    this.mChannelPay = ChannelPayUtil.getChannelPay(126);
                } else if (BANKCARD_PAYCHANNEL.equals(valueOf)) {
                    this.mChannelId = 178;
                    this.mChannelPay = ChannelPayUtil.getChannelPay(178);
                } else {
                    LBSPayResult.payResult(this.mAct, 2, "");
                    return;
                }
                ((AbstractChannelPay) this.mChannelPay).setNotifyOnError(true);
                StatHelper.cacheChannelId(this.mChannelId + "");
                String orderNo = this.mCashierData.getOrderNo();
                List<String> collectData = StatHelper.collectData(orderNo, this.mChannelId + "");
                HashMap hashMap = new HashMap();
                hashMap.put("pay_amount", StatHelper.getPayAmount());
                StatisticManager.onEventWithValues(PayStatServiceEvent.LBS_PAY_CHANNEL, collectData, hashMap);
                GetPayBean getPayBean = (GetPayBean) LbsPayBeanFactory.getInstance().getBean((Context) this.mAct, 2, BEAN_TAG);
                this.mGetPayBean = getPayBean;
                getPayBean.setmCashierData(this.mCashierData);
                this.mGetPayBean.setmReqData(str);
                this.mGetPayBean.setResponseCallback(this);
                this.mGetPayBean.execBean();
                StatisticManager.onEventWithValue(LbsStatistics.LBS_DO_PAY_CLICK, ChannelPayUtil.getChannelTag(this.mChannelId));
                return;
            }
            if (this.getPayOrderListener != null) {
                this.getPayOrderListener.complete();
            }
            GlobalUtils.toast(this.mAct, ResUtils.getString(this.mAct, "dxm_ebpay_resolve_error"));
            LBSPayResult.payResult(this.mAct, 2, "");
        } catch (Exception unused) {
            LBSPayResult.payResult(this.mAct, 2, "");
        }
    }

    public void doPay(GetPayContent getPayContent) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, getPayContent) == null) {
            IChannelPay iChannelPay = this.mChannelPay;
            if (iChannelPay != null) {
                if ((iChannelPay instanceof ChannelAliPay) && (activity = this.mAlipayActivity) != null) {
                    iChannelPay.pay(this.mAct, activity, getPayContent);
                    return;
                }
                IChannelPay iChannelPay2 = this.mChannelPay;
                if ((iChannelPay2 instanceof ChannelFastPay) && TextUtils.isEmpty(((ChannelFastPay) iChannelPay2).getUrl(getPayContent))) {
                    this.mChannelPay.payCancel();
                    return;
                } else {
                    this.mChannelPay.pay(this.mAct, getPayContent);
                    return;
                }
            }
            LBSPayResult.payResult(this.mAct, 2, "");
            GlobalUtils.toast(this.mAct, "暂不支持这种支付方式");
        }
    }

    public void getUnionPayResult(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) || bundle == null) {
            return;
        }
        String string = bundle.getString(WalletPayResultActivityConfig.PAY_RESULT);
        String str = "result =" + string;
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (string.equalsIgnoreCase("success")) {
            IChannelPay iChannelPay = this.mChannelPay;
            if (iChannelPay != null) {
                iChannelPay.paySuccess("");
            }
        } else if (string.equalsIgnoreCase(QueryResponse.Options.CANCEL)) {
            IChannelPay iChannelPay2 = this.mChannelPay;
            if (iChannelPay2 != null) {
                iChannelPay2.payCancel();
            }
        } else {
            string.equalsIgnoreCase(f.f31931j);
        }
    }

    @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(int i2, int i3, String str) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, str) == null) || (handler = this.mHandler) == null) {
            return;
        }
        handler.post(new Runnable(this, i2, i3, str) { // from class: com.baidu.android.lbspay.view.PayChannelController.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f32623b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f32624c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ PayChannelController f32625d;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(i2), Integer.valueOf(i3), str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f32625d = this;
                this.a = i2;
                this.f32623b = i3;
                this.f32624c = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f32625d.handleFailure(this.a, this.f32623b, this.f32624c);
                }
            }
        });
    }

    @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
    public void onBeanExecSuccess(int i2, Object obj, String str) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048580, this, i2, obj, str) == null) || (handler = this.mHandler) == null) {
            return;
        }
        handler.post(new Runnable(this, i2, obj, str) { // from class: com.baidu.android.lbspay.view.PayChannelController.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Object f32620b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f32621c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ PayChannelController f32622d;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(i2), obj, str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f32622d = this;
                this.a = i2;
                this.f32620b = obj;
                this.f32621c = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f32622d.handlerResponse(this.a, this.f32620b, this.f32621c);
                }
            }
        });
    }

    public PayChannelController(Activity activity, Activity activity2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, activity2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mAlipayActivity = null;
        this.mAct = activity;
        this.mAlipayActivity = activity2;
        this.mHandler = new Handler(activity.getMainLooper());
    }
}
