package c.d;

import android.os.SystemClock;
import c.d.m0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.fun.ad.sdk.FunAdConfig;
import com.fun.ad.sdk.internal.api.Module;
import com.fun.ad.sdk.internal.api.PidLoaderCreator;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
/* loaded from: classes3.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public interface a {
        void a(o0 o0Var);
    }

    public static <T extends d> T a(Random random, List<T> list, g<T> gVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, random, list, gVar)) == null) {
            if (random == null || list == null || list.isEmpty()) {
                return null;
            }
            LogPrinter.v("Start select for class:%s with size:%d", list.iterator().next().getClass().getSimpleName(), Integer.valueOf(list.size()));
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            T t = null;
            for (int i = 0; i < size; i++) {
                T t2 = list.get(i);
                if (gVar != null) {
                    if (!gVar.a(t2)) {
                        continue;
                    }
                    if (t == null && t2.b() != t.b()) {
                        break;
                    }
                    arrayList.add(t2);
                    t = t2;
                } else {
                    if (!t2.a()) {
                        continue;
                    }
                    if (t == null) {
                    }
                    arrayList.add(t2);
                    t = t2;
                }
            }
            if (arrayList.isEmpty()) {
                LogPrinter.v("No one is selected", new Object[0]);
                return null;
            }
            return (T) arrayList.get(random.nextInt(arrayList.size()));
        }
        return (T) invokeLLL.objValue;
    }

    public static void b(long j, a aVar, Map<String, PidLoaderCreator> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j), aVar, map}) == null) {
            m0.a aVar2 = m0.a;
            aVar2.a = System.currentTimeMillis() - 0;
            aVar2.f23211b = SystemClock.currentThreadTimeMillis() - 0;
            LogPrinter.d("All ssp initialized with %dms consumed.", Long.valueOf(System.currentTimeMillis() - j));
            aVar.a(new o0(map));
        }
    }

    public static void c(String str, String str2, FunAdConfig funAdConfig, Map<String, PidLoaderCreator> map, String str3) {
        Module module;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65538, null, str, str2, funAdConfig, map, str3) == null) {
            try {
                module = (Module) Class.forName(str2).getConstructor(new Class[0]).newInstance(new Object[0]);
                LogPrinter.d("Module for %s created", str2);
            } catch (Exception e2) {
                LogPrinter.e(e2, "Module for %s not found", str2);
                module = null;
            }
            if (module == null) {
                return;
            }
            PidLoaderCreator init = module.init(funAdConfig, str3);
            if (init == null) {
                LogPrinter.e("Module for %s init failed", str);
            } else {
                map.put(str, init);
            }
        }
    }
}
