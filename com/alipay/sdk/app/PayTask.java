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
import com.alipay.sdk.util.f;
import com.alipay.sdk.util.g;
import com.alipay.sdk.util.j;
import com.alipay.sdk.util.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.channelpay.alipay.Result;
import com.baidu.android.lbspay.presenter.LBSTransAuthPresenter;
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
/* loaded from: classes9.dex */
public class PayTask {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: h  reason: collision with root package name */
    public static final Object f31003h;

    /* renamed from: i  reason: collision with root package name */
    public static long f31004i = 0;

    /* renamed from: j  reason: collision with root package name */
    public static final long f31005j = 3000;
    public static long k = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;

    /* renamed from: b  reason: collision with root package name */
    public com.alipay.sdk.widget.a f31006b;

    /* renamed from: c  reason: collision with root package name */
    public final String f31007c;

    /* renamed from: d  reason: collision with root package name */
    public final String f31008d;

    /* renamed from: e  reason: collision with root package name */
    public final String f31009e;

    /* renamed from: f  reason: collision with root package name */
    public final String f31010f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, c> f31011g;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f31012b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ H5PayCallback f31013c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PayTask f31014d;

        public a(PayTask payTask, String str, boolean z, H5PayCallback h5PayCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payTask, str, Boolean.valueOf(z), h5PayCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31014d = payTask;
            this.a = str;
            this.f31012b = z;
            this.f31013c = h5PayCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                H5PayResultModel h5Pay = this.f31014d.h5Pay(new com.alipay.sdk.sys.a(this.f31014d.a, this.a, "payInterceptorWithUrl"), this.a, this.f31012b);
                com.alipay.sdk.util.c.d(com.alipay.sdk.cons.a.x, "inc finished: " + h5Pay.getResultCode());
                this.f31013c.onPayResult(h5Pay);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements f.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayTask a;

        public b(PayTask payTask) {
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
            this.a = payTask;
        }

        @Override // com.alipay.sdk.util.f.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.dismissLoading();
            }
        }

        @Override // com.alipay.sdk.util.f.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f31015b;

        /* renamed from: c  reason: collision with root package name */
        public String f31016c;

        /* renamed from: d  reason: collision with root package name */
        public String f31017d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PayTask f31018e;

        public c(PayTask payTask) {
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
            this.f31018e = payTask;
            this.a = "";
            this.f31015b = "";
            this.f31016c = "";
            this.f31017d = "";
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f31016c : (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (String) invokeV.objValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f31015b : (String) invokeV.objValue;
        }

        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f31017d : (String) invokeV.objValue;
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f31016c = str;
            }
        }

        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.a = str;
            }
        }

        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.f31015b = str;
            }
        }

        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
                this.f31017d = str;
            }
        }

        public /* synthetic */ c(PayTask payTask, a aVar) {
            this(payTask);
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
        f31003h = f.class;
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
        this.f31007c = "wappaygw.alipay.com/service/rest.htm";
        this.f31008d = "mclient.alipay.com/service/rest.htm";
        this.f31009e = "mclient.alipay.com/home/exterfaceAssign.htm";
        this.f31010f = "mclient.alipay.com/cashier/mobilepay.htm";
        this.f31011g = new HashMap();
        this.a = activity;
        com.alipay.sdk.sys.b.d().a(this.a);
        this.f31006b = new com.alipay.sdk.widget.a(activity, com.alipay.sdk.widget.a.f31191j);
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
                    com.alipay.sdk.sys.b.d().a(context);
                    long elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
                    if (elapsedRealtime - f31004i < com.alipay.sdk.data.a.u().c()) {
                        return false;
                    }
                    f31004i = elapsedRealtime;
                    com.alipay.sdk.data.a.u().a(com.alipay.sdk.sys.a.e(), context.getApplicationContext());
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
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f31006b) == null) {
            return;
        }
        aVar.a();
        this.f31006b = null;
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
                                String a2 = l.a("<request_token>", "</request_token>", l.a(trim2).get("req_data"));
                                com.alipay.sdk.sys.a aVar = new com.alipay.sdk.sys.a(this.a, "", "");
                                return "_input_charset=\"utf-8\"&ordertoken=\"" + a2 + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + aVar.a("sc", "h5tonative") + "\"";
                            }
                        }
                        if (trim.startsWith("https://mclient.alipay.com/service/rest.htm") || trim.startsWith("http://mclient.alipay.com/service/rest.htm")) {
                            String trim3 = trim.replaceFirst("(http|https)://mclient.alipay.com/service/rest.htm\\?", "").trim();
                            if (!TextUtils.isEmpty(trim3)) {
                                String a3 = l.a("<request_token>", "</request_token>", l.a(trim3).get("req_data"));
                                com.alipay.sdk.sys.a aVar2 = new com.alipay.sdk.sys.a(this.a, "", "");
                                return "_input_charset=\"utf-8\"&ordertoken=\"" + a3 + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + aVar2.a("sc", "h5tonative") + "\"";
                            }
                        }
                        if ((trim.startsWith("https://mclient.alipay.com/home/exterfaceAssign.htm") || trim.startsWith("http://mclient.alipay.com/home/exterfaceAssign.htm")) && ((trim.contains("alipay.wap.create.direct.pay.by.user") || trim.contains("create_forex_trade_wap")) && !TextUtils.isEmpty(trim.replaceFirst("(http|https)://mclient.alipay.com/home/exterfaceAssign.htm\\?", "").trim()))) {
                            com.alipay.sdk.sys.a aVar3 = new com.alipay.sdk.sys.a(this.a, "", "");
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("url", str);
                            jSONObject.put("bizcontext", aVar3.a("sc", "h5tonative"));
                            return "new_external_info==" + jSONObject.toString();
                        }
                        if (Pattern.compile("^(http|https)://(maliprod\\.alipay\\.com/w/trade_pay\\.do.?|mali\\.alipay\\.com/w/trade_pay\\.do.?|mclient\\.alipay\\.com/w/trade_pay\\.do.?)").matcher(str).find()) {
                            String a4 = l.a("?", "", str);
                            if (!TextUtils.isEmpty(a4)) {
                                Map<String, String> a5 = l.a(a4);
                                StringBuilder sb = new StringBuilder();
                                if (a(false, true, com.alipay.sdk.app.statistic.b.H0, sb, a5, com.alipay.sdk.app.statistic.b.H0, "alipay_trade_no")) {
                                    a(true, false, "pay_phase_id", sb, a5, "payPhaseId", "pay_phase_id", "out_relation_id");
                                    sb.append("&biz_sub_type=\"TRADE\"");
                                    sb.append("&biz_type=\"trade\"");
                                    String str2 = a5.get("app_name");
                                    if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(a5.get("cid"))) {
                                        str2 = "ali1688";
                                    } else if (TextUtils.isEmpty(str2) && (!TextUtils.isEmpty(a5.get("sid")) || !TextUtils.isEmpty(a5.get("s_id")))) {
                                        str2 = TbConfig.PassConfig.TPL;
                                    }
                                    sb.append("&app_name=\"" + str2 + "\"");
                                    if (a(true, true, "extern_token", sb, a5, "extern_token", "cid", "sid", "s_id")) {
                                        a(true, false, "appenv", sb, a5, "appenv");
                                        sb.append("&pay_channel_id=\"alipay_sdk\"");
                                        c cVar = new c(this, null);
                                        cVar.b(a5.get("return_url"));
                                        cVar.c(a5.get("show_url"));
                                        cVar.a(a5.get("pay_order_id"));
                                        com.alipay.sdk.sys.a aVar4 = new com.alipay.sdk.sys.a(this.a, "", "");
                                        String str3 = sb.toString() + "&bizcontext=\"" + aVar4.a("sc", "h5tonative") + "\"";
                                        this.f31011g.put(str3, cVar);
                                        return str3;
                                    }
                                    return "";
                                }
                            }
                        }
                        if (!trim.startsWith("https://mclient.alipay.com/cashier/mobilepay.htm") && !trim.startsWith("http://mclient.alipay.com/cashier/mobilepay.htm") && (!EnvUtils.isSandBox() || !trim.contains("mobileclientgw.alipaydev.com/cashier/mobilepay.htm"))) {
                            if (com.alipay.sdk.data.a.u().g() && Pattern.compile("^https?://(maliprod\\.alipay\\.com|mali\\.alipay\\.com)/batch_payment\\.do\\?").matcher(trim).find()) {
                                Uri parse = Uri.parse(trim);
                                String queryParameter = parse.getQueryParameter("return_url");
                                String queryParameter2 = parse.getQueryParameter("show_url");
                                String queryParameter3 = parse.getQueryParameter("pay_order_id");
                                String a6 = a(parse.getQueryParameter("trade_nos"), parse.getQueryParameter("alipay_trade_no"));
                                String a7 = a(parse.getQueryParameter("payPhaseId"), parse.getQueryParameter("pay_phase_id"), parse.getQueryParameter("out_relation_id"));
                                String[] strArr = new String[4];
                                strArr[0] = parse.getQueryParameter("app_name");
                                strArr[1] = !TextUtils.isEmpty(parse.getQueryParameter("cid")) ? "ali1688" : "";
                                strArr[2] = !TextUtils.isEmpty(parse.getQueryParameter("sid")) ? TbConfig.PassConfig.TPL : "";
                                strArr[3] = !TextUtils.isEmpty(parse.getQueryParameter("s_id")) ? TbConfig.PassConfig.TPL : "";
                                String a8 = a(strArr);
                                String a9 = a(parse.getQueryParameter("extern_token"), parse.getQueryParameter("cid"), parse.getQueryParameter("sid"), parse.getQueryParameter("s_id"));
                                String a10 = a(parse.getQueryParameter("appenv"));
                                if (!TextUtils.isEmpty(a6) && !TextUtils.isEmpty(a8) && !TextUtils.isEmpty(a9)) {
                                    String format = String.format("trade_no=\"%s\"&pay_phase_id=\"%s\"&biz_type=\"trade\"&biz_sub_type=\"TRADE\"&app_name=\"%s\"&extern_token=\"%s\"&appenv=\"%s\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"%s\"", a6, a7, a8, a9, a10, new com.alipay.sdk.sys.a(this.a, "", "").a("sc", "h5tonative"));
                                    c cVar2 = new c(this, null);
                                    cVar2.b(queryParameter);
                                    cVar2.c(queryParameter2);
                                    cVar2.a(queryParameter3);
                                    cVar2.d(a6);
                                    this.f31011g.put(format, cVar2);
                                    return format;
                                }
                            }
                        }
                        String a11 = new com.alipay.sdk.sys.a(this.a, "", "").a("sc", "h5tonative");
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("url", trim);
                        jSONObject2.put("bizcontext", a11);
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
                a2 = g.a(new com.alipay.sdk.sys.a(this.a, "", "fetchTradeToken"), this.a.getApplicationContext());
            }
            return a2;
        }
        return (String) invokeV.objValue;
    }

    public String getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "15.8.02" : (String) invokeV.objValue;
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
                if (hashMap.containsKey("resultStatus")) {
                    h5PayResultModel.setResultCode(hashMap.get("resultStatus"));
                }
                h5PayResultModel.setReturnUrl(a(str, hashMap));
                if (TextUtils.isEmpty(h5PayResultModel.getReturnUrl())) {
                    com.alipay.sdk.app.statistic.a.b(aVar, "biz", com.alipay.sdk.app.statistic.b.r0, "");
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
                a2 = a(new com.alipay.sdk.sys.a(this.a, str, "pay"), str, z);
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
                    com.alipay.sdk.util.c.d(com.alipay.sdk.cons.a.x, "intercepted: " + fetchOrderInfoFromH5PayUrl);
                    new Thread(new a(this, fetchOrderInfoFromH5PayUrl, z, h5PayCallback)).start();
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
                com.alipay.sdk.sys.a aVar = new com.alipay.sdk.sys.a(this.a, str, "payV2");
                a2 = j.a(aVar, a(aVar, str, z));
            }
            return a2;
        }
        return (Map) invokeLZ.objValue;
    }

    public void showLoading() {
        com.alipay.sdk.widget.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (aVar = this.f31006b) == null) {
            return;
        }
        aVar.d();
    }

    private synchronized String a(com.alipay.sdk.sys.a aVar, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65544, this, aVar, str, z)) == null) {
            synchronized (this) {
                if (b()) {
                    com.alipay.sdk.app.statistic.a.b(aVar, "biz", "RepPay", "");
                    return com.alipay.sdk.app.b.b();
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
                com.alipay.sdk.util.c.d(com.alipay.sdk.cons.a.x, "pay prepared: " + str);
                String a2 = a(str, aVar);
                com.alipay.sdk.util.c.d(com.alipay.sdk.cons.a.x, "pay raw result: " + a2);
                g.a(aVar, this.a.getApplicationContext(), a2);
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.Z, "" + SystemClock.elapsedRealtime());
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.a0, j.a(a2, "resultStatus") + "|" + j.a(a2, "memo"));
                if (!com.alipay.sdk.data.a.u().q()) {
                    com.alipay.sdk.data.a.u().a(aVar, this.a.getApplicationContext());
                }
                dismissLoading();
                com.alipay.sdk.app.statistic.a.b(this.a.getApplicationContext(), aVar, str, aVar.f31132d);
                com.alipay.sdk.util.c.d(com.alipay.sdk.cons.a.x, "pay returning: " + a2);
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
            boolean equals = Result.RESULT_SUCCESS.equals(map.get("resultStatus"));
            String str2 = map.get("result");
            c remove = this.f31011g.remove(str);
            String[] strArr = new String[2];
            strArr[0] = remove != null ? remove.a() : "";
            strArr[1] = remove != null ? remove.d() : "";
            a(strArr);
            if (map.containsKey("callBackUrl")) {
                return map.get("callBackUrl");
            }
            if (str2.length() > 15) {
                String a2 = a(l.a("&callBackUrl=\"", "\"", str2), l.a("&call_back_url=\"", "\"", str2), l.a(com.alipay.sdk.cons.a.r, "\"", str2), URLDecoder.decode(l.a(com.alipay.sdk.cons.a.s, "&", str2), "utf-8"), URLDecoder.decode(l.a("&callBackUrl=", "&", str2), "utf-8"), l.a("call_back_url=\"", "\"", str2));
                if (!TextUtils.isEmpty(a2)) {
                    return a2;
                }
            }
            if (remove != null) {
                String b2 = equals ? remove.b() : remove.c();
                if (!TextUtils.isEmpty(b2)) {
                    return b2;
                }
            }
            return remove != null ? com.alipay.sdk.data.a.u().p() : "";
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

    private f.e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? new b(this) : (f.e) invokeV.objValue;
    }

    private String a(String str, com.alipay.sdk.sys.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, str, aVar)) == null) {
            String a2 = aVar.a(str);
            if (a2.contains("paymethod=\"expressGateway\"")) {
                return a(aVar, a2);
            }
            List<a.b> k2 = com.alipay.sdk.data.a.u().k();
            if (!com.alipay.sdk.data.a.u().f31076g || k2 == null) {
                k2 = com.alipay.sdk.app.a.f31021d;
            }
            if (l.b(aVar, this.a, k2)) {
                f fVar = new f(this.a, aVar, a());
                com.alipay.sdk.util.c.d(com.alipay.sdk.cons.a.x, "pay inner started: " + a2);
                String a3 = fVar.a(a2);
                com.alipay.sdk.util.c.d(com.alipay.sdk.cons.a.x, "pay inner raw result: " + a3);
                fVar.a();
                if (!TextUtils.equals(a3, f.f31162j) && !TextUtils.equals(a3, f.k)) {
                    if (TextUtils.isEmpty(a3)) {
                        return com.alipay.sdk.app.b.a();
                    }
                    if (a3.contains(PayResultActivity.f30994b)) {
                        com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.o0);
                        return a(aVar, a2, k2, a3, this.a);
                    }
                    return a3;
                }
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.m0);
                return a(aVar, a2);
            }
            com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.n0);
            return a(aVar, a2);
        }
        return (String) invokeLL.objValue;
    }

    public static String a(com.alipay.sdk.sys.a aVar, String str, List<a.b> list, String str2, Activity activity) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65543, null, aVar, str, list, str2, activity)) == null) {
            l.b a2 = l.a(aVar, activity, list);
            if (a2 == null || a2.a(aVar) || a2.a() || !TextUtils.equals(a2.a.packageName, PayResultActivity.f30996d)) {
                return str2;
            }
            com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, "PayTask not_login");
            String valueOf = String.valueOf(str.hashCode());
            PayResultActivity.f30995c.put(valueOf, new Object());
            Intent intent = new Intent(activity, PayResultActivity.class);
            intent.putExtra(PayResultActivity.f30998f, str);
            intent.putExtra(PayResultActivity.f30999g, activity.getPackageName());
            intent.putExtra(PayResultActivity.f30997e, valueOf);
            a.C1713a.a(aVar, intent);
            activity.startActivity(intent);
            synchronized (PayResultActivity.f30995c.get(valueOf)) {
                try {
                    com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, "PayTask wait");
                    PayResultActivity.f30995c.get(valueOf).wait();
                } catch (InterruptedException unused) {
                    com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, "PayTask interrupted");
                    return com.alipay.sdk.app.b.a();
                }
            }
            String str3 = PayResultActivity.b.f31002b;
            com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, "PayTask ret: " + str3);
            return str3;
        }
        return (String) invokeLLLLL.objValue;
    }

    private String a(com.alipay.sdk.sys.a aVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, this, aVar, str)) == null) {
            showLoading();
            com.alipay.sdk.app.c cVar = null;
            try {
                try {
                    JSONObject c2 = new com.alipay.sdk.packet.impl.f().a(aVar, this.a.getApplicationContext(), str).c();
                    String optString = c2.optString("end_code", null);
                    List<com.alipay.sdk.protocol.b> a2 = com.alipay.sdk.protocol.b.a(c2.optJSONObject("form").optJSONObject(com.alipay.sdk.cons.c.f31064d));
                    for (int i2 = 0; i2 < a2.size(); i2++) {
                        if (a2.get(i2).a() == com.alipay.sdk.protocol.a.f31122d) {
                            com.alipay.sdk.protocol.b.a(a2.get(i2));
                        }
                    }
                    a(aVar, c2);
                    dismissLoading();
                    com.alipay.sdk.app.statistic.a.a(this.a, aVar, str, aVar.f31132d);
                    for (int i3 = 0; i3 < a2.size(); i3++) {
                        com.alipay.sdk.protocol.b bVar = a2.get(i3);
                        if (bVar.a() == com.alipay.sdk.protocol.a.f31121c) {
                            String a3 = a(aVar, bVar);
                            dismissLoading();
                            com.alipay.sdk.app.statistic.a.a(this.a, aVar, str, aVar.f31132d);
                            return a3;
                        } else if (bVar.a() == com.alipay.sdk.protocol.a.f31123e) {
                            String a4 = a(aVar, bVar, optString);
                            dismissLoading();
                            com.alipay.sdk.app.statistic.a.a(this.a, aVar, str, aVar.f31132d);
                            return a4;
                        }
                    }
                    dismissLoading();
                    com.alipay.sdk.app.statistic.a.a(this.a, aVar, str, aVar.f31132d);
                } catch (IOException e2) {
                    com.alipay.sdk.app.c b2 = com.alipay.sdk.app.c.b(com.alipay.sdk.app.c.f31026f.b());
                    com.alipay.sdk.app.statistic.a.a(aVar, "net", e2);
                    dismissLoading();
                    com.alipay.sdk.app.statistic.a.a(this.a, aVar, str, aVar.f31132d);
                    cVar = b2;
                }
                if (cVar == null) {
                    cVar = com.alipay.sdk.app.c.b(com.alipay.sdk.app.c.f31024d.b());
                }
                return com.alipay.sdk.app.b.a(cVar.b(), cVar.a(), "");
            }
        }
        return (String) invokeLL.objValue;
    }

    private void a(com.alipay.sdk.sys.a aVar, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, this, aVar, jSONObject) == null) {
            try {
                String optString = jSONObject.optString("tid");
                String optString2 = jSONObject.optString(com.alipay.sdk.tid.a.f31144j);
                if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                    return;
                }
                com.alipay.sdk.tid.a.a(com.alipay.sdk.sys.b.d().b()).a(optString, optString2);
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.T, th);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0095, code lost:
        r0 = r6.c();
        r11 = com.alipay.sdk.app.b.a(java.lang.Integer.valueOf(r0[1]).intValue(), r0[0], com.alipay.sdk.util.l.e(r10, r0[2]));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(com.alipay.sdk.sys.a aVar, com.alipay.sdk.protocol.b bVar, String str) {
        InterceptResult invokeLLL;
        boolean c2;
        String d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, this, aVar, bVar, str)) == null) {
            String[] c3 = bVar.c();
            Intent intent = new Intent(this.a, H5PayActivity.class);
            try {
                JSONObject f2 = l.f(new String(com.alipay.sdk.encrypt.a.a(c3[2])));
                intent.putExtra("url", c3[0]);
                intent.putExtra("title", c3[1]);
                intent.putExtra("version", "v2");
                intent.putExtra("method", f2.optString("method", "POST"));
                com.alipay.sdk.app.b.a(false);
                com.alipay.sdk.app.b.a((String) null);
                a.C1713a.a(aVar, intent);
                this.a.startActivity(intent);
                synchronized (f31003h) {
                    try {
                        f31003h.wait();
                        c2 = com.alipay.sdk.app.b.c();
                        d2 = com.alipay.sdk.app.b.d();
                        com.alipay.sdk.app.b.a(false);
                        com.alipay.sdk.app.b.a((String) null);
                    } catch (InterruptedException e2) {
                        com.alipay.sdk.util.c.a(e2);
                        return com.alipay.sdk.app.b.a();
                    }
                }
                String str2 = "";
                if (c2) {
                    try {
                        List<com.alipay.sdk.protocol.b> a2 = com.alipay.sdk.protocol.b.a(l.f(new String(com.alipay.sdk.encrypt.a.a(d2))));
                        int i2 = 0;
                        while (true) {
                            if (i2 >= a2.size()) {
                                break;
                            }
                            com.alipay.sdk.protocol.b bVar2 = a2.get(i2);
                            if (bVar2.a() == com.alipay.sdk.protocol.a.f31124f) {
                                break;
                            }
                            i2++;
                        }
                    } catch (Throwable th) {
                        com.alipay.sdk.util.c.a(th);
                        com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.F, th, d2);
                    }
                }
                if (TextUtils.isEmpty(str2)) {
                    try {
                        return com.alipay.sdk.app.b.a(Integer.valueOf(str).intValue(), "", "");
                    } catch (Throwable th2) {
                        com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.F, th2, "endCode: " + str);
                        return com.alipay.sdk.app.b.a(8000, "", "");
                    }
                }
                return str2;
            } catch (Throwable th3) {
                com.alipay.sdk.util.c.a(th3);
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.F, th3, Arrays.toString(c3));
                return com.alipay.sdk.app.b.a();
            }
        }
        return (String) invokeLLL.objValue;
    }

    private String a(com.alipay.sdk.sys.a aVar, com.alipay.sdk.protocol.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, aVar, bVar)) == null) {
            String[] c2 = bVar.c();
            Intent intent = new Intent(this.a, H5PayActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("url", c2[0]);
            if (c2.length == 2) {
                bundle.putString("cookie", c2[1]);
            }
            intent.putExtras(bundle);
            a.C1713a.a(aVar, intent);
            this.a.startActivity(intent);
            synchronized (f31003h) {
                try {
                    f31003h.wait();
                } catch (InterruptedException e2) {
                    com.alipay.sdk.util.c.a(e2);
                    return com.alipay.sdk.app.b.a();
                }
            }
            String d2 = com.alipay.sdk.app.b.d();
            return TextUtils.isEmpty(d2) ? com.alipay.sdk.app.b.a() : d2;
        }
        return (String) invokeLL.objValue;
    }
}
