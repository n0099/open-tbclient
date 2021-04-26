package com.baidu.android.imsdk.group;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.android.imsdk.utils.PinYinUtils;
/* loaded from: classes.dex */
public class GroupInfo implements Parcelable, NoProGuard, PinYinUtils.PinYinObject {
    public static final Parcelable.Creator<GroupInfo> CREATOR = new Parcelable.Creator<GroupInfo>() { // from class: com.baidu.android.imsdk.group.GroupInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupInfo createFromParcel(Parcel parcel) {
            return new GroupInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupInfo[] newArray(int i2) {
            return new GroupInfo[i2];
        }
    };
    public int brief;
    public int mActiveState;
    public long mBduid;
    public long mCreateTime;
    public String mDescription;
    public int mDisturb;
    public String mGroupId;
    public String mGroupName;
    public String mHeadUrl;
    public int mMarkTop;
    public long mMarkTopTime;
    public long mMembersVersion;
    public int mNum;
    public String mPinYin;
    public int mType;
    public long mUk;
    public int state;

    public GroupInfo(String str) {
        this.mGroupName = "";
        this.mDescription = "";
        this.mType = 0;
        this.mGroupId = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getActiveState() {
        return this.mActiveState;
    }

    public int getBrief() {
        return this.brief;
    }

    public long getBuid() {
        return this.mBduid;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public int getDisturb() {
        return this.mDisturb;
    }

    public String getGroupId() {
        return this.mGroupId;
    }

    public String getGroupName() {
        return this.mGroupName;
    }

    public String getHeadUrl() {
        return this.mHeadUrl;
    }

    public int getMarkTop() {
        return this.mMarkTop;
    }

    public long getMarkTopTime() {
        return this.mMarkTopTime;
    }

    public long getMembersVersion() {
        return this.mMembersVersion;
    }

    public int getNum() {
        return this.mNum;
    }

    @Override // com.baidu.android.imsdk.utils.PinYinUtils.PinYinObject
    public String getPy() {
        if (TextUtils.isEmpty(this.mPinYin)) {
            this.mPinYin = PinYinUtils.getPy(this.mGroupName);
        }
        return this.mPinYin;
    }

    public int getState() {
        return this.state;
    }

    public int getType() {
        return this.mType;
    }

    public long getUk() {
        return this.mUk;
    }

    public void setActiveState(int i2) {
        this.mActiveState = i2;
    }

    public void setBrief(int i2) {
        this.brief = i2;
    }

    public void setBuid(long j) {
        this.mBduid = j;
    }

    public void setCreateTime(long j) {
        this.mCreateTime = j;
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    public void setDisturb(int i2) {
        this.mDisturb = i2;
    }

    public void setGroupName(String str) {
        this.mGroupName = str;
    }

    public void setHeadUrl(String str) {
        this.mHeadUrl = str;
    }

    public void setMarkTop(int i2) {
        this.mMarkTop = i2;
    }

    public void setMarkTopTime(long j) {
        this.mMarkTopTime = j;
    }

    public void setMembersVersion(long j) {
        this.mMembersVersion = j;
    }

    public void setNum(int i2) {
        this.mNum = i2;
    }

    public void setState(int i2) {
        this.state = i2;
    }

    public void setType(int i2) {
        this.mType = i2;
    }

    public void setUk(long j) {
        this.mUk = j;
    }

    public String toString() {
        return "GroupInfo [mGroupId=" + this.mGroupId + ", mGroupName=" + this.mGroupName + ", mDescription=" + this.mDescription + ", mType=" + this.mType + ", mPinYin=" + this.mPinYin + ", mCreateTime=" + this.mCreateTime + ", mBduid=" + this.mBduid + ", mUk=" + this.mUk + ", mNum=" + this.mNum + ", mMembersVersion=" + this.mMembersVersion + ", mDisturb=" + this.mDisturb + ", state=" + this.state + ", activeState=" + this.mActiveState + " marktop = " + this.mMarkTop + " martTime = " + this.mMarkTopTime + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mGroupId);
        parcel.writeString(this.mGroupName);
        parcel.writeString(this.mDescription);
        parcel.writeInt(this.mDisturb);
        parcel.writeInt(this.state);
        parcel.writeInt(this.mType);
        parcel.writeInt(this.mNum);
        parcel.writeLong(this.mCreateTime);
        parcel.writeLong(this.mBduid);
        parcel.writeLong(this.mUk);
        parcel.writeInt(this.mActiveState);
        parcel.writeLong(this.mMembersVersion);
        parcel.writeInt(this.brief);
        parcel.writeInt(this.mMarkTop);
        parcel.writeLong(this.mMarkTopTime);
    }

    public GroupInfo(Parcel parcel) {
        this.mGroupName = "";
        this.mDescription = "";
        this.mType = 0;
        this.mGroupId = parcel.readString();
        this.mGroupName = parcel.readString();
        this.mDescription = parcel.readString();
        this.mDisturb = parcel.readInt();
        this.state = parcel.readInt();
        this.mType = parcel.readInt();
        this.mNum = parcel.readInt();
        this.mCreateTime = parcel.readLong();
        this.mBduid = parcel.readLong();
        this.mUk = parcel.readLong();
        this.mActiveState = parcel.readInt();
        this.mMembersVersion = parcel.readLong();
        this.brief = parcel.readInt();
        this.mMarkTop = parcel.readInt();
        this.mMarkTopTime = parcel.readLong();
    }
}
