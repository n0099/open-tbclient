package c.a.r0.x0.f2;

import c.a.r0.x0.q;
import c.a.r0.x0.u0;
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
    public final q f26895a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsFragment f26896b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.r0.x0.o2.n f26897c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.r0.x0.o2.h f26898d;

    /* renamed from: e  reason: collision with root package name */
    public final FrsModelController f26899e;

    /* renamed from: f  reason: collision with root package name */
    public final u0 f26900f;

    /* renamed from: g  reason: collision with root package name */
    public final c f26901g;

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
            this.f26896b = frsFragment;
            this.f26898d = frsFragment.getHeaderVC();
            this.f26895a = this.f26896b.getFrsView();
            this.f26897c = this.f26896b.getTabController();
            this.f26899e = this.f26896b.getModelController();
            this.f26900f = this.f26896b.getNavigationAnimDispatcher();
            this.f26901g = this.f26896b.getFrsLoadMoreModelController();
            return;
        }
        throw new NullPointerException("FrsActivity is NullPointerException");
    }
}
