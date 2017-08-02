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
    private static com.baidu.adp.lib.webSocket.b zO;

    /* loaded from: classes.dex */
    public interface a {
        void close() throws IOException;

        String hA();

        String hQ();

        long hR();

        int hS();

        String hz();

        boolean isConnected();

        int read(ByteBuffer byteBuffer) throws Exception;

        int write(ByteBuffer byteBuffer) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(String str, int i, l lVar, boolean z) throws Exception {
        if (zO != null) {
            return zO.a(str, i, lVar);
        }
        if (z) {
            return new b(str, i, lVar);
        }
        return new c(str, i, lVar);
    }

    /* loaded from: classes.dex */
    static class c implements a {
        private OutputStream mOutputStream;
        private byte[] rK;
        private long zQ;
        private String zR;
        private String zS;
        private String zT;
        private Socket zU;
        private InputStream zV;

        public c(String str, int i, l lVar) throws Exception {
            this.zU = null;
            this.zV = null;
            this.mOutputStream = null;
            this.rK = null;
            this.zQ = 0L;
            this.zR = null;
            this.zS = null;
            this.zT = null;
            this.zU = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.zR = inetSocketAddress.getAddress().getHostAddress();
                this.zQ = System.currentTimeMillis() - currentTimeMillis;
            }
            this.zU.connect(inetSocketAddress, lVar.in());
            this.zU.setSoTimeout(lVar.im());
            this.zU.setTcpNoDelay(lVar.getTcpNoDelay());
            this.zV = this.zU.getInputStream();
            this.mOutputStream = this.zU.getOutputStream();
            this.rK = new byte[1024];
            this.zS = com.baidu.adp.lib.util.k.hz();
            this.zT = com.baidu.adp.lib.util.k.hA();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            try {
                this.zV.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.zU != null) {
                try {
                    this.zU.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.zU != null) {
                return this.zU.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.zV.read(this.rK);
            if (read > 0) {
                byteBuffer.put(this.rK, 0, read);
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
        public String hQ() {
            return this.zR;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long hR() {
            return this.zQ;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hz() {
            return this.zS;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hA() {
            return this.zT;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int hS() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel zP;
        private long zQ;
        private String zR;
        private String zS;
        private String zT;

        public b(String str, int i, l lVar) throws Exception {
            this.zP = null;
            this.zQ = 0L;
            this.zR = null;
            this.zS = null;
            this.zT = null;
            this.zP = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.zR = inetSocketAddress.getAddress().getHostAddress();
                this.zQ = System.currentTimeMillis() - currentTimeMillis;
            }
            this.zP.socket().connect(inetSocketAddress, lVar.in());
            this.zP.socket().setSoTimeout(lVar.im());
            this.zP.socket().setTcpNoDelay(lVar.getTcpNoDelay());
            this.zS = com.baidu.adp.lib.util.k.hz();
            this.zT = com.baidu.adp.lib.util.k.hA();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            if (this.zP != null) {
                this.zP.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.zP != null) {
                return this.zP.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.zP.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.zP.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hQ() {
            return this.zR;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long hR() {
            return this.zQ;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hz() {
            return this.zS;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hA() {
            return this.zT;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int hS() {
            return 0;
        }
    }
}
