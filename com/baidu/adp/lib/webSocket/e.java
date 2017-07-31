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
    private static com.baidu.adp.lib.webSocket.b Bp;

    /* loaded from: classes.dex */
    public interface a {
        void close() throws IOException;

        String hJ();

        String hK();

        String ia();

        long ib();

        int ic();

        boolean isConnected();

        int read(ByteBuffer byteBuffer) throws Exception;

        int write(ByteBuffer byteBuffer) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(String str, int i, l lVar, boolean z) throws Exception {
        if (Bp != null) {
            return Bp.a(str, i, lVar);
        }
        if (z) {
            return new b(str, i, lVar);
        }
        return new c(str, i, lVar);
    }

    /* loaded from: classes.dex */
    static class c implements a {
        private long Br;
        private String Bs;
        private String Bt;
        private String Bu;
        private Socket Bv;
        private InputStream Bw;
        private OutputStream mOutputStream;
        private byte[] ts;

        public c(String str, int i, l lVar) throws Exception {
            this.Bv = null;
            this.Bw = null;
            this.mOutputStream = null;
            this.ts = null;
            this.Br = 0L;
            this.Bs = null;
            this.Bt = null;
            this.Bu = null;
            this.Bv = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.Bs = inetSocketAddress.getAddress().getHostAddress();
                this.Br = System.currentTimeMillis() - currentTimeMillis;
            }
            this.Bv.connect(inetSocketAddress, lVar.ix());
            this.Bv.setSoTimeout(lVar.iw());
            this.Bv.setTcpNoDelay(lVar.getTcpNoDelay());
            this.Bw = this.Bv.getInputStream();
            this.mOutputStream = this.Bv.getOutputStream();
            this.ts = new byte[1024];
            this.Bt = com.baidu.adp.lib.util.k.hJ();
            this.Bu = com.baidu.adp.lib.util.k.hK();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            try {
                this.Bw.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.Bv != null) {
                try {
                    this.Bv.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.Bv != null) {
                return this.Bv.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.Bw.read(this.ts);
            if (read > 0) {
                byteBuffer.put(this.ts, 0, read);
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
        public String ia() {
            return this.Bs;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long ib() {
            return this.Br;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hJ() {
            return this.Bt;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hK() {
            return this.Bu;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int ic() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel Bq;
        private long Br;
        private String Bs;
        private String Bt;
        private String Bu;

        public b(String str, int i, l lVar) throws Exception {
            this.Bq = null;
            this.Br = 0L;
            this.Bs = null;
            this.Bt = null;
            this.Bu = null;
            this.Bq = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.Bs = inetSocketAddress.getAddress().getHostAddress();
                this.Br = System.currentTimeMillis() - currentTimeMillis;
            }
            this.Bq.socket().connect(inetSocketAddress, lVar.ix());
            this.Bq.socket().setSoTimeout(lVar.iw());
            this.Bq.socket().setTcpNoDelay(lVar.getTcpNoDelay());
            this.Bt = com.baidu.adp.lib.util.k.hJ();
            this.Bu = com.baidu.adp.lib.util.k.hK();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            if (this.Bq != null) {
                this.Bq.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.Bq != null) {
                return this.Bq.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.Bq.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.Bq.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String ia() {
            return this.Bs;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long ib() {
            return this.Br;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hJ() {
            return this.Bt;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hK() {
            return this.Bu;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int ic() {
            return 0;
        }
    }
}
