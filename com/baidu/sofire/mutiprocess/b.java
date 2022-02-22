package com.baidu.sofire.mutiprocess;

import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.f;
import com.baidu.sofire.mutiprocess.a;
import com.baidu.sofire.utility.c;
import com.baidu.sofire.utility.w;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkCode;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes11.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static Context a;

    /* renamed from: b  reason: collision with root package name */
    public static Map<Integer, a> f38746b;

    /* renamed from: c  reason: collision with root package name */
    public static Map<Integer, List<String>> f38747c;

    /* renamed from: d  reason: collision with root package name */
    public static List<String> f38748d;

    /* renamed from: e  reason: collision with root package name */
    public static a f38749e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1820019813, "Lcom/baidu/sofire/mutiprocess/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1820019813, "Lcom/baidu/sofire/mutiprocess/b;");
                return;
            }
        }
        f38746b = new HashMap();
        f38747c = new HashMap();
        f38748d = new ArrayList();
        f38749e = new a.AbstractBinderC1885a() { // from class: com.baidu.sofire.mutiprocess.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.sofire.mutiprocess.a
            public final Bundle a(Bundle bundle) throws RemoteException {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, bundle)) == null) ? b.f(bundle) : (Bundle) invokeL.objValue;
            }

            @Override // com.baidu.sofire.mutiprocess.a
            public final Bundle b(Bundle bundle) throws RemoteException {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle)) == null) ? b.d(bundle) : (Bundle) invokeL.objValue;
            }

            @Override // com.baidu.sofire.mutiprocess.a
            public final Bundle a(String str) throws RemoteException {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? b.d(str) : (Bundle) invokeL.objValue;
            }
        };
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? c.a(context) : invokeL.intValue;
    }

    public static Bundle d(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, bundle)) == null) {
            try {
                String string = bundle.getString("bundle_key_method_name");
                String string2 = bundle.getString("bundle_key_plugin_package_name");
                if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string)) {
                    f a2 = f.a();
                    if (a2 == null) {
                        return a(-102);
                    }
                    ApkInfo d2 = a2.d(string2);
                    com.baidu.sofire.core.c a3 = com.baidu.sofire.core.c.a();
                    if (a3 == null) {
                        return a(-105);
                    }
                    Pair<Integer, Object> a4 = a3.a(d2.key, string, new Class[]{Bundle.class}, bundle);
                    if (((Integer) a4.first).intValue() == 0) {
                        if (a4.second instanceof Bundle) {
                            Bundle bundle2 = (Bundle) a4.second;
                            bundle2.putInt("bundle_key_error_code", 0);
                            return bundle2;
                        }
                        return a(-103);
                    }
                    return a(((Integer) a4.first).intValue());
                }
                return a(-101);
            } catch (Throwable unused) {
                c.a();
                try {
                    return a(-100);
                } catch (Throwable unused2) {
                    c.a();
                    return null;
                }
            }
        }
        return (Bundle) invokeL.objValue;
    }

    public static Bundle e(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, bundle)) == null) {
            try {
                bundle.setClassLoader(b.class.getClassLoader());
                int i2 = bundle.getInt("bundle_key_pid");
                BinderHolder binderHolder = (BinderHolder) bundle.getParcelable("bundle_key_binder_holder");
                if (i2 > 0 && binderHolder != null && binderHolder.a != null) {
                    f38746b.put(Integer.valueOf(i2), a.AbstractBinderC1885a.a(binderHolder.a));
                    if (f38748d.size() <= 0) {
                        return a(0);
                    }
                    com.baidu.sofire.core.c a2 = com.baidu.sofire.core.c.a();
                    f a3 = f.a();
                    if (a2 != null && a3 != null) {
                        for (String str : f38748d) {
                            ApkInfo d2 = a3.d(str);
                            if (d2 == null) {
                                return a(0);
                            }
                            a2.a(d2.key, "notifyNewSubProcess", new Class[]{Integer.TYPE}, Integer.valueOf(i2));
                        }
                        return a(0);
                    }
                    return a(0);
                }
                return a(-101);
            } catch (Throwable unused) {
                c.a();
                return null;
            }
        }
        return (Bundle) invokeL.objValue;
    }

    public static Bundle f(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, bundle)) == null) {
            try {
                int i2 = bundle.getInt("bundle_key_ctrl_action");
                if (i2 != 1) {
                    if (i2 != 2) {
                        return a(-106);
                    }
                    return h(bundle);
                }
                return g(bundle);
            } catch (Throwable unused) {
                c.a();
                return null;
            }
        }
        return (Bundle) invokeL.objValue;
    }

    public static Bundle g(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, bundle)) == null) {
            try {
                if (a == null) {
                    return a(-104);
                }
                String string = bundle.getString("bundle_key_plugin_package_name");
                if (TextUtils.isEmpty(string)) {
                    return a(-101);
                }
                com.baidu.sofire.core.c a2 = com.baidu.sofire.core.c.a(a);
                if (a2 == null) {
                    return a(-105);
                }
                if (a2.b(string)) {
                    return a(0);
                }
                return a(-100);
            } catch (Throwable unused) {
                c.a();
                return null;
            }
        }
        return (Bundle) invokeL.objValue;
    }

    public static Bundle h(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, bundle)) == null) {
            try {
                if (a == null) {
                    return a(-104);
                }
                String string = bundle.getString("bundle_key_plugin_package_name");
                if (TextUtils.isEmpty(string)) {
                    return a(-101);
                }
                f a2 = f.a();
                if (a2 == null) {
                    return a(-102);
                }
                if (a2.e(string)) {
                    return a(0);
                }
                return a(-100);
            } catch (Throwable unused) {
                c.a();
                return null;
            }
        }
        return (Bundle) invokeL.objValue;
    }

    public static Bundle a(String str, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, bundle)) == null) {
            if (!TextUtils.isEmpty(str) && str.contains("register_sub_process")) {
                return e(bundle);
            }
            if (!TextUtils.isEmpty(str) && str.contains("call_main_plugin")) {
                return d(bundle);
            }
            return a(-300);
        }
        return (Bundle) invokeLL.objValue;
    }

    public static void b(String str) {
        Set<Map.Entry<Integer, List<String>>> entrySet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, str) == null) {
            try {
                if (f38747c == null || (entrySet = f38747c.entrySet()) == null) {
                    return;
                }
                for (Map.Entry<Integer, List<String>> entry : entrySet) {
                    List<String> value = entry.getValue();
                    if (value != null && value.contains(str)) {
                        a(entry.getKey().intValue(), str, false);
                    }
                }
            } catch (Throwable unused) {
                c.a();
            }
        }
    }

    public static Bundle a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("bundle_key_error_code", i2);
            return bundle;
        }
        return (Bundle) invokeI.objValue;
    }

    public static Set<Integer> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            try {
                if (f38746b == null) {
                    return null;
                }
                return f38746b.keySet();
            } catch (Throwable unused) {
                c.a();
                return null;
            }
        }
        return (Set) invokeV.objValue;
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, null, context) == null) || context == null) {
            return;
        }
        try {
            if (c.b(context, "ampf")) {
                a = context.getApplicationContext();
                Bundle bundle = new Bundle();
                bundle.putInt("bundle_key_pid", Process.myPid());
                bundle.putParcelable("bundle_key_binder_holder", new BinderHolder(f38749e.asBinder()));
                w.a(context, "sub_process_register_sub_process", bundle);
            }
        } catch (Throwable unused) {
            c.a();
        }
    }

    public static int a(int i2, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)})) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return -201;
                }
                if (f38746b == null) {
                    return DeepLinkCode.ERROR_LINK_NOT_MATCH;
                }
                a aVar = f38746b.get(Integer.valueOf(i2));
                if (aVar == null) {
                    return -202;
                }
                Bundle bundle = new Bundle();
                bundle.putInt("bundle_key_ctrl_action", z ? 1 : 2);
                bundle.putString("bundle_key_plugin_package_name", str);
                int i3 = aVar.a(bundle).getInt("bundle_key_error_code", DeepLinkCode.ERROR_LINK_NOT_MATCH);
                if (i3 == 0 && f38747c != null) {
                    List<String> list = f38747c.get(Integer.valueOf(i2));
                    if (list == null) {
                        list = new ArrayList<>();
                        f38747c.put(Integer.valueOf(i2), list);
                    }
                    if (z && !list.contains(str)) {
                        list.add(str);
                    } else if (!z && list.contains(str)) {
                        list.remove(str);
                    }
                }
                return i3;
            } catch (RemoteException unused) {
                c.a();
                return -203;
            } catch (Throwable unused2) {
                c.a();
                return DeepLinkCode.ERROR_LINK_NOT_MATCH;
            }
        }
        return invokeCommon.intValue;
    }

    public static Bundle d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return a(-101);
                }
                f a2 = f.a();
                if (a2 == null) {
                    return a(-102);
                }
                Bundle bundle = new Bundle();
                if (a2.d(str) == null) {
                    bundle.putInt("bundle_key_error_code", 0);
                    bundle.putInt("status", -1);
                    return bundle;
                }
                bundle.putInt("bundle_key_error_code", 0);
                bundle.putInt("status", 1);
                return bundle;
            } catch (Throwable unused) {
                c.a();
                try {
                    return a(-100);
                } catch (Throwable unused2) {
                    c.a();
                    return null;
                }
            }
        }
        return (Bundle) invokeL.objValue;
    }

    public static Map<Integer, Integer> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            try {
                if (TextUtils.isEmpty(str) || f38746b == null) {
                    return null;
                }
                HashMap hashMap = new HashMap();
                for (Integer num : f38746b.keySet()) {
                    hashMap.put(num, Integer.valueOf(a(num.intValue(), str, true)));
                }
                return hashMap;
            } catch (Throwable unused) {
                c.a();
                return null;
            }
        }
        return (Map) invokeL.objValue;
    }

    public static Bundle a(int i2, Bundle bundle) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65541, null, i2, bundle)) == null) {
            try {
                if (bundle == null) {
                    return a(-201);
                }
                if (f38746b == null) {
                    return a((int) DeepLinkCode.ERROR_LINK_NOT_MATCH);
                }
                a aVar = f38746b.get(Integer.valueOf(i2));
                if (aVar == null) {
                    return a(-202);
                }
                return aVar.b(bundle);
            } catch (RemoteException unused) {
                c.a();
                return a(-203);
            } catch (Throwable unused2) {
                c.a();
                try {
                    return a((int) DeepLinkCode.ERROR_LINK_NOT_MATCH);
                } catch (Throwable unused3) {
                    c.a();
                    return null;
                }
            }
        }
        return (Bundle) invokeIL.objValue;
    }

    public static void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65547, null, str, z) == null) {
            try {
                if (TextUtils.isEmpty(str) || f38748d == null) {
                    return;
                }
                if (z) {
                    f38748d.add(str);
                } else {
                    f38748d.remove(str);
                }
            } catch (Throwable unused) {
                c.a();
            }
        }
    }

    public static Bundle a(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65542, null, i2, str)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return a(-201);
                }
                if (f38746b == null) {
                    return a((int) DeepLinkCode.ERROR_LINK_NOT_MATCH);
                }
                a aVar = f38746b.get(Integer.valueOf(i2));
                if (aVar == null) {
                    return a(-202);
                }
                return aVar.a(str);
            } catch (RemoteException unused) {
                c.a();
                return a(-203);
            } catch (Throwable unused2) {
                c.a();
                return a((int) DeepLinkCode.ERROR_LINK_NOT_MATCH);
            }
        }
        return (Bundle) invokeIL.objValue;
    }

    public static Bundle a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bundle)) == null) {
            try {
                if (a == null) {
                    return a(-204);
                }
                if (bundle == null) {
                    return a(-201);
                }
                return w.a(a, "sub_process_call_main_plugin", bundle);
            } catch (Throwable unused) {
                c.a();
                return a((int) DeepLinkCode.ERROR_LINK_NOT_MATCH);
            }
        }
        return (Bundle) invokeL.objValue;
    }
}
