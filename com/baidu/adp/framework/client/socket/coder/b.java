package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.framework.client.socket.j;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.f;
import com.baidu.adp.lib.util.v;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
/* loaded from: classes.dex */
public class b {
    private static b qx = null;

    public static b dj() {
        if (qx == null) {
            synchronized (b.class) {
                if (qx == null) {
                    qx = new b();
                }
            }
        }
        return qx;
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
                encodeInBackGround = v.a(d.dk().getSecretKey(), encodeInBackGround);
            }
            return a.a(z2, z, socketMessage.getCmd(), i, encodeInBackGround);
        } catch (Throwable th) {
            throw new CoderException(j.pO);
        }
    }

    public c a(c cVar) throws CoderException {
        if (cVar == null || cVar.qy == null || cVar.qz == null) {
            throw new CoderException(j.pE);
        }
        a aVar = cVar.qy;
        if (aVar.dg() && cVar.qB > 0) {
            if (d.dk().getSecretKey() == null) {
                throw new CoderException(j.pL);
            }
            try {
                cVar.qz = v.a(d.dk().getSecretKey(), cVar.qz, cVar.qA, cVar.qB);
                cVar.qA = 0;
                cVar.qB = cVar.qz.length;
            } catch (Exception e) {
                throw new CoderException(j.pN);
            }
        }
        if (aVar.de() && cVar.qB > 0) {
            try {
                cVar.qz = c(cVar.qz, cVar.qA, cVar.qB);
                cVar.qA = 0;
                cVar.qB = cVar.qz.length;
            } catch (Exception e2) {
                throw new CoderException(j.pK);
            }
        }
        return cVar;
    }

    public c i(byte[] bArr) throws CoderException {
        int dd = a.dd();
        if (bArr == null || bArr.length < dd) {
            throw new CoderException(j.pE);
        }
        a h = a.h(bArr);
        if (h == null) {
            throw new CoderException(j.pE);
        }
        c cVar = new c();
        cVar.qy = h;
        cVar.qz = bArr;
        cVar.qA = dd;
        cVar.qB = bArr.length - dd;
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
                    newInstance.onDecodeFailedInBackGround(i, bArr, j.pH);
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
            BdStatisticsManager.getInstance().error("im", j, (String) null, IntentConfig.CMD, Integer.valueOf(i), "byteslength", Integer.valueOf(i2), "comment", str);
            throw new CoderException(j.pH);
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
            com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
            com.baidu.adp.lib.g.a.j(byteArrayInputStream);
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
            com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
            com.baidu.adp.lib.g.a.j(byteArrayInputStream);
        }
    }
}
