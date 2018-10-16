package com.baidu.browser.sailor.webkit.update;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.baidu.browser.sailor.BdSailorClient;
import com.baidu.browser.sailor.util.c;
import com.baidu.webkit.internal.blink.EngineManager;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.File;
/* loaded from: classes2.dex */
public final class BdZeusDownloadHelper implements BdSailorClient.a {
    public static final String LOG_TAG = BdZeusDownloadHelper.class.getSimpleName();
    private static BdZeusDownloadHelper WS = null;
    protected static final String WX = Environment.getExternalStorageDirectory().getAbsolutePath() + "/baidu/zeus/";
    protected static String WY = WX + "updateZeus.zes";
    protected static String WZ = "com.baidu.android.appswitchsdk:web";
    protected long WV;
    protected long WW;
    private Context mContext;
    private String mDownloadUrl = "";
    private String WU = "";
    private int WT = a.c;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class a {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        public static final int f = 6;
        public static final int g = 7;
        private static final /* synthetic */ int[] h = {a, b, c, d, e, f, g};
    }

    private BdZeusDownloadHelper(Context context) {
        this.mContext = context;
    }

    public static BdZeusDownloadHelper bc(Context context) {
        if (WS == null) {
            synchronized (BdZeusDownloadHelper.class) {
                if (WS == null) {
                    WS = new BdZeusDownloadHelper(context);
                }
            }
        }
        return WS;
    }

    public static void rf() {
        try {
            File file = new File(WY);
            if (!file.exists() || file.delete()) {
                return;
            }
            Log.e(EngineManager.LOG_TAG, "delete zeus download file failed");
        } catch (Throwable th) {
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x001a: INVOKE  (r2v1 long A[REMOVE]) =  type: STATIC call: java.lang.System.currentTimeMillis():long)] */
    public final void W(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mDownloadUrl = str;
        this.WU = str2;
        if (TextUtils.isEmpty(rg())) {
            cF(new StringBuilder().append(System.currentTimeMillis()).toString());
        }
        try {
            BdSailorClient qv = com.baidu.browser.sailor.a.qq().qv();
            if (qv != null) {
                qv.a(this.mDownloadUrl, "", WX, "updateZeus.zes", BdSailorClient.DownloadTaskType.ZEUS, this);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void cF(String str) {
        SharedPreferences.Editor edit = this.mContext.getSharedPreferences(WZ, 0).edit();
        edit.putString("zeus_download_id", str);
        edit.commit();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            File file = new File(WX);
            if (file.exists()) {
                for (File file2 : file.listFiles()) {
                    file2.delete();
                }
            }
        } catch (Exception e) {
            Log.e(e.toString());
        }
    }

    @Keep
    public final void onDownloadCancel(String str, long j, long j2, String str2) {
        this.WT = a.f;
        Log.d(EngineManager.LOG_TAG, "onDownloadCancel");
    }

    @Keep
    public final void onDownloadFail(String str, long j, String str2, String str3) {
        this.WT = a.e;
        Log.d(EngineManager.LOG_TAG, "onDownloadFail");
        cF("");
    }

    @Keep
    public final void onDownloadPause(String str, long j, long j2, String str2) {
        this.WT = a.b;
        Log.d(EngineManager.LOG_TAG, "onDownloadPause");
    }

    @Keep
    public final void onDownloadStart(String str, long j, String str2) {
        this.WT = a.a;
    }

    @Keep
    public final void onDownloadSuccess(String str, String str2, long j) {
        this.WT = a.d;
        Log.d(EngineManager.LOG_TAG, "aKey:" + str + ", aFilelength:" + j);
        Log.d(EngineManager.LOG_TAG, "onDownloadSuccess");
        cF("");
        File file = new File(WY);
        if (!file.exists()) {
            Log.e("Apk file is not exist.");
            if (TextUtils.isEmpty(this.mDownloadUrl)) {
                return;
            }
            W(this.mDownloadUrl, this.WU);
        } else if (file.length() != j) {
            Log.e("Apk file download failed: wrong size");
            file.delete();
            if (TextUtils.isEmpty(this.mDownloadUrl)) {
                return;
            }
            W(this.mDownloadUrl, this.WU);
        } else {
            Log.d(EngineManager.LOG_TAG, " begine check md5");
            String a2 = c.a(WY);
            if (a2 == null || !a2.equalsIgnoreCase(this.WU)) {
                Log.d(EngineManager.LOG_TAG, " check md5 failed ");
                return;
            }
            Log.d(EngineManager.LOG_TAG, " begine install");
            if (WebKitFactory.getCurEngine() != 1) {
                com.baidu.browser.sailor.b.a.qS().b("download-webkit-end", String.valueOf(System.currentTimeMillis()));
                com.baidu.browser.sailor.b.a.qS().a();
            }
            com.baidu.browser.sailor.b.a.qT().cE(WY);
        }
    }

    @Keep
    public final void onDownloading(String str, long j, long j2) {
        this.WV += j;
        this.WW = j2;
        this.WT = a.a;
    }

    public final String rg() {
        return this.mContext.getSharedPreferences(WZ, 0).getString("zeus_download_id", "");
    }
}
