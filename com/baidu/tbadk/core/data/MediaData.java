package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.Media;
/* loaded from: classes.dex */
public class MediaData implements Serializable {
    private int type = -1;
    private String pic_url = null;
    private String video_url = null;
    private String src_pic = null;

    public String getSrc_pic() {
        return this.src_pic;
    }

    public void setSrc_pic(String str) {
        this.src_pic = str;
    }

    public int getType() {
        return this.type;
    }

    public String getPicUrl() {
        return this.pic_url;
    }

    public String getSmallUrl() {
        return this.pic_url;
    }

    public String getVideoUrl() {
        return this.video_url;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setPic(String str) {
        this.pic_url = str;
    }

    public void setVideo(String str) {
        this.video_url = str;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.type = jSONObject.optInt("type");
                if (this.type == 3) {
                    this.pic_url = jSONObject.optString("big_pic");
                    this.src_pic = jSONObject.optString("src_pic");
                } else if (this.type == 5) {
                    this.pic_url = jSONObject.optString("vpic");
                    this.video_url = jSONObject.optString("vsrc");
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void parserProtobuf(Media media) {
        if (media != null) {
            this.type = media.type.intValue();
            if (this.type == 3) {
                this.pic_url = media.big_pic;
                this.src_pic = media.src_pic;
            } else if (this.type == 5) {
                this.pic_url = media.vpic;
                this.video_url = media.vsrc;
            }
        }
    }
}
