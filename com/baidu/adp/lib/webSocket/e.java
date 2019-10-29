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
    private static com.baidu.adp.lib.webSocket.b sh;

    /* loaded from: classes.dex */
    public interface a {
        void close() throws IOException;

        String getLocalDns();

        String getLocalDnsBak();

        String hn();

        long ho();

        int hp();

        boolean isConnected();

        int read(ByteBuffer byteBuffer) throws Exception;

        int write(ByteBuffer byteBuffer) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(String str, int i, l lVar, boolean z) throws Exception {
        if (sh != null) {
            return sh.a(str, i, lVar);
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
        private long sj;
        private String sk;
        private String sl;
        private String sm;

        public c(String str, int i, l lVar) throws Exception {
            this.mSocket = null;
            this.mInputStream = null;
            this.mOutputStream = null;
            this.mData = null;
            this.sj = 0L;
            this.sk = null;
            this.sl = null;
            this.sm = null;
            this.mSocket = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.sk = inetSocketAddress.getAddress().getHostAddress();
                this.sj = System.currentTimeMillis() - currentTimeMillis;
            }
            this.mSocket.connect(inetSocketAddress, lVar.hK());
            this.mSocket.setSoTimeout(lVar.hJ());
            this.mSocket.setTcpNoDelay(lVar.hI());
            this.mInputStream = this.mSocket.getInputStream();
            this.mOutputStream = this.mSocket.getOutputStream();
            this.mData = new byte[1024];
            this.sl = com.baidu.adp.lib.util.l.getLocalDns();
            this.sm = com.baidu.adp.lib.util.l.getLocalDnsBak();
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
        public String hn() {
            return this.sk;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long ho() {
            return this.sj;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String getLocalDns() {
            return this.sl;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String getLocalDnsBak() {
            return this.sm;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int hp() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel si;
        private long sj;
        private String sk;
        private String sl;
        private String sm;

        public b(String str, int i, l lVar) throws Exception {
            this.si = null;
            this.sj = 0L;
            this.sk = null;
            this.sl = null;
            this.sm = null;
            this.si = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.sk = inetSocketAddress.getAddress().getHostAddress();
                this.sj = System.currentTimeMillis() - currentTimeMillis;
            }
            this.si.socket().connect(inetSocketAddress, lVar.hK());
            this.si.socket().setSoTimeout(lVar.hJ());
            this.si.socket().setTcpNoDelay(lVar.hI());
            this.sl = com.baidu.adp.lib.util.l.getLocalDns();
            this.sm = com.baidu.adp.lib.util.l.getLocalDnsBak();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            if (this.si != null) {
                this.si.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.si != null) {
                return this.si.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.si.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.si.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String hn() {
            return this.sk;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long ho() {
            return this.sj;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String getLocalDns() {
            return this.sl;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String getLocalDnsBak() {
            return this.sm;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int hp() {
            return 0;
        }
    }
}
