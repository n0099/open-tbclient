package com.baidu.live.im.data;

import com.baidu.live.adp.widget.listview.IAdapterData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public abstract class a implements IAdapterData {
    private com.baidu.live.data.a aMF;
    private com.baidu.live.data.a aNr;
    private List<Long> aNs;
    private long aNu;
    private double aNv;
    private long aNw;
    private b barrageCardInfo;
    private String barrageId;
    private int barrageType;
    private long bornTime;
    private String content;
    private boolean hasRead;
    private String[] imEffect;
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
    private boolean aNt = false;
    private boolean isGifLoadSuccess = true;
    private boolean isUploading = false;

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

    public com.baidu.live.data.a Ce() {
        return this.aMF;
    }

    public void d(com.baidu.live.data.a aVar) {
        this.aMF = aVar;
    }

    public com.baidu.live.data.a Cf() {
        return this.aNr;
    }

    public void e(com.baidu.live.data.a aVar) {
        this.aNr = aVar;
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
            if (this.aNs == null) {
                this.aNs = new ArrayList();
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                long optLong = jSONArray.optLong(i);
                if (optLong > 0) {
                    this.aNs.add(Long.valueOf(optLong));
                }
            }
        }
    }

    public List<Long> Cg() {
        return this.aNs;
    }

    public boolean Ch() {
        return this.aNt;
    }

    public void bz(boolean z) {
        this.aNt = z;
    }

    public int Ci() {
        return this.barrageType;
    }

    public void cm(int i) {
        this.barrageType = i;
    }

    public String Cj() {
        return this.barrageId;
    }

    public void eF(String str) {
        this.barrageId = str;
    }

    public b Ck() {
        return this.barrageCardInfo;
    }

    public void a(b bVar) {
        this.barrageCardInfo = bVar;
    }

    public String[] Cl() {
        return this.imEffect;
    }

    public void l(String[] strArr) {
        this.imEffect = strArr;
    }

    public long Cm() {
        return this.aNu;
    }

    public void ae(long j) {
        this.aNu = j;
    }

    public double Cn() {
        return this.aNv;
    }

    public void i(double d) {
        this.aNv = d;
    }

    public long Co() {
        return this.aNw;
    }

    public void af(long j) {
        this.aNw = j;
    }
}
