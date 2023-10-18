package com.baidu.searchbox.player.model;

import com.baidu.searchbox.player.helper.PlayerUrlParamsManager;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/player/model/VideoSceneEnvModel;", "", "sceneModel", "Lcom/baidu/searchbox/player/model/VideoSceneModel;", PlayerUrlParamsManager.SCENEX, "", "(Lcom/baidu/searchbox/player/model/VideoSceneModel;Ljava/lang/String;)V", "getSceneModel", "()Lcom/baidu/searchbox/player/model/VideoSceneModel;", "getScenex", "()Ljava/lang/String;", "component1", "component2", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "hashCode", "", "toString", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class VideoSceneEnvModel {
    public final VideoSceneModel sceneModel;
    public final String scenex;

    public static /* synthetic */ VideoSceneEnvModel copy$default(VideoSceneEnvModel videoSceneEnvModel, VideoSceneModel videoSceneModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            videoSceneModel = videoSceneEnvModel.sceneModel;
        }
        if ((i & 2) != 0) {
            str = videoSceneEnvModel.scenex;
        }
        return videoSceneEnvModel.copy(videoSceneModel, str);
    }

    public final VideoSceneModel component1() {
        return this.sceneModel;
    }

    public final String component2() {
        return this.scenex;
    }

    public final VideoSceneEnvModel copy(VideoSceneModel sceneModel, String scenex) {
        Intrinsics.checkNotNullParameter(sceneModel, "sceneModel");
        Intrinsics.checkNotNullParameter(scenex, "scenex");
        return new VideoSceneEnvModel(sceneModel, scenex);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VideoSceneEnvModel) {
            VideoSceneEnvModel videoSceneEnvModel = (VideoSceneEnvModel) obj;
            return Intrinsics.areEqual(this.sceneModel, videoSceneEnvModel.sceneModel) && Intrinsics.areEqual(this.scenex, videoSceneEnvModel.scenex);
        }
        return false;
    }

    public int hashCode() {
        return (this.sceneModel.hashCode() * 31) + this.scenex.hashCode();
    }

    public String toString() {
        return "VideoSceneEnvModel(sceneModel=" + this.sceneModel + ", scenex=" + this.scenex + ')';
    }

    public VideoSceneEnvModel(VideoSceneModel sceneModel, String scenex) {
        Intrinsics.checkNotNullParameter(sceneModel, "sceneModel");
        Intrinsics.checkNotNullParameter(scenex, "scenex");
        this.sceneModel = sceneModel;
        this.scenex = scenex;
    }

    public final VideoSceneModel getSceneModel() {
        return this.sceneModel;
    }

    public final String getScenex() {
        return this.scenex;
    }
}
