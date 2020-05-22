package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tieba.R;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes.dex */
public class AccountData implements Serializable {
    private static final long serialVersionUID = 4126203103788833116L;
    private String bjhAvatar;
    private boolean isBigV;
    private int liveLevel;
    private String mDisplayName;
    private int mGodType;
    private boolean mIsSelectTail;
    private int mMemberCloseAdIsOpen;
    private int mMemberCloseAdVipClose;
    private String mMemberIconUrl;
    private int mMemberType;
    private int mNewGodStatus;
    private int mSex;
    private List<IconData> mUserIcons;
    private UserVipInfoData mVipInfo;
    private String nameShow;
    private String personalBgUrl;
    private String portrait;
    private String mID = null;
    private String mAccount = null;
    private String mPassword = null;
    private String BDUSS = null;
    private String mTbs = null;
    private String mStoken = null;
    private int mIsActive = 0;
    private long mTime = 0;
    private long mPersonalGid = 0;

    public String getID() {
        return this.mID;
    }

    public void setID(String str) {
        this.mID = str;
    }

    public void setStoken(String str) {
        this.mStoken = str;
    }

    public String getStoken() {
        return this.mStoken;
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

    public String getDisplayName() {
        return this.mDisplayName;
    }

    public void setDisplayName(String str) {
        this.mDisplayName = str;
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

    public long getPersonalGid() {
        return this.mPersonalGid;
    }

    public void setPersonalGid(long j) {
        this.mPersonalGid = j;
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

    public void setMemberCloseAdIsOpen(int i) {
        this.mMemberCloseAdIsOpen = i;
    }

    public void setMemberCloseAdVipClose(int i) {
        this.mMemberCloseAdVipClose = i;
    }

    public int getMemberCloseAdIsOpen() {
        return this.mMemberCloseAdIsOpen;
    }

    public boolean isMemberCloseAdIsOpen() {
        return this.mMemberCloseAdIsOpen == 1;
    }

    public int getMemberCloseAdVipClose() {
        return this.mMemberCloseAdVipClose;
    }

    public boolean getIsSelectTail() {
        return this.mIsSelectTail;
    }

    public void setIsSelectTail(boolean z) {
        this.mIsSelectTail = z;
    }

    public int getGodType() {
        return this.mGodType;
    }

    public void setGodType(int i) {
        this.mGodType = i;
    }

    public String getPersonalBgUrl() {
        return this.personalBgUrl;
    }

    public void setPersonalBgUrl(String str) {
        this.personalBgUrl = str;
    }

    public int getLiveLevel() {
        return this.liveLevel;
    }

    public void setLiveLevel(int i) {
        this.liveLevel = i;
    }

    public boolean isBigV() {
        return this.isBigV;
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }

    public void setNameShow(String str) {
        this.nameShow = str;
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
        return !TextUtils.isEmpty(this.bjhAvatar) ? this.bjhAvatar : this.portrait;
    }

    public void setBjhAvatar(String str) {
        this.bjhAvatar = str;
    }

    public int getNewGodStatus() {
        return this.mNewGodStatus;
    }

    public void setNewGodStatus(int i) {
        this.mNewGodStatus = i;
    }
}
