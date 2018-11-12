package com.baidu.searchbox.ng.ai.apps.impl.map.model.element;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.impl.map.utils.MapUtils;
import com.baidu.searchbox.ng.ai.apps.model.IModel;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class MarkerModel implements IModel {
    private static final String ALPHA = "alpha";
    private static final String ANCHOR = "anchor";
    private static final String CALLOUT = "callout";
    private static final boolean DEBUG = false;
    private static final String HEIGHT = "height";
    private static final String ICON_PATH = "iconPath";
    public static final String ID = "markerId";
    private static final String LABEL = "label";
    private static final String ROTATE = "rotate";
    private static final String TAG = MarkerModel.class.getSimpleName();
    private static final String TITLE = "title";
    private static final String WIDTH = "width";
    public Anchor anchor;
    public Callout callout;
    public CoordinateModel coordinate;
    public Label label;
    public String id = "";
    public String title = "";
    public String iconPath = "";
    public double rotate = 0.0d;
    public double alpha = 1.0d;
    public int width = -1;
    public int height = -1;

    @Override // com.baidu.searchbox.ng.ai.apps.model.IModel
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.coordinate = new CoordinateModel();
            this.coordinate.parseFromJson(jSONObject);
            if (this.coordinate.isValid()) {
                this.id = jSONObject.optString(ID);
                this.title = jSONObject.optString("title");
                this.iconPath = jSONObject.optString(ICON_PATH);
                this.rotate = jSONObject.optDouble("rotate", 0.0d);
                this.alpha = Math.abs(jSONObject.optDouble(ALPHA, 1.0d));
                this.width = jSONObject.has("width") ? Math.abs(AiAppsUIUtils.dp2px(jSONObject.optInt("width"))) : -1;
                this.height = jSONObject.has("height") ? Math.abs(AiAppsUIUtils.dp2px(jSONObject.optInt("height"))) : -1;
                this.callout = new Callout();
                this.callout.parseFromJson(jSONObject.optJSONObject(CALLOUT));
                this.label = new Label();
                this.label.parseFromJson(jSONObject.optJSONObject(LABEL));
                this.anchor = new Anchor();
                this.anchor.parseFromJson(jSONObject.optJSONObject(ANCHOR));
            }
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.model.IModel
    public boolean isValid() {
        return this.coordinate != null && this.coordinate.isValid();
    }

    /* loaded from: classes4.dex */
    public static class Callout extends SubBase {
        public static final String ALWAYS = "ALWAYS";
        private static final String BORDER_RADIUS = "borderRadius";
        public static final String BYCLICK = "BYCLICK";
        private static final boolean DEBUG = false;
        private static final String DISPLAY = "display";
        private static final String TAG = Callout.class.getSimpleName();
        public int bgColor;
        public float borderRadius;
        public String display;

        public Callout() {
            super();
            this.borderRadius = 0.0f;
            this.display = BYCLICK;
            this.bgColor = -1;
        }

        @Override // com.baidu.searchbox.ng.ai.apps.impl.map.model.element.MarkerModel.SubBase, com.baidu.searchbox.ng.ai.apps.model.IModel
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                super.parseFromJson(jSONObject);
                this.borderRadius = Math.abs(MapUtils.dp2px(jSONObject.optDouble(BORDER_RADIUS, 0.0d)));
                this.display = jSONObject.has(DISPLAY) ? jSONObject.optString(DISPLAY) : BYCLICK;
                this.bgColor = MapUtils.convertColorSafe(jSONObject.optString(SubBase.BG_COLOR), -1);
            }
        }

        @Override // com.baidu.searchbox.ng.ai.apps.impl.map.model.element.MarkerModel.SubBase, com.baidu.searchbox.ng.ai.apps.model.IModel
        public boolean isValid() {
            return super.isValid();
        }
    }

    /* loaded from: classes4.dex */
    public static class Label extends SubBase implements IModel {
        private static final String BORDER_COLOR = "borderColor";
        private static final String BORDER_RADIUS = "borderRadius";
        private static final String BORDER_WIDTH = "borderWidth";
        private static final boolean DEBUG = false;
        private static final String TAG = Label.class.getSimpleName();
        private static final String X = "x";
        private static final String Y = "y";
        public int borderColor;
        public float borderRadius;
        public float borderWidth;
        public float x;
        public float y;

        public Label() {
            super();
            this.x = 0.0f;
            this.y = 0.0f;
            this.borderWidth = 0.0f;
            this.borderColor = 0;
            this.borderRadius = 0.0f;
        }

        @Override // com.baidu.searchbox.ng.ai.apps.impl.map.model.element.MarkerModel.SubBase, com.baidu.searchbox.ng.ai.apps.model.IModel
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                super.parseFromJson(jSONObject);
                this.x = MapUtils.dp2px(jSONObject.optDouble("x", 0.0d));
                this.y = MapUtils.dp2px(jSONObject.optDouble("y", 0.0d));
                this.borderWidth = Math.abs(MapUtils.dp2px(jSONObject.optDouble(BORDER_WIDTH, 0.0d)));
                this.borderColor = MapUtils.convertColorSafe(jSONObject.optString(BORDER_COLOR), 0);
                this.borderRadius = Math.abs(MapUtils.dp2px(jSONObject.optDouble(BORDER_RADIUS, 0.0d)));
            }
        }

        @Override // com.baidu.searchbox.ng.ai.apps.impl.map.model.element.MarkerModel.SubBase, com.baidu.searchbox.ng.ai.apps.model.IModel
        public boolean isValid() {
            return super.isValid();
        }
    }

    /* loaded from: classes4.dex */
    public static class Anchor implements IModel {
        private static final boolean DEBUG = false;
        private static final String TAG = Anchor.class.getSimpleName();
        private static final String X = "x";
        private static final String Y = "y";
        public double x = 0.5d;
        public double y = 1.0d;

        @Override // com.baidu.searchbox.ng.ai.apps.model.IModel
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            double d;
            double d2 = 0.0d;
            if (jSONObject != null) {
                this.x = Math.abs(jSONObject.optDouble("x", 0.5d));
                this.y = Math.abs(jSONObject.optDouble("y", 1.0d));
                if (this.x < 0.0d) {
                    d = 0.0d;
                } else {
                    d = this.x > 1.0d ? 1.0d : this.x;
                }
                this.x = d;
                if (this.y >= 0.0d) {
                    d2 = this.y > 1.0d ? 1.0d : this.y;
                }
                this.y = d2;
            }
        }

        @Override // com.baidu.searchbox.ng.ai.apps.model.IModel
        public boolean isValid() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class SubBase implements IModel {
        public static final String BG_COLOR = "bgColor";
        public static final String CENTER = "center";
        private static final String COLOR = "color";
        private static final String CONTENT = "content";
        private static final String FONT_SIZE = "fontSize";
        public static final String LEFT = "left";
        private static final String PADDING = "padding";
        public static final String RIGHT = "right";
        private static final String TEXT_ALIGN = "textAlign";
        public int bgColor;
        public int color;
        public String content;
        public float fontSize;
        public float padding;
        public String textAlign;

        private SubBase() {
            this.content = "";
            this.color = -16777216;
            this.fontSize = MapUtils.dp2px(10.0d);
            this.bgColor = 0;
            this.padding = 0.0f;
            this.textAlign = CENTER;
        }

        @Override // com.baidu.searchbox.ng.ai.apps.model.IModel
        public void parseFromJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null && jSONObject.has("content")) {
                this.content = jSONObject.optString("content");
                this.color = MapUtils.convertColorSafe(jSONObject.optString(COLOR), -16777216);
                this.fontSize = jSONObject.has(FONT_SIZE) ? Math.abs(MapUtils.dp2px(jSONObject.optDouble(FONT_SIZE, 0.0d))) : MapUtils.dp2px(10.0d);
                this.bgColor = MapUtils.convertColorSafe(jSONObject.optString(BG_COLOR), 0);
                this.padding = MapUtils.dp2px(jSONObject.optDouble(PADDING, 0.0d));
                this.textAlign = jSONObject.has(TEXT_ALIGN) ? jSONObject.optString(TEXT_ALIGN) : CENTER;
            }
        }

        @Override // com.baidu.searchbox.ng.ai.apps.model.IModel
        public boolean isValid() {
            return !TextUtils.isEmpty(this.content);
        }
    }
}
