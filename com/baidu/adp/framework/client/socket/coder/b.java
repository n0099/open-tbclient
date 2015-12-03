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
import java.io.OutputStream;
/* loaded from: classes.dex */
public class b {
    private static b pQ = null;

    public static b eK() {
        if (pQ == null) {
            synchronized (b.class) {
                if (pQ == null) {
                    pQ = new b();
                }
            }
        }
        return pQ;
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
            throw new CoderException(j.pg);
        }
    }

    public c a(c cVar) {
        if (cVar == null || cVar.pR == null || cVar.pS == null) {
            throw new CoderException(j.oU);
        }
        a aVar = cVar.pR;
        if (aVar.eI() && cVar.pU > 0) {
            if (d.eL().getSecretKey() == null) {
                throw new CoderException(j.pd);
            }
            try {
                cVar.pS = v.a(d.eL().getSecretKey(), cVar.pS, cVar.pT, cVar.pU);
                cVar.pT = 0;
                cVar.pU = cVar.pS.length;
            } catch (Exception e) {
                throw new CoderException(j.pf);
            }
        }
        if (aVar.eG() && cVar.pU > 0) {
            try {
                cVar.pS = c(cVar.pS, cVar.pT, cVar.pU);
                cVar.pT = 0;
                cVar.pU = cVar.pS.length;
            } catch (Exception e2) {
                throw new CoderException(j.pa);
            }
        }
        return cVar;
    }

    public c u(byte[] bArr) {
        int eF = a.eF();
        if (bArr == null || bArr.length < eF) {
            throw new CoderException(j.oU);
        }
        a t = a.t(bArr);
        if (t == null) {
            throw new CoderException(j.oU);
        }
        c cVar = new c();
        cVar.pR = t;
        cVar.pS = bArr;
        cVar.pT = eF;
        cVar.pU = bArr.length - eF;
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
            com.baidu.adp.lib.stats.a.hl().b("im", j, (String) null, IntentConfig.CMD, Integer.valueOf(i), "byteslength", Integer.valueOf(bArr != null ? bArr.length : 0), "comment", th != null ? th.getMessage() : null);
            throw new CoderException(j.oX);
        }
    }

    protected byte[] c(byte[] bArr, int i, int i2) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f.c(byteArrayInputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            com.baidu.adp.lib.h.a.b((OutputStream) byteArrayOutputStream);
            com.baidu.adp.lib.h.a.e(byteArrayInputStream);
        }
    }

    protected byte[] d(byte[] bArr, int i, int i2) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f.d(byteArrayInputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            com.baidu.adp.lib.h.a.b((OutputStream) byteArrayOutputStream);
            com.baidu.adp.lib.h.a.e(byteArrayInputStream);
        }
    }
}
