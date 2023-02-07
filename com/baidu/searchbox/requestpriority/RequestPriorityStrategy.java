package com.baidu.searchbox.requestpriority;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class RequestPriorityStrategy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int REQUEST_PRIORITY_INITED = 1;
    public static final int REQUEST_PRIORITY_NOT_INITED = -1;
    public static volatile int sCoreRequestNum = 0;
    public static int sRequestPriorityDelayTime = -1;
    public static boolean sRequestPriorityEnabled = false;
    public static int sRequestPrioritySwitchValue = -1;
    public static String sRequestPriorityWhiteList;
    public static volatile ScheduledExecutorService sScheduledExecutorService;
    public static volatile Set<Integer> sTimeoutRequestSet;
    public static volatile List<Runnable> sWaitingList;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1565033867, "Lcom/baidu/searchbox/requestpriority/RequestPriorityStrategy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1565033867, "Lcom/baidu/searchbox/requestpriority/RequestPriorityStrategy;");
                return;
            }
        }
        sWaitingList = new ArrayList();
        sCoreRequestNum = 0;
        sTimeoutRequestSet = new HashSet();
    }

    public RequestPriorityStrategy() {
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

    public static /* synthetic */ int access$110() {
        int i = sCoreRequestNum;
        sCoreRequestNum = i - 1;
        return i;
    }

    public static ScheduledExecutorService scheduledExecutorService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (sScheduledExecutorService == null) {
                synchronized (RequestPriorityStrategy.class) {
                    if (sScheduledExecutorService == null) {
                        sScheduledExecutorService = new ScheduledThreadPoolExecutor(1);
                    }
                }
            }
            return sScheduledExecutorService;
        }
        return (ScheduledExecutorService) invokeV.objValue;
    }

    public static void addToWaitingList(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, runnable) == null) {
            synchronized (sWaitingList) {
                sWaitingList.add(runnable);
            }
            if (sCoreRequestNum <= 0) {
                promoteAndExecute();
            }
        }
    }

    public static void scheduleWaitingRequestCalls(IRequestCall iRequestCall) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, iRequestCall) == null) {
            synchronized (IRequestCall.class) {
                sCoreRequestNum++;
            }
            scheduledExecutorService().schedule(new Runnable(iRequestCall) { // from class: com.baidu.searchbox.requestpriority.RequestPriorityStrategy.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IRequestCall val$request;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {iRequestCall};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$request = iRequestCall;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && !this.val$request.isFinished()) {
                        synchronized (IRequestCall.class) {
                            RequestPriorityStrategy.sTimeoutRequestSet.add(Integer.valueOf(this.val$request.hashCode()));
                            RequestPriorityStrategy.access$110();
                        }
                        RequestPriorityStrategy.promoteAndExecute();
                    }
                }
            }, sRequestPriorityDelayTime, TimeUnit.MILLISECONDS);
        }
    }

    public static void startPriorityControlled(IRequestCall iRequestCall) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, iRequestCall) == null) {
            synchronized (IRequestCall.class) {
                sCoreRequestNum++;
            }
            scheduledExecutorService().schedule(new Runnable(iRequestCall) { // from class: com.baidu.searchbox.requestpriority.RequestPriorityStrategy.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IRequestCall val$request;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {iRequestCall};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$request = iRequestCall;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && !this.val$request.isFinished()) {
                        synchronized (IRequestCall.class) {
                            RequestPriorityStrategy.sTimeoutRequestSet.add(Integer.valueOf(this.val$request.hashCode()));
                            RequestPriorityStrategy.access$110();
                        }
                        RequestPriorityStrategy.promoteAndExecute();
                    }
                }
            }, 1000L, TimeUnit.MILLISECONDS);
        }
    }

    public static <T> void enqueueWithResponseCallback(IRequestCall iRequestCall, T t, T t2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, iRequestCall, t, t2) == null) {
            if (isCoreRequest(iRequestCall)) {
                scheduleWaitingRequestCalls(iRequestCall);
                iRequestCall.priorityEnqueueWithResponseCallback(t, t2);
            } else if (sCoreRequestNum > 0) {
                addToWaitingList(new Runnable(iRequestCall, t, t2) { // from class: com.baidu.searchbox.requestpriority.RequestPriorityStrategy.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Object val$callback;
                    public final /* synthetic */ Object val$handler;
                    public final /* synthetic */ IRequestCall val$request;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {iRequestCall, t, t2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$request = iRequestCall;
                        this.val$handler = t;
                        this.val$callback = t2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.val$request.priorityEnqueueWithResponseCallback(this.val$handler, this.val$callback);
                        }
                    }
                });
            } else {
                iRequestCall.priorityEnqueueWithResponseCallback(t, t2);
            }
        }
    }

    public static <T> void enqueueWithStatResponseCallback(IRequestCall iRequestCall, T t, T t2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, iRequestCall, t, t2) == null) {
            if (isCoreRequest(iRequestCall)) {
                scheduleWaitingRequestCalls(iRequestCall);
                iRequestCall.priorityEnqueueWithStatResponseCallback(t, t2);
            } else if (sCoreRequestNum > 0) {
                addToWaitingList(new Runnable(iRequestCall, t, t2) { // from class: com.baidu.searchbox.requestpriority.RequestPriorityStrategy.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Object val$callback;
                    public final /* synthetic */ Object val$handler;
                    public final /* synthetic */ IRequestCall val$request;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {iRequestCall, t, t2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$request = iRequestCall;
                        this.val$handler = t;
                        this.val$callback = t2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.val$request.priorityEnqueueWithStatResponseCallback(this.val$handler, this.val$callback);
                        }
                    }
                });
            } else {
                iRequestCall.priorityEnqueueWithStatResponseCallback(t, t2);
            }
        }
    }

    public static Object executeSync(IRequestCall iRequestCall) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, iRequestCall)) == null) {
            if (isCoreRequest(iRequestCall)) {
                scheduleWaitingRequestCalls(iRequestCall);
            } else if (sCoreRequestNum > 0) {
                CountDownLatch countDownLatch = new CountDownLatch(1);
                addToWaitingList(new Runnable(countDownLatch) { // from class: com.baidu.searchbox.requestpriority.RequestPriorityStrategy.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ CountDownLatch val$countDownLatch;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {countDownLatch};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$countDownLatch = countDownLatch;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.val$countDownLatch.countDown();
                        }
                    }
                });
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return iRequestCall.priorityExecuteSync();
        }
        return invokeL.objValue;
    }

    public static boolean isCoreRequest(IRequestCall iRequestCall) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, iRequestCall)) == null) {
            return sRequestPriorityWhiteList.contains(iRequestCall.getRequestFrom() + "|" + iRequestCall.getRequestSubFrom());
        }
        return invokeL.booleanValue;
    }

    public static void stopPriorityControlled(IRequestCall iRequestCall) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, iRequestCall) == null) {
            synchronized (IRequestCall.class) {
                if (sTimeoutRequestSet.contains(Integer.valueOf(iRequestCall.hashCode()))) {
                    sTimeoutRequestSet.remove(Integer.valueOf(iRequestCall.hashCode()));
                } else {
                    sCoreRequestNum--;
                }
            }
            if (sCoreRequestNum <= 0) {
                promoteAndExecute();
            }
        }
    }

    public static boolean isRequestPriorityEnabled() {
        InterceptResult invokeV;
        RequestPriorityParams requestPriorityParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (sRequestPrioritySwitchValue == -1) {
                sRequestPrioritySwitchValue = 1;
                IRequestPriorityManager requestPriorityManager = RequestPriorityRuntime.getRequestPriorityManager();
                if (requestPriorityManager == null || (requestPriorityParams = requestPriorityManager.getRequestPriorityParams()) == null || !requestPriorityParams.isRequestPriorityEnabled() || requestPriorityParams.getRequestPriorityDelayTime() <= 0) {
                    return false;
                }
                sRequestPriorityDelayTime = requestPriorityParams.getRequestPriorityDelayTime();
                String requestPriorityWhitelist = requestPriorityParams.getRequestPriorityWhitelist();
                sRequestPriorityWhiteList = requestPriorityWhitelist;
                sRequestPriorityEnabled = true ^ TextUtils.isEmpty(requestPriorityWhitelist);
            }
            return sRequestPriorityEnabled;
        }
        return invokeV.booleanValue;
    }

    public static void promoteAndExecute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            synchronized (sWaitingList) {
                int size = sWaitingList.size();
                for (int i = 0; i < size; i++) {
                    sWaitingList.get(i).run();
                }
                sWaitingList.clear();
            }
        }
    }

    public static void promoteAndExecuteIfNeeded(IRequestCall iRequestCall) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65548, null, iRequestCall) == null) && isRequestPriorityEnabled() && isCoreRequest(iRequestCall)) {
            synchronized (IRequestCall.class) {
                if (sTimeoutRequestSet.contains(Integer.valueOf(iRequestCall.hashCode()))) {
                    sTimeoutRequestSet.remove(Integer.valueOf(iRequestCall.hashCode()));
                } else {
                    sCoreRequestNum--;
                }
            }
            if (sCoreRequestNum <= 0) {
                promoteAndExecute();
            }
        }
    }
}
