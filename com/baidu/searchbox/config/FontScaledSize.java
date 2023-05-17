package com.baidu.searchbox.config;

import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/config/FontScaledSize;", "", "isScaled", "", "scaledWidth", "", "scaledHeight", "(ZFF)V", "()Z", "getScaledHeight", "()F", "getScaledWidth", "component1", "component2", "component3", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "other", TTDownloadField.TT_HASHCODE, "", "toString", "", "lib-fontsize_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FontScaledSize {
    public final boolean isScaled;
    public final float scaledHeight;
    public final float scaledWidth;

    public static /* synthetic */ FontScaledSize copy$default(FontScaledSize fontScaledSize, boolean z, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = fontScaledSize.isScaled;
        }
        if ((i & 2) != 0) {
            f = fontScaledSize.scaledWidth;
        }
        if ((i & 4) != 0) {
            f2 = fontScaledSize.scaledHeight;
        }
        return fontScaledSize.copy(z, f, f2);
    }

    public final boolean component1() {
        return this.isScaled;
    }

    public final float component2() {
        return this.scaledWidth;
    }

    public final float component3() {
        return this.scaledHeight;
    }

    public final FontScaledSize copy(boolean z, float f, float f2) {
        return new FontScaledSize(z, f, f2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FontScaledSize) {
            FontScaledSize fontScaledSize = (FontScaledSize) obj;
            return this.isScaled == fontScaledSize.isScaled && Intrinsics.areEqual((Object) Float.valueOf(this.scaledWidth), (Object) Float.valueOf(fontScaledSize.scaledWidth)) && Intrinsics.areEqual((Object) Float.valueOf(this.scaledHeight), (Object) Float.valueOf(fontScaledSize.scaledHeight));
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z = this.isScaled;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((r0 * 31) + Float.floatToIntBits(this.scaledWidth)) * 31) + Float.floatToIntBits(this.scaledHeight);
    }

    public String toString() {
        return "FontScaledSize(isScaled=" + this.isScaled + ", scaledWidth=" + this.scaledWidth + ", scaledHeight=" + this.scaledHeight + ')';
    }

    public FontScaledSize(boolean z, float f, float f2) {
        this.isScaled = z;
        this.scaledWidth = f;
        this.scaledHeight = f2;
    }

    public final float getScaledHeight() {
        return this.scaledHeight;
    }

    public final float getScaledWidth() {
        return this.scaledWidth;
    }

    public final boolean isScaled() {
        return this.isScaled;
    }
}
