package c.a.t0.e1.r2;

import c.a.t0.e1.q;
import c.a.t0.e1.v0;
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
    public final FrsFragment f16841b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.t0.e1.a3.n f16842c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.t0.e1.a3.h f16843d;

    /* renamed from: e  reason: collision with root package name */
    public final FrsModelController f16844e;

    /* renamed from: f  reason: collision with root package name */
    public final v0 f16845f;

    /* renamed from: g  reason: collision with root package name */
    public final c f16846g;

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
            this.f16841b = frsFragment;
            this.f16843d = frsFragment.getHeaderVC();
            this.a = this.f16841b.getFrsView();
            this.f16842c = this.f16841b.getTabController();
            this.f16844e = this.f16841b.getModelController();
            this.f16845f = this.f16841b.getNavigationAnimDispatcher();
            this.f16846g = this.f16841b.getFrsLoadMoreModelController();
            return;
        }
        throw new NullPointerException("FrsActivity is NullPointerException");
    }
}
