package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator CREATOR = new r();
    final String a;
    final int b;
    final boolean c;
    final int d;
    final int e;
    final String f;
    final boolean g;
    final boolean h;
    final Bundle i;
    Bundle j;
    Fragment k;

    public FragmentState(Fragment fragment) {
        this.a = fragment.getClass().getName();
        this.b = fragment.n;
        this.c = fragment.w;
        this.d = fragment.C;
        this.e = fragment.D;
        this.f = fragment.E;
        this.g = fragment.H;
        this.h = fragment.G;
        this.i = fragment.p;
    }

    public FragmentState(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readInt();
        this.c = parcel.readInt() != 0;
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readString();
        this.g = parcel.readInt() != 0;
        this.h = parcel.readInt() != 0;
        this.i = parcel.readBundle();
        this.j = parcel.readBundle();
    }

    public Fragment a(g gVar) {
        if (this.k != null) {
            return this.k;
        }
        if (this.i != null) {
            this.i.setClassLoader(gVar.getClassLoader());
        }
        this.k = Fragment.a(gVar, this.a, this.i);
        if (this.j != null) {
            this.j.setClassLoader(gVar.getClassLoader());
            this.k.l = this.j;
        }
        this.k.a(this.b);
        this.k.w = this.c;
        this.k.y = true;
        this.k.C = this.d;
        this.k.D = this.e;
        this.k.E = this.f;
        this.k.H = this.g;
        this.k.G = this.h;
        this.k.A = gVar.mFragments;
        return this.k;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c ? 1 : 0);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeBundle(this.i);
        parcel.writeBundle(this.j);
    }
}
