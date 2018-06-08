package com.baidu.crabsdk.c;

import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public final class b<E> extends LinkedList<E> {
    private final int bQ;

    public b(int i) {
        this.bQ = i;
    }

    @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final void add(int i, E e) {
        if (size() == this.bQ) {
            removeFirst();
        }
        super.add(i, e);
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public final boolean add(E e) {
        if (size() == this.bQ) {
            removeFirst();
        }
        return super.add(e);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
        }
        return sb.toString();
    }
}
