package com.baidu.bdtask.event;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.model.response.NextActive;
import com.baidu.bdtask.utils.UniqueId;
import com.baidu.tieba.mq;
import com.baidu.tieba.nq;
import com.baidu.tieba.oq;
import com.baidu.tieba.pq;
import com.baidu.tieba.qq;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b(\u0010)J=\u0010\n\u001a\u00020\t\"\b\b\u0000\u0010\u0002*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0016J;\u0010\u0019\u001a&\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0005\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00070\u0018\u0018\u00010\u00172\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u00172\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001b\u0010\u001aJ'\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00142\u0010\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00142\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u001f\u0010 R\"\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\"0!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/baidu/bdtask/event/TaskBusinessEventManager;", "Lcom/baidu/bdtask/event/TaskBusinessEvent;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/baidu/bdtask/model/info/TaskInfo;", NextActive.keyTaskInfo, "Ljava/lang/Class;", "eventClass", "Lcom/baidu/bdtask/event/TaskBusinessEventAction;", "action", "", "addBusinessEventAction", "(Lcom/baidu/bdtask/model/info/TaskInfo;Ljava/lang/Class;Lcom/baidu/bdtask/event/TaskBusinessEventAction;)V", "Lcom/baidu/bdtask/event/TaskBusinessEventCallback;", WebChromeClient.KEY_ARG_CALLBACK, "addBusinessEventCallback", "(Lcom/baidu/bdtask/model/info/TaskInfo;Lcom/baidu/bdtask/event/TaskBusinessEventCallback;)V", "Lcom/baidu/bdtask/utils/UniqueId;", "eventId", "dispatchBusinessEvent", "(Lcom/baidu/bdtask/model/info/TaskInfo;Lcom/baidu/bdtask/utils/UniqueId;)V", "", "singleKey", "(Ljava/lang/String;Lcom/baidu/bdtask/utils/UniqueId;)V", "", "Lkotlin/Pair;", "getBusinessEventActions", "(Ljava/lang/String;)Ljava/util/Set;", "getBusinessEventCallbacks", "actionId", "removeBusinessEventAction", "(Ljava/lang/String;Lcom/baidu/bdtask/event/TaskBusinessEventAction;)V", "removeBusinessEventCallback", "(Ljava/lang/String;Lcom/baidu/bdtask/event/TaskBusinessEventCallback;)V", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/baidu/bdtask/event/TaskBusinessEventCache;", "cacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/locks/ReentrantLock;", "fairLock", "Ljava/util/concurrent/locks/ReentrantLock;", "<init>", "()V", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class TaskBusinessEventManager {
    public static /* synthetic */ Interceptable $ic;
    public static final ReentrantLock a;
    public static final ConcurrentHashMap<String, qq> b;
    public static final TaskBusinessEventManager c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1060382092, "Lcom/baidu/bdtask/event/TaskBusinessEventManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1060382092, "Lcom/baidu/bdtask/event/TaskBusinessEventManager;");
                return;
            }
        }
        c = new TaskBusinessEventManager();
        a = new ReentrantLock(true);
        b = new ConcurrentHashMap<>();
    }

    public TaskBusinessEventManager() {
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

    public final <T extends mq> void a(TaskInfo taskInfo, Class<T> cls, nq<T> nqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, taskInfo, cls, nqVar) == null) {
            ReentrantLock reentrantLock = a;
            reentrantLock.lock();
            try {
                String singleKey = taskInfo.getSingleKey();
                if (!b.containsKey(singleKey)) {
                    b.put(singleKey, new qq(taskInfo.deepCopy()));
                } else {
                    qq qqVar = b.get(singleKey);
                    if (qqVar != null) {
                        qqVar.d(taskInfo.deepCopy());
                    }
                }
                qq qqVar2 = b.get(singleKey);
                if (qqVar2 != null) {
                    qqVar2.e(cls, nqVar);
                    Unit unit = Unit.INSTANCE;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final void b(TaskInfo taskInfo, oq oqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, taskInfo, oqVar) == null) {
            ReentrantLock reentrantLock = a;
            reentrantLock.lock();
            try {
                String singleKey = taskInfo.getSingleKey();
                if (!b.containsKey(singleKey)) {
                    b.put(singleKey, new qq(taskInfo.deepCopy()));
                } else {
                    qq qqVar = b.get(singleKey);
                    if (qqVar != null) {
                        qqVar.d(taskInfo.deepCopy());
                    }
                }
                qq qqVar2 = b.get(singleKey);
                if (qqVar2 != null) {
                    qqVar2.c(oqVar);
                    Unit unit = Unit.INSTANCE;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final void g(String str, nq<? extends mq> nqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, nqVar) == null) {
            ReentrantLock reentrantLock = a;
            reentrantLock.lock();
            try {
                for (Map.Entry<String, qq> entry : b.entrySet()) {
                    qq value = entry.getValue();
                    if (Intrinsics.areEqual(value.h().getActionId(), str)) {
                        value.b(nqVar);
                    }
                }
                Unit unit = Unit.INSTANCE;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final void h(String str, oq oqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, oqVar) == null) {
            ReentrantLock reentrantLock = a;
            reentrantLock.lock();
            try {
                for (Map.Entry<String, qq> entry : b.entrySet()) {
                    qq value = entry.getValue();
                    if (Intrinsics.areEqual(value.h().getActionId(), str)) {
                        value.g(oqVar);
                    }
                }
                Unit unit = Unit.INSTANCE;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final void c(TaskInfo taskInfo, UniqueId uniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, taskInfo, uniqueId) == null) {
            ReentrantLock reentrantLock = a;
            reentrantLock.lock();
            try {
                final mq a2 = pq.a.a(taskInfo, uniqueId);
                if (a2 != null) {
                    DebugTrace.a.c(new Function0<String>(a2) { // from class: com.baidu.bdtask.event.TaskBusinessEventManager$dispatchBusinessEvent$1$1
                        public static /* synthetic */ Interceptable $ic;
                        public final /* synthetic */ mq $event;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {a2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    super(((Integer) newInitContext.callArgs[0]).intValue());
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.$event = a2;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                                return "dispatchBusinessEvent " + this.$event;
                            }
                            return (String) invokeV.objValue;
                        }
                    });
                    Set<Pair<Class<? extends mq>, nq<? extends mq>>> e = c.e(taskInfo.getSingleKey());
                    Set<oq> f = c.f(taskInfo.getSingleKey());
                    if (f != null) {
                        for (oq oqVar : f) {
                            if (oqVar != null) {
                                oqVar.onEvent(a2);
                            }
                        }
                    }
                    if (e != null) {
                        Iterator<T> it = e.iterator();
                        while (it.hasNext()) {
                            Pair pair = (Pair) it.next();
                            if (a2.getClass().isAssignableFrom((Class) pair.getFirst())) {
                                Object second = pair.getSecond();
                                if (!(second instanceof nq)) {
                                    second = null;
                                }
                                nq nqVar = (nq) second;
                                if (nqVar != null) {
                                    nqVar.a(a2);
                                }
                            }
                        }
                    }
                }
                Unit unit = Unit.INSTANCE;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final void d(String str, UniqueId uniqueId) {
        qq qqVar;
        TaskInfo h;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, str, uniqueId) == null) && (qqVar = b.get(str)) != null && (h = qqVar.h()) != null) {
            c(h, uniqueId);
        }
    }

    public final Set<Pair<Class<? extends mq>, nq<? extends mq>>> e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            qq qqVar = b.get(str);
            if (qqVar == null || (!Intrinsics.areEqual(qqVar.h().getSingleKey(), str))) {
                return null;
            }
            return qqVar.f();
        }
        return (Set) invokeL.objValue;
    }

    public final Set<oq> f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            qq qqVar = b.get(str);
            if (qqVar == null || (!Intrinsics.areEqual(qqVar.h().getSingleKey(), str))) {
                return null;
            }
            return qqVar.a();
        }
        return (Set) invokeL.objValue;
    }
}
