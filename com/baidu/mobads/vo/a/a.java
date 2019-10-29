package com.baidu.mobads.vo.a;

import android.content.Context;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.e;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import com.xiaomi.mipush.sdk.Constants;
import java.net.URLEncoder;
import java.util.HashMap;
import org.apache.http.protocol.HTTP;
/* loaded from: classes5.dex */
public abstract class a {
    public long a;
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
    private C0107a o;

    protected abstract HashMap<String, String> b();

    /* renamed from: com.baidu.mobads.vo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0107a {
        String a;
        String b;
        String c;
        String d;
        String e;

        public C0107a(IXAdInstanceInfo iXAdInstanceInfo, IXAdProdInfo iXAdProdInfo) {
            this.a = "";
            this.b = "";
            this.c = "";
            this.d = "";
            this.e = "";
            if (iXAdInstanceInfo != null) {
                this.a = iXAdInstanceInfo.getAdId();
                this.b = iXAdInstanceInfo.getQueryKey();
                this.d = iXAdInstanceInfo.getCreativeType().getValue();
            }
            if (iXAdProdInfo != null) {
                this.e = iXAdProdInfo.getAdPlacementId();
                this.c = iXAdProdInfo.getProdType();
            }
        }
    }

    public a(C0107a c0107a) {
        this(c0107a.a, c0107a.b, c0107a.c);
        this.o = c0107a;
    }

    @Deprecated
    public a(String str, String str2, String str3) {
        this.b = LivenessStat.TYPE_STRING_DEFAULT;
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
        this.a = System.currentTimeMillis();
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
        hashMap.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, "" + this.a);
        hashMap.put("v", this.g);
        hashMap.put("os", this.i);
        hashMap.put("prod", this.j);
        hashMap.put("cuid", this.k);
        hashMap.put(IXAdRequestInfo.P_VER, "8.8079");
        if (this.o != null) {
            hashMap.put("adt", this.o.d);
            hashMap.put("apid", this.o.e);
        }
        return hashMap;
    }

    public HashMap<String, String> c() {
        HashMap<String, String> a = a();
        HashMap<String, String> b = b();
        if (b != null) {
            a.putAll(b);
        }
        return a;
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
                    String a = a(str);
                    String a2 = a(str2);
                    sb.append(a + "=" + a2 + "&");
                    sb2.append(a2 + Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
            sb2.append("mobads,");
            sb.append("vd=" + commonUtils.getMD5(sb2.toString()) + "&");
            return sb.toString();
        } catch (Exception e) {
            return "";
        }
    }

    protected String a(String str) {
        try {
            return URLEncoder.encode(str, HTTP.UTF_8).replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", ")").replaceAll("\\%7E", Constants.WAVE_SEPARATOR);
        } catch (Exception e) {
            return str;
        }
    }
}
