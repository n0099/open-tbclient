package com.baidu.swan.apps.component.a.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends com.baidu.swan.apps.component.a.c.b {
    public int bdr;
    public int bds;
    public int bdt;
    public int bdu;
    public String bdv;
    public boolean bdw;
    protected int mViewHeight;
    public int maxLength;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.bdv = "";
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.maxLength = jSONObject.optInt("maxLength");
            this.bdr = Z(jSONObject);
            this.bds = jSONObject.optInt(Constants.EXTRA_CONFIG_CURSOR);
            this.bdt = jSONObject.optInt("selectionStart");
            this.bdu = jSONObject.optInt("selectionEnd");
            this.bdv = jSONObject.optString("confirmType");
            this.bdw = jSONObject.optInt("password") == 1;
            Ij();
        }
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b
    public void Y(JSONObject jSONObject) {
        super.Y(jSONObject);
        if (!TextUtils.isEmpty(jSONObject.optString("cursorSpacing"))) {
            this.bdr = Z(jSONObject);
        }
        this.maxLength = jSONObject.optInt("maxLength", this.maxLength);
        this.bds = jSONObject.optInt(Constants.EXTRA_CONFIG_CURSOR, this.bds);
        this.bdt = jSONObject.optInt("selectionStart", this.bdt);
        this.bdu = jSONObject.optInt("selectionEnd", this.bdu);
        this.bdv = jSONObject.optString("confirmType", this.bdv);
        this.bdw = jSONObject.optInt("password", this.bdw ? 1 : 0) == 1;
        Ij();
    }

    private void Ij() {
        if (this.bdG != null) {
            this.textColor = SwanAppConfigData.cy(this.bdG.optString("color"));
            this.bdz = true;
        }
    }

    private int Z(@NonNull JSONObject jSONObject) {
        String optString = jSONObject.optString("cursorSpacing");
        if (TextUtils.isEmpty(optString)) {
            return 0;
        }
        if (optString.endsWith("rpx")) {
            try {
                return af.S(Integer.parseInt(optString.replace("rpx", "")));
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

    public void X(int i, int i2) {
        this.bdt = i;
        this.bdu = i2;
    }

    public void dN(int i) {
        this.mViewHeight = i;
    }
}
