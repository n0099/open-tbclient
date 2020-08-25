package com.baidu.android.imsdk.shield.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.HttpHelper;
/* loaded from: classes9.dex */
public class GetShieldAndTopResult extends HttpHelper.ResponseResult implements Parcelable {
    public static final Parcelable.Creator<GetShieldAndTopResult> CREATOR = new Parcelable.Creator<GetShieldAndTopResult>() { // from class: com.baidu.android.imsdk.shield.model.GetShieldAndTopResult.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GetShieldAndTopResult createFromParcel(Parcel parcel) {
            return new GetShieldAndTopResult(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GetShieldAndTopResult[] newArray(int i) {
            return new GetShieldAndTopResult[i];
        }
    };
    public static final String TAG = "GetShieldAndTopResult";
    private int mChatType;
    private long mContacter;
    private int mDisturbStatus;
    private long mDisturbTime;
    private int mMarkTop;
    private long mMarkTopTime;
    private int mShield;
    private long mShieldTime;

    public GetShieldAndTopResult() {
    }

    protected GetShieldAndTopResult(Parcel parcel) {
        this.mErrorCode = parcel.readInt();
        this.mErrorMsg = parcel.readString();
        this.mMarkTop = parcel.readInt();
        this.mMarkTopTime = parcel.readLong();
        this.mShield = parcel.readInt();
        this.mShieldTime = parcel.readLong();
        this.mContacter = parcel.readLong();
        this.mChatType = parcel.readInt();
        this.mDisturbStatus = parcel.readInt();
        this.mDisturbTime = parcel.readLong();
    }

    public int getMarkTop() {
        return this.mMarkTop;
    }

    public long getMarkTopTime() {
        return this.mMarkTopTime;
    }

    public int getShield() {
        return this.mShield;
    }

    public long getShieldTime() {
        return this.mShieldTime;
    }

    public long getContacter() {
        return this.mContacter;
    }

    public void setMarkTop(int i) {
        this.mMarkTop = i;
    }

    public void setMarkTopTime(long j) {
        this.mMarkTopTime = j;
    }

    public void setShield(int i) {
        this.mShield = i;
    }

    public void setShieldTime(long j) {
        this.mShieldTime = j;
    }

    public void setContacter(long j) {
        this.mContacter = j;
    }

    public void setChatType(int i) {
        this.mChatType = i;
    }

    public void setDisturbStatus(int i) {
        this.mDisturbStatus = i;
    }

    public void setDisturbTime(long j) {
        this.mDisturbTime = j;
    }

    public int getChatType() {
        return this.mChatType;
    }

    public int getDisturbStatus() {
        return this.mDisturbStatus;
    }

    public long getDisturbTime() {
        return this.mDisturbTime;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mErrorCode);
        parcel.writeString(this.mErrorMsg);
        parcel.writeInt(this.mMarkTop);
        parcel.writeLong(this.mMarkTopTime);
        parcel.writeInt(this.mShield);
        parcel.writeLong(this.mShieldTime);
        parcel.writeLong(this.mContacter);
        parcel.writeInt(this.mChatType);
        parcel.writeInt(this.mDisturbStatus);
        parcel.writeLong(this.mDisturbTime);
    }
}
