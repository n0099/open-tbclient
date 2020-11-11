package com.baidu.mobads.vo.a;

import android.content.Context;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.e;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes7.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public long f2452a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    protected Context l;
    protected e m;
    protected IXAdSystemUtils n;
    private C0265a o;

    protected abstract HashMap<String, String> b();

    /* renamed from: com.baidu.mobads.vo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0265a {

        /* renamed from: a  reason: collision with root package name */
        String f2453a;
        String b;
        String c;
        String d;
        String e;

        public C0265a(IXAdInstanceInfo iXAdInstanceInfo, IXAdProdInfo iXAdProdInfo) {
            this.f2453a = "";
            this.b = "";
            this.c = "";
            this.d = "";
            this.e = "";
            if (iXAdInstanceInfo != null) {
                this.f2453a = iXAdInstanceInfo.getAdId();
                this.b = iXAdInstanceInfo.getQueryKey();
                this.d = iXAdInstanceInfo.getCreativeType().getValue();
            }
            if (iXAdProdInfo != null) {
                this.e = iXAdProdInfo.getAdPlacementId();
                this.c = iXAdProdInfo.getProdType();
            }
        }
    }

    public a(C0265a c0265a) {
        this(c0265a.f2453a, c0265a.b, c0265a.c);
        this.o = c0265a;
    }

    @Deprecated
    public a(String str, String str2, String str3) {
        this.b = "-1";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.j = "";
        this.k = "";
        this.o = null;
        this.m = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        this.n = XAdSDKFoundationFacade.getInstance().getSystemUtils();
        this.l = XAdSDKFoundationFacade.getInstance().getApplicationContext();
        this.f2452a = System.currentTimeMillis();
        this.b = str;
        this.c = str2;
        this.e = this.m.getAppSec(this.l);
        if (this.l != null) {
            this.d = this.l.getPackageName();
        }
        this.f = this.m.getAppId(this.l);
        this.h = this.n.getEncodedSN(this.l);
        this.i = "android";
        this.g = "android_" + com.baidu.mobads.a.a.c + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + "4.1.30";
        this.j = str3;
        this.k = XAdSDKFoundationFacade.getInstance().getSystemUtils().getCUID(this.l);
    }

    protected HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("adid", this.b);
        hashMap.put("appsec", this.e);
        hashMap.put("appsid", this.f);
        hashMap.put("pack", this.d);
        hashMap.put("qk", this.c);
        hashMap.put(IXAdRequestInfo.SN, this.h);
        hashMap.put("ts", "" + this.f2452a);
        hashMap.put("v", this.g);
        hashMap.put("os", this.i);
        hashMap.put("prod", this.j);
        hashMap.put("cuid", this.k);
        hashMap.put(IXAdRequestInfo.P_VER, "8.8146");
        if (this.o != null) {
            hashMap.put("adt", this.o.d);
            hashMap.put("apid", this.o.e);
        }
        return hashMap;
    }

    public HashMap<String, String> c() {
        HashMap<String, String> a2 = a();
        HashMap<String, String> b = b();
        if (b != null) {
            a2.putAll(b);
        }
        return a2;
    }

    public String toString() {
        return a(c());
    }

    protected String a(HashMap<String, String> hashMap) {
        StringBuilder sb = new StringBuilder();
        try {
            e commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
            StringBuilder sb2 = new StringBuilder();
            for (String str : hashMap.keySet()) {
                String str2 = hashMap.get(str);
                if (str != null && str2 != null) {
                    String a2 = a(str);
                    String a3 = a(str2);
                    sb.append(a2 + ETAG.EQUAL + a3 + ETAG.ITEM_SEPARATOR);
                    sb2.append(a3 + Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
            sb2.append("mobads,");
            sb.append("vd=" + commonUtils.getMD5(sb2.toString()) + ETAG.ITEM_SEPARATOR);
            return sb.toString();
        } catch (Exception e) {
            return "";
        }
    }

    protected String a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", ")").replaceAll("\\%7E", Constants.WAVE_SEPARATOR);
        } catch (Exception e) {
            return str;
        }
    }
}
