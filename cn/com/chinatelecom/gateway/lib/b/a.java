package cn.com.chinatelecom.gateway.lib.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import cn.com.chinatelecom.gateway.lib.CtAuth;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.searchbox.common.security.CacheDeviceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public int o;
    public String p;
    public long q;
    public long r;
    public String s;
    public StringBuffer t;
    public long u;
    public long v;
    public String w;

    public a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = new StringBuffer();
        this.c = "";
        this.e = "";
        this.n = "";
        this.m = "";
        this.p = "";
        this.a = "1.1";
        long currentTimeMillis = System.currentTimeMillis();
        this.u = currentTimeMillis;
        this.b = b(currentTimeMillis);
        this.d = "";
        this.f = "";
        this.g = Build.BRAND;
        this.h = Build.MODEL;
        this.i = "Android";
        this.j = Build.VERSION.RELEASE;
        this.k = "SDK-JJ-v3.7.5";
        this.l = str;
        this.s = "0";
        this.w = "";
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x0042 */
    /* JADX DEBUG: Multi-variable search result rejected for r5v14, resolved type: java.io.InputStreamReader */
    /* JADX DEBUG: Multi-variable search result rejected for r5v6, resolved type: java.io.InputStreamReader */
    /* JADX DEBUG: Multi-variable search result rejected for r5v7, resolved type: java.io.InputStreamReader */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        Throwable th;
        InputStreamReader inputStreamReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            File j = j(context);
            StringBuilder sb = new StringBuilder();
            if (j == null || !j.exists()) {
                return "";
            }
            try {
                fileInputStream = new FileInputStream(j);
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream);
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine != null) {
                                    sb.append(readLine);
                                } else {
                                    try {
                                        break;
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    th.printStackTrace();
                                } finally {
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (Exception e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                    if (inputStreamReader != 0) {
                                        try {
                                            inputStreamReader.close();
                                        } catch (Exception e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (Exception e4) {
                                            e4.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                        bufferedReader.close();
                        try {
                            inputStreamReader.close();
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                    } catch (Throwable th3) {
                        bufferedReader = null;
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader = null;
                    th = th;
                    inputStreamReader = bufferedReader;
                    th.printStackTrace();
                }
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = null;
                bufferedReader = null;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Throwable th;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            String str3 = "";
            BufferedReader bufferedReader = null;
            try {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setRequestProperty(BOSTokenRequest.ACCEPT, "*/*");
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.addRequestProperty("Accept-Charset", "UTF-8");
                    if (TextUtils.isEmpty(str2)) {
                        httpURLConnection.connect();
                    } else {
                        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(httpURLConnection.getOutputStream()));
                        dataOutputStream.write(str2.getBytes("UTF-8"));
                        dataOutputStream.flush();
                        dataOutputStream.close();
                    }
                    if (httpURLConnection.getResponseCode() == 200) {
                        inputStream = httpURLConnection.getInputStream();
                        try {
                            StringBuilder sb = new StringBuilder();
                            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));
                            while (true) {
                                try {
                                    String readLine = bufferedReader2.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    sb.append(readLine);
                                    sb.append("\n");
                                } catch (Throwable th2) {
                                    th = th2;
                                    bufferedReader = bufferedReader2;
                                    try {
                                        th.printStackTrace();
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        return str3;
                                    } catch (Throwable th3) {
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                                throw th3;
                                            }
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        throw th3;
                                    }
                                }
                            }
                            str3 = sb.toString();
                            bufferedReader = bufferedReader2;
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } else {
                        inputStream = null;
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable th5) {
                    th = th5;
                    inputStream = null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return str3;
        }
        return (String) invokeLL.objValue;
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, str) == null) {
            File j = j(context);
            if (j == null || !j.exists()) {
                a(i(context), str);
            } else {
                a(j, str);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(File file, String str) {
        FileWriter fileWriter;
        Exception e;
        Throwable th;
        BufferedWriter bufferedWriter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, file, str) == null) && file != null && file.exists()) {
            BufferedWriter bufferedWriter2 = null;
            try {
                fileWriter = new FileWriter(file, false);
                try {
                    bufferedWriter = new BufferedWriter(fileWriter);
                } catch (Exception e2) {
                    e = e2;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedWriter2 != null) {
                    }
                    if (fileWriter != null) {
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileWriter = null;
            } catch (Throwable th3) {
                th = th3;
                fileWriter = null;
            }
            try {
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                bufferedWriter.write(str);
                bufferedWriter.flush();
                try {
                    bufferedWriter.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                try {
                    fileWriter.close();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            } catch (Exception e6) {
                e = e6;
                bufferedWriter2 = bufferedWriter;
                try {
                    e.printStackTrace();
                    if (bufferedWriter2 != null) {
                        try {
                            bufferedWriter2.close();
                        } catch (Exception e7) {
                            e7.printStackTrace();
                        }
                    }
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (Exception e8) {
                            e8.printStackTrace();
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    th = th;
                    if (bufferedWriter2 != null) {
                        try {
                            bufferedWriter2.close();
                        } catch (Exception e9) {
                            e9.printStackTrace();
                        }
                    }
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (Exception e10) {
                            e10.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                bufferedWriter2 = bufferedWriter;
                th = th;
                if (bufferedWriter2 != null) {
                }
                if (fileWriter != null) {
                }
                throw th;
            }
        }
    }

    public static NetworkInfo b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (context == null) {
                return null;
            }
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        }
        return (NetworkInfo) invokeL.objValue;
    }

    public static String b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65542, null, j)) == null) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA).format(new Date(j));
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return (String) invokeJ.objValue;
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            NetworkInfo b = b(context);
            return b != null && b.isAvailable();
        }
        return invokeL.booleanValue;
    }

    public static boolean d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            NetworkInfo b = b(context);
            return b != null && b.getType() == 0;
        }
        return invokeL.booleanValue;
    }

    public static boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            if (context == null) {
                return true;
            }
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
                declaredMethod.setAccessible(true);
                return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
            } catch (Throwable th) {
                CtAuth.warn("NetUtil", "isMobileEnable error ", th);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            int k = k(context);
            return k != -101 ? (k == -1 || k == 0) ? StringUtil.NULL_STRING : k != 1 ? k != 2 ? k != 3 ? Integer.toString(k) : "4G" : "3G" : "2G" : "WIFI";
        }
        return (String) invokeL.objValue;
    }

    public static String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            String f = f(context);
            return (f != null && f.equals("WIFI") && e(context)) ? "BOTH" : f;
        }
        return (String) invokeL.objValue;
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            String g = g(context);
            if (!TextUtils.isEmpty(g) && !g.equals(StringUtil.NULL_STRING)) {
                if (g.equals("2G")) {
                    return "10";
                }
                if (g.equals("3G")) {
                    return "11";
                }
                if (g.equals("4G")) {
                    return "12";
                }
                if (g.equals("WIFI")) {
                    return "13";
                }
                if (g.equals("BOTH")) {
                    return "14";
                }
            }
            return "15";
        }
        return (String) invokeL.objValue;
    }

    public static File i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            if (context != null) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(context.getFilesDir());
                    sb.append("/eAccount/Log/");
                    File file = new File(sb.toString());
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    File file2 = new File(file, "ipa_ol.ds");
                    if (file2.exists()) {
                        file2.delete();
                    }
                    file2.createNewFile();
                    return file2;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    public static File j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            if (context != null) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(context.getFilesDir());
                    sb.append("/eAccount/Log/");
                    File file = new File(sb.toString());
                    if (file.exists()) {
                        File file2 = new File(file, "ipa_ol.ds");
                        if (file2.exists()) {
                            return file2;
                        }
                        return null;
                    }
                    return null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    public static int k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            int i = 0;
            try {
                NetworkInfo b = b(context);
                if (b != null && b.isAvailable() && b.isConnected()) {
                    int type = b.getType();
                    if (type == 1) {
                        i = -101;
                    } else if (type == 0) {
                        try {
                            i = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (i == 0) {
                            i = b.getSubtype();
                        }
                    }
                } else {
                    i = -1;
                }
            } catch (NullPointerException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            if (i != -101) {
                if (i != -1) {
                    switch (i) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                        case 16:
                            return 1;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                        case 17:
                            return 2;
                        case 13:
                        case 18:
                        case 19:
                            return 3;
                        default:
                            return i;
                    }
                }
                return -1;
            }
            return -101;
        }
        return invokeL.intValue;
    }

    public final a a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            this.o = i;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public final a a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            this.q = j;
            return this;
        }
        return (a) invokeJ.objValue;
    }

    public final a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.d = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public final a b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.e = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public final a c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.f = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public final a d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.m = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public final a e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.n = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public final a f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            this.p = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public final a g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.s = str;
            }
            return this;
        }
        return (a) invokeL.objValue;
    }

    public final a h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            StringBuffer stringBuffer = this.t;
            stringBuffer.append(str);
            stringBuffer.append("\n");
            return this;
        }
        return (a) invokeL.objValue;
    }

    public final a i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            this.w = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                this.v = currentTimeMillis;
                this.r = currentTimeMillis - this.u;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("v", this.a);
                jSONObject.put("t", this.b);
                jSONObject.put("tag", this.c);
                jSONObject.put(CacheDeviceInfo.JSON_KEY_ANDROID_ID, this.d);
                jSONObject.put(AppIconSetting.DEFAULT_LARGE_ICON, this.e);
                jSONObject.put(NotificationStyle.NOTIFICATION_STYLE, this.f);
                jSONObject.put(TtmlNode.TAG_BR, this.g);
                jSONObject.put("ml", this.h);
                jSONObject.put("os", this.i);
                jSONObject.put("ov", this.j);
                jSONObject.put("sv", this.k);
                jSONObject.put("ri", this.l);
                jSONObject.put("api", this.m);
                jSONObject.put("p", this.n);
                jSONObject.put("rt", this.o);
                jSONObject.put("msg", this.p);
                jSONObject.put("st", this.q);
                jSONObject.put("tt", this.r);
                jSONObject.put("ot", this.s);
                jSONObject.put("ep", this.t.toString());
                jSONObject.put("aip", this.w);
                return jSONObject.toString();
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
