package android.support.v4.a;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
class d implements Parcelable.ClassLoaderCreator {

    /* renamed from: a  reason: collision with root package name */
    private final c f261a;

    public d(c cVar) {
        this.f261a = cVar;
    }

    @Override // android.os.Parcelable.Creator
    public Object createFromParcel(Parcel parcel) {
        return this.f261a.a(parcel, null);
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.f261a.a(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public Object[] newArray(int i) {
        return this.f261a.a(i);
    }
}
