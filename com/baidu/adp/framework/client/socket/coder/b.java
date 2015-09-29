package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.framework.client.socket.j;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.f;
import com.baidu.adp.lib.util.v;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
                encodeInBackGround = d(encodeInBackGround, 0, encodeInBackGround.length);
            }
            if (encodeInBackGround != null && z2) {
                encodeInBackGround = v.a(d.eL().getSecretKey(), encodeInBackGround);
            }
            return a.a(z2, z, socketMessage.getCmd(), i, encodeInBackGround);
        } catch (Throwable th) {
            throw new CoderException(j.pf);
        }
    }

    public c a(c cVar) {
        if (cVar == null || cVar.pQ == null || cVar.pR == null) {
            throw new CoderException(j.oT);
        }
        a aVar = cVar.pQ;
        if (aVar.eI() && cVar.pT > 0) {
            if (d.eL().getSecretKey() == null) {
                throw new CoderException(j.pa);
            }
            try {
                cVar.pR = v.a(d.eL().getSecretKey(), cVar.pR, cVar.pS, cVar.pT);
                cVar.pS = 0;
                cVar.pT = cVar.pR.length;
            } catch (Exception e) {
                throw new CoderException(j.pe);
            }
        }
        if (aVar.eG() && cVar.pT > 0) {
            try {
                cVar.pR = c(cVar.pR, cVar.pS, cVar.pT);
                cVar.pS = 0;
                cVar.pT = cVar.pR.length;
            } catch (Exception e2) {
                throw new CoderException(j.oZ);
            }
        }
        return cVar;
    }

    public c u(byte[] bArr) {
        int eF = a.eF();
        if (bArr == null || bArr.length < eF) {
            throw new CoderException(j.oT);
        }
        a t = a.t(bArr);
        if (t == null) {
            throw new CoderException(j.oT);
        }
        c cVar = new c();
        cVar.pQ = t;
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
            long j = 0;
            if (socketMessage != null) {
                j = socketMessage.getClientLogID();
            }
            com.baidu.adp.lib.stats.a.hi().b("im", j, (String) null, IntentConfig.CMD, Integer.valueOf(i), "byteslength", Integer.valueOf(bArr != null ? bArr.length : 0), "comment", th != null ? th.getMessage() : null);
            throw new CoderException(j.oW);
        }
    }

    protected byte[] c(byte[] bArr, int i, int i2) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f.b(byteArrayInputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
            com.baidu.adp.lib.g.a.d(byteArrayInputStream);
        }
    }

    protected byte[] d(byte[] bArr, int i, int i2) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f.c(byteArrayInputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
            com.baidu.adp.lib.g.a.d(byteArrayInputStream);
        }
    }
}
