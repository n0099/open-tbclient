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
    private static com.baidu.adp.lib.webSocket.b any;

    /* loaded from: classes.dex */
    public interface a {
        void close() throws IOException;

        boolean isConnected();

        String pb();

        String pc();

        String pr();

        long ps();

        int pt();

        int read(ByteBuffer byteBuffer) throws Exception;

        int write(ByteBuffer byteBuffer) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(String str, int i, l lVar, boolean z) throws Exception {
        if (any != null) {
            return any.a(str, i, lVar);
        }
        if (z) {
            return new b(str, i, lVar);
        }
        return new c(str, i, lVar);
    }

    /* loaded from: classes.dex */
    static class c implements a {
        private long anA;
        private String anB;
        private String anC;
        private String anD;
        private Socket anE;
        private InputStream anF;
        private byte[] mData;
        private OutputStream mOutputStream;

        public c(String str, int i, l lVar) throws Exception {
            this.anE = null;
            this.anF = null;
            this.mOutputStream = null;
            this.mData = null;
            this.anA = 0L;
            this.anB = null;
            this.anC = null;
            this.anD = null;
            this.anE = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.anB = inetSocketAddress.getAddress().getHostAddress();
                this.anA = System.currentTimeMillis() - currentTimeMillis;
            }
            this.anE.connect(inetSocketAddress, lVar.pO());
            this.anE.setSoTimeout(lVar.pN());
            this.anE.setTcpNoDelay(lVar.getTcpNoDelay());
            this.anF = this.anE.getInputStream();
            this.mOutputStream = this.anE.getOutputStream();
            this.mData = new byte[1024];
            this.anC = com.baidu.adp.lib.util.l.pb();
            this.anD = com.baidu.adp.lib.util.l.pc();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            try {
                this.anF.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.anE != null) {
                try {
                    this.anE.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.anE != null) {
                return this.anE.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.anF.read(this.mData);
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
        public String pr() {
            return this.anB;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long ps() {
            return this.anA;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String pb() {
            return this.anC;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String pc() {
            return this.anD;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int pt() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private long anA;
        private String anB;
        private String anC;
        private String anD;
        private SocketChannel anz;

        public b(String str, int i, l lVar) throws Exception {
            this.anz = null;
            this.anA = 0L;
            this.anB = null;
            this.anC = null;
            this.anD = null;
            this.anz = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.anB = inetSocketAddress.getAddress().getHostAddress();
                this.anA = System.currentTimeMillis() - currentTimeMillis;
            }
            this.anz.socket().connect(inetSocketAddress, lVar.pO());
            this.anz.socket().setSoTimeout(lVar.pN());
            this.anz.socket().setTcpNoDelay(lVar.getTcpNoDelay());
            this.anC = com.baidu.adp.lib.util.l.pb();
            this.anD = com.baidu.adp.lib.util.l.pc();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            if (this.anz != null) {
                this.anz.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.anz != null) {
                return this.anz.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.anz.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.anz.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String pr() {
            return this.anB;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long ps() {
            return this.anA;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String pb() {
            return this.anC;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String pc() {
            return this.anD;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int pt() {
            return 0;
        }
    }
}
