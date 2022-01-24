package com.baidu.mobstat;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.cq;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: classes10.dex */
public class cr implements cp {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f36635b;
    public transient /* synthetic */ FieldHolder $fh;
    public ByteBuffer a;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36636c;

    /* renamed from: d  reason: collision with root package name */
    public cq.a f36637d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f36638e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581659299, "Lcom/baidu/mobstat/cr;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581659299, "Lcom/baidu/mobstat/cr;");
                return;
            }
        }
        f36635b = new byte[0];
    }

    public cr() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.mobstat.cp
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f36636c = z;
        }
    }

    @Override // com.baidu.mobstat.cp
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f36638e = z;
        }
    }

    @Override // com.baidu.mobstat.cq
    public ByteBuffer c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : (ByteBuffer) invokeV.objValue;
    }

    @Override // com.baidu.mobstat.cq
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f36636c : invokeV.booleanValue;
    }

    @Override // com.baidu.mobstat.cq
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f36638e : invokeV.booleanValue;
    }

    @Override // com.baidu.mobstat.cq
    public cq.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f36637d : (cq.a) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return "Framedata{ optcode:" + f() + ", fin:" + d() + ", payloadlength:[pos:" + this.a.position() + ", len:" + this.a.remaining() + "], payload:" + Arrays.toString(dc.a(new String(this.a.array()))) + "}";
        }
        return (String) invokeV.objValue;
    }

    public cr(cq.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f36637d = aVar;
        this.a = ByteBuffer.wrap(f36635b);
    }

    @Override // com.baidu.mobstat.cp
    public void a(cq.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f36637d = aVar;
        }
    }

    @Override // com.baidu.mobstat.cp
    public void a(ByteBuffer byteBuffer) throws ch {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteBuffer) == null) {
            this.a = byteBuffer;
        }
    }

    @Override // com.baidu.mobstat.cq
    public void a(cq cqVar) throws ci {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cqVar) == null) {
            ByteBuffer c2 = cqVar.c();
            if (this.a == null) {
                this.a = ByteBuffer.allocate(c2.remaining());
                c2.mark();
                this.a.put(c2);
                c2.reset();
            } else {
                c2.mark();
                ByteBuffer byteBuffer = this.a;
                byteBuffer.position(byteBuffer.limit());
                ByteBuffer byteBuffer2 = this.a;
                byteBuffer2.limit(byteBuffer2.capacity());
                if (c2.remaining() > this.a.remaining()) {
                    ByteBuffer allocate = ByteBuffer.allocate(c2.remaining() + this.a.capacity());
                    this.a.flip();
                    allocate.put(this.a);
                    allocate.put(c2);
                    this.a = allocate;
                } else {
                    this.a.put(c2);
                }
                this.a.rewind();
                c2.reset();
            }
            this.f36636c = cqVar.d();
        }
    }

    public cr(cq cqVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cqVar};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f36636c = cqVar.d();
        this.f36637d = cqVar.f();
        this.a = cqVar.c();
        this.f36638e = cqVar.e();
    }
}
