package b.a.p0.h.o0.d.b;

import b.a.p0.a.v2.q0;
import b.a.p0.h.f0.e;
import b.a.p0.h.f0.h;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.games.view.button.userinfo.UserInfoButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b extends b.a.p0.h.o0.d.a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10625e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10625e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || b.a.p0.h.o0.b.b() == null) {
                return;
            }
            this.f10625e.f10618e = new UserInfoButton(b.a.p0.h.o0.b.b(), this.f10625e);
            this.f10625e.f10618e.setType(this.f10625e.type);
            this.f10625e.f10618e.setButtonText(this.f10625e.text);
            this.f10625e.f10618e.setImageUrl(this.f10625e.image);
            this.f10625e.f10618e.setApiButtonStyle(this.f10625e.style);
            this.f10625e.x();
            this.f10625e.I();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(JsObject jsObject, b.a.p0.a.l0.c cVar) {
        super(jsObject, cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jsObject, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((JsObject) objArr2[0], (b.a.p0.a.l0.c) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        q0.b0(new a(this));
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || h.d()) {
            return;
        }
        e.l("Button shows early.");
    }
}
