package cn.jiguang.d.c;

import java.io.EOFException;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
/* loaded from: classes3.dex */
public final class r extends a {
    private r(long j) {
        super(SocketChannel.open(), j);
    }

    private byte[] a(int i) {
        SocketChannel socketChannel = (SocketChannel) this.lI.channel();
        byte[] bArr = new byte[i];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.lI.interestOps(1);
        int i2 = 0;
        while (i2 < i) {
            try {
                if (this.lI.isReadable()) {
                    long read = socketChannel.read(wrap);
                    if (read < 0) {
                        throw new EOFException();
                    }
                    i2 += (int) read;
                    if (i2 < i && System.currentTimeMillis() > this.a) {
                        throw new SocketTimeoutException();
                    }
                } else {
                    a(this.lI, this.a);
                }
            } finally {
                if (this.lI.isValid()) {
                    this.lI.interestOps(0);
                }
            }
        }
        return bArr;
    }

    public static byte[] a(SocketAddress socketAddress, SocketAddress socketAddress2, byte[] bArr, long j) {
        int i = 0;
        r rVar = new r(j);
        try {
            SocketChannel socketChannel = (SocketChannel) rVar.lI.channel();
            if (!socketChannel.connect(socketAddress2)) {
                rVar.lI.interestOps(8);
                while (!socketChannel.finishConnect()) {
                    if (!rVar.lI.isConnectable()) {
                        a(rVar.lI, rVar.a);
                    }
                }
                if (rVar.lI.isValid()) {
                    rVar.lI.interestOps(0);
                }
            }
            SocketChannel socketChannel2 = (SocketChannel) rVar.lI.channel();
            ByteBuffer[] byteBufferArr = {ByteBuffer.wrap(new byte[]{(byte) (bArr.length >>> 8), (byte) (bArr.length & 255)}), ByteBuffer.wrap(bArr)};
            rVar.lI.interestOps(4);
            while (i < bArr.length + 2) {
                if (rVar.lI.isWritable()) {
                    long write = socketChannel2.write(byteBufferArr);
                    if (write < 0) {
                        throw new EOFException();
                    }
                    i += (int) write;
                    if (i < bArr.length + 2 && System.currentTimeMillis() > rVar.a) {
                        throw new SocketTimeoutException();
                    }
                } else {
                    a(rVar.lI, rVar.a);
                }
            }
            if (rVar.lI.isValid()) {
                rVar.lI.interestOps(0);
            }
            byte[] a = rVar.a(2);
            byte[] a2 = rVar.a((a[1] & 255) + ((a[0] & 255) << 8));
            rVar.lI.channel();
            return a2;
        } finally {
            rVar.a();
        }
    }
}
