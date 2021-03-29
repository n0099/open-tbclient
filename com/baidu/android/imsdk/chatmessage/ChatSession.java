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
/* loaded from: classes.dex */
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
    public int mBusinessType;
    public int mCategory;
    public String mCertification;
    public int mChatType;
    public String mClassAvatar;
    public int mClassShow;
    public String mClassTitle;
    public int mClassType;
    public int mCollectionType;
    public long mContacter;
    public long mContacterId;
    public String mExt;
    public String mGameHistory;
    public String mIconUrl;
    public int mIsClicked;
    public String mLastMsg;
    public long mLastMsgTime;
    public long mLastOpenTime;
    public int mMarkTop;
    public long mMarkTopTime;
    public String mName;
    public long mNewMsgSum;
    public String mNickName;
    public long mPaid;
    public int mSessionFrom;
    public int mShield;
    public long mShieldTime;
    public int mShow;
    public int mState;
    public String mVipId;
    public int mWeight;
    public String vPortrait;

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

    public void addExt(String str, String str2) {
        JSONObject jSONObject;
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            if (TextUtils.isEmpty(this.mExt)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(this.mExt);
            }
            jSONObject.put(str, str2);
            this.mExt = jSONObject.toString();
        } catch (Exception e2) {
            LogUtils.e("ChatSession", "addExt", e2);
        }
    }

    public void clearExt() {
        if (TextUtils.isEmpty(this.mExt)) {
            return;
        }
        this.mExt = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBusinessType() {
        return this.mBusinessType;
    }

    public int getCategory() {
        return this.mCategory;
    }

    public String getCertification() {
        return this.mCertification;
    }

    public ChatSession getChatRecord() {
        return this;
    }

    public int getChatType() {
        return this.mChatType;
    }

    public String getClassAvatar() {
        return this.mClassAvatar;
    }

    public int getClassShow() {
        return this.mClassShow;
    }

    public String getClassTitle() {
        return this.mClassTitle;
    }

    public int getClassType() {
        return this.mClassType;
    }

    public int getCollectionType() {
        return this.mCollectionType;
    }

    public long getContacter() {
        return this.mContacter;
    }

    public long getContacterId() {
        return this.mContacterId;
    }

    public String getExt() {
        return this.mExt;
    }

    public String getGameHistory() {
        return this.mGameHistory;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public int getIsClicked() {
        return this.mIsClicked;
    }

    public String getLastMsg() {
        return this.mLastMsg;
    }

    public long getLastMsgTime() {
        return this.mLastMsgTime;
    }

    public long getLastOpenTime() {
        return this.mLastOpenTime;
    }

    public int getMarkTop() {
        return this.mMarkTop;
    }

    public long getMarkTopTime() {
        return this.mMarkTopTime;
    }

    public String getName() {
        return this.mName;
    }

    public long getNewMsgSum() {
        return this.mNewMsgSum;
    }

    public String getNickName() {
        return this.mNickName;
    }

    public long getPaid() {
        return this.mPaid;
    }

    public int getSessionFrom() {
        return this.mSessionFrom;
    }

    public int getShield() {
        return this.mShield;
    }

    public long getShieldTime() {
        return this.mShieldTime;
    }

    public int getShow() {
        return this.mShow;
    }

    public int getState() {
        return this.mState;
    }

    public String getVPortrait() {
        return this.vPortrait;
    }

    public String getVipId() {
        return this.mVipId;
    }

    public int getWeight() {
        return this.mWeight;
    }

    public boolean isRed() {
        return this.mIsClicked == 0;
    }

    public boolean isShow() {
        return this.mShow == 1;
    }

    public void setBusinessType(int i) {
        this.mBusinessType = i;
    }

    public void setCertification(String str) {
        this.mCertification = str;
    }

    public void setChatType(int i) {
        this.mChatType = i;
    }

    public void setClassAvatar(String str) {
        this.mClassAvatar = str;
    }

    public void setClassShow(int i) {
        this.mClassShow = i;
    }

    public void setClassTitle(String str) {
        this.mClassTitle = str;
    }

    public void setClassType(int i) {
        this.mClassType = i;
    }

    public void setCollectionType(int i) {
        this.mCollectionType = i;
    }

    public void setContacter(long j) {
        this.mContacter = j;
    }

    public void setExt(String str) {
        this.mExt = str;
    }

    public void setGameHistory(String str) {
        this.mGameHistory = str;
    }

    public void setIconUrl(String str) {
        this.mIconUrl = str;
    }

    public void setIsClicked(int i) {
        this.mIsClicked = i;
    }

    public void setLastMsg(String str) {
        this.mLastMsg = str;
    }

    public void setLastMsgTime(long j) {
        this.mLastMsgTime = j;
    }

    public void setLastOpenTime(long j) {
        this.mLastOpenTime = j;
    }

    public void setMarkTop(int i) {
        this.mMarkTop = i;
    }

    public void setMarkTopTime(long j) {
        this.mMarkTopTime = j;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setNewMsgSum(long j) {
        this.mNewMsgSum = j;
    }

    public void setNickName(String str) {
        this.mNickName = str;
    }

    public void setPaid(long j) {
        this.mPaid = j;
    }

    public void setSessionFrom(int i) {
        this.mSessionFrom = i;
    }

    public void setShield(int i) {
        this.mShield = i;
    }

    public void setShieldTime(long j) {
        this.mShieldTime = j;
    }

    public void setShow(int i) {
        this.mShow = i;
    }

    public void setState(int i) {
        this.mState = i;
    }

    public void setVPortrait(String str) {
        this.vPortrait = str;
    }

    public void setVipId(String str) {
        this.mVipId = str;
    }

    public void setWeight(int i) {
        this.mWeight = i;
    }

    @SuppressLint({"SimpleDateFormat"})
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ChatSession [");
        sb.append(" category=");
        sb.append(this.mCategory);
        sb.append(" ,");
        sb.append(" name=");
        sb.append(this.mName);
        sb.append(" ,");
        sb.append(" unReadMsgCount=");
        sb.append(this.mNewMsgSum);
        sb.append(" ,");
        sb.append(" contacter=");
        sb.append(this.mContacter);
        sb.append(" ,");
        sb.append(" contacterId=");
        sb.append(this.mContacterId);
        sb.append(" ,");
        sb.append(" content=");
        sb.append(this.mLastMsg);
        sb.append(" ,");
        if (Long.valueOf(this.mLastMsgTime).toString().length() == 10) {
            sb.append(" time=");
            sb.append(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date(this.mLastMsgTime * 1000)));
            sb.append(" ,");
        } else {
            sb.append(" time=");
            sb.append(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date(this.mLastMsgTime)));
            sb.append(" ,");
        }
        sb.append(" chatType=");
        sb.append(this.mChatType);
        sb.append(" ,");
        sb.append(" mPaid=");
        sb.append(this.mPaid);
        sb.append(" ,");
        sb.append(" lastMsg=");
        sb.append(this.mLastMsg);
        sb.append(" ,");
        sb.append(" mMarkTop=");
        sb.append(this.mMarkTop);
        sb.append(" ,");
        sb.append(" mMarkTopTime=");
        sb.append(this.mMarkTopTime);
        sb.append(" ,");
        sb.append(" icon=");
        sb.append(this.mIconUrl);
        sb.append(" ,");
        sb.append(" mExt=");
        sb.append(this.mExt);
        sb.append(" ,");
        sb.append(" mShield=");
        sb.append(this.mShield);
        sb.append(" ,");
        sb.append(" mShieldTime=");
        sb.append(this.mShieldTime);
        sb.append(" ,");
        sb.append(" vPortrait=");
        sb.append(this.vPortrait);
        sb.append(" ,");
        sb.append(" mVipId=");
        sb.append(this.mVipId);
        sb.append(" ,");
        sb.append(" mCertification=");
        sb.append(this.mCertification);
        sb.append(" ,");
        sb.append(" mNickName=");
        sb.append(this.mNickName);
        sb.append(" ,");
        sb.append(" mSessionFrom=");
        sb.append(this.mSessionFrom);
        sb.append("]");
        return sb.toString();
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

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public ChatSession m11clone() throws CloneNotSupportedException {
        return (ChatSession) super.clone();
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

    public ChatSession(Parcel parcel) {
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
}
