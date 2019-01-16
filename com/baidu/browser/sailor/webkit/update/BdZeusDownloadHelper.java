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
    private static BdZeusDownloadHelper Xd = null;
    protected static final String Xi = Environment.getExternalStorageDirectory().getAbsolutePath() + "/baidu/zeus/";
    protected static String Xj = Xi + "updateZeus.zes";
    protected static String Xk = "com.baidu.android.appswitchsdk:web";
    protected long Xg;
    protected long Xh;
    private Context mContext;
    private String mDownloadUrl = "";
    private String Xf = "";
    private int Xe = a.c;

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
        if (Xd == null) {
            synchronized (BdZeusDownloadHelper.class) {
                if (Xd == null) {
                    Xd = new BdZeusDownloadHelper(context);
                }
            }
        }
        return Xd;
    }

    public static void rg() {
        try {
            File file = new File(Xj);
            if (!file.exists() || file.delete()) {
                return;
            }
            Log.e(EngineManager.LOG_TAG, "delete zeus download file failed");
        } catch (Throwable th) {
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x001a: INVOKE  (r2v1 long A[REMOVE]) =  type: STATIC call: java.lang.System.currentTimeMillis():long)] */
    public final void X(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mDownloadUrl = str;
        this.Xf = str2;
        if (TextUtils.isEmpty(rh())) {
            cG(new StringBuilder().append(System.currentTimeMillis()).toString());
        }
        try {
            BdSailorClient qw = com.baidu.browser.sailor.a.qr().qw();
            if (qw != null) {
                qw.a(this.mDownloadUrl, "", Xi, "updateZeus.zes", BdSailorClient.DownloadTaskType.ZEUS, this);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void cG(String str) {
        SharedPreferences.Editor edit = this.mContext.getSharedPreferences(Xk, 0).edit();
        edit.putString("zeus_download_id", str);
        edit.commit();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            File file = new File(Xi);
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
        this.Xe = a.f;
        Log.d(EngineManager.LOG_TAG, "onDownloadCancel");
    }

    @Keep
    public final void onDownloadFail(String str, long j, String str2, String str3) {
        this.Xe = a.e;
        Log.d(EngineManager.LOG_TAG, "onDownloadFail");
        cG("");
    }

    @Keep
    public final void onDownloadPause(String str, long j, long j2, String str2) {
        this.Xe = a.b;
        Log.d(EngineManager.LOG_TAG, "onDownloadPause");
    }

    @Keep
    public final void onDownloadStart(String str, long j, String str2) {
        this.Xe = a.a;
    }

    @Keep
    public final void onDownloadSuccess(String str, String str2, long j) {
        this.Xe = a.d;
        Log.d(EngineManager.LOG_TAG, "aKey:" + str + ", aFilelength:" + j);
        Log.d(EngineManager.LOG_TAG, "onDownloadSuccess");
        cG("");
        File file = new File(Xj);
        if (!file.exists()) {
            Log.e("Apk file is not exist.");
            if (TextUtils.isEmpty(this.mDownloadUrl)) {
                return;
            }
            X(this.mDownloadUrl, this.Xf);
        } else if (file.length() != j) {
            Log.e("Apk file download failed: wrong size");
            file.delete();
            if (TextUtils.isEmpty(this.mDownloadUrl)) {
                return;
            }
            X(this.mDownloadUrl, this.Xf);
        } else {
            Log.d(EngineManager.LOG_TAG, " begine check md5");
            String a2 = c.a(Xj);
            if (a2 == null || !a2.equalsIgnoreCase(this.Xf)) {
                Log.d(EngineManager.LOG_TAG, " check md5 failed ");
                return;
            }
            Log.d(EngineManager.LOG_TAG, " begine install");
            if (WebKitFactory.getCurEngine() != 1) {
                com.baidu.browser.sailor.b.a.qT().b("download-webkit-end", String.valueOf(System.currentTimeMillis()));
                com.baidu.browser.sailor.b.a.qT().a();
            }
            com.baidu.browser.sailor.b.a.qU().cF(Xj);
        }
    }

    @Keep
    public final void onDownloading(String str, long j, long j2) {
        this.Xg += j;
        this.Xh = j2;
        this.Xe = a.a;
    }

    public final String rh() {
        return this.mContext.getSharedPreferences(Xk, 0).getString("zeus_download_id", "");
    }
}
