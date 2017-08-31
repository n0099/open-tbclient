package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.framework.client.socket.h;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.f;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class b {
    private static b py = null;

    public static b dj() {
        if (py == null) {
            synchronized (b.class) {
                if (py == null) {
                    py = new b();
                }
            }
        }
        return py;
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
                ByteBuffer allocate = ByteBuffer.allocate(encodeInBackGround.length + encodeExtraDataInBackGround.length + a.pj);
                if (encodeExtraDataInBackGround.length > Integer.MAX_VALUE) {
                    throw new CoderException(h.oA);
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
                encodeInBackGround = t.a(d.dk().getSecretKey(), encodeInBackGround);
            }
            return a.a(z2, z, socketMessage.getCmd(), i, encodeInBackGround, z3);
        } catch (Throwable th) {
            throw new CoderException(h.oG);
        }
    }

    public c a(c cVar) throws CoderException {
        if (cVar == null || cVar.pz == null || cVar.pA == null) {
            throw new CoderException(h.ou);
        }
        a aVar = cVar.pz;
        if (aVar.df() && cVar.pC > 0) {
            if (d.dk().getSecretKey() == null) {
                throw new CoderException(h.oD);
            }
            try {
                cVar.pA = t.a(d.dk().getSecretKey(), cVar.pA, cVar.pB, cVar.pC);
                cVar.pB = 0;
                cVar.pC = cVar.pA.length;
            } catch (Exception e) {
                throw new CoderException(h.oF);
            }
        }
        if (aVar.dd() && cVar.pC > 0) {
            try {
                cVar.pA = e(cVar.pA, cVar.pB, cVar.pC);
                cVar.pB = 0;
                cVar.pC = cVar.pA.length;
            } catch (Exception e2) {
                throw new CoderException(h.oC);
            }
        }
        return cVar;
    }

    public c e(byte[] bArr) throws CoderException {
        int dc = a.dc();
        if (bArr == null || bArr.length < dc) {
            throw new CoderException(h.ou);
        }
        a d = a.d(bArr);
        if (d == null) {
            throw new CoderException(h.ou);
        }
        c cVar = new c();
        cVar.pz = d;
        cVar.pA = bArr;
        cVar.pB = dc;
        cVar.pC = bArr.length - dc;
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
                    newInstance.onDecodeFailedInBackGround(i, bArr, h.ox);
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
            throw new CoderException(h.ox);
        }
    }

    protected byte[] e(byte[] bArr, int i, int i2) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f.c(byteArrayInputStream, byteArrayOutputStream);
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
            f.d(byteArrayInputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
            com.baidu.adp.lib.g.a.d(byteArrayInputStream);
        }
    }
}
