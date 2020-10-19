package com.baidu.rtc;

import android.content.Context;
import com.baidu.rtc.RtcParameterSettings;
import com.baidu.rtc.g;
import java.nio.ByteBuffer;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public abstract class BaiduRtcRoom {
    private static ArrayList<com.baidu.rtc.b.a> bVS = new ArrayList<>();

    /* loaded from: classes9.dex */
    public enum RtcLiveTransferMode {
        RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION,
        RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION
    }

    /* loaded from: classes9.dex */
    public enum RtcSoundMode {
        RTC_SOUND_MODE_SPEAKER,
        RTC_SOUND_MODE_EAR
    }

    /* loaded from: classes9.dex */
    public enum RtcVideoFormat {
        RTC_VIDEO_FORMAT_YUV420,
        RTC_VIDEO_FORMAT_RGBA
    }

    /* loaded from: classes9.dex */
    public interface a {
        void l(ByteBuffer byteBuffer);

        void onErrorInfoUpdate(int i);

        void onPeerConnectStateUpdate(int i);

        void onRoomEventUpdate(int i, long j, String str);
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(l lVar, long j);
    }

    /* loaded from: classes9.dex */
    public static class c {
        public long userId = 0;
        public String nicName = "";
        public int volumeLevel = 0;
    }

    /* loaded from: classes9.dex */
    public static class d {
        public String attribute;
        public long userId;
        public String userName;
    }

    /* loaded from: classes9.dex */
    public static class e {
    }

    public static BaiduRtcRoom a(Context context, String str, String str2, String str3, boolean z) {
        synchronized (BaiduRtcRoom.class) {
            if (context != null) {
                try {
                    com.baidu.rtc.b.a aVar = new com.baidu.rtc.b.a(context, str, str2, str3, z);
                    bVS.add(aVar);
                    return aVar;
                } finally {
                }
            }
            return null;
        }
    }

    public static void du(boolean z) {
        com.baidu.rtc.b.a.du(z);
    }

    public static BaiduRtcRoom p(Context context, String str, String str2) {
        BaiduRtcRoom a2;
        synchronized (BaiduRtcRoom.class) {
            try {
                a2 = a(context, str, str2, "", false);
            } catch (Throwable th) {
                throw th;
            }
        }
        return a2;
    }

    public abstract void Zj();

    public abstract c[] Zk();

    public abstract void a(RtcParameterSettings rtcParameterSettings, RtcParameterSettings.RtcParamSettingType rtcParamSettingType);

    public abstract void a(g.d dVar);

    public abstract void a(i iVar);

    public abstract void a(RTCVideoView[] rTCVideoViewArr);

    public abstract boolean a(a aVar);

    public abstract boolean a(String str, long j, String str2, boolean z);

    public abstract boolean a(String str, boolean z, boolean z2, String str2, RtcLiveTransferMode rtcLiveTransferMode);

    public abstract void aM(long j);

    public void destroy() {
        synchronized (this) {
            if (bVS.size() > 0) {
                if (this instanceof com.baidu.rtc.b.a) {
                    ((com.baidu.rtc.b.a) this).doDestroy();
                }
                bVS.remove(this);
                System.gc();
            }
        }
    }

    public abstract void enableExternalVideoCapturer(boolean z);

    public abstract boolean loginRtcRoomWithRoomName(String str, long j, String str2, boolean z, boolean z2);

    public abstract boolean logoutRtcRoom();

    public abstract void muteMicphone(boolean z);
}
