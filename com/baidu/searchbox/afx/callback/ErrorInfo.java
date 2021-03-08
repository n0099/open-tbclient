package com.baidu.searchbox.afx.callback;
/* loaded from: classes4.dex */
public class ErrorInfo {
    public static final String END_TIME_ERROR = "-1";
    public static final int ERROR_DECODE = 16;
    public static final int ERROR_GL = 2;
    public static final int ERROR_PARAMS = 4;
    public static final int ERROR_SOURCE = 1;
    public static final int ERROR_UNKNOW = 8;
    public static final String MEDIAPLAYER_DECODING_ERROR_ERRORMSG = "MediaPlayer解码错误";
    public static final String MEDIAPLAYER_PLAY_SOURCE_ERROR_ERRORMSG = "MediaPlayer播放源出错";
    public static final String OPENGL_ENVIRONMENT_ERROR_ERRORMSG = "OpenGL环境错误";
    public static final String PARAMETER_ERROR_ASSETS_ERRORMSG = "设置播放源（assets文件）时发生错误，assetsFileName: ";
    public static final String PARAMETER_ERROR_ERRORMSG = "参数错误：设置播放源路径为空";
    public static final String PARAMETER_ERROR_SRCFILE_ERRORMSG = "设置播放源（文件）时发生错误，srcFile: ";
    public static final String VIDEO_PLAY_SOURCE_ERROR_ERRORMSG = "VideoPlayer解码错误";
    public Exception mE;
    public String mEndTime;
    public int mErrorCode;
    public String mErrorMsg;
    public String mFilePath;
    public String mGlVersion;
    public String mTimeStamp;

    public ErrorInfo(int i, String str, Exception exc, String str2, String str3, String str4, String str5) {
        this.mErrorCode = i;
        this.mErrorMsg = str;
        this.mE = exc;
        this.mEndTime = str2;
        this.mGlVersion = str3;
        this.mFilePath = str4;
        this.mTimeStamp = str5;
    }
}
