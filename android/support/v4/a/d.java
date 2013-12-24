package android.support.v4.a;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
class d<T> implements Parcelable.ClassLoaderCreator<T> {
    private final c<T> a;

    public d(c<T> cVar) {
        this.a = cVar;
    }

    @Override // android.os.Parcelable.Creator
    public T createFromParcel(Parcel parcel) {
        return this.a.a(parcel, null);
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.a.a(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public T[] newArray(int i) {
        return this.a.a(i);
    }
}
