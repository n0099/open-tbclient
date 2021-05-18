package com.baidu.browser.sailor.webkit.update;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.webkit.internal.blink.EngineManager;
import com.baidu.webkit.internal.blink.WebKitVersionBlink;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.internal.daemon.ZeusThreadPoolUtil;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.net.INetListener;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import d.a.h.b.c.b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BdZeusUpdate {

    /* renamed from: e  reason: collision with root package name */
    public static BdZeusUpdate f4310e;

    /* renamed from: a  reason: collision with root package name */
    public String f4311a;

    /* renamed from: b  reason: collision with root package name */
    public String f4312b;

    /* renamed from: c  reason: collision with root package name */
    public String f4313c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4314d;

    /* loaded from: classes.dex */
    public class BdZesuUpdateTask extends BdNetTask implements INetListener {
        public ByteArrayOutputStream mOutputStream;

        public BdZesuUpdateTask(Context context, String str) {
            setUrl(BdZeusUpdate.b(str, context));
            setMethod(BdNet.HttpMethod.METHOD_GET);
        }

        @Override // com.baidu.webkit.net.INetListener
        public void onNetDownloadComplete(BdNet bdNet) {
        }

        @Override // com.baidu.webkit.net.INetListener
        public void onNetDownloadError(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetError netError, int i2) {
            this.mOutputStream.reset();
        }

        @Override // com.baidu.webkit.net.INetListener
        public void onNetReceiveData(BdNet bdNet, BdNetTask bdNetTask, byte[] bArr, int i2) {
            if (this.mOutputStream == null) {
                this.mOutputStream = new ByteArrayOutputStream();
            }
            if (i2 > 0) {
                this.mOutputStream.write(bArr, 0, i2);
            }
        }

        @Override // com.baidu.webkit.net.INetListener
        public void onNetReceiveHeaders(BdNet bdNet, BdNetTask bdNetTask) {
        }

        @Override // com.baidu.webkit.net.INetListener
        public boolean onNetRedirect(BdNet bdNet, BdNetTask bdNetTask, int i2) {
            return false;
        }

        @Override // com.baidu.webkit.net.INetListener
        public void onNetResponseCode(BdNet bdNet, BdNetTask bdNetTask, int i2) {
        }

        @Override // com.baidu.webkit.net.INetListener
        public void onNetStateChanged(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetState netState, int i2) {
        }

        @Override // com.baidu.webkit.net.INetListener
        public void onNetTaskComplete(BdNet bdNet, BdNetTask bdNetTask) {
            ByteArrayOutputStream byteArrayOutputStream = this.mOutputStream;
            if (byteArrayOutputStream != null) {
                try {
                    String byteArrayOutputStream2 = byteArrayOutputStream.toString("utf-8");
                    Log.d(EngineManager.LOG_TAG, "received data = ".concat(String.valueOf(byteArrayOutputStream2)));
                    if (byteArrayOutputStream2.length() > 0) {
                        JSONObject jSONObject = new JSONObject(byteArrayOutputStream2);
                        if (jSONObject.has("data")) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                            if (jSONObject2.has("version")) {
                                BdZeusUpdate.this.f4312b = jSONObject2.getString("version");
                            }
                            if (jSONObject2.has("link")) {
                                BdZeusUpdate.this.f4311a = jSONObject2.getString("link");
                            }
                            if (jSONObject2.has(PackageTable.MD5)) {
                                BdZeusUpdate.this.f4313c = jSONObject2.getString(PackageTable.MD5);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
            Log.i(EngineManager.LOG_TAG, "check received data");
            release();
            BdZeusUpdate.this.g();
        }

        @Override // com.baidu.webkit.net.INetListener
        public void onNetTaskStart(BdNet bdNet, BdNetTask bdNetTask) {
        }

        @Override // com.baidu.webkit.net.INetListener
        public void onNetUploadComplete(BdNet bdNet, BdNetTask bdNetTask) {
        }

        @Override // com.baidu.webkit.net.INetListener
        public void onNetUploadData(BdNet bdNet, BdNetTask bdNetTask, int i2, int i3) {
        }

        public void release() {
            ByteArrayOutputStream byteArrayOutputStream = this.mOutputStream;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.reset();
                    this.mOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            this.mOutputStream = null;
        }
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f4315e;

        public a(Context context) {
            this.f4315e = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f4315e != null) {
                Log.i(EngineManager.LOG_TAG, "start check zeus update async");
                BdZeusUpdate bdZeusUpdate = BdZeusUpdate.this;
                Context context = this.f4315e;
                if (WebKitFactory.isUserPrivacyEnabled() && !bdZeusUpdate.f4314d && b.d(context)) {
                    BdZesuUpdateTask bdZesuUpdateTask = new BdZesuUpdateTask(context, "https://mbrowser.baidu.com/api/update/kernel?version=");
                    BdNet bdNet = new BdNet(context);
                    bdNet.setEventListener(bdZesuUpdateTask);
                    bdNet.start(bdZesuUpdateTask, false);
                    bdZeusUpdate.f4314d = true;
                }
            }
        }
    }

    public static BdZeusUpdate a() {
        if (f4310e == null) {
            synchronized (BdZeusUpdate.class) {
                if (f4310e == null) {
                    f4310e = new BdZeusUpdate();
                }
            }
        }
        return f4310e;
    }

    public static String b(String str, Context context) {
        if (TextUtils.isEmpty(str) || context == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        String zeusVersionByUpdate = WebKitVersionBlink.getZeusVersionByUpdate();
        String sdkVersionName = WebKitFactory.getSdkVersionName();
        Log.w("sdk in=".concat(String.valueOf(zeusVersionByUpdate)));
        Log.w("sdk out=".concat(String.valueOf(sdkVersionName)));
        sb.append(zeusVersionByUpdate);
        sb.append("&");
        if (!TextUtils.isEmpty(sdkVersionName)) {
            d(sb, "sdk", sdkVersionName);
        }
        String cuid = BdSailorPlatform.getInstance().getCuid();
        String f2 = !TextUtils.isEmpty(cuid) ? b.f(cuid) : "";
        if (!TextUtils.isEmpty(f2)) {
            d(sb, "cuid", f2);
        }
        String str2 = Build.MODEL;
        String str3 = Build.VERSION.RELEASE;
        int i2 = Build.VERSION.SDK_INT;
        String str4 = Build.MANUFACTURER;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str2.replace("_", "-"));
        stringBuffer.append("_");
        stringBuffer.append(str3);
        stringBuffer.append("_");
        stringBuffer.append(i2);
        stringBuffer.append("_");
        stringBuffer.append(str4.replace("_", "-"));
        String f3 = b.f(stringBuffer.toString().replace(" ", "-"));
        if (!TextUtils.isEmpty(f3)) {
            d(sb, BdZeusUtil.URL_KEY_MACHINE, f3);
        }
        String packageName = context.getPackageName();
        if (!TextUtils.isEmpty(packageName)) {
            d(sb, "app", packageName);
        }
        PackageInfo h2 = h(context);
        if (h2 != null) {
            String str5 = h2.versionName;
            if (!TextUtils.isEmpty(str5)) {
                d(sb, "appversion", str5);
            }
        }
        String f4 = f(context);
        if (!TextUtils.isEmpty(f4)) {
            sb.append("from");
            sb.append("=");
            sb.append(f4);
        }
        if (!BdZeusUtil.isWebkitLoaded()) {
            sb.append("&");
            sb.append("nozeus");
            sb.append("=");
            sb.append("1");
        }
        Log.i(EngineManager.LOG_TAG, "startCheck url = " + sb.toString());
        return sb.toString();
    }

    public static void d(StringBuilder sb, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        sb.append(str);
        sb.append("=");
        sb.append(str2);
        sb.append("&");
    }

    public static boolean e(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            long[] jArr = new long[8];
            for (int i2 = 0; i2 < 8; i2++) {
                jArr[i2] = 0;
            }
            try {
                String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX, 4);
                String[] split2 = str2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX, 4);
                jArr[0] = Long.parseLong(split[0]);
                jArr[1] = Long.parseLong(split[1]);
                jArr[2] = Long.parseLong(split[2]);
                jArr[3] = Long.parseLong(split[3]);
                jArr[4] = Long.parseLong(split2[0]);
                jArr[5] = Long.parseLong(split2[1]);
                jArr[6] = Long.parseLong(split2[2]);
                jArr[7] = Long.parseLong(split2[3]);
            } catch (Throwable unused) {
            }
            if (jArr[0] == jArr[4] && jArr[1] <= jArr[5] && jArr[2] == jArr[6] && jArr[3] < jArr[7]) {
                return true;
            }
        }
        return false;
    }

    public static String f(Context context) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            inputStream = context.getResources().openRawResource(context.getResources().getIdentifier("tnconfig", "raw", context.getPackageName()));
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Exception unused) {
            } catch (Throwable th2) {
                byteArrayOutputStream = null;
                th = th2;
            }
        } catch (Exception unused2) {
            inputStream = null;
        } catch (Throwable th3) {
            byteArrayOutputStream = null;
            th = th3;
            inputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            String trim = new String(byteArrayOutputStream.toByteArray()).trim();
            try {
                byteArrayOutputStream.close();
            } catch (Exception unused3) {
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused4) {
                }
            }
            return trim;
        } catch (Exception unused5) {
            byteArrayOutputStream2 = byteArrayOutputStream;
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                } catch (Exception unused6) {
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                    return BdZeusUtil.DEFAULT_TNNUMBER;
                } catch (Exception unused7) {
                    return BdZeusUtil.DEFAULT_TNNUMBER;
                }
            }
            return BdZeusUtil.DEFAULT_TNNUMBER;
        } catch (Throwable th4) {
            th = th4;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception unused8) {
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused9) {
                }
            }
            throw th;
        }
    }

    public static PackageInfo h(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final void c(Context context) {
        ZeusThreadPoolUtil.executeIgnoreZeus(new a(context));
    }

    public final void g() {
        if (BdSailor.getInstance().getAppContext() != null) {
            String zeusVersionName = WebKitFactory.getZeusVersionName();
            boolean z = false;
            if (WebKitFactory.getCurEngine() == 1) {
                if (e(zeusVersionName, this.f4312b)) {
                    BdZeusDownloadHelper.b(BdSailor.getInstance().getAppContext()).e(this.f4311a, this.f4313c);
                    return;
                }
                return;
            }
            String packageName = BdSailor.getInstance().getAppContext().getPackageName();
            if (packageName != null && packageName.equalsIgnoreCase(BdSailorPlatform.LITE_PACKAGE_NAME)) {
                z = true;
            }
            if (z) {
                try {
                    float a2 = d.a.h.a.k.a.a() / 1024.0f;
                    String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("update_zeus_mem_size_mb");
                    if (a2 < (TextUtils.isEmpty(GetCloudSettingsValue) ? 1024 : Integer.valueOf(GetCloudSettingsValue).intValue())) {
                        return;
                    }
                    BdSailorPlatform.getStatic().c("MemMbSize", String.valueOf(a2));
                } catch (Exception unused) {
                }
            }
            BdSailorPlatform.getStatic().c("download-webkit-start", String.valueOf(System.currentTimeMillis()));
            BdSailorPlatform.getStatic().a();
            Log.i(EngineManager.LOG_TAG, "start download zeus");
            BdZeusDownloadHelper.b(BdSailor.getInstance().getAppContext()).e(this.f4311a, this.f4313c);
        }
    }
}
