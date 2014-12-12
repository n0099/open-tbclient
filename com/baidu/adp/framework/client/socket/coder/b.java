package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.framework.client.socket.l;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.ab;
import com.baidu.adp.lib.util.e;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
/* loaded from: classes.dex */
public class b {
    private static b ep = null;

    public static b bk() {
        if (ep == null) {
            synchronized (b.class) {
                if (ep == null) {
                    ep = new b();
                }
            }
        }
        return ep;
    }

    private b() {
    }

    public byte[] a(SocketMessage socketMessage, int i, boolean z, boolean z2) {
        if (socketMessage == null) {
            return null;
        }
        try {
            byte[] encodeInBackGround = socketMessage.encodeInBackGround();
            if (encodeInBackGround != null && z) {
                encodeInBackGround = c(encodeInBackGround, 0, encodeInBackGround.length);
            }
            if (encodeInBackGround != null && z2) {
                encodeInBackGround = ab.a(d.bl().getSecretKey(), encodeInBackGround);
            }
            return a.a(z2, z, socketMessage.getCmd(), i, encodeInBackGround);
        } catch (Throwable th) {
            throw new CoderException(l.dJ);
        }
    }

    public c a(c cVar) {
        if (cVar == null || cVar.eq == null || cVar.er == null) {
            throw new CoderException(l.dz);
        }
        a aVar = cVar.eq;
        if (aVar.bi() && cVar.eu > 0) {
            if (d.bl().getSecretKey() == null) {
                throw new CoderException(l.dG);
            }
            try {
                cVar.er = ab.a(d.bl().getSecretKey(), cVar.er, cVar.es, cVar.eu);
                cVar.es = 0;
                cVar.eu = cVar.er.length;
            } catch (Exception e) {
                throw new CoderException(l.dI);
            }
        }
        if (aVar.bg() && cVar.eu > 0) {
            try {
                cVar.er = b(cVar.er, cVar.es, cVar.eu);
                cVar.es = 0;
                cVar.eu = cVar.er.length;
            } catch (Exception e2) {
                throw new CoderException(l.dF);
            }
        }
        return cVar;
    }

    public c g(byte[] bArr) {
        int bf = a.bf();
        if (bArr == null || bArr.length < bf) {
            throw new CoderException(l.dz);
        }
        a f = a.f(bArr);
        if (f == null) {
            throw new CoderException(l.dz);
        }
        c cVar = new c();
        cVar.eq = f;
        cVar.er = bArr;
        cVar.es = bf;
        cVar.eu = bArr.length - bf;
        return cVar;
    }

    public SocketResponsedMessage a(int i, byte[] bArr, SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        SocketResponsedMessage newInstance;
        int i2;
        if (bArr == null) {
            throw new CoderException(i2);
        }
        try {
            Class<? extends SocketResponsedMessage> responsedClass = socketMessageTask.getResponsedClass();
            try {
                newInstance = responsedClass.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e) {
                newInstance = responsedClass.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(i));
            }
            newInstance.setOrginalMessage(socketMessage);
            newInstance.decodeInBackGround(i, bArr);
            return newInstance;
        } finally {
            CoderException coderException = new CoderException(l.dC);
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
            com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
            com.baidu.adp.lib.g.a.d(byteArrayInputStream);
        }
    }

    protected byte[] c(byte[] bArr, int i, int i2) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            e.c(byteArrayInputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
            com.baidu.adp.lib.g.a.d(byteArrayInputStream);
        }
    }
}
