package com.baidu.searchbox.ugc.model;

import android.graphics.Bitmap;
import android.net.Uri;
import com.baidu.android.util.media.model.DefaultVideoInfo;
import com.baidu.searchbox.ugc.utils.UgcUriUtils;
/* loaded from: classes12.dex */
public class VideoInfo {
    public Bitmap bitmap;
    public long clipDuration;
    public long clipPoint;
    public Uri contentUri;
    public long duration;
    public int height;
    public int rotation;
    public long size;
    public String thumbUri;
    public String uriStr;
    public int width;

    public void setInfo(DefaultVideoInfo defaultVideoInfo) {
        if (defaultVideoInfo != null) {
            this.contentUri = defaultVideoInfo.contentUri;
            this.uriStr = this.contentUri == null ? "" : this.contentUri.toString();
            this.duration = defaultVideoInfo.duration;
            this.size = defaultVideoInfo.size;
            this.width = defaultVideoInfo.width;
            this.height = defaultVideoInfo.height;
        }
    }

    public void setUriStr(String str) {
        this.uriStr = str;
        this.contentUri = UgcUriUtils.getUri(str);
    }

    public Bitmap getThumbnailBitmap() {
        return this.bitmap;
    }

    public void setThumbnailBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long j) {
        this.size = j;
    }
}
