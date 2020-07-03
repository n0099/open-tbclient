package com.baidu.swan.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new Parcelable.Creator<FragmentManagerState>() { // from class: com.baidu.swan.support.v4.app.FragmentManagerState.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: E */
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: jC */
        public FragmentManagerState[] newArray(int i) {
            return new FragmentManagerState[i];
        }
    };
    FragmentState[] dta;
    BackStackState[] dtb;
    int[] mAdded;

    public FragmentManagerState() {
    }

    public FragmentManagerState(Parcel parcel) {
        this.dta = (FragmentState[]) parcel.createTypedArray(FragmentState.CREATOR);
        this.mAdded = parcel.createIntArray();
        this.dtb = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.dta, i);
        parcel.writeIntArray(this.mAdded);
        parcel.writeTypedArray(this.dtb, i);
    }
}
