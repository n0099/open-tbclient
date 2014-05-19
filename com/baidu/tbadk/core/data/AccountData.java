package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
/* loaded from: classes.dex */
public class AccountData implements Serializable {
    private static final long serialVersionUID = 4126203103788833116L;
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

    public void logPrint() {
        BdLog.v(getClass().getName(), "logPrint", "mAccount = " + this.mAccount);
        BdLog.v(getClass().getName(), "logPrint", "mPassword = " + this.mPassword);
        BdLog.v(getClass().getName(), "logPrint", "mIsActive = " + String.valueOf(this.mIsActive));
        BdLog.v(getClass().getName(), "logPrint", "BDUSS = " + this.BDUSS);
        BdLog.v(getClass().getName(), "logPrint", "portrait = " + this.portrait);
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
}
