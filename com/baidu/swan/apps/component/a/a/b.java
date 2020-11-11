package com.baidu.swan.apps.component.a.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends com.baidu.swan.apps.component.a.c.b {
    public int cDi;
    public int cDj;
    public String cDk;
    public boolean cDl;
    protected int mViewHeight;
    public int maxLength;
    public int selectionEnd;
    public int selectionStart;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.cDk = "";
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.maxLength = jSONObject.optInt("maxLength");
            this.cDi = bb(jSONObject);
            this.cDj = jSONObject.optInt(Constants.EXTRA_CONFIG_CURSOR);
            this.selectionStart = jSONObject.optInt("selectionStart");
            this.selectionEnd = jSONObject.optInt("selectionEnd");
            this.cDk = jSONObject.optString("confirmType");
            this.cDl = jSONObject.optInt("password") == 1;
            akI();
        }
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void ba(JSONObject jSONObject) {
        super.ba(jSONObject);
        if (!TextUtils.isEmpty(jSONObject.optString("cursorSpacing"))) {
            this.cDi = bb(jSONObject);
        }
        this.maxLength = jSONObject.optInt("maxLength", this.maxLength);
        this.cDj = jSONObject.optInt(Constants.EXTRA_CONFIG_CURSOR, this.cDj);
        this.selectionStart = jSONObject.optInt("selectionStart", this.selectionStart);
        this.selectionEnd = jSONObject.optInt("selectionEnd", this.selectionEnd);
        this.cDk = jSONObject.optString("confirmType", this.cDk);
        this.cDl = jSONObject.optInt("password", this.cDl ? 1 : 0) == 1;
        akI();
    }

    private void akI() {
        if (this.cDv != null) {
            this.textColor = SwanAppConfigData.fv(this.cDv.optString("color"));
            this.cDo = true;
        }
    }

    private int bb(@NonNull JSONObject jSONObject) {
        String optString = jSONObject.optString("cursorSpacing");
        if (TextUtils.isEmpty(optString)) {
            return 0;
        }
        if (optString.endsWith("rpx")) {
            try {
                return ah.N(Integer.parseInt(optString.replace("rpx", "")));
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

    public void hF(int i) {
        this.mViewHeight = i;
    }
}
