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
    private OutputStream fS;
    private byte[] mData;
    private InputStream mInputStream;
    private long oY;
    private String oZ;
    private String pa;
    private String pd;
    private Socket pe;

    public i(String str, int i, am amVar) {
        this.pe = null;
        this.mInputStream = null;
        this.fS = null;
        this.mData = null;
        this.oY = 0L;
        this.oZ = null;
        this.pa = null;
        this.pd = null;
        this.pe = new Socket();
        long currentTimeMillis = System.currentTimeMillis();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
        if (inetSocketAddress.getAddress() != null) {
            this.oZ = inetSocketAddress.getAddress().getHostAddress();
            this.oY = System.currentTimeMillis() - currentTimeMillis;
        }
        this.pe.connect(inetSocketAddress, amVar.gp());
        this.pe.setSoTimeout(amVar.go());
        this.pe.setTcpNoDelay(amVar.getTcpNoDelay());
        this.mInputStream = this.pe.getInputStream();
        this.fS = this.pe.getOutputStream();
        this.mData = new byte[1024];
        this.pa = com.baidu.adp.lib.util.l.fv();
        this.pd = com.baidu.adp.lib.util.l.fw();
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public void close() {
        try {
            this.mInputStream.close();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        try {
            this.fS.close();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        if (this.pe != null) {
            try {
                this.pe.close();
            } catch (IOException e3) {
                throw e3;
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public boolean isConnected() {
        if (this.pe != null) {
            return this.pe.isConnected();
        }
        return false;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public int read(ByteBuffer byteBuffer) {
        int read = this.mInputStream.read(this.mData);
        if (read > 0) {
            byteBuffer.put(this.mData, 0, read);
        }
        return read;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public int write(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        if (remaining > 0) {
            byte[] bArr = new byte[remaining];
            byteBuffer.get(bArr);
            this.fS.write(bArr);
        }
        return remaining;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public String fS() {
        return this.oZ;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public long fT() {
        return this.oY;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public String fv() {
        return this.pa;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public String fw() {
        return this.pd;
    }
}
