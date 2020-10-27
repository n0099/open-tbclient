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
/* loaded from: classes10.dex */
public class a {
    public static byte[] a(j jVar, g gVar) {
        byte[] encrypt;
        if (gVar == null) {
            return null;
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        byte[] bArr = new byte[32];
        new Random().nextBytes(bArr);
        Bdtls.Random build = Bdtls.Random.newBuilder().lO(currentTimeMillis).h(ByteString.copyFrom(bArr)).build();
        int aMl = DH.aMl();
        int aMk = DH.aMk();
        int au = DH.au(aMl, aMk);
        jVar.g(Integer.valueOf(aMl));
        jVar.h(Integer.valueOf(aMk));
        jVar.i(Integer.valueOf(au));
        byte[] lL = d.lL(au);
        if (lL == null || (encrypt = RSA.encrypt(lL)) == null) {
            return null;
        }
        byte[] bytes = e.toHexString(Certificate.dv(com.baidu.swan.apps.t.a.aua()), "", false).getBytes(StandardCharsets.UTF_8);
        LinkedList linkedList = new LinkedList();
        linkedList.offer(Bdtls.Extension.newBuilder().lN(0).g(ByteString.copyFrom(encrypt)).build());
        linkedList.offer(Bdtls.Extension.newBuilder().lN(1).g(ByteString.copyFrom(new byte[]{0})).build());
        linkedList.offer(Bdtls.Extension.newBuilder().lN(2).g(ByteString.copyFrom(d.lL(aMl))).build());
        linkedList.offer(Bdtls.Extension.newBuilder().lN(3).g(ByteString.copyFrom(bytes)).build());
        if (com.baidu.swan.games.bdtls.a.DEBUG) {
            Log.d("BDTLS", "groupId encode=" + aMl);
            Log.d("BDTLS", "secretC encode=" + aMk);
            Log.d("BDTLS", "pubKey encode=" + au);
            Log.d("BDTLS", "signature encode=" + new String(bytes));
        }
        Bdtls.ClientHello.a newBuilder = Bdtls.ClientHello.newBuilder();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            newBuilder.a((Bdtls.Extension) it.next());
        }
        byte[] byteArray = newBuilder.a(build).e(ByteString.copyFrom(com.baidu.swan.games.bdtls.b.dLM)).build().toByteArray();
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
                            int P = d.P(RSA.decrypt(byteArray));
                            jVar.U(DH.v(P, jVar.aRF().intValue(), jVar.aRG().intValue()));
                            jVar.j(Integer.valueOf(P));
                            if (com.baidu.swan.games.bdtls.a.DEBUG) {
                                Log.d("BDTLS", "GroupId=" + jVar.aRF());
                                Log.d("BDTLS", "client dh pubkey secret=" + jVar.aRG());
                                Log.d("BDTLS", "client dh pubkey=" + jVar.aRH());
                                Log.d("BDTLS", "server dh pubkey=" + P);
                                Log.d("BDTLS", "server dh raw pubkey=" + d.Q(decrypt));
                                Log.d("BDTLS", "aeskey=" + d.Q(v));
                                break;
                            } else {
                                break;
                            }
                    }
                }
                if (parseFrom.getSKR() == null) {
                    return null;
                }
                jVar.V(Bdtls.ApplicationData.newBuilder().d(parseFrom.getSKR()).build().toByteArray());
                if (jVar.aRJ() == null) {
                    return null;
                }
                long currentTimeMillis = (System.currentTimeMillis() / 1000) + parseFrom.getLifeTime();
                if (com.baidu.swan.games.bdtls.a.DEBUG) {
                    Log.d("BDTLS", "liftTime=" + parseFrom.getLifeTime());
                    Log.d("BDTLS", "expireTime=" + currentTimeMillis);
                }
                jVar.E(currentTimeMillis);
                if (parseFrom.getCipherSuite() != null) {
                    jVar.W(parseFrom.getCipherSuite().toByteArray());
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
