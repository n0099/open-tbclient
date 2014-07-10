package com.baidu.channelrtc.medialivesender;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.channelrtc.medialivesender.LiveNativeSender;
import java.util.Map;
/* loaded from: classes.dex */
public class LiveSenderControl {
    boolean loadLibrary;
    private LiveNativeSender mNativeSender = new LiveNativeSender();
    private String mPublishToken;

    /* loaded from: classes.dex */
    public class LiveSenderChannel {
        public static final int LAYOUT_MONO = 1;
        public static final int LAYOUT_STEREO = 2;

        public LiveSenderChannel() {
        }
    }

    /* loaded from: classes.dex */
    public class LiveSenderSampleRate {
        public static final int SAMPLINGRATE_11_025 = 11025;
        public static final int SAMPLINGRATE_12 = 12000;
        public static final int SAMPLINGRATE_16 = 16000;
        public static final int SAMPLINGRATE_22_05 = 22050;
        public static final int SAMPLINGRATE_24 = 24000;
        public static final int SAMPLINGRATE_32 = 32000;
        public static final int SAMPLINGRATE_44_1 = 44100;
        public static final int SAMPLINGRATE_48 = 48000;
        public static final int SAMPLINGRATE_64 = 64000;
        public static final int SAMPLINGRATE_8 = 8000;

        public LiveSenderSampleRate() {
        }
    }

    public static boolean checkSDKCap() {
        if (Build.VERSION.SDK_INT >= 10) {
            String upperCase = Build.CPU_ABI.substring(0, 3).toUpperCase();
            return TextUtils.equals(upperCase, "ARM") || TextUtils.equals(upperCase, "X86");
        }
        return false;
    }

    public void close() {
        this.mNativeSender.close();
    }

    public int connect(String str) {
        return this.mNativeSender.connect(str);
    }

    public void disableAECM() {
        this.mNativeSender.disableAECM();
    }

    public void enableAECM() {
        this.mNativeSender.enableAECM();
    }

    public void pause() {
        this.mNativeSender.pause();
    }

    public void prepare() {
        this.mNativeSender.init();
    }

    public int querySignalStrength() {
        return this.mNativeSender.querySignalStrength();
    }

    public void resume() {
        this.mNativeSender.resume();
    }

    public int sendUserCmd(String str, String str2) {
        return this.mNativeSender.sendUserCmd(str, str2);
    }

    public int sendUserCmd(String str, String str2, LiveNativeSender.OnCommandResultListener onCommandResultListener) {
        return this.mNativeSender.sendUserCmdCallback(str, str2, onCommandResultListener);
    }

    public void setAudioParams(int i, int i2) {
        this.mNativeSender.setAudioParams(i, i2);
    }

    public void setEventListener(OnStatusEventListener onStatusEventListener) {
        this.mNativeSender.setOnStatusEventListner(onStatusEventListener);
    }

    public void setLogLevel(int i) {
        this.mNativeSender.setLogLevel(i);
    }

    public void setLoginInfo(String str, String str2, String str3, String str4, String str5, String str6) {
        this.mNativeSender.setLoginInfo(str, str2, str3, str4, str5, str6);
        this.mPublishToken = str2;
    }

    public void setLoginInfo(Map<String, String> map) {
        this.mNativeSender.setLoginInfoMap(map);
        this.mPublishToken = map.get("publishtoken");
    }

    public void setOption(String str, String str2) {
        this.mNativeSender.setOptions(str, str2);
    }

    public void setUserCmdListener(OnUserCmdEventListener onUserCmdEventListener) {
        this.mNativeSender.setOnUsercommandCallbackEventListner(onUserCmdEventListener);
    }

    public void shutdown() {
        this.mNativeSender.shutdown();
    }

    public void start() {
        this.mNativeSender.start(this.mPublishToken);
    }

    public void stop() {
        this.mNativeSender.stop();
    }
}
