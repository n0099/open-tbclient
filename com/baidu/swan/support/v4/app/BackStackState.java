package com.baidu.swan.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import d.a.m0.o.a.a.e;
import d.a.m0.o.a.a.m;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new a();

    /* renamed from: e  reason: collision with root package name */
    public final int[] f11988e;

    /* renamed from: f  reason: collision with root package name */
    public final int f11989f;

    /* renamed from: g  reason: collision with root package name */
    public final int f11990g;

    /* renamed from: h  reason: collision with root package name */
    public final String f11991h;

    /* renamed from: i  reason: collision with root package name */
    public final int f11992i;
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
        public BackStackState[] newArray(int i2) {
            return new BackStackState[i2];
        }
    }

    public BackStackState(e eVar) {
        int i2 = 0;
        for (e.d dVar = eVar.f51977f; dVar != null; dVar = dVar.f51992a) {
            ArrayList<Fragment> arrayList = dVar.f52000i;
            if (arrayList != null) {
                i2 += arrayList.size();
            }
        }
        this.f11988e = new int[(eVar.f51979h * 7) + i2];
        if (eVar.o) {
            int i3 = 0;
            for (e.d dVar2 = eVar.f51977f; dVar2 != null; dVar2 = dVar2.f51992a) {
                int[] iArr = this.f11988e;
                int i4 = i3 + 1;
                iArr[i3] = dVar2.f51994c;
                int i5 = i4 + 1;
                Fragment fragment = dVar2.f51995d;
                iArr[i4] = fragment != null ? fragment.j : -1;
                int[] iArr2 = this.f11988e;
                int i6 = i5 + 1;
                iArr2[i5] = dVar2.f51996e;
                int i7 = i6 + 1;
                iArr2[i6] = dVar2.f51997f;
                int i8 = i7 + 1;
                iArr2[i7] = dVar2.f51998g;
                int i9 = i8 + 1;
                iArr2[i8] = dVar2.f51999h;
                ArrayList<Fragment> arrayList2 = dVar2.f52000i;
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    int i10 = i9 + 1;
                    this.f11988e[i9] = size;
                    int i11 = 0;
                    while (i11 < size) {
                        this.f11988e[i10] = dVar2.f52000i.get(i11).j;
                        i11++;
                        i10++;
                    }
                    i3 = i10;
                } else {
                    iArr2[i9] = 0;
                    i3 = i9 + 1;
                }
            }
            this.f11989f = eVar.m;
            this.f11990g = eVar.n;
            this.f11991h = eVar.p;
            this.f11992i = eVar.r;
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

    public e a(m mVar) {
        e eVar = new e(mVar);
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.f11988e.length) {
            e.d dVar = new e.d();
            int i4 = i2 + 1;
            dVar.f51994c = this.f11988e[i2];
            if (m.x) {
                Log.v("FragmentManager", "Instantiate " + eVar + " op #" + i3 + " base fragment #" + this.f11988e[i4]);
            }
            int i5 = i4 + 1;
            int i6 = this.f11988e[i4];
            if (i6 >= 0) {
                dVar.f51995d = mVar.f52017d.get(i6);
            } else {
                dVar.f51995d = null;
            }
            int[] iArr = this.f11988e;
            int i7 = i5 + 1;
            dVar.f51996e = iArr[i5];
            int i8 = i7 + 1;
            dVar.f51997f = iArr[i7];
            int i9 = i8 + 1;
            dVar.f51998g = iArr[i8];
            int i10 = i9 + 1;
            dVar.f51999h = iArr[i9];
            int i11 = i10 + 1;
            int i12 = iArr[i10];
            if (i12 > 0) {
                dVar.f52000i = new ArrayList<>(i12);
                int i13 = 0;
                while (i13 < i12) {
                    if (m.x) {
                        Log.v("FragmentManager", "Instantiate " + eVar + " set remove fragment #" + this.f11988e[i11]);
                    }
                    dVar.f52000i.add(mVar.f52017d.get(this.f11988e[i11]));
                    i13++;
                    i11++;
                }
            }
            i2 = i11;
            eVar.n(dVar);
            i3++;
        }
        eVar.m = this.f11989f;
        eVar.n = this.f11990g;
        eVar.p = this.f11991h;
        eVar.r = this.f11992i;
        eVar.o = true;
        eVar.s = this.j;
        eVar.t = this.k;
        eVar.u = this.l;
        eVar.v = this.m;
        eVar.w = this.n;
        eVar.x = this.o;
        eVar.p(1);
        return eVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeIntArray(this.f11988e);
        parcel.writeInt(this.f11989f);
        parcel.writeInt(this.f11990g);
        parcel.writeString(this.f11991h);
        parcel.writeInt(this.f11992i);
        parcel.writeInt(this.j);
        TextUtils.writeToParcel(this.k, parcel, 0);
        parcel.writeInt(this.l);
        TextUtils.writeToParcel(this.m, parcel, 0);
        parcel.writeStringList(this.n);
        parcel.writeStringList(this.o);
    }

    public BackStackState(Parcel parcel) {
        this.f11988e = parcel.createIntArray();
        this.f11989f = parcel.readInt();
        this.f11990g = parcel.readInt();
        this.f11991h = parcel.readString();
        this.f11992i = parcel.readInt();
        this.j = parcel.readInt();
        this.k = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.l = parcel.readInt();
        this.m = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.n = parcel.createStringArrayList();
        this.o = parcel.createStringArrayList();
    }
}
