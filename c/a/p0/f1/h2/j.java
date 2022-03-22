package c.a.p0.f1.h2;

import c.a.p0.f1.q;
import c.a.p0.f1.v0;
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
    public final FrsFragment f14046b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.p0.f1.s2.n f14047c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.p0.f1.s2.h f14048d;

    /* renamed from: e  reason: collision with root package name */
    public final FrsModelController f14049e;

    /* renamed from: f  reason: collision with root package name */
    public final v0 f14050f;

    /* renamed from: g  reason: collision with root package name */
    public final c f14051g;

    public j(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (frsFragment != null) {
            this.f14046b = frsFragment;
            this.f14048d = frsFragment.N();
            this.a = this.f14046b.x0();
            this.f14047c = this.f14046b.I2();
            this.f14049e = this.f14046b.b0();
            this.f14050f = this.f14046b.F2();
            this.f14051g = this.f14046b.n0();
            return;
        }
        throw new NullPointerException("FrsActivity is NullPointerException");
    }
}
