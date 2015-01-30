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
    private OutputStream fU;
    private byte[] mData;
    private InputStream mInputStream;
    private long pf;
    private String pg;
    private String ph;
    private String pi;
    private Socket pj;

    public i(String str, int i, am amVar) {
        this.pj = null;
        this.mInputStream = null;
        this.fU = null;
        this.mData = null;
        this.pf = 0L;
        this.pg = null;
        this.ph = null;
        this.pi = null;
        this.pj = new Socket();
        long currentTimeMillis = System.currentTimeMillis();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
        if (inetSocketAddress.getAddress() != null) {
            this.pg = inetSocketAddress.getAddress().getHostAddress();
            this.pf = System.currentTimeMillis() - currentTimeMillis;
        }
        this.pj.connect(inetSocketAddress, amVar.go());
        this.pj.setSoTimeout(amVar.gn());
        this.pj.setTcpNoDelay(amVar.getTcpNoDelay());
        this.mInputStream = this.pj.getInputStream();
        this.fU = this.pj.getOutputStream();
        this.mData = new byte[1024];
        this.ph = com.baidu.adp.lib.util.l.fu();
        this.pi = com.baidu.adp.lib.util.l.fv();
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public void close() {
        try {
            this.mInputStream.close();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        try {
            this.fU.close();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        if (this.pj != null) {
            try {
                this.pj.close();
            } catch (IOException e3) {
                throw e3;
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public boolean isConnected() {
        if (this.pj != null) {
            return this.pj.isConnected();
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
            this.fU.write(bArr);
        }
        return remaining;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public String fR() {
        return this.pg;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public long fS() {
        return this.pf;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public String fu() {
        return this.ph;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public String fv() {
        return this.pi;
    }
}
