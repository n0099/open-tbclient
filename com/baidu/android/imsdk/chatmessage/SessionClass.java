package com.baidu.android.imsdk.chatmessage;
/* loaded from: classes18.dex */
public class SessionClass {
    private String avatarurl;
    private int show;
    private String title;
    private int type;
    private int unreadcount;

    public int getType() {
        return this.type;
    }

    public String getAvatarurl() {
        return this.avatarurl;
    }

    public String getTitle() {
        return this.title;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setAvatarurl(String str) {
        this.avatarurl = str;
    }

    public void setUnread(int i) {
        this.unreadcount = i;
    }

    public int getUnread() {
        return this.unreadcount;
    }

    public void setShow(int i) {
        this.show = i;
    }

    public int isShow() {
        return this.show;
    }
}
