package com.baidu.searchbox.player.model;

import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"toBasicVideoSeries", "Lcom/baidu/searchbox/player/model/BasicVideoSeries;", "", "needPrepare", "", "bdvideoplayer-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BasicVideoSeriesKt {
    @JvmOverloads
    public static final BasicVideoSeries toBasicVideoSeries(String str) {
        return toBasicVideoSeries$default(str, false, 1, null);
    }

    @JvmOverloads
    public static final BasicVideoSeries toBasicVideoSeries(String str, boolean z) {
        BasicVideoSeries basicVideoSeries = new BasicVideoSeries();
        basicVideoSeries.setVideoUrl(str);
        basicVideoSeries.setNeedPrepare(z);
        return basicVideoSeries;
    }

    public static /* synthetic */ BasicVideoSeries toBasicVideoSeries$default(String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return toBasicVideoSeries(str, z);
    }
}
