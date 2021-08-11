package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.app.PayResultActivity;
import com.alipay.sdk.data.a;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.util.H5PayResultModel;
import com.alipay.sdk.util.e;
import com.alipay.sdk.util.f;
import com.alipay.sdk.util.i;
import com.alipay.sdk.util.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.channelpay.alipay.Result;
import com.baidu.android.lbspay.presenter.LBSTransAuthPresenter;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PayTask {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final Object f35656a;

    /* renamed from: i  reason: collision with root package name */
    public static long f35657i = 0;

    /* renamed from: j  reason: collision with root package name */
    public static final long f35658j = 3000;
    public static long k = -1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Activity f35659b;

    /* renamed from: c  reason: collision with root package name */
    public com.alipay.sdk.widget.a f35660c;

    /* renamed from: d  reason: collision with root package name */
    public final String f35661d;

    /* renamed from: e  reason: collision with root package name */
    public final String f35662e;

    /* renamed from: f  reason: collision with root package name */
    public final String f35663f;

    /* renamed from: g  reason: collision with root package name */
    public final String f35664g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, a> f35665h;

    /* loaded from: classes4.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PayTask f35671a;

        /* renamed from: b  reason: collision with root package name */
        public String f35672b;

        /* renamed from: c  reason: collision with root package name */
        public String f35673c;

        /* renamed from: d  reason: collision with root package name */
        public String f35674d;

        /* renamed from: e  reason: collision with root package name */
        public String f35675e;

        public a(PayTask payTask) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payTask};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35671a = payTask;
            this.f35672b = "";
            this.f35673c = "";
            this.f35674d = "";
            this.f35675e = "";
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f35672b : (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f35674d : (String) invokeV.objValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f35673c : (String) invokeV.objValue;
        }

        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f35675e : (String) invokeV.objValue;
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f35672b = str;
            }
        }

        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f35674d = str;
            }
        }

        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.f35673c = str;
            }
        }

        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
                this.f35675e = str;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(585070172, "Lcom/alipay/sdk/app/PayTask;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(585070172, "Lcom/alipay/sdk/app/PayTask;");
                return;
            }
        }
        f35656a = e.class;
    }

    public PayTask(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f35661d = "wappaygw.alipay.com/service/rest.htm";
        this.f35662e = "mclient.alipay.com/service/rest.htm";
        this.f35663f = "mclient.alipay.com/home/exterfaceAssign.htm";
        this.f35664g = "mclient.alipay.com/cashier/mobilepay.htm";
        this.f35665h = new HashMap();
        this.f35659b = activity;
        com.alipay.sdk.sys.b.a().a(this.f35659b);
        this.f35660c = new com.alipay.sdk.widget.a(activity, com.alipay.sdk.widget.a.f35894b);
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - k >= 3000) {
                k = elapsedRealtime;
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static synchronized boolean fetchSdkConfig(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
            synchronized (PayTask.class) {
                try {
                    com.alipay.sdk.sys.b.a().a(context);
                    long elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
                    if (elapsedRealtime - f35657i < com.alipay.sdk.data.a.p().f()) {
                        return false;
                    }
                    f35657i = elapsedRealtime;
                    com.alipay.sdk.data.a.p().a(com.alipay.sdk.sys.a.a(), context.getApplicationContext());
                    return true;
                } catch (Exception e2) {
                    com.alipay.sdk.util.c.a(e2);
                    return false;
                }
            }
        }
        return invokeL.booleanValue;
    }

    public void dismissLoading() {
        com.alipay.sdk.widget.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f35660c) == null) {
            return;
        }
        aVar.c();
        this.f35660c = null;
    }

    public synchronized String fetchOrderInfoFromH5PayUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            synchronized (this) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        String trim = str.trim();
                        if (trim.startsWith("https://wappaygw.alipay.com/service/rest.htm") || trim.startsWith("http://wappaygw.alipay.com/service/rest.htm")) {
                            String trim2 = trim.replaceFirst("(http|https)://wappaygw.alipay.com/service/rest.htm\\?", "").trim();
                            if (!TextUtils.isEmpty(trim2)) {
                                String a2 = k.a("<request_token>", "</request_token>", k.b(trim2).get("req_data"));
                                com.alipay.sdk.sys.a aVar = new com.alipay.sdk.sys.a(this.f35659b, "", "");
                                return "_input_charset=\"utf-8\"&ordertoken=\"" + a2 + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + aVar.a("sc", "h5tonative") + "\"";
                            }
                        }
                        if (trim.startsWith("https://mclient.alipay.com/service/rest.htm") || trim.startsWith("http://mclient.alipay.com/service/rest.htm")) {
                            String trim3 = trim.replaceFirst("(http|https)://mclient.alipay.com/service/rest.htm\\?", "").trim();
                            if (!TextUtils.isEmpty(trim3)) {
                                String a3 = k.a("<request_token>", "</request_token>", k.b(trim3).get("req_data"));
                                com.alipay.sdk.sys.a aVar2 = new com.alipay.sdk.sys.a(this.f35659b, "", "");
                                return "_input_charset=\"utf-8\"&ordertoken=\"" + a3 + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + aVar2.a("sc", "h5tonative") + "\"";
                            }
                        }
                        if ((trim.startsWith("https://mclient.alipay.com/home/exterfaceAssign.htm") || trim.startsWith("http://mclient.alipay.com/home/exterfaceAssign.htm")) && ((trim.contains("alipay.wap.create.direct.pay.by.user") || trim.contains("create_forex_trade_wap")) && !TextUtils.isEmpty(trim.replaceFirst("(http|https)://mclient.alipay.com/home/exterfaceAssign.htm\\?", "").trim()))) {
                            com.alipay.sdk.sys.a aVar3 = new com.alipay.sdk.sys.a(this.f35659b, "", "");
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("url", str);
                            jSONObject.put("bizcontext", aVar3.a("sc", "h5tonative"));
                            return "new_external_info==" + jSONObject.toString();
                        }
                        if (Pattern.compile("^(http|https)://(maliprod\\.alipay\\.com/w/trade_pay\\.do.?|mali\\.alipay\\.com/w/trade_pay\\.do.?|mclient\\.alipay\\.com/w/trade_pay\\.do.?)").matcher(str).find()) {
                            String a4 = k.a("?", "", str);
                            if (!TextUtils.isEmpty(a4)) {
                                Map<String, String> b2 = k.b(a4);
                                StringBuilder sb = new StringBuilder();
                                if (a(false, true, com.alipay.sdk.app.statistic.b.ar, sb, b2, com.alipay.sdk.app.statistic.b.ar, "alipay_trade_no")) {
                                    a(true, false, "pay_phase_id", sb, b2, "payPhaseId", "pay_phase_id", "out_relation_id");
                                    sb.append("&biz_sub_type=\"TRADE\"");
                                    sb.append("&biz_type=\"trade\"");
                                    String str2 = b2.get("app_name");
                                    if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(b2.get(IAdRequestParam.CELL_ID))) {
                                        str2 = "ali1688";
                                    } else if (TextUtils.isEmpty(str2) && (!TextUtils.isEmpty(b2.get("sid")) || !TextUtils.isEmpty(b2.get("s_id")))) {
                                        str2 = TbConfig.PassConfig.TPL;
                                    }
                                    sb.append("&app_name=\"" + str2 + "\"");
                                    if (a(true, true, "extern_token", sb, b2, "extern_token", IAdRequestParam.CELL_ID, "sid", "s_id")) {
                                        a(true, false, "appenv", sb, b2, "appenv");
                                        sb.append("&pay_channel_id=\"alipay_sdk\"");
                                        a aVar4 = new a();
                                        aVar4.a(b2.get("return_url"));
                                        aVar4.c(b2.get("show_url"));
                                        aVar4.b(b2.get("pay_order_id"));
                                        com.alipay.sdk.sys.a aVar5 = new com.alipay.sdk.sys.a(this.f35659b, "", "");
                                        String str3 = sb.toString() + "&bizcontext=\"" + aVar5.a("sc", "h5tonative") + "\"";
                                        this.f35665h.put(str3, aVar4);
                                        return str3;
                                    }
                                    return "";
                                }
                            }
                        }
                        if (!trim.startsWith("https://mclient.alipay.com/cashier/mobilepay.htm") && !trim.startsWith("http://mclient.alipay.com/cashier/mobilepay.htm") && (!EnvUtils.isSandBox() || !trim.contains("mobileclientgw.alipaydev.com/cashier/mobilepay.htm"))) {
                            if (com.alipay.sdk.data.a.p().d() && Pattern.compile("^https?://(maliprod\\.alipay\\.com|mali\\.alipay\\.com)/batch_payment\\.do\\?").matcher(trim).find()) {
                                Uri parse = Uri.parse(trim);
                                String queryParameter = parse.getQueryParameter("return_url");
                                String queryParameter2 = parse.getQueryParameter("show_url");
                                String queryParameter3 = parse.getQueryParameter("pay_order_id");
                                String a5 = a(parse.getQueryParameter("trade_nos"), parse.getQueryParameter("alipay_trade_no"));
                                String a6 = a(parse.getQueryParameter("payPhaseId"), parse.getQueryParameter("pay_phase_id"), parse.getQueryParameter("out_relation_id"));
                                String[] strArr = new String[4];
                                strArr[0] = parse.getQueryParameter("app_name");
                                strArr[1] = !TextUtils.isEmpty(parse.getQueryParameter(IAdRequestParam.CELL_ID)) ? "ali1688" : "";
                                strArr[2] = !TextUtils.isEmpty(parse.getQueryParameter("sid")) ? TbConfig.PassConfig.TPL : "";
                                strArr[3] = !TextUtils.isEmpty(parse.getQueryParameter("s_id")) ? TbConfig.PassConfig.TPL : "";
                                String a7 = a(strArr);
                                String a8 = a(parse.getQueryParameter("extern_token"), parse.getQueryParameter(IAdRequestParam.CELL_ID), parse.getQueryParameter("sid"), parse.getQueryParameter("s_id"));
                                String a9 = a(parse.getQueryParameter("appenv"));
                                if (!TextUtils.isEmpty(a5) && !TextUtils.isEmpty(a7) && !TextUtils.isEmpty(a8)) {
                                    String format = String.format("trade_no=\"%s\"&pay_phase_id=\"%s\"&biz_type=\"trade\"&biz_sub_type=\"TRADE\"&app_name=\"%s\"&extern_token=\"%s\"&appenv=\"%s\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"%s\"", a5, a6, a7, a8, a9, new com.alipay.sdk.sys.a(this.f35659b, "", "").a("sc", "h5tonative"));
                                    a aVar6 = new a();
                                    aVar6.a(queryParameter);
                                    aVar6.c(queryParameter2);
                                    aVar6.b(queryParameter3);
                                    aVar6.d(a5);
                                    this.f35665h.put(format, aVar6);
                                    return format;
                                }
                            }
                        }
                        String a10 = new com.alipay.sdk.sys.a(this.f35659b, "", "").a("sc", "h5tonative");
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("url", trim);
                        jSONObject2.put("bizcontext", a10);
                        return String.format("new_external_info==%s", jSONObject2.toString());
                    }
                } catch (Throwable th) {
                    com.alipay.sdk.util.c.a(th);
                }
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public synchronized String fetchTradeToken() {
        InterceptResult invokeV;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                a2 = f.a(new com.alipay.sdk.sys.a(this.f35659b, "", "fetchTradeToken"), this.f35659b.getApplicationContext());
            }
            return a2;
        }
        return (String) invokeV.objValue;
    }

    public String getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "15.7.7" : (String) invokeV.objValue;
    }

    public synchronized H5PayResultModel h5Pay(com.alipay.sdk.sys.a aVar, String str, boolean z) {
        InterceptResult invokeLLZ;
        H5PayResultModel h5PayResultModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, aVar, str, z)) == null) {
            synchronized (this) {
                h5PayResultModel = new H5PayResultModel();
                String[] split = a(aVar, str, z).split(";");
                HashMap hashMap = new HashMap();
                for (String str2 : split) {
                    int indexOf = str2.indexOf("={");
                    if (indexOf >= 0) {
                        String substring = str2.substring(0, indexOf);
                        hashMap.put(substring, a(str2, substring));
                    }
                }
                if (hashMap.containsKey(i.f35879a)) {
                    h5PayResultModel.setResultCode(hashMap.get(i.f35879a));
                }
                h5PayResultModel.setReturnUrl(a(str, hashMap));
                if (TextUtils.isEmpty(h5PayResultModel.getReturnUrl())) {
                    com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.ah, "");
                }
            }
            return h5PayResultModel;
        }
        return (H5PayResultModel) invokeLLZ.objValue;
    }

    public synchronized String pay(String str, boolean z) {
        InterceptResult invokeLZ;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048581, this, str, z)) == null) {
            synchronized (this) {
                a2 = a(new com.alipay.sdk.sys.a(this.f35659b, str, "pay"), str, z);
            }
            return a2;
        }
        return (String) invokeLZ.objValue;
    }

    public synchronized boolean payInterceptorWithUrl(String str, boolean z, H5PayCallback h5PayCallback) {
        InterceptResult invokeCommon;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, Boolean.valueOf(z), h5PayCallback})) == null) {
            synchronized (this) {
                String fetchOrderInfoFromH5PayUrl = fetchOrderInfoFromH5PayUrl(str);
                if (!TextUtils.isEmpty(fetchOrderInfoFromH5PayUrl)) {
                    com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, "intercepted: " + fetchOrderInfoFromH5PayUrl);
                    new Thread(new Runnable(this, fetchOrderInfoFromH5PayUrl, z, h5PayCallback) { // from class: com.alipay.sdk.app.PayTask.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ String f35666a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ boolean f35667b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ H5PayCallback f35668c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ PayTask f35669d;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, fetchOrderInfoFromH5PayUrl, Boolean.valueOf(z), h5PayCallback};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f35669d = this;
                            this.f35666a = fetchOrderInfoFromH5PayUrl;
                            this.f35667b = z;
                            this.f35668c = h5PayCallback;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                H5PayResultModel h5Pay = this.f35669d.h5Pay(new com.alipay.sdk.sys.a(this.f35669d.f35659b, this.f35666a, "payInterceptorWithUrl"), this.f35666a, this.f35667b);
                                com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, "inc finished: " + h5Pay.getResultCode());
                                this.f35668c.onPayResult(h5Pay);
                            }
                        }
                    }).start();
                }
                z2 = !TextUtils.isEmpty(fetchOrderInfoFromH5PayUrl);
            }
            return z2;
        }
        return invokeCommon.booleanValue;
    }

    public synchronized Map<String, String> payV2(String str, boolean z) {
        InterceptResult invokeLZ;
        Map<String, String> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048583, this, str, z)) == null) {
            synchronized (this) {
                com.alipay.sdk.sys.a aVar = new com.alipay.sdk.sys.a(this.f35659b, str, "payV2");
                a2 = i.a(aVar, a(aVar, str, z));
            }
            return a2;
        }
        return (Map) invokeLZ.objValue;
    }

    public void showLoading() {
        com.alipay.sdk.widget.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (aVar = this.f35660c) == null) {
            return;
        }
        aVar.b();
    }

    private synchronized String a(com.alipay.sdk.sys.a aVar, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65544, this, aVar, str, z)) == null) {
            synchronized (this) {
                if (b()) {
                    com.alipay.sdk.app.statistic.a.a(aVar, "biz", "RepPay", "");
                    return b.d();
                }
                if (z) {
                    showLoading();
                }
                if (str.contains("payment_inst=")) {
                    String substring = str.substring(str.indexOf("payment_inst=") + 13);
                    int indexOf = substring.indexOf(38);
                    if (indexOf > 0) {
                        substring = substring.substring(0, indexOf);
                    }
                    com.alipay.sdk.app.a.a(substring.replaceAll("\"", "").toLowerCase(Locale.getDefault()).replaceAll(LBSTransAuthPresenter.AUTH_CHANNEL_ALI, ""));
                } else {
                    com.alipay.sdk.app.a.a("");
                }
                if (str.contains(com.alipay.sdk.cons.a.t)) {
                    com.alipay.sdk.cons.a.u = true;
                }
                if (com.alipay.sdk.cons.a.u) {
                    if (str.startsWith(com.alipay.sdk.cons.a.v)) {
                        str = str.substring(str.indexOf(com.alipay.sdk.cons.a.v) + 53);
                    } else if (str.startsWith(com.alipay.sdk.cons.a.w)) {
                        str = str.substring(str.indexOf(com.alipay.sdk.cons.a.w) + 52);
                    }
                }
                com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, "pay prepared: " + str);
                String a2 = a(str, aVar);
                com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, "pay raw result: " + a2);
                f.a(aVar, this.f35659b.getApplicationContext(), a2);
                com.alipay.sdk.app.statistic.a.b(aVar, "biz", com.alipay.sdk.app.statistic.b.P, "" + SystemClock.elapsedRealtime());
                com.alipay.sdk.app.statistic.a.b(aVar, "biz", com.alipay.sdk.app.statistic.b.Q, i.a(a2, i.f35879a) + "|" + i.a(a2, i.f35880b));
                if (!com.alipay.sdk.data.a.p().n()) {
                    com.alipay.sdk.data.a.p().a(aVar, this.f35659b.getApplicationContext());
                }
                dismissLoading();
                com.alipay.sdk.app.statistic.a.b(this.f35659b.getApplicationContext(), aVar, str, aVar.q);
                com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, "pay returning: " + a2);
                return a2;
            }
        }
        return (String) invokeLLZ.objValue;
    }

    public static final String a(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, strArr)) == null) {
            if (strArr == null) {
                return "";
            }
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    private boolean a(boolean z, boolean z2, String str, StringBuilder sb, Map<String, String> map, String... strArr) {
        InterceptResult invokeCommon;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, sb, map, strArr})) == null) {
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    str2 = "";
                    break;
                }
                String str3 = strArr[i2];
                if (!TextUtils.isEmpty(map.get(str3))) {
                    str2 = map.get(str3);
                    break;
                }
                i2++;
            }
            if (TextUtils.isEmpty(str2)) {
                return !z2;
            } else if (z) {
                sb.append("&");
                sb.append(str);
                sb.append("=\"");
                sb.append(str2);
                sb.append("\"");
                return true;
            } else {
                sb.append(str);
                sb.append("=\"");
                sb.append(str2);
                sb.append("\"");
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }

    private String a(String str, Map<String, String> map) throws UnsupportedEncodingException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, this, str, map)) == null) {
            boolean equals = Result.RESULT_SUCCESS.equals(map.get(i.f35879a));
            String str2 = map.get("result");
            a remove = this.f35665h.remove(str);
            String[] strArr = new String[2];
            strArr[0] = remove != null ? remove.b() : "";
            strArr[1] = remove != null ? remove.d() : "";
            a(strArr);
            if (map.containsKey("callBackUrl")) {
                return map.get("callBackUrl");
            }
            if (str2.length() > 15) {
                String a2 = a(k.a("&callBackUrl=\"", "\"", str2), k.a("&call_back_url=\"", "\"", str2), k.a(com.alipay.sdk.cons.a.r, "\"", str2), URLDecoder.decode(k.a(com.alipay.sdk.cons.a.s, "&", str2), "utf-8"), URLDecoder.decode(k.a("&callBackUrl=", "&", str2), "utf-8"), k.a("call_back_url=\"", "\"", str2));
                if (!TextUtils.isEmpty(a2)) {
                    return a2;
                }
            }
            if (remove != null) {
                String a3 = equals ? remove.a() : remove.c();
                if (!TextUtils.isEmpty(a3)) {
                    return a3;
                }
            }
            return remove != null ? com.alipay.sdk.data.a.p().e() : "";
        }
        return (String) invokeLL.objValue;
    }

    private String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, this, str, str2)) == null) {
            String str3 = str2 + "={";
            return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf("}"));
        }
        return (String) invokeLL.objValue;
    }

    private e.c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? new e.c(this) { // from class: com.alipay.sdk.app.PayTask.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PayTask f35670a;

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
                this.f35670a = this;
            }

            @Override // com.alipay.sdk.util.e.c
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.alipay.sdk.util.e.c
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f35670a.dismissLoading();
                }
            }
        } : (e.c) invokeV.objValue;
    }

    private String a(String str, com.alipay.sdk.sys.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, str, aVar)) == null) {
            String a2 = aVar.a(str);
            if (a2.contains("paymethod=\"expressGateway\"")) {
                return a(aVar, a2);
            }
            List<a.C1559a> o = com.alipay.sdk.data.a.p().o();
            if (!com.alipay.sdk.data.a.p().f35747a || o == null) {
                o = com.alipay.sdk.app.a.f35676a;
            }
            if (k.b(aVar, this.f35659b, o)) {
                e eVar = new e(this.f35659b, aVar, a());
                com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, "pay inner started: " + a2);
                String a3 = eVar.a(a2);
                com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, "pay inner raw result: " + a3);
                eVar.a();
                if (!TextUtils.equals(a3, e.f35855a) && !TextUtils.equals(a3, e.f35856b)) {
                    if (TextUtils.isEmpty(a3)) {
                        return b.c();
                    }
                    if (a3.contains(PayResultActivity.f35644a)) {
                        com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.ae);
                        return a(aVar, a2, o, a3, this.f35659b);
                    }
                    return a3;
                }
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.ac);
                return a(aVar, a2);
            }
            com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.ad);
            return a(aVar, a2);
        }
        return (String) invokeLL.objValue;
    }

    public static String a(com.alipay.sdk.sys.a aVar, String str, List<a.C1559a> list, String str2, Activity activity) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65543, null, aVar, str, list, str2, activity)) == null) {
            k.a a2 = k.a(aVar, activity, list);
            if (a2 == null || a2.a(aVar) || a2.a() || !TextUtils.equals(a2.f35890a.packageName, PayResultActivity.f35646c)) {
                return str2;
            }
            com.alipay.sdk.util.c.a(com.alipay.sdk.cons.a.x, "PayTask not_login");
            String valueOf = String.valueOf(str.hashCode());
            PayResultActivity.f35645b.put(valueOf, new Object());
            Intent intent = new Intent(activity, PayResultActivity.class);
            intent.putExtra(PayResultActivity.f35648e, str);
            intent.putExtra(PayResultActivity.f35649f, activity.getPackageName());
            intent.putExtra(PayResultActivity.f35647d, valueOf);
            a.C1561a.a(aVar, intent);
            activity.startActivity(intent);
            synchronized (PayResultActivity.f35645b.get(valueOf)) {
                try {
                    com.alipay.sdk.util.c.a(com.alipay.sdk.cons.a.x, "PayTask wait");
                    PayResultActivity.f35645b.get(valueOf).wait();
                } catch (InterruptedException unused) {
                    com.alipay.sdk.util.c.a(com.alipay.sdk.cons.a.x, "PayTask interrupted");
                    return b.c();
                }
            }
            String str3 = PayResultActivity.a.f35655b;
            com.alipay.sdk.util.c.a(com.alipay.sdk.cons.a.x, "PayTask ret: " + str3);
            return str3;
        }
        return (String) invokeLLLLL.objValue;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
    private String a(com.alipay.sdk.sys.a aVar, String str) {
        InterceptResult invokeLL;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, aVar, str)) == null) {
            showLoading();
            c cVar = null;
            try {
                try {
                    JSONObject c2 = new com.alipay.sdk.packet.impl.f().a(aVar, this.f35659b.getApplicationContext(), str).c();
                    String optString = c2.optString("end_code", null);
                    List<com.alipay.sdk.protocol.b> a3 = com.alipay.sdk.protocol.b.a(c2.optJSONObject("form").optJSONObject(com.alipay.sdk.cons.c.f35731d));
                    for (int i2 = 0; i2 < a3.size(); i2++) {
                        if (a3.get(i2).b() == com.alipay.sdk.protocol.a.f35806c) {
                            com.alipay.sdk.protocol.b.a(a3.get(i2));
                        }
                    }
                    a(aVar, c2);
                    dismissLoading();
                    com.alipay.sdk.app.statistic.a.a(this.f35659b, aVar, str, aVar.q);
                    for (int i3 = 0; i3 < a3.size(); i3++) {
                        com.alipay.sdk.protocol.b bVar = a3.get(i3);
                        if (bVar.b() == com.alipay.sdk.protocol.a.f35805b) {
                            a2 = a(aVar, bVar);
                        } else if (bVar.b() == com.alipay.sdk.protocol.a.f35807d) {
                            a2 = a(aVar, bVar, optString);
                        }
                        return a2;
                    }
                } finally {
                    dismissLoading();
                    com.alipay.sdk.app.statistic.a.a(this.f35659b, aVar, str, aVar.q);
                }
            } catch (IOException e2) {
                c b2 = c.b(c.f35685d.a());
                com.alipay.sdk.app.statistic.a.a(aVar, "net", e2);
                dismissLoading();
                com.alipay.sdk.app.statistic.a.a(this.f35659b, aVar, str, aVar.q);
                cVar = b2;
            } catch (Throwable th) {
                com.alipay.sdk.util.c.a(th);
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.v, th);
            }
            if (cVar == null) {
                cVar = c.b(c.f35683b.a());
            }
            return b.a(cVar.a(), cVar.b(), "");
        }
        return (String) invokeLL.objValue;
    }

    private void a(com.alipay.sdk.sys.a aVar, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, this, aVar, jSONObject) == null) {
            try {
                String optString = jSONObject.optString("tid");
                String optString2 = jSONObject.optString(com.alipay.sdk.tid.a.f35833d);
                if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                    return;
                }
                com.alipay.sdk.tid.a.a(com.alipay.sdk.sys.b.a().b()).a(optString, optString2);
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.J, th);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0098, code lost:
        r0 = r6.c();
        r11 = com.alipay.sdk.app.b.a(java.lang.Integer.valueOf(r0[1]).intValue(), r0[0], com.alipay.sdk.util.k.b(r10, r0[2]));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(com.alipay.sdk.sys.a aVar, com.alipay.sdk.protocol.b bVar, String str) {
        InterceptResult invokeLLL;
        boolean b2;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, this, aVar, bVar, str)) == null) {
            String[] c2 = bVar.c();
            Intent intent = new Intent(this.f35659b, H5PayActivity.class);
            try {
                JSONObject c3 = k.c(new String(com.alipay.sdk.encrypt.a.a(c2[2])));
                intent.putExtra("url", c2[0]);
                intent.putExtra("title", c2[1]);
                intent.putExtra("version", "v2");
                intent.putExtra("method", c3.optString("method", "POST"));
                b.a(false);
                b.a((String) null);
                a.C1561a.a(aVar, intent);
                this.f35659b.startActivity(intent);
                synchronized (f35656a) {
                    try {
                        f35656a.wait();
                        b2 = b.b();
                        a2 = b.a();
                        b.a(false);
                        b.a((String) null);
                    } catch (InterruptedException e2) {
                        com.alipay.sdk.util.c.a(e2);
                        return b.c();
                    }
                }
                String str2 = "";
                if (b2) {
                    try {
                        List<com.alipay.sdk.protocol.b> a3 = com.alipay.sdk.protocol.b.a(k.c(new String(com.alipay.sdk.encrypt.a.a(a2))));
                        int i2 = 0;
                        while (true) {
                            if (i2 >= a3.size()) {
                                break;
                            }
                            com.alipay.sdk.protocol.b bVar2 = a3.get(i2);
                            if (bVar2.b() == com.alipay.sdk.protocol.a.f35808e) {
                                break;
                            }
                            i2++;
                        }
                    } catch (Throwable th) {
                        com.alipay.sdk.util.c.a(th);
                        com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.v, th, a2);
                    }
                }
                if (TextUtils.isEmpty(str2)) {
                    try {
                        return b.a(Integer.valueOf(str).intValue(), "", "");
                    } catch (Throwable th2) {
                        com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.v, th2, "endCode: " + str);
                        return b.a(8000, "", "");
                    }
                }
                return str2;
            } catch (Throwable th3) {
                com.alipay.sdk.util.c.a(th3);
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.v, th3, Arrays.toString(c2));
                return b.c();
            }
        }
        return (String) invokeLLL.objValue;
    }

    private String a(com.alipay.sdk.sys.a aVar, com.alipay.sdk.protocol.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, aVar, bVar)) == null) {
            String[] c2 = bVar.c();
            Intent intent = new Intent(this.f35659b, H5PayActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("url", c2[0]);
            if (c2.length == 2) {
                bundle.putString("cookie", c2[1]);
            }
            intent.putExtras(bundle);
            a.C1561a.a(aVar, intent);
            this.f35659b.startActivity(intent);
            synchronized (f35656a) {
                try {
                    f35656a.wait();
                } catch (InterruptedException e2) {
                    com.alipay.sdk.util.c.a(e2);
                    return b.c();
                }
            }
            String a2 = b.a();
            return TextUtils.isEmpty(a2) ? b.c() : a2;
        }
        return (String) invokeLL.objValue;
    }
}
