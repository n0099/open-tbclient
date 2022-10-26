package com.baidu.searchbox.live.eventbus;

import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.arch.thread.MiniElasticExecutor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class MixEventBusCore implements IActionHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler mainHandler;

    public MixEventBusCore() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mainHandler = new Handler(Looper.getMainLooper());
    }

    private boolean isMainThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.eventbus.IActionHandler
    public void execute(int i, Object obj, EventAction eventAction) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i, obj, eventAction) == null) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        eventAction.call(obj);
                    } else {
                        MiniElasticExecutor.INSTANCE.execute(new Runnable(this, eventAction, obj) { // from class: com.baidu.searchbox.live.eventbus.MixEventBusCore.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ MixEventBusCore this$0;
                            public final /* synthetic */ EventAction val$action;
                            public final /* synthetic */ Object val$event;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, eventAction, obj};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$action = eventAction;
                                this.val$event = obj;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    this.val$action.call(this.val$event);
                                }
                            }
                        });
                    }
                } else if (isMainThread()) {
                    MiniElasticExecutor.INSTANCE.execute(new Runnable(this, eventAction, obj) { // from class: com.baidu.searchbox.live.eventbus.MixEventBusCore.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ MixEventBusCore this$0;
                        public final /* synthetic */ EventAction val$action;
                        public final /* synthetic */ Object val$event;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, eventAction, obj};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$action = eventAction;
                            this.val$event = obj;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.val$action.call(this.val$event);
                            }
                        }
                    });
                } else {
                    eventAction.call(obj);
                }
            } else if (isMainThread()) {
                eventAction.call(obj);
            } else {
                this.mainHandler.post(new Runnable(this, eventAction, obj) { // from class: com.baidu.searchbox.live.eventbus.MixEventBusCore.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MixEventBusCore this$0;
                    public final /* synthetic */ EventAction val$action;
                    public final /* synthetic */ Object val$event;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, eventAction, obj};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$action = eventAction;
                        this.val$event = obj;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.val$action.call(this.val$event);
                        }
                    }
                });
            }
        }
    }

    public synchronized void post(ConcurrentHashMap concurrentHashMap, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, concurrentHashMap, obj) == null) {
            synchronized (this) {
                if (obj != null && concurrentHashMap != null) {
                    if (!concurrentHashMap.isEmpty()) {
                        for (Map.Entry entry : concurrentHashMap.entrySet()) {
                            if (entry != null && entry.getValue() != null) {
                                Iterator it = ((CopyOnWriteArrayList) entry.getValue()).iterator();
                                while (it.hasNext()) {
                                    EventPoster eventPoster = (EventPoster) it.next();
                                    if (eventPoster.isSupport(obj)) {
                                        eventPoster.call(obj);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public synchronized void unRegister(ConcurrentHashMap concurrentHashMap, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, concurrentHashMap, obj) == null) {
            synchronized (this) {
                if (obj != null && concurrentHashMap != null) {
                    if (!concurrentHashMap.isEmpty() && concurrentHashMap.containsKey(obj)) {
                        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) concurrentHashMap.remove(obj);
                        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                            Iterator it = copyOnWriteArrayList.iterator();
                            while (it.hasNext()) {
                                ((EventPoster) it.next()).clear();
                            }
                        }
                        if (copyOnWriteArrayList != null) {
                            copyOnWriteArrayList.clear();
                        }
                    }
                }
            }
        }
    }

    public synchronized void register(ConcurrentHashMap concurrentHashMap, Object obj, Class cls, int i, EventAction eventAction) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{concurrentHashMap, obj, cls, Integer.valueOf(i), eventAction}) == null) {
            synchronized (this) {
                if (obj != null && cls != null && eventAction != null && concurrentHashMap != null) {
                    CopyOnWriteArrayList copyOnWriteArrayList = null;
                    if (concurrentHashMap.containsKey(obj)) {
                        copyOnWriteArrayList = (CopyOnWriteArrayList) concurrentHashMap.get(obj);
                    }
                    if (copyOnWriteArrayList == null) {
                        copyOnWriteArrayList = new CopyOnWriteArrayList();
                        concurrentHashMap.put(obj, copyOnWriteArrayList);
                    }
                    copyOnWriteArrayList.add(new EventPoster(i, cls, eventAction, this));
                }
            }
        }
    }
}
