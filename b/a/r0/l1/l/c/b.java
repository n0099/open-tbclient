package b.a.r0.l1.l.c;

import androidx.core.view.InputDeviceCompat;
import b.a.r0.l1.l.c.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b implements b.a.q0.k0.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f20266e;

    /* renamed from: f  reason: collision with root package name */
    public a.C1004a f20267f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.l1.h.o.a f20268g;

    /* renamed from: h  reason: collision with root package name */
    public long f20269h;

    /* renamed from: i  reason: collision with root package name */
    public int f20270i;

    public b() {
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

    public static b a(ChatMessage chatMessage, a.C1004a c1004a) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, chatMessage, c1004a)) == null) {
            b bVar = new b();
            if (chatMessage == null) {
                return bVar;
            }
            c1004a.f20264h /= 100;
            bVar.o(chatMessage.getReadCountPv());
            bVar.m(c1004a);
            bVar.i(chatMessage.getTime());
            if (chatMessage.getObjContent() instanceof b.a.r0.l1.h.o.a) {
                bVar.k((b.a.r0.l1.h.o.a) chatMessage.getObjContent());
            }
            return bVar;
        }
        return (b) invokeLL.objValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20269h : invokeV.longValue;
    }

    public b.a.r0.l1.h.o.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20268g : (b.a.r0.l1.h.o.a) invokeV.objValue;
    }

    public a.C1004a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20267f : (a.C1004a) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f20270i : invokeV.intValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f20266e : invokeV.booleanValue;
    }

    public void i(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.f20269h = j;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f20266e = z;
        }
    }

    public void k(b.a.r0.l1.h.o.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f20268g = aVar;
        }
    }

    public void m(a.C1004a c1004a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, c1004a) == null) {
            this.f20267f = c1004a;
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f20270i = i2;
        }
    }
}
