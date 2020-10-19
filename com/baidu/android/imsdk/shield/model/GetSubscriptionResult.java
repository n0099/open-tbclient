package com.baidu.android.imsdk.shield.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.HttpHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
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
        public GetSubscriptionResult[] newArray(int i) {
            return new GetSubscriptionResult[i];
        }
    };
    public static final String TAG = "GetSubscriptionResult";
    private String mPaAvatar;
    private String mPaNickName;
    private long mPauid;
    private List<SubscriptionInfo> mSubscriptionList;

    public GetSubscriptionResult() {
        this.mSubscriptionList = new ArrayList();
    }

    protected GetSubscriptionResult(Parcel parcel) {
        this.mErrorCode = parcel.readInt();
        this.mErrorMsg = parcel.readString();
        this.mSubscriptionList = new ArrayList();
        parcel.readList(this.mSubscriptionList, SubscriptionInfo.class.getClassLoader());
        this.mPauid = parcel.readLong();
        this.mPaAvatar = parcel.readString();
        this.mPaNickName = parcel.readString();
    }

    public List<SubscriptionInfo> getSubscriptionList() {
        return this.mSubscriptionList;
    }

    public long getPauid() {
        return this.mPauid;
    }

    public String getPaAvatar() {
        return this.mPaAvatar;
    }

    public String getPaNickName() {
        return this.mPaNickName;
    }

    public void setPauid(long j) {
        this.mPauid = j;
    }

    public void setPaAvatar(String str) {
        this.mPaAvatar = str;
    }

    public void setPaNickName(String str) {
        this.mPaNickName = str;
    }

    public void setSubscriptionList(List<SubscriptionInfo> list) {
        this.mSubscriptionList.clear();
        this.mSubscriptionList.addAll(list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mErrorCode);
        parcel.writeString(this.mErrorMsg);
        parcel.writeList(this.mSubscriptionList);
        parcel.writeLong(this.mPauid);
        parcel.writeString(this.mPaAvatar);
        parcel.writeString(this.mPaNickName);
    }

    /* loaded from: classes5.dex */
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
            public SubscriptionInfo[] newArray(int i) {
                return new SubscriptionInfo[i];
            }
        };
        private static final String TAG = "SubscriptionInfo";
        private String mDescription;
        private String mMiNiTopicId;
        private int mStatus;
        private long mTopicId;
        private String mTopicName;

        public SubscriptionInfo(long j, String str, String str2, int i) {
            this.mTopicName = "";
            this.mDescription = "";
            this.mTopicId = j;
            this.mTopicName = str;
            this.mDescription = str2;
            this.mStatus = i;
        }

        public SubscriptionInfo() {
            this.mTopicName = "";
            this.mDescription = "";
        }

        protected SubscriptionInfo(Parcel parcel) {
            this.mTopicName = "";
            this.mDescription = "";
            this.mTopicId = parcel.readLong();
            this.mMiNiTopicId = parcel.readString();
            this.mTopicName = parcel.readString();
            this.mDescription = parcel.readString();
            this.mStatus = parcel.readInt();
        }

        public long getTopicId() {
            return this.mTopicId;
        }

        public String getMiNiTopicId() {
            return this.mMiNiTopicId;
        }

        public String getTopicName() {
            return this.mTopicName;
        }

        public String getDescription() {
            return this.mDescription;
        }

        public int getStatus() {
            return this.mStatus;
        }

        public void setTopicId(long j) {
            this.mTopicId = j;
        }

        public void setMiNiTopicId(String str) {
            this.mMiNiTopicId = str;
        }

        public void setTopicName(String str) {
            this.mTopicName = str;
        }

        public void setDescription(String str) {
            this.mDescription = str;
        }

        public void setStatus(int i) {
            this.mStatus = i;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.mTopicId);
            parcel.writeString(this.mMiNiTopicId);
            parcel.writeString(this.mTopicName);
            parcel.writeString(this.mDescription);
            parcel.writeInt(this.mStatus);
        }
    }
}
