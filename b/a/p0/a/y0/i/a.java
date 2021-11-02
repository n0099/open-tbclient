package b.a.p0.a.y0.i;

import androidx.annotation.NonNull;
import b.a.p0.a.y0.d;
import b.a.p0.a.y0.i.c;
import b.a.p0.a.y0.i.d.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class a extends b.a.p0.a.y0.b<c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final c.f f9029h;

    /* renamed from: b.a.p0.a.y0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0462a implements c.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f9030a;

        public C0462a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9030a = aVar;
        }

        @Override // b.a.p0.a.y0.i.c.f
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f9030a.f8961b == null) {
                return;
            }
            this.f9030a.f8961b.onCallback(this.f9030a, "onConfirmBtnClick", null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull c cVar) {
        super(cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        C0462a c0462a = new C0462a(this);
        this.f9029h = c0462a;
        cVar.D0(c0462a);
        this.f8960a.a(new b.a.p0.a.y0.i.d.d());
        this.f8960a.a(new b.a.p0.a.y0.i.d.c());
        this.f8960a.a(new e());
        this.f8960a.a(new b.a.p0.a.y0.i.d.a());
        this.f8960a.a(new b.a.p0.a.y0.i.d.b());
    }
}
