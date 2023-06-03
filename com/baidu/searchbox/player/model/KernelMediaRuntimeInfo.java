package com.baidu.searchbox.player.model;

import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/player/model/KernelMediaRuntimeInfo;", "", "memCacheSize", "", "diskCacheSize", "dropFrameCount", "downloadSpeed", "p2pDownloadSpeed", "cdnDownloadSpeed", "(IIIIII)V", "getCdnDownloadSpeed", "()I", "getDiskCacheSize", "getDownloadSpeed", "getDropFrameCount", "getMemCacheSize", "getP2pDownloadSpeed", "component1", "component2", "component3", "component4", "component5", "component6", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", TTDownloadField.TT_HASHCODE, "toString", "", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class KernelMediaRuntimeInfo {
    public final int cdnDownloadSpeed;
    public final int diskCacheSize;
    public final int downloadSpeed;
    public final int dropFrameCount;
    public final int memCacheSize;
    public final int p2pDownloadSpeed;

    public KernelMediaRuntimeInfo() {
        this(0, 0, 0, 0, 0, 0, 63, null);
    }

    public static /* synthetic */ KernelMediaRuntimeInfo copy$default(KernelMediaRuntimeInfo kernelMediaRuntimeInfo, int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = kernelMediaRuntimeInfo.memCacheSize;
        }
        if ((i7 & 2) != 0) {
            i2 = kernelMediaRuntimeInfo.diskCacheSize;
        }
        int i8 = i2;
        if ((i7 & 4) != 0) {
            i3 = kernelMediaRuntimeInfo.dropFrameCount;
        }
        int i9 = i3;
        if ((i7 & 8) != 0) {
            i4 = kernelMediaRuntimeInfo.downloadSpeed;
        }
        int i10 = i4;
        if ((i7 & 16) != 0) {
            i5 = kernelMediaRuntimeInfo.p2pDownloadSpeed;
        }
        int i11 = i5;
        if ((i7 & 32) != 0) {
            i6 = kernelMediaRuntimeInfo.cdnDownloadSpeed;
        }
        return kernelMediaRuntimeInfo.copy(i, i8, i9, i10, i11, i6);
    }

    public final int component1() {
        return this.memCacheSize;
    }

    public final int component2() {
        return this.diskCacheSize;
    }

    public final int component3() {
        return this.dropFrameCount;
    }

    public final int component4() {
        return this.downloadSpeed;
    }

    public final int component5() {
        return this.p2pDownloadSpeed;
    }

    public final int component6() {
        return this.cdnDownloadSpeed;
    }

    public final KernelMediaRuntimeInfo copy(int i, int i2, int i3, int i4, int i5, int i6) {
        return new KernelMediaRuntimeInfo(i, i2, i3, i4, i5, i6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KernelMediaRuntimeInfo) {
            KernelMediaRuntimeInfo kernelMediaRuntimeInfo = (KernelMediaRuntimeInfo) obj;
            return this.memCacheSize == kernelMediaRuntimeInfo.memCacheSize && this.diskCacheSize == kernelMediaRuntimeInfo.diskCacheSize && this.dropFrameCount == kernelMediaRuntimeInfo.dropFrameCount && this.downloadSpeed == kernelMediaRuntimeInfo.downloadSpeed && this.p2pDownloadSpeed == kernelMediaRuntimeInfo.p2pDownloadSpeed && this.cdnDownloadSpeed == kernelMediaRuntimeInfo.cdnDownloadSpeed;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.memCacheSize * 31) + this.diskCacheSize) * 31) + this.dropFrameCount) * 31) + this.downloadSpeed) * 31) + this.p2pDownloadSpeed) * 31) + this.cdnDownloadSpeed;
    }

    public String toString() {
        return "KernelMediaRuntimeInfo(memCacheSize=" + this.memCacheSize + ", diskCacheSize=" + this.diskCacheSize + ", dropFrameCount=" + this.dropFrameCount + ", downloadSpeed=" + this.downloadSpeed + ", p2pDownloadSpeed=" + this.p2pDownloadSpeed + ", cdnDownloadSpeed=" + this.cdnDownloadSpeed + ')';
    }

    public KernelMediaRuntimeInfo(int i, int i2, int i3, int i4, int i5, int i6) {
        this.memCacheSize = i;
        this.diskCacheSize = i2;
        this.dropFrameCount = i3;
        this.downloadSpeed = i4;
        this.p2pDownloadSpeed = i5;
        this.cdnDownloadSpeed = i6;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ KernelMediaRuntimeInfo(int i, int i2, int i3, int i4, int i5, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(r13, r1, r2, r3, r4, r12);
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        if ((i7 & 1) != 0) {
            i8 = 0;
        } else {
            i8 = i;
        }
        if ((i7 & 2) != 0) {
            i9 = 0;
        } else {
            i9 = i2;
        }
        if ((i7 & 4) != 0) {
            i10 = 0;
        } else {
            i10 = i3;
        }
        if ((i7 & 8) != 0) {
            i11 = 0;
        } else {
            i11 = i4;
        }
        if ((i7 & 16) != 0) {
            i12 = 0;
        } else {
            i12 = i5;
        }
        if ((i7 & 32) != 0) {
            i13 = 0;
        } else {
            i13 = i6;
        }
    }

    public final int getCdnDownloadSpeed() {
        return this.cdnDownloadSpeed;
    }

    public final int getDiskCacheSize() {
        return this.diskCacheSize;
    }

    public final int getDownloadSpeed() {
        return this.downloadSpeed;
    }

    public final int getDropFrameCount() {
        return this.dropFrameCount;
    }

    public final int getMemCacheSize() {
        return this.memCacheSize;
    }

    public final int getP2pDownloadSpeed() {
        return this.p2pDownloadSpeed;
    }
}
