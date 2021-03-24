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
    public long f8598a;

    /* renamed from: b  reason: collision with root package name */
    public String f8599b;

    /* renamed from: c  reason: collision with root package name */
    public String f8600c;

    /* renamed from: d  reason: collision with root package name */
    public String f8601d;

    /* renamed from: e  reason: collision with root package name */
    public String f8602e;

    /* renamed from: f  reason: collision with root package name */
    public String f8603f;

    /* renamed from: g  reason: collision with root package name */
    public String f8604g;

    /* renamed from: h  reason: collision with root package name */
    public String f8605h;
    public String i;
    public String j;
    public String k;
    public Context l;
    public h m;
    public IXAdSystemUtils n;
    public C0109a o;

    /* renamed from: com.baidu.mobads.vo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0109a {

        /* renamed from: a  reason: collision with root package name */
        public String f8606a;

        /* renamed from: b  reason: collision with root package name */
        public String f8607b;

        /* renamed from: c  reason: collision with root package name */
        public String f8608c;

        /* renamed from: d  reason: collision with root package name */
        public String f8609d;

        /* renamed from: e  reason: collision with root package name */
        public String f8610e;

        public C0109a(IXAdInstanceInfo iXAdInstanceInfo, IXAdProdInfo iXAdProdInfo) {
            this.f8606a = "";
            this.f8607b = "";
            this.f8608c = "";
            this.f8609d = "";
            this.f8610e = "";
            if (iXAdInstanceInfo != null) {
                this.f8606a = iXAdInstanceInfo.getAdId();
                this.f8607b = iXAdInstanceInfo.getQueryKey();
                this.f8609d = iXAdInstanceInfo.getCreativeType().getValue();
            }
            if (iXAdProdInfo != null) {
                this.f8610e = iXAdProdInfo.getAdPlacementId();
                this.f8608c = iXAdProdInfo.getProdType();
            }
        }
    }

    public a(C0109a c0109a) {
        this(c0109a.f8606a, c0109a.f8607b, c0109a.f8608c);
        this.o = c0109a;
    }

    public HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("adid", this.f8599b);
        hashMap.put("appsec", this.f8602e);
        hashMap.put("appsid", this.f8603f);
        hashMap.put("pack", this.f8601d);
        hashMap.put("qk", this.f8600c);
        hashMap.put(IXAdRequestInfo.SN, this.f8605h);
        hashMap.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, "" + this.f8598a);
        hashMap.put("v", this.f8604g);
        hashMap.put(IXAdRequestInfo.OS, this.i);
        hashMap.put("prod", this.j);
        hashMap.put("cuid", XAdSDKFoundationFacade.getInstance().getBase64().encode(this.k));
        hashMap.put(IXAdRequestInfo.P_VER, XAdSDKProxyVersion.RELEASE_TAG);
        C0109a c0109a = this.o;
        if (c0109a != null) {
            hashMap.put("adt", c0109a.f8609d);
            hashMap.put("apid", this.o.f8610e);
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
        this.f8599b = "-1";
        this.f8600c = "";
        this.f8601d = "";
        this.f8602e = "";
        this.f8603f = "";
        this.f8604g = "";
        this.f8605h = "";
        this.j = "";
        this.k = "";
        this.o = null;
        this.m = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        this.n = XAdSDKFoundationFacade.getInstance().getSystemUtils();
        this.l = XAdSDKFoundationFacade.getInstance().getApplicationContext();
        this.f8598a = System.currentTimeMillis();
        this.f8599b = str;
        this.f8600c = str2;
        this.f8602e = this.m.getAppSec(this.l);
        Context context = this.l;
        if (context != null) {
            this.f8601d = context.getPackageName();
        }
        this.f8603f = this.m.getAppId(this.l);
        this.f8605h = this.n.getEncodedSN(this.l);
        this.i = "android";
        this.f8604g = "android_" + com.baidu.mobads.constants.a.f8205c + "_4.1.30";
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
