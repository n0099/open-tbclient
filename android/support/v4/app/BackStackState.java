package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
/* loaded from: classes.dex */
final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new k();

    /* renamed from: a  reason: collision with root package name */
    final int[] f273a;
    final int b;
    final int c;
    final String d;
    final int e;
    final int f;
    final CharSequence g;
    final int h;
    final CharSequence i;

    public BackStackState(v vVar, i iVar) {
        int i = 0;
        for (j jVar = iVar.b; jVar != null; jVar = jVar.f294a) {
            if (jVar.i != null) {
                i += jVar.i.size();
            }
        }
        this.f273a = new int[i + (iVar.d * 7)];
        if (!iVar.k) {
            throw new IllegalStateException("Not on back stack");
        }
        int i2 = 0;
        for (j jVar2 = iVar.b; jVar2 != null; jVar2 = jVar2.f294a) {
            int i3 = i2 + 1;
            this.f273a[i2] = jVar2.c;
            int i4 = i3 + 1;
            this.f273a[i3] = jVar2.d != null ? jVar2.d.o : -1;
            int i5 = i4 + 1;
            this.f273a[i4] = jVar2.e;
            int i6 = i5 + 1;
            this.f273a[i5] = jVar2.f;
            int i7 = i6 + 1;
            this.f273a[i6] = jVar2.g;
            int i8 = i7 + 1;
            this.f273a[i7] = jVar2.h;
            if (jVar2.i != null) {
                int size = jVar2.i.size();
                int i9 = i8 + 1;
                this.f273a[i8] = size;
                int i10 = 0;
                while (i10 < size) {
                    this.f273a[i9] = jVar2.i.get(i10).o;
                    i10++;
                    i9++;
                }
                i2 = i9;
            } else {
                i2 = i8 + 1;
                this.f273a[i8] = 0;
            }
        }
        this.b = iVar.i;
        this.c = iVar.j;
        this.d = iVar.m;
        this.e = iVar.o;
        this.f = iVar.p;
        this.g = iVar.q;
        this.h = iVar.r;
        this.i = iVar.s;
    }

    public BackStackState(Parcel parcel) {
        this.f273a = parcel.createIntArray();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.h = parcel.readInt();
        this.i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
    }

    public i a(v vVar) {
        i iVar = new i(vVar);
        int i = 0;
        int i2 = 0;
        while (i2 < this.f273a.length) {
            j jVar = new j();
            int i3 = i2 + 1;
            jVar.c = this.f273a[i2];
            if (v.f300a) {
                Log.v("FragmentManager", "Instantiate " + iVar + " op #" + i + " base fragment #" + this.f273a[i3]);
            }
            int i4 = i3 + 1;
            int i5 = this.f273a[i3];
            if (i5 >= 0) {
                jVar.d = vVar.f.get(i5);
            } else {
                jVar.d = null;
            }
            int i6 = i4 + 1;
            jVar.e = this.f273a[i4];
            int i7 = i6 + 1;
            jVar.f = this.f273a[i6];
            int i8 = i7 + 1;
            jVar.g = this.f273a[i7];
            int i9 = i8 + 1;
            jVar.h = this.f273a[i8];
            int i10 = i9 + 1;
            int i11 = this.f273a[i9];
            if (i11 > 0) {
                jVar.i = new ArrayList<>(i11);
                int i12 = 0;
                while (i12 < i11) {
                    if (v.f300a) {
                        Log.v("FragmentManager", "Instantiate " + iVar + " set remove fragment #" + this.f273a[i10]);
                    }
                    jVar.i.add(vVar.f.get(this.f273a[i10]));
                    i12++;
                    i10++;
                }
            }
            iVar.a(jVar);
            i++;
            i2 = i10;
        }
        iVar.i = this.b;
        iVar.j = this.c;
        iVar.m = this.d;
        iVar.o = this.e;
        iVar.k = true;
        iVar.p = this.f;
        iVar.q = this.g;
        iVar.r = this.h;
        iVar.s = this.i;
        iVar.a(1);
        return iVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f273a);
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
