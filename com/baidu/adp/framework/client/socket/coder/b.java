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
    private static b pW = null;

    public static b di() {
        if (pW == null) {
            synchronized (b.class) {
                if (pW == null) {
                    pW = new b();
                }
            }
        }
        return pW;
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
                encodeInBackGround = v.a(d.dj().getSecretKey(), encodeInBackGround);
            }
            return a.a(z2, z, socketMessage.getCmd(), i, encodeInBackGround);
        } catch (Throwable th) {
            throw new CoderException(j.pj);
        }
    }

    public c a(c cVar) throws CoderException {
        if (cVar == null || cVar.pX == null || cVar.pY == null) {
            throw new CoderException(j.oX);
        }
        a aVar = cVar.pX;
        if (aVar.df() && cVar.qa > 0) {
            if (d.dj().getSecretKey() == null) {
                throw new CoderException(j.pg);
            }
            try {
                cVar.pY = v.a(d.dj().getSecretKey(), cVar.pY, cVar.pZ, cVar.qa);
                cVar.pZ = 0;
                cVar.qa = cVar.pY.length;
            } catch (Exception e) {
                throw new CoderException(j.pi);
            }
        }
        if (aVar.dd() && cVar.qa > 0) {
            try {
                cVar.pY = c(cVar.pY, cVar.pZ, cVar.qa);
                cVar.pZ = 0;
                cVar.qa = cVar.pY.length;
            } catch (Exception e2) {
                throw new CoderException(j.pf);
            }
        }
        return cVar;
    }

    public c i(byte[] bArr) throws CoderException {
        int dc = a.dc();
        if (bArr == null || bArr.length < dc) {
            throw new CoderException(j.oX);
        }
        a h = a.h(bArr);
        if (h == null) {
            throw new CoderException(j.oX);
        }
        c cVar = new c();
        cVar.pX = h;
        cVar.pY = bArr;
        cVar.pZ = dc;
        cVar.qa = bArr.length - dc;
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
                    newInstance.onDecodeFailedInBackGround(i, bArr, j.pa);
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
            throw new CoderException(j.pa);
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
