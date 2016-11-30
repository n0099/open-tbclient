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
    private static com.baidu.adp.lib.webSocket.b td;

    /* loaded from: classes.dex */
    public interface a {
        void close() throws IOException;

        String gE();

        String gF();

        String gW();

        long gX();

        int gY();

        boolean isConnected();

        int read(ByteBuffer byteBuffer) throws Exception;

        int write(ByteBuffer byteBuffer) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(String str, int i, n nVar, boolean z) throws Exception {
        if (td != null) {
            return td.a(str, i, nVar);
        }
        if (z) {
            return new b(str, i, nVar);
        }
        return new c(str, i, nVar);
    }

    /* loaded from: classes.dex */
    static class c implements a {
        private byte[] ks;
        private OutputStream mOutputStream;
        private long tf;
        private String tg;
        private String th;
        private String ti;
        private Socket tj;
        private InputStream tk;

        public c(String str, int i, n nVar) throws Exception {
            this.tj = null;
            this.tk = null;
            this.mOutputStream = null;
            this.ks = null;
            this.tf = 0L;
            this.tg = null;
            this.th = null;
            this.ti = null;
            this.tj = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.tg = inetSocketAddress.getAddress().getHostAddress();
                this.tf = System.currentTimeMillis() - currentTimeMillis;
            }
            this.tj.connect(inetSocketAddress, nVar.hu());
            this.tj.setSoTimeout(nVar.ht());
            this.tj.setTcpNoDelay(nVar.getTcpNoDelay());
            this.tk = this.tj.getInputStream();
            this.mOutputStream = this.tj.getOutputStream();
            this.ks = new byte[1024];
            this.th = com.baidu.adp.lib.util.k.gE();
            this.ti = com.baidu.adp.lib.util.k.gF();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            try {
                this.tk.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.tj != null) {
                try {
                    this.tj.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.tj != null) {
                return this.tj.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.tk.read(this.ks);
            if (read > 0) {
                byteBuffer.put(this.ks, 0, read);
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
        public String gW() {
            return this.tg;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long gX() {
            return this.tf;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String gE() {
            return this.th;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String gF() {
            return this.ti;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int gY() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel te;
        private long tf;
        private String tg;
        private String th;
        private String ti;

        public b(String str, int i, n nVar) throws Exception {
            this.te = null;
            this.tf = 0L;
            this.tg = null;
            this.th = null;
            this.ti = null;
            this.te = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.tg = inetSocketAddress.getAddress().getHostAddress();
                this.tf = System.currentTimeMillis() - currentTimeMillis;
            }
            this.te.socket().connect(inetSocketAddress, nVar.hu());
            this.te.socket().setSoTimeout(nVar.ht());
            this.te.socket().setTcpNoDelay(nVar.getTcpNoDelay());
            this.th = com.baidu.adp.lib.util.k.gE();
            this.ti = com.baidu.adp.lib.util.k.gF();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            if (this.te != null) {
                this.te.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.te != null) {
                return this.te.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.te.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.te.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String gW() {
            return this.tg;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long gX() {
            return this.tf;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String gE() {
            return this.th;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String gF() {
            return this.ti;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int gY() {
            return 0;
        }
    }
}
