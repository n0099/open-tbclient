package c.i.d.c;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes9.dex */
public interface s0<E> extends Collection<E> {

    /* loaded from: classes9.dex */
    public interface a<E> {
        int getCount();

        E getElement();

        String toString();
    }

    int add(E e2, int i2);

    @Override // java.util.Collection, c.i.d.c.s0
    boolean contains(Object obj);

    @Override // java.util.Collection
    boolean containsAll(Collection<?> collection);

    int count(Object obj);

    Set<E> elementSet();

    Set<a<E>> entrySet();

    @Override // c.i.d.c.s0
    boolean equals(Object obj);

    @Override // c.i.d.c.s0
    int hashCode();

    @Override // java.lang.Iterable, c.i.d.c.s0
    Iterator<E> iterator();

    int remove(Object obj, int i2);

    @Override // java.util.Collection, c.i.d.c.s0
    boolean remove(Object obj);

    int setCount(E e2, int i2);

    boolean setCount(E e2, int i2, int i3);

    @Override // java.util.Collection
    int size();
}
