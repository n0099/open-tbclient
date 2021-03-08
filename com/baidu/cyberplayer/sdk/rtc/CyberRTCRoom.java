package com.baidu.cyberplayer.sdk.rtc;

import android.content.Context;
import android.view.Surface;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.d;
import com.baidu.cyberplayer.sdk.rtc.CyberRTCAudioSamples;
import com.baidu.cyberplayer.sdk.rtc.CyberRTCSetting;
import com.baidu.cyberplayer.sdk.rtc.RTCRoomProvider;
@Keep
/* loaded from: classes4.dex */
public class CyberRTCRoom {

    /* renamed from: a  reason: collision with root package name */
    private RTCRoomProvider f1458a;

    public CyberRTCRoom(boolean z) {
        this.f1458a = a.a().a(z);
    }

    public static void setRTCVerbose(boolean z) {
        d.a(z);
    }

    public void changeSurfaceSize(long j, int i, int i2) {
        if (this.f1458a != null) {
            this.f1458a.changeSurfaceSize(j, i, i2);
        }
    }

    public boolean configLiveServerWithUrl(String str, boolean z, boolean z2, String str2, RTCRoomProvider.CyberRtcLiveTransferMode cyberRtcLiveTransferMode) {
        if (this.f1458a != null) {
            return this.f1458a.configLiveServerWithUrl(str, z, z2, str2, cyberRtcLiveTransferMode);
        }
        return false;
    }

    public void destroy() {
        if (this.f1458a != null) {
            this.f1458a.destroy();
        }
        this.f1458a = null;
    }

    public void destroyExternalSurface(long j, Surface surface) {
        if (this.f1458a != null) {
            this.f1458a.destroyExternalSurface(j, surface);
        }
    }

    public void disbandRoom() {
        if (this.f1458a != null) {
            this.f1458a.disbandRoom();
        }
    }

    public void enableAgc(boolean z) {
        if (this.f1458a != null) {
            this.f1458a.enableAgc(z);
        }
    }

    public void enableAns(boolean z) {
        if (this.f1458a != null) {
            this.f1458a.enableAns(z);
        }
    }

    public void enableExternalVideoCapturer(boolean z) {
        if (this.f1458a != null) {
            this.f1458a.enableExternalVideoCapturer(z);
        }
    }

    public void enableStatsToServer(boolean z, String str) {
        if (this.f1458a != null) {
            this.f1458a.enableStatsToServer(z, str);
        }
    }

    public RTCRoomProvider getProvider() {
        return this.f1458a;
    }

    public RTCRoomProvider.CyberRtcRoomAudioLevel[] getRemoteAudioLevels() {
        return this.f1458a != null ? this.f1458a.getRemoteAudioLevels() : new RTCRoomProvider.CyberRtcRoomAudioLevel[0];
    }

    public RTCRoomProvider.CyberRtcRoomVideoDimension getRemoteVideoDimension(long j) {
        return this.f1458a != null ? this.f1458a.getRemoteVideoDimension(j) : new RTCRoomProvider.CyberRtcRoomVideoDimension();
    }

    public void getUserAttribute(long j) {
        if (this.f1458a != null) {
            this.f1458a.getUserAttribute(j);
        }
    }

    public RTCRoomProvider.CyberRtcRoomUserInfo[] getUserListOfRoom() {
        return this.f1458a != null ? this.f1458a.getUserListOfRoom() : new RTCRoomProvider.CyberRtcRoomUserInfo[0];
    }

    public synchronized boolean initWithAppID(Context context, String str, String str2, String str3, boolean z) {
        return this.f1458a != null ? this.f1458a.initWithAppID(context, str, str2, str3, z) : false;
    }

    public void kickOffUserWithID(long j) {
        if (this.f1458a != null) {
            this.f1458a.kickOffUserWithID(j);
        }
    }

    public boolean loginRtcRoomWithRoomName(String str, long j, String str2) {
        if (this.f1458a != null) {
            return this.f1458a.loginRtcRoomWithRoomName(str, j, str2);
        }
        return false;
    }

    public boolean loginRtcRoomWithRoomName(String str, long j, String str2, boolean z) {
        if (this.f1458a != null) {
            return this.f1458a.loginRtcRoomWithRoomName(str, j, str2, z);
        }
        return false;
    }

