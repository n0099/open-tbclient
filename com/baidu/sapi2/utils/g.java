package com.baidu.sapi2.utils;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Xml;
import android.webkit.WebView;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SmsService;
import com.baidu.sapi2.callback.RequestSMSCallback;
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
/* loaded from: classes19.dex */
public class g {
    public static final String a = "g";
    private static final String b = "file:///android_asset/";

    @TargetApi(4)
    public static void a(Context context, String str, String str2, PendingIntent pendingIntent, PendingIntent pendingIntent2, RequestSMSCallback requestSMSCallback) {
        try {
            SmsService.sendSms(context, str2, str, pendingIntent, pendingIntent2, requestSMSCallback);
        } catch (Throwable th) {
            requestSMSCallback.sendSmsResult(false);
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
        hashMap.put(Config.EVENT_HEAT_X, 1);
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

    public static void a(Context context, Handler handler, RequestSMSCallback requestSMSCallback) {
        try {
            SmsService.registerReceiver(context, handler, requestSMSCallback);
        } catch (Throwable th) {
            requestSMSCallback.receiverResult(null);
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:72:0x0123 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:77:? */
    /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: java.lang.Process */
    /* JADX DEBUG: Multi-variable search result rejected for r3v11, resolved type: java.lang.Process */
    /* JADX DEBUG: Multi-variable search result rejected for r3v12, resolved type: java.lang.Process */
    /* JADX DEBUG: Multi-variable search result rejected for r3v15, resolved type: java.lang.Process */
    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: java.lang.Process */
    /* JADX DEBUG: Multi-variable search result rejected for r3v22, resolved type: java.lang.Process */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0112: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:62:0x0112 */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c8 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x010f  */
    @TargetApi(4)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context, File file) {
        Process process;
        Process process2;
        Process process3;
        int i;
        String str;
        String str2 = null;
        try {
            try {
                Runtime runtime = Runtime.getRuntime();
                String packageName = context.getPackageName();
                Process process4 = null;
                while (!packageName.equals(file.getName())) {
                    try {
                        if (file.isDirectory()) {
                            process3 = runtime.exec("chmod 701 " + file);
                        } else {
                            process3 = runtime.exec("chmod 664 " + file);
                        }
                        try {
                            file = file.getParentFile();
                            process4 = process3;
                        } catch (Exception e) {
                            e = e;
                            Log.e(e);
                            if (process3 != 0) {
                                process3.destroy();
                            }
                            i = -1;
                            if (i == 0) {
                            }
                        }
                    } catch (Exception e2) {
                        str2 = process4;
                        e = e2;
                        process3 = str2;
                        Log.e(e);
                        if (process3 != 0) {
                        }
                        i = -1;
                        if (i == 0) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        process = process4;
                        if (process != null) {
                            process.destroy();
                        }
                        throw th;
                    }
                }
                String b2 = b(a(context.getApplicationInfo().dataDir));
                if (TextUtils.isEmpty(b2)) {
                    str2 = "chmod 701 " + file;
                    str = "701";
                } else if (b2.substring(2, 3).equals("0")) {
                    str2 = "chmod " + b2.substring(0, 2) + "1 " + file;
                    str = b2;
                } else {
                    str = b2;
                }
                String str3 = a;
                Object[] objArr = new Object[5];
                objArr[0] = "chmodFile";
                objArr[1] = "command";
                objArr[2] = str2;
                objArr[3] = "originPer";
                objArr[4] = str;
                Log.e(str3, objArr);
                if (str2 != null) {
                    Process exec = runtime.exec(str2);
                    process3 = exec;
                    if (TextUtils.isEmpty(SapiContext.getInstance().getPackageDirExecutePer())) {
                        SapiContext.getInstance().setPackageDirExecutePer(str);
                        process3 = exec;
                    }
                } else {
                    process3 = process4;
                }
                i = process3 != 0 ? process3.waitFor() : -1;
                if (process3 != 0) {
                    process3.destroy();
                }
            } catch (Throwable th2) {
                th = th2;
                process = process2;
            }
        } catch (Exception e3) {
            e = e3;
        } catch (Throwable th3) {
            th = th3;
            process = null;
        }
        return i == 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [79=4] */
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
                                        nextText2 = new com.baidu.sapi2.outsdk.c().c();
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [35=5] */
    public static String a(String str) {
        Process process;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        r0 = null;
        String str2 = null;
        bufferedReader2 = null;
        try {
            process = Runtime.getRuntime().exec("ls -ld " + str);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            } catch (IOException e) {
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            bufferedReader = null;
            process = null;
        } catch (Throwable th2) {
            th = th2;
            process = null;
        }
        try {
            str2 = bufferedReader.readLine();
            try {
                bufferedReader.close();
            } catch (Exception e3) {
            }
            if (process != null) {
                process.destroy();
            }
        } catch (IOException e4) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e5) {
                }
            }
            if (process != null) {
                process.destroy();
            }
            return str2;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception e6) {
                }
            }
            if (process != null) {
                process.destroy();
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
        webView.setWebViewClient(new f(webView, "javascript:moonshade(" + str3 + ")", aVar));
    }
}
