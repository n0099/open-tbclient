package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.framework.client.socket.l;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.ae;
import com.baidu.adp.lib.util.g;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
/* loaded from: classes.dex */
public class b {
    private static b pP = null;

    public static b eK() {
        if (pP == null) {
            synchronized (b.class) {
                if (pP == null) {
                    pP = new b();
                }
            }
        }
        return pP;
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
                encodeInBackGround = ae.a(d.eL().getSecretKey(), encodeInBackGround);
            }
            return a.a(z2, z, socketMessage.getCmd(), i, encodeInBackGround);
        } catch (Throwable th) {
            throw new CoderException(l.pf);
        }
    }

    public c a(c cVar) {
        if (cVar == null || cVar.pQ == null || cVar.pR == null) {
            throw new CoderException(l.oT);
        }
        a aVar = cVar.pQ;
        if (aVar.eI() && cVar.pT > 0) {
            if (d.eL().getSecretKey() == null) {
                throw new CoderException(l.pa);
            }
            try {
                cVar.pR = ae.a(d.eL().getSecretKey(), cVar.pR, cVar.pS, cVar.pT);
                cVar.pS = 0;
                cVar.pT = cVar.pR.length;
            } catch (Exception e) {
                throw new CoderException(l.pe);
            }
        }
        if (aVar.eG() && cVar.pT > 0) {
            try {
                cVar.pR = b(cVar.pR, cVar.pS, cVar.pT);
                cVar.pS = 0;
                cVar.pT = cVar.pR.length;
            } catch (Exception e2) {
                throw new CoderException(l.oZ);
            }
        }
        return cVar;
    }

    public c h(byte[] bArr) {
        int eF = a.eF();
        if (bArr == null || bArr.length < eF) {
            throw new CoderException(l.oT);
        }
        a f = a.f(bArr);
        if (f == null) {
            throw new CoderException(l.oT);
        }
        c cVar = new c();
        cVar.pQ = f;
        cVar.pR = bArr;
        cVar.pS = eF;
        cVar.pT = bArr.length - eF;
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
            throw new CoderException(l.oW);
        }
    }

    protected byte[] b(byte[] bArr, int i, int i2) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            g.b(byteArrayInputStream, byteArrayOutputStream);
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
            g.c(byteArrayInputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
            com.baidu.adp.lib.g.a.d(byteArrayInputStream);
        }
    }
}
