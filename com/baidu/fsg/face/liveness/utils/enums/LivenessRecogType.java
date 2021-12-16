package com.baidu.fsg.face.liveness.utils.enums;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes10.dex */
public final class LivenessRecogType {
    public static final /* synthetic */ LivenessRecogType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final LivenessRecogType RECOG_TYPE_AUTHTOKEN;
    public static final LivenessRecogType RECOG_TYPE_BDUSS;
    public static final LivenessRecogType RECOG_TYPE_CERTINFO;
    public static final LivenessRecogType RECOG_TYPE_FACEDETECT;
    public static final LivenessRecogType RECOG_TYPE_OUTER;
    public transient /* synthetic */ FieldHolder $fh;
    public String recogTypeName;
    public int recogTypeNum;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(199234580, "Lcom/baidu/fsg/face/liveness/utils/enums/LivenessRecogType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(199234580, "Lcom/baidu/fsg/face/liveness/utils/enums/LivenessRecogType;");
                return;
            }
        }
        RECOG_TYPE_BDUSS = new LivenessRecogType("RECOG_TYPE_BDUSS", 0, "recog_type_bduss", 1);
        RECOG_TYPE_AUTHTOKEN = new LivenessRecogType("RECOG_TYPE_AUTHTOKEN", 1, "recog_type_authtoken", 2);
        RECOG_TYPE_CERTINFO = new LivenessRecogType("RECOG_TYPE_CERTINFO", 2, "recog_type_certinfo", 3);
        RECOG_TYPE_FACEDETECT = new LivenessRecogType("RECOG_TYPE_FACEDETECT", 3, "recog_type_facedetect", 4);
        LivenessRecogType livenessRecogType = new LivenessRecogType("RECOG_TYPE_OUTER", 4, "recog_type_outer", 5);
        RECOG_TYPE_OUTER = livenessRecogType;
        $VALUES = new LivenessRecogType[]{RECOG_TYPE_BDUSS, RECOG_TYPE_AUTHTOKEN, RECOG_TYPE_CERTINFO, RECOG_TYPE_FACEDETECT, livenessRecogType};
    }

    public LivenessRecogType(String str, int i2, String str2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.recogTypeName = str2;
        this.recogTypeNum = i3;
    }

    public static LivenessRecogType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LivenessRecogType) Enum.valueOf(LivenessRecogType.class, str) : (LivenessRecogType) invokeL.objValue;
    }

    public static LivenessRecogType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LivenessRecogType[]) $VALUES.clone() : (LivenessRecogType[]) invokeV.objValue;
    }

    public String getRecogTypeName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.recogTypeName : (String) invokeV.objValue;
    }

    public int getRecogTypeNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.recogTypeNum : invokeV.intValue;
    }
}
