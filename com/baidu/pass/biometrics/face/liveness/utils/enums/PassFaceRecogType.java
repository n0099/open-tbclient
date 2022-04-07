package com.baidu.pass.biometrics.face.liveness.utils.enums;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class PassFaceRecogType {
    public static /* synthetic */ Interceptable $ic;
    public static final PassFaceRecogType RECOG_TYPE_AUTHTOKEN;
    public static final PassFaceRecogType RECOG_TYPE_BDUSS;
    public static final PassFaceRecogType RECOG_TYPE_CERTINFO;
    public static final PassFaceRecogType RECOG_TYPE_FACEDETECT;
    public static final PassFaceRecogType RECOG_TYPE_FACEIMAGE;
    public static final PassFaceRecogType RECOG_TYPE_OUTER;
    public static final /* synthetic */ PassFaceRecogType[] c;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(150092352, "Lcom/baidu/pass/biometrics/face/liveness/utils/enums/PassFaceRecogType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(150092352, "Lcom/baidu/pass/biometrics/face/liveness/utils/enums/PassFaceRecogType;");
                return;
            }
        }
        RECOG_TYPE_BDUSS = new PassFaceRecogType("RECOG_TYPE_BDUSS", 0, "recog_type_bduss", 1);
        RECOG_TYPE_AUTHTOKEN = new PassFaceRecogType("RECOG_TYPE_AUTHTOKEN", 1, "recog_type_authtoken", 2);
        RECOG_TYPE_CERTINFO = new PassFaceRecogType("RECOG_TYPE_CERTINFO", 2, "recog_type_certinfo", 3);
        RECOG_TYPE_FACEDETECT = new PassFaceRecogType("RECOG_TYPE_FACEDETECT", 3, "recog_type_facedetect", 4);
        RECOG_TYPE_OUTER = new PassFaceRecogType("RECOG_TYPE_OUTER", 4, "recog_type_outer", 5);
        PassFaceRecogType passFaceRecogType = new PassFaceRecogType("RECOG_TYPE_FACEIMAGE", 5, "recog_type_facedimage", 6);
        RECOG_TYPE_FACEIMAGE = passFaceRecogType;
        c = new PassFaceRecogType[]{RECOG_TYPE_BDUSS, RECOG_TYPE_AUTHTOKEN, RECOG_TYPE_CERTINFO, RECOG_TYPE_FACEDETECT, RECOG_TYPE_OUTER, passFaceRecogType};
    }

    public PassFaceRecogType(String str, int i, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str2;
        this.b = i2;
    }

    public static PassFaceRecogType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PassFaceRecogType) Enum.valueOf(PassFaceRecogType.class, str) : (PassFaceRecogType) invokeL.objValue;
    }

    public static PassFaceRecogType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PassFaceRecogType[]) c.clone() : (PassFaceRecogType[]) invokeV.objValue;
    }

    public String getRecogTypeName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public int getRecogTypeNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : invokeV.intValue;
    }
}
