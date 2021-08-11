package com.baidu.idl.facesdk;

import android.content.Context;
import android.content.res.AssetManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.idl.authority.IDLAuthorityException;
import com.baidu.idl.facesdk.FaceSDK;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.utils.StatHelper;
import org.apache.http.client.methods.HttpDelete;
/* loaded from: classes5.dex */
public class FaceTracker {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class ActionType {
        public static final /* synthetic */ ActionType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ActionType DELETE;
        public static final ActionType RECOGNIZE;
        public static final ActionType REGIST;
        public static final ActionType VERIFY;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1134497308, "Lcom/baidu/idl/facesdk/FaceTracker$ActionType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1134497308, "Lcom/baidu/idl/facesdk/FaceTracker$ActionType;");
                    return;
                }
            }
            DELETE = new ActionType(HttpDelete.METHOD_NAME, 0);
            REGIST = new ActionType("REGIST", 1);
            VERIFY = new ActionType("VERIFY", 2);
            ActionType actionType = new ActionType("RECOGNIZE", 3);
            RECOGNIZE = actionType;
            $VALUES = new ActionType[]{DELETE, REGIST, VERIFY, actionType};
        }

        public ActionType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ActionType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ActionType) Enum.valueOf(ActionType.class, str) : (ActionType) invokeL.objValue;
        }

        public static ActionType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ActionType[]) $VALUES.clone() : (ActionType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class ErrCode {
        public static final /* synthetic */ ErrCode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ErrCode DATA_HIT_LAST;
        public static final ErrCode DATA_HIT_ONE;
        public static final ErrCode DATA_NOT_READY;
        public static final ErrCode LIVENESS_NOT_SUCCEED;
        public static final ErrCode NO_FACE_DETECTED;
        public static final ErrCode OK;
        public static final ErrCode PITCH_OUT_OF_RANGE;
        public static final ErrCode POOR_ILLUMINATION;
        public static final ErrCode UNKNOW_TYPE;
        public static final ErrCode YAW_OUT_OF_RANGE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2042926608, "Lcom/baidu/idl/facesdk/FaceTracker$ErrCode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2042926608, "Lcom/baidu/idl/facesdk/FaceTracker$ErrCode;");
                    return;
                }
            }
            OK = new ErrCode(StatHelper.SENSOR_OK, 0);
            PITCH_OUT_OF_RANGE = new ErrCode("PITCH_OUT_OF_RANGE", 1);
            YAW_OUT_OF_RANGE = new ErrCode("YAW_OUT_OF_RANGE", 2);
            LIVENESS_NOT_SUCCEED = new ErrCode("LIVENESS_NOT_SUCCEED", 3);
            POOR_ILLUMINATION = new ErrCode("POOR_ILLUMINATION", 4);
            NO_FACE_DETECTED = new ErrCode("NO_FACE_DETECTED", 5);
            DATA_NOT_READY = new ErrCode("DATA_NOT_READY", 6);
            DATA_HIT_ONE = new ErrCode("DATA_HIT_ONE", 7);
            DATA_HIT_LAST = new ErrCode("DATA_HIT_LAST", 8);
            ErrCode errCode = new ErrCode("UNKNOW_TYPE", 9);
            UNKNOW_TYPE = errCode;
            $VALUES = new ErrCode[]{OK, PITCH_OUT_OF_RANGE, YAW_OUT_OF_RANGE, LIVENESS_NOT_SUCCEED, POOR_ILLUMINATION, NO_FACE_DETECTED, DATA_NOT_READY, DATA_HIT_ONE, DATA_HIT_LAST, errCode};
        }

        public ErrCode(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ErrCode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ErrCode) Enum.valueOf(ErrCode.class, str) : (ErrCode) invokeL.objValue;
        }

        public static ErrCode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ErrCode[]) $VALUES.clone() : (ErrCode[]) invokeV.objValue;
        }
    }

    public FaceTracker(AssetManager assetManager, Context context, String str, String str2, String str3, FaceSDK.AlignMethodType alignMethodType, FaceSDK.ParsMethodType parsMethodType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {assetManager, context, str, str2, str3, alignMethodType, parsMethodType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        FaceSDK.getInstance(assetManager, context, str, str2, str3, alignMethodType, parsMethodType);
        set_AlignMethodType(alignMethodType.ordinal());
    }

    private native void tracking(int[] iArr, int i2, int i3, int i4, int i5);

    public native void clearTrackedFaces();

    public ErrCode face_verification(int[] iArr, int i2, int i3, FaceSDK.ImgType imgType, ActionType actionType, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{iArr, Integer.valueOf(i2), Integer.valueOf(i3), imgType, actionType, str, str2, str3})) == null) {
            if (FaceSDK.isAuthoritySucceeded()) {
                int prepare_data_for_verify = prepare_data_for_verify(iArr, i2, i3, imgType.ordinal(), actionType.ordinal());
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
            throw new IDLAuthorityException();
        }
        return (ErrCode) invokeCommon.objValue;
    }

    public native FaceVerifyData[] get_FaceVerifyData(int i2);

    public native FaceInfo[] get_TrackedFaceInfo();

    public native int prepare_data_for_verify(int[] iArr, int i2, int i3, int i4, int i5);

    public native int set_AlignMethodType(int i2);

    public native int set_cropFaceEnlargeRatio(float f2);

    public native int set_cropFaceSize(int i2);

    public native int set_detect_in_video_interval(int i2);

    public native int set_eulur_angle_thr(int i2, int i3, int i4);

    public native int set_illum_thr(float f2);

    public native int set_isFineAlign(boolean z);

    public native int set_isVerifyLive(boolean z);

    public native int set_max_face_num(int i2);

    public native int set_max_reg_img_num(int i2);

    public native int set_min_face_size(int i2);

    public native int set_notFace_thr(float f2);

    public native int set_prefetch_reg_img_interval(int i2);

    public native int set_track_by_detection_interval(int i2);

    public void track(int[] iArr, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{iArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            if (FaceSDK.isAuthoritySucceeded()) {
                tracking(iArr, i2, i3, i4, i5);
                return;
            }
            throw new IDLAuthorityException();
        }
    }
}
