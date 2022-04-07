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
/* loaded from: classes2.dex */
public class co extends cr implements cn {
    public static /* synthetic */ Interceptable $ic;
    public static final ByteBuffer a;
    public transient /* synthetic */ FieldHolder $fh;
    public int f;
    public String g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581659206, "Lcom/baidu/mobstat/co;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581659206, "Lcom/baidu/mobstat/co;");
                return;
            }
        }
        a = ByteBuffer.allocate(0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public co() {
        super(cq.a.f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((cq.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a(true);
    }

    private void a(int i, String str) throws ch {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, this, i, str) == null) {
            String str2 = "";
            if (str == null) {
                str = "";
            }
            if (i == 1015) {
                i = 1005;
            } else {
                str2 = str;
            }
            if (i == 1005) {
                if (str2.length() > 0) {
                    throw new ch(1002, "A close frame must have a closecode if it has a reason");
                }
            } else if (i > 1011 && i < 3000 && i != 1015) {
                throw new ch(1002, "Trying to send an illegal close code!");
            } else {
                byte[] a2 = dc.a(str2);
                ByteBuffer allocate = ByteBuffer.allocate(4);
                allocate.putInt(i);
                allocate.position(2);
                ByteBuffer allocate2 = ByteBuffer.allocate(a2.length + 2);
                allocate2.put(allocate);
                allocate2.put(a2);
                allocate2.rewind();
                a(allocate2);
            }
        }
    }

    private void g() throws ci {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.f = 1005;
            ByteBuffer c = super.c();
            c.mark();
            if (c.remaining() >= 2) {
                ByteBuffer allocate = ByteBuffer.allocate(4);
                allocate.position(2);
                allocate.putShort(c.getShort());
                allocate.position(0);
                int i = allocate.getInt();
                this.f = i;
                if (i == 1006 || i == 1015 || i == 1005 || i > 4999 || i < 1000 || i == 1004) {
                    throw new ci("closecode must not be sent over the wire: " + this.f);
                }
            }
            c.reset();
        }
    }

    private void h() throws ch {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            if (this.f == 1005) {
                this.g = dc.a(super.c());
                return;
            }
            ByteBuffer c = super.c();
            int position = c.position();
            try {
                try {
                    c.position(c.position() + 2);
                    this.g = dc.a(c);
                } catch (IllegalArgumentException e) {
                    throw new ci(e);
                }
            } finally {
                c.position(position);
            }
        }
    }

    @Override // com.baidu.mobstat.cn
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.g : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobstat.cr, com.baidu.mobstat.cq
    public ByteBuffer c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f == 1005) {
                return a;
            }
            return super.c();
        }
        return (ByteBuffer) invokeV.objValue;
    }

    @Override // com.baidu.mobstat.cr
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return super.toString() + "code: " + this.f;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public co(int i, String str) throws ch {
        super(cq.a.f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((cq.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a(true);
        a(i, str);
    }

    @Override // com.baidu.mobstat.cn
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f : invokeV.intValue;
    }

    @Override // com.baidu.mobstat.cr, com.baidu.mobstat.cp
    public void a(ByteBuffer byteBuffer) throws ch {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer) == null) {
            super.a(byteBuffer);
            g();
            h();
        }
    }
}
