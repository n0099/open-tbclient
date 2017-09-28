package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.Media;
/* loaded from: classes.dex */
public class MediaData extends OrmObject implements Serializable {
    public static final int EXT_TYPE_XIAOYING = 12;
    private long postId;
    private int e_type = -1;
    private int type = -1;
    private String pic_url = null;
    private String video_url = null;
    private String src_pic = null;
    private String original_url = null;
    private long original_size = 0;
    private String thumbnails_url = null;
    private int during_time = 0;
    private boolean isLongPic = false;
    private boolean showOriginBtn = false;

    public MediaData() {
        this.postId = -1L;
        this.postId = -1L;
    }

    public boolean isXiaoying() {
        return this.type == 5 && this.e_type == 12;
    }

    public String getSrc_pic() {
        return this.src_pic;
    }

    public void setSrc_pic(String str) {
        this.src_pic = str;
    }

    public String getThumbnails_url() {
        return this.thumbnails_url;
    }

    public void setThumbnails_url(String str) {
        this.thumbnails_url = str;
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

    public long getPostId() {
        return this.postId;
    }

    public int getDuration() {
        return this.during_time;
    }

    public void setDuration(int i) {
        this.during_time = i;
    }

    public boolean isLongPic() {
        return this.isLongPic;
    }

    public void setIsLongPic(boolean z) {
        this.isLongPic = z;
    }

    public boolean isShowOriginBtn() {
        return this.showOriginBtn;
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
                this.postId = jSONObject.optLong("post_id");
                this.during_time = jSONObject.optInt("during_time");
                this.isLongPic = jSONObject.optInt("is_long_pic", 0) == 1;
                this.showOriginBtn = jSONObject.optInt("show_original_btn", 1) == 1;
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
            this.during_time = media.during_time.intValue();
            this.thumbnails_url = media.dynamic_pic;
            this.original_url = media.origin_pic;
            this.original_size = media.origin_size.intValue();
            this.postId = media.post_id.longValue();
            this.isLongPic = media.is_long_pic.intValue() == 1;
            this.showOriginBtn = media.show_original_btn.intValue() == 1;
        }
    }
}
