package com.baidu.swan.games.bdtls.a;

import android.util.Log;
import com.baidu.swan.bdtls.Certificate;
import com.baidu.swan.bdtls.DH;
import com.baidu.swan.bdtls.RSA;
import com.baidu.swan.c.e;
import com.baidu.swan.games.bdtls.d;
import com.baidu.swan.games.bdtls.model.Bdtls;
import com.baidu.swan.games.bdtls.model.g;
import com.baidu.swan.games.bdtls.model.j;
import com.google.protobuf.ByteString;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
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
        Bdtls.Random build = Bdtls.Random.newBuilder().kX(currentTimeMillis).i(ByteString.copyFrom(bArr)).build();
        int aQd = DH.aQd();
        int aQc = DH.aQc();
        int aq = DH.aq(aQd, aQc);
        jVar.i(Integer.valueOf(aQd));
        jVar.j(Integer.valueOf(aQc));
        jVar.k(Integer.valueOf(aq));
        byte[] kU = d.kU(aq);
        if (kU == null || (encrypt = RSA.encrypt(kU)) == null) {
            return null;
        }
        byte[] bytes = e.toHexString(Certificate.es(com.baidu.swan.apps.t.a.awW()), "", false).getBytes(StandardCharsets.UTF_8);
        LinkedList linkedList = new LinkedList();
        linkedList.offer(Bdtls.Extension.newBuilder().kW(0).h(ByteString.copyFrom(encrypt)).build());
        linkedList.offer(Bdtls.Extension.newBuilder().kW(1).h(ByteString.copyFrom(new byte[]{0})).build());
        linkedList.offer(Bdtls.Extension.newBuilder().kW(2).h(ByteString.copyFrom(d.kU(aQd))).build());
        linkedList.offer(Bdtls.Extension.newBuilder().kW(3).h(ByteString.copyFrom(bytes)).build());
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "groupId encode=" + aQd);
            Log.d("BDTLS", "secretC encode=" + aQc);
            Log.d("BDTLS", "pubKey encode=" + aq);
            Log.d("BDTLS", "signature encode=" + new String(bytes));
        }
        Bdtls.ClientHello.a newBuilder = Bdtls.ClientHello.newBuilder();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            newBuilder.a((Bdtls.Extension) it.next());
        }
        byte[] byteArray = newBuilder.a(build).f(ByteString.copyFrom(com.baidu.swan.games.bdtls.b.edm)).build().toByteArray();
        ByteBuffer allocate = ByteBuffer.allocate(byteArray.length + 1);
        allocate.put((byte) 1);
        allocate.put(byteArray);
        return allocate.array();
    }

    public static g b(j jVar, byte[] bArr) {
        Exception exc;
        g gVar;
        byte[] decrypt;
        byte[] w;
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
                            int M = d.M(RSA.decrypt(byteArray));
                            jVar.R(DH.w(M, jVar.aVp().intValue(), jVar.aVq().intValue()));
                            jVar.l(Integer.valueOf(M));
                            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                                Log.d("BDTLS", "GroupId=" + jVar.aVp());
                                Log.d("BDTLS", "client dh pubkey secret=" + jVar.aVq());
                                Log.d("BDTLS", "client dh pubkey=" + jVar.aVr());
                                Log.d("BDTLS", "server dh pubkey=" + M);
                                Log.d("BDTLS", "server dh raw pubkey=" + d.N(decrypt));
                                Log.d("BDTLS", "aeskey=" + d.N(w));
                                break;
                            } else {
                                break;
                            }
                    }
                }
                if (parseFrom.getSKR() == null) {
                    return null;
                }
                jVar.S(Bdtls.ApplicationData.newBuilder().e(parseFrom.getSKR()).build().toByteArray());
                if (jVar.aVt() == null) {
                    return null;
                }
                long currentTimeMillis = (System.currentTimeMillis() / 1000) + parseFrom.getLifeTime();
                if (com.baidu.swan.games.bdtls.a.DEBUG) {
                    Log.d("BDTLS", "liftTime=" + parseFrom.getLifeTime());
                    Log.d("BDTLS", "expireTime=" + currentTimeMillis);
                }
                jVar.C(currentTimeMillis);
                if (parseFrom.getCipherSuite() != null) {
                    jVar.T(parseFrom.getCipherSuite().toByteArray());
                }
                return gVar2;
            } catch (Exception e) {
                exc = e;
                gVar = gVar2;
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
