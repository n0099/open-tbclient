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
    public final q f26720a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsFragment f26721b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.r0.w0.o2.n f26722c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.r0.w0.o2.h f26723d;

    /* renamed from: e  reason: collision with root package name */
    public final FrsModelController f26724e;

    /* renamed from: f  reason: collision with root package name */
    public final u0 f26725f;

    /* renamed from: g  reason: collision with root package name */
    public final c f26726g;

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
            this.f26721b = frsFragment;
            this.f26723d = frsFragment.getHeaderVC();
            this.f26720a = this.f26721b.getFrsView();
            this.f26722c = this.f26721b.getTabController();
            this.f26724e = this.f26721b.getModelController();
            this.f26725f = this.f26721b.getNavigationAnimDispatcher();
            this.f26726g = this.f26721b.getFrsLoadMoreModelController();
            return;
        }
        throw new NullPointerException("FrsActivity is NullPointerException");
    }
}
