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
    private static com.baidu.adp.lib.webSocket.b zm;

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
        if (zm != null) {
            return zm.a(str, i, lVar);
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
        private long zo;
        private String zp;
        private String zq;
        private String zr;
        private Socket zs;
        private InputStream zt;

        public c(String str, int i, l lVar) throws Exception {
            this.zs = null;
            this.zt = null;
            this.mOutputStream = null;
            this.mData = null;
            this.zo = 0L;
            this.zp = null;
            this.zq = null;
            this.zr = null;
            this.zs = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.zp = inetSocketAddress.getAddress().getHostAddress();
                this.zo = System.currentTimeMillis() - currentTimeMillis;
            }
            this.zs.connect(inetSocketAddress, lVar.io());
            this.zs.setSoTimeout(lVar.in());
            this.zs.setTcpNoDelay(lVar.getTcpNoDelay());
            this.zt = this.zs.getInputStream();
            this.mOutputStream = this.zs.getOutputStream();
            this.mData = new byte[1024];
            this.zq = com.baidu.adp.lib.util.l.hz();
            this.zr = com.baidu.adp.lib.util.l.hA();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            try {
                this.zt.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.zs != null) {
                try {
                    this.zs.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.zs != null) {
                return this.zs.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.zt.read(this.mData);
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
            return this.zp;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long hR() {
            return this.zo;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hz() {
            return this.zq;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hA() {
            return this.zr;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int hS() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel zn;
        private long zo;
        private String zp;
        private String zq;
        private String zr;

        public b(String str, int i, l lVar) throws Exception {
            this.zn = null;
            this.zo = 0L;
            this.zp = null;
            this.zq = null;
            this.zr = null;
            this.zn = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.zp = inetSocketAddress.getAddress().getHostAddress();
                this.zo = System.currentTimeMillis() - currentTimeMillis;
            }
            this.zn.socket().connect(inetSocketAddress, lVar.io());
            this.zn.socket().setSoTimeout(lVar.in());
            this.zn.socket().setTcpNoDelay(lVar.getTcpNoDelay());
            this.zq = com.baidu.adp.lib.util.l.hz();
            this.zr = com.baidu.adp.lib.util.l.hA();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            if (this.zn != null) {
                this.zn.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.zn != null) {
                return this.zn.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.zn.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.zn.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hQ() {
            return this.zp;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long hR() {
            return this.zo;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hz() {
            return this.zq;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hA() {
            return this.zr;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int hS() {
            return 0;
        }
    }
}
