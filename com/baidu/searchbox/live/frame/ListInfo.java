package com.baidu.searchbox.live.frame;

import com.baidu.live.arch.frame.State;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0014\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/live/frame/ListInfo;", "Lcom/baidu/live/arch/frame/State;", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "pageSession", "hasMore", "copy", "(Ljava/lang/String;I)Lcom/baidu/searchbox/live/frame/ListInfo;", "", ImageViewerConfig.FROM_OTHER, "", "equals", "(Ljava/lang/Object;)Z", TTDownloadField.TT_HASHCODE, "toString", "I", "getHasMore", "Ljava/lang/String;", "getPageSession", "<init>", "(Ljava/lang/String;I)V", "Companion", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class ListInfo implements State {
    public static final Companion Companion = new Companion(null);
    public static final String KEY = "list_info";
    public final int hasMore;
    public final String pageSession;

    public static /* synthetic */ ListInfo copy$default(ListInfo listInfo, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = listInfo.pageSession;
        }
        if ((i2 & 2) != 0) {
            i = listInfo.hasMore;
        }
        return listInfo.copy(str, i);
    }

    public final String component1() {
        return this.pageSession;
    }

    public final int component2() {
        return this.hasMore;
    }

    public final ListInfo copy(String str, int i) {
        return new ListInfo(str, i);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ListInfo) {
                ListInfo listInfo = (ListInfo) obj;
                return Intrinsics.areEqual(this.pageSession, listInfo.pageSession) && this.hasMore == listInfo.hasMore;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.pageSession;
        return ((str != null ? str.hashCode() : 0) * 31) + this.hasMore;
    }

    public String toString() {
        return "ListInfo(pageSession=" + this.pageSession + ", hasMore=" + this.hasMore + SmallTailInfo.EMOTION_SUFFIX;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/live/frame/ListInfo$Companion;", "", "KEY", "Ljava/lang/String;", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ListInfo(String str, int i) {
        this.pageSession = str;
        this.hasMore = i;
    }

    public final int getHasMore() {
        return this.hasMore;
    }

    public final String getPageSession() {
        return this.pageSession;
    }
}
