package b.a.p0.c.a.j;

import b.a.p0.c.a.e;
import b.a.p0.c.a.i.d;
import b.a.p0.c.a.i.g;
import b.a.p0.t.f;
import com.baidu.swan.bdtls.Certificate;
import com.baidu.swan.bdtls.DH;
import com.baidu.swan.bdtls.RSA;
import com.baidu.swan.bdtls.impl.model.Bdtls$ApplicationData;
import com.baidu.swan.bdtls.impl.model.Bdtls$ClientHello;
import com.baidu.swan.bdtls.impl.model.Bdtls$Extension;
import com.baidu.swan.bdtls.impl.model.Bdtls$Random;
import com.baidu.swan.bdtls.impl.model.Bdtls$ServerHello;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.protobuf.ByteString;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static d a(g gVar, byte[] bArr) {
        InterceptResult invokeLL;
        byte[] decrypt;
        byte[] dHSecretKey;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65536, null, gVar, bArr)) != null) {
            return (d) invokeLL.objValue;
        }
        d dVar = null;
        if (gVar == null || bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            if (bArr[0] != 2) {
                return null;
            }
            d dVar2 = new d();
            try {
                Bdtls$ServerHello parseFrom = Bdtls$ServerHello.parseFrom(Arrays.copyOfRange(bArr, 1, bArr.length));
                if (parseFrom == null) {
                    return null;
                }
                dVar2.a(parseFrom);
                List<Bdtls$Extension> extensionsList = parseFrom.getExtensionsList();
                if (extensionsList == null) {
                    return null;
                }
                for (Bdtls$Extension bdtls$Extension : extensionsList) {
                    int type = bdtls$Extension.getType();
                    byte[] byteArray = bdtls$Extension.getData().toByteArray();
                    if (type == 0) {
                        int a2 = e.a(RSA.decrypt(byteArray));
                        gVar.l(DH.getDHSecretKey(a2, gVar.d().intValue(), gVar.f().intValue()));
                        gVar.p(Integer.valueOf(a2));
                        if (b.a.p0.c.a.a.f9542a) {
                            String str = "GroupId=" + gVar.d();
                            String str2 = "client dh pubkey secret=" + gVar.f();
                            String str3 = "client dh pubkey=" + gVar.e();
                            String str4 = "server dh pubkey=" + a2;
                            String str5 = "server dh raw pubkey=" + e.d(decrypt);
                            String str6 = "aeskey=" + e.d(dHSecretKey);
                        }
                    }
                }
                if (parseFrom.getSKR() == null) {
                    return null;
                }
                Bdtls$ApplicationData.b newBuilder = Bdtls$ApplicationData.newBuilder();
                newBuilder.v(parseFrom.getSKR());
                gVar.t(newBuilder.build().toByteArray());
                if (gVar.c() == null) {
                    return null;
                }
                long currentTimeMillis = (System.currentTimeMillis() / 1000) + parseFrom.getLifeTime();
                if (b.a.p0.c.a.a.f9542a) {
                    String str7 = "liftTime=" + parseFrom.getLifeTime();
                    String str8 = "expireTime=" + currentTimeMillis;
                }
                gVar.r(currentTimeMillis);
                if (parseFrom.getCipherSuite() != null) {
                    gVar.q(parseFrom.getCipherSuite().toByteArray());
                    return dVar2;
                }
                return dVar2;
            } catch (Exception e2) {
                e = e2;
                dVar = dVar2;
                if (b.a.p0.c.a.a.f9542a) {
                    e.printStackTrace();
                    String str9 = "exception=" + e.getMessage();
                }
                return dVar;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static byte[] b(g gVar, d dVar) {
        InterceptResult invokeLL;
        byte[] encrypt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, gVar, dVar)) == null) {
            if (dVar == null) {
                return null;
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            byte[] bArr = new byte[32];
            new Random().nextBytes(bArr);
            Bdtls$Random.b newBuilder = Bdtls$Random.newBuilder();
            newBuilder.w(currentTimeMillis);
            newBuilder.x(ByteString.copyFrom(bArr));
            Bdtls$Random build = newBuilder.build();
            int dHGroupId = DH.getDHGroupId();
            int dHSecret = DH.getDHSecret();
            int dHPublicKey = DH.getDHPublicKey(dHGroupId, dHSecret);
            gVar.m(Integer.valueOf(dHGroupId));
            gVar.o(Integer.valueOf(dHSecret));
            gVar.n(Integer.valueOf(dHPublicKey));
            byte[] g2 = e.g(dHPublicKey);
            if (g2 == null || (encrypt = RSA.encrypt(g2)) == null) {
                return null;
            }
            byte[] bytes = f.a(Certificate.getSignature(b.a.p0.a.c1.a.b()), "", false).getBytes(StandardCharsets.UTF_8);
            LinkedList linkedList = new LinkedList();
            Bdtls$Extension.b newBuilder2 = Bdtls$Extension.newBuilder();
            newBuilder2.w(0);
            newBuilder2.v(ByteString.copyFrom(encrypt));
            linkedList.offer(newBuilder2.build());
            Bdtls$Extension.b newBuilder3 = Bdtls$Extension.newBuilder();
            newBuilder3.w(1);
            newBuilder3.v(ByteString.copyFrom(new byte[]{0}));
            linkedList.offer(newBuilder3.build());
            Bdtls$Extension.b newBuilder4 = Bdtls$Extension.newBuilder();
            newBuilder4.w(2);
            newBuilder4.v(ByteString.copyFrom(e.g(dHGroupId)));
            linkedList.offer(newBuilder4.build());
            Bdtls$Extension.b newBuilder5 = Bdtls$Extension.newBuilder();
            newBuilder5.w(3);
            newBuilder5.v(ByteString.copyFrom(bytes));
            linkedList.offer(newBuilder5.build());
            if (b.a.p0.c.a.a.f9542a) {
                String str = "groupId encode=" + dHGroupId;
                String str2 = "secretC encode=" + dHSecret;
                String str3 = "pubKey encode=" + dHPublicKey;
                String str4 = "signature encode=" + new String(bytes);
            }
            Bdtls$ClientHello.b newBuilder6 = Bdtls$ClientHello.newBuilder();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                newBuilder6.n((Bdtls$Extension) it.next());
            }
            newBuilder6.C(build);
            newBuilder6.m(ByteString.copyFrom(b.a.p0.c.a.b.f9545c));
            byte[] byteArray = newBuilder6.build().toByteArray();
            ByteBuffer allocate = ByteBuffer.allocate(byteArray.length + 1);
            allocate.put((byte) 1);
            allocate.put(byteArray);
            return allocate.array();
        }
        return (byte[]) invokeLL.objValue;
    }
}
