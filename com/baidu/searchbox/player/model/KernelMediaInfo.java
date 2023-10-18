package com.baidu.searchbox.player.model;

import com.baidu.cyberplayer.sdk.mediainfo.MediaInfo;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003JI\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/baidu/searchbox/player/model/KernelMediaInfo;", "", "videoCodecName", "", "audioCodecName", "videoBitrate", "", "audioBitrate", MediaInfo.DPM_KEY_BITRATE, "videoFrameRate", "(Ljava/lang/String;Ljava/lang/String;IIII)V", "getAudioBitrate", "()I", "getAudioCodecName", "()Ljava/lang/String;", "getBitrate", "getVideoBitrate", "getVideoCodecName", "getVideoFrameRate", "component1", "component2", "component3", "component4", "component5", "component6", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "hashCode", "toString", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class KernelMediaInfo {
    public final int audioBitrate;
    public final String audioCodecName;
    public final int bitrate;
    public final int videoBitrate;
    public final String videoCodecName;
    public final int videoFrameRate;

    public KernelMediaInfo() {
        this(null, null, 0, 0, 0, 0, 63, null);
    }

    public static /* synthetic */ KernelMediaInfo copy$default(KernelMediaInfo kernelMediaInfo, String str, String str2, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = kernelMediaInfo.videoCodecName;
        }
        if ((i5 & 2) != 0) {
            str2 = kernelMediaInfo.audioCodecName;
        }
        String str3 = str2;
        if ((i5 & 4) != 0) {
            i = kernelMediaInfo.videoBitrate;
        }
        int i6 = i;
        if ((i5 & 8) != 0) {
            i2 = kernelMediaInfo.audioBitrate;
        }
        int i7 = i2;
        if ((i5 & 16) != 0) {
            i3 = kernelMediaInfo.bitrate;
        }
        int i8 = i3;
        if ((i5 & 32) != 0) {
            i4 = kernelMediaInfo.videoFrameRate;
        }
        return kernelMediaInfo.copy(str, str3, i6, i7, i8, i4);
    }

    public final String component1() {
        return this.videoCodecName;
    }

    public final String component2() {
        return this.audioCodecName;
    }

    public final int component3() {
        return this.videoBitrate;
    }

    public final int component4() {
        return this.audioBitrate;
    }

    public final int component5() {
        return this.bitrate;
    }

    public final int component6() {
        return this.videoFrameRate;
    }

    public final KernelMediaInfo copy(String str, String str2, int i, int i2, int i3, int i4) {
        return new KernelMediaInfo(str, str2, i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KernelMediaInfo) {
            KernelMediaInfo kernelMediaInfo = (KernelMediaInfo) obj;
            return Intrinsics.areEqual(this.videoCodecName, kernelMediaInfo.videoCodecName) && Intrinsics.areEqual(this.audioCodecName, kernelMediaInfo.audioCodecName) && this.videoBitrate == kernelMediaInfo.videoBitrate && this.audioBitrate == kernelMediaInfo.audioBitrate && this.bitrate == kernelMediaInfo.bitrate && this.videoFrameRate == kernelMediaInfo.videoFrameRate;
        }
        return false;
    }

    public int hashCode() {
        String str = this.videoCodecName;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.audioCodecName;
        return ((((((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.videoBitrate) * 31) + this.audioBitrate) * 31) + this.bitrate) * 31) + this.videoFrameRate;
    }

    public String toString() {
        return "KernelMediaInfo(videoCodecName=" + this.videoCodecName + ", audioCodecName=" + this.audioCodecName + ", videoBitrate=" + this.videoBitrate + ", audioBitrate=" + this.audioBitrate + ", bitrate=" + this.bitrate + ", videoFrameRate=" + this.videoFrameRate + ')';
    }

    public KernelMediaInfo(String str, String str2, int i, int i2, int i3, int i4) {
        this.videoCodecName = str;
        this.audioCodecName = str2;
        this.videoBitrate = i;
        this.audioBitrate = i2;
        this.bitrate = i3;
        this.videoFrameRate = i4;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ KernelMediaInfo(String str, String str2, int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(r12, r0, r1, r2, r3, r11);
        String str3;
        int i6;
        int i7;
        int i8;
        int i9;
        if ((i5 & 1) != 0) {
            str3 = "";
        } else {
            str3 = str;
        }
        String str4 = (i5 & 2) == 0 ? str2 : "";
        if ((i5 & 4) != 0) {
            i6 = 0;
        } else {
            i6 = i;
        }
        if ((i5 & 8) != 0) {
            i7 = 0;
        } else {
            i7 = i2;
        }
        if ((i5 & 16) != 0) {
            i8 = 0;
        } else {
            i8 = i3;
        }
        if ((i5 & 32) != 0) {
            i9 = 0;
        } else {
            i9 = i4;
        }
    }

    public final int getAudioBitrate() {
        return this.audioBitrate;
    }

    public final String getAudioCodecName() {
        return this.audioCodecName;
    }

    public final int getBitrate() {
        return this.bitrate;
    }

    public final int getVideoBitrate() {
        return this.videoBitrate;
    }

    public final String getVideoCodecName() {
        return this.videoCodecName;
    }

    public final int getVideoFrameRate() {
        return this.videoFrameRate;
    }
}
