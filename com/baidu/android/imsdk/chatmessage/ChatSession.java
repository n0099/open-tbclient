package com.baidu.android.imsdk.chatmessage;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public final class ChatSession implements Parcelable, NoProGuard, Cloneable {
    public static final Parcelable.Creator<ChatSession> CREATOR = new Parcelable.Creator<ChatSession>() { // from class: com.baidu.android.imsdk.chatmessage.ChatSession.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ChatSession createFromParcel(Parcel parcel) {
            return new ChatSession(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ChatSession[] newArray(int i) {
            return new ChatSession[i];
        }
    };
    private int mBusinessType;
    private int mCategory;
    private String mCertification;
    private int mChatType;
    private String mClassAvatar;
    private int mClassShow;
    private String mClassTitle;
    private int mClassType;
    private int mCollectionType;
    private long mContacter;
    private long mContacterId;
    private String mExt;
    private String mGameHistory;
    private String mIconUrl;
    private int mIsClicked;
    private String mLastMsg;
    private long mLastMsgTime;
    private long mLastOpenTime;
    private int mMarkTop;
    private long mMarkTopTime;
    private String mName;
    private long mNewMsgSum;
    private String mNickName;
    private long mPaid;
    private int mSessionFrom;
    private int mShield;
    private long mShieldTime;
    private int mShow;
    private int mState;
    private String mVipId;
    private int mWeight;
    private String vPortrait;

    public ChatSession(int i, long j, long j2, String str) {
        this.mCategory = -1;
        this.mContacter = -1L;
        this.mContacterId = -1L;
        this.mName = null;
        this.mLastMsg = null;
        this.mLastMsgTime = -1L;
        this.mLastOpenTime = -1L;
        this.mNewMsgSum = 0L;
        this.mWeight = 0;
        this.mShow = 1;
        this.mCollectionType = -1;
        this.mChatType = -1;
        this.mIconUrl = null;
        this.mState = -1;
        this.mPaid = -1L;
        this.mClassType = -1;
        this.mClassTitle = null;
        this.mClassAvatar = null;
        this.mClassShow = 1;
        this.mMarkTop = 0;
        this.mMarkTopTime = 0L;
        this.mNickName = null;
        this.mGameHistory = "";
        this.mExt = "";
        this.vPortrait = "";
        this.mCertification = "";
        this.mVipId = "";
        this.mShield = 0;
        this.mShieldTime = 0L;
        this.mSessionFrom = 0;
        this.mBusinessType = -1;
        this.mContacter = j;
        this.mName = str;
        this.mCategory = i;
        this.mContacterId = j2;
    }

    public ChatSession() {
        this.mCategory = -1;
        this.mContacter = -1L;
        this.mContacterId = -1L;
        this.mName = null;
        this.mLastMsg = null;
        this.mLastMsgTime = -1L;
        this.mLastOpenTime = -1L;
        this.mNewMsgSum = 0L;
        this.mWeight = 0;
        this.mShow = 1;
        this.mCollectionType = -1;
        this.mChatType = -1;
        this.mIconUrl = null;
        this.mState = -1;
        this.mPaid = -1L;
        this.mClassType = -1;
        this.mClassTitle = null;
        this.mClassAvatar = null;
        this.mClassShow = 1;
        this.mMarkTop = 0;
        this.mMarkTopTime = 0L;
        this.mNickName = null;
        this.mGameHistory = "";
        this.mExt = "";
        this.vPortrait = "";
        this.mCertification = "";
        this.mVipId = "";
        this.mShield = 0;
        this.mShieldTime = 0L;
        this.mSessionFrom = 0;
        this.mBusinessType = -1;
    }

    ChatSession(Parcel parcel) {
        this.mCategory = -1;
        this.mContacter = -1L;
        this.mContacterId = -1L;
        this.mName = null;
        this.mLastMsg = null;
        this.mLastMsgTime = -1L;
        this.mLastOpenTime = -1L;
        this.mNewMsgSum = 0L;
        this.mWeight = 0;
        this.mShow = 1;
        this.mCollectionType = -1;
        this.mChatType = -1;
        this.mIconUrl = null;
        this.mState = -1;
        this.mPaid = -1L;
        this.mClassType = -1;
        this.mClassTitle = null;
        this.mClassAvatar = null;
        this.mClassShow = 1;
        this.mMarkTop = 0;
        this.mMarkTopTime = 0L;
        this.mNickName = null;
        this.mGameHistory = "";
        this.mExt = "";
        this.vPortrait = "";
        this.mCertification = "";
        this.mVipId = "";
        this.mShield = 0;
        this.mShieldTime = 0L;
        this.mSessionFrom = 0;
        this.mBusinessType = -1;
        this.mCategory = parcel.readInt();
        this.mContacter = parcel.readLong();
        this.mContacterId = parcel.readLong();
        this.mName = parcel.readString();
        this.mLastMsg = parcel.readString();
        this.mLastMsgTime = parcel.readLong();
        this.mLastOpenTime = parcel.readLong();
        this.mNewMsgSum = parcel.readLong();
        this.mWeight = parcel.readInt();
        this.mShow = parcel.readInt();
        this.mCollectionType = parcel.readInt();
        this.mChatType = parcel.readInt();
        this.mIconUrl = parcel.readString();
        this.mState = parcel.readInt();
        this.mPaid = parcel.readLong();
        this.mIsClicked = parcel.readInt();
        this.mClassType = parcel.readInt();
        this.mClassTitle = parcel.readString();
        this.mClassAvatar = parcel.readString();
        this.mClassShow = parcel.readInt();
        this.mMarkTop = parcel.readInt();
        this.mMarkTopTime = parcel.readLong();
        this.mNickName = parcel.readString();
        this.mGameHistory = parcel.readString();
        this.mExt = parcel.readString();
        this.vPortrait = parcel.readString();
        this.mCertification = parcel.readString();
        this.mVipId = parcel.readString();
        this.mShield = parcel.readInt();
        this.mShieldTime = parcel.readLong();
        this.mSessionFrom = parcel.readInt();
    }

    public int getBusinessType() {
        return this.mBusinessType;
    }

    public void setBusinessType(int i) {
        this.mBusinessType = i;
    }

    public int getMarkTop() {
        return this.mMarkTop;
    }

    public void setMarkTop(int i) {
        this.mMarkTop = i;
    }

    public long getMarkTopTime() {
        return this.mMarkTopTime;
    }

    public void setMarkTopTime(long j) {
        this.mMarkTopTime = j;
    }

    public long getLastMsgTime() {
        return this.mLastMsgTime;
    }

    public void setLastMsgTime(long j) {
        this.mLastMsgTime = j;
    }

    public long getLastOpenTime() {
        return this.mLastOpenTime;
    }

    public void setLastOpenTime(long j) {
        this.mLastOpenTime = j;
    }

    public long getNewMsgSum() {
        return this.mNewMsgSum;
    }

    public void setNewMsgSum(long j) {
        this.mNewMsgSum = j;
    }

    public String getLastMsg() {
        return this.mLastMsg;
    }

    public void setLastMsg(String str) {
        this.mLastMsg = str;
    }

    public String getExt() {
        return this.mExt;
    }

    public void setExt(String str) {
        this.mExt = str;
    }

    public void addExt(String str, String str2) {
        JSONObject jSONObject;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (TextUtils.isEmpty(this.mExt)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(this.mExt);
                }
                jSONObject.put(str, str2);
                this.mExt = jSONObject.toString();
            }
        } catch (Exception e) {
            LogUtils.e("ChatSession", "addExt", e);
        }
    }

    public void clearExt() {
        if (!TextUtils.isEmpty(this.mExt)) {
            this.mExt = "";
        }
    }

    public String getVPortrait() {
        return this.vPortrait;
    }

    public String getCertification() {
        return this.mCertification;
    }

    public String getVipId() {
        return this.mVipId;
    }

    public void setVPortrait(String str) {
        this.vPortrait = str;
    }

    public void setCertification(String str) {
        this.mCertification = str;
    }

    public void setVipId(String str) {
        this.mVipId = str;
    }

    public int getShield() {
        return this.mShield;
    }

    public long getShieldTime() {
        return this.mShieldTime;
    }

    public void setShield(int i) {
        this.mShield = i;
    }

    public void setShieldTime(long j) {
        this.mShieldTime = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mCategory);
        parcel.writeLong(this.mContacter);
        parcel.writeLong(this.mContacterId);
        parcel.writeString(this.mName);
        parcel.writeString(this.mLastMsg);
        parcel.writeLong(this.mLastMsgTime);
        parcel.writeLong(this.mLastOpenTime);
        parcel.writeLong(this.mNewMsgSum);
        parcel.writeInt(this.mWeight);
        parcel.writeInt(this.mShow);
        parcel.writeInt(this.mCollectionType);
        parcel.writeInt(this.mChatType);
        parcel.writeString(this.mIconUrl);
        parcel.writeInt(this.mState);
        parcel.writeLong(this.mPaid);
        parcel.writeInt(this.mIsClicked);
        parcel.writeInt(this.mClassType);
        parcel.writeString(this.mClassTitle);
        parcel.writeString(this.mClassAvatar);
        parcel.writeInt(this.mClassShow);
        parcel.writeInt(this.mMarkTop);
        parcel.writeLong(this.mMarkTopTime);
        parcel.writeString(this.mNickName);
        parcel.writeString(this.mGameHistory);
        parcel.writeString(this.mExt);
        parcel.writeString(this.vPortrait);
        parcel.writeString(this.mCertification);
        parcel.writeString(this.mVipId);
        parcel.writeInt(this.mShield);
        parcel.writeLong(this.mShieldTime);
        parcel.writeInt(this.mSessionFrom);
    }

    public int getCategory() {
        return this.mCategory;
    }

    public long getContacter() {
        return this.mContacter;
    }

    public long getContacterId() {
        return this.mContacterId;
    }

    public void setContacter(long j) {
        this.mContacter = j;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public ChatSession getChatRecord() {
        return this;
    }

    public void setWeight(int i) {
        this.mWeight = i;
    }

    public int getWeight() {
        return this.mWeight;
    }

    public boolean isShow() {
        return this.mShow == 1;
    }

    public void setShow(int i) {
        this.mShow = i;
    }

    public int getShow() {
        return this.mShow;
    }

    public int getCollectionType() {
        return this.mCollectionType;
    }

    public void setCollectionType(int i) {
        this.mCollectionType = i;
    }

    public int getChatType() {
        return this.mChatType;
    }

    public void setChatType(int i) {
        this.mChatType = i;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public void setIconUrl(String str) {
        this.mIconUrl = str;
    }

    public int getState() {
        return this.mState;
    }

    public int getIsClicked() {
        return this.mIsClicked;
    }

    public boolean isRed() {
        return this.mIsClicked == 0;
    }

    public void setIsClicked(int i) {
        this.mIsClicked = i;
    }

    public void setState(int i) {
        this.mState = i;
    }

    public long getPaid() {
        return this.mPaid;
    }

    public void setPaid(long j) {
        this.mPaid = j;
    }

    public void setClassType(int i) {
        this.mClassType = i;
    }

    public int getClassType() {
        return this.mClassType;
    }

    public void setClassTitle(String str) {
        this.mClassTitle = str;
    }

    public String getClassTitle() {
        return this.mClassTitle;
    }

    public void setClassAvatar(String str) {
        this.mClassAvatar = str;
    }

    public String getClassAvatar() {
        return this.mClassAvatar;
    }

    public void setClassShow(int i) {
        this.mClassShow = i;
    }

    public int getClassShow() {
        return this.mClassShow;
    }

    public void setNickName(String str) {
        this.mNickName = str;
    }

    public String getNickName() {
        return this.mNickName;
    }

    public String getGameHistory() {
        return this.mGameHistory;
    }

    public void setGameHistory(String str) {
        this.mGameHistory = str;
    }

    public void setSessionFrom(int i) {
        this.mSessionFrom = i;
    }

    public int getSessionFrom() {
        return this.mSessionFrom;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: clone */
    public ChatSession m15clone() throws CloneNotSupportedException {
        return (ChatSession) super.clone();
    }

    @SuppressLint({"SimpleDateFormat"})
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ChatSession [");
        sb.append(" category=").append(this.mCategory).append(" ,");
        sb.append(" name=").append(this.mName).append(" ,");
        sb.append(" unReadMsgCount=").append(this.mNewMsgSum).append(" ,");
        sb.append(" contacter=").append(this.mContacter).append(" ,");
        sb.append(" contacterId=").append(this.mContacterId).append(" ,");
        sb.append(" content=").append(this.mLastMsg).append(" ,");
        if (Long.valueOf(this.mLastMsgTime).toString().length() == 10) {
            sb.append(" time=").append(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date(this.mLastMsgTime * 1000))).append(" ,");
        } else {
            sb.append(" time=").append(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date(this.mLastMsgTime))).append(" ,");
        }
        sb.append(" chatType=").append(this.mChatType).append(" ,");
        sb.append(" mPaid=").append(this.mPaid).append(" ,");
        sb.append(" lastMsg=").append(this.mLastMsg).append(" ,");
        sb.append(" mMarkTop=").append(this.mMarkTop).append(" ,");
        sb.append(" mMarkTopTime=").append(this.mMarkTopTime).append(" ,");
        sb.append(" icon=").append(this.mIconUrl).append(" ,");
        sb.append(" mExt=").append(this.mExt).append(" ,");
        sb.append(" mShield=").append(this.mShield).append(" ,");
        sb.append(" mShieldTime=").append(this.mShieldTime).append(" ,");
        sb.append(" vPortrait=").append(this.vPortrait).append(" ,");
        sb.append(" mVipId=").append(this.mVipId).append(" ,");
        sb.append(" mCertification=").append(this.mCertification).append(" ,");
        sb.append(" mNickName=").append(this.mNickName).append(" ,");
        sb.append(" mSessionFrom=").append(this.mSessionFrom).append("]");
        return sb.toString();
    }
}
