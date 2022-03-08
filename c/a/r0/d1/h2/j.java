package c.a.r0.d1.h2;

import c.a.r0.d1.q;
import c.a.r0.d1.v0;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final q a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsFragment f15618b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.r0.d1.s2.n f15619c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.r0.d1.s2.h f15620d;

    /* renamed from: e  reason: collision with root package name */
    public final FrsModelController f15621e;

    /* renamed from: f  reason: collision with root package name */
    public final v0 f15622f;

    /* renamed from: g  reason: collision with root package name */
    public final c f15623g;

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
            this.f15618b = frsFragment;
            this.f15620d = frsFragment.getHeaderVC();
            this.a = this.f15618b.getFrsView();
            this.f15619c = this.f15618b.getTabController();
            this.f15621e = this.f15618b.getModelController();
            this.f15622f = this.f15618b.getNavigationAnimDispatcher();
            this.f15623g = this.f15618b.getFrsLoadMoreModelController();
            return;
        }
        throw new NullPointerException("FrsActivity is NullPointerException");
    }
}
