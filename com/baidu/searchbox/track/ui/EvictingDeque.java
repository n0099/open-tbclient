package com.baidu.searchbox.track.ui;

import androidx.annotation.NonNull;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public final class EvictingDeque<E> {
    public int mCapacity;
    public final LinkedList<E> mDelegate = new LinkedList<>();

    public EvictingDeque(int i2) {
        this.mCapacity = i2;
    }

    public static <E> EvictingDeque<E> create(int i2) {
        if (i2 >= 0) {
            return new EvictingDeque<>(i2);
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

    public void setCapacity(int i2) {
        if (i2 >= 0) {
            this.mCapacity = i2;
            return;
        }
        throw new IllegalArgumentException("capacity should not < 0");
    }

    public int size() {
        return this.mDelegate.size();
    }
}
