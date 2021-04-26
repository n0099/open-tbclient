package com.baidu.pyramid.runtime.multiprocess;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class BindlerHolder implements Parcelable {
    public static final Parcelable.Creator<BindlerHolder> CREATOR = new a();
    public IBinder mBinder;

    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<BindlerHolder> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public BindlerHolder createFromParcel(Parcel parcel) {
            return new BindlerHolder(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public BindlerHolder[] newArray(int i2) {
            return new BindlerHolder[i2];
        }
    }

    public BindlerHolder(IBinder iBinder) {
        this.mBinder = iBinder;
    }

    public IBinder a() {
        return this.mBinder;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeStrongBinder(this.mBinder);
    }

    public BindlerHolder(Parcel parcel) {
        this.mBinder = parcel.readStrongBinder();
    }
}
