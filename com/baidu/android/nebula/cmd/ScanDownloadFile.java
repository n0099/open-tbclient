package com.baidu.android.nebula.cmd;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.moplus.util.NoProGuard;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.cyberplayer.sdk.internal.HttpUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ScanDownloadFile implements NoProGuard, e {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long access$914(ScanDownloadFile scanDownloadFile, long j) {
        long j2 = scanDownloadFile.mTotalRetryTime + j;
        scanDownloadFile.mTotalRetryTime = j2;
        return j2;
    }

    @Override // com.baidu.android.nebula.cmd.e
    public void execute(com.baidu.android.nebula.b.a aVar, com.baidu.android.nebula.b.b bVar) {
        String str;
        Map a2 = aVar.a();
        if (a2 == null || a2.size() < 1 || (str = (String) a2.get("callback")) == null) {
            return;
        }
        this.mIntentStr = (String) a2.get("intent");
        this.mFileLength = (String) a2.get("apkfilelength");
        this.mFileName = (String) a2.get("apkfilename");
        this.mFilePackageName = (String) a2.get("apkpackagename");
        if (!TextUtils.isEmpty((CharSequence) a2.get("apkexpiredtime"))) {
            this.mExpiredTime = Long.parseLong((String) a2.get("apkexpiredtime"));
        }
        if (!TextUtils.isEmpty((CharSequence) a2.get("scanedexpiredtime"))) {
            this.mTotalExpiredTime = Long.parseLong((String) a2.get("scanedexpiredtime"));
        }
        if (!TextUtils.isEmpty((CharSequence) a2.get("scanedonetime"))) {
            this.mScanedOneTime = Long.parseLong((String) a2.get("scanedonetime"));
        }
        if (TextUtils.isEmpty(this.mIntentStr) || TextUtils.isEmpty(this.mFileLength) || TextUtils.isEmpty(this.mFileName) || TextUtils.isEmpty(this.mFilePackageName)) {
            return;
        }
        try {
            this.mIntentStr = URLDecoder.decode(this.mIntentStr, BdUtil.UTF8);
            this.mFileName = URLDecoder.decode(this.mFileName, BdUtil.UTF8);
        } catch (UnsupportedEncodingException e) {
        }
        this.mContext = com.baidu.android.nebula.c.c.a().c();
        if (this.mContext != null) {
            if (!com.baidu.android.nebula.c.a.a(this.mContext).a(aVar.a(HttpUtils.HEADER_NAME_REFERER))) {
                this.mErrcode = 4;
            }
            if (this.mErrcode != 4) {
                new f(this).a();
                this.mErrcode = 0;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error", this.mErrcode);
            } catch (JSONException e2) {
            }
            bVar.a("text/javascript");
            bVar.a().put("Cache-Control", "no-cache");
            bVar.b(str + " && " + str + "(" + jSONObject.toString() + ");");
            bVar.a(200);
        }
    }
}
