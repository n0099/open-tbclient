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
    private static com.baidu.adp.lib.webSocket.b xT;

    /* loaded from: classes.dex */
    public interface a {
        void close() throws IOException;

        String hh();

        String hi();

        String hx();

        long hy();

        int hz();

        boolean isConnected();

        int read(ByteBuffer byteBuffer) throws Exception;

        int write(ByteBuffer byteBuffer) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(String str, int i, l lVar, boolean z) throws Exception {
        if (xT != null) {
            return xT.a(str, i, lVar);
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
        private long xV;
        private String xW;
        private String xX;
        private String xY;
        private Socket xZ;
        private InputStream ya;

        public c(String str, int i, l lVar) throws Exception {
            this.xZ = null;
            this.ya = null;
            this.mOutputStream = null;
            this.mData = null;
            this.xV = 0L;
            this.xW = null;
            this.xX = null;
            this.xY = null;
            this.xZ = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.xW = inetSocketAddress.getAddress().getHostAddress();
                this.xV = System.currentTimeMillis() - currentTimeMillis;
            }
            this.xZ.connect(inetSocketAddress, lVar.hT());
            this.xZ.setSoTimeout(lVar.hS());
            this.xZ.setTcpNoDelay(lVar.getTcpNoDelay());
            this.ya = this.xZ.getInputStream();
            this.mOutputStream = this.xZ.getOutputStream();
            this.mData = new byte[1024];
            this.xX = com.baidu.adp.lib.util.l.hh();
            this.xY = com.baidu.adp.lib.util.l.hi();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            try {
                this.ya.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.xZ != null) {
                try {
                    this.xZ.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.xZ != null) {
                return this.xZ.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.ya.read(this.mData);
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
        public String hx() {
            return this.xW;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long hy() {
            return this.xV;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hh() {
            return this.xX;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hi() {
            return this.xY;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int hz() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel xU;
        private long xV;
        private String xW;
        private String xX;
        private String xY;

        public b(String str, int i, l lVar) throws Exception {
            this.xU = null;
            this.xV = 0L;
            this.xW = null;
            this.xX = null;
            this.xY = null;
            this.xU = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.xW = inetSocketAddress.getAddress().getHostAddress();
                this.xV = System.currentTimeMillis() - currentTimeMillis;
            }
            this.xU.socket().connect(inetSocketAddress, lVar.hT());
            this.xU.socket().setSoTimeout(lVar.hS());
            this.xU.socket().setTcpNoDelay(lVar.getTcpNoDelay());
            this.xX = com.baidu.adp.lib.util.l.hh();
            this.xY = com.baidu.adp.lib.util.l.hi();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            if (this.xU != null) {
                this.xU.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.xU != null) {
                return this.xU.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.xU.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.xU.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hx() {
            return this.xW;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long hy() {
            return this.xV;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hh() {
            return this.xX;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hi() {
            return this.xY;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int hz() {
            return 0;
        }
    }
}
