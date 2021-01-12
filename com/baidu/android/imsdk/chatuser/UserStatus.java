package com.baidu.android.imsdk.chatuser;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
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
        public UserStatus[] newArray(int i) {
            return new UserStatus[i];
        }
    };
    private boolean mIsOnline;
    private long mLastOnlineTime;
    private long mUid;

    public UserStatus(long j, boolean z, long j2) {
        this.mUid = j;
        this.mIsOnline = z;
        this.mLastOnlineTime = j2;
    }

    protected UserStatus(Parcel parcel) {
        this.mUid = parcel.readLong();
        this.mIsOnline = parcel.readByte() != 0;
        this.mLastOnlineTime = parcel.readLong();
    }

    public long getUid() {
        return this.mUid;
    }

    public void setUid(long j) {
        this.mUid = j;
    }

    public boolean isOnline() {
        return this.mIsOnline;
    }

    public void setOnline(boolean z) {
        this.mIsOnline = z;
    }

    public long getLastOnlineTime() {
        return this.mLastOnlineTime;
    }

    public void setLastOnlineTime(long j) {
        this.mLastOnlineTime = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mUid);
        parcel.writeByte((byte) (this.mIsOnline ? 1 : 0));
        parcel.writeLong(this.mLastOnlineTime);
    }
}
