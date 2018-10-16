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
    private static com.baidu.adp.lib.webSocket.b Hd;

    /* loaded from: classes.dex */
    public interface a {
        void close() throws IOException;

        String getLocalDns();

        boolean isConnected();

        String lD();

        long lE();

        int lF();

        String lp();

        int read(ByteBuffer byteBuffer) throws Exception;

        int write(ByteBuffer byteBuffer) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(String str, int i, l lVar, boolean z) throws Exception {
        if (Hd != null) {
            return Hd.a(str, i, lVar);
        }
        if (z) {
            return new b(str, i, lVar);
        }
        return new c(str, i, lVar);
    }

    /* loaded from: classes.dex */
    static class c implements a {
        private long Hf;
        private String Hg;
        private String Hh;
        private String Hi;
        private Socket Hj;
        private byte[] mData;
        private InputStream mInputStream;
        private OutputStream mOutputStream;

        public c(String str, int i, l lVar) throws Exception {
            this.Hj = null;
            this.mInputStream = null;
            this.mOutputStream = null;
            this.mData = null;
            this.Hf = 0L;
            this.Hg = null;
            this.Hh = null;
            this.Hi = null;
            this.Hj = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.Hg = inetSocketAddress.getAddress().getHostAddress();
                this.Hf = System.currentTimeMillis() - currentTimeMillis;
            }
            this.Hj.connect(inetSocketAddress, lVar.lZ());
            this.Hj.setSoTimeout(lVar.lY());
            this.Hj.setTcpNoDelay(lVar.getTcpNoDelay());
            this.mInputStream = this.Hj.getInputStream();
            this.mOutputStream = this.Hj.getOutputStream();
            this.mData = new byte[1024];
            this.Hh = com.baidu.adp.lib.util.l.getLocalDns();
            this.Hi = com.baidu.adp.lib.util.l.lp();
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
            if (this.Hj != null) {
                try {
                    this.Hj.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.Hj != null) {
                return this.Hj.isConnected();
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
        public String lD() {
            return this.Hg;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long lE() {
            return this.Hf;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String getLocalDns() {
            return this.Hh;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String lp() {
            return this.Hi;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int lF() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel He;
        private long Hf;
        private String Hg;
        private String Hh;
        private String Hi;

        public b(String str, int i, l lVar) throws Exception {
            this.He = null;
            this.Hf = 0L;
            this.Hg = null;
            this.Hh = null;
            this.Hi = null;
            this.He = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.Hg = inetSocketAddress.getAddress().getHostAddress();
                this.Hf = System.currentTimeMillis() - currentTimeMillis;
            }
            this.He.socket().connect(inetSocketAddress, lVar.lZ());
            this.He.socket().setSoTimeout(lVar.lY());
            this.He.socket().setTcpNoDelay(lVar.getTcpNoDelay());
            this.Hh = com.baidu.adp.lib.util.l.getLocalDns();
            this.Hi = com.baidu.adp.lib.util.l.lp();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            if (this.He != null) {
                this.He.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.He != null) {
                return this.He.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.He.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.He.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String lD() {
            return this.Hg;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long lE() {
            return this.Hf;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String getLocalDns() {
            return this.Hh;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String lp() {
            return this.Hi;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int lF() {
            return 0;
        }
    }
}
