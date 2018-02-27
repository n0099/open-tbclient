package android.support.v7.view.menu;
/* loaded from: classes2.dex */
class b<T> {
    final T HI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.HI = t;
    }

    public T getWrappedObject() {
        return this.HI;
    }
}
