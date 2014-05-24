package com.baidu.tbadk.a;

import com.baidu.adp.lib.network.websocket.CoderException;
import com.baidu.adp.lib.network.websocket.i;
import com.baidu.adp.lib.network.websocket.l;
import com.baidu.adp.lib.network.websocket.m;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class e extends l {
    @Override // com.baidu.adp.lib.network.websocket.l
    public m b(byte[] bArr) {
        com.baidu.tbadk.message.websockt.a a;
        int a2 = com.baidu.tbadk.message.websockt.a.a();
        if (bArr == null || bArr.length < a2 || (a = com.baidu.tbadk.message.websockt.a.a(bArr)) == null) {
            return null;
        }
        return new f(this, a);
    }

    @Override // com.baidu.adp.lib.network.websocket.l
    public byte[] a(byte[] bArr) {
        int a = com.baidu.tbadk.message.websockt.a.a();
        if (bArr == null || bArr.length < a) {
            throw new CoderException(i.a);
        }
        com.baidu.tbadk.message.websockt.a a2 = com.baidu.tbadk.message.websockt.a.a(bArr);
        if (a2 == null) {
            throw new CoderException(i.a);
        }
        com.baidu.tbadk.message.websockt.b bVar = new com.baidu.tbadk.message.websockt.b();
        bVar.a = a2;
        bVar.b = bArr;
        bVar.c = a;
        bVar.d = bArr.length - a;
        if (bVar == null || bVar.a == null || bVar.b == null) {
            throw new CoderException(i.a);
        }
        if (a2.d() && a2.c() != 1003) {
            if (com.baidu.tbadk.message.websockt.c.b().d() == null) {
                throw new CoderException(i.h);
            }
            try {
                if (bVar.d > 0) {
                    bVar.b = com.baidu.tbadk.c.e.a(com.baidu.tbadk.message.websockt.c.b().d(), bVar.b, bVar.c, bVar.d);
                    bVar.c = 0;
                    bVar.d = bVar.b.length;
                }
            } catch (Exception e) {
                throw new CoderException(i.j);
            }
        }
        if (a2.b() && a2.c() != 1003) {
            try {
                if (bVar.b != null && bVar.d > 0) {
                    bVar.b = a(bVar.b, bVar.c, bVar.d);
                    bVar.c = 0;
                    bVar.d = bVar.b.length;
                }
            } catch (Exception e2) {
                throw new CoderException(i.g);
            }
        }
        return ByteBuffer.wrap(bVar.b, bVar.c, bVar.d).array();
    }

    protected byte[] a(byte[] bArr, int i, int i2) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            com.baidu.tbadk.c.b.b(byteArrayInputStream, byteArrayOutputStream);
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
