package com.baidu.mobstat;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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

    /* renamed from: a  reason: collision with root package name */
    public static final ByteBuffer f8928a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public int f8929f;

    /* renamed from: g  reason: collision with root package name */
    public String f8930g;

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
        f8928a = ByteBuffer.allocate(0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public co() {
        super(cq.a.f8936f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((cq.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a(true);
    }

    private void a(int i2, String str) throws ch {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, this, i2, str) == null) {
            String str2 = "";
            if (str == null) {
                str = "";
            }
            if (i2 == 1015) {
                i2 = 1005;
            } else {
                str2 = str;
            }
            if (i2 == 1005) {
                if (str2.length() > 0) {
                    throw new ch(1002, "A close frame must have a closecode if it has a reason");
                }
            } else if (i2 > 1011 && i2 < 3000 && i2 != 1015) {
                throw new ch(1002, "Trying to send an illegal close code!");
            } else {
                byte[] a2 = dc.a(str2);
                ByteBuffer allocate = ByteBuffer.allocate(4);
                allocate.putInt(i2);
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
            this.f8929f = 1005;
            ByteBuffer c2 = super.c();
            c2.mark();
            if (c2.remaining() >= 2) {
                ByteBuffer allocate = ByteBuffer.allocate(4);
                allocate.position(2);
                allocate.putShort(c2.getShort());
                allocate.position(0);
                int i2 = allocate.getInt();
                this.f8929f = i2;
                if (i2 == 1006 || i2 == 1015 || i2 == 1005 || i2 > 4999 || i2 < 1000 || i2 == 1004) {
                    throw new ci("closecode must not be sent over the wire: " + this.f8929f);
                }
            }
            c2.reset();
        }
    }

    private void h() throws ch {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            if (this.f8929f == 1005) {
                this.f8930g = dc.a(super.c());
                return;
            }
            ByteBuffer c2 = super.c();
            int position = c2.position();
            try {
                try {
                    c2.position(c2.position() + 2);
                    this.f8930g = dc.a(c2);
                } catch (IllegalArgumentException e2) {
                    throw new ci(e2);
                }
            } finally {
                c2.position(position);
            }
        }
    }

    @Override // com.baidu.mobstat.cn
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f8930g : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobstat.cr, com.baidu.mobstat.cq
    public ByteBuffer c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f8929f == 1005) {
                return f8928a;
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
            return super.toString() + "code: " + this.f8929f;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public co(int i2, String str) throws ch {
        super(cq.a.f8936f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((cq.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a(true);
        a(i2, str);
    }

    @Override // com.baidu.mobstat.cn
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f8929f : invokeV.intValue;
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
