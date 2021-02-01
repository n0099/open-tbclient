package aegon.chrome.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
/* loaded from: classes3.dex */
public class ObserverList<E> implements Iterable<E> {
    public static final /* synthetic */ boolean $assertionsDisabled = !ObserverList.class.desiredAssertionStatus();
    public int mCount;
    public int mIterationDepth;
    public boolean mNeedsCompact;
    public final List<E> mObservers = new ArrayList();

    /* loaded from: classes3.dex */
    private class ObserverListIterator implements RewindableIterator<E> {
        public int mIndex;
        public boolean mIsExhausted;
        public int mListEndMarker;

        public /* synthetic */ ObserverListIterator(AnonymousClass1 anonymousClass1) {
            ObserverList.access$100(ObserverList.this);
            this.mListEndMarker = ObserverList.access$200(ObserverList.this);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i = this.mIndex;
            while (i < this.mListEndMarker && ObserverList.access$300(ObserverList.this, i) == null) {
                i++;
            }
            if (i < this.mListEndMarker) {
                return true;
            }
            if (!this.mIsExhausted) {
                this.mIsExhausted = true;
                ObserverList.access$400(ObserverList.this);
            }
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            while (true) {
                int i = this.mIndex;
                if (i >= this.mListEndMarker || ObserverList.access$300(ObserverList.this, i) != null) {
                    break;
                }
                this.mIndex++;
            }
            int i2 = this.mIndex;
            if (i2 < this.mListEndMarker) {
                ObserverList observerList = ObserverList.this;
                this.mIndex = i2 + 1;
                return (E) ObserverList.access$300(observerList, i2);
            }
            if (!this.mIsExhausted) {
                this.mIsExhausted = true;
                ObserverList.access$400(ObserverList.this);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes3.dex */
    public interface RewindableIterator<E> extends Iterator<E> {
    }

    public static /* synthetic */ void access$100(ObserverList observerList) {
        observerList.mIterationDepth++;
    }

    public static /* synthetic */ int access$200(ObserverList observerList) {
        return observerList.mObservers.size();
    }

    public static /* synthetic */ Object access$300(ObserverList observerList, int i) {
        return observerList.mObservers.get(i);
    }

    public static /* synthetic */ void access$400(ObserverList observerList) {
        observerList.mIterationDepth--;
        if (!$assertionsDisabled && observerList.mIterationDepth < 0) {
            throw new AssertionError();
        }
        int i = observerList.mIterationDepth;
        if (i <= 0 && observerList.mNeedsCompact) {
            observerList.mNeedsCompact = false;
            if (!$assertionsDisabled && i != 0) {
                throw new AssertionError();
            }
            for (int size = observerList.mObservers.size() - 1; size >= 0; size--) {
                if (observerList.mObservers.get(size) == null) {
                    observerList.mObservers.remove(size);
                }
            }
        }
    }

    public boolean addObserver(E e) {
        if (e == null || this.mObservers.contains(e)) {
            return false;
        }
        boolean add = this.mObservers.add(e);
        if ($assertionsDisabled || add) {
            this.mCount++;
            return true;
        }
        throw new AssertionError();
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return new ObserverListIterator(null);
    }

    public boolean removeObserver(E e) {
        int indexOf;
        if (e == null || (indexOf = this.mObservers.indexOf(e)) == -1) {
            return false;
        }
        if (this.mIterationDepth == 0) {
            this.mObservers.remove(indexOf);
        } else {
            this.mNeedsCompact = true;
            this.mObservers.set(indexOf, null);
        }
        this.mCount--;
        if ($assertionsDisabled || this.mCount >= 0) {
            return true;
        }
        throw new AssertionError();
    }
}
