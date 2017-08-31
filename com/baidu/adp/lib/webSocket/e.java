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
    private static com.baidu.adp.lib.webSocket.b zk;

    /* loaded from: classes.dex */
    public interface a {
        void close() throws IOException;

        String hA();

        String hB();

        String hR();

        long hS();

        int hT();

        boolean isConnected();

        int read(ByteBuffer byteBuffer) throws Exception;

        int write(ByteBuffer byteBuffer) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(String str, int i, l lVar, boolean z) throws Exception {
        if (zk != null) {
            return zk.a(str, i, lVar);
        }
        if (z) {
            return new b(str, i, lVar);
        }
        return new c(str, i, lVar);
    }

    /* loaded from: classes.dex */
    static class c implements a {
        private byte[] mData;
        private OutputStream mOutputStream;
        private long zm;
        private String zn;
        private String zo;
        private String zp;
        private Socket zq;
        private InputStream zr;

        public c(String str, int i, l lVar) throws Exception {
            this.zq = null;
            this.zr = null;
            this.mOutputStream = null;
            this.mData = null;
            this.zm = 0L;
            this.zn = null;
            this.zo = null;
            this.zp = null;
            this.zq = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.zn = inetSocketAddress.getAddress().getHostAddress();
                this.zm = System.currentTimeMillis() - currentTimeMillis;
            }
            this.zq.connect(inetSocketAddress, lVar.ip());
            this.zq.setSoTimeout(lVar.io());
            this.zq.setTcpNoDelay(lVar.getTcpNoDelay());
            this.zr = this.zq.getInputStream();
            this.mOutputStream = this.zq.getOutputStream();
            this.mData = new byte[1024];
            this.zo = com.baidu.adp.lib.util.k.hA();
            this.zp = com.baidu.adp.lib.util.k.hB();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            try {
                this.zr.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.zq != null) {
                try {
                    this.zq.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.zq != null) {
                return this.zq.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.zr.read(this.mData);
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
        public String hR() {
            return this.zn;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long hS() {
            return this.zm;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hA() {
            return this.zo;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hB() {
            return this.zp;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int hT() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel zl;
        private long zm;
        private String zn;
        private String zo;
        private String zp;

        public b(String str, int i, l lVar) throws Exception {
            this.zl = null;
            this.zm = 0L;
            this.zn = null;
            this.zo = null;
            this.zp = null;
            this.zl = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.zn = inetSocketAddress.getAddress().getHostAddress();
                this.zm = System.currentTimeMillis() - currentTimeMillis;
            }
            this.zl.socket().connect(inetSocketAddress, lVar.ip());
            this.zl.socket().setSoTimeout(lVar.io());
            this.zl.socket().setTcpNoDelay(lVar.getTcpNoDelay());
            this.zo = com.baidu.adp.lib.util.k.hA();
            this.zp = com.baidu.adp.lib.util.k.hB();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            if (this.zl != null) {
                this.zl.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.zl != null) {
                return this.zl.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.zl.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.zl.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hR() {
            return this.zn;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long hS() {
            return this.zm;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hA() {
            return this.zo;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hB() {
            return this.zp;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int hT() {
            return 0;
        }
    }
}
