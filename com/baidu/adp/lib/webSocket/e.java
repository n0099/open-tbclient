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
    private static com.baidu.adp.lib.webSocket.b Br;

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
        if (Br != null) {
            return Br.a(str, i, lVar);
        }
        if (z) {
            return new b(str, i, lVar);
        }
        return new c(str, i, lVar);
    }

    /* loaded from: classes.dex */
    static class c implements a {
        private long Bt;
        private String Bu;
        private String Bv;
        private String Bw;
        private Socket Bx;
        private InputStream By;
        private byte[] mData;
        private OutputStream mOutputStream;

        public c(String str, int i, l lVar) throws Exception {
            this.Bx = null;
            this.By = null;
            this.mOutputStream = null;
            this.mData = null;
            this.Bt = 0L;
            this.Bu = null;
            this.Bv = null;
            this.Bw = null;
            this.Bx = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.Bu = inetSocketAddress.getAddress().getHostAddress();
                this.Bt = System.currentTimeMillis() - currentTimeMillis;
            }
            this.Bx.connect(inetSocketAddress, lVar.ix());
            this.Bx.setSoTimeout(lVar.iw());
            this.Bx.setTcpNoDelay(lVar.getTcpNoDelay());
            this.By = this.Bx.getInputStream();
            this.mOutputStream = this.Bx.getOutputStream();
            this.mData = new byte[1024];
            this.Bv = com.baidu.adp.lib.util.k.hJ();
            this.Bw = com.baidu.adp.lib.util.k.hK();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            try {
                this.By.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.Bx != null) {
                try {
                    this.Bx.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.Bx != null) {
                return this.Bx.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.By.read(this.mData);
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
        public String ia() {
            return this.Bu;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long ib() {
            return this.Bt;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hJ() {
            return this.Bv;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hK() {
            return this.Bw;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int ic() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel Bs;
        private long Bt;
        private String Bu;
        private String Bv;
        private String Bw;

        public b(String str, int i, l lVar) throws Exception {
            this.Bs = null;
            this.Bt = 0L;
            this.Bu = null;
            this.Bv = null;
            this.Bw = null;
            this.Bs = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.Bu = inetSocketAddress.getAddress().getHostAddress();
                this.Bt = System.currentTimeMillis() - currentTimeMillis;
            }
            this.Bs.socket().connect(inetSocketAddress, lVar.ix());
            this.Bs.socket().setSoTimeout(lVar.iw());
            this.Bs.socket().setTcpNoDelay(lVar.getTcpNoDelay());
            this.Bv = com.baidu.adp.lib.util.k.hJ();
            this.Bw = com.baidu.adp.lib.util.k.hK();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            if (this.Bs != null) {
                this.Bs.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.Bs != null) {
                return this.Bs.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.Bs.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.Bs.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String ia() {
            return this.Bu;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long ib() {
            return this.Bt;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hJ() {
            return this.Bv;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hK() {
            return this.Bw;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int ic() {
            return 0;
        }
    }
}
