package com.baidu.lbsapi.auth;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.bbalbs.common.util.CommonParam;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p0.u;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LBSAuthManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CODE_AUTHENTICATE_SUCC = 0;
    public static final int CODE_AUTHENTICATING = 602;
    public static final int CODE_INNER_ERROR = -1;
    public static final int CODE_KEY_NOT_EXIST = 101;
    public static final int CODE_NETWORK_FAILED = -11;
    public static final int CODE_NETWORK_INVALID = -10;
    public static final int CODE_UNAUTHENTICATE = 601;
    public static final String VERSION = "1.0.23";
    public static Context a;
    public static m d;
    public static int e;
    public static Hashtable f;
    public static LBSAuthManager g;
    public transient /* synthetic */ FieldHolder $fh;
    public c b;
    public e c;
    public boolean h;
    public final Handler i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1933636720, "Lcom/baidu/lbsapi/auth/LBSAuthManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1933636720, "Lcom/baidu/lbsapi/auth/LBSAuthManager;");
                return;
            }
        }
        f = new Hashtable();
    }

    public LBSAuthManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = null;
        this.h = false;
        this.i = new i(this, Looper.getMainLooper());
        a = context;
        m mVar = d;
        if (mVar != null && !mVar.isAlive()) {
            d = null;
        }
        a.b("BaiduApiAuth SDK Version:1.0.23");
        d();
    }

    private int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            int i = -1;
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.has("status")) {
                    jSONObject.put("status", -1);
                }
                i = jSONObject.getInt("status");
                if (jSONObject.has(ProgressInfo.JSON_KEY_CURRENT) && i == 0) {
                    long j = jSONObject.getLong(ProgressInfo.JSON_KEY_CURRENT);
                    long currentTimeMillis = System.currentTimeMillis();
                    if ((currentTimeMillis - j) / 3600000.0d < 24.0d) {
                        if (this.h) {
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            if (!simpleDateFormat.format(Long.valueOf(currentTimeMillis)).equals(simpleDateFormat.format(Long.valueOf(j)))) {
                            }
                        }
                    }
                    i = 601;
                }
                if (jSONObject.has(ProgressInfo.JSON_KEY_CURRENT) && i == 602) {
                    if ((System.currentTimeMillis() - jSONObject.getLong(ProgressInfo.JSON_KEY_CURRENT)) / 1000 > 180.0d) {
                        return 601;
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return i;
        }
        return invokeL.intValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:11:0x003e */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0078, code lost:
        if (r6 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0088, code lost:
        if (r6 == null) goto L15;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0085  */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(int i) throws IOException {
        InterceptResult invokeI;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        Throwable th;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i)) == null) {
            String str = null;
            try {
                fileInputStream = new FileInputStream(new File("/proc/" + i + "/cmdline"));
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream);
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                        try {
                            str = bufferedReader.readLine();
                            bufferedReader.close();
                            inputStreamReader.close();
                        } catch (FileNotFoundException unused) {
                            bufferedReader3 = bufferedReader;
                            if (bufferedReader3 != 0) {
                            }
                            if (inputStreamReader != null) {
                            }
                        } catch (IOException unused2) {
                            bufferedReader2 = bufferedReader;
                            if (bufferedReader2 != 0) {
                            }
                            if (inputStreamReader != null) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException unused3) {
                        bufferedReader3 = 0;
                    } catch (IOException unused4) {
                        bufferedReader2 = 0;
                    } catch (Throwable th3) {
                        bufferedReader = null;
                        th = th3;
                    }
                } catch (FileNotFoundException unused5) {
                    inputStreamReader = null;
                    bufferedReader3 = inputStreamReader;
                    if (bufferedReader3 != 0) {
                        bufferedReader3.close();
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                } catch (IOException unused6) {
                    inputStreamReader = null;
                    bufferedReader2 = inputStreamReader;
                    if (bufferedReader2 != 0) {
                        bufferedReader2.close();
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                } catch (Throwable th4) {
                    bufferedReader = null;
                    th = th4;
                    inputStreamReader = null;
                }
            } catch (FileNotFoundException unused7) {
                fileInputStream = null;
                inputStreamReader = null;
            } catch (IOException unused8) {
                fileInputStream = null;
                inputStreamReader = null;
            } catch (Throwable th5) {
                inputStreamReader = null;
                bufferedReader = null;
                th = th5;
                fileInputStream = null;
            }
            fileInputStream.close();
            return str;
        }
        return (String) invokeI.objValue;
    }

    private String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context)) == null) {
            int myPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == myPid) {
                        return runningAppProcessInfo.processName;
                    }
                }
            }
            String str = null;
            try {
                str = a(myPid);
            } catch (IOException unused) {
            }
            return str != null ? str : a.getPackageName();
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
        if (r6.equals("") != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, this, context, str)) == null) {
            String str2 = "";
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo.metaData == null) {
                    LBSAuthManagerListener lBSAuthManagerListener = (LBSAuthManagerListener) f.get(str);
                    if (lBSAuthManagerListener != null) {
                        lBSAuthManagerListener.onAuthResult(101, ErrorMessage.a(101, "AndroidManifest.xml的application中没有meta-data标签"));
                    }
                } else {
                    String string = applicationInfo.metaData.getString("com.baidu.lbsapi.API_KEY");
                    if (string != null) {
                        try {
                        } catch (PackageManager.NameNotFoundException unused) {
                            str2 = string;
                            LBSAuthManagerListener lBSAuthManagerListener2 = (LBSAuthManagerListener) f.get(str);
                            if (lBSAuthManagerListener2 != null) {
                                lBSAuthManagerListener2.onAuthResult(101, ErrorMessage.a(101, "无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值"));
                            }
                            return str2;
                        }
                    }
                    LBSAuthManagerListener lBSAuthManagerListener3 = (LBSAuthManagerListener) f.get(str);
                    if (lBSAuthManagerListener3 != null) {
                        lBSAuthManagerListener3.onAuthResult(101, ErrorMessage.a(101, "无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值"));
                    }
                    str2 = string;
                }
            } catch (PackageManager.NameNotFoundException unused2) {
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, this, str, str2) == null) {
            synchronized (this) {
                if (str == null) {
                    str = e();
                }
                Message obtainMessage = this.i.obtainMessage();
                int i = -1;
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (!jSONObject.has("status")) {
                        jSONObject.put("status", -1);
                    }
                    if (!jSONObject.has(ProgressInfo.JSON_KEY_CURRENT)) {
                        jSONObject.put(ProgressInfo.JSON_KEY_CURRENT, System.currentTimeMillis());
                    }
                    c(jSONObject.toString());
                    if (jSONObject.has(ProgressInfo.JSON_KEY_CURRENT)) {
                        jSONObject.remove(ProgressInfo.JSON_KEY_CURRENT);
                    }
                    i = jSONObject.getInt("status");
                    obtainMessage.what = i;
                    obtainMessage.obj = jSONObject.toString();
                    Bundle bundle = new Bundle();
                    bundle.putString("listenerKey", str2);
                    obtainMessage.setData(bundle);
                    this.i.sendMessage(obtainMessage);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    obtainMessage.what = i;
                    obtainMessage.obj = new JSONObject();
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("listenerKey", str2);
                    obtainMessage.setData(bundle2);
                    this.i.sendMessage(obtainMessage);
                }
                if (d != null) {
                    d.c();
                }
                e--;
                a.a("httpRequest called mAuthCounter-- = " + e);
                if (e == 0 && d != null) {
                    d.a();
                    d = null;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, Hashtable hashtable, String str2) {
        String a2;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65547, this, new Object[]{Boolean.valueOf(z), str, hashtable, str2}) == null) || (a2 = a(a, str2)) == null || a2.equals("")) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", "https://api.map.baidu.com/sdkcs/verify");
        a.a("url:https://api.map.baidu.com/sdkcs/verify");
        hashMap.put("output", "json");
        hashMap.put(ContentUtil.RESULT_KEY_AK, a2);
        a.a("ak:" + a2);
        hashMap.put("mcode", b.a(a));
        hashMap.put("from", "lbs_yunsdk");
        if (hashtable != null && hashtable.size() > 0) {
            for (Map.Entry entry : hashtable.entrySet()) {
                String str5 = (String) entry.getKey();
                String str6 = (String) entry.getValue();
                if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
                    hashMap.put(str5, str6);
                }
            }
        }
        try {
            str3 = CommonParam.getCUID(a);
        } catch (Exception e2) {
            a.a("get cuid failed");
            e2.printStackTrace();
            str3 = "";
        }
        a.a("cuid:" + str3);
        if (TextUtils.isEmpty(str3)) {
            hashMap.put("cuid", "");
        } else {
            hashMap.put("cuid", str3);
        }
        hashMap.put(u.w, a.getPackageName());
        hashMap.put("version", VERSION);
        hashMap.put("macaddr", "");
        try {
            str4 = b.a();
        } catch (Exception unused) {
            str4 = "";
        }
        if (TextUtils.isEmpty(str4)) {
            hashMap.put("language", "");
        } else {
            hashMap.put("language", str4);
        }
        if (z) {
            hashMap.put(TTDownloadField.TT_FORCE, z ? "1" : "0");
        }
        if (str == null) {
            hashMap.put("from_service", "");
        } else {
            hashMap.put("from_service", str);
        }
        c cVar = new c(a);
        this.b = cVar;
        cVar.a(hashMap, new k(this, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, Hashtable hashtable, String[] strArr, String str2) {
        String a2;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65548, this, new Object[]{Boolean.valueOf(z), str, hashtable, strArr, str2}) == null) || (a2 = a(a, str2)) == null || a2.equals("")) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", "https://api.map.baidu.com/sdkcs/verify");
        hashMap.put("output", "json");
        hashMap.put(ContentUtil.RESULT_KEY_AK, a2);
        hashMap.put("from", "lbs_yunsdk");
        if (hashtable != null && hashtable.size() > 0) {
            for (Map.Entry entry : hashtable.entrySet()) {
                String str5 = (String) entry.getKey();
                String str6 = (String) entry.getValue();
                if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
                    hashMap.put(str5, str6);
                }
            }
        }
        try {
            str3 = CommonParam.getCUID(a);
        } catch (Exception unused) {
            str3 = "";
        }
        if (TextUtils.isEmpty(str3)) {
            hashMap.put("cuid", "");
        } else {
            hashMap.put("cuid", str3);
        }
        hashMap.put(u.w, a.getPackageName());
        hashMap.put("version", VERSION);
        hashMap.put("macaddr", "");
        try {
            str4 = b.a();
        } catch (Exception unused2) {
            str4 = "";
        }
        if (TextUtils.isEmpty(str4)) {
            hashMap.put("language", "");
        } else {
            hashMap.put("language", str4);
        }
        if (z) {
            hashMap.put(TTDownloadField.TT_FORCE, z ? "1" : "0");
        }
        if (str == null) {
            hashMap.put("from_service", "");
        } else {
            hashMap.put("from_service", str);
        }
        e eVar = new e(a);
        this.c = eVar;
        eVar.a(hashMap, strArr, new l(this, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        InterceptResult invokeL;
        String str2;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, str)) == null) {
            String a2 = a(a, str);
            try {
                jSONObject = new JSONObject(e());
            } catch (JSONException e2) {
                e2.printStackTrace();
                str2 = "";
            }
            if (jSONObject.has(ContentUtil.RESULT_KEY_AK)) {
                str2 = jSONObject.getString(ContentUtil.RESULT_KEY_AK);
                return (a2 == null || str2 == null || a2.equals(str2)) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, str) == null) {
            Context context = a;
            context.getSharedPreferences("authStatus_" + a(a), 0).edit().putString("status", str).commit();
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            synchronized (LBSAuthManager.class) {
                if (d == null) {
                    m mVar = new m("auth");
                    d = mVar;
                    mVar.start();
                    while (d.a == null) {
                        try {
                            a.a("wait for create auth thread.");
                            Thread.sleep(3L);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            Context context = a;
            return context.getSharedPreferences("authStatus_" + a(a), 0).getString("status", "{\"status\":601}");
        }
        return (String) invokeV.objValue;
    }

    public static LBSAuthManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, context)) == null) {
            if (g == null) {
                synchronized (LBSAuthManager.class) {
                    if (g == null) {
                        g = new LBSAuthManager(context);
                    }
                }
            } else if (context != null) {
                a = context;
            } else if (a.a) {
                a.c("input context is null");
                new RuntimeException("here").printStackTrace();
            }
            return g;
        }
        return (LBSAuthManager) invokeL.objValue;
    }

    public int authenticate(boolean z, String str, Hashtable hashtable, LBSAuthManagerListener lBSAuthManagerListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, hashtable, lBSAuthManagerListener})) == null) {
            synchronized (LBSAuthManager.class) {
                boolean z2 = false;
                if (hashtable != null) {
                    String str2 = (String) hashtable.get("zero_auth");
                    if (str2 != null && Integer.valueOf(str2).intValue() == 1) {
                        z2 = true;
                    }
                }
                this.h = z2;
                String str3 = System.currentTimeMillis() + "";
                if (lBSAuthManagerListener != null) {
                    f.put(str3, lBSAuthManagerListener);
                }
                String a2 = a(a, str3);
                if (a2 != null && !a2.equals("")) {
                    e++;
                    a.a(" mAuthCounter  ++ = " + e);
                    String e2 = e();
                    a.a("getAuthMessage from cache:" + e2);
                    int a3 = a(e2);
                    if (a3 == 601) {
                        try {
                            c(new JSONObject().put("status", CODE_AUTHENTICATING).toString());
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                    }
                    d();
                    if (d != null && d.a != null) {
                        a.a("mThreadLooper.mHandler = " + d.a);
                        d.a.post(new j(this, a3, z, str3, str, hashtable));
                        return a3;
                    }
                    return -1;
                }
                return 101;
            }
        }
        return invokeCommon.intValue;
    }

    public String getCUID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Context context = a;
            if (context == null) {
                return "";
            }
            try {
                return CommonParam.getCUID(context);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Context context = a;
            if (context == null) {
                return "";
            }
            try {
                return getPublicKey(context);
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public String getMCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Context context = a;
            return context == null ? "" : b.a(context);
        }
        return (String) invokeV.objValue;
    }

    public String getPublicKey(Context context) throws PackageManager.NameNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("com.baidu.lbsapi.API_KEY") : (String) invokeL.objValue;
    }
}
