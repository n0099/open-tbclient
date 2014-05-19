package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Media;
/* loaded from: classes.dex */
public class k {
    private int a = -1;
    private String b = null;
    private String c = null;
    private String d = null;

    public String a() {
        return this.d;
    }

    public int b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public void b(String str) {
        this.c = str;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optInt("type");
                if (this.a == 3) {
                    this.b = jSONObject.optString("big_pic");
                    this.d = jSONObject.optString("src_pic");
                } else if (this.a == 5) {
                    this.b = jSONObject.optString("vpic");
                    this.c = jSONObject.optString("vsrc");
                }
            } catch (Exception e) {
                BdLog.e(getClass().getName(), "parserJson", "error=" + e.toString());
            }
        }
    }

    public void a(Media media) {
        if (media != null) {
            this.a = media.type.intValue();
            if (this.a == 3) {
                this.b = media.big_pic;
                this.d = media.src_pic;
            } else if (this.a == 5) {
                this.b = media.vpic;
                this.c = media.vsrc;
            }
        }
    }
}
