package com.baidu.searchbox.ng.ai.apps.textarea.info;

import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import com.baidu.searchbox.ng.ai.apps.view.container.AiAppsNAViewType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class TextAreaStatusInfo extends AiAppsNaViewModel {
    private static final String ADJUST_POSITION = "adjustPosition";
    private static final String AUTO_HEIGHT = "autoHeight";
    private static final String CURSOR_SPACING = "cursorSpacing";
    private static final int DEF_LINE_COUNT = 1;
    private static final String FONT_SIZE = "fontSize";
    private static final String FONT_WEIGHT = "fontWeight";
    public static final String ID = "inputId";
    private static final String LINE_SPACE = "lineSpace";
    private static final String MAX_LENGTH = "maxLength";
    private static final String PADDING = "padding";
    private static final String PLACE_HOLDER = "placeholder";
    private static final String PLACE_HOLDER_STYLE = "placeholderStyle";
    private static final String POSITION_FIXED = "fixed";
    private static final String SELECTION_END = "selectionEnd";
    private static final String SELECTION_START = "selectionStart";
    private static final String SHOW_CONFIRM_BAR = "showConfirmBar";
    private static final String STYLE = "style";
    private static final String TEXT_ALIGN = "textAlign";
    private static final String TEXT_COLOR = "color";
    private static final String TEXT_CURSOR = "cursor";
    private static final String TEXT_DISABLE = "disabled";
    private static final String TEXT_FOCUS = "focus";
    private static final String TEXT_VALUE = "value";
    public boolean mAdjustPosition;
    public boolean mAutoHeight;
    public String mColor;
    public int mCursor;
    public int mCursorSpacing;
    public boolean mDisable;
    public boolean mFixed;
    public boolean mFocus;
    public int mFontSize;
    public String mFontWeight;
    public int mHeight;
    public String mHint;
    public int mLeft;
    public int mLineCount;
    public int mLineSpace;
    public int mMaxLength;
    public JSONArray mPaddingArray;
    public String mPlaceHolderFontColor;
    public int mPlaceHolderFontSize;
    public String mPlaceHolderFontWeight;
    public int mSelectionEnd;
    public int mSelectionStart;
    public boolean mShowConfirmBar;
    public String mTextAlign;
    public int mTop;
    public String mValue;
    public int mWidth;

    public static TextAreaStatusInfo createTextAreaStatusInfo(JSONObject jSONObject) {
        TextAreaStatusInfo textAreaStatusInfo = new TextAreaStatusInfo();
        try {
            textAreaStatusInfo.parseFromJson(jSONObject);
        } catch (JSONException e) {
            AiAppsLog.e("TextArea", "parsing TextAreaStatusInfo occurs exception", e);
        }
        return textAreaStatusInfo;
    }

    public TextAreaStatusInfo() {
        super(ID, AiAppsNAViewType.TEXTAREA);
        this.mLineCount = 1;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        this.mValue = jSONObject.optString("value");
        this.mHint = jSONObject.optString(PLACE_HOLDER);
        JSONObject optJSONObject = jSONObject.optJSONObject(PLACE_HOLDER_STYLE);
        this.mPlaceHolderFontSize = optJSONObject.optInt(FONT_SIZE);
        this.mPlaceHolderFontWeight = optJSONObject.optString(FONT_WEIGHT);
        this.mPlaceHolderFontColor = optJSONObject.optString(TEXT_COLOR);
        this.mFocus = jSONObject.optBoolean("focus", false);
        this.mAutoHeight = jSONObject.optBoolean(AUTO_HEIGHT, false);
        this.mFixed = jSONObject.optBoolean(POSITION_FIXED);
        this.mShowConfirmBar = jSONObject.optBoolean(SHOW_CONFIRM_BAR, true);
        this.mMaxLength = jSONObject.optInt(MAX_LENGTH);
        this.mCursorSpacing = jSONObject.optInt(CURSOR_SPACING);
        this.mCursor = jSONObject.optInt("cursor");
        this.mSelectionStart = jSONObject.optInt(SELECTION_START);
        this.mSelectionEnd = jSONObject.optInt(SELECTION_END);
        this.mAdjustPosition = jSONObject.optBoolean(ADJUST_POSITION, true);
        JSONObject optJSONObject2 = jSONObject.optJSONObject("style");
        this.mPaddingArray = optJSONObject2.optJSONArray(PADDING);
        this.mFontSize = optJSONObject2.optInt(FONT_SIZE);
        this.mFontWeight = optJSONObject2.optString(FONT_WEIGHT);
        this.mColor = optJSONObject2.optString(TEXT_COLOR);
        this.mTextAlign = optJSONObject2.optString(TEXT_ALIGN);
        this.mLineSpace = AiAppsUIUtils.dp2px((float) optJSONObject2.optDouble(LINE_SPACE));
        this.mDisable = jSONObject.optBoolean(TEXT_DISABLE, false);
        this.mLeft = this.position.getLeft();
        this.mTop = this.position.getTop();
        this.mWidth = this.position.getWidth();
        this.mHeight = this.position.getHeight();
    }
}
