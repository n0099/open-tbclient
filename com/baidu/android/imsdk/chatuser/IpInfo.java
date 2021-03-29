package com.baidu.android.imsdk.chatuser;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.NoProGuard;
/* loaded from: classes.dex */
public class IpInfo implements Parcelable, NoProGuard {
    public static final Parcelable.Creator<IpInfo> CREATOR = new Parcelable.Creator<IpInfo>() { // from class: com.baidu.android.imsdk.chatuser.IpInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IpInfo createFromParcel(Parcel parcel) {
            return new IpInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IpInfo[] newArray(int i) {
            return new IpInfo[i];
        }
    };
    public String mCity;
    public String mCountry;
    public String mCounty;
    public String mIp;
    public String mIsp;
    public String mProv;
    public long mUid;

    public IpInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCity() {
        return this.mCity;
    }

    public String getCountry() {
        return this.mCountry;
    }

    public String getCounty() {
        return this.mCounty;
    }

    public String getIp() {
        return this.mCountry;
    }

    public String getIsp() {
        return this.mIsp;
    }

    public String getProv() {
        return this.mProv;
    }

    public long getUid() {
        return this.mUid;
    }

    public void setCity(String str) {
        this.mCity = str;
    }

    public void setCountry(String str) {
        this.mCountry = str;
    }

    public void setCounty(String str) {
        this.mCounty = str;
    }

    public void setIp(String str) {
        this.mIp = str;
    }

    public void setIsp(String str) {
        this.mIsp = str;
    }

    public void setProv(String str) {
        this.mProv = str;
    }

    public void setUid(long j) {
        this.mUid = j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mUid);
        parcel.writeString(this.mIp);
        parcel.writeString(this.mIsp);
        parcel.writeString(this.mCountry);
        parcel.writeString(this.mProv);
        parcel.writeString(this.mCity);
        parcel.writeString(this.mCounty);
    }

    public IpInfo(Parcel parcel) {
        this.mUid = parcel.readLong();
        this.mIp = parcel.readString();
        this.mIsp = parcel.readString();
        this.mCountry = parcel.readString();
        this.mProv = parcel.readString();
        this.mCity = parcel.readString();
        this.mCounty = parcel.readString();
    }
}
