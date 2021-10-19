package c.a.z.a;

import androidx.core.view.InputDeviceCompat;
import c.a.z.a.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class d implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.d f31320a;

    /* renamed from: b  reason: collision with root package name */
    public b.a f31321b;

    /* renamed from: c  reason: collision with root package name */
    public b.e f31322c;

    /* renamed from: d  reason: collision with root package name */
    public b.InterfaceC1443b f31323d;

    /* renamed from: e  reason: collision with root package name */
    public b.c f31324e;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f31320a = null;
            this.f31321b = null;
            this.f31322c = null;
            this.f31323d = null;
            this.f31324e = null;
        }
    }

    public final boolean a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
            b.InterfaceC1443b interfaceC1443b = this.f31323d;
            return interfaceC1443b != null && interfaceC1443b.d(this, i2, i3);
        }
        return invokeII.booleanValue;
    }

    public final boolean a(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, obj)) == null) {
            b.c cVar = this.f31324e;
            return cVar != null && cVar.e(this, i2, i3, obj);
        }
        return invokeIIL.booleanValue;
    }

    public final void b() {
        b.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (dVar = this.f31320a) == null) {
            return;
        }
        dVar.c(this);
    }

    public final void c() {
        b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f31321b) == null) {
            return;
        }
        aVar.b(this);
    }

    public final void d() {
        b.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (eVar = this.f31322c) == null) {
            return;
        }
        eVar.a(this);
    }

    public final void setOnCompletionListener(b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.f31321b = aVar;
        }
    }

    public final void setOnErrorListener(b.InterfaceC1443b interfaceC1443b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, interfaceC1443b) == null) {
            this.f31323d = interfaceC1443b;
        }
    }

    public final void setOnInfoListener(b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.f31324e = cVar;
        }
    }

    public final void setOnPreparedListener(b.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dVar) == null) {
            this.f31320a = dVar;
        }
    }

    public final void setOnTerminalListener(b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, eVar) == null) {
            this.f31322c = eVar;
        }
    }
}
