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
    private static b xK = null;

    public static b he() {
        if (xK == null) {
            synchronized (b.class) {
                if (xK == null) {
                    xK = new b();
                }
            }
        }
        return xK;
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
                ByteBuffer allocate = ByteBuffer.allocate(encodeInBackGround.length + encodeExtraDataInBackGround.length + a.xz);
                if (encodeExtraDataInBackGround.length > Integer.MAX_VALUE) {
                    throw new CoderException(h.wS);
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
                encodeInBackGround = u.a(d.hf().getSecretKey(), encodeInBackGround);
            }
            return a.a(z2, z, socketMessage.getCmd(), i, encodeInBackGround, z3);
        } catch (Throwable th) {
            throw new CoderException(h.wY);
        }
    }

    public c a(c cVar) throws CoderException {
        if (cVar == null || cVar.xL == null || cVar.xM == null) {
            throw new CoderException(h.wM);
        }
        a aVar = cVar.xL;
        if (aVar.ha() && cVar.xO > 0) {
            if (d.hf().getSecretKey() == null) {
                throw new CoderException(h.wV);
            }
            try {
                cVar.xM = u.a(d.hf().getSecretKey(), cVar.xM, cVar.xN, cVar.xO);
                cVar.xN = 0;
                cVar.xO = cVar.xM.length;
            } catch (Exception e) {
                throw new CoderException(h.wX);
            }
        }
        if (aVar.gZ() && cVar.xO > 0) {
            try {
                cVar.xM = e(cVar.xM, cVar.xN, cVar.xO);
                cVar.xN = 0;
                cVar.xO = cVar.xM.length;
            } catch (Exception e2) {
                throw new CoderException(h.wU);
            }
        }
        return cVar;
    }

    public c n(byte[] bArr) throws CoderException {
        int gY = a.gY();
        if (bArr == null || bArr.length < gY) {
            throw new CoderException(h.wM);
        }
        a m = a.m(bArr);
        if (m == null) {
            throw new CoderException(h.wM);
        }
        c cVar = new c();
        cVar.xL = m;
        cVar.xM = bArr;
        cVar.xN = gY;
        cVar.xO = bArr.length - gY;
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
                    newInstance.onDecodeFailedInBackGround(i, bArr, h.wP);
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
            throw new CoderException(h.wP);
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
            com.baidu.adp.lib.g.a.h(byteArrayInputStream);
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
            com.baidu.adp.lib.g.a.h(byteArrayInputStream);
        }
    }
}
