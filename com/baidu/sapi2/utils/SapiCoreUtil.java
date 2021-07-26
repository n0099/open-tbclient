package com.baidu.sapi2.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Xml;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.inner.ExecuteJsCallback;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.FromType;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
public class SapiCoreUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CUSTOM_THEME_SCHEMA = "file:///android_asset/";
    public static final String TAG = "SapiCoreUtil";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2116546307, "Lcom/baidu/sapi2/utils/SapiCoreUtil;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2116546307, "Lcom/baidu/sapi2/utils/SapiCoreUtil;");
        }
    }

    public SapiCoreUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00de, code lost:
        if (r1 != null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00e0, code lost:
        r1.destroy();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f0, code lost:
        if (r1 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f3, code lost:
        if (r3 != 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f6, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:?, code lost:
        return true;
     */
    @TargetApi(4)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean chmodFile(Context context, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65538, null, context, file)) != null) {
            return invokeLL.booleanValue;
        }
        Process process = null;
        String str = null;
        process = null;
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
                    } catch (Exception e2) {
                        e = e2;
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
                r3 = process != null ? process.waitFor() : -1;
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void executeJsCode(String str, String str2, String str3, Context context, ExecuteJsCallback executeJsCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65539, null, str, str2, str3, context, executeJsCallback) == null) {
            try {
                WebView webView = new WebView(context);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadDataWithBaseURL("", "<html><head><meta charset=\"utf-8\"><script> " + str + str2 + " </script></head></html>", SapiWebView.DATA_MIME_TYPE, "UTF-8", "");
                StringBuilder sb = new StringBuilder();
                sb.append("javascript:moonshade(");
                sb.append(str3);
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                webView.setWebViewClient(new WebViewClient(webView, sb.toString(), executeJsCallback) { // from class: com.baidu.sapi2.utils.SapiCoreUtil.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String val$callJs;
                    public final /* synthetic */ ExecuteJsCallback val$callback;
                    public final /* synthetic */ WebView val$webView;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {webView, r7, executeJsCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$webView = webView;
                        this.val$callJs = r7;
                        this.val$callback = executeJsCallback;
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView2, String str4) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView2, str4) == null) {
                            super.onPageFinished(webView2, str4);
                            if (Build.VERSION.SDK_INT >= 19) {
                                this.val$webView.evaluateJavascript(this.val$callJs, new ValueCallback<String>(this) { // from class: com.baidu.sapi2.utils.SapiCoreUtil.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass1 this$0;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$0 = this;
                                    }

                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // android.webkit.ValueCallback
                                    public void onReceiveValue(String str5) {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str5) == null) {
                                            this.this$0.val$callback.jsExecuteCompleted(str5);
                                            this.this$0.val$webView.destroy();
                                        }
                                    }
                                });
                                return;
                            }
                            this.val$callback.jsExecuteCompleted(null);
                            this.val$webView.destroy();
                        }
                    }
                });
            } catch (Exception unused) {
                if (executeJsCallback != null) {
                    executeJsCallback.jsExecuteCompleted(null);
                }
            }
        }
    }

    public static InputStream getCacheInputStream(Context context, String str) {
        InterceptResult invokeLL;
        InputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
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
        return (InputStream) invokeLL.objValue;
    }

    public static String getExecResult(String str) {
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        Throwable th;
        Process process;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            try {
                process = Runtime.getRuntime().exec("ls -ld " + str);
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                } catch (IOException unused) {
                    bufferedReader = null;
                } catch (Throwable th2) {
                    bufferedReader = null;
                    th = th2;
                }
            } catch (IOException unused2) {
                process = null;
                bufferedReader = null;
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
                process = null;
            }
            try {
                String readLine = bufferedReader.readLine();
                try {
                    bufferedReader.close();
                } catch (Exception unused3) {
                }
                if (process != null) {
                    process.destroy();
                }
                return readLine;
            } catch (IOException unused4) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused5) {
                    }
                }
                if (process != null) {
                    process.destroy();
                }
                return null;
            } catch (Throwable th4) {
                th = th4;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused6) {
                    }
                }
                if (process != null) {
                    process.destroy();
                }
                throw th;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getMatcher(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2)) == null) {
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
        return (String) invokeLL.objValue;
    }

    public static SapiAccountResponse parseAccountXmlToResponse(String str, String str2) {
        InterceptResult invokeLL;
        SapiAccountResponse sapiAccountResponse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) {
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
                            } else if (name.equalsIgnoreCase(SapiAccount.SAPI_ACCOUNT_PTOKEN)) {
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
                            } else if (IWalletLoginListener.KEY_LOGIN_TYPE.equals(name)) {
                                String nextText3 = newPullParser.nextText();
                                if ("oneKeyLogin".equals(nextText3) || "business_from_one_key_login".equals(str)) {
                                    nextText3 = new OneKeyLoginSdkCall().getOperatorType();
                                }
                                SapiContext.getInstance().put(SapiContext.KEY_PRE_LOGIN_TYPE, nextText3);
                                continue;
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
                        } else if (sapiAccountResponse2 == null) {
                            sapiAccountResponse = new SapiAccountResponse();
                            sapiAccountResponse2 = sapiAccountResponse;
                            continue;
                        } else {
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
        return (SapiAccountResponse) invokeLL.objValue;
    }

    public static String parseExecutePer(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (TextUtils.isEmpty(str) || str.length() < 10) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(r.f7788a, 4);
            hashMap.put("w", 2);
            int i2 = 1;
            hashMap.put("x", 1);
            hashMap.put("-", 0);
            String str2 = "";
            int i3 = 0;
            while (i2 < 10) {
                int i4 = i2 + 1;
                Integer num = (Integer) hashMap.get(str.substring(i2, i4));
                if (num == null) {
                    return null;
                }
                i3 += num.intValue();
                if (i2 % 3 == 0) {
                    str2 = str2 + i3;
                    i3 = 0;
                }
                i2 = i4;
            }
            if (str2.length() != 3) {
                return null;
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }
}
