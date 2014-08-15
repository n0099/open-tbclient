package com.baidu.channelrtc.medialivesender;

import android.util.Log;
import java.util.Map;
/* loaded from: classes.dex */
public class LiveNativeSender {
    public static final String AUDIOENGINE = "audioels";
    public static final String FFMPEGLIB = "ffmpeg";
    public static final String LIVESENDER = "livesender";
    public static final String TAG = "LiveNativeSender";
    public static String mNativeLibraryPath;
    public static boolean setted = false;
    private OnStatusEventListener mStatusEventListener;
    private OnUserCmdEventListener mUsercommandCallbackEventListner;

    /* loaded from: classes.dex */
    public interface OnCommandResultListener {
        void onCommandCallback(int i, String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnJavaExceptionListener {
        void onJavaException();
    }

    public LiveNativeSender() {
    }

    public LiveNativeSender(OnJavaExceptionListener onJavaExceptionListener) {
    }

    public native void close();

    public void commandCallbackEventListener(String str, int i) {
        if (this.mUsercommandCallbackEventListner != null) {
            String[] strArr = new String[3];
            UserCmdResponse userCmdResponse = new UserCmdResponse();
            try {
                String[] split = str.split("\n", 4);
                userCmdResponse.setCallID(Integer.parseInt(split[1]));
                userCmdResponse.setExtraData(split[2]);
                userCmdResponse.setResponse(split[3]);
            } catch (Exception e) {
                Log.d(TAG, "parse user cmd call back failed, response = " + str);
            }
            if (i == 0) {
                this.mUsercommandCallbackEventListner.onCmdErrorReport(userCmdResponse);
            } else {
                this.mUsercommandCallbackEventListner.onCmdResultReport(userCmdResponse);
            }
        }
    }

    public native int connect(String str);

    public native void disableAECM();

    public native void enableAECM();

    public native void init();

    public native void pause();

    public native int querySignalStrength();

    public native void resume();

    public native int sendUserCmd(String str, String str2);

    public native int sendUserCmdCallback(String str, String str2, OnCommandResultListener onCommandResultListener);

    public native void setAudioParams(int i, int i2);

    public native void setLogLevel(int i);

    public native void setLoginInfo(String str, String str2, String str3, String str4, String str5, String str6);

    public native void setLoginInfoMap(Map<String, String> map);

    public void setOnStatusEventListner(OnStatusEventListener onStatusEventListener) {
        this.mStatusEventListener = onStatusEventListener;
    }

    public void setOnUsercommandCallbackEventListner(OnUserCmdEventListener onUserCmdEventListener) {
        this.mUsercommandCallbackEventListner = onUserCmdEventListener;
    }

    public native void setOptions(String str, String str2);

    public native void shutdown();

    public native void start(String str);

    public void statusEventListener(int i) {
        if (this.mStatusEventListener != null) {
            if (i >= 0) {
                this.mStatusEventListener.onStatusReport(i);
            } else {
                this.mStatusEventListener.onErrorReport(i);
            }
        }
    }

    public native void stop();
}
