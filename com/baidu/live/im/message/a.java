package com.baidu.live.im.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.core.util.TbEnum;
/* loaded from: classes10.dex */
public class a extends HttpMessage {
    private String appId;
    private com.baidu.live.im.data.d barrageCardInfo;
    private String barrageId;
    private int barrageType;
    private int bma;
    private boolean bmb;
    private String content;
    private String customRoomId;
    private int groupId;
    private String[] imEffect;
    private boolean isOut;
    private boolean isQuickBarrage;
    private String liveId;
    private short msgType;
    private String otherParams;
    private long price;
    private String roomId;
    private String text;

    public a(String str, short s, int i, String str2) {
        super(1021013);
        this.bmb = false;
        this.isOut = false;
        this.isQuickBarrage = false;
        this.text = "";
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

    public short JP() {
        return this.msgType;
    }

    public void setLiveId(String str) {
        this.liveId = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public String JQ() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public long JR() {
        return this.price;
    }

    public void aV(long j) {
        this.price = j;
    }

    public int JF() {
        return this.barrageType;
    }

    public void dw(int i) {
        this.barrageType = i;
    }

    public String JG() {
        return this.barrageId;
    }

    public void gI(String str) {
        this.barrageId = str;
    }

    public com.baidu.live.im.data.d JH() {
        return this.barrageCardInfo;
    }

    public void a(com.baidu.live.im.data.d dVar) {
        this.barrageCardInfo = dVar;
    }

    public String[] JI() {
        return this.imEffect;
    }

    public void l(String[] strArr) {
        this.imEffect = strArr;
    }

    public void ci(boolean z) {
        this.bmb = z;
    }

    public boolean JS() {
        return this.bmb;
    }

    public void cj(boolean z) {
        this.isOut = z;
    }

    public boolean JT() {
        return this.isOut;
    }

    public void ck(boolean z) {
        this.isQuickBarrage = z;
    }

    public boolean JU() {
        return this.isQuickBarrage;
    }

    public void setText(String str) {
        this.text = str;
    }

    public String getText() {
        return this.text;
    }

    public void dx(int i) {
        this.bma = i;
    }

    public boolean JV() {
        return this.bma == 1;
    }

    public String getCustomRoomId() {
        return this.customRoomId;
    }

    public void setCustomRoomId(String str) {
        this.customRoomId = str;
    }
}
