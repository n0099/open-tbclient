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
    private static com.baidu.adp.lib.webSocket.b anw;

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
        if (anw != null) {
            return anw.a(str, i, lVar);
        }
        if (z) {
            return new b(str, i, lVar);
        }
        return new c(str, i, lVar);
    }

    /* loaded from: classes.dex */
    static class c implements a {
        private String anA;
        private String anB;
        private Socket anC;
        private InputStream anD;
        private long any;
        private String anz;
        private byte[] mData;
        private OutputStream mOutputStream;

        public c(String str, int i, l lVar) throws Exception {
            this.anC = null;
            this.anD = null;
            this.mOutputStream = null;
            this.mData = null;
            this.any = 0L;
            this.anz = null;
            this.anA = null;
            this.anB = null;
            this.anC = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.anz = inetSocketAddress.getAddress().getHostAddress();
                this.any = System.currentTimeMillis() - currentTimeMillis;
            }
            this.anC.connect(inetSocketAddress, lVar.pN());
            this.anC.setSoTimeout(lVar.pM());
            this.anC.setTcpNoDelay(lVar.getTcpNoDelay());
            this.anD = this.anC.getInputStream();
            this.mOutputStream = this.anC.getOutputStream();
            this.mData = new byte[1024];
            this.anA = com.baidu.adp.lib.util.l.pa();
            this.anB = com.baidu.adp.lib.util.l.pb();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            try {
                this.anD.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.anC != null) {
                try {
                    this.anC.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.anC != null) {
                return this.anC.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.anD.read(this.mData);
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
            return this.anz;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long pr() {
            return this.any;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String pa() {
            return this.anA;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String pb() {
            return this.anB;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int ps() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private String anA;
        private String anB;
        private SocketChannel anx;
        private long any;
        private String anz;

        public b(String str, int i, l lVar) throws Exception {
            this.anx = null;
            this.any = 0L;
            this.anz = null;
            this.anA = null;
            this.anB = null;
            this.anx = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.anz = inetSocketAddress.getAddress().getHostAddress();
                this.any = System.currentTimeMillis() - currentTimeMillis;
            }
            this.anx.socket().connect(inetSocketAddress, lVar.pN());
            this.anx.socket().setSoTimeout(lVar.pM());
            this.anx.socket().setTcpNoDelay(lVar.getTcpNoDelay());
            this.anA = com.baidu.adp.lib.util.l.pa();
            this.anB = com.baidu.adp.lib.util.l.pb();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            if (this.anx != null) {
                this.anx.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.anx != null) {
                return this.anx.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.anx.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.anx.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String pq() {
            return this.anz;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long pr() {
            return this.any;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String pa() {
            return this.anA;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String pb() {
            return this.anB;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int ps() {
            return 0;
        }
    }
}
