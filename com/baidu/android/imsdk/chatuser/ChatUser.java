package com.baidu.android.imsdk.chatuser;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.android.imsdk.utils.PinYinUtils;
import org.json.JSONObject;
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
    public int mAccountType;
    public int mAttrBlack;
    public int mAttrDisturb;
    public long mBuid;
    public int mHasSpecialIdentity;
    public String mIconUrl;
    public String mIdentity;
    public IpInfo mIpInfo;
    public int mIsIpLocatonExist;
    public long mLastUpdate;
    public int mMarkTop;
    public long mMarkTopTime;
    public long mPhone;
    public int mPhoneRelation;
    public String mSchema;
    public int mSex;
    public int mShield;
    public long mShieldTime;
    public String mSpecialIdentity;
    public int mSubscribe;
    public String mTinyUrl;
    public long mUk;
    public String mUserDetail;
    public String mUserExt;
    public String mUserName;
    public String mUserNamePy;
    public String mVipId;
    public String vPortrait;

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
        this.vPortrait = "";
        this.mVipId = "";
        this.mIdentity = "";
        this.mLastUpdate = 0L;
        this.mShield = 0;
        this.mShieldTime = 0L;
        this.mMarkTop = 0;
        this.mMarkTopTime = 0L;
        this.mSubscribe = 0;
        this.mPhoneRelation = 0;
        this.mHasSpecialIdentity = 0;
        this.mSpecialIdentity = "";
        this.mUserExt = "";
        this.mUk = j;
        this.mBuid = j2;
        this.mUserName = str;
        this.mIconUrl = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAccountType() {
        return this.mAccountType;
    }

    public int getBlack() {
        return this.mAttrBlack;
    }

    public long getBuid() {
        return this.mBuid;
    }

    public int getDisturb() {
        return this.mAttrDisturb;
    }

    public int getHasSpecialIdentity() {
        return this.mHasSpecialIdentity;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public String getIdentity() {
        return this.mIdentity;
    }

    public IpInfo getIpInfo() {
        return this.mIpInfo;
    }

    @Deprecated
    public int getIsIpLocationExist() {
        return this.mIsIpLocatonExist;
    }

    public long getLastUpdate() {
        return this.mLastUpdate;
    }

    public int getMarkTop() {
        return this.mMarkTop;
    }

    public long getMarkTopTime() {
        return this.mMarkTopTime;
    }

    public long getPhone() {
        return this.mPhone;
    }

    public int getPhoneRelation() {
        return this.mPhoneRelation;
    }

    @Override // com.baidu.android.imsdk.utils.PinYinUtils.PinYinObject
    public String getPy() {
        if (TextUtils.isEmpty(this.mUserNamePy)) {
            this.mUserNamePy = PinYinUtils.getPy(this.mUserNamePy);
        }
        return this.mUserNamePy;
    }

    public String getSchema() {
        if (TextUtils.isEmpty(this.mSchema) && !TextUtils.isEmpty(this.mUserExt)) {
            try {
                this.mSchema = new JSONObject(this.mUserExt).optString("homepage", "");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return this.mSchema;
    }

    public int getSex() {
        return this.mSex;
    }

    public int getShield() {
        return this.mShield;
    }

    public long getShieldTime() {
        return this.mShieldTime;
    }

    public String getSpecialIdentity() {
        return this.mSpecialIdentity;
    }

    public int getSubscribe() {
        return this.mSubscribe;
    }

    public String getTinyUrl() {
        return this.mTinyUrl;
    }

    public long getUk() {
        return this.mUk;
    }

    public ChatUser getUser() {
        return this;
    }

    public String getUserDetail() {
        return this.mUserDetail;
    }

    public String getUserExt() {
        return this.mUserExt;
    }

    @Deprecated
    public long getUserId() {
        return this.mUk;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public String getVPortrait() {
        return this.vPortrait;
    }

    public String getVipId() {
        return this.mVipId;
    }

    public boolean isAnonymousUser() {
        return this.mAccountType == 0;
    }

    public boolean isIpLocationExist() {
        return this.mIsIpLocatonExist == 0;
    }

    public void setAccountType(int i) {
        this.mAccountType = i;
    }

    public void setBlack(int i) {
        this.mAttrBlack = i;
    }

    public void setDisturb(int i) {
        this.mAttrDisturb = i;
    }

    public void setHasSpecialIdentity(int i) {
        this.mHasSpecialIdentity = i;
    }

    public void setIconUrl(String str) {
        this.mIconUrl = str;
    }

    public void setIdentity(String str) {
        this.mIdentity = str;
    }

    public void setIpInfo(IpInfo ipInfo) {
        this.mIpInfo = ipInfo;
    }

    public void setIsIpLocationExist(int i) {
        this.mIsIpLocatonExist = i;
    }

    public void setLastUpdate(long j) {
        this.mLastUpdate = j;
    }

    public void setMarkTop(int i) {
        this.mMarkTop = i;
    }

    public void setMarkTopTime(long j) {
        this.mMarkTopTime = j;
    }

    public void setPhone(long j) {
        this.mPhone = j;
    }

    public void setPhoneRelation(int i) {
        this.mPhoneRelation = i;
    }

    public void setSchema(String str) {
        this.mSchema = str;
    }

    public void setSex(int i) {
        this.mSex = i;
    }

    public void setShield(int i) {
        this.mShield = i;
    }

    public void setShieldTime(long j) {
        this.mShieldTime = j;
    }

    public void setSpecialIdentity(String str) {
        this.mSpecialIdentity = str;
    }

    public void setSubscribe(int i) {
        this.mSubscribe = i;
    }

    public void setTinyUrl(String str) {
        this.mTinyUrl = str;
    }

    public void setUserDetail(String str) {
        this.mUserDetail = str;
    }

    public void setUserExt(String str) {
        this.mUserExt = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            setSchema(new JSONObject(str).optString("homepage", ""));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Deprecated
    public void setUserNamePy(String str) {
        this.mUserNamePy = str;
    }

    public void setVPortrait(String str) {
        this.vPortrait = str;
    }

    public void setVipId(String str) {
        this.mVipId = str;
    }

    public String toString() {
        return "ChatUser [mUk=" + this.mUk + ", mBuid=" + this.mBuid + ", mUserName=" + this.mUserName + ", mIconUrl=" + this.mIconUrl + ", mSex=" + this.mSex + ", mTinyUrl=" + this.mTinyUrl + ", mPhone=" + this.mPhone + ", mUserDetail=" + this.mUserDetail + ", mUserNamePy=" + this.mUserNamePy + ", mAccountType=" + this.mAccountType + ", mIsIpLocatonExist=" + this.mIsIpLocatonExist + ", mIpInfo=" + this.mIpInfo + ", mAttrDisturb=" + this.mAttrDisturb + ", mAttrBlack=" + this.mAttrBlack + ", vPortrait=" + this.vPortrait + ", mIdentity=" + this.mIdentity + ", mLastUpdate=" + this.mLastUpdate + ", mShield=" + this.mShield + ", mShieldTime=" + this.mShieldTime + ", mVipId=" + this.mVipId + ", mMarkTop=" + this.mMarkTop + ", mMarkTopTime=" + this.mMarkTopTime + ", mSubscribe=" + this.mSubscribe + "mPhoneRelation=" + this.mPhoneRelation + ", mHasSpecialIdentity= " + this.mHasSpecialIdentity + ", mUserExt=" + this.mUserExt + ", mSchema=" + this.mSchema + ", mSpecialIdentity= " + this.mSpecialIdentity + "]";
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
        parcel.writeString(this.mVipId);
        parcel.writeString(this.vPortrait);
        parcel.writeString(this.mIdentity);
        parcel.writeLong(this.mLastUpdate);
        parcel.writeInt(this.mShield);
        parcel.writeLong(this.mShieldTime);
        parcel.writeInt(this.mMarkTop);
        parcel.writeLong(this.mMarkTopTime);
        parcel.writeInt(this.mSubscribe);
        parcel.writeInt(this.mPhoneRelation);
        parcel.writeInt(this.mHasSpecialIdentity);
        parcel.writeString(this.mSpecialIdentity);
        parcel.writeString(this.mUserExt);
        parcel.writeString(this.mSchema);
    }

    public ChatUser(Parcel parcel) {
        this.mUserName = "";
        this.mIconUrl = "";
        this.mSex = 0;
        this.mTinyUrl = "";
        this.mPhone = 0L;
        this.mUserDetail = "";
        this.mUserNamePy = "";
        this.mAccountType = -1;
        this.mIsIpLocatonExist = 1;
        this.vPortrait = "";
        this.mVipId = "";
        this.mIdentity = "";
        this.mLastUpdate = 0L;
        this.mShield = 0;
        this.mShieldTime = 0L;
        this.mMarkTop = 0;
        this.mMarkTopTime = 0L;
        this.mSubscribe = 0;
        this.mPhoneRelation = 0;
        this.mHasSpecialIdentity = 0;
        this.mSpecialIdentity = "";
        this.mUserExt = "";
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
        this.mVipId = parcel.readString();
        this.vPortrait = parcel.readString();
        this.mIdentity = parcel.readString();
        this.mLastUpdate = parcel.readLong();
        this.mShield = parcel.readInt();
        this.mShieldTime = parcel.readLong();
        this.mMarkTop = parcel.readInt();
        this.mMarkTopTime = parcel.readLong();
        this.mSubscribe = parcel.readInt();
        this.mPhoneRelation = parcel.readInt();
        this.mHasSpecialIdentity = parcel.readInt();
        this.mSpecialIdentity = parcel.readString();
        this.mUserExt = parcel.readString();
        this.mSchema = parcel.readString();
    }
}
