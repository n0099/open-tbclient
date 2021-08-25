package c.a.q0.u.b.f.e;

import android.app.Activity;
import android.os.Bundle;
import c.a.e.e.p.l;
import c.a.o0.a.k;
import c.a.p0.n0.d;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a extends ActivityDelegation {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f24829a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.q0.u.b.f.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1152a implements c.a.q0.u.b.f.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f24830a;

        public C1152a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24830a = aVar;
        }

        @Override // c.a.q0.u.b.f.d.a
        public void a(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
                this.f24830a.mResult.putInt("status_code", bundle.getInt("result_code"));
                this.f24830a.mResult.putString("params", bundle.getString(AbstractThirdPartyService.EXTRA_RESULT_MSG));
                this.f24830a.finish();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1825498850, "Lc/a/q0/u/b/f/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1825498850, "Lc/a/q0/u/b/f/e/a;");
                return;
            }
        }
        f24829a = k.f7049a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Bundle b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("order_info", str);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.mParams.isEmpty()) {
                boolean z = f24829a;
                return false;
            }
            boolean z2 = f24829a;
            if (!d.c().g()) {
                l.L(TbadkCoreApplication.getInst(), R.string.plugin_pay_wallet_not_found);
                return false;
            } else if (getAgent() instanceof Activity) {
                c.a.q0.u.b.f.a aVar = new c.a.q0.u.b.f.a();
                aVar.mParams.putInt("type", 1);
                aVar.mParams.putString("orderInfo", this.mParams.getString("order_info"));
                aVar.b(getAgent());
                aVar.c(new C1152a(this));
                aVar.onExec();
                return false;
            } else {
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
