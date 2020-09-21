package com.baidu.live.data;

import com.coremedia.iso.boxes.TrackReferenceTypeBox;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bm {
    public int aLw;
    public int aLx;
    public int aLy;
    public int aLz;
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
            this.aLw = jSONObject.optInt("popup_id");
            this.aLx = jSONObject.optInt("popup_times");
            this.aLy = jSONObject.optInt("popup_type");
            this.hint = jSONObject.optString(TrackReferenceTypeBox.TYPE1);
            this.app_version = jSONObject.optString("app_version");
            this.app_size = jSONObject.optInt("app_size");
            this.changelogs = jSONObject.optString("changelogs");
            this.appendix_text = jSONObject.optString("appendix_text");
            this.appendix_link = jSONObject.optString("appendix_link");
            this.aLz = jSONObject.optInt("appendix_optional");
            this.y_btn_text = jSONObject.optString("y_btn_text");
            this.y_btn_link = jSONObject.optString("y_btn_link");
            this.n_btn_text = jSONObject.optString("n_btn_text");
            this.n_btn_link = jSONObject.optString("n_btn_link");
        }
    }
}
