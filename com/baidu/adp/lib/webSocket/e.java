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
    private static com.baidu.adp.lib.webSocket.b zW;

    /* loaded from: classes.dex */
    public interface a {
        void close();

        boolean isConnected();

        String jN();

        long jO();

        int jP();

        String jx();

        String jy();

        int read(ByteBuffer byteBuffer);

        int write(ByteBuffer byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(String str, int i, n nVar, boolean z) {
        if (zW != null) {
            return zW.a(str, i, nVar);
        }
        if (z) {
            return new b(str, i, nVar);
        }
        return new c(str, i, nVar);
    }

    /* loaded from: classes.dex */
    static class c implements a {
        private String Aa;
        private String Ab;
        private Socket Ac;
        private InputStream Ae;
        private OutputStream mOutputStream;
        private byte[] rK;
        private long zY;
        private String zZ;

        public c(String str, int i, n nVar) {
            this.Ac = null;
            this.Ae = null;
            this.mOutputStream = null;
            this.rK = null;
            this.zY = 0L;
            this.zZ = null;
            this.Aa = null;
            this.Ab = null;
            this.Ac = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.zZ = inetSocketAddress.getAddress().getHostAddress();
                this.zY = System.currentTimeMillis() - currentTimeMillis;
            }
            this.Ac.connect(inetSocketAddress, nVar.kl());
            this.Ac.setSoTimeout(nVar.kk());
            this.Ac.setTcpNoDelay(nVar.getTcpNoDelay());
            this.Ae = this.Ac.getInputStream();
            this.mOutputStream = this.Ac.getOutputStream();
            this.rK = new byte[1024];
            this.Aa = com.baidu.adp.lib.util.k.jx();
            this.Ab = com.baidu.adp.lib.util.k.jy();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() {
            try {
                this.Ae.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.Ac != null) {
                try {
                    this.Ac.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.Ac != null) {
                return this.Ac.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) {
            int read = this.Ae.read(this.rK);
            if (read > 0) {
                byteBuffer.put(this.rK, 0, read);
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
        public String jN() {
            return this.zZ;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long jO() {
            return this.zY;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jx() {
            return this.Aa;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jy() {
            return this.Ab;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int jP() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private String Aa;
        private String Ab;
        private SocketChannel zX;
        private long zY;
        private String zZ;

        public b(String str, int i, n nVar) {
            this.zX = null;
            this.zY = 0L;
            this.zZ = null;
            this.Aa = null;
            this.Ab = null;
            this.zX = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.zZ = inetSocketAddress.getAddress().getHostAddress();
                this.zY = System.currentTimeMillis() - currentTimeMillis;
            }
            this.zX.socket().connect(inetSocketAddress, nVar.kl());
            this.zX.socket().setSoTimeout(nVar.kk());
            this.zX.socket().setTcpNoDelay(nVar.getTcpNoDelay());
            this.Aa = com.baidu.adp.lib.util.k.jx();
            this.Ab = com.baidu.adp.lib.util.k.jy();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() {
            if (this.zX != null) {
                this.zX.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.zX != null) {
                return this.zX.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) {
            return this.zX.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) {
            return this.zX.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jN() {
            return this.zZ;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long jO() {
            return this.zY;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jx() {
            return this.Aa;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jy() {
            return this.Ab;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int jP() {
            return 0;
        }
    }
}
