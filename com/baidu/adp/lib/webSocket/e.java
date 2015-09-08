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
    private static com.baidu.adp.lib.webSocket.b zn;

    /* loaded from: classes.dex */
    public interface a {
        void close();

        boolean isConnected();

        String jd();

        String je();

        String ju();

        long jv();

        int jw();

        int read(ByteBuffer byteBuffer);

        int write(ByteBuffer byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(String str, int i, n nVar, boolean z) {
        if (zn != null) {
            return zn.a(str, i, nVar);
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
        private long zp;
        private String zq;
        private String zr;
        private String zs;
        private Socket zt;
        private InputStream zu;

        public c(String str, int i, n nVar) {
            this.zt = null;
            this.zu = null;
            this.mOutputStream = null;
            this.mData = null;
            this.zp = 0L;
            this.zq = null;
            this.zr = null;
            this.zs = null;
            this.zt = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.zq = inetSocketAddress.getAddress().getHostAddress();
                this.zp = System.currentTimeMillis() - currentTimeMillis;
            }
            this.zt.connect(inetSocketAddress, nVar.jR());
            this.zt.setSoTimeout(nVar.jQ());
            this.zt.setTcpNoDelay(nVar.getTcpNoDelay());
            this.zu = this.zt.getInputStream();
            this.mOutputStream = this.zt.getOutputStream();
            this.mData = new byte[1024];
            this.zr = com.baidu.adp.lib.util.k.jd();
            this.zs = com.baidu.adp.lib.util.k.je();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() {
            try {
                this.zu.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.zt != null) {
                try {
                    this.zt.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.zt != null) {
                return this.zt.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) {
            int read = this.zu.read(this.mData);
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
        public String ju() {
            return this.zq;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long jv() {
            return this.zp;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jd() {
            return this.zr;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String je() {
            return this.zs;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int jw() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel zo;
        private long zp;
        private String zq;
        private String zr;
        private String zs;

        public b(String str, int i, n nVar) {
            this.zo = null;
            this.zp = 0L;
            this.zq = null;
            this.zr = null;
            this.zs = null;
            this.zo = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.zq = inetSocketAddress.getAddress().getHostAddress();
                this.zp = System.currentTimeMillis() - currentTimeMillis;
            }
            this.zo.socket().connect(inetSocketAddress, nVar.jR());
            this.zo.socket().setSoTimeout(nVar.jQ());
            this.zo.socket().setTcpNoDelay(nVar.getTcpNoDelay());
            this.zr = com.baidu.adp.lib.util.k.jd();
            this.zs = com.baidu.adp.lib.util.k.je();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() {
            if (this.zo != null) {
                this.zo.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.zo != null) {
                return this.zo.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) {
            return this.zo.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) {
            return this.zo.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String ju() {
            return this.zq;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long jv() {
            return this.zp;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jd() {
            return this.zr;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String je() {
            return this.zs;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int jw() {
            return 0;
        }
    }
}
