package com.baidu.swan.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new Parcelable.Creator<FragmentManagerState>() { // from class: com.baidu.swan.support.v4.app.FragmentManagerState.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: q */
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: fl */
        public FragmentManagerState[] newArray(int i) {
            return new FragmentManagerState[i];
        }
    };
    FragmentState[] bnZ;
    BackStackState[] boa;
    int[] mAdded;

    public FragmentManagerState() {
    }

    public FragmentManagerState(Parcel parcel) {
        this.bnZ = (FragmentState[]) parcel.createTypedArray(FragmentState.CREATOR);
        this.mAdded = parcel.createIntArray();
        this.boa = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.bnZ, i);
        parcel.writeIntArray(this.mAdded);
        parcel.writeTypedArray(this.boa, i);
    }
}
