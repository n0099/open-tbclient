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
import com.alipay.sdk.util.H5PayResultModel;
import com.alipay.sdk.util.e;
import com.alipay.sdk.util.l;
import com.alipay.sdk.util.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.channelpay.alipay.Result;
import com.baidu.android.lbspay.presenter.LBSTransAuthPresenter;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.disk.DefaultDiskStorage;
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
/* loaded from: classes.dex */
public class PayTask {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final Object f1772a;

    /* renamed from: h  reason: collision with root package name */
    public static long f1773h = 0;

    /* renamed from: i  reason: collision with root package name */
    public static final long f1774i = 3000;
    public static long j = -1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Activity f1775b;

    /* renamed from: c  reason: collision with root package name */
    public com.alipay.sdk.widget.a f1776c;

    /* renamed from: d  reason: collision with root package name */
    public String f1777d;

    /* renamed from: e  reason: collision with root package name */
    public String f1778e;

    /* renamed from: f  reason: collision with root package name */
    public String f1779f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, a> f1780g;

    /* loaded from: classes.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PayTask f1781a;

        /* renamed from: b  reason: collision with root package name */
        public String f1782b;

        /* renamed from: c  reason: collision with root package name */
        public String f1783c;

        /* renamed from: d  reason: collision with root package name */
        public String f1784d;

