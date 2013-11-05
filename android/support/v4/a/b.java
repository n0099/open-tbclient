package android.support.v4.a;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
class b<T> implements Parcelable.Creator<T> {

    /* renamed from: a  reason: collision with root package name */
    final c<T> f270a;

    public b(c<T> cVar) {
        this.f270a = cVar;
    }

    @Override // android.os.Parcelable.Creator
    public T createFromParcel(Parcel parcel) {
        return this.f270a.a(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public T[] newArray(int i) {
        return this.f270a.a(i);
    }
}
