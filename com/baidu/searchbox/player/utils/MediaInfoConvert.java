package com.baidu.searchbox.player.utils;

import com.baidu.cyberplayer.sdk.CyberRuntimeInfo;
import com.baidu.cyberplayer.sdk.mediainfo.MediaInfo;
import com.baidu.searchbox.player.model.KernelMediaInfo;
import com.baidu.searchbox.player.model.KernelMediaRuntimeInfo;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0003*\u0004\u0018\u00010\u0004¨\u0006\u0005"}, d2 = {"transform", "Lcom/baidu/searchbox/player/model/KernelMediaRuntimeInfo;", "Lcom/baidu/cyberplayer/sdk/CyberRuntimeInfo;", "Lcom/baidu/searchbox/player/model/KernelMediaInfo;", "Lcom/baidu/cyberplayer/sdk/mediainfo/MediaInfo;", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "MediaInfoConvert")
/* loaded from: classes4.dex */
public final class MediaInfoConvert {
    public static final KernelMediaInfo transform(MediaInfo mediaInfo) {
        if (mediaInfo != null) {
            return new KernelMediaInfo(mediaInfo.getVideoCodecName(), mediaInfo.getAudioCodecName(), mediaInfo.getVideoBitRate(), mediaInfo.getAudioBitRate(), mediaInfo.getBitRate(), mediaInfo.getVideoFrameRate());
        }
        return null;
    }

    public static final KernelMediaRuntimeInfo transform(CyberRuntimeInfo cyberRuntimeInfo) {
        if (cyberRuntimeInfo != null) {
            return new KernelMediaRuntimeInfo(cyberRuntimeInfo.getMemCacheSize(), cyberRuntimeInfo.getDiskCacheSize(), cyberRuntimeInfo.getDropFrameCount(), cyberRuntimeInfo.getDownloadSpeed(), cyberRuntimeInfo.getDownloadSpeedP2P(), cyberRuntimeInfo.getDownloadSpeedCdn());
        }
        return null;
    }
}
