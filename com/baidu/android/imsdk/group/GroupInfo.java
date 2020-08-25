package com.baidu.android.imsdk.group;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.android.imsdk.utils.PinYinUtils;
/* loaded from: classes9.dex */
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
        public GroupInfo[] newArray(int i) {
            return new GroupInfo[i];
        }
    };
    private int brief;
    private int mActiveState;
    private long mBduid;
    private long mCreateTime;
    private String mDescription;
    private int mDisturb;
    private String mGroupId;
    private String mGroupName;
    private String mHeadUrl;
    private long mMembersVersion;
    private int mNum;
    private String mPinYin;
    private int mType;
    private long mUk;
    private int state;

    public String getHeadUrl() {
        return this.mHeadUrl;
    }

    public void setHeadUrl(String str) {
        this.mHeadUrl = str;
    }

    public int getBrief() {
        return this.brief;
    }

    public void setBrief(int i) {
        this.brief = i;
    }

    public GroupInfo(String str) {
        this.mGroupName = "";
        this.mDescription = "";
        this.mType = 0;
        this.mGroupId = str;
    }

    GroupInfo(Parcel parcel) {
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
    }

    public String toString() {
        return "GroupInfo [mGroupId=" + this.mGroupId + ", mGroupName=" + this.mGroupName + ", mDescription=" + this.mDescription + ", mType=" + this.mType + ", mPinYin=" + this.mPinYin + ", mCreateTime=" + this.mCreateTime + ", mBduid=" + this.mBduid + ", mUk=" + this.mUk + ", mNum=" + this.mNum + ", mMembersVersion=" + this.mMembersVersion + ", mDisturb=" + this.mDisturb + ", state=" + this.state + ", activeState=" + this.mActiveState + "]";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
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
    }

    public String getGroupId() {
        return this.mGroupId;
    }

    public void setGroupName(String str) {
        this.mGroupName = str;
    }

    public String getGroupName() {
        return this.mGroupName;
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int i) {
        this.state = i;
    }

    public int getDisturb() {
        return this.mDisturb;
    }

    public void setDisturb(int i) {
        this.mDisturb = i;
    }

    public void setCreateTime(long j) {
        this.mCreateTime = j;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void setBuid(long j) {
        this.mBduid = j;
    }

    public long getBuid() {
        return this.mBduid;
    }

    public void setUk(long j) {
        this.mUk = j;
    }

    public long getUk() {
        return this.mUk;
    }

    public void setNum(int i) {
        this.mNum = i;
    }

    public int getNum() {
        return this.mNum;
    }

    public long getMembersVersion() {
        return this.mMembersVersion;
    }

    public void setMembersVersion(long j) {
        this.mMembersVersion = j;
    }

    public int getActiveState() {
        return this.mActiveState;
    }

    public void setActiveState(int i) {
        this.mActiveState = i;
    }

    @Override // com.baidu.android.imsdk.utils.PinYinUtils.PinYinObject
    public String getPy() {
        if (TextUtils.isEmpty(this.mPinYin)) {
            this.mPinYin = PinYinUtils.getPy(this.mGroupName);
        }
        return this.mPinYin;
    }
}
