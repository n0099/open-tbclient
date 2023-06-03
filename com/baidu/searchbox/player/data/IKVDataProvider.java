package com.baidu.searchbox.player.data;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/player/data/IKVDataProvider;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/baidu/searchbox/player/data/IReadOnlyDataProvider;", "saveData", "", "key", "", "value", "", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface IKVDataProvider<V> extends IReadOnlyDataProvider<V> {
    void saveData(String str, Object obj);
}
