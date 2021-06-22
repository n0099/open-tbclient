package com.baidu.android.imsdk.group;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
/* loaded from: classes.dex */
public class GroupMember implements Parcelable, NoProGuard {
    public static final int ADDSTATUSFAIL = 1;
    public static final int ADDSTATUSORIG = 2;
    public static final int ADDSTATUSSUC = 0;
    public static final Parcelable.Creator<GroupMember> CREATOR = new Parcelable.Creator<GroupMember>() { // from class: com.baidu.android.imsdk.group.GroupMember.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupMember createFromParcel(Parcel parcel) {
            return new GroupMember(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupMember[] newArray(int i2) {
            return new GroupMember[i2];
        }
    };
    public static final int ROLECOMMON = 0;
    public static final int ROLEMANAGER = 2;
    public static final int ROLEMASTER = 1;
    public int addStatus;
    public String groupid;
    public long jointime;
    public long mBduid;
    public String mName;
    public String mNickName;
    public String mPortrait;
    public long mUk;
    public int role;
    public int valid;

    public GroupMember(long j, String str, int i2) {
        this.mUk = -1L;
        this.mName = "";
        this.role = 0;
        this.jointime = 0L;
        this.addStatus = 0;
        this.valid = 0;
        this.mNickName = "";
        this.mPortrait = "";
        this.mUk = j;
        this.mName = str;
        this.role = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAddStatus() {
        return this.addStatus;
    }

    public long getBduid() {
        return this.mBduid;
    }

    public String getGroupid() {
        return this.groupid;
    }

    public long getJointime() {
        return this.jointime;
    }

    public String getName() {
        return this.mName;
    }

    public String getNickName() {
        return this.mNickName;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getRole() {
        return this.role;
    }

    public String getShowName() {
        return TextUtils.isEmpty(this.mNickName) ? this.mName : this.mNickName;
    }

    public long getUk() {
        return this.mUk;
    }

    public int getValid() {
        return this.valid;
    }

    public void setAddStatus(int i2) {
        this.addStatus = i2;
    }

    public void setBduid(long j) {
        this.mBduid = j;
    }

    public void setGroupid(String str) {
        this.groupid = str;
    }

    public void setJointime(long j) {
        this.jointime = j;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setNickName(String str) {
        this.mNickName = str;
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public void setRole(int i2) {
        this.role = i2;
    }

    public void setValid(int i2) {
        this.valid = i2;
    }

    public String toString() {
        return "GroupMember [groupid=" + this.groupid + ", mUk=" + this.mUk + ", mName=" + this.mName + ", mBduid=" + this.mBduid + ", role=" + this.role + ", jointime=" + this.jointime + ", addStatus=" + this.addStatus + ", valid=" + this.valid + ", mPortrait=" + getPortrait() + PreferencesUtil.RIGHT_MOUNT;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.mUk);
        parcel.writeString(this.mName);
        parcel.writeInt(this.role);
        parcel.writeLong(this.jointime);
        parcel.writeLong(this.mBduid);
        parcel.writeString(this.groupid);
        parcel.writeString(getPortrait());
    }

    public GroupMember(String str, long j, String str2, long j2, int i2, long j3) {
        this.mUk = -1L;
        this.mName = "";
        this.role = 0;
        this.jointime = 0L;
        this.addStatus = 0;
        this.valid = 0;
        this.mNickName = "";
        this.mPortrait = "";
        this.groupid = str;
        this.mUk = j;
        this.mName = str2;
        this.mBduid = j2;
        this.role = i2;
        this.jointime = j3;
    }

    public GroupMember(Parcel parcel) {
        this.mUk = -1L;
        this.mName = "";
        this.role = 0;
        this.jointime = 0L;
        this.addStatus = 0;
        this.valid = 0;
        this.mNickName = "";
        this.mPortrait = "";
        this.mUk = parcel.readLong();
        this.mName = parcel.readString();
        this.role = parcel.readInt();
        this.jointime = parcel.readLong();
        this.mBduid = parcel.readLong();
        this.groupid = parcel.readString();
        setPortrait(parcel.readString());
    }
}
