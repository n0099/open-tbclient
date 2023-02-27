package com.baidu.bdtask.service.cache;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.TaskState;
import com.baidu.bdtask.ctrl.SubTaskState;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.model.response.NextActive;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.tieba.ew;
import com.baidu.tieba.fw;
import com.baidu.tieba.ss;
import com.baidu.tieba.vr;
import com.baidu.tieba.yt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d:\u0001\u001dB\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u0014J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\n8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\"\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00190\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/baidu/bdtask/service/cache/TaskCacheManager;", "Lcom/baidu/bdtask/ctrl/BDPTaskState;", "state", "Lcom/baidu/bdtask/model/info/TaskInfo;", NextActive.keyTaskInfo, "", TTDownloadField.TT_FORCE, "", "cacheTasks", "(Lcom/baidu/bdtask/ctrl/BDPTaskState;Lcom/baidu/bdtask/model/info/TaskInfo;Z)V", "", "actionId", "id", "duplicateIdIsValid", "(Ljava/lang/String;Ljava/lang/String;)Z", "getTaskStateCacheSync", "()Ljava/lang/String;", "isCacheAble", "(Lcom/baidu/bdtask/model/info/TaskInfo;)Z", "removeCache", "()V", "cacheKey", "Ljava/lang/String;", TaskInfo.keyFingerprint, "Lcom/baidu/bdtask/utils/stack/ISafeStack;", "Lkotlin/Function0;", "storageRequestStack", "Lcom/baidu/bdtask/utils/stack/ISafeStack;", "<init>", "Companion", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static final b d;
    public static final a e;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final ew<Function0<Unit>> b;
    public String c;

    /* loaded from: classes.dex */
    public static final class a {
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

        public final b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b.d;
            }
            return (b) invokeV.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: com.baidu.bdtask.service.cache.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class RunnableC0074b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public RunnableC0074b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Function0 function0;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.b.c() && (function0 = (Function0) this.a.b.a()) != null) {
                function0.invoke();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(783401306, "Lcom/baidu/bdtask/service/cache/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(783401306, "Lcom/baidu/bdtask/service/cache/b;");
                return;
            }
        }
        e = new a(null);
        d = new b();
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
                return;
            }
        }
        this.a = TaskState.key;
        this.b = new fw();
        this.c = "";
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String a2 = vr.c.c().a(this.a);
            if (a2 == null) {
                return "";
            }
            return a2;
        }
        return (String) invokeV.objValue;
    }

    public final boolean e(TaskInfo taskInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, taskInfo)) == null) {
            if (taskInfo == null) {
                return false;
            }
            if (!taskInfo.getTaskRule().isNeedPersist() && !taskInfo.isPassiveTask()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void c(final com.baidu.bdtask.ctrl.b bVar, TaskInfo taskInfo, final boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, taskInfo, z) == null) {
            DebugTrace.a.c(new Function0<String>(z, bVar) { // from class: com.baidu.bdtask.service.cache.TaskCacheManager$cacheTasks$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean $force;
                public final /* synthetic */ com.baidu.bdtask.ctrl.b $state;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Boolean.valueOf(z), bVar};
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
                    this.$force = z;
                    this.$state = bVar;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return "save requested force:" + this.$force + " will save " + this.$state.m();
                    }
                    return (String) invokeV.objValue;
                }
            });
            if (!z) {
                if (taskInfo == null) {
                    SubTaskState c = com.baidu.bdtask.ctrl.b.c(bVar, null, 1, null);
                    if (c != null) {
                        taskInfo = c.getTaskInfo();
                    } else {
                        taskInfo = null;
                    }
                }
                if (taskInfo != null) {
                    if (!e(taskInfo)) {
                        DebugTrace.a.c(TaskCacheManager$cacheTasks$2.INSTANCE);
                        return;
                    }
                } else {
                    return;
                }
            }
            this.b.b();
            this.b.a(new Function0<Unit>(this, bVar) { // from class: com.baidu.bdtask.service.cache.TaskCacheManager$cacheTasks$3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.baidu.bdtask.ctrl.b $state;
                public final /* synthetic */ b this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bVar};
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
                    this.this$0 = this;
                    this.$state = bVar;
                }

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    String str;
                    String str2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        String m = this.$state.m();
                        Charset charset = Charsets.UTF_8;
                        if (m != null) {
                            byte[] bytes = m.getBytes(charset);
                            Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                            String newFingerprint = yt.b(bytes, false);
                            str = this.this$0.c;
                            if (Intrinsics.areEqual(newFingerprint, str)) {
                                DebugTrace.a.c(AnonymousClass1.INSTANCE);
                                return;
                            }
                            b bVar2 = this.this$0;
                            Intrinsics.checkExpressionValueIsNotNull(newFingerprint, "newFingerprint");
                            bVar2.c = newFingerprint;
                            DebugTrace.a.c(new Function0<String>(this, m) { // from class: com.baidu.bdtask.service.cache.TaskCacheManager$cacheTasks$3.2
                                public static /* synthetic */ Interceptable $ic;
                                public final /* synthetic */ String $data;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ TaskCacheManager$cacheTasks$3 this$0;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, m};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            super(((Integer) newInitContext.callArgs[0]).intValue());
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$0 = this;
                                    this.$data = m;
                                }

                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    InterceptResult invokeV;
                                    String str3;
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || (invokeV = interceptable3.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("fingerprint:");
                                        str3 = this.this$0.this$0.c;
                                        sb.append(str3);
                                        sb.append(" save state:");
                                        sb.append(this.$data);
                                        return sb.toString();
                                    }
                                    return (String) invokeV.objValue;
                                }
                            });
                            ss c2 = vr.c.c();
                            str2 = this.this$0.a;
                            c2.a(m, str2);
                            return;
                        }
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                }
            });
            ExecutorUtilsExt.postOnSerial(new RunnableC0074b(this), "storageSync");
        }
    }

    public final synchronized boolean f(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            synchronized (this) {
                TaskState m = BDPTask.m.m(str);
                if (m != null) {
                    if (m.getTaskInfo().getTaskRule().isNeedUnique() && !TextUtils.isEmpty(str2)) {
                        return !m.getTaskStatus().getProcess().isContainsInDuplicateIds(str2);
                    }
                    return true;
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
