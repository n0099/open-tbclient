package b.a.r0.v.b.f.e;

import android.app.Activity;
import android.os.Bundle;
import b.a.e.f.p.l;
import b.a.p0.a.k;
import b.a.q0.p0.d;
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
/* loaded from: classes5.dex */
public class a extends ActivityDelegation {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f25644a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.r0.v.b.f.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1247a implements b.a.r0.v.b.f.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f25645a;

        public C1247a(a aVar) {
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
            this.f25645a = aVar;
        }

        @Override // b.a.r0.v.b.f.d.a
        public void a(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
                this.f25645a.mResult.putInt("status_code", bundle.getInt("result_code"));
                this.f25645a.mResult.putString("params", bundle.getString(AbstractThirdPartyService.EXTRA_RESULT_MSG));
                this.f25645a.finish();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(626242237, "Lb/a/r0/v/b/f/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(626242237, "Lb/a/r0/v/b/f/e/a;");
                return;
            }
        }
        f25644a = k.f6863a;
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
                boolean z = f25644a;
                return false;
            }
            boolean z2 = f25644a;
            if (!d.c().g()) {
                l.L(TbadkCoreApplication.getInst(), R.string.plugin_pay_wallet_not_found);
                return false;
            } else if (getAgent() instanceof Activity) {
                b.a.r0.v.b.f.a aVar = new b.a.r0.v.b.f.a();
                aVar.mParams.putInt("type", 1);
                aVar.mParams.putString("orderInfo", this.mParams.getString("order_info"));
                aVar.b(getAgent());
                aVar.c(new C1247a(this));
                aVar.onExec();
                return false;
            } else {
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
