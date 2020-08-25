package com.baidu.searchbox.publisher.base;
/* loaded from: classes3.dex */
public class PublisherConfig {
    public static final int EXPORT_APP_VERSION = 2;
    public static final int MAIN_APP_VERSION = 1;
    public static volatile int mPublisherVersion = 1;
    private static volatile boolean mIsCloseUnlegoFunc = false;
    private static volatile boolean mIsCloseVideoDraft = false;
    private static volatile boolean mIsCloseCaptureSelectPic = false;
    private static volatile boolean mIsShowCamera = false;
    private static volatile boolean mIsShowVideoTips = true;

    public static int getPublisherVersion() {
        return mPublisherVersion;
    }

    public static void setPublisherVersion(int i) {
        mPublisherVersion = i;
    }

    public static boolean isMainApp() {
        return mPublisherVersion == 1;
    }

    public static boolean getIsCloseUnlegoFunc() {
        return mIsCloseUnlegoFunc;
    }

    public static void setIsCloseUnlegoFunc(boolean z) {
        mIsCloseUnlegoFunc = z;
    }

    public static boolean getIsCloseVideoDraft() {
        return mIsCloseVideoDraft;
    }

    public static void setIsCloseVideoDraft(boolean z) {
        mIsCloseVideoDraft = z;
    }

    public static boolean getIsCloseCaptureSelectPic() {
        return mIsCloseCaptureSelectPic;
    }

    public static void setIsCloseCaptureSelectPic(boolean z) {
        mIsCloseCaptureSelectPic = z;
    }

    public static boolean getIsShowCamera() {
        return mIsShowCamera;
    }

    public static void setIsShowCamera(boolean z) {
        mIsShowCamera = z;
    }

    public static boolean getIsShowVideoTips() {
        return mIsShowVideoTips;
    }

    public static void setIsShowVideoTips(boolean z) {
        mIsShowVideoTips = z;
    }
}
