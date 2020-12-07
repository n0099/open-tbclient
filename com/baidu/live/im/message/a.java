package com.baidu.live.im.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.core.util.TbEnum;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private String appId;
    private com.baidu.live.im.data.d barrageCardInfo;
    private String barrageId;
    private int barrageType;
    private int bpg;
    private boolean bph;
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
        this.bph = false;
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

    public short Oi() {
        return this.msgType;
    }

    public void setLiveId(String str) {
        this.liveId = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public String Oj() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public long Ok() {
        return this.price;
    }

    public void aW(long j) {
        this.price = j;
    }

    public int NY() {
        return this.barrageType;
    }

    public void fe(int i) {
        this.barrageType = i;
    }

    public String NZ() {
        return this.barrageId;
    }

    public void ii(String str) {
        this.barrageId = str;
    }

    public com.baidu.live.im.data.d Oa() {
        return this.barrageCardInfo;
    }

    public void a(com.baidu.live.im.data.d dVar) {
        this.barrageCardInfo = dVar;
    }

    public String[] Ob() {
        return this.imEffect;
    }

    public void l(String[] strArr) {
        this.imEffect = strArr;
    }

    public void cm(boolean z) {
        this.bph = z;
    }

    public boolean Ol() {
        return this.bph;
    }

    public void ff(int i) {
        this.bpg = i;
    }

    public boolean Om() {
        return this.bpg == 1;
    }

    public String getCustomRoomId() {
        return this.customRoomId;
    }

    public void setCustomRoomId(String str) {
        this.customRoomId = str;
    }
}
