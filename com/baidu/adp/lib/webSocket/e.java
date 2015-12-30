package com.baidu.adp.lib.webSocket;

import com.baidu.adp.lib.util.BdLog;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
/* loaded from: classes.dex */
public class e {
    private static com.baidu.adp.lib.webSocket.b zw;

    /* loaded from: classes.dex */
    public interface a {
        void close();

        boolean isConnected();

        int jA();

        String ji();

        String jj();

        String jy();

        long jz();

        int read(ByteBuffer byteBuffer);

        int write(ByteBuffer byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(String str, int i, n nVar, boolean z) {
        if (zw != null) {
            return zw.a(str, i, nVar);
        }
        if (z) {
            return new b(str, i, nVar);
        }
        return new c(str, i, nVar);
    }

    /* loaded from: classes.dex */
    static class c implements a {
        private byte[] mData;
        private OutputStream mOutputStream;
        private String zA;
        private String zB;
        private Socket zC;
        private InputStream zD;
        private long zy;
        private String zz;

        public c(String str, int i, n nVar) {
            this.zC = null;
            this.zD = null;
            this.mOutputStream = null;
            this.mData = null;
            this.zy = 0L;
            this.zz = null;
            this.zA = null;
            this.zB = null;
            this.zC = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.zz = inetSocketAddress.getAddress().getHostAddress();
                this.zy = System.currentTimeMillis() - currentTimeMillis;
            }
            this.zC.connect(inetSocketAddress, nVar.jV());
            this.zC.setSoTimeout(nVar.jU());
            this.zC.setTcpNoDelay(nVar.getTcpNoDelay());
            this.zD = this.zC.getInputStream();
            this.mOutputStream = this.zC.getOutputStream();
            this.mData = new byte[1024];
            this.zA = com.baidu.adp.lib.util.k.ji();
            this.zB = com.baidu.adp.lib.util.k.jj();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() {
            try {
                this.zD.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.zC != null) {
                try {
                    this.zC.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.zC != null) {
                return this.zC.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) {
            int read = this.zD.read(this.mData);
            if (read > 0) {
                byteBuffer.put(this.mData, 0, read);
            }
            return read;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (remaining > 0) {
                byte[] bArr = new byte[remaining];
                byteBuffer.get(bArr);
                this.mOutputStream.write(bArr);
            }
            return remaining;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jy() {
            return this.zz;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long jz() {
            return this.zy;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String ji() {
            return this.zA;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jj() {
            return this.zB;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int jA() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private String zA;
        private String zB;
        private SocketChannel zx;
        private long zy;
        private String zz;

        public b(String str, int i, n nVar) {
            this.zx = null;
            this.zy = 0L;
            this.zz = null;
            this.zA = null;
            this.zB = null;
            this.zx = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.zz = inetSocketAddress.getAddress().getHostAddress();
                this.zy = System.currentTimeMillis() - currentTimeMillis;
            }
            this.zx.socket().connect(inetSocketAddress, nVar.jV());
            this.zx.socket().setSoTimeout(nVar.jU());
            this.zx.socket().setTcpNoDelay(nVar.getTcpNoDelay());
            this.zA = com.baidu.adp.lib.util.k.ji();
            this.zB = com.baidu.adp.lib.util.k.jj();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() {
            if (this.zx != null) {
                this.zx.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.zx != null) {
                return this.zx.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) {
            return this.zx.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) {
            return this.zx.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jy() {
            return this.zz;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long jz() {
            return this.zy;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String ji() {
            return this.zA;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jj() {
            return this.zB;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int jA() {
            return 0;
        }
    }
}
