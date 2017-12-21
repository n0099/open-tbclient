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
    private static com.baidu.adp.lib.webSocket.b zl;

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
        if (zl != null) {
            return zl.a(str, i, lVar);
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
        private long zn;
        private String zo;
        private String zp;
        private String zq;
        private Socket zr;
        private InputStream zs;

        public c(String str, int i, l lVar) throws Exception {
            this.zr = null;
            this.zs = null;
            this.mOutputStream = null;
            this.mData = null;
            this.zn = 0L;
            this.zo = null;
            this.zp = null;
            this.zq = null;
            this.zr = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.zo = inetSocketAddress.getAddress().getHostAddress();
                this.zn = System.currentTimeMillis() - currentTimeMillis;
            }
            this.zr.connect(inetSocketAddress, lVar.io());
            this.zr.setSoTimeout(lVar.in());
            this.zr.setTcpNoDelay(lVar.getTcpNoDelay());
            this.zs = this.zr.getInputStream();
            this.mOutputStream = this.zr.getOutputStream();
            this.mData = new byte[1024];
            this.zp = com.baidu.adp.lib.util.l.hz();
            this.zq = com.baidu.adp.lib.util.l.hA();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            try {
                this.zs.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.zr != null) {
                try {
                    this.zr.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.zr != null) {
                return this.zr.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.zs.read(this.mData);
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
        public String hQ() {
            return this.zo;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long hR() {
            return this.zn;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hz() {
            return this.zp;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hA() {
            return this.zq;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int hS() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel zm;
        private long zn;
        private String zo;
        private String zp;
        private String zq;

        public b(String str, int i, l lVar) throws Exception {
            this.zm = null;
            this.zn = 0L;
            this.zo = null;
            this.zp = null;
            this.zq = null;
            this.zm = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.zo = inetSocketAddress.getAddress().getHostAddress();
                this.zn = System.currentTimeMillis() - currentTimeMillis;
            }
            this.zm.socket().connect(inetSocketAddress, lVar.io());
            this.zm.socket().setSoTimeout(lVar.in());
            this.zm.socket().setTcpNoDelay(lVar.getTcpNoDelay());
            this.zp = com.baidu.adp.lib.util.l.hz();
            this.zq = com.baidu.adp.lib.util.l.hA();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            if (this.zm != null) {
                this.zm.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.zm != null) {
                return this.zm.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.zm.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.zm.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hQ() {
            return this.zo;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long hR() {
            return this.zn;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hz() {
            return this.zp;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hA() {
            return this.zq;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int hS() {
            return 0;
        }
    }
}
