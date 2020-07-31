package com.baidu.searchbox.ugc.model;

import com.baidu.android.util.media.MimeType;
import com.baidu.android.util.media.annotations.ColumnName;
import com.baidu.android.util.media.annotations.MediaQueryParam;
import com.baidu.android.util.media.model.MediaInfo;
@MediaQueryParam(select = {"mime_type", "=?", " or ", "mime_type", "=?"}, selectArgs = {MimeType.Image.JPEG, MimeType.Image.PNG}, sortBy = "date_added", sortType = MediaQueryParam.SORT_DESC)
/* loaded from: classes19.dex */
public class UgcImageInfo extends MediaInfo implements ILocalMedia {
    @ColumnName("bucket_display_name")
    public String bucketDisplayName;
    @ColumnName("bucket_id")
    public String bucketId;
    @ColumnName("date_modified")
    public long dateModified;
    @ColumnName("height")
    public int height;
    @ColumnName("mime_type")
    public String mimeType;
    @ColumnName("_data")
    public String path;
    @ColumnName("_size")
    public long size;
    @ColumnName("width")
    public int width;

    public String toString() {
        return "UgcImageInfo{bucketId='" + this.bucketId + "', bucketDisplayName='" + this.bucketDisplayName + "', dateModified=" + this.dateModified + ", size=" + this.size + ", mimeType='" + this.mimeType + "', width=" + this.width + ", height=" + this.height + '}';
    }

    @Override // com.baidu.searchbox.ugc.model.ILocalMedia
    public String getPath() {
        return this.path;
    }
}
