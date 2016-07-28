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
    private static b gm = null;

    public static b bf() {
        if (gm == null) {
            synchronized (b.class) {
                if (gm == null) {
                    gm = new b();
                }
            }
        }
        return gm;
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
                encodeInBackGround = v.a(d.bg().getSecretKey(), encodeInBackGround);
            }
            return a.a(z2, z, socketMessage.getCmd(), i, encodeInBackGround);
        } catch (Throwable th) {
            throw new CoderException(j.fD);
        }
    }

    public c a(c cVar) throws CoderException {
        if (cVar == null || cVar.gn == null || cVar.go == null) {
            throw new CoderException(j.ft);
        }
        a aVar = cVar.gn;
        if (aVar.bc() && cVar.gq > 0) {
            if (d.bg().getSecretKey() == null) {
                throw new CoderException(j.fA);
            }
            try {
                cVar.go = v.a(d.bg().getSecretKey(), cVar.go, cVar.gp, cVar.gq);
                cVar.gp = 0;
                cVar.gq = cVar.go.length;
            } catch (Exception e) {
                throw new CoderException(j.fC);
            }
        }
        if (aVar.ba() && cVar.gq > 0) {
            try {
                cVar.go = c(cVar.go, cVar.gp, cVar.gq);
                cVar.gp = 0;
                cVar.gq = cVar.go.length;
            } catch (Exception e2) {
                throw new CoderException(j.fz);
            }
        }
        return cVar;
    }

    public c i(byte[] bArr) throws CoderException {
        int aZ = a.aZ();
        if (bArr == null || bArr.length < aZ) {
            throw new CoderException(j.ft);
        }
        a h = a.h(bArr);
        if (h == null) {
            throw new CoderException(j.ft);
        }
        c cVar = new c();
        cVar.gn = h;
        cVar.go = bArr;
        cVar.gp = aZ;
        cVar.gq = bArr.length - aZ;
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
                    newInstance.onDecodeFailedInBackGround(i, bArr, j.fw);
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
            throw new CoderException(j.fw);
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
