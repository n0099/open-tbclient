package com.baidu.storage.swankv;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.io.IOException;
/* loaded from: classes2.dex */
public class AshmemFileDescriptor implements Parcelable {
    public static final Parcelable.Creator<AshmemFileDescriptor> CREATOR = new a();
    public int mAshmemFD;
    public final String mName;
    public final int mSize;

    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<AshmemFileDescriptor> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AshmemFileDescriptor createFromParcel(Parcel parcel) {
            return new AshmemFileDescriptor(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AshmemFileDescriptor[] newArray(int i2) {
            return new AshmemFileDescriptor[i2];
        }
    }

    public AshmemFileDescriptor(@NonNull String str, int i2, int i3) {
        this.mAshmemFD = -1;
        this.mName = str;
        this.mAshmemFD = i2;
        this.mSize = i3;
    }

    public int a() {
        return this.mAshmemFD;
    }

    public String b() {
        return this.mName;
    }

    public int c() {
        return this.mSize;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        try {
            parcel.writeString(this.mName);
            ParcelFileDescriptor.fromFd(this.mAshmemFD).writeToParcel(parcel, i2 | 1);
            parcel.writeInt(this.mSize);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public AshmemFileDescriptor(Parcel parcel) {
        this.mAshmemFD = -1;
        this.mName = parcel.readString();
        this.mAshmemFD = ((ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel)).detachFd();
        this.mSize = parcel.readInt();
    }
}
