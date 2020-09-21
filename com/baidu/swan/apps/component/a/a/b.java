package com.baidu.swan.apps.component.a.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends com.baidu.swan.apps.component.a.c.b {
    public boolean ccA;
    public int ccx;
    public int ccy;
    public String ccz;
    protected int mViewHeight;
    public int maxLength;
    public int selectionEnd;
    public int selectionStart;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.ccz = "";
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.maxLength = jSONObject.optInt("maxLength");
            this.ccx = aL(jSONObject);
            this.ccy = jSONObject.optInt(Constants.EXTRA_CONFIG_CURSOR);
            this.selectionStart = jSONObject.optInt("selectionStart");
            this.selectionEnd = jSONObject.optInt("selectionEnd");
            this.ccz = jSONObject.optString("confirmType");
            this.ccA = jSONObject.optInt("password") == 1;
            adD();
        }
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void aK(JSONObject jSONObject) {
        super.aK(jSONObject);
        if (!TextUtils.isEmpty(jSONObject.optString("cursorSpacing"))) {
            this.ccx = aL(jSONObject);
        }
        this.maxLength = jSONObject.optInt("maxLength", this.maxLength);
        this.ccy = jSONObject.optInt(Constants.EXTRA_CONFIG_CURSOR, this.ccy);
        this.selectionStart = jSONObject.optInt("selectionStart", this.selectionStart);
        this.selectionEnd = jSONObject.optInt("selectionEnd", this.selectionEnd);
        this.ccz = jSONObject.optString("confirmType", this.ccz);
        this.ccA = jSONObject.optInt("password", this.ccA ? 1 : 0) == 1;
        adD();
    }

    private void adD() {
        if (this.ccK != null) {
            this.textColor = SwanAppConfigData.fq(this.ccK.optString("color"));
            this.ccD = true;
        }
    }

    private int aL(@NonNull JSONObject jSONObject) {
        String optString = jSONObject.optString("cursorSpacing");
        if (TextUtils.isEmpty(optString)) {
            return 0;
        }
        if (optString.endsWith("rpx")) {
            try {
                return ah.H(Integer.parseInt(optString.replace("rpx", "")));
            } catch (NumberFormatException e) {
                return 0;
            }
        }
        try {
            return Integer.parseInt(optString.replace("px", ""));
        } catch (NumberFormatException e2) {
            return 0;
        }
    }

    public void ag(int i, int i2) {
        this.selectionStart = i;
        this.selectionEnd = i2;
    }

    public void gN(int i) {
        this.mViewHeight = i;
    }
}
