package com.baidu.live.im.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.core.util.TbEnum;
/* loaded from: classes7.dex */
public class a extends HttpMessage {
    private String appId;
    private com.baidu.live.im.data.b barrageCardInfo;
    private String barrageId;
    private int barrageType;
    private boolean bcy;
    private String content;
    private int groupId;
    private String[] imEffect;
    private String liveId;
    private short msgType;
    private String otherParams;
    private long price;
    private String roomId;

    public a(String str, short s, int i, String str2) {
        super(1021013);
        this.bcy = false;
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

    public short JX() {
        return this.msgType;
    }

    public void gb(String str) {
        this.liveId = str;
    }

    public void gS(String str) {
        this.roomId = str;
    }

    public String JY() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public long JZ() {
        return this.price;
    }

    public void al(long j) {
        this.price = j;
    }

    public int JO() {
        return this.barrageType;
    }

    public void ew(int i) {
        this.barrageType = i;
    }

    public String JP() {
        return this.barrageId;
    }

    public void gR(String str) {
        this.barrageId = str;
    }

    public com.baidu.live.im.data.b JQ() {
        return this.barrageCardInfo;
    }

    public void a(com.baidu.live.im.data.b bVar) {
        this.barrageCardInfo = bVar;
    }

    public String[] JR() {
        return this.imEffect;
    }

    public void k(String[] strArr) {
        this.imEffect = strArr;
    }

    public void bS(boolean z) {
        this.bcy = z;
    }

    public boolean Ka() {
        return this.bcy;
    }
}
