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
import d.b.h.b.e.b;
import java.io.File;
/* loaded from: classes2.dex */
public final class BdZeusDownloadHelper {

    /* renamed from: g  reason: collision with root package name */
    public static BdZeusDownloadHelper f4330g = null;

    /* renamed from: h  reason: collision with root package name */
    public static String f4331h = null;
    public static String i = null;
    public static String j = "com.baidu.android.appswitchsdk:web";

    /* renamed from: a  reason: collision with root package name */
    public Context f4332a;

    /* renamed from: c  reason: collision with root package name */
    public int f4334c;

    /* renamed from: e  reason: collision with root package name */
    public long f4336e;

    /* renamed from: f  reason: collision with root package name */
    public long f4337f;

    /* renamed from: b  reason: collision with root package name */
    public String f4333b = "";

    /* renamed from: d  reason: collision with root package name */
    public String f4335d = "";

    /* loaded from: classes2.dex */
    public class ZeusDownloadTaskListener implements BdSailorClient.IDownloadTaskListener {
        public ZeusDownloadTaskListener() {
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadCancel(String str, long j, long j2, String str2) {
            BdZeusDownloadHelper.this.f4334c = a.f4343f;
            Log.i(EngineManager.LOG_TAG, "onDownloadCancel");
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadFail(String str, long j, String str2, String str3) {
            BdZeusDownloadHelper.this.f4334c = a.f4342e;
            Log.i(EngineManager.LOG_TAG, "onDownloadFail");
            BdZeusDownloadHelper.this.e("");
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadPause(String str, long j, long j2, String str2) {
            BdZeusDownloadHelper.this.f4334c = a.f4339b;
            Log.i(EngineManager.LOG_TAG, "onDownloadPause");
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadStart(String str, long j, String str2) {
            BdZeusDownloadHelper.this.f4334c = a.f4338a;
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadSuccess(String str, String str2, long j) {
            BdZeusDownloadHelper.this.f4334c = a.f4341d;
            Log.i(EngineManager.LOG_TAG, "aKey:" + str + ", aFilelength:" + j);
            Log.i(EngineManager.LOG_TAG, "onDownloadSuccess");
            if (TextUtils.isEmpty(BdZeusDownloadHelper.i)) {
                return;
            }
            BdZeusDownloadHelper.this.e("");
            File file = new File(BdZeusDownloadHelper.i);
            if (!file.exists()) {
                Log.e("Apk file is not exist.");
                if (TextUtils.isEmpty(BdZeusDownloadHelper.this.f4333b)) {
                    return;
                }
                BdZeusDownloadHelper bdZeusDownloadHelper = BdZeusDownloadHelper.this;
                bdZeusDownloadHelper.f(bdZeusDownloadHelper.f4333b, BdZeusDownloadHelper.this.f4335d);
            } else if (file.length() != j) {
                Log.e("Apk file download failed: wrong size");
                file.delete();
                if (TextUtils.isEmpty(BdZeusDownloadHelper.this.f4333b)) {
                    return;
                }
                BdZeusDownloadHelper bdZeusDownloadHelper2 = BdZeusDownloadHelper.this;
                bdZeusDownloadHelper2.f(bdZeusDownloadHelper2.f4333b, BdZeusDownloadHelper.this.f4335d);
            } else {
                Log.i(EngineManager.LOG_TAG, " begine check md5");
                String a2 = b.a(BdZeusDownloadHelper.i);
                if (a2 == null || !a2.equalsIgnoreCase(BdZeusDownloadHelper.this.f4335d)) {
                    Log.i(EngineManager.LOG_TAG, " check md5 failed ");
                    return;
                }
                Log.i(EngineManager.LOG_TAG, " begine install");
                if (WebKitFactory.getCurEngine() != 1) {
                    BdSailorPlatform.getStatic().c("download-webkit-end", String.valueOf(System.currentTimeMillis()));
                    BdSailorPlatform.getStatic().a();
                }
                BdSailorPlatform.getWebkitManager().installZeusFromDownload(BdZeusDownloadHelper.i);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloading(String str, long j, long j2) {
            BdZeusDownloadHelper bdZeusDownloadHelper = BdZeusDownloadHelper.this;
            bdZeusDownloadHelper.f4336e += j;
            bdZeusDownloadHelper.f4337f = j2;
            bdZeusDownloadHelper.f4334c = a.f4338a;
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f4338a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f4339b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f4340c = 3;

        /* renamed from: d  reason: collision with root package name */
        public static final int f4341d = 4;

        /* renamed from: e  reason: collision with root package name */
        public static final int f4342e = 5;

        /* renamed from: f  reason: collision with root package name */
        public static final int f4343f = 6;

        /* renamed from: g  reason: collision with root package name */
        public static final int f4344g = 7;

        /* renamed from: h  reason: collision with root package name */
        public static final /* synthetic */ int[] f4345h = {1, 2, 3, 4, 5, 6, 7};
    }

    public BdZeusDownloadHelper(Context context) {
        this.f4332a = context;
        int i2 = a.f4340c;
        if (context != null) {
            f4331h = this.f4332a.getExternalFilesDir("").getAbsolutePath() + "/baidu/zeus/";
            i = f4331h + "updateZeus.zes";
        }
    }

    public static BdZeusDownloadHelper b(Context context) {
        if (f4330g == null) {
            synchronized (BdZeusDownloadHelper.class) {
                if (f4330g == null) {
                    f4330g = new BdZeusDownloadHelper(context);
                }
            }
        }
        return f4330g;
    }

    public static void d() {
        if (TextUtils.isEmpty(i)) {
            return;
        }
        try {
            File file = new File(i);
            if (!file.exists() || file.delete()) {
                return;
            }
            Log.e(EngineManager.LOG_TAG, "delete zeus download file failed");
        } catch (Throwable unused) {
        }
    }

    public final void e(String str) {
        SharedPreferences.Editor edit = this.f4332a.getSharedPreferences(j, 0).edit();
        edit.putString("zeus_download_id", str);
        edit.commit();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(f4331h)) {
            return;
        }
        try {
            File file = new File(f4331h);
            if (file.exists()) {
                for (File file2 : file.listFiles()) {
                    file2.delete();
                }
            }
        } catch (Exception e2) {
            Log.e(e2.toString());
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0028: INVOKE  (r0v4 long A[REMOVE]) =  type: STATIC call: java.lang.System.currentTimeMillis():long)] */
    public final void f(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f4333b = str;
        this.f4335d = str2;
        if (TextUtils.isEmpty(this.f4332a.getSharedPreferences(j, 0).getString("zeus_download_id", ""))) {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            e(sb.toString());
        }
        try {
            BdSailorClient sailorClient = BdSailor.getInstance().getSailorClient();
            if (sailorClient == null || TextUtils.isEmpty(f4331h)) {
                return;
            }
            sailorClient.onDownloadTask(this.f4333b, "", f4331h, "updateZeus.zes", BdSailorClient.DownloadTaskType.ZEUS, new ZeusDownloadTaskListener());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
