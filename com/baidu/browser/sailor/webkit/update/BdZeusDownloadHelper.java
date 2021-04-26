package com.baidu.browser.sailor.webkit.update;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.BdSailorClient;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.webkit.internal.blink.EngineManager;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import d.a.h.b.e.b;
import java.io.File;
/* loaded from: classes.dex */
public final class BdZeusDownloadHelper {

    /* renamed from: g  reason: collision with root package name */
    public static BdZeusDownloadHelper f4444g = null;

    /* renamed from: h  reason: collision with root package name */
    public static String f4445h = null;

    /* renamed from: i  reason: collision with root package name */
    public static String f4446i = null;
    public static String j = "com.baidu.android.appswitchsdk:web";

    /* renamed from: a  reason: collision with root package name */
    public Context f4447a;

    /* renamed from: c  reason: collision with root package name */
    public int f4449c;

    /* renamed from: e  reason: collision with root package name */
    public long f4451e;

    /* renamed from: f  reason: collision with root package name */
    public long f4452f;

    /* renamed from: b  reason: collision with root package name */
    public String f4448b = "";

    /* renamed from: d  reason: collision with root package name */
    public String f4450d = "";

    /* loaded from: classes.dex */
    public class ZeusDownloadTaskListener implements BdSailorClient.IDownloadTaskListener {
        public ZeusDownloadTaskListener() {
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadCancel(String str, long j, long j2, String str2) {
            BdZeusDownloadHelper.this.f4449c = a.f4458f;
            Log.i(EngineManager.LOG_TAG, "onDownloadCancel");
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadFail(String str, long j, String str2, String str3) {
            BdZeusDownloadHelper.this.f4449c = a.f4457e;
            Log.i(EngineManager.LOG_TAG, "onDownloadFail");
            BdZeusDownloadHelper.this.e("");
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadPause(String str, long j, long j2, String str2) {
            BdZeusDownloadHelper.this.f4449c = a.f4454b;
            Log.i(EngineManager.LOG_TAG, "onDownloadPause");
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadStart(String str, long j, String str2) {
            BdZeusDownloadHelper.this.f4449c = a.f4453a;
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadSuccess(String str, String str2, long j) {
            BdZeusDownloadHelper.this.f4449c = a.f4456d;
            Log.i(EngineManager.LOG_TAG, "aKey:" + str + ", aFilelength:" + j);
            Log.i(EngineManager.LOG_TAG, "onDownloadSuccess");
            if (TextUtils.isEmpty(BdZeusDownloadHelper.f4446i)) {
                return;
            }
            BdZeusDownloadHelper.this.e("");
            File file = new File(BdZeusDownloadHelper.f4446i);
            if (!file.exists()) {
                Log.e("Apk file is not exist.");
                if (TextUtils.isEmpty(BdZeusDownloadHelper.this.f4448b)) {
                    return;
                }
                BdZeusDownloadHelper bdZeusDownloadHelper = BdZeusDownloadHelper.this;
                bdZeusDownloadHelper.f(bdZeusDownloadHelper.f4448b, BdZeusDownloadHelper.this.f4450d);
            } else if (file.length() != j) {
                Log.e("Apk file download failed: wrong size");
                file.delete();
                if (TextUtils.isEmpty(BdZeusDownloadHelper.this.f4448b)) {
                    return;
                }
                BdZeusDownloadHelper bdZeusDownloadHelper2 = BdZeusDownloadHelper.this;
                bdZeusDownloadHelper2.f(bdZeusDownloadHelper2.f4448b, BdZeusDownloadHelper.this.f4450d);
            } else {
                Log.i(EngineManager.LOG_TAG, " begine check md5");
                String a2 = b.a(BdZeusDownloadHelper.f4446i);
                if (a2 == null || !a2.equalsIgnoreCase(BdZeusDownloadHelper.this.f4450d)) {
                    Log.i(EngineManager.LOG_TAG, " check md5 failed ");
                    return;
                }
                Log.i(EngineManager.LOG_TAG, " begine install");
                if (WebKitFactory.getCurEngine() != 1) {
                    BdSailorPlatform.getStatic().c("download-webkit-end", String.valueOf(System.currentTimeMillis()));
                    BdSailorPlatform.getStatic().a();
                }
                BdSailorPlatform.getWebkitManager().installZeusFromDownload(BdZeusDownloadHelper.f4446i);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloading(String str, long j, long j2) {
            BdZeusDownloadHelper bdZeusDownloadHelper = BdZeusDownloadHelper.this;
            bdZeusDownloadHelper.f4451e += j;
            bdZeusDownloadHelper.f4452f = j2;
            bdZeusDownloadHelper.f4449c = a.f4453a;
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f4453a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f4454b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f4455c = 3;

        /* renamed from: d  reason: collision with root package name */
        public static final int f4456d = 4;

        /* renamed from: e  reason: collision with root package name */
        public static final int f4457e = 5;

        /* renamed from: f  reason: collision with root package name */
        public static final int f4458f = 6;

        /* renamed from: g  reason: collision with root package name */
        public static final int f4459g = 7;

        /* renamed from: h  reason: collision with root package name */
        public static final /* synthetic */ int[] f4460h = {1, 2, 3, 4, 5, 6, 7};
    }

    public BdZeusDownloadHelper(Context context) {
        this.f4447a = context;
        int i2 = a.f4455c;
        if (context != null) {
            f4445h = this.f4447a.getExternalFilesDir("").getAbsolutePath() + "/baidu/zeus/";
            f4446i = f4445h + "updateZeus.zes";
        }
    }

    public static BdZeusDownloadHelper b(Context context) {
        if (f4444g == null) {
            synchronized (BdZeusDownloadHelper.class) {
                if (f4444g == null) {
                    f4444g = new BdZeusDownloadHelper(context);
                }
            }
        }
        return f4444g;
    }

    public static void d() {
        if (TextUtils.isEmpty(f4446i)) {
            return;
        }
        try {
            File file = new File(f4446i);
            if (!file.exists() || file.delete()) {
                return;
            }
            Log.e(EngineManager.LOG_TAG, "delete zeus download file failed");
        } catch (Throwable unused) {
        }
    }

    public final void e(String str) {
        SharedPreferences.Editor edit = this.f4447a.getSharedPreferences(j, 0).edit();
        edit.putString("zeus_download_id", str);
        edit.commit();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(f4445h)) {
            return;
        }
        try {
            File file = new File(f4445h);
            if (file.exists()) {
                for (File file2 : file.listFiles()) {
                    file2.delete();
                }
            }
        } catch (Exception e2) {
            Log.e(e2.toString());
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0027: INVOKE  (r0v4 long A[REMOVE]) =  type: STATIC call: java.lang.System.currentTimeMillis():long)] */
    public final void f(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f4448b = str;
        this.f4450d = str2;
        if (TextUtils.isEmpty(this.f4447a.getSharedPreferences(j, 0).getString("zeus_download_id", ""))) {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            e(sb.toString());
        }
        try {
            BdSailorClient sailorClient = BdSailor.getInstance().getSailorClient();
            if (sailorClient == null || TextUtils.isEmpty(f4445h)) {
                return;
            }
            sailorClient.onDownloadTask(this.f4448b, "", f4445h, "updateZeus.zes", BdSailorClient.DownloadTaskType.ZEUS, new ZeusDownloadTaskListener());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
