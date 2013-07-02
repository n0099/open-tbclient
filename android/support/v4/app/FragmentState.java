package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
/* loaded from: classes.dex */
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator CREATOR = new aa();
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
        this.b = fragment.o;
        this.c = fragment.x;
        this.d = fragment.F;
        this.e = fragment.G;
        this.f = fragment.H;
        this.g = fragment.K;
        this.h = fragment.J;
        this.i = fragment.q;
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

    public Fragment a(n nVar, Fragment fragment) {
        if (this.k != null) {
            return this.k;
        }
        if (this.i != null) {
            this.i.setClassLoader(nVar.getClassLoader());
        }
        this.k = Fragment.a(nVar, this.a, this.i);
        if (this.j != null) {
            this.j.setClassLoader(nVar.getClassLoader());
            this.k.m = this.j;
        }
        this.k.a(this.b, fragment);
        this.k.x = this.c;
        this.k.z = true;
        this.k.F = this.d;
        this.k.G = this.e;
        this.k.H = this.f;
        this.k.K = this.g;
        this.k.J = this.h;
        this.k.B = nVar.mFragments;
        if (v.a) {
            Log.v("FragmentManager", "Instantiated fragment " + this.k);
        }
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
