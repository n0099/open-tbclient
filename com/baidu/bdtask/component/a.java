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
import com.repackage.br;
import com.repackage.gs;
import com.repackage.hs;
import com.repackage.jv;
import com.repackage.ns;
import com.repackage.os;
import com.repackage.sp;
import com.repackage.vs;
import com.repackage.wp;
import com.repackage.ws;
import com.repackage.xs;
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
    public static final C0063a b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.bdtask.component.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0063a {
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
            a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(C0063a.class), "INSTANCE", "getINSTANCE()Lcom/baidu/bdtask/component/GuideViewManager;"))};
        }

        public C0063a() {
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

        public /* synthetic */ C0063a(DefaultConstructorMarker defaultConstructorMarker) {
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
        b = new C0063a(null);
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

    public static /* bridge */ /* synthetic */ void c(a aVar, int i, TaskUIData taskUIData, TaskInfo taskInfo, TaskStatus taskStatus, xs xsVar, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            xsVar = null;
        }
        aVar.b(i, taskUIData, taskInfo, taskStatus, xsVar);
    }

    public final void b(int i, TaskUIData taskUIData, TaskInfo taskInfo, TaskStatus taskStatus, xs xsVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), taskUIData, taskInfo, taskStatus, xsVar}) == null) {
            DebugTrace debugTrace = DebugTrace.a;
            debugTrace.a("showGuide guide type : " + i);
            if (i == 1) {
                e(taskUIData, taskInfo, taskStatus, xsVar);
            } else if (i != 3) {
            } else {
                d(taskUIData, taskInfo, taskStatus);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:
        if ((r0 instanceof com.repackage.os) == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(TaskUIData taskUIData, TaskInfo taskInfo, TaskStatus taskStatus) {
        os<? extends ns<?>> newInstance;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, taskUIData, taskInfo, taskStatus) == null) {
            b bVar = b.a;
            gs a2 = br.c.e().a();
            ns<?> nsVar = null;
            Class<? extends os<? extends ns<?>>> a3 = a2 != null ? a2.a() : null;
            if (a3 != null) {
                try {
                    newInstance = a3.newInstance();
                } catch (Exception unused) {
                }
            }
            newInstance = null;
            os<? extends ns<?>> osVar = newInstance;
            b bVar2 = b.a;
            gs a4 = br.c.e().a();
            Class<? extends ns<?>> b2 = a4 != null ? a4.b() : null;
            if (b2 != null) {
                try {
                    ns<?> newInstance2 = b2.newInstance();
                    if (newInstance2 instanceof ns) {
                        nsVar = newInstance2;
                    }
                } catch (Exception unused2) {
                }
            }
            ns<?> nsVar2 = nsVar;
            if (osVar == null || nsVar2 == null) {
                return;
            }
            TaskUIBtn backBtn = taskUIData.getBackBtn();
            TaskUIBtn cancelBtn = taskUIData.getCancelBtn();
            new sp(osVar, nsVar2, new TaskDialogViewData(taskInfo.getActionId(), taskInfo.getActTaskId(), taskInfo.getSingleKey(), taskUIData.getModalType() != 1 ? 2 : 1, taskUIData.getTxtColor(), taskUIData.getBgUrl(), backBtn.getTxtColor(), backBtn.getTxt(), backBtn.getBgUrl(), backBtn.getScheme(), cancelBtn.getTxt(), cancelBtn.getBgUrl(), cancelBtn.getTxtColor(), cancelBtn.getScheme(), taskUIData.getCloseBg())).a();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:
        if ((r0 instanceof com.repackage.ws) == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(TaskUIData taskUIData, TaskInfo taskInfo, TaskStatus taskStatus, xs xsVar) {
        ws<? extends vs<?>> newInstance;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, taskUIData, taskInfo, taskStatus, xsVar) == null) {
            b bVar = b.a;
            hs b2 = br.c.e().b();
            vs<?> vsVar = null;
            Class<? extends ws<? extends vs<?>>> b3 = b2 != null ? b2.b() : null;
            if (b3 != null) {
                try {
                    newInstance = b3.newInstance();
                } catch (Exception unused) {
                }
            }
            newInstance = null;
            ws<? extends vs<?>> wsVar = newInstance;
            b bVar2 = b.a;
            hs b4 = br.c.e().b();
            Class<? extends vs<?>> c = b4 != null ? b4.c() : null;
            if (c != null) {
                try {
                    vs<?> newInstance2 = c.newInstance();
                    if (newInstance2 instanceof vs) {
                        vsVar = newInstance2;
                    }
                } catch (Exception unused2) {
                }
            }
            vs<?> vsVar2 = vsVar;
            if (wsVar == null || vsVar2 == null) {
                return;
            }
            hs b5 = br.c.e().b();
            jv.h(b5 != null ? b5.a() : false);
            TaskUIBtn backBtn = taskUIData.getBackBtn();
            new wp(wsVar, vsVar2, new TaskToastViewData(taskInfo, taskStatus, backBtn.isEmpty() ? 1 : 2, taskUIData.getBackColor(), taskUIData.getBgUrl(), taskUIData.getMessage(), taskUIData.getDuration(), taskUIData.getTxtColor(), backBtn.getColor(), backBtn.getTxt(), backBtn.getBgUrl(), backBtn.getTxtColor(), backBtn.getScheme(), xsVar)).a();
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
