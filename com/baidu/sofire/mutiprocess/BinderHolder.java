package com.baidu.sofire.mutiprocess;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes15.dex */
public class BinderHolder implements Parcelable {
    public static final Parcelable.Creator<BinderHolder> CREATOR = new Parcelable.Creator<BinderHolder>() { // from class: com.baidu.sofire.mutiprocess.BinderHolder.1
        /* JADX DEBUG: Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BinderHolder[] newArray(int i) {
            return new BinderHolder[i];
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BinderHolder createFromParcel(Parcel parcel) {
            return new BinderHolder(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public IBinder f5589a;

    public BinderHolder(IBinder iBinder) {
        this.f5589a = iBinder;
    }

    protected BinderHolder(Parcel parcel) {
        this.f5589a = parcel.readStrongBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.f5589a);
    }
}
