package com.baidu.android.util.media.model;

import com.baidu.android.util.media.annotations.ColumnName;
import com.baidu.android.util.media.annotations.MediaQueryParam;
@MediaQueryParam(sortBy = "date_added", sortType = MediaQueryParam.SORT_DESC)
/* loaded from: classes10.dex */
public class DefaultAudioInfo extends MediaInfo {
    @ColumnName("duration")
    public long duration;
    @ColumnName("_size")
    public long size;
}
