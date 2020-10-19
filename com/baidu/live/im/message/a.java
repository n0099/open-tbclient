package com.baidu.live.im.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.core.util.TbEnum;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private String appId;
    private com.baidu.live.im.data.b barrageCardInfo;
    private String barrageId;
    private int barrageType;
    private int biY;
    private boolean biZ;
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
        this.biZ = false;
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

    public short LH() {
        return this.msgType;
    }

    public void gx(String str) {
        this.liveId = str;
    }

    public void hx(String str) {
        this.roomId = str;
    }

    public String LI() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public long LJ() {
        return this.price;
    }

    public void al(long j) {
        this.price = j;
    }

    public int Lx() {
        return this.barrageType;
    }

    public void eJ(int i) {
        this.barrageType = i;
    }

    public String Ly() {
        return this.barrageId;
    }

    public void hw(String str) {
        this.barrageId = str;
    }

    public com.baidu.live.im.data.b Lz() {
        return this.barrageCardInfo;
    }

    public void a(com.baidu.live.im.data.b bVar) {
        this.barrageCardInfo = bVar;
    }

    public String[] LA() {
        return this.imEffect;
    }

    public void k(String[] strArr) {
        this.imEffect = strArr;
    }

    public void bX(boolean z) {
        this.biZ = z;
    }

    public boolean LK() {
        return this.biZ;
    }

    public boolean LL() {
        return this.biY == 1;
    }

    public String LM() {
        return this.customRoomId;
    }
}
