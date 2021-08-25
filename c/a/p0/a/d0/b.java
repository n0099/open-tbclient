package c.a.p0.a.d0;

import android.app.Activity;
import android.text.TextUtils;
import c.a.e.e.p.k;
import c.a.p0.h0.h;
import c.a.p0.s.s.g;
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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f12555a;

    /* renamed from: b  reason: collision with root package name */
    public g f12556b;

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

    public void a() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (gVar = this.f12556b) == null) {
            return;
        }
        gVar.f();
        this.f12556b = null;
    }

    public final void b(String str) {
        Activity currentActivity;
        TbPageContext c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || k.isEmpty(str) || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || (c2 = c(currentActivity)) == null || StringUtils.isNull(str)) {
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
            this.f12555a = aVar;
        }
    }

    public void e() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f12555a) == null) {
            return;
        }
        int i2 = aVar.f12547c;
        if (i2 == a.y) {
            g h2 = g.h(TbadkCoreApplication.getInst().getCurrentActivity(), this.f12555a);
            h2.j();
            this.f12556b = h2;
        } else if (i2 == a.z) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            c.a.p0.s.o.b bVar = new c.a.p0.s.o.b(currentActivity);
            bVar.d(currentActivity, this.f12555a);
            bVar.i();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            c.a.p0.s.o.a b2 = c.a.p0.s.o.a.b();
            c.a.p0.s.o.a b3 = c.a.p0.s.o.a.b();
            b3.i("business_count_hint" + currentAccount + this.f12555a.f12545a, b2.c("business_count_hint" + currentAccount + this.f12555a.f12545a) - 1);
        } else if (i2 == a.A) {
            int i3 = aVar.f12548d;
            if (i3 == a.D) {
                if (UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.f12555a.l) || k.isEmpty(this.f12555a.k)) {
                    return;
                }
                b(this.f12555a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            } else if (i3 != a.E || k.isEmpty(aVar.k)) {
            } else {
                b(this.f12555a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            }
        } else if (i2 != a.B || TextUtils.isEmpty(aVar.f12549e)) {
        } else {
            CompleteTaskToastData completeTaskToastData = new CompleteTaskToastData();
            a aVar2 = this.f12555a;
            completeTaskToastData.activityId = aVar2.f12545a;
            completeTaskToastData.missionId = aVar2.f12546b;
            completeTaskToastData.duration = aVar2.f12553i;
            completeTaskToastData.message = aVar2.f12549e;
            completeTaskToastData.url = aVar2.k;
            completeTaskToastData.pageId = c.a.p0.a.d.y().x();
            CompeteTaskEvent competeTaskEvent = new CompeteTaskEvent();
            competeTaskEvent.taskToastData = completeTaskToastData;
            h.i(competeTaskEvent);
            a aVar3 = this.f12555a;
            c.c(aVar3.f12545a, aVar3.f12546b);
        }
    }
}
