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
    private static com.baidu.adp.lib.webSocket.b anr;

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
        if (anr != null) {
            return anr.a(str, i, lVar);
        }
        if (z) {
            return new b(str, i, lVar);
        }
        return new c(str, i, lVar);
    }

    /* loaded from: classes.dex */
    static class c implements a {
        private long ant;
        private String anu;
        private String anv;
        private String anw;
        private Socket anx;
        private InputStream any;
        private byte[] mData;
        private OutputStream mOutputStream;

        public c(String str, int i, l lVar) throws Exception {
            this.anx = null;
            this.any = null;
            this.mOutputStream = null;
            this.mData = null;
            this.ant = 0L;
            this.anu = null;
            this.anv = null;
            this.anw = null;
            this.anx = new Socket();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.anu = inetSocketAddress.getAddress().getHostAddress();
                this.ant = System.currentTimeMillis() - currentTimeMillis;
            }
            this.anx.connect(inetSocketAddress, lVar.pO());
            this.anx.setSoTimeout(lVar.pN());
            this.anx.setTcpNoDelay(lVar.getTcpNoDelay());
            this.any = this.anx.getInputStream();
            this.mOutputStream = this.anx.getOutputStream();
            this.mData = new byte[1024];
            this.anv = com.baidu.adp.lib.util.l.pb();
            this.anw = com.baidu.adp.lib.util.l.pc();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            try {
                this.any.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mOutputStream.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.anx != null) {
                try {
                    this.anx.close();
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th) {
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.anx != null) {
                return this.anx.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            int read = this.any.read(this.mData);
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
            return this.anu;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long ps() {
            return this.ant;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String pb() {
            return this.anv;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String pc() {
            return this.anw;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int pt() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private SocketChannel ans;
        private long ant;
        private String anu;
        private String anv;
        private String anw;

        public b(String str, int i, l lVar) throws Exception {
            this.ans = null;
            this.ant = 0L;
            this.anu = null;
            this.anv = null;
            this.anw = null;
            this.ans = SocketChannel.open();
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                this.anu = inetSocketAddress.getAddress().getHostAddress();
                this.ant = System.currentTimeMillis() - currentTimeMillis;
            }
            this.ans.socket().connect(inetSocketAddress, lVar.pO());
            this.ans.socket().setSoTimeout(lVar.pN());
            this.ans.socket().setTcpNoDelay(lVar.getTcpNoDelay());
            this.anv = com.baidu.adp.lib.util.l.pb();
            this.anw = com.baidu.adp.lib.util.l.pc();
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public void close() throws IOException {
            if (this.ans != null) {
                this.ans.close();
            }
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public boolean isConnected() {
            if (this.ans != null) {
                return this.ans.isConnected();
            }
            return false;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            return this.ans.read(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            return this.ans.write(byteBuffer);
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String pr() {
            return this.anu;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public long ps() {
            return this.ant;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String pb() {
            return this.anv;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public String pc() {
            return this.anw;
        }

        @Override // com.baidu.adp.lib.webSocket.e.a
        public int pt() {
            return 0;
        }
    }
}
