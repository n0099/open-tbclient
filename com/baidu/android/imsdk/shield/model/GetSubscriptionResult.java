package com.baidu.android.imsdk.shield.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.HttpHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class GetSubscriptionResult extends HttpHelper.ResponseResult implements Parcelable {
    public static final Parcelable.Creator<GetSubscriptionResult> CREATOR = new Parcelable.Creator<GetSubscriptionResult>() { // from class: com.baidu.android.imsdk.shield.model.GetSubscriptionResult.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GetSubscriptionResult createFromParcel(Parcel parcel) {
            return new GetSubscriptionResult(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GetSubscriptionResult[] newArray(int i2) {
            return new GetSubscriptionResult[i2];
        }
    };
    public static final String TAG = "GetSubscriptionResult";
    public String mPaAvatar;
    public String mPaNickName;
    public long mPauid;
    public List<SubscriptionInfo> mSubscriptionList;

    public GetSubscriptionResult() {
        this.mSubscriptionList = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getPaAvatar() {
        return this.mPaAvatar;
    }

    public String getPaNickName() {
        return this.mPaNickName;
    }

    public long getPauid() {
        return this.mPauid;
    }

    public List<SubscriptionInfo> getSubscriptionList() {
        return this.mSubscriptionList;
    }

    public void setPaAvatar(String str) {
        this.mPaAvatar = str;
    }

    public void setPaNickName(String str) {
        this.mPaNickName = str;
    }

    public void setPauid(long j) {
        this.mPauid = j;
    }

    public void setSubscriptionList(List<SubscriptionInfo> list) {
        this.mSubscriptionList.clear();
        this.mSubscriptionList.addAll(list);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.mErrorCode);
        parcel.writeString(this.mErrorMsg);
        parcel.writeList(this.mSubscriptionList);
        parcel.writeLong(this.mPauid);
        parcel.writeString(this.mPaAvatar);
        parcel.writeString(this.mPaNickName);
    }

    public GetSubscriptionResult(Parcel parcel) {
        this.mErrorCode = parcel.readInt();
        this.mErrorMsg = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.mSubscriptionList = arrayList;
        parcel.readList(arrayList, SubscriptionInfo.class.getClassLoader());
        this.mPauid = parcel.readLong();
        this.mPaAvatar = parcel.readString();
        this.mPaNickName = parcel.readString();
    }

    /* loaded from: classes.dex */
    public static class SubscriptionInfo implements Parcelable {
        public static final Parcelable.Creator<SubscriptionInfo> CREATOR = new Parcelable.Creator<SubscriptionInfo>() { // from class: com.baidu.android.imsdk.shield.model.GetSubscriptionResult.SubscriptionInfo.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SubscriptionInfo createFromParcel(Parcel parcel) {
                return new SubscriptionInfo(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SubscriptionInfo[] newArray(int i2) {
                return new SubscriptionInfo[i2];
            }
        };
        public static final String TAG = "SubscriptionInfo";
        public String mDescription;
        public String mMiNiTopicId;
        public int mStatus;
        public long mTopicId;
        public String mTopicName;

        public SubscriptionInfo(long j, String str, String str2, int i2) {
            this.mTopicName = "";
            this.mDescription = "";
            this.mTopicId = j;
            this.mTopicName = str;
            this.mDescription = str2;
            this.mStatus = i2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getDescription() {
            return this.mDescription;
        }

        public String getMiNiTopicId() {
            return this.mMiNiTopicId;
        }

        public int getStatus() {
            return this.mStatus;
        }

        public long getTopicId() {
            return this.mTopicId;
        }

        public String getTopicName() {
            return this.mTopicName;
        }

        public void setDescription(String str) {
            this.mDescription = str;
        }

        public void setMiNiTopicId(String str) {
            this.mMiNiTopicId = str;
        }

        public void setStatus(int i2) {
            this.mStatus = i2;
        }

        public void setTopicId(long j) {
            this.mTopicId = j;
        }

        public void setTopicName(String str) {
            this.mTopicName = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeLong(this.mTopicId);
            parcel.writeString(this.mMiNiTopicId);
            parcel.writeString(this.mTopicName);
            parcel.writeString(this.mDescription);
            parcel.writeInt(this.mStatus);
        }

        public SubscriptionInfo() {
            this.mTopicName = "";
            this.mDescription = "";
        }

        public SubscriptionInfo(Parcel parcel) {
            this.mTopicName = "";
            this.mDescription = "";
            this.mTopicId = parcel.readLong();
            this.mMiNiTopicId = parcel.readString();
            this.mTopicName = parcel.readString();
            this.mDescription = parcel.readString();
            this.mStatus = parcel.readInt();
        }
    }
}
