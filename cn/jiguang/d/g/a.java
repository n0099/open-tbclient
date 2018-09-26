package cn.jiguang.d.g;

import com.baidu.ar.audio.AudioParams;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
/* loaded from: classes3.dex */
public abstract class a {
    protected int c;
    protected SocketChannel lJ;
    protected Selector lK;
    protected ByteBuffer a = ByteBuffer.allocate(AudioParams.DEFAULT_AUDIO_BUFFER_SIZE);
    protected boolean e = false;

    public int a(String str, int i) {
        if (this.a == null) {
            this.a = ByteBuffer.allocate(AudioParams.DEFAULT_AUDIO_BUFFER_SIZE);
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
        return this.e && this.lJ != null && this.lJ.isConnected();
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
