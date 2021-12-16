package c.a.s0.d1.q2;

import c.a.s0.d1.q;
import c.a.s0.d1.v0;
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
    public final FrsFragment f16285b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.s0.d1.z2.n f16286c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.s0.d1.z2.h f16287d;

    /* renamed from: e  reason: collision with root package name */
    public final FrsModelController f16288e;

    /* renamed from: f  reason: collision with root package name */
    public final v0 f16289f;

    /* renamed from: g  reason: collision with root package name */
    public final c f16290g;

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
            this.f16285b = frsFragment;
            this.f16287d = frsFragment.getHeaderVC();
            this.a = this.f16285b.getFrsView();
            this.f16286c = this.f16285b.getTabController();
            this.f16288e = this.f16285b.getModelController();
            this.f16289f = this.f16285b.getNavigationAnimDispatcher();
            this.f16290g = this.f16285b.getFrsLoadMoreModelController();
            return;
        }
        throw new NullPointerException("FrsActivity is NullPointerException");
    }
}
