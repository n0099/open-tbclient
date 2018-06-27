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
    private static com.baidu.adp.lib.webSocket.b Ed;

    /* loaded from: classes.dex */
    public interface a {
        void close() throws IOException;

        boolean isConnected();

        String jV();

        String jW();

        String kl();

        long km();

        int kn();

        int read(ByteBuffer byteBuffer) throws Exception;

        int write(ByteBuffer byteBuffer) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(String str, int i, l lVar, boolean z) throws Exception {
        if (Ed != null) {
            return Ed.a(str, i, lVar);
        }
        if (z) {
            return new b(str, i, lVar);
        }
        return new c(str, i, lVar);
    }

    /* loaded from: classes.dex */
    static class c implements a {
        private long Ef;
        private String Eg;
        private String Eh;
        private String Ei;
        private Socket Ej;
        private InputStream Ek;
        private byte[] mData;
        private OutputStream mOutputStream;

        public c(String str, int i, l lVar) throws Exception {
            this.Ej = null;
            this.Ek = null;
            this.mOutputStream = null;
            this.mData = null;
            this.Ef = 0L;
            this.Eg = null;
            this.Eh = null;
            this.Ei = null;
            this.Ej = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.Eg = inetSocketAddress.getAddress().getHostAddress();
                this.Ef = System.currentTimeMillis() - currentTimeMillis;
            }
            this.Ej.connect(inetSocketAddress, lVar.kH());
            this.Ej.setSoTimeout(lVar.kG());
            this.Ej.setTcpNoDelay(lVar.getTcpNoDelay());
            this.Ek = this.Ej.getInputStream();
            this.mOutputStream = this.Ej.getOutputStream();
            this.mData = new byte[1024];
            this.Eh = com.baidu.adp.lib.util.l.jV();
            this.Ei = com.baidu.adp.lib.util.l.jW();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            try {
                this.Ek.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.Ej != null) {
                try {
                    this.Ej.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.Ej != null) {
                return this.Ej.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.Ek.read(this.mData);
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
        public String kl() {
            return this.Eg;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long km() {
            return this.Ef;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jV() {
            return this.Eh;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jW() {
            return this.Ei;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int kn() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel Ee;
        private long Ef;
        private String Eg;
        private String Eh;
        private String Ei;

        public b(String str, int i, l lVar) throws Exception {
            this.Ee = null;
            this.Ef = 0L;
            this.Eg = null;
            this.Eh = null;
            this.Ei = null;
            this.Ee = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.Eg = inetSocketAddress.getAddress().getHostAddress();
                this.Ef = System.currentTimeMillis() - currentTimeMillis;
            }
            this.Ee.socket().connect(inetSocketAddress, lVar.kH());
            this.Ee.socket().setSoTimeout(lVar.kG());
            this.Ee.socket().setTcpNoDelay(lVar.getTcpNoDelay());
            this.Eh = com.baidu.adp.lib.util.l.jV();
            this.Ei = com.baidu.adp.lib.util.l.jW();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            if (this.Ee != null) {
                this.Ee.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.Ee != null) {
                return this.Ee.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.Ee.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.Ee.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String kl() {
            return this.Eg;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long km() {
            return this.Ef;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jV() {
            return this.Eh;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jW() {
            return this.Ei;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int kn() {
            return 0;
        }
    }
}
