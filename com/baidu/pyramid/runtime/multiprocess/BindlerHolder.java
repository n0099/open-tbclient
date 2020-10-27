package com.baidu.pyramid.runtime.multiprocess;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes16.dex */
public class BindlerHolder implements Parcelable {
    public static final Parcelable.Creator<BindlerHolder> CREATOR = new Parcelable.Creator<BindlerHolder>() { // from class: com.baidu.pyramid.runtime.multiprocess.BindlerHolder.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: o */
        public BindlerHolder createFromParcel(Parcel parcel) {
            return new BindlerHolder(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: gQ */
        public BindlerHolder[] newArray(int i) {
            return new BindlerHolder[i];
        }
    };
    private IBinder mBinder;

    /* JADX INFO: Access modifiers changed from: protected */
    public BindlerHolder(IBinder iBinder) {
        this.mBinder = iBinder;
    }

    protected BindlerHolder(Parcel parcel) {
        this.mBinder = parcel.readStrongBinder();
    }

    public IBinder aaK() {
        return this.mBinder;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.mBinder);
    }
}
