package com.baidu.searchbox.player.config;

import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/player/config/LoadingTimeConfig;", "", "delayTimeByStart", "", "delayTimeByPlaying", "enable", "", "(IIZ)V", "getDelayTimeByPlaying", "()I", "getDelayTimeByStart", "getEnable", "()Z", "component1", "component2", "component3", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "other", TTDownloadField.TT_HASHCODE, "toString", "", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LoadingTimeConfig {
    public final int delayTimeByPlaying;
    public final int delayTimeByStart;
    public final boolean enable;

    public LoadingTimeConfig() {
        this(0, 0, false, 7, null);
    }

    public static /* synthetic */ LoadingTimeConfig copy$default(LoadingTimeConfig loadingTimeConfig, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = loadingTimeConfig.delayTimeByStart;
        }
        if ((i3 & 2) != 0) {
            i2 = loadingTimeConfig.delayTimeByPlaying;
        }
        if ((i3 & 4) != 0) {
            z = loadingTimeConfig.enable;
        }
        return loadingTimeConfig.copy(i, i2, z);
    }

    public final int component1() {
        return this.delayTimeByStart;
    }

    public final int component2() {
        return this.delayTimeByPlaying;
    }

    public final boolean component3() {
        return this.enable;
    }

    public final LoadingTimeConfig copy(int i, int i2, boolean z) {
        return new LoadingTimeConfig(i, i2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LoadingTimeConfig) {
            LoadingTimeConfig loadingTimeConfig = (LoadingTimeConfig) obj;
            return this.delayTimeByStart == loadingTimeConfig.delayTimeByStart && this.delayTimeByPlaying == loadingTimeConfig.delayTimeByPlaying && this.enable == loadingTimeConfig.enable;
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i = ((this.delayTimeByStart * 31) + this.delayTimeByPlaying) * 31;
        boolean z = this.enable;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return i + i2;
    }

    public String toString() {
        return "LoadingTimeConfig(delayTimeByStart=" + this.delayTimeByStart + ", delayTimeByPlaying=" + this.delayTimeByPlaying + ", enable=" + this.enable + ')';
    }

    public LoadingTimeConfig(int i, int i2, boolean z) {
        this.delayTimeByStart = i;
        this.delayTimeByPlaying = i2;
        this.enable = z;
    }

    public /* synthetic */ LoadingTimeConfig(int i, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? -1 : i, (i3 & 2) != 0 ? 300 : i2, (i3 & 4) != 0 ? false : z);
    }

    public final int getDelayTimeByPlaying() {
        return this.delayTimeByPlaying;
    }

    public final int getDelayTimeByStart() {
        return this.delayTimeByStart;
    }

    public final boolean getEnable() {
        return this.enable;
    }
}
