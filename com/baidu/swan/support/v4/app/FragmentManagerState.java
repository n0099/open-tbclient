package com.baidu.swan.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new a();

    /* renamed from: e  reason: collision with root package name */
    public FragmentState[] f13041e;

    /* renamed from: f  reason: collision with root package name */
    public int[] f13042f;

    /* renamed from: g  reason: collision with root package name */
    public BackStackState[] f13043g;

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
        parcel.writeTypedArray(this.f13041e, i);
        parcel.writeIntArray(this.f13042f);
        parcel.writeTypedArray(this.f13043g, i);
    }

    public FragmentManagerState(Parcel parcel) {
        this.f13041e = (FragmentState[]) parcel.createTypedArray(FragmentState.CREATOR);
        this.f13042f = parcel.createIntArray();
        this.f13043g = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
    }
}
