package com.baidu.swan.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import d.b.g0.m.a.a.e;
import d.b.g0.m.a.a.l;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new a();

    /* renamed from: e  reason: collision with root package name */
    public final int[] f13026e;

    /* renamed from: f  reason: collision with root package name */
    public final int f13027f;

    /* renamed from: g  reason: collision with root package name */
    public final int f13028g;

    /* renamed from: h  reason: collision with root package name */
    public final String f13029h;
    public final int i;
    public final int j;
    public final CharSequence k;
    public final int l;
    public final CharSequence m;
    public final ArrayList<String> n;
    public final ArrayList<String> o;

    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<BackStackState> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public BackStackState[] newArray(int i) {
            return new BackStackState[i];
        }
    }

    public BackStackState(e eVar) {
        int i = 0;
        for (e.d dVar = eVar.f49068f; dVar != null; dVar = dVar.f49080a) {
            ArrayList<Fragment> arrayList = dVar.i;
            if (arrayList != null) {
                i += arrayList.size();
            }
        }
        this.f13026e = new int[(eVar.f49070h * 7) + i];
        if (eVar.o) {
            int i2 = 0;
            for (e.d dVar2 = eVar.f49068f; dVar2 != null; dVar2 = dVar2.f49080a) {
                int[] iArr = this.f13026e;
                int i3 = i2 + 1;
                iArr[i2] = dVar2.f49082c;
                int i4 = i3 + 1;
                Fragment fragment = dVar2.f49083d;
                iArr[i3] = fragment != null ? fragment.j : -1;
                int[] iArr2 = this.f13026e;
                int i5 = i4 + 1;
                iArr2[i4] = dVar2.f49084e;
                int i6 = i5 + 1;
                iArr2[i5] = dVar2.f49085f;
                int i7 = i6 + 1;
                iArr2[i6] = dVar2.f49086g;
                int i8 = i7 + 1;
                iArr2[i7] = dVar2.f49087h;
                ArrayList<Fragment> arrayList2 = dVar2.i;
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    int i9 = i8 + 1;
                    this.f13026e[i8] = size;
                    int i10 = 0;
                    while (i10 < size) {
                        this.f13026e[i9] = dVar2.i.get(i10).j;
                        i10++;
                        i9++;
                    }
                    i2 = i9;
                } else {
                    iArr2[i8] = 0;
                    i2 = i8 + 1;
                }
            }
            this.f13027f = eVar.m;
            this.f13028g = eVar.n;
            this.f13029h = eVar.p;
            this.i = eVar.r;
            this.j = eVar.s;
            this.k = eVar.t;
            this.l = eVar.u;
            this.m = eVar.v;
            this.n = eVar.w;
            this.o = eVar.x;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public e a(l lVar) {
        e eVar = new e(lVar);
        int i = 0;
        int i2 = 0;
        while (i < this.f13026e.length) {
            e.d dVar = new e.d();
            int i3 = i + 1;
            dVar.f49082c = this.f13026e[i];
            if (l.x) {
                Log.v("FragmentManager", "Instantiate " + eVar + " op #" + i2 + " base fragment #" + this.f13026e[i3]);
            }
            int i4 = i3 + 1;
            int i5 = this.f13026e[i3];
            if (i5 >= 0) {
                dVar.f49083d = lVar.f49104d.get(i5);
            } else {
                dVar.f49083d = null;
            }
            int[] iArr = this.f13026e;
            int i6 = i4 + 1;
            dVar.f49084e = iArr[i4];
            int i7 = i6 + 1;
            dVar.f49085f = iArr[i6];
            int i8 = i7 + 1;
            dVar.f49086g = iArr[i7];
            int i9 = i8 + 1;
            dVar.f49087h = iArr[i8];
            int i10 = i9 + 1;
            int i11 = iArr[i9];
            if (i11 > 0) {
                dVar.i = new ArrayList<>(i11);
                int i12 = 0;
                while (i12 < i11) {
                    if (l.x) {
                        Log.v("FragmentManager", "Instantiate " + eVar + " set remove fragment #" + this.f13026e[i10]);
                    }
                    dVar.i.add(lVar.f49104d.get(this.f13026e[i10]));
                    i12++;
                    i10++;
                }
            }
            i = i10;
            eVar.m(dVar);
            i2++;
        }
        eVar.m = this.f13027f;
        eVar.n = this.f13028g;
        eVar.p = this.f13029h;
        eVar.r = this.i;
        eVar.o = true;
        eVar.s = this.j;
        eVar.t = this.k;
        eVar.u = this.l;
        eVar.v = this.m;
        eVar.w = this.n;
        eVar.x = this.o;
        eVar.o(1);
        return eVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f13026e);
        parcel.writeInt(this.f13027f);
        parcel.writeInt(this.f13028g);
        parcel.writeString(this.f13029h);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
        TextUtils.writeToParcel(this.k, parcel, 0);
        parcel.writeInt(this.l);
        TextUtils.writeToParcel(this.m, parcel, 0);
        parcel.writeStringList(this.n);
        parcel.writeStringList(this.o);
    }

    public BackStackState(Parcel parcel) {
        this.f13026e = parcel.createIntArray();
        this.f13027f = parcel.readInt();
        this.f13028g = parcel.readInt();
        this.f13029h = parcel.readString();
        this.i = parcel.readInt();
        this.j = parcel.readInt();
        this.k = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.l = parcel.readInt();
        this.m = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.n = parcel.createStringArrayList();
        this.o = parcel.createStringArrayList();
    }
}
