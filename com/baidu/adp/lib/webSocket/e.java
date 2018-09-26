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
    private static com.baidu.adp.lib.webSocket.b Gu;

    /* loaded from: classes.dex */
    public interface a {
        void close() throws IOException;

        boolean isConnected();

        String lc();

        String ld();

        String ls();

        long lt();

        int lu();

        int read(ByteBuffer byteBuffer) throws Exception;

        int write(ByteBuffer byteBuffer) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(String str, int i, l lVar, boolean z) throws Exception {
        if (Gu != null) {
            return Gu.a(str, i, lVar);
        }
        if (z) {
            return new b(str, i, lVar);
        }
        return new c(str, i, lVar);
    }

    /* loaded from: classes.dex */
    static class c implements a {
        private Socket GA;
        private InputStream GB;
        private long Gw;
        private String Gx;
        private String Gy;
        private String Gz;
        private byte[] mData;
        private OutputStream mOutputStream;

        public c(String str, int i, l lVar) throws Exception {
            this.GA = null;
            this.GB = null;
            this.mOutputStream = null;
            this.mData = null;
            this.Gw = 0L;
            this.Gx = null;
            this.Gy = null;
            this.Gz = null;
            this.GA = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.Gx = inetSocketAddress.getAddress().getHostAddress();
                this.Gw = System.currentTimeMillis() - currentTimeMillis;
            }
            this.GA.connect(inetSocketAddress, lVar.lP());
            this.GA.setSoTimeout(lVar.lO());
            this.GA.setTcpNoDelay(lVar.getTcpNoDelay());
            this.GB = this.GA.getInputStream();
            this.mOutputStream = this.GA.getOutputStream();
            this.mData = new byte[1024];
            this.Gy = com.baidu.adp.lib.util.l.lc();
            this.Gz = com.baidu.adp.lib.util.l.ld();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            try {
                this.GB.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.GA != null) {
                try {
                    this.GA.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.GA != null) {
                return this.GA.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.GB.read(this.mData);
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
        public String ls() {
            return this.Gx;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long lt() {
            return this.Gw;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String lc() {
            return this.Gy;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String ld() {
            return this.Gz;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int lu() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel Gv;
        private long Gw;
        private String Gx;
        private String Gy;
        private String Gz;

        public b(String str, int i, l lVar) throws Exception {
            this.Gv = null;
            this.Gw = 0L;
            this.Gx = null;
            this.Gy = null;
            this.Gz = null;
            this.Gv = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.Gx = inetSocketAddress.getAddress().getHostAddress();
                this.Gw = System.currentTimeMillis() - currentTimeMillis;
            }
            this.Gv.socket().connect(inetSocketAddress, lVar.lP());
            this.Gv.socket().setSoTimeout(lVar.lO());
            this.Gv.socket().setTcpNoDelay(lVar.getTcpNoDelay());
            this.Gy = com.baidu.adp.lib.util.l.lc();
            this.Gz = com.baidu.adp.lib.util.l.ld();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            if (this.Gv != null) {
                this.Gv.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.Gv != null) {
                return this.Gv.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.Gv.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.Gv.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String ls() {
            return this.Gx;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long lt() {
            return this.Gw;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String lc() {
            return this.Gy;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String ld() {
            return this.Gz;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int lu() {
            return 0;
        }
    }
}
