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
import com.repackage.bs;
import com.repackage.cs;
import com.repackage.ev;
import com.repackage.is;
import com.repackage.js;
import com.repackage.np;
import com.repackage.qs;
import com.repackage.rp;
import com.repackage.rs;
import com.repackage.ss;
import com.repackage.wq;
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
    public static final C0061a b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.bdtask.component.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0061a {
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
            a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(C0061a.class), "INSTANCE", "getINSTANCE()Lcom/baidu/bdtask/component/GuideViewManager;"))};
        }

        public C0061a() {
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

        public /* synthetic */ C0061a(DefaultConstructorMarker defaultConstructorMarker) {
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
        b = new C0061a(null);
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

    public static /* bridge */ /* synthetic */ void c(a aVar, int i, TaskUIData taskUIData, TaskInfo taskInfo, TaskStatus taskStatus, ss ssVar, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            ssVar = null;
        }
        aVar.b(i, taskUIData, taskInfo, taskStatus, ssVar);
    }

    public final void b(int i, TaskUIData taskUIData, TaskInfo taskInfo, TaskStatus taskStatus, ss ssVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), taskUIData, taskInfo, taskStatus, ssVar}) == null) {
            DebugTrace debugTrace = DebugTrace.a;
            debugTrace.a("showGuide guide type : " + i);
            if (i == 1) {
                e(taskUIData, taskInfo, taskStatus, ssVar);
            } else if (i != 3) {
            } else {
                d(taskUIData, taskInfo, taskStatus);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:
        if ((r0 instanceof com.repackage.js) == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(TaskUIData taskUIData, TaskInfo taskInfo, TaskStatus taskStatus) {
        js<? extends is<?>> newInstance;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, taskUIData, taskInfo, taskStatus) == null) {
            b bVar = b.a;
            bs a2 = wq.c.e().a();
            is<?> isVar = null;
            Class<? extends js<? extends is<?>>> a3 = a2 != null ? a2.a() : null;
            if (a3 != null) {
                try {
                    newInstance = a3.newInstance();
                } catch (Exception unused) {
                }
            }
            newInstance = null;
            js<? extends is<?>> jsVar = newInstance;
            b bVar2 = b.a;
            bs a4 = wq.c.e().a();
            Class<? extends is<?>> b2 = a4 != null ? a4.b() : null;
            if (b2 != null) {
                try {
                    is<?> newInstance2 = b2.newInstance();
                    if (newInstance2 instanceof is) {
                        isVar = newInstance2;
                    }
                } catch (Exception unused2) {
                }
            }
            is<?> isVar2 = isVar;
            if (jsVar == null || isVar2 == null) {
                return;
            }
            TaskUIBtn backBtn = taskUIData.getBackBtn();
            TaskUIBtn cancelBtn = taskUIData.getCancelBtn();
            new np(jsVar, isVar2, new TaskDialogViewData(taskInfo.getActionId(), taskInfo.getActTaskId(), taskInfo.getSingleKey(), taskUIData.getModalType() != 1 ? 2 : 1, taskUIData.getTxtColor(), taskUIData.getBgUrl(), backBtn.getTxtColor(), backBtn.getTxt(), backBtn.getBgUrl(), backBtn.getScheme(), cancelBtn.getTxt(), cancelBtn.getBgUrl(), cancelBtn.getTxtColor(), cancelBtn.getScheme(), taskUIData.getCloseBg())).a();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:
        if ((r0 instanceof com.repackage.rs) == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(TaskUIData taskUIData, TaskInfo taskInfo, TaskStatus taskStatus, ss ssVar) {
        rs<? extends qs<?>> newInstance;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, taskUIData, taskInfo, taskStatus, ssVar) == null) {
            b bVar = b.a;
            cs b2 = wq.c.e().b();
            qs<?> qsVar = null;
            Class<? extends rs<? extends qs<?>>> b3 = b2 != null ? b2.b() : null;
            if (b3 != null) {
                try {
                    newInstance = b3.newInstance();
                } catch (Exception unused) {
                }
            }
            newInstance = null;
            rs<? extends qs<?>> rsVar = newInstance;
            b bVar2 = b.a;
            cs b4 = wq.c.e().b();
            Class<? extends qs<?>> c = b4 != null ? b4.c() : null;
            if (c != null) {
                try {
                    qs<?> newInstance2 = c.newInstance();
                    if (newInstance2 instanceof qs) {
                        qsVar = newInstance2;
                    }
                } catch (Exception unused2) {
                }
            }
            qs<?> qsVar2 = qsVar;
            if (rsVar == null || qsVar2 == null) {
                return;
            }
            cs b5 = wq.c.e().b();
            ev.h(b5 != null ? b5.a() : false);
            TaskUIBtn backBtn = taskUIData.getBackBtn();
            new rp(rsVar, qsVar2, new TaskToastViewData(taskInfo, taskStatus, backBtn.isEmpty() ? 1 : 2, taskUIData.getBackColor(), taskUIData.getBgUrl(), taskUIData.getMessage(), taskUIData.getDuration(), taskUIData.getTxtColor(), backBtn.getColor(), backBtn.getTxt(), backBtn.getBgUrl(), backBtn.getTxtColor(), backBtn.getScheme(), ssVar)).a();
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
