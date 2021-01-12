package com.baidu.ala.recorder;
/* loaded from: classes14.dex */
public class AlaLiveRecorderConfig {
    private static FaceUnityCallBack FACE_UNITY_CALLBACK = null;
    private static ILoadLibrary ILOAD_LIBRARY_CALLBACK = null;
    public static final boolean RECORDER_HARDWIRE_ENCODER_USE_SURFACE = true;

    /* loaded from: classes14.dex */
    public interface FaceUnityCallBack {
        byte[] getAuthPackCert();

        byte[] getFaceBeautificationData();

        byte[] getV3Data();
    }

    /* loaded from: classes14.dex */
    public interface ILoadLibrary {
        boolean loadlibrary(String str);
    }

    /* loaded from: classes14.dex */
    public static class Video {
        public static final int H264_ENCODE_FPS1 = 10;
        public static final int H264_ENCODE_FPS2 = 15;
        public static final int H264_ENCODE_GOP1 = 1;
        public static final int H264_ENCODE_GOP2 = 2;
    }

    public static void setFaceUnityCallback(FaceUnityCallBack faceUnityCallBack) {
        FACE_UNITY_CALLBACK = faceUnityCallBack;
    }

    public static FaceUnityCallBack getFaceUnityCallback() {
        return FACE_UNITY_CALLBACK;
    }

    public static void setILoadLibraryCallback(ILoadLibrary iLoadLibrary) {
        ILOAD_LIBRARY_CALLBACK = iLoadLibrary;
    }

    public static ILoadLibrary getILoadLibraryCallback() {
        return ILOAD_LIBRARY_CALLBACK;
    }
}
