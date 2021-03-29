package com.baidu.swan.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import d.b.g0.m.a.a.j;
import d.b.g0.m.a.a.l;
/* loaded from: classes3.dex */
public final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new a();

    /* renamed from: e  reason: collision with root package name */
    public final String f13044e;

    /* renamed from: f  reason: collision with root package name */
    public final int f13045f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f13046g;

    /* renamed from: h  reason: collision with root package name */
    public final int f13047h;
    public final int i;
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
        public FragmentState[] newArray(int i) {
            return new FragmentState[i];
        }
    }

    public FragmentState(Fragment fragment) {
        this.f13044e = fragment.getClass().getName();
        this.f13045f = fragment.j;
        this.f13046g = fragment.s;
        this.f13047h = fragment.A;
        this.i = fragment.B;
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
        this.o = Fragment.g0(h2, this.f13044e, this.m);
        Bundle bundle2 = this.n;
        if (bundle2 != null) {
            bundle2.setClassLoader(h2.getClassLoader());
            this.o.f13034h = this.n;
        }
        this.o.e1(this.f13045f, fragment);
        Fragment fragment3 = this.o;
        fragment3.s = this.f13046g;
        fragment3.u = true;
        fragment3.A = this.f13047h;
        fragment3.B = this.i;
        fragment3.C = this.j;
        fragment3.F = this.k;
        fragment3.E = this.l;
        fragment3.w = jVar.f49097d;
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
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f13044e);
        parcel.writeInt(this.f13045f);
        parcel.writeInt(this.f13046g ? 1 : 0);
        parcel.writeInt(this.f13047h);
        parcel.writeInt(this.i);
        parcel.writeString(this.j);
        parcel.writeInt(this.k ? 1 : 0);
        parcel.writeInt(this.l ? 1 : 0);
        parcel.writeBundle(this.m);
        parcel.writeBundle(this.n);
    }

    public FragmentState(Parcel parcel) {
        this.f13044e = parcel.readString();
        this.f13045f = parcel.readInt();
        this.f13046g = parcel.readInt() != 0;
        this.f13047h = parcel.readInt();
        this.i = parcel.readInt();
        this.j = parcel.readString();
        this.k = parcel.readInt() != 0;
        this.l = parcel.readInt() != 0;
        this.m = parcel.readBundle();
        this.n = parcel.readBundle();
    }
}
