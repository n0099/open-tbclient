package com.baidu.browser.sailor.webkit.update;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.internal.blink.EngineManager;
import com.baidu.webkit.internal.blink.WebKitVersionBlink;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.internal.daemon.ZeusThreadPoolUtil;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.net.INetListener;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class a {
    private static a agY = null;

    /* renamed from: a  reason: collision with root package name */
    protected String f1662a;

    /* renamed from: b  reason: collision with root package name */
    protected String f1663b;
    protected String c;
    boolean d;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.browser.sailor.webkit.update.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public class C0088a extends BdNetTask implements INetListener {
        protected ByteArrayOutputStream agZ;

        public C0088a(Context context, String str) {
            setUrl(a.a(str, context));
            setMethod(BdNet.HttpMethod.METHOD_GET);
        }

        @Override // com.baidu.webkit.net.INetListener
        public void onNetDownloadComplete(BdNet bdNet) {
        }

        @Override // com.baidu.webkit.net.INetListener
        public void onNetDownloadError(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetError netError, int i) {
            this.agZ.reset();
        }

        @Override // com.baidu.webkit.net.INetListener
        public void onNetReceiveData(BdNet bdNet, BdNetTask bdNetTask, byte[] bArr, int i) {
            if (this.agZ == null) {
                this.agZ = new ByteArrayOutputStream();
            }
            if (i > 0) {
                this.agZ.write(bArr, 0, i);
            }
        }

        @Override // com.baidu.webkit.net.INetListener
        public void onNetReceiveHeaders(BdNet bdNet, BdNetTask bdNetTask) {
        }

        @Override // com.baidu.webkit.net.INetListener
        public boolean onNetRedirect(BdNet bdNet, BdNetTask bdNetTask, int i) {
            return false;
        }

        @Override // com.baidu.webkit.net.INetListener
        public void onNetResponseCode(BdNet bdNet, BdNetTask bdNetTask, int i) {
        }

        @Override // com.baidu.webkit.net.INetListener
        public void onNetStateChanged(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetState netState, int i) {
        }

        @Override // com.baidu.webkit.net.INetListener
        public void onNetTaskComplete(BdNet bdNet, BdNetTask bdNetTask) {
            if (this.agZ != null) {
                try {
                    String byteArrayOutputStream = this.agZ.toString("utf-8");
                    Log.d(EngineManager.LOG_TAG, "received data = " + byteArrayOutputStream);
                    if (byteArrayOutputStream.length() > 0) {
                        JSONObject jSONObject = new JSONObject(byteArrayOutputStream);
                        if (jSONObject.has("data")) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                            if (jSONObject2.has("version")) {
                                a.this.f1663b = jSONObject2.getString("version");
                            }
                            if (jSONObject2.has("link")) {
                                a.this.f1662a = jSONObject2.getString("link");
                            }
                            if (jSONObject2.has("md5")) {
                                a.this.c = jSONObject2.getString("md5");
                            }
                        }
                    }
                } catch (Exception e) {
                }
            }
            Log.i(EngineManager.LOG_TAG, "check received data");
            release();
            a.this.b();
        }

        @Override // com.baidu.webkit.net.INetListener
        public void onNetTaskStart(BdNet bdNet, BdNetTask bdNetTask) {
        }

        @Override // com.baidu.webkit.net.INetListener
        public void onNetUploadComplete(BdNet bdNet, BdNetTask bdNetTask) {
        }

        @Override // com.baidu.webkit.net.INetListener
        public void onNetUploadData(BdNet bdNet, BdNetTask bdNetTask, int i, int i2) {
        }

        public void release() {
            if (this.agZ != null) {
                try {
                    this.agZ.reset();
                    this.agZ.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            this.agZ = null;
        }
    }

    protected a() {
    }

    private static PackageInfo V(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(String str, Context context) {
        if (TextUtils.isEmpty(str) || context == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        String zeusVersionByUpdate = WebKitVersionBlink.getZeusVersionByUpdate();
        String sdkVersionName = WebKitFactory.getSdkVersionName();
        Log.w("sdk in=" + zeusVersionByUpdate);
        Log.w("sdk out=" + sdkVersionName);
        sb.append(zeusVersionByUpdate);
        sb.append(ETAG.ITEM_SEPARATOR);
        if (!TextUtils.isEmpty(sdkVersionName)) {
            a(sb, CashierData.SDK, sdkVersionName);
        }
        String cuid = BdSailorPlatform.getInstance().getCuid();
        String b2 = !TextUtils.isEmpty(cuid) ? com.baidu.browser.sailor.util.b.b(cuid) : "";
        if (!TextUtils.isEmpty(b2)) {
            a(sb, "cuid", b2);
        }
        String str2 = Build.MODEL;
        String str3 = Build.VERSION.RELEASE;
        int i = Build.VERSION.SDK_INT;
        String str4 = Build.MANUFACTURER;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str2.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER));
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(str3);
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(i);
        stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        stringBuffer.append(str4.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER));
        String b3 = com.baidu.browser.sailor.util.b.b(stringBuffer.toString().replace(" ", Constants.ACCEPT_TIME_SEPARATOR_SERVER));
        if (!TextUtils.isEmpty(b3)) {
            a(sb, "dev", b3);
        }
        String packageName = context.getPackageName();
        if (!TextUtils.isEmpty(packageName)) {
            a(sb, "app", packageName);
        }
        PackageInfo V = V(context);
        if (V != null) {
            String str5 = V.versionName;
            if (!TextUtils.isEmpty(str5)) {
                a(sb, "appversion", str5);
            }
        }
        String b4 = b(context);
        if (!TextUtils.isEmpty(b4)) {
            sb.append("from");
            sb.append("=");
            sb.append(b4);
        }
        if (!BdZeusUtil.isWebkitLoaded()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append("nozeus");
            sb.append("=");
            sb.append("1");
        }
        Log.i(EngineManager.LOG_TAG, "startCheck url = " + sb.toString());
        return sb.toString();
    }

    private static void a(StringBuilder sb, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        sb.append(str);
        sb.append("=");
        sb.append(str2);
        sb.append(ETAG.ITEM_SEPARATOR);
    }

    private static boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        long[] jArr = new long[8];
        for (int i = 0; i < 8; i++) {
            jArr[i] = 0;
        }
        try {
            String[] split = str.split("\\.", 4);
            String[] split2 = str2.split("\\.", 4);
            jArr[0] = Long.parseLong(split[0]);
            jArr[1] = Long.parseLong(split[1]);
            jArr[2] = Long.parseLong(split[2]);
            jArr[3] = Long.parseLong(split[3]);
            jArr[4] = Long.parseLong(split2[0]);
            jArr[5] = Long.parseLong(split2[1]);
            jArr[6] = Long.parseLong(split2[2]);
            jArr[7] = Long.parseLong(split2[3]);
        } catch (Throwable th) {
        }
        return jArr[0] == jArr[4] && jArr[1] <= jArr[5] && jArr[2] == jArr[6] && jArr[3] < jArr[7];
    }

    private static String b(Context context) {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        try {
            inputStream = context.getResources().openRawResource(context.getResources().getIdentifier("tnconfig", "raw", context.getPackageName()));
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
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
                    } catch (Exception e) {
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            return trim;
                        } catch (Exception e2) {
                            return trim;
                        }
                    }
                    return trim;
                } catch (Exception e3) {
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (Exception e4) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e5) {
                        }
                    }
                    return "1200a";
                } catch (Throwable th) {
                    th = th;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e6) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e7) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e8) {
                byteArrayOutputStream2 = null;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
            }
        } catch (Exception e9) {
            byteArrayOutputStream2 = null;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            inputStream = null;
        }
    }

    public static a sZ() {
        if (agY == null) {
            synchronized (a.class) {
                if (agY == null) {
                    agY = new a();
                }
            }
        }
        return agY;
    }

    public final void a(Context context) {
        ZeusThreadPoolUtil.executeIgnoreZeus(new c(this, context));
    }

    protected final void b() {
        String GetCloudSettingsValue;
        boolean z = true;
        if (BdSailor.getInstance().getAppContext() != null) {
            String zeusVersionName = WebKitFactory.getZeusVersionName();
            if (WebKitFactory.getCurEngine() == 1) {
                if (a(zeusVersionName, this.f1663b)) {
                    BdZeusDownloadHelper.U(BdSailor.getInstance().getAppContext()).a(this.f1662a, this.c);
                    return;
                }
                return;
            }
            String packageName = BdSailor.getInstance().getAppContext().getPackageName();
            if (packageName == null || !packageName.equalsIgnoreCase(BdSailorPlatform.LITE_PACKAGE_NAME)) {
                z = false;
            }
            if (z) {
                try {
                    float sX = com.baidu.browser.core.util.a.sX() / 1024.0f;
                    if (sX < (TextUtils.isEmpty(WebSettingsGlobalBlink.GetCloudSettingsValue("update_zeus_mem_size_mb")) ? 1024 : Integer.valueOf(GetCloudSettingsValue).intValue())) {
                        return;
                    }
                    BdSailorPlatform.getStatic().b("MemMbSize", String.valueOf(sX));
                } catch (Exception e) {
                }
            }
            BdSailorPlatform.getStatic().b("download-webkit-start", String.valueOf(System.currentTimeMillis()));
            BdSailorPlatform.getStatic().a();
            Log.i(EngineManager.LOG_TAG, "start download zeus");
            BdZeusDownloadHelper.U(BdSailor.getInstance().getAppContext()).a(this.f1662a, this.c);
        }
    }
}
