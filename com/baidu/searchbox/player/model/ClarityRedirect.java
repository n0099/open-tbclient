package com.baidu.searchbox.player.model;

import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/player/model/ClarityRedirect;", "", "fromRank", "", "toRank", "tag", "", "(IILjava/lang/String;)V", "getFromRank", "()I", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "getToRank", "component1", "component2", "component3", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", TTDownloadField.TT_HASHCODE, "toString", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ClarityRedirect {
    public final int fromRank;
    public String tag;
    public final int toRank;

    public ClarityRedirect() {
        this(0, 0, null, 7, null);
    }

    public static /* synthetic */ ClarityRedirect copy$default(ClarityRedirect clarityRedirect, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = clarityRedirect.fromRank;
        }
        if ((i3 & 2) != 0) {
            i2 = clarityRedirect.toRank;
        }
        if ((i3 & 4) != 0) {
            str = clarityRedirect.tag;
        }
        return clarityRedirect.copy(i, i2, str);
    }

    public final int component1() {
        return this.fromRank;
    }

    public final int component2() {
        return this.toRank;
    }

    public final String component3() {
        return this.tag;
    }

    public final ClarityRedirect copy(int i, int i2, String str) {
        return new ClarityRedirect(i, i2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ClarityRedirect) {
            ClarityRedirect clarityRedirect = (ClarityRedirect) obj;
            return this.fromRank == clarityRedirect.fromRank && this.toRank == clarityRedirect.toRank && Intrinsics.areEqual(this.tag, clarityRedirect.tag);
        }
        return false;
    }

    public int hashCode() {
        int i = ((this.fromRank * 31) + this.toRank) * 31;
        String str = this.tag;
        return i + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ClarityRedirect(fromRank=" + this.fromRank + ", toRank=" + this.toRank + ", tag=" + this.tag + ')';
    }

    public ClarityRedirect(int i, int i2, String str) {
        this.fromRank = i;
        this.toRank = i2;
        this.tag = str;
    }

    public /* synthetic */ ClarityRedirect(int i, int i2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? -1 : i, (i3 & 2) != 0 ? -1 : i2, (i3 & 4) != 0 ? "" : str);
    }

    public final int getFromRank() {
        return this.fromRank;
    }

    public final String getTag() {
        return this.tag;
    }

    public final int getToRank() {
        return this.toRank;
    }

    public final void setTag(String str) {
        this.tag = str;
    }
}
