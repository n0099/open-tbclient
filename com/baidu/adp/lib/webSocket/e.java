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
    private static com.baidu.adp.lib.webSocket.b tc;

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
        if (tc != null) {
            return tc.a(str, i, nVar);
        }
        if (z) {
            return new b(str, i, nVar);
        }
        return new c(str, i, nVar);
    }

    /* loaded from: classes.dex */
    static class c implements a {
        private byte[] kr;
        private OutputStream mOutputStream;
        private long te;
        private String tf;
        private String tg;
        private String th;
        private Socket ti;
        private InputStream tj;

        public c(String str, int i, n nVar) throws Exception {
            this.ti = null;
            this.tj = null;
            this.mOutputStream = null;
            this.kr = null;
            this.te = 0L;
            this.tf = null;
            this.tg = null;
            this.th = null;
            this.ti = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.tf = inetSocketAddress.getAddress().getHostAddress();
                this.te = System.currentTimeMillis() - currentTimeMillis;
            }
            this.ti.connect(inetSocketAddress, nVar.hu());
            this.ti.setSoTimeout(nVar.ht());
            this.ti.setTcpNoDelay(nVar.getTcpNoDelay());
            this.tj = this.ti.getInputStream();
            this.mOutputStream = this.ti.getOutputStream();
            this.kr = new byte[1024];
            this.tg = com.baidu.adp.lib.util.k.gE();
            this.th = com.baidu.adp.lib.util.k.gF();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            try {
                this.tj.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.ti != null) {
                try {
                    this.ti.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.ti != null) {
                return this.ti.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.tj.read(this.kr);
            if (read > 0) {
                byteBuffer.put(this.kr, 0, read);
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
            return this.tf;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long gX() {
            return this.te;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String gE() {
            return this.tg;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String gF() {
            return this.th;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int gY() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel td;
        private long te;
        private String tf;
        private String tg;
        private String th;

        public b(String str, int i, n nVar) throws Exception {
            this.td = null;
            this.te = 0L;
            this.tf = null;
            this.tg = null;
            this.th = null;
            this.td = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.tf = inetSocketAddress.getAddress().getHostAddress();
                this.te = System.currentTimeMillis() - currentTimeMillis;
            }
            this.td.socket().connect(inetSocketAddress, nVar.hu());
            this.td.socket().setSoTimeout(nVar.ht());
            this.td.socket().setTcpNoDelay(nVar.getTcpNoDelay());
            this.tg = com.baidu.adp.lib.util.k.gE();
            this.th = com.baidu.adp.lib.util.k.gF();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            if (this.td != null) {
                this.td.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.td != null) {
                return this.td.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.td.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.td.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String gW() {
            return this.tf;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long gX() {
            return this.te;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String gE() {
            return this.tg;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String gF() {
            return this.th;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int gY() {
            return 0;
        }
    }
}
