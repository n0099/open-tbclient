package androidx.appcompat.view.menu;
/* loaded from: classes.dex */
public class BaseWrapper<T> {
    public final T mWrappedObject;

    public BaseWrapper(T t) {
        if (t != null) {
            this.mWrappedObject = t;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public T getWrappedObject() {
        return this.mWrappedObject;
    }
}
