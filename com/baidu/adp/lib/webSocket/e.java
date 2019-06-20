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
    private static com.baidu.adp.lib.webSocket.b EP;

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
        if (EP != null) {
            return EP.a(str, i, lVar);
        }
        if (z) {
            return new b(str, i, lVar);
        }
        return new c(str, i, lVar);
    }

    /* loaded from: classes.dex */
    static class c implements a {
        private long ES;
        private String ET;
        private String EU;
        private String EV;
        private Socket EW;
        private InputStream EX;
        private byte[] mData;
        private OutputStream mOutputStream;

        public c(String str, int i, l lVar) throws Exception {
            this.EW = null;
            this.EX = null;
            this.mOutputStream = null;
            this.mData = null;
            this.ES = 0L;
            this.ET = null;
            this.EU = null;
            this.EV = null;
            this.EW = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.ET = inetSocketAddress.getAddress().getHostAddress();
                this.ES = System.currentTimeMillis() - currentTimeMillis;
            }
            this.EW.connect(inetSocketAddress, lVar.kV());
            this.EW.setSoTimeout(lVar.kU());
            this.EW.setTcpNoDelay(lVar.getTcpNoDelay());
            this.EX = this.EW.getInputStream();
            this.mOutputStream = this.EW.getOutputStream();
            this.mData = new byte[1024];
            this.EU = com.baidu.adp.lib.util.l.kj();
            this.EV = com.baidu.adp.lib.util.l.kk();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            try {
                this.EX.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.EW != null) {
                try {
                    this.EW.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.EW != null) {
                return this.EW.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.EX.read(this.mData);
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
            return this.ET;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long kA() {
            return this.ES;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String kj() {
            return this.EU;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String kk() {
            return this.EV;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int kB() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel ER;
        private long ES;
        private String ET;
        private String EU;
        private String EV;

        public b(String str, int i, l lVar) throws Exception {
            this.ER = null;
            this.ES = 0L;
            this.ET = null;
            this.EU = null;
            this.EV = null;
            this.ER = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.ET = inetSocketAddress.getAddress().getHostAddress();
                this.ES = System.currentTimeMillis() - currentTimeMillis;
            }
            this.ER.socket().connect(inetSocketAddress, lVar.kV());
            this.ER.socket().setSoTimeout(lVar.kU());
            this.ER.socket().setTcpNoDelay(lVar.getTcpNoDelay());
            this.EU = com.baidu.adp.lib.util.l.kj();
            this.EV = com.baidu.adp.lib.util.l.kk();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            if (this.ER != null) {
                this.ER.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.ER != null) {
                return this.ER.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.ER.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.ER.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String kz() {
            return this.ET;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long kA() {
            return this.ES;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String kj() {
            return this.EU;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String kk() {
            return this.EV;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int kB() {
            return 0;
        }
    }
}
