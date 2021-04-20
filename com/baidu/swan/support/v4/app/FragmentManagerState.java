package com.baidu.swan.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new a();

    /* renamed from: e  reason: collision with root package name */
    public FragmentState[] f12702e;

    /* renamed from: f  reason: collision with root package name */
    public int[] f12703f;

    /* renamed from: g  reason: collision with root package name */
    public BackStackState[] f12704g;

    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<FragmentManagerState> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public FragmentManagerState[] newArray(int i) {
            return new FragmentManagerState[i];
        }
    }

    public FragmentManagerState() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f12702e, i);
        parcel.writeIntArray(this.f12703f);
        parcel.writeTypedArray(this.f12704g, i);
    }

    public FragmentManagerState(Parcel parcel) {
        this.f12702e = (FragmentState[]) parcel.createTypedArray(FragmentState.CREATOR);
        this.f12703f = parcel.createIntArray();
        this.f12704g = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
    }
}
