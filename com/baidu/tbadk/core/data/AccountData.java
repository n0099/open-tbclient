package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tieba.R;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes3.dex */
public class AccountData implements Serializable {
    public static final long serialVersionUID = 4126203103788833116L;
    public String bjhAvatar;
    public boolean isBigV;
    public int liveLevel;
    public String mDisplayName;
    public int mGodType;
    public boolean mIsSelectTail;
    public int mMemberCloseAdIsOpen;
    public int mMemberCloseAdVipClose;
    public String mMemberIconUrl;
    public int mMemberType;
    public int mNewGodStatus;
    public int mSex;
    public List<IconData> mUserIcons;
    public UserVipInfoData mVipInfo;
    public String nameShow;
    public String personalBgUrl;
    public String portrait;
    public String uk;
    public String mID = null;
    public String mAccount = null;
    public String mPassword = null;
    public String BDUSS = null;
    public String mTbs = null;
    public String mStoken = null;
    public int mIsActive = 0;
    public long mTime = 0;
    public long mPersonalGid = 0;

    public String getAccount() {
        return this.mAccount;
    }

    public String getAccountNameShow() {
        if (!TextUtils.isEmpty(this.nameShow)) {
            return this.nameShow;
        }
        if (!TextUtils.isEmpty(this.mDisplayName)) {
            return this.mDisplayName;
        }
        if (!TextUtils.isEmpty(this.mAccount)) {
            return this.mAccount;
        }
        return TbadkCoreApplication.getInst().getString(R.string.account_default_text);
    }

    public String getAvatar() {
        if (!TextUtils.isEmpty(this.bjhAvatar)) {
            return this.bjhAvatar;
        }
        return this.portrait;
    }

    public String getBDUSS() {
        return this.BDUSS;
    }

    public String getDisplayName() {
        return this.mDisplayName;
    }

    public int getGodType() {
        return this.mGodType;
    }

    public String getID() {
        return this.mID;
    }

    public int getIsActive() {
        return this.mIsActive;
    }

    public boolean getIsSelectTail() {
        return this.mIsSelectTail;
    }

    public int getLiveLevel() {
        return this.liveLevel;
    }

    public int getMemberCloseAdIsOpen() {
        return this.mMemberCloseAdIsOpen;
    }

    public int getMemberCloseAdVipClose() {
        return this.mMemberCloseAdVipClose;
    }

    public String getMemberIconUrl() {
        return this.mMemberIconUrl;
    }

    public int getMemberType() {
        return this.mMemberType;
    }

    public int getNewGodStatus() {
        return this.mNewGodStatus;
    }

    public String getPassword() {
        return this.mPassword;
    }

    public String getPersonalBgUrl() {
        return this.personalBgUrl;
    }

    public long getPersonalGid() {
        return this.mPersonalGid;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public int getSex() {
        return this.mSex;
    }

    public String getStoken() {
        return this.mStoken;
    }

    public String getTbs() {
        return this.mTbs;
    }

    public long getTime() {
        return this.mTime;
    }

    public String getUk() {
        return this.uk;
    }

    public List<IconData> getUserIcons() {
        return this.mUserIcons;
    }

    public UserVipInfoData getVipInfo() {
        return this.mVipInfo;
    }

    public boolean isBigV() {
        return this.isBigV;
    }

    public boolean isMemberCloseAdIsOpen() {
        return this.mMemberCloseAdIsOpen == 1;
    }

    public void setAccount(String str) {
        this.mAccount = str;
    }

    public void setBDUSS(String str) {
        this.BDUSS = str;
    }

    public void setBjhAvatar(String str) {
        this.bjhAvatar = str;
    }

    public void setDisplayName(String str) {
        this.mDisplayName = str;
    }

    public void setGodType(int i) {
        this.mGodType = i;
    }

    public void setID(String str) {
        this.mID = str;
    }

    public void setIsActive(int i) {
        this.mIsActive = i;
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }

    public void setIsSelectTail(boolean z) {
        this.mIsSelectTail = z;
    }

    public void setLiveLevel(int i) {
        this.liveLevel = i;
    }

    public void setMemberCloseAdIsOpen(int i) {
        this.mMemberCloseAdIsOpen = i;
    }

    public void setMemberCloseAdVipClose(int i) {
        this.mMemberCloseAdVipClose = i;
    }

    public void setMemberIconUrl(String str) {
        this.mMemberIconUrl = str;
    }

    public void setMemberType(int i) {
        this.mMemberType = i;
    }

    public void setNameShow(String str) {
        this.nameShow = str;
    }

    public void setNewGodStatus(int i) {
        this.mNewGodStatus = i;
    }

    public void setPassword(String str) {
        this.mPassword = str;
    }

    public void setPersonalBgUrl(String str) {
        this.personalBgUrl = str;
    }

    public void setPersonalGid(long j) {
        this.mPersonalGid = j;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public void setSex(int i) {
        this.mSex = i;
    }

    public void setStoken(String str) {
        this.mStoken = str;
    }

    public void setTbs(String str) {
        this.mTbs = str;
    }

    public void setTime(long j) {
        this.mTime = j;
    }

    public void setUk(String str) {
        this.uk = str;
    }

    public void setUserIcons(List<IconData> list) {
        this.mUserIcons = list;
    }

    public void setVipInfo(UserVipInfoData userVipInfoData) {
        this.mVipInfo = userVipInfoData;
    }
}
