package com.baidu.android.imsdk.chatuser;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.NoProGuard;
/* loaded from: classes6.dex */
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
    private String mCity;
    private String mCountry;
    private String mCounty;
    private String mIp;
    private String mIsp;
    private String mProv;
    private long mUid;

    public IpInfo() {
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

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setUid(long j) {
        this.mUid = j;
    }

    public long getUid() {
        return this.mUid;
    }

    public void setIp(String str) {
        this.mIp = str;
    }

    public String getCountry() {
        return this.mCountry;
    }

    public void setCountry(String str) {
        this.mCountry = str;
    }

    public String getIp() {
        return this.mCountry;
    }

    public void setProv(String str) {
        this.mProv = str;
    }

    public String getProv() {
        return this.mProv;
    }

    public void setCity(String str) {
        this.mCity = str;
    }

    public String getCity() {
        return this.mCity;
    }

    public void setCounty(String str) {
        this.mCounty = str;
    }

    public String getCounty() {
        return this.mCounty;
    }

    public void setIsp(String str) {
        this.mIsp = str;
    }

    public String getIsp() {
        return this.mIsp;
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
}
