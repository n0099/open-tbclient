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
    private static com.baidu.adp.lib.webSocket.b zo;

    /* loaded from: classes.dex */
    public interface a {
        void close();

        boolean isConnected();

        String jf();

        String jg();

        String jw();

        long jx();

        int jy();

        int read(ByteBuffer byteBuffer);

        int write(ByteBuffer byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(String str, int i, n nVar, boolean z) {
        if (zo != null) {
            return zo.a(str, i, nVar);
        }
        if (z) {
            return new b(str, i, nVar);
        }
        return new c(str, i, nVar);
    }

    /* loaded from: classes.dex */
    static class c implements a {
        private byte[] mData;
        private OutputStream mOutputStream;
        private long zq;
        private String zr;
        private String zs;
        private String zt;
        private Socket zu;
        private InputStream zv;

        public c(String str, int i, n nVar) {
            this.zu = null;
            this.zv = null;
            this.mOutputStream = null;
            this.mData = null;
            this.zq = 0L;
            this.zr = null;
            this.zs = null;
            this.zt = null;
            this.zu = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.zr = inetSocketAddress.getAddress().getHostAddress();
                this.zq = System.currentTimeMillis() - currentTimeMillis;
            }
            this.zu.connect(inetSocketAddress, nVar.jT());
            this.zu.setSoTimeout(nVar.jS());
            this.zu.setTcpNoDelay(nVar.getTcpNoDelay());
            this.zv = this.zu.getInputStream();
            this.mOutputStream = this.zu.getOutputStream();
            this.mData = new byte[1024];
            this.zs = com.baidu.adp.lib.util.k.jf();
            this.zt = com.baidu.adp.lib.util.k.jg();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() {
            try {
                this.zv.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.zu != null) {
                try {
                    this.zu.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.zu != null) {
                return this.zu.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) {
            int read = this.zv.read(this.mData);
            if (read > 0) {
                byteBuffer.put(this.mData, 0, read);
            }
            return read;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (remaining > 0) {
                byte[] bArr = new byte[remaining];
                byteBuffer.get(bArr);
                this.mOutputStream.write(bArr);
            }
            return remaining;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jw() {
            return this.zr;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long jx() {
            return this.zq;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jf() {
            return this.zs;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jg() {
            return this.zt;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int jy() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel zp;
        private long zq;
        private String zr;
        private String zs;
        private String zt;

        public b(String str, int i, n nVar) {
            this.zp = null;
            this.zq = 0L;
            this.zr = null;
            this.zs = null;
            this.zt = null;
            this.zp = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.zr = inetSocketAddress.getAddress().getHostAddress();
                this.zq = System.currentTimeMillis() - currentTimeMillis;
            }
            this.zp.socket().connect(inetSocketAddress, nVar.jT());
            this.zp.socket().setSoTimeout(nVar.jS());
            this.zp.socket().setTcpNoDelay(nVar.getTcpNoDelay());
            this.zs = com.baidu.adp.lib.util.k.jf();
            this.zt = com.baidu.adp.lib.util.k.jg();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() {
            if (this.zp != null) {
                this.zp.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.zp != null) {
                return this.zp.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) {
            return this.zp.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) {
            return this.zp.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jw() {
            return this.zr;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long jx() {
            return this.zq;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jf() {
            return this.zs;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jg() {
            return this.zt;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int jy() {
            return 0;
        }
    }
}
