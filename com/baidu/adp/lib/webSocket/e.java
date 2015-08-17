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
    private static com.baidu.adp.lib.webSocket.b zp;

    /* loaded from: classes.dex */
    public interface a {
        void close();

        boolean isConnected();

        String jg();

        String jh();

        String jx();

        long jy();

        int jz();

        int read(ByteBuffer byteBuffer);

        int write(ByteBuffer byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(String str, int i, n nVar, boolean z) {
        if (zp != null) {
            return zp.a(str, i, nVar);
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
        private long zr;
        private String zs;
        private String zt;
        private String zu;
        private Socket zv;
        private InputStream zw;

        public c(String str, int i, n nVar) {
            this.zv = null;
            this.zw = null;
            this.mOutputStream = null;
            this.mData = null;
            this.zr = 0L;
            this.zs = null;
            this.zt = null;
            this.zu = null;
            this.zv = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.zs = inetSocketAddress.getAddress().getHostAddress();
                this.zr = System.currentTimeMillis() - currentTimeMillis;
            }
            this.zv.connect(inetSocketAddress, nVar.jU());
            this.zv.setSoTimeout(nVar.jT());
            this.zv.setTcpNoDelay(nVar.getTcpNoDelay());
            this.zw = this.zv.getInputStream();
            this.mOutputStream = this.zv.getOutputStream();
            this.mData = new byte[1024];
            this.zt = com.baidu.adp.lib.util.k.jg();
            this.zu = com.baidu.adp.lib.util.k.jh();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() {
            try {
                this.zw.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.zv != null) {
                try {
                    this.zv.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.zv != null) {
                return this.zv.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) {
            int read = this.zw.read(this.mData);
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
        public String jx() {
            return this.zs;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long jy() {
            return this.zr;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jg() {
            return this.zt;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jh() {
            return this.zu;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int jz() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel zq;
        private long zr;
        private String zs;
        private String zt;
        private String zu;

        public b(String str, int i, n nVar) {
            this.zq = null;
            this.zr = 0L;
            this.zs = null;
            this.zt = null;
            this.zu = null;
            this.zq = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.zs = inetSocketAddress.getAddress().getHostAddress();
                this.zr = System.currentTimeMillis() - currentTimeMillis;
            }
            this.zq.socket().connect(inetSocketAddress, nVar.jU());
            this.zq.socket().setSoTimeout(nVar.jT());
            this.zq.socket().setTcpNoDelay(nVar.getTcpNoDelay());
            this.zt = com.baidu.adp.lib.util.k.jg();
            this.zu = com.baidu.adp.lib.util.k.jh();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() {
            if (this.zq != null) {
                this.zq.close();
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
        public int read(ByteBuffer byteBuffer) {
            return this.zq.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) {
            return this.zq.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jx() {
            return this.zs;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long jy() {
            return this.zr;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jg() {
            return this.zt;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jh() {
            return this.zu;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int jz() {
            return 0;
        }
    }
}
