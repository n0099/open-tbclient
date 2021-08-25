package c.a.x0.e;

import android.text.TextUtils;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<Integer> f31092a;

    /* renamed from: b  reason: collision with root package name */
    public static String f31093b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(394831060, "Lc/a/x0/e/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(394831060, "Lc/a/x0/e/b;");
                return;
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>(4);
        f31092a = arrayList;
        arrayList.add(10000);
        f31092a.add(10001);
        f31092a.add(10002);
        f31092a.add(Integer.valueOf((int) ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT));
        f31092a.add(-1);
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (TextUtils.isEmpty(f31093b)) {
                f31093b = c.a.x0.e.h.d.a();
            }
            if (TextUtils.isEmpty(f31093b)) {
                return ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT;
            }
            if (f31093b.toUpperCase().contains("HUAWEI")) {
                return 10001;
            }
            if (f31093b.toUpperCase().contains("XIAOMI")) {
                return 10002;
            }
            return ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT;
        }
        return invokeV.intValue;
    }
}
