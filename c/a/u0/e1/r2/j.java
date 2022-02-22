package c.a.u0.e1.r2;

import c.a.u0.e1.q;
import c.a.u0.e1.v0;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final q a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsFragment f17026b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.u0.e1.c3.n f17027c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.u0.e1.c3.h f17028d;

    /* renamed from: e  reason: collision with root package name */
    public final FrsModelController f17029e;

    /* renamed from: f  reason: collision with root package name */
    public final v0 f17030f;

    /* renamed from: g  reason: collision with root package name */
    public final c f17031g;

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
            this.f17026b = frsFragment;
            this.f17028d = frsFragment.getHeaderVC();
            this.a = this.f17026b.getFrsView();
            this.f17027c = this.f17026b.getTabController();
            this.f17029e = this.f17026b.getModelController();
            this.f17030f = this.f17026b.getNavigationAnimDispatcher();
            this.f17031g = this.f17026b.getFrsLoadMoreModelController();
            return;
        }
        throw new NullPointerException("FrsActivity is NullPointerException");
    }
}
