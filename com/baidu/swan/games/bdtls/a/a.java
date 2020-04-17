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
/* loaded from: classes11.dex */
public class a {
    public static byte[] a(j jVar, g gVar) {
        byte[] encrypt;
        if (gVar == null) {
            return null;
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        byte[] bArr = new byte[32];
        new Random().nextBytes(bArr);
        Bdtls.Random build = Bdtls.Random.newBuilder().hR(currentTimeMillis).g(ByteString.copyFrom(bArr)).build();
        int arf = DH.arf();
        int are = DH.are();
        int am = DH.am(arf, are);
        jVar.c(Integer.valueOf(arf));
        jVar.d(Integer.valueOf(are));
        jVar.e(Integer.valueOf(am));
        byte[] hN = d.hN(am);
        if (hN == null || (encrypt = RSA.encrypt(hN)) == null) {
            return null;
        }
        Bdtls.Extension[] extensionArr = {Bdtls.Extension.newBuilder().hQ(0).f(ByteString.copyFrom(encrypt)).build(), Bdtls.Extension.newBuilder().hQ(1).f(ByteString.copyFrom(new byte[]{0})).build(), Bdtls.Extension.newBuilder().hQ(2).f(ByteString.copyFrom(d.hN(arf))).build()};
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "groupId encode=" + arf);
            Log.d("BDTLS", "secretC encode=" + are);
            Log.d("BDTLS", "pubKey encode=" + am);
        }
        byte[] byteArray = Bdtls.ClientHello.newBuilder().a(build).a(extensionArr[0]).a(extensionArr[1]).a(extensionArr[2]).d(ByteString.copyFrom(com.baidu.swan.games.bdtls.b.cJP)).build().toByteArray();
        ByteBuffer allocate = ByteBuffer.allocate(byteArray.length + 1);
        allocate.put((byte) 1);
        allocate.put(byteArray);
        return allocate.array();
    }

    public static g b(j jVar, byte[] bArr) {
        Exception exc;
        g gVar;
        byte[] decrypt;
        byte[] v;
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
                            int F = d.F(RSA.decrypt(byteArray));
                            jVar.K(DH.v(F, jVar.avd().intValue(), jVar.ave().intValue()));
                            jVar.f(Integer.valueOf(F));
                            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                                Log.d("BDTLS", "GroupId=" + jVar.avd());
                                Log.d("BDTLS", "client dh pubkey secret=" + jVar.ave());
                                Log.d("BDTLS", "client dh pubkey=" + jVar.avf());
                                Log.d("BDTLS", "server dh pubkey=" + F);
                                Log.d("BDTLS", "server dh raw pubkey=" + d.G(decrypt));
                                Log.d("BDTLS", "aeskey=" + d.G(v));
                                break;
                            } else {
                                break;
                            }
                    }
                }
                if (parseFrom.getSKR() == null) {
                    return null;
                }
                jVar.L(Bdtls.ApplicationData.newBuilder().c(parseFrom.getSKR()).build().toByteArray());
                if (jVar.avh() == null) {
                    return null;
                }
                long currentTimeMillis = (System.currentTimeMillis() / 1000) + parseFrom.getLifeTime();
                if (com.baidu.swan.games.bdtls.a.DEBUG) {
                    Log.d("BDTLS", "liftTime=" + parseFrom.getLifeTime());
                    Log.d("BDTLS", "expireTime=" + currentTimeMillis);
                }
                jVar.E(currentTimeMillis);
                if (parseFrom.getCipherSuite() != null) {
                    jVar.M(parseFrom.getCipherSuite().toByteArray());
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
