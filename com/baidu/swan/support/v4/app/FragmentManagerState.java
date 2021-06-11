package com.baidu.swan.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new a();

    /* renamed from: e  reason: collision with root package name */
    public FragmentState[] f11923e;

    /* renamed from: f  reason: collision with root package name */
    public int[] f11924f;

    /* renamed from: g  reason: collision with root package name */
    public BackStackState[] f11925g;

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
        public FragmentManagerState[] newArray(int i2) {
            return new FragmentManagerState[i2];
        }
    }

    public FragmentManagerState() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedArray(this.f11923e, i2);
        parcel.writeIntArray(this.f11924f);
        parcel.writeTypedArray(this.f11925g, i2);
    }

    public FragmentManagerState(Parcel parcel) {
        this.f11923e = (FragmentState[]) parcel.createTypedArray(FragmentState.CREATOR);
        this.f11924f = parcel.createIntArray();
        this.f11925g = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
    }
}
