package b.a.y0.e;

import android.text.TextUtils;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<Integer> f29974a;

    /* renamed from: b  reason: collision with root package name */
    public static String f29975b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1215681196, "Lb/a/y0/e/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1215681196, "Lb/a/y0/e/b;");
                return;
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>(4);
        f29974a = arrayList;
        arrayList.add(10000);
        f29974a.add(10001);
        f29974a.add(10002);
        f29974a.add(Integer.valueOf((int) ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT));
        f29974a.add(-1);
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (TextUtils.isEmpty(f29975b)) {
                f29975b = b.a.y0.e.h.d.a();
            }
            if (TextUtils.isEmpty(f29975b)) {
                return ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT;
            }
            if (f29975b.toUpperCase().contains("HUAWEI")) {
                return 10001;
            }
            if (f29975b.toUpperCase().contains("XIAOMI")) {
                return 10002;
            }
            return ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT;
        }
        return invokeV.intValue;
    }
}
