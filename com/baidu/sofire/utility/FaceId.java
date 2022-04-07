package com.baidu.sofire.utility;

import android.content.Context;
import android.util.Base64;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
/* loaded from: classes2.dex */
public class FaceId {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FACE_AUTH_ID_TYPE_SIMPLE_RECORD = "3";
    public static final String FACE_AUTH_ID_TYPE_SURFACE_LIVENESS = "4";
    public static final String FACE_AUTH_ID_TYPE_TEXTURE_LIVENESS_RECORD = "5";
    public transient /* synthetic */ FieldHolder $fh;

    public FaceId() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getFaceAuthId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            try {
                return Base64.encodeToString((UUID.randomUUID() + "_" + System.currentTimeMillis() + "_" + str).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", "");
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getFaceId(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) ? "" : (String) invokeLL.objValue;
    }
}
