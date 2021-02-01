package com.baidu.live.data;

import android.graphics.Color;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.data.BaseData;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaLiveGiftUIInfo extends BaseData implements Serializable {
    private String categoryTextSelectedColor;
    private String horizontalBgUrl;
    private String panelBgColor;
    private String tabBgSelectedColor;
    private String tabBgUnSelectedColor;
    private String tabTextSelectedColor;
    private String tabTextUnSelectedColor;
    private String verticalBgUrl;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.panelBgColor = jSONObject.optString("bg_color");
            this.verticalBgUrl = jSONObject.optString("vertical_bg_url");
            this.horizontalBgUrl = jSONObject.optString("cross_bg_url");
            this.tabBgSelectedColor = jSONObject.optString("ks_bg_chosen_color");
            this.tabBgUnSelectedColor = jSONObject.optString("ks_bg_color");
            this.tabTextSelectedColor = jSONObject.optString("ks_text_chosen_color");
            this.tabTextUnSelectedColor = jSONObject.optString("ks_text_color");
            this.categoryTextSelectedColor = jSONObject.optString("tab_chosen_color");
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bg_color", this.panelBgColor);
            jSONObject.put("vertical_bg_url", this.verticalBgUrl);
            jSONObject.put("cross_bg_url", this.horizontalBgUrl);
            jSONObject.put("ks_bg_chosen_color", this.tabBgSelectedColor);
            jSONObject.put("ks_bg_color", this.tabBgUnSelectedColor);
            jSONObject.put("ks_text_chosen_color", this.tabTextSelectedColor);
            jSONObject.put("ks_text_color", this.tabTextUnSelectedColor);
            jSONObject.put("tab_chosen_color", this.categoryTextSelectedColor);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public int getBgColor() {
        if (TextUtils.isEmpty(this.panelBgColor)) {
            return 0;
        }
        if (this.panelBgColor.charAt(0) != '#') {
            this.panelBgColor = '#' + this.panelBgColor;
        }
        try {
            return Color.parseColor(this.panelBgColor);
        } catch (Exception e) {
            return 0;
        }
    }

    public String getVerticalBgUrl() {
        return this.verticalBgUrl;
    }

    public String getHorizontalBgUrl() {
        return this.horizontalBgUrl;
    }

    public int getTabBgSelectedColor() {
        if (TextUtils.isEmpty(this.tabBgSelectedColor)) {
            return 0;
        }
        if (this.tabBgSelectedColor.charAt(0) != '#') {
            this.tabBgSelectedColor = '#' + this.tabBgSelectedColor;
        }
        try {
            return Color.parseColor(this.tabBgSelectedColor);
        } catch (Exception e) {
            return 0;
        }
    }

    public int getTabBgUnSelectedColor() {
        if (TextUtils.isEmpty(this.tabBgUnSelectedColor)) {
            return 0;
        }
        if (this.tabBgUnSelectedColor.charAt(0) != '#') {
            this.tabBgUnSelectedColor = '#' + this.tabBgUnSelectedColor;
        }
        try {
            return Color.parseColor(this.tabBgUnSelectedColor);
        } catch (Exception e) {
            return 0;
        }
    }

    public int getTabTextSelectedColor() {
        if (TextUtils.isEmpty(this.tabTextSelectedColor)) {
            return 0;
        }
        if (this.tabTextSelectedColor.charAt(0) != '#') {
            this.tabTextSelectedColor = '#' + this.tabTextSelectedColor;
        }
        try {
            return Color.parseColor(this.tabTextSelectedColor);
        } catch (Exception e) {
            return 0;
        }
    }

    public int getTabTextUnSelectedColor() {
        if (TextUtils.isEmpty(this.tabTextUnSelectedColor)) {
            return 0;
        }
        if (this.tabTextUnSelectedColor.charAt(0) != '#') {
            this.tabTextUnSelectedColor = '#' + this.tabTextUnSelectedColor;
        }
        try {
            return Color.parseColor(this.tabTextUnSelectedColor);
        } catch (Exception e) {
            return 0;
        }
    }

    public int getCategoryTextSelectedColor() {
        if (TextUtils.isEmpty(this.categoryTextSelectedColor)) {
            return 0;
        }
        if (this.categoryTextSelectedColor.charAt(0) != '#') {
            this.categoryTextSelectedColor = '#' + this.categoryTextSelectedColor;
        }
        try {
            return Color.parseColor(this.categoryTextSelectedColor);
        } catch (Exception e) {
            return 0;
        }
    }
}
