package com.baidu.rtc;

import android.content.Context;
import android.view.Surface;
import com.baidu.rtc.RTCAudioSamples;
import com.baidu.rtc.RtcParameterSettings;
import com.baidu.rtc.internal.BaiduRtcRoomImp;
import java.nio.ByteBuffer;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public abstract class BaiduRtcRoom {
    public static ArrayList<BaiduRtcRoomImp> mInstanceList = new ArrayList<>();

    /* loaded from: classes2.dex */
    public interface BaiduRtcRoomDelegate {
        public static final int RTC_ROOM_EVENTS_DISBAND_ROOM = 112;
        public static final int RTC_ROOM_EVENTS_LIVE_INTRERRUPT = 118;
        public static final int RTC_ROOM_EVENTS_LIVE_PUBLISH_FAIL = 117;
        public static final int RTC_ROOM_EVENTS_LIVE_PUBLISH_SUCCESS = 116;
        public static final int RTC_ROOM_EVENTS_SOMEBODY_DISSHUTUPED = 114;
        public static final int RTC_ROOM_EVENTS_SOMEBODY_KICKOFFED = 115;
        public static final int RTC_ROOM_EVENTS_SOMEBODY_SHUTUPED = 113;
        public static final int RTC_ROOM_EVENT_AVAILABLE_SEND_BITRATE = 200;
        public static final int RTC_ROOM_EVENT_AVAILABLE_SEND_PACKET_LOSS = 201;
        public static final int RTC_ROOM_EVENT_CONNECTION_LOST = 103;
        public static final int RTC_ROOM_EVENT_LOGIN_ERROR = 102;
        public static final int RTC_ROOM_EVENT_LOGIN_OK = 100;
        public static final int RTC_ROOM_EVENT_LOGIN_TIMEOUT = 101;
        public static final int RTC_ROOM_EVENT_ON_USER_ATTRIBUTE = 303;
        public static final int RTC_ROOM_EVENT_ON_USER_JOINED_ROOM = 300;
        public static final int RTC_ROOM_EVENT_ON_USER_LEAVING_ROOM = 301;
        public static final int RTC_ROOM_EVENT_ON_USER_MESSAGE = 302;
        public static final int RTC_ROOM_EVENT_REMOTE_COMING = 104;
        public static final int RTC_ROOM_EVENT_REMOTE_GONE = 107;
        public static final int RTC_ROOM_EVENT_REMOTE_LEAVING = 105;
        public static final int RTC_ROOM_EVENT_REMOTE_RENDERING = 106;
        public static final int RTC_ROOM_EVENT_REMOTE_VIDEO_SIZE_CHANGE = 500;
        public static final int RTC_ROOM_PEER_CONNECTION_ERROR = 10000;
        public static final int RTC_ROOM_SERVER_KEEPALIVE_TIMEOUT_ERROR = 402;
        public static final int RTC_ROOM_SET_EXTERNAL_SURFACE_ERROR = 600;
        public static final int RTC_ROOM_SO_LATER_DOWNLOADING_FAIL = 400;
        public static final int RTC_ROOM_SO_LATER_LOADING_FAIL = 401;
        public static final int RTC_ROOM_USERID_ALREADY_EXIST_ERROR = 436;
        public static final int RTC_STATE_SENDING_MEDIA_FAILED = 2002;
        public static final int RTC_STATE_SENDING_MEDIA_OK = 2001;
        public static final int RTC_STATE_STREAM_DOWN = 2003;
        public static final int RTC_STATE_STREAM_SLOW_LINK_LEVEL0 = 2100;
        public static final int RTC_STATE_STREAM_SLOW_LINK_LEVEL1 = 2101;
        public static final int RTC_STATE_STREAM_SLOW_LINK_LEVEL2 = 2102;
        public static final int RTC_STATE_STREAM_SLOW_LINK_LEVEL3 = 2103;
        public static final int RTC_STATE_STREAM_SLOW_LINK_LEVEL4 = 2104;
        public static final int RTC_STATE_STREAM_SLOW_LINK_LEVEL5 = 2105;
        public static final int RTC_STATE_STREAM_SLOW_LINK_LEVEL6 = 2106;
        public static final int RTC_STATE_STREAM_SLOW_LINK_LEVEL7 = 2107;
        public static final int RTC_STATE_STREAM_SLOW_LINK_LEVEL8 = 2108;
        public static final int RTC_STATE_STREAM_SLOW_LINK_LEVEL9 = 2109;
        public static final int RTC_STATE_STREAM_UP = 2000;

        void onEngineStatisticsInfo(int i);

        void onErrorInfoUpdate(int i);

        void onPeerConnectStateUpdate(int i);

        void onRoomDataMessage(ByteBuffer byteBuffer);

        void onRoomEventUpdate(int i, long j, String str);

        void onStreamInfoUpdate(String[] strArr);
    }

    /* loaded from: classes2.dex */
    public interface BaiduRtcRoomVideoObserver {
        void getInputBuffer(int i, int i2, RtcVideoFormat rtcVideoFormat);

        void onVideoFrame(RTCVideoFrame rTCVideoFrame, long j);
    }

    /* loaded from: classes2.dex */
    public static class RoomInfo {
        public String MediaServerURL = "";
        public String RoomID = "";
    }

    /* loaded from: classes2.dex */
    public enum RtcLiveTransferMode {
        RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION,
        RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION
    }

    /* loaded from: classes2.dex */
    public static class RtcRoomAudioLevel {
        public long userId = 0;
        public String nicName = "";
        public int volumeLevel = 0;
    }

    /* loaded from: classes2.dex */
    public static class RtcRoomUserInfo {
        public String attribute;
        public int role;
        public long userId;
        public String userName;
    }

    /* loaded from: classes2.dex */
    public static class RtcRoomVideoDimension {
        public int videoHeight;
        public int videoRotation;
        public int videoWidth;
    }

    /* loaded from: classes2.dex */
    public enum RtcSoundMode {
        RTC_SOUND_MODE_SPEAKER,
        RTC_SOUND_MODE_EAR
    }

    /* loaded from: classes2.dex */
    public enum RtcVideoFormat {
        RTC_VIDEO_FORMAT_YUV420,
        RTC_VIDEO_FORMAT_RGBA
    }

    /* loaded from: classes2.dex */
    public static class UserList {
        public long[] Listeners;
        public long[] Publishers;

        public UserList(int i, int i2) {
            if (i > 0) {
                this.Publishers = new long[i];
            } else {
                this.Publishers = null;
            }
            if (i2 > 0) {
                this.Listeners = new long[i2];
            } else {
                this.Listeners = null;
            }
        }
    }

    public static RoomInfo getRoomInfofromPlatformServer(String str, String str2, String str3, String str4) {
        return BaiduRtcRoomImp.getRoomInfofromPlatformServer(str, str2, str3, str4);
    }

    public static BaiduRtcRoom initWithAppID(Context context, String str, String str2) {
        BaiduRtcRoom initWithAppID;
        synchronized (BaiduRtcRoom.class) {
            initWithAppID = initWithAppID(context, str, str2, "", false);
        }
        return initWithAppID;
    }

    public static BaiduRtcRoom initWithAppID(Context context, String str, String str2, String str3, boolean z) {
        synchronized (BaiduRtcRoom.class) {
            if (context != null) {
                BaiduRtcRoomImp baiduRtcRoomImp = new BaiduRtcRoomImp(context, str, str2, str3, z);
                mInstanceList.add(baiduRtcRoomImp);
                return baiduRtcRoomImp;
            }
            return null;
        }
    }

    public static void setUseTestEnv(boolean z) {
        BaiduRtcRoomImp.setUseTestEnv(z);
    }

    public static void setVerbose(boolean z) {
        BaiduRtcRoomImp.setVerbose(z);
    }

    public static String version() {
        return BaiduRtcRoomImp.version();
    }

    public abstract void addExternalRenderer(long j, RTCVideoExternalRender rTCVideoExternalRender);

    public abstract void cameraFocusWithPoint(int i, int i2);

    public abstract void changeSurfaceSize(long j, int i, int i2);

    public abstract boolean configLiveServerWithUrl(String str, boolean z, boolean z2, String str2, RtcLiveTransferMode rtcLiveTransferMode);

    public void destroy() {
        synchronized (this) {
            if (mInstanceList.size() > 0) {
                if (this instanceof BaiduRtcRoomImp) {
                    ((BaiduRtcRoomImp) this).doDestroy();
                }
                mInstanceList.remove(this);
                System.gc();
            }
        }
    }

    public abstract void destroyExternalSurface(long j, Surface surface);

    public abstract void disbandRoom();

    public abstract void enableAgc(boolean z);

    public abstract void enableAns(boolean z);

    public abstract void enableAudioMix(boolean z);

    public abstract void enableErrorInfoToServer(boolean z, String str);

    public abstract void enableExternalAudioRecord(boolean z);

    public abstract void enableExternalVideoCapturer(boolean z);

    public abstract void enableLaterLoadSo(String str);

    public abstract void enableStatsToServer(boolean z, String str);

    public abstract void enableStatsToServer(boolean z, boolean z2, String str);

    public abstract RTCAudioSamples.RTCExternalSamplesReadyCallback getExternalAudioSamplesCallback();

    public abstract RtcRoomAudioLevel[] getRemoteAudioLevels();

    public abstract RtcRoomVideoDimension getRemoteVideoDimension(long j);

    public abstract void getUserAttribute(long j);

    public abstract RtcRoomUserInfo[] getUserListOfRoom();

    public abstract boolean isExternalAudioRecord();

    public abstract boolean isSpeakerOn();

    public abstract void kickOffUserWithId(long j);

    public abstract boolean loginRtcRoomWithRoomName(String str, long j, String str2);

    public abstract boolean loginRtcRoomWithRoomName(String str, long j, String str2, boolean z);

    public abstract boolean loginRtcRoomWithRoomName(String str, long j, String str2, boolean z, boolean z2);

    public abstract boolean logoutRtcRoom();

    public abstract void muteCamera(boolean z);

    public abstract void muteMicphone(boolean z);

    public abstract void muteSpeaker(boolean z);

    public abstract void presetLoudSpeaker(boolean z);

    public abstract void publishStreaming();

    public abstract void queryEngineStatisticsInfo();

    public abstract UserList queryUserListOfRoom();

    public abstract void removeExternalRenderer(long j);

    public abstract void sendData(ByteBuffer byteBuffer);

    public abstract void sendMessageToUser(String str, long j);

    public abstract void setAudioRecordDelegate(RTCAudioSamples.RTCSamplesReadyCallback rTCSamplesReadyCallback);

    public abstract void setAuidoSamplesReadyCallback(RTCAudioSamples.RTCSamplesReadyCallback rTCSamplesReadyCallback);

    public void setBaiduRtcAppID(String str, String str2) {
    }

    public abstract boolean setBaiduRtcRoomDelegate(BaiduRtcRoomDelegate baiduRtcRoomDelegate);

    public abstract void setBuffingFactor(float f2);

    public abstract void setCameraID(int i);

    public abstract void setEngineStateStatistics(boolean z);

    public abstract void setExternalSurface(long j, Surface surface);

    public abstract boolean setLiveStreamingMix(boolean z);

    public abstract boolean setLiveStreamingRole(String str);

    public abstract boolean setLiveStreamingURL(String str);

    public abstract void setLocalDisplay(RTCVideoView rTCVideoView);

    public abstract void setMediaServerURL(String str);

    public abstract boolean setMixLayoutPositionIndex(String str);

    public abstract void setMixedAudioSamplesCallback(RTCAudioSamples.RTCMixedSamplesReadyCallback rTCMixedSamplesReadyCallback);

    public abstract void setParamSettings(RtcParameterSettings rtcParameterSettings, RtcParameterSettings.RtcParamSettingType rtcParamSettingType);

    public abstract boolean setRecording(boolean z);

    public abstract void setRedenFactor(float f2);

    public abstract void setRemoteAudioPlayState(boolean z, long j);

    public abstract void setRemoteAudioSamplesCallback(RTCAudioSamples.RTCRemoteSamplesReadyCallback rTCRemoteSamplesReadyCallback);

    public abstract void setRemoteDisplay(RTCVideoView rTCVideoView);

    public abstract void setRemoteDisplay(RTCVideoView rTCVideoView, long j);

    public abstract void setRemoteDisplayGroup(RTCVideoView[] rTCVideoViewArr);

    public abstract void setRemoteVideoPlayState(boolean z, long j);

    public abstract void setSoLaterLoadUrl(String str);

    public abstract void setSoundMod(RtcSoundMode rtcSoundMode);

    public abstract void setUserAttribute(String str);

    public abstract void setVideoCapture(RTCVideoCapture rTCVideoCapture);

    public abstract void setWhitenFactor(float f2);

    public abstract void shutUpUserWithId(long j);

    public abstract void shutUpUserWithId(long j, boolean z);

    public abstract boolean startLiveServerStreaming(String str, boolean z, boolean z2, String str2, RtcLiveTransferMode rtcLiveTransferMode);

    public abstract void startPreview();

    public abstract void startPublish();

    public abstract boolean stopLiveServerStreaming(RtcLiveTransferMode rtcLiveTransferMode);

    public abstract void stopPreview();

    public abstract void stopPublish();

    public abstract void stopSubscribeStreaming(long j);

    public abstract void subscribeStreaming(int i, long j);

    public abstract void switchCamera();

    public abstract void switchLoundSpeaker();

    public abstract void upLoadLog();
}
