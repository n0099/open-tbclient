package c.a.o0.a.d0;

import android.app.Activity;
import android.text.TextUtils;
import c.a.d.f.p.m;
import c.a.o0.j0.h;
import c.a.o0.r.t.i;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskToastData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mutiprocess.competetask.CompeteTaskEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* renamed from: b  reason: collision with root package name */
    public i f9636b;

    public b() {
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

    public void a() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iVar = this.f9636b) == null) {
            return;
        }
        iVar.f();
        this.f9636b = null;
    }

    public final void b(String str) {
        Activity currentActivity;
        TbPageContext c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || m.isEmpty(str) || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || (c2 = c(currentActivity)) == null || StringUtils.isNull(str)) {
            return;
        }
        c2.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(currentActivity, "", str, true)));
    }

    public final TbPageContext c(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
            if (activity instanceof BaseActivity) {
                return ((BaseActivity) activity).getPageContext();
            }
            if (activity instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) activity).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeL.objValue;
    }

    public void d(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.a = aVar;
        }
    }

    public void e() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.a) == null) {
            return;
        }
        int i = aVar.f9630c;
        if (i == a.y) {
            i h2 = i.h(TbadkCoreApplication.getInst().getCurrentActivity(), this.a);
            h2.j();
            this.f9636b = h2;
        } else if (i == a.z) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            c.a.o0.r.p.b bVar = new c.a.o0.r.p.b(currentActivity);
            bVar.d(currentActivity, this.a);
            bVar.i();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            c.a.o0.r.p.a b2 = c.a.o0.r.p.a.b();
            c.a.o0.r.p.a b3 = c.a.o0.r.p.a.b();
            b3.i("business_count_hint" + currentAccount + this.a.a, b2.c("business_count_hint" + currentAccount + this.a.a) - 1);
        } else if (i == a.A) {
            int i2 = aVar.f9631d;
            if (i2 == a.D) {
                if (UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.a.l) || m.isEmpty(this.a.k)) {
                    return;
                }
                b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            } else if (i2 != a.E || m.isEmpty(aVar.k)) {
            } else {
                b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            }
        } else if (i != a.B || TextUtils.isEmpty(aVar.f9632e)) {
        } else {
            CompleteTaskToastData completeTaskToastData = new CompleteTaskToastData();
            a aVar2 = this.a;
            completeTaskToastData.activityId = aVar2.a;
            completeTaskToastData.missionId = aVar2.f9629b;
            completeTaskToastData.duration = aVar2.i;
            completeTaskToastData.message = aVar2.f9632e;
            completeTaskToastData.url = aVar2.k;
            completeTaskToastData.pageId = c.a.o0.a.d.y().x();
            CompeteTaskEvent competeTaskEvent = new CompeteTaskEvent();
            competeTaskEvent.taskToastData = completeTaskToastData;
            h.i(competeTaskEvent);
            a aVar3 = this.a;
            c.c(aVar3.a, aVar3.f9629b);
        }
    }
}
