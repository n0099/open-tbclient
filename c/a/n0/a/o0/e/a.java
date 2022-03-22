package c.a.n0.a.o0.e;

import android.view.KeyEvent;
import androidx.annotation.NonNull;
import c.a.n0.a.o0.d;
import c.a.n0.a.o0.e.c;
import c.a.n0.a.o0.e.d.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a extends c.a.n0.a.o0.b<c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final c.f f5516h;

    /* renamed from: c.a.n0.a.o0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0383a implements c.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0383a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.n0.a.o0.e.c.f
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f5510b == null) {
                return;
            }
            this.a.f5510b.onCallback(this.a, "onCustomKeyboardHide", null);
        }

        @Override // c.a.n0.a.o0.e.c.f
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.a.f5510b == null) {
                return;
            }
            this.a.f5510b.onCallback(this.a, "onCustomKeyboardShow", Integer.valueOf(i));
        }

        @Override // c.a.n0.a.o0.e.c.f
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.a.f5510b == null) {
                return;
            }
            this.a.f5510b.onCallback(this.a, "committext", str);
        }

        @Override // c.a.n0.a.o0.e.c.f
        public void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.a.f5510b == null) {
                return;
            }
            this.a.f5510b.onCallback(this.a, "deletebutton", new KeyEvent(0, 67));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        C0383a c0383a = new C0383a(this);
        this.f5516h = c0383a;
        cVar.D0(c0383a);
        this.a.a(new e());
        this.a.a(new c.a.n0.a.o0.e.d.a());
        this.a.a(new c.a.n0.a.o0.e.d.d());
        this.a.a(new c.a.n0.a.o0.e.d.c());
        this.a.a(new c.a.n0.a.o0.e.d.b());
    }
}
