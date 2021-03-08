package com.baidu.live.im.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.core.util.TbEnum;
/* loaded from: classes10.dex */
public class a extends HttpMessage {
    private String appId;
    private com.baidu.live.im.data.d barrageCardInfo;
    private String barrageId;
    private int barrageType;
    private int brb;
    private boolean brc;
    private String content;
    private String customRoomId;
    private int groupId;
    private String[] imEffect;
    private boolean isOut;
    private boolean isQuickBarrage;
    private boolean isUseCard;
    private String liveId;
    private short msgType;
    private String otherParams;
    private long price;
    private String roomId;
    private String text;

    public a(String str, short s, int i, String str2) {
        super(1021013);
        this.brc = false;
        this.isOut = false;
        this.isQuickBarrage = false;
        this.text = "";
        this.isUseCard = false;
        this.content = str;
        this.msgType = s;
        this.groupId = i;
        this.appId = str2;
        addParam(TbEnum.SystemMessage.KEY_GROUP_ID, i);
        addParam("content", str);
        addParam("thirdAppId", str2);
        addParam("msgType", (int) s);
    }

    public String getContent() {
        return this.content;
    }

    public short Lq() {
        return this.msgType;
    }

    public void setLiveId(String str) {
        this.liveId = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public String Lr() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public long Ls() {
        return this.price;
    }

    public void aZ(long j) {
        this.price = j;
    }

    public int Lg() {
        return this.barrageType;
    }

    public void dD(int i) {
        this.barrageType = i;
    }

    public String Lh() {
        return this.barrageId;
    }

    public void hn(String str) {
        this.barrageId = str;
    }

    public com.baidu.live.im.data.d Li() {
        return this.barrageCardInfo;
    }

    public void a(com.baidu.live.im.data.d dVar) {
        this.barrageCardInfo = dVar;
    }

    public String[] Lj() {
        return this.imEffect;
    }

    public void l(String[] strArr) {
        this.imEffect = strArr;
    }

    public void cq(boolean z) {
        this.brc = z;
    }

    public boolean Lt() {
        return this.brc;
    }

    public void cr(boolean z) {
        this.isOut = z;
    }

    public boolean Lu() {
        return this.isUseCard;
    }

    public void cs(boolean z) {
        this.isUseCard = z;
    }

    public boolean Lv() {
        return this.isOut;
    }

    public void ct(boolean z) {
        this.isQuickBarrage = z;
    }

    public boolean Lw() {
        return this.isQuickBarrage;
    }

    public void setText(String str) {
        this.text = str;
    }

    public String getText() {
        return this.text;
    }

    public void dE(int i) {
        this.brb = i;
    }

    public boolean Lx() {
        return this.brb == 1;
    }

    public String getCustomRoomId() {
        return this.customRoomId;
    }

    public void setCustomRoomId(String str) {
        this.customRoomId = str;
    }
}
