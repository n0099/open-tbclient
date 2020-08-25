package com.baidu.live.tbadk.data;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
@Deprecated
/* loaded from: classes7.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private NewsNotifyData mData;

    /* loaded from: classes7.dex */
    public class NewsNotifyData {
        private int mMsgAgreeme = 0;
        private int mMsgReplyme = 0;
        private int mMsgAtme = 0;
        private int mMsgChat = 0;
        private int mMsgFans = 0;
        private int mMsgBookmark = 0;
        private int mMsgGiftNum = 0;
        private int mMsgPrivateChat = 0;
        private int mMsgStrangerChat = 0;
        private int mMsgOfficialMerge = 0;

        public NewsNotifyData() {
        }
    }

    public NewsNotifyMessage() {
        super(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.mData = new NewsNotifyData();
    }

    public NewsNotifyMessage(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        super(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.mData = new NewsNotifyData();
        this.mData.mMsgAgreeme = i;
        this.mData.mMsgReplyme = i2;
        this.mData.mMsgAtme = i3;
        this.mData.mMsgChat = i4;
        this.mData.mMsgBookmark = i5;
        this.mData.mMsgGiftNum = i6;
        this.mData.mMsgPrivateChat = i7;
    }

    public int getMsgAgree() {
        return this.mData.mMsgAgreeme;
    }

    public void setMsgAgree(int i) {
        this.mData.mMsgAgreeme = i;
    }

    public int getMsgReplyme() {
        return this.mData.mMsgReplyme;
    }

    public void setMsgReplyme(int i) {
        this.mData.mMsgReplyme = i;
    }

    public int getMsgAtme() {
        return this.mData.mMsgAtme;
    }

    public void setMsgAtme(int i) {
        this.mData.mMsgAtme = i;
    }

    public int getMsgChat() {
        return this.mData.mMsgChat;
    }

    public void setMsgChat(int i) {
        this.mData.mMsgChat = i;
    }

    public void setMsgFans(int i) {
        this.mData.mMsgFans = i;
    }

    public int getMsgFans() {
        return this.mData.mMsgFans;
    }

    public int getMsgBookmark() {
        return this.mData.mMsgBookmark;
    }

    public void setMsgBookmark(int i) {
        this.mData.mMsgBookmark = i;
    }

    public int getMsgGiftNum() {
        return this.mData.mMsgGiftNum;
    }

    public void setMsgGiftNum(int i) {
        this.mData.mMsgGiftNum = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.mMsgPrivateChat = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.mMsgPrivateChat;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.mMsgStrangerChat = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.mMsgStrangerChat;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.mMsgOfficialMerge = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.mMsgOfficialMerge;
    }
}
