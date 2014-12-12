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
    private boolean loadLibraryfailed;
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
        loadLibrary();
    }

    public LiveNativeSender(OnJavaExceptionListener onJavaExceptionListener) {
        loadLibrary();
        if (this.loadLibraryfailed) {
            onJavaExceptionListener.onJavaException();
        }
    }

    private void loadLibrary() {
        this.loadLibraryfailed = false;
    }

    public static void setLibraryPath(String str) {
        mNativeLibraryPath = str;
        setted = true;
    }

    public void LogInfoListener(String str) {
        this.mStatusEventListener.onLogReport(str);
    }

    public native void close();

    public void commandCallbackEventListener(String str, int i) {
        if (this.mUsercommandCallbackEventListner != null) {
            UserCmdResponse userCmdResponse = new UserCmdResponse();
            try {
                String[] split = str.split("\n");
                userCmdResponse.setCallID(Integer.parseInt(split[1]));
                userCmdResponse.setExtraData(split[2]);
                userCmdResponse.setResponse(split[3]);
                String str2 = "";
                for (int i2 = 3; i2 < split.length; i2++) {
                    str2 = str2 + split[i2];
                }
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

    public native void disableQOS();

    public native void enableAEC(boolean z);

    public native void enableAECM();

    public native void enableAECM(boolean z);

    public native void enableAGC(boolean z);

    public native void enableNS(boolean z);

    public native void enableQOS();

    public native void enableVAD(boolean z);

    public native void init();

    public boolean isLoadLibraryfailed() {
        return this.loadLibraryfailed;
    }

    public native void pause();

    public native void pausePub(int i);

    public native int querySignalStrength();

    public native void resume();

    public native void resumePub(int i);

    public native int sendUserCmd(String str, String str2);

    public native int sendUserCmdCallback(String str, String str2, OnCommandResultListener onCommandResultListener);

    public native void setAudioParams(int i, int i2);

    public native void setLogLevel(int i);

    public native void setLogType(int i);

    public native void setLoginInfo(String str, String str2, String str3, String str4, String str5, String str6);

    public native void setLoginInfoMap(Map<String, String> map);

    public void setOnStatusEventListner(OnStatusEventListener onStatusEventListener) {
        this.mStatusEventListener = onStatusEventListener;
    }

    public void setOnUsercommandCallbackEventListner(OnUserCmdEventListener onUserCmdEventListener) {
        this.mUsercommandCallbackEventListner = onUserCmdEventListener;
    }

    public native void setOptions(String str, String str2);

    public native void setRecordMode(int i);

    public native void setVideoParams(int i, int i2, int i3, int i4);

    public native void shutdown();

    public native void startPub(String str, int i);

    public void statusEventListener(int i) {
        if (this.mStatusEventListener != null) {
            if (i >= 0) {
                this.mStatusEventListener.onStatusReport(i);
            } else {
                this.mStatusEventListener.onErrorReport(i);
            }
        }
    }

    public native void stopPub(int i);
}
