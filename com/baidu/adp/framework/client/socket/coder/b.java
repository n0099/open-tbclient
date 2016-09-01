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
    private static b iF = null;

    public static b ca() {
        if (iF == null) {
            synchronized (b.class) {
                if (iF == null) {
                    iF = new b();
                }
            }
        }
        return iF;
    }

    private b() {
    }

    public byte[] a(SocketMessage socketMessage, int i, boolean z, boolean z2) throws CoderException {
        if (socketMessage == null) {
            return null;
        }
        try {
            byte[] encodeInBackGround = socketMessage.encodeInBackGround();
            if (encodeInBackGround != null && z) {
                encodeInBackGround = d(encodeInBackGround, 0, encodeInBackGround.length);
            }
            if (encodeInBackGround != null && z2) {
                encodeInBackGround = v.a(d.cb().getSecretKey(), encodeInBackGround);
            }
            return a.a(z2, z, socketMessage.getCmd(), i, encodeInBackGround);
        } catch (Throwable th) {
            throw new CoderException(j.hQ);
        }
    }

    public c a(c cVar) throws CoderException {
        if (cVar == null || cVar.iG == null || cVar.iH == null) {
            throw new CoderException(j.hG);
        }
        a aVar = cVar.iG;
        if (aVar.bX() && cVar.iJ > 0) {
            if (d.cb().getSecretKey() == null) {
                throw new CoderException(j.hN);
            }
            try {
                cVar.iH = v.a(d.cb().getSecretKey(), cVar.iH, cVar.iI, cVar.iJ);
                cVar.iI = 0;
                cVar.iJ = cVar.iH.length;
            } catch (Exception e) {
                throw new CoderException(j.hP);
            }
        }
        if (aVar.bV() && cVar.iJ > 0) {
            try {
                cVar.iH = c(cVar.iH, cVar.iI, cVar.iJ);
                cVar.iI = 0;
                cVar.iJ = cVar.iH.length;
            } catch (Exception e2) {
                throw new CoderException(j.hM);
            }
        }
        return cVar;
    }

    public c i(byte[] bArr) throws CoderException {
        int bU = a.bU();
        if (bArr == null || bArr.length < bU) {
            throw new CoderException(j.hG);
        }
        a h = a.h(bArr);
        if (h == null) {
            throw new CoderException(j.hG);
        }
        c cVar = new c();
        cVar.iG = h;
        cVar.iH = bArr;
        cVar.iI = bU;
        cVar.iJ = bArr.length - bU;
        return cVar;
    }

    public SocketResponsedMessage a(int i, byte[] bArr, SocketMessage socketMessage, SocketMessageTask socketMessageTask, boolean z) throws CoderException {
        int i2;
        String str;
        SocketResponsedMessage newInstance;
        try {
            Class<? extends SocketResponsedMessage> responsedClass = socketMessageTask.getResponsedClass();
            try {
                newInstance = responsedClass.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e) {
                newInstance = responsedClass.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(i));
            }
            newInstance.setOrginalMessage(socketMessage);
            if (z) {
                try {
                    newInstance.onDecodeFailedInBackGround(i, bArr, j.hJ);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                newInstance.decodeInBackGround(i, bArr);
            }
            return newInstance;
        } catch (Throwable th) {
            long j = 0;
            if (socketMessage != null) {
                j = socketMessage.getClientLogID();
            }
            if (bArr == null) {
                i2 = 0;
            } else {
                i2 = bArr.length;
            }
            if (th == null) {
                str = null;
            } else {
                str = th.getMessage();
            }
            com.baidu.adp.lib.stats.a.eI().b("im", j, (String) null, IntentConfig.CMD, Integer.valueOf(i), "byteslength", Integer.valueOf(i2), "comment", str);
            throw new CoderException(j.hJ);
        }
    }

    protected byte[] c(byte[] bArr, int i, int i2) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f.c(byteArrayInputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            com.baidu.adp.lib.h.a.d(byteArrayOutputStream);
            com.baidu.adp.lib.h.a.j(byteArrayInputStream);
        }
    }

    protected byte[] d(byte[] bArr, int i, int i2) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f.d(byteArrayInputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            com.baidu.adp.lib.h.a.d(byteArrayOutputStream);
            com.baidu.adp.lib.h.a.j(byteArrayInputStream);
        }
    }
}
