package com.baidu.idl.facesdk;

import android.content.Context;
import android.content.res.AssetManager;
import com.baidu.idl.authority.IDLAuthorityException;
import com.baidu.idl.facesdk.FaceSDK;
/* loaded from: classes4.dex */
public class FaceTracker {

    /* loaded from: classes4.dex */
    public enum ActionType {
        DELETE,
        REGIST,
        VERIFY,
        RECOGNIZE
    }

    /* loaded from: classes4.dex */
    public enum ErrCode {
        OK,
        PITCH_OUT_OF_RANGE,
        YAW_OUT_OF_RANGE,
        LIVENESS_NOT_SUCCEED,
        POOR_ILLUMINATION,
        NO_FACE_DETECTED,
        DATA_NOT_READY,
        DATA_HIT_ONE,
        DATA_HIT_LAST,
        UNKNOW_TYPE
    }

    private native void tracking(int[] iArr, int i, int i2, int i3, int i4);

    public native void clearTrackedFaces();

    public native FaceVerifyData[] get_FaceVerifyData(int i);

    public native FaceInfo[] get_TrackedFaceInfo();

    public native int prepare_data_for_verify(int[] iArr, int i, int i2, int i3, int i4);

    public native int set_AlignMethodType(int i);

    public native int set_cropFaceEnlargeRatio(float f);

    public native int set_cropFaceSize(int i);

    public native int set_detect_in_video_interval(int i);

    public native int set_eulur_angle_thr(int i, int i2, int i3);

    public native int set_illum_thr(float f);

    public native int set_isFineAlign(boolean z);

    public native int set_isVerifyLive(boolean z);

    public native int set_max_face_num(int i);

    public native int set_max_reg_img_num(int i);

    public native int set_min_face_size(int i);

    public native int set_notFace_thr(float f);

    public native int set_prefetch_reg_img_interval(int i);

    public native int set_track_by_detection_interval(int i);

    public FaceTracker(AssetManager assetManager, Context context, String str, String str2, String str3, FaceSDK.AlignMethodType alignMethodType, FaceSDK.ParsMethodType parsMethodType) {
        FaceSDK.getInstance(assetManager, context, str, str2, str3, alignMethodType, parsMethodType);
        set_AlignMethodType(alignMethodType.ordinal());
    }

    public void track(int[] iArr, int i, int i2, int i3, int i4) {
        if (!FaceSDK.isAuthoritySucceeded()) {
            throw new IDLAuthorityException();
        }
        tracking(iArr, i, i2, i3, i4);
    }

    public ErrCode face_verification(int[] iArr, int i, int i2, FaceSDK.ImgType imgType, ActionType actionType, String str, String str2, String str3) {
        if (!FaceSDK.isAuthoritySucceeded()) {
            throw new IDLAuthorityException();
        }
        int prepare_data_for_verify = prepare_data_for_verify(iArr, i, i2, imgType.ordinal(), actionType.ordinal());
        if (prepare_data_for_verify == ErrCode.OK.ordinal()) {
            return ErrCode.OK;
        }
        if (prepare_data_for_verify == ErrCode.PITCH_OUT_OF_RANGE.ordinal()) {
            return ErrCode.PITCH_OUT_OF_RANGE;
        }
        if (prepare_data_for_verify == ErrCode.YAW_OUT_OF_RANGE.ordinal()) {
            return ErrCode.YAW_OUT_OF_RANGE;
        }
        if (prepare_data_for_verify == ErrCode.LIVENESS_NOT_SUCCEED.ordinal()) {
            return ErrCode.LIVENESS_NOT_SUCCEED;
        }
        if (prepare_data_for_verify == ErrCode.POOR_ILLUMINATION.ordinal()) {
            return ErrCode.POOR_ILLUMINATION;
        }
        if (prepare_data_for_verify == ErrCode.NO_FACE_DETECTED.ordinal()) {
            return ErrCode.NO_FACE_DETECTED;
        }
        if (prepare_data_for_verify == ErrCode.DATA_NOT_READY.ordinal()) {
            return ErrCode.DATA_NOT_READY;
        }
        if (prepare_data_for_verify == ErrCode.DATA_HIT_ONE.ordinal()) {
            return ErrCode.DATA_HIT_ONE;
        }
        if (prepare_data_for_verify == ErrCode.DATA_HIT_LAST.ordinal()) {
            return ErrCode.DATA_HIT_LAST;
        }
        return ErrCode.DATA_NOT_READY;
    }
}
