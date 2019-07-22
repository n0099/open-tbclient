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
    private static com.baidu.adp.lib.webSocket.b EX;

    /* loaded from: classes.dex */
    public interface a {
        void close() throws IOException;

        boolean isConnected();

        String kO();

        long kP();

        int kQ();

        String ku();

        String kv();

        int read(ByteBuffer byteBuffer) throws Exception;

        int write(ByteBuffer byteBuffer) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(String str, int i, l lVar, boolean z) throws Exception {
        if (EX != null) {
            return EX.a(str, i, lVar);
        }
        if (z) {
            return new b(str, i, lVar);
        }
        return new c(str, i, lVar);
    }

    /* loaded from: classes.dex */
    static class c implements a {
        private long EZ;
        private String Fa;
        private String Fb;
        private String Fc;
        private Socket Fd;
        private InputStream Fe;
        private byte[] mData;
        private OutputStream mOutputStream;

        public c(String str, int i, l lVar) throws Exception {
            this.Fd = null;
            this.Fe = null;
            this.mOutputStream = null;
            this.mData = null;
            this.EZ = 0L;
            this.Fa = null;
            this.Fb = null;
            this.Fc = null;
            this.Fd = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.Fa = inetSocketAddress.getAddress().getHostAddress();
                this.EZ = System.currentTimeMillis() - currentTimeMillis;
            }
            this.Fd.connect(inetSocketAddress, lVar.ll());
            this.Fd.setSoTimeout(lVar.lk());
            this.Fd.setTcpNoDelay(lVar.lj());
            this.Fe = this.Fd.getInputStream();
            this.mOutputStream = this.Fd.getOutputStream();
            this.mData = new byte[1024];
            this.Fb = com.baidu.adp.lib.util.l.ku();
            this.Fc = com.baidu.adp.lib.util.l.kv();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            try {
                this.Fe.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.Fd != null) {
                try {
                    this.Fd.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.Fd != null) {
                return this.Fd.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.Fe.read(this.mData);
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
        public String kO() {
            return this.Fa;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long kP() {
            return this.EZ;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String ku() {
            return this.Fb;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String kv() {
            return this.Fc;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int kQ() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel EY;
        private long EZ;
        private String Fa;
        private String Fb;
        private String Fc;

        public b(String str, int i, l lVar) throws Exception {
            this.EY = null;
            this.EZ = 0L;
            this.Fa = null;
            this.Fb = null;
            this.Fc = null;
            this.EY = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.Fa = inetSocketAddress.getAddress().getHostAddress();
                this.EZ = System.currentTimeMillis() - currentTimeMillis;
            }
            this.EY.socket().connect(inetSocketAddress, lVar.ll());
            this.EY.socket().setSoTimeout(lVar.lk());
            this.EY.socket().setTcpNoDelay(lVar.lj());
            this.Fb = com.baidu.adp.lib.util.l.ku();
            this.Fc = com.baidu.adp.lib.util.l.kv();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            if (this.EY != null) {
                this.EY.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.EY != null) {
                return this.EY.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.EY.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.EY.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String kO() {
            return this.Fa;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long kP() {
            return this.EZ;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String ku() {
            return this.Fb;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String kv() {
            return this.Fc;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int kQ() {
            return 0;
        }
    }
}
