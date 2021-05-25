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
import java.io.File;
/* loaded from: classes.dex */
public final class BdZeusDownloadHelper {

    /* renamed from: g  reason: collision with root package name */
    public static BdZeusDownloadHelper f4296g = null;

    /* renamed from: h  reason: collision with root package name */
    public static String f4297h = null;

    /* renamed from: i  reason: collision with root package name */
    public static String f4298i = null;
    public static String j = "com.baidu.android.appswitchsdk:web";

    /* renamed from: a  reason: collision with root package name */
    public Context f4299a;

    /* renamed from: c  reason: collision with root package name */
    public int f4301c;

    /* renamed from: e  reason: collision with root package name */
    public long f4303e;

    /* renamed from: f  reason: collision with root package name */
    public long f4304f;

    /* renamed from: b  reason: collision with root package name */
    public String f4300b = "";

    /* renamed from: d  reason: collision with root package name */
    public String f4302d = "";

    /* loaded from: classes.dex */
    public class ZeusDownloadTaskListener implements BdSailorClient.IDownloadTaskListener {
        public ZeusDownloadTaskListener() {
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadCancel(String str, long j, long j2, String str2) {
            BdZeusDownloadHelper.this.f4301c = a.f4310f;
            Log.i(EngineManager.LOG_TAG, "onDownloadCancel");
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadFail(String str, long j, String str2, String str3) {
            BdZeusDownloadHelper.this.f4301c = a.f4309e;
            Log.i(EngineManager.LOG_TAG, "onDownloadFail");
            BdZeusDownloadHelper.this.d("");
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadPause(String str, long j, long j2, String str2) {
            BdZeusDownloadHelper.this.f4301c = a.f4306b;
            Log.i(EngineManager.LOG_TAG, "onDownloadPause");
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadStart(String str, long j, String str2) {
            BdZeusDownloadHelper.this.f4301c = a.f4305a;
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadSuccess(String str, String str2, long j) {
            BdZeusDownloadHelper.this.f4301c = a.f4308d;
            Log.i(EngineManager.LOG_TAG, "aKey:" + str + ", aFilelength:" + j);
            Log.i(EngineManager.LOG_TAG, "onDownloadSuccess");
            if (TextUtils.isEmpty(BdZeusDownloadHelper.f4298i)) {
                return;
            }
            BdZeusDownloadHelper.this.d("");
            File file = new File(BdZeusDownloadHelper.f4298i);
            if (!file.exists()) {
                Log.e("Apk file is not exist.");
                if (TextUtils.isEmpty(BdZeusDownloadHelper.this.f4300b)) {
                    return;
                }
                BdZeusDownloadHelper bdZeusDownloadHelper = BdZeusDownloadHelper.this;
                bdZeusDownloadHelper.e(bdZeusDownloadHelper.f4300b, BdZeusDownloadHelper.this.f4302d);
            } else if (file.length() != j) {
                Log.e("Apk file download failed: wrong size");
                file.delete();
                if (TextUtils.isEmpty(BdZeusDownloadHelper.this.f4300b)) {
                    return;
                }
                BdZeusDownloadHelper bdZeusDownloadHelper2 = BdZeusDownloadHelper.this;
                bdZeusDownloadHelper2.e(bdZeusDownloadHelper2.f4300b, BdZeusDownloadHelper.this.f4302d);
            } else {
                Log.i(EngineManager.LOG_TAG, " begine check md5");
                String a2 = d.a.h.b.c.b.a(BdZeusDownloadHelper.f4298i);
                if (a2 == null || !a2.equalsIgnoreCase(BdZeusDownloadHelper.this.f4302d)) {
                    Log.i(EngineManager.LOG_TAG, " check md5 failed ");
                    return;
                }
                Log.i(EngineManager.LOG_TAG, " begine install");
                if (WebKitFactory.getCurEngine() != 1) {
                    BdSailorPlatform.getStatic().c("download-webkit-end", String.valueOf(System.currentTimeMillis()));
                    BdSailorPlatform.getStatic().a();
                }
                BdSailorPlatform.getWebkitManager().installZeusFromDownload(BdZeusDownloadHelper.f4298i);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloading(String str, long j, long j2) {
            BdZeusDownloadHelper bdZeusDownloadHelper = BdZeusDownloadHelper.this;
            bdZeusDownloadHelper.f4303e += j;
            bdZeusDownloadHelper.f4304f = j2;
            bdZeusDownloadHelper.f4301c = a.f4305a;
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f4305a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f4306b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f4307c = 3;

        /* renamed from: d  reason: collision with root package name */
        public static final int f4308d = 4;

        /* renamed from: e  reason: collision with root package name */
        public static final int f4309e = 5;

        /* renamed from: f  reason: collision with root package name */
        public static final int f4310f = 6;

        /* renamed from: g  reason: collision with root package name */
        public static final int f4311g = 7;

        /* renamed from: h  reason: collision with root package name */
        public static final /* synthetic */ int[] f4312h = {1, 2, 3, 4, 5, 6, 7};
    }

    public BdZeusDownloadHelper(Context context) {
        this.f4299a = context;
        int i2 = a.f4307c;
        if (context != null) {
            f4297h = this.f4299a.getExternalFilesDir("").getAbsolutePath() + "/baidu/zeus/";
            f4298i = f4297h + "updateZeus.zes";
        }
    }

    public static BdZeusDownloadHelper b(Context context) {
        if (f4296g == null) {
            synchronized (BdZeusDownloadHelper.class) {
                if (f4296g == null) {
                    f4296g = new BdZeusDownloadHelper(context);
                }
            }
        }
        return f4296g;
    }

    public final void d(String str) {
        SharedPreferences.Editor edit = this.f4299a.getSharedPreferences(j, 0).edit();
        edit.putString("zeus_download_id", str);
        edit.commit();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(f4297h)) {
            return;
        }
        try {
            File file = new File(f4297h);
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
    public final void e(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f4300b = str;
        this.f4302d = str2;
        if (TextUtils.isEmpty(this.f4299a.getSharedPreferences(j, 0).getString("zeus_download_id", ""))) {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            d(sb.toString());
        }
        try {
            BdSailorClient sailorClient = BdSailor.getInstance().getSailorClient();
            if (sailorClient == null || TextUtils.isEmpty(f4297h)) {
                return;
            }
            sailorClient.onDownloadTask(this.f4300b, "", f4297h, "updateZeus.zes", BdSailorClient.DownloadTaskType.ZEUS, new ZeusDownloadTaskListener());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
