package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.framework.client.socket.h;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.g;
import com.baidu.adp.lib.util.u;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class b {
    private static b pA = null;

    public static b dj() {
        if (pA == null) {
            synchronized (b.class) {
                if (pA == null) {
                    pA = new b();
                }
            }
        }
        return pA;
    }

    private b() {
    }

    public byte[] a(SocketMessage socketMessage, int i, boolean z, boolean z2) throws CoderException {
        boolean z3 = false;
        if (socketMessage == null) {
            return null;
        }
        try {
            byte[] encodeInBackGround = socketMessage.encodeInBackGround();
            byte[] encodeExtraDataInBackGround = socketMessage.encodeExtraDataInBackGround();
            if (encodeExtraDataInBackGround != null) {
                ByteBuffer allocate = ByteBuffer.allocate(encodeInBackGround.length + encodeExtraDataInBackGround.length + a.po);
                if (encodeExtraDataInBackGround.length > Integer.MAX_VALUE) {
                    throw new CoderException(h.oC);
                }
                allocate.putInt(encodeExtraDataInBackGround.length);
                allocate.put(encodeExtraDataInBackGround);
                allocate.put(encodeInBackGround);
                encodeInBackGround = allocate.array();
                z3 = true;
            }
            if (encodeInBackGround != null && z) {
                encodeInBackGround = f(encodeInBackGround, 0, encodeInBackGround.length);
            }
            if (encodeInBackGround != null && z2) {
                encodeInBackGround = u.a(d.dk().getSecretKey(), encodeInBackGround);
            }
            return a.a(z2, z, socketMessage.getCmd(), i, encodeInBackGround, z3);
        } catch (Throwable th) {
            throw new CoderException(h.oI);
        }
    }

    public c a(c cVar) throws CoderException {
        if (cVar == null || cVar.pB == null || cVar.pC == null) {
            throw new CoderException(h.ow);
        }
        a aVar = cVar.pB;
        if (aVar.df() && cVar.pE > 0) {
            if (d.dk().getSecretKey() == null) {
                throw new CoderException(h.oF);
            }
            try {
                cVar.pC = u.a(d.dk().getSecretKey(), cVar.pC, cVar.pD, cVar.pE);
                cVar.pD = 0;
                cVar.pE = cVar.pC.length;
            } catch (Exception e) {
                throw new CoderException(h.oH);
            }
        }
        if (aVar.dd() && cVar.pE > 0) {
            try {
                cVar.pC = e(cVar.pC, cVar.pD, cVar.pE);
                cVar.pD = 0;
                cVar.pE = cVar.pC.length;
            } catch (Exception e2) {
                throw new CoderException(h.oE);
            }
        }
        return cVar;
    }

    public c e(byte[] bArr) throws CoderException {
        int dc = a.dc();
        if (bArr == null || bArr.length < dc) {
            throw new CoderException(h.ow);
        }
        a d = a.d(bArr);
        if (d == null) {
            throw new CoderException(h.ow);
        }
        c cVar = new c();
        cVar.pB = d;
        cVar.pC = bArr;
        cVar.pD = dc;
        cVar.pE = bArr.length - dc;
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
                    newInstance.onDecodeFailedInBackGround(i, bArr, h.oz);
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
            throw new CoderException(h.oz);
        }
    }

    protected byte[] e(byte[] bArr, int i, int i2) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            g.c(byteArrayInputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
            com.baidu.adp.lib.g.a.d(byteArrayInputStream);
        }
    }

    protected byte[] f(byte[] bArr, int i, int i2) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            g.d(byteArrayInputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
            com.baidu.adp.lib.g.a.d(byteArrayInputStream);
        }
    }
}
