package com.baidu.swan.apps.component.a.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends com.baidu.swan.apps.component.a.c.b {
    public int bUJ;
    public int bUK;
    public String bUL;
    public boolean bUM;
    protected int mViewHeight;
    public int maxLength;
    public int selectionEnd;
    public int selectionStart;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.bUL = "";
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.maxLength = jSONObject.optInt("maxLength");
            this.bUJ = aC(jSONObject);
            this.bUK = jSONObject.optInt(Constants.EXTRA_CONFIG_CURSOR);
            this.selectionStart = jSONObject.optInt("selectionStart");
            this.selectionEnd = jSONObject.optInt("selectionEnd");
            this.bUL = jSONObject.optString("confirmType");
            this.bUM = jSONObject.optInt("password") == 1;
            WO();
        }
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void aB(JSONObject jSONObject) {
        super.aB(jSONObject);
        if (!TextUtils.isEmpty(jSONObject.optString("cursorSpacing"))) {
            this.bUJ = aC(jSONObject);
        }
        this.maxLength = jSONObject.optInt("maxLength", this.maxLength);
        this.bUK = jSONObject.optInt(Constants.EXTRA_CONFIG_CURSOR, this.bUK);
        this.selectionStart = jSONObject.optInt("selectionStart", this.selectionStart);
        this.selectionEnd = jSONObject.optInt("selectionEnd", this.selectionEnd);
        this.bUL = jSONObject.optString("confirmType", this.bUL);
        this.bUM = jSONObject.optInt("password", this.bUM ? 1 : 0) == 1;
        WO();
    }

    private void WO() {
        if (this.bUW != null) {
            this.textColor = SwanAppConfigData.dU(this.bUW.optString("color"));
            this.bUP = true;
        }
    }

    private int aC(@NonNull JSONObject jSONObject) {
        String optString = jSONObject.optString("cursorSpacing");
        if (TextUtils.isEmpty(optString)) {
            return 0;
        }
        if (optString.endsWith("rpx")) {
            try {
                return ai.D(Integer.parseInt(optString.replace("rpx", "")));
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

    public void ae(int i, int i2) {
        this.selectionStart = i;
        this.selectionEnd = i2;
    }

    public void eG(int i) {
        this.mViewHeight = i;
    }
}
