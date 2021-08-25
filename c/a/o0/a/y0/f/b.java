package c.a.o0.a.y0.f;

import android.os.Bundle;
import androidx.annotation.NonNull;
import c.a.o0.a.y0.d;
import c.a.o0.a.y0.f.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b extends c.a.o0.a.y0.b<c.a.o0.a.y0.f.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements a.InterfaceC0461a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f9735a;

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
            this.f9735a = bVar;
        }

        @Override // c.a.o0.a.y0.f.a.InterfaceC0461a
        public void a(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) || this.f9735a.f9689b == null) {
                return;
            }
            this.f9735a.f9689b.onCallback(this.f9735a, "onMediaMetadataExtracted", bundle);
        }

        @Override // c.a.o0.a.y0.f.a.InterfaceC0461a
        public void onRelease() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f9735a.f9689b == null) {
                return;
            }
            this.f9735a.f9689b = null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull c.a.o0.a.y0.f.a aVar) {
        super(aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
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
        ((c.a.o0.a.y0.f.a) this.f9690c).w(new a(this));
        this.f9688a.a(new c.a.o0.a.y0.f.d.a());
        this.f9688a.a(new c.a.o0.a.y0.f.d.b());
    }
}
