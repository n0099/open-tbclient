package com.baidu.bdtask.component.buoy;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
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
import com.baidu.tieba.bq;
import com.baidu.tieba.cv;
import com.baidu.tieba.cw;
import com.baidu.tieba.dq;
import com.baidu.tieba.dt;
import com.baidu.tieba.dv;
import com.baidu.tieba.hu;
import com.baidu.tieba.iu;
import com.baidu.tieba.rq;
import com.baidu.tieba.tu;
import com.baidu.tieba.wt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 F2\u00020\u0001:\u0001FB+\u0012\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020?0=\u0012\u0006\u0010B\u001a\u00020?\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\bD\u0010EJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000b\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u001d\u0010\u0019J\u0017\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\fH\u0016¢\u0006\u0004\b \u0010!J\u001f\u0010\"\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0006H\u0014¢\u0006\u0004\b$\u0010\nJ\u001b\u0010&\u001a\u00020\f2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0006H\u0002¢\u0006\u0004\b(\u0010\nJ!\u0010)\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0017¢\u0006\u0004\b)\u0010#R\u0016\u0010*\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010+R\u0016\u0010-\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010+R\u0016\u0010.\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010+R*\u00100\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00106\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010<R\"\u0010@\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020?0=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010C¨\u0006G"}, d2 = {"Lcom/baidu/bdtask/component/buoy/BuoyComponent;", "Lcom/baidu/tieba/rq;", "Landroid/view/ViewGroup;", "viewGroup", "Landroid/view/ViewGroup$LayoutParams;", "layoutParams", "", "attachToWindow", "(Landroid/view/ViewGroup;Landroid/view/ViewGroup$LayoutParams;)V", "buoyViewRemoveFromWindow", "()V", "destroy", "", NativeConstants.COMPONENT_SYNC_TEXT_VIEW, "(Z)V", "detachFromWindow", "Lcom/baidu/bdtask/framework/ui/buoy/IBuoyView;", "getBuoyView", "()Lcom/baidu/bdtask/framework/ui/buoy/IBuoyView;", "Lcom/baidu/bdtask/model/info/TaskInfo;", NextActive.keyTaskInfo, "Lcom/baidu/bdtask/ctrl/model/TaskStatus;", TaskStatus.key, "", "getCurProcessRate", "(Lcom/baidu/bdtask/model/info/TaskInfo;Lcom/baidu/bdtask/ctrl/model/TaskStatus;)F", "", "getFormatTotal", "(Lcom/baidu/bdtask/model/info/TaskInfo;Lcom/baidu/bdtask/ctrl/model/TaskStatus;)J", "getFullProcessRate", "isSingleProcessDuplicated", "(Lcom/baidu/bdtask/ctrl/model/TaskStatus;)Z", "isValid", "()Z", "onChanged", "(Lcom/baidu/bdtask/model/info/TaskInfo;Lcom/baidu/bdtask/ctrl/model/TaskStatus;)V", "onDuplicated", "curTaskInfo", "taskSignCheck", "(Lcom/baidu/bdtask/model/info/TaskInfo;)Z", "tryAttachBuoyVie2Window", StickerDataChangeType.UPDATE, "bindTaskHasUnRegistered", "Z", "hasAttached", "hasDestroyed", "hasShowUBCRecord", "Lkotlin/Function0;", "lazyAttach", "Lkotlin/Function0;", "getLazyAttach", "()Lkotlin/jvm/functions/Function0;", "setLazyAttach", "(Lkotlin/jvm/functions/Function0;)V", "rootView", "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "setRootView", "(Landroid/view/ViewGroup;)V", "Lcom/baidu/bdtask/model/info/TaskInfo;", "Lcom/baidu/bdtask/framework/ui/buoy/BaseBuoyView;", "Lcom/baidu/bdtask/component/buoy/TaskBuoyViewData;", "Lcom/baidu/bdtask/component/buoy/TaskBuoyViewModel;", NativeConstants.TYPE_VIEW, "Lcom/baidu/bdtask/framework/ui/buoy/BaseBuoyView;", "viewModel", "Lcom/baidu/bdtask/component/buoy/TaskBuoyViewModel;", "<init>", "(Lcom/baidu/bdtask/framework/ui/buoy/BaseBuoyView;Lcom/baidu/bdtask/component/buoy/TaskBuoyViewModel;Lcom/baidu/bdtask/model/info/TaskInfo;)V", "Companion", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public abstract class BuoyComponent implements rq {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public boolean c;
    public ViewGroup d;
    public Function0<Unit> e;
    public final dt<TaskBuoyViewData, TaskBuoyViewModel> f;
    public final TaskBuoyViewModel g;
    public final TaskInfo h;

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

    public abstract float q(TaskInfo taskInfo, TaskStatus taskStatus);

    public abstract long r(TaskInfo taskInfo, TaskStatus taskStatus);

    public abstract float s(TaskInfo taskInfo, TaskStatus taskStatus);

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

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
            dq dqVar;
            String str;
            cv f;
            T t;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a.u()) {
                return;
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ?? r2 = this.b;
            objectRef.element = r2;
            TaskProcessData taskProcessData = null;
            if (((TaskStatus) r2) == null) {
                TaskState m = BDPTask.m.m(this.c.getActionId());
                if (m != null) {
                    t = m.getTaskStatus();
                } else {
                    t = 0;
                }
                objectRef.element = t;
            }
            T t2 = objectRef.element;
            if (((TaskStatus) t2) != null && ((TaskStatus) t2).isEnable()) {
                final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.element = this.c.getTaskMeter().getUi();
                long r = this.a.r(this.c, (TaskStatus) objectRef.element);
                hu a = iu.a.a((TaskStatus) objectRef.element, this.c);
                final int b = a.b();
                ?? a2 = a.a();
                if (a2 != 0) {
                    objectRef2.element = a2;
                }
                if (!TaskGuideData.Companion.a(b)) {
                    DebugTrace.a.c(new Function0<String>(b) { // from class: com.baidu.bdtask.component.buoy.BuoyComponent$update$1$3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ int $uiType;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {Integer.valueOf(b)};
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
                            this.$uiType = b;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                                return "uiType:" + this.$uiType + " is not a layer";
                            }
                            return (String) invokeV.objValue;
                        }
                    });
                    this.a.m();
                    return;
                }
                this.a.y();
                bq bqVar = new bq(b, ((TaskUIData) objectRef2.element).getMessage(), ((TaskUIData) objectRef2.element).getTxtColor(), ((TaskUIData) objectRef2.element).getBgUrl(), ((TaskUIData) objectRef2.element).getProgress().getForeColor(), ((TaskUIData) objectRef2.element).getProgress().getBackColor(), ((TaskUIData) objectRef2.element).getCloseBg(), ((TaskUIData) objectRef2.element).getBackBtn().getScheme());
                if (!this.c.getResponse().isEmpty()) {
                    taskProcessData = this.c.getResponse().getProcessData();
                }
                TaskProcessData taskProcessData2 = taskProcessData;
                dq dqVar2 = new dq(this.a.q(this.c, (TaskStatus) objectRef.element), r);
                if (this.a.t((TaskStatus) objectRef.element)) {
                    ?? a3 = cw.a.a((TaskStatus) objectRef.element);
                    objectRef.element = a3;
                    dq dqVar3 = new dq(this.a.s(this.c, (TaskStatus) a3), r);
                    this.a.v();
                    dqVar = dqVar3;
                } else {
                    dqVar = dqVar2;
                }
                final TaskBuoyViewData taskBuoyViewData = new TaskBuoyViewData((TaskStatus) objectRef.element, bqVar, dqVar, taskProcessData2, ((TaskUIData) objectRef2.element).getExtra());
                DebugTrace.a.c(new Function0<String>(objectRef, objectRef2, taskBuoyViewData) { // from class: com.baidu.bdtask.component.buoy.BuoyComponent$update$1$4
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ Ref.ObjectRef $curTaskStatus;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Ref.ObjectRef $uiData;
                    public final /* synthetic */ TaskBuoyViewData $viewData;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {objectRef, objectRef2, taskBuoyViewData};
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
                        this.$curTaskStatus = objectRef;
                        this.$uiData = objectRef2;
                        this.$viewData = taskBuoyViewData;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            return "status:" + ((TaskStatus) this.$curTaskStatus.element) + " \n uidata:" + ((TaskUIData) this.$uiData.element) + " \n viewData:" + this.$viewData;
                        }
                        return (String) invokeV.objValue;
                    }
                });
                this.a.g.f(taskBuoyViewData);
                if (this.a.c) {
                    return;
                }
                this.a.c = true;
                if (TaskGuideData.Companion.b(a.b())) {
                    str = "y_task_icon";
                } else {
                    str = "y_task_diyicon";
                }
                String c = dv.a.c((TaskStatus) objectRef.element);
                tu v = BDPTask.m.v();
                if (v != null && (f = v.f()) != null) {
                    f.a(str, "c_pv", dv.a.a(this.c.getId(), this.c.getActTaskId(), c));
                    return;
                }
                return;
            }
            DebugTrace.a.c(new Function0<String>(objectRef) { // from class: com.baidu.bdtask.component.buoy.BuoyComponent$update$1$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ Ref.ObjectRef $curTaskStatus;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {objectRef};
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
                    this.$curTaskStatus = objectRef;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return "update error:curTaskStatus not enable:" + ((TaskStatus) this.$curTaskStatus.element);
                    }
                    return (String) invokeV.objValue;
                }
            });
        }
    }

    public BuoyComponent(dt<TaskBuoyViewData, TaskBuoyViewModel> dtVar, TaskBuoyViewModel taskBuoyViewModel, TaskInfo taskInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dtVar, taskBuoyViewModel, taskInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = dtVar;
        this.g = taskBuoyViewModel;
        this.h = taskInfo;
        dtVar.a(taskBuoyViewModel);
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            p();
            this.a = true;
        }
    }

    public boolean t(TaskStatus taskStatus) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, taskStatus)) == null) {
            return taskStatus.isDuplicated();
        }
        return invokeL.booleanValue;
    }

    public void l(final ViewGroup viewGroup, final ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, layoutParams) != null) || !u()) {
            return;
        }
        this.e = new Function0<Unit>(this, viewGroup, layoutParams) { // from class: com.baidu.bdtask.component.buoy.BuoyComponent$attachToWindow$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ViewGroup.LayoutParams $layoutParams;
            public final /* synthetic */ ViewGroup $viewGroup;
            public final /* synthetic */ BuoyComponent this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, viewGroup, layoutParams};
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
                this.$viewGroup = viewGroup;
                this.$layoutParams = layoutParams;
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
                dt dtVar;
                ViewParent viewParent;
                dt dtVar2;
                dt dtVar3;
                dt dtVar4;
                dt dtVar5;
                dt dtVar6;
                ViewParent viewParent2;
                dt dtVar7;
                dt dtVar8;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    dtVar = this.this$0.f;
                    View contentView = dtVar.getContentView();
                    ViewParent viewParent3 = null;
                    if (contentView != null) {
                        viewParent = contentView.getParent();
                    } else {
                        viewParent = null;
                    }
                    if (viewParent != null) {
                        dtVar6 = this.this$0.f;
                        View contentView2 = dtVar6.getContentView();
                        if (contentView2 != null) {
                            viewParent2 = contentView2.getParent();
                        } else {
                            viewParent2 = null;
                        }
                        if (!(viewParent2 instanceof ViewGroup)) {
                            viewParent2 = null;
                        }
                        if (((ViewGroup) viewParent2) != null) {
                            dtVar7 = this.this$0.f;
                            View contentView3 = dtVar7.getContentView();
                            if (contentView3 != null) {
                                viewParent3 = contentView3.getParent();
                            }
                            if (viewParent3 != null) {
                                dtVar8 = this.this$0.f;
                                ((ViewGroup) viewParent3).removeView(dtVar8.getContentView());
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
                            }
                        }
                    }
                    ViewGroup viewGroup2 = this.$viewGroup;
                    dtVar2 = this.this$0.f;
                    if (viewGroup2.indexOfChild(dtVar2.getContentView()) != -1) {
                        ViewGroup viewGroup3 = this.$viewGroup;
                        viewGroup3.removeView(viewGroup3);
                    }
                    View findViewWithTag = this.$viewGroup.findViewWithTag("TaskSDKBuoyViewTag");
                    if (findViewWithTag != null) {
                        this.$viewGroup.removeView(findViewWithTag);
                    }
                    dtVar3 = this.this$0.f;
                    View contentView4 = dtVar3.getContentView();
                    if (contentView4 != null) {
                        contentView4.setTag("TaskSDKBuoyViewTag");
                    }
                    if (this.$layoutParams == null) {
                        ViewGroup viewGroup4 = this.$viewGroup;
                        dtVar5 = this.this$0.f;
                        viewGroup4.addView(dtVar5.getContentView());
                        return;
                    }
                    ViewGroup viewGroup5 = this.$viewGroup;
                    dtVar4 = this.this$0.f;
                    viewGroup5.addView(dtVar4.getContentView(), this.$layoutParams);
                }
            }
        };
        this.d = viewGroup;
        BDPTask.m.z(this.h, this);
    }

    public synchronized void update(TaskInfo taskInfo, TaskStatus taskStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, taskInfo, taskStatus) == null) {
            synchronized (this) {
                wt.c(new b(this, taskStatus, taskInfo));
            }
        }
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

    @Override // com.baidu.tieba.yp
    public void a(final TaskInfo taskInfo, TaskStatus taskStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, taskInfo, taskStatus) == null) {
            DebugTrace.a.c(new Function0<String>(taskInfo) { // from class: com.baidu.bdtask.component.buoy.BuoyComponent$onChanged$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TaskInfo $taskInfo;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {taskInfo};
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
                    this.$taskInfo = taskInfo;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return "onChanged:taskInfo.response:" + this.$taskInfo.getResponse();
                    }
                    return (String) invokeV.objValue;
                }
            });
            DebugTrace.a.c(new Function0<String>(taskInfo) { // from class: com.baidu.bdtask.component.buoy.BuoyComponent$onChanged$2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TaskInfo $taskInfo;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {taskInfo};
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
                    this.$taskInfo = taskInfo;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return "onChanged:taskInfo:" + this.$taskInfo;
                    }
                    return (String) invokeV.objValue;
                }
            });
            update(taskInfo, taskStatus);
            if (taskStatus.isUnRegistered()) {
                this.b = true;
                DebugTrace.a.c(BuoyComponent$onChanged$3.INSTANCE);
            }
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

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            m();
            this.e = null;
            BDPTask.m.H(this.h.getActionId(), this);
        }
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            DebugTrace.a.c(new Function0<String>(this) { // from class: com.baidu.bdtask.component.buoy.BuoyComponent$isValid$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BuoyComponent this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    InterceptResult invokeV2;
                    boolean z;
                    boolean z2;
                    boolean z3;
                    boolean z4;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        z = this.this$0.a;
                        if (!z && BuoyComponent.x(this.this$0, null, 1, null)) {
                            z4 = this.this$0.b;
                            if (!z4) {
                                return "cur component is valid";
                            }
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("cur component is invalid by hasDestroyed:");
                        z2 = this.this$0.a;
                        sb.append(z2);
                        sb.append(" taskSignCheck:");
                        sb.append(BuoyComponent.x(this.this$0, null, 1, null));
                        sb.append(" bindTaskHasUnRegistered:");
                        z3 = this.this$0.b;
                        sb.append(z3);
                        return sb.toString();
                    }
                    return (String) invokeV2.objValue;
                }
            });
            if (!this.a && x(this, null, 1, null) && !this.b) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void y() {
        ViewParent viewParent;
        Function0<Unit> function0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            View contentView = this.f.getContentView();
            if (contentView != null) {
                viewParent = contentView.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent == null && (function0 = this.e) != null) {
                function0.invoke();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.bdtask.model.info.TaskInfo */
    /* JADX DEBUG: Multi-variable search result rejected for r5v12, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r5v13, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r5v15, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean w(TaskInfo taskInfo) {
        InterceptResult invokeL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, taskInfo)) == null) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = taskInfo;
            if (taskInfo == null) {
                TaskState m = BDPTask.m.m(this.h.getActionId());
                if (m != null) {
                    t = m.getTaskInfo();
                } else {
                    t = 0;
                }
                objectRef.element = t;
            }
            if (((TaskInfo) objectRef.element) != null) {
                DebugTrace.a.c(new Function0<String>(this, objectRef) { // from class: com.baidu.bdtask.component.buoy.BuoyComponent$taskSignCheck$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Ref.ObjectRef $tempCurTaskInfo;
                    public final /* synthetic */ BuoyComponent this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, objectRef};
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
                        this.$tempCurTaskInfo = objectRef;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        InterceptResult invokeV;
                        TaskInfo taskInfo2;
                        TaskInfo taskInfo3;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            String singleKey = ((TaskInfo) this.$tempCurTaskInfo.element).getSingleKey();
                            taskInfo2 = this.this$0.h;
                            if (!Intrinsics.areEqual(singleKey, taskInfo2.getSingleKey())) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("taskSignCheck fail:curTaskInfo:");
                                sb.append((TaskInfo) this.$tempCurTaskInfo.element);
                                sb.append(" bindTaskInfo:");
                                taskInfo3 = this.this$0.h;
                                sb.append(taskInfo3);
                                return sb.toString();
                            }
                            return "taskSignCheck pass";
                        }
                        return (String) invokeV.objValue;
                    }
                });
                return Intrinsics.areEqual(((TaskInfo) objectRef.element).getSingleKey(), this.h.getSingleKey());
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
