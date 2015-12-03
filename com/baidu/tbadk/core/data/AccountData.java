package com.baidu.tbadk.core.data;

import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserVipInfoData;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes.dex */
public class AccountData implements Serializable {
    private static final long serialVersionUID = 4126203103788833116L;
    private boolean mIsSelectTail;
    private String mMemberIconUrl;
    private int mMemberType;
    private int mSex;
    private List<IconData> mUserIcons;
    private UserVipInfoData mVipInfo;
    private String portrait;
    private String mID = null;
    private String mAccount = null;
    private String mPassword = null;
    private String BDUSS = null;
    private String mTbs = null;
    private int mIsActive = 0;
    private long mTime = 0;
    private int mPersonalGid = 0;

    public String getID() {
        return this.mID;
    }

    public void setID(String str) {
        this.mID = str;
    }

    public String getAccount() {
        return this.mAccount;
    }

    public void setAccount(String str) {
        this.mAccount = str;
    }

    public String getPassword() {
        return this.mPassword;
    }

    public void setPassword(String str) {
        this.mPassword = str;
    }

    public int getMemberType() {
        return this.mMemberType;
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void setVipInfo(UserVipInfoData userVipInfoData) {
        this.mVipInfo = userVipInfoData;
    }

    public UserVipInfoData getVipInfo() {
        return this.mVipInfo;
    }

    public String getBDUSS() {
        return this.BDUSS;
    }

    public void setBDUSS(String str) {
        this.BDUSS = str;
    }

    public int getIsActive() {
        return this.mIsActive;
    }

    public void setIsActive(int i) {
        this.mIsActive = i;
    }

    public List<IconData> getUserIcons() {
        return this.mUserIcons;
    }

    public void setUserIcons(List<IconData> list) {
        this.mUserIcons = list;
    }

    public void setTbs(String str) {
        this.mTbs = str;
    }

    public String getTbs() {
        return this.mTbs;
    }

    public void setTime(long j) {
        this.mTime = j;
    }

    public long getTime() {
        return this.mTime;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public int getPersonalGid() {
        return this.mPersonalGid;
    }

    public void setPersonalGid(int i) {
        this.mPersonalGid = i;
    }

    public int getSex() {
        return this.mSex;
    }

    public void setSex(int i) {
        this.mSex = i;
    }

    public String getMemberIconUrl() {
        return this.mMemberIconUrl;
    }

    public void setMemberIconUrl(String str) {
        this.mMemberIconUrl = str;
    }

    public boolean getIsSelectTail() {
        return this.mIsSelectTail;
    }

    public void setIsSelectTail(boolean z) {
        this.mIsSelectTail = z;
    }
}
