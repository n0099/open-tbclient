package com.baidu.searchbox.ugc.utils;

import android.text.TextUtils;
import com.baidu.fsg.face.liveness.video.f;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes5.dex */
public class UgcUbcDataKeeper {
    private static String voteSourceFrom = "default";
    private static String naShareSourceFrom = "default";
    private static String naSharePublishType = "9";
    private static String videoUploadVideoMime = f.b;
    private static String videoUploadAudioMime = "audio/mp4a-latm";
    private static int videoIndex = -1;

    public static String getVoteSourceFrom() {
        return voteSourceFrom;
    }

    public static void setVoteSourceFrom(String str) {
        voteSourceFrom = str;
    }

    public static String getNaShareSourceFrom() {
        return naShareSourceFrom;
    }

    public static void setNaShareSourceFrom(String str) {
        naShareSourceFrom = str;
    }

    public static String getNaSharePublishType() {
        return naSharePublishType;
    }

    public static void setNaSharePublishType(String str) {
        naSharePublishType = str;
    }

    public static String getVideoUploadVideoMime() {
        return videoUploadVideoMime;
    }

    public static void setVideoUploadVideoMime(String str) {
        videoUploadVideoMime = str;
    }

    public static String getVideoUploadAudioMime() {
        return videoUploadAudioMime;
    }

    public static void setVideoUploadAudioMime(String str) {
        videoUploadAudioMime = str;
    }

    public static void setVideoFormat(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("video")) {
                setVideoUploadVideoMime(str);
            } else if (str.startsWith(MediaStreamTrack.AUDIO_TRACK_KIND)) {
                setVideoUploadAudioMime(str);
            }
        }
    }

    public static void setVideoIndex(int i) {
        videoIndex = i;
    }
}
