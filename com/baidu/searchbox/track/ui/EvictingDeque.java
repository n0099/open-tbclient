package com.baidu.searchbox.track.ui;

import androidx.annotation.NonNull;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public final class EvictingDeque<E> {
    public int mCapacity;
    public final LinkedList<E> mDelegate = new LinkedList<>();

    public EvictingDeque(int i) {
        this.mCapacity = i;
    }

    public static <E> EvictingDeque<E> create(int i) {
        if (i >= 0) {
            return new EvictingDeque<>(i);
        }
        throw new IllegalArgumentException("capacity should not < 0");
    }

    public int getCapacity() {
        return this.mCapacity;
    }

    public LinkedList<E> getElements() {
        return this.mDelegate;
    }

    public boolean offerLast(@NonNull E e2) {
        if (e2 != null) {
            while (this.mDelegate.size() > 0 && this.mDelegate.size() >= this.mCapacity) {
                this.mDelegate.pollFirst();
            }
            if (this.mCapacity == 0) {
                return true;
            }
            this.mDelegate.offerLast(e2);
            return true;
        }
        throw new NullPointerException("element should not be null");
    }

    public E peekLast() {
        return this.mDelegate.peekLast();
    }

    public void setCapacity(int i) {
        if (i >= 0) {
            this.mCapacity = i;
            return;
        }
        throw new IllegalArgumentException("capacity should not < 0");
    }

    public int size() {
        return this.mDelegate.size();
    }
}
