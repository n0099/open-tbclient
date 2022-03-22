package c.a.j.h.b.b$d;

import c.a.j.h.b.b$b.k;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static k a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            k kVar = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b2 = wrap.get();
            byte b3 = wrap.get();
            if (b2 == -27 && b3 == -89) {
                kVar = new k();
                wrap.get();
                wrap.get();
                kVar.a(wrap.get());
                kVar.f(wrap.get());
                int i = wrap.getShort();
                kVar.c(i);
                int i2 = wrap.getInt();
                kVar.b(i2);
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                kVar.j(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    kVar.l(bArr3);
                }
            }
            return kVar;
        }
        return (k) invokeL.objValue;
    }

    public static byte[] b(k kVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, kVar)) == null) {
            if (kVar == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(kVar.m() + 12 + kVar.n());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (kVar.e() != null && kVar.e().length == 2) {
                allocate.put(kVar.e()[0]);
                allocate.put(kVar.e()[1]);
                allocate.put(kVar.i());
                allocate.put(kVar.k());
                if (kVar.o() != null && kVar.o().length != 0) {
                    int length = kVar.o().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (kVar.p() != null && kVar.p().length != 0) {
                        allocate.putInt(kVar.p().length);
                    } else {
                        allocate.putInt(0);
                    }
                    if (kVar.o() != null) {
                        allocate.put(kVar.o());
                    }
                    if (kVar.p() != null) {
                        allocate.put(kVar.p());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
