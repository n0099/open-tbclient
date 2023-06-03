package com.baidu.cyberplayer.sdk.rtc;

import android.content.Context;
import android.view.Surface;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.f;
import com.baidu.cyberplayer.sdk.rtc.CyberRTCAudioSamples;
import com.baidu.cyberplayer.sdk.rtc.CyberRTCSetting;
import com.baidu.cyberplayer.sdk.rtc.RTCRoomProvider;
@Keep
/* loaded from: classes3.dex */
public class CyberRTCRoom {
    public RTCRoomProvider a;

    public CyberRTCRoom(boolean z) {
        this.a = a.a().a(z);
    }

    public static void setRTCVerbose(boolean z) {
        f.a(z);
    }

    public void enableAgc(boolean z) {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            rTCRoomProvider.enableAgc(z);
        }
    }

    public void enableAns(boolean z) {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            rTCRoomProvider.enableAns(z);
        }
    }

    public void enableExternalVideoCapturer(boolean z) {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            rTCRoomProvider.enableExternalVideoCapturer(z);
        }
    }

    public RTCRoomProvider.CyberRtcRoomVideoDimension getRemoteVideoDimension(long j) {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            return rTCRoomProvider.getRemoteVideoDimension(j);
        }
        return new RTCRoomProvider.CyberRtcRoomVideoDimension();
    }

    public void getUserAttribute(long j) {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            rTCRoomProvider.getUserAttribute(j);
        }
    }

    public void kickOffUserWithID(long j) {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            rTCRoomProvider.kickOffUserWithID(j);
        }
    }

    public void muteCamera(boolean z) {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            rTCRoomProvider.muteCamera(z);
        }
    }

    public void muteMicphone(boolean z) {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            rTCRoomProvider.muteMicphone(z);
        }
    }

    public void presetLoudSpeaker(boolean z) {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            rTCRoomProvider.presetLoudSpeaker(z);
        }
    }

    public void setAudioRecordDelegate(CyberRTCAudioSamples.CyberRTCSamplesReadyCallback cyberRTCSamplesReadyCallback) {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            rTCRoomProvider.setAudioRecordDelegate(cyberRTCSamplesReadyCallback);
        }
    }

    public void setCyberRTCRoomDelegate(RTCRoomProvider.CyberRtcRoomDelegate cyberRtcRoomDelegate) {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            rTCRoomProvider.setCyberRTCRoomDelegate(cyberRtcRoomDelegate);
        }
    }

    public void setRemoteDisplay(CyberRTCVideoView cyberRTCVideoView) {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            rTCRoomProvider.setRemoteDisplay(cyberRTCVideoView);
        }
    }

    public void setSoundMod(RTCRoomProvider.CyberRtcSoundMode cyberRtcSoundMode) {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            rTCRoomProvider.setSoundMod(cyberRtcSoundMode);
        }
    }

    public void setUserAttribute(String str) {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            rTCRoomProvider.setUserAttribute(str);
        }
    }

    public void shutUpUserWithID(long j) {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            rTCRoomProvider.shutUpUserWithID(j);
        }
    }

    public void stopSubscribeStreaming(long j) {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            rTCRoomProvider.stopSubscribeStreaming(j);
        }
    }

    public void changeSurfaceSize(long j, int i, int i2) {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            rTCRoomProvider.changeSurfaceSize(j, i, i2);
        }
    }

    public boolean loginRtcRoomWithRoomName(String str, long j, String str2) {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            return rTCRoomProvider.loginRtcRoomWithRoomName(str, j, str2);
        }
        return false;
    }

    public boolean configLiveServerWithUrl(String str, boolean z, boolean z2, String str2, RTCRoomProvider.CyberRtcLiveTransferMode cyberRtcLiveTransferMode) {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            return rTCRoomProvider.configLiveServerWithUrl(str, z, z2, str2, cyberRtcLiveTransferMode);
        }
        return false;
    }

    public synchronized boolean initWithAppID(Context context, String str, String str2, String str3, boolean z) {
        if (this.a != null) {
            return this.a.initWithAppID(context, str, str2, str3, z);
        }
        return false;
    }

    public boolean loginRtcRoomWithRoomName(String str, long j, String str2, boolean z, boolean z2) {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            return rTCRoomProvider.loginRtcRoomWithRoomName(str, j, str2, z, z2);
        }
        return false;
    }

    public void destroy() {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            rTCRoomProvider.destroy();
        }
        this.a = null;
    }

    public void disbandRoom() {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            rTCRoomProvider.disbandRoom();
        }
    }

    public RTCRoomProvider getProvider() {
        return this.a;
    }

    public RTCRoomProvider.CyberRtcRoomAudioLevel[] getRemoteAudioLevels() {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            return rTCRoomProvider.getRemoteAudioLevels();
        }
        return new RTCRoomProvider.CyberRtcRoomAudioLevel[0];
    }

    public RTCRoomProvider.CyberRtcRoomUserInfo[] getUserListOfRoom() {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            return rTCRoomProvider.getUserListOfRoom();
        }
        return new RTCRoomProvider.CyberRtcRoomUserInfo[0];
    }

    public boolean logoutRtcRoom() {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            return rTCRoomProvider.logoutRtcRoom();
        }
        return false;
    }

    public void publishStreaming() {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            rTCRoomProvider.publishStreaming();
        }
    }

    public void startPublish() {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            rTCRoomProvider.startPublish();
        }
    }

    public void stopPublish() {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            rTCRoomProvider.stopPublish();
        }
    }

    public void switchCamera() {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            rTCRoomProvider.switchCamera();
        }
    }

    public void destroyExternalSurface(long j, Surface surface) {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            rTCRoomProvider.destroyExternalSurface(j, surface);
        }
    }

    public void enableStatsToServer(boolean z, String str) {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            rTCRoomProvider.enableStatsToServer(z, str);
        }
    }

    public void sendMessageToUser(String str, long j) {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            rTCRoomProvider.sendMessageToUser(str, j);
        }
    }

    public void setExternalSurface(long j, Surface surface) {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            rTCRoomProvider.setExternalSurface(j, surface);
        }
    }

    public void setParamSettings(CyberRTCSetting cyberRTCSetting, CyberRTCSetting.CyberRTCSettingType cyberRTCSettingType) {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            rTCRoomProvider.setParamSettings(cyberRTCSetting, cyberRTCSettingType);
        }
    }

    public void setRemoteAudioPlayState(boolean z, long j) {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            rTCRoomProvider.setRemoteAudioPlayState(z, j);
        }
    }

    public void setRemoteVideoPlayState(boolean z, long j) {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            rTCRoomProvider.setRemoteVideoPlayState(z, j);
        }
    }

    public void shutUpUserWithID(long j, boolean z) {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            rTCRoomProvider.shutUpUserWithID(j, z);
        }
    }

    public void subscribeStreaming(int i, long j) {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            rTCRoomProvider.subscribeStreaming(i, j);
        }
    }

    public boolean loginRtcRoomWithRoomName(String str, long j, String str2, boolean z) {
        RTCRoomProvider rTCRoomProvider = this.a;
        if (rTCRoomProvider != null) {
            return rTCRoomProvider.loginRtcRoomWithRoomName(str, j, str2, z);
        }
        return false;
    }
}
