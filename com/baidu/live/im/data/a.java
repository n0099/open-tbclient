package com.baidu.live.im.data;

import com.baidu.live.adp.widget.listview.IAdapterData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public abstract class a implements IAdapterData, Cloneable {
    private b barrageCardInfo;
    private String barrageId;
    private int barrageType;
    private com.baidu.live.data.a biM;
    private List<Long> biN;
    private long biP;
    private double biQ;
    private long biR;
    public String biS;
    private boolean biT;
    private com.baidu.live.data.a bic;
    private long bornTime;
    private String content;
    private boolean hasRead;
    private String[] imEffect;
    private boolean isHost;
    private String link;
    private long logTime;
    private long mToUserId;
    private long msgId;
    private int msgType;
    private Object objContent;
    private long recordId;
    private String st_type;
    private String stat;
    private long taskId;
    private long time;
    private long userId;
    private int progressValue = 0;
    private long statisticsTaskId = -1;
    private boolean mIsPushForOperateAccount = false;
    private boolean biO = false;
    private boolean isGifLoadSuccess = true;
    private boolean isUploading = false;

    public boolean isHost() {
        return this.isHost;
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public boolean isPushForOperateAccount() {
        return this.mIsPushForOperateAccount;
    }

    public void setIsPushForOperateAccount(boolean z) {
        this.mIsPushForOperateAccount = z;
    }

    public long getBornTime() {
        return this.bornTime;
    }

    public void setBornTime(long j) {
        this.bornTime = j;
    }

    public long getToUserId() {
        return this.mToUserId;
    }

    public void setToUserId(long j) {
        this.mToUserId = j;
    }

    public String getSt_type() {
        return this.st_type;
    }

    public void setSt_type(String str) {
        this.st_type = str;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public String getStat() {
        return this.stat;
    }

    public void setStat(String str) {
        this.stat = str;
    }

    public long getTaskId() {
        return this.taskId;
    }

    public void setTaskId(long j) {
        this.taskId = j;
    }

    public boolean getIsUploading() {
        return this.isUploading;
    }

    public void setIsUploading(boolean z) {
        this.isUploading = z;
    }

    public int getProgressValue() {
        return this.progressValue;
    }

    public void setProgressValue(int i) {
        this.progressValue = i;
    }

    public Object getObjContent() {
        return this.objContent;
    }

    public void setObjContent(Object obj) {
        this.objContent = obj;
    }

    public com.baidu.live.data.a Lt() {
        return this.bic;
    }

    public void e(com.baidu.live.data.a aVar) {
        this.bic = aVar;
    }

    public com.baidu.live.data.a Lu() {
        return this.biM;
    }

    public void f(com.baidu.live.data.a aVar) {
        this.biM = aVar;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public void setMsgType(int i) {
        this.msgType = i;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public long getMsgId() {
        return this.msgId;
    }

    public void setMsgId(long j) {
        this.msgId = j;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public boolean isGifLoadSuccess() {
        return this.isGifLoadSuccess;
    }

    public void setGifLoadSuccess(boolean z) {
        this.isGifLoadSuccess = z;
    }

    public long getLogTime() {
        return this.logTime;
    }

    public void setLogTime(long j) {
        this.logTime = j;
    }

    public boolean isHasRead() {
        return this.hasRead;
    }

    public void setHasRead(boolean z) {
        this.hasRead = z;
    }

    public long getRecordId() {
        return this.recordId;
    }

    public void setRecordId(long j) {
        this.recordId = j;
    }

    public void l(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            if (this.biN == null) {
                this.biN = new ArrayList();
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                long optLong = jSONArray.optLong(i);
                if (optLong > 0) {
                    this.biN.add(Long.valueOf(optLong));
                }
            }
        }
    }

    public List<Long> Lv() {
        return this.biN;
    }

    public boolean Lw() {
        return this.biO;
    }

    public void bW(boolean z) {
        this.biO = z;
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

    public b Lz() {
        return this.barrageCardInfo;
    }

    public void a(b bVar) {
        this.barrageCardInfo = bVar;
    }

    public String[] LA() {
        return this.imEffect;
    }

    public void k(String[] strArr) {
        this.imEffect = strArr;
    }

    public long LB() {
        return this.biP;
    }

    public void aj(long j) {
        this.biP = j;
    }

    public double LC() {
        return this.biQ;
    }

    public void o(double d) {
        this.biQ = d;
    }

    public long LD() {
        return this.biR;
    }

    public void ak(long j) {
        this.biR = j;
    }

    public boolean LE() {
        return this.biT;
    }

    public void LF() {
        this.biT = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: LG */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (Exception e) {
            return null;
        }
    }
}
