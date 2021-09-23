package c.a.r0.k1.l.c;

import androidx.core.view.InputDeviceCompat;
import c.a.r0.k1.l.c.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b implements c.a.q0.k0.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f21502e;

    /* renamed from: f  reason: collision with root package name */
    public a.C1001a f21503f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.k1.h.o.a f21504g;

    /* renamed from: h  reason: collision with root package name */
    public long f21505h;

    /* renamed from: i  reason: collision with root package name */
    public int f21506i;

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

    public static b a(ChatMessage chatMessage, a.C1001a c1001a) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, chatMessage, c1001a)) == null) {
            b bVar = new b();
            if (chatMessage == null) {
                return bVar;
            }
            c1001a.f21499h /= 100;
            bVar.o(chatMessage.getReadCountPv());
            bVar.m(c1001a);
            bVar.i(chatMessage.getTime());
            if (chatMessage.getObjContent() instanceof c.a.r0.k1.h.o.a) {
                bVar.k((c.a.r0.k1.h.o.a) chatMessage.getObjContent());
            }
            return bVar;
        }
        return (b) invokeLL.objValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21505h : invokeV.longValue;
    }

    public c.a.r0.k1.h.o.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f21504g : (c.a.r0.k1.h.o.a) invokeV.objValue;
    }

    public a.C1001a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f21503f : (a.C1001a) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f21506i : invokeV.intValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f21502e : invokeV.booleanValue;
    }

    public void i(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            this.f21505h = j2;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f21502e = z;
        }
    }

    public void k(c.a.r0.k1.h.o.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f21504g = aVar;
        }
    }

    public void m(a.C1001a c1001a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, c1001a) == null) {
            this.f21503f = c1001a;
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f21506i = i2;
        }
    }
}
