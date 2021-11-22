package b.f;

import b.f.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.fun.ad.sdk.FunAdConfig;
import com.fun.ad.sdk.internal.api.Module;
import com.fun.ad.sdk.internal.api.PidLoaderCreator;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
/* loaded from: classes6.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f31986a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface a {
        void a(i iVar);
    }

    public static <T extends k> T a(Random random, Collection<T> collection, o<T> oVar) {
        InterceptResult invokeLLL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, random, collection, oVar)) == null) {
            if (random == null || collection == null || collection.isEmpty()) {
                return null;
            }
            LogPrinter.v("Start select for class:%s with size:%d", collection.iterator().next().getClass().getSimpleName(), Integer.valueOf(collection.size()));
            ArrayList arrayList = new ArrayList();
            long j = 0;
            long j2 = 0;
            for (T t : collection) {
                if (oVar != null) {
                    if (((b.d) oVar).a(t)) {
                        j2 += t.b();
                        arrayList.add(t);
                    }
                } else if (t.a()) {
                    j2 += t.b();
                    arrayList.add(t);
                }
            }
            LogPrinter.v("%d of them isSelectable.", Integer.valueOf(arrayList.size()));
            if (arrayList.isEmpty()) {
                LogPrinter.v("No one is selected", new Object[0]);
                return null;
            }
            if (arrayList.size() == 1) {
                LogPrinter.v("Select the only one", new Object[0]);
                obj = arrayList.get(0);
            } else if (j2 != 0) {
                Collections.sort(arrayList, new m());
                long nextFloat = j2 > 2147483647L ? random.nextFloat() * ((float) j2) : random.nextInt((int) j2);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    T t2 = (T) it.next();
                    j += t2.b();
                    if (nextFloat <= j) {
                        LogPrinter.v("Select the weight:%d one with sample:%d weightOffset:%d totalWeight:%d", Integer.valueOf(t2.b()), Long.valueOf(nextFloat), Long.valueOf(j), Long.valueOf(j2));
                        return t2;
                    }
                }
                throw new IllegalStateException();
            } else {
                LogPrinter.v("Select the random one by totalWeight:0", new Object[0]);
                obj = arrayList.get(random.nextInt(arrayList.size()));
            }
            return (T) obj;
        }
        return (T) invokeLLL.objValue;
    }

    public static void b(String str, String str2, FunAdConfig funAdConfig, Map<String, PidLoaderCreator> map, String str3) {
        Module module;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, str, str2, funAdConfig, map, str3) == null) {
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
