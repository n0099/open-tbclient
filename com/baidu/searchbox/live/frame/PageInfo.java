package com.baidu.searchbox.live.frame;

import com.baidu.live.arch.frame.State;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.data.SmallTailInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!B)\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0007J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u000e\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\f\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/live/frame/PageInfo;", "Lcom/baidu/live/arch/frame/State;", "", "component1", "()Z", "", "component2", "()I", "component3", "", "component4", "()J", "isUp", CriusAttrConstants.POSITION, "isFromForward", "listRequestDuration", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "(ZIZJ)Lcom/baidu/searchbox/live/frame/PageInfo;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Z", "J", "getListRequestDuration", "I", "getPosition", "<init>", "(ZIZJ)V", "Companion", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class PageInfo implements State {
    public static final Companion Companion = new Companion(null);
    public static final String KEY = "page_info";
    public final boolean isFromForward;
    public final boolean isUp;
    public final long listRequestDuration;
    public final int position;

    public static /* synthetic */ PageInfo copy$default(PageInfo pageInfo, boolean z, int i, boolean z2, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = pageInfo.isUp;
        }
        if ((i2 & 2) != 0) {
            i = pageInfo.position;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            z2 = pageInfo.isFromForward;
        }
        boolean z3 = z2;
        if ((i2 & 8) != 0) {
            j = pageInfo.listRequestDuration;
        }
        return pageInfo.copy(z, i3, z3, j);
    }

    public final boolean component1() {
        return this.isUp;
    }

    public final int component2() {
        return this.position;
    }

    public final boolean component3() {
        return this.isFromForward;
    }

    public final long component4() {
        return this.listRequestDuration;
    }

    public final PageInfo copy(boolean z, int i, boolean z2, long j) {
        return new PageInfo(z, i, z2, j);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof PageInfo) {
                PageInfo pageInfo = (PageInfo) obj;
                return this.isUp == pageInfo.isUp && this.position == pageInfo.position && this.isFromForward == pageInfo.isFromForward && this.listRequestDuration == pageInfo.listRequestDuration;
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z = this.isUp;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = ((r0 * 31) + this.position) * 31;
        boolean z2 = this.isFromForward;
        int i2 = z2 ? 1 : z2 ? 1 : 0;
        long j = this.listRequestDuration;
        return ((i + i2) * 31) + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "PageInfo(isUp=" + this.isUp + ", position=" + this.position + ", isFromForward=" + this.isFromForward + ", listRequestDuration=" + this.listRequestDuration + SmallTailInfo.EMOTION_SUFFIX;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/live/frame/PageInfo$Companion;", "", "KEY", "Ljava/lang/String;", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PageInfo(boolean z, int i, boolean z2, long j) {
        this.isUp = z;
        this.position = i;
        this.isFromForward = z2;
        this.listRequestDuration = j;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ PageInfo(boolean z, int i, boolean z2, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, i, r3, j);
        boolean z3;
        if ((i2 & 4) != 0) {
            z3 = false;
        } else {
            z3 = z2;
        }
    }

    public final long getListRequestDuration() {
        return this.listRequestDuration;
    }

    public final int getPosition() {
        return this.position;
    }

    public final boolean isFromForward() {
        return this.isFromForward;
    }

    public final boolean isUp() {
        return this.isUp;
    }
}
