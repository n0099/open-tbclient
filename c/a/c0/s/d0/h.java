package c.a.c0.s.d0;

import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.s.v0.s;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.utils.BdNetUtils;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static String f2376e;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<String> a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<String> f2377b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<c> f2378c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<c> f2379d;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final h a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1979323168, "Lc/a/c0/s/d0/h$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1979323168, "Lc/a/c0/s/d0/h$b;");
                    return;
                }
            }
            a = new h(null);
        }
    }

    /* loaded from: classes.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f2380b;

        public c(h hVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f2380b = str2;
        }
    }

    public /* synthetic */ h(a aVar) {
        this();
    }

    public static h h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (h) invokeV.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? "" : (String) invokeL.objValue;
    }

    public final boolean a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.f2377b == null) {
                m();
            }
            ArrayList<String> arrayList = this.f2377b;
            if (arrayList == null || arrayList.size() <= 0) {
                return false;
            }
            Iterator<String> it = this.f2377b.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next) && str.contains(next)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean b(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? k(4) && c() && a(str) : invokeL.booleanValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f2379d == null) {
                l();
            }
            ArrayList<c> arrayList = this.f2379d;
            if (arrayList == null || arrayList.size() <= 0) {
                return false;
            }
            Iterator<c> it = this.f2379d.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (c.a.c0.s.v0.i.a(next.a, next.f2380b)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean d(int i2, @Nullable String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i2, str)) == null) {
            if (s.m()) {
                return true;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (i2 == 23) {
                if (!b(str)) {
                    return false;
                }
            } else if (!f(i2, str)) {
                return false;
            }
            return BdNetUtils.g() || !BdNetUtils.c();
        }
        return invokeIL.booleanValue;
    }

    public final boolean e(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (this.a == null) {
                o();
            }
            ArrayList<String> arrayList = this.a;
            if (arrayList == null || arrayList.size() <= 0) {
                return false;
            }
            Iterator<String> it = this.a.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next) && str.contains(next)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean f(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i2, str)) == null) ? k(j(i2)) && g() && e(str) : invokeIL.booleanValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f2378c == null) {
                n();
            }
            ArrayList<c> arrayList = this.f2378c;
            if (arrayList == null || arrayList.size() <= 0) {
                return false;
            }
            Iterator<c> it = this.f2378c.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (c.a.c0.s.v0.i.a(next.a, next.f2380b)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final int j(@IntRange(from = 0) int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            if (i2 != 1) {
                if (i2 != 6) {
                    if (i2 != 44) {
                        if (i2 != 22) {
                            return i2 != 23 ? -1 : 4;
                        }
                        return 1;
                    }
                    return 3;
                }
                return 2;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public final boolean k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            if (TextUtils.isEmpty(f2376e)) {
                f2376e = i("video_pcdn_scene_control_android");
            }
            if (TextUtils.isEmpty(f2376e) || i2 >= f2376e.length() || i2 < 0) {
                return i2 >= 0 && i2 < 4;
            }
            return "1".equals(String.valueOf(f2376e.charAt(i2)));
        }
        return invokeI.booleanValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            String f2 = s.f();
            if (TextUtils.isEmpty(f2)) {
                return;
            }
            this.f2379d = q(f2);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            String g2 = s.g();
            if (TextUtils.isEmpty(g2)) {
                return;
            }
            this.f2377b = p(g2);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            String n = s.n();
            if (TextUtils.isEmpty(n)) {
                return;
            }
            this.f2378c = q(n);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            String o = s.o();
            if (TextUtils.isEmpty(o)) {
                return;
            }
            this.a = p(o);
        }
    }

    public final ArrayList<String> p(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    String optString = jSONArray.optString(i2, "");
                    if (!TextUtils.isEmpty(optString)) {
                        arrayList.add(optString);
                    }
                }
            } catch (Exception unused) {
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final ArrayList<c> q(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            ArrayList<c> arrayList = new ArrayList<>();
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        arrayList.add(new c(this, optJSONObject.optString(SmartLaunchStats.UBC_BUSINESS_START_TIME_KEY, ""), optJSONObject.optString("end_time", "")));
                    }
                }
            } catch (Exception unused) {
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
