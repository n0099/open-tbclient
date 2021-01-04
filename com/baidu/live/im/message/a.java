package com.baidu.live.im.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.core.util.TbEnum;
/* loaded from: classes11.dex */
public class a extends HttpMessage {
    private String appId;
    private com.baidu.live.im.data.d barrageCardInfo;
    private String barrageId;
    private int barrageType;
    private int bqN;
    private boolean bqO;
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
        this.bqO = false;
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

    public short NK() {
        return this.msgType;
    }

    public void setLiveId(String str) {
        this.liveId = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public String NL() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public long NM() {
        return this.price;
    }

    public void aV(long j) {
        this.price = j;
    }

    public int NA() {
        return this.barrageType;
    }

    public void fc(int i) {
        this.barrageType = i;
    }

    public String NB() {
        return this.barrageId;
    }

    public void hT(String str) {
        this.barrageId = str;
    }

    public com.baidu.live.im.data.d NC() {
        return this.barrageCardInfo;
    }

    public void a(com.baidu.live.im.data.d dVar) {
        this.barrageCardInfo = dVar;
    }

    public String[] ND() {
        return this.imEffect;
    }

    public void l(String[] strArr) {
        this.imEffect = strArr;
    }

    public void cm(boolean z) {
        this.bqO = z;
    }

    public boolean NN() {
        return this.bqO;
    }

    public void cn(boolean z) {
        this.isOut = z;
    }

    public boolean NO() {
        return this.isOut;
    }

    public void co(boolean z) {
        this.isQuickBarrage = z;
    }

    public boolean NP() {
        return this.isQuickBarrage;
    }

    public void setText(String str) {
        this.text = str;
    }

    public String getText() {
        return this.text;
    }

    public void fd(int i) {
        this.bqN = i;
    }

    public boolean NQ() {
        return this.bqN == 1;
    }

    public String getCustomRoomId() {
        return this.customRoomId;
    }

    public void setCustomRoomId(String str) {
        this.customRoomId = str;
    }
}
