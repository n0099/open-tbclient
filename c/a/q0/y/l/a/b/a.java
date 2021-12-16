package c.a.q0.y.l.a.b;

import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.k;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final SparseArray<Integer> f11509b;

    /* renamed from: c  reason: collision with root package name */
    public static final SparseArray<String> f11510c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1788413464, "Lc/a/q0/y/l/a/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1788413464, "Lc/a/q0/y/l/a/b/a;");
                return;
            }
        }
        a = k.a;
        SparseArray<Integer> sparseArray = new SparseArray<>(32);
        f11509b = sparseArray;
        sparseArray.put(CyberPlayerManager.MEDIA_INFO_CONNECTED_SERVER, 2001);
        f11509b.put(CyberPlayerManager.MEDIA_INFO_START_PULL_STREAM, 2002);
        f11509b.put(904, 2003);
        f11509b.put(CyberPlayerManager.MEDIA_INFO_START_PLAY, 2004);
        f11509b.put(10004, 2006);
        f11509b.put(701, 2007);
        f11509b.put(10005, 2008);
        f11509b.put(10006, 2009);
        f11509b.put(10007, -2301);
        f11509b.put(10008, 2101);
        f11509b.put(923, 2103);
        f11509b.put(10009, 2105);
        f11509b.put(10010, 2106);
        f11509b.put(10003, 2107);
        f11509b.put(10011, 2108);
        f11509b.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, 3001);
        f11509b.put(3002, 3002);
        f11509b.put(3003, 3003);
        f11509b.put(3004, 3005);
        SparseArray<String> sparseArray2 = new SparseArray<>();
        f11510c = sparseArray2;
        sparseArray2.put(10007, "MEDIA_ERR_NETWORK");
        f11510c.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, "MEDIA_ERR_NETWORK");
        f11510c.put(3002, "MEDIA_ERR_NETWORK");
        f11510c.put(3003, "MEDIA_ERR_NETWORK");
        f11510c.put(3004, "MEDIA_ERR_NETWORK");
        f11510c.put(-2022, "MEDIA_ERR_NETWORK");
        f11510c.put(-111, "MEDIA_ERR_NETWORK");
        f11510c.put(10008, "MEDIA_ERR_DECODE");
    }

    public static String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) ? f11510c.get(i2, "MEDIA_ERR_SRC_NOT_SUPPORTED") : (String) invokeI.objValue;
    }

    public static int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (f11509b.indexOfKey(i2) < 0) {
                if (a) {
                    String str = "Please check sStatusCodeMap already putted correct K,V pair. what: " + i2;
                    return 100;
                }
                return 100;
            }
            return f11509b.get(i2).intValue();
        }
        return invokeI.intValue;
    }

    public static JSONObject c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? d("errMsg", a(i2)) : (JSONObject) invokeI.objValue;
    }

    public static JSONObject d(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, obj)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (obj instanceof Integer) {
                    jSONObject.put(str, ((Integer) obj).intValue());
                } else if (obj instanceof String) {
                    jSONObject.put(str, obj);
                }
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
