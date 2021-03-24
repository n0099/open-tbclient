package com.baidu.swan.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new a();

    /* renamed from: e  reason: collision with root package name */
    public FragmentState[] f13040e;

    /* renamed from: f  reason: collision with root package name */
    public int[] f13041f;

    /* renamed from: g  reason: collision with root package name */
    public BackStackState[] f13042g;

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
        parcel.writeTypedArray(this.f13040e, i);
        parcel.writeIntArray(this.f13041f);
        parcel.writeTypedArray(this.f13042g, i);
    }

    public FragmentManagerState(Parcel parcel) {
        this.f13040e = (FragmentState[]) parcel.createTypedArray(FragmentState.CREATOR);
        this.f13041f = parcel.createIntArray();
        this.f13042g = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
    }
}
