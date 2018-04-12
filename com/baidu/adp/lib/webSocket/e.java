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
    private static com.baidu.adp.lib.webSocket.b xU;

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
        if (xU != null) {
            return xU.a(str, i, lVar);
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
        private long xW;
        private String xX;
        private String xY;
        private String xZ;
        private Socket ya;
        private InputStream yb;

        public c(String str, int i, l lVar) throws Exception {
            this.ya = null;
            this.yb = null;
            this.mOutputStream = null;
            this.mData = null;
            this.xW = 0L;
            this.xX = null;
            this.xY = null;
            this.xZ = null;
            this.ya = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.xX = inetSocketAddress.getAddress().getHostAddress();
                this.xW = System.currentTimeMillis() - currentTimeMillis;
            }
            this.ya.connect(inetSocketAddress, lVar.hT());
            this.ya.setSoTimeout(lVar.hS());
            this.ya.setTcpNoDelay(lVar.getTcpNoDelay());
            this.yb = this.ya.getInputStream();
            this.mOutputStream = this.ya.getOutputStream();
            this.mData = new byte[1024];
            this.xY = com.baidu.adp.lib.util.l.hh();
            this.xZ = com.baidu.adp.lib.util.l.hi();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            try {
                this.yb.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.ya != null) {
                try {
                    this.ya.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.ya != null) {
                return this.ya.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.yb.read(this.mData);
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
            return this.xX;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long hy() {
            return this.xW;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hh() {
            return this.xY;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hi() {
            return this.xZ;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int hz() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel xV;
        private long xW;
        private String xX;
        private String xY;
        private String xZ;

        public b(String str, int i, l lVar) throws Exception {
            this.xV = null;
            this.xW = 0L;
            this.xX = null;
            this.xY = null;
            this.xZ = null;
            this.xV = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.xX = inetSocketAddress.getAddress().getHostAddress();
                this.xW = System.currentTimeMillis() - currentTimeMillis;
            }
            this.xV.socket().connect(inetSocketAddress, lVar.hT());
            this.xV.socket().setSoTimeout(lVar.hS());
            this.xV.socket().setTcpNoDelay(lVar.getTcpNoDelay());
            this.xY = com.baidu.adp.lib.util.l.hh();
            this.xZ = com.baidu.adp.lib.util.l.hi();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            if (this.xV != null) {
                this.xV.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.xV != null) {
                return this.xV.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.xV.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.xV.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hx() {
            return this.xX;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long hy() {
            return this.xW;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hh() {
            return this.xY;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hi() {
            return this.xZ;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int hz() {
            return 0;
        }
    }
}
