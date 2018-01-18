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
    private static com.baidu.adp.lib.webSocket.b anv;

    /* loaded from: classes.dex */
    public interface a {
        void close() throws IOException;

        boolean isConnected();

        String pa();

        String pb();

        String pq();

        long pr();

        int ps();

        int read(ByteBuffer byteBuffer) throws Exception;

        int write(ByteBuffer byteBuffer) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(String str, int i, l lVar, boolean z) throws Exception {
        if (anv != null) {
            return anv.a(str, i, lVar);
        }
        if (z) {
            return new b(str, i, lVar);
        }
        return new c(str, i, lVar);
    }

    /* loaded from: classes.dex */
    static class c implements a {
        private String anA;
        private Socket anB;
        private InputStream anC;
        private long anx;
        private String any;
        private String anz;
        private byte[] mData;
        private OutputStream mOutputStream;

        public c(String str, int i, l lVar) throws Exception {
            this.anB = null;
            this.anC = null;
            this.mOutputStream = null;
            this.mData = null;
            this.anx = 0L;
            this.any = null;
            this.anz = null;
            this.anA = null;
            this.anB = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.any = inetSocketAddress.getAddress().getHostAddress();
                this.anx = System.currentTimeMillis() - currentTimeMillis;
            }
            this.anB.connect(inetSocketAddress, lVar.pN());
            this.anB.setSoTimeout(lVar.pM());
            this.anB.setTcpNoDelay(lVar.getTcpNoDelay());
            this.anC = this.anB.getInputStream();
            this.mOutputStream = this.anB.getOutputStream();
            this.mData = new byte[1024];
            this.anz = com.baidu.adp.lib.util.l.pa();
            this.anA = com.baidu.adp.lib.util.l.pb();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            try {
                this.anC.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.anB != null) {
                try {
                    this.anB.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.anB != null) {
                return this.anB.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.anC.read(this.mData);
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
        public String pq() {
            return this.any;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long pr() {
            return this.anx;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String pa() {
            return this.anz;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String pb() {
            return this.anA;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int ps() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private String anA;
        private SocketChannel anw;
        private long anx;
        private String any;
        private String anz;

        public b(String str, int i, l lVar) throws Exception {
            this.anw = null;
            this.anx = 0L;
            this.any = null;
            this.anz = null;
            this.anA = null;
            this.anw = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.any = inetSocketAddress.getAddress().getHostAddress();
                this.anx = System.currentTimeMillis() - currentTimeMillis;
            }
            this.anw.socket().connect(inetSocketAddress, lVar.pN());
            this.anw.socket().setSoTimeout(lVar.pM());
            this.anw.socket().setTcpNoDelay(lVar.getTcpNoDelay());
            this.anz = com.baidu.adp.lib.util.l.pa();
            this.anA = com.baidu.adp.lib.util.l.pb();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            if (this.anw != null) {
                this.anw.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.anw != null) {
                return this.anw.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.anw.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.anw.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String pq() {
            return this.any;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long pr() {
            return this.anx;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String pa() {
            return this.anz;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String pb() {
            return this.anA;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int ps() {
            return 0;
        }
    }
}
