package com.baidu.swan.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new Parcelable.Creator<FragmentManagerState>() { // from class: com.baidu.swan.support.v4.app.FragmentManagerState.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: L */
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: iy */
        public FragmentManagerState[] newArray(int i) {
            return new FragmentManagerState[i];
        }
    };
    FragmentState[] czj;
    BackStackState[] czk;
    int[] mAdded;

    public FragmentManagerState() {
    }

    public FragmentManagerState(Parcel parcel) {
        this.czj = (FragmentState[]) parcel.createTypedArray(FragmentState.CREATOR);
        this.mAdded = parcel.createIntArray();
        this.czk = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.czj, i);
        parcel.writeIntArray(this.mAdded);
        parcel.writeTypedArray(this.czk, i);
    }
}
