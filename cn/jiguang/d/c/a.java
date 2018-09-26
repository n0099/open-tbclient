package cn.jiguang.d.c;

import java.net.SocketTimeoutException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
/* loaded from: classes3.dex */
class a {
    protected long a;
    protected SelectionKey lc;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(SelectableChannel selectableChannel, long j) {
        Selector selector = null;
        this.a = j;
        try {
            selector = Selector.open();
            selectableChannel.configureBlocking(false);
            this.lc = selectableChannel.register(selector, 1);
        } catch (Throwable th) {
            if (selector != null) {
                selector.close();
            }
            selectableChannel.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(SelectionKey selectionKey, long j) {
        long currentTimeMillis = j - System.currentTimeMillis();
        int i = 0;
        if (currentTimeMillis > 0) {
            i = selectionKey.selector().select(currentTimeMillis);
        } else if (currentTimeMillis == 0) {
            i = selectionKey.selector().selectNow();
        }
        if (i == 0) {
            throw new SocketTimeoutException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.lc.selector().close();
        this.lc.channel().close();
    }
}
