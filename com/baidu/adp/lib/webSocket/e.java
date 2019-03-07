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
    private static com.baidu.adp.lib.webSocket.b Hg;

    /* loaded from: classes.dex */
    public interface a {
        void close() throws IOException;

        boolean isConnected();

        String lF();

        long lG();

        int lH();

        String lp();

        String lq();

        int read(ByteBuffer byteBuffer) throws Exception;

        int write(ByteBuffer byteBuffer) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(String str, int i, l lVar, boolean z) throws Exception {
        if (Hg != null) {
            return Hg.a(str, i, lVar);
        }
        if (z) {
            return new b(str, i, lVar);
        }
        return new c(str, i, lVar);
    }

    /* loaded from: classes.dex */
    static class c implements a {
        private long Hi;
        private String Hj;
        private String Hk;
        private String Hl;
        private Socket Hm;
        private InputStream Hn;
        private byte[] mData;
        private OutputStream mOutputStream;

        public c(String str, int i, l lVar) throws Exception {
            this.Hm = null;
            this.Hn = null;
            this.mOutputStream = null;
            this.mData = null;
            this.Hi = 0L;
            this.Hj = null;
            this.Hk = null;
            this.Hl = null;
            this.Hm = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.Hj = inetSocketAddress.getAddress().getHostAddress();
                this.Hi = System.currentTimeMillis() - currentTimeMillis;
            }
            this.Hm.connect(inetSocketAddress, lVar.mb());
            this.Hm.setSoTimeout(lVar.ma());
            this.Hm.setTcpNoDelay(lVar.getTcpNoDelay());
            this.Hn = this.Hm.getInputStream();
            this.mOutputStream = this.Hm.getOutputStream();
            this.mData = new byte[1024];
            this.Hk = com.baidu.adp.lib.util.l.lp();
            this.Hl = com.baidu.adp.lib.util.l.lq();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            try {
                this.Hn.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.Hm != null) {
                try {
                    this.Hm.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.Hm != null) {
                return this.Hm.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.Hn.read(this.mData);
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
        public String lF() {
            return this.Hj;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long lG() {
            return this.Hi;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String lp() {
            return this.Hk;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String lq() {
            return this.Hl;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int lH() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel Hh;
        private long Hi;
        private String Hj;
        private String Hk;
        private String Hl;

        public b(String str, int i, l lVar) throws Exception {
            this.Hh = null;
            this.Hi = 0L;
            this.Hj = null;
            this.Hk = null;
            this.Hl = null;
            this.Hh = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.Hj = inetSocketAddress.getAddress().getHostAddress();
                this.Hi = System.currentTimeMillis() - currentTimeMillis;
            }
            this.Hh.socket().connect(inetSocketAddress, lVar.mb());
            this.Hh.socket().setSoTimeout(lVar.ma());
            this.Hh.socket().setTcpNoDelay(lVar.getTcpNoDelay());
            this.Hk = com.baidu.adp.lib.util.l.lp();
            this.Hl = com.baidu.adp.lib.util.l.lq();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            if (this.Hh != null) {
                this.Hh.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.Hh != null) {
                return this.Hh.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.Hh.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.Hh.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String lF() {
            return this.Hj;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long lG() {
            return this.Hi;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String lp() {
            return this.Hk;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String lq() {
            return this.Hl;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int lH() {
            return 0;
        }
    }
}
