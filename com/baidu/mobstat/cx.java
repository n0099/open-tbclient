package com.baidu.mobstat;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.cw;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class cx implements cv {
    public static /* synthetic */ Interceptable $ic;
    public static byte[] b;
    public transient /* synthetic */ FieldHolder $fh;
    public ByteBuffer a;
    public boolean c;
    public cw.a d;
    public boolean e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581659485, "Lcom/baidu/mobstat/cx;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581659485, "Lcom/baidu/mobstat/cx;");
                return;
            }
        }
        b = new byte[0];
    }

    public cx() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.mobstat.cw
    public ByteBuffer c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a;
        }
        return (ByteBuffer) invokeV.objValue;
    }

    @Override // com.baidu.mobstat.cw
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.mobstat.cw
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.mobstat.cw
    public cw.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.d;
        }
        return (cw.a) invokeV.objValue;
    }

    public cx(cw.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.d = aVar;
        this.a = ByteBuffer.wrap(b);
    }

    public cx(cw cwVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cwVar};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.c = cwVar.d();
        this.d = cwVar.f();
        this.a = cwVar.c();
        this.e = cwVar.e();
    }

    @Override // com.baidu.mobstat.cv
    public void a(cw.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.d = aVar;
        }
    }

    @Override // com.baidu.mobstat.cv
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.e = z;
        }
    }

    @Override // com.baidu.mobstat.cw
    public void a(cw cwVar) throws co {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cwVar) == null) {
            ByteBuffer c = cwVar.c();
            if (this.a == null) {
                this.a = ByteBuffer.allocate(c.remaining());
                c.mark();
                this.a.put(c);
                c.reset();
            } else {
                c.mark();
                ByteBuffer byteBuffer = this.a;
                byteBuffer.position(byteBuffer.limit());
                ByteBuffer byteBuffer2 = this.a;
                byteBuffer2.limit(byteBuffer2.capacity());
                if (c.remaining() > this.a.remaining()) {
                    ByteBuffer allocate = ByteBuffer.allocate(c.remaining() + this.a.capacity());
                    this.a.flip();
                    allocate.put(this.a);
                    allocate.put(c);
                    this.a = allocate;
                } else {
                    this.a.put(c);
                }
                this.a.rewind();
                c.reset();
            }
            this.c = cwVar.d();
        }
    }

    @Override // com.baidu.mobstat.cv
    public void a(ByteBuffer byteBuffer) throws cn {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteBuffer) == null) {
            this.a = byteBuffer;
        }
    }

    @Override // com.baidu.mobstat.cv
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.c = z;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return "Framedata{ optcode:" + f() + ", fin:" + d() + ", payloadlength:[pos:" + this.a.position() + ", len:" + this.a.remaining() + "], payload:" + Arrays.toString(di.a(new String(this.a.array()))) + "}";
        }
        return (String) invokeV.objValue;
    }
}