    public boolean loginRtcRoomWithRoomName(String str, long j, String str2, boolean z, boolean z2) {
        if (this.f1458a != null) {
            return this.f1458a.loginRtcRoomWithRoomName(str, j, str2, z, z2);
        }
        return false;
    }

    public boolean logoutRtcRoom() {
        if (this.f1458a != null) {
            return this.f1458a.logoutRtcRoom();
        }
        return false;
    }

    public void muteCamera(boolean z) {
        if (this.f1458a != null) {
            this.f1458a.muteCamera(z);
        }
    }

    public void muteMicphone(boolean z) {
        if (this.f1458a != null) {
            this.f1458a.muteMicphone(z);
        }
    }

    public void presetLoudSpeaker(boolean z) {
        if (this.f1458a != null) {
            this.f1458a.presetLoudSpeaker(z);
        }
    }

    public void publishStreaming() {
        if (this.f1458a != null) {
            this.f1458a.publishStreaming();
        }
    }

    public void sendMessageToUser(String str, long j) {
        if (this.f1458a != null) {
            this.f1458a.sendMessageToUser(str, j);
        }
    }

    public void setAudioRecordDelegate(CyberRTCAudioSamples.CyberRTCSamplesReadyCallback cyberRTCSamplesReadyCallback) {
        if (this.f1458a != null) {
            this.f1458a.setAudioRecordDelegate(cyberRTCSamplesReadyCallback);
        }
    }

    public void setCyberRTCRoomDelegate(RTCRoomProvider.CyberRtcRoomDelegate cyberRtcRoomDelegate) {
        if (this.f1458a != null) {
            this.f1458a.setCyberRTCRoomDelegate(cyberRtcRoomDelegate);
        }
    }

    public void setExternalSurface(long j, Surface surface) {
        if (this.f1458a != null) {
            this.f1458a.setExternalSurface(j, surface);
        }
    }

    public void setParamSettings(CyberRTCSetting cyberRTCSetting, CyberRTCSetting.CyberRTCSettingType cyberRTCSettingType) {
        if (this.f1458a != null) {
            this.f1458a.setParamSettings(cyberRTCSetting, cyberRTCSettingType);
        }
    }

    public void setRemoteAudioPlayState(boolean z, long j) {
        if (this.f1458a != null) {
            this.f1458a.setRemoteAudioPlayState(z, j);
        }
    }

    public void setRemoteDisplay(CyberRTCVideoView cyberRTCVideoView) {
        if (this.f1458a != null) {
            this.f1458a.setRemoteDisplay(cyberRTCVideoView);
        }
    }

    public void setRemoteVideoPlayState(boolean z, long j) {
        if (this.f1458a != null) {
            this.f1458a.setRemoteVideoPlayState(z, j);
        }
    }

    public void setSoundMod(RTCRoomProvider.CyberRtcSoundMode cyberRtcSoundMode) {
        if (this.f1458a != null) {
            this.f1458a.setSoundMod(cyberRtcSoundMode);
        }
    }

    public void setUserAttribute(String str) {
        if (this.f1458a != null) {
            this.f1458a.setUserAttribute(str);
        }
    }

    public void shutUpUserWithID(long j) {
        if (this.f1458a != null) {
            this.f1458a.shutUpUserWithID(j);
        }
    }

    public void shutUpUserWithID(long j, boolean z) {
        if (this.f1458a != null) {
            this.f1458a.shutUpUserWithID(j, z);
        }
    }

    public void startPublish() {
        if (this.f1458a != null) {
            this.f1458a.startPublish();
        }
    }

    public void stopPublish() {
        if (this.f1458a != null) {
            this.f1458a.stopPublish();
        }
    }

    public void stopSubscribeStreaming(long j) {
        if (this.f1458a != null) {
            this.f1458a.stopSubscribeStreaming(j);
        }
    }

    public void subscribeStreaming(int i, long j) {
        if (this.f1458a != null) {
            this.f1458a.subscribeStreaming(i, j);
        }
    }

    public void switchCamera() {
        if (this.f1458a != null) {
            this.f1458a.switchCamera();
        }
    }
}
