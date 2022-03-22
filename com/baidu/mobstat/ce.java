package com.baidu.mobstat;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.by;
import com.baidu.mobstat.cd;
import com.baidu.mobstat.cq;
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
/* loaded from: classes4.dex */
public class ce extends cd {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ boolean f27365f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f27366g;

    /* renamed from: h  reason: collision with root package name */
    public final Random f27367h;

    /* loaded from: classes4.dex */
    public class a extends Throwable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ce a;

        /* renamed from: b  reason: collision with root package name */
        public int f27368b;

        public a(ce ceVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ceVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ceVar;
            this.f27368b = i;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f27368b : invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581658896, "Lcom/baidu/mobstat/ce;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581658896, "Lcom/baidu/mobstat/ce;");
                return;
            }
        }
        f27365f = !ce.class.desiredAssertionStatus();
    }

    public ce() {
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
        this.f27367h = new Random();
    }

    @Override // com.baidu.mobstat.cd
    public cd.b a(cs csVar, cz czVar) throws cj {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, csVar, czVar)) == null) {
            if (csVar.c("Sec-WebSocket-Key") && czVar.c("Sec-WebSocket-Accept")) {
                if (a(csVar.b("Sec-WebSocket-Key")).equals(czVar.b("Sec-WebSocket-Accept"))) {
                    return cd.b.a;
                }
                return cd.b.f27363b;
            }
            return cd.b.f27363b;
        }
        return (cd.b) invokeLL.objValue;
    }

    @Override // com.baidu.mobstat.cd
    public cd.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? cd.a.f27361c : (cd.a) invokeV.objValue;
    }

    @Override // com.baidu.mobstat.cd
    public List<cq> c(ByteBuffer byteBuffer) throws ck, ch {
        LinkedList linkedList;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, byteBuffer)) == null) {
            while (true) {
                linkedList = new LinkedList();
                if (this.f27366g == null) {
                    break;
                }
                try {
                    byteBuffer.mark();
                    int remaining = byteBuffer.remaining();
                    int remaining2 = this.f27366g.remaining();
                    if (remaining2 > remaining) {
                        this.f27366g.put(byteBuffer.array(), byteBuffer.position(), remaining);
                        byteBuffer.position(byteBuffer.position() + remaining);
                        return Collections.emptyList();
                    }
                    this.f27366g.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                    byteBuffer.position(byteBuffer.position() + remaining2);
                    linkedList.add(e((ByteBuffer) this.f27366g.duplicate().position(0)));
                    this.f27366g = null;
                } catch (a e2) {
                    this.f27366g.limit();
                    ByteBuffer allocate = ByteBuffer.allocate(a(e2.a()));
                    if (!f27365f && allocate.limit() <= this.f27366g.limit()) {
                        throw new AssertionError();
                    }
                    this.f27366g.rewind();
                    allocate.put(this.f27366g);
                    this.f27366g = allocate;
                }
            }
            while (byteBuffer.hasRemaining()) {
                byteBuffer.mark();
                try {
                    linkedList.add(e(byteBuffer));
                } catch (a e3) {
                    byteBuffer.reset();
                    ByteBuffer allocate2 = ByteBuffer.allocate(a(e3.a()));
                    this.f27366g = allocate2;
                    allocate2.put(byteBuffer);
                }
            }
            return linkedList;
        }
        return (List) invokeL.objValue;
    }

    public cq e(ByteBuffer byteBuffer) throws a, ch {
        InterceptResult invokeL;
        cp crVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteBuffer)) == null) {
            int remaining = byteBuffer.remaining();
            int i = 2;
            if (remaining >= 2) {
                byte b2 = byteBuffer.get();
                boolean z = (b2 >> 8) != 0;
                byte b3 = (byte) ((b2 & ByteCompanionObject.MAX_VALUE) >> 4);
                if (b3 == 0) {
                    byte b4 = byteBuffer.get();
                    boolean z2 = (b4 & Byte.MIN_VALUE) != 0;
                    int i2 = (byte) (b4 & ByteCompanionObject.MAX_VALUE);
                    cq.a a2 = a((byte) (b2 & 15));
                    if (z || !(a2 == cq.a.f27373d || a2 == cq.a.f27374e || a2 == cq.a.f27375f)) {
                        if (i2 < 0 || i2 > 125) {
                            if (a2 == cq.a.f27373d || a2 == cq.a.f27374e || a2 == cq.a.f27375f) {
                                throw new ci("more than 125 octets");
                            }
                            if (i2 != 126) {
                                i = 10;
                                if (remaining >= 10) {
                                    byte[] bArr = new byte[8];
                                    for (int i3 = 0; i3 < 8; i3++) {
                                        bArr[i3] = byteBuffer.get();
                                    }
                                    long longValue = new BigInteger(bArr).longValue();
                                    if (longValue > 2147483647L) {
                                        throw new ck("Payloadsize is to big...");
                                    }
                                    i2 = (int) longValue;
                                } else {
                                    throw new a(this, 10);
                                }
                            } else if (remaining >= 4) {
                                i2 = new BigInteger(new byte[]{0, byteBuffer.get(), byteBuffer.get()}).intValue();
                                i = 4;
                            } else {
                                throw new a(this, 4);
                            }
                        }
                        int i4 = i + (z2 ? 4 : 0) + i2;
                        if (remaining >= i4) {
                            ByteBuffer allocate = ByteBuffer.allocate(a(i2));
                            if (z2) {
                                byte[] bArr2 = new byte[4];
                                byteBuffer.get(bArr2);
                                for (int i5 = 0; i5 < i2; i5++) {
                                    allocate.put((byte) (byteBuffer.get() ^ bArr2[i5 % 4]));
                                }
                            } else {
                                allocate.put(byteBuffer.array(), byteBuffer.position(), allocate.limit());
                                byteBuffer.position(byteBuffer.position() + allocate.limit());
                            }
                            if (a2 == cq.a.f27375f) {
                                crVar = new co();
                            } else {
                                crVar = new cr();
                                crVar.a(z);
                                crVar.a(a2);
                            }
                            allocate.flip();
                            crVar.a(allocate);
                            if (a2 != cq.a.f27371b || dc.b(crVar.c())) {
                                return crVar;
                            }
                            throw new ch(1007);
                        }
                        throw new a(this, i4);
                    }
                    throw new ci("control frames may no be fragmented");
                }
                throw new ci("bad rsv " + ((int) b3));
            }
            throw new a(this, 2);
        }
        return (cq) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.cd
    public ByteBuffer a(cq cqVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cqVar)) == null) {
            ByteBuffer c2 = cqVar.c();
            int i = 0;
            boolean z = this.f27358d == by.b.a;
            int i2 = c2.remaining() <= 125 ? 1 : c2.remaining() <= 65535 ? 2 : 8;
            ByteBuffer allocate = ByteBuffer.allocate((i2 > 1 ? i2 + 1 : i2) + 1 + (z ? 4 : 0) + c2.remaining());
            allocate.put((byte) (((byte) (cqVar.d() ? -128 : 0)) | a(cqVar.f())));
            byte[] a2 = a(c2.remaining(), i2);
            if (f27365f || a2.length == i2) {
                if (i2 == 1) {
                    allocate.put((byte) (a2[0] | (z ? Byte.MIN_VALUE : (byte) 0)));
                } else if (i2 == 2) {
                    allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | 126));
                    allocate.put(a2);
                } else if (i2 == 8) {
                    allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | ByteCompanionObject.MAX_VALUE));
                    allocate.put(a2);
                } else {
                    throw new RuntimeException("Size representation not supported/specified");
                }
                if (z) {
                    ByteBuffer allocate2 = ByteBuffer.allocate(4);
                    allocate2.putInt(this.f27367h.nextInt());
                    allocate.put(allocate2.array());
                    while (c2.hasRemaining()) {
                        allocate.put((byte) (c2.get() ^ allocate2.get(i % 4)));
                        i++;
                    }
                } else {
                    allocate.put(c2);
                }
                if (f27365f || allocate.remaining() == 0) {
                    allocate.flip();
                    return allocate;
                }
                throw new AssertionError(allocate.remaining());
            }
            throw new AssertionError();
        }
        return (ByteBuffer) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.cd
    public cd c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new ce() : (cd) invokeV.objValue;
    }

    @Override // com.baidu.mobstat.cd
    public List<cq> a(ByteBuffer byteBuffer, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, byteBuffer, z)) == null) {
            cr crVar = new cr();
            try {
                crVar.a(byteBuffer);
                crVar.a(true);
                crVar.a(cq.a.f27372c);
                crVar.b(z);
                return Collections.singletonList(crVar);
            } catch (ch e2) {
                throw new cl(e2);
            }
        }
        return (List) invokeLZ.objValue;
    }

    private byte a(cq.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, aVar)) == null) {
            if (aVar == cq.a.a) {
                return (byte) 0;
            }
            if (aVar == cq.a.f27371b) {
                return (byte) 1;
            }
            if (aVar == cq.a.f27372c) {
                return (byte) 2;
            }
            if (aVar == cq.a.f27375f) {
                return (byte) 8;
            }
            if (aVar == cq.a.f27373d) {
                return (byte) 9;
            }
            if (aVar == cq.a.f27374e) {
                return (byte) 10;
            }
            throw new RuntimeException("Don't know how to handle " + aVar.toString());
        }
        return invokeL.byteValue;
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            String trim = str.trim();
            try {
                return db.a(MessageDigest.getInstance("SHA1").digest((trim + WebSocketProtocol.ACCEPT_MAGIC).getBytes()));
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.cd
    public ct a(ct ctVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ctVar)) == null) {
            ctVar.a("Upgrade", "websocket");
            ctVar.a(HTTP.CONN_DIRECTIVE, "Upgrade");
            ctVar.a("Sec-WebSocket-Version", "8");
            byte[] bArr = new byte[16];
            this.f27367h.nextBytes(bArr);
            ctVar.a("Sec-WebSocket-Key", db.a(bArr));
            return ctVar;
        }
        return (ct) invokeL.objValue;
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

    private cq.a a(byte b2) throws ci {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(65539, this, b2)) == null) {
            if (b2 != 0) {
                if (b2 != 1) {
                    if (b2 != 2) {
                        switch (b2) {
                            case 8:
                                return cq.a.f27375f;
                            case 9:
                                return cq.a.f27373d;
                            case 10:
                                return cq.a.f27374e;
                            default:
                                throw new ci("unknow optcode " + ((int) b2));
                        }
                    }
                    return cq.a.f27372c;
                }
                return cq.a.f27371b;
            }
            return cq.a.a;
        }
        return (cq.a) invokeB.objValue;
    }

    @Override // com.baidu.mobstat.cd
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f27366g = null;
        }
    }
}
