package com.baidu.swan.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.kp4;
import com.baidu.tieba.sp4;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new a();
    public final int mBreadCrumbShortTitleRes;
    public final CharSequence mBreadCrumbShortTitleText;
    public final int mBreadCrumbTitleRes;
    public final CharSequence mBreadCrumbTitleText;
    public final int mIndex;
    public final String mName;
    public final int[] mOps;
    public final ArrayList<String> mSharedElementSourceNames;
    public final ArrayList<String> mSharedElementTargetNames;
    public final int mTransition;
    public final int mTransitionStyle;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* loaded from: classes4.dex */
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

    public BackStackState(Parcel parcel) {
        this.mOps = parcel.createIntArray();
        this.mTransition = parcel.readInt();
        this.mTransitionStyle = parcel.readInt();
        this.mName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.mBreadCrumbTitleRes = parcel.readInt();
        this.mBreadCrumbTitleText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mBreadCrumbShortTitleRes = parcel.readInt();
        this.mBreadCrumbShortTitleText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mSharedElementSourceNames = parcel.createStringArrayList();
        this.mSharedElementTargetNames = parcel.createStringArrayList();
    }

    public BackStackState(kp4 kp4Var) {
        int i;
        int i2 = 0;
        for (kp4.d dVar = kp4Var.b; dVar != null; dVar = dVar.a) {
            ArrayList<Fragment> arrayList = dVar.i;
            if (arrayList != null) {
                i2 += arrayList.size();
            }
        }
        this.mOps = new int[(kp4Var.d * 7) + i2];
        if (kp4Var.k) {
            int i3 = 0;
            for (kp4.d dVar2 = kp4Var.b; dVar2 != null; dVar2 = dVar2.a) {
                int[] iArr = this.mOps;
                int i4 = i3 + 1;
                iArr[i3] = dVar2.c;
                int i5 = i4 + 1;
                Fragment fragment = dVar2.d;
                if (fragment != null) {
                    i = fragment.f;
                } else {
                    i = -1;
                }
                iArr[i4] = i;
                int[] iArr2 = this.mOps;
                int i6 = i5 + 1;
                iArr2[i5] = dVar2.e;
                int i7 = i6 + 1;
                iArr2[i6] = dVar2.f;
                int i8 = i7 + 1;
                iArr2[i7] = dVar2.g;
                int i9 = i8 + 1;
                iArr2[i8] = dVar2.h;
                ArrayList<Fragment> arrayList2 = dVar2.i;
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    int i10 = i9 + 1;
                    this.mOps[i9] = size;
                    int i11 = 0;
                    while (i11 < size) {
                        this.mOps[i10] = dVar2.i.get(i11).f;
                        i11++;
                        i10++;
                    }
                    i3 = i10;
                } else {
                    iArr2[i9] = 0;
                    i3 = i9 + 1;
                }
            }
            this.mTransition = kp4Var.i;
            this.mTransitionStyle = kp4Var.j;
            this.mName = kp4Var.m;
            this.mIndex = kp4Var.o;
            this.mBreadCrumbTitleRes = kp4Var.p;
            this.mBreadCrumbTitleText = kp4Var.q;
            this.mBreadCrumbShortTitleRes = kp4Var.r;
            this.mBreadCrumbShortTitleText = kp4Var.s;
            this.mSharedElementSourceNames = kp4Var.t;
            this.mSharedElementTargetNames = kp4Var.u;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public kp4 instantiate(sp4 sp4Var) {
        kp4 kp4Var = new kp4(sp4Var);
        int i = 0;
        int i2 = 0;
        while (i < this.mOps.length) {
            kp4.d dVar = new kp4.d();
            int i3 = i + 1;
            dVar.c = this.mOps[i];
            if (sp4.x) {
                Log.v("FragmentManager", "Instantiate " + kp4Var + " op #" + i2 + " base fragment #" + this.mOps[i3]);
            }
            int i4 = i3 + 1;
            int i5 = this.mOps[i3];
            if (i5 >= 0) {
                dVar.d = sp4Var.d.get(i5);
            } else {
                dVar.d = null;
            }
            int[] iArr = this.mOps;
            int i6 = i4 + 1;
            dVar.e = iArr[i4];
            int i7 = i6 + 1;
            dVar.f = iArr[i6];
            int i8 = i7 + 1;
            dVar.g = iArr[i7];
            int i9 = i8 + 1;
            dVar.h = iArr[i8];
            int i10 = i9 + 1;
            int i11 = iArr[i9];
            if (i11 > 0) {
                dVar.i = new ArrayList<>(i11);
                int i12 = 0;
                while (i12 < i11) {
                    if (sp4.x) {
                        Log.v("FragmentManager", "Instantiate " + kp4Var + " set remove fragment #" + this.mOps[i10]);
                    }
                    dVar.i.add(sp4Var.d.get(this.mOps[i10]));
                    i12++;
                    i10++;
                }
            }
            i = i10;
            kp4Var.o(dVar);
            i2++;
        }
        kp4Var.i = this.mTransition;
        kp4Var.j = this.mTransitionStyle;
        kp4Var.m = this.mName;
        kp4Var.o = this.mIndex;
        kp4Var.k = true;
        kp4Var.p = this.mBreadCrumbTitleRes;
        kp4Var.q = this.mBreadCrumbTitleText;
        kp4Var.r = this.mBreadCrumbShortTitleRes;
        kp4Var.s = this.mBreadCrumbShortTitleText;
        kp4Var.t = this.mSharedElementSourceNames;
        kp4Var.u = this.mSharedElementTargetNames;
        kp4Var.q(1);
        return kp4Var;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.mOps);
        parcel.writeInt(this.mTransition);
        parcel.writeInt(this.mTransitionStyle);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.mBreadCrumbTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbTitleText, parcel, 0);
        parcel.writeInt(this.mBreadCrumbShortTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, parcel, 0);
        parcel.writeStringList(this.mSharedElementSourceNames);
        parcel.writeStringList(this.mSharedElementTargetNames);
    }
}
