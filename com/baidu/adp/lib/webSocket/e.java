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
    private static com.baidu.adp.lib.webSocket.b Ea;

    /* loaded from: classes.dex */
    public interface a {
        void close() throws IOException;

        boolean isConnected();

        String jW();

        String jX();

        String km();

        long kn();

        int ko();

        int read(ByteBuffer byteBuffer) throws Exception;

        int write(ByteBuffer byteBuffer) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(String str, int i, l lVar, boolean z) throws Exception {
        if (Ea != null) {
            return Ea.a(str, i, lVar);
        }
        if (z) {
            return new b(str, i, lVar);
        }
        return new c(str, i, lVar);
    }

    /* loaded from: classes.dex */
    static class c implements a {
        private long Ec;
        private String Ed;
        private String Ee;
        private String Ef;
        private Socket Eg;
        private InputStream Eh;
        private byte[] mData;
        private OutputStream mOutputStream;

        public c(String str, int i, l lVar) throws Exception {
            this.Eg = null;
            this.Eh = null;
            this.mOutputStream = null;
            this.mData = null;
            this.Ec = 0L;
            this.Ed = null;
            this.Ee = null;
            this.Ef = null;
            this.Eg = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.Ed = inetSocketAddress.getAddress().getHostAddress();
                this.Ec = System.currentTimeMillis() - currentTimeMillis;
            }
            this.Eg.connect(inetSocketAddress, lVar.kJ());
            this.Eg.setSoTimeout(lVar.kI());
            this.Eg.setTcpNoDelay(lVar.getTcpNoDelay());
            this.Eh = this.Eg.getInputStream();
            this.mOutputStream = this.Eg.getOutputStream();
            this.mData = new byte[1024];
            this.Ee = com.baidu.adp.lib.util.l.jW();
            this.Ef = com.baidu.adp.lib.util.l.jX();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            try {
                this.Eh.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.Eg != null) {
                try {
                    this.Eg.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.Eg != null) {
                return this.Eg.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.Eh.read(this.mData);
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
        public String km() {
            return this.Ed;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long kn() {
            return this.Ec;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jW() {
            return this.Ee;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jX() {
            return this.Ef;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int ko() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel Eb;
        private long Ec;
        private String Ed;
        private String Ee;
        private String Ef;

        public b(String str, int i, l lVar) throws Exception {
            this.Eb = null;
            this.Ec = 0L;
            this.Ed = null;
            this.Ee = null;
            this.Ef = null;
            this.Eb = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.Ed = inetSocketAddress.getAddress().getHostAddress();
                this.Ec = System.currentTimeMillis() - currentTimeMillis;
            }
            this.Eb.socket().connect(inetSocketAddress, lVar.kJ());
            this.Eb.socket().setSoTimeout(lVar.kI());
            this.Eb.socket().setTcpNoDelay(lVar.getTcpNoDelay());
            this.Ee = com.baidu.adp.lib.util.l.jW();
            this.Ef = com.baidu.adp.lib.util.l.jX();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            if (this.Eb != null) {
                this.Eb.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.Eb != null) {
                return this.Eb.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.Eb.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.Eb.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String km() {
            return this.Ed;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long kn() {
            return this.Ec;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jW() {
            return this.Ee;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jX() {
            return this.Ef;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int ko() {
            return 0;
        }
    }
}
