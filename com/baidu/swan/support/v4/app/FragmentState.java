package com.baidu.swan.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import d.a.i0.o.a.a.k;
import d.a.i0.o.a.a.m;
/* loaded from: classes3.dex */
public final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new a();

    /* renamed from: e  reason: collision with root package name */
    public final String f11963e;

    /* renamed from: f  reason: collision with root package name */
    public final int f11964f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f11965g;

    /* renamed from: h  reason: collision with root package name */
    public final int f11966h;

    /* renamed from: i  reason: collision with root package name */
    public final int f11967i;
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
        this.f11963e = fragment.getClass().getName();
        this.f11964f = fragment.j;
        this.f11965g = fragment.s;
        this.f11966h = fragment.A;
        this.f11967i = fragment.B;
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
        this.o = Fragment.g0(h2, this.f11963e, this.m);
        Bundle bundle2 = this.n;
        if (bundle2 != null) {
            bundle2.setClassLoader(h2.getClassLoader());
            this.o.f11951h = this.n;
        }
        this.o.k1(this.f11964f, fragment);
        Fragment fragment3 = this.o;
        fragment3.s = this.f11965g;
        fragment3.u = true;
        fragment3.A = this.f11966h;
        fragment3.B = this.f11967i;
        fragment3.C = this.j;
        fragment3.F = this.k;
        fragment3.E = this.l;
        fragment3.w = kVar.f48051d;
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
        parcel.writeString(this.f11963e);
        parcel.writeInt(this.f11964f);
        parcel.writeInt(this.f11965g ? 1 : 0);
        parcel.writeInt(this.f11966h);
        parcel.writeInt(this.f11967i);
        parcel.writeString(this.j);
        parcel.writeInt(this.k ? 1 : 0);
        parcel.writeInt(this.l ? 1 : 0);
        parcel.writeBundle(this.m);
        parcel.writeBundle(this.n);
    }

    public FragmentState(Parcel parcel) {
        this.f11963e = parcel.readString();
        this.f11964f = parcel.readInt();
        this.f11965g = parcel.readInt() != 0;
        this.f11966h = parcel.readInt();
        this.f11967i = parcel.readInt();
        this.j = parcel.readString();
        this.k = parcel.readInt() != 0;
        this.l = parcel.readInt() != 0;
        this.m = parcel.readBundle();
        this.n = parcel.readBundle();
    }
}
