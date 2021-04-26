package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.app.PayResultActivity;
import com.alipay.sdk.data.a;
import com.alipay.sdk.util.H5PayResultModel;
import com.alipay.sdk.util.e;
import com.alipay.sdk.util.l;
import com.alipay.sdk.util.n;
import com.baidu.android.lbspay.channelpay.alipay.Result;
import com.baidu.android.lbspay.presenter.LBSTransAuthPresenter;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
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

    /* renamed from: a  reason: collision with root package name */
    public static final Object f1755a = com.alipay.sdk.util.e.class;

    /* renamed from: h  reason: collision with root package name */
    public static long f1756h = 0;

    /* renamed from: i  reason: collision with root package name */
    public static final long f1757i = 3000;
    public static long j = -1;

    /* renamed from: b  reason: collision with root package name */
    public Activity f1758b;

    /* renamed from: c  reason: collision with root package name */
    public com.alipay.sdk.widget.a f1759c;

    /* renamed from: d  reason: collision with root package name */
    public String f1760d = "wappaygw.alipay.com/service/rest.htm";

    /* renamed from: e  reason: collision with root package name */
    public String f1761e = "mclient.alipay.com/service/rest.htm";

    /* renamed from: f  reason: collision with root package name */
    public String f1762f = "mclient.alipay.com/home/exterfaceAssign.htm";

    /* renamed from: g  reason: collision with root package name */
    public Map<String, a> f1763g = new HashMap();

    /* loaded from: classes.dex */
    public class a {

        /* renamed from: b  reason: collision with root package name */
        public String f1765b;

        /* renamed from: c  reason: collision with root package name */
        public String f1766c;

        /* renamed from: d  reason: collision with root package name */
        public String f1767d;

        /* renamed from: e  reason: collision with root package name */
        public String f1768e;

        public a() {
            this.f1765b = "";
            this.f1766c = "";
            this.f1767d = "";
            this.f1768e = "";
        }

        public String a() {
            return this.f1765b;
        }

        public String b() {
            return this.f1767d;
        }

        public String c() {
            return this.f1766c;
        }

        public String d() {
            return this.f1768e;
        }

        public void a(String str) {
            this.f1765b = str;
        }

        public void b(String str) {
            this.f1767d = str;
        }

        public void c(String str) {
            this.f1766c = str;
        }

        public void d(String str) {
            this.f1768e = str;
        }

        public /* synthetic */ a(PayTask payTask, g gVar) {
            this();
        }
    }

    public PayTask(Activity activity) {
        this.f1758b = activity;
        com.alipay.sdk.sys.b.a().a(this.f1758b, com.alipay.sdk.data.c.b());
        com.alipay.sdk.app.statistic.a.a(activity);
        this.f1759c = new com.alipay.sdk.widget.a(activity, com.alipay.sdk.widget.a.f1998b);
    }

    public static final String a(String... strArr) {
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

    /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String b(String str) {
        showLoading();
        k kVar = null;
        try {
            try {
                JSONObject c2 = new com.alipay.sdk.packet.impl.e().a(this.f1758b.getApplicationContext(), str).c();
                String optString = c2.optString("end_code", null);
                List<com.alipay.sdk.protocol.b> a2 = com.alipay.sdk.protocol.b.a(c2.optJSONObject("form").optJSONObject(com.alipay.sdk.cons.c.f1836d));
                for (int i2 = 0; i2 < a2.size(); i2++) {
                    if (a2.get(i2).b() == com.alipay.sdk.protocol.a.Update) {
                        com.alipay.sdk.protocol.b.a(a2.get(i2));
                    }
                }
                a(c2);
                dismissLoading();
                for (int i3 = 0; i3 < a2.size(); i3++) {
                    com.alipay.sdk.protocol.b bVar = a2.get(i3);
                    if (bVar.b() == com.alipay.sdk.protocol.a.WapPay) {
                        return a(bVar);
                    }
                    if (bVar.b() == com.alipay.sdk.protocol.a.OpenWeb) {
                        return a(bVar, optString);
                    }
                }
            } finally {
                dismissLoading();
            }
        } catch (IOException e2) {
            kVar = k.b(k.NETWORK_ERROR.a());
            com.alipay.sdk.app.statistic.a.a("net", e2);
            if (kVar == null) {
            }
            return j.a(kVar.a(), kVar.b(), "");
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
            com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.u, th);
            if (kVar == null) {
            }
            return j.a(kVar.a(), kVar.b(), "");
        }
        if (kVar == null) {
            kVar = k.b(k.FAILED.a());
        }
        return j.a(kVar.a(), kVar.b(), "");
    }

    public static synchronized boolean fetchSdkConfig(Context context) {
        synchronized (PayTask.class) {
            try {
                com.alipay.sdk.sys.b.a().a(context, com.alipay.sdk.data.c.b());
                long elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
                if (elapsedRealtime - f1756h < com.alipay.sdk.data.a.g().e()) {
                    return false;
                }
                f1756h = elapsedRealtime;
                com.alipay.sdk.data.a.g().a(context.getApplicationContext());
                return true;
            } catch (Exception e2) {
                com.alipay.sdk.util.c.a(e2);
                return false;
            }
        }
    }

    public void dismissLoading() {
        com.alipay.sdk.widget.a aVar = this.f1759c;
        if (aVar != null) {
            aVar.c();
            this.f1759c = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00dc, code lost:
        if (r9.startsWith("http://" + r16.f1761e) != false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0179, code lost:
        if (r9.startsWith("http://" + r16.f1762f) != false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x003f, code lost:
        if (r9.startsWith("http://" + r16.f1760d) != false) goto L95;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized String fetchOrderInfoFromH5PayUrl(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String trim = str.trim();
                if (!trim.startsWith("https://" + this.f1760d)) {
                }
                String trim2 = trim.replaceFirst("(http|https)://" + this.f1760d + "\\?", "").trim();
                if (!TextUtils.isEmpty(trim2)) {
                    return "_input_charset=\"utf-8\"&ordertoken=\"" + n.a("<request_token>", "</request_token>", n.b(trim2).get("req_data")) + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + new com.alipay.sdk.sys.a(this.f1758b).a(Config.STAT_SDK_CHANNEL, "h5tonative") + "\"";
                }
                if (!trim.startsWith("https://" + this.f1761e)) {
                }
                String trim3 = trim.replaceFirst("(http|https)://" + this.f1761e + "\\?", "").trim();
                if (!TextUtils.isEmpty(trim3)) {
                    return "_input_charset=\"utf-8\"&ordertoken=\"" + n.a("<request_token>", "</request_token>", n.b(trim3).get("req_data")) + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + new com.alipay.sdk.sys.a(this.f1758b).a(Config.STAT_SDK_CHANNEL, "h5tonative") + "\"";
                }
                if (!trim.startsWith("https://" + this.f1762f)) {
                }
                if (trim.contains("alipay.wap.create.direct.pay.by.user") || trim.contains("create_forex_trade_wap")) {
                    if (!TextUtils.isEmpty(trim.replaceFirst("(http|https)://" + this.f1762f + "\\?", "").trim())) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("url", str);
                        jSONObject.put("bizcontext", new com.alipay.sdk.sys.a(this.f1758b).a(Config.STAT_SDK_CHANNEL, "h5tonative"));
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
                            String str2 = b2.get(DpStatConstants.KEY_APP_NAME);
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
                                String str3 = sb.toString() + "&bizcontext=\"" + new com.alipay.sdk.sys.a(this.f1758b).a(Config.STAT_SDK_CHANNEL, "h5tonative") + "\"";
                                this.f1763g.put(str3, aVar);
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
                        strArr[0] = parse.getQueryParameter(DpStatConstants.KEY_APP_NAME);
                        strArr[1] = !TextUtils.isEmpty(parse.getQueryParameter(IAdRequestParam.CELL_ID)) ? "ali1688" : "";
                        strArr[2] = !TextUtils.isEmpty(parse.getQueryParameter("sid")) ? TbConfig.PassConfig.TPL : "";
                        strArr[3] = !TextUtils.isEmpty(parse.getQueryParameter("s_id")) ? TbConfig.PassConfig.TPL : "";
                        String a5 = a(strArr);
                        String a6 = a(parse.getQueryParameter("extern_token"), parse.getQueryParameter(IAdRequestParam.CELL_ID), parse.getQueryParameter("sid"), parse.getQueryParameter("s_id"));
                        String a7 = a(parse.getQueryParameter("appenv"));
                        if (!TextUtils.isEmpty(a3) && !TextUtils.isEmpty(a5) && !TextUtils.isEmpty(a6)) {
                            String format = String.format("trade_no=\"%s\"&pay_phase_id=\"%s\"&biz_type=\"trade\"&biz_sub_type=\"TRADE\"&app_name=\"%s\"&extern_token=\"%s\"&appenv=\"%s\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"%s\"", a3, a4, a5, a6, a7, new com.alipay.sdk.sys.a(this.f1758b).a(Config.STAT_SDK_CHANNEL, "h5tonative"));
                            a aVar2 = new a(this, null);
                            aVar2.a(queryParameter);
                            aVar2.c(queryParameter2);
                            aVar2.b(queryParameter3);
                            aVar2.d(a3);
                            this.f1763g.put(format, aVar2);
                            return format;
                        }
                    }
                }
                String a8 = new com.alipay.sdk.sys.a(this.f1758b).a(Config.STAT_SDK_CHANNEL, "h5tonative");
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

    public synchronized String fetchTradeToken() {
        return com.alipay.sdk.util.i.a(this.f1758b.getApplicationContext());
    }

    public String getVersion() {
        return "15.6.5";
    }

    public synchronized H5PayResultModel h5Pay(String str, boolean z) {
        H5PayResultModel h5PayResultModel;
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
        if (hashMap.containsKey(l.f1974a)) {
            h5PayResultModel.setResultCode(hashMap.get(l.f1974a));
        }
        h5PayResultModel.setReturnUrl(a(str, hashMap));
        if (TextUtils.isEmpty(h5PayResultModel.getReturnUrl())) {
            com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.T, "");
        }
        return h5PayResultModel;
    }

    public synchronized String pay(String str, boolean z) {
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
        com.alipay.sdk.util.i.a(this.f1758b.getApplicationContext(), a2);
        com.alipay.sdk.data.a.g().a(this.f1758b.getApplicationContext());
        dismissLoading();
        com.alipay.sdk.app.statistic.a.b(this.f1758b.getApplicationContext(), str);
        return a2;
    }

    public synchronized boolean payInterceptorWithUrl(String str, boolean z, H5PayCallback h5PayCallback) {
        String fetchOrderInfoFromH5PayUrl;
        fetchOrderInfoFromH5PayUrl = fetchOrderInfoFromH5PayUrl(str);
        if (!TextUtils.isEmpty(fetchOrderInfoFromH5PayUrl)) {
            new Thread(new g(this, fetchOrderInfoFromH5PayUrl, z, h5PayCallback)).start();
        }
        return !TextUtils.isEmpty(fetchOrderInfoFromH5PayUrl);
    }

    public synchronized Map<String, String> payV2(String str, boolean z) {
        return l.a(pay(str, z));
    }

    public void showLoading() {
        com.alipay.sdk.widget.a aVar = this.f1759c;
        if (aVar != null) {
            aVar.b();
        }
    }

    private boolean a(boolean z, boolean z2, String str, StringBuilder sb, Map<String, String> map, String... strArr) {
        String str2;
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

    private String a(String str, Map<String, String> map) throws UnsupportedEncodingException {
        boolean equals = Result.RESULT_SUCCESS.equals(map.get(l.f1974a));
        String str2 = map.get("result");
        a remove = this.f1763g.remove(str);
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

    private String a(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf("}"));
    }

    public static boolean b() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - j >= 3000) {
            j = elapsedRealtime;
            return false;
        }
        return true;
    }

    private e.a a() {
        return new h(this);
    }

    private String a(String str) {
        String a2 = new com.alipay.sdk.sys.a(this.f1758b).a(str);
        if (a2.contains("paymethod=\"expressGateway\"")) {
            return b(a2);
        }
        List<a.C0015a> f2 = com.alipay.sdk.data.a.g().f();
        if (!com.alipay.sdk.data.a.g().q || f2 == null) {
            f2 = i.f1787a;
        }
        if (n.b(this.f1758b, f2)) {
            com.alipay.sdk.util.e eVar = new com.alipay.sdk.util.e(this.f1758b, a());
            String a3 = eVar.a(a2);
            eVar.a();
            if (!TextUtils.equals(a3, com.alipay.sdk.util.e.f1950a) && !TextUtils.equals(a3, com.alipay.sdk.util.e.f1951b)) {
                if (TextUtils.isEmpty(a3)) {
                    return j.c();
                }
                if (a3.contains(PayResultActivity.f1744a)) {
                    com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.Q, "");
                    return a(a2, f2, a3, this.f1758b);
                }
                return a3;
            }
            com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.O, "");
            return b(a2);
        }
        com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.P, "");
        return b(a2);
    }

    public static String a(String str, List<a.C0015a> list, String str2, Activity activity) {
        n.a a2 = n.a(activity, list);
        if (a2 == null || a2.a() || a2.b() || !TextUtils.equals(a2.f1984a.packageName, PayResultActivity.f1746c)) {
            return str2;
        }
        com.alipay.sdk.util.c.b(com.alipay.sdk.net.a.f1877a, "PayTask:payResult: NOT_LOGIN");
        String valueOf = String.valueOf(str.hashCode());
        PayResultActivity.f1745b.put(valueOf, new Object());
        Intent intent = new Intent(activity, PayResultActivity.class);
        intent.putExtra(PayResultActivity.f1748e, str);
        intent.putExtra(PayResultActivity.f1749f, activity.getPackageName());
        intent.putExtra(PayResultActivity.f1747d, valueOf);
        activity.startActivity(intent);
        synchronized (PayResultActivity.f1745b.get(valueOf)) {
            try {
                com.alipay.sdk.util.c.b(com.alipay.sdk.net.a.f1877a, "PayTask:payResult: wait");
                PayResultActivity.f1745b.get(valueOf).wait();
            } catch (InterruptedException e2) {
                com.alipay.sdk.util.c.b(com.alipay.sdk.net.a.f1877a, "PayTask:payResult: InterruptedException:" + e2);
                return j.c();
            }
        }
        String str3 = PayResultActivity.a.f1754b;
        com.alipay.sdk.util.c.b(com.alipay.sdk.net.a.f1877a, "PayTask:payResult: result:" + str3);
        return str3;
    }

    private void a(JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("tid");
            String optString2 = jSONObject.optString(com.alipay.sdk.tid.b.f1930e);
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                return;
            }
            com.alipay.sdk.tid.b.a(com.alipay.sdk.sys.b.a().b()).a(optString, optString2);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.H, th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x008e, code lost:
        r0 = r6.c();
        r10 = com.alipay.sdk.app.j.a(java.lang.Integer.valueOf(r0[1]).intValue(), r0[0], com.alipay.sdk.util.n.e(r0[2]));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(com.alipay.sdk.protocol.b bVar, String str) {
        boolean b2;
        String a2;
        String[] c2 = bVar.c();
        Intent intent = new Intent(this.f1758b, H5PayActivity.class);
        try {
            JSONObject d2 = n.d(new String(com.alipay.sdk.encrypt.a.a(c2[2])));
            intent.putExtra("url", c2[0]);
            intent.putExtra("title", c2[1]);
            intent.putExtra("version", DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX);
            intent.putExtra("method", d2.optString("method", "POST"));
            j.a(false);
            j.a((String) null);
            this.f1758b.startActivity(intent);
            synchronized (f1755a) {
                try {
                    f1755a.wait();
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
                        if (bVar2.b() == com.alipay.sdk.protocol.a.SetResult) {
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

    private String a(com.alipay.sdk.protocol.b bVar) {
        String[] c2 = bVar.c();
        Intent intent = new Intent(this.f1758b, H5PayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("url", c2[0]);
        if (c2.length == 2) {
            bundle.putString("cookie", c2[1]);
        }
        intent.putExtras(bundle);
        this.f1758b.startActivity(intent);
        synchronized (f1755a) {
            try {
                f1755a.wait();
            } catch (InterruptedException e2) {
                com.alipay.sdk.util.c.a(e2);
                return j.c();
            }
        }
        String a2 = j.a();
        return TextUtils.isEmpty(a2) ? j.c() : a2;
    }
}
