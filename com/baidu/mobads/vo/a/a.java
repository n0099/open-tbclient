package com.baidu.mobads.vo.a;

import android.content.Context;
import com.baidu.mobads.constants.XAdSDKProxyVersion;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.h;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import com.xiaomi.mipush.sdk.Constants;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public long f8599a;

    /* renamed from: b  reason: collision with root package name */
    public String f8600b;

    /* renamed from: c  reason: collision with root package name */
    public String f8601c;

    /* renamed from: d  reason: collision with root package name */
    public String f8602d;

    /* renamed from: e  reason: collision with root package name */
    public String f8603e;

    /* renamed from: f  reason: collision with root package name */
    public String f8604f;

    /* renamed from: g  reason: collision with root package name */
    public String f8605g;

    /* renamed from: h  reason: collision with root package name */
    public String f8606h;
    public String i;
    public String j;
    public String k;
    public Context l;
    public h m;
    public IXAdSystemUtils n;
    public C0110a o;

    /* renamed from: com.baidu.mobads.vo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0110a {

        /* renamed from: a  reason: collision with root package name */
        public String f8607a;

        /* renamed from: b  reason: collision with root package name */
        public String f8608b;

        /* renamed from: c  reason: collision with root package name */
        public String f8609c;

        /* renamed from: d  reason: collision with root package name */
        public String f8610d;

        /* renamed from: e  reason: collision with root package name */
        public String f8611e;

        public C0110a(IXAdInstanceInfo iXAdInstanceInfo, IXAdProdInfo iXAdProdInfo) {
            this.f8607a = "";
            this.f8608b = "";
            this.f8609c = "";
            this.f8610d = "";
            this.f8611e = "";
            if (iXAdInstanceInfo != null) {
                this.f8607a = iXAdInstanceInfo.getAdId();
                this.f8608b = iXAdInstanceInfo.getQueryKey();
                this.f8610d = iXAdInstanceInfo.getCreativeType().getValue();
            }
            if (iXAdProdInfo != null) {
                this.f8611e = iXAdProdInfo.getAdPlacementId();
                this.f8609c = iXAdProdInfo.getProdType();
            }
        }
    }

    public a(C0110a c0110a) {
        this(c0110a.f8607a, c0110a.f8608b, c0110a.f8609c);
        this.o = c0110a;
    }

    public HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("adid", this.f8600b);
        hashMap.put("appsec", this.f8603e);
        hashMap.put("appsid", this.f8604f);
        hashMap.put("pack", this.f8602d);
        hashMap.put("qk", this.f8601c);
        hashMap.put(IXAdRequestInfo.SN, this.f8606h);
        hashMap.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, "" + this.f8599a);
        hashMap.put("v", this.f8605g);
        hashMap.put(IXAdRequestInfo.OS, this.i);
        hashMap.put("prod", this.j);
        hashMap.put("cuid", XAdSDKFoundationFacade.getInstance().getBase64().encode(this.k));
        hashMap.put(IXAdRequestInfo.P_VER, XAdSDKProxyVersion.RELEASE_TAG);
        C0110a c0110a = this.o;
        if (c0110a != null) {
            hashMap.put("adt", c0110a.f8610d);
            hashMap.put("apid", this.o.f8611e);
        }
        return hashMap;
    }

    public abstract HashMap<String, String> b();

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

    @Deprecated
    public a(String str, String str2, String str3) {
        this.f8600b = "-1";
        this.f8601c = "";
        this.f8602d = "";
        this.f8603e = "";
        this.f8604f = "";
        this.f8605g = "";
        this.f8606h = "";
        this.j = "";
        this.k = "";
        this.o = null;
        this.m = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        this.n = XAdSDKFoundationFacade.getInstance().getSystemUtils();
        this.l = XAdSDKFoundationFacade.getInstance().getApplicationContext();
        this.f8599a = System.currentTimeMillis();
        this.f8600b = str;
        this.f8601c = str2;
        this.f8603e = this.m.getAppSec(this.l);
        Context context = this.l;
        if (context != null) {
            this.f8602d = context.getPackageName();
        }
        this.f8604f = this.m.getAppId(this.l);
        this.f8606h = this.n.getEncodedSN(this.l);
        this.i = "android";
        this.f8605g = "android_" + com.baidu.mobads.constants.a.f8206c + "_4.1.30";
        this.j = str3;
        this.k = XAdSDKFoundationFacade.getInstance().getSystemUtils().getCUID(this.l);
    }

    public String a(HashMap<String, String> hashMap) {
        StringBuilder sb = new StringBuilder();
        try {
            h commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
            StringBuilder sb2 = new StringBuilder();
            for (String str : hashMap.keySet()) {
                String str2 = hashMap.get(str);
                if (str != null && str2 != null) {
                    String a2 = a(str);
                    String a3 = a(str2);
                    sb.append(a2 + "=" + a3 + "&");
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(a3);
                    sb3.append(",");
                    sb2.append(sb3.toString());
                }
            }
            sb2.append("mobads,");
            String md5 = commonUtils.getMD5(sb2.toString());
            sb.append("vd=" + md5 + "&");
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public String a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", SmallTailInfo.EMOTION_SUFFIX).replaceAll("\\%7E", Constants.WAVE_SEPARATOR);
        } catch (Exception unused) {
            return str;
        }
    }
}
