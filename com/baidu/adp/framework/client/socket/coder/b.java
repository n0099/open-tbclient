package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.l;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.e;
import com.baidu.adp.lib.util.r;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class b {
    private static b a = null;

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    private b() {
    }

    public byte[] a(SocketMessage socketMessage, int i, boolean z) {
        if (socketMessage == null) {
            return null;
        }
        try {
            byte[] encodeInBackGround = socketMessage.encodeInBackGround();
            if (encodeInBackGround != null && z) {
                encodeInBackGround = b(encodeInBackGround, 0, encodeInBackGround.length);
            }
            boolean b = d.a().b(socketMessage.getCmd());
            if (encodeInBackGround != null && b) {
                encodeInBackGround = r.a(d.a().c(), encodeInBackGround);
            }
            return a.a(b, z, socketMessage.getCmd(), i, encodeInBackGround);
        } catch (Exception e) {
            throw new CoderException(l.k);
        }
    }

    public c a(c cVar) {
        if (cVar == null || cVar.a == null || cVar.b == null) {
            throw new CoderException(l.a);
        }
        a aVar = cVar.a;
        if (aVar.d() && cVar.d > 0) {
            if (d.a().c() == null) {
                throw new CoderException(l.h);
            }
            try {
                cVar.b = r.a(d.a().c(), cVar.b, cVar.c, cVar.d);
                cVar.c = 0;
                cVar.d = cVar.b.length;
            } catch (Exception e) {
                throw new CoderException(l.j);
            }
        }
        if (aVar.b() && cVar.d > 0) {
            try {
                cVar.b = a(cVar.b, cVar.c, cVar.d);
                cVar.c = 0;
                cVar.d = cVar.b.length;
            } catch (Exception e2) {
                throw new CoderException(l.g);
            }
        }
        return cVar;
    }

    public c a(byte[] bArr) {
        int a2 = a.a();
        if (bArr == null || bArr.length < a2) {
            throw new CoderException(l.a);
        }
        a a3 = a.a(bArr);
        if (a3 == null) {
            throw new CoderException(l.a);
        }
        c cVar = new c();
        cVar.a = a3;
        cVar.b = bArr;
        cVar.c = a2;
        cVar.d = bArr.length - a2;
        return cVar;
    }

    public SocketResponsedMessage a(int i, byte[] bArr, SocketMessage socketMessage) {
        try {
            SocketResponsedMessage newInstance = ((SocketMessageTask) MessageManager.getInstance().findTask(i)).c().newInstance();
            newInstance.setOrginalMessage(socketMessage);
            newInstance.decodeInBackGround(i, bArr);
            return newInstance;
        } catch (Exception e) {
            throw new CoderException(l.d);
        }
    }

    protected byte[] a(byte[] bArr, int i, int i2) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            e.a(byteArrayInputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            com.baidu.adp.lib.f.a.a((OutputStream) byteArrayOutputStream);
            com.baidu.adp.lib.f.a.a((InputStream) byteArrayInputStream);
        }
    }

    protected byte[] b(byte[] bArr, int i, int i2) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            e.b(byteArrayInputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            com.baidu.adp.lib.f.a.a((OutputStream) byteArrayOutputStream);
            com.baidu.adp.lib.f.a.a((InputStream) byteArrayInputStream);
        }
    }
}
