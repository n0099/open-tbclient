package c.a.e0.j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import c.a.e0.e.c;
import c.a.e0.i.h;
import c.a.e0.i.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.statistics.exception.SdkException;
import com.baidu.poly.widget.ChannelListView;
import com.baidu.poly.widget.PayChannelEntity;
import com.baidu.poly.widget.PayWebActivity;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.poly.widget.PolyNoticeDialog;
import com.baidu.poly.widget.PopupWindow;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.e0.j.c a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.e0.j.g.c f2832b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.e0.j.f.a f2833c;

    /* renamed from: d  reason: collision with root package name */
    public PolyNoticeDialog f2834d;

    /* loaded from: classes.dex */
    public class a extends c.a.e0.c.a<Map<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bundle a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PayChannelEntity f2835b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ChannelListView f2836c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f2837d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f2838e;

        public a(d dVar, Bundle bundle, PayChannelEntity payChannelEntity, ChannelListView channelListView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, bundle, payChannelEntity, channelListView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2838e = dVar;
            this.a = bundle;
            this.f2835b = payChannelEntity;
            this.f2836c = channelListView;
            this.f2837d = str;
        }

        @Override // c.a.e0.c.a
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
                if (TextUtils.equals(string, "NONE") && TextUtils.equals(string2, PolyActivity.DIRECT_PAY_TRADE_TYPE)) {
                    this.f2836c.R(c.a.e0.i.d.c(l.a().getString(R.string.obfuscated_res_0x7f0f0d44) + message), str);
                } else {
                    ChannelListView channelListView = this.f2836c;
                    channelListView.R(l.a().getString(R.string.obfuscated_res_0x7f0f0d44) + message, str);
                }
                c.a.e0.g.c cVar = new c.a.e0.g.c("1");
                cVar.b(new SdkException("launchpayment error --> " + str, th).getStackMessage());
                c.a.e0.g.f.e(cVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e0.c.a
        /* renamed from: d */
        public void c(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) {
                c.a.e0.e.c.b().d(map.get("orderInfoUrl"));
                c.a.e0.g.f.f2796e = map.get("orderId");
                String str = map.get("logicType");
                if (TextUtils.equals(str, "PASS_CHECK")) {
                    String str2 = map.get("authId");
                    if (this.f2838e.f2833c != null) {
                        c.a.e0.c.c cVar = new c.a.e0.c.c();
                        cVar.d("logicType", str);
                        cVar.d("authId", str2);
                        this.f2838e.f2833c.showNeedAuthDialog(new c.a.e0.j.a(cVar, this.a, this.f2835b));
                    }
                } else if (TextUtils.equals(str, "RISK_BLOCK")) {
                    if (this.f2838e.f2833c != null) {
                        this.f2838e.f2833c.showBlockDialog();
                    }
                } else if (TextUtils.equals(str, "DIRECT_OUTTER")) {
                    this.f2838e.o(this.f2835b, this.f2836c, map);
                } else if (TextUtils.equals(str, "SDK_TO_AGREEMENT")) {
                    this.f2838e.p(this.f2836c, map);
                } else if (TextUtils.equals(str, "SIGN_AFTER_PAY")) {
                    this.f2838e.q(this.f2836c, map);
                } else if (!TextUtils.equals(str, "DIRECT_DRMB")) {
                    this.f2838e.n(this.f2835b, this.f2836c, map, this.f2837d);
                } else {
                    this.f2836c.o0(map.get("orderId"), this.f2835b);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = channelListView;
        }

        @Override // c.a.e0.e.c.b
        public void onResult(int i, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) || this.a == null) {
                return;
            }
            this.a.a0(i, c.a.e0.i.e.a(i, "", str), "0");
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.e0.j.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChannelListView f2839b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f2840c;

        public c(d dVar, String str, ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2840c = dVar;
            this.a = str;
            this.f2839b = channelListView;
        }

        @Override // c.a.e0.j.g.a
        public void onResult(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                if (1 == i) {
                    this.f2840c.t(this.a, this.f2839b);
                } else if (6 == i) {
                    if (this.f2840c.f2834d != null) {
                        this.f2840c.f2834d.setTips("请点击查询按钮确认支付结果");
                        this.f2840c.f2834d.stopLoadingAnim();
                        this.f2840c.f2834d.setRightBtnEnable(true);
                    }
                } else if (i == 0) {
                    c.a.e0.g.f.e(new c.a.e0.g.c("108"));
                    this.f2839b.a0(i, c.a.e0.i.e.a(i, "", str), "0");
                } else if (3 == i) {
                    c.a.e0.g.f.e(new c.a.e0.g.c(TbEnum.SystemMessage.EVENT_ID_INVITE_GROUP));
                    this.f2839b.c0();
                    this.f2840c.u(this.f2839b);
                }
            }
        }
    }

    /* renamed from: c.a.e0.j.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0128d implements PolyNoticeDialog.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PolyNoticeDialog a;

        public C0128d(d dVar, PolyNoticeDialog polyNoticeDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, polyNoticeDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        public void onOptionClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
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
        public final /* synthetic */ String f2841b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f2842c;

        /* loaded from: classes.dex */
        public class a implements c.a.e0.j.g.a {
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // c.a.e0.j.g.a
            public void onResult(int i, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                    if (6 == i) {
                        this.a.f2842c.f2834d.setTips("请点击查询按钮确认支付结果");
                        this.a.f2842c.f2834d.stopLoadingAnim();
                        this.a.f2842c.f2834d.setRightBtnEnable(true);
                    } else if (i == 0) {
                        c.a.e0.g.f.e(new c.a.e0.g.c("108"));
                        this.a.a.a0(i, c.a.e0.i.e.a(i, "", str), "0");
                    } else if (3 == i) {
                        c.a.e0.g.f.e(new c.a.e0.g.c(TbEnum.SystemMessage.EVENT_ID_INVITE_GROUP));
                        this.a.a.c0();
                        e eVar = this.a;
                        eVar.f2842c.u(eVar.a);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2842c = dVar;
            this.a = channelListView;
            this.f2841b = str;
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f2842c.f2834d.setTitle("确认小额免密支付结果");
                this.f2842c.f2834d.setTips("支付结果查询中 请稍后");
                this.f2842c.f2834d.startLoadingAnim();
                this.f2842c.f2834d.setActionLayoutBtnText("关闭", "查询");
                this.f2842c.f2834d.setRightBtnEnable(false);
            }
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.e0.e.b.h().f();
            }
        }

        @Override // com.baidu.poly.widget.PolyNoticeDialog.a
        public void onOptionClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                if (i == R.id.obfuscated_res_0x7f091875) {
                    c.a.e0.e.b.h().f();
                    this.a.a0(6, "支付结果查询失败，请重试", "0");
                    this.f2842c.f2834d.dismiss();
                } else if (i == R.id.obfuscated_res_0x7f091877) {
                    c.a.e0.g.f.e(new c.a.e0.g.c("111"));
                    this.f2842c.f2834d.setRightBtnEnable(false);
                    this.f2842c.f2834d.startLoadingAnim();
                    this.f2842c.f2834d.setTips("支付结果查询中 请稍后");
                    c.a.e0.e.b.h().g(this.f2841b, new a(this));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PopupWindow a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChannelListView f2843b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f2844c;

        public f(d dVar, PopupWindow popupWindow, ChannelListView channelListView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, popupWindow, channelListView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = popupWindow;
            this.f2843b = channelListView;
            this.f2844c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PopupWindow popupWindow = this.a;
                if (popupWindow != null && popupWindow.r()) {
                    this.a.n();
                }
                this.f2843b.a0(0, this.f2844c, "0");
            }
        }
    }

    public d(c.a.e0.j.c cVar, c.a.e0.j.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cVar;
        this.f2833c = aVar;
    }

    public final void i(Map<String, String> map, PayChannelEntity payChannelEntity, String str, ChannelListView channelListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, map, payChannelEntity, str, channelListView) == null) {
            String str2 = map.get("extData");
            if (!TextUtils.isEmpty(str2)) {
                try {
                    if (TextUtils.equals(new JSONObject(str2).optString("actionType"), "H5")) {
                        String str3 = map.get("payUrl");
                        if (!TextUtils.isEmpty(str3)) {
                            if (j(channelListView.getContext())) {
                                channelListView.setWechatH5Pay(true);
                                channelListView.setIsPreparePaying(false);
                                k((Activity) channelListView.getContext(), str3, map);
                                c.a.e0.g.b.h("8");
                                HashMap hashMap = new HashMap();
                                hashMap.put("exceptionCode", "0");
                                if (!TextUtils.isEmpty(str)) {
                                    hashMap.put("isFoldChannel", str);
                                }
                                c.a.e0.g.b.c("8", hashMap);
                                return;
                            }
                            c.a.e0.g.b.g(119102, "3", "BAIDU-SUPER-WECHAT-WISE", "-101", "没有安装微信");
                            Toast.makeText(channelListView.getContext(), "您没有安装微信，请选择其他支付方式", 0).show();
                            channelListView.a0(3, "wx_not_installed", "0");
                            return;
                        }
                        c.a.e0.g.b.g(119102, "3", "BAIDU-SUPER-WECHAT-WISE", "-107", "调起微信H5链接无效");
                        channelListView.R("H5 no corresponding url ", null);
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("exceptionCode", "3");
                        hashMap2.put("errno", null);
                        hashMap2.put("errmsg", "H5 no corresponding url");
                        if (!TextUtils.isEmpty(str)) {
                            hashMap2.put("isFoldChannel", str);
                        }
                        c.a.e0.g.b.c("8", hashMap2);
                        return;
                    }
                } catch (Exception e2) {
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("exceptionType", "119502");
                    hashMap3.put("path", "cashier/launchpayment");
                    hashMap3.put(StatConstants.KEY_EXT_ERR_CODE, TbEnum.CustomGroupId.OFFICIAL_MERGE);
                    if (!TextUtils.isEmpty(str)) {
                        hashMap3.put("isFoldChannel", str);
                    }
                    hashMap3.put(StatConstants.KEY_EXT_ERR_MSG, e2.getMessage());
                    c.a.e0.g.b.c("8", hashMap3);
                    channelListView.R("launchpayment extData analyze failed ", null);
                    HashMap hashMap4 = new HashMap();
                    hashMap4.put("exceptionCode", "3");
                    hashMap4.put("errno", null);
                    hashMap4.put("errmsg", "launchpayment extData analyze failed");
                    if (!TextUtils.isEmpty(str)) {
                        hashMap4.put("isFoldChannel", str);
                    }
                    c.a.e0.g.b.c("8", hashMap4);
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

    public void m(c.a.e0.c.c cVar, Bundle bundle, PayChannelEntity payChannelEntity, ChannelListView channelListView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, cVar, bundle, payChannelEntity, channelListView, str) == null) {
            if (payChannelEntity != null && payChannelEntity.isNeedAgreementGuide() && payChannelEntity.isAlreadySigned()) {
                c.a.e0.k.g.b.e(channelListView.getContext(), R.drawable.obfuscated_res_0x7f08063a, "小额免密扣款中");
            }
            c.a.e0.c.h.b.j().v(cVar, bundle, new a(this, bundle, payChannelEntity, channelListView, str), payChannelEntity, str);
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
                    String a2 = c.a.e0.i.e.a(0, map.get("orderId"), "Successful payment");
                    PopupWindow popupWindow = new PopupWindow(View.inflate(channelListView.getContext(), R.layout.obfuscated_res_0x7f0d065b, null), -1, -1, true);
                    popupWindow.w(false);
                    popupWindow.y(false);
                    popupWindow.B(false);
                    popupWindow.D(channelListView, 0, 0, 0);
                    new Handler().postDelayed(new f(this, popupWindow, channelListView, a2), 2000L);
                    c.a.e0.g.b.h("8");
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
                    String optString = new JSONObject(str).optString("actionType");
                    StringBuilder sb = new StringBuilder();
                    sb.append("processWxH5Pay actionType=");
                    sb.append(optString);
                    h.g(sb.toString());
                    equalsIgnoreCase = "H5".equalsIgnoreCase(optString);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (!equalsIgnoreCase && TextUtils.equals("BAIDU-SUPER-WECHAT-WISE", payChannelEntity.getPayChannel())) {
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
            if (!TextUtils.equals(map.get(StatConstants.KEY_EXT_ERR_CODE), "0")) {
                channelListView.c0();
                u(channelListView);
                return;
            }
            String queryOrderString = channelListView.getSelectedPayChannelEntity().getQueryOrderString();
            c.a.e0.e.b.h().g(queryOrderString, new c(this, queryOrderString, channelListView));
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
                this.f2832b.a(activity, jSONObject.optString("wechatAppId"), optString);
                c.a.e0.e.c.b().e(new b(this, channelListView));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void r(Map<String, String> map, ChannelListView channelListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, map, channelListView) == null) {
            String str = map.get("orderId");
            c.a.e0.g.f.f2796e = str;
            String str2 = map.get("extData");
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                if ("H5".equalsIgnoreCase(new JSONObject(str2).optString("actionType"))) {
                    String str3 = map.get("payUrl");
                    if (!TextUtils.isEmpty(str3)) {
                        if (j(channelListView.getContext())) {
                            channelListView.setWechatH5Pay(true);
                            channelListView.setIsPreparePaying(false);
                            k((Activity) channelListView.getContext(), str3, map);
                            c.a.e0.g.b.h("8");
                            channelListView.a0(1, c.a.e0.i.d.d(str, str3, "wx H5 paying"), "");
                        } else {
                            c.a.e0.g.b.g(119102, "3", "BAIDU-SUPER-WECHAT-WISE", "-101", "没有安装微信");
                            Toast.makeText(channelListView.getContext(), "您没有安装微信，请选择其他支付方式", 0).show();
                            channelListView.a0(3, c.a.e0.i.d.d(str, str3, "wx_not_installed"), "0");
                        }
                    } else {
                        channelListView.R(c.a.e0.i.d.d(str, str3, "H5 no corresponding url "), null);
                        c.a.e0.g.b.b("8", null, "H5 no corresponding url");
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                channelListView.R(c.a.e0.i.d.d(str, "", "launchpayment extData analyze failed "), null);
                c.a.e0.g.b.b("8", null, "launchpayment extData analyze failed");
            }
        }
    }

    public void s(c.a.e0.j.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.f2832b = cVar;
        }
    }

    public final void t(String str, ChannelListView channelListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, channelListView) == null) {
            PolyNoticeDialog polyNoticeDialog = new PolyNoticeDialog();
            this.f2834d = polyNoticeDialog;
            polyNoticeDialog.setCancelable(false);
            this.f2834d.setOptionOnClickListener(new e(this, channelListView, str));
            this.f2834d.show(((Activity) channelListView.getContext()).getFragmentManager(), "QUERY_ORDER_NOTICE_FRAGMENT_TAG");
            c.a.e0.g.f.e(new c.a.e0.g.c(TbEnum.SystemMessage.EVENT_ID_COMMON));
        }
    }

    public final void u(ChannelListView channelListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, channelListView) == null) {
            PolyNoticeDialog polyNoticeDialog = new PolyNoticeDialog();
            polyNoticeDialog.setCancelable(true);
            polyNoticeDialog.setOptionOnClickListener(new C0128d(this, polyNoticeDialog));
            polyNoticeDialog.show(((Activity) channelListView.getContext()).getFragmentManager(), "PAY_FAILED_NOTICE_FRAGMENT_TAG");
        }
    }
}
