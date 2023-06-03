package com.baidu.searchbox.player.utils;

import com.baidu.searchbox.player.model.BasicVideoSeries;
import com.baidu.searchbox.player.model.VideoSceneModel;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002¨\u0006\u0003"}, d2 = {"toSceneModel", "Lcom/baidu/searchbox/player/model/VideoSceneModel;", "Lcom/baidu/searchbox/player/model/BasicVideoSeries;", "bdvideoplayer-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "VideoSceneModelCreator")
/* loaded from: classes4.dex */
public final class VideoSceneModelCreator {
    public static final VideoSceneModel toSceneModel(BasicVideoSeries basicVideoSeries) {
        if (basicVideoSeries == null) {
            return null;
        }
        return new VideoSceneModel(basicVideoSeries.getFrom(), basicVideoSeries.getPage(), basicVideoSeries.getSource(), basicVideoSeries.getExtLog());
    }
}
