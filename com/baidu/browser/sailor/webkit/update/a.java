package com.baidu.browser.sailor.webkit.update;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.ar.parser.ARResourceKey;
import com.baidu.ar.util.IoUtils;
import com.baidu.browser.sailor.util.c;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthDef;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.internal.blink.EngineManager;
import com.baidu.webkit.internal.blink.WebKitVersionBlink;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
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
/* loaded from: classes2.dex */
public class a {
    private static a Xc = null;
    protected String a;
    protected String b;
    protected String c;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.browser.sailor.webkit.update.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0068a extends BdNetTask implements INetListener {
        protected ByteArrayOutputStream mOutputStream;

        public C0068a(Context context, String str) {
            setUrl(a.a(str, context));
            setMethod(BdNet.HttpMethod.METHOD_GET);
        }

        @Override // com.baidu.webkit.net.INetListener
        public void onNetDownloadComplete(BdNet bdNet) {
        }

        @Override // com.baidu.webkit.net.INetListener
        public void onNetDownloadError(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetError netError, int i) {
            this.mOutputStream.reset();
        }

        @Override // com.baidu.webkit.net.INetListener
        public void onNetReceiveData(BdNet bdNet, BdNetTask bdNetTask, byte[] bArr, int i) {
            if (this.mOutputStream == null) {
                this.mOutputStream = new ByteArrayOutputStream();
            }
            if (i > 0) {
                this.mOutputStream.write(bArr, 0, i);
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
            if (this.mOutputStream != null) {
                try {
                    String byteArrayOutputStream = this.mOutputStream.toString(IoUtils.UTF_8);
                    Log.d(EngineManager.LOG_TAG, "received data = " + byteArrayOutputStream);
                    if (byteArrayOutputStream.length() > 0) {
                        JSONObject jSONObject = new JSONObject(byteArrayOutputStream);
                        if (jSONObject.has("data")) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                            if (jSONObject2.has("version")) {
                                a.this.b = jSONObject2.getString("version");
                            }
                            if (jSONObject2.has(SelectForumActivityConfig.KEY_SHARE_LINK)) {
                                a.this.a = jSONObject2.getString(SelectForumActivityConfig.KEY_SHARE_LINK);
                            }
                            if (jSONObject2.has(ARResourceKey.HTTP_AR_MD5)) {
                                a.this.c = jSONObject2.getString(ARResourceKey.HTTP_AR_MD5);
                            }
                        }
                    }
                } catch (Exception e) {
                }
            }
            Log.d(EngineManager.LOG_TAG, "check received data");
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
            if (this.mOutputStream != null) {
                try {
                    this.mOutputStream.reset();
                    this.mOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            this.mOutputStream = null;
        }
    }

    protected a() {
    }

    private static String a(Context context) {
        InputStream inputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream2;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
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
                    inputStream2 = inputStream;
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (Exception e4) {
                        }
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Exception e5) {
                        }
                    }
                    return "1200a";
                } catch (Throwable th2) {
                    th = th2;
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
                inputStream2 = inputStream;
            } catch (Throwable th3) {
                byteArrayOutputStream = null;
                th = th3;
            }
        } catch (Exception e9) {
            inputStream2 = null;
        } catch (Throwable th4) {
            inputStream = null;
            th = th4;
            byteArrayOutputStream = null;
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
            a(sb, "sdk", sdkVersionName);
        }
        String cuid = com.baidu.browser.sailor.b.a.qO().getCuid();
        String b = !TextUtils.isEmpty(cuid) ? c.b(cuid) : "";
        if (!TextUtils.isEmpty(b)) {
            a(sb, "cuid", b);
        }
        String str2 = Build.MODEL;
        String str3 = Build.VERSION.RELEASE;
        int i = Build.VERSION.SDK_INT;
        String str4 = Build.MANUFACTURER;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str2.replace(BaseRequestAction.SPLITE, Constants.ACCEPT_TIME_SEPARATOR_SERVER));
        stringBuffer.append(BaseRequestAction.SPLITE);
        stringBuffer.append(str3);
        stringBuffer.append(BaseRequestAction.SPLITE);
        stringBuffer.append(i);
        stringBuffer.append(BaseRequestAction.SPLITE);
        stringBuffer.append(str4.replace(BaseRequestAction.SPLITE, Constants.ACCEPT_TIME_SEPARATOR_SERVER));
        String b2 = c.b(stringBuffer.toString().replace(" ", Constants.ACCEPT_TIME_SEPARATOR_SERVER));
        if (!TextUtils.isEmpty(b2)) {
            a(sb, OAuthDef.TPL, b2);
        }
        String packageName = context.getPackageName();
        if (!TextUtils.isEmpty(packageName)) {
            a(sb, "app", packageName);
        }
        String str5 = bd(context).versionName;
        if (!TextUtils.isEmpty(str5)) {
            a(sb, ETAG.KEY_APP_VERSION, str5);
        }
        String a = a(context);
        if (!TextUtils.isEmpty(a)) {
            sb.append("from");
            sb.append(ETAG.EQUAL);
            sb.append(a);
        }
        if (!com.baidu.browser.sailor.util.a.qU()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append("nozeus");
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        Log.d(EngineManager.LOG_TAG, "startCheck url = " + sb.toString());
        return sb.toString();
    }

    private static void a(StringBuilder sb, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        sb.append(str);
        sb.append(ETAG.EQUAL);
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

    private static PackageInfo bd(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static a re() {
        if (Xc == null) {
            synchronized (a.class) {
                if (Xc == null) {
                    Xc = new a();
                }
            }
        }
        return Xc;
    }

    protected final void b() {
        String GetCloudSettingsValue;
        boolean z = true;
        if (com.baidu.browser.sailor.a.qn().getAppContext() != null) {
            String zeusVersionName = WebKitFactory.getZeusVersionName();
            if (WebKitFactory.getCurEngine() == 1) {
                if (a(zeusVersionName, this.b)) {
                    Log.d(EngineManager.LOG_TAG, "start download update zeus");
                    BdZeusDownloadHelper.bc(com.baidu.browser.sailor.a.qn().getAppContext()).W(this.a, this.c);
                    return;
                }
                return;
            }
            String packageName = com.baidu.browser.sailor.a.qn().getAppContext().getPackageName();
            if (packageName == null || !packageName.equalsIgnoreCase("com.baidu.searchbox.lite")) {
                z = false;
            }
            if (z) {
                try {
                    float qm = com.baidu.browser.core.util.a.qm() / 1024.0f;
                    if (qm < (TextUtils.isEmpty(WebSettingsGlobalBlink.GetCloudSettingsValue("update_zeus_mem_size_mb")) ? 1024 : Integer.valueOf(GetCloudSettingsValue).intValue())) {
                        return;
                    }
                    com.baidu.browser.sailor.b.a.qP().b("MemMbSize", String.valueOf(qm));
                } catch (Exception e) {
                }
            }
            com.baidu.browser.sailor.b.a.qP().b("download-webkit-start", String.valueOf(System.currentTimeMillis()));
            com.baidu.browser.sailor.b.a.qP().a();
            Log.d(EngineManager.LOG_TAG, "start download zeus");
            BdZeusDownloadHelper.bc(com.baidu.browser.sailor.a.qn().getAppContext()).W(this.a, this.c);
        }
    }
}