        /* renamed from: e  reason: collision with root package name */
        public String f1785e;

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
            this.f1781a = payTask;
            this.f1782b = "";
            this.f1783c = "";
            this.f1784d = "";
            this.f1785e = "";
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f1782b : (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f1784d : (String) invokeV.objValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f1783c : (String) invokeV.objValue;
        }

        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f1785e : (String) invokeV.objValue;
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f1782b = str;
            }
        }

        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f1784d = str;
            }
        }

        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.f1783c = str;
            }
        }

        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
                this.f1785e = str;
            }
        }

        public /* synthetic */ a(PayTask payTask, g gVar) {
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
        f1772a = com.alipay.sdk.util.e.class;
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
        this.f1777d = "wappaygw.alipay.com/service/rest.htm";
        this.f1778e = "mclient.alipay.com/service/rest.htm";
        this.f1779f = "mclient.alipay.com/home/exterfaceAssign.htm";
        this.f1780g = new HashMap();
        this.f1775b = activity;
        com.alipay.sdk.sys.b.a().a(this.f1775b, com.alipay.sdk.data.c.b());
        com.alipay.sdk.app.statistic.a.a(activity);
        this.f1776c = new com.alipay.sdk.widget.a(activity, com.alipay.sdk.widget.a.f2015b);
    }

    public static final String a(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, strArr)) == null) {
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

    private String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, str)) == null) {
            showLoading();
            k kVar = null;
            try {
                try {
                    JSONObject c2 = new com.alipay.sdk.packet.impl.e().a(this.f1775b.getApplicationContext(), str).c();
                    String optString = c2.optString("end_code", null);
                    List<com.alipay.sdk.protocol.b> a2 = com.alipay.sdk.protocol.b.a(c2.optJSONObject("form").optJSONObject(com.alipay.sdk.cons.c.f1853d));
                    for (int i2 = 0; i2 < a2.size(); i2++) {
                        if (a2.get(i2).b() == com.alipay.sdk.protocol.a.f1920c) {
                            com.alipay.sdk.protocol.b.a(a2.get(i2));
                        }
                    }
                    a(c2);
                    dismissLoading();
                    for (int i3 = 0; i3 < a2.size(); i3++) {
                        com.alipay.sdk.protocol.b bVar = a2.get(i3);
                        if (bVar.b() == com.alipay.sdk.protocol.a.f1919b) {
                            String a3 = a(bVar);
                            dismissLoading();
                            return a3;
                        } else if (bVar.b() == com.alipay.sdk.protocol.a.f1921d) {
                            String a4 = a(bVar, optString);
                            dismissLoading();
                            return a4;
                        }
                    }
                } catch (IOException e2) {
                    kVar = k.b(k.f1813d.a());
                    com.alipay.sdk.app.statistic.a.a("net", e2);
                }
                dismissLoading();
                if (kVar == null) {
                    kVar = k.b(k.f1811b.a());
                }
                return j.a(kVar.a(), kVar.b(), "");
            }
        }
        return (String) invokeL.objValue;
    }

    public static synchronized boolean fetchSdkConfig(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            synchronized (PayTask.class) {
                try {
                    com.alipay.sdk.sys.b.a().a(context, com.alipay.sdk.data.c.b());
                    long elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
                    if (elapsedRealtime - f1773h < com.alipay.sdk.data.a.g().e()) {
                        return false;
                    }
                    f1773h = elapsedRealtime;
                    com.alipay.sdk.data.a.g().a(context.getApplicationContext());
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
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f1776c) == null) {
            return;
        }
        aVar.c();
        this.f1776c = null;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0043, code lost:
        if (r9.startsWith("http://" + r16.f1777d) != false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00e0, code lost:
        if (r9.startsWith("http://" + r16.f1778e) != false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x017d, code lost:
        if (r9.startsWith("http://" + r16.f1779f) != false) goto L83;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized String fetchOrderInfoFromH5PayUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            synchronized (this) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        String trim = str.trim();
                        if (!trim.startsWith("https://" + this.f1777d)) {
                        }
                        String trim2 = trim.replaceFirst("(http|https)://" + this.f1777d + "\\?", "").trim();
                        if (!TextUtils.isEmpty(trim2)) {
                            return "_input_charset=\"utf-8\"&ordertoken=\"" + n.a("<request_token>", "</request_token>", n.b(trim2).get("req_data")) + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + new com.alipay.sdk.sys.a(this.f1775b).a(Config.STAT_SDK_CHANNEL, "h5tonative") + "\"";
                        }
                        if (!trim.startsWith("https://" + this.f1778e)) {
                        }
                        String trim3 = trim.replaceFirst("(http|https)://" + this.f1778e + "\\?", "").trim();
                        if (!TextUtils.isEmpty(trim3)) {
                            return "_input_charset=\"utf-8\"&ordertoken=\"" + n.a("<request_token>", "</request_token>", n.b(trim3).get("req_data")) + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + new com.alipay.sdk.sys.a(this.f1775b).a(Config.STAT_SDK_CHANNEL, "h5tonative") + "\"";
                        }
                        if (!trim.startsWith("https://" + this.f1779f)) {
                        }
                        if (trim.contains("alipay.wap.create.direct.pay.by.user") || trim.contains("create_forex_trade_wap")) {
                            if (!TextUtils.isEmpty(trim.replaceFirst("(http|https)://" + this.f1779f + "\\?", "").trim())) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("url", str);
                                jSONObject.put("bizcontext", new com.alipay.sdk.sys.a(this.f1775b).a(Config.STAT_SDK_CHANNEL, "h5tonative"));
                                return "new_external_info==" + jSONObject.toString();
                            }
                        }
                        if (Pattern.compile("^(http|https)://(maliprod\\.alipay\\.com/w/trade_pay\\.do.?|mali\\.alipay\\.com/w/trade_pay\\.do.?|mclient\\.alipay\\.com/w/trade_pay\\.do.?)").matcher(str).find()) {
                            String a2 = n.a("?", "", str);
                            if (!TextUtils.isEmpty(a2)) {
                                Map<String, String> b2 = n.b(a2);
                                StringBuilder sb = new StringBuilder();
                                if (a(false, true, com.alipay.sdk.app.statistic.c.ad, sb, b2, com.alipay.sdk.app.statistic.c.ad, "alipay_trade_no")) {
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
                                        a aVar = new a(this, null);
                                        aVar.a(b2.get("return_url"));
                                        aVar.c(b2.get("show_url"));
                                        aVar.b(b2.get("pay_order_id"));
                                        String str3 = sb.toString() + "&bizcontext=\"" + new com.alipay.sdk.sys.a(this.f1775b).a(Config.STAT_SDK_CHANNEL, "h5tonative") + "\"";
                                        this.f1780g.put(str3, aVar);
                                        return str3;
                                    }
                                    return "";
                                }
                            }
                        }
                        if (!trim.contains("mclient.alipay.com/cashier/mobilepay.htm") && (!EnvUtils.isSandBox() || !trim.contains("mobileclientgw.alipaydev.com/cashier/mobilepay.htm"))) {
                            if (com.alipay.sdk.data.a.g().c() && Pattern.compile("^https?://(maliprod\\.alipay\\.com|mali\\.alipay\\.com)/batch_payment\\.do\\?").matcher(trim).find()) {
                                Uri parse = Uri.parse(trim);
                                String queryParameter = parse.getQueryParameter("return_url");
                                String queryParameter2 = parse.getQueryParameter("show_url");
                                String queryParameter3 = parse.getQueryParameter("pay_order_id");
                                String a3 = a(parse.getQueryParameter("trade_nos"), parse.getQueryParameter("alipay_trade_no"));
                                String a4 = a(parse.getQueryParameter("payPhaseId"), parse.getQueryParameter("pay_phase_id"), parse.getQueryParameter("out_relation_id"));
                                String[] strArr = new String[4];
                                strArr[0] = parse.getQueryParameter("app_name");
                                strArr[1] = !TextUtils.isEmpty(parse.getQueryParameter(IAdRequestParam.CELL_ID)) ? "ali1688" : "";
                                strArr[2] = !TextUtils.isEmpty(parse.getQueryParameter("sid")) ? TbConfig.PassConfig.TPL : "";
                                strArr[3] = !TextUtils.isEmpty(parse.getQueryParameter("s_id")) ? TbConfig.PassConfig.TPL : "";
                                String a5 = a(strArr);
                                String a6 = a(parse.getQueryParameter("extern_token"), parse.getQueryParameter(IAdRequestParam.CELL_ID), parse.getQueryParameter("sid"), parse.getQueryParameter("s_id"));
                                String a7 = a(parse.getQueryParameter("appenv"));
                                if (!TextUtils.isEmpty(a3) && !TextUtils.isEmpty(a5) && !TextUtils.isEmpty(a6)) {
                                    String format = String.format("trade_no=\"%s\"&pay_phase_id=\"%s\"&biz_type=\"trade\"&biz_sub_type=\"TRADE\"&app_name=\"%s\"&extern_token=\"%s\"&appenv=\"%s\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"%s\"", a3, a4, a5, a6, a7, new com.alipay.sdk.sys.a(this.f1775b).a(Config.STAT_SDK_CHANNEL, "h5tonative"));
                                    a aVar2 = new a(this, null);
                                    aVar2.a(queryParameter);
                                    aVar2.c(queryParameter2);
                                    aVar2.b(queryParameter3);
                                    aVar2.d(a3);
                                    this.f1780g.put(format, aVar2);
                                    return format;
                                }
                            }
                        }
                        String a8 = new com.alipay.sdk.sys.a(this.f1775b).a(Config.STAT_SDK_CHANNEL, "h5tonative");
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("url", trim);
                        jSONObject2.put("bizcontext", a8);
                        return String.format("new_external_info==%s", jSONObject2.toString());
                    }
                } finally {
                    return "";
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
                a2 = com.alipay.sdk.util.i.a(this.f1775b.getApplicationContext());
            }
            return a2;
        }
        return (String) invokeV.objValue;
    }

    public String getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "15.6.5" : (String) invokeV.objValue;
    }

    public synchronized H5PayResultModel h5Pay(String str, boolean z) {
        InterceptResult invokeLZ;
        H5PayResultModel h5PayResultModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, str, z)) == null) {
            synchronized (this) {
                h5PayResultModel = new H5PayResultModel();
                String[] split = pay(str, z).split(";");
                HashMap hashMap = new HashMap();
                for (String str2 : split) {
                    int indexOf = str2.indexOf("={");
                    if (indexOf >= 0) {
                        String substring = str2.substring(0, indexOf);
                        hashMap.put(substring, a(str2, substring));
                    }
                }
                if (hashMap.containsKey(l.f1991a)) {
                    h5PayResultModel.setResultCode(hashMap.get(l.f1991a));
                }
                h5PayResultModel.setReturnUrl(a(str, hashMap));
                if (TextUtils.isEmpty(h5PayResultModel.getReturnUrl())) {
                    com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.T, "");
                }
            }
            return h5PayResultModel;
        }
        return (H5PayResultModel) invokeLZ.objValue;
    }

    public synchronized String pay(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048581, this, str, z)) == null) {
            synchronized (this) {
                if (b()) {
                    return j.d();
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
                    i.a(substring.replaceAll("\"", "").toLowerCase(Locale.getDefault()).replaceAll(LBSTransAuthPresenter.AUTH_CHANNEL_ALI, ""));
                } else {
                    i.a("");
                }
                if (str.contains(com.alipay.sdk.cons.a.r)) {
                    com.alipay.sdk.cons.a.s = true;
                }
                if (com.alipay.sdk.cons.a.s) {
                    if (str.startsWith(com.alipay.sdk.cons.a.t)) {
                        str = str.substring(str.indexOf(com.alipay.sdk.cons.a.t) + 53);
                    } else if (str.startsWith(com.alipay.sdk.cons.a.u)) {
                        str = str.substring(str.indexOf(com.alipay.sdk.cons.a.u) + 52);
                    }
                }
                String a2 = a(str);
                com.alipay.sdk.util.i.a(this.f1775b.getApplicationContext(), a2);
                com.alipay.sdk.data.a.g().a(this.f1775b.getApplicationContext());
                dismissLoading();
                com.alipay.sdk.app.statistic.a.b(this.f1775b.getApplicationContext(), str);
                return a2;
            }
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
                    new Thread(new g(this, fetchOrderInfoFromH5PayUrl, z, h5PayCallback)).start();
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
                a2 = l.a(pay(str, z));
            }
            return a2;
        }
        return (Map) invokeLZ.objValue;
    }

    public void showLoading() {
        com.alipay.sdk.widget.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (aVar = this.f1776c) == null) {
            return;
        }
        aVar.b();
    }

    private boolean a(boolean z, boolean z2, String str, StringBuilder sb, Map<String, String> map, String... strArr) {
        InterceptResult invokeCommon;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, sb, map, strArr})) == null) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, str, map)) == null) {
            boolean equals = Result.RESULT_SUCCESS.equals(map.get(l.f1991a));
            String str2 = map.get("result");
            a remove = this.f1780g.remove(str);
            String[] strArr = new String[2];
            strArr[0] = remove != null ? remove.b() : "";
            strArr[1] = remove != null ? remove.d() : "";
            a(strArr);
            if (map.containsKey("callBackUrl")) {
                return map.get("callBackUrl");
            }
            if (str2.length() > 15) {
                String a2 = a(n.a("&callBackUrl=\"", "\"", str2), n.a("&call_back_url=\"", "\"", str2), n.a(com.alipay.sdk.cons.a.p, "\"", str2), URLDecoder.decode(n.a(com.alipay.sdk.cons.a.q, "&", str2), "utf-8"), URLDecoder.decode(n.a("&callBackUrl=", "&", str2), "utf-8"), n.a("call_back_url=\"", "\"", str2));
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
            return remove != null ? com.alipay.sdk.data.a.g().d() : "";
        }
        return (String) invokeLL.objValue;
    }

    private String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, str, str2)) == null) {
            String str3 = str2 + "={";
            return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf("}"));
        }
        return (String) invokeLL.objValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - j >= 3000) {
                j = elapsedRealtime;
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    private e.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? new h(this) : (e.a) invokeV.objValue;
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str)) == null) {
            String a2 = new com.alipay.sdk.sys.a(this.f1775b).a(str);
            if (a2.contains("paymethod=\"expressGateway\"")) {
                return b(a2);
            }
            List<a.C0016a> f2 = com.alipay.sdk.data.a.g().f();
            if (!com.alipay.sdk.data.a.g().q || f2 == null) {
                f2 = i.f1804a;
            }
            if (n.b(this.f1775b, f2)) {
                com.alipay.sdk.util.e eVar = new com.alipay.sdk.util.e(this.f1775b, a());
                String a3 = eVar.a(a2);
                eVar.a();
                if (!TextUtils.equals(a3, com.alipay.sdk.util.e.f1967a) && !TextUtils.equals(a3, com.alipay.sdk.util.e.f1968b)) {
                    if (TextUtils.isEmpty(a3)) {
                        return j.c();
                    }
                    if (a3.contains(PayResultActivity.f1761a)) {
                        com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.Q, "");
                        return a(a2, f2, a3, this.f1775b);
                    }
                    return a3;
                }
                com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.O, "");
                return b(a2);
            }
            com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.P, "");
            return b(a2);
        }
        return (String) invokeL.objValue;
    }

    public static String a(String str, List<a.C0016a> list, String str2, Activity activity) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65543, null, str, list, str2, activity)) == null) {
            n.a a2 = n.a(activity, list);
            if (a2 == null || a2.a() || a2.b() || !TextUtils.equals(a2.f2001a.packageName, PayResultActivity.f1763c)) {
                return str2;
            }
            com.alipay.sdk.util.c.b(com.alipay.sdk.net.a.f1894a, "PayTask:payResult: NOT_LOGIN");
            String valueOf = String.valueOf(str.hashCode());
            PayResultActivity.f1762b.put(valueOf, new Object());
            Intent intent = new Intent(activity, PayResultActivity.class);
            intent.putExtra(PayResultActivity.f1765e, str);
            intent.putExtra(PayResultActivity.f1766f, activity.getPackageName());
            intent.putExtra(PayResultActivity.f1764d, valueOf);
            activity.startActivity(intent);
            synchronized (PayResultActivity.f1762b.get(valueOf)) {
                try {
                    com.alipay.sdk.util.c.b(com.alipay.sdk.net.a.f1894a, "PayTask:payResult: wait");
                    PayResultActivity.f1762b.get(valueOf).wait();
                } catch (InterruptedException e2) {
                    com.alipay.sdk.util.c.b(com.alipay.sdk.net.a.f1894a, "PayTask:payResult: InterruptedException:" + e2);
                    return j.c();
                }
            }
            String str3 = PayResultActivity.a.f1771b;
            com.alipay.sdk.util.c.b(com.alipay.sdk.net.a.f1894a, "PayTask:payResult: result:" + str3);
            return str3;
        }
        return (String) invokeLLLL.objValue;
    }

    private void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, jSONObject) == null) {
            try {
                String optString = jSONObject.optString("tid");
                String optString2 = jSONObject.optString(com.alipay.sdk.tid.b.f1947e);
                if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                    return;
                }
                com.alipay.sdk.tid.b.a(com.alipay.sdk.sys.b.a().b()).a(optString, optString2);
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.H, th);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0092, code lost:
        r0 = r6.c();
        r10 = com.alipay.sdk.app.j.a(java.lang.Integer.valueOf(r0[1]).intValue(), r0[0], com.alipay.sdk.util.n.e(r0[2]));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(com.alipay.sdk.protocol.b bVar, String str) {
        InterceptResult invokeLL;
        boolean b2;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, bVar, str)) == null) {
            String[] c2 = bVar.c();
            Intent intent = new Intent(this.f1775b, H5PayActivity.class);
            try {
                JSONObject d2 = n.d(new String(com.alipay.sdk.encrypt.a.a(c2[2])));
                intent.putExtra("url", c2[0]);
                intent.putExtra("title", c2[1]);
                intent.putExtra("version", DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX);
                intent.putExtra("method", d2.optString("method", "POST"));
                j.a(false);
                j.a((String) null);
                this.f1775b.startActivity(intent);
                synchronized (f1772a) {
                    try {
                        f1772a.wait();
                        b2 = j.b();
                        a2 = j.a();
                        j.a(false);
                        j.a((String) null);
                    } catch (InterruptedException e2) {
                        com.alipay.sdk.util.c.a(e2);
                        return j.c();
                    }
                }
                String str2 = "";
                if (b2) {
                    try {
                        List<com.alipay.sdk.protocol.b> a3 = com.alipay.sdk.protocol.b.a(n.d(new String(com.alipay.sdk.encrypt.a.a(a2))));
                        int i2 = 0;
                        while (true) {
                            if (i2 >= a3.size()) {
                                break;
                            }
                            com.alipay.sdk.protocol.b bVar2 = a3.get(i2);
                            if (bVar2.b() == com.alipay.sdk.protocol.a.f1922e) {
                                break;
                            }
                            i2++;
                        }
                    } catch (Throwable th) {
                        com.alipay.sdk.util.c.a(th);
                        com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.u, th, a2);
                    }
                }
                if (TextUtils.isEmpty(str2)) {
                    try {
                        return j.a(Integer.valueOf(str).intValue(), "", "");
                    } catch (Throwable th2) {
                        com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.u, th2, "endCode: " + str);
                        return j.a(8000, "", "");
                    }
                }
                return str2;
            } catch (Throwable th3) {
                com.alipay.sdk.util.c.a(th3);
                com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.u, th3, Arrays.toString(c2));
                return j.c();
            }
        }
        return (String) invokeLL.objValue;
    }

    private String a(com.alipay.sdk.protocol.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, bVar)) == null) {
            String[] c2 = bVar.c();
            Intent intent = new Intent(this.f1775b, H5PayActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("url", c2[0]);
            if (c2.length == 2) {
                bundle.putString("cookie", c2[1]);
            }
            intent.putExtras(bundle);
            this.f1775b.startActivity(intent);
            synchronized (f1772a) {
                try {
                    f1772a.wait();
                } catch (InterruptedException e2) {
                    com.alipay.sdk.util.c.a(e2);
                    return j.c();
                }
            }
            String a2 = j.a();
            return TextUtils.isEmpty(a2) ? j.c() : a2;
        }
        return (String) invokeL.objValue;
    }
}
