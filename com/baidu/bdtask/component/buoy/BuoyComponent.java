package com.baidu.bdtask.component.buoy;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.TaskState;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.bdtask.model.guide.TaskGuideData;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.model.response.NextActive;
import com.baidu.bdtask.model.response.TaskProcessData;
import com.baidu.bdtask.model.ui.TaskUIData;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fr;
import com.repackage.hv;
import com.repackage.ku;
import com.repackage.pq;
import com.repackage.qv;
import com.repackage.qw;
import com.repackage.rq;
import com.repackage.rt;
import com.repackage.rv;
import com.repackage.vu;
import com.repackage.wu;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 F2\u00020\u0001:\u0001FB+\u0012\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020?0=\u0012\u0006\u0010B\u001a\u00020?\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\bD\u0010EJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000b\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u001d\u0010\u0019J\u0017\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\fH\u0016¢\u0006\u0004\b \u0010!J\u001f\u0010\"\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0006H\u0014¢\u0006\u0004\b$\u0010\nJ\u001b\u0010&\u001a\u00020\f2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0006H\u0002¢\u0006\u0004\b(\u0010\nJ!\u0010)\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0017¢\u0006\u0004\b)\u0010#R\u0016\u0010*\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010+R\u0016\u0010-\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010+R\u0016\u0010.\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010+R*\u00100\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00106\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010<R\"\u0010@\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020?0=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010C¨\u0006G"}, d2 = {"Lcom/baidu/bdtask/component/buoy/BuoyComponent;", "Lcom/repackage/fr;", "Landroid/view/ViewGroup;", "viewGroup", "Landroid/view/ViewGroup$LayoutParams;", "layoutParams", "", "attachToWindow", "(Landroid/view/ViewGroup;Landroid/view/ViewGroup$LayoutParams;)V", "buoyViewRemoveFromWindow", "()V", "destroy", "", "sync", "(Z)V", "detachFromWindow", "Lcom/baidu/bdtask/framework/ui/buoy/IBuoyView;", "getBuoyView", "()Lcom/baidu/bdtask/framework/ui/buoy/IBuoyView;", "Lcom/baidu/bdtask/model/info/TaskInfo;", NextActive.keyTaskInfo, "Lcom/baidu/bdtask/ctrl/model/TaskStatus;", TaskStatus.key, "", "getCurProcessRate", "(Lcom/baidu/bdtask/model/info/TaskInfo;Lcom/baidu/bdtask/ctrl/model/TaskStatus;)F", "", "getFormatTotal", "(Lcom/baidu/bdtask/model/info/TaskInfo;Lcom/baidu/bdtask/ctrl/model/TaskStatus;)J", "getFullProcessRate", "isSingleProcessDuplicated", "(Lcom/baidu/bdtask/ctrl/model/TaskStatus;)Z", "isValid", "()Z", "onChanged", "(Lcom/baidu/bdtask/model/info/TaskInfo;Lcom/baidu/bdtask/ctrl/model/TaskStatus;)V", "onDuplicated", "curTaskInfo", "taskSignCheck", "(Lcom/baidu/bdtask/model/info/TaskInfo;)Z", "tryAttachBuoyVie2Window", "update", "bindTaskHasUnRegistered", "Z", "hasAttached", "hasDestroyed", "hasShowUBCRecord", "Lkotlin/Function0;", "lazyAttach", "Lkotlin/Function0;", "getLazyAttach", "()Lkotlin/jvm/functions/Function0;", "setLazyAttach", "(Lkotlin/jvm/functions/Function0;)V", "rootView", "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "setRootView", "(Landroid/view/ViewGroup;)V", "Lcom/baidu/bdtask/model/info/TaskInfo;", "Lcom/baidu/bdtask/framework/ui/buoy/BaseBuoyView;", "Lcom/baidu/bdtask/component/buoy/TaskBuoyViewData;", "Lcom/baidu/bdtask/component/buoy/TaskBuoyViewModel;", NativeConstants.TYPE_VIEW, "Lcom/baidu/bdtask/framework/ui/buoy/BaseBuoyView;", "viewModel", "Lcom/baidu/bdtask/component/buoy/TaskBuoyViewModel;", "<init>", "(Lcom/baidu/bdtask/framework/ui/buoy/BaseBuoyView;Lcom/baidu/bdtask/component/buoy/TaskBuoyViewModel;Lcom/baidu/bdtask/model/info/TaskInfo;)V", "Companion", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public abstract class BuoyComponent implements fr {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public boolean c;
    public ViewGroup d;
    public Function0<Unit> e;
    public final rt<TaskBuoyViewData, TaskBuoyViewModel> f;
    public final TaskBuoyViewModel g;
    public final TaskInfo h;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
    /* loaded from: classes.dex */
    public static final class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BuoyComponent a;
        public final /* synthetic */ TaskStatus b;
        public final /* synthetic */ TaskInfo c;

        public b(BuoyComponent buoyComponent, TaskStatus taskStatus, TaskInfo taskInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buoyComponent, taskStatus, taskInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = buoyComponent;
            this.b = taskStatus;
            this.c = taskInfo;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v20, resolved type: T */
        /* JADX DEBUG: Multi-variable search result rejected for r2v21, resolved type: T */
        /* JADX DEBUG: Multi-variable search result rejected for r2v23, resolved type: T */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [com.baidu.bdtask.ctrl.model.TaskStatus, T] */
        /* JADX WARN: Type inference failed for: r3v12, types: [com.baidu.bdtask.ctrl.model.TaskStatus, T] */
        /* JADX WARN: Type inference failed for: r4v4, types: [T, com.baidu.bdtask.model.ui.TaskUIData] */
        /* JADX WARN: Type inference failed for: r7v2, types: [T, com.baidu.bdtask.model.ui.TaskUIData] */
        @Override // java.lang.Runnable
        public final void run() {
            rq rqVar;
            qv f;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.u()) {
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                ?? r2 = this.b;
                objectRef.element = r2;
                if (((TaskStatus) r2) == null) {
                    TaskState m = BDPTask.m.m(this.c.getActionId());
                    objectRef.element = m != null ? m.getTaskStatus() : 0;
                }
                T t = objectRef.element;
                if (((TaskStatus) t) != null && ((TaskStatus) t).isEnable()) {
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = this.c.getTaskMeter().getUi();
                    long r = this.a.r(this.c, (TaskStatus) objectRef.element);
                    vu a = wu.a.a((TaskStatus) objectRef.element, this.c);
                    int b = a.b();
                    ?? a2 = a.a();
                    if (a2 != 0) {
                        objectRef2.element = a2;
                    }
                    if (TaskGuideData.Companion.a(b)) {
                        this.a.y();
                        pq pqVar = new pq(b, ((TaskUIData) objectRef2.element).getMessage(), ((TaskUIData) objectRef2.element).getTxtColor(), ((TaskUIData) objectRef2.element).getBgUrl(), ((TaskUIData) objectRef2.element).getProgress().getForeColor(), ((TaskUIData) objectRef2.element).getProgress().getBackColor(), ((TaskUIData) objectRef2.element).getCloseBg(), ((TaskUIData) objectRef2.element).getBackBtn().getScheme());
                        TaskProcessData processData = this.c.getResponse().isEmpty() ? null : this.c.getResponse().getProcessData();
                        rq rqVar2 = new rq(this.a.q(this.c, (TaskStatus) objectRef.element), r);
                        if (this.a.t((TaskStatus) objectRef.element)) {
                            ?? a3 = qw.a.a((TaskStatus) objectRef.element);
                            objectRef.element = a3;
                            rq rqVar3 = new rq(this.a.s(this.c, (TaskStatus) a3), r);
                            this.a.v();
                            rqVar = rqVar3;
                        } else {
                            rqVar = rqVar2;
                        }
                        TaskBuoyViewData taskBuoyViewData = new TaskBuoyViewData((TaskStatus) objectRef.element, pqVar, rqVar, processData, ((TaskUIData) objectRef2.element).getExtra());
                        DebugTrace.a.c(new BuoyComponent$update$1$4(objectRef, objectRef2, taskBuoyViewData));
                        this.a.g.f(taskBuoyViewData);
                        if (this.a.c) {
                            return;
                        }
                        this.a.c = true;
                        String str = TaskGuideData.Companion.b(a.b()) ? "y_task_icon" : "y_task_diyicon";
                        String c = rv.a.c((TaskStatus) objectRef.element);
                        hv v = BDPTask.m.v();
                        if (v == null || (f = v.f()) == null) {
                            return;
                        }
                        f.a(str, "c_pv", rv.a.a(this.c.getId(), this.c.getActTaskId(), c));
                        return;
                    }
                    DebugTrace.a.c(new BuoyComponent$update$1$3(b));
                    this.a.m();
                    return;
                }
                DebugTrace.a.c(new BuoyComponent$update$1$1(objectRef));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1021537311, "Lcom/baidu/bdtask/component/buoy/BuoyComponent;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1021537311, "Lcom/baidu/bdtask/component/buoy/BuoyComponent;");
        }
    }

    public BuoyComponent(rt<TaskBuoyViewData, TaskBuoyViewModel> rtVar, TaskBuoyViewModel taskBuoyViewModel, TaskInfo taskInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rtVar, taskBuoyViewModel, taskInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = rtVar;
        this.g = taskBuoyViewModel;
        this.h = taskInfo;
        rtVar.a(taskBuoyViewModel);
    }

    public static /* synthetic */ boolean x(BuoyComponent buoyComponent, TaskInfo taskInfo, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                taskInfo = null;
            }
            return buoyComponent.w(taskInfo);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: taskSignCheck");
    }

    @Override // com.repackage.mq
    public void a(TaskInfo taskInfo, TaskStatus taskStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, taskInfo, taskStatus) == null) {
            DebugTrace.a.c(new BuoyComponent$onChanged$1(taskInfo));
            DebugTrace.a.c(new BuoyComponent$onChanged$2(taskInfo));
            update(taskInfo, taskStatus);
            if (taskStatus.isUnRegistered()) {
                this.b = true;
                DebugTrace.a.c(BuoyComponent$onChanged$3.INSTANCE);
            }
        }
    }

    public void l(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, layoutParams) == null) && u()) {
            this.e = new BuoyComponent$attachToWindow$1(this, viewGroup, layoutParams);
            this.d = viewGroup;
            BDPTask.m.z(this.h, this);
        }
    }

    public final void m() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ViewGroup viewGroup2 = this.d;
            if ((viewGroup2 == null || viewGroup2.indexOfChild(this.f.getContentView()) != -1) && (viewGroup = this.d) != null) {
                viewGroup.removeView(this.f.getContentView());
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            o(true);
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            p();
            this.a = true;
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            m();
            this.e = null;
            BDPTask.m.G(this.h.getActionId(), this);
        }
    }

    public abstract float q(TaskInfo taskInfo, TaskStatus taskStatus);

    public abstract long r(TaskInfo taskInfo, TaskStatus taskStatus);

    public abstract float s(TaskInfo taskInfo, TaskStatus taskStatus);

    public boolean t(TaskStatus taskStatus) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, taskStatus)) == null) ? taskStatus.isDuplicated() : invokeL.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            DebugTrace.a.c(new BuoyComponent$isValid$1(this));
            return (this.a || !x(this, null, 1, null) || this.b) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public synchronized void update(TaskInfo taskInfo, TaskStatus taskStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, taskInfo, taskStatus) == null) {
            synchronized (this) {
                ku.c(new b(this, taskStatus, taskInfo));
            }
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.bdtask.model.info.TaskInfo */
    /* JADX DEBUG: Multi-variable search result rejected for r5v12, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r5v13, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r5v15, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean w(TaskInfo taskInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, taskInfo)) == null) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = taskInfo;
            if (taskInfo == null) {
                TaskState m = BDPTask.m.m(this.h.getActionId());
                objectRef.element = m != null ? m.getTaskInfo() : 0;
            }
            if (((TaskInfo) objectRef.element) != null) {
                DebugTrace.a.c(new BuoyComponent$taskSignCheck$1(this, objectRef));
                return Intrinsics.areEqual(((TaskInfo) objectRef.element).getSingleKey(), this.h.getSingleKey());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void y() {
        Function0<Unit> function0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            View contentView = this.f.getContentView();
            if ((contentView != null ? contentView.getParent() : null) == null && (function0 = this.e) != null) {
                function0.invoke();
            }
        }
    }
}
