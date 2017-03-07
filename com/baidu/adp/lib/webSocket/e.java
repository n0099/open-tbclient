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
    private static com.baidu.adp.lib.webSocket.b Al;

    /* loaded from: classes.dex */
    public interface a {
        void close() throws IOException;

        String hO();

        long hP();

        int hQ();

        String hw();

        String hx();

        boolean isConnected();

        int read(ByteBuffer byteBuffer) throws Exception;

        int write(ByteBuffer byteBuffer) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(String str, int i, n nVar, boolean z) throws Exception {
        if (Al != null) {
            return Al.a(str, i, nVar);
        }
        if (z) {
            return new b(str, i, nVar);
        }
        return new c(str, i, nVar);
    }

    /* loaded from: classes.dex */
    static class c implements a {
        private long An;
        private String Ao;
        private String Ap;
        private String Aq;
        private Socket Ar;
        private InputStream As;
        private OutputStream mOutputStream;
        private byte[] sg;

        public c(String str, int i, n nVar) throws Exception {
            this.Ar = null;
            this.As = null;
            this.mOutputStream = null;
            this.sg = null;
            this.An = 0L;
            this.Ao = null;
            this.Ap = null;
            this.Aq = null;
            this.Ar = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.Ao = inetSocketAddress.getAddress().getHostAddress();
                this.An = System.currentTimeMillis() - currentTimeMillis;
            }
            this.Ar.connect(inetSocketAddress, nVar.im());
            this.Ar.setSoTimeout(nVar.il());
            this.Ar.setTcpNoDelay(nVar.getTcpNoDelay());
            this.As = this.Ar.getInputStream();
            this.mOutputStream = this.Ar.getOutputStream();
            this.sg = new byte[1024];
            this.Ap = com.baidu.adp.lib.util.k.hw();
            this.Aq = com.baidu.adp.lib.util.k.hx();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            try {
                this.As.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.Ar != null) {
                try {
                    this.Ar.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.Ar != null) {
                return this.Ar.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.As.read(this.sg);
            if (read > 0) {
                byteBuffer.put(this.sg, 0, read);
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
        public String hO() {
            return this.Ao;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long hP() {
            return this.An;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hw() {
            return this.Ap;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hx() {
            return this.Aq;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int hQ() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel Am;
        private long An;
        private String Ao;
        private String Ap;
        private String Aq;

        public b(String str, int i, n nVar) throws Exception {
            this.Am = null;
            this.An = 0L;
            this.Ao = null;
            this.Ap = null;
            this.Aq = null;
            this.Am = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.Ao = inetSocketAddress.getAddress().getHostAddress();
                this.An = System.currentTimeMillis() - currentTimeMillis;
            }
            this.Am.socket().connect(inetSocketAddress, nVar.im());
            this.Am.socket().setSoTimeout(nVar.il());
            this.Am.socket().setTcpNoDelay(nVar.getTcpNoDelay());
            this.Ap = com.baidu.adp.lib.util.k.hw();
            this.Aq = com.baidu.adp.lib.util.k.hx();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            if (this.Am != null) {
                this.Am.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.Am != null) {
                return this.Am.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.Am.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.Am.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hO() {
            return this.Ao;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long hP() {
            return this.An;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hw() {
            return this.Ap;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hx() {
            return this.Aq;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int hQ() {
            return 0;
        }
    }
}
