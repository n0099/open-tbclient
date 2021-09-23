package com.baidu.android.lbspay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.app.PayTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.activity.LBSTransActivity;
import com.baidu.android.lbspay.activity.LBSTransCashierActivity;
import com.baidu.android.lbspay.channelpay.alipay.LBSPayAli;
import com.baidu.android.lbspay.datamodel.AuthorizeData;
import com.baidu.android.lbspay.presenter.LBSTransPresenterFactory;
import com.baidu.android.lbspay.view.PayChannelController;
import com.baidu.android.pay.BindBack;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.core.beans.NetworkBean;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.utils.BussinessUtils;
import com.dxmpay.apollon.utils.CheckUtils;
import com.dxmpay.apollon.utils.EncodeUtils;
import com.dxmpay.apollon.utils.PhoneUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.passport.LoginBackListenerProxy;
import com.dxmpay.wallet.paysdk.PayUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LBSPayInner {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATE_CODE_CANCEL = 2;
    public static final int STATE_CODE_FAILD = 3;
    public static final int STATE_CODE_PAYING = 1;
    public static final int STATE_CODE_SUCCEED = 0;
    public static final String Tag = "LBSPayInner";
    public transient /* synthetic */ FieldHolder $fh;
    public AliPayCallback mAliPayCallback;
    public Handler mHandler;
    public LBSPayBack mLbsPayBack;
    public String mOrderNo;

    /* loaded from: classes4.dex */
    public interface AliPayCallback {
        void onResult(String str);
    }

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static LBSPayInner f36790a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1719206711, "Lcom/baidu/android/lbspay/LBSPayInner$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1719206711, "Lcom/baidu/android/lbspay/LBSPayInner$a;");
                    return;
                }
            }
            f36790a = new LBSPayInner();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1692063910, "Lcom/baidu/android/lbspay/LBSPayInner;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1692063910, "Lcom/baidu/android/lbspay/LBSPayInner;");
        }
    }

    private void LBSCashierEnterSensor(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, map) == null) || map == null) {
            return;
        }
        StatHelper.clearSensor();
        StatHelper.cachePayFrom("2");
        StatHelper.cacheOrderId(this.mOrderNo);
        StatisticManager.onEventStart(PayStatServiceEvent.PAY_DURATION);
        double fen2YuanBigDecimal = TextUtils.isEmpty(map.get("payAmount")) ? 0.0d : StatHelper.fen2YuanBigDecimal(map.get("payAmount"));
        StatHelper.cachePayAmount(fen2YuanBigDecimal);
        List<String> collectData = StatHelper.collectData(this.mOrderNo, new String[0]);
        HashMap hashMap = new HashMap();
        hashMap.put("pay_amount", Double.valueOf(fen2YuanBigDecimal));
        StatisticManager.onEventWithValues(PayStatServiceEvent.LBS_PAY_ENTER, collectData, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void directCallThirdPay(Activity activity, GetPayOrderListener getPayOrderListener, LBSPayBack lBSPayBack, Map<String, String> map, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65547, this, activity, getPayOrderListener, lBSPayBack, map, str) == null) {
            PayChannelController payChannelController = new PayChannelController(activity);
            this.mOrderNo = map.get("orderId");
            LBSCashierEnterSensor(map);
            CashierDataNew cashierDataNew = new CashierDataNew();
            cashierDataNew.setData(map);
            this.mLbsPayBack = lBSPayBack;
            payChannelController.doDirectCallThirdPay(getPayOrderListener, cashierDataNew, str);
        }
    }

    public static LBSPayInner getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? a.f36790a : (LBSPayInner) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void polymerAuthorizeSign(Activity activity, LBSPayBack lBSPayBack, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, this, activity, lBSPayBack, map) == null) {
            this.mLbsPayBack = lBSPayBack;
            AuthorizeData authorizeData = new AuthorizeData();
            authorizeData.setData(map);
            Intent intent = new Intent(activity, LBSTransActivity.class);
            intent.putExtra(AuthorizeData.DELIVERY_AUTHORIZE_DATA, authorizeData);
            intent.putExtra(LBSTransActivity.PRESENTER_TYPE, LBSTransPresenterFactory.TRANS_AUTH_PRESENTER);
            activity.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void polymerPay(Context context, LBSPayBack lBSPayBack, Map<String, String> map, Map<String, String[]> map2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65550, this, context, lBSPayBack, map, map2) == null) || map == null) {
            return;
        }
        StatHelper.clearSensor();
        StatHelper.cachePayFrom("2");
        StatisticManager.onEventStart(PayStatServiceEvent.PAY_DURATION);
        this.mLbsPayBack = lBSPayBack;
        String str = map.get("orderId");
        this.mOrderNo = str;
        StatHelper.cacheOrderId(str);
        double fen2YuanBigDecimal = TextUtils.isEmpty(map.get("payAmount")) ? 0.0d : StatHelper.fen2YuanBigDecimal(map.get("payAmount"));
        StatHelper.cachePayAmount(fen2YuanBigDecimal);
        List<String> collectData = StatHelper.collectData(this.mOrderNo, new String[0]);
        HashMap hashMap = new HashMap();
        hashMap.put("pay_amount", Double.valueOf(fen2YuanBigDecimal));
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
        intent.addFlags(268435456);
        context.getApplicationContext().startActivity(intent);
    }

    public void clearLbsPayBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mLbsPayBack = null;
            LBSPayAli.getInstance().clearChannelPay();
        }
    }

    public void doAliPay(Activity activity, String str, boolean z, AliPayCallback aliPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{activity, str, Boolean.valueOf(z), aliPayCallback}) == null) {
            this.mAliPayCallback = aliPayCallback;
            Runnable runnable = new Runnable(this, activity, str, z) { // from class: com.baidu.android.lbspay.LBSPayInner.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Activity f36786a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f36787b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ boolean f36788c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ LBSPayInner f36789d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, activity, str, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36789d = this;
                    this.f36786a = activity;
                    this.f36787b = str;
                    this.f36788c = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        JSONObject jSONObject = new JSONObject(new PayTask(this.f36786a).payV2(this.f36787b, this.f36788c));
                        Message message = new Message();
                        message.what = 101;
                        message.obj = jSONObject.toString();
                        StatisticManager.onEventWithValue(PayStatServiceEvent.LBS_ALIPAY_RESULT, jSONObject.toString());
                        this.f36789d.mHandler.sendMessage(message);
                    }
                }
            };
            StatisticManager.onEventWithValue(PayStatServiceEvent.LBS_ALIPAY_ENTER, str);
            new Thread(runnable).start();
        }
    }

    public void doBindCard(Context context, BindBack bindBack, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, bindBack, map) == null) {
            StatisticManager.onEvent("#doBindCard");
            BaiduPayDelegate.getInstance().doBind(context, bindBack, map);
        }
    }

    public void doCallFrontCashierPay(Activity activity, GetPayOrderListener getPayOrderListener, LBSPayBack lBSPayBack, Map<String, String> map, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048579, this, activity, getPayOrderListener, lBSPayBack, map, str) == null) || map == null) {
            return;
        }
        StatisticManager.onEvent("#doFrontCashierPay");
        this.mOrderNo = map.get("orderId");
        doDirectCallThirdPay(activity, getPayOrderListener, lBSPayBack, map, str);
    }

    public void doDirectCallThirdPay(Activity activity, GetPayOrderListener getPayOrderListener, LBSPayBack lBSPayBack, Map<String, String> map, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048581, this, activity, getPayOrderListener, lBSPayBack, map, str) == null) {
            StatisticManager.onEvent("#doThirdPay");
            if (TextUtils.isEmpty(str) || map == null) {
                if (lBSPayBack != null) {
                    lBSPayBack.onPayResult(2, "invalid parameter");
                }
            } else if (CheckUtils.isFastDoubleClick()) {
            } else {
                WalletLoginHelper.getInstance().setOpenBdussErrorCodeShowFlag(false);
                WalletLoginHelper.getInstance().verifyPassLogin(new LoginBackListenerProxy(activity, new ILoginBackListener(this, activity, getPayOrderListener, lBSPayBack, map, str) { // from class: com.baidu.android.lbspay.LBSPayInner.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Activity f36769a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ GetPayOrderListener f36770b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ LBSPayBack f36771c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ Map f36772d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ String f36773e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ LBSPayInner f36774f;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, activity, getPayOrderListener, lBSPayBack, map, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f36774f = this;
                        this.f36769a = activity;
                        this.f36770b = getPayOrderListener;
                        this.f36771c = lBSPayBack;
                        this.f36772d = map;
                        this.f36773e = str;
                    }

                    @Override // com.baidu.wallet.api.ILoginBackListener
                    public void onFail(int i2, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                            this.f36774f.directCallThirdPay(this.f36769a, this.f36770b, this.f36771c, this.f36772d, this.f36773e);
                        }
                    }

                    @Override // com.baidu.wallet.api.ILoginBackListener
                    public void onSuccess(int i2, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) {
                            this.f36774f.directCallThirdPay(this.f36769a, this.f36770b, this.f36771c, this.f36772d, this.f36773e);
                        }
                    }
                }));
            }
        }
    }

    public void doPolymerAuthorizeSign(Activity activity, LBSPayBack lBSPayBack, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, activity, lBSPayBack, map) == null) || activity == null || map == null || CheckUtils.isFastDoubleClick()) {
            return;
        }
        WalletLoginHelper.getInstance().setOpenBdussErrorCodeShowFlag(false);
        WalletLoginHelper.getInstance().verifyPassLogin(new LoginBackListenerProxy(activity, new ILoginBackListener(this, activity, lBSPayBack, map) { // from class: com.baidu.android.lbspay.LBSPayInner.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Activity f36782a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ LBSPayBack f36783b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Map f36784c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ LBSPayInner f36785d;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, activity, lBSPayBack, map};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f36785d = this;
                this.f36782a = activity;
                this.f36783b = lBSPayBack;
                this.f36784c = map;
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                    this.f36785d.polymerAuthorizeSign(this.f36782a, this.f36783b, this.f36784c);
                }
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                    this.f36785d.polymerAuthorizeSign(this.f36782a, this.f36783b, this.f36784c);
                }
            }
        }));
    }

    public void doPolymerPay(Context context, LBSPayBack lBSPayBack, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, context, lBSPayBack, map) == null) {
            doPolymerPay(context, lBSPayBack, map, null);
        }
    }

    public LBSPayBack getCallBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mLbsPayBack : (LBSPayBack) invokeV.objValue;
    }

    public String getOrderNo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mOrderNo : (String) invokeV.objValue;
    }

    public String getReqData(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, context)) == null) {
            WalletLoginHelper.getInstance().clearOpenBduss();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ua", BussinessUtils.getUA(context));
                jSONObject.put("cuid_1", EncodeUtils.encodeCommParms(PhoneUtils.getCUID(context)));
                jSONObject.put("supportList", String.valueOf(343L));
                jSONObject.put("wcp", PhoneUtils.getWCPParams(context));
                jSONObject.put("key", SecurePay.getInstance().getpwProxy());
                String cookie = PayUtils.getCookie(context);
                if (!TextUtils.isEmpty(cookie)) {
                    jSONObject.put(NetworkBean.PARAM_COOKIE, SecurePay.getInstance().encryptProxy(cookie));
                } else {
                    jSONObject.put(NetworkBean.PARAM_COOKIE, "");
                }
                String newCookie = PayUtils.getNewCookie(context);
                if (!TextUtils.isEmpty(newCookie)) {
                    jSONObject.put(NetworkBean.PARAM_NEW_COOKIE, SecurePay.getInstance().encryptProxy(newCookie));
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
                String str = "getReqData error:" + e2.toString();
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public LBSPayInner() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mHandler = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.android.lbspay.LBSPayInner.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LBSPayInner f36763a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super((Looper) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f36763a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    super.handleMessage(message);
                    if (message.what == 101) {
                        Object obj = message.obj;
                        String str = (obj == null || !(obj instanceof String)) ? "" : (String) obj;
                        if (this.f36763a.mAliPayCallback != null) {
                            this.f36763a.mAliPayCallback.onResult(str);
                        }
                    }
                }
            }
        };
    }

    public void doPolymerPay(Context context, LBSPayBack lBSPayBack, Map<String, String> map, Map<String, String[]> map2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, lBSPayBack, map, map2) == null) || context == null) {
            return;
        }
        if (CheckUtils.isFastDoubleClick()) {
            StatisticManager.onEvent(PayStatServiceEvent.FAST_DOUBLE_CLICK_DO_POLYMER_PAY);
            return;
        }
        StatisticManager.onEvent("#doPolymerPay");
        if (map == null) {
            return;
        }
        WalletLoginHelper.getInstance().setOpenBdussErrorCodeShowFlag(false);
        WalletLoginHelper.getInstance().verifyPassLogin(new LoginBackListenerProxy(context, new ILoginBackListener(this, context, lBSPayBack, map, map2) { // from class: com.baidu.android.lbspay.LBSPayInner.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f36764a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ LBSPayBack f36765b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Map f36766c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ Map f36767d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ LBSPayInner f36768e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, context, lBSPayBack, map, map2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f36768e = this;
                this.f36764a = context;
                this.f36765b = lBSPayBack;
                this.f36766c = map;
                this.f36767d = map2;
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                    this.f36768e.polymerPay(this.f36764a, this.f36765b, this.f36766c, this.f36767d);
                }
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                    this.f36768e.polymerPay(this.f36764a, this.f36765b, this.f36766c, this.f36767d);
                }
            }
        }));
    }

    public void doDirectCallThirdPay(Activity activity, Activity activity2, GetPayOrderListener getPayOrderListener, LBSPayBack lBSPayBack, Map<String, String> map, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{activity, activity2, getPayOrderListener, lBSPayBack, map, str}) == null) {
            StatisticManager.onEvent("#doThirdPay");
            if (TextUtils.isEmpty(str) || map == null || CheckUtils.isFastDoubleClick()) {
                return;
            }
            WalletLoginHelper.getInstance().setOpenBdussErrorCodeShowFlag(false);
            WalletLoginHelper.getInstance().verifyPassLogin(new LoginBackListenerProxy(activity, new ILoginBackListener(this, activity, activity2, getPayOrderListener, lBSPayBack, map, str) { // from class: com.baidu.android.lbspay.LBSPayInner.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Activity f36775a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Activity f36776b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ GetPayOrderListener f36777c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ LBSPayBack f36778d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Map f36779e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ String f36780f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ LBSPayInner f36781g;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, activity, activity2, getPayOrderListener, lBSPayBack, map, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36781g = this;
                    this.f36775a = activity;
                    this.f36776b = activity2;
                    this.f36777c = getPayOrderListener;
                    this.f36778d = lBSPayBack;
                    this.f36779e = map;
                    this.f36780f = str;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                        this.f36781g.directCallThirdPay(this.f36775a, this.f36776b, this.f36777c, this.f36778d, this.f36779e, this.f36780f);
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) {
                        this.f36781g.directCallThirdPay(this.f36775a, this.f36776b, this.f36777c, this.f36778d, this.f36779e, this.f36780f);
                    }
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void directCallThirdPay(Activity activity, Activity activity2, GetPayOrderListener getPayOrderListener, LBSPayBack lBSPayBack, Map<String, String> map, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, this, new Object[]{activity, activity2, getPayOrderListener, lBSPayBack, map, str}) == null) {
            PayChannelController payChannelController = new PayChannelController(activity, activity2);
            this.mOrderNo = map.get("orderId");
            LBSCashierEnterSensor(map);
            CashierDataNew cashierDataNew = new CashierDataNew();
            cashierDataNew.setData(map);
            this.mLbsPayBack = lBSPayBack;
            payChannelController.doDirectCallThirdPay(getPayOrderListener, cashierDataNew, str);
        }
    }
}
