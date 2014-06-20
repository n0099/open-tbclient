package com.baidu.android.nebula.cmd;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.moplus.util.NoProGuard;
import com.baidu.tbadk.TbConfig;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ScanDownloadFile implements NoProGuard, d {
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
    private long mScanedOneTime = TbConfig.NOTIFY_SOUND_INTERVAL;
    private long mTotalRetryTime = 0;
    private BroadcastReceiver mInstallReceiver = new b(this);

    public ScanDownloadFile() {
        a.a();
        a.a(TAG);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long access$1114(ScanDownloadFile scanDownloadFile, long j) {
        long j2 = scanDownloadFile.mTotalRetryTime + j;
        scanDownloadFile.mTotalRetryTime = j2;
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseReceiver() {
        try {
            this.mIntentStr = "";
            this.mFileLength = "";
            this.mFileName = "";
            this.mFilePackageName = "";
            this.mContext.unregisterReceiver(this.mInstallReceiver);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override // com.baidu.android.nebula.cmd.d
    public com.baidu.android.nebula.b.c execute(com.baidu.android.nebula.b.k kVar, Map map, Map map2, Map map3) {
        a.a(System.currentTimeMillis());
        if (map2 == null || map2.size() < 1) {
            a.a(-1);
            return null;
        }
        String str = (String) map2.get("callback");
        a.d((String) map2.get("mcmdf"));
        if (str == null) {
            a.a(-1);
            return null;
        }
        this.mIntentStr = (String) map2.get("intent");
        this.mFileLength = (String) map2.get("apkfilelength");
        this.mFileName = (String) map2.get("apkfilename");
        this.mFilePackageName = (String) map2.get("apkpackagename");
        if (!TextUtils.isEmpty((CharSequence) map2.get("apkexpiredtime"))) {
            this.mExpiredTime = Long.parseLong((String) map2.get("apkexpiredtime"));
        }
        if (!TextUtils.isEmpty((CharSequence) map2.get("scanedexpiredtime"))) {
            this.mTotalExpiredTime = Long.parseLong((String) map2.get("scanedexpiredtime"));
        }
        if (!TextUtils.isEmpty((CharSequence) map2.get("scanedonetime"))) {
            this.mScanedOneTime = Long.parseLong((String) map2.get("scanedonetime"));
        }
        if (TextUtils.isEmpty(this.mIntentStr) || TextUtils.isEmpty(this.mFileLength) || TextUtils.isEmpty(this.mFileName) || TextUtils.isEmpty(this.mFilePackageName)) {
            a.a(-1);
            return null;
        }
        this.mContext = com.baidu.android.nebula.d.b.a().c();
        if (this.mContext == null) {
            a.a(-1);
            return null;
        }
        a.b(this.mContext.getPackageName());
        a.c(this.mFilePackageName);
        if (!com.baidu.android.nebula.d.a.a(this.mContext).a((String) map.get("referer"))) {
            this.mErrcode = 4;
        }
        if (this.mErrcode != 4) {
            new j(this).a();
            this.mErrcode = 0;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error", this.mErrcode);
        } catch (JSONException e) {
        }
        com.baidu.android.nebula.b.c cVar = new com.baidu.android.nebula.b.c(str + " && " + str + "(" + jSONObject.toString() + ");");
        a.a(this.mErrcode);
        return cVar;
    }

    @Override // com.baidu.android.nebula.cmd.d
    public void writeToStatic() {
        k.a().a(this.mContext, a.toString());
    }
}
