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
    private static b fL = null;

    public static b bf() {
        if (fL == null) {
            synchronized (b.class) {
                if (fL == null) {
                    fL = new b();
                }
            }
        }
        return fL;
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
                encodeInBackGround = v.a(d.bg().getSecretKey(), encodeInBackGround);
            }
            return a.a(z2, z, socketMessage.getCmd(), i, encodeInBackGround);
        } catch (Throwable th) {
            throw new CoderException(j.fc);
        }
    }

    public c a(c cVar) {
        if (cVar == null || cVar.fM == null || cVar.fN == null) {
            throw new CoderException(j.eS);
        }
        a aVar = cVar.fM;
        if (aVar.bc() && cVar.fP > 0) {
            if (d.bg().getSecretKey() == null) {
                throw new CoderException(j.eZ);
            }
            try {
                cVar.fN = v.a(d.bg().getSecretKey(), cVar.fN, cVar.fO, cVar.fP);
                cVar.fO = 0;
                cVar.fP = cVar.fN.length;
            } catch (Exception e) {
                throw new CoderException(j.fb);
            }
        }
        if (aVar.ba() && cVar.fP > 0) {
            try {
                cVar.fN = b(cVar.fN, cVar.fO, cVar.fP);
                cVar.fO = 0;
                cVar.fP = cVar.fN.length;
            } catch (Exception e2) {
                throw new CoderException(j.eY);
            }
        }
        return cVar;
    }

    public c e(byte[] bArr) {
        int aZ = a.aZ();
        if (bArr == null || bArr.length < aZ) {
            throw new CoderException(j.eS);
        }
        a d = a.d(bArr);
        if (d == null) {
            throw new CoderException(j.eS);
        }
        c cVar = new c();
        cVar.fM = d;
        cVar.fN = bArr;
        cVar.fO = aZ;
        cVar.fP = bArr.length - aZ;
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
                    newInstance.onDecodeFailedInBackGround(i, bArr, j.eV);
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
            com.baidu.adp.lib.stats.a.dN().b("im", j, (String) null, IntentConfig.CMD, Integer.valueOf(i), "byteslength", Integer.valueOf(i2), "comment", str);
            throw new CoderException(j.eV);
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
            com.baidu.adp.lib.h.a.a((OutputStream) byteArrayOutputStream);
            com.baidu.adp.lib.h.a.c(byteArrayInputStream);
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
            com.baidu.adp.lib.h.a.a((OutputStream) byteArrayOutputStream);
            com.baidu.adp.lib.h.a.c(byteArrayInputStream);
        }
    }
}
