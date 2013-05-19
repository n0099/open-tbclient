package com.baidu.location;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import com.baidu.android.pushservice.PushConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    public String a;
    public Messenger b;
    public j c = new j();
    public int d = 0;
    final /* synthetic */ k e;

    public l(k kVar, Message message) {
        this.e = kVar;
        this.a = null;
        this.b = null;
        this.b = message.replyTo;
        this.a = message.getData().getString("packName");
        this.c.f = message.getData().getString("prodName");
        this.c.a = message.getData().getString("coorType");
        this.c.b = message.getData().getString("addrType");
        ap.i = this.c.b;
        this.c.c = message.getData().getBoolean("openGPS");
        this.c.d = message.getData().getInt("scanSpan");
        this.c.e = message.getData().getInt("timeOut");
        this.c.g = message.getData().getInt("priority");
        this.c.h = message.getData().getBoolean("location_change_notify");
    }

    public void a(int i) {
        Message obtain = Message.obtain((Handler) null, i);
        try {
            if (this.b != null) {
                this.b.send(obtain);
            }
            this.d = 0;
        } catch (Exception e) {
            if (e instanceof DeadObjectException) {
                this.d++;
            }
        }
    }

    private void a(int i, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(str, str2);
        Message obtain = Message.obtain((Handler) null, i);
        obtain.setData(bundle);
        try {
            if (this.b != null) {
                this.b.send(obtain);
            }
            this.d = 0;
        } catch (Exception e) {
            if (e instanceof DeadObjectException) {
                this.d++;
            }
        }
    }

    public void a() {
        if (this.c.h) {
            if (ap.d) {
                a(54);
            } else {
                a(55);
            }
        }
    }

    public void a(String str) {
        if (str == null) {
            return;
        }
        if (ap.b) {
            a(21, "locStr", str);
            return;
        }
        a(27, "locStr", str);
        if (this.c.a != null && !this.c.a.equals("gcj02")) {
            double c = ap.c(str, "x\":\"", "\"");
            double c2 = ap.c(str, "y\":\"", "\"");
            if (c != Double.MIN_VALUE && c2 != Double.MIN_VALUE) {
                double[] a = Jni.a(c, c2, this.c.a);
                if (a[0] > 0.0d || a[1] > 0.0d) {
                    str = ap.a(ap.a(str, "x\":\"", "\"", a[0]), "y\":\"", "\"", a[1]);
                }
            }
        }
        a(21, "locStr", str);
    }

    public void a(String str, int i) {
        String str2;
        String str3;
        String str4;
        String str5;
        int i2 = 0;
        str2 = k.a;
        ap.a(str2, "decode...");
        if (str == null) {
            return;
        }
        if (ap.b) {
            a(i, "locStr", str);
            return;
        }
        if (i == 21) {
            a(27, "locStr", str);
        }
        if (this.c.a != null && !this.c.a.equals("gcj02")) {
            double c = ap.c(str, "x\":\"", "\"");
            double c2 = ap.c(str, "y\":\"", "\"");
            str3 = k.a;
            ap.a(str3, "decode..." + c + ":" + c2);
            if (c != Double.MIN_VALUE && c2 != Double.MIN_VALUE) {
                double[] a = Jni.a(c, c2, this.c.a);
                str = ap.a(ap.a(str, "x\":\"", "\"", a[0]), "y\":\"", "\"", a[1]);
                str4 = k.a;
                ap.a(str4, "decode2 ..." + a[0] + ":" + a[1]);
                str5 = k.a;
                ap.a(str5, "decode3 ..." + str);
            }
            if (this.c.j) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    JSONObject jSONObject2 = jSONObject.getJSONObject("result");
                    JSONObject jSONObject3 = jSONObject.getJSONObject(PushConstants.EXTRA_CONTENT);
                    if (Integer.parseInt(jSONObject2.getString("error")) == 161) {
                        JSONObject jSONObject4 = jSONObject3.getJSONObject("poi");
                        JSONArray jSONArray = jSONObject4.getJSONArray("p");
                        while (i2 < jSONArray.length()) {
                            JSONObject jSONObject5 = jSONArray.getJSONObject(i2);
                            double parseDouble = Double.parseDouble(jSONObject5.getString("x"));
                            double parseDouble2 = Double.parseDouble(jSONObject5.getString("y"));
                            if (parseDouble != Double.MIN_VALUE && parseDouble2 != Double.MIN_VALUE) {
                                double[] a2 = Jni.a(parseDouble, parseDouble2, this.c.a);
                                jSONObject5.put("x", String.valueOf(a2[0]));
                                jSONObject5.put("y", String.valueOf(a2[1]));
                                jSONArray.put(i2, jSONObject5);
                                i2++;
                            }
                        }
                        jSONObject4.put("p", jSONArray);
                        jSONObject3.put("poi", jSONObject4);
                        jSONObject.put(PushConstants.EXTRA_CONTENT, jSONObject3);
                        str = jSONObject.toString();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        a(i, "locStr", str);
    }

    public void b(String str) {
        if (this.c.h) {
            a(str);
        }
    }
}
