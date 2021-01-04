package com.baidu.searchbox.track.ui;

import androidx.annotation.NonNull;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public final class EvictingDeque<E> {
    private int mCapacity;
    private final LinkedList<E> mDelegate = new LinkedList<>();

    private EvictingDeque(int i) {
        this.mCapacity = i;
    }

    public static <E> EvictingDeque<E> create(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("capacity should not < 0");
        }
        return new EvictingDeque<>(i);
    }

    public int getCapacity() {
        return this.mCapacity;
    }

    public void setCapacity(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("capacity should not < 0");
        }
        this.mCapacity = i;
    }

    public int size() {
        return this.mDelegate.size();
    }

    public E peekLast() {
        return this.mDelegate.peekLast();
    }

    public boolean offerLast(@NonNull E e) {
        if (e == null) {
            throw new NullPointerException("element should not be null");
        }
        while (this.mDelegate.size() > 0 && this.mDelegate.size() >= this.mCapacity) {
            this.mDelegate.pollFirst();
        }
        if (this.mCapacity != 0) {
            this.mDelegate.offerLast(e);
        }
        return true;
    }

    public LinkedList<E> getElements() {
        return this.mDelegate;
    }
}
