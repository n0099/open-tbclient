package com.baidu.tbadk.a;

import com.baidu.adp.framework.message.g;
import com.baidu.adp.lib.network.websocket.CoderException;
import com.baidu.adp.lib.network.websocket.i;
import com.baidu.adp.lib.network.websocket.k;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
/* loaded from: classes.dex */
public final class c extends k {
    @Override // com.baidu.adp.lib.network.websocket.k
    public final byte[] a(g gVar, boolean z) {
        com.baidu.tbadk.message.websockt.d dVar;
        try {
            if (!(gVar instanceof com.baidu.tbadk.message.websockt.d)) {
                dVar = null;
            } else {
                dVar = (com.baidu.tbadk.message.websockt.d) gVar;
            }
            byte[] b = gVar.b();
            if (b != null && z) {
                b = a(b, 0, b.length);
            }
            boolean b2 = com.baidu.tbadk.message.websockt.c.a().b(gVar.e());
            if (b != null && b2) {
                b = com.baidu.tbadk.d.c.a(com.baidu.tbadk.message.websockt.c.a().c(), b);
            }
            dVar.g(a.a().b());
            return com.baidu.tbadk.message.websockt.a.a(b2, z, dVar.e(), dVar.k(), b);
        } catch (Exception e) {
            throw new CoderException(i.k);
        }
    }

    private static byte[] a(byte[] bArr, int i, int i2) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, 0, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            com.baidu.tbadk.d.a.a(byteArrayInputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (Exception e) {
            }
            try {
                byteArrayInputStream.close();
            } catch (Exception e2) {
            }
        }
    }
}
