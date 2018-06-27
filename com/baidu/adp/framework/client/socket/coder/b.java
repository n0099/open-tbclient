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
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes.dex */
public class b {
    private static b uJ = null;

    public static b fG() {
        if (uJ == null) {
            synchronized (b.class) {
                if (uJ == null) {
                    uJ = new b();
                }
            }
        }
        return uJ;
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
                ByteBuffer allocate = ByteBuffer.allocate(encodeInBackGround.length + encodeExtraDataInBackGround.length + a.uy);
                if (encodeExtraDataInBackGround.length > Integer.MAX_VALUE) {
                    throw new CoderException(h.tO);
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
                encodeInBackGround = u.a(d.fH().getSecretKey(), encodeInBackGround);
            }
            return a.a(z2, z, socketMessage.getCmd(), i, encodeInBackGround, z3);
        } catch (Throwable th) {
            throw new CoderException(h.tU);
        }
    }

    public c a(c cVar) throws CoderException {
        if (cVar == null || cVar.uK == null || cVar.uL == null) {
            throw new CoderException(h.tI);
        }
        a aVar = cVar.uK;
        if (aVar.fC() && cVar.uN > 0) {
            if (d.fH().getSecretKey() == null) {
                throw new CoderException(h.tR);
            }
            try {
                cVar.uL = u.a(d.fH().getSecretKey(), cVar.uL, cVar.uM, cVar.uN);
                cVar.uM = 0;
                cVar.uN = cVar.uL.length;
            } catch (Exception e) {
                throw new CoderException(h.tT);
            }
        }
        if (aVar.fA() && cVar.uN > 0) {
            try {
                cVar.uL = e(cVar.uL, cVar.uM, cVar.uN);
                cVar.uM = 0;
                cVar.uN = cVar.uL.length;
            } catch (Exception e2) {
                throw new CoderException(h.tQ);
            }
        }
        return cVar;
    }

    public c i(byte[] bArr) throws CoderException {
        int fz = a.fz();
        if (bArr == null || bArr.length < fz) {
            throw new CoderException(h.tI);
        }
        a h = a.h(bArr);
        if (h == null) {
            throw new CoderException(h.tI);
        }
        c cVar = new c();
        cVar.uK = h;
        cVar.uL = bArr;
        cVar.uM = fz;
        cVar.uN = bArr.length - fz;
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
                    newInstance.onDecodeFailedInBackGround(i, bArr, h.tL);
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
            BdStatisticsManager.getInstance().error("im", j, (String) null, IntentConfig.CMD, Integer.valueOf(i), "byteslength", Integer.valueOf(i2), ClientCookie.COMMENT_ATTR, str);
            throw new CoderException(h.tL);
        }
    }

    protected byte[] e(byte[] bArr, int i, int i2) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            g.d(byteArrayInputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
            com.baidu.adp.lib.g.a.f(byteArrayInputStream);
        }
    }

    protected byte[] f(byte[] bArr, int i, int i2) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            g.e(byteArrayInputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
            com.baidu.adp.lib.g.a.f(byteArrayInputStream);
        }
    }
}
