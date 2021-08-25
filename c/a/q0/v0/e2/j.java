package c.a.q0.v0.e2;

import c.a.q0.v0.q;
import c.a.q0.v0.u0;
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
    public final q f26010a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsFragment f26011b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.q0.v0.n2.n f26012c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.q0.v0.n2.h f26013d;

    /* renamed from: e  reason: collision with root package name */
    public final FrsModelController f26014e;

    /* renamed from: f  reason: collision with root package name */
    public final u0 f26015f;

    /* renamed from: g  reason: collision with root package name */
    public final c f26016g;

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
            this.f26011b = frsFragment;
            this.f26013d = frsFragment.getHeaderVC();
            this.f26010a = this.f26011b.getFrsView();
            this.f26012c = this.f26011b.getTabController();
            this.f26014e = this.f26011b.getModelController();
            this.f26015f = this.f26011b.getNavigationAnimDispatcher();
            this.f26016g = this.f26011b.getFrsLoadMoreModelController();
            return;
        }
        throw new NullPointerException("FrsActivity is NullPointerException");
    }
}
