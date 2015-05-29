package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.b.n;
import com.baidu.adp.lib.stats.q;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    protected String mFilePrefixString;
    private String wZ;
    protected String xa;
    protected n xc;
    private StringBuffer mMemCache = new StringBuffer();
    private int mMemCacheCount = 0;
    private long mLastLogTime = 0;
    protected long mLastUploadTime = 0;
    private long mCurrentFileSize = 0;
    protected int mMaxMemCount = 50;
    protected final String mFileSuffixString = ".log";
    protected boolean mUseSdCard = true;
    protected boolean mMustSuccess = false;
    private boolean isUploading = false;
    private ArrayList<String> xb = new ArrayList<>();

    public a(n nVar) {
        this.xc = nVar;
    }

    public synchronized void add(q qVar) {
        if (qVar != null) {
            try {
                this.mMemCache.append(qVar.toString());
                this.mMemCache.append("\r\n");
                this.mMemCacheCount++;
            } catch (Exception e) {
                BdLog.e(e);
            } catch (OutOfMemoryError e2) {
            }
        }
        if (this.xc != null) {
            this.xc.h(this);
        }
        this.mLastLogTime = System.currentTimeMillis();
    }

    public int ib() {
        return this.mMemCacheCount;
    }

    public long getmLastUploadTime() {
        return this.mLastUploadTime;
    }

    public void setmLastUploadTime(long j) {
        this.mLastUploadTime = j;
    }

    public long ic() {
        return this.mLastLogTime;
    }

    public String id() {
        if (TextUtils.isEmpty(this.xa)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(this.mFilePrefixString);
            sb.append(com.baidu.adp.lib.h.a.iB().iD());
            sb.append("Writing");
            sb.append(".log");
            this.xa = sb.toString();
        }
        return this.xa;
    }

    public String getUploadingLogFile() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.mFilePrefixString);
        sb.append(System.currentTimeMillis());
        sb.append(com.baidu.adp.lib.h.a.iB().iD());
        sb.append("Uploading");
        sb.append(".log");
        return sb.toString();
    }

    public long ie() {
        return this.mCurrentFileSize;
    }

    public void l(long j) {
        this.mCurrentFileSize = j;
    }

    public void clearMemData() {
        this.mMemCache = new StringBuffer();
        this.mMemCacheCount = 0;
        this.mCurrentFileSize = 0L;
    }

    public void aB(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.wZ = str;
        }
    }

    public String ig() {
        return this.wZ;
    }

    public boolean ih() {
        return this.isUploading;
    }

    public void D(boolean z) {
        this.isUploading = z;
    }

    public String getPostFileName() {
        return "omp";
    }

    public StringBuffer ii() {
        return this.mMemCache;
    }

    public boolean ij() {
        return this.mUseSdCard;
    }

    public boolean ik() {
        return this.mMustSuccess;
    }

    public String il() {
        return this.mFilePrefixString;
    }

    public void aC(String str) {
        if (!TextUtils.isEmpty(str) && !this.xb.contains(str)) {
            this.xb.add(str);
        }
    }

    public ArrayList<String> im() {
        return this.xb;
    }

    public static String aD(String str) {
        if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || AddFriendActivityConfig.MSG.equals(str)) {
            return "error";
        }
        return str;
    }
}
