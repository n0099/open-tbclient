package com.baidu.live.im.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.core.util.TbEnum;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private boolean aNv;
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
        this.aNv = false;
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

    public short Cq() {
        return this.msgType;
    }

    public void eG(String str) {
        this.liveId = str;
    }

    public void eH(String str) {
        this.roomId = str;
    }

    public String Cr() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public long Cs() {
        return this.price;
    }

    public void ag(long j) {
        this.price = j;
    }

    public int Cj() {
        return this.barrageType;
    }

    public void cm(int i) {
        this.barrageType = i;
    }

    public String Ck() {
        return this.barrageId;
    }

    public void eF(String str) {
        this.barrageId = str;
    }

    public com.baidu.live.im.data.b Cl() {
        return this.barrageCardInfo;
    }

    public void a(com.baidu.live.im.data.b bVar) {
        this.barrageCardInfo = bVar;
    }

    public String[] Cm() {
        return this.imEffect;
    }

    public void l(String[] strArr) {
        this.imEffect = strArr;
    }

    public void bA(boolean z) {
        this.aNv = z;
    }

    public boolean Ct() {
        return this.aNv;
    }
}
