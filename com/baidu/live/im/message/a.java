package com.baidu.live.im.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.core.util.TbEnum;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private boolean aWo;
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
        this.aWo = false;
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

    public short Eo() {
        return this.msgType;
    }

    public void eI(String str) {
        this.liveId = str;
    }

    public void fy(String str) {
        this.roomId = str;
    }

    public String Ep() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public long Eq() {
        return this.price;
    }

    public void ak(long j) {
        this.price = j;
    }

    public int Eh() {
        return this.barrageType;
    }

    public void cB(int i) {
        this.barrageType = i;
    }

    public String Ei() {
        return this.barrageId;
    }

    public void fx(String str) {
        this.barrageId = str;
    }

    public com.baidu.live.im.data.b Ej() {
        return this.barrageCardInfo;
    }

    public void a(com.baidu.live.im.data.b bVar) {
        this.barrageCardInfo = bVar;
    }

    public String[] Ek() {
        return this.imEffect;
    }

    public void k(String[] strArr) {
        this.imEffect = strArr;
    }

    public void bJ(boolean z) {
        this.aWo = z;
    }

    public boolean Er() {
        return this.aWo;
    }
}
