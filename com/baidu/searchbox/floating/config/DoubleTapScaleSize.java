package com.baidu.searchbox.floating.config;

import com.baidu.minivideo.effect.core.vlogedit.MediaAEffect;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u0015\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J5\u0010\u000f\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001J\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u0004R&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/floating/config/DoubleTapScaleSize;", "", "preSize", "Lkotlin/Pair;", "", "curSize", "(Lkotlin/Pair;Lkotlin/Pair;)V", "getCurSize", "()Lkotlin/Pair;", "setCurSize", "(Lkotlin/Pair;)V", "getPreSize", "setPreSize", "component1", "component2", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "hashCode", MediaAEffect.AE_ANIM_REVERSE, "toString", "", StickerDataChangeType.UPDATE, "", "width", "height", "sizeChangeThreshold", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DoubleTapScaleSize {
    public Pair<Integer, Integer> curSize;
    public Pair<Integer, Integer> preSize;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.floating.config.DoubleTapScaleSize */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DoubleTapScaleSize copy$default(DoubleTapScaleSize doubleTapScaleSize, Pair pair, Pair pair2, int i, Object obj) {
        if ((i & 1) != 0) {
            pair = doubleTapScaleSize.preSize;
        }
        if ((i & 2) != 0) {
            pair2 = doubleTapScaleSize.curSize;
        }
        return doubleTapScaleSize.copy(pair, pair2);
    }

    public final Pair<Integer, Integer> component1() {
        return this.preSize;
    }

    public final Pair<Integer, Integer> component2() {
        return this.curSize;
    }

    public final DoubleTapScaleSize copy(Pair<Integer, Integer> preSize, Pair<Integer, Integer> curSize) {
        Intrinsics.checkNotNullParameter(preSize, "preSize");
        Intrinsics.checkNotNullParameter(curSize, "curSize");
        return new DoubleTapScaleSize(preSize, curSize);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DoubleTapScaleSize) {
            DoubleTapScaleSize doubleTapScaleSize = (DoubleTapScaleSize) obj;
            return Intrinsics.areEqual(this.preSize, doubleTapScaleSize.preSize) && Intrinsics.areEqual(this.curSize, doubleTapScaleSize.curSize);
        }
        return false;
    }

    public int hashCode() {
        return (this.preSize.hashCode() * 31) + this.curSize.hashCode();
    }

    public String toString() {
        return "DoubleTapScaleSize(preSize=" + this.preSize + ", curSize=" + this.curSize + ')';
    }

    public DoubleTapScaleSize(Pair<Integer, Integer> preSize, Pair<Integer, Integer> curSize) {
        Intrinsics.checkNotNullParameter(preSize, "preSize");
        Intrinsics.checkNotNullParameter(curSize, "curSize");
        this.preSize = preSize;
        this.curSize = curSize;
    }

    public static /* synthetic */ void update$default(DoubleTapScaleSize doubleTapScaleSize, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 10;
        }
        doubleTapScaleSize.update(i, i2, i3);
    }

    public final Pair<Integer, Integer> getCurSize() {
        return this.curSize;
    }

    public final Pair<Integer, Integer> getPreSize() {
        return this.preSize;
    }

    public final Pair<Integer, Integer> reverse() {
        Pair<Integer, Integer> pair = this.preSize;
        this.preSize = this.curSize;
        this.curSize = pair;
        return pair;
    }

    public final void setCurSize(Pair<Integer, Integer> pair) {
        Intrinsics.checkNotNullParameter(pair, "<set-?>");
        this.curSize = pair;
    }

    public final void setPreSize(Pair<Integer, Integer> pair) {
        Intrinsics.checkNotNullParameter(pair, "<set-?>");
        this.preSize = pair;
    }

    public final void update(int i, int i2, int i3) {
        if (Math.abs(i - this.curSize.getFirst().intValue()) >= i3) {
            this.preSize = this.curSize;
            this.curSize = new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
