package com.baidu.android.imsdk.chatuser;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.android.imsdk.utils.PinYinUtils;
/* loaded from: classes2.dex */
public final class ChatUser implements Parcelable, NoProGuard, PinYinUtils.PinYinObject {
    public static final Parcelable.Creator<ChatUser> CREATOR = new Parcelable.Creator<ChatUser>() { // from class: com.baidu.android.imsdk.chatuser.ChatUser.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ChatUser createFromParcel(Parcel parcel) {
            return new ChatUser(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ChatUser[] newArray(int i) {
            return new ChatUser[i];
        }
    };
    private int mAccountType;
    private int mAttrBlack;
    private int mAttrDisturb;
    private long mBuid;
    public String mIconUrl;
    private IpInfo mIpInfo;
    private int mIsIpLocatonExist;
    private long mPhone;
    private int mSex;
    private String mTinyUrl;
    private long mUk;
    private String mUserDetail;
    private String mUserName;
    private String mUserNamePy;

    public ChatUser(long j, long j2, String str, String str2) {
        this.mUserName = "";
        this.mIconUrl = "";
        this.mSex = 0;
        this.mTinyUrl = "";
        this.mPhone = 0L;
        this.mUserDetail = "";
        this.mUserNamePy = "";
        this.mAccountType = -1;
        this.mIsIpLocatonExist = 1;
        this.mUk = j;
        this.mBuid = j2;
        this.mUserName = str;
        this.mIconUrl = str2;
    }

    ChatUser(Parcel parcel) {
        this.mUserName = "";
        this.mIconUrl = "";
        this.mSex = 0;
        this.mTinyUrl = "";
        this.mPhone = 0L;
        this.mUserDetail = "";
        this.mUserNamePy = "";
        this.mAccountType = -1;
        this.mIsIpLocatonExist = 1;
        this.mUk = parcel.readLong();
        this.mBuid = parcel.readLong();
        this.mUserName = parcel.readString();
        this.mIconUrl = parcel.readString();
        this.mSex = parcel.readInt();
        this.mTinyUrl = parcel.readString();
        this.mPhone = parcel.readLong();
        this.mUserDetail = parcel.readString();
        this.mUserNamePy = parcel.readString();
        this.mAccountType = parcel.readInt();
        this.mIsIpLocatonExist = parcel.readInt();
        this.mIpInfo = (IpInfo) parcel.readParcelable(IpInfo.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mUk);
        parcel.writeLong(this.mBuid);
        parcel.writeString(this.mUserName);
        parcel.writeString(this.mIconUrl);
        parcel.writeInt(this.mSex);
        parcel.writeString(this.mTinyUrl);
        parcel.writeLong(this.mPhone);
        parcel.writeString(this.mUserDetail);
        parcel.writeString(this.mUserNamePy);
        parcel.writeInt(this.mAccountType);
        parcel.writeInt(this.mIsIpLocatonExist);
        parcel.writeParcelable(this.mIpInfo, i);
    }

    public IpInfo getIpInfo() {
        return this.mIpInfo;
    }

    public void setIpInfo(IpInfo ipInfo) {
        this.mIpInfo = ipInfo;
    }

    public boolean isIpLocationExist() {
        return this.mIsIpLocatonExist == 0;
    }

    public void setIsIpLocationExist(int i) {
        this.mIsIpLocatonExist = i;
    }

    @Deprecated
    public int getIsIpLocationExist() {
        return this.mIsIpLocatonExist;
    }

    public int getAccountType() {
        return this.mAccountType;
    }

    public void setAccountType(int i) {
        this.mAccountType = i;
    }

    public boolean isAnonymousUser() {
        return this.mAccountType == 0;
    }

    @Deprecated
    public long getUserId() {
        return this.mUk;
    }

    public long getUk() {
        return this.mUk;
    }

    public long getBuid() {
        return this.mBuid;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public void setIconUrl(String str) {
        this.mIconUrl = str;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public void setSex(int i) {
        this.mSex = i;
    }

    public int getSex() {
        return this.mSex;
    }

    public void setTinyUrl(String str) {
        this.mTinyUrl = str;
    }

    public String getTinyUrl() {
        return this.mTinyUrl;
    }

    public void setPhone(long j) {
        this.mPhone = j;
    }

    public long getPhone() {
        return this.mPhone;
    }

    public void setUserDetail(String str) {
        this.mUserDetail = str;
    }

    public String getUserDetail() {
        return this.mUserDetail;
    }

    public ChatUser getUser() {
        return this;
    }

    @Override // com.baidu.android.imsdk.utils.PinYinUtils.PinYinObject
    public String getPy() {
        if (TextUtils.isEmpty(this.mUserNamePy)) {
            this.mUserNamePy = PinYinUtils.getPy(this.mUserNamePy);
        }
        return this.mUserNamePy;
    }

    public void setDisturb(int i) {
        this.mAttrDisturb = i;
    }

    public int getDisturb() {
        return this.mAttrDisturb;
    }

    public void setBlack(int i) {
        this.mAttrBlack = i;
    }

    public int getBlack() {
        return this.mAttrBlack;
    }

    @Deprecated
    public void setUserNamePy(String str) {
        this.mUserNamePy = str;
    }

    public String toString() {
        return "ChatUser [mUk=" + this.mUk + ", mBuid=" + this.mBuid + ", mUserName=" + this.mUserName + ", mIconUrl=" + this.mIconUrl + ", mSex=" + this.mSex + ", mTinyUrl=" + this.mTinyUrl + ", mPhone=" + this.mPhone + ", mUserDetail=" + this.mUserDetail + ", mUserNamePy=" + this.mUserNamePy + ", mAccountType=" + this.mAccountType + ", mIsIpLocatonExist=" + this.mIsIpLocatonExist + ", mIpInfo=" + this.mIpInfo + ", mAttrDisturb=" + this.mAttrDisturb + ", mAttrBlack=" + this.mAttrBlack + "]";
    }
}
