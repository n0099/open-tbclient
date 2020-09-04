package com.baidu.live.data;

import com.coremedia.iso.boxes.TrackReferenceTypeBox;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class bg {
    public int aJV;
    public int aJW;
    public int aJX;
    public int aJY;
    public int app_size;
    public String app_version;
    public String appendix_link;
    public String appendix_text;
    public String changelogs;
    public String hint;
    public String n_btn_link;
    public String n_btn_text;
    public String y_btn_link;
    public String y_btn_text;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aJV = jSONObject.optInt("popup_id");
            this.aJW = jSONObject.optInt("popup_times");
            this.aJX = jSONObject.optInt("popup_type");
            this.hint = jSONObject.optString(TrackReferenceTypeBox.TYPE1);
            this.app_version = jSONObject.optString("app_version");
            this.app_size = jSONObject.optInt("app_size");
            this.changelogs = jSONObject.optString("changelogs");
            this.appendix_text = jSONObject.optString("appendix_text");
            this.appendix_link = jSONObject.optString("appendix_link");
            this.aJY = jSONObject.optInt("appendix_optional");
            this.y_btn_text = jSONObject.optString("y_btn_text");
            this.y_btn_link = jSONObject.optString("y_btn_link");
            this.n_btn_text = jSONObject.optString("n_btn_text");
            this.n_btn_link = jSONObject.optString("n_btn_link");
        }
    }
}
