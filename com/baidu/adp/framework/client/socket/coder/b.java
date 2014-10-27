package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.framework.client.socket.l;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.f;
import com.baidu.adp.lib.util.w;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class b {
    private static b cj = null;

    public static b aK() {
        if (cj == null) {
            synchronized (b.class) {
                if (cj == null) {
                    cj = new b();
                }
            }
        }
        return cj;
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
                encodeInBackGround = b(encodeInBackGround, 0, encodeInBackGround.length);
            }
            if (encodeInBackGround != null && z2) {
                encodeInBackGround = w.a(d.aL().getSecretKey(), encodeInBackGround);
            }
            return a.a(z2, z, socketMessage.getCmd(), i, encodeInBackGround);
        } catch (Throwable th) {
            throw new CoderException(l.bD);
        }
    }

    public c a(c cVar) {
        if (cVar == null || cVar.ck == null || cVar.cl == null) {
            throw new CoderException(l.bt);
        }
        a aVar = cVar.ck;
        if (aVar.aI() && cVar.cn > 0) {
            if (d.aL().getSecretKey() == null) {
                throw new CoderException(l.bA);
            }
            try {
                cVar.cl = w.a(d.aL().getSecretKey(), cVar.cl, cVar.cm, cVar.cn);
                cVar.cm = 0;
                cVar.cn = cVar.cl.length;
            } catch (Exception e) {
                throw new CoderException(l.bC);
            }
        }
        if (aVar.aG() && cVar.cn > 0) {
            try {
                cVar.cl = a(cVar.cl, cVar.cm, cVar.cn);
                cVar.cm = 0;
                cVar.cn = cVar.cl.length;
            } catch (Exception e2) {
                throw new CoderException(l.bz);
            }
        }
        return cVar;
    }

    public c f(byte[] bArr) {
        int aF = a.aF();
        if (bArr == null || bArr.length < aF) {
            throw new CoderException(l.bt);
        }
        a e = a.e(bArr);
        if (e == null) {
            throw new CoderException(l.bt);
        }
        c cVar = new c();
        cVar.ck = e;
        cVar.cl = bArr;
        cVar.cm = aF;
        cVar.cn = bArr.length - aF;
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
            CoderException coderException = new CoderException(l.bw);
        }
    }

    protected byte[] a(byte[] bArr, int i, int i2) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f.a(byteArrayInputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            com.baidu.adp.lib.g.a.a((OutputStream) byteArrayOutputStream);
            com.baidu.adp.lib.g.a.a((InputStream) byteArrayInputStream);
        }
    }

    protected byte[] b(byte[] bArr, int i, int i2) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f.b(byteArrayInputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            com.baidu.adp.lib.g.a.a((OutputStream) byteArrayOutputStream);
            com.baidu.adp.lib.g.a.a((InputStream) byteArrayInputStream);
        }
    }
}
