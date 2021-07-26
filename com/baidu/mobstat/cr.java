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
/* loaded from: classes2.dex */
public class cr implements cp {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f8964b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ByteBuffer f8965a;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8966c;

    /* renamed from: d  reason: collision with root package name */
    public cq.a f8967d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f8968e;

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
        f8964b = new byte[0];
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
            this.f8966c = z;
        }
    }

    @Override // com.baidu.mobstat.cp
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f8968e = z;
        }
    }

    @Override // com.baidu.mobstat.cq
    public ByteBuffer c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f8965a : (ByteBuffer) invokeV.objValue;
    }

    @Override // com.baidu.mobstat.cq
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f8966c : invokeV.booleanValue;
    }

    @Override // com.baidu.mobstat.cq
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f8968e : invokeV.booleanValue;
    }

    @Override // com.baidu.mobstat.cq
    public cq.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f8967d : (cq.a) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return "Framedata{ optcode:" + f() + ", fin:" + d() + ", payloadlength:[pos:" + this.f8965a.position() + ", len:" + this.f8965a.remaining() + "], payload:" + Arrays.toString(dc.a(new String(this.f8965a.array()))) + "}";
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
        this.f8967d = aVar;
        this.f8965a = ByteBuffer.wrap(f8964b);
    }

    @Override // com.baidu.mobstat.cp
    public void a(cq.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f8967d = aVar;
        }
    }

    @Override // com.baidu.mobstat.cp
    public void a(ByteBuffer byteBuffer) throws ch {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteBuffer) == null) {
            this.f8965a = byteBuffer;
        }
    }

    @Override // com.baidu.mobstat.cq
    public void a(cq cqVar) throws ci {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cqVar) == null) {
            ByteBuffer c2 = cqVar.c();
            if (this.f8965a == null) {
                this.f8965a = ByteBuffer.allocate(c2.remaining());
                c2.mark();
                this.f8965a.put(c2);
                c2.reset();
            } else {
                c2.mark();
                ByteBuffer byteBuffer = this.f8965a;
                byteBuffer.position(byteBuffer.limit());
                ByteBuffer byteBuffer2 = this.f8965a;
                byteBuffer2.limit(byteBuffer2.capacity());
                if (c2.remaining() > this.f8965a.remaining()) {
                    ByteBuffer allocate = ByteBuffer.allocate(c2.remaining() + this.f8965a.capacity());
                    this.f8965a.flip();
                    allocate.put(this.f8965a);
                    allocate.put(c2);
                    this.f8965a = allocate;
                } else {
                    this.f8965a.put(c2);
                }
                this.f8965a.rewind();
                c2.reset();
            }
            this.f8966c = cqVar.d();
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
        this.f8966c = cqVar.d();
        this.f8967d = cqVar.f();
        this.f8965a = cqVar.c();
        this.f8968e = cqVar.e();
    }
}
