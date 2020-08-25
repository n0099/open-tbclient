package com.baidu.tbadk.core.data;
/* loaded from: classes2.dex */
public class GroupData extends BaseGroupData {
    private static final long serialVersionUID = 5616188082014345808L;
    private String authorPortrait;
    private String forumName;
    private int grade;
    private int isHidePosition;
    private boolean isMeizhi;
    private String nickName;

    public String getAuthorPortrait() {
        return this.authorPortrait;
    }

    public void setAuthorPortrait(String str) {
        this.authorPortrait = str;
    }

    public void setIsHidePosition(int i) {
        this.isHidePosition = i;
    }

    public int getIsHidePosition() {
        return this.isHidePosition;
    }

    public int getGrade() {
        return this.grade;
    }

    public void setGrade(int i) {
        this.grade = i;
    }

    public String getForumName() {
        return this.forumName;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public boolean isMeizhi() {
        return this.isMeizhi;
    }

    public void setMeizhi(boolean z) {
        this.isMeizhi = z;
    }
}
