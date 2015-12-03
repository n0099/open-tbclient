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
    private static com.baidu.adp.lib.webSocket.b zu;

    /* loaded from: classes.dex */
    public interface a {
        void close();

        boolean isConnected();

        String jh();

        String ji();

        String jx();

        long jy();

        int jz();

        int read(ByteBuffer byteBuffer);

        int write(ByteBuffer byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(String str, int i, n nVar, boolean z) {
        if (zu != null) {
            return zu.a(str, i, nVar);
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
        private Socket zA;
        private InputStream zB;
        private long zw;
        private String zx;
        private String zy;
        private String zz;

        public c(String str, int i, n nVar) {
            this.zA = null;
            this.zB = null;
            this.mOutputStream = null;
            this.mData = null;
            this.zw = 0L;
            this.zx = null;
            this.zy = null;
            this.zz = null;
            this.zA = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.zx = inetSocketAddress.getAddress().getHostAddress();
                this.zw = System.currentTimeMillis() - currentTimeMillis;
            }
            this.zA.connect(inetSocketAddress, nVar.jU());
            this.zA.setSoTimeout(nVar.jT());
            this.zA.setTcpNoDelay(nVar.getTcpNoDelay());
            this.zB = this.zA.getInputStream();
            this.mOutputStream = this.zA.getOutputStream();
            this.mData = new byte[1024];
            this.zy = com.baidu.adp.lib.util.k.jh();
            this.zz = com.baidu.adp.lib.util.k.ji();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() {
            try {
                this.zB.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.zA != null) {
                try {
                    this.zA.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.zA != null) {
                return this.zA.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) {
            int read = this.zB.read(this.mData);
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
            return this.zx;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long jy() {
            return this.zw;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jh() {
            return this.zy;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String ji() {
            return this.zz;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int jz() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel zv;
        private long zw;
        private String zx;
        private String zy;
        private String zz;

        public b(String str, int i, n nVar) {
            this.zv = null;
            this.zw = 0L;
            this.zx = null;
            this.zy = null;
            this.zz = null;
            this.zv = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.zx = inetSocketAddress.getAddress().getHostAddress();
                this.zw = System.currentTimeMillis() - currentTimeMillis;
            }
            this.zv.socket().connect(inetSocketAddress, nVar.jU());
            this.zv.socket().setSoTimeout(nVar.jT());
            this.zv.socket().setTcpNoDelay(nVar.getTcpNoDelay());
            this.zy = com.baidu.adp.lib.util.k.jh();
            this.zz = com.baidu.adp.lib.util.k.ji();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() {
            if (this.zv != null) {
                this.zv.close();
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
            return this.zv.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) {
            return this.zv.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jx() {
            return this.zx;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long jy() {
            return this.zw;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jh() {
            return this.zy;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String ji() {
            return this.zz;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int jz() {
            return 0;
        }
    }
}
