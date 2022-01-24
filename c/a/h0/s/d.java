package c.a.h0.s;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import c.a.h0.g;
import c.a.h0.i;
import c.a.h0.n.c;
import c.a.h0.r.h;
import c.a.h0.r.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.view.PayChannelController;
import com.baidu.poly.statistics.exception.SdkException;
import com.baidu.poly.widget.ChannelListView;
import com.baidu.poly.widget.PayChannelEntity;
import com.baidu.poly.widget.PayWebActivity;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.poly.widget.PolyNoticeDialog;
import com.baidu.poly.widget.PopupWindow;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.walletfacesdk.LightInvokerImpl;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.h0.s.c a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.h0.s.g.c f3795b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.h0.s.f.a f3796c;

    /* renamed from: d  reason: collision with root package name */
    public PolyNoticeDialog f3797d;

    /* loaded from: classes.dex */
    public class a extends c.a.h0.l.a<Map<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bundle a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PayChannelEntity f3798b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ChannelListView f3799c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f3800d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f3801e;

        public a(d dVar, Bundle bundle, PayChannelEntity payChannelEntity, ChannelListView channelListView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, bundle, payChannelEntity, channelListView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3801e = dVar;
            this.a = bundle;
            this.f3798b = payChannelEntity;
            this.f3799c = channelListView;
            this.f3800d = str;
        }

        @Override // c.a.h0.l.a
        public void b(Throwable th, String str) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, th, str) == null) {
                if (str != null) {
                    message = str;
                } else {
                    message = th != null ? th.getMessage() : null;
                }
                String string = this.a.getString(PolyActivity.PANEL_TYPE_KEY);
                String string2 = this.a.getString(PolyActivity.TRADE_TYPE);
                h.g("onWindowFocusChanged panelType=" + string + ", tradeType=" + string2);
                if (TextUtils.equals(string, PolyActivity.NONE_PANEL_TYPE) && TextUtils.equals(string2, PolyActivity.DIRECT_PAY_TRADE_TYPE)) {
                    this.f3799c.errorEnd(c.a.h0.r.d.c(l.a().getString(i.pay_first_interface_fail) + message), str);
                } else {
                    ChannelListView channelListView = this.f3799c;
                    channelListView.errorEnd(l.a().getString(i.pay_first_interface_fail) + message, str);
                }
                c.a.h0.p.c cVar = new c.a.h0.p.c("1");
                cVar.b(new SdkException("launchpayment error --> " + str, th).getStackMessage());
                c.a.h0.p.f.e(cVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.h0.l.a
        /* renamed from: d */
        public void c(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) {
                c.a.h0.n.c.b().d(map.get("orderInfoUrl"));
                c.a.h0.p.f.f3753e = map.get("orderId");
                String str = map.get("logicType");
                if (TextUtils.equals(str, "PASS_CHECK")) {
                    String str2 = map.get("authId");
                    if (this.f3801e.f3796c != null) {
                        c.a.h0.l.c cVar = new c.a.h0.l.c();
                        cVar.d("logicType", str);
                        cVar.d("authId", str2);
                        this.f3801e.f3796c.showNeedAuthDialog(new c.a.h0.s.a(cVar, this.a, this.f3798b));
                    }
                } else if (TextUtils.equals(str, "RISK_BLOCK")) {
                    if (this.f3801e.f3796c != null) {
                        this.f3801e.f3796c.showBlockDialog();
                    }
                } else if (TextUtils.equals(str, "DIRECT_OUTTER")) {
                    this.f3801e.o(this.f3798b, this.f3799c, map);
                } else if (TextUtils.equals(str, "SDK_TO_AGREEMENT")) {
                    this.f3801e.p(this.f3799c, map);
                } else if (TextUtils.equals(str, "SIGN_AFTER_PAY")) {
                    this.f3801e.q(this.f3799c, map);
                } else if (!TextUtils.equals(str, "DIRECT_DRMB")) {
                    this.f3801e.n(this.f3798b, this.f3799c, map, this.f3800d);
                } else {
                    this.f3799c.showVerifyView(map.get("orderId"), this.f3798b);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;

        public b(d dVar, ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = channelListView;
        }

        @Override // c.a.h0.n.c.b
        public void onResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) || this.a == null) {
                return;
            }
            this.a.payEnd(i2, c.a.h0.r.e.a(i2, "", str), "0");
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.h0.s.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChannelListView f3802b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f3803c;

        public c(d dVar, String str, ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3803c = dVar;
            this.a = str;
            this.f3802b = channelListView;
        }

        @Override // c.a.h0.s.g.a
        public void onResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                if (1 == i2) {
                    this.f3803c.t(this.a, this.f3802b);
                } else if (6 == i2) {
                    if (this.f3803c.f3797d != null) {
                        this.f3803c.f3797d.setTips("请点击查询按钮确认支付结果");
                        this.f3803c.f3797d.stopLoadingAnim();
                        this.f3803c.f3797d.setRightBtnEnable(true);
                    }
                } else if (i2 == 0) {
                    c.a.h0.p.f.e(new c.a.h0.p.c("108"));
                    this.f3802b.payEnd(i2, c.a.h0.r.e.a(i2, "", str), "0");
                } else if (3 == i2) {
                    c.a.h0.p.f.e(new c.a.h0.p.c(TbEnum.SystemMessage.EVENT_ID_INVITE_GROUP));
                    this.f3802b.payPause();
                    this.f3803c.u(this.f3802b);
                }
            }
        }
    }

    /* renamed from: c.a.h0.s.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0157d implements PolyNoticeDialog.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PolyNoticeDialog a;

        public C0157d(d dVar, PolyNoticeDialog polyNoticeDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, polyNoticeDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = polyNoticeDialog;
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.setTitle(EventAlias.PayEventAlias.PAY_FAIL);
                this.a.setTips("请确认账号余额，或选择其他支付方式");
                this.a.setSingleBtnText("我知道了");
            }
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void onOptionClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements PolyNoticeDialog.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f3804b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f3805c;

        /* loaded from: classes.dex */
        public class a implements c.a.h0.s.g.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // c.a.h0.s.g.a
            public void onResult(int i2, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                    if (6 == i2) {
                        this.a.f3805c.f3797d.setTips("请点击查询按钮确认支付结果");
                        this.a.f3805c.f3797d.stopLoadingAnim();
                        this.a.f3805c.f3797d.setRightBtnEnable(true);
                    } else if (i2 == 0) {
                        c.a.h0.p.f.e(new c.a.h0.p.c("108"));
                        this.a.a.payEnd(i2, c.a.h0.r.e.a(i2, "", str), "0");
                    } else if (3 == i2) {
                        c.a.h0.p.f.e(new c.a.h0.p.c(TbEnum.SystemMessage.EVENT_ID_INVITE_GROUP));
                        this.a.a.payPause();
                        e eVar = this.a;
                        eVar.f3805c.u(eVar.a);
                    }
                }
            }
        }

        public e(d dVar, ChannelListView channelListView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, channelListView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3805c = dVar;
            this.a = channelListView;
            this.f3804b = str;
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f3805c.f3797d.setTitle("确认小额免密支付结果");
                this.f3805c.f3797d.setTips("支付结果查询中 请稍后");
                this.f3805c.f3797d.startLoadingAnim();
                this.f3805c.f3797d.setActionLayoutBtnText("关闭", "查询");
                this.f3805c.f3797d.setRightBtnEnable(false);
            }
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.h0.n.b.h().f();
            }
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void onOptionClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                if (i2 == g.poly_notice_dialog_left_action_btn) {
                    c.a.h0.n.b.h().f();
                    this.a.payEnd(6, "支付结果查询失败，请重试", "0");
                    this.f3805c.f3797d.dismiss();
                } else if (i2 == g.poly_notice_dialog_right_action_btn) {
                    c.a.h0.p.f.e(new c.a.h0.p.c("111"));
                    this.f3805c.f3797d.setRightBtnEnable(false);
                    this.f3805c.f3797d.startLoadingAnim();
                    this.f3805c.f3797d.setTips("支付结果查询中 请稍后");
                    c.a.h0.n.b.h().g(this.f3804b, new a(this));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PopupWindow f3806e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ChannelListView f3807f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f3808g;

        public f(d dVar, PopupWindow popupWindow, ChannelListView channelListView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, popupWindow, channelListView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3806e = popupWindow;
            this.f3807f = channelListView;
            this.f3808g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PopupWindow popupWindow = this.f3806e;
                if (popupWindow != null && popupWindow.r()) {
                    this.f3806e.n();
                }
                this.f3807f.payEnd(0, this.f3808g, "0");
            }
        }
    }

    public d(c.a.h0.s.c cVar, c.a.h0.s.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cVar;
        this.f3796c = aVar;
    }

    public final void i(Map<String, String> map, PayChannelEntity payChannelEntity, String str, ChannelListView channelListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, map, payChannelEntity, str, channelListView) == null) {
            String str2 = map.get("extData");
            if (!TextUtils.isEmpty(str2)) {
                try {
                    if (TextUtils.equals(new JSONObject(str2).optString(LightInvokerImpl.VOICE_ACTIONTYPE), "H5")) {
                        String str3 = map.get("payUrl");
                        if (!TextUtils.isEmpty(str3)) {
                            if (j(channelListView.getContext())) {
                                channelListView.setWechatH5Pay(true);
                                channelListView.setIsPreparePaying(false);
                                k((Activity) channelListView.getContext(), str3, map);
                                c.a.h0.p.b.h("8");
                                HashMap hashMap = new HashMap();
                                hashMap.put("exceptionCode", "0");
                                if (!TextUtils.isEmpty(str)) {
                                    hashMap.put("isFoldChannel", str);
                                }
                                c.a.h0.p.b.c("8", hashMap);
                                return;
                            }
                            c.a.h0.p.b.g(119102, "3", PayChannelController.WXPAY_PAYCHANNEL, "-101", "没有安装微信");
                            Toast.makeText(channelListView.getContext(), "您没有安装微信，请选择其他支付方式", 0).show();
                            channelListView.payEnd(3, "wx_not_installed", "0");
                            return;
                        }
                        c.a.h0.p.b.g(119102, "3", PayChannelController.WXPAY_PAYCHANNEL, "-107", "调起微信H5链接无效");
                        channelListView.errorEnd("H5 no corresponding url ", null);
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("exceptionCode", "3");
                        hashMap2.put("errno", null);
                        hashMap2.put("errmsg", "H5 no corresponding url");
                        if (!TextUtils.isEmpty(str)) {
                            hashMap2.put("isFoldChannel", str);
                        }
                        c.a.h0.p.b.c("8", hashMap2);
                        return;
                    }
                } catch (Exception e2) {
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("exceptionType", "119502");
                    hashMap3.put("path", "cashier/launchpayment");
                    hashMap3.put("errCode", TbEnum.CustomGroupId.OFFICIAL_MERGE);
                    if (!TextUtils.isEmpty(str)) {
                        hashMap3.put("isFoldChannel", str);
                    }
                    hashMap3.put(StatConstants.KEY_EXT_ERR_MSG, e2.getMessage());
                    c.a.h0.p.b.c("8", hashMap3);
                    channelListView.errorEnd("launchpayment extData analyze failed ", null);
                    HashMap hashMap4 = new HashMap();
                    hashMap4.put("exceptionCode", "3");
                    hashMap4.put("errno", null);
                    hashMap4.put("errmsg", "launchpayment extData analyze failed");
                    if (!TextUtils.isEmpty(str)) {
                        hashMap4.put("isFoldChannel", str);
                    }
                    c.a.h0.p.b.c("8", hashMap4);
                    return;
                }
            }
            this.a.d(map, payChannelEntity, str, channelListView);
        }
    }

    public final boolean j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? context.getPackageManager().getPackageInfo("com.tencent.mm", 0) != null : invokeL.booleanValue;
    }

    public final void k(Activity activity, String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, str, map) == null) || activity == null || TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent(activity, PayWebActivity.class);
        intent.putExtra(PayWebActivity.LOAD_URL, str);
        Bundle bundle = new Bundle();
        for (String str2 : map.keySet()) {
            bundle.putString(str2, map.get(str2));
        }
        intent.putExtra(PayWebActivity.LAUNCH_PAYMENT_DATA, bundle);
        activity.startActivityForResult(intent, 200);
    }

    public void l(Bundle bundle, PayChannelEntity payChannelEntity, ChannelListView channelListView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, bundle, payChannelEntity, channelListView, str) == null) {
            m(null, bundle, payChannelEntity, channelListView, str);
        }
    }

    public void m(c.a.h0.l.c cVar, Bundle bundle, PayChannelEntity payChannelEntity, ChannelListView channelListView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, cVar, bundle, payChannelEntity, channelListView, str) == null) {
            if (payChannelEntity != null && payChannelEntity.isNeedAgreementGuide() && payChannelEntity.isAlreadySigned()) {
                c.a.h0.t.e.b.e(channelListView.getContext(), c.a.h0.f.ic_loading_4_toast, "小额免密扣款中");
            }
            c.a.h0.l.h.b.j().v(cVar, bundle, new a(this, bundle, payChannelEntity, channelListView, str), payChannelEntity, str);
        }
    }

    public final void n(PayChannelEntity payChannelEntity, ChannelListView channelListView, Map<String, String> map, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, payChannelEntity, channelListView, map, str) == null) {
            if (map.containsKey("parentType")) {
                String str2 = map.get("parentType");
                if (TextUtils.isEmpty(str2)) {
                    i(map, payChannelEntity, str, channelListView);
                    return;
                } else if (4 == Integer.parseInt(str2)) {
                    String a2 = c.a.h0.r.e.a(0, map.get("orderId"), "Successful payment");
                    PopupWindow popupWindow = new PopupWindow(View.inflate(channelListView.getContext(), c.a.h0.h.pay_success, null), -1, -1, true);
                    popupWindow.w(false);
                    popupWindow.y(false);
                    popupWindow.B(false);
                    popupWindow.D(channelListView, 0, 0, 0);
                    new Handler().postDelayed(new f(this, popupWindow, channelListView, a2), 2000L);
                    c.a.h0.p.b.h("8");
                    h.g("WalletList->pay() 命中0单元");
                    return;
                } else {
                    i(map, payChannelEntity, str, channelListView);
                    return;
                }
            }
            i(map, payChannelEntity, str, channelListView);
        }
    }

    public final void o(PayChannelEntity payChannelEntity, ChannelListView channelListView, Map<String, String> map) {
        boolean equalsIgnoreCase;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, payChannelEntity, channelListView, map) == null) {
            h.g("processDirectOuter ------ payChannel=" + payChannelEntity.getPayChannel());
            String str = map.get("extData");
            if (!TextUtils.isEmpty(str)) {
                try {
                    String optString = new JSONObject(str).optString(LightInvokerImpl.VOICE_ACTIONTYPE);
                    StringBuilder sb = new StringBuilder();
                    sb.append("processWxH5Pay actionType=");
                    sb.append(optString);
                    h.g(sb.toString());
                    equalsIgnoreCase = "H5".equalsIgnoreCase(optString);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (!equalsIgnoreCase && TextUtils.equals(PayChannelController.WXPAY_PAYCHANNEL, payChannelEntity.getPayChannel())) {
                    r(map, channelListView);
                    return;
                }
                this.a.f("DIRECT_OUTTER", map, payChannelEntity.getPayChannel(), channelListView, map.get("payResUrl"));
            }
            equalsIgnoreCase = false;
            if (!equalsIgnoreCase) {
            }
            this.a.f("DIRECT_OUTTER", map, payChannelEntity.getPayChannel(), channelListView, map.get("payResUrl"));
        }
    }

    public final void p(ChannelListView channelListView, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, channelListView, map) == null) {
            if (!TextUtils.equals(map.get("errCode"), "0")) {
                channelListView.payPause();
                u(channelListView);
                return;
            }
            String queryOrderString = channelListView.getSelectedPayChannelEntity().getQueryOrderString();
            c.a.h0.n.b.h().g(queryOrderString, new c(this, queryOrderString, channelListView));
        }
    }

    public final void q(ChannelListView channelListView, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, channelListView, map) == null) {
            String str = map.get("signUrl");
            try {
                Activity activity = (Activity) channelListView.getContext();
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("preEntrustWebId");
                this.f3795b.a(activity, jSONObject.optString("wechatAppId"), optString);
                c.a.h0.n.c.b().e(new b(this, channelListView));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void r(Map<String, String> map, ChannelListView channelListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, map, channelListView) == null) {
            String str = map.get("orderId");
            c.a.h0.p.f.f3753e = str;
            String str2 = map.get("extData");
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                if ("H5".equalsIgnoreCase(new JSONObject(str2).optString(LightInvokerImpl.VOICE_ACTIONTYPE))) {
                    String str3 = map.get("payUrl");
                    if (!TextUtils.isEmpty(str3)) {
                        if (j(channelListView.getContext())) {
                            channelListView.setWechatH5Pay(true);
                            channelListView.setIsPreparePaying(false);
                            k((Activity) channelListView.getContext(), str3, map);
                            c.a.h0.p.b.h("8");
                            channelListView.payEnd(1, c.a.h0.r.d.d(str, str3, "wx H5 paying"), "");
                        } else {
                            c.a.h0.p.b.g(119102, "3", PayChannelController.WXPAY_PAYCHANNEL, "-101", "没有安装微信");
                            Toast.makeText(channelListView.getContext(), "您没有安装微信，请选择其他支付方式", 0).show();
                            channelListView.payEnd(3, c.a.h0.r.d.d(str, str3, "wx_not_installed"), "0");
                        }
                    } else {
                        channelListView.errorEnd(c.a.h0.r.d.d(str, str3, "H5 no corresponding url "), null);
                        c.a.h0.p.b.b("8", null, "H5 no corresponding url");
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                channelListView.errorEnd(c.a.h0.r.d.d(str, "", "launchpayment extData analyze failed "), null);
                c.a.h0.p.b.b("8", null, "launchpayment extData analyze failed");
            }
        }
    }

    public void s(c.a.h0.s.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.f3795b = cVar;
        }
    }

    public final void t(String str, ChannelListView channelListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, channelListView) == null) {
            PolyNoticeDialog polyNoticeDialog = new PolyNoticeDialog();
            this.f3797d = polyNoticeDialog;
            polyNoticeDialog.setCancelable(false);
            this.f3797d.setOptionOnClickListener(new e(this, channelListView, str));
            this.f3797d.show(((Activity) channelListView.getContext()).getFragmentManager(), "QUERY_ORDER_NOTICE_FRAGMENT_TAG");
            c.a.h0.p.f.e(new c.a.h0.p.c(TbEnum.SystemMessage.EVENT_ID_COMMON));
        }
    }

    public final void u(ChannelListView channelListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, channelListView) == null) {
            PolyNoticeDialog polyNoticeDialog = new PolyNoticeDialog();
            polyNoticeDialog.setCancelable(true);
            polyNoticeDialog.setOptionOnClickListener(new C0157d(this, polyNoticeDialog));
            polyNoticeDialog.show(((Activity) channelListView.getContext()).getFragmentManager(), "PAY_FAILED_NOTICE_FRAGMENT_TAG");
        }
    }
}
