package com.baidu.bdtask.component;

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
import com.baidu.bdtask.utils.b;
import com.baidu.tieba.es;
import com.baidu.tieba.fs;
import com.baidu.tieba.hv;
import com.baidu.tieba.ls;
import com.baidu.tieba.ms;
import com.baidu.tieba.qp;
import com.baidu.tieba.ts;
import com.baidu.tieba.up;
import com.baidu.tieba.us;
import com.baidu.tieba.vs;
import com.baidu.tieba.zq;
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
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final Lazy a;
    public static final C0062a b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.bdtask.component.a$a */
    /* loaded from: classes.dex */
    public static final class C0062a {
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
            a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(C0062a.class), "INSTANCE", "getINSTANCE()Lcom/baidu/bdtask/component/GuideViewManager;"))};
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

        public C0062a() {
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

        public /* synthetic */ C0062a(DefaultConstructorMarker defaultConstructorMarker) {
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
        b = new C0062a(null);
        a = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) GuideViewManager$Companion$INSTANCE$2.INSTANCE);
    }

    public a() {
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

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* bridge */ /* synthetic */ void c(a aVar, int i, TaskUIData taskUIData, TaskInfo taskInfo, TaskStatus taskStatus, vs vsVar, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            vsVar = null;
        }
        aVar.b(i, taskUIData, taskInfo, taskStatus, vsVar);
    }

    public final void b(int i, TaskUIData taskUIData, TaskInfo taskInfo, TaskStatus taskStatus, vs vsVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), taskUIData, taskInfo, taskStatus, vsVar}) == null) {
            DebugTrace debugTrace = DebugTrace.a;
            debugTrace.a("showGuide guide type : " + i);
            if (i != 1) {
                if (i == 3) {
                    d(taskUIData, taskInfo, taskStatus);
                    return;
                }
                return;
            }
            e(taskUIData, taskInfo, taskStatus, vsVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0023, code lost:
        if ((r0 instanceof com.baidu.tieba.ms) == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(TaskUIData taskUIData, TaskInfo taskInfo, TaskStatus taskStatus) {
        Class<? extends ms<? extends ls<?>>> cls;
        ms<? extends ls<?>> newInstance;
        Class<? extends ls<?>> cls2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, taskUIData, taskInfo, taskStatus) == null) {
            b bVar = b.a;
            es a2 = zq.c.e().a();
            ls<?> lsVar = null;
            if (a2 != null) {
                cls = a2.a();
            } else {
                cls = null;
            }
            if (cls != null) {
                try {
                    newInstance = cls.newInstance();
                } catch (Exception unused) {
                }
            }
            newInstance = null;
            ms<? extends ls<?>> msVar = newInstance;
            b bVar2 = b.a;
            es a3 = zq.c.e().a();
            if (a3 != null) {
                cls2 = a3.b();
            } else {
                cls2 = null;
            }
            if (cls2 != null) {
                try {
                    ls<?> newInstance2 = cls2.newInstance();
                    if (newInstance2 instanceof ls) {
                        lsVar = newInstance2;
                    }
                } catch (Exception unused2) {
                }
            }
            ls<?> lsVar2 = lsVar;
            if (msVar != null && lsVar2 != null) {
                TaskUIBtn backBtn = taskUIData.getBackBtn();
                TaskUIBtn cancelBtn = taskUIData.getCancelBtn();
                String actionId = taskInfo.getActionId();
                String actTaskId = taskInfo.getActTaskId();
                String singleKey = taskInfo.getSingleKey();
                int i = 1;
                if (taskUIData.getModalType() != 1) {
                    i = 2;
                }
                new qp(msVar, lsVar2, new TaskDialogViewData(actionId, actTaskId, singleKey, i, taskUIData.getTxtColor(), taskUIData.getBgUrl(), backBtn.getTxtColor(), backBtn.getTxt(), backBtn.getBgUrl(), backBtn.getScheme(), cancelBtn.getTxt(), cancelBtn.getBgUrl(), cancelBtn.getTxtColor(), cancelBtn.getScheme(), taskUIData.getCloseBg())).a();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0023, code lost:
        if ((r0 instanceof com.baidu.tieba.us) == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(TaskUIData taskUIData, TaskInfo taskInfo, TaskStatus taskStatus, vs vsVar) {
        Class<? extends us<? extends ts<?>>> cls;
        us<? extends ts<?>> newInstance;
        Class<? extends ts<?>> cls2;
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, taskUIData, taskInfo, taskStatus, vsVar) == null) {
            b bVar = b.a;
            fs b2 = zq.c.e().b();
            ts<?> tsVar = null;
            if (b2 != null) {
                cls = b2.b();
            } else {
                cls = null;
            }
            if (cls != null) {
                try {
                    newInstance = cls.newInstance();
                } catch (Exception unused) {
                }
            }
            newInstance = null;
            us<? extends ts<?>> usVar = newInstance;
            b bVar2 = b.a;
            fs b3 = zq.c.e().b();
            if (b3 != null) {
                cls2 = b3.c();
            } else {
                cls2 = null;
            }
            if (cls2 != null) {
                try {
                    ts<?> newInstance2 = cls2.newInstance();
                    if (newInstance2 instanceof ts) {
                        tsVar = newInstance2;
                    }
                } catch (Exception unused2) {
                }
            }
            ts<?> tsVar2 = tsVar;
            if (usVar != null && tsVar2 != null) {
                fs b4 = zq.c.e().b();
                if (b4 != null) {
                    z = b4.a();
                } else {
                    z = false;
                }
                hv.h(z);
                TaskUIBtn backBtn = taskUIData.getBackBtn();
                if (backBtn.isEmpty()) {
                    i = 1;
                } else {
                    i = 2;
                }
                new up(usVar, tsVar2, new TaskToastViewData(taskInfo, taskStatus, i, taskUIData.getBackColor(), taskUIData.getBgUrl(), taskUIData.getMessage(), taskUIData.getDuration(), taskUIData.getTxtColor(), backBtn.getColor(), backBtn.getTxt(), backBtn.getBgUrl(), backBtn.getTxtColor(), backBtn.getScheme(), vsVar)).a();
            }
        }
    }
}
