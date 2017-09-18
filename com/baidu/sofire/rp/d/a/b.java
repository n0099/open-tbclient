package com.baidu.sofire.rp.d.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.appsearchlib.Info;
import com.baidu.sofire.rp.f.d;
import com.baidu.sofire.rp.f.f;
import com.baidu.sofire.rp.f.i;
import java.net.URLEncoder;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b extends a {
    private com.baidu.sofire.rp.d.b.a Qa;

    public b(Context context) {
        super(context);
        this.b = context;
        this.Qa = com.baidu.sofire.rp.d.b.a.at(context);
    }

    public final boolean b(String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            byte[] b = com.baidu.sofire.rp.f.b.b();
            String a = this.Qa.a(URLEncoder.encode(Base64.encodeToString(f.c(b, i.a(d.a(this.b)).getBytes()), 0)));
            String str3 = a;
            com.baidu.sofire.rp.d.b.a aVar = this.Qa;
            byte[] a2 = com.baidu.sofire.rp.d.b.a.a(b, str);
            if (a2 != null) {
                try {
                    String g = g(a, a2);
                    String str4 = g;
                    if (TextUtils.isEmpty(g)) {
                        return false;
                    }
                    try {
                        if (new JSONObject(g).getInt("response") == 1) {
                        }
                        return true;
                    } catch (Throwable th) {
                        com.baidu.sofire.rp.f.b.a();
                        return true;
                    }
                } catch (Throwable th2) {
                    com.baidu.sofire.rp.f.b.a();
                    return false;
                }
            }
            return true;
        } catch (Throwable th3) {
            com.baidu.sofire.rp.f.b.a();
            return true;
        }
    }

    public final void a(Context context) {
        try {
            String a = this.Qa.a();
            r0 = a;
            String a2 = a(a);
            r0 = a2;
            if (!TextUtils.isEmpty(a2)) {
                try {
                    JSONObject jSONObject = new JSONObject(a2);
                    String optString = jSONObject.optString("response");
                    String optString2 = jSONObject.optString("skey");
                    if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString)) {
                        try {
                            try {
                                try {
                                    JSONObject jSONObject2 = new JSONObject(new String(f.b(Base64.decode(optString.getBytes(), 0), f.d(Base64.decode(optString2.getBytes(), 0), i.a(d.a(context)).getBytes())))).getJSONObject("c");
                                    com.baidu.sofire.rp.a.a aVar = new com.baidu.sofire.rp.a.a(this.b);
                                    int optInt = jSONObject2.optInt("n");
                                    if (optInt > 0) {
                                        aVar.PS.putInt("re_net_ty", optInt);
                                        aVar.PS.commit();
                                    }
                                    int optInt2 = jSONObject2.optInt("i");
                                    if (optInt2 > 0) {
                                        aVar.PS.putInt("re_net_hr", optInt2);
                                        aVar.PS.commit();
                                    }
                                    int optInt3 = jSONObject2.optInt("i2");
                                    if (optInt3 > 0) {
                                        aVar.PS.putInt("re_net_hr_bc", optInt3);
                                        aVar.PS.commit();
                                    }
                                    String str = Integer.toString(optInt2) + " " + Integer.toString(optInt3);
                                    int optInt4 = jSONObject2.optInt("w");
                                    if (optInt4 > 0) {
                                        aVar.PS.putInt("re_net_wt", optInt4);
                                        aVar.PS.commit();
                                    }
                                    if (jSONObject2.optInt("s1") > 0) {
                                        aVar.PS.putInt("re_net_one_lt", jSONObject2.optInt("s1"));
                                        aVar.PS.commit();
                                    }
                                    int optInt5 = jSONObject2.optInt("s2");
                                    if (optInt5 > 0) {
                                        aVar.PS.putInt("re_net_dy_lt", optInt5);
                                        aVar.PS.commit();
                                    }
                                    int optInt6 = jSONObject2.optInt(Info.kBaiduTimeKey);
                                    if (optInt6 > 0) {
                                        aVar.PS.putInt("re_net_over", optInt6);
                                        aVar.PS.commit();
                                    }
                                    int optInt7 = jSONObject2.optInt("l1");
                                    if (optInt7 > 0) {
                                        aVar.PS.putInt("up_nu_co", optInt7);
                                        aVar.PS.commit();
                                    }
                                    int optInt8 = jSONObject2.optInt("l2");
                                    if (optInt8 > 0) {
                                        aVar.PS.putInt("up_nu_li", optInt8);
                                        aVar.PS.commit();
                                    }
                                    String str2 = Integer.toString(optInt7) + " " + Integer.toString(optInt8);
                                } catch (Throwable th) {
                                    com.baidu.sofire.rp.f.b.a();
                                }
                            } catch (Throwable th2) {
                                com.baidu.sofire.rp.f.b.a();
                            }
                        } catch (Throwable th3) {
                            com.baidu.sofire.rp.f.b.a();
                        }
                    }
                } catch (Throwable th4) {
                    com.baidu.sofire.rp.f.b.a();
                }
            }
        } catch (Throwable th5) {
            com.baidu.sofire.rp.f.b.a();
        }
    }
}
