package c.a.q0.a.y0.e;

import android.view.KeyEvent;
import androidx.annotation.NonNull;
import c.a.q0.a.y0.d;
import c.a.q0.a.y0.e.c;
import c.a.q0.a.y0.e.d.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a extends c.a.q0.a.y0.b<c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final c.f f9071h;

    /* renamed from: c.a.q0.a.y0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0559a implements c.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0559a(a aVar) {
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
            this.a = aVar;
        }

        @Override // c.a.q0.a.y0.e.c.f
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f9065b == null) {
                return;
            }
            this.a.f9065b.onCallback(this.a, "onCustomKeyboardHide", null);
        }

        @Override // c.a.q0.a.y0.e.c.f
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.a.f9065b == null) {
                return;
            }
            this.a.f9065b.onCallback(this.a, "onCustomKeyboardShow", Integer.valueOf(i2));
        }

        @Override // c.a.q0.a.y0.e.c.f
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.a.f9065b == null) {
                return;
            }
            this.a.f9065b.onCallback(this.a, "committext", str);
        }

        @Override // c.a.q0.a.y0.e.c.f
        public void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.a.f9065b == null) {
                return;
            }
            this.a.f9065b.onCallback(this.a, "deletebutton", new KeyEvent(0, 67));
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
        C0559a c0559a = new C0559a(this);
        this.f9071h = c0559a;
        cVar.D0(c0559a);
        this.a.a(new e());
        this.a.a(new c.a.q0.a.y0.e.d.a());
        this.a.a(new c.a.q0.a.y0.e.d.d());
        this.a.a(new c.a.q0.a.y0.e.d.c());
        this.a.a(new c.a.q0.a.y0.e.d.b());
    }
}
