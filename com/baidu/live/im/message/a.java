package com.baidu.live.im.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.core.util.TbEnum;
/* loaded from: classes2.dex */
public class a extends HttpMessage {
    private String appId;
    private com.baidu.live.im.data.b barrageCardInfo;
    private String barrageId;
    private int barrageType;
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

    public short vy() {
        return this.msgType;
    }

    public void dD(String str) {
        this.liveId = str;
    }

    public void dE(String str) {
        this.roomId = str;
    }

    public String vz() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public long vA() {
        return this.price;
    }

    public void C(long j) {
        this.price = j;
    }

    public int vu() {
        return this.barrageType;
    }

    public void bK(int i) {
        this.barrageType = i;
    }

    public String vv() {
        return this.barrageId;
    }

    public void dC(String str) {
        this.barrageId = str;
    }

    public com.baidu.live.im.data.b vw() {
        return this.barrageCardInfo;
    }

    public void a(com.baidu.live.im.data.b bVar) {
        this.barrageCardInfo = bVar;
    }

    public String[] vx() {
        return this.imEffect;
    }

    public void k(String[] strArr) {
        this.imEffect = strArr;
    }
}
