package com.baidu.sofire.d;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.b.i;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.d.a;
import com.baidu.sofire.k.s;
import com.baidu.sofire.mutiprocess.BinderHolder;
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
import org.chromium.net.NetError;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static Context a;
    public static Map<Integer, com.baidu.sofire.d.a> b;
    public static Map<Integer, List<String>> c;
    public static List<String> d;
    public static com.baidu.sofire.d.a e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends a.AbstractBinderC0175a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.baidu.sofire.d.a
        public Bundle a(Bundle bundle) throws RemoteException {
            InterceptResult invokeL;
            Bundle a;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                try {
                    int i = bundle.getInt("bundle_key_ctrl_action");
                    if (i != 1) {
                        if (i != 2) {
                            a = b.a(-106);
                        } else if (b.a == null) {
                            a = b.a(-104);
                        } else {
                            String string = bundle.getString("bundle_key_plugin_package_name");
                            if (TextUtils.isEmpty(string)) {
                                a = b.a(-101);
                            } else {
                                i iVar = i.g;
                                if (iVar == null) {
                                    a = b.a(-102);
                                } else if (iVar.e(string)) {
                                    a = b.a(0);
                                } else {
                                    a = b.a(-100);
                                }
                            }
                        }
                    } else if (b.a == null) {
                        a = b.a(-104);
                    } else {
                        String string2 = bundle.getString("bundle_key_plugin_package_name");
                        if (TextUtils.isEmpty(string2)) {
                            a = b.a(-101);
                        } else {
                            com.baidu.sofire.b.b a2 = com.baidu.sofire.b.b.a(b.a);
                            if (a2 == null) {
                                a = b.a(-105);
                            } else if (a2.a(string2)) {
                                a = b.a(0);
                            } else {
                                a = b.a(-100);
                            }
                        }
                    }
                    return a;
                } catch (Throwable unused) {
                    int i2 = com.baidu.sofire.a.b.a;
                    return null;
                }
            }
            return (Bundle) invokeL.objValue;
        }

        @Override // com.baidu.sofire.d.a
        public Bundle a(String str) throws RemoteException {
            Bundle a;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                try {
                    if (TextUtils.isEmpty(str)) {
                        a = b.a(-101);
                    } else {
                        i iVar = i.g;
                        if (iVar == null) {
                            a = b.a(-102);
                        } else {
                            Bundle bundle = new Bundle();
                            if (iVar.b(str) == null) {
                                bundle.putInt("bundle_key_error_code", 0);
                                bundle.putInt("status", -1);
                                return bundle;
                            }
                            bundle.putInt("bundle_key_error_code", 0);
                            bundle.putInt("status", 1);
                            return bundle;
                        }
                    }
                } catch (Throwable unused) {
                    int i = com.baidu.sofire.a.b.a;
                    try {
                        a = b.a(-100);
                    } catch (Throwable unused2) {
                        int i2 = com.baidu.sofire.a.b.a;
                        return null;
                    }
                }
                return a;
            }
            return (Bundle) invokeL.objValue;
        }

        @Override // com.baidu.sofire.d.a
        public Bundle b(Bundle bundle) throws RemoteException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle)) == null) {
                return b.a(bundle);
            }
            return (Bundle) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2074050355, "Lcom/baidu/sofire/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2074050355, "Lcom/baidu/sofire/d/b;");
                return;
            }
        }
        b = new HashMap();
        c = new HashMap();
        d = new ArrayList();
        e = new a();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int a(int i, String str, boolean z) {
        InterceptResult invokeCommon;
        int i2;
        Map<Integer, List<String>> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)})) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return -201;
                }
                Map<Integer, com.baidu.sofire.d.a> map2 = b;
                if (map2 == null) {
                    return -200;
                }
                com.baidu.sofire.d.a aVar = map2.get(Integer.valueOf(i));
                if (aVar == null) {
                    return -202;
                }
                Bundle bundle = new Bundle();
                if (z) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                bundle.putInt("bundle_key_ctrl_action", i2);
                bundle.putString("bundle_key_plugin_package_name", str);
                int i3 = aVar.a(bundle).getInt("bundle_key_error_code", -200);
                if (i3 == 0 && (map = c) != null) {
                    List<String> list = map.get(Integer.valueOf(i));
                    if (list == null) {
                        list = new ArrayList<>();
                        c.put(Integer.valueOf(i), list);
                    }
                    if (z && !list.contains(str)) {
                        list.add(str);
                    } else if (!z && list.contains(str)) {
                        list.remove(str);
                    }
                }
                return i3;
            } catch (RemoteException unused) {
                int i4 = com.baidu.sofire.a.b.a;
                return -203;
            } catch (Throwable unused2) {
                int i5 = com.baidu.sofire.a.b.a;
                return -200;
            }
        }
        return invokeCommon.intValue;
    }

    public static Bundle a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("bundle_key_error_code", i);
            return bundle;
        }
        return (Bundle) invokeI.objValue;
    }

    public static Bundle a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bundle)) == null) {
            try {
                String string = bundle.getString("bundle_key_method_name");
                String string2 = bundle.getString("bundle_key_plugin_package_name");
                if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string)) {
                    i iVar = i.g;
                    if (iVar == null) {
                        return a(-102);
                    }
                    ApkInfo b2 = iVar.b(string2);
                    com.baidu.sofire.b.b bVar = com.baidu.sofire.b.b.d;
                    if (bVar == null) {
                        return a(-105);
                    }
                    Pair<Integer, Object> a2 = bVar.a(b2.key, string, new Class[]{Bundle.class}, bundle);
                    if (((Integer) a2.first).intValue() == 0) {
                        Object obj = a2.second;
                        if (obj instanceof Bundle) {
                            Bundle bundle2 = (Bundle) obj;
                            bundle2.putInt("bundle_key_error_code", 0);
                            return bundle2;
                        }
                        return a(-103);
                    }
                    return a(((Integer) a2.first).intValue());
                }
                return a(-101);
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
                try {
                    return a(-100);
                } catch (Throwable unused2) {
                    int i2 = com.baidu.sofire.a.b.a;
                    return null;
                }
            }
        }
        return (Bundle) invokeL.objValue;
    }

    public static Bundle a(String str, Bundle bundle) {
        InterceptResult invokeLL;
        IBinder iBinder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, bundle)) == null) {
            if (!TextUtils.isEmpty(str) && str.contains("register_sub_process")) {
                try {
                    bundle.setClassLoader(b.class.getClassLoader());
                    int i = bundle.getInt("bundle_key_pid");
                    BinderHolder binderHolder = (BinderHolder) bundle.getParcelable("bundle_key_binder_holder");
                    if (i > 0 && binderHolder != null && (iBinder = binderHolder.a) != null) {
                        b.put(Integer.valueOf(i), a.AbstractBinderC0175a.a(iBinder));
                        if (d.size() <= 0) {
                            return a(0);
                        }
                        com.baidu.sofire.b.b bVar = com.baidu.sofire.b.b.d;
                        i iVar = i.g;
                        if (bVar != null && iVar != null) {
                            for (String str2 : d) {
                                ApkInfo b2 = iVar.b(str2);
                                if (b2 == null) {
                                    return a(0);
                                }
                                bVar.a(b2.key, "notifyNewSubProcess", new Class[]{Integer.TYPE}, Integer.valueOf(i));
                            }
                            return a(0);
                        }
                        return a(0);
                    }
                    return a(-101);
                } catch (Throwable unused) {
                    int i2 = com.baidu.sofire.a.b.a;
                    return null;
                }
            } else if (!TextUtils.isEmpty(str) && str.contains("call_main_plugin")) {
                return a(bundle);
            } else {
                return a((int) NetError.ERR_INVALID_URL);
            }
        }
        return (Bundle) invokeLL.objValue;
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, context) != null) || context == null) {
            return;
        }
        try {
            if (!com.baidu.sofire.k.b.a(context, "ampf")) {
                return;
            }
            a = context.getApplicationContext();
            Bundle bundle = new Bundle();
            bundle.putInt("bundle_key_pid", Process.myPid());
            bundle.putParcelable("bundle_key_binder_holder", new BinderHolder(e.asBinder()));
            s.a(context, "sub_process_register_sub_process", bundle, "sofire");
        } catch (Throwable unused) {
            int i = com.baidu.sofire.a.b.a;
        }
    }

    public static void a(String str) {
        Set<Map.Entry<Integer, List<String>>> entrySet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            try {
                Map<Integer, List<String>> map = c;
                if (map == null || (entrySet = map.entrySet()) == null) {
                    return;
                }
                for (Map.Entry<Integer, List<String>> entry : entrySet) {
                    List<String> value = entry.getValue();
                    if (value != null && value.contains(str)) {
                        a(entry.getKey().intValue(), str, false);
                    }
                }
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
        }
    }
}
