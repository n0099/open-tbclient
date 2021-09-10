package c.a.r0.w0.f2;

import c.a.r0.w0.q;
import c.a.r0.w0.u0;
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
    public final q f26697a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsFragment f26698b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.r0.w0.o2.n f26699c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.r0.w0.o2.h f26700d;

    /* renamed from: e  reason: collision with root package name */
    public final FrsModelController f26701e;

    /* renamed from: f  reason: collision with root package name */
    public final u0 f26702f;

    /* renamed from: g  reason: collision with root package name */
    public final c f26703g;

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
            this.f26698b = frsFragment;
            this.f26700d = frsFragment.getHeaderVC();
            this.f26697a = this.f26698b.getFrsView();
            this.f26699c = this.f26698b.getTabController();
            this.f26701e = this.f26698b.getModelController();
            this.f26702f = this.f26698b.getNavigationAnimDispatcher();
            this.f26703g = this.f26698b.getFrsLoadMoreModelController();
            return;
        }
        throw new NullPointerException("FrsActivity is NullPointerException");
    }
}
