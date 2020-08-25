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
    private static com.baidu.adp.lib.webSocket.b Ph;

    /* loaded from: classes.dex */
    public interface a {
        void close() throws IOException;

        String getLocalDns();

        String getLocalDnsBak();

        boolean isConnected();

        String ou();

        long ov();

        int ow();

        int read(ByteBuffer byteBuffer) throws Exception;

        int write(ByteBuffer byteBuffer) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(String str, int i, l lVar, boolean z) throws Exception {
        if (Ph != null) {
            return Ph.a(str, i, lVar);
        }
        if (z) {
            return new b(str, i, lVar);
        }
        return new c(str, i, lVar);
    }

    /* loaded from: classes.dex */
    static class c implements a {
        private long Pj;
        private String Pk;
        private String Pl;
        private String Pm;
        private byte[] mData;
        private InputStream mInputStream;
        private OutputStream mOutputStream;
        private Socket mSocket;

        public c(String str, int i, l lVar) throws Exception {
            this.mSocket = null;
            this.mInputStream = null;
            this.mOutputStream = null;
            this.mData = null;
            this.Pj = 0L;
            this.Pk = null;
            this.Pl = null;
            this.Pm = null;
            this.mSocket = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.Pk = inetSocketAddress.getAddress().getHostAddress();
                this.Pj = System.currentTimeMillis() - currentTimeMillis;
            }
            this.mSocket.connect(inetSocketAddress, lVar.oP());
            this.mSocket.setSoTimeout(lVar.oO());
            this.mSocket.setTcpNoDelay(lVar.getTcpNoDelay());
            this.mInputStream = this.mSocket.getInputStream();
            this.mOutputStream = this.mSocket.getOutputStream();
            this.mData = new byte[1024];
            this.Pl = com.baidu.adp.lib.util.l.getLocalDns();
            this.Pm = com.baidu.adp.lib.util.l.getLocalDnsBak();
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
        public String ou() {
            return this.Pk;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long ov() {
            return this.Pj;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String getLocalDns() {
            return this.Pl;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String getLocalDnsBak() {
            return this.Pm;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int ow() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel Pi;
        private long Pj;
        private String Pk;
        private String Pl;
        private String Pm;

        public b(String str, int i, l lVar) throws Exception {
            this.Pi = null;
            this.Pj = 0L;
            this.Pk = null;
            this.Pl = null;
            this.Pm = null;
            this.Pi = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.Pk = inetSocketAddress.getAddress().getHostAddress();
                this.Pj = System.currentTimeMillis() - currentTimeMillis;
            }
            this.Pi.socket().connect(inetSocketAddress, lVar.oP());
            this.Pi.socket().setSoTimeout(lVar.oO());
            this.Pi.socket().setTcpNoDelay(lVar.getTcpNoDelay());
            this.Pl = com.baidu.adp.lib.util.l.getLocalDns();
            this.Pm = com.baidu.adp.lib.util.l.getLocalDnsBak();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            if (this.Pi != null) {
                this.Pi.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.Pi != null) {
                return this.Pi.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.Pi.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.Pi.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String ou() {
            return this.Pk;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long ov() {
            return this.Pj;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String getLocalDns() {
            return this.Pl;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String getLocalDnsBak() {
            return this.Pm;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int ow() {
            return 0;
        }
    }
}
