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
    private static com.baidu.adp.lib.webSocket.b zL;

    /* loaded from: classes.dex */
    public interface a {
        void close() throws IOException;

        String hB();

        String hC();

        String hT();

        long hU();

        int hV();

        boolean isConnected();

        int read(ByteBuffer byteBuffer) throws Exception;

        int write(ByteBuffer byteBuffer) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(String str, int i, n nVar, boolean z) throws Exception {
        if (zL != null) {
            return zL.a(str, i, nVar);
        }
        if (z) {
            return new b(str, i, nVar);
        }
        return new c(str, i, nVar);
    }

    /* loaded from: classes.dex */
    static class c implements a {
        private OutputStream mOutputStream;
        private byte[] rF;
        private long zN;
        private String zO;
        private String zP;
        private String zQ;
        private Socket zR;
        private InputStream zS;

        public c(String str, int i, n nVar) throws Exception {
            this.zR = null;
            this.zS = null;
            this.mOutputStream = null;
            this.rF = null;
            this.zN = 0L;
            this.zO = null;
            this.zP = null;
            this.zQ = null;
            this.zR = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.zO = inetSocketAddress.getAddress().getHostAddress();
                this.zN = System.currentTimeMillis() - currentTimeMillis;
            }
            this.zR.connect(inetSocketAddress, nVar.iq());
            this.zR.setSoTimeout(nVar.ip());
            this.zR.setTcpNoDelay(nVar.getTcpNoDelay());
            this.zS = this.zR.getInputStream();
            this.mOutputStream = this.zR.getOutputStream();
            this.rF = new byte[1024];
            this.zP = com.baidu.adp.lib.util.k.hB();
            this.zQ = com.baidu.adp.lib.util.k.hC();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            try {
                this.zS.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.zR != null) {
                try {
                    this.zR.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.zR != null) {
                return this.zR.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.zS.read(this.rF);
            if (read > 0) {
                byteBuffer.put(this.rF, 0, read);
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
        public String hT() {
            return this.zO;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long hU() {
            return this.zN;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hB() {
            return this.zP;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hC() {
            return this.zQ;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int hV() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel zM;
        private long zN;
        private String zO;
        private String zP;
        private String zQ;

        public b(String str, int i, n nVar) throws Exception {
            this.zM = null;
            this.zN = 0L;
            this.zO = null;
            this.zP = null;
            this.zQ = null;
            this.zM = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.zO = inetSocketAddress.getAddress().getHostAddress();
                this.zN = System.currentTimeMillis() - currentTimeMillis;
            }
            this.zM.socket().connect(inetSocketAddress, nVar.iq());
            this.zM.socket().setSoTimeout(nVar.ip());
            this.zM.socket().setTcpNoDelay(nVar.getTcpNoDelay());
            this.zP = com.baidu.adp.lib.util.k.hB();
            this.zQ = com.baidu.adp.lib.util.k.hC();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            if (this.zM != null) {
                this.zM.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.zM != null) {
                return this.zM.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.zM.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.zM.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hT() {
            return this.zO;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long hU() {
            return this.zN;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hB() {
            return this.zP;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hC() {
            return this.zQ;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int hV() {
            return 0;
        }
    }
}
