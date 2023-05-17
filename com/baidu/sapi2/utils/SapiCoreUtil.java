package com.baidu.sapi2.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Xml;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.inner.ExecuteJsCallback;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.Enums;
import com.baidu.sapi2.utils.enums.FromType;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.core.data.SmallTailInfo;
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
/* loaded from: classes3.dex */
public class SapiCoreUtil {
    public static final String CUSTOM_THEME_SCHEMA = "file:///android_asset/";
    public static final String TAG = "SapiCoreUtil";

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00db, code lost:
        if (r1 != null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00dd, code lost:
        r1.destroy();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ed, code lost:
        if (r1 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f0, code lost:
        if (r3 != 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f3, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:?, code lost:
        return true;
     */
    @TargetApi(4)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean chmodFile(Context context, File file) {
        Process process = null;
        String str = null;
        process = null;
        int i = -1;
        try {
            try {
                Runtime runtime = Runtime.getRuntime();
                String packageName = context.getPackageName();
                Process process2 = null;
                while (!packageName.equals(file.getName())) {
                    try {
                        if (file.isDirectory()) {
                            process2 = runtime.exec("chmod 701 " + file);
                        } else {
                            process2 = runtime.exec("chmod 664 " + file);
                        }
                        file = file.getParentFile();
                    } catch (Exception e) {
                        e = e;
                        process = process2;
                        Log.e(e);
                    } catch (Throwable th) {
                        th = th;
                        process = process2;
                        if (process != null) {
                            process.destroy();
                        }
                        throw th;
                    }
                }
                String parseExecutePer = parseExecutePer(getExecResult(context.getApplicationInfo().dataDir));
                if (TextUtils.isEmpty(parseExecutePer)) {
                    parseExecutePer = "701";
                    str = "chmod 701 " + file;
                } else if (parseExecutePer.substring(2, 3).equals("0")) {
                    str = "chmod " + parseExecutePer.substring(0, 2) + "1 " + file;
                }
                Log.e(TAG, "chmodFile", "command", str, "originPer", parseExecutePer);
                if (str != null) {
                    process = runtime.exec(str);
                    if (TextUtils.isEmpty(SapiContext.getInstance().getPackageDirExecutePer())) {
                        SapiContext.getInstance().setPackageDirExecutePer(parseExecutePer);
                    }
                } else {
                    process = process2;
                }
                if (process != null) {
                    i = process.waitFor();
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void executeJsCode(String str, String str2, String str3, Context context, final ExecuteJsCallback executeJsCallback) {
        try {
            final WebView webView = new WebView(context);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadDataWithBaseURL("", "<html><head><meta charset=\"utf-8\"><script> " + str + str2 + " </script></head></html>", SapiWebView.DATA_MIME_TYPE, "UTF-8", "");
            StringBuilder sb = new StringBuilder();
            sb.append("javascript:moonshade(");
            sb.append(str3);
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            final String sb2 = sb.toString();
            webView.setWebViewClient(new WebViewClient() { // from class: com.baidu.sapi2.utils.SapiCoreUtil.1
                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView webView2, String str4) {
                    super.onPageFinished(webView2, str4);
                    if (Build.VERSION.SDK_INT >= 19) {
                        webView.evaluateJavascript(sb2, new ValueCallback<String>() { // from class: com.baidu.sapi2.utils.SapiCoreUtil.1.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // android.webkit.ValueCallback
                            public void onReceiveValue(String str5) {
                                executeJsCallback.jsExecuteCompleted(str5);
                                webView.destroy();
                            }
                        });
                        return;
                    }
                    executeJsCallback.jsExecuteCompleted(null);
                    webView.destroy();
                }
            });
        } catch (Exception unused) {
            if (executeJsCallback != null) {
                executeJsCallback.jsExecuteCompleted(null);
            }
        }
    }

    public static InputStream getCacheInputStream(Context context, String str) {
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

    public static String getMatcher(String str, String str2) {
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

    public static String getExecResult(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        Process process;
        try {
            process = Runtime.getRuntime().exec("ls -ld " + str);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                try {
                    String readLine = bufferedReader.readLine();
                    try {
                        bufferedReader.close();
                    } catch (Exception unused) {
                    }
                    if (process != null) {
                        process.destroy();
                    }
                    return readLine;
                } catch (IOException unused2) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused3) {
                        }
                    }
                    if (process != null) {
                        process.destroy();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused4) {
                        }
                    }
                    if (process != null) {
                        process.destroy();
                    }
                    throw th;
                }
            } catch (IOException unused5) {
                bufferedReader = null;
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
            }
        } catch (IOException unused6) {
            process = null;
            bufferedReader = null;
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
            process = null;
        }
    }

    public static SapiAccountResponse parseAccountXmlToResponse(String str, String str2) {
        SapiAccountResponse sapiAccountResponse;
        String matcher = getMatcher("<client>([\\S\\s]*?)</client>", str2);
        SapiAccountResponse sapiAccountResponse2 = null;
        if (TextUtils.isEmpty(matcher)) {
            return null;
        }
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(new ByteArrayInputStream(matcher.getBytes()), "UTF-8");
            int eventType = newPullParser.getEventType();
            boolean z = false;
            while (true) {
                boolean z2 = true;
                if (eventType == 1) {
                    break;
                }
                if (eventType != 2) {
                    continue;
                } else {
                    String name = newPullParser.getName();
                    if (name.equalsIgnoreCase("data")) {
                        if (sapiAccountResponse2 == null) {
                            sapiAccountResponse = new SapiAccountResponse();
                            sapiAccountResponse2 = sapiAccountResponse;
                            continue;
                        } else {
                            continue;
                        }
                    } else {
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
                        } else if (sapiAccountResponse2 == null) {
                            continue;
                        } else if (name.equalsIgnoreCase("errno")) {
                            sapiAccountResponse2.errorCode = Integer.parseInt(newPullParser.nextText());
                            continue;
                        } else if (name.equalsIgnoreCase("uname")) {
                            sapiAccountResponse2.username = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase("errmsg")) {
                            sapiAccountResponse2.errorMsg = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase("bduss")) {
                            sapiAccountResponse2.bduss = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase("ptoken")) {
                            sapiAccountResponse2.ptoken = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase("stoken")) {
                            if (z) {
                                String[] split = newPullParser.nextText().split("#");
                                if (split != null && split.length > 1) {
                                    sapiAccountResponse2.tplStokenMap.put(split[0], split[1]);
                                    continue;
                                }
                            } else {
                                sapiAccountResponse2.stoken = newPullParser.nextText();
                                continue;
                            }
                        } else if (name.equalsIgnoreCase("displayname")) {
                            sapiAccountResponse2.displayname = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase("uid")) {
                            sapiAccountResponse2.uid = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase("authsid")) {
                            String nextText = newPullParser.nextText();
                            sapiAccountResponse2.authSid = nextText;
                            if (TextUtils.isEmpty(nextText)) {
                                z2 = false;
                            }
                            sapiAccountResponse2.newReg = z2;
                            continue;
                        } else if (name.equalsIgnoreCase("stoken_list")) {
                            z = true;
                            continue;
                        } else if (name.equalsIgnoreCase("os_headurl")) {
                            sapiAccountResponse2.socialPortraitUrl = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase("os_name")) {
                            sapiAccountResponse2.socialNickname = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase("os_type")) {
                            sapiAccountResponse2.socialType = SocialType.getSocialType(Integer.parseInt(newPullParser.nextText()));
                            continue;
                        } else if (name.equalsIgnoreCase("incomplete_user")) {
                            String nextText2 = newPullParser.nextText();
                            if ("0".equals(nextText2)) {
                                sapiAccountResponse2.accountType = AccountType.NORMAL;
                                continue;
                            } else if ("1".equals(nextText2)) {
                                sapiAccountResponse2.accountType = AccountType.INCOMPLETE_USER;
                                continue;
                            } else {
                                sapiAccountResponse2.accountType = AccountType.UNKNOWN;
                                continue;
                            }
                        } else if (name.equalsIgnoreCase("actiontype")) {
                            sapiAccountResponse2.actionType = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase(SapiAccount.SAPI_ACCOUNT_FROMTYPE)) {
                            sapiAccountResponse2.fromType = FromType.getFromType(newPullParser.nextText());
                            continue;
                        } else if (name.equals("livinguname")) {
                            sapiAccountResponse2.livingUname = URLDecoder.decode(newPullParser.nextText());
                            continue;
                        } else if ("loginType".equals(name)) {
                            if ("oneKeyLogin".equals(newPullParser.nextText()) || "business_from_one_key_login".equals(str)) {
                                String operatorType = new OneKeyLoginSdkCall().getOperatorType();
                                if ("CM".equals(operatorType)) {
                                    SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.ONEKEYLOGIN_CM.getName());
                                    continue;
                                } else if ("CU".equals(operatorType)) {
                                    SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.ONEKEYLOGIN_CU.getName());
                                    continue;
                                } else if ("CT".equals(operatorType)) {
                                    SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.ONEKEYLOGIN_CT.getName());
                                    continue;
                                } else {
                                    continue;
                                }
                            }
                        } else if (name.equals("mobilephone")) {
                            SapiContext.getInstance().putEncryptStr(SapiContext.KEY_LAST_LOGIN_PHONE, newPullParser.nextText());
                            continue;
                        } else if (name.equals("app")) {
                            sapiAccountResponse2.app = newPullParser.nextText();
                            continue;
                        } else if (name.equals("extra")) {
                            sapiAccountResponse2.extra = newPullParser.nextText();
                            continue;
                        } else {
                            continue;
                        }
                        sapiAccountResponse2 = sapiAccountResponse;
                        continue;
                    }
                }
                eventType = newPullParser.next();
            }
        } catch (Throwable th2) {
            th = th2;
        }
        if (sapiAccountResponse2 != null && !TextUtils.isEmpty(sapiAccountResponse2.bduss) && sapiAccountResponse2.errorCode == -100) {
            sapiAccountResponse2.errorCode = 0;
        }
        return sapiAccountResponse2;
    }

    public static String parseExecutePer(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 10) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("r", 4);
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
}
