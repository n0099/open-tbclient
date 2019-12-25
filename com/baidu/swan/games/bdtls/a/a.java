package com.baidu.swan.games.bdtls.a;

import android.util.Log;
import com.baidu.swan.bdtls.DH;
import com.baidu.swan.bdtls.RSA;
import com.baidu.swan.games.bdtls.d;
import com.baidu.swan.games.bdtls.model.Bdtls;
import com.baidu.swan.games.bdtls.model.g;
import com.baidu.swan.games.bdtls.model.j;
import com.google.protobuf.ByteString;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
/* loaded from: classes9.dex */
public class a {
    public static byte[] a(j jVar, g gVar) {
        byte[] encrypt;
        if (gVar == null) {
            return null;
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        byte[] bArr = new byte[32];
        new Random().nextBytes(bArr);
        Bdtls.Random build = Bdtls.Random.newBuilder().ht(currentTimeMillis).g(ByteString.copyFrom(bArr)).build();
        int agl = DH.agl();
        int agk = DH.agk();
        int af = DH.af(agl, agk);
        jVar.c(Integer.valueOf(agl));
        jVar.d(Integer.valueOf(agk));
        jVar.e(Integer.valueOf(af));
        byte[] hp = d.hp(af);
        if (hp == null || (encrypt = RSA.encrypt(hp)) == null) {
            return null;
        }
        Bdtls.Extension[] extensionArr = {Bdtls.Extension.newBuilder().hs(0).f(ByteString.copyFrom(encrypt)).build(), Bdtls.Extension.newBuilder().hs(1).f(ByteString.copyFrom(new byte[]{0})).build(), Bdtls.Extension.newBuilder().hs(2).f(ByteString.copyFrom(d.hp(agl))).build()};
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "groupId encode=" + agl);
            Log.d("BDTLS", "secretC encode=" + agk);
            Log.d("BDTLS", "pubKey encode=" + af);
        }
        byte[] byteArray = Bdtls.ClientHello.newBuilder().a(build).a(extensionArr[0]).a(extensionArr[1]).a(extensionArr[2]).d(ByteString.copyFrom(com.baidu.swan.games.bdtls.b.cgo)).build().toByteArray();
        ByteBuffer allocate = ByteBuffer.allocate(byteArray.length + 1);
        allocate.put((byte) 1);
        allocate.put(byteArray);
        return allocate.array();
    }

    public static g b(j jVar, byte[] bArr) {
        Exception exc;
        g gVar;
        byte[] decrypt;
        byte[] s;
        if (jVar == null || bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            if (bArr[0] != 2) {
                return null;
            }
            g gVar2 = new g();
            try {
                Bdtls.ServerHello parseFrom = Bdtls.ServerHello.parseFrom(Arrays.copyOfRange(bArr, 1, bArr.length));
                if (parseFrom == null) {
                    return null;
                }
                gVar2.b(parseFrom);
                List<Bdtls.Extension> extensionsList = parseFrom.getExtensionsList();
                if (extensionsList == null) {
                    return null;
                }
                for (Bdtls.Extension extension : extensionsList) {
                    int type = extension.getType();
                    byte[] byteArray = extension.getData().toByteArray();
                    switch (type) {
                        case 0:
                            int z = d.z(RSA.decrypt(byteArray));
                            jVar.E(DH.s(z, jVar.ake().intValue(), jVar.akf().intValue()));
                            jVar.f(Integer.valueOf(z));
                            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                                Log.d("BDTLS", "GroupId=" + jVar.ake());
                                Log.d("BDTLS", "client dh pubkey secret=" + jVar.akf());
                                Log.d("BDTLS", "client dh pubkey=" + jVar.akg());
                                Log.d("BDTLS", "server dh pubkey=" + z);
                                Log.d("BDTLS", "server dh raw pubkey=" + d.A(decrypt));
                                Log.d("BDTLS", "aeskey=" + d.A(s));
                                break;
                            } else {
                                break;
                            }
                    }
                }
                if (parseFrom.getSKR() == null) {
                    return null;
                }
                jVar.F(Bdtls.ApplicationData.newBuilder().c(parseFrom.getSKR()).build().toByteArray());
                if (jVar.aki() == null) {
                    return null;
                }
                long currentTimeMillis = (System.currentTimeMillis() / 1000) + parseFrom.getLifeTime();
                if (com.baidu.swan.games.bdtls.a.DEBUG) {
                    Log.d("BDTLS", "liftTime=" + parseFrom.getLifeTime());
                    Log.d("BDTLS", "expireTime=" + currentTimeMillis);
                }
                jVar.g(currentTimeMillis);
                if (parseFrom.getCipherSuite() != null) {
                    jVar.G(parseFrom.getCipherSuite().toByteArray());
                }
                return gVar2;
            } catch (Exception e) {
                gVar = gVar2;
                exc = e;
                if (com.baidu.swan.games.bdtls.a.DEBUG) {
                    exc.printStackTrace();
                    Log.d("BDTLS", "exception=" + exc.getMessage());
                    return gVar;
                }
                return gVar;
            }
        } catch (Exception e2) {
            exc = e2;
            gVar = null;
        }
    }
}
