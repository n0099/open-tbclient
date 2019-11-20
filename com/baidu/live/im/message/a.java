package com.baidu.live.im.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.core.util.TbEnum;
/* loaded from: classes6.dex */
public class a extends HttpMessage {
    private String appId;
    private com.baidu.live.im.data.b barrageCardInfo;
    private String barrageId;
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

    public short tm() {
        return this.msgType;
    }

    public void cK(String str) {
        this.liveId = str;
    }

    public void cL(String str) {
        this.roomId = str;
    }

    public String tn() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public long tp() {
        return this.price;
    }

    public void A(long j) {
        this.price = j;
    }

    public String tj() {
        return this.barrageId;
    }

    public void cJ(String str) {
        this.barrageId = str;
    }

    public com.baidu.live.im.data.b tk() {
        return this.barrageCardInfo;
    }

    public void a(com.baidu.live.im.data.b bVar) {
        this.barrageCardInfo = bVar;
    }

    public String[] tl() {
        return this.imEffect;
    }

    public void k(String[] strArr) {
        this.imEffect = strArr;
    }
}
