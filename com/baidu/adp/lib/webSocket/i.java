package com.baidu.adp.lib.webSocket;

import com.baidu.adp.lib.util.BdLog;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
class i implements g {
    private byte[] dL;
    private OutputStream dP;
    private long oZ;
    private String pa;
    private String pd;
    private String pe;
    private Socket pf;
    private InputStream pg;

    public i(String str, int i, am amVar) {
        this.pf = null;
        this.pg = null;
        this.dP = null;
        this.dL = null;
        this.oZ = 0L;
        this.pa = null;
        this.pd = null;
        this.pe = null;
        this.pf = new Socket();
        long currentTimeMillis = System.currentTimeMillis();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
        if (inetSocketAddress.getAddress() != null) {
            this.pa = inetSocketAddress.getAddress().getHostAddress();
            this.oZ = System.currentTimeMillis() - currentTimeMillis;
        }
        this.pf.connect(inetSocketAddress, amVar.go());
        this.pf.setSoTimeout(amVar.gn());
        this.pf.setTcpNoDelay(amVar.getTcpNoDelay());
        this.pg = this.pf.getInputStream();
        this.dP = this.pf.getOutputStream();
        this.dL = new byte[1024];
        this.pd = com.baidu.adp.lib.util.m.fv();
        this.pe = com.baidu.adp.lib.util.m.fw();
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public void close() {
        try {
            this.pg.close();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        try {
            this.dP.close();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        if (this.pf != null) {
            try {
                this.pf.close();
            } catch (IOException e3) {
                throw e3;
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public boolean isConnected() {
        if (this.pf != null) {
            return this.pf.isConnected();
        }
        return false;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public int read(ByteBuffer byteBuffer) {
        int read = this.pg.read(this.dL);
        if (read > 0) {
            byteBuffer.put(this.dL, 0, read);
        }
        return read;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public int write(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        if (remaining > 0) {
            byte[] bArr = new byte[remaining];
            byteBuffer.get(bArr);
            this.dP.write(bArr);
        }
        return remaining;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public String fQ() {
        return this.pa;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public long fR() {
        return this.oZ;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public String fv() {
        return this.pd;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public String fw() {
        return this.pe;
    }
}
