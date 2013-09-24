package android.support.v4.a;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
class b<T> implements Parcelable.Creator<T> {

    /* renamed from: a  reason: collision with root package name */
    final c<T> f260a;

    public b(c<T> cVar) {
        this.f260a = cVar;
    }

    @Override // android.os.Parcelable.Creator
    public T createFromParcel(Parcel parcel) {
        return this.f260a.a(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public T[] newArray(int i) {
        return this.f260a.a(i);
    }
}
