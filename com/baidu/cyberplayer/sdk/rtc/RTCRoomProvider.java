package com.baidu.cyberplayer.sdk.rtc;

import android.content.Context;
import android.view.Surface;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.rtc.CyberRTCSetting;
@Keep
/* loaded from: classes17.dex */
public abstract class RTCRoomProvider {

    @Keep
    /* loaded from: classes17.dex */
    public static class CyberRtcRoomAudioLevel {
        public String nicName;
        public long userID;
        public int volumeLevel;

        public CyberRtcRoomAudioLevel(long j, String str, int i) {
            this.userID = j;
            this.nicName = str;
            this.volumeLevel = i;
        }
    }

    @Keep
    /* loaded from: classes17.dex */
    public interface CyberRtcRoomDelegate {
        void onErrorInfoUpdate(int i);

        void onPeerConnectStateUpdate(int i);

        void onRoomEventUpdate(int i, long j, String str);
    }

    @Keep
    /* loaded from: classes17.dex */
    public static class CyberRtcRoomUserInfo {
        public String attribute;
        public int role;
        public long userID;
        public String userName;

        public CyberRtcRoomUserInfo(long j, String str, String str2, int i) {
            this.userID = j;
            this.userName = str;
            this.attribute = str2;
            this.role = i;
        }
    }

    @Keep
    /* loaded from: classes17.dex */
    public static class CyberRtcRoomVideoDimension {
        public int videoHeight;
        public int videoRotation;
        public int videoWidth;
    }

    @Keep
    /* loaded from: classes17.dex */
    public enum CyberRtcSoundMode {
        RTC_SOUND_MODE_SPEAKER,
        RTC_SOUND_MODE_EAR
    }

    public abstract void changeSurfaceSize(long j, int i, int i2);

    public abstract void destroy();

    public abstract void destroyExternalSurface(long j, Surface surface);

    public abstract void enableAgc(boolean z);

    public abstract void enableAns(boolean z);

    public abstract void enableExternalVideoCapturer(boolean z);

    public abstract CyberRtcRoomAudioLevel[] getRemoteAudioLevels();

    public abstract CyberRtcRoomVideoDimension getRemoteVideoDimension(long j);

    public abstract void getUserAttribute(long j);

    public abstract CyberRtcRoomUserInfo[] getUserListOfRoom();

    public abstract boolean initWithAppID(Context context, String str, String str2, String str3, boolean z);

    public abstract boolean loginRtcRoomWithRoomName(String str, long j, String str2, boolean z, boolean z2);

    public abstract boolean logoutRtcRoom();

    public abstract void muteCamera(boolean z);

    public abstract void muteMicphone(boolean z);

    public abstract void publishStreaming();

    public abstract void sendMessageToUser(String str, long j);

    public abstract void setCyberRTCRoomDelegate(CyberRtcRoomDelegate cyberRtcRoomDelegate);

    public abstract void setExternalSurface(long j, Surface surface);

    public abstract void setParamSettings(CyberRTCSetting cyberRTCSetting, CyberRTCSetting.CyberRTCSettingType cyberRTCSettingType);

    public abstract void setRemoteAudioPlayState(boolean z, long j);

    public abstract void setRemoteVideoPlayState(boolean z, long j);

    public abstract void setSoundMod(CyberRtcSoundMode cyberRtcSoundMode);

    public abstract void setUserAttribute(String str);

    public abstract void startPublish();

    public abstract void stopPublish();

    public abstract void stopSubscribeStreaming(long j);

    public abstract void subscribeStreaming(int i, long j);

    public abstract void switchCamera();
}
