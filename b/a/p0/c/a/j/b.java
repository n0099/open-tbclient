package b.a.p0.c.a.j;

import b.a.p0.c.a.i.f;
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
    public static f a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            f fVar = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b2 = wrap.get();
            byte b3 = wrap.get();
            if (b2 == -27 && b3 == -89) {
                fVar = new f();
                wrap.get();
                wrap.get();
                fVar.r(wrap.get());
                fVar.p(wrap.get());
                int i2 = wrap.getShort();
                fVar.q(i2);
                int i3 = wrap.getInt();
                fVar.k(i3);
                fVar.l(wrap.getLong());
                byte[] bArr2 = new byte[i2];
                wrap.get(bArr2, 0, i2);
                fVar.o(bArr2);
                if (i3 > 0) {
                    byte[] bArr3 = new byte[i3];
                    wrap.get(bArr3, 0, i3);
                    fVar.j(bArr3);
                }
            }
            return fVar;
        }
        return (f) invokeL.objValue;
    }

    public static byte[] b(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fVar)) == null) {
            if (fVar == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(fVar.h() + 20 + fVar.b());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (fVar.e() != null && fVar.e().length == 2) {
                allocate.put(fVar.e()[0]);
                allocate.put(fVar.e()[1]);
                allocate.put(fVar.i());
                allocate.put(fVar.g());
                if (fVar.f() != null && fVar.f().length != 0) {
                    int length = fVar.f().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (fVar.a() != null && fVar.a().length != 0) {
                        allocate.putInt(fVar.a().length);
                    } else {
                        allocate.putInt(0);
                    }
                    allocate.putLong(fVar.c());
                    if (fVar.f() != null) {
                        allocate.put(fVar.f());
                    }
                    if (fVar.a() != null) {
                        allocate.put(fVar.a());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
