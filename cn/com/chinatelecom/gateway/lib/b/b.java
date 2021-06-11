package cn.com.chinatelecom.gateway.lib.b;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public String f1535b;

    /* renamed from: d  reason: collision with root package name */
    public String f1537d;

    /* renamed from: f  reason: collision with root package name */
    public String f1539f;

    /* renamed from: g  reason: collision with root package name */
    public String f1540g;

    /* renamed from: h  reason: collision with root package name */
    public String f1541h;

    /* renamed from: i  reason: collision with root package name */
    public String f1542i;
    public String j;
    public String k;
    public String l;
    public int o;
    public long q;
    public long r;
    public String s;
    public long u;
    public long v;
    public StringBuffer t = new StringBuffer();

    /* renamed from: c  reason: collision with root package name */
    public String f1536c = "";

    /* renamed from: e  reason: collision with root package name */
    public String f1538e = "";
    public String n = "";
    public String m = "";
    public String p = "";

    /* renamed from: a  reason: collision with root package name */
    public String f1534a = "1.1";

    public b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.u = currentTimeMillis;
        this.f1535b = a(currentTimeMillis);
        this.f1537d = "";
        this.f1539f = "";
        this.f1540g = Build.BRAND;
        this.f1541h = Build.MODEL;
        this.f1542i = "Android";
        this.j = Build.VERSION.RELEASE;
        this.k = "SDK-JJ-v3.6.2";
        this.l = str;
        this.s = "0";
    }

    public static String a(long j) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA).format(new Date(j));
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public b a(int i2) {
        this.o = i2;
        return this;
    }

    public b a(String str) {
        this.f1537d = str;
        return this;
    }

    public b b(long j) {
        this.q = j;
        return this;
    }

    public b b(String str) {
        this.f1538e = str;
        return this;
    }

    public b c(String str) {
        this.f1539f = str;
        return this;
    }

    public b d(String str) {
        this.m = str;
        return this;
    }

    public b e(String str) {
        this.n = str;
        return this;
    }

    public b f(String str) {
        this.p = str;
        return this;
    }

    public b g(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.s = str;
        }
        return this;
    }

    public b h(String str) {
        StringBuffer stringBuffer = this.t;
        stringBuffer.append(str);
        stringBuffer.append("\n");
        return this;
    }

    public String toString() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.v = currentTimeMillis;
            this.r = currentTimeMillis - this.u;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("v", this.f1534a);
            jSONObject.put("t", this.f1535b);
            jSONObject.put("tag", this.f1536c);
            jSONObject.put("ai", this.f1537d);
            jSONObject.put(AppIconSetting.DEFAULT_LARGE_ICON, this.f1538e);
            jSONObject.put(NotificationStyle.NOTIFICATION_STYLE, this.f1539f);
            jSONObject.put("br", this.f1540g);
            jSONObject.put("ml", this.f1541h);
            jSONObject.put(IAdRequestParam.OS, this.f1542i);
            jSONObject.put(SearchJsBridge.COOKIE_OV, this.j);
            jSONObject.put("sv", this.k);
            jSONObject.put("ri", this.l);
            jSONObject.put(RetrieveTaskManager.KEY, this.m);
            jSONObject.put("p", this.n);
            jSONObject.put("rt", this.o);
            jSONObject.put("msg", this.p);
            jSONObject.put("st", this.q);
            jSONObject.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, this.r);
            jSONObject.put("ot", this.s);
            jSONObject.put("ep", this.t.toString());
            return jSONObject.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
