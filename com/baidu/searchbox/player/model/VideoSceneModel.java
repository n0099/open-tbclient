package com.baidu.searchbox.player.model;

import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/player/model/VideoSceneModel;", "", "from", "", "page", "source", "extLog", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getExtLog", "()Ljava/lang/String;", "getFrom", "getPage", "getSource", "component1", "component2", "component3", "component4", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", TTDownloadField.TT_HASHCODE, "", "toString", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class VideoSceneModel {
    public final String extLog;
    public final String from;
    public final String page;
    public final String source;

    public VideoSceneModel() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ VideoSceneModel copy$default(VideoSceneModel videoSceneModel, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = videoSceneModel.from;
        }
        if ((i & 2) != 0) {
            str2 = videoSceneModel.page;
        }
        if ((i & 4) != 0) {
            str3 = videoSceneModel.source;
        }
        if ((i & 8) != 0) {
            str4 = videoSceneModel.extLog;
        }
        return videoSceneModel.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.from;
    }

    public final String component2() {
        return this.page;
    }

    public final String component3() {
        return this.source;
    }

    public final String component4() {
        return this.extLog;
    }

    public final VideoSceneModel copy(String str, String str2, String str3, String str4) {
        return new VideoSceneModel(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VideoSceneModel) {
            VideoSceneModel videoSceneModel = (VideoSceneModel) obj;
            return Intrinsics.areEqual(this.from, videoSceneModel.from) && Intrinsics.areEqual(this.page, videoSceneModel.page) && Intrinsics.areEqual(this.source, videoSceneModel.source) && Intrinsics.areEqual(this.extLog, videoSceneModel.extLog);
        }
        return false;
    }

    public int hashCode() {
        String str = this.from;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.page;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.source;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.extLog;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "VideoSceneModel(from=" + this.from + ", page=" + this.page + ", source=" + this.source + ", extLog=" + this.extLog + ')';
    }

    public VideoSceneModel(String str, String str2, String str3, String str4) {
        this.from = str;
        this.page = str2;
        this.source = str3;
        this.extLog = str4;
    }

    public /* synthetic */ VideoSceneModel(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }

    public final String getExtLog() {
        return this.extLog;
    }

    public final String getFrom() {
        return this.from;
    }

    public final String getPage() {
        return this.page;
    }

    public final String getSource() {
        return this.source;
    }
}
