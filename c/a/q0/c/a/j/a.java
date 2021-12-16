package c.a.q0.c.a.j;

import c.a.q0.c.a.i.d;
import c.a.q0.c.a.i.e;
import c.a.q0.c.a.i.h;
import c.a.q0.d.c;
import c.a.q0.w.f;
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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static e a(h hVar, byte[] bArr) {
        InterceptResult invokeLL;
        byte[] decrypt;
        byte[] dHSecretKey;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65536, null, hVar, bArr)) != null) {
            return (e) invokeLL.objValue;
        }
        e eVar = null;
        if (hVar == null || bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            if (bArr[0] != 2) {
                return null;
            }
            e eVar2 = new e();
            try {
                Bdtls$ServerHello parseFrom = Bdtls$ServerHello.parseFrom(Arrays.copyOfRange(bArr, 1, bArr.length));
                if (parseFrom == null) {
                    return null;
                }
                eVar2.a(parseFrom);
                List<Bdtls$Extension> extensionsList = parseFrom.getExtensionsList();
                if (extensionsList == null) {
                    return null;
                }
                for (Bdtls$Extension bdtls$Extension : extensionsList) {
                    int type = bdtls$Extension.getType();
                    byte[] byteArray = bdtls$Extension.getData().toByteArray();
                    if (type == 0) {
                        int a = c.a.q0.c.a.e.a(RSA.decrypt(byteArray));
                        hVar.l(DH.getDHSecretKey(a, hVar.d().intValue(), hVar.f().intValue()));
                        hVar.p(Integer.valueOf(a));
                        if (c.a.q0.c.a.a.a) {
                            String str = "GroupId=" + hVar.d();
                            String str2 = "client dh pubkey secret=" + hVar.f();
                            String str3 = "client dh pubkey=" + hVar.e();
                            String str4 = "server dh pubkey=" + a;
                            String str5 = "server dh raw pubkey=" + c.a.q0.c.a.e.d(decrypt);
                            String str6 = "aeskey=" + c.a.q0.c.a.e.d(dHSecretKey);
                        }
                    }
                }
                if (parseFrom.getSKR() == null) {
                    return null;
                }
                Bdtls$ApplicationData.b newBuilder = Bdtls$ApplicationData.newBuilder();
                newBuilder.v(parseFrom.getSKR());
                Bdtls$ApplicationData build = newBuilder.build();
                hVar.t(build.toByteArray());
                if (hVar.c() == null) {
                    return null;
                }
                long currentTimeMillis = (System.currentTimeMillis() / 1000) + parseFrom.getLifeTime();
                if (c.a.q0.c.a.a.a) {
                    String str7 = "liftTime=" + parseFrom.getLifeTime();
                    String str8 = "expireTime=" + currentTimeMillis;
                }
                hVar.r(currentTimeMillis);
                if (parseFrom.getCipherSuite() != null) {
                    hVar.q(parseFrom.getCipherSuite().toByteArray());
                }
                if (c.a.q0.a.u1.l.b.c()) {
                    new d().edit().putString("secretKey", Arrays.toString(hVar.c())).putString("sessionTicket", String.valueOf(build)).putLong("expireTime", currentTimeMillis).apply();
                    return eVar2;
                }
                return eVar2;
            } catch (Exception e2) {
                e = e2;
                eVar = eVar2;
                if (c.a.q0.c.a.a.a) {
                    e.printStackTrace();
                    String str9 = "exception=" + e.getMessage();
                }
                return eVar;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static byte[] b(h hVar, e eVar) {
        InterceptResult invokeLL;
        byte[] encrypt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, hVar, eVar)) == null) {
            if (eVar == null) {
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
            hVar.m(Integer.valueOf(dHGroupId));
            hVar.o(Integer.valueOf(dHSecret));
            hVar.n(Integer.valueOf(dHPublicKey));
            byte[] g2 = c.a.q0.c.a.e.g(dHPublicKey);
            if (g2 == null || (encrypt = RSA.encrypt(g2)) == null) {
                return null;
            }
            byte[] bytes = f.a(Certificate.getSignature(c.a.q0.a.c1.a.c()), "", false).getBytes(StandardCharsets.UTF_8);
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
            newBuilder4.v(ByteString.copyFrom(c.a.q0.c.a.e.g(dHGroupId)));
            linkedList.offer(newBuilder4.build());
            Bdtls$Extension.b newBuilder5 = Bdtls$Extension.newBuilder();
            newBuilder5.w(3);
            newBuilder5.v(ByteString.copyFrom(bytes));
            linkedList.offer(newBuilder5.build());
            if (c.a.q0.a.u1.l.b.c()) {
                if (c.getContext() != null) {
                    Bdtls$Extension.b newBuilder6 = Bdtls$Extension.newBuilder();
                    newBuilder6.w(4);
                    newBuilder6.v(ByteString.copyFrom(c.getContext().b().getBytes()));
                    linkedList.offer(newBuilder6.build());
                }
                if (c.getContext() != null) {
                    Bdtls$Extension.b newBuilder7 = Bdtls$Extension.newBuilder();
                    newBuilder7.w(5);
                    newBuilder7.v(ByteString.copyFrom(c.a.q0.w.a.f().getBytes()));
                    linkedList.offer(newBuilder7.build());
                }
            }
            if (c.a.q0.c.a.a.a) {
                String str = "groupId encode=" + dHGroupId;
                String str2 = "secretC encode=" + dHSecret;
                String str3 = "pubKey encode=" + dHPublicKey;
                String str4 = "signature encode=" + new String(bytes);
            }
            Bdtls$ClientHello.b newBuilder8 = Bdtls$ClientHello.newBuilder();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                newBuilder8.n((Bdtls$Extension) it.next());
            }
            newBuilder8.C(build);
            newBuilder8.m(ByteString.copyFrom(c.a.q0.c.a.b.f9719c));
            byte[] byteArray = newBuilder8.build().toByteArray();
            ByteBuffer allocate = ByteBuffer.allocate(byteArray.length + 1);
            allocate.put((byte) 1);
            allocate.put(byteArray);
            return allocate.array();
        }
        return (byte[]) invokeLL.objValue;
    }
}
