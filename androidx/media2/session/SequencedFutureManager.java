package androidx.media2.session;

import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.concurrent.futures.AbstractResolvableFuture;
import java.io.Closeable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SequencedFutureManager implements Closeable {
    public static final boolean DEBUG = false;
    public static final String TAG = "SequencedFutureManager";
    @GuardedBy("mLock")
    public int mNextSequenceNumber;
    public final Object mLock = new Object();
    @GuardedBy("mLock")
    public ArrayMap<Integer, SequencedFuture<?>> mSeqToFutureMap = new ArrayMap<>();

    /* loaded from: classes.dex */
    public static final class SequencedFuture<T> extends AbstractResolvableFuture<T> {
        public final T mResultWhenClosed;
        public final int mSequenceNumber;

        public SequencedFuture(int i, @NonNull T t) {
            this.mSequenceNumber = i;
            this.mResultWhenClosed = t;
        }

        public static <T> SequencedFuture<T> create(int i, @NonNull T t) {
            return new SequencedFuture<>(i, t);
        }

        @NonNull
        public T getResultWhenClosed() {
            return this.mResultWhenClosed;
        }

        public int getSequenceNumber() {
            return this.mSequenceNumber;
        }

        public void setWithTheValueOfResultWhenClosed() {
            set(this.mResultWhenClosed);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture
        public boolean set(@Nullable T t) {
            return super.set(t);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ArrayList<SequencedFuture> arrayList;
        synchronized (this.mLock) {
            arrayList = new ArrayList(this.mSeqToFutureMap.values());
            this.mSeqToFutureMap.clear();
        }
        for (SequencedFuture sequencedFuture : arrayList) {
            sequencedFuture.setWithTheValueOfResultWhenClosed();
        }
    }

    public int obtainNextSequenceNumber() {
        int i;
        synchronized (this.mLock) {
            i = this.mNextSequenceNumber;
            this.mNextSequenceNumber = i + 1;
        }
        return i;
    }

    public <T> SequencedFuture<T> createSequencedFuture(T t) {
        SequencedFuture<T> create;
        synchronized (this.mLock) {
            int obtainNextSequenceNumber = obtainNextSequenceNumber();
            create = SequencedFuture.create(obtainNextSequenceNumber, t);
            this.mSeqToFutureMap.put(Integer.valueOf(obtainNextSequenceNumber), create);
        }
        return create;
    }

    public <T> void setFutureResult(int i, T t) {
        synchronized (this.mLock) {
            SequencedFuture<?> remove = this.mSeqToFutureMap.remove(Integer.valueOf(i));
            if (remove != null) {
                if (t != null && remove.getResultWhenClosed().getClass() != t.getClass()) {
                    Log.w(TAG, "Type mismatch, expected " + remove.getResultWhenClosed().getClass() + ", but was " + t.getClass());
                }
                remove.set(t);
            }
        }
    }
}
