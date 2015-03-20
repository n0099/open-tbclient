package com.baidu.adp.lib.webSocket;

import com.baidu.adp.lib.util.BdLog;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
class h implements f {
    private byte[] mData;
    private InputStream mInputStream;
    private OutputStream ro;
    private long zR;
    private String zS;
    private String zT;
    private String zU;
    private Socket zV;

    public h(String str, int i, al alVar) {
        this.zV = null;
        this.mInputStream = null;
        this.ro = null;
        this.mData = null;
        this.zR = 0L;
        this.zS = null;
        this.zT = null;
        this.zU = null;
        this.zV = new Socket();
        long currentTimeMillis = System.currentTimeMillis();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
        if (inetSocketAddress.getAddress() != null) {
            this.zS = inetSocketAddress.getAddress().getHostAddress();
            this.zR = System.currentTimeMillis() - currentTimeMillis;
        }
        this.zV.connect(inetSocketAddress, alVar.jK());
        this.zV.setSoTimeout(alVar.jJ());
        this.zV.setTcpNoDelay(alVar.getTcpNoDelay());
        this.mInputStream = this.zV.getInputStream();
        this.ro = this.zV.getOutputStream();
        this.mData = new byte[1024];
        this.zT = com.baidu.adp.lib.util.n.iX();
        this.zU = com.baidu.adp.lib.util.n.iY();
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public void close() {
        try {
            this.mInputStream.close();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        try {
            this.ro.close();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        if (this.zV != null) {
            try {
                this.zV.close();
            } catch (IOException e3) {
                throw e3;
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public boolean isConnected() {
        if (this.zV != null) {
            return this.zV.isConnected();
        }
        return false;
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public int read(ByteBuffer byteBuffer) {
        int read = this.mInputStream.read(this.mData);
        if (read > 0) {
            byteBuffer.put(this.mData, 0, read);
        }
        return read;
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public int write(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        if (remaining > 0) {
            byte[] bArr = new byte[remaining];
            byteBuffer.get(bArr);
            this.ro.write(bArr);
        }
        return remaining;
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public String jn() {
        return this.zS;
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public long jo() {
        return this.zR;
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public String iX() {
        return this.zT;
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public String iY() {
        return this.zU;
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public int jp() {
        return 0;
    }
}
