package c.a.z.f;

import androidx.core.view.InputDeviceCompat;
import c.a.z.f.b;
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
    public b.d f31316a;

    /* renamed from: b  reason: collision with root package name */
    public b.a f31317b;

    /* renamed from: c  reason: collision with root package name */
    public b.e f31318c;

    /* renamed from: d  reason: collision with root package name */
    public b.InterfaceC1441b f31319d;

    /* renamed from: e  reason: collision with root package name */
    public b.c f31320e;

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
            this.f31316a = null;
            this.f31317b = null;
            this.f31318c = null;
            this.f31319d = null;
            this.f31320e = null;
        }
    }

    public final boolean a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
            b.InterfaceC1441b interfaceC1441b = this.f31319d;
            return interfaceC1441b != null && interfaceC1441b.d(this, i2, i3);
        }
        return invokeII.booleanValue;
    }

    public final boolean a(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, obj)) == null) {
            b.c cVar = this.f31320e;
            return cVar != null && cVar.e(this, i2, i3, obj);
        }
        return invokeIIL.booleanValue;
    }

    public final void b() {
        b.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (dVar = this.f31316a) == null) {
            return;
        }
        dVar.c(this);
    }

    public final void c() {
        b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f31317b) == null) {
            return;
        }
        aVar.b(this);
    }

    public final void d() {
        b.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (eVar = this.f31318c) == null) {
            return;
        }
        eVar.a(this);
    }

    public final void setOnCompletionListener(b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.f31317b = aVar;
        }
    }

    public final void setOnErrorListener(b.InterfaceC1441b interfaceC1441b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, interfaceC1441b) == null) {
            this.f31319d = interfaceC1441b;
        }
    }

    public final void setOnInfoListener(b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.f31320e = cVar;
        }
    }

    public final void setOnPreparedListener(b.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dVar) == null) {
            this.f31316a = dVar;
        }
    }

    public final void setOnTerminalListener(b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, eVar) == null) {
            this.f31318c = eVar;
        }
    }
}
