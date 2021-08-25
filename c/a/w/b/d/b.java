package c.a.w.b.d;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static int f30321a;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            String str = "";
            if ((f30321a & 1) != 0) {
                str = "banner,";
            }
            if ((f30321a & 2) != 0) {
                str = str + "follow,";
            }
            if ((f30321a & 4) != 0) {
                str = str + "tab,";
            }
            if ((f30321a & 8) != 0) {
                str = str + "feed,";
            }
            if (!TextUtils.isEmpty(str)) {
                return str.substring(0, str.length() - 1);
            }
            throw new RuntimeException("Request resource param can not be null");
        }
        return (String) invokeV.objValue;
    }

    public static void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, null, i2) == null) {
            f30321a = i2;
        }
    }
}
