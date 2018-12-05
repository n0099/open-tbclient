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
    private static com.baidu.adp.lib.webSocket.b Hh;

    /* loaded from: classes.dex */
    public interface a {
        void close() throws IOException;

        String getLocalDns();

        boolean isConnected();

        String lA();

        long lB();

        int lC();

        String lm();

        int read(ByteBuffer byteBuffer) throws Exception;

        int write(ByteBuffer byteBuffer) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(String str, int i, l lVar, boolean z) throws Exception {
        if (Hh != null) {
            return Hh.a(str, i, lVar);
        }
        if (z) {
            return new b(str, i, lVar);
        }
        return new c(str, i, lVar);
    }

    /* loaded from: classes.dex */
    static class c implements a {
        private long Hj;
        private String Hk;
        private String Hl;
        private String Hm;
        private Socket Hn;
        private byte[] mData;
        private InputStream mInputStream;
        private OutputStream mOutputStream;

        public c(String str, int i, l lVar) throws Exception {
            this.Hn = null;
            this.mInputStream = null;
            this.mOutputStream = null;
            this.mData = null;
            this.Hj = 0L;
            this.Hk = null;
            this.Hl = null;
            this.Hm = null;
            this.Hn = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.Hk = inetSocketAddress.getAddress().getHostAddress();
                this.Hj = System.currentTimeMillis() - currentTimeMillis;
            }
            this.Hn.connect(inetSocketAddress, lVar.lW());
            this.Hn.setSoTimeout(lVar.lV());
            this.Hn.setTcpNoDelay(lVar.getTcpNoDelay());
            this.mInputStream = this.Hn.getInputStream();
            this.mOutputStream = this.Hn.getOutputStream();
            this.mData = new byte[1024];
            this.Hl = com.baidu.adp.lib.util.l.getLocalDns();
            this.Hm = com.baidu.adp.lib.util.l.lm();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            try {
                this.mInputStream.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.Hn != null) {
                try {
                    this.Hn.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.Hn != null) {
                return this.Hn.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.mInputStream.read(this.mData);
            if (read > 0) {
                byteBuffer.put(this.mData, 0, read);
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
        public String lA() {
            return this.Hk;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long lB() {
            return this.Hj;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String getLocalDns() {
            return this.Hl;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String lm() {
            return this.Hm;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int lC() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel Hi;
        private long Hj;
        private String Hk;
        private String Hl;
        private String Hm;

        public b(String str, int i, l lVar) throws Exception {
            this.Hi = null;
            this.Hj = 0L;
            this.Hk = null;
            this.Hl = null;
            this.Hm = null;
            this.Hi = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.Hk = inetSocketAddress.getAddress().getHostAddress();
                this.Hj = System.currentTimeMillis() - currentTimeMillis;
            }
            this.Hi.socket().connect(inetSocketAddress, lVar.lW());
            this.Hi.socket().setSoTimeout(lVar.lV());
            this.Hi.socket().setTcpNoDelay(lVar.getTcpNoDelay());
            this.Hl = com.baidu.adp.lib.util.l.getLocalDns();
            this.Hm = com.baidu.adp.lib.util.l.lm();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            if (this.Hi != null) {
                this.Hi.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.Hi != null) {
                return this.Hi.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.Hi.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.Hi.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String lA() {
            return this.Hk;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long lB() {
            return this.Hj;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String getLocalDns() {
            return this.Hl;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String lm() {
            return this.Hm;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int lC() {
            return 0;
        }
    }
}
