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
    public String bja;
    private com.baidu.live.data.a bjz;
    private com.baidu.live.data.a bkh;
    private List<Long> bki;
    private long bkk;
    private double bkl;
    private long bkm;
    public String bkn;
    private boolean bko;
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
    private boolean bkj = false;
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

    public com.baidu.live.data.a LO() {
        return this.bjz;
    }

    public void e(com.baidu.live.data.a aVar) {
        this.bjz = aVar;
    }

    public com.baidu.live.data.a LP() {
        return this.bkh;
    }

    public void f(com.baidu.live.data.a aVar) {
        this.bkh = aVar;
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
            if (this.bki == null) {
                this.bki = new ArrayList();
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                long optLong = jSONArray.optLong(i);
                if (optLong > 0) {
                    this.bki.add(Long.valueOf(optLong));
                }
            }
        }
    }

    public List<Long> LQ() {
        return this.bki;
    }

    public boolean LR() {
        return this.bkj;
    }

    public void bY(boolean z) {
        this.bkj = z;
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

    public b LU() {
        return this.barrageCardInfo;
    }

    public void a(b bVar) {
        this.barrageCardInfo = bVar;
    }

    public String[] LV() {
        return this.imEffect;
    }

    public void l(String[] strArr) {
        this.imEffect = strArr;
    }

    public long LW() {
        return this.bkk;
    }

    public void ak(long j) {
        this.bkk = j;
    }

    public double LX() {
        return this.bkl;
    }

    public void o(double d) {
        this.bkl = d;
    }

    public long LY() {
        return this.bkm;
    }

    public void al(long j) {
        this.bkm = j;
    }

    public boolean LZ() {
        return this.bko;
    }

    public void Ma() {
        this.bko = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Mb */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (Exception e) {
            return null;
        }
    }
}
