package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.framework.client.socket.l;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.ad;
import com.baidu.adp.lib.util.g;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
/* loaded from: classes.dex */
public class b {
    private static b pK = null;

    public static b eH() {
        if (pK == null) {
            synchronized (b.class) {
                if (pK == null) {
                    pK = new b();
                }
            }
        }
        return pK;
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
                encodeInBackGround = ad.a(d.eI().getSecretKey(), encodeInBackGround);
            }
            return a.a(z2, z, socketMessage.getCmd(), i, encodeInBackGround);
        } catch (Throwable th) {
            throw new CoderException(l.oY);
        }
    }

    public c a(c cVar) {
        if (cVar == null || cVar.pL == null || cVar.pM == null) {
            throw new CoderException(l.oO);
        }
        a aVar = cVar.pL;
        if (aVar.eF() && cVar.pO > 0) {
            if (d.eI().getSecretKey() == null) {
                throw new CoderException(l.oV);
            }
            try {
                cVar.pM = ad.a(d.eI().getSecretKey(), cVar.pM, cVar.pN, cVar.pO);
                cVar.pN = 0;
                cVar.pO = cVar.pM.length;
            } catch (Exception e) {
                throw new CoderException(l.oX);
            }
        }
        if (aVar.eD() && cVar.pO > 0) {
            try {
                cVar.pM = b(cVar.pM, cVar.pN, cVar.pO);
                cVar.pN = 0;
                cVar.pO = cVar.pM.length;
            } catch (Exception e2) {
                throw new CoderException(l.oU);
            }
        }
        return cVar;
    }

    public c h(byte[] bArr) {
        int eC = a.eC();
        if (bArr == null || bArr.length < eC) {
            throw new CoderException(l.oO);
        }
        a f = a.f(bArr);
        if (f == null) {
            throw new CoderException(l.oO);
        }
        c cVar = new c();
        cVar.pL = f;
        cVar.pM = bArr;
        cVar.pN = eC;
        cVar.pO = bArr.length - eC;
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
            throw new CoderException(l.oR);
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
