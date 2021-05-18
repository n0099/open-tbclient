package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.AbstractImageProvider;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ImMessageCenterShowItemData extends AbstractImageProvider implements Serializable, Cloneable {
    public static final long serialVersionUID = 3133087680118197014L;
    public String friendBjhAvatar;
    public String friendId;
    public String friendName;
    public String friendNameShow;
    public String friendPortrait;
    public int friendStatus;
    public ChatSetting groupSetting;
    public boolean isSelected = false;
    public boolean isSelf;
    public String msgContent;
    public String ownerId;
    public String ownerName;
    public int sendStatus;
    public long serverTime;
    public int status;
    public String title;
    public int unReadCount;
    public int unReadCountExtra;
    public int userType;

    public String getFriendBjhAvatar() {
        return this.friendBjhAvatar;
    }

    public String getFriendId() {
        return this.friendId;
    }

    public String getFriendName() {
        return this.friendName;
    }

    public String getFriendNameShow() {
        if (!StringUtils.isNull(this.friendNameShow)) {
            return this.friendNameShow;
        }
        return this.friendName;
    }

    public String getFriendPortrait() {
        return this.friendPortrait;
    }

    public int getFriendStatus() {
        return this.friendStatus;
    }

    public ChatSetting getGroupSetting() {
        return this.groupSetting;
    }

    @Override // com.baidu.tbadk.core.util.AbstractImageProvider, com.baidu.tbadk.core.util.ImageProvider
    public ArrayList<String> getImageUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(getFriendPortrait());
        return arrayList;
    }

    public String getMsgContent() {
        return this.msgContent;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public String getPK() {
        return this.ownerId + "@" + this.friendId;
    }

    public int getSendStatus() {
        return this.sendStatus;
    }

    public long getServerTime() {
        return this.serverTime;
    }

    public int getStatus() {
        return this.status;
    }

    public String getTitle() {
        return this.title;
    }

    public int getUnReadCount() {
        return this.unReadCount;
    }

    public int getUnReadCountExtra() {
        return this.unReadCountExtra;
    }

    public int getUserType() {
        return this.userType;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public boolean isSelf() {
        return this.isSelf;
    }

    public void setFriendBjhAvatar(String str) {
        this.friendBjhAvatar = str;
    }

    public void setFriendId(String str) {
        this.friendId = str;
    }

    public void setFriendName(String str) {
        this.friendName = str;
    }

    public void setFriendNameShow(String str) {
        this.friendNameShow = str;
    }

    public void setFriendPortrait(String str) {
        this.friendPortrait = str;
    }

    public void setFriendStatus(int i2) {
        this.friendStatus = i2;
    }

    public void setGroupSetting(ChatSetting chatSetting) {
        this.groupSetting = chatSetting;
    }

    public void setMsgContent(String str) {
        this.msgContent = str;
    }

    public void setOwnerId(String str) {
        this.ownerId = str;
    }

    public void setOwnerName(String str) {
        this.ownerName = str;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void setSelf(boolean z) {
        this.isSelf = z;
    }

    public void setSendStatus(int i2) {
        this.sendStatus = i2;
    }

    public void setServerTime(long j) {
        this.serverTime = j;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUnReadCount(int i2) {
        this.unReadCount = i2;
    }

    public void setUnReadCountExtra(int i2) {
        this.unReadCountExtra = i2;
    }

    public void setUserType(int i2) {
        this.userType = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public ImMessageCenterShowItemData m14clone() {
        try {
            return (ImMessageCenterShowItemData) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            return this;
        }
    }
}
