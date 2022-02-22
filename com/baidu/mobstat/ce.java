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
/* loaded from: classes10.dex */
public class ce extends cd {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ boolean f36829f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f36830g;

    /* renamed from: h  reason: collision with root package name */
    public final Random f36831h;

    /* loaded from: classes10.dex */
    public class a extends Throwable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ce a;

        /* renamed from: b  reason: collision with root package name */
        public int f36832b;

        public a(ce ceVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ceVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ceVar;
            this.f36832b = i2;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f36832b : invokeV.intValue;
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
        f36829f = !ce.class.desiredAssertionStatus();
    }

    public ce() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f36831h = new Random();
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
                return cd.b.f36827b;
            }
            return cd.b.f36827b;
        }
        return (cd.b) invokeLL.objValue;
    }

    @Override // com.baidu.mobstat.cd
    public cd.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? cd.a.f36825c : (cd.a) invokeV.objValue;
    }

    @Override // com.baidu.mobstat.cd
    public List<cq> c(ByteBuffer byteBuffer) throws ck, ch {
        LinkedList linkedList;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, byteBuffer)) == null) {
            while (true) {
                linkedList = new LinkedList();
                if (this.f36830g == null) {
                    break;
                }
                try {
                    byteBuffer.mark();
                    int remaining = byteBuffer.remaining();
                    int remaining2 = this.f36830g.remaining();
                    if (remaining2 > remaining) {
                        this.f36830g.put(byteBuffer.array(), byteBuffer.position(), remaining);
                        byteBuffer.position(byteBuffer.position() + remaining);
                        return Collections.emptyList();
                    }
                    this.f36830g.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                    byteBuffer.position(byteBuffer.position() + remaining2);
                    linkedList.add(e((ByteBuffer) this.f36830g.duplicate().position(0)));
                    this.f36830g = null;
                } catch (a e2) {
                    this.f36830g.limit();
                    ByteBuffer allocate = ByteBuffer.allocate(a(e2.a()));
                    if (!f36829f && allocate.limit() <= this.f36830g.limit()) {
                        throw new AssertionError();
                    }
                    this.f36830g.rewind();
                    allocate.put(this.f36830g);
                    this.f36830g = allocate;
                }
            }
            while (byteBuffer.hasRemaining()) {
                byteBuffer.mark();
                try {
                    linkedList.add(e(byteBuffer));
                } catch (a e3) {
                    byteBuffer.reset();
                    ByteBuffer allocate2 = ByteBuffer.allocate(a(e3.a()));
                    this.f36830g = allocate2;
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
            int i2 = 2;
            if (remaining >= 2) {
                byte b2 = byteBuffer.get();
                boolean z = (b2 >> 8) != 0;
                byte b3 = (byte) ((b2 & ByteCompanionObject.MAX_VALUE) >> 4);
                if (b3 == 0) {
                    byte b4 = byteBuffer.get();
                    boolean z2 = (b4 & Byte.MIN_VALUE) != 0;
                    int i3 = (byte) (b4 & ByteCompanionObject.MAX_VALUE);
                    cq.a a2 = a((byte) (b2 & 15));
                    if (z || !(a2 == cq.a.f36837d || a2 == cq.a.f36838e || a2 == cq.a.f36839f)) {
                        if (i3 < 0 || i3 > 125) {
                            if (a2 == cq.a.f36837d || a2 == cq.a.f36838e || a2 == cq.a.f36839f) {
                                throw new ci("more than 125 octets");
                            }
                            if (i3 != 126) {
                                i2 = 10;
                                if (remaining >= 10) {
                                    byte[] bArr = new byte[8];
                                    for (int i4 = 0; i4 < 8; i4++) {
                                        bArr[i4] = byteBuffer.get();
                                    }
                                    long longValue = new BigInteger(bArr).longValue();
                                    if (longValue > 2147483647L) {
                                        throw new ck("Payloadsize is to big...");
                                    }
                                    i3 = (int) longValue;
                                } else {
                                    throw new a(this, 10);
                                }
                            } else if (remaining >= 4) {
                                i3 = new BigInteger(new byte[]{0, byteBuffer.get(), byteBuffer.get()}).intValue();
                                i2 = 4;
                            } else {
                                throw new a(this, 4);
                            }
                        }
                        int i5 = i2 + (z2 ? 4 : 0) + i3;
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
                            if (a2 == cq.a.f36839f) {
                                crVar = new co();
                            } else {
                                crVar = new cr();
                                crVar.a(z);
                                crVar.a(a2);
                            }
                            allocate.flip();
                            crVar.a(allocate);
                            if (a2 != cq.a.f36835b || dc.b(crVar.c())) {
                                return crVar;
                            }
                            throw new ch(1007);
                        }
                        throw new a(this, i5);
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
            int i2 = 0;
            boolean z = this.f36822d == by.b.a;
            int i3 = c2.remaining() <= 125 ? 1 : c2.remaining() <= 65535 ? 2 : 8;
            ByteBuffer allocate = ByteBuffer.allocate((i3 > 1 ? i3 + 1 : i3) + 1 + (z ? 4 : 0) + c2.remaining());
            allocate.put((byte) (((byte) (cqVar.d() ? com.alipay.sdk.encrypt.a.f31098g : 0)) | a(cqVar.f())));
            byte[] a2 = a(c2.remaining(), i3);
            if (f36829f || a2.length == i3) {
                if (i3 == 1) {
                    allocate.put((byte) (a2[0] | (z ? Byte.MIN_VALUE : (byte) 0)));
                } else if (i3 == 2) {
                    allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | 126));
                    allocate.put(a2);
                } else if (i3 == 8) {
                    allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | ByteCompanionObject.MAX_VALUE));
                    allocate.put(a2);
                } else {
                    throw new RuntimeException("Size representation not supported/specified");
                }
                if (z) {
                    ByteBuffer allocate2 = ByteBuffer.allocate(4);
                    allocate2.putInt(this.f36831h.nextInt());
                    allocate.put(allocate2.array());
                    while (c2.hasRemaining()) {
                        allocate.put((byte) (c2.get() ^ allocate2.get(i2 % 4)));
                        i2++;
                    }
                } else {
                    allocate.put(c2);
                }
                if (f36829f || allocate.remaining() == 0) {
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
                crVar.a(cq.a.f36836c);
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
            if (aVar == cq.a.f36835b) {
                return (byte) 1;
            }
            if (aVar == cq.a.f36836c) {
                return (byte) 2;
            }
            if (aVar == cq.a.f36839f) {
                return (byte) 8;
            }
            if (aVar == cq.a.f36837d) {
                return (byte) 9;
            }
            if (aVar == cq.a.f36838e) {
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
            this.f36831h.nextBytes(bArr);
            ctVar.a("Sec-WebSocket-Key", db.a(bArr));
            return ctVar;
        }
        return (ct) invokeL.objValue;
    }

    private byte[] a(long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            byte[] bArr = new byte[i2];
            int i3 = (i2 * 8) - 8;
            for (int i4 = 0; i4 < i2; i4++) {
                bArr[i4] = (byte) (j2 >>> (i3 - (i4 * 8)));
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
                                return cq.a.f36839f;
                            case 9:
                                return cq.a.f36837d;
                            case 10:
                                return cq.a.f36838e;
                            default:
                                throw new ci("unknow optcode " + ((int) b2));
                        }
                    }
                    return cq.a.f36836c;
                }
                return cq.a.f36835b;
            }
            return cq.a.a;
        }
        return (cq.a) invokeB.objValue;
    }

    @Override // com.baidu.mobstat.cd
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f36830g = null;
        }
    }
}
