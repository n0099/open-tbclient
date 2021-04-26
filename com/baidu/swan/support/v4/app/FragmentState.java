package com.baidu.swan.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import d.a.h0.m.a.a.j;
import d.a.h0.m.a.a.l;
/* loaded from: classes3.dex */
public final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new a();

    /* renamed from: e  reason: collision with root package name */
    public final String f12621e;

    /* renamed from: f  reason: collision with root package name */
    public final int f12622f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f12623g;

    /* renamed from: h  reason: collision with root package name */
    public final int f12624h;

    /* renamed from: i  reason: collision with root package name */
    public final int f12625i;
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
        this.f12621e = fragment.getClass().getName();
        this.f12622f = fragment.j;
        this.f12623g = fragment.s;
        this.f12624h = fragment.A;
        this.f12625i = fragment.B;
        this.j = fragment.C;
        this.k = fragment.F;
        this.l = fragment.E;
        this.m = fragment.l;
    }

    public Fragment a(j jVar, Fragment fragment) {
        Fragment fragment2 = this.o;
        if (fragment2 != null) {
            return fragment2;
        }
        Context h2 = jVar.h();
        Bundle bundle = this.m;
        if (bundle != null) {
            bundle.setClassLoader(h2.getClassLoader());
        }
        this.o = Fragment.T(h2, this.f12621e, this.m);
        Bundle bundle2 = this.n;
        if (bundle2 != null) {
            bundle2.setClassLoader(h2.getClassLoader());
            this.o.f12609h = this.n;
        }
        this.o.d1(this.f12622f, fragment);
        Fragment fragment3 = this.o;
        fragment3.s = this.f12623g;
        fragment3.u = true;
        fragment3.A = this.f12624h;
        fragment3.B = this.f12625i;
        fragment3.C = this.j;
        fragment3.F = this.k;
        fragment3.E = this.l;
        fragment3.w = jVar.f47336d;
        if (l.x) {
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
        parcel.writeString(this.f12621e);
        parcel.writeInt(this.f12622f);
        parcel.writeInt(this.f12623g ? 1 : 0);
        parcel.writeInt(this.f12624h);
        parcel.writeInt(this.f12625i);
        parcel.writeString(this.j);
        parcel.writeInt(this.k ? 1 : 0);
        parcel.writeInt(this.l ? 1 : 0);
        parcel.writeBundle(this.m);
        parcel.writeBundle(this.n);
    }

    public FragmentState(Parcel parcel) {
        this.f12621e = parcel.readString();
        this.f12622f = parcel.readInt();
        this.f12623g = parcel.readInt() != 0;
        this.f12624h = parcel.readInt();
        this.f12625i = parcel.readInt();
        this.j = parcel.readString();
        this.k = parcel.readInt() != 0;
        this.l = parcel.readInt() != 0;
        this.m = parcel.readBundle();
        this.n = parcel.readBundle();
    }
}
