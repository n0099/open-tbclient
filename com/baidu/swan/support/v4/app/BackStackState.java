package com.baidu.swan.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.support.v4.app.e;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator<BackStackState>() { // from class: com.baidu.swan.support.v4.app.BackStackState.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: F */
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: nb */
        public BackStackState[] newArray(int i) {
            return new BackStackState[i];
        }
    };
    final int mBreadCrumbShortTitleRes;
    final CharSequence mBreadCrumbShortTitleText;
    final int mBreadCrumbTitleRes;
    final CharSequence mBreadCrumbTitleText;
    final int mIndex;
    final String mName;
    final int[] mOps;
    final ArrayList<String> mSharedElementSourceNames;
    final ArrayList<String> mSharedElementTargetNames;
    final int mTransition;
    final int mTransitionStyle;

    public BackStackState(e eVar) {
        int i = 0;
        for (e.a aVar = eVar.ejA; aVar != null; aVar = aVar.ejM) {
            if (aVar.ejP != null) {
                i += aVar.ejP.size();
            }
        }
        this.mOps = new int[i + (eVar.ejC * 7)];
        if (!eVar.mAddToBackStack) {
            throw new IllegalStateException("Not on back stack");
        }
        int i2 = 0;
        for (e.a aVar2 = eVar.ejA; aVar2 != null; aVar2 = aVar2.ejM) {
            int i3 = i2 + 1;
            this.mOps[i2] = aVar2.cmd;
            int i4 = i3 + 1;
            this.mOps[i3] = aVar2.ejO != null ? aVar2.ejO.mIndex : -1;
            int i5 = i4 + 1;
            this.mOps[i4] = aVar2.enterAnim;
            int i6 = i5 + 1;
            this.mOps[i5] = aVar2.exitAnim;
            int i7 = i6 + 1;
            this.mOps[i6] = aVar2.popEnterAnim;
            int i8 = i7 + 1;
            this.mOps[i7] = aVar2.popExitAnim;
            if (aVar2.ejP != null) {
                int size = aVar2.ejP.size();
                int i9 = i8 + 1;
                this.mOps[i8] = size;
                int i10 = 0;
                while (i10 < size) {
                    this.mOps[i9] = aVar2.ejP.get(i10).mIndex;
                    i10++;
                    i9++;
                }
                i2 = i9;
            } else {
                i2 = i8 + 1;
                this.mOps[i8] = 0;
            }
        }
        this.mTransition = eVar.mTransition;
        this.mTransitionStyle = eVar.mTransitionStyle;
        this.mName = eVar.mName;
        this.mIndex = eVar.mIndex;
        this.mBreadCrumbTitleRes = eVar.mBreadCrumbTitleRes;
        this.mBreadCrumbTitleText = eVar.mBreadCrumbTitleText;
        this.mBreadCrumbShortTitleRes = eVar.mBreadCrumbShortTitleRes;
        this.mBreadCrumbShortTitleText = eVar.mBreadCrumbShortTitleText;
        this.mSharedElementSourceNames = eVar.mSharedElementSourceNames;
        this.mSharedElementTargetNames = eVar.mSharedElementTargetNames;
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

    public e a(l lVar) {
        e eVar = new e(lVar);
        int i = 0;
        int i2 = 0;
        while (i2 < this.mOps.length) {
            e.a aVar = new e.a();
            int i3 = i2 + 1;
            aVar.cmd = this.mOps[i2];
            if (l.DEBUG) {
                Log.v("FragmentManager", "Instantiate " + eVar + " op #" + i + " base fragment #" + this.mOps[i3]);
            }
            int i4 = i3 + 1;
            int i5 = this.mOps[i3];
            if (i5 >= 0) {
                aVar.ejO = lVar.eko.get(i5);
            } else {
                aVar.ejO = null;
            }
            int i6 = i4 + 1;
            aVar.enterAnim = this.mOps[i4];
            int i7 = i6 + 1;
            aVar.exitAnim = this.mOps[i6];
            int i8 = i7 + 1;
            aVar.popEnterAnim = this.mOps[i7];
            int i9 = i8 + 1;
            aVar.popExitAnim = this.mOps[i8];
            int i10 = i9 + 1;
            int i11 = this.mOps[i9];
            if (i11 > 0) {
                aVar.ejP = new ArrayList<>(i11);
                int i12 = 0;
                while (i12 < i11) {
                    if (l.DEBUG) {
                        Log.v("FragmentManager", "Instantiate " + eVar + " set remove fragment #" + this.mOps[i10]);
                    }
                    aVar.ejP.add(lVar.eko.get(this.mOps[i10]));
                    i12++;
                    i10++;
                }
            }
            eVar.a(aVar);
            i++;
            i2 = i10;
        }
        eVar.mTransition = this.mTransition;
        eVar.mTransitionStyle = this.mTransitionStyle;
        eVar.mName = this.mName;
        eVar.mIndex = this.mIndex;
        eVar.mAddToBackStack = true;
        eVar.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
        eVar.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
        eVar.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
        eVar.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
        eVar.mSharedElementSourceNames = this.mSharedElementSourceNames;
        eVar.mSharedElementTargetNames = this.mSharedElementTargetNames;
        eVar.bumpBackStackNesting(1);
        return eVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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
