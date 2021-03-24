package com.baidu.crabsdk.c;

import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public final class b<E> extends LinkedList<E> {
    public final int cg;

    public b(int i) {
        this.cg = i;
    }

    @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final void add(int i, E e2) {
        if (size() == this.cg) {
            removeFirst();
        }
        super.add(i, e2);
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public final boolean add(E e2) {
        if (size() == this.cg) {
            removeFirst();
        }
        return super.add(e2);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
        }
        return sb.toString();
    }
}
