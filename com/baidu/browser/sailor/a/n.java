package com.baidu.browser.sailor.a;

import android.text.TextUtils;
import com.baidu.webkit.sdk.Log;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class n {
    private JSONObject WA = new JSONObject();
    private a WB;
    private HashMap<String, String> WC;
    private String Wy;
    private String Wz;
    private String mParam;

    /* loaded from: classes2.dex */
    public interface a {
        void W(String str, String str2);
    }

    public n(String str, String str2) {
        this.Wy = str;
        this.Wz = str2;
    }

    public void a(a aVar) {
        this.WB = aVar;
    }

    public void aG(boolean z) {
        setResult(z ? 0 : 1);
    }

    public void addField(String str, String str2) {
        try {
            this.WA.put(str, str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void bD(int i) {
        try {
            this.WA.put("error_code", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        setResult(i == 0 ? 0 : 1);
        qQ();
    }

    public void c(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str)) {
            cA(str2);
        } else {
            addField(str, str2);
        }
        aG(z);
        qQ();
    }

    public void cA(String str) {
        if (this.mParam != null) {
            addField(this.mParam, str);
        }
    }

    public void cB(String str) {
        c("error_info", str, false);
    }

    public void cz(String str) {
        this.mParam = str;
    }

    public void l(String str, boolean z) {
        aG(z);
        if (z) {
            if (str == null) {
                str = "";
            }
            cA(str);
        }
        qQ();
    }

    public void notifyCallback(String str, String str2) {
        if (this.WB != null) {
            this.WB.W(str, str2);
        }
    }

    public HashMap<String, String> qP() {
        if (this.WC == null) {
            this.WC = new HashMap<>();
        }
        return this.WC;
    }

    public void qQ() {
        int i = 0;
        try {
            i = this.WA.getInt("result");
        } catch (JSONException e) {
            Log.e("BdLightappKernalCallback", "result must be set befor notify!!!");
        }
        notifyCallback(i == 0 ? this.Wy : this.Wz, this.WA.toString());
    }

    public void qR() {
        aG(true);
        qQ();
    }

    public void setResult(int i) {
        try {
            this.WA.put("result", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
