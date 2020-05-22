package com.baidu.live.im.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.core.util.TbEnum;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private boolean aTH;
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
        this.aTH = false;
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

    public short DM() {
        return this.msgType;
    }

    public void fs(String str) {
        this.liveId = str;
    }

    public void ft(String str) {
        this.roomId = str;
    }

    public String DN() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public long DO() {
        return this.price;
    }

    public void ak(long j) {
        this.price = j;
    }

    public int DF() {
        return this.barrageType;
    }

    public void ct(int i) {
        this.barrageType = i;
    }

    public String DG() {
        return this.barrageId;
    }

    public void fr(String str) {
        this.barrageId = str;
    }

    public com.baidu.live.im.data.b DH() {
        return this.barrageCardInfo;
    }

    public void a(com.baidu.live.im.data.b bVar) {
        this.barrageCardInfo = bVar;
    }

    public String[] DI() {
        return this.imEffect;
    }

    public void k(String[] strArr) {
        this.imEffect = strArr;
    }

    public void bJ(boolean z) {
        this.aTH = z;
    }

    public boolean DP() {
        return this.aTH;
    }
}
