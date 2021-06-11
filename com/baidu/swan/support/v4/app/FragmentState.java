package com.baidu.swan.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import d.a.l0.o.a.a.k;
import d.a.l0.o.a.a.m;
/* loaded from: classes3.dex */
public final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new a();

    /* renamed from: e  reason: collision with root package name */
    public final String f11926e;

    /* renamed from: f  reason: collision with root package name */
    public final int f11927f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f11928g;

    /* renamed from: h  reason: collision with root package name */
    public final int f11929h;

    /* renamed from: i  reason: collision with root package name */
    public final int f11930i;
    public final String j;
    public final boolean k;
    public final boolean l;
    public final Bundle m;
    public Bundle n;
    public Fragment o;

    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<FragmentState> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public FragmentState[] newArray(int i2) {
            return new FragmentState[i2];
        }
    }

    public FragmentState(Fragment fragment) {
        this.f11926e = fragment.getClass().getName();
        this.f11927f = fragment.j;
        this.f11928g = fragment.s;
        this.f11929h = fragment.A;
        this.f11930i = fragment.B;
        this.j = fragment.C;
        this.k = fragment.F;
        this.l = fragment.E;
        this.m = fragment.l;
    }

    public Fragment a(k kVar, Fragment fragment) {
        Fragment fragment2 = this.o;
        if (fragment2 != null) {
            return fragment2;
        }
        Context h2 = kVar.h();
        Bundle bundle = this.m;
        if (bundle != null) {
            bundle.setClassLoader(h2.getClassLoader());
        }
        this.o = Fragment.g0(h2, this.f11926e, this.m);
        Bundle bundle2 = this.n;
        if (bundle2 != null) {
            bundle2.setClassLoader(h2.getClassLoader());
            this.o.f11914h = this.n;
        }
        this.o.k1(this.f11927f, fragment);
        Fragment fragment3 = this.o;
        fragment3.s = this.f11928g;
        fragment3.u = true;
        fragment3.A = this.f11929h;
        fragment3.B = this.f11930i;
        fragment3.C = this.j;
        fragment3.F = this.k;
        fragment3.E = this.l;
        fragment3.w = kVar.f51901d;
        if (m.x) {
            Log.v("FragmentManager", "Instantiated fragment " + this.o);
        }
        return this.o;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f11926e);
        parcel.writeInt(this.f11927f);
        parcel.writeInt(this.f11928g ? 1 : 0);
        parcel.writeInt(this.f11929h);
        parcel.writeInt(this.f11930i);
        parcel.writeString(this.j);
        parcel.writeInt(this.k ? 1 : 0);
        parcel.writeInt(this.l ? 1 : 0);
        parcel.writeBundle(this.m);
        parcel.writeBundle(this.n);
    }

    public FragmentState(Parcel parcel) {
        this.f11926e = parcel.readString();
        this.f11927f = parcel.readInt();
        this.f11928g = parcel.readInt() != 0;
        this.f11929h = parcel.readInt();
        this.f11930i = parcel.readInt();
        this.j = parcel.readString();
        this.k = parcel.readInt() != 0;
        this.l = parcel.readInt() != 0;
        this.m = parcel.readBundle();
        this.n = parcel.readBundle();
    }
}
