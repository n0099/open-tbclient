package com.baidu.searchbox.player.model;

import com.baidu.searchbox.player.utils.BasicVideoParserKt;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J1\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R%\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/player/model/ClarityStrategyModel;", "", BasicVideoParserKt.PREFERRED_CLARITY_RANK, "", "clarityRedirect", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/player/model/ClarityRedirect;", "Lkotlin/collections/ArrayList;", "(ILjava/util/ArrayList;)V", "getClarityRedirect", "()Ljava/util/ArrayList;", "getPreferredClarityRank", "()I", "component1", "component2", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "hashCode", "toString", "", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ClarityStrategyModel {
    public final ArrayList<ClarityRedirect> clarityRedirect;
    public final int preferredClarityRank;

    public ClarityStrategyModel() {
        this(0, null, 3, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.player.model.ClarityStrategyModel */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ClarityStrategyModel copy$default(ClarityStrategyModel clarityStrategyModel, int i, ArrayList arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = clarityStrategyModel.preferredClarityRank;
        }
        if ((i2 & 2) != 0) {
            arrayList = clarityStrategyModel.clarityRedirect;
        }
        return clarityStrategyModel.copy(i, arrayList);
    }

    public final int component1() {
        return this.preferredClarityRank;
    }

    public final ArrayList<ClarityRedirect> component2() {
        return this.clarityRedirect;
    }

    public final ClarityStrategyModel copy(int i, ArrayList<ClarityRedirect> arrayList) {
        return new ClarityStrategyModel(i, arrayList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ClarityStrategyModel) {
            ClarityStrategyModel clarityStrategyModel = (ClarityStrategyModel) obj;
            return this.preferredClarityRank == clarityStrategyModel.preferredClarityRank && Intrinsics.areEqual(this.clarityRedirect, clarityStrategyModel.clarityRedirect);
        }
        return false;
    }

    public int hashCode() {
        int i = this.preferredClarityRank * 31;
        ArrayList<ClarityRedirect> arrayList = this.clarityRedirect;
        return i + (arrayList == null ? 0 : arrayList.hashCode());
    }

    public String toString() {
        return "ClarityStrategyModel(preferredClarityRank=" + this.preferredClarityRank + ", clarityRedirect=" + this.clarityRedirect + ')';
    }

    public ClarityStrategyModel(int i, ArrayList<ClarityRedirect> arrayList) {
        this.preferredClarityRank = i;
        this.clarityRedirect = arrayList;
    }

    public /* synthetic */ ClarityStrategyModel(int i, ArrayList arrayList, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i, (i2 & 2) != 0 ? null : arrayList);
    }

    public final ArrayList<ClarityRedirect> getClarityRedirect() {
        return this.clarityRedirect;
    }

    public final int getPreferredClarityRank() {
        return this.preferredClarityRank;
    }
}
