package com.baidu.tbadk.core.data;
/* loaded from: classes3.dex */
public class GroupData extends BaseGroupData {
    public static final long serialVersionUID = 5616188082014345808L;
    public String authorPortrait;
    public String forumName;
    public int grade;
    public int isHidePosition;
    public boolean isMeizhi;
    public String nickName;

    public String getAuthorPortrait() {
        return this.authorPortrait;
    }

    public String getForumName() {
        return this.forumName;
    }

    public int getGrade() {
        return this.grade;
    }

    public int getIsHidePosition() {
        return this.isHidePosition;
    }

    public String getNickName() {
        return this.nickName;
    }

    public boolean isMeizhi() {
        return this.isMeizhi;
    }

    public void setAuthorPortrait(String str) {
        this.authorPortrait = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public void setGrade(int i) {
        this.grade = i;
    }

    public void setIsHidePosition(int i) {
        this.isHidePosition = i;
    }

    public void setMeizhi(boolean z) {
        this.isMeizhi = z;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }
}
