package com.baidu.apollon.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3872a = "wifi";

    /* renamed from: b  reason: collision with root package name */
    public static final String f3873b = "3G";

    /* renamed from: c  reason: collision with root package name */
    public static final String f3874c = "time";

    /* renamed from: d  reason: collision with root package name */
    public static final String f3875d = "count";

    /* renamed from: e  reason: collision with root package name */
    public static final String f3876e = "now";

    /* renamed from: f  reason: collision with root package name */
    public static final String f3877f = "never";

    /* renamed from: g  reason: collision with root package name */
    public static final String f3878g = "now";

    /* renamed from: h  reason: collision with root package name */
    public static final String f3879h = "strategy_timestamp";
    public static final int i = 0;
    public static final int j = 200;
    public static final String k = "g";
    public static final int l = 1;
    public static final int m = 2;
    public static final int n = 3;
    public static final int o = 1;
    public static final int p = 5;
    public Context q;
    public JSONObject r;
    public JSONObject s;
    public String[] x;
    public String[] y;
    public final String z = "{data:{disable:0,3G:5,wifi:1,now:[\"abandonPay\",\"schemePayEnter\",\"resultClickBtn\"],kf:{now:[],time:0,count:200}}}";
    public byte[] u = new byte[0];
    public volatile int v = 1;
    public volatile int w = 5;
    public boolean t = true;

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final g f3880a = new g();
    }

    public static g a() {
        return a.f3880a;
    }

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = (JSONObject) new JSONTokener(str).nextValue();
            jSONObject.put(f3879h, System.currentTimeMillis());
            BasicStoreTools.getInstance().setStrategy(this.q, jSONObject.toString());
            this.r = jSONObject;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void f() {
        StatisticsSettings a2 = PayStatisticsUtil.getInstance().a();
        if (a2 != null) {
            c(a2.getStrategy());
        }
    }

    private void g() {
        JSONObject jSONObject = this.r;
        if (jSONObject != null && jSONObject.has(f3879h)) {
            synchronized (this.u) {
                JSONObject optJSONObject = this.r.optJSONObject("data");
                if (optJSONObject == null) {
                    optJSONObject = this.r;
                }
                boolean z = true;
                if (optJSONObject != null) {
                    this.v = optJSONObject.optInt("wifi", 1);
                    this.w = optJSONObject.optInt(f3873b, 5);
                    if (1 == optJSONObject.optInt(PackageTable.DISABLE, 0)) {
                        z = false;
                    }
                    this.t = z;
                    JSONArray optJSONArray = optJSONObject.optJSONArray("now");
                    this.x = optJSONArray == null ? new String[0] : new String[optJSONArray.length()];
                    if (optJSONArray != null) {
                        for (int i2 = 0; i2 < this.x.length; i2++) {
                            this.x[i2] = optJSONArray.optString(i2);
                        }
                    }
                    Arrays.sort(this.x);
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray(f3877f);
                    this.y = optJSONArray2 == null ? new String[0] : new String[optJSONArray2.length()];
                    for (int i3 = 0; i3 < this.y.length; i3++) {
                        this.y[i3] = optJSONArray2.optString(i3);
                    }
                    Arrays.sort(this.y);
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(CustomerService.sMarkString);
                    if (optJSONObject2 != null) {
                        CustomerService.getInstance().setConfig(optJSONObject2.optInt("time", 0) * 1000, optJSONObject2.optInt("count", 200));
                        this.s = optJSONObject2.optJSONObject("now");
                    } else {
                        a(2);
                    }
                } else {
                    a(1);
                    a(2);
                }
            }
            return;
        }
        a(3);
    }

    public boolean b() {
        long j2;
        JSONObject jSONObject = this.r;
        if (jSONObject == null || !jSONObject.has(f3879h)) {
            return true;
        }
        try {
            j2 = this.r.getLong(f3879h);
        } catch (Exception e2) {
            e2.printStackTrace();
            j2 = 0;
        }
        long currentTimeMillis = System.currentTimeMillis() - j2;
        return 86400000 < currentTimeMillis || 0 > currentTimeMillis;
    }

    public int d() {
        return this.w;
    }

    public boolean e() {
        return this.t;
    }

    private void a(int i2) {
        synchronized (this.u) {
            if ((i2 & 1) != 0) {
                this.x = new String[]{"abandonPay", StatServiceEvent.SCHEME_PAY_ENTER, StatServiceEvent.RESULT_CLICK_BTN};
                this.y = new String[0];
                this.t = true;
                this.w = 5;
                this.v = 1;
            }
            if ((i2 & 2) != 0) {
                this.s = null;
                CustomerService.getInstance().setConfig(0, 200);
            }
        }
        if (3 == (i2 & 3)) {
            try {
                this.r = (JSONObject) new JSONTokener("{data:{disable:0,3G:5,wifi:1,now:[\"abandonPay\",\"schemePayEnter\",\"resultClickBtn\"],kf:{now:[],time:0,count:200}}}").nextValue();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean b(String str) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        synchronized (this.u) {
            z = false;
            if (this.y != null && this.y.length > 0) {
                try {
                    z = Arrays.binarySearch(this.y, str) >= 0;
                } catch (Exception unused) {
                }
            }
        }
        return z;
    }

    public int c() {
        return this.v;
    }

    public void a(Context context) {
        if (this.q == null && context != null) {
            this.q = context.getApplicationContext();
        }
        if (this.q == null) {
            return;
        }
        String strategy = BasicStoreTools.getInstance().getStrategy(this.q);
        if (TextUtils.isEmpty(strategy)) {
            strategy = "{data:{disable:0,3G:5,wifi:1,now:[\"abandonPay\",\"schemePayEnter\",\"resultClickBtn\"],kf:{now:[],time:0,count:200}}}";
        }
        try {
            this.r = (JSONObject) new JSONTokener(strategy).nextValue();
            if (com.baidu.apollon.statistics.a.a(this.q) && b()) {
                f();
            }
        } catch (Exception unused) {
        }
        g();
        LogSender.getInstance().triggerSending("normal_log");
    }

    public boolean a(String str) {
        boolean z;
        synchronized (this.u) {
            z = false;
            if (!TextUtils.isEmpty(str) && this.x != null && this.x.length > 0) {
                try {
                    if (Arrays.binarySearch(this.x, str) >= 0) {
                        z = true;
                    }
                } catch (Exception unused) {
                }
            }
        }
        return z;
    }

    public boolean a(e eVar) {
        if (this.s != null && eVar != null && !TextUtils.isEmpty(eVar.f3869h)) {
            synchronized (this.u) {
                if (this.s.has(eVar.f3869h)) {
                    try {
                        JSONObject optJSONObject = this.s.optJSONObject(eVar.f3869h);
                        if (optJSONObject == null) {
                            return true;
                        }
                        Iterator<String> keys = optJSONObject.keys();
                        if (!keys.hasNext()) {
                            return true;
                        }
                        JSONArray jSONArray = (JSONArray) new JSONTokener(eVar.j).nextValue();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            int intValue = Integer.valueOf(next).intValue() - 1;
                            if (intValue >= 0 && jSONArray.length() > intValue) {
                                JSONArray jSONArray2 = (JSONArray) new JSONTokener(optJSONObject.getString(next)).nextValue();
                                String str = (String) jSONArray.get(intValue);
                                int length = jSONArray2.length();
                                for (int i2 = 0; i2 < length; i2++) {
                                    String optString = jSONArray2.optString(i2, "");
                                    if (optString != null && optString.equals(str)) {
                                        return true;
                                    }
                                }
                                continue;
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        return false;
    }
}
