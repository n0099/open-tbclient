package com.baidu.android.imsdk.chatmessage;
/* loaded from: classes.dex */
public class SessionClass {
    public String avatarurl;
    public int show;
    public String title;
    public int type;
    public int unreadcount;

    public String getAvatarurl() {
        return this.avatarurl;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public int getUnread() {
        return this.unreadcount;
    }

    public int isShow() {
        return this.show;
    }

    public void setAvatarurl(String str) {
        this.avatarurl = str;
    }

    public void setShow(int i2) {
        this.show = i2;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public void setUnread(int i2) {
        this.unreadcount = i2;
    }
}
