package com.baidu.live.im.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.core.util.TbEnum;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private String appId;
    private com.baidu.live.im.data.b barrageCardInfo;
    private String barrageId;
    private int barrageType;
    private int bkt;
    private boolean bku;
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
        this.bku = false;
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

    public short Mc() {
        return this.msgType;
    }

    public void setLiveId(String str) {
        this.liveId = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public String Md() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public long Me() {
        return this.price;
    }

    public void am(long j) {
        this.price = j;
    }

    public int LS() {
        return this.barrageType;
    }

    public void eL(int i) {
        this.barrageType = i;
    }

    public String LT() {
        return this.barrageId;
    }

    public void hE(String str) {
        this.barrageId = str;
    }

    public com.baidu.live.im.data.b LU() {
        return this.barrageCardInfo;
    }

    public void a(com.baidu.live.im.data.b bVar) {
        this.barrageCardInfo = bVar;
    }

    public String[] LV() {
        return this.imEffect;
    }

    public void l(String[] strArr) {
        this.imEffect = strArr;
    }

    public void bZ(boolean z) {
        this.bku = z;
    }

    public boolean Mf() {
        return this.bku;
    }

    public void eM(int i) {
        this.bkt = i;
    }

    public boolean Mg() {
        return this.bkt == 1;
    }

    public String getCustomRoomId() {
        return this.customRoomId;
    }

    public void setCustomRoomId(String str) {
        this.customRoomId = str;
    }
}
