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
    private static com.baidu.adp.lib.webSocket.b uE;

    /* loaded from: classes.dex */
    public interface a {
        void close() throws IOException;

        String getLocalDns();

        String getLocalDnsBak();

        String hI();

        long hJ();

        int hK();

        boolean isConnected();

        int read(ByteBuffer byteBuffer) throws Exception;

        int write(ByteBuffer byteBuffer) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(String str, int i, l lVar, boolean z) throws Exception {
        if (uE != null) {
            return uE.a(str, i, lVar);
        }
        if (z) {
            return new b(str, i, lVar);
        }
        return new c(str, i, lVar);
    }

    /* loaded from: classes.dex */
    static class c implements a {
        private byte[] mData;
        private InputStream mInputStream;
        private OutputStream mOutputStream;
        private Socket mSocket;
        private long uG;
        private String uH;
        private String uI;
        private String uJ;

        public c(String str, int i, l lVar) throws Exception {
            this.mSocket = null;
            this.mInputStream = null;
            this.mOutputStream = null;
            this.mData = null;
            this.uG = 0L;
            this.uH = null;
            this.uI = null;
            this.uJ = null;
            this.mSocket = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.uH = inetSocketAddress.getAddress().getHostAddress();
                this.uG = System.currentTimeMillis() - currentTimeMillis;
            }
            this.mSocket.connect(inetSocketAddress, lVar.id());
            this.mSocket.setSoTimeout(lVar.ic());
            this.mSocket.setTcpNoDelay(lVar.getTcpNoDelay());
            this.mInputStream = this.mSocket.getInputStream();
            this.mOutputStream = this.mSocket.getOutputStream();
            this.mData = new byte[1024];
            this.uI = com.baidu.adp.lib.util.l.getLocalDns();
            this.uJ = com.baidu.adp.lib.util.l.getLocalDnsBak();
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
        public String hI() {
            return this.uH;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long hJ() {
            return this.uG;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String getLocalDns() {
            return this.uI;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String getLocalDnsBak() {
            return this.uJ;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int hK() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel uF;
        private long uG;
        private String uH;
        private String uI;
        private String uJ;

        public b(String str, int i, l lVar) throws Exception {
            this.uF = null;
            this.uG = 0L;
            this.uH = null;
            this.uI = null;
            this.uJ = null;
            this.uF = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.uH = inetSocketAddress.getAddress().getHostAddress();
                this.uG = System.currentTimeMillis() - currentTimeMillis;
            }
            this.uF.socket().connect(inetSocketAddress, lVar.id());
            this.uF.socket().setSoTimeout(lVar.ic());
            this.uF.socket().setTcpNoDelay(lVar.getTcpNoDelay());
            this.uI = com.baidu.adp.lib.util.l.getLocalDns();
            this.uJ = com.baidu.adp.lib.util.l.getLocalDnsBak();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            if (this.uF != null) {
                this.uF.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.uF != null) {
                return this.uF.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.uF.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.uF.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hI() {
            return this.uH;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long hJ() {
            return this.uG;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String getLocalDns() {
            return this.uI;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String getLocalDnsBak() {
            return this.uJ;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int hK() {
            return 0;
        }
    }
}
