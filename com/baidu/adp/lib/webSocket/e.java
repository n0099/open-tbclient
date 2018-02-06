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
    private static com.baidu.adp.lib.webSocket.b anx;

    /* loaded from: classes.dex */
    public interface a {
        void close() throws IOException;

        boolean isConnected();

        String pb();

        String pc();

        String pr();

        long ps();

        int pt();

        int read(ByteBuffer byteBuffer) throws Exception;

        int write(ByteBuffer byteBuffer) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(String str, int i, l lVar, boolean z) throws Exception {
        if (anx != null) {
            return anx.a(str, i, lVar);
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
        private String anC;
        private Socket anD;
        private InputStream anE;
        private long anz;
        private byte[] mData;
        private OutputStream mOutputStream;

        public c(String str, int i, l lVar) throws Exception {
            this.anD = null;
            this.anE = null;
            this.mOutputStream = null;
            this.mData = null;
            this.anz = 0L;
            this.anA = null;
            this.anB = null;
            this.anC = null;
            this.anD = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.anA = inetSocketAddress.getAddress().getHostAddress();
                this.anz = System.currentTimeMillis() - currentTimeMillis;
            }
            this.anD.connect(inetSocketAddress, lVar.pO());
            this.anD.setSoTimeout(lVar.pN());
            this.anD.setTcpNoDelay(lVar.getTcpNoDelay());
            this.anE = this.anD.getInputStream();
            this.mOutputStream = this.anD.getOutputStream();
            this.mData = new byte[1024];
            this.anB = com.baidu.adp.lib.util.l.pb();
            this.anC = com.baidu.adp.lib.util.l.pc();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            try {
                this.anE.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.anD != null) {
                try {
                    this.anD.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.anD != null) {
                return this.anD.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.anE.read(this.mData);
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
        public String pr() {
            return this.anA;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long ps() {
            return this.anz;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String pb() {
            return this.anB;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String pc() {
            return this.anC;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int pt() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private String anA;
        private String anB;
        private String anC;
        private SocketChannel any;
        private long anz;

        public b(String str, int i, l lVar) throws Exception {
            this.any = null;
            this.anz = 0L;
            this.anA = null;
            this.anB = null;
            this.anC = null;
            this.any = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.anA = inetSocketAddress.getAddress().getHostAddress();
                this.anz = System.currentTimeMillis() - currentTimeMillis;
            }
            this.any.socket().connect(inetSocketAddress, lVar.pO());
            this.any.socket().setSoTimeout(lVar.pN());
            this.any.socket().setTcpNoDelay(lVar.getTcpNoDelay());
            this.anB = com.baidu.adp.lib.util.l.pb();
            this.anC = com.baidu.adp.lib.util.l.pc();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            if (this.any != null) {
                this.any.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.any != null) {
                return this.any.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.any.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.any.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String pr() {
            return this.anA;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long ps() {
            return this.anz;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String pb() {
            return this.anB;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String pc() {
            return this.anC;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int pt() {
            return 0;
        }
    }
}
