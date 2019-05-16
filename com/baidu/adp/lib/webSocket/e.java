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
    private static com.baidu.adp.lib.webSocket.b ER;

    /* loaded from: classes.dex */
    public interface a {
        void close() throws IOException;

        boolean isConnected();

        long kA();

        int kB();

        String kj();

        String kk();

        String kz();

        int read(ByteBuffer byteBuffer) throws Exception;

        int write(ByteBuffer byteBuffer) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(String str, int i, l lVar, boolean z) throws Exception {
        if (ER != null) {
            return ER.a(str, i, lVar);
        }
        if (z) {
            return new b(str, i, lVar);
        }
        return new c(str, i, lVar);
    }

    /* loaded from: classes.dex */
    static class c implements a {
        private long ET;
        private String EU;
        private String EV;
        private String EW;
        private Socket EX;
        private InputStream EY;
        private byte[] mData;
        private OutputStream mOutputStream;

        public c(String str, int i, l lVar) throws Exception {
            this.EX = null;
            this.EY = null;
            this.mOutputStream = null;
            this.mData = null;
            this.ET = 0L;
            this.EU = null;
            this.EV = null;
            this.EW = null;
            this.EX = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.EU = inetSocketAddress.getAddress().getHostAddress();
                this.ET = System.currentTimeMillis() - currentTimeMillis;
            }
            this.EX.connect(inetSocketAddress, lVar.kV());
            this.EX.setSoTimeout(lVar.kU());
            this.EX.setTcpNoDelay(lVar.getTcpNoDelay());
            this.EY = this.EX.getInputStream();
            this.mOutputStream = this.EX.getOutputStream();
            this.mData = new byte[1024];
            this.EV = com.baidu.adp.lib.util.l.kj();
            this.EW = com.baidu.adp.lib.util.l.kk();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            try {
                this.EY.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.EX != null) {
                try {
                    this.EX.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.EX != null) {
                return this.EX.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.EY.read(this.mData);
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
        public String kz() {
            return this.EU;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long kA() {
            return this.ET;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String kj() {
            return this.EV;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String kk() {
            return this.EW;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int kB() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel ES;
        private long ET;
        private String EU;
        private String EV;
        private String EW;

        public b(String str, int i, l lVar) throws Exception {
            this.ES = null;
            this.ET = 0L;
            this.EU = null;
            this.EV = null;
            this.EW = null;
            this.ES = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.EU = inetSocketAddress.getAddress().getHostAddress();
                this.ET = System.currentTimeMillis() - currentTimeMillis;
            }
            this.ES.socket().connect(inetSocketAddress, lVar.kV());
            this.ES.socket().setSoTimeout(lVar.kU());
            this.ES.socket().setTcpNoDelay(lVar.getTcpNoDelay());
            this.EV = com.baidu.adp.lib.util.l.kj();
            this.EW = com.baidu.adp.lib.util.l.kk();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            if (this.ES != null) {
                this.ES.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.ES != null) {
                return this.ES.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.ES.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.ES.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String kz() {
            return this.EU;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long kA() {
            return this.ET;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String kj() {
            return this.EV;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String kk() {
            return this.EW;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int kB() {
            return 0;
        }
    }
}
