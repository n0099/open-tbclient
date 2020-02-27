package com.baidu.android.util.media.model;

import com.baidu.android.util.media.annotations.ColumnName;
import com.baidu.android.util.media.annotations.MediaQueryParam;
@MediaQueryParam(sortBy = "date_added", sortType = MediaQueryParam.SORT_DESC)
/* loaded from: classes12.dex */
public class DefaultVideoInfo extends MediaInfo {
    @ColumnName("duration")
    public long duration;
    @ColumnName("height")
    public int height;
    @ColumnName("_size")
    public long size;
    @ColumnName("width")
    public int width;
}
