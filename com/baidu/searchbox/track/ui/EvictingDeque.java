package com.baidu.searchbox.track.ui;

import androidx.annotation.NonNull;
import java.util.LinkedList;
/* loaded from: classes2.dex */
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

    public boolean offerLast(@NonNull E e) {
        if (e != null) {
            while (this.mDelegate.size() > 0 && this.mDelegate.size() >= this.mCapacity) {
                this.mDelegate.pollFirst();
            }
            if (this.mCapacity == 0) {
                return true;
            }
            this.mDelegate.offerLast(e);
            return true;
        }
        throw new NullPointerException("element should not be null");
    }

    public void setCapacity(int i) {
        if (i >= 0) {
            this.mCapacity = i;
            return;
        }
        throw new IllegalArgumentException("capacity should not < 0");
    }

    public int getCapacity() {
        return this.mCapacity;
    }

    public LinkedList<E> getElements() {
        return this.mDelegate;
    }

    public E peekLast() {
        return this.mDelegate.peekLast();
    }

    public int size() {
        return this.mDelegate.size();
    }
}
