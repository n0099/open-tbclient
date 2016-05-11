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
    private static com.baidu.adp.lib.webSocket.b qj;

    /* loaded from: classes.dex */
    public interface a {
        void close();

        String fI();

        String fJ();

        String ga();

        long gb();

        int gd();

        boolean isConnected();

        int read(ByteBuffer byteBuffer);

        int write(ByteBuffer byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(String str, int i, n nVar, boolean z) {
        if (qj != null) {
            return qj.a(str, i, nVar);
        }
        if (z) {
            return new b(str, i, nVar);
        }
        return new c(str, i, nVar);
    }

    /* loaded from: classes.dex */
    static class c implements a {
        private byte[] hx;
        private OutputStream mOutputStream;
        private long ql;
        private String qm;
        private String qn;
        private String qo;
        private Socket qp;
        private InputStream qq;

        public c(String str, int i, n nVar) {
            this.qp = null;
            this.qq = null;
            this.mOutputStream = null;
            this.hx = null;
            this.ql = 0L;
            this.qm = null;
            this.qn = null;
            this.qo = null;
            this.qp = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.qm = inetSocketAddress.getAddress().getHostAddress();
                this.ql = System.currentTimeMillis() - currentTimeMillis;
            }
            this.qp.connect(inetSocketAddress, nVar.gy());
            this.qp.setSoTimeout(nVar.gx());
            this.qp.setTcpNoDelay(nVar.getTcpNoDelay());
            this.qq = this.qp.getInputStream();
            this.mOutputStream = this.qp.getOutputStream();
            this.hx = new byte[1024];
            this.qn = com.baidu.adp.lib.util.k.fI();
            this.qo = com.baidu.adp.lib.util.k.fJ();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() {
            try {
                this.qq.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.qp != null) {
                try {
                    this.qp.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.qp != null) {
                return this.qp.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) {
            int read = this.qq.read(this.hx);
            if (read > 0) {
                byteBuffer.put(this.hx, 0, read);
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
        public String ga() {
            return this.qm;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long gb() {
            return this.ql;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String fI() {
            return this.qn;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String fJ() {
            return this.qo;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int gd() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel qk;
        private long ql;
        private String qm;
        private String qn;
        private String qo;

        public b(String str, int i, n nVar) {
            this.qk = null;
            this.ql = 0L;
            this.qm = null;
            this.qn = null;
            this.qo = null;
            this.qk = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.qm = inetSocketAddress.getAddress().getHostAddress();
                this.ql = System.currentTimeMillis() - currentTimeMillis;
            }
            this.qk.socket().connect(inetSocketAddress, nVar.gy());
            this.qk.socket().setSoTimeout(nVar.gx());
            this.qk.socket().setTcpNoDelay(nVar.getTcpNoDelay());
            this.qn = com.baidu.adp.lib.util.k.fI();
            this.qo = com.baidu.adp.lib.util.k.fJ();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() {
            if (this.qk != null) {
                this.qk.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.qk != null) {
                return this.qk.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) {
            return this.qk.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) {
            return this.qk.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String ga() {
            return this.qm;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long gb() {
            return this.ql;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String fI() {
            return this.qn;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String fJ() {
            return this.qo;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int gd() {
            return 0;
        }
    }
}
