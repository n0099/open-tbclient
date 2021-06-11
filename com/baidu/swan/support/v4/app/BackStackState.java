package com.baidu.swan.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import d.a.l0.o.a.a.e;
import d.a.l0.o.a.a.m;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new a();

    /* renamed from: e  reason: collision with root package name */
    public final int[] f11906e;

    /* renamed from: f  reason: collision with root package name */
    public final int f11907f;

    /* renamed from: g  reason: collision with root package name */
    public final int f11908g;

    /* renamed from: h  reason: collision with root package name */
    public final String f11909h;

    /* renamed from: i  reason: collision with root package name */
    public final int f11910i;
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
        for (e.d dVar = eVar.f51869f; dVar != null; dVar = dVar.f51884a) {
            ArrayList<Fragment> arrayList = dVar.f51892i;
            if (arrayList != null) {
                i2 += arrayList.size();
            }
        }
        this.f11906e = new int[(eVar.f51871h * 7) + i2];
        if (eVar.o) {
            int i3 = 0;
            for (e.d dVar2 = eVar.f51869f; dVar2 != null; dVar2 = dVar2.f51884a) {
                int[] iArr = this.f11906e;
                int i4 = i3 + 1;
                iArr[i3] = dVar2.f51886c;
                int i5 = i4 + 1;
                Fragment fragment = dVar2.f51887d;
                iArr[i4] = fragment != null ? fragment.j : -1;
                int[] iArr2 = this.f11906e;
                int i6 = i5 + 1;
                iArr2[i5] = dVar2.f51888e;
                int i7 = i6 + 1;
                iArr2[i6] = dVar2.f51889f;
                int i8 = i7 + 1;
                iArr2[i7] = dVar2.f51890g;
                int i9 = i8 + 1;
                iArr2[i8] = dVar2.f51891h;
                ArrayList<Fragment> arrayList2 = dVar2.f51892i;
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    int i10 = i9 + 1;
                    this.f11906e[i9] = size;
                    int i11 = 0;
                    while (i11 < size) {
                        this.f11906e[i10] = dVar2.f51892i.get(i11).j;
                        i11++;
                        i10++;
                    }
                    i3 = i10;
                } else {
                    iArr2[i9] = 0;
                    i3 = i9 + 1;
                }
            }
            this.f11907f = eVar.m;
            this.f11908g = eVar.n;
            this.f11909h = eVar.p;
            this.f11910i = eVar.r;
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
        while (i2 < this.f11906e.length) {
            e.d dVar = new e.d();
            int i4 = i2 + 1;
            dVar.f51886c = this.f11906e[i2];
            if (m.x) {
                Log.v("FragmentManager", "Instantiate " + eVar + " op #" + i3 + " base fragment #" + this.f11906e[i4]);
            }
            int i5 = i4 + 1;
            int i6 = this.f11906e[i4];
            if (i6 >= 0) {
                dVar.f51887d = mVar.f51909d.get(i6);
            } else {
                dVar.f51887d = null;
            }
            int[] iArr = this.f11906e;
            int i7 = i5 + 1;
            dVar.f51888e = iArr[i5];
            int i8 = i7 + 1;
            dVar.f51889f = iArr[i7];
            int i9 = i8 + 1;
            dVar.f51890g = iArr[i8];
            int i10 = i9 + 1;
            dVar.f51891h = iArr[i9];
            int i11 = i10 + 1;
            int i12 = iArr[i10];
            if (i12 > 0) {
                dVar.f51892i = new ArrayList<>(i12);
                int i13 = 0;
                while (i13 < i12) {
                    if (m.x) {
                        Log.v("FragmentManager", "Instantiate " + eVar + " set remove fragment #" + this.f11906e[i11]);
                    }
                    dVar.f51892i.add(mVar.f51909d.get(this.f11906e[i11]));
                    i13++;
                    i11++;
                }
            }
            i2 = i11;
            eVar.n(dVar);
            i3++;
        }
        eVar.m = this.f11907f;
        eVar.n = this.f11908g;
        eVar.p = this.f11909h;
        eVar.r = this.f11910i;
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
        parcel.writeIntArray(this.f11906e);
        parcel.writeInt(this.f11907f);
        parcel.writeInt(this.f11908g);
        parcel.writeString(this.f11909h);
        parcel.writeInt(this.f11910i);
        parcel.writeInt(this.j);
        TextUtils.writeToParcel(this.k, parcel, 0);
        parcel.writeInt(this.l);
        TextUtils.writeToParcel(this.m, parcel, 0);
        parcel.writeStringList(this.n);
        parcel.writeStringList(this.o);
    }

    public BackStackState(Parcel parcel) {
        this.f11906e = parcel.createIntArray();
        this.f11907f = parcel.readInt();
        this.f11908g = parcel.readInt();
        this.f11909h = parcel.readString();
        this.f11910i = parcel.readInt();
        this.j = parcel.readInt();
        this.k = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.l = parcel.readInt();
        this.m = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.n = parcel.createStringArrayList();
        this.o = parcel.createStringArrayList();
    }
}
