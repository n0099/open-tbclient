package cn.com.chinatelecom.gateway.lib.b;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
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
    public String f1502b;

    /* renamed from: d  reason: collision with root package name */
    public String f1504d;

    /* renamed from: f  reason: collision with root package name */
    public String f1506f;

    /* renamed from: g  reason: collision with root package name */
    public String f1507g;

    /* renamed from: h  reason: collision with root package name */
    public String f1508h;
    public String i;
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
    public String f1503c = "";

    /* renamed from: e  reason: collision with root package name */
    public String f1505e = "";
    public String n = "";
    public String m = "";
    public String p = "";

    /* renamed from: a  reason: collision with root package name */
    public String f1501a = "1.1";

    public b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.u = currentTimeMillis;
        this.f1502b = a(currentTimeMillis);
        this.f1504d = "";
        this.f1506f = "";
        this.f1507g = Build.BRAND;
        this.f1508h = Build.MODEL;
        this.i = "Android";
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

    public b a(int i) {
        this.o = i;
        return this;
    }

    public b a(String str) {
        this.f1504d = str;
        return this;
    }

    public b b(long j) {
        this.q = j;
        return this;
    }

    public b b(String str) {
        this.f1505e = str;
        return this;
    }

    public b c(String str) {
        this.f1506f = str;
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
            jSONObject.put("v", this.f1501a);
            jSONObject.put("t", this.f1502b);
            jSONObject.put("tag", this.f1503c);
            jSONObject.put("ai", this.f1504d);
            jSONObject.put(AppIconSetting.DEFAULT_LARGE_ICON, this.f1505e);
            jSONObject.put(NotificationStyle.NOTIFICATION_STYLE, this.f1506f);
            jSONObject.put("br", this.f1507g);
            jSONObject.put("ml", this.f1508h);
            jSONObject.put(IAdRequestParam.OS, this.i);
            jSONObject.put("ov", this.j);
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
