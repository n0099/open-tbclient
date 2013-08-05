package android.support.v4.a;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
class b implements Parcelable.Creator {

    /* renamed from: a  reason: collision with root package name */
    final c f260a;

    public b(c cVar) {
        this.f260a = cVar;
    }

    @Override // android.os.Parcelable.Creator
    public Object createFromParcel(Parcel parcel) {
        return this.f260a.a(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public Object[] newArray(int i) {
        return this.f260a.a(i);
    }
}
