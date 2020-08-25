package com.baidu.cyberplayer.sdk.rtc;

import android.content.Context;
import android.view.Surface;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.d;
import com.baidu.cyberplayer.sdk.rtc.CyberRTCSetting;
import com.baidu.cyberplayer.sdk.rtc.RTCRoomProvider;
@Keep
/* loaded from: classes7.dex */
public class CyberRTCRoom {
    private RTCRoomProvider a;

    public CyberRTCRoom(boolean z) {
        this.a = a.a().a(z);
    }

    public static void setRTCVerbose(boolean z) {
        d.a(z);
    }

    public void changeSurfaceSize(long j, int i, int i2) {
        if (this.a != null) {
            this.a.changeSurfaceSize(j, i, i2);
        }
    }

    public void destroy() {
        if (this.a != null) {
            this.a.destroy();
        }
    }

    public void destroyExternalSurface(long j, Surface surface) {
        if (this.a != null) {
            this.a.destroyExternalSurface(j, surface);
        }
    }

    public void enableAgc(boolean z) {
        if (this.a != null) {
            this.a.enableAgc(z);
        }
    }

    public void enableAns(boolean z) {
        if (this.a != null) {
            this.a.enableAns(z);
        }
    }

    public void enableExternalVideoCapturer(boolean z) {
        if (this.a != null) {
            this.a.enableExternalVideoCapturer(z);
        }
    }

    public RTCRoomProvider getProvider() {
        return this.a;
    }

    public RTCRoomProvider.CyberRtcRoomAudioLevel[] getRemoteAudioLevels() {
        return this.a != null ? this.a.getRemoteAudioLevels() : new RTCRoomProvider.CyberRtcRoomAudioLevel[0];
    }

    public RTCRoomProvider.CyberRtcRoomVideoDimension getRemoteVideoDimension(long j) {
        return this.a != null ? this.a.getRemoteVideoDimension(j) : new RTCRoomProvider.CyberRtcRoomVideoDimension();
    }

    public void getUserAttribute(long j) {
        if (this.a != null) {
            this.a.getUserAttribute(j);
        }
    }

    public RTCRoomProvider.CyberRtcRoomUserInfo[] getUserListOfRoom() {
        return this.a != null ? this.a.getUserListOfRoom() : new RTCRoomProvider.CyberRtcRoomUserInfo[0];
    }

    public synchronized boolean initWithAppID(Context context, String str, String str2, String str3, boolean z) {
        return this.a != null ? this.a.initWithAppID(context, str, str2, str3, z) : false;
    }

    public boolean loginRtcRoomWithRoomName(String str, long j, String str2, boolean z, boolean z2) {
        if (this.a != null) {
            return this.a.loginRtcRoomWithRoomName(str, j, str2, z, z2);
        }
        return false;
    }

    public boolean logoutRtcRoom() {
        if (this.a != null) {
            return this.a.logoutRtcRoom();
        }
        return false;
    }

    public void muteCamera(boolean z) {
        if (this.a != null) {
            this.a.muteCamera(z);
        }
    }

    public void muteMicphone(boolean z) {
        if (this.a != null) {
            this.a.muteMicphone(z);
        }
    }

    public void publishStreaming() {
        if (this.a != null) {
            this.a.publishStreaming();
        }
    }

    public void sendMessageToUser(String str, long j) {
        if (this.a != null) {
            this.a.sendMessageToUser(str, j);
        }
    }

    public void setCyberRTCRoomDelegate(RTCRoomProvider.CyberRtcRoomDelegate cyberRtcRoomDelegate) {
        if (this.a != null) {
            this.a.setCyberRTCRoomDelegate(cyberRtcRoomDelegate);
        }
    }

    public void setExternalSurface(long j, Surface surface) {
        if (this.a != null) {
            this.a.setExternalSurface(j, surface);
        }
    }

    public void setParamSettings(CyberRTCSetting cyberRTCSetting, CyberRTCSetting.CyberRTCSettingType cyberRTCSettingType) {
        if (this.a != null) {
            this.a.setParamSettings(cyberRTCSetting, cyberRTCSettingType);
        }
    }

    public void setRemoteAudioPlayState(boolean z, long j) {
        if (this.a != null) {
            this.a.setRemoteAudioPlayState(z, j);
        }
    }

    public void setRemoteVideoPlayState(boolean z, long j) {
        if (this.a != null) {
            this.a.setRemoteVideoPlayState(z, j);
        }
    }

    public void setSoundMod(RTCRoomProvider.CyberRtcSoundMode cyberRtcSoundMode) {
        if (this.a != null) {
            this.a.setSoundMod(cyberRtcSoundMode);
        }
    }

    public void setUserAttribute(String str) {
        if (this.a != null) {
            this.a.setUserAttribute(str);
        }
    }

    public void startPublish() {
        if (this.a != null) {
            this.a.startPublish();
        }
    }

    public void stopPublish() {
        if (this.a != null) {
            this.a.stopPublish();
        }
    }

    public void stopSubscribeStreaming(long j) {
        if (this.a != null) {
            this.a.stopSubscribeStreaming(j);
        }
    }

    public void subscribeStreaming(int i, long j) {
        if (this.a != null) {
            this.a.subscribeStreaming(i, j);
        }
    }

    public void switchCamera() {
        if (this.a != null) {
            this.a.switchCamera();
        }
    }
}
