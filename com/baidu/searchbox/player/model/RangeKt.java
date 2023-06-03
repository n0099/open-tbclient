package com.baidu.searchbox.player.model;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a(\u0010\u0002\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u0002H\u0004H\u0086\u0002¢\u0006\u0002\u0010\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"SPLIT_OPERATOR", "", "contains", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/baidu/searchbox/player/model/Range;", "value", "(Lcom/baidu/searchbox/player/model/Range;Ljava/lang/Object;)Z", "bdvideoplayer-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RangeKt {
    public static final String SPLIT_OPERATOR = "_";

    public static final <T> boolean contains(Range<T> range, T t) {
        if (range != null && !range.contains(t)) {
            return false;
        }
        return true;
    }
}
