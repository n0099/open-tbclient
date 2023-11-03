package com.baidu.adp.lib.resourceLoader;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.qb;
import com.baidu.tieba.rb;
import com.baidu.tieba.sb;
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
public class BdResourceLoader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int RESOURCE_FROM_LOCAL = 2;
    public static final int RESOURCE_FROM_MEMORY = 1;
    public static final int RESOURCE_FROM_REMOTE = 3;
    public static BdAsyncTaskParallel mBdAsyncTaskSerial;
    public static BdAsyncTaskParallel mBdAsyncTaskThree;
    public static BdResourceLoader sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray<sb<?>> mLoaderProcs;
    public final BdUniqueId resourceTag;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1651317628, "Lcom/baidu/adp/lib/resourceLoader/BdResourceLoader;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1651317628, "Lcom/baidu/adp/lib/resourceLoader/BdResourceLoader;");
        }
    }

    /* loaded from: classes.dex */
    public class a<T> extends BdAsyncTask<String, Object, T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final int b;
        public int c;
        public int d;
        public boolean e;
        public Object[] f;
        public int g;
        public long h;
        public final Map<BdResourceCallback<T>, BdUniqueId> i;
        public final rb j;
        public final /* synthetic */ BdResourceLoader k;

        public a(BdResourceLoader bdResourceLoader, String str, int i, int i2, int i3, BdUniqueId bdUniqueId, BdResourceCallback<T> bdResourceCallback, boolean z, Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr2 = {bdResourceLoader, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), bdUniqueId, bdResourceCallback, Boolean.valueOf(z), objArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = bdResourceLoader;
            this.c = 0;
            this.d = 0;
            this.e = false;
            this.f = null;
            this.g = 2;
            this.i = new HashMap();
            this.j = new rb();
            this.h = System.currentTimeMillis();
            this.a = str;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = z;
            this.f = objArr;
            b(bdResourceCallback, bdUniqueId);
        }

        public void b(BdResourceCallback<T> bdResourceCallback, BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, bdResourceCallback, bdUniqueId) == null) {
                BdUtilHelper.checkMainThread();
                if (this.i.containsKey(bdResourceCallback)) {
                    return;
                }
                this.i.put(bdResourceCallback, bdUniqueId);
            }
        }

        public void c(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
                BdUtilHelper.checkMainThread();
                if (this.i.size() == 0) {
                    cancel();
                    return;
                }
                Iterator<Map.Entry<BdResourceCallback<T>, BdUniqueId>> it = this.i.entrySet().iterator();
                while (it.hasNext()) {
                    BdUniqueId value = it.next().getValue();
                    if (value != null && value == bdUniqueId) {
                        it.remove();
                    }
                }
                if (this.i.size() == 0) {
                    cancel();
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            sb sbVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, t) == null) {
                if (t != null && (sbVar = (sb) this.k.mLoaderProcs.get(this.b)) != null) {
                    sbVar.updateMemory(this.k.genCacheKey(this.a, this.b), t, this.c, this.d, this.f);
                }
                for (Map.Entry<BdResourceCallback<T>, BdUniqueId> entry : this.i.entrySet()) {
                    BdResourceCallback<T> key = entry.getKey();
                    if (key != null) {
                        key.onLoaded(t, this.a, this.g);
                    }
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            rb.a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel();
                rb rbVar = this.j;
                if (rbVar != null && (aVar = rbVar.a) != null) {
                    aVar.cancel();
                }
                if (this.i.size() == 0) {
                    return;
                }
                for (Map.Entry<BdResourceCallback<T>, BdUniqueId> entry : this.i.entrySet()) {
                    BdResourceCallback<T> key = entry.getKey();
                    if (key != null) {
                        key.onCancelled(this.a);
                    }
                }
                this.i.clear();
            }
        }

        public void d(BdUniqueId bdUniqueId, BdResourceCallback<T> bdResourceCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, bdUniqueId, bdResourceCallback) == null) {
                BdUtilHelper.checkMainThread();
                if (this.i.size() == 0) {
                    cancel();
                    return;
                }
                Iterator<Map.Entry<BdResourceCallback<T>, BdUniqueId>> it = this.i.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<BdResourceCallback<T>, BdUniqueId> next = it.next();
                    BdResourceCallback<T> key = next.getKey();
                    BdUniqueId value = next.getValue();
                    if (value != null && value == bdUniqueId && key == bdResourceCallback) {
                        it.remove();
                    }
                }
                if (this.i.size() == 0) {
                    cancel();
                }
            }
        }

        public void e(BdResourceCallback<T> bdResourceCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, bdResourceCallback) == null) {
                BdUtilHelper.checkMainThread();
                this.i.remove(bdResourceCallback);
                if (bdResourceCallback != null) {
                    bdResourceCallback.onCancelled(this.a);
                }
                if (this.i.size() == 0) {
                    cancel();
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, objArr) == null) {
                for (Map.Entry<BdResourceCallback<T>, BdUniqueId> entry : this.i.entrySet()) {
                    BdResourceCallback<T> key = entry.getKey();
                    if (key != null) {
                        key.onProgressUpdate(objArr);
                    }
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
                qb.l(true, System.currentTimeMillis() - this.h);
                sb sbVar = (sb) this.k.mLoaderProcs.get(this.b);
                if (sbVar == null) {
                    return null;
                }
                String key = getKey();
                try {
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (isCancelled()) {
                    return null;
                }
                T t2 = (T) sbVar.getFromLocal(this.a, key, this.c, this.d, this.j, this.f);
                if (t2 != null) {
                    return t2;
                }
                t = t2;
                if (isCancelled() || this.e) {
                    return null;
                }
                this.g = 3;
                try {
                    return (T) sbVar.getFromRemote(this.a, key, this.c, this.d, this.j, this.f);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    return t;
                }
            }
            return (T) invokeL.objValue;
        }
    }

    public BdResourceLoader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.resourceTag = BdUniqueId.gen();
        this.mLoaderProcs = null;
        BdUniqueId gen = BdUniqueId.gen();
        mBdAsyncTaskSerial = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, gen);
        mBdAsyncTaskThree = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, gen);
        this.mLoaderProcs = new SparseArray<>();
    }

    public sb getLoaderProc(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            SparseArray<sb<?>> sparseArray = this.mLoaderProcs;
            if (sparseArray == null) {
                return null;
            }
            return sparseArray.get(i);
        }
        return (sb) invokeI.objValue;
    }

    public static BdResourceLoader getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (sInstance == null) {
                synchronized (BdResourceLoader.class) {
                    if (sInstance == null) {
                        sInstance = new BdResourceLoader();
                    }
                }
            }
            return sInstance;
        }
        return (BdResourceLoader) invokeV.objValue;
    }

    private <T> a<T> searchTask(String str) {
        InterceptResult invokeL;
        BdAsyncTask<?, ?, ?> searchTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (searchTask = BdAsyncTask.searchTask(str)) == null) {
                return null;
            }
            if (!(searchTask instanceof a)) {
                BdLog.e("BdAsyncTask has encountered repeat key");
                return null;
            }
            try {
                return (a) searchTask;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return (a) invokeL.objValue;
    }

    public void cancelAllLoadByPageId(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bdUniqueId) == null) && (searchAllTask = BdAsyncTask.searchAllTask(this.resourceTag)) != null && searchAllTask.size() != 0) {
            Iterator<BdAsyncTask<?, ?, ?>> it = searchAllTask.iterator();
            while (it.hasNext()) {
                BdAsyncTask<?, ?, ?> next = it.next();
                if (next != null && (next instanceof a)) {
                    ((a) next).c(bdUniqueId);
                }
            }
        }
    }

    public void cancelWaitingLoadByPageId(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) && (searchWaitingTask = BdAsyncTask.searchWaitingTask(this.resourceTag)) != null && searchWaitingTask.size() != 0) {
            Iterator<BdAsyncTask<?, ?, ?>> it = searchWaitingTask.iterator();
            while (it.hasNext()) {
                BdAsyncTask<?, ?, ?> next = it.next();
                if (next != null && (next instanceof a)) {
                    ((a) next).c(bdUniqueId);
                }
            }
        }
    }

    public boolean isNeedLoad(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            sb<?> sbVar = this.mLoaderProcs.get(i);
            if (sbVar == null) {
                BdLog.e("Can't find the ResourceLoaderProc with type " + i);
                return false;
            }
            return sbVar.isNeedLoad();
        }
        return invokeI.booleanValue;
    }

    public void cancelLoad(String str, int i) {
        a searchTask;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) != null) || (searchTask = searchTask(genCacheKey(str, i))) == null) {
            return;
        }
        searchTask.cancel();
    }

    public String genCacheKey(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, str, i)) == null) {
            if (str == null) {
                str = "";
            }
            return str + i;
        }
        return (String) invokeLI.objValue;
    }

    public <T> void cancelLoad(String str, int i, BdUniqueId bdUniqueId) {
        a<T> searchTask;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, str, i, bdUniqueId) != null) || (searchTask = searchTask(genCacheKey(str, i))) == null) {
            return;
        }
        searchTask.c(bdUniqueId);
    }

    public <T> void cancelLoad(String str, int i, BdResourceCallback<T> bdResourceCallback) {
        a<T> searchTask;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048579, this, str, i, bdResourceCallback) != null) || (searchTask = searchTask(genCacheKey(str, i))) == null) {
            return;
        }
        searchTask.e(bdResourceCallback);
    }

    public <T> void cancelWaitingLoadByPageId(BdUniqueId bdUniqueId, BdResourceCallback<T> bdResourceCallback) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, bdUniqueId, bdResourceCallback) == null) && (searchWaitingTask = BdAsyncTask.searchWaitingTask(this.resourceTag)) != null && searchWaitingTask.size() != 0) {
            Iterator<BdAsyncTask<?, ?, ?>> it = searchWaitingTask.iterator();
            while (it.hasNext()) {
                BdAsyncTask<?, ?, ?> next = it.next();
                if (next != null && (next instanceof a)) {
                    ((a) next).d(bdUniqueId, bdResourceCallback);
                }
            }
        }
    }

    public synchronized <T> void registerLoaderProc(int i, sb<T> sbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048589, this, i, sbVar) == null) {
            synchronized (this) {
                if (sbVar != null) {
                    if (this.mLoaderProcs.get(i) == null) {
                        this.mLoaderProcs.put(i, sbVar);
                    } else {
                        throw new IllegalArgumentException("registerLoaderProc key has been registered. The key is " + i);
                    }
                }
            }
        }
    }

    public <T> Object loadResource(String str, int i, BdResourceCallback<T> bdResourceCallback, int i2, int i3, BdUniqueId bdUniqueId, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{str, Integer.valueOf(i), bdResourceCallback, Integer.valueOf(i2), Integer.valueOf(i3), bdUniqueId, objArr})) == null) {
            return loadResource(str, i, bdResourceCallback, i2, i3, false, bdUniqueId, objArr);
        }
        return invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> Object loadResource(String str, int i, BdResourceCallback<T> bdResourceCallback, int i2, int i3, boolean z, BdUniqueId bdUniqueId, Object... objArr) {
        InterceptResult invokeCommon;
        sb<?> sbVar;
        int i4;
        int i5;
        a<T> searchTask;
        boolean isWifiNet;
        int asyncTaskPriority;
        Object fromMemory;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{str, Integer.valueOf(i), bdResourceCallback, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), bdUniqueId, objArr})) == null) {
            if (TextUtils.isEmpty(str) || (sbVar = this.mLoaderProcs.get(i)) == null) {
                return null;
            }
            if (i2 >= 0 && i3 >= 0) {
                i4 = i2;
                i5 = i3;
            } else {
                i4 = 0;
                i5 = 0;
            }
            String genCacheKey = genCacheKey(str, i);
            try {
                fromMemory = sbVar.getFromMemory(genCacheKey, str, i4, i5, true, objArr);
            } catch (Exception e) {
                e = e;
            }
            if (fromMemory != null) {
                if (bdResourceCallback != 0) {
                    try {
                        bdResourceCallback.onLoaded(fromMemory, str, 1);
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.e(e.getMessage());
                        searchTask = searchTask(genCacheKey);
                        if (searchTask == null) {
                        }
                        isWifiNet = BdNetTypeUtil.isWifiNet();
                        boolean is4GNet = BdNetTypeUtil.is4GNet();
                        a aVar = new a(this, str, i, i4, i5, bdUniqueId, bdResourceCallback, z, objArr);
                        aVar.setKey(genCacheKey);
                        aVar.setTag(this.resourceTag);
                        asyncTaskPriority = sbVar.getAsyncTaskPriority();
                        if (asyncTaskPriority == 0) {
                        }
                        aVar.setPriority(asyncTaskPriority);
                        if (isWifiNet) {
                        }
                        if (sbVar.getAsyncTaskParallel() != null) {
                        }
                        aVar.execute(new String[0]);
                        return null;
                    }
                }
                return fromMemory;
            }
            searchTask = searchTask(genCacheKey);
            if (searchTask == null && searchTask.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
                searchTask.b(bdResourceCallback, bdUniqueId);
                return null;
            }
            isWifiNet = BdNetTypeUtil.isWifiNet();
            boolean is4GNet2 = BdNetTypeUtil.is4GNet();
            a aVar2 = new a(this, str, i, i4, i5, bdUniqueId, bdResourceCallback, z, objArr);
            aVar2.setKey(genCacheKey);
            aVar2.setTag(this.resourceTag);
            asyncTaskPriority = sbVar.getAsyncTaskPriority();
            if (asyncTaskPriority == 0) {
                asyncTaskPriority = 1;
            }
            aVar2.setPriority(asyncTaskPriority);
            if (isWifiNet && !is4GNet2) {
                aVar2.setParallel(mBdAsyncTaskSerial);
            } else if (sbVar.getAsyncTaskParallel() != null) {
                aVar2.setParallel(mBdAsyncTaskThree);
            } else {
                aVar2.setParallel(sbVar.getAsyncTaskParallel());
            }
            aVar2.execute(new String[0]);
            return null;
        }
        return invokeCommon.objValue;
    }

    public <T> Object loadResource(String str, int i, BdResourceCallback<T> bdResourceCallback, BdUniqueId bdUniqueId) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048587, this, str, i, bdResourceCallback, bdUniqueId)) == null) {
            return loadResource(str, i, bdResourceCallback, 0, 0, bdUniqueId, new Object[0]);
        }
        return invokeLILL.objValue;
    }

    public Object loadResourceFromMemery(String str, int i, Object... objArr) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048588, this, str, i, objArr)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            sb<?> sbVar = this.mLoaderProcs.get(i);
            if (sbVar == null) {
                BdLog.e("Can't find the ResourceLoaderProc with type " + i);
                return null;
            }
            return sbVar.getFromMemory(genCacheKey(str, i), str, 0, 0, false, objArr);
        }
        return invokeLIL.objValue;
    }
}
