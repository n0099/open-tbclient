package com.baidu.tbadk.a;

import com.baidu.adp.lib.network.websocket.CoderException;
import com.baidu.adp.lib.network.websocket.i;
import com.baidu.adp.lib.network.websocket.l;
import com.baidu.adp.lib.network.websocket.m;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public final class d extends l {
    @Override // com.baidu.adp.lib.network.websocket.l
    public final m b(byte[] bArr) {
        com.baidu.tbadk.message.websockt.a a;
        com.baidu.tbadk.message.websockt.a.a();
        if (bArr == null || bArr.length < 9 || (a = com.baidu.tbadk.message.websockt.a.a(bArr)) == null) {
            return null;
        }
        return new e(this, a);
    }

    @Override // com.baidu.adp.lib.network.websocket.l
    public final byte[] a(byte[] bArr) {
        com.baidu.tbadk.message.websockt.a.a();
        if (bArr == null || bArr.length < 9) {
            throw new CoderException(i.a);
        }
        com.baidu.tbadk.message.websockt.a a = com.baidu.tbadk.message.websockt.a.a(bArr);
        if (a == null) {
            throw new CoderException(i.a);
        }
        com.baidu.tbadk.message.websockt.b bVar = new com.baidu.tbadk.message.websockt.b();
        bVar.a = a;
        bVar.b = bArr;
        bVar.c = 9;
        bVar.d = bArr.length - 9;
        if (bVar.a == null || bVar.b == null) {
            throw new CoderException(i.a);
        }
        if (a.d() && a.c() != 1003) {
            if (com.baidu.tbadk.message.websockt.c.a().c() == null) {
                throw new CoderException(i.h);
            }
            try {
                if (bVar.d > 0) {
                    bVar.b = com.baidu.tbadk.d.c.a(com.baidu.tbadk.message.websockt.c.a().c(), bVar.b, bVar.c, bVar.d);
                    bVar.c = 0;
                    bVar.d = bVar.b.length;
                }
            } catch (Exception e) {
                throw new CoderException(i.j);
            }
        }
        if (a.b() && a.c() != 1003) {
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

    private static byte[] a(byte[] bArr, int i, int i2) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            com.baidu.tbadk.d.a.b(byteArrayInputStream, byteArrayOutputStream);
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
