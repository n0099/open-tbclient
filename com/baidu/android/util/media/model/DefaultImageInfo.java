package com.baidu.android.util.media.model;

import com.baidu.android.util.media.MimeType;
import com.baidu.android.util.media.annotations.ColumnName;
import com.baidu.android.util.media.annotations.MediaQueryParam;
@MediaQueryParam(select = {"mime_type", "=?", " or ", "mime_type", "=?"}, selectArgs = {MimeType.Image.JPEG, MimeType.Image.PNG}, sortBy = "date_added", sortType = MediaQueryParam.SORT_DESC)
/* loaded from: classes10.dex */
public class DefaultImageInfo extends MediaInfo {
    @ColumnName("bucket_display_name")
    public String bucketDisplayName;
    @ColumnName("bucket_id")
    public String bucketId;
    @ColumnName("date_modified")
    public long dateModified;
    @ColumnName("_size")
    public long size;

    public String toString() {
        return "DefaultImageInfo{bucketId=" + this.bucketId + ", bucketDisplayName='" + this.bucketDisplayName + "', dateModified=" + this.dateModified + ", size=" + this.size + '}';
    }
}
