package com.baidu.searchbox.live.data.req;

import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.atomData.AlaLiveTabMyConcernActivityConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b3\u00104J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJP\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010\u0004R$\u0010!\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001f\u001a\u0004\b\"\u0010\u0004\"\u0004\b#\u0010$R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b%\u0010\u0004R$\u0010&\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b&\u0010(\"\u0004\b)\u0010*R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b+\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010,\u001a\u0004\b-\u0010\u000bR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b.\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b/\u0010\u0004R$\u00100\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010\u001f\u001a\u0004\b1\u0010\u0004\"\u0004\b2\u0010$¨\u00065"}, d2 = {"Lcom/baidu/searchbox/live/data/req/RoomEnterParams;", "Lcom/baidu/searchbox/live/data/req/MixBaseParams;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "", "component6", "()Z", "id", "source", "query", "nid", "ext", "preFetch", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/baidu/searchbox/live/data/req/RoomEnterParams;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toMap", "()Ljava/util/Map;", "toString", "Ljava/lang/String;", "getExt", "extLog", "getExtLog", "setExtLog", "(Ljava/lang/String;)V", "getId", "isAudio", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setAudio", "(Ljava/lang/Boolean;)V", "getNid", "Z", "getPreFetch", "getQuery", "getSource", "specialSource", "getSpecialSource", "setSpecialSource", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class RoomEnterParams extends MixBaseParams {
    public final String ext;
    public String extLog;
    public final String id;
    public Boolean isAudio;
    public final String nid;
    public final boolean preFetch;
    public final String query;
    public final String source;
    public String specialSource;

    public static /* synthetic */ RoomEnterParams copy$default(RoomEnterParams roomEnterParams, String str, String str2, String str3, String str4, String str5, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = roomEnterParams.id;
        }
        if ((i & 2) != 0) {
            str2 = roomEnterParams.source;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = roomEnterParams.query;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = roomEnterParams.nid;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = roomEnterParams.ext;
        }
        String str9 = str5;
        if ((i & 32) != 0) {
            z = roomEnterParams.preFetch;
        }
        return roomEnterParams.copy(str, str6, str7, str8, str9, z);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.source;
    }

    public final String component3() {
        return this.query;
    }

    public final String component4() {
        return this.nid;
    }

    public final String component5() {
        return this.ext;
    }

    public final boolean component6() {
        return this.preFetch;
    }

    public final RoomEnterParams copy(String str, String str2, String str3, String str4, String str5, boolean z) {
        return new RoomEnterParams(str, str2, str3, str4, str5, z);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof RoomEnterParams) {
                RoomEnterParams roomEnterParams = (RoomEnterParams) obj;
                return Intrinsics.areEqual(this.id, roomEnterParams.id) && Intrinsics.areEqual(this.source, roomEnterParams.source) && Intrinsics.areEqual(this.query, roomEnterParams.query) && Intrinsics.areEqual(this.nid, roomEnterParams.nid) && Intrinsics.areEqual(this.ext, roomEnterParams.ext) && this.preFetch == roomEnterParams.preFetch;
            }
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.id;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.source;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.query;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.nid;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.ext;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        boolean z = this.preFetch;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "RoomEnterParams(id=" + this.id + ", source=" + this.source + ", query=" + this.query + ", nid=" + this.nid + ", ext=" + this.ext + ", preFetch=" + this.preFetch + SmallTailInfo.EMOTION_SUFFIX;
    }

    public RoomEnterParams(String str, String str2, String str3, String str4, String str5, boolean z) {
        super(null, null, 3, null);
        this.id = str;
        this.source = str2;
        this.query = str3;
        this.nid = str4;
        this.ext = str5;
        this.preFetch = z;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ RoomEnterParams(String str, String str2, String str3, String str4, String str5, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, r5, r6, str5, r8);
        String str6;
        String str7;
        boolean z2;
        if ((i & 4) != 0) {
            str6 = null;
        } else {
            str6 = str3;
        }
        if ((i & 8) != 0) {
            str7 = null;
        } else {
            str7 = str4;
        }
        if ((i & 32) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
    }

    public final String getExt() {
        return this.ext;
    }

    public final String getExtLog() {
        return this.extLog;
    }

    public final String getId() {
        return this.id;
    }

    public final String getNid() {
        return this.nid;
    }

    public final boolean getPreFetch() {
        return this.preFetch;
    }

    public final String getQuery() {
        return this.query;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getSpecialSource() {
        return this.specialSource;
    }

    public final Boolean isAudio() {
        return this.isAudio;
    }

    public final void setAudio(Boolean bool) {
        this.isAudio = bool;
    }

    public final void setExtLog(String str) {
        this.extLog = str;
    }

    public final void setSpecialSource(String str) {
        this.specialSource = str;
    }

    @Override // com.baidu.searchbox.live.data.req.MixBaseParams
    public Map<String, String> toMap() {
        boolean z;
        addExtParams("room_id", this.id);
        addExtParams(AlaLiveTabMyConcernActivityConfig.ALA_LIVE_SOURCE, this.source);
        String str = this.query;
        boolean z2 = false;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            addExtParams("query_content", this.query);
        }
        String str2 = this.nid;
        if (!((str2 == null || str2.length() == 0) ? true : true)) {
            addExtParams("nid", this.nid);
            addExtParams("nid_type", "1");
        }
        addExtParams("ext", this.ext);
        String str3 = this.specialSource;
        if (str3 != null) {
            addExtParams("special_source", str3);
        }
        String str4 = this.extLog;
        if (str4 != null) {
            addExtParams("extLog", str4);
        }
        return super.toMap();
    }
}
