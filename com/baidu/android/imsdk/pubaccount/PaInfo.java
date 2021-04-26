package com.baidu.android.imsdk.pubaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PaInfo implements Parcelable {
    public static final Parcelable.Creator<PaInfo> CREATOR = new Parcelable.Creator<PaInfo>() { // from class: com.baidu.android.imsdk.pubaccount.PaInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PaInfo createFromParcel(Parcel parcel) {
            return PaInfo.readFromParcel(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PaInfo[] newArray(int i2) {
            return new PaInfo[i2];
        }
    };
    public boolean acceptPush;
    public String avatar;
    public String classavatar;
    public int classshow;
    public String classtitle;
    public int classtype;
    public String description;
    public String detail;
    public int disturb;
    public boolean mMsgNotify;
    public int mRejectMenu;
    public String mRepliesStr;
    public int markTop;
    public long markTopTime;
    public String name;
    public String nickName;
    public String paExt;
    public long paId;
    public int status;
    public long subcribeTime;
    public int subtype;
    public long tpl;
    public String url;
    public int subsetType = 0;
    public long mLastRefreshTime = -1;
    public String mVipId = "";
    public String vPortrait = "";
    public int mHasIdentity = 0;
    public int mShield = 0;
    public long mShieldTime = 0;
    public String mIdentity = "";
    public int mSubscribe = 0;
    public String mThirdExt = "";
    public String mSchema = "";

    public static PaInfo readFromParcel(Parcel parcel) {
        PaInfo paInfo = new PaInfo();
        paInfo.setPaId(parcel.readLong());
        paInfo.setNickName(parcel.readString());
        paInfo.setAvatar(parcel.readString());
        paInfo.setAcceptPush(parcel.readInt() == 1);
        paInfo.setDescription(parcel.readString());
        paInfo.setUrl(parcel.readString());
        paInfo.setSubcribeTime(parcel.readLong());
        paInfo.setDetail(parcel.readString());
        paInfo.setUsername(parcel.readString());
        paInfo.setTPL(parcel.readLong());
        paInfo.setDisturb(parcel.readInt());
        paInfo.setSubtype(parcel.readInt());
        paInfo.setClassType(parcel.readInt());
        paInfo.setClasstitle(parcel.readString());
        paInfo.setClassAvatar(parcel.readString());
        paInfo.setStatus(parcel.readInt());
        paInfo.setMsgNotify(parcel.readInt() == 1);
        paInfo.setMarkTop(parcel.readInt());
        paInfo.setMarkTopTime(parcel.readLong());
        paInfo.setRepliesStr(parcel.readString());
        paInfo.setLastRefreshTime(parcel.readLong());
        paInfo.setSubsetType(parcel.readInt());
        paInfo.setPaExt(parcel.readString());
        paInfo.setVPortrait(parcel.readString());
        paInfo.setVipId(parcel.readString());
        paInfo.setHasIdentity(parcel.readInt());
        paInfo.setShield(parcel.readInt());
        paInfo.setShieldTime(parcel.readLong());
        paInfo.setIdentity(parcel.readString());
        paInfo.setSubscribe(parcel.readInt());
        paInfo.setThirdExt(parcel.readString());
        paInfo.setSchema(parcel.readString());
        paInfo.setRejectMenu(parcel.readInt());
        return paInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getClassTitle() {
        return this.classtitle;
    }

    public int getClassType() {
        return this.classtype;
    }

    public String getClassavatar() {
        return this.classavatar;
    }

    public int getClassshow() {
        return this.classshow;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDetail() {
        return this.detail;
    }

    public int getDisturb() {
        return this.disturb;
    }

    public int getHasIdentity() {
        return this.mHasIdentity;
    }

    public String getIdentity() {
        return this.mIdentity;
    }

    public long getLastRefreshTime() {
        return this.mLastRefreshTime;
    }

    public int getMarkTop() {
        return this.markTop;
    }

    public long getMarkTopTime() {
        return this.markTopTime;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getPaExt() {
        return this.paExt;
    }

    public long getPaId() {
        return this.paId;
    }

    public int getRejectMenu() {
        return this.mRejectMenu;
    }

    public String getRepliesStr() {
        return this.mRepliesStr;
    }

    public String getSchema() {
        if (TextUtils.isEmpty(this.mSchema) && !TextUtils.isEmpty(this.mThirdExt)) {
            try {
                this.mSchema = new JSONObject(this.mThirdExt).optString("homepage", "");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return this.mSchema;
    }

    public int getShield() {
        return this.mShield;
    }

    public long getShieldTime() {
        return this.mShieldTime;
    }

    public int getStatus() {
        return this.status;
    }

    public long getSubcribeTime() {
        return this.subcribeTime;
    }

    public int getSubscribe() {
        return this.mSubscribe;
    }

    public int getSubsetType() {
        return this.subsetType;
    }

    public int getSubtype() {
        return this.subtype;
    }

    public long getTPL() {
        return this.tpl;
    }

    public String getThirdExt() {
        return this.mThirdExt;
    }

    public String getThirdId() {
        if (!TextUtils.isEmpty(this.mThirdExt)) {
            try {
                return new JSONObject(this.mThirdExt).optString("third_id", "");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    public String getUrl() {
        return this.url;
    }

    public String getUsername() {
        return this.name;
    }

    public String getVPortrait() {
        return this.vPortrait;
    }

    public String getVipId() {
        return this.mVipId;
    }

    public boolean isAcceptPush() {
        return this.acceptPush;
    }

    public boolean isMsgNotify() {
        return this.mMsgNotify;
    }

    public void setAcceptPush(boolean z) {
        this.acceptPush = z;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setClassAvatar(String str) {
        this.classavatar = str;
    }

    public void setClassType(int i2) {
        this.classtype = i2;
    }

    public void setClassshow(int i2) {
        this.classshow = i2;
    }

    public void setClasstitle(String str) {
        this.classtitle = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDetail(String str) {
        this.detail = str;
    }

    public void setDisturb(int i2) {
        this.disturb = i2;
    }

    public void setHasIdentity(int i2) {
        this.mHasIdentity = i2;
    }

    public void setIdentity(String str) {
        this.mIdentity = str;
    }

    public void setLastRefreshTime(long j) {
        this.mLastRefreshTime = j;
    }

    public void setMarkTop(int i2) {
        this.markTop = i2;
    }

    public void setMarkTopTime(long j) {
        this.markTopTime = j;
    }

    public void setMsgNotify(boolean z) {
        this.mMsgNotify = z;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setPaExt(String str) {
        this.paExt = str;
    }

    public void setPaId(long j) {
        this.paId = j;
    }

    public void setRejectMenu(int i2) {
        this.mRejectMenu = i2;
    }

    public void setRepliesStr(String str) {
        this.mRepliesStr = str;
    }

    public void setSchema(String str) {
        this.mSchema = str;
    }

    public void setShield(int i2) {
        this.mShield = i2;
    }

    public void setShieldTime(long j) {
        this.mShieldTime = j;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public void setSubcribeTime(long j) {
        this.subcribeTime = j;
    }

    public void setSubscribe(int i2) {
        this.mSubscribe = i2;
    }

    public void setSubsetType(int i2) {
        this.subsetType = i2;
    }

    public void setSubtype(int i2) {
        this.subtype = i2;
    }

    public void setTPL(long j) {
        this.tpl = j;
    }

    public void setThirdExt(String str) {
        this.mThirdExt = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            setSchema(new JSONObject(str).optString("homepage", ""));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setUsername(String str) {
        this.name = str;
    }

    public void setVPortrait(String str) {
        this.vPortrait = str;
    }

    public void setVipId(String str) {
        this.mVipId = str;
    }

    public String toString() {
        return "PaInfo [pdId=" + this.paId + " nickName=" + this.nickName + " disturb= " + this.disturb + " description=" + this.description + " acceptPush=" + this.acceptPush + " url=" + this.url + " subscribeTime" + this.subcribeTime + " classtype= " + this.classtype + "  classtitle= " + this.classtitle + " markTop= " + this.markTop + " markTopTime= " + this.markTopTime + "  classavatar= " + this.classavatar + " mMsgNotify= " + this.mMsgNotify + " mRepliesStr= " + this.mRepliesStr + " mLastRefreshTime= " + this.mLastRefreshTime + " subsetType= " + this.subsetType + " paExt= " + this.paExt + " vPortrait= " + this.vPortrait + " mHasIdentity= " + this.mHasIdentity + " mShield= " + this.mShield + " mShieldTime " + this.mShieldTime + " mIdentity= " + this.mIdentity + " mVipId= " + this.mVipId + ", schema=" + this.mSchema + ", mSubscribe=" + this.mSubscribe + ", mThirdExt=" + this.mThirdExt + ", mRejectMenu=" + this.mRejectMenu + "  ]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.paId);
        parcel.writeString(this.nickName);
        parcel.writeString(this.avatar);
        parcel.writeInt(this.acceptPush ? 1 : 0);
        parcel.writeString(this.description);
        parcel.writeString(this.url);
        parcel.writeLong(this.subcribeTime);
        parcel.writeString(this.detail);
        parcel.writeString(this.name);
        parcel.writeLong(this.tpl);
        parcel.writeInt(this.disturb);
        parcel.writeInt(this.subtype);
        parcel.writeInt(this.classtype);
        parcel.writeString(this.classtitle);
        parcel.writeString(this.classavatar);
        parcel.writeInt(this.status);
        parcel.writeInt(this.mMsgNotify ? 1 : 0);
        parcel.writeLong(this.markTopTime);
        parcel.writeInt(this.markTop);
        parcel.writeString(this.mRepliesStr);
        parcel.writeLong(this.mLastRefreshTime);
        parcel.writeInt(this.subsetType);
        parcel.writeString(this.paExt);
        parcel.writeString(this.vPortrait);
        parcel.writeString(this.mVipId);
        parcel.writeInt(this.mHasIdentity);
        parcel.writeInt(this.mShield);
        parcel.writeLong(this.mShieldTime);
        parcel.writeString(this.mIdentity);
        parcel.writeString(this.mThirdExt);
        parcel.writeString(this.mSchema);
        parcel.writeInt(this.mSubscribe);
        parcel.writeInt(this.mRejectMenu);
    }
}
