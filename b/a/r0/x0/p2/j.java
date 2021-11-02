package b.a.r0.x0.p2;

import b.a.r0.x0.q;
import b.a.r0.x0.u0;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final q f26143a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsFragment f26144b;

    /* renamed from: c  reason: collision with root package name */
    public final b.a.r0.x0.y2.n f26145c;

    /* renamed from: d  reason: collision with root package name */
    public final b.a.r0.x0.y2.h f26146d;

    /* renamed from: e  reason: collision with root package name */
    public final FrsModelController f26147e;

    /* renamed from: f  reason: collision with root package name */
    public final u0 f26148f;

    /* renamed from: g  reason: collision with root package name */
    public final c f26149g;

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
            this.f26144b = frsFragment;
            this.f26146d = frsFragment.getHeaderVC();
            this.f26143a = this.f26144b.getFrsView();
            this.f26145c = this.f26144b.getTabController();
            this.f26147e = this.f26144b.getModelController();
            this.f26148f = this.f26144b.getNavigationAnimDispatcher();
            this.f26149g = this.f26144b.getFrsLoadMoreModelController();
            return;
        }
        throw new NullPointerException("FrsActivity is NullPointerException");
    }
}
