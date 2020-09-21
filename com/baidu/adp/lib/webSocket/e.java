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
    private static com.baidu.adp.lib.webSocket.b Pz;

    /* loaded from: classes.dex */
    public interface a {
        void close() throws IOException;

        String getLocalDns();

        String getLocalDnsBak();

        boolean isConnected();

        long oA();

        int oB();

        String oz();

        int read(ByteBuffer byteBuffer) throws Exception;

        int write(ByteBuffer byteBuffer) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(String str, int i, l lVar, boolean z) throws Exception {
        if (Pz != null) {
            return Pz.a(str, i, lVar);
        }
        if (z) {
            return new b(str, i, lVar);
        }
        return new c(str, i, lVar);
    }

    /* loaded from: classes.dex */
    static class c implements a {
        private long PE;
        private String PF;
        private String PG;
        private String PH;
        private byte[] mData;
        private InputStream mInputStream;
        private OutputStream mOutputStream;
        private Socket mSocket;

        public c(String str, int i, l lVar) throws Exception {
            this.mSocket = null;
            this.mInputStream = null;
            this.mOutputStream = null;
            this.mData = null;
            this.PE = 0L;
            this.PF = null;
            this.PG = null;
            this.PH = null;
            this.mSocket = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.PF = inetSocketAddress.getAddress().getHostAddress();
                this.PE = System.currentTimeMillis() - currentTimeMillis;
            }
            this.mSocket.connect(inetSocketAddress, lVar.oU());
            this.mSocket.setSoTimeout(lVar.oT());
            this.mSocket.setTcpNoDelay(lVar.getTcpNoDelay());
            this.mInputStream = this.mSocket.getInputStream();
            this.mOutputStream = this.mSocket.getOutputStream();
            this.mData = new byte[1024];
            this.PG = com.baidu.adp.lib.util.l.getLocalDns();
            this.PH = com.baidu.adp.lib.util.l.getLocalDnsBak();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            try {
                this.mInputStream.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.mSocket != null) {
                try {
                    this.mSocket.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.mSocket != null) {
                return this.mSocket.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.mInputStream.read(this.mData);
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
        public String oz() {
            return this.PF;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long oA() {
            return this.PE;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String getLocalDns() {
            return this.PG;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String getLocalDnsBak() {
            return this.PH;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int oB() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel PD;
        private long PE;
        private String PF;
        private String PG;
        private String PH;

        public b(String str, int i, l lVar) throws Exception {
            this.PD = null;
            this.PE = 0L;
            this.PF = null;
            this.PG = null;
            this.PH = null;
            this.PD = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.PF = inetSocketAddress.getAddress().getHostAddress();
                this.PE = System.currentTimeMillis() - currentTimeMillis;
            }
            this.PD.socket().connect(inetSocketAddress, lVar.oU());
            this.PD.socket().setSoTimeout(lVar.oT());
            this.PD.socket().setTcpNoDelay(lVar.getTcpNoDelay());
            this.PG = com.baidu.adp.lib.util.l.getLocalDns();
            this.PH = com.baidu.adp.lib.util.l.getLocalDnsBak();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            if (this.PD != null) {
                this.PD.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.PD != null) {
                return this.PD.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.PD.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.PD.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String oz() {
            return this.PF;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long oA() {
            return this.PE;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String getLocalDns() {
            return this.PG;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String getLocalDnsBak() {
            return this.PH;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int oB() {
            return 0;
        }
    }
}
