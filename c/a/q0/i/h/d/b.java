package c.a.q0.i.h.d;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.q0.a.k;
import c.a.q0.a.o2.g.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends c.a.q0.i.e.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f10267c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1119349157, "Lc/a/q0/i/h/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1119349157, "Lc/a/q0/i/h/d/b;");
                return;
            }
        }
        f10267c = k.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b() {
        super("ReservationGame");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.q0.i.e.a
    public c.a.q0.a.u.h.b a(@NonNull JSONObject jSONObject, @NonNull c.a.q0.a.u0.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
            if (jSONObject == null) {
                bVar.onFail(202, "params may be error");
                return null;
            }
            if (f10267c) {
                String str = "params is " + jSONObject.toString();
            }
            String optString = jSONObject.optString("apkId");
            int optInt = jSONObject.optInt("isReservation");
            if (TextUtils.isEmpty(optString)) {
                bVar.onFail(31023, "reservation apk id is empty");
                return null;
            } else if (optInt == 0) {
                bVar.onFail(31024, "reservation status error");
                return null;
            } else {
                String string = h.a().getString("reservation_apk_ids", "");
                if (optInt == 1) {
                    d(string, optString);
                    bVar.a(null);
                } else if (optInt == 2) {
                    if (b(string, optString)) {
                        bVar.a(null);
                    } else {
                        bVar.onFail(31025, "reservation cancel fail");
                    }
                }
                return null;
            }
        }
        return (c.a.q0.a.u.h.b) invokeLL.objValue;
    }

    public final boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(str.split(",")));
            boolean remove = arrayList.remove(str2);
            if (remove) {
                c(arrayList);
            }
            return remove;
        }
        return invokeLL.booleanValue;
    }

    public final void c(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                stringBuffer.append(arrayList.get(i2));
                if (i2 < arrayList.size() - 1) {
                    stringBuffer.append(",");
                }
            }
            h.a().putString("reservation_apk_ids", stringBuffer.toString());
        }
    }

    public final void d(String str, String str2) {
        HashSet hashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            if (TextUtils.isEmpty(str)) {
                hashSet = new HashSet();
            } else {
                hashSet = new HashSet(Arrays.asList(str.split(",")));
            }
            hashSet.add(str2);
            c(new ArrayList<>(hashSet));
        }
    }
}
