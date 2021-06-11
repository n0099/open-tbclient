package com.baidu.android.lbspay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
import com.alipay.sdk.app.PayTask;
import com.baidu.android.lbspay.activity.LBSTransActivity;
import com.baidu.android.lbspay.activity.LBSTransCashierActivity;
import com.baidu.android.lbspay.channelpay.alipay.LBSPayAli;
import com.baidu.android.lbspay.datamodel.AuthorizeData;
import com.baidu.android.lbspay.presenter.LBSTransPresenterFactory;
import com.baidu.android.lbspay.view.PayChannelController;
import com.baidu.android.pay.BindBack;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.EncodeUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.beans.NetworkBean;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.StringUtils;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import com.baidu.wallet.paysdk.PayUtils;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.util.StatHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class LBSPayInner {
    public static final int STATE_CODE_CANCEL = 2;
    public static final int STATE_CODE_FAILD = 3;
    public static final int STATE_CODE_PAYING = 1;
    public static final int STATE_CODE_SUCCEED = 0;
    public static final String Tag = "LBSPayInner";
    public AliPayCallback mCallback;
    public Handler mHandler;
    public LBSPayBack mLbsPayBack;
    public String mOrderNo;

    /* loaded from: classes.dex */
    public interface AliPayCallback {
        void onResult(String str);
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static LBSPayInner f2613a = new LBSPayInner();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void directCallThirdPay(Activity activity, GetPayOrderListener getPayOrderListener, LBSPayBack lBSPayBack, Map<String, String> map, String str) {
        PayChannelController payChannelController = new PayChannelController(activity);
        this.mOrderNo = map.get("orderId");
        CashierDataNew cashierDataNew = new CashierDataNew();
        cashierDataNew.setData(map);
        this.mLbsPayBack = lBSPayBack;
        payChannelController.doDirectCallThirdPay(getPayOrderListener, cashierDataNew, str);
    }

    public static LBSPayInner getInstance() {
        return a.f2613a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void polymerAuthorizeSign(Activity activity, LBSPayBack lBSPayBack, Map<String, String> map) {
        this.mLbsPayBack = lBSPayBack;
        AuthorizeData authorizeData = new AuthorizeData();
        authorizeData.setData(map);
        Intent intent = new Intent(activity, LBSTransActivity.class);
        intent.putExtra(AuthorizeData.DELIVERY_AUTHORIZE_DATA, authorizeData);
        intent.putExtra(LBSTransActivity.PRESENTER_TYPE, LBSTransPresenterFactory.TRANS_AUTH_PRESENTER);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void polymerPay(Context context, LBSPayBack lBSPayBack, Map<String, String> map, Map<String, String[]> map2) {
        if (map == null) {
            return;
        }
        this.mLbsPayBack = lBSPayBack;
        String str = map.get("orderId");
        this.mOrderNo = str;
        StatHelper.cacheOrderId(str);
        double doubleValue = TextUtils.isEmpty(map.get("payAmount")) ? 0.0d : StringUtils.fen2YuanBigDecimal(map.get("payAmount")).doubleValue();
        StatHelper.cachePayAmount(doubleValue);
        List<String> collectData = StatHelper.collectData(this.mOrderNo, new String[0]);
        HashMap hashMap = new HashMap();
        hashMap.put(BaiduPay.AMOUNT, Double.valueOf(doubleValue));
        StatisticManager.onEventWithValues(PayStatServiceEvent.LBS_PAY_ENTER, collectData, hashMap);
        CashierDataNew cashierDataNew = new CashierDataNew();
        cashierDataNew.setData(map);
        if (map2 != null) {
            cashierDataNew.setExtraData(map2);
        }
        Intent intent = new Intent(context, LBSTransCashierActivity.class);
        intent.putExtra(CashierDataNew.DELIVERY_CASHIER_DATA, cashierDataNew);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            activity.startActivity(intent);
            activity.overridePendingTransition(0, 0);
            return;
        }
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        context.getApplicationContext().startActivity(intent);
    }

    public void clearLbsPayBack() {
        this.mLbsPayBack = null;
        LBSPayAli.getInstance().clearChannelPay();
    }

    public void doAliPay(final Activity activity, final String str, final boolean z, AliPayCallback aliPayCallback) {
        this.mCallback = aliPayCallback;
        new Thread(new Runnable() { // from class: com.baidu.android.lbspay.LBSPayInner.6
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject(new PayTask(activity).payV2(str, z));
                Message message = new Message();
                message.what = 101;
                message.obj = jSONObject.toString();
                LBSPayInner.this.mHandler.sendMessage(message);
            }
        }).start();
    }

    public void doBindCard(Context context, BindBack bindBack, Map<String, String> map) {
        StatisticManager.onEvent(StatServiceEvent.EVENT_API_DOBINDCARD);
        BaiduPayDelegate.getInstance().doBind(context, bindBack, map);
    }

    public void doCallFrontCashierPay(Activity activity, GetPayOrderListener getPayOrderListener, LBSPayBack lBSPayBack, Map<String, String> map, String str) {
        if (map == null) {
            return;
        }
        StatisticManager.onEvent(StatServiceEvent.EVENT_API_FRONTCASHIERPAY);
        String str2 = map.get("orderId");
        this.mOrderNo = str2;
        StatHelper.cacheOrderId(str2);
        double doubleValue = TextUtils.isEmpty(map.get("payAmount")) ? 0.0d : StringUtils.fen2YuanBigDecimal(map.get("payAmount")).doubleValue();
        StatHelper.cachePayAmount(doubleValue);
        List<String> collectData = StatHelper.collectData(this.mOrderNo, new String[0]);
        HashMap hashMap = new HashMap();
        hashMap.put(BaiduPay.AMOUNT, Double.valueOf(doubleValue));
        StatisticManager.onEventWithValues(PayStatServiceEvent.LBS_PAY_ENTER, collectData, hashMap);
        doDirectCallThirdPay(activity, getPayOrderListener, lBSPayBack, map, str);
    }

    public void doDirectCallThirdPay(final Activity activity, final GetPayOrderListener getPayOrderListener, final LBSPayBack lBSPayBack, final Map<String, String> map, final String str) {
        StatisticManager.onEvent(StatServiceEvent.EVENT_API_THIRDPAY);
        if (TextUtils.isEmpty(str) || map == null) {
            if (lBSPayBack != null) {
                lBSPayBack.onPayResult(2, "invalid parameter");
            }
        } else if (CheckUtils.isFastDoubleClick()) {
        } else {
            WalletLoginHelper.getInstance().setOpenBdussErrorCodeShowFlag(false);
            WalletLoginHelper.getInstance().verifyPassLogin(new LoginBackListenerProxy(activity, new ILoginBackListener() { // from class: com.baidu.android.lbspay.LBSPayInner.3
                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str2) {
                    LBSPayInner.this.directCallThirdPay(activity, getPayOrderListener, lBSPayBack, map, str);
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str2) {
                    LBSPayInner.this.directCallThirdPay(activity, getPayOrderListener, lBSPayBack, map, str);
                }
            }));
        }
    }

    public void doPolymerAuthorizeSign(final Activity activity, final LBSPayBack lBSPayBack, final Map<String, String> map) {
        if (activity == null || map == null || CheckUtils.isFastDoubleClick()) {
            return;
        }
        WalletLoginHelper.getInstance().setOpenBdussErrorCodeShowFlag(false);
        WalletLoginHelper.getInstance().verifyPassLogin(new LoginBackListenerProxy(activity, new ILoginBackListener() { // from class: com.baidu.android.lbspay.LBSPayInner.5
            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i2, String str) {
                LBSPayInner.this.polymerAuthorizeSign(activity, lBSPayBack, map);
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i2, String str) {
                LBSPayInner.this.polymerAuthorizeSign(activity, lBSPayBack, map);
            }
        }));
    }

    public void doPolymerPay(Context context, LBSPayBack lBSPayBack, Map<String, String> map) {
        doPolymerPay(context, lBSPayBack, map, null);
    }

    public LBSPayBack getCallBack() {
        return this.mLbsPayBack;
    }

    public String getOrderNo() {
        return this.mOrderNo;
    }

    public String getReqData(Context context) {
        WalletLoginHelper.getInstance().clearOpenBduss();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ua", BussinessUtils.getUA(context));
            jSONObject.put("cuid_1", EncodeUtils.encodeCommParms(PhoneUtils.getCUID(context)));
            jSONObject.put("supportList", String.valueOf(343L));
            jSONObject.put("wcp", PhoneUtils.getWCPParams(context));
            jSONObject.put("key", SafePay.getInstance().getpwProxy());
            String cookie = PayUtils.getCookie(context);
            if (!TextUtils.isEmpty(cookie)) {
                jSONObject.put(NetworkBean.PARAM_COOKIE, SafePay.getInstance().encryptProxy(cookie));
            } else {
                jSONObject.put(NetworkBean.PARAM_COOKIE, "");
            }
            String newCookie = PayUtils.getNewCookie(context);
            if (!TextUtils.isEmpty(newCookie)) {
                jSONObject.put(NetworkBean.PARAM_NEW_COOKIE, SafePay.getInstance().encryptProxy(newCookie));
            } else {
                jSONObject.put(NetworkBean.PARAM_NEW_COOKIE, "");
            }
            if (WalletLoginHelper.getInstance().isLogin()) {
                jSONObject.put("preOrder", "1");
            } else {
                jSONObject.put("preOrder", "0");
            }
            if (WalletFingerprint.getInstance(context).hasEnrollFingerprint()) {
                jSONObject.put("enroll_fingerprint", "1");
            }
        } catch (Exception e2) {
            String str = Tag;
            LogUtil.w(str, "getReqData error:" + e2.toString());
        }
        return jSONObject.toString();
    }

    public LBSPayInner() {
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.android.lbspay.LBSPayInner.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 101) {
                    Object obj = message.obj;
                    String str = (obj == null || !(obj instanceof String)) ? "" : (String) obj;
                    if (LBSPayInner.this.mCallback != null) {
                        LBSPayInner.this.mCallback.onResult(str);
                    }
                }
            }
        };
    }

    public void doPolymerPay(final Context context, final LBSPayBack lBSPayBack, final Map<String, String> map, final Map<String, String[]> map2) {
        if (context == null) {
            return;
        }
        if (CheckUtils.isFastDoubleClick()) {
            StatisticManager.onEvent(PayStatServiceEvent.FAST_DOUBLE_CLICK_DO_POLYMER_PAY);
            return;
        }
        StatisticManager.onEvent(StatServiceEvent.EVENT_API_DOPOLYMERPAY);
        if (map == null) {
            return;
        }
        WalletLoginHelper.getInstance().setOpenBdussErrorCodeShowFlag(false);
        WalletLoginHelper.getInstance().verifyPassLogin(new LoginBackListenerProxy(context, new ILoginBackListener() { // from class: com.baidu.android.lbspay.LBSPayInner.2
            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i2, String str) {
                LBSPayInner.this.polymerPay(context, lBSPayBack, map, map2);
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i2, String str) {
                LBSPayInner.this.polymerPay(context, lBSPayBack, map, map2);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void directCallThirdPay(Activity activity, Activity activity2, GetPayOrderListener getPayOrderListener, LBSPayBack lBSPayBack, Map<String, String> map, String str) {
        PayChannelController payChannelController = new PayChannelController(activity, activity2);
        this.mOrderNo = map.get("orderId");
        CashierDataNew cashierDataNew = new CashierDataNew();
        cashierDataNew.setData(map);
        this.mLbsPayBack = lBSPayBack;
        payChannelController.doDirectCallThirdPay(getPayOrderListener, cashierDataNew, str);
    }

    public void doDirectCallThirdPay(final Activity activity, final Activity activity2, final GetPayOrderListener getPayOrderListener, final LBSPayBack lBSPayBack, final Map<String, String> map, final String str) {
        StatisticManager.onEvent(StatServiceEvent.EVENT_API_THIRDPAY);
        if (TextUtils.isEmpty(str) || map == null || CheckUtils.isFastDoubleClick()) {
            return;
        }
        WalletLoginHelper.getInstance().setOpenBdussErrorCodeShowFlag(false);
        WalletLoginHelper.getInstance().verifyPassLogin(new LoginBackListenerProxy(activity, new ILoginBackListener() { // from class: com.baidu.android.lbspay.LBSPayInner.4
            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i2, String str2) {
                LBSPayInner.this.directCallThirdPay(activity, activity2, getPayOrderListener, lBSPayBack, map, str);
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i2, String str2) {
                LBSPayInner.this.directCallThirdPay(activity, activity2, getPayOrderListener, lBSPayBack, map, str);
            }
        }));
    }
}
