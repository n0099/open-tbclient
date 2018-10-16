package com.baidu.browser.sailor.a;

import android.text.TextUtils;
import com.baidu.webkit.sdk.Log;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class n {
    private String Wn;
    private String Wo;
    private JSONObject Wp = new JSONObject();
    private a Wq;
    private HashMap<String, String> Wr;
    private String mParam;

    /* loaded from: classes2.dex */
    public interface a {
        void V(String str, String str2);
    }

    public n(String str, String str2) {
        this.Wn = str;
        this.Wo = str2;
    }

    public void a(a aVar) {
        this.Wq = aVar;
    }

    public void addField(String str, String str2) {
        try {
            this.Wp.put(str, str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void as(boolean z) {
        setResult(z ? 0 : 1);
    }

    public void bo(int i) {
        try {
            this.Wp.put("error_code", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        setResult(i == 0 ? 0 : 1);
        qP();
    }

    public void c(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str)) {
            cz(str2);
        } else {
            addField(str, str2);
        }
        as(z);
        qP();
    }

    public void cA(String str) {
        c("error_info", str, false);
    }

    public void cy(String str) {
        this.mParam = str;
    }

    public void cz(String str) {
        if (this.mParam != null) {
            addField(this.mParam, str);
        }
    }

    public void l(String str, boolean z) {
        as(z);
        if (z) {
            if (str == null) {
                str = "";
            }
            cz(str);
        }
        qP();
    }

    public void notifyCallback(String str, String str2) {
        if (this.Wq != null) {
            this.Wq.V(str, str2);
        }
    }

    public HashMap<String, String> qO() {
        if (this.Wr == null) {
            this.Wr = new HashMap<>();
        }
        return this.Wr;
    }

    public void qP() {
        int i = 0;
        try {
            i = this.Wp.getInt("result");
        } catch (JSONException e) {
            Log.e("BdLightappKernalCallback", "result must be set befor notify!!!");
        }
        notifyCallback(i == 0 ? this.Wn : this.Wo, this.Wp.toString());
    }

    public void qQ() {
        as(true);
        qP();
    }

    public void setResult(int i) {
        try {
            this.Wp.put("result", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
