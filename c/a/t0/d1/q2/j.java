package c.a.t0.d1.q2;

import c.a.t0.d1.q;
import c.a.t0.d1.v0;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final q a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsFragment f16780b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.t0.d1.z2.n f16781c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.t0.d1.z2.h f16782d;

    /* renamed from: e  reason: collision with root package name */
    public final FrsModelController f16783e;

    /* renamed from: f  reason: collision with root package name */
    public final v0 f16784f;

    /* renamed from: g  reason: collision with root package name */
    public final c f16785g;

    public j(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (frsFragment != null) {
            this.f16780b = frsFragment;
            this.f16782d = frsFragment.getHeaderVC();
            this.a = this.f16780b.getFrsView();
            this.f16781c = this.f16780b.getTabController();
            this.f16783e = this.f16780b.getModelController();
            this.f16784f = this.f16780b.getNavigationAnimDispatcher();
            this.f16785g = this.f16780b.getFrsLoadMoreModelController();
            return;
        }
        throw new NullPointerException("FrsActivity is NullPointerException");
    }
}
