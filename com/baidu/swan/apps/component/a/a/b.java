package com.baidu.swan.apps.component.a.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b extends com.baidu.swan.apps.component.a.c.b {
    public int bcC;
    public int bcD;
    public int bcE;
    public int bcF;
    public String bcG;
    public boolean bcH;
    protected int mViewHeight;
    public int maxLength;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.bcG = "";
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.maxLength = jSONObject.optInt("maxLength");
            this.bcC = Z(jSONObject);
            this.bcD = jSONObject.optInt(Constants.EXTRA_CONFIG_CURSOR);
            this.bcE = jSONObject.optInt("selectionStart");
            this.bcF = jSONObject.optInt("selectionEnd");
            this.bcG = jSONObject.optString("confirmType");
            this.bcH = jSONObject.optInt("password") == 1;
            HN();
        }
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void Y(JSONObject jSONObject) {
        super.Y(jSONObject);
        if (!TextUtils.isEmpty(jSONObject.optString("cursorSpacing"))) {
            this.bcC = Z(jSONObject);
        }
        this.maxLength = jSONObject.optInt("maxLength", this.maxLength);
        this.bcD = jSONObject.optInt(Constants.EXTRA_CONFIG_CURSOR, this.bcD);
        this.bcE = jSONObject.optInt("selectionStart", this.bcE);
        this.bcF = jSONObject.optInt("selectionEnd", this.bcF);
        this.bcG = jSONObject.optString("confirmType", this.bcG);
        this.bcH = jSONObject.optInt("password", this.bcH ? 1 : 0) == 1;
        HN();
    }

    private void HN() {
        if (this.bcR != null) {
            this.textColor = SwanAppConfigData.cy(this.bcR.optString("color"));
            this.bcK = true;
        }
    }

    private int Z(@NonNull JSONObject jSONObject) {
        String optString = jSONObject.optString("cursorSpacing");
        if (TextUtils.isEmpty(optString)) {
            return 0;
        }
        if (optString.endsWith("rpx")) {
            try {
                return af.T(Integer.parseInt(optString.replace("rpx", "")));
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

    public void T(int i, int i2) {
        this.bcE = i;
        this.bcF = i2;
    }

    public void dM(int i) {
        this.mViewHeight = i;
    }
}
