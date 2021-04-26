package com.baidu.tbadk.core.data;

import com.baidu.tbadk.core.util.AbstractImageProvider;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class BaseGroupData extends AbstractImageProvider implements Serializable {
    public static final long serialVersionUID = 5616188082014345808L;
    public String album;
    public long authorId;
    public String authorName;
    public String authorNameShow;
    public String business;
    public int createTime;
    public int flag;
    public int forumId;
    public long groupId;
    public int groupType;
    public String intro;
    public String lat;
    public String lng;
    public int maxMemberNum;
    public int memberNum;
    public String name;
    public String notice;
    public String portrait;
    public String position;
    public int status;

    public String getAlbum() {
        return this.album;
    }

    public long getAuthorId() {
        return this.authorId;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public String getAuthorNameShow() {
        return this.authorNameShow;
    }

    public String getBusiness() {
        return this.business;
    }

    public int getCreateTime() {
        return this.createTime;
    }

    public int getFlag() {
        return this.flag;
    }

    public int getForumId() {
        return this.forumId;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public int getGroupType() {
        return this.groupType;
    }

    @Override // com.baidu.tbadk.core.util.AbstractImageProvider, com.baidu.tbadk.core.util.ImageProvider
    public ArrayList<String> getImageUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(this.portrait);
        return arrayList;
    }

    public String getIntro() {
        return this.intro;
    }

    public String getLat() {
        return this.lat;
    }

    public String getLng() {
        return this.lng;
    }

    public int getMaxMemberNum() {
        return this.maxMemberNum;
    }

    public int getMemberNum() {
        return this.memberNum;
    }

    public String getName() {
        return this.name;
    }

    public String getNotice() {
        return this.notice;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public String getPosition() {
        return this.position;
    }

    public int getStatus() {
        return this.status;
    }

    public void setAlbum(String str) {
        this.album = str;
    }

    public void setAuthorId(long j) {
        this.authorId = j;
    }

    public void setAuthorName(String str) {
        this.authorName = str;
    }

    public void setAuthorNameShow(String str) {
        this.authorNameShow = str;
    }

    public void setBusiness(String str) {
        this.business = str;
    }

    public void setCreateTime(int i2) {
        this.createTime = i2;
    }

    public void setFlag(int i2) {
        this.flag = i2;
    }

    public void setForumId(int i2) {
        this.forumId = i2;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public void setGroupType(int i2) {
        this.groupType = i2;
    }

    public void setIntro(String str) {
        this.intro = str;
    }

    public void setLat(String str) {
        this.lat = str;
    }

    public void setLng(String str) {
        this.lng = str;
    }

    public void setMaxMemberNum(int i2) {
        this.maxMemberNum = i2;
    }

    public void setMemberNum(int i2) {
        this.memberNum = i2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNotice(String str) {
        this.notice = str;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public void setPosition(String str) {
        this.position = str;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }
}
