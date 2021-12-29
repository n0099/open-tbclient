package c.a.r0.a.v1;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) ? i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "" : "getPhoneContacts" : "calendar" : "saveImageToPhotosAlbum" : "getRecorderManager" : "camera" : "location" : (String) invokeI.objValue;
    }

    public static String b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65537, null, z)) == null) ? z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0 : (String) invokeZ.objValue;
    }
}
