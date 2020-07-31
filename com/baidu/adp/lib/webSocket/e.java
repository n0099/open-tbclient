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
    private static com.baidu.adp.lib.webSocket.b OB;

    /* loaded from: classes.dex */
    public interface a {
        void close() throws IOException;

        String getLocalDns();

        String getLocalDnsBak();

        boolean isConnected();

        String mU();

        long mV();

        int mW();

        int read(ByteBuffer byteBuffer) throws Exception;

        int write(ByteBuffer byteBuffer) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(String str, int i, l lVar, boolean z) throws Exception {
        if (OB != null) {
            return OB.a(str, i, lVar);
        }
        if (z) {
            return new b(str, i, lVar);
        }
        return new c(str, i, lVar);
    }

    /* loaded from: classes.dex */
    static class c implements a {
        private long OD;
        private String OE;
        private String OF;
        private String OG;
        private byte[] mData;
        private InputStream mInputStream;
        private OutputStream mOutputStream;
        private Socket mSocket;

        public c(String str, int i, l lVar) throws Exception {
            this.mSocket = null;
            this.mInputStream = null;
            this.mOutputStream = null;
            this.mData = null;
            this.OD = 0L;
            this.OE = null;
            this.OF = null;
            this.OG = null;
            this.mSocket = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.OE = inetSocketAddress.getAddress().getHostAddress();
                this.OD = System.currentTimeMillis() - currentTimeMillis;
            }
            this.mSocket.connect(inetSocketAddress, lVar.np());
            this.mSocket.setSoTimeout(lVar.no());
            this.mSocket.setTcpNoDelay(lVar.getTcpNoDelay());
            this.mInputStream = this.mSocket.getInputStream();
            this.mOutputStream = this.mSocket.getOutputStream();
            this.mData = new byte[1024];
            this.OF = com.baidu.adp.lib.util.l.getLocalDns();
            this.OG = com.baidu.adp.lib.util.l.getLocalDnsBak();
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
        public String mU() {
            return this.OE;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long mV() {
            return this.OD;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String getLocalDns() {
            return this.OF;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String getLocalDnsBak() {
            return this.OG;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int mW() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel OC;
        private long OD;
        private String OE;
        private String OF;
        private String OG;

        public b(String str, int i, l lVar) throws Exception {
            this.OC = null;
            this.OD = 0L;
            this.OE = null;
            this.OF = null;
            this.OG = null;
            this.OC = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.OE = inetSocketAddress.getAddress().getHostAddress();
                this.OD = System.currentTimeMillis() - currentTimeMillis;
            }
            this.OC.socket().connect(inetSocketAddress, lVar.np());
            this.OC.socket().setSoTimeout(lVar.no());
            this.OC.socket().setTcpNoDelay(lVar.getTcpNoDelay());
            this.OF = com.baidu.adp.lib.util.l.getLocalDns();
            this.OG = com.baidu.adp.lib.util.l.getLocalDnsBak();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            if (this.OC != null) {
                this.OC.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.OC != null) {
                return this.OC.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.OC.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.OC.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String mU() {
            return this.OE;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long mV() {
            return this.OD;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String getLocalDns() {
            return this.OF;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String getLocalDnsBak() {
            return this.OG;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int mW() {
            return 0;
        }
    }
}
