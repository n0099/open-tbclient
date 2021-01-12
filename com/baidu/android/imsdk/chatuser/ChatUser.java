package com.baidu.android.imsdk.chatuser;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.android.imsdk.utils.PinYinUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
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
    private int mHasSpecialIdentity;
    public String mIconUrl;
    private String mIdentity;
    private IpInfo mIpInfo;
    private int mIsIpLocatonExist;
    private long mLastUpdate;
    private int mMarkTop;
    private long mMarkTopTime;
    private long mPhone;
    private int mPhoneRelation;
    private String mSchema;
    private int mSex;
    private int mShield;
    private long mShieldTime;
    private String mSpecialIdentity;
    private int mSubscribe;
    private String mTinyUrl;
    private long mUk;
    private String mUserDetail;
    private String mUserExt;
    private String mUserName;
    private String mUserNamePy;
    private String mVipId;
    private String vPortrait;

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

    public int getHasSpecialIdentity() {
        return this.mHasSpecialIdentity;
    }

    public String getSpecialIdentity() {
        return this.mSpecialIdentity;
    }

    public void setHasSpecialIdentity(int i) {
        this.mHasSpecialIdentity = i;
    }

    public void setSpecialIdentity(String str) {
        this.mSpecialIdentity = str;
    }

    public int getPhoneRelation() {
        return this.mPhoneRelation;
    }

    public void setPhoneRelation(int i) {
        this.mPhoneRelation = i;
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

    public String getVPortrait() {
        return this.vPortrait;
    }

    public String getIdentity() {
        return this.mIdentity;
    }

    public void setVPortrait(String str) {
        this.vPortrait = str;
    }

    public String getVipId() {
        return this.mVipId;
    }

    public void setVipId(String str) {
        this.mVipId = str;
    }

    public void setIdentity(String str) {
        this.mIdentity = str;
    }

    public long getLastUpdate() {
        return this.mLastUpdate;
    }

    public int getShield() {
        return this.mShield;
    }

    public long getShieldTime() {
        return this.mShieldTime;
    }

    public int getMarkTop() {
        return this.mMarkTop;
    }

    public long getMarkTopTime() {
        return this.mMarkTopTime;
    }

    public int getSubscribe() {
        return this.mSubscribe;
    }

    public void setLastUpdate(long j) {
        this.mLastUpdate = j;
    }

    public void setShield(int i) {
        this.mShield = i;
    }

    public void setShieldTime(long j) {
        this.mShieldTime = j;
    }

    public void setMarkTop(int i) {
        this.mMarkTop = i;
    }

    public void setMarkTopTime(long j) {
        this.mMarkTopTime = j;
    }

    public void setSubscribe(int i) {
        this.mSubscribe = i;
    }

    @Deprecated
    public void setUserNamePy(String str) {
        this.mUserNamePy = str;
    }

    public String getUserExt() {
        return this.mUserExt;
    }

    public void setUserExt(String str) {
        this.mUserExt = str;
        if (!TextUtils.isEmpty(str)) {
            try {
                setSchema(new JSONObject(str).optString("homepage", ""));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String getSchema() {
        if (TextUtils.isEmpty(this.mSchema) && !TextUtils.isEmpty(this.mUserExt)) {
            try {
                this.mSchema = new JSONObject(this.mUserExt).optString("homepage", "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.mSchema;
    }

    public void setSchema(String str) {
        this.mSchema = str;
    }

    public String toString() {
        return "ChatUser [mUk=" + this.mUk + ", mBuid=" + this.mBuid + ", mUserName=" + this.mUserName + ", mIconUrl=" + this.mIconUrl + ", mSex=" + this.mSex + ", mTinyUrl=" + this.mTinyUrl + ", mPhone=" + this.mPhone + ", mUserDetail=" + this.mUserDetail + ", mUserNamePy=" + this.mUserNamePy + ", mAccountType=" + this.mAccountType + ", mIsIpLocatonExist=" + this.mIsIpLocatonExist + ", mIpInfo=" + this.mIpInfo + ", mAttrDisturb=" + this.mAttrDisturb + ", mAttrBlack=" + this.mAttrBlack + ", vPortrait=" + this.vPortrait + ", mIdentity=" + this.mIdentity + ", mLastUpdate=" + this.mLastUpdate + ", mShield=" + this.mShield + ", mShieldTime=" + this.mShieldTime + ", mVipId=" + this.mVipId + ", mMarkTop=" + this.mMarkTop + ", mMarkTopTime=" + this.mMarkTopTime + ", mSubscribe=" + this.mSubscribe + "mPhoneRelation=" + this.mPhoneRelation + ", mHasSpecialIdentity= " + this.mHasSpecialIdentity + ", mUserExt=" + this.mUserExt + ", mSchema=" + this.mSchema + ", mSpecialIdentity= " + this.mSpecialIdentity + "]";
    }
}
