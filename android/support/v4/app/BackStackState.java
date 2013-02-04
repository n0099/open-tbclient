package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
/* loaded from: classes.dex */
final class BackStackState implements Parcelable {
    public static final Parcelable.Creator CREATOR = new d();
    final int[] a;
    final int b;
    final int c;
    final String d;
    final int e;
    final int f;
    final CharSequence g;
    final int h;
    final CharSequence i;

    public BackStackState(Parcel parcel) {
        this.a = parcel.createIntArray();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.h = parcel.readInt();
        this.i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
    }

    public BackStackState(l lVar, b bVar) {
        int i = 0;
        for (c cVar = bVar.b; cVar != null; cVar = cVar.a) {
            if (cVar.i != null) {
                i += cVar.i.size();
            }
        }
        this.a = new int[i + (bVar.d * 7)];
        if (!bVar.k) {
            throw new IllegalStateException("Not on back stack");
        }
        int i2 = 0;
        for (c cVar2 = bVar.b; cVar2 != null; cVar2 = cVar2.a) {
            int i3 = i2 + 1;
            this.a[i2] = cVar2.c;
            int i4 = i3 + 1;
            this.a[i3] = cVar2.d.n;
            int i5 = i4 + 1;
            this.a[i4] = cVar2.e;
            int i6 = i5 + 1;
            this.a[i5] = cVar2.f;
            int i7 = i6 + 1;
            this.a[i6] = cVar2.g;
            int i8 = i7 + 1;
            this.a[i7] = cVar2.h;
            if (cVar2.i != null) {
                int size = cVar2.i.size();
                int i9 = i8 + 1;
                this.a[i8] = size;
                int i10 = 0;
                while (i10 < size) {
                    this.a[i9] = ((Fragment) cVar2.i.get(i10)).n;
                    i10++;
                    i9++;
                }
                i2 = i9;
            } else {
                i2 = i8 + 1;
                this.a[i8] = 0;
            }
        }
        this.b = bVar.i;
        this.c = bVar.j;
        this.d = bVar.m;
        this.e = bVar.o;
        this.f = bVar.p;
        this.g = bVar.q;
        this.h = bVar.r;
        this.i = bVar.s;
    }

    public b a(l lVar) {
        b bVar = new b(lVar);
        int i = 0;
        while (i < this.a.length) {
            c cVar = new c();
            int i2 = i + 1;
            cVar.c = this.a[i];
            if (l.a) {
                Log.v("FragmentManager", "BSE " + bVar + " set base fragment #" + this.a[i2]);
            }
            int i3 = i2 + 1;
            cVar.d = (Fragment) lVar.f.get(this.a[i2]);
            int i4 = i3 + 1;
            cVar.e = this.a[i3];
            int i5 = i4 + 1;
            cVar.f = this.a[i4];
            int i6 = i5 + 1;
            cVar.g = this.a[i5];
            int i7 = i6 + 1;
            cVar.h = this.a[i6];
            i = i7 + 1;
            int i8 = this.a[i7];
            if (i8 > 0) {
                cVar.i = new ArrayList(i8);
                int i9 = 0;
                while (i9 < i8) {
                    if (l.a) {
                        Log.v("FragmentManager", "BSE " + bVar + " set remove fragment #" + this.a[i]);
                    }
                    cVar.i.add((Fragment) lVar.f.get(this.a[i]));
                    i9++;
                    i++;
                }
            }
            bVar.a(cVar);
        }
        bVar.i = this.b;
        bVar.j = this.c;
        bVar.m = this.d;
        bVar.o = this.e;
        bVar.k = true;
        bVar.p = this.f;
        bVar.q = this.g;
        bVar.r = this.h;
        bVar.s = this.i;
        bVar.a(1);
        return bVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        TextUtils.writeToParcel(this.g, parcel, 0);
        parcel.writeInt(this.h);
        TextUtils.writeToParcel(this.i, parcel, 0);
    }
}
