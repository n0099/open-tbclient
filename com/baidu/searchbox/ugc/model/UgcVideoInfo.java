package com.baidu.searchbox.ugc.model;

import com.baidu.android.util.media.annotations.ColumnName;
import com.baidu.android.util.media.annotations.MediaQueryParam;
import com.baidu.android.util.media.model.DefaultVideoInfo;
@MediaQueryParam(select = {"duration>? and _size>?"}, selectArgs = {"0", "0"}, sortBy = "date_added", sortType = MediaQueryParam.SORT_DESC)
/* loaded from: classes13.dex */
public class UgcVideoInfo extends DefaultVideoInfo implements ILocalMedia {
    @ColumnName("_data")
    public String path;

    public String toString() {
        return "UgcVideoInfo{path='" + this.path + "', duration=" + this.duration + ", size=" + this.size + ", width=" + this.width + ", height=" + this.height + ", contentUri=" + this.contentUri + '}';
    }

    @Override // com.baidu.searchbox.ugc.model.ILocalMedia
    public String getPath() {
        return this.path;
    }
}
