package com.baidu.swan.apps.component.a.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b extends com.baidu.swan.apps.component.a.c.b {
    public int cNl;
    public int cNm;
    public String cNn;
    public boolean cNo;
    protected int mViewHeight;
    public int maxLength;
    public int selectionEnd;
    public int selectionStart;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.cNn = "";
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.maxLength = jSONObject.optInt("maxLength");
            this.cNl = bf(jSONObject);
            this.cNm = jSONObject.optInt(Constants.EXTRA_CONFIG_CURSOR);
            this.selectionStart = jSONObject.optInt("selectionStart");
            this.selectionEnd = jSONObject.optInt("selectionEnd");
            this.cNn = jSONObject.optString("confirmType");
            this.cNo = jSONObject.optInt("password") == 1;
            aor();
        }
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void be(JSONObject jSONObject) {
        super.be(jSONObject);
        if (!TextUtils.isEmpty(jSONObject.optString("cursorSpacing"))) {
            this.cNl = bf(jSONObject);
        }
        this.maxLength = jSONObject.optInt("maxLength", this.maxLength);
        this.cNm = jSONObject.optInt(Constants.EXTRA_CONFIG_CURSOR, this.cNm);
        this.selectionStart = jSONObject.optInt("selectionStart", this.selectionStart);
        this.selectionEnd = jSONObject.optInt("selectionEnd", this.selectionEnd);
        this.cNn = jSONObject.optString("confirmType", this.cNn);
        this.cNo = jSONObject.optInt("password", this.cNo ? 1 : 0) == 1;
        aor();
    }

    private void aor() {
        if (this.cNz != null) {
            this.textColor = SwanAppConfigData.sF(this.cNz.optString("color"));
            this.cNr = true;
        }
    }

    private int bf(@NonNull JSONObject jSONObject) {
        String optString = jSONObject.optString("cursorSpacing");
        if (TextUtils.isEmpty(optString)) {
            return 0;
        }
        if (optString.endsWith("rpx")) {
            try {
                return ah.O(Integer.parseInt(optString.replace("rpx", "")));
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

    public void ad(int i, int i2) {
        this.selectionStart = i;
        this.selectionEnd = i2;
    }

    public void hT(int i) {
        this.mViewHeight = i;
    }
}
