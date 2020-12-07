package com.baidu.sapi2.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Xml;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.SocialType;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3543a = "d";
    private static final String b = "file:///android_asset/";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WebView f3544a;
        final /* synthetic */ String b;
        final /* synthetic */ com.baidu.sapi2.callback.a.a c;

        /* renamed from: com.baidu.sapi2.utils.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        class C0354a implements ValueCallback<String> {
            C0354a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.webkit.ValueCallback
            /* renamed from: a */
            public void onReceiveValue(String str) {
                a.this.c.a(str);
                a.this.f3544a.destroy();
            }
        }

        a(WebView webView, String str, com.baidu.sapi2.callback.a.a aVar) {
            this.f3544a = webView;
            this.b = str;
            this.c = aVar;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (Build.VERSION.SDK_INT >= 19) {
                this.f3544a.evaluateJavascript(this.b, new C0354a());
                return;
            }
            this.c.a(null);
            this.f3544a.destroy();
        }
    }

    public static InputStream a(Context context, String str) {
        InputStream fileInputStream;
        try {
            if (str.startsWith(b)) {
                fileInputStream = context.getAssets().open(str.replace(b, ""));
            } else {
                fileInputStream = new FileInputStream(str);
            }
            return fileInputStream;
        } catch (Exception e) {
            return null;
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 10) {
            return null;
        }
        String str2 = "";
        HashMap hashMap = new HashMap();
        hashMap.put("r", 4);
        hashMap.put("w", 2);
        hashMap.put("x", 1);
        hashMap.put(Constants.ACCEPT_TIME_SEPARATOR_SERVER, 0);
        int i = 1;
        int i2 = 0;
        while (i < 10) {
            int i3 = i + 1;
            Integer num = (Integer) hashMap.get(str.substring(i, i3));
            if (num == null) {
                return null;
            }
            int intValue = num.intValue() + i2;
            if (i % 3 == 0) {
                str2 = str2 + intValue;
                intValue = 0;
            }
            i = i3;
            i2 = intValue;
        }
        if (str2.length() != 3) {
            return null;
        }
        return str2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [42=4] */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c2, code lost:
        if (r1 == null) goto L20;
     */
    /* JADX WARN: Not initialized variable reg: 0, insn: 0x0122: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r0 I:??[OBJECT, ARRAY]), block:B:54:0x0121 */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a3 A[Catch: Exception -> 0x0117, all -> 0x0125, TRY_LEAVE, TryCatch #6 {Exception -> 0x0117, all -> 0x0125, blocks: (B:5:0x000d, B:7:0x0017, B:9:0x001d, B:12:0x003b, B:13:0x0054, B:16:0x006b, B:18:0x0081, B:20:0x00a3, B:32:0x00cd, B:34:0x00da), top: B:69:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00be A[Catch: Exception -> 0x011b, all -> 0x0128, TRY_LEAVE, TryCatch #7 {Exception -> 0x011b, all -> 0x0128, blocks: (B:21:0x00a7, B:23:0x00b5, B:25:0x00be), top: B:67:0x00a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x012e  */
    @TargetApi(4)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context, File file) {
        Process process;
        Exception e;
        Process process2;
        Process process3;
        int i;
        String str;
        String str2;
        String str3 = null;
        try {
            try {
                Runtime runtime = Runtime.getRuntime();
                String packageName = context.getPackageName();
                Process process4 = null;
                while (!packageName.equals(file.getName())) {
                    try {
                        process2 = file.isDirectory() ? runtime.exec("chmod 701 " + file) : runtime.exec("chmod 664 " + file);
                        try {
                            file = file.getParentFile();
                            process4 = process2;
                        } catch (Exception e2) {
                            e = e2;
                            Log.e(e);
                            if (process2 == null) {
                                process = process2;
                                i = -1;
                                process.destroy();
                                return i != 0;
                            }
                            i = -1;
                            if (i != 0) {
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        process2 = process4;
                    } catch (Throwable th) {
                        th = th;
                        process = process4;
                    }
                }
                String b2 = b(a(context.getApplicationInfo().dataDir));
                if (TextUtils.isEmpty(b2)) {
                    b2 = "701";
                    str2 = "chmod 701 " + file;
                } else if (b2.substring(2, 3).equals("0")) {
                    str2 = "chmod " + b2.substring(0, 2) + "1 " + file;
                } else {
                    str = b2;
                    Log.e(f3543a, "chmodFile", "command", str3, "originPer", str);
                    if (str3 == null) {
                        process = runtime.exec(str3);
                        try {
                            if (TextUtils.isEmpty(SapiContext.getInstance().getPackageDirExecutePer())) {
                                SapiContext.getInstance().setPackageDirExecutePer(str);
                            }
                        } catch (Exception e4) {
                            process2 = process;
                            e = e4;
                            Log.e(e);
                            if (process2 == null) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (process != null) {
                                process.destroy();
                            }
                            throw th;
                        }
                    } else {
                        process = process4;
                    }
                    i = process == null ? process.waitFor() : -1;
                }
                str3 = str2;
                str = b2;
                Log.e(f3543a, "chmodFile", "command", str3, "originPer", str);
                if (str3 == null) {
                }
                if (process == null) {
                }
            } catch (Throwable th3) {
                process = process3;
                th = th3;
            }
        } catch (Exception e5) {
            e = e5;
            process2 = null;
        } catch (Throwable th4) {
            th = th4;
            process = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [125=4] */
    public static SapiAccountResponse b(String str, String str2) {
        SapiAccountResponse sapiAccountResponse;
        Throwable th;
        XmlPullParser newPullParser;
        int eventType;
        SapiAccountResponse sapiAccountResponse2;
        boolean z;
        SapiAccountResponse sapiAccountResponse3 = null;
        String a2 = a("<client>([\\S\\s]*?)</client>", str2);
        if (!TextUtils.isEmpty(a2)) {
            try {
                newPullParser = Xml.newPullParser();
                newPullParser.setInput(new ByteArrayInputStream(a2.getBytes()), "UTF-8");
                eventType = newPullParser.getEventType();
                sapiAccountResponse2 = null;
                z = false;
            } catch (Throwable th2) {
                sapiAccountResponse = null;
                th = th2;
            }
            while (eventType != 1) {
                if (eventType == 2) {
                    try {
                        String name = newPullParser.getName();
                        if (!name.equalsIgnoreCase("data")) {
                            if (sapiAccountResponse2 == null && name.equalsIgnoreCase("error_code")) {
                                sapiAccountResponse = new SapiAccountResponse();
                                try {
                                    sapiAccountResponse.errorCode = Integer.parseInt(newPullParser.nextText());
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            } else if (sapiAccountResponse2 == null && name.equalsIgnoreCase("error_description")) {
                                sapiAccountResponse = new SapiAccountResponse();
                                sapiAccountResponse.errorMsg = newPullParser.nextText();
                            } else if (sapiAccountResponse2 != null) {
                                if (name.equalsIgnoreCase(BaseJsonData.TAG_ERRNO)) {
                                    sapiAccountResponse2.errorCode = Integer.parseInt(newPullParser.nextText());
                                } else if (name.equalsIgnoreCase(BdStatsConstant.StatsKey.UNAME)) {
                                    sapiAccountResponse2.username = newPullParser.nextText();
                                } else if (name.equalsIgnoreCase(BaseJsonData.TAG_ERRMSG)) {
                                    sapiAccountResponse2.errorMsg = newPullParser.nextText();
                                } else if (name.equalsIgnoreCase("bduss")) {
                                    sapiAccountResponse2.bduss = newPullParser.nextText();
                                } else if (name.equalsIgnoreCase("ptoken")) {
                                    sapiAccountResponse2.ptoken = newPullParser.nextText();
                                } else if (name.equalsIgnoreCase("stoken")) {
                                    if (z) {
                                        String[] split = newPullParser.nextText().split("#");
                                        if (split != null && split.length > 1) {
                                            sapiAccountResponse2.tplStokenMap.put(split[0], split[1]);
                                        }
                                    } else {
                                        sapiAccountResponse2.stoken = newPullParser.nextText();
                                    }
                                } else if (name.equalsIgnoreCase(SapiAccountManager.SESSION_DISPLAYNAME)) {
                                    sapiAccountResponse2.displayname = newPullParser.nextText();
                                } else if (name.equalsIgnoreCase("uid")) {
                                    sapiAccountResponse2.uid = newPullParser.nextText();
                                } else if (name.equalsIgnoreCase("authsid")) {
                                    sapiAccountResponse2.authSid = newPullParser.nextText();
                                    sapiAccountResponse2.newReg = !TextUtils.isEmpty(sapiAccountResponse2.authSid);
                                } else if (name.equalsIgnoreCase("stoken_list")) {
                                    z = true;
                                    sapiAccountResponse = sapiAccountResponse2;
                                } else if (name.equalsIgnoreCase("os_headurl")) {
                                    sapiAccountResponse2.socialPortraitUrl = newPullParser.nextText();
                                } else if (name.equalsIgnoreCase(HttpConstants.HTTP_OS_TYPE)) {
                                    sapiAccountResponse2.socialType = SocialType.getSocialType(Integer.parseInt(newPullParser.nextText()));
                                } else if (name.equalsIgnoreCase("incomplete_user")) {
                                    String nextText = newPullParser.nextText();
                                    if ("0".equals(nextText)) {
                                        sapiAccountResponse2.accountType = AccountType.NORMAL;
                                    } else if ("1".equals(nextText)) {
                                        sapiAccountResponse2.accountType = AccountType.INCOMPLETE_USER;
                                    } else {
                                        sapiAccountResponse2.accountType = AccountType.UNKNOWN;
                                    }
                                } else if (name.equalsIgnoreCase("actiontype")) {
                                    sapiAccountResponse2.actionType = newPullParser.nextText();
                                } else if (name.equals("livinguname")) {
                                    sapiAccountResponse2.livingUname = URLDecoder.decode(newPullParser.nextText());
                                } else if ("loginType".equals(name)) {
                                    String nextText2 = newPullParser.nextText();
                                    if ("oneKeyLogin".equals(nextText2) || "business_from_one_key_login".equals(str)) {
                                        nextText2 = new OneKeyLoginSdkCall().c();
                                    }
                                    SapiContext.getInstance().put(SapiContext.KEY_PRE_LOGIN_TYPE, nextText2);
                                } else if (name.equals("mobilephone")) {
                                    SapiContext.getInstance().putEncryptStr(SapiContext.KEY_LAST_LOGIN_PHONE, newPullParser.nextText());
                                } else if (name.equals("app")) {
                                    sapiAccountResponse2.app = newPullParser.nextText();
                                } else if (name.equals("extra")) {
                                    sapiAccountResponse2.extra = newPullParser.nextText();
                                }
                            }
                            SapiAccountResponse sapiAccountResponse4 = sapiAccountResponse;
                            eventType = newPullParser.next();
                            sapiAccountResponse2 = sapiAccountResponse4;
                        } else if (sapiAccountResponse2 == null) {
                            sapiAccountResponse = new SapiAccountResponse();
                            SapiAccountResponse sapiAccountResponse42 = sapiAccountResponse;
                            eventType = newPullParser.next();
                            sapiAccountResponse2 = sapiAccountResponse42;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        sapiAccountResponse = sapiAccountResponse2;
                    }
                    th = th3;
                    Log.e(th);
                    sapiAccountResponse3 = sapiAccountResponse;
                    if (sapiAccountResponse3 != null && !TextUtils.isEmpty(sapiAccountResponse3.bduss) && sapiAccountResponse3.errorCode == -100) {
                        sapiAccountResponse3.errorCode = 0;
                    }
                }
                sapiAccountResponse = sapiAccountResponse2;
                SapiAccountResponse sapiAccountResponse422 = sapiAccountResponse;
                eventType = newPullParser.next();
                sapiAccountResponse2 = sapiAccountResponse422;
            }
            sapiAccountResponse3 = sapiAccountResponse2;
            if (sapiAccountResponse3 != null) {
                sapiAccountResponse3.errorCode = 0;
            }
        }
        return sapiAccountResponse3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [63=4] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x003f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str) {
        Process process;
        Throwable th;
        BufferedReader bufferedReader;
        String str2 = null;
        try {
            process = Runtime.getRuntime().exec("ls -ld " + str);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            } catch (IOException e) {
                bufferedReader = null;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e2) {
                    }
                }
                if (process != null) {
                    process.destroy();
                }
                return str2;
            } catch (Throwable th2) {
                th = th2;
                th = th;
                bufferedReader = null;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e3) {
                    }
                }
                if (process != null) {
                    process.destroy();
                }
                throw th;
            }
        } catch (IOException e4) {
            process = null;
        } catch (Throwable th3) {
            th = th3;
            process = null;
        }
        try {
            str2 = bufferedReader.readLine();
            try {
                bufferedReader.close();
            } catch (Exception e5) {
            }
            if (process != null) {
                process.destroy();
            }
        } catch (IOException e6) {
            if (bufferedReader != null) {
            }
            if (process != null) {
            }
            return str2;
        } catch (Throwable th4) {
            th = th4;
            if (bufferedReader != null) {
            }
            if (process != null) {
            }
            throw th;
        }
        return str2;
    }

    public static String a(String str, String str2) {
        String str3 = "";
        Pattern compile = Pattern.compile(str);
        if (!TextUtils.isEmpty(str2)) {
            Matcher matcher = compile.matcher(str2);
            while (matcher.find()) {
                str3 = matcher.group();
            }
        }
        return str3;
    }

    public static void a(String str, String str2, String str3, Context context, com.baidu.sapi2.callback.a.a aVar) {
        WebView webView = new WebView(context);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadDataWithBaseURL("", "<html><head><meta charset=\"utf-8\"><script> " + str + str2 + " </script></head></html>", "text/html", "UTF-8", "");
        webView.setWebViewClient(new a(webView, "javascript:moonshade(" + str3 + ")", aVar));
    }
}
