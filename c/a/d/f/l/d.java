package c.a.d.f.l;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.l.b;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static d f2957c;

    /* renamed from: d  reason: collision with root package name */
    public static BdAsyncTaskParallel f2958d;

    /* renamed from: e  reason: collision with root package name */
    public static BdAsyncTaskParallel f2959e;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<e<?>> f2960b;

    /* loaded from: classes.dex */
    public class a<T> extends BdAsyncTask<String, Object, T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final int f2961b;

        /* renamed from: c  reason: collision with root package name */
        public int f2962c;

        /* renamed from: d  reason: collision with root package name */
        public int f2963d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f2964e;

        /* renamed from: f  reason: collision with root package name */
        public Object[] f2965f;

        /* renamed from: g  reason: collision with root package name */
        public int f2966g;

        /* renamed from: h  reason: collision with root package name */
        public long f2967h;

        /* renamed from: i  reason: collision with root package name */
        public final Map<c<T>, BdUniqueId> f2968i;

        /* renamed from: j  reason: collision with root package name */
        public final b f2969j;
        public final /* synthetic */ d k;

        public a(d dVar, String str, int i2, int i3, int i4, BdUniqueId bdUniqueId, c<T> cVar, boolean z, Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr2 = {dVar, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), bdUniqueId, cVar, Boolean.valueOf(z), objArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = dVar;
            this.f2962c = 0;
            this.f2963d = 0;
            this.f2964e = false;
            this.f2965f = null;
            this.f2966g = 2;
            this.f2968i = new HashMap();
            this.f2969j = new b();
            this.f2967h = System.currentTimeMillis();
            this.a = str;
            this.f2961b = i2;
            this.f2962c = i3;
            this.f2963d = i4;
            this.f2964e = z;
            this.f2965f = objArr;
            b(cVar, bdUniqueId);
        }

        public void b(c<T> cVar, BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, cVar, bdUniqueId) == null) {
                n.c();
                if (this.f2968i.containsKey(cVar)) {
                    return;
                }
                this.f2968i.put(cVar, bdUniqueId);
            }
        }

        public void c(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
                n.c();
                if (this.f2968i.size() == 0) {
                    cancel();
                    return;
                }
                Iterator<Map.Entry<c<T>, BdUniqueId>> it = this.f2968i.entrySet().iterator();
                while (it.hasNext()) {
                    BdUniqueId value = it.next().getValue();
                    if (value != null && value == bdUniqueId) {
                        it.remove();
                    }
                }
                if (this.f2968i.size() == 0) {
                    cancel();
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            b.a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel();
                b bVar = this.f2969j;
                if (bVar != null && (aVar = bVar.a) != null) {
                    aVar.cancel();
                }
                if (this.f2968i.size() == 0) {
                    return;
                }
                for (Map.Entry<c<T>, BdUniqueId> entry : this.f2968i.entrySet()) {
                    c<T> key = entry.getKey();
                    if (key != null) {
                        key.onCancelled(this.a);
                    }
                }
                this.f2968i.clear();
            }
        }

        public void d(BdUniqueId bdUniqueId, c<T> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, bdUniqueId, cVar) == null) {
                n.c();
                if (this.f2968i.size() == 0) {
                    cancel();
                    return;
                }
                Iterator<Map.Entry<c<T>, BdUniqueId>> it = this.f2968i.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<c<T>, BdUniqueId> next = it.next();
                    c<T> key = next.getKey();
                    BdUniqueId value = next.getValue();
                    if (value != null && value == bdUniqueId && key == cVar) {
                        it.remove();
                    }
                }
                if (this.f2968i.size() == 0) {
                    cancel();
                }
            }
        }

        public void e(c<T> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
                n.c();
                this.f2968i.remove(cVar);
                if (cVar != null) {
                    cVar.onCancelled(this.a);
                }
                if (this.f2968i.size() == 0) {
                    cancel();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public T doInBackground(String... strArr) {
            InterceptResult invokeL;
            T t;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, strArr)) == null) {
                c.a.d.f.l.a.m(true, System.currentTimeMillis() - this.f2967h);
                e eVar = (e) this.k.f2960b.get(this.f2961b);
                if (eVar == null) {
                    return null;
                }
                String key = getKey();
                try {
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    t = null;
                }
                if (isCancelled()) {
                    return null;
                }
                T t2 = (T) eVar.getFromLocal(this.a, key, this.f2962c, this.f2963d, this.f2969j, this.f2965f);
                if (t2 != null) {
                    return t2;
                }
                t = t2;
                if (isCancelled() || this.f2964e) {
                    return null;
                }
                this.f2966g = 3;
                try {
                    return (T) eVar.getFromRemote(this.a, key, this.f2962c, this.f2963d, this.f2969j, this.f2965f);
                } catch (Exception e3) {
                    BdLog.e(e3.getMessage());
                    return t;
                }
            }
            return (T) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            e eVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, t) == null) {
                if (t != null && (eVar = (e) this.k.f2960b.get(this.f2961b)) != null) {
                    eVar.updateMemory(this.k.g(this.a, this.f2961b), t, this.f2962c, this.f2963d, this.f2965f);
                }
                for (Map.Entry<c<T>, BdUniqueId> entry : this.f2968i.entrySet()) {
                    c<T> key = entry.getKey();
                    if (key != null) {
                        key.onLoaded(t, this.a, this.f2966g);
                    }
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, objArr) == null) {
                for (Map.Entry<c<T>, BdUniqueId> entry : this.f2968i.entrySet()) {
                    c<T> key = entry.getKey();
                    if (key != null) {
                        key.onProgressUpdate(objArr);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-502608300, "Lc/a/d/f/l/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-502608300, "Lc/a/d/f/l/d;");
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = BdUniqueId.gen();
        this.f2960b = null;
        BdUniqueId gen = BdUniqueId.gen();
        f2958d = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, gen);
        f2959e = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, gen);
        this.f2960b = new SparseArray<>();
    }

    public static d h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f2957c == null) {
                synchronized (d.class) {
                    if (f2957c == null) {
                        f2957c = new d();
                    }
                }
            }
            return f2957c;
        }
        return (d) invokeV.objValue;
    }

    public void b(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdUniqueId) == null) || (searchAllTask = BdAsyncTask.searchAllTask(this.a)) == null || searchAllTask.size() == 0) {
            return;
        }
        Iterator<BdAsyncTask<?, ?, ?>> it = searchAllTask.iterator();
        while (it.hasNext()) {
            BdAsyncTask<?, ?, ?> next = it.next();
            if (next != null && (next instanceof a)) {
                ((a) next).c(bdUniqueId);
            }
        }
    }

    public void c(String str, int i2) {
        a p;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) || (p = p(g(str, i2))) == null) {
            return;
        }
        p.cancel();
    }

    public <T> void d(String str, int i2, c<T> cVar) {
        a<T> p;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, str, i2, cVar) == null) || (p = p(g(str, i2))) == null) {
            return;
        }
        p.e(cVar);
    }

    public void e(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) || (searchWaitingTask = BdAsyncTask.searchWaitingTask(this.a)) == null || searchWaitingTask.size() == 0) {
            return;
        }
        Iterator<BdAsyncTask<?, ?, ?>> it = searchWaitingTask.iterator();
        while (it.hasNext()) {
            BdAsyncTask<?, ?, ?> next = it.next();
            if (next != null && (next instanceof a)) {
                ((a) next).c(bdUniqueId);
            }
        }
    }

    public <T> void f(BdUniqueId bdUniqueId, c<T> cVar) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, bdUniqueId, cVar) == null) || (searchWaitingTask = BdAsyncTask.searchWaitingTask(this.a)) == null || searchWaitingTask.size() == 0) {
            return;
        }
        Iterator<BdAsyncTask<?, ?, ?>> it = searchWaitingTask.iterator();
        while (it.hasNext()) {
            BdAsyncTask<?, ?, ?> next = it.next();
            if (next != null && (next instanceof a)) {
                ((a) next).d(bdUniqueId, cVar);
            }
        }
    }

    public String g(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i2)) == null) {
            if (str == null) {
                str = "";
            }
            return str + i2;
        }
        return (String) invokeLI.objValue;
    }

    public e i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            SparseArray<e<?>> sparseArray = this.f2960b;
            if (sparseArray == null) {
                return null;
            }
            return sparseArray.get(i2);
        }
        return (e) invokeI.objValue;
    }

    public boolean j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            e<?> eVar = this.f2960b.get(i2);
            if (eVar == null) {
                BdLog.e("Can't find the ResourceLoaderProc with type " + i2);
                return false;
            }
            return eVar.isNeedLoad();
        }
        return invokeI.booleanValue;
    }

    public <T> Object k(String str, int i2, c<T> cVar, int i3, int i4, BdUniqueId bdUniqueId, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, Integer.valueOf(i2), cVar, Integer.valueOf(i3), Integer.valueOf(i4), bdUniqueId, objArr})) == null) ? l(str, i2, cVar, i3, i4, false, bdUniqueId, objArr) : invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> Object l(String str, int i2, c<T> cVar, int i3, int i4, boolean z, BdUniqueId bdUniqueId, Object... objArr) {
        InterceptResult invokeCommon;
        e<?> eVar;
        int i5;
        int i6;
        a<T> p;
        boolean H;
        int asyncTaskPriority;
        Object fromMemory;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{str, Integer.valueOf(i2), cVar, Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), bdUniqueId, objArr})) == null) {
            if (TextUtils.isEmpty(str) || (eVar = this.f2960b.get(i2)) == null) {
                return null;
            }
            if (i3 < 0 || i4 < 0) {
                i5 = 0;
                i6 = 0;
            } else {
                i5 = i3;
                i6 = i4;
            }
            String g2 = g(str, i2);
            try {
                fromMemory = eVar.getFromMemory(g2, str, i5, i6, true, objArr);
            } catch (Exception e2) {
                e = e2;
            }
            if (fromMemory != null) {
                if (cVar != 0) {
                    try {
                        cVar.onLoaded(fromMemory, str, 1);
                    } catch (Exception e3) {
                        e = e3;
                        BdLog.e(e.getMessage());
                        p = p(g2);
                        if (p == null) {
                        }
                        H = l.H();
                        boolean v = l.v();
                        a aVar = new a(this, str, i2, i5, i6, bdUniqueId, cVar, z, objArr);
                        aVar.setKey(g2);
                        aVar.setTag(this.a);
                        asyncTaskPriority = eVar.getAsyncTaskPriority();
                        if (asyncTaskPriority == 0) {
                        }
                        aVar.setPriority(asyncTaskPriority);
                        if (H) {
                        }
                        if (eVar.getAsyncTaskParallel() != null) {
                        }
                        aVar.execute(new String[0]);
                        return null;
                    }
                }
                return fromMemory;
            }
            p = p(g2);
            if (p == null && p.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
                p.b(cVar, bdUniqueId);
                return null;
            }
            H = l.H();
            boolean v2 = l.v();
            a aVar2 = new a(this, str, i2, i5, i6, bdUniqueId, cVar, z, objArr);
            aVar2.setKey(g2);
            aVar2.setTag(this.a);
            asyncTaskPriority = eVar.getAsyncTaskPriority();
            if (asyncTaskPriority == 0) {
                asyncTaskPriority = 1;
            }
            aVar2.setPriority(asyncTaskPriority);
            if (H && !v2) {
                aVar2.setParallel(f2958d);
            } else if (eVar.getAsyncTaskParallel() != null) {
                aVar2.setParallel(f2959e);
            } else {
                aVar2.setParallel(eVar.getAsyncTaskParallel());
            }
            aVar2.execute(new String[0]);
            return null;
        }
        return invokeCommon.objValue;
    }

    public <T> Object m(String str, int i2, c<T> cVar, BdUniqueId bdUniqueId) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048586, this, str, i2, cVar, bdUniqueId)) == null) ? k(str, i2, cVar, 0, 0, bdUniqueId, new Object[0]) : invokeLILL.objValue;
    }

    public Object n(String str, int i2, Object... objArr) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048587, this, str, i2, objArr)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            e<?> eVar = this.f2960b.get(i2);
            if (eVar == null) {
                BdLog.e("Can't find the ResourceLoaderProc with type " + i2);
                return null;
            }
            return eVar.getFromMemory(g(str, i2), str, 0, 0, false, objArr);
        }
        return invokeLIL.objValue;
    }

    public synchronized <T> void o(int i2, e<T> eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, eVar) == null) {
            synchronized (this) {
                if (eVar != null) {
                    if (this.f2960b.get(i2) == null) {
                        this.f2960b.put(i2, eVar);
                    } else {
                        throw new IllegalArgumentException("registerLoaderProc key has been registered. The key is " + i2);
                    }
                }
            }
        }
    }

    public final <T> a<T> p(String str) {
        InterceptResult invokeL;
        BdAsyncTask<?, ?, ?> searchTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (searchTask = BdAsyncTask.searchTask(str)) == null) {
                return null;
            }
            if (!(searchTask instanceof a)) {
                BdLog.e("BdAsyncTask has encountered repeat key");
                return null;
            }
            try {
                return (a) searchTask;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return null;
            }
        }
        return (a) invokeL.objValue;
    }
}
