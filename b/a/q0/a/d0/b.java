package b.a.q0.a.d0;

import android.app.Activity;
import android.text.TextUtils;
import b.a.e.e.p.k;
import b.a.q0.j0.h;
import b.a.q0.s.s.g;
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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f11736a;

    /* renamed from: b  reason: collision with root package name */
    public g f11737b;

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
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (gVar = this.f11737b) == null) {
            return;
        }
        gVar.f();
        this.f11737b = null;
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
            this.f11736a = aVar;
        }
    }

    public void e() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f11736a) == null) {
            return;
        }
        int i2 = aVar.f11729c;
        if (i2 == a.y) {
            g h2 = g.h(TbadkCoreApplication.getInst().getCurrentActivity(), this.f11736a);
            h2.j();
            this.f11737b = h2;
        } else if (i2 == a.z) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            b.a.q0.s.o.b bVar = new b.a.q0.s.o.b(currentActivity);
            bVar.d(currentActivity, this.f11736a);
            bVar.i();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            b.a.q0.s.o.a b2 = b.a.q0.s.o.a.b();
            b.a.q0.s.o.a b3 = b.a.q0.s.o.a.b();
            b3.i("business_count_hint" + currentAccount + this.f11736a.f11727a, b2.c("business_count_hint" + currentAccount + this.f11736a.f11727a) - 1);
        } else if (i2 == a.A) {
            int i3 = aVar.f11730d;
            if (i3 == a.D) {
                if (UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.f11736a.l) || k.isEmpty(this.f11736a.k)) {
                    return;
                }
                b(this.f11736a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            } else if (i3 != a.E || k.isEmpty(aVar.k)) {
            } else {
                b(this.f11736a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            }
        } else if (i2 != a.B || TextUtils.isEmpty(aVar.f11731e)) {
        } else {
            CompleteTaskToastData completeTaskToastData = new CompleteTaskToastData();
            a aVar2 = this.f11736a;
            completeTaskToastData.activityId = aVar2.f11727a;
            completeTaskToastData.missionId = aVar2.f11728b;
            completeTaskToastData.duration = aVar2.f11735i;
            completeTaskToastData.message = aVar2.f11731e;
            completeTaskToastData.url = aVar2.k;
            completeTaskToastData.pageId = b.a.q0.a.d.y().x();
            CompeteTaskEvent competeTaskEvent = new CompeteTaskEvent();
            competeTaskEvent.taskToastData = completeTaskToastData;
            h.i(competeTaskEvent);
            a aVar3 = this.f11736a;
            c.c(aVar3.f11727a, aVar3.f11728b);
        }
    }
}
