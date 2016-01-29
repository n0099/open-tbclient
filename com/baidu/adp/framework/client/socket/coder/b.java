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
    private static b pT = null;

    public static b eO() {
        if (pT == null) {
            synchronized (b.class) {
                if (pT == null) {
                    pT = new b();
                }
            }
        }
        return pT;
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
                encodeInBackGround = v.a(d.eP().getSecretKey(), encodeInBackGround);
            }
            return a.a(z2, z, socketMessage.getCmd(), i, encodeInBackGround);
        } catch (Throwable th) {
            throw new CoderException(j.pj);
        }
    }

    public c a(c cVar) {
        if (cVar == null || cVar.pU == null || cVar.pV == null) {
            throw new CoderException(j.oX);
        }
        a aVar = cVar.pU;
        if (aVar.eM() && cVar.pX > 0) {
            if (d.eP().getSecretKey() == null) {
                throw new CoderException(j.pg);
            }
            try {
                cVar.pV = v.a(d.eP().getSecretKey(), cVar.pV, cVar.pW, cVar.pX);
                cVar.pW = 0;
                cVar.pX = cVar.pV.length;
            } catch (Exception e) {
                throw new CoderException(j.pi);
            }
        }
        if (aVar.eK() && cVar.pX > 0) {
            try {
                cVar.pV = b(cVar.pV, cVar.pW, cVar.pX);
                cVar.pW = 0;
                cVar.pX = cVar.pV.length;
            } catch (Exception e2) {
                throw new CoderException(j.pf);
            }
        }
        return cVar;
    }

    public c u(byte[] bArr) {
        int eJ = a.eJ();
        if (bArr == null || bArr.length < eJ) {
            throw new CoderException(j.oX);
        }
        a t = a.t(bArr);
        if (t == null) {
            throw new CoderException(j.oX);
        }
        c cVar = new c();
        cVar.pU = t;
        cVar.pV = bArr;
        cVar.pW = eJ;
        cVar.pX = bArr.length - eJ;
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
            com.baidu.adp.lib.stats.a.ht().b("im", j, (String) null, IntentConfig.CMD, Integer.valueOf(i), "byteslength", Integer.valueOf(bArr != null ? bArr.length : 0), "comment", th != null ? th.getMessage() : null);
            throw new CoderException(j.pa);
        }
    }

    protected byte[] b(byte[] bArr, int i, int i2) {
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

    protected byte[] c(byte[] bArr, int i, int i2) {
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
