package com.baidu.mobstat;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.ce;
import com.baidu.mobstat.cj;
import com.baidu.mobstat.cw;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import kotlin.jvm.internal.ByteCompanionObject;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class ck extends cj {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public ByteBuffer g;
    public final Random h;

    /* loaded from: classes2.dex */
    public class a extends Throwable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ck a;
        public int b;

        public a(ck ckVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ckVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ckVar;
            this.b = i;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b;
            }
            return invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581659082, "Lcom/baidu/mobstat/ck;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581659082, "Lcom/baidu/mobstat/ck;");
                return;
            }
        }
        f = !ck.class.desiredAssertionStatus();
    }

    public ck() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.h = new Random();
    }

    @Override // com.baidu.mobstat.cj
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.g = null;
        }
    }

    @Override // com.baidu.mobstat.cj
    public cj.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return cj.a.c;
        }
        return (cj.a) invokeV.objValue;
    }

    @Override // com.baidu.mobstat.cj
    public cj c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return new ck();
        }
        return (cj) invokeV.objValue;
    }

    private byte a(cw.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, aVar)) == null) {
            if (aVar == cw.a.a) {
                return (byte) 0;
            }
            if (aVar == cw.a.b) {
                return (byte) 1;
            }
            if (aVar == cw.a.c) {
                return (byte) 2;
            }
            if (aVar == cw.a.f) {
                return (byte) 8;
            }
            if (aVar == cw.a.d) {
                return (byte) 9;
            }
            if (aVar == cw.a.e) {
                return (byte) 10;
            }
            throw new RuntimeException("Don't know how to handle " + aVar.toString());
        }
        return invokeL.byteValue;
    }

    private cw.a a(byte b) throws co {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(65539, this, b)) == null) {
            if (b != 0) {
                if (b != 1) {
                    if (b != 2) {
                        switch (b) {
                            case 8:
                                return cw.a.f;
                            case 9:
                                return cw.a.d;
                            case 10:
                                return cw.a.e;
                            default:
                                throw new co("unknow optcode " + ((int) b));
                        }
                    }
                    return cw.a.c;
                }
                return cw.a.b;
            }
            return cw.a.a;
        }
        return (cw.a) invokeB.objValue;
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            String trim = str.trim();
            try {
                return dh.a(MessageDigest.getInstance("SHA1").digest((trim + WebSocketProtocol.ACCEPT_MAGIC).getBytes()));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
        return (String) invokeL.objValue;
    }

    private byte[] a(long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) {
            byte[] bArr = new byte[i];
            int i2 = (i * 8) - 8;
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) (j >>> (i2 - (i3 * 8)));
            }
            return bArr;
        }
        return (byte[]) invokeCommon.objValue;
    }

    @Override // com.baidu.mobstat.cj
    public cj.b a(cy cyVar, df dfVar) throws cp {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cyVar, dfVar)) == null) {
            if (cyVar.c("Sec-WebSocket-Key") && dfVar.c("Sec-WebSocket-Accept")) {
                if (a(cyVar.b("Sec-WebSocket-Key")).equals(dfVar.b("Sec-WebSocket-Accept"))) {
                    return cj.b.a;
                }
                return cj.b.b;
            }
            return cj.b.b;
        }
        return (cj.b) invokeLL.objValue;
    }

    @Override // com.baidu.mobstat.cj
    public cz a(cz czVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, czVar)) == null) {
            czVar.a("Upgrade", "websocket");
            czVar.a(HTTP.CONN_DIRECTIVE, "Upgrade");
            czVar.a("Sec-WebSocket-Version", "8");
            byte[] bArr = new byte[16];
            this.h.nextBytes(bArr);
            czVar.a("Sec-WebSocket-Key", dh.a(bArr));
            return czVar;
        }
        return (cz) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.cj
    public ByteBuffer a(cw cwVar) {
        InterceptResult invokeL;
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cwVar)) == null) {
            ByteBuffer c = cwVar.c();
            int i5 = 0;
            if (this.d == ce.b.a) {
                z = true;
            } else {
                z = false;
            }
            if (c.remaining() <= 125) {
                i = 1;
            } else if (c.remaining() <= 65535) {
                i = 2;
            } else {
                i = 8;
            }
            if (i > 1) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            int i6 = i2 + 1;
            if (z) {
                i3 = 4;
            } else {
                i3 = 0;
            }
            ByteBuffer allocate = ByteBuffer.allocate(i6 + i3 + c.remaining());
            byte a2 = a(cwVar.f());
            byte b = Byte.MIN_VALUE;
            if (cwVar.d()) {
                i4 = -128;
            } else {
                i4 = 0;
            }
            allocate.put((byte) (((byte) i4) | a2));
            byte[] a3 = a(c.remaining(), i);
            if (!f && a3.length != i) {
                throw new AssertionError();
            }
            if (i == 1) {
                byte b2 = a3[0];
                if (!z) {
                    b = 0;
                }
                allocate.put((byte) (b2 | b));
            } else if (i == 2) {
                if (!z) {
                    b = 0;
                }
                allocate.put((byte) (b | 126));
                allocate.put(a3);
            } else if (i == 8) {
                if (!z) {
                    b = 0;
                }
                allocate.put((byte) (b | ByteCompanionObject.MAX_VALUE));
                allocate.put(a3);
            } else {
                throw new RuntimeException("Size representation not supported/specified");
            }
            if (z) {
                ByteBuffer allocate2 = ByteBuffer.allocate(4);
                allocate2.putInt(this.h.nextInt());
                allocate.put(allocate2.array());
                while (c.hasRemaining()) {
                    allocate.put((byte) (c.get() ^ allocate2.get(i5 % 4)));
                    i5++;
                }
            } else {
                allocate.put(c);
            }
            if (!f && allocate.remaining() != 0) {
                throw new AssertionError(allocate.remaining());
            }
            allocate.flip();
            return allocate;
        }
        return (ByteBuffer) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.cj
    public List<cw> c(ByteBuffer byteBuffer) throws cq, cn {
        LinkedList linkedList;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, byteBuffer)) == null) {
            while (true) {
                linkedList = new LinkedList();
                if (this.g == null) {
                    break;
                }
                try {
                    byteBuffer.mark();
                    int remaining = byteBuffer.remaining();
                    int remaining2 = this.g.remaining();
                    if (remaining2 > remaining) {
                        this.g.put(byteBuffer.array(), byteBuffer.position(), remaining);
                        byteBuffer.position(byteBuffer.position() + remaining);
                        return Collections.emptyList();
                    }
                    this.g.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                    byteBuffer.position(byteBuffer.position() + remaining2);
                    linkedList.add(e((ByteBuffer) this.g.duplicate().position(0)));
                    this.g = null;
                } catch (a e) {
                    this.g.limit();
                    ByteBuffer allocate = ByteBuffer.allocate(a(e.a()));
                    if (!f && allocate.limit() <= this.g.limit()) {
                        throw new AssertionError();
                    }
                    this.g.rewind();
                    allocate.put(this.g);
                    this.g = allocate;
                }
            }
            while (byteBuffer.hasRemaining()) {
                byteBuffer.mark();
                try {
                    linkedList.add(e(byteBuffer));
                } catch (a e2) {
                    byteBuffer.reset();
                    ByteBuffer allocate2 = ByteBuffer.allocate(a(e2.a()));
                    this.g = allocate2;
                    allocate2.put(byteBuffer);
                }
            }
            return linkedList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.cj
    public List<cw> a(ByteBuffer byteBuffer, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, byteBuffer, z)) == null) {
            cx cxVar = new cx();
            try {
                cxVar.a(byteBuffer);
                cxVar.a(true);
                cxVar.a(cw.a.c);
                cxVar.b(z);
                return Collections.singletonList(cxVar);
            } catch (cn e) {
                throw new cr(e);
            }
        }
        return (List) invokeLZ.objValue;
    }

    public cw e(ByteBuffer byteBuffer) throws a, cn {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        int i;
        cv cxVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteBuffer)) == null) {
            int remaining = byteBuffer.remaining();
            int i2 = 2;
            if (remaining >= 2) {
                byte b = byteBuffer.get();
                if ((b >> 8) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                byte b2 = (byte) ((b & ByteCompanionObject.MAX_VALUE) >> 4);
                if (b2 == 0) {
                    byte b3 = byteBuffer.get();
                    if ((b3 & Byte.MIN_VALUE) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    int i3 = (byte) (b3 & ByteCompanionObject.MAX_VALUE);
                    cw.a a2 = a((byte) (b & 15));
                    if (!z && (a2 == cw.a.d || a2 == cw.a.e || a2 == cw.a.f)) {
                        throw new co("control frames may no be fragmented");
                    }
                    if (i3 < 0 || i3 > 125) {
                        if (a2 != cw.a.d && a2 != cw.a.e && a2 != cw.a.f) {
                            if (i3 == 126) {
                                if (remaining >= 4) {
                                    i3 = new BigInteger(new byte[]{0, byteBuffer.get(), byteBuffer.get()}).intValue();
                                    i2 = 4;
                                } else {
                                    throw new a(this, 4);
                                }
                            } else {
                                i2 = 10;
                                if (remaining >= 10) {
                                    byte[] bArr = new byte[8];
                                    for (int i4 = 0; i4 < 8; i4++) {
                                        bArr[i4] = byteBuffer.get();
                                    }
                                    long longValue = new BigInteger(bArr).longValue();
                                    if (longValue <= 2147483647L) {
                                        i3 = (int) longValue;
                                    } else {
                                        throw new cq("Payloadsize is to big...");
                                    }
                                } else {
                                    throw new a(this, 10);
                                }
                            }
                        } else {
                            throw new co("more than 125 octets");
                        }
                    }
                    if (z2) {
                        i = 4;
                    } else {
                        i = 0;
                    }
                    int i5 = i2 + i + i3;
                    if (remaining >= i5) {
                        ByteBuffer allocate = ByteBuffer.allocate(a(i3));
                        if (z2) {
                            byte[] bArr2 = new byte[4];
                            byteBuffer.get(bArr2);
                            for (int i6 = 0; i6 < i3; i6++) {
                                allocate.put((byte) (byteBuffer.get() ^ bArr2[i6 % 4]));
                            }
                        } else {
                            allocate.put(byteBuffer.array(), byteBuffer.position(), allocate.limit());
                            byteBuffer.position(byteBuffer.position() + allocate.limit());
                        }
                        if (a2 == cw.a.f) {
                            cxVar = new cu();
                        } else {
                            cxVar = new cx();
                            cxVar.a(z);
                            cxVar.a(a2);
                        }
                        allocate.flip();
                        cxVar.a(allocate);
                        if (a2 == cw.a.b && !di.b(cxVar.c())) {
                            throw new cn(1007);
                        }
                        return cxVar;
                    }
                    throw new a(this, i5);
                }
                throw new co("bad rsv " + ((int) b2));
            }
            throw new a(this, 2);
        }
        return (cw) invokeL.objValue;
    }
}
