package c.a.o0.a.d0;

import android.app.Activity;
import android.text.TextUtils;
import c.a.e.e.p.k;
import c.a.o0.h0.h;
import c.a.o0.s.s.g;
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
    public a f12288a;

    /* renamed from: b  reason: collision with root package name */
    public g f12289b;

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
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (gVar = this.f12289b) == null) {
            return;
        }
        gVar.f();
        this.f12289b = null;
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
            this.f12288a = aVar;
        }
    }

    public void e() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f12288a) == null) {
            return;
        }
        int i2 = aVar.f12280c;
        if (i2 == a.y) {
            g h2 = g.h(TbadkCoreApplication.getInst().getCurrentActivity(), this.f12288a);
            h2.j();
            this.f12289b = h2;
        } else if (i2 == a.z) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            c.a.o0.s.o.b bVar = new c.a.o0.s.o.b(currentActivity);
            bVar.d(currentActivity, this.f12288a);
            bVar.i();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            c.a.o0.s.o.a b2 = c.a.o0.s.o.a.b();
            c.a.o0.s.o.a b3 = c.a.o0.s.o.a.b();
            b3.i("business_count_hint" + currentAccount + this.f12288a.f12278a, b2.c("business_count_hint" + currentAccount + this.f12288a.f12278a) - 1);
        } else if (i2 == a.A) {
            int i3 = aVar.f12281d;
            if (i3 == a.D) {
                if (UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.f12288a.l) || k.isEmpty(this.f12288a.k)) {
                    return;
                }
                b(this.f12288a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            } else if (i3 != a.E || k.isEmpty(aVar.k)) {
            } else {
                b(this.f12288a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            }
        } else if (i2 != a.B || TextUtils.isEmpty(aVar.f12282e)) {
        } else {
            CompleteTaskToastData completeTaskToastData = new CompleteTaskToastData();
            a aVar2 = this.f12288a;
            completeTaskToastData.activityId = aVar2.f12278a;
            completeTaskToastData.missionId = aVar2.f12279b;
            completeTaskToastData.duration = aVar2.f12286i;
            completeTaskToastData.message = aVar2.f12282e;
            completeTaskToastData.url = aVar2.k;
            completeTaskToastData.pageId = c.a.o0.a.d.y().x();
            CompeteTaskEvent competeTaskEvent = new CompeteTaskEvent();
            competeTaskEvent.taskToastData = completeTaskToastData;
            h.i(competeTaskEvent);
            a aVar3 = this.f12288a;
            c.c(aVar3.f12278a, aVar3.f12279b);
        }
    }
}
