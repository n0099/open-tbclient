package com.baidu.android.imsdk.chatuser;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class UserStatus implements Parcelable {
    public static final Parcelable.Creator<UserStatus> CREATOR = new Parcelable.Creator<UserStatus>() { // from class: com.baidu.android.imsdk.chatuser.UserStatus.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserStatus createFromParcel(Parcel parcel) {
            return new UserStatus(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserStatus[] newArray(int i2) {
            return new UserStatus[i2];
        }
    };
    public boolean mIsOnline;
    public long mLastOnlineTime;
    public long mUid;

    public UserStatus(long j, boolean z, long j2) {
        this.mUid = j;
        this.mIsOnline = z;
        this.mLastOnlineTime = j2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getLastOnlineTime() {
        return this.mLastOnlineTime;
    }

    public long getUid() {
        return this.mUid;
    }

    public boolean isOnline() {
        return this.mIsOnline;
    }

    public void setLastOnlineTime(long j) {
        this.mLastOnlineTime = j;
    }

    public void setOnline(boolean z) {
        this.mIsOnline = z;
    }

    public void setUid(long j) {
        this.mUid = j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.mUid);
        parcel.writeByte(this.mIsOnline ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.mLastOnlineTime);
    }

    public UserStatus(Parcel parcel) {
        this.mUid = parcel.readLong();
        this.mIsOnline = parcel.readByte() != 0;
        this.mLastOnlineTime = parcel.readLong();
    }
}
