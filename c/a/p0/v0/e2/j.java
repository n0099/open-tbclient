package c.a.p0.v0.e2;

import c.a.p0.v0.q;
import c.a.p0.v0.u0;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final q f25674a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsFragment f25675b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.p0.v0.o2.n f25676c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.p0.v0.o2.h f25677d;

    /* renamed from: e  reason: collision with root package name */
    public final FrsModelController f25678e;

    /* renamed from: f  reason: collision with root package name */
    public final u0 f25679f;

    /* renamed from: g  reason: collision with root package name */
    public final c f25680g;

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
            this.f25675b = frsFragment;
            this.f25677d = frsFragment.getHeaderVC();
            this.f25674a = this.f25675b.getFrsView();
            this.f25676c = this.f25675b.getTabController();
            this.f25678e = this.f25675b.getModelController();
            this.f25679f = this.f25675b.getNavigationAnimDispatcher();
            this.f25680g = this.f25675b.getFrsLoadMoreModelController();
            return;
        }
        throw new NullPointerException("FrsActivity is NullPointerException");
    }
}
