package com.baidu.adp.lib.asyncTask;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.be;
import com.baidu.tieba.ce;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class BdAsyncTask<Params, Progress, Result> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MESSAGE_POST_PROGRESS = 2;
    public static final int MESSAGE_POST_RESULT = 1;
    public static final be sDefaultExecutor;
    public static final e sHandler;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isSelfExecute;
    public final ce<Result> mFuture;
    public boolean mIsTimeout;
    public String mKey;
    public BdAsyncTaskParallel mParallel;
    public final AtomicBoolean mPreCancelInvoked;
    public int mPriority;
    public volatile BdAsyncTaskStatus mStatus;
    public int mTag;
    public final AtomicBoolean mTaskInvoked;
    public final f<Params, Result> mWorker;

    public abstract Result doInBackground(Params... paramsArr) throws IOException;

    public void onCancelled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    public void onPostExecute(Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, result) == null) {
        }
    }

    public void onPreCancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    public void onPreExecute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    public void onProgressUpdate(Progress... progressArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, progressArr) == null) {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class BdAsyncTaskStatus {
        public static final /* synthetic */ BdAsyncTaskStatus[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BdAsyncTaskStatus FINISHED;
        public static final BdAsyncTaskStatus PENDING;
        public static final BdAsyncTaskStatus RUNNING;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2039815753, "Lcom/baidu/adp/lib/asyncTask/BdAsyncTask$BdAsyncTaskStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2039815753, "Lcom/baidu/adp/lib/asyncTask/BdAsyncTask$BdAsyncTaskStatus;");
                    return;
                }
            }
            PENDING = new BdAsyncTaskStatus("PENDING", 0);
            RUNNING = new BdAsyncTaskStatus("RUNNING", 1);
            BdAsyncTaskStatus bdAsyncTaskStatus = new BdAsyncTaskStatus("FINISHED", 2);
            FINISHED = bdAsyncTaskStatus;
            $VALUES = new BdAsyncTaskStatus[]{PENDING, RUNNING, bdAsyncTaskStatus};
        }

        public BdAsyncTaskStatus(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static BdAsyncTaskStatus valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (BdAsyncTaskStatus) Enum.valueOf(BdAsyncTaskStatus.class, str);
            }
            return (BdAsyncTaskStatus) invokeL.objValue;
        }

        public static BdAsyncTaskStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (BdAsyncTaskStatus[]) $VALUES.clone();
            }
            return (BdAsyncTaskStatus[]) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class a extends f<Params, Result> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdAsyncTask b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BdAsyncTask bdAsyncTask) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdAsyncTask};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bdAsyncTask;
        }

        @Override // java.util.concurrent.Callable
        public Result call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!this.b.mFuture.isCancelled()) {
                    BdAsyncTask bdAsyncTask = this.b;
                    return (Result) bdAsyncTask.postResult(bdAsyncTask.doInBackground(this.a));
                }
                return (Result) this.b.postResult(null);
            }
            return (Result) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b extends ce<Result> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdAsyncTask b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(BdAsyncTask bdAsyncTask, Callable callable, BdAsyncTask bdAsyncTask2) {
            super(callable, bdAsyncTask2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdAsyncTask, callable, bdAsyncTask2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Callable) objArr2[0], (BdAsyncTask) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bdAsyncTask;
        }

        @Override // com.baidu.tieba.ce
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.cancel();
            }
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    this.b.postResult(get());
                } catch (InterruptedException unused) {
                } catch (CancellationException unused2) {
                    this.b.postResult(null);
                } catch (ExecutionException e) {
                    this.b.postResult(null);
                    if (BdBaseApplication.getInst().isDebugMode()) {
                        throw new RuntimeException("An error occured while executing doInBackground()", e);
                    }
                } catch (Throwable th) {
                    throw new RuntimeException("An error occured while executing doInBackground()", th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class c {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(854236741, "Lcom/baidu/adp/lib/asyncTask/BdAsyncTask$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(854236741, "Lcom/baidu/adp/lib/asyncTask/BdAsyncTask$c;");
                    return;
                }
            }
            int[] iArr = new int[BdAsyncTaskStatus.values().length];
            a = iArr;
            try {
                iArr[BdAsyncTaskStatus.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BdAsyncTaskStatus.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d<Data> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final BdAsyncTask a;
        public final Data[] b;

        public d(BdAsyncTask bdAsyncTask, Data... dataArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdAsyncTask, dataArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdAsyncTask;
            this.b = dataArr;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                d dVar = (d) message.obj;
                int i = message.what;
                if (i != 1) {
                    if (i == 2) {
                        dVar.a.onProgressUpdate(dVar.b);
                        return;
                    }
                    return;
                }
                dVar.a.finish(dVar.b[0]);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class f<Params, Result> implements Callable<Result> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Params[] a;

        public f() {
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

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(277983588, "Lcom/baidu/adp/lib/asyncTask/BdAsyncTask;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(277983588, "Lcom/baidu/adp/lib/asyncTask/BdAsyncTask;");
                return;
            }
        }
        sDefaultExecutor = be.e();
        sHandler = new e(Looper.getMainLooper());
    }

    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            cancel(true);
        }
    }

    public final Result get() throws InterruptedException, ExecutionException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mFuture.get();
        }
        return (Result) invokeV.objValue;
    }

    public String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mKey;
        }
        return (String) invokeV.objValue;
    }

    public BdAsyncTaskParallel getParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mParallel;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    public int getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mPriority;
        }
        return invokeV.intValue;
    }

    public final BdAsyncTaskStatus getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mStatus;
        }
        return (BdAsyncTaskStatus) invokeV.objValue;
    }

    public int getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mTag;
        }
        return invokeV.intValue;
    }

    public final boolean isCancelled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mFuture.isCancelled();
        }
        return invokeV.booleanValue;
    }

    public boolean isSelfExecute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.isSelfExecute;
        }
        return invokeV.booleanValue;
    }

    public boolean isTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mIsTimeout;
        }
        return invokeV.booleanValue;
    }

    public BdAsyncTask() {
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
        this.mStatus = BdAsyncTaskStatus.PENDING;
        this.mPriority = 1;
        this.mTag = 0;
        this.mKey = null;
        this.mParallel = null;
        this.isSelfExecute = false;
        this.mTaskInvoked = new AtomicBoolean(false);
        this.mPreCancelInvoked = new AtomicBoolean(false);
        this.mIsTimeout = false;
        this.mWorker = new a(this);
        this.mFuture = new b(this, this.mWorker, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish(Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, result) == null) {
            if (isCancelled()) {
                onCancelled(result);
            } else {
                onPostExecute(result);
            }
            this.mStatus = BdAsyncTaskStatus.FINISHED;
        }
    }

    public static int getTaskNum(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bdUniqueId)) == null) {
            return getTaskNum(null, bdUniqueId);
        }
        return invokeL.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Result postResult(Result result) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, result)) == null) {
            if (this.mTaskInvoked.compareAndSet(false, true)) {
                sHandler.obtainMessage(1, new d(this, result)).sendToTarget();
                return result;
            }
            return null;
        }
        return (Result) invokeL.objValue;
    }

    public static void removeAllTask(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, bdUniqueId) == null) {
            sDefaultExecutor.i(bdUniqueId);
        }
    }

    public static void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, bdUniqueId) == null) {
            sDefaultExecutor.k(bdUniqueId);
        }
    }

    public static BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            return sDefaultExecutor.q(str);
        }
        return (BdAsyncTask) invokeL.objValue;
    }

    public static LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bdUniqueId)) == null) {
            return sDefaultExecutor.r(bdUniqueId);
        }
        return (LinkedList) invokeL.objValue;
    }

    public static BdAsyncTask<?, ?, ?> searchTask(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            return sDefaultExecutor.u(str);
        }
        return (BdAsyncTask) invokeL.objValue;
    }

    public static BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            return sDefaultExecutor.w(str);
        }
        return (BdAsyncTask) invokeL.objValue;
    }

    public final BdAsyncTask<Params, Progress, Result> execute(Params... paramsArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, paramsArr)) == null) {
            return executeOnExecutor(sDefaultExecutor, paramsArr);
        }
        return (BdAsyncTask) invokeL.objValue;
    }

    public void onCancelled(Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, result) == null) {
            onCancelled();
        }
    }

    public void publishProgress(Progress... progressArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, progressArr) == null) && !isCancelled()) {
            sHandler.obtainMessage(2, new d(this, progressArr)).sendToTarget();
        }
    }

    public synchronized String setKey(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            synchronized (this) {
                if (this.mStatus == BdAsyncTaskStatus.PENDING) {
                    str2 = this.mKey;
                    this.mKey = str;
                } else {
                    throw new IllegalStateException("the task is already running");
                }
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public synchronized void setParallel(BdAsyncTaskParallel bdAsyncTaskParallel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bdAsyncTaskParallel) == null) {
            synchronized (this) {
                if (this.mStatus == BdAsyncTaskStatus.PENDING) {
                    this.mParallel = bdAsyncTaskParallel;
                } else {
                    throw new IllegalStateException("the task is already running");
                }
            }
        }
    }

    public synchronized int setPriority(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) {
            synchronized (this) {
                if (this.mStatus == BdAsyncTaskStatus.PENDING) {
                    i2 = this.mPriority;
                    this.mPriority = i;
                } else {
                    throw new IllegalStateException("the task is already running");
                }
            }
            return i2;
        }
        return invokeI.intValue;
    }

    public synchronized void setSelfExecute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            synchronized (this) {
                if (this.mStatus == BdAsyncTaskStatus.PENDING) {
                    this.isSelfExecute = z;
                } else {
                    throw new IllegalStateException("the task is already running");
                }
            }
        }
    }

    public synchronized int setTag(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, bdUniqueId)) == null) {
            synchronized (this) {
                if (this.mStatus == BdAsyncTaskStatus.PENDING) {
                    i = this.mTag;
                    if (bdUniqueId != null) {
                        this.mTag = bdUniqueId.getId();
                    }
                } else {
                    throw new IllegalStateException("the task is already running");
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public synchronized void setTimeout(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            synchronized (this) {
                this.mIsTimeout = z;
            }
        }
    }

    public static int getTaskNum(String str, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, bdUniqueId)) == null) {
            return sDefaultExecutor.g(str, bdUniqueId);
        }
        return invokeLL.intValue;
    }

    public static void removeAllTask(BdUniqueId bdUniqueId, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, bdUniqueId, str) == null) {
            sDefaultExecutor.j(bdUniqueId, str);
        }
    }

    public static void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, bdUniqueId, str) == null) {
            sDefaultExecutor.l(bdUniqueId, str);
        }
    }

    public static LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, bdUniqueId, str)) == null) {
            return sDefaultExecutor.s(bdUniqueId, str);
        }
        return (LinkedList) invokeLL.objValue;
    }

    public final Result get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048582, this, j, timeUnit)) == null) {
            return this.mFuture.get(j, timeUnit);
        }
        return (Result) invokeJL.objValue;
    }

    public static LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, bdUniqueId)) == null) {
            return sDefaultExecutor.x(bdUniqueId);
        }
        return (LinkedList) invokeL.objValue;
    }

    public final synchronized boolean cancel(boolean z) {
        InterceptResult invokeZ;
        boolean cancel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            synchronized (this) {
                if (!this.isSelfExecute) {
                    sDefaultExecutor.o(this);
                }
                cancel = this.mFuture.cancel(z);
                if (this.mPreCancelInvoked.compareAndSet(false, true)) {
                    onPreCancel();
                }
            }
            return cancel;
        }
        return invokeZ.booleanValue;
    }

    public final synchronized BdAsyncTask<Params, Progress, Result> executeOnExecutor(Executor executor, Params... paramsArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, executor, paramsArr)) == null) {
            synchronized (this) {
                if (this.mStatus != BdAsyncTaskStatus.PENDING) {
                    int i = c.a[this.mStatus.ordinal()];
                    if (i != 1) {
                        if (i == 2) {
                            throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                        }
                    } else {
                        throw new IllegalStateException("Cannot execute task: the task is already running.");
                    }
                }
                this.mStatus = BdAsyncTaskStatus.RUNNING;
                onPreExecute();
                this.mWorker.a = paramsArr;
                executor.execute(this.mFuture);
            }
            return this;
        }
        return (BdAsyncTask) invokeLL.objValue;
    }
}
