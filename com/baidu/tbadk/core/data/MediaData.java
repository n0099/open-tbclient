package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.Media;
/* loaded from: classes.dex */
public class MediaData extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
    public static final int EXT_TYPE_XIAOYING = 12;
    private int e_type = -1;
    private int type = -1;
    private String pic_url = null;
    private String video_url = null;
    private String src_pic = null;
    private String original_url = null;
    private long original_size = 0;

    public boolean isXiaoying() {
        return this.type == 5 && this.e_type == 12;
    }

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

    public String getOriginalUrl() {
        return this.original_url;
    }

    public void setOriginalUrl(String str) {
        this.original_url = str;
    }

    public long getOriginalSize() {
        return this.original_size;
    }

    public void setOriginalSize(long j) {
        this.original_size = j;
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
                this.original_url = jSONObject.optString("original_url");
                this.original_size = jSONObject.optLong("original_size");
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
                this.e_type = media.e_type.intValue();
            }
            this.original_url = media.origin_pic;
            this.original_size = media.origin_size.intValue();
        }
    }
}
