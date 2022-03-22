package c.a.n0.y.f.a.b;

import android.util.Log;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final SparseArray<Integer> f9542b;

    /* renamed from: c  reason: collision with root package name */
    public static final SparseArray<String> f9543c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(801695067, "Lc/a/n0/y/f/a/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(801695067, "Lc/a/n0/y/f/a/b/a;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
        SparseArray<Integer> sparseArray = new SparseArray<>(32);
        f9542b = sparseArray;
        sparseArray.put(CyberPlayerManager.MEDIA_INFO_CONNECTED_SERVER, 2001);
        f9542b.put(CyberPlayerManager.MEDIA_INFO_START_PULL_STREAM, 2002);
        f9542b.put(904, 2003);
        f9542b.put(CyberPlayerManager.MEDIA_INFO_START_PLAY, 2004);
        f9542b.put(10004, 2006);
        f9542b.put(701, 2007);
        f9542b.put(10005, 2008);
        f9542b.put(10006, 2009);
        f9542b.put(10007, -2301);
        f9542b.put(10008, 2101);
        f9542b.put(923, 2103);
        f9542b.put(10009, 2105);
        f9542b.put(10010, 2106);
        f9542b.put(10003, 2107);
        f9542b.put(CyberPlayerManager.MEDIA_INFO_FIRST_FRAME_DECODE_FAIL_CHANGE_MODE, 2108);
        f9542b.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, 3001);
        f9542b.put(3002, 3002);
        f9542b.put(3003, 3003);
        f9542b.put(3004, 3005);
        SparseArray<String> sparseArray2 = new SparseArray<>();
        f9543c = sparseArray2;
        sparseArray2.put(10007, "MEDIA_ERR_NETWORK");
        f9543c.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, "MEDIA_ERR_NETWORK");
        f9543c.put(3002, "MEDIA_ERR_NETWORK");
        f9543c.put(3003, "MEDIA_ERR_NETWORK");
        f9543c.put(3004, "MEDIA_ERR_NETWORK");
        f9543c.put(-2022, "MEDIA_ERR_NETWORK");
        f9543c.put(-111, "MEDIA_ERR_NETWORK");
        f9543c.put(10008, "MEDIA_ERR_DECODE");
    }

    public static String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? f9543c.get(i, "MEDIA_ERR_SRC_NOT_SUPPORTED") : (String) invokeI.objValue;
    }

    public static int b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (f9542b.indexOfKey(i) < 0) {
                if (a) {
                    Log.e("LiveStatusCodeAdapter", "Please check sStatusCodeMap already putted correct K,V pair. what: " + i);
                    return 100;
                }
                return 100;
            }
            return f9542b.get(i).intValue();
        }
        return invokeI.intValue;
    }

    public static JSONObject c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) ? d(StatConstants.KEY_EXT_ERR_MSG, a(i)) : (JSONObject) invokeI.objValue;
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
