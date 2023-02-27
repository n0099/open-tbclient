package com.baidu.searchbox.live.data.req;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J8\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/live/data/req/LiveListParamsMix;", "Lcom/baidu/searchbox/live/data/req/MixBaseParams;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "roomId", "pageSession", "ext", "source", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/baidu/searchbox/live/data/req/LiveListParamsMix;", "", ImageViewerConfig.FROM_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "toString", "Ljava/lang/String;", "getExt", "getPageSession", "getRoomId", "getSource", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveListParamsMix extends MixBaseParams {
    public final String ext;
    public final String pageSession;
    public final String roomId;
    public final String source;

    public static /* synthetic */ LiveListParamsMix copy$default(LiveListParamsMix liveListParamsMix, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = liveListParamsMix.roomId;
        }
        if ((i & 2) != 0) {
            str2 = liveListParamsMix.pageSession;
        }
        if ((i & 4) != 0) {
            str3 = liveListParamsMix.ext;
        }
        if ((i & 8) != 0) {
            str4 = liveListParamsMix.source;
        }
        return liveListParamsMix.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.roomId;
    }

    public final String component2() {
        return this.pageSession;
    }

    public final String component3() {
        return this.ext;
    }

    public final String component4() {
        return this.source;
    }

    public final LiveListParamsMix copy(String str, String str2, String str3, String str4) {
        return new LiveListParamsMix(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof LiveListParamsMix) {
                LiveListParamsMix liveListParamsMix = (LiveListParamsMix) obj;
                return Intrinsics.areEqual(this.roomId, liveListParamsMix.roomId) && Intrinsics.areEqual(this.pageSession, liveListParamsMix.pageSession) && Intrinsics.areEqual(this.ext, liveListParamsMix.ext) && Intrinsics.areEqual(this.source, liveListParamsMix.source);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.roomId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.pageSession;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.ext;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.source;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "LiveListParamsMix(roomId=" + this.roomId + ", pageSession=" + this.pageSession + ", ext=" + this.ext + ", source=" + this.source + SmallTailInfo.EMOTION_SUFFIX;
    }

    public LiveListParamsMix(String str, String str2, String str3, String str4) {
        super(null, null, 3, null);
        this.roomId = str;
        this.pageSession = str2;
        this.ext = str3;
        this.source = str4;
    }

    public final String getExt() {
        return this.ext;
    }

    public final String getPageSession() {
        return this.pageSession;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getSource() {
        return this.source;
    }
}
