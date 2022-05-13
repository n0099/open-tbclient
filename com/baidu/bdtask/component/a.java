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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ar;
import com.repackage.du;
import com.repackage.er;
import com.repackage.eu;
import com.repackage.fu;
import com.repackage.js;
import com.repackage.ot;
import com.repackage.pt;
import com.repackage.rw;
import com.repackage.vt;
import com.repackage.wt;
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

    /* renamed from: com.baidu.bdtask.component.a$a  reason: collision with other inner class name */
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

    public static /* bridge */ /* synthetic */ void c(a aVar, int i, TaskUIData taskUIData, TaskInfo taskInfo, TaskStatus taskStatus, fu fuVar, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            fuVar = null;
        }
        aVar.b(i, taskUIData, taskInfo, taskStatus, fuVar);
    }

    public final void b(int i, TaskUIData taskUIData, TaskInfo taskInfo, TaskStatus taskStatus, fu fuVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), taskUIData, taskInfo, taskStatus, fuVar}) == null) {
            DebugTrace debugTrace = DebugTrace.a;
            debugTrace.a("showGuide guide type : " + i);
            if (i == 1) {
                e(taskUIData, taskInfo, taskStatus, fuVar);
            } else if (i != 3) {
            } else {
                d(taskUIData, taskInfo, taskStatus);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:
        if ((r0 instanceof com.repackage.wt) == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(TaskUIData taskUIData, TaskInfo taskInfo, TaskStatus taskStatus) {
        wt<? extends vt<?>> newInstance;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, taskUIData, taskInfo, taskStatus) == null) {
            b bVar = b.a;
            ot a2 = js.c.e().a();
            vt<?> vtVar = null;
            Class<? extends wt<? extends vt<?>>> a3 = a2 != null ? a2.a() : null;
            if (a3 != null) {
                try {
                    newInstance = a3.newInstance();
                } catch (Exception unused) {
                }
            }
            newInstance = null;
            wt<? extends vt<?>> wtVar = newInstance;
            b bVar2 = b.a;
            ot a4 = js.c.e().a();
            Class<? extends vt<?>> b2 = a4 != null ? a4.b() : null;
            if (b2 != null) {
                try {
                    vt<?> newInstance2 = b2.newInstance();
                    if (newInstance2 instanceof vt) {
                        vtVar = newInstance2;
                    }
                } catch (Exception unused2) {
                }
            }
            vt<?> vtVar2 = vtVar;
            if (wtVar == null || vtVar2 == null) {
                return;
            }
            TaskUIBtn backBtn = taskUIData.getBackBtn();
            TaskUIBtn cancelBtn = taskUIData.getCancelBtn();
            new ar(wtVar, vtVar2, new TaskDialogViewData(taskInfo.getActionId(), taskInfo.getActTaskId(), taskInfo.getSingleKey(), taskUIData.getModalType() != 1 ? 2 : 1, taskUIData.getTxtColor(), taskUIData.getBgUrl(), backBtn.getTxtColor(), backBtn.getTxt(), backBtn.getBgUrl(), backBtn.getScheme(), cancelBtn.getTxt(), cancelBtn.getBgUrl(), cancelBtn.getTxtColor(), cancelBtn.getScheme(), taskUIData.getCloseBg())).a();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:
        if ((r0 instanceof com.repackage.eu) == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(TaskUIData taskUIData, TaskInfo taskInfo, TaskStatus taskStatus, fu fuVar) {
        eu<? extends du<?>> newInstance;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, taskUIData, taskInfo, taskStatus, fuVar) == null) {
            b bVar = b.a;
            pt b2 = js.c.e().b();
            du<?> duVar = null;
            Class<? extends eu<? extends du<?>>> b3 = b2 != null ? b2.b() : null;
            if (b3 != null) {
                try {
                    newInstance = b3.newInstance();
                } catch (Exception unused) {
                }
            }
            newInstance = null;
            eu<? extends du<?>> euVar = newInstance;
            b bVar2 = b.a;
            pt b4 = js.c.e().b();
            Class<? extends du<?>> c = b4 != null ? b4.c() : null;
            if (c != null) {
                try {
                    du<?> newInstance2 = c.newInstance();
                    if (newInstance2 instanceof du) {
                        duVar = newInstance2;
                    }
                } catch (Exception unused2) {
                }
            }
            du<?> duVar2 = duVar;
            if (euVar == null || duVar2 == null) {
                return;
            }
            pt b5 = js.c.e().b();
            rw.h(b5 != null ? b5.a() : false);
            TaskUIBtn backBtn = taskUIData.getBackBtn();
            new er(euVar, duVar2, new TaskToastViewData(taskInfo, taskStatus, backBtn.isEmpty() ? 1 : 2, taskUIData.getBackColor(), taskUIData.getBgUrl(), taskUIData.getMessage(), taskUIData.getDuration(), taskUIData.getTxtColor(), backBtn.getColor(), backBtn.getTxt(), backBtn.getBgUrl(), backBtn.getTxtColor(), backBtn.getScheme(), fuVar)).a();
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
