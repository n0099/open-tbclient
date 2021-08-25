package c.a.o0.a.y0.i;

import androidx.annotation.NonNull;
import c.a.o0.a.y0.d;
import c.a.o0.a.y0.i.c;
import c.a.o0.a.y0.i.d.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class a extends c.a.o0.a.y0.b<c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final c.f f9758h;

    /* renamed from: c.a.o0.a.y0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0465a implements c.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f9759a;

        public C0465a(a aVar) {
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
            this.f9759a = aVar;
        }

        @Override // c.a.o0.a.y0.i.c.f
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f9759a.f9689b == null) {
                return;
            }
            this.f9759a.f9689b.onCallback(this.f9759a, "onConfirmBtnClick", null);
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
        C0465a c0465a = new C0465a(this);
        this.f9758h = c0465a;
        cVar.D0(c0465a);
        this.f9688a.a(new c.a.o0.a.y0.i.d.d());
        this.f9688a.a(new c.a.o0.a.y0.i.d.c());
        this.f9688a.a(new e());
        this.f9688a.a(new c.a.o0.a.y0.i.d.a());
        this.f9688a.a(new c.a.o0.a.y0.i.d.b());
    }
}
