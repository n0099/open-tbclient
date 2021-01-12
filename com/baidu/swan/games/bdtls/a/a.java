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
/* loaded from: classes8.dex */
public class a {
    public static byte[] a(j jVar, g gVar) {
        byte[] encrypt;
        if (gVar == null) {
            return null;
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        byte[] bArr = new byte[32];
        new Random().nextBytes(bArr);
        Bdtls.Random build = Bdtls.Random.newBuilder().kU(currentTimeMillis).i(ByteString.copyFrom(bArr)).build();
        int aPK = DH.aPK();
        int aPJ = DH.aPJ();
        int at = DH.at(aPK, aPJ);
        jVar.i(Integer.valueOf(aPK));
        jVar.j(Integer.valueOf(aPJ));
        jVar.k(Integer.valueOf(at));
        byte[] kR = d.kR(at);
        if (kR == null || (encrypt = RSA.encrypt(kR)) == null) {
            return null;
        }
        byte[] bytes = e.toHexString(Certificate.et(com.baidu.swan.apps.t.a.awy()), "", false).getBytes(StandardCharsets.UTF_8);
        LinkedList linkedList = new LinkedList();
        linkedList.offer(Bdtls.Extension.newBuilder().kT(0).h(ByteString.copyFrom(encrypt)).build());
        linkedList.offer(Bdtls.Extension.newBuilder().kT(1).h(ByteString.copyFrom(new byte[]{0})).build());
        linkedList.offer(Bdtls.Extension.newBuilder().kT(2).h(ByteString.copyFrom(d.kR(aPK))).build());
        linkedList.offer(Bdtls.Extension.newBuilder().kT(3).h(ByteString.copyFrom(bytes)).build());
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "groupId encode=" + aPK);
            Log.d("BDTLS", "secretC encode=" + aPJ);
            Log.d("BDTLS", "pubKey encode=" + at);
            Log.d("BDTLS", "signature encode=" + new String(bytes));
        }
        Bdtls.ClientHello.a newBuilder = Bdtls.ClientHello.newBuilder();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            newBuilder.a((Bdtls.Extension) it.next());
        }
        byte[] byteArray = newBuilder.a(build).f(ByteString.copyFrom(com.baidu.swan.games.bdtls.b.ebf)).build().toByteArray();
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
                            int N = d.N(RSA.decrypt(byteArray));
                            jVar.S(DH.w(N, jVar.aVd().intValue(), jVar.aVe().intValue()));
                            jVar.l(Integer.valueOf(N));
                            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                                Log.d("BDTLS", "GroupId=" + jVar.aVd());
                                Log.d("BDTLS", "client dh pubkey secret=" + jVar.aVe());
                                Log.d("BDTLS", "client dh pubkey=" + jVar.aVf());
                                Log.d("BDTLS", "server dh pubkey=" + N);
                                Log.d("BDTLS", "server dh raw pubkey=" + d.O(decrypt));
                                Log.d("BDTLS", "aeskey=" + d.O(w));
                                break;
                            } else {
                                break;
                            }
                    }
                }
                if (parseFrom.getSKR() == null) {
                    return null;
                }
                jVar.T(Bdtls.ApplicationData.newBuilder().e(parseFrom.getSKR()).build().toByteArray());
                if (jVar.aVh() == null) {
                    return null;
                }
                long currentTimeMillis = (System.currentTimeMillis() / 1000) + parseFrom.getLifeTime();
                if (com.baidu.swan.games.bdtls.a.DEBUG) {
                    Log.d("BDTLS", "liftTime=" + parseFrom.getLifeTime());
                    Log.d("BDTLS", "expireTime=" + currentTimeMillis);
                }
                jVar.C(currentTimeMillis);
                if (parseFrom.getCipherSuite() != null) {
                    jVar.U(parseFrom.getCipherSuite().toByteArray());
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
