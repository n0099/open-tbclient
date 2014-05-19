package com.baidu.tbadk.a;

import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.lib.network.websocket.CoderException;
import com.baidu.adp.lib.network.websocket.i;
import com.baidu.adp.lib.network.websocket.k;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
/* loaded from: classes.dex */
public class d extends k {
    @Override // com.baidu.adp.lib.network.websocket.k
    public byte[] a(SocketMessage socketMessage, boolean z) {
        try {
            SocketMessage socketMessage2 = socketMessage instanceof SocketMessage ? socketMessage : null;
            byte[] encodeInBackGround = socketMessage.encodeInBackGround();
            if (encodeInBackGround != null && z) {
                encodeInBackGround = a(encodeInBackGround, 0, encodeInBackGround.length);
            }
            boolean b = com.baidu.tbadk.message.websockt.c.b().b(socketMessage.getCmd());
            if (encodeInBackGround != null && b) {
                encodeInBackGround = com.baidu.tbadk.c.d.a(com.baidu.tbadk.message.websockt.c.b().d(), encodeInBackGround);
            }
            socketMessage2.setSquencedId(a.a().b());
            return com.baidu.tbadk.message.websockt.a.a(b, z, socketMessage2.getCmd(), socketMessage2.getSquencedId(), encodeInBackGround);
        } catch (Exception e) {
            throw new CoderException(i.k);
        }
    }

    protected byte[] a(byte[] bArr, int i, int i2) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            com.baidu.tbadk.c.a.a(byteArrayInputStream, byteArrayOutputStream);
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
