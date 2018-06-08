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
    private static com.baidu.adp.lib.webSocket.b Eb;

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
        if (Eb != null) {
            return Eb.a(str, i, lVar);
        }
        if (z) {
            return new b(str, i, lVar);
        }
        return new c(str, i, lVar);
    }

    /* loaded from: classes.dex */
    static class c implements a {
        private long Ed;
        private String Ee;
        private String Ef;
        private String Eg;
        private Socket Eh;
        private InputStream Ei;
        private byte[] mData;
        private OutputStream mOutputStream;

        public c(String str, int i, l lVar) throws Exception {
            this.Eh = null;
            this.Ei = null;
            this.mOutputStream = null;
            this.mData = null;
            this.Ed = 0L;
            this.Ee = null;
            this.Ef = null;
            this.Eg = null;
            this.Eh = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.Ee = inetSocketAddress.getAddress().getHostAddress();
                this.Ed = System.currentTimeMillis() - currentTimeMillis;
            }
            this.Eh.connect(inetSocketAddress, lVar.kH());
            this.Eh.setSoTimeout(lVar.kG());
            this.Eh.setTcpNoDelay(lVar.getTcpNoDelay());
            this.Ei = this.Eh.getInputStream();
            this.mOutputStream = this.Eh.getOutputStream();
            this.mData = new byte[1024];
            this.Ef = com.baidu.adp.lib.util.l.jV();
            this.Eg = com.baidu.adp.lib.util.l.jW();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            try {
                this.Ei.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.Eh != null) {
                try {
                    this.Eh.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.Eh != null) {
                return this.Eh.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.Ei.read(this.mData);
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
            return this.Ee;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long km() {
            return this.Ed;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jV() {
            return this.Ef;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jW() {
            return this.Eg;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int kn() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel Ec;
        private long Ed;
        private String Ee;
        private String Ef;
        private String Eg;

        public b(String str, int i, l lVar) throws Exception {
            this.Ec = null;
            this.Ed = 0L;
            this.Ee = null;
            this.Ef = null;
            this.Eg = null;
            this.Ec = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.Ee = inetSocketAddress.getAddress().getHostAddress();
                this.Ed = System.currentTimeMillis() - currentTimeMillis;
            }
            this.Ec.socket().connect(inetSocketAddress, lVar.kH());
            this.Ec.socket().setSoTimeout(lVar.kG());
            this.Ec.socket().setTcpNoDelay(lVar.getTcpNoDelay());
            this.Ef = com.baidu.adp.lib.util.l.jV();
            this.Eg = com.baidu.adp.lib.util.l.jW();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            if (this.Ec != null) {
                this.Ec.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.Ec != null) {
                return this.Ec.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.Ec.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.Ec.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String kl() {
            return this.Ee;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long km() {
            return this.Ed;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jV() {
            return this.Ef;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String jW() {
            return this.Eg;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int kn() {
            return 0;
        }
    }
}
