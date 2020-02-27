package com.baidu.browser.sailor.webkit.update;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.BdSailorClient;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.webkit.internal.blink.EngineManager;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.File;
/* loaded from: classes11.dex */
public final class BdZeusDownloadHelper {
    protected long b;
    protected long c;
    private Context h;
    public static final String a = BdZeusDownloadHelper.class.getSimpleName();
    private static BdZeusDownloadHelper JL = null;
    protected static final String d = Environment.getExternalStorageDirectory().getAbsolutePath() + "/baidu/zeus/";
    protected static String e = d + "updateZeus.zes";
    protected static String f = "com.baidu.android.appswitchsdk:web";
    private String i = "";
    private String k = "";
    private int j = a.c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class ZeusDownloadTaskListener implements BdSailorClient.IDownloadTaskListener {
        private ZeusDownloadTaskListener() {
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadCancel(String str, long j, long j2, String str2) {
            BdZeusDownloadHelper.this.j = a.f;
            Log.d(EngineManager.LOG_TAG, "onDownloadCancel");
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadFail(String str, long j, String str2, String str3) {
            BdZeusDownloadHelper.this.j = a.e;
            Log.d(EngineManager.LOG_TAG, "onDownloadFail");
            BdZeusDownloadHelper.this.a("");
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadPause(String str, long j, long j2, String str2) {
            BdZeusDownloadHelper.this.j = a.b;
            Log.d(EngineManager.LOG_TAG, "onDownloadPause");
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadStart(String str, long j, String str2) {
            BdZeusDownloadHelper.this.j = a.a;
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadSuccess(String str, String str2, long j) {
            BdZeusDownloadHelper.this.j = a.d;
            Log.d(EngineManager.LOG_TAG, "aKey:" + str + ", aFilelength:" + j);
            Log.d(EngineManager.LOG_TAG, "onDownloadSuccess");
            BdZeusDownloadHelper.this.a("");
            File file = new File(BdZeusDownloadHelper.e);
            if (!file.exists()) {
                Log.e("Apk file is not exist.");
                if (TextUtils.isEmpty(BdZeusDownloadHelper.this.i)) {
                    return;
                }
                BdZeusDownloadHelper.this.a(BdZeusDownloadHelper.this.i, BdZeusDownloadHelper.this.k);
            } else if (file.length() != j) {
                Log.e("Apk file download failed: wrong size");
                file.delete();
                if (TextUtils.isEmpty(BdZeusDownloadHelper.this.i)) {
                    return;
                }
                BdZeusDownloadHelper.this.a(BdZeusDownloadHelper.this.i, BdZeusDownloadHelper.this.k);
            } else {
                Log.d(EngineManager.LOG_TAG, " begine check md5");
                String a = com.baidu.browser.sailor.util.b.a(BdZeusDownloadHelper.e);
                if (a == null || !a.equalsIgnoreCase(BdZeusDownloadHelper.this.k)) {
                    Log.d(EngineManager.LOG_TAG, " check md5 failed ");
                    return;
                }
                Log.d(EngineManager.LOG_TAG, " begine install");
                if (WebKitFactory.getCurEngine() != 1) {
                    BdSailorPlatform.getStatic().b("download-webkit-end", String.valueOf(System.currentTimeMillis()));
                    BdSailorPlatform.getStatic().a();
                }
                BdSailorPlatform.getWebkitManager().installZeusFromDownload(BdZeusDownloadHelper.e);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloading(String str, long j, long j2) {
            BdZeusDownloadHelper.this.b += j;
            BdZeusDownloadHelper.this.c = j2;
            BdZeusDownloadHelper.this.j = a.a;
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes11.dex */
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
        this.h = context;
    }

    public static void a() {
        try {
            File file = new File(e);
            if (!file.exists() || file.delete()) {
                return;
            }
            Log.e(EngineManager.LOG_TAG, "delete zeus download file failed");
        } catch (Throwable th) {
        }
    }

    public static BdZeusDownloadHelper ak(Context context) {
        if (JL == null) {
            synchronized (BdZeusDownloadHelper.class) {
                if (JL == null) {
                    JL = new BdZeusDownloadHelper(context);
                }
            }
        }
        return JL;
    }

    public final void a(String str) {
        SharedPreferences.Editor edit = this.h.getSharedPreferences(f, 0).edit();
        edit.putString("zeus_download_id", str);
        edit.commit();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            File file = new File(d);
            if (file.exists()) {
                for (File file2 : file.listFiles()) {
                    file2.delete();
                }
            }
        } catch (Exception e2) {
            Log.e(e2.toString());
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0029: INVOKE  (r2v3 long A[REMOVE]) =  type: STATIC call: java.lang.System.currentTimeMillis():long)] */
    public final void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.i = str;
        this.k = str2;
        if (TextUtils.isEmpty(this.h.getSharedPreferences(f, 0).getString("zeus_download_id", ""))) {
            a(new StringBuilder().append(System.currentTimeMillis()).toString());
        }
        try {
            BdSailorClient sailorClient = BdSailor.getInstance().getSailorClient();
            if (sailorClient != null) {
                sailorClient.onDownloadTask(this.i, "", d, "updateZeus.zes", BdSailorClient.DownloadTaskType.ZEUS, new ZeusDownloadTaskListener());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
