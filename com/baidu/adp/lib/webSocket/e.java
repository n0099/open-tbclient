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
    private static com.baidu.adp.lib.webSocket.b sT;

    /* loaded from: classes.dex */
    public interface a {
        void close() throws IOException;

        String gC();

        String gD();

        String gU();

        long gV();

        int gW();

        boolean isConnected();

        int read(ByteBuffer byteBuffer) throws Exception;

        int write(ByteBuffer byteBuffer) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(String str, int i, n nVar, boolean z) throws Exception {
        if (sT != null) {
            return sT.a(str, i, nVar);
        }
        if (z) {
            return new b(str, i, nVar);
        }
        return new c(str, i, nVar);
    }

    /* loaded from: classes.dex */
    static class c implements a {
        private byte[] kl;
        private OutputStream mOutputStream;
        private long sV;
        private String sW;
        private String sX;
        private String sY;
        private Socket sZ;
        private InputStream tb;

        public c(String str, int i, n nVar) throws Exception {
            this.sZ = null;
            this.tb = null;
            this.mOutputStream = null;
            this.kl = null;
            this.sV = 0L;
            this.sW = null;
            this.sX = null;
            this.sY = null;
            this.sZ = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.sW = inetSocketAddress.getAddress().getHostAddress();
                this.sV = System.currentTimeMillis() - currentTimeMillis;
            }
            this.sZ.connect(inetSocketAddress, nVar.hs());
            this.sZ.setSoTimeout(nVar.hr());
            this.sZ.setTcpNoDelay(nVar.getTcpNoDelay());
            this.tb = this.sZ.getInputStream();
            this.mOutputStream = this.sZ.getOutputStream();
            this.kl = new byte[1024];
            this.sX = com.baidu.adp.lib.util.k.gC();
            this.sY = com.baidu.adp.lib.util.k.gD();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            try {
                this.tb.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.sZ != null) {
                try {
                    this.sZ.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.sZ != null) {
                return this.sZ.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.tb.read(this.kl);
            if (read > 0) {
                byteBuffer.put(this.kl, 0, read);
            }
            return read;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            int remaining = byteBuffer.remaining();
            if (remaining > 0) {
                byte[] bArr = new byte[remaining];
                byteBuffer.get(bArr);
                this.mOutputStream.write(bArr);
            }
            return remaining;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String gU() {
            return this.sW;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long gV() {
            return this.sV;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String gC() {
            return this.sX;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String gD() {
            return this.sY;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int gW() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel sU;
        private long sV;
        private String sW;
        private String sX;
        private String sY;

        public b(String str, int i, n nVar) throws Exception {
            this.sU = null;
            this.sV = 0L;
            this.sW = null;
            this.sX = null;
            this.sY = null;
            this.sU = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.sW = inetSocketAddress.getAddress().getHostAddress();
                this.sV = System.currentTimeMillis() - currentTimeMillis;
            }
            this.sU.socket().connect(inetSocketAddress, nVar.hs());
            this.sU.socket().setSoTimeout(nVar.hr());
            this.sU.socket().setTcpNoDelay(nVar.getTcpNoDelay());
            this.sX = com.baidu.adp.lib.util.k.gC();
            this.sY = com.baidu.adp.lib.util.k.gD();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            if (this.sU != null) {
                this.sU.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.sU != null) {
                return this.sU.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.sU.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.sU.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String gU() {
            return this.sW;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long gV() {
            return this.sV;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String gC() {
            return this.sX;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String gD() {
            return this.sY;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int gW() {
            return 0;
        }
    }
}
