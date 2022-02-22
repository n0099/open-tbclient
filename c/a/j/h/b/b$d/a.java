package c.a.j.h.b.b$d;

import c.a.j.h.b.b;
import c.a.j.h.b.b$b.b;
import c.a.j.h.b.b$b.c;
import c.a.j.h.b.b$b.d;
import c.a.j.h.b.b$b.e;
import c.a.j.h.b.b$b.f;
import c.a.j.h.b.b$b.i;
import c.a.j.h.b.b$b.m;
import c.a.j.h.d.g;
import com.baidu.bdptask.bdtls.DH;
import com.baidu.bdptask.bdtls.RSA;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static i a(m mVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65536, null, mVar, bArr)) != null) {
            return (i) invokeLL.objValue;
        }
        i iVar = null;
        if (mVar == null || bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            if (bArr[0] != 2) {
                return null;
            }
            i iVar2 = new i();
            try {
                f a = f.a(Arrays.copyOfRange(bArr, 1, bArr.length));
                if (a == null) {
                    return null;
                }
                iVar2.a(a);
                List<d> b2 = a.b();
                if (b2 == null) {
                    return null;
                }
                for (d dVar : b2) {
                    int a2 = dVar.a();
                    byte[] b3 = dVar.b();
                    if (a2 == 0) {
                        int a3 = b.g.a(RSA.decrypt(b3));
                        mVar.e(DH.getDHSecretKey(a3, mVar.o().intValue(), mVar.p().intValue()));
                        mVar.l(Integer.valueOf(a3));
                    }
                }
                if (a.e() == null) {
                    return null;
                }
                b.a d2 = c.a.j.h.b.b$b.b.d();
                d2.a(a.e());
                mVar.h(d2.b().a());
                if (mVar.q() == null) {
                    return null;
                }
                long currentTimeMillis = (System.currentTimeMillis() / 1000) + a.c();
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("liftTime=" + a.c());
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("expireTime=" + currentTimeMillis);
                mVar.c(currentTimeMillis);
                if (a.d() != null) {
                    mVar.j(a.d());
                    return iVar2;
                }
                return iVar2;
            } catch (Exception e2) {
                e = e2;
                iVar = iVar2;
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("exception=" + e.getMessage());
                return iVar;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static byte[] b(m mVar, i iVar) throws Exception {
        InterceptResult invokeLL;
        byte[] encrypt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, mVar, iVar)) == null) {
            if (iVar == null) {
                return null;
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            byte[] bArr = new byte[32];
            new Random().nextBytes(bArr);
            e.a a = e.a();
            a.a(Integer.valueOf(currentTimeMillis));
            a.b(c.a.j.h.d.f.a(bArr));
            e c2 = a.c();
            int dHGroupId = DH.getDHGroupId();
            int dHSecret = DH.getDHSecret();
            int dHPublicKey = DH.getDHPublicKey(dHGroupId, dHSecret);
            mVar.d(Integer.valueOf(dHGroupId));
            mVar.g(Integer.valueOf(dHSecret));
            mVar.i(Integer.valueOf(dHPublicKey));
            byte[] d2 = b.g.d(dHPublicKey);
            if (d2 == null || (encrypt = RSA.encrypt(d2)) == null) {
                return null;
            }
            byte[] bytes = g.b(c.a.j.h.d.i.b(c.a.j.h.d.b.a()), false).getBytes();
            LinkedList linkedList = new LinkedList();
            d.a d3 = d.d();
            d3.a(0);
            d3.b(c.a.j.h.d.f.a(encrypt));
            linkedList.offer(d3.c());
            d.a d4 = d.d();
            d4.a(1);
            d4.b(c.a.j.h.d.f.a(new byte[]{0}));
            linkedList.offer(d4.c());
            d.a d5 = d.d();
            d5.a(2);
            d5.b(c.a.j.h.d.f.a(b.g.d(dHGroupId)));
            linkedList.offer(d5.c());
            d.a d6 = d.d();
            d6.a(3);
            d6.b(c.a.j.h.d.f.a(bytes));
            linkedList.offer(d6.c());
            if (c.a.j.h.b.b.f4057c.h().d()) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("groupId encode=" + dHGroupId);
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("secretC encode=" + dHSecret);
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("pubKey encode=" + dHPublicKey);
                DebugTrace debugTrace4 = DebugTrace.a;
                debugTrace4.a("signature encode=" + new String(bytes));
            }
            c.a d7 = c.d();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                d7.a((d) it.next());
            }
            d7.b(c2);
            d7.c(c.a.j.h.d.f.a(b.c.a));
            byte[] a2 = d7.d().a();
            ByteBuffer allocate = ByteBuffer.allocate(a2.length + 1);
            allocate.put((byte) 1);
            allocate.put(a2);
            return allocate.array();
        }
        return (byte[]) invokeLL.objValue;
    }
}
