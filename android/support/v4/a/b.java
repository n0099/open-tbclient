package android.support.v4.a;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
class b<T> implements Parcelable.Creator<T> {
    final c<T> a;

    public b(c<T> cVar) {
        this.a = cVar;
    }

    @Override // android.os.Parcelable.Creator
    public T createFromParcel(Parcel parcel) {
        return this.a.a(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public T[] newArray(int i) {
        return this.a.a(i);
    }
}
