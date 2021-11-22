package b.a.r0.x0.q2;

import b.a.r0.x0.q;
import b.a.r0.x0.v0;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final q f27761a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsFragment f27762b;

    /* renamed from: c  reason: collision with root package name */
    public final b.a.r0.x0.z2.n f27763c;

    /* renamed from: d  reason: collision with root package name */
    public final b.a.r0.x0.z2.h f27764d;

    /* renamed from: e  reason: collision with root package name */
    public final FrsModelController f27765e;

    /* renamed from: f  reason: collision with root package name */
    public final v0 f27766f;

    /* renamed from: g  reason: collision with root package name */
    public final c f27767g;

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
            this.f27762b = frsFragment;
            this.f27764d = frsFragment.getHeaderVC();
            this.f27761a = this.f27762b.getFrsView();
            this.f27763c = this.f27762b.getTabController();
            this.f27765e = this.f27762b.getModelController();
            this.f27766f = this.f27762b.getNavigationAnimDispatcher();
            this.f27767g = this.f27762b.getFrsLoadMoreModelController();
            return;
        }
        throw new NullPointerException("FrsActivity is NullPointerException");
    }
}
