package com.baidu.pass.main.facesdk.model;

import android.util.Base64;
/* loaded from: classes2.dex */
public class Feature {
    public long ctime;
    public byte[] feature;
    public int id;
    public boolean isChecked;
    public float score;
    public long updateTime;
    public String faceToken = "";
    public String userId = "";
    public String groupId = "";
    public String imageName = "";
    public String userName = "";
    public String cropImageName = "";

    public Feature() {
    }

    public Feature(int i, float f) {
        this.id = i;
        this.score = f;
    }

    public String getCropImageName() {
        return this.cropImageName;
    }

    public long getCtime() {
        return this.ctime;
    }

    public String getFaceToken() {
        byte[] bArr = this.feature;
        if (bArr != null) {
            this.faceToken = new String(Base64.encode(bArr, 2));
        }
        return this.faceToken;
    }

    public byte[] getFeature() {
        return this.feature;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public int getId() {
        return this.id;
    }

    public String getImageName() {
        return this.imageName;
    }

    public float getScore() {
        return this.score;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
    }

    public void setCropImageName(String str) {
        this.cropImageName = str;
    }

    public void setCtime(long j) {
        this.ctime = j;
    }

    public void setFaceToken(String str) {
        this.faceToken = str;
    }

    public void setFeature(byte[] bArr) {
        this.feature = bArr;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setImageName(String str) {
        this.imageName = str;
    }

    public void setScore(float f) {
        this.score = f;
    }

    public void setUpdateTime(long j) {
        this.updateTime = j;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }
}
