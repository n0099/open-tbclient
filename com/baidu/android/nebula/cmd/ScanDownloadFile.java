package com.baidu.android.nebula.cmd;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.moplus.util.NoProGuard;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ScanDownloadFile implements NoProGuard, n {
    private static final String BROWSER_DOWNLOAD_INFO = "http://wap.baidu.com/static/freeapp/broswer_down_path.cfg?v=1";
    private static final boolean DEBUG = false;
    public static final int ERROR_NOT_EXIST = 2;
    public static final int ERROR_PARSE_ERROR = 1;
    private static final String TAG = "ScanDownloadFile";
    private int mErrcode = 0;
    private Context mContext = null;
    private String mIntentStr = "";
    private String mFileLength = "";
    private String mFileName = "";
    private String mFilePackageName = "";
    private long mExpiredTime = 1800000;
    private long mTotalExpiredTime = 1800000;
    private long mScanedOneTime = 5000;
    private long mTotalRetryTime = 0;

    public ScanDownloadFile() {
        a.a();
        a.a(TAG);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long access$914(ScanDownloadFile scanDownloadFile, long j) {
        long j2 = scanDownloadFile.mTotalRetryTime + j;
        scanDownloadFile.mTotalRetryTime = j2;
        return j2;
    }

    @Override // com.baidu.android.nebula.cmd.n
    public void execute(com.baidu.android.nebula.a.d dVar, com.baidu.android.nebula.a.a aVar) {
        a.a(System.currentTimeMillis());
        Map a = dVar.a();
        if (a == null || a.size() <= 0) {
            a.a(-1);
            return;
        }
        String str = (String) a.get("callback");
        a.d((String) a.get("mcmdf"));
        if (str == null) {
            a.a(-1);
            return;
        }
        this.mIntentStr = (String) a.get("intent");
        this.mFileLength = (String) a.get("apkfilelength");
        this.mFileName = (String) a.get("apkfilename");
        this.mFilePackageName = (String) a.get("apkpackagename");
        if (!TextUtils.isEmpty((CharSequence) a.get("apkexpiredtime"))) {
            this.mExpiredTime = Long.parseLong((String) a.get("apkexpiredtime"));
        }
        if (!TextUtils.isEmpty((CharSequence) a.get("scanedexpiredtime"))) {
            this.mTotalExpiredTime = Long.parseLong((String) a.get("scanedexpiredtime"));
        }
        if (!TextUtils.isEmpty((CharSequence) a.get("scanedonetime"))) {
            this.mScanedOneTime = Long.parseLong((String) a.get("scanedonetime"));
        }
        if (TextUtils.isEmpty(this.mIntentStr) || TextUtils.isEmpty(this.mFileLength) || TextUtils.isEmpty(this.mFileName) || TextUtils.isEmpty(this.mFilePackageName)) {
            a.a(-1);
            return;
        }
        this.mContext = com.baidu.android.nebula.d.c.a().c();
        if (this.mContext == null) {
            a.a(-1);
            return;
        }
        a.b(this.mContext.getPackageName());
        a.c(this.mFilePackageName);
        if (!com.baidu.android.nebula.d.a.a(this.mContext).a(dVar.a("Referer"))) {
            this.mErrcode = 4;
        }
        if (this.mErrcode != 4) {
            new i(this).a();
            this.mErrcode = 0;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error", this.mErrcode);
        } catch (JSONException e) {
        }
        aVar.a("text/javascript");
        aVar.a().put("Cache-Control", "no-cache");
        aVar.b(str + " && " + str + "(" + jSONObject.toString() + ");");
        aVar.a(200);
        a.a(this.mErrcode);
    }

    @Override // com.baidu.android.nebula.cmd.n
    public void writeToStatic() {
        m.a().a(this.mContext, a.toString());
    }
}
