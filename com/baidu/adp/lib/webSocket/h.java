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
    private OutputStream ry;
    private long zG;
    private String zH;
    private String zI;
    private String zJ;
    private Socket zK;

    public h(String str, int i, al alVar) {
        this.zK = null;
        this.mInputStream = null;
        this.ry = null;
        this.mData = null;
        this.zG = 0L;
        this.zH = null;
        this.zI = null;
        this.zJ = null;
        this.zK = new Socket();
        long currentTimeMillis = System.currentTimeMillis();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
        if (inetSocketAddress.getAddress() != null) {
            this.zH = inetSocketAddress.getAddress().getHostAddress();
            this.zG = System.currentTimeMillis() - currentTimeMillis;
        }
        this.zK.connect(inetSocketAddress, alVar.kb());
        this.zK.setSoTimeout(alVar.ka());
        this.zK.setTcpNoDelay(alVar.getTcpNoDelay());
        this.mInputStream = this.zK.getInputStream();
        this.ry = this.zK.getOutputStream();
        this.mData = new byte[1024];
        this.zI = com.baidu.adp.lib.util.n.jm();
        this.zJ = com.baidu.adp.lib.util.n.jn();
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public void close() {
        try {
            this.mInputStream.close();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        try {
            this.ry.close();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        if (this.zK != null) {
            try {
                this.zK.close();
            } catch (IOException e3) {
                throw e3;
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public boolean isConnected() {
        if (this.zK != null) {
            return this.zK.isConnected();
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
            this.ry.write(bArr);
        }
        return remaining;
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public String jE() {
        return this.zH;
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public long jF() {
        return this.zG;
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public String jm() {
        return this.zI;
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public String jn() {
        return this.zJ;
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public int jG() {
        return 0;
    }
}
