package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.AbstractImageProvider;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ImMessageCenterShowItemData extends AbstractImageProvider implements Serializable, Cloneable {
    private static final long serialVersionUID = 3133087680118197014L;
    protected String friendBjhAvatar;
    protected String friendId;
    protected String friendName;
    protected String friendNameShow;
    protected String friendPortrait;
    private int friendStatus;
    private ChatSetting groupSetting;
    private boolean isSelected = false;
    private boolean isSelf;
    protected String msgContent;
    protected String ownerId;
    protected String ownerName;
    private int sendStatus;
    protected long serverTime;
    protected int status;
    private String title;
    protected int unReadCount;
    protected int unReadCountExtra;
    private int userType;

    public String getPK() {
        return this.ownerId + "@" + this.friendId;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public void setOwnerId(String str) {
        this.ownerId = str;
    }

    public String getFriendId() {
        return this.friendId;
    }

    public void setFriendId(String str) {
        this.friendId = str;
    }

    public String getFriendPortrait() {
        return this.friendPortrait;
    }

    public void setFriendPortrait(String str) {
        this.friendPortrait = str;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public long getServerTime() {
        return this.serverTime;
    }

    public void setServerTime(long j) {
        this.serverTime = j;
    }

    public String getMsgContent() {
        return this.msgContent;
    }

    public void setMsgContent(String str) {
        this.msgContent = str;
    }

    public int getUnReadCount() {
        return this.unReadCount;
    }

    public void setUnReadCount(int i) {
        this.unReadCount = i;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public void setOwnerName(String str) {
        this.ownerName = str;
    }

    public String getFriendName() {
        return this.friendName;
    }

    public void setFriendName(String str) {
        this.friendName = str;
    }

    public String getFriendNameShow() {
        return !StringUtils.isNull(this.friendNameShow) ? this.friendNameShow : this.friendName;
    }

    public void setFriendNameShow(String str) {
        this.friendNameShow = str;
    }

    public String getFriendBjhAvatar() {
        return this.friendBjhAvatar;
    }

    public void setFriendBjhAvatar(String str) {
        this.friendBjhAvatar = str;
    }

    public ChatSetting getGroupSetting() {
        return this.groupSetting;
    }

    public void setGroupSetting(ChatSetting chatSetting) {
        this.groupSetting = chatSetting;
    }

    public int getUnReadCountExtra() {
        return this.unReadCountExtra;
    }

    public void setUnReadCountExtra(int i) {
        this.unReadCountExtra = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public boolean isSelf() {
        return this.isSelf;
    }

    public void setSelf(boolean z) {
        this.isSelf = z;
    }

    @Override // com.baidu.tbadk.core.util.AbstractImageProvider
    public ArrayList<String> getImageUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(getFriendPortrait());
        return arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public ImMessageCenterShowItemData m30clone() {
        try {
            return (ImMessageCenterShowItemData) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return this;
        }
    }

    public void setFriendStatus(int i) {
        this.friendStatus = i;
    }

    public int getFriendStatus() {
        return this.friendStatus;
    }

    public int getSendStatus() {
        return this.sendStatus;
    }

    public void setSendStatus(int i) {
        this.sendStatus = i;
    }

    public int getUserType() {
        return this.userType;
    }

    public void setUserType(int i) {
        this.userType = i;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }
}
