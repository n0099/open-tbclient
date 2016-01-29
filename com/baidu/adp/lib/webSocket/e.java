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
    private static com.baidu.adp.lib.webSocket.b zE;

    /* loaded from: classes.dex */
    public interface a {
        void close();

        boolean isConnected();

        String jH();

        long jI();

        int jJ();

        String jr();

        String js();

        int read(ByteBuffer byteBuffer);

        int write(ByteBuffer byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(String str, int i, n nVar, boolean z) {
        if (zE != null) {
            return zE.a(str, i, nVar);
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
        private long zG;
        private String zH;
        private String zI;
        private String zJ;
        private Socket zK;
        private InputStream zL;

        public c(String str, int i, n nVar) {
            this.zK = null;
            this.zL = null;
            this.mOutputStream = null;
            this.mData = null;
            this.zG = 0L;
            this.zH = null;
            this.zI = null;
            this.zJ = null;
            this.zK = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.zH = inetSocketAddress.getAddress().getHostAddress();
                this.zG = System.currentTimeMillis() - currentTimeMillis;
            }
            this.zK.connect(inetSocketAddress, nVar.kf());
            this.zK.setSoTimeout(nVar.ke());
            this.zK.setTcpNoDelay(nVar.getTcpNoDelay());
            this.zL = this.zK.getInputStream();
            this.mOutputStream = this.zK.getOutputStream();
            this.mData = new byte[1024];
            this.zI = com.baidu.adp.lib.util.k.jr();
            this.zJ = com.baidu.adp.lib.util.k.js();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() {
            try {
                this.zL.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.zK != null) {
                try {
                    this.zK.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.zK != null) {
                return this.zK.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) {
            int read = this.zL.read(this.mData);
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
        public String jH() {
            return this.zH;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long jI() {
            return this.zG;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jr() {
            return this.zI;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String js() {
            return this.zJ;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int jJ() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel zF;
        private long zG;
        private String zH;
        private String zI;
        private String zJ;

        public b(String str, int i, n nVar) {
            this.zF = null;
            this.zG = 0L;
            this.zH = null;
            this.zI = null;
            this.zJ = null;
            this.zF = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.zH = inetSocketAddress.getAddress().getHostAddress();
                this.zG = System.currentTimeMillis() - currentTimeMillis;
            }
            this.zF.socket().connect(inetSocketAddress, nVar.kf());
            this.zF.socket().setSoTimeout(nVar.ke());
            this.zF.socket().setTcpNoDelay(nVar.getTcpNoDelay());
            this.zI = com.baidu.adp.lib.util.k.jr();
            this.zJ = com.baidu.adp.lib.util.k.js();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() {
            if (this.zF != null) {
                this.zF.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.zF != null) {
                return this.zF.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) {
            return this.zF.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) {
            return this.zF.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jH() {
            return this.zH;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long jI() {
            return this.zG;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jr() {
            return this.zI;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String js() {
            return this.zJ;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int jJ() {
            return 0;
        }
    }
}
