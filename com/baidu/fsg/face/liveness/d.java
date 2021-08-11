package com.baidu.fsg.face.liveness;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String A = "ABTestEnd";
    public static final String B = "showLivenessConfirm";
    public static final String C = "livnenessConfirmClickContinue";
    public static final String D = "livnenessConfirmClickCancel";
    public static final String E = "livenessAllSupportPreview";
    public static final String F = "livenessMinMaxPreview";
    public static final String G = "livenessIdealPreviewSize";
    public static final String H = "@faceDetect";
    public static final String I = "#videoStartRecog";
    public static final String J = "@videoGetPortrait";
    public static final String K = "videoGuidpageAutoSlide";
    public static final String L = "videoGuidpageManualSlide";
    public static final String M = "videoEnterVideoRecog";
    public static final String N = "videoCameraReady";
    public static final String O = "@videoFaceMatch";
    public static final String P = "videoFirstStepTimeout";
    public static final String Q = "videoSecondStepTimeout";
    public static final String R = "videoCancelVideoRecog";
    public static final String S = "videoStopVideoRecog";
    public static final String T = "videoPreviewCallbackSuccess";
    public static final String U = "videoUploadConfirm";
    public static final String V = "videoUploadCancel";
    public static final String W = "@videoUploadVideo";
    public static final String X = "videoUploadReloadConfirm";
    public static final String Y = "videoUploadRelodCancel";
    public static final String Z = "videoFileException";

    /* renamed from: a  reason: collision with root package name */
    public static final String f40016a = "#startLiveness";
    public static final String aa = "videoFileTooLargeException";
    public static final String ab = "videoMediaRecordIdealBitrate";
    public static final String ac = "videoFileSize";
    public static final String ad = "videoFileUploadTimeout";

    /* renamed from: b  reason: collision with root package name */
    public static final String f40017b = "@queryVideo";

    /* renamed from: c  reason: collision with root package name */
    public static final String f40018c = "enterLiveness";

    /* renamed from: d  reason: collision with root package name */
    public static final String f40019d = "userSwitchSound";

    /* renamed from: e  reason: collision with root package name */
    public static final String f40020e = "@getPortrait";

    /* renamed from: f  reason: collision with root package name */
    public static final String f40021f = "passLiveness";

    /* renamed from: g  reason: collision with root package name */
    public static final String f40022g = "faceDetected";

    /* renamed from: h  reason: collision with root package name */
    public static final String f40023h = "showBlink";

    /* renamed from: i  reason: collision with root package name */
    public static final String f40024i = "detectBlink";

    /* renamed from: j  reason: collision with root package name */
    public static final String f40025j = "showMouth";
    public static final String k = "detectMouth";
    public static final String l = "firstTimeOut";
    public static final String m = "secondTimeOut";
    public static final String n = "cancelLiveness";
    public static final String o = "userCancelLiveness";
    public static final String p = "retrievedImage";
    public static final String q = "@faceMatch";
    public static final String r = "prepareResult";
    public static final String s = "cameraCallback";
    public static final String t = "cameraPreviewsize";
    public static final String u = "idlProcessTime";
    public static final String v = "idlTrackblinkProcessTime";
    public static final String w = "livenessCameraReady";
    public static final String x = "enterVideoVerify";
    public static final String y = "@videoUpload";
    public static final String z = "ABTestStart";
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
