package com.baidu.browser.sailor.a;

import android.text.TextUtils;
import com.baidu.webkit.sdk.Log;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class n {
    private String Wp;
    private String Wq;
    private JSONObject Wr = new JSONObject();
    private a Ws;
    private HashMap<String, String> Wt;
    private String mParam;

    /* loaded from: classes2.dex */
    public interface a {
        void V(String str, String str2);
    }

    public n(String str, String str2) {
        this.Wp = str;
        this.Wq = str2;
    }

    public void a(a aVar) {
        this.Ws = aVar;
    }

    public void aG(boolean z) {
        setResult(z ? 0 : 1);
    }

    public void addField(String str, String str2) {
        try {
            this.Wr.put(str, str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void bD(int i) {
        try {
            this.Wr.put("error_code", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        setResult(i == 0 ? 0 : 1);
        qN();
    }

    public void c(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str)) {
            cz(str2);
        } else {
            addField(str, str2);
        }
        aG(z);
        qN();
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
        aG(z);
        if (z) {
            if (str == null) {
                str = "";
            }
            cz(str);
        }
        qN();
    }

    public void notifyCallback(String str, String str2) {
        if (this.Ws != null) {
            this.Ws.V(str, str2);
        }
    }

    public HashMap<String, String> qM() {
        if (this.Wt == null) {
            this.Wt = new HashMap<>();
        }
        return this.Wt;
    }

    public void qN() {
        int i = 0;
        try {
            i = this.Wr.getInt("result");
        } catch (JSONException e) {
            Log.e("BdLightappKernalCallback", "result must be set befor notify!!!");
        }
        notifyCallback(i == 0 ? this.Wp : this.Wq, this.Wr.toString());
    }

    public void qO() {
        aG(true);
        qN();
    }

    public void setResult(int i) {
        try {
            this.Wr.put("result", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
