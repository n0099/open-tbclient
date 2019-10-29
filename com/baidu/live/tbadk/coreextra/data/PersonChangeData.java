package com.baidu.live.tbadk.coreextra.data;

import java.io.Serializable;
/* loaded from: classes6.dex */
public class PersonChangeData implements Serializable {
    public static final String TAG_PERSON_INFO = "person_change_data";
    private static final long serialVersionUID = 4345761658406426272L;
    private String mIntro = null;
    private int mSex = 0;
    private String mName = null;
    private String mPortrait = null;
    private boolean mPhotoChanged = false;
    private String mNameShow = null;
    private int mNickNameLeftDays = -1;
    private int isMem = 0;

    public String getIntro() {
        return this.mIntro;
    }

    public void setIntro(String str) {
        this.mIntro = str;
    }

    public int getSex() {
        return this.mSex;
    }

    public void setSex(int i) {
        this.mSex = i;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getName() {
        return this.mName;
    }

    public void setPhotoChanged(boolean z) {
        this.mPhotoChanged = z;
    }

    public boolean getPhotoChanged() {
        return this.mPhotoChanged;
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public String getNameShow() {
        return this.mNameShow;
    }

    public void setNameShow(String str) {
        this.mNameShow = str;
    }

    public int getNickNameLeftDays() {
        return this.mNickNameLeftDays;
    }

    public void setNickNameLeftDays(int i) {
        this.mNickNameLeftDays = i;
    }

    public int getMen() {
        return this.isMem;
    }

    public void setMem(int i) {
        this.isMem = i;
    }
}
