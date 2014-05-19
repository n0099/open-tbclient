package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private boolean a;
    private int b;
    private int c;
    private int d;

    public boolean a() {
        return this.a;
    }

    public void a(boolean z) {
        this.a = z;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public void a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                a(new JSONObject(str));
            }
        } catch (Exception e) {
            this.a = false;
            BdLog.e(getClass().getName(), "parserJson", e.getMessage());
        }
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.a = true;
                } else {
                    this.a = false;
                }
                this.d = jSONObject.optJSONObject("err").optInt("num");
                JSONObject optJSONObject = jSONObject.optJSONObject("slow");
                this.c = optJSONObject.optInt("time");
                this.b = optJSONObject.optInt("num");
                if (this.c <= 0 || this.b <= 0 || this.d <= 0) {
                    this.a = false;
                }
            } catch (Exception e) {
                this.a = false;
                BdLog.e(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
