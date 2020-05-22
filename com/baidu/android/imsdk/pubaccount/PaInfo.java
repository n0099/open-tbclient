package com.baidu.android.imsdk.pubaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
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
        public PaInfo[] newArray(int i) {
            return new PaInfo[i];
        }
    };
    private boolean acceptPush;
    private String avatar;
    private String classavatar;
    private int classshow;
    private String classtitle;
    private int classtype;
    private String description;
    private String detail;
    private int disturb;
    private boolean mMsgNotify;
    private String mRepliesStr;
    private int markTop;
    private long markTopTime;
    private String name;
    private String nickName;
    private String paExt;
    private long paId;
    private int status;
    private long subcribeTime;
    private int subtype;
    private long tpl;
    private String url;
    private int subsetType = 0;
    private long mLastRefreshTime = -1;
    private String mVipId = "";
    private String vPortrait = "";
    private int mHasIdentity = 0;
    private int mShield = 0;
    private long mShieldTime = 0;
    private String mIdentity = "";
    private int mSubscribe = 0;
    private String mThirdExt = "";
    private String mSchema = "";

    public void setSchema(String str) {
        this.mSchema = str;
    }

    public String getSchema() {
        if (TextUtils.isEmpty(this.mSchema) && !TextUtils.isEmpty(this.mThirdExt)) {
            try {
                this.mSchema = new JSONObject(this.mThirdExt).optString("homepage", "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.mSchema;
    }

    public void setIdentity(String str) {
        this.mIdentity = str;
    }

    public String getIdentity() {
        return this.mIdentity;
    }

    public long getMarkTopTime() {
        return this.markTopTime;
    }

    public void setMarkTopTime(long j) {
        this.markTopTime = j;
    }

    public int getMarkTop() {
        return this.markTop;
    }

    public void setMarkTop(int i) {
        this.markTop = i;
    }

    public boolean isMsgNotify() {
        return this.mMsgNotify;
    }

    public void setMsgNotify(boolean z) {
        this.mMsgNotify = z;
    }

    public int getSubsetType() {
        return this.subsetType;
    }

    public void setSubsetType(int i) {
        this.subsetType = i;
    }

    public void setPaExt(String str) {
        this.paExt = str;
    }

    public String getPaExt() {
        return this.paExt;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getSubtype() {
        return this.subtype;
    }

    public void setSubtype(int i) {
        this.subtype = i;
    }

    public long getPaId() {
        return this.paId;
    }

    public void setPaId(long j) {
        this.paId = j;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public boolean isAcceptPush() {
        return this.acceptPush;
    }

    public void setAcceptPush(boolean z) {
        this.acceptPush = z;
    }

    public int getDisturb() {
        return this.disturb;
    }

    public void setDisturb(int i) {
        this.disturb = i;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public long getSubcribeTime() {
        return this.subcribeTime;
    }

    public void setSubcribeTime(long j) {
        this.subcribeTime = j;
    }

    public void setDetail(String str) {
        this.detail = str;
    }

    public String getDetail() {
        return this.detail;
    }

    public void setUsername(String str) {
        this.name = str;
    }

    public String getUsername() {
        return this.name;
    }

    public void setTPL(long j) {
        this.tpl = j;
    }

    public long getTPL() {
        return this.tpl;
    }

    public void setClassType(int i) {
        this.classtype = i;
    }

    public int getClassType() {
        return this.classtype;
    }

    public void setClasstitle(String str) {
        this.classtitle = str;
    }

    public String getClassTitle() {
        return this.classtitle;
    }

    public void setClassAvatar(String str) {
        this.classavatar = str;
    }

    public String getClassavatar() {
        return this.classavatar;
    }

    public void setClassshow(int i) {
        this.classshow = i;
    }

    public int getClassshow() {
        return this.classshow;
    }

    public String getRepliesStr() {
        return this.mRepliesStr;
    }

    public void setRepliesStr(String str) {
        this.mRepliesStr = str;
    }

    public long getLastRefreshTime() {
        return this.mLastRefreshTime;
    }

    public void setLastRefreshTime(long j) {
        this.mLastRefreshTime = j;
    }

    public String getVPortrait() {
        return this.vPortrait;
    }

    public String getVipId() {
        return this.mVipId;
    }

    public void setVipId(String str) {
        this.mVipId = str;
    }

    public int getHasIdentity() {
        return this.mHasIdentity;
    }

    public int getShield() {
        return this.mShield;
    }

    public long getShieldTime() {
        return this.mShieldTime;
    }

    public void setVPortrait(String str) {
        this.vPortrait = str;
    }

    public void setHasIdentity(int i) {
        this.mHasIdentity = i;
    }

    public void setShield(int i) {
        this.mShield = i;
    }

    public void setShieldTime(long j) {
        this.mShieldTime = j;
    }

    public int getSubscribe() {
        return this.mSubscribe;
    }

    public void setSubscribe(int i) {
        this.mSubscribe = i;
    }

    public String getThirdExt() {
        return this.mThirdExt;
    }

    public void setThirdExt(String str) {
        this.mThirdExt = str;
        if (!TextUtils.isEmpty(str)) {
            try {
                setSchema(new JSONObject(str).optString("homepage", ""));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
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
    }

    public String toString() {
        return "PaInfo [pdId=" + this.paId + " nickName=" + this.nickName + " disturb= " + this.disturb + " description=" + this.description + " acceptPush=" + this.acceptPush + " url=" + this.url + " subscribeTime" + this.subcribeTime + " classtype= " + this.classtype + "  classtitle= " + this.classtitle + " markTop= " + this.markTop + " markTopTime= " + this.markTopTime + "  classavatar= " + this.classavatar + " mMsgNotify= " + this.mMsgNotify + " mRepliesStr= " + this.mRepliesStr + " mLastRefreshTime= " + this.mLastRefreshTime + " subsetType= " + this.subsetType + " paExt= " + this.paExt + " vPortrait= " + this.vPortrait + " mHasIdentity= " + this.mHasIdentity + " mShield= " + this.mShield + " mShieldTime " + this.mShieldTime + " mIdentity= " + this.mIdentity + " mVipId= " + this.mVipId + ", schema=" + this.mSchema + ", mSubscribe=" + this.mSubscribe + ", mThirdExt=" + this.mThirdExt + "  ]";
    }

    /* JADX INFO: Access modifiers changed from: private */
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
        return paInfo;
    }
}
