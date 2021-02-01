package com.baidu.live.talentshow.components.waitpanel;

import com.baidu.live.tieba.pb.interactionpopupwindow.IBaseDialogData;
/* loaded from: classes11.dex */
public class LiveVideoBCPanelData implements IBaseDialogData {
    private static final String DEFAULT = "";
    private String userPortrait = "";
    private String userNickName = "";
    private String anchorPortrait = "";
    private String anchorNickName = "";
    private int downTime = 0;

    public int getDownTime() {
        return this.downTime;
    }

    public void setDownTime(int i) {
        this.downTime = i;
    }

    public String getUserPortrait() {
        return this.userPortrait;
    }

    public void setUserPortrait(String str) {
        this.userPortrait = str;
    }

    public String getUserNickName() {
        return this.userNickName;
    }

    public void setUserNickName(String str) {
        this.userNickName = str;
    }

    public String getAnchorPortrait() {
        return this.anchorPortrait;
    }

    public void setAnchorPortrait(String str) {
        this.anchorPortrait = str;
    }

    public String getAnchorNickName() {
        return this.anchorNickName;
    }

    public void setAnchorNickName(String str) {
        this.anchorNickName = str;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.IBaseDialogData
    public int getType() {
        return 0;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.IBaseDialogData
    public int getFrom() {
        return 0;
    }

    public void clear() {
        this.userNickName = "";
        this.userPortrait = "";
        this.anchorNickName = "";
        this.anchorPortrait = "";
        this.downTime = 0;
    }
}
