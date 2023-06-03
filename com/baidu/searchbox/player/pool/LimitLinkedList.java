package com.baidu.searchbox.player.pool;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0002J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bJ\u0013\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0004R\u001e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/player/pool/LimitLinkedList;", ExifInterface.GPS_DIRECTION_TRUE, "", "_limit", "", "(I)V", "<set-?>", Constants.EXTRA_CONFIG_LIMIT, "getLimit", "()I", "queue", "Ljava/util/LinkedList;", "checkLimit", "", "list", "offer", "value", "(Ljava/lang/Object;)V", "size", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LimitLinkedList<T> {
    public int limit;
    public final LinkedList<T> queue;

    public LimitLinkedList() {
        this(0, 1, null);
    }

    public LimitLinkedList(int i) {
        this.limit = i;
        this.queue = new LinkedList<>();
        checkLimit();
    }

    public final void offer(T t) {
        if (this.queue.size() >= this.limit) {
            this.queue.poll();
        }
        this.queue.offer(t);
    }

    public /* synthetic */ LimitLinkedList(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 10 : i);
    }

    private final void checkLimit() {
        int i = this.limit;
        boolean z = false;
        if (1 <= i && i <= Integer.MAX_VALUE) {
            z = true;
        }
        if (!z) {
            this.limit = 10;
        }
    }

    public final int getLimit() {
        return this.limit;
    }

    public final LinkedList<T> list() {
        return this.queue;
    }

    public final int size() {
        return this.queue.size();
    }
}
