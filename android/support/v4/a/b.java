package android.support.v4.a;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
class b implements Parcelable.Creator {

    /* renamed from: a  reason: collision with root package name */
    final c f36a;

    public b(c cVar) {
        this.f36a = cVar;
    }

    @Override // android.os.Parcelable.Creator
    public Object createFromParcel(Parcel parcel) {
        return this.f36a.a(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public Object[] newArray(int i) {
        return this.f36a.a(i);
    }
}
