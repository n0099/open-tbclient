package com.baidu.live.im.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.core.util.TbEnum;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private String appId;
    private com.baidu.live.im.data.b barrageCardInfo;
    private String barrageId;
    private int barrageType;
    private int bkc;
    private boolean bkd;
    private String content;
    private String customRoomId;
    private int groupId;
    private String[] imEffect;
    private String liveId;
    private short msgType;
    private String otherParams;
    private long price;
    private String roomId;

    public a(String str, short s, int i, String str2) {
        super(1021013);
        this.bkd = false;
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

    public short LT() {
        return this.msgType;
    }

    public void setLiveId(String str) {
        this.liveId = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public String LU() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public long LV() {
        return this.price;
    }

    public void ay(long j) {
        this.price = j;
    }

    public int LJ() {
        return this.barrageType;
    }

    public void eH(int i) {
        this.barrageType = i;
    }

    public String LK() {
        return this.barrageId;
    }

    public void hF(String str) {
        this.barrageId = str;
    }

    public com.baidu.live.im.data.b LL() {
        return this.barrageCardInfo;
    }

    public void a(com.baidu.live.im.data.b bVar) {
        this.barrageCardInfo = bVar;
    }

    public String[] LM() {
        return this.imEffect;
    }

    public void l(String[] strArr) {
        this.imEffect = strArr;
    }

    public void cc(boolean z) {
        this.bkd = z;
    }

    public boolean LW() {
        return this.bkd;
    }

    public void eI(int i) {
        this.bkc = i;
    }

    public boolean LX() {
        return this.bkc == 1;
    }

    public String getCustomRoomId() {
        return this.customRoomId;
    }

    public void setCustomRoomId(String str) {
        this.customRoomId = str;
    }
}
