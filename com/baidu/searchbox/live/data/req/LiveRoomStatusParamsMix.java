package com.baidu.searchbox.live.data.req;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/live/data/req/LiveRoomStatusParamsMix;", "Lcom/baidu/searchbox/live/data/req/MixBaseParams;", "", "component1", "()Ljava/lang/String;", "roomId", "copy", "(Ljava/lang/String;)Lcom/baidu/searchbox/live/data/req/LiveRoomStatusParamsMix;", "", ImageViewerConfig.FROM_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "toString", "Ljava/lang/String;", "getRoomId", "<init>", "(Ljava/lang/String;)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveRoomStatusParamsMix extends MixBaseParams {
    public final String roomId;

    public static /* synthetic */ LiveRoomStatusParamsMix copy$default(LiveRoomStatusParamsMix liveRoomStatusParamsMix, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = liveRoomStatusParamsMix.roomId;
        }
        return liveRoomStatusParamsMix.copy(str);
    }

    public final String component1() {
        return this.roomId;
    }

    public final LiveRoomStatusParamsMix copy(String str) {
        return new LiveRoomStatusParamsMix(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof LiveRoomStatusParamsMix) && Intrinsics.areEqual(this.roomId, ((LiveRoomStatusParamsMix) obj).roomId);
        }
        return true;
    }

    public int hashCode() {
        String str = this.roomId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "LiveRoomStatusParamsMix(roomId=" + this.roomId + SmallTailInfo.EMOTION_SUFFIX;
    }

    public LiveRoomStatusParamsMix(String str) {
        super(null, null, 3, null);
        this.roomId = str;
    }

    public final String getRoomId() {
        return this.roomId;
    }
}
