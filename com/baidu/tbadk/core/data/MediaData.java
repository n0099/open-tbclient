package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.Media;
/* loaded from: classes3.dex */
public class MediaData extends OrmObject implements Serializable {
    public static final int EXT_TYPE_XIAOYING = 12;
    public String origin_pic;
    public long postId;
    public String small_pic_url;
    public int e_type = -1;
    public int picWidth = 0;
    public int picHeight = 0;
    public int type = -1;
    public String pic_url = null;
    public String video_url = null;
    public String src_pic = null;
    public String original_url = null;
    public long original_size = 0;
    public String thumbnails_url = null;
    public int during_time = 0;
    public boolean isLongPic = false;
    public boolean showOriginBtn = false;
    public double smartCropCenterPointWidthRatio = 0.0d;
    public double smartCropCenterPointHeightRatio = 0.0d;

    public MediaData() {
        this.postId = -1L;
        this.postId = -1L;
    }

    public int getDuration() {
        return this.during_time;
    }

    public long getOriginalSize() {
        return this.original_size;
    }

    public String getOriginalUrl() {
        return this.original_url;
    }

    public String getPicUrl() {
        return this.pic_url;
    }

    public long getPostId() {
        return this.postId;
    }

    public String getSmallPicUrl() {
        return this.small_pic_url;
    }

    public String getSmallUrl() {
        return this.pic_url;
    }

    public double getSmartCropCenterPointHeightRatio() {
        return this.smartCropCenterPointHeightRatio;
    }

    public double getSmartCropCenterPointWidthRatio() {
        return this.smartCropCenterPointWidthRatio;
    }

    public String getSrc_pic() {
        return this.src_pic;
    }

    public String getThumbnails_url() {
        return this.thumbnails_url;
    }

    public int getType() {
        return this.type;
    }

    public String getVideoUrl() {
        return this.video_url;
    }

    public boolean isLongPic() {
        return this.isLongPic;
    }

    public boolean isShowOriginBtn() {
        return this.showOriginBtn;
    }

    public boolean isSmartCrop() {
        return this.smartCropCenterPointWidthRatio > 0.0d && this.smartCropCenterPointHeightRatio > 0.0d;
    }

    public boolean isXiaoying() {
        return this.type == 5 && this.e_type == 12;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            int optInt = jSONObject.optInt("type");
            this.type = optInt;
            if (optInt == 3) {
                this.pic_url = jSONObject.optString("big_pic");
                this.src_pic = jSONObject.optString("src_pic");
            } else if (optInt == 5) {
                this.pic_url = jSONObject.optString("vpic");
                this.video_url = jSONObject.optString("vsrc");
            }
            this.original_url = jSONObject.optString("original_url");
            this.original_size = jSONObject.optLong("original_size");
            this.postId = jSONObject.optLong("post_id");
            this.during_time = jSONObject.optInt("during_time");
            boolean z = true;
            this.isLongPic = jSONObject.optInt("is_long_pic", 0) == 1;
            if (jSONObject.optInt("show_original_btn", 1) != 1) {
                z = false;
            }
            this.showOriginBtn = z;
            this.small_pic_url = jSONObject.optString("small_pic");
            this.origin_pic = jSONObject.optString("origin_pic");
            this.smartCropCenterPointWidthRatio = jSONObject.optDouble("wth_mid_loc");
            this.smartCropCenterPointHeightRatio = jSONObject.optDouble("hth_mid_loc");
            this.picWidth = jSONObject.optInt("width", 0);
            this.picHeight = jSONObject.optInt("height", 0);
            if (TextUtils.isEmpty(this.src_pic)) {
                if (!TextUtils.isEmpty(this.original_url)) {
                    this.src_pic = this.original_url;
                } else if (TextUtils.isEmpty(this.pic_url)) {
                } else {
                    this.src_pic = this.pic_url;
                    this.original_url = this.pic_url;
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void parserProtobuf(Media media) {
        if (media == null) {
            return;
        }
        int intValue = media.type.intValue();
        this.type = intValue;
        if (intValue == 3) {
            this.pic_url = media.big_pic;
            this.src_pic = media.src_pic;
        } else if (intValue == 5) {
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
        this.small_pic_url = media.small_pic;
        this.origin_pic = media.origin_pic;
        this.smartCropCenterPointWidthRatio = media.wth_mid_loc.doubleValue();
        this.smartCropCenterPointHeightRatio = media.hth_mid_loc.doubleValue();
        this.picWidth = media.width.intValue();
        this.picHeight = media.height.intValue();
        if (TextUtils.isEmpty(this.src_pic)) {
            if (!TextUtils.isEmpty(this.original_url)) {
                this.src_pic = this.original_url;
            } else if (TextUtils.isEmpty(this.pic_url)) {
            } else {
                String str = this.pic_url;
                this.src_pic = str;
                this.original_url = str;
                if (TextUtils.isEmpty(this.origin_pic)) {
                    this.origin_pic = this.pic_url;
                }
                if (TextUtils.isEmpty(this.thumbnails_url)) {
                    this.thumbnails_url = this.pic_url;
                }
            }
        }
    }

    public void setDuration(int i2) {
        this.during_time = i2;
    }

    public void setIsLongPic(boolean z) {
        this.isLongPic = z;
    }

    public void setOriginalSize(long j) {
        this.original_size = j;
    }

    public void setOriginalUrl(String str) {
        this.original_url = str;
    }

    public void setPic(String str) {
        this.pic_url = str;
    }

    public void setSrc_pic(String str) {
        this.src_pic = str;
    }

    public void setThumbnails_url(String str) {
        this.thumbnails_url = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public void setVideo(String str) {
        this.video_url = str;
    }
}
