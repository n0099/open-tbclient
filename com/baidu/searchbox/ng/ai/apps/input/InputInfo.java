package com.baidu.searchbox.ng.ai.apps.input;

import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsRectPosition;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class InputInfo extends AiAppsNaViewModel {
    private static final String ADJUST_POSITION = "adjustPosition";
    private static final String CONFIRM_HOLD = "confirmHold";
    private static final String CONFIRM_TYPE = "confirmType";
    private static final String CURSOR_SPACING = "cursorSpacing";
    private static final String FONT_SIZE = "fontSize";
    private static final String FONT_WEIGHT = "fontWeight";
    private static final int INT_TRUE = 1;
    private static final String MAX_LENGTH = "maxLength";
    private static final String PASSWORD = "password";
    private static final String SELECTION_END = "selectionEnd";
    private static final String SELECTION_START = "selectionStart";
    private static final String STYLE = "style";
    private static final String TEXT_ALIGN = "textAlign";
    private static final String TEXT_COLOR = "color";
    private static final String TEXT_CURSOR = "cursor";
    private static final String TEXT_TYPE = "type";
    private static final String TEXT_VALUE = "value";
    private static final String VIEW_ID = "viewId";
    public String color;
    public String confirmType;
    public int cursor;
    public int cursorSpacing;
    public int fontSize;
    public String fontWeight;
    public boolean isPassword;
    public int maxLength;
    public boolean needAdjustPosition;
    public boolean needConfirmHold;
    public int selectionEnd;
    public int selectionStart;
    public String textAlign;
    public String type;
    public String value;

    public InputInfo() {
        super(VIEW_ID, "input");
    }

    @Override // com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        if (this.position == null) {
            this.position = new AiAppsRectPosition();
        }
        this.value = jSONObject.optString("value");
        this.type = jSONObject.optString("type");
        this.maxLength = jSONObject.optInt(MAX_LENGTH);
        this.cursorSpacing = jSONObject.optInt(CURSOR_SPACING);
        this.cursor = jSONObject.optInt("cursor");
        this.selectionStart = jSONObject.optInt(SELECTION_START);
        this.selectionEnd = jSONObject.optInt(SELECTION_END);
        this.confirmType = jSONObject.optString(CONFIRM_TYPE);
        JSONObject optJSONObject = jSONObject.optJSONObject("style");
        this.fontSize = optJSONObject.optInt(FONT_SIZE);
        this.fontWeight = optJSONObject.optString(FONT_WEIGHT);
        this.color = optJSONObject.optString(TEXT_COLOR);
        this.textAlign = optJSONObject.optString(TEXT_ALIGN);
        this.isPassword = jSONObject.optInt(PASSWORD) == 1;
        this.needConfirmHold = jSONObject.optInt(CONFIRM_HOLD) == 1;
        this.needAdjustPosition = jSONObject.optInt(ADJUST_POSITION, 1) == 1;
    }

    public void fastParseFromJson(JSONObject jSONObject) {
        try {
            super.parseFromJson(jSONObject);
        } catch (JSONException e) {
            AiAppsLog.e("Input", "parsing InputInfo occurs exception", e);
        }
    }
}
