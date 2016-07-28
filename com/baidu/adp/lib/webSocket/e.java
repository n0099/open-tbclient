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
    private static com.baidu.adp.lib.webSocket.b qL;

    /* loaded from: classes.dex */
    public interface a {
        void close() throws IOException;

        String fI();

        String fJ();

        String ga();

        long gb();

        int gd();

        boolean isConnected();

        int read(ByteBuffer byteBuffer) throws Exception;

        int write(ByteBuffer byteBuffer) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(String str, int i, n nVar, boolean z) throws Exception {
        if (qL != null) {
            return qL.a(str, i, nVar);
        }
        if (z) {
            return new b(str, i, nVar);
        }
        return new c(str, i, nVar);
    }

    /* loaded from: classes.dex */
    static class c implements a {
        private byte[] hY;
        private OutputStream mOutputStream;
        private long qN;
        private String qO;
        private String qP;
        private String qQ;
        private Socket qR;
        private InputStream qS;

        public c(String str, int i, n nVar) throws Exception {
            this.qR = null;
            this.qS = null;
            this.mOutputStream = null;
            this.hY = null;
            this.qN = 0L;
            this.qO = null;
            this.qP = null;
            this.qQ = null;
            this.qR = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.qO = inetSocketAddress.getAddress().getHostAddress();
                this.qN = System.currentTimeMillis() - currentTimeMillis;
            }
            this.qR.connect(inetSocketAddress, nVar.gz());
            this.qR.setSoTimeout(nVar.gy());
            this.qR.setTcpNoDelay(nVar.getTcpNoDelay());
            this.qS = this.qR.getInputStream();
            this.mOutputStream = this.qR.getOutputStream();
            this.hY = new byte[1024];
            this.qP = com.baidu.adp.lib.util.k.fI();
            this.qQ = com.baidu.adp.lib.util.k.fJ();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            try {
                this.qS.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.qR != null) {
                try {
                    this.qR.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.qR != null) {
                return this.qR.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.qS.read(this.hY);
            if (read > 0) {
                byteBuffer.put(this.hY, 0, read);
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
        public String ga() {
            return this.qO;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long gb() {
            return this.qN;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String fI() {
            return this.qP;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String fJ() {
            return this.qQ;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int gd() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel qM;
        private long qN;
        private String qO;
        private String qP;
        private String qQ;

        public b(String str, int i, n nVar) throws Exception {
            this.qM = null;
            this.qN = 0L;
            this.qO = null;
            this.qP = null;
            this.qQ = null;
            this.qM = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.qO = inetSocketAddress.getAddress().getHostAddress();
                this.qN = System.currentTimeMillis() - currentTimeMillis;
            }
            this.qM.socket().connect(inetSocketAddress, nVar.gz());
            this.qM.socket().setSoTimeout(nVar.gy());
            this.qM.socket().setTcpNoDelay(nVar.getTcpNoDelay());
            this.qP = com.baidu.adp.lib.util.k.fI();
            this.qQ = com.baidu.adp.lib.util.k.fJ();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            if (this.qM != null) {
                this.qM.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.qM != null) {
                return this.qM.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.qM.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.qM.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String ga() {
            return this.qO;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long gb() {
            return this.qN;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String fI() {
            return this.qP;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String fJ() {
            return this.qQ;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int gd() {
            return 0;
        }
    }
}
