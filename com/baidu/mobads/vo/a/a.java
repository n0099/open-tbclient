package com.baidu.mobads.vo.a;

import android.content.Context;
import com.baidu.ar.constants.HttpConstants;
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
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public long f3554a;

    /* renamed from: b  reason: collision with root package name */
    public String f3555b;
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
    private C0274a o;

    protected abstract HashMap<String, String> b();

    /* renamed from: com.baidu.mobads.vo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0274a {

        /* renamed from: a  reason: collision with root package name */
        String f3556a;

        /* renamed from: b  reason: collision with root package name */
        String f3557b;
        String c;
        String d;
        String e;

        public C0274a(IXAdInstanceInfo iXAdInstanceInfo, IXAdProdInfo iXAdProdInfo) {
            this.f3556a = "";
            this.f3557b = "";
            this.c = "";
            this.d = "";
            this.e = "";
            if (iXAdInstanceInfo != null) {
                this.f3556a = iXAdInstanceInfo.getAdId();
                this.f3557b = iXAdInstanceInfo.getQueryKey();
                this.d = iXAdInstanceInfo.getCreativeType().getValue();
            }
            if (iXAdProdInfo != null) {
                this.e = iXAdProdInfo.getAdPlacementId();
                this.c = iXAdProdInfo.getProdType();
            }
        }
    }

    public a(C0274a c0274a) {
        this(c0274a.f3556a, c0274a.f3557b, c0274a.c);
        this.o = c0274a;
    }

    @Deprecated
    public a(String str, String str2, String str3) {
        this.f3555b = "-1";
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
        this.f3554a = System.currentTimeMillis();
        this.f3555b = str;
        this.c = str2;
        this.e = this.m.getAppSec(this.l);
        if (this.l != null) {
            this.d = this.l.getPackageName();
        }
        this.f = this.m.getAppId(this.l);
        this.h = this.n.getEncodedSN(this.l);
        this.i = HttpConstants.OS_TYPE_VALUE;
        this.g = "android_" + com.baidu.mobads.a.a.c + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + "4.1.30";
        this.j = str3;
        this.k = XAdSDKFoundationFacade.getInstance().getSystemUtils().getCUID(this.l);
    }

    protected HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("adid", this.f3555b);
        hashMap.put("appsec", this.e);
        hashMap.put("appsid", this.f);
        hashMap.put("pack", this.d);
        hashMap.put("qk", this.c);
        hashMap.put(IXAdRequestInfo.SN, this.h);
        hashMap.put("ts", "" + this.f3554a);
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
        HashMap<String, String> b2 = b();
        if (b2 != null) {
            a2.putAll(b2);
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
                    sb.append(a2 + "=" + a3 + ETAG.ITEM_SEPARATOR);
                    sb2.append(a3 + ",");
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
