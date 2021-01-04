package com.baidu.android.imsdk.group;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.NoProGuard;
/* loaded from: classes4.dex */
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
        public GroupMember[] newArray(int i) {
            return new GroupMember[i];
        }
    };
    public static final int ROLECOMMON = 0;
    public static final int ROLEMANAGER = 2;
    public static final int ROLEMASTER = 1;
    private int addStatus;
    private String groupid;
    private long jointime;
    private long mBduid;
    private String mName;
    private String mNickName;
    private String mPortrait;
    private long mUk;
    private int role;
    private int valid;

    public GroupMember(long j, String str, int i) {
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
        this.role = i;
    }

    public GroupMember(String str, long j, String str2, long j2, int i, long j3) {
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
        this.role = i;
        this.jointime = j3;
    }

    public String toString() {
        return "GroupMember [groupid=" + this.groupid + ", mUk=" + this.mUk + ", mName=" + this.mName + ", mBduid=" + this.mBduid + ", role=" + this.role + ", jointime=" + this.jointime + ", addStatus=" + this.addStatus + ", valid=" + this.valid + ", mPortrait=" + getPortrait() + "]";
    }

    GroupMember(Parcel parcel) {
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

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mUk);
        parcel.writeString(this.mName);
        parcel.writeInt(this.role);
        parcel.writeLong(this.jointime);
        parcel.writeLong(this.mBduid);
        parcel.writeString(this.groupid);
        parcel.writeString(getPortrait());
    }

    public long getUk() {
        return this.mUk;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getNickName() {
        return this.mNickName;
    }

    public void setNickName(String str) {
        this.mNickName = str;
    }

    public int getRole() {
        return this.role;
    }

    public void setRole(int i) {
        this.role = i;
    }

    public long getBduid() {
        return this.mBduid;
    }

    public void setBduid(long j) {
        this.mBduid = j;
    }

    public long getJointime() {
        return this.jointime;
    }

    public void setJointime(long j) {
        this.jointime = j;
    }

    public String getGroupid() {
        return this.groupid;
    }

    public void setGroupid(String str) {
        this.groupid = str;
    }

    public void setAddStatus(int i) {
        this.addStatus = i;
    }

    public int getAddStatus() {
        return this.addStatus;
    }

    public int getValid() {
        return this.valid;
    }

    public void setValid(int i) {
        this.valid = i;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }
}
