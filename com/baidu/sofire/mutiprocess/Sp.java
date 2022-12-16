package com.baidu.sofire.mutiprocess;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sofire.d.a;
import com.baidu.sofire.d.b;
import com.baidu.sofire.k.o;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class Sp {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Sp() {
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

    public static Set<Integer> mainProcessGetSubProcessPids() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            Context context = b.a;
            try {
                Map<Integer, a> map = b.b;
                if (map == null) {
                    return null;
                }
                return map.keySet();
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
                return null;
            }
        }
        return (Set) invokeV.objValue;
    }

    public static int isMainProcess(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            Context context2 = b.a;
            return com.baidu.sofire.k.a.k(context);
        }
        return invokeL.intValue;
    }

    public static Bundle mainProcessCallGetPluginStatus(int i, String str) {
        InterceptResult invokeIL;
        Bundle a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i, str)) == null) {
            Context context = b.a;
            try {
                if (TextUtils.isEmpty(str)) {
                    a = b.a(-201);
                } else {
                    Map<Integer, a> map = b.b;
                    if (map == null) {
                        a = b.a(-200);
                    } else {
                        a aVar = map.get(Integer.valueOf(i));
                        if (aVar == null) {
                            a = b.a(-202);
                        } else {
                            a = aVar.a(str);
                        }
                    }
                }
                return a;
            } catch (RemoteException unused) {
                int i2 = com.baidu.sofire.a.b.a;
                return b.a(-203);
            } catch (Throwable unused2) {
                int i3 = com.baidu.sofire.a.b.a;
                return b.a(-200);
            }
        }
        return (Bundle) invokeIL.objValue;
    }

    public static Bundle mainProcessRequestCallPlugin(int i, Bundle bundle) {
        InterceptResult invokeIL;
        Bundle b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bundle)) == null) {
            Context context = b.a;
            try {
                if (bundle == null) {
                    b = b.a(-201);
                } else {
                    Map<Integer, a> map = b.b;
                    if (map == null) {
                        b = b.a(-200);
                    } else {
                        a aVar = map.get(Integer.valueOf(i));
                        if (aVar == null) {
                            b = b.a(-202);
                        } else {
                            b = aVar.b(bundle);
                        }
                    }
                }
                return b;
            } catch (RemoteException unused) {
                int i2 = com.baidu.sofire.a.b.a;
                return b.a(-203);
            } catch (Throwable unused2) {
                int i3 = com.baidu.sofire.a.b.a;
                try {
                    return b.a(-200);
                } catch (Throwable unused3) {
                    int i4 = com.baidu.sofire.a.b.a;
                    return null;
                }
            }
        }
        return (Bundle) invokeIL.objValue;
    }

    public static Map<Integer, Integer> mainProcessStartAllPlugin(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            Context context = b.a;
            try {
                if (!TextUtils.isEmpty(str) && b.b != null) {
                    HashMap hashMap = new HashMap();
                    for (Integer num : b.b.keySet()) {
                        hashMap.put(num, Integer.valueOf(b.a(num.intValue(), str, true)));
                    }
                    return hashMap;
                }
                return null;
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
                return null;
            }
        }
        return (Map) invokeL.objValue;
    }

    public static int mainProcessStartOrStopPlugin(int i, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)})) == null) {
            return b.a(i, str, z);
        }
        return invokeCommon.intValue;
    }

    public static void registerNeedNotifySubProcess(String str, boolean z) {
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65543, null, str, z) == null) {
            Context context = b.a;
            try {
                if (!TextUtils.isEmpty(str) && (list = b.d) != null) {
                    if (z) {
                        list.add(str);
                    } else {
                        list.remove(str);
                    }
                }
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
        }
    }

    public static Bundle subProcessRequestCallPlugin(Bundle bundle) {
        InterceptResult invokeL;
        Bundle a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bundle)) == null) {
            Context context = b.a;
            try {
                if (context == null) {
                    a = b.a(-204);
                } else if (bundle == null) {
                    a = b.a(-201);
                } else {
                    a = o.a(context, "sub_process_call_main_plugin", bundle, "sofire");
                }
                return a;
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
                return b.a(-200);
            }
        }
        return (Bundle) invokeL.objValue;
    }
}
