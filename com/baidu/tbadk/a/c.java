package com.baidu.tbadk.a;

import com.baidu.adp.lib.network.websocket.k;
import com.baidu.adp.lib.network.websocket.l;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public final class c extends k {
    @Override // com.baidu.adp.lib.network.websocket.k
    public final l b(byte[] bArr) {
        com.baidu.tbadk.message.websockt.a a;
        com.baidu.tbadk.message.websockt.a.a();
        if (bArr == null || bArr.length < 9 || (a = com.baidu.tbadk.message.websockt.a.a(bArr)) == null) {
            return null;
        }
        return new d(this, a);
    }

    @Override // com.baidu.adp.lib.network.websocket.k
    public final byte[] a(byte[] bArr) {
        com.baidu.tbadk.message.websockt.a.a();
        com.baidu.tbadk.message.websockt.a a = com.baidu.tbadk.message.websockt.a.a(bArr);
        com.baidu.tbadk.message.websockt.b bVar = new com.baidu.tbadk.message.websockt.b();
        bVar.a = a;
        bVar.b = bArr;
        bVar.c = 9;
        bVar.d = bArr.length - 9;
        if (bVar.a == null || bVar.b == null) {
            return null;
        }
        if (a.d()) {
            com.baidu.tbadk.message.websockt.c.a().c();
            try {
                bVar.b = com.baidu.tbadk.d.c.a(com.baidu.tbadk.message.websockt.c.a().c(), bVar.b, bVar.c, bVar.d);
                bVar.c = 0;
                bVar.d = bVar.b.length;
            } catch (Exception e) {
            }
        }
        if (a.b()) {
            try {
                bVar.b = a(bVar.b, bVar.c, bVar.d);
                bVar.c = 0;
                bVar.d = bVar.b.length;
            } catch (Exception e2) {
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
