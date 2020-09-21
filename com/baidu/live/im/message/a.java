package com.baidu.live.im.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.core.util.TbEnum;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private String appId;
    private com.baidu.live.im.data.b barrageCardInfo;
    private String barrageId;
    private int barrageType;
    private int bfm;
    private boolean bfn;
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
        this.bfn = false;
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

    public short KC() {
        return this.msgType;
    }

    public void gi(String str) {
        this.liveId = str;
    }

    public void hg(String str) {
        this.roomId = str;
    }

    public String KD() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public long KE() {
        return this.price;
    }

    public void ak(long j) {
        this.price = j;
    }

    public int Ks() {
        return this.barrageType;
    }

    public void eA(int i) {
        this.barrageType = i;
    }

    public String Kt() {
        return this.barrageId;
    }

    public void hf(String str) {
        this.barrageId = str;
    }

    public com.baidu.live.im.data.b Ku() {
        return this.barrageCardInfo;
    }

    public void a(com.baidu.live.im.data.b bVar) {
        this.barrageCardInfo = bVar;
    }

    public String[] Kv() {
        return this.imEffect;
    }

    public void k(String[] strArr) {
        this.imEffect = strArr;
    }

    public void bU(boolean z) {
        this.bfn = z;
    }

    public boolean KF() {
        return this.bfn;
    }

    public boolean KG() {
        return this.bfm == 1;
    }

    public String KH() {
        return this.customRoomId;
    }
}
