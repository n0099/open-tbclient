package com.baidu.sapi2.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Xml;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.wallet.api.IWalletLoginListener;
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
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final String f11455a = "e";

    /* renamed from: b  reason: collision with root package name */
    public static final String f11456b = "file:///android_asset/";

    /* loaded from: classes2.dex */
    public static class a extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WebView f11457a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f11458b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ com.baidu.sapi2.callback.a.a f11459c;

        /* renamed from: com.baidu.sapi2.utils.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0147a implements ValueCallback<String> {
            public C0147a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.webkit.ValueCallback
            /* renamed from: a */
            public void onReceiveValue(String str) {
                a.this.f11459c.a(str);
                a.this.f11457a.destroy();
            }
        }

        public a(WebView webView, String str, com.baidu.sapi2.callback.a.a aVar) {
            this.f11457a = webView;
            this.f11458b = str;
            this.f11459c = aVar;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (Build.VERSION.SDK_INT >= 19) {
                this.f11457a.evaluateJavascript(this.f11458b, new C0147a());
                return;
            }
            this.f11459c.a(null);
            this.f11457a.destroy();
        }
    }

    public static InputStream a(Context context, String str) {
        InputStream fileInputStream;
        try {
            if (str.startsWith("file:///android_asset/")) {
                fileInputStream = context.getAssets().open(str.replace("file:///android_asset/", ""));
            } else {
                fileInputStream = new FileInputStream(str);
            }
            return fileInputStream;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 10) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(r.f7664a, 4);
        hashMap.put("w", 2);
        int i = 1;
        hashMap.put("x", 1);
        hashMap.put("-", 0);
        String str2 = "";
        int i2 = 0;
        while (i < 10) {
            int i3 = i + 1;
            Integer num = (Integer) hashMap.get(str.substring(i, i3));
            if (num == null) {
                return null;
            }
            i2 += num.intValue();
            if (i % 3 == 0) {
                str2 = str2 + i2;
                i2 = 0;
            }
            i = i3;
        }
        if (str2.length() != 3) {
            return null;
        }
        return str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00dd, code lost:
        if (r1 != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ec, code lost:
        if (r1 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ee, code lost:
        r1.destroy();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00f1, code lost:
        if (r3 != 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00f4, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:?, code lost:
        return true;
     */
    @TargetApi(4)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context, File file) {
        Process process = null;
        String str = null;
        Process process2 = null;
        try {
            try {
                Runtime runtime = Runtime.getRuntime();
                String packageName = context.getPackageName();
                Process process3 = null;
                while (!packageName.equals(file.getName())) {
                    try {
                        if (file.isDirectory()) {
                            process3 = runtime.exec("chmod 701 " + file);
                        } else {
                            process3 = runtime.exec("chmod 664 " + file);
                        }
                        file = file.getParentFile();
                    } catch (Exception e2) {
                        e = e2;
                        process = process3;
                        Log.e(e);
                    } catch (Throwable th) {
                        th = th;
                        process2 = process3;
                        if (process2 != null) {
                            process2.destroy();
                        }
                        throw th;
                    }
                }
                String b2 = b(a(context.getApplicationInfo().dataDir));
                if (TextUtils.isEmpty(b2)) {
                    str = "chmod 701 " + file;
                    b2 = "701";
                } else if (b2.substring(2, 3).equals("0")) {
                    str = "chmod " + b2.substring(0, 2) + "1 " + file;
                }
                Log.e(f11455a, "chmodFile", "command", str, "originPer", b2);
                if (str != null) {
                    process = runtime.exec(str);
                    if (TextUtils.isEmpty(SapiContext.getInstance().getPackageDirExecutePer())) {
                        SapiContext.getInstance().setPackageDirExecutePer(b2);
                    }
                } else {
                    process = process3;
                }
                r3 = process != null ? process.waitFor() : -1;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0228  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SapiAccountResponse b(String str, String str2) {
        SapiAccountResponse sapiAccountResponse;
        String a2 = a("<client>([\\S\\s]*?)</client>", str2);
        SapiAccountResponse sapiAccountResponse2 = null;
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(new ByteArrayInputStream(a2.getBytes()), "UTF-8");
            boolean z = false;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if (!name.equalsIgnoreCase("data")) {
                        if (sapiAccountResponse2 == null && name.equalsIgnoreCase("error_code")) {
                            sapiAccountResponse = new SapiAccountResponse();
                            try {
                                sapiAccountResponse.errorCode = Integer.parseInt(newPullParser.nextText());
                            } catch (Throwable th) {
                                th = th;
                                sapiAccountResponse2 = sapiAccountResponse;
                                Log.e(th);
                                if (sapiAccountResponse2 != null) {
                                    sapiAccountResponse2.errorCode = 0;
                                }
                                return sapiAccountResponse2;
                            }
                        } else if (sapiAccountResponse2 == null && name.equalsIgnoreCase("error_description")) {
                            sapiAccountResponse = new SapiAccountResponse();
                            sapiAccountResponse.errorMsg = newPullParser.nextText();
                        } else if (sapiAccountResponse2 != null) {
                            if (name.equalsIgnoreCase("errno")) {
                                sapiAccountResponse2.errorCode = Integer.parseInt(newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("uname")) {
                                sapiAccountResponse2.username = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("errmsg")) {
                                sapiAccountResponse2.errorMsg = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("bduss")) {
                                sapiAccountResponse2.bduss = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase(SapiAccount.f10606h)) {
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
                            } else if (name.equalsIgnoreCase("displayname")) {
                                sapiAccountResponse2.displayname = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("uid")) {
                                sapiAccountResponse2.uid = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("authsid")) {
                                String nextText = newPullParser.nextText();
                                sapiAccountResponse2.authSid = nextText;
                                sapiAccountResponse2.newReg = !TextUtils.isEmpty(nextText);
                            } else if (name.equalsIgnoreCase("stoken_list")) {
                                z = true;
                            } else if (name.equalsIgnoreCase("os_headurl")) {
                                sapiAccountResponse2.socialPortraitUrl = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("os_type")) {
                                sapiAccountResponse2.socialType = SocialType.getSocialType(Integer.parseInt(newPullParser.nextText()));
                            } else if (name.equalsIgnoreCase("incomplete_user")) {
                                String nextText2 = newPullParser.nextText();
                                if ("0".equals(nextText2)) {
                                    sapiAccountResponse2.accountType = AccountType.NORMAL;
                                } else if ("1".equals(nextText2)) {
                                    sapiAccountResponse2.accountType = AccountType.INCOMPLETE_USER;
                                } else {
                                    sapiAccountResponse2.accountType = AccountType.UNKNOWN;
                                }
                            } else if (name.equalsIgnoreCase("actiontype")) {
                                sapiAccountResponse2.actionType = newPullParser.nextText();
                            } else if (name.equals("livinguname")) {
                                sapiAccountResponse2.livingUname = URLDecoder.decode(newPullParser.nextText());
                            } else if (IWalletLoginListener.KEY_LOGIN_TYPE.equals(name)) {
                                String nextText3 = newPullParser.nextText();
                                if ("oneKeyLogin".equals(nextText3) || "business_from_one_key_login".equals(str)) {
                                    nextText3 = new OneKeyLoginSdkCall().getOperatorType();
                                }
                                SapiContext.getInstance().put(SapiContext.KEY_PRE_LOGIN_TYPE, nextText3);
                            } else if (name.equals("mobilephone")) {
                                SapiContext.getInstance().putEncryptStr(SapiContext.KEY_LAST_LOGIN_PHONE, newPullParser.nextText());
                            } else if (name.equals("app")) {
                                sapiAccountResponse2.app = newPullParser.nextText();
                            } else if (name.equals("extra")) {
                                sapiAccountResponse2.extra = newPullParser.nextText();
                            }
                        }
                        sapiAccountResponse2 = sapiAccountResponse;
                    } else if (sapiAccountResponse2 == null) {
                        sapiAccountResponse = new SapiAccountResponse();
                        sapiAccountResponse2 = sapiAccountResponse;
                    }
                }
                try {
                } catch (Throwable th2) {
                    th = th2;
                    sapiAccountResponse = sapiAccountResponse2;
                    sapiAccountResponse2 = sapiAccountResponse;
                    Log.e(th);
                    if (sapiAccountResponse2 != null) {
                    }
                    return sapiAccountResponse2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
        if (sapiAccountResponse2 != null && !TextUtils.isEmpty(sapiAccountResponse2.bduss) && sapiAccountResponse2.errorCode == -100) {
            sapiAccountResponse2.errorCode = 0;
        }
        return sapiAccountResponse2;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str) {
        Throwable th;
        Process process;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            process = Runtime.getRuntime().exec("ls -ld " + str);
        } catch (IOException unused) {
            process = null;
        } catch (Throwable th2) {
            th = th2;
            process = null;
        }
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            try {
                String readLine = bufferedReader.readLine();
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
                if (process != null) {
                    process.destroy();
                }
                return readLine;
            } catch (IOException unused3) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused4) {
                    }
                }
                if (process != null) {
                    process.destroy();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception unused5) {
                    }
                }
                if (process != null) {
                    process.destroy();
                }
                throw th;
            }
        } catch (IOException unused6) {
            bufferedReader = null;
            if (bufferedReader != null) {
            }
            if (process != null) {
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static String a(String str, String str2) {
        Pattern compile = Pattern.compile(str);
        String str3 = "";
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        Matcher matcher = compile.matcher(str2);
        while (matcher.find()) {
            str3 = matcher.group();
        }
        return str3;
    }

    public static void a(String str, String str2, String str3, Context context, com.baidu.sapi2.callback.a.a aVar) {
        WebView webView = new WebView(context);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadDataWithBaseURL("", "<html><head><meta charset=\"utf-8\"><script> " + str + str2 + " </script></head></html>", SapiWebView.K, "UTF-8", "");
        StringBuilder sb = new StringBuilder();
        sb.append("javascript:moonshade(");
        sb.append(str3);
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        webView.setWebViewClient(new a(webView, sb.toString(), aVar));
    }
}
