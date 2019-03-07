package cn.jiguang.d.g;

import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
/* loaded from: classes3.dex */
public abstract class a {
    protected int c;
    protected SocketChannel mr;
    protected Selector mt;
    protected ByteBuffer a = ByteBuffer.allocate(20480);
    protected boolean e = false;

    public int a(String str, int i) {
        if (this.a == null) {
            this.a = ByteBuffer.allocate(20480);
        }
        this.a.clear();
        this.c = 0;
        this.e = true;
        return 0;
    }

    public void a() {
        b();
        this.e = false;
        if (this.a != null) {
            this.a.clear();
        }
        this.c = 0;
    }

    public final boolean b() {
        return this.e && this.mr != null && this.mr.isConnected();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int c() {
        if (this.c < 20) {
            return 0;
        }
        int position = this.a.position();
        this.a.position(0);
        int i = this.a.getShort() & Short.MAX_VALUE;
        this.a.position(position);
        return i;
    }

    public abstract int j(byte[] bArr);

    public abstract d o(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public final ByteBuffer p(int i) {
        if (this.c >= i) {
            this.c -= i;
            byte[] bArr = new byte[i];
            this.a.flip();
            this.a.get(bArr, 0, i);
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.a.compact();
            return wrap;
        }
        return null;
    }
}
