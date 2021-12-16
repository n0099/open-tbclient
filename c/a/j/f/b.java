package c.a.j.f;

import android.text.TextUtils;
import c.a.j.m.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.ctrl.SubTaskState;
import com.baidu.bdtask.ctrl.model.TaskEnvTag;
import com.baidu.bdtask.ctrl.model.TaskProcess;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.ctrl.model.TaskStatusRuntime;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final com.baidu.bdtask.ctrl.b a(com.baidu.bdtask.ctrl.b bVar, c.a.j.h.a.a aVar) {
        InterceptResult invokeLL;
        com.baidu.bdtask.ctrl.b bVar2;
        TaskStatus taskStatus;
        TaskStatusRuntime taskStatusRuntime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, aVar)) == null) {
            if (bVar == null || (bVar2 = bVar.e()) == null) {
                bVar2 = new com.baidu.bdtask.ctrl.b();
            }
            SubTaskState c2 = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c2 != null) {
                c2.processRuleDataMaxValueFix();
            }
            SubTaskState c3 = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c3 != null && (taskStatus = c3.getTaskStatus()) != null && (taskStatusRuntime = taskStatus.getTaskStatusRuntime()) != null) {
                taskStatusRuntime.setCurAction(aVar);
            }
            return bVar2;
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }

    public final com.baidu.bdtask.ctrl.b b(com.baidu.bdtask.ctrl.b bVar, String str) {
        InterceptResult invokeLL;
        SubTaskState k2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, str)) == null) {
            TaskInfo f2 = bVar.f(str);
            if (f2 != null && !g.a.c(f2.getTaskRule().getExpireTime()) && (k2 = bVar.k(str)) != null) {
                k2.updateStatus(22, 103, "task is expired");
                k2.getTaskStatus().clearProcess();
            }
            return bVar;
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }

    public final com.baidu.bdtask.ctrl.b c(c.a.j.h.a.a aVar, com.baidu.bdtask.ctrl.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, bVar)) == null) {
            if (Intrinsics.areEqual(aVar, (c.a.j.f.c.h.a) (!(aVar instanceof c.a.j.f.c.h.a) ? null : aVar))) {
                com.baidu.bdtask.ctrl.b a = a(bVar, aVar);
                c.a.j.f.c.h.a aVar2 = (c.a.j.f.c.h.a) aVar;
                a.h(aVar2.h());
                a.i(aVar2.h(), aVar2.i());
                SubTaskState k2 = a.k(aVar2.f());
                if (k2 != null) {
                    k2.setInterceptor(aVar2.j());
                    k2.updateStatus(aVar2.g(), Integer.valueOf(aVar2.a()), aVar2.d());
                }
                b(a, aVar2.f());
                return a;
            }
            if (Intrinsics.areEqual(aVar, (c.a.j.f.c.b.a) (!(aVar instanceof c.a.j.f.c.b.a) ? null : aVar))) {
                com.baidu.bdtask.ctrl.b a2 = a(bVar, aVar);
                c.a.j.f.c.b.a aVar3 = (c.a.j.f.c.b.a) aVar;
                SubTaskState k3 = a2.k(aVar3.f());
                if (k3 != null) {
                    k3.updateStatus(aVar3.g(), Integer.valueOf(aVar3.a()), aVar3.d());
                    k3.updateExtraUnRegisterMsg(aVar3.h());
                }
                return a2;
            }
            if (Intrinsics.areEqual(aVar, (c.a.j.f.c.g.a) (!(aVar instanceof c.a.j.f.c.g.a) ? null : aVar))) {
                com.baidu.bdtask.ctrl.b a3 = a(bVar, aVar);
                c.a.j.f.c.g.a aVar4 = (c.a.j.f.c.g.a) aVar;
                SubTaskState k4 = a3.k(aVar4.f());
                if (k4 != null) {
                    k4.updateStatus(aVar4.g(), Integer.valueOf(aVar4.a()), aVar4.d()).getTaskStatus().setInterruptErrorNo(aVar4.h());
                    k4.clearProcess();
                    k4.cleanDuplicateId();
                }
                return a3;
            }
            if (Intrinsics.areEqual(aVar, (c.a.j.f.c.a.a) (!(aVar instanceof c.a.j.f.c.a.a) ? null : aVar))) {
                com.baidu.bdtask.ctrl.b a4 = a(bVar, aVar);
                c.a.j.f.c.a.a aVar5 = (c.a.j.f.c.a.a) aVar;
                SubTaskState k5 = a4.k(aVar5.f());
                if (k5 != null) {
                    k5.updateStatus(aVar5.g(), Integer.valueOf(aVar5.a()), aVar5.d());
                    k5.reset2Running(k5.getTaskInfo().isPassiveTask());
                }
                return a4;
            }
            if (Intrinsics.areEqual(aVar, (c.a.j.f.c.c.a.a) (!(aVar instanceof c.a.j.f.c.c.a.a) ? null : aVar))) {
                com.baidu.bdtask.ctrl.b a5 = a(bVar, aVar);
                c.a.j.f.c.c.a.a aVar6 = (c.a.j.f.c.c.a.a) aVar;
                SubTaskState k6 = a5.k(aVar6.f());
                if (k6 != null) {
                    k6.updateStatus(aVar6.g(), Integer.valueOf(aVar6.a()), aVar6.d());
                    TaskProcess process = k6.getTaskStatus().getProcess();
                    if (!TextUtils.isEmpty(aVar6.i())) {
                        process.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, aVar6.i(), 1L, 0L, 4, null));
                    }
                    process.addClickNumber();
                    if (k6.getTaskInfo().getTaskRule().isNeedUnique()) {
                        process.cacheDuplicateId(aVar6.h());
                    }
                }
                b(a5, aVar6.f());
                return a5;
            }
            if (Intrinsics.areEqual(aVar, (c.a.j.f.c.c.b.a) (!(aVar instanceof c.a.j.f.c.c.b.a) ? null : aVar))) {
                com.baidu.bdtask.ctrl.b a6 = a(bVar, aVar);
                c.a.j.f.c.c.b.a aVar7 = (c.a.j.f.c.c.b.a) aVar;
                SubTaskState k7 = a6.k(aVar7.f());
                if (k7 != null) {
                    k7.updateStatus(aVar7.g(), Integer.valueOf(aVar7.a()), aVar7.d());
                    TaskStatus taskStatus = k7.getTaskStatus();
                    TaskProcess process2 = taskStatus.getProcess();
                    process2.addStayTime(aVar7.h());
                    if (!TextUtils.isEmpty(aVar7.j())) {
                        process2.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, aVar7.j(), aVar7.h(), 0L, 4, null));
                    }
                    taskStatus.getTaskStatusRuntime().setCurDuplicateId(aVar7.i());
                }
                b(a6, aVar7.f());
                return a6;
            }
            if (Intrinsics.areEqual(aVar, (c.a.j.f.c.f.a) (!(aVar instanceof c.a.j.f.c.f.a) ? null : aVar))) {
                c.a.j.f.c.f.a aVar8 = (c.a.j.f.c.f.a) aVar;
                TaskInfo k8 = aVar8.k();
                com.baidu.bdtask.ctrl.b a7 = a(bVar, aVar);
                SubTaskState k9 = a7.k(aVar8.f());
                if (k9 != null) {
                    if (c.a.j.m.a.a.a(aVar8.a()) && k9.getTaskInfo().getTaskRule().isNeedSkipRequestError()) {
                        k9.updateStatus(aVar8.i(), 0, "");
                        k9.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(true);
                    } else {
                        k9.updateStatus(aVar8.i(), Integer.valueOf(aVar8.a()), aVar8.d());
                        k9.updateTaskInfoByMerge(k8);
                        k9.updateTaskInfoWithResponse(aVar8.j());
                        k9.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(false);
                        if (k9.getTaskInfo().getTaskRule().isNeedUnique() && k9.getTaskInfo().isVisitAction()) {
                            k9.getTaskStatus().getProcess().cacheDuplicateId(aVar8.l());
                        }
                        k9.clearProcessTags();
                        k9.addExitOnce();
                    }
                }
                b(a7, aVar8.f());
                return a7;
            }
            if (Intrinsics.areEqual(aVar, (c.a.j.f.c.d.b.a) (!(aVar instanceof c.a.j.f.c.d.b.a) ? null : aVar))) {
                com.baidu.bdtask.ctrl.b a8 = a(bVar, aVar);
                c.a.j.f.c.d.b.a aVar9 = (c.a.j.f.c.d.b.a) aVar;
                SubTaskState k10 = a8.k(aVar9.f());
                if (k10 != null) {
                    k10.updateStatus(aVar9.g(), Integer.valueOf(aVar9.a()), aVar9.d()).getTaskStatus().getTaskStatusRuntime().setDuplicated(true);
                }
                return a8;
            }
            if (Intrinsics.areEqual(aVar, (c.a.j.f.c.e.a) (!(aVar instanceof c.a.j.f.c.e.a) ? null : aVar))) {
                com.baidu.bdtask.ctrl.b a9 = a(bVar, aVar);
                SubTaskState k11 = a9.k(((c.a.j.f.c.e.a) aVar).f());
                if (k11 != null) {
                    k11.resetExit();
                }
                return a9;
            }
            if (Intrinsics.areEqual(aVar, aVar instanceof c.a.j.f.c.d.a.a ? aVar : null)) {
                com.baidu.bdtask.ctrl.b a10 = a(bVar, aVar);
                c.a.j.f.c.d.a.a aVar10 = (c.a.j.f.c.d.a.a) aVar;
                SubTaskState k12 = a10.k(aVar10.f());
                if (k12 != null && k12.getTaskInfo().getTaskRule().isNeedUnique() && !TextUtils.isEmpty(aVar10.g())) {
                    k12.getTaskStatus().getProcess().cacheDuplicateId(aVar10.g());
                }
                return a10;
            }
            return a(bVar, aVar);
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }
}
