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
    private static b er = null;

    public static b bk() {
        if (er == null) {
            synchronized (b.class) {
                if (er == null) {
                    er = new b();
                }
            }
        }
        return er;
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
            throw new CoderException(l.dK);
        }
    }

    public c a(c cVar) {
        if (cVar == null || cVar.es == null || cVar.eu == null) {
            throw new CoderException(l.dA);
        }
        a aVar = cVar.es;
        if (aVar.bi() && cVar.ew > 0) {
            if (d.bl().getSecretKey() == null) {
                throw new CoderException(l.dH);
            }
            try {
                cVar.eu = ab.a(d.bl().getSecretKey(), cVar.eu, cVar.ev, cVar.ew);
                cVar.ev = 0;
                cVar.ew = cVar.eu.length;
            } catch (Exception e) {
                throw new CoderException(l.dJ);
            }
        }
        if (aVar.bg() && cVar.ew > 0) {
            try {
                cVar.eu = b(cVar.eu, cVar.ev, cVar.ew);
                cVar.ev = 0;
                cVar.ew = cVar.eu.length;
            } catch (Exception e2) {
                throw new CoderException(l.dG);
            }
        }
        return cVar;
    }

    public c g(byte[] bArr) {
        int bf = a.bf();
        if (bArr == null || bArr.length < bf) {
            throw new CoderException(l.dA);
        }
        a f = a.f(bArr);
        if (f == null) {
            throw new CoderException(l.dA);
        }
        c cVar = new c();
        cVar.es = f;
        cVar.eu = bArr;
        cVar.ev = bf;
        cVar.ew = bArr.length - bf;
        return cVar;
    }

    public SocketResponsedMessage a(int i, byte[] bArr, SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        SocketResponsedMessage newInstance;
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
        } catch (Throwable th) {
            throw new CoderException(l.dD);
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
