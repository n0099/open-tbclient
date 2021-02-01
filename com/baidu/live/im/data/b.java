package com.baidu.live.im.data;

import com.baidu.live.adp.widget.listview.IAdapterData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public abstract class b implements IAdapterData, Cloneable {
    private d barrageCardInfo;
    private String barrageId;
    private int barrageType;
    private com.baidu.live.data.a bnO;
    public String bno;
    private long bornTime;
    private com.baidu.live.data.a bpe;
    private List<Long> bpf;
    private long bph;
    private double bpi;
    private long bpj;
    public String bpk;
    private boolean bpl;
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
    private boolean bpg = false;
    private boolean isGifLoadSuccess = true;
    private boolean isUploading = false;
    public boolean aJp = false;

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

    public com.baidu.live.data.a KZ() {
        return this.bnO;
    }

    public void e(com.baidu.live.data.a aVar) {
        this.bnO = aVar;
    }

    public com.baidu.live.data.a La() {
        return this.bpe;
    }

    public void f(com.baidu.live.data.a aVar) {
        this.bpe = aVar;
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

    public void m(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            if (this.bpf == null) {
                this.bpf = new ArrayList();
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                long optLong = jSONArray.optLong(i);
                if (optLong > 0) {
                    this.bpf.add(Long.valueOf(optLong));
                }
            }
        }
    }

    public List<Long> Lb() {
        return this.bpf;
    }

    public boolean Lc() {
        return this.bpg;
    }

    public void cp(boolean z) {
        this.bpg = z;
    }

    public int Ld() {
        return this.barrageType;
    }

    public void dC(int i) {
        this.barrageType = i;
    }

    public String Le() {
        return this.barrageId;
    }

    public void hh(String str) {
        this.barrageId = str;
    }

    public d Lf() {
        return this.barrageCardInfo;
    }

    public void a(d dVar) {
        this.barrageCardInfo = dVar;
    }

    public String[] Lg() {
        return this.imEffect;
    }

    public void l(String[] strArr) {
        this.imEffect = strArr;
    }

    public long Lh() {
        return this.bph;
    }

    public void aX(long j) {
        this.bph = j;
    }

    public double Li() {
        return this.bpi;
    }

    public void h(double d) {
        this.bpi = d;
    }

    public long Lj() {
        return this.bpj;
    }

    public void aY(long j) {
        this.bpj = j;
    }

    public boolean Lk() {
        return this.bpl;
    }

    public void Ll() {
        this.bpl = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Lm */
    public b clone() {
        try {
            return (b) super.clone();
        } catch (Exception e) {
            return null;
        }
    }
}
