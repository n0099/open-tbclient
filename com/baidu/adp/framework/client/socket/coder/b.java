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
    private static b pX = null;

    public static b eP() {
        if (pX == null) {
            synchronized (b.class) {
                if (pX == null) {
                    pX = new b();
                }
            }
        }
        return pX;
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
                encodeInBackGround = v.a(d.eQ().getSecretKey(), encodeInBackGround);
            }
            return a.a(z2, z, socketMessage.getCmd(), i, encodeInBackGround);
        } catch (Throwable th) {
            throw new CoderException(j.po);
        }
    }

    public c a(c cVar) {
        if (cVar == null || cVar.pY == null || cVar.pZ == null) {
            throw new CoderException(j.oZ);
        }
        a aVar = cVar.pY;
        if (aVar.eM() && cVar.qb > 0) {
            if (d.eQ().getSecretKey() == null) {
                throw new CoderException(j.pi);
            }
            try {
                cVar.pZ = v.a(d.eQ().getSecretKey(), cVar.pZ, cVar.qa, cVar.qb);
                cVar.qa = 0;
                cVar.qb = cVar.pZ.length;
            } catch (Exception e) {
                throw new CoderException(j.pl);
            }
        }
        if (aVar.eK() && cVar.qb > 0) {
            try {
                cVar.pZ = b(cVar.pZ, cVar.qa, cVar.qb);
                cVar.qa = 0;
                cVar.qb = cVar.pZ.length;
            } catch (Exception e2) {
                throw new CoderException(j.ph);
            }
        }
        return cVar;
    }

    public c e(byte[] bArr) {
        int eJ = a.eJ();
        if (bArr == null || bArr.length < eJ) {
            throw new CoderException(j.oZ);
        }
        a d = a.d(bArr);
        if (d == null) {
            throw new CoderException(j.oZ);
        }
        c cVar = new c();
        cVar.pY = d;
        cVar.pZ = bArr;
        cVar.qa = eJ;
        cVar.qb = bArr.length - eJ;
        return cVar;
    }

    public SocketResponsedMessage a(int i, byte[] bArr, SocketMessage socketMessage, SocketMessageTask socketMessageTask, boolean z) {
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
                    newInstance.onDecodeFailedInBackGround(i, bArr, j.pe);
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
            com.baidu.adp.lib.stats.a.hz().b("im", j, (String) null, IntentConfig.CMD, Integer.valueOf(i), "byteslength", Integer.valueOf(i2), "comment", str);
            throw new CoderException(j.pe);
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
            com.baidu.adp.lib.h.a.b(byteArrayOutputStream);
            com.baidu.adp.lib.h.a.c(byteArrayInputStream);
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
            com.baidu.adp.lib.h.a.b(byteArrayOutputStream);
            com.baidu.adp.lib.h.a.c(byteArrayInputStream);
        }
    }
}
