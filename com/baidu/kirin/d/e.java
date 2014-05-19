package com.baidu.kirin.d;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public boolean a;
    public int b;
    public String c;
    public JSONObject d = null;

    public int a() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public void a(String str) {
        this.c = str;
        try {
            this.d = new JSONObject(this.c);
        } catch (JSONException e) {
            d.c("message to JSONObject error!! msg[" + this.c + "]");
            e.printStackTrace();
        }
    }

    public void a(boolean z) {
        this.a = z;
    }

    public boolean b() {
        return this.a;
    }

    public String c() {
        return this.c;
    }

    public JSONObject d() {
        if (this.d != null) {
            return this.d;
        }
        return null;
    }
}
