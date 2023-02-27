package com.baidu.searchbox.live.data.req;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J&\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004R$\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001d\u0010\u0004¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/live/data/req/RoomExitParams;", "Lcom/baidu/searchbox/live/data/req/MixBaseParams;", "", "component1", "()Ljava/lang/String;", "component2", "roomId", "templateId", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/baidu/searchbox/live/data/req/RoomExitParams;", "", ImageViewerConfig.FROM_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "", "toMap", "()Ljava/util/Map;", "toString", "isAudio", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setAudio", "(Ljava/lang/Boolean;)V", "Ljava/lang/String;", "getRoomId", "getTemplateId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class RoomExitParams extends MixBaseParams {
    public Boolean isAudio;
    public final String roomId;
    public final String templateId;

    public static /* synthetic */ RoomExitParams copy$default(RoomExitParams roomExitParams, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = roomExitParams.roomId;
        }
        if ((i & 2) != 0) {
            str2 = roomExitParams.templateId;
        }
        return roomExitParams.copy(str, str2);
    }

    public final String component1() {
        return this.roomId;
    }

    public final String component2() {
        return this.templateId;
    }

    public final RoomExitParams copy(String str, String str2) {
        return new RoomExitParams(str, str2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof RoomExitParams) {
                RoomExitParams roomExitParams = (RoomExitParams) obj;
                return Intrinsics.areEqual(this.roomId, roomExitParams.roomId) && Intrinsics.areEqual(this.templateId, roomExitParams.templateId);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.roomId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.templateId;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "RoomExitParams(roomId=" + this.roomId + ", templateId=" + this.templateId + SmallTailInfo.EMOTION_SUFFIX;
    }

    public RoomExitParams(String str, String str2) {
        super(null, null, 3, null);
        this.roomId = str;
        this.templateId = str2;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final Boolean isAudio() {
        return this.isAudio;
    }

    @Override // com.baidu.searchbox.live.data.req.MixBaseParams
    public Map<String, String> toMap() {
        addExtParams("room_id", this.roomId);
        String str = this.templateId;
        if (str != null) {
            addExtParams("template_id", str);
        }
        return super.toMap();
    }

    public final void setAudio(Boolean bool) {
        this.isAudio = bool;
    }
}
