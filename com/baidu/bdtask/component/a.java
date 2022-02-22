package com.baidu.bdtask.component;

import c.a.j.h.c.b.b;
import c.a.j.h.c.d.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.component.dialog.TaskDialogViewData;
import com.baidu.bdtask.component.toast.TaskToastViewData;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.model.response.NextActive;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.bdtask.model.ui.TaskUIBtn;
import com.baidu.bdtask.model.ui.TaskUIData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u0015:\u0001\u0015B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ9\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J3\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/baidu/bdtask/component/GuideViewManager;", "Lcom/baidu/bdtask/model/ui/TaskUIData;", "data", "Lcom/baidu/bdtask/model/info/TaskInfo;", NextActive.keyTaskInfo, "Lcom/baidu/bdtask/ctrl/model/TaskStatus;", TaskStatus.key, "", "showDialog", "(Lcom/baidu/bdtask/model/ui/TaskUIData;Lcom/baidu/bdtask/model/info/TaskInfo;Lcom/baidu/bdtask/ctrl/model/TaskStatus;)V", "", TaskResponseData.keyUiType, "uiData", "Lcom/baidu/bdtask/framework/ui/toast/ToastLayoutParams;", "toastLayoutParams", "showGuide", "(ILcom/baidu/bdtask/model/ui/TaskUIData;Lcom/baidu/bdtask/model/info/TaskInfo;Lcom/baidu/bdtask/ctrl/model/TaskStatus;Lcom/baidu/bdtask/framework/ui/toast/ToastLayoutParams;)V", "showToast", "(Lcom/baidu/bdtask/model/ui/TaskUIData;Lcom/baidu/bdtask/model/info/TaskInfo;Lcom/baidu/bdtask/ctrl/model/TaskStatus;Lcom/baidu/bdtask/framework/ui/toast/ToastLayoutParams;)V", "<init>", "()V", "Companion", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final Lazy a;

    /* renamed from: b  reason: collision with root package name */
    public static final C1785a f33167b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.bdtask.component.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C1785a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ KProperty[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-781242135, "Lcom/baidu/bdtask/component/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-781242135, "Lcom/baidu/bdtask/component/a$a;");
                    return;
                }
            }
            a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(C1785a.class), "INSTANCE", "getINSTANCE()Lcom/baidu/bdtask/component/GuideViewManager;"))};
        }

        public C1785a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public final a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Lazy lazy = a.a;
                KProperty kProperty = a[0];
                return (a) lazy.getValue();
            }
            return (a) invokeV.objValue;
        }

        public /* synthetic */ C1785a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1417571130, "Lcom/baidu/bdtask/component/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1417571130, "Lcom/baidu/bdtask/component/a;");
                return;
            }
        }
        f33167b = new C1785a(null);
        a = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) GuideViewManager$Companion$INSTANCE$2.INSTANCE);
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static /* bridge */ /* synthetic */ void c(a aVar, int i2, TaskUIData taskUIData, TaskInfo taskInfo, TaskStatus taskStatus, c cVar, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            cVar = null;
        }
        aVar.b(i2, taskUIData, taskInfo, taskStatus, cVar);
    }

    public final void b(int i2, TaskUIData taskUIData, TaskInfo taskInfo, TaskStatus taskStatus, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), taskUIData, taskInfo, taskStatus, cVar}) == null) {
            DebugTrace debugTrace = DebugTrace.a;
            debugTrace.a("showGuide guide type : " + i2);
            if (i2 == 1) {
                e(taskUIData, taskInfo, taskStatus, cVar);
            } else if (i2 != 3) {
            } else {
                d(taskUIData, taskInfo, taskStatus);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:
        if ((r0 instanceof c.a.j.h.c.b.b) == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(TaskUIData taskUIData, TaskInfo taskInfo, TaskStatus taskStatus) {
        b<? extends c.a.j.h.c.b.a<?>> newInstance;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, taskUIData, taskInfo, taskStatus) == null) {
            com.baidu.bdtask.utils.b bVar = com.baidu.bdtask.utils.b.a;
            c.a.j.h.b.i.a a2 = c.a.j.h.b.b.f4057c.e().a();
            c.a.j.h.c.b.a<?> aVar = null;
            Class<? extends b<? extends c.a.j.h.c.b.a<?>>> a3 = a2 != null ? a2.a() : null;
            if (a3 != null) {
                try {
                    newInstance = a3.newInstance();
                } catch (Exception unused) {
                }
            }
            newInstance = null;
            b<? extends c.a.j.h.c.b.a<?>> bVar2 = newInstance;
            com.baidu.bdtask.utils.b bVar3 = com.baidu.bdtask.utils.b.a;
            c.a.j.h.b.i.a a4 = c.a.j.h.b.b.f4057c.e().a();
            Class<? extends c.a.j.h.c.b.a<?>> b2 = a4 != null ? a4.b() : null;
            if (b2 != null) {
                try {
                    c.a.j.h.c.b.a<?> newInstance2 = b2.newInstance();
                    if (newInstance2 instanceof c.a.j.h.c.b.a) {
                        aVar = newInstance2;
                    }
                } catch (Exception unused2) {
                }
            }
            c.a.j.h.c.b.a<?> aVar2 = aVar;
            if (bVar2 == null || aVar2 == null) {
                return;
            }
            TaskUIBtn backBtn = taskUIData.getBackBtn();
            TaskUIBtn cancelBtn = taskUIData.getCancelBtn();
            new c.a.j.e.b.b(bVar2, aVar2, new TaskDialogViewData(taskInfo.getActionId(), taskInfo.getActTaskId(), taskInfo.getSingleKey(), taskUIData.getModalType() != 1 ? 2 : 1, taskUIData.getTxtColor(), taskUIData.getBgUrl(), backBtn.getTxtColor(), backBtn.getTxt(), backBtn.getBgUrl(), backBtn.getScheme(), cancelBtn.getTxt(), cancelBtn.getBgUrl(), cancelBtn.getTxtColor(), cancelBtn.getScheme(), taskUIData.getCloseBg())).a();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:
        if ((r0 instanceof c.a.j.h.c.d.b) == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(TaskUIData taskUIData, TaskInfo taskInfo, TaskStatus taskStatus, c cVar) {
        c.a.j.h.c.d.b<? extends c.a.j.h.c.d.a<?>> newInstance;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, taskUIData, taskInfo, taskStatus, cVar) == null) {
            com.baidu.bdtask.utils.b bVar = com.baidu.bdtask.utils.b.a;
            c.a.j.h.b.i.b b2 = c.a.j.h.b.b.f4057c.e().b();
            c.a.j.h.c.d.a<?> aVar = null;
            Class<? extends c.a.j.h.c.d.b<? extends c.a.j.h.c.d.a<?>>> b3 = b2 != null ? b2.b() : null;
            if (b3 != null) {
                try {
                    newInstance = b3.newInstance();
                } catch (Exception unused) {
                }
            }
            newInstance = null;
            c.a.j.h.c.d.b<? extends c.a.j.h.c.d.a<?>> bVar2 = newInstance;
            com.baidu.bdtask.utils.b bVar3 = com.baidu.bdtask.utils.b.a;
            c.a.j.h.b.i.b b4 = c.a.j.h.b.b.f4057c.e().b();
            Class<? extends c.a.j.h.c.d.a<?>> c2 = b4 != null ? b4.c() : null;
            if (c2 != null) {
                try {
                    c.a.j.h.c.d.a<?> newInstance2 = c2.newInstance();
                    if (newInstance2 instanceof c.a.j.h.c.d.a) {
                        aVar = newInstance2;
                    }
                } catch (Exception unused2) {
                }
            }
            c.a.j.h.c.d.a<?> aVar2 = aVar;
            if (bVar2 == null || aVar2 == null) {
                return;
            }
            c.a.j.h.b.i.b b5 = c.a.j.h.b.b.f4057c.e().b();
            c.a.j.m.c.h(b5 != null ? b5.a() : false);
            TaskUIBtn backBtn = taskUIData.getBackBtn();
            new c.a.j.e.d.b(bVar2, aVar2, new TaskToastViewData(taskInfo, taskStatus, backBtn.isEmpty() ? 1 : 2, taskUIData.getBackColor(), taskUIData.getBgUrl(), taskUIData.getMessage(), taskUIData.getDuration(), taskUIData.getTxtColor(), backBtn.getColor(), backBtn.getTxt(), backBtn.getBgUrl(), backBtn.getTxtColor(), backBtn.getScheme(), cVar)).a();
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
