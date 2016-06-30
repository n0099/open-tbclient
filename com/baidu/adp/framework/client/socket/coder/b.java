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
    private static b fK = null;

    public static b bg() {
        if (fK == null) {
            synchronized (b.class) {
                if (fK == null) {
                    fK = new b();
                }
            }
        }
        return fK;
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
                encodeInBackGround = v.a(d.bh().getSecretKey(), encodeInBackGround);
            }
            return a.a(z2, z, socketMessage.getCmd(), i, encodeInBackGround);
        } catch (Throwable th) {
            throw new CoderException(j.fb);
        }
    }

    public c a(c cVar) {
        if (cVar == null || cVar.fL == null || cVar.fM == null) {
            throw new CoderException(j.eR);
        }
        a aVar = cVar.fL;
        if (aVar.bd() && cVar.fO > 0) {
            if (d.bh().getSecretKey() == null) {
                throw new CoderException(j.eY);
            }
            try {
                cVar.fM = v.a(d.bh().getSecretKey(), cVar.fM, cVar.fN, cVar.fO);
                cVar.fN = 0;
                cVar.fO = cVar.fM.length;
            } catch (Exception e) {
                throw new CoderException(j.fa);
            }
        }
        if (aVar.bb() && cVar.fO > 0) {
            try {
                cVar.fM = b(cVar.fM, cVar.fN, cVar.fO);
                cVar.fN = 0;
                cVar.fO = cVar.fM.length;
            } catch (Exception e2) {
                throw new CoderException(j.eX);
            }
        }
        return cVar;
    }

    public c e(byte[] bArr) {
        int ba = a.ba();
        if (bArr == null || bArr.length < ba) {
            throw new CoderException(j.eR);
        }
        a d = a.d(bArr);
        if (d == null) {
            throw new CoderException(j.eR);
        }
        c cVar = new c();
        cVar.fL = d;
        cVar.fM = bArr;
        cVar.fN = ba;
        cVar.fO = bArr.length - ba;
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
                    newInstance.onDecodeFailedInBackGround(i, bArr, j.eU);
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
            com.baidu.adp.lib.stats.a.dO().b("im", j, (String) null, IntentConfig.CMD, Integer.valueOf(i), "byteslength", Integer.valueOf(i2), "comment", str);
            throw new CoderException(j.eU);
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
            com.baidu.adp.lib.h.a.b((OutputStream) byteArrayOutputStream);
            com.baidu.adp.lib.h.a.c(byteArrayInputStream);
        }
    }
}
