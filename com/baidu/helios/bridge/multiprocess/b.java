package com.baidu.helios.bridge.multiprocess;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes6.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.baidu.helios.bridge.multiprocess.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: dp */
        public b[] newArray(int i) {
            return new b[i];
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: e */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private IBinder f2456a;

    public b(IBinder iBinder) {
        this.f2456a = iBinder;
    }

    protected b(Parcel parcel) {
        this.f2456a = parcel.readStrongBinder();
    }

    public IBinder a() {
        return this.f2456a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.f2456a);
    }
}
