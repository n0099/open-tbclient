package com.baidu.searchbox.player.model;
/* loaded from: classes3.dex */
public class VideoUrlModel {
    public boolean isNeedPrepare;
    public String logId;
    public int playerStageType = -1;
    public String videoUrl;

    public String toString() {
        return "VideoUrlModel{videoUrl='" + this.videoUrl + "', isNeedPrepare=" + this.isNeedPrepare + ", playerStageType=" + this.playerStageType + '}';
    }
}
