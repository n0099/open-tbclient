package com.baidu.swan.apps.component.a.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.apps.component.a.c.b {
    public int bPd;
    public int bPe;
    public String bPf;
    public boolean bPg;
    protected int mViewHeight;
    public int maxLength;
    public int selectionEnd;
    public int selectionStart;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.bPf = "";
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.maxLength = jSONObject.optInt("maxLength");
            this.bPd = as(jSONObject);
            this.bPe = jSONObject.optInt(Constants.EXTRA_CONFIG_CURSOR);
            this.selectionStart = jSONObject.optInt("selectionStart");
            this.selectionEnd = jSONObject.optInt("selectionEnd");
            this.bPf = jSONObject.optString("confirmType");
            this.bPg = jSONObject.optInt("password") == 1;
            Vb();
        }
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void ar(JSONObject jSONObject) {
        super.ar(jSONObject);
        if (!TextUtils.isEmpty(jSONObject.optString("cursorSpacing"))) {
            this.bPd = as(jSONObject);
        }
        this.maxLength = jSONObject.optInt("maxLength", this.maxLength);
        this.bPe = jSONObject.optInt(Constants.EXTRA_CONFIG_CURSOR, this.bPe);
        this.selectionStart = jSONObject.optInt("selectionStart", this.selectionStart);
        this.selectionEnd = jSONObject.optInt("selectionEnd", this.selectionEnd);
        this.bPf = jSONObject.optString("confirmType", this.bPf);
        this.bPg = jSONObject.optInt("password", this.bPg ? 1 : 0) == 1;
        Vb();
    }

    private void Vb() {
        if (this.bPq != null) {
            this.textColor = SwanAppConfigData.dT(this.bPq.optString("color"));
            this.bPj = true;
        }
    }

    private int as(@NonNull JSONObject jSONObject) {
        String optString = jSONObject.optString("cursorSpacing");
        if (TextUtils.isEmpty(optString)) {
            return 0;
        }
        if (optString.endsWith("rpx")) {
            try {
                return ag.B(Integer.parseInt(optString.replace("rpx", "")));
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

    public void ac(int i, int i2) {
        this.selectionStart = i;
        this.selectionEnd = i2;
    }

    public void et(int i) {
        this.mViewHeight = i;
    }
}
