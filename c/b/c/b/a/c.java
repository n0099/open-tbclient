package c.b.c.b.a;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import c.b.c.b.i;
import c.b.c.b.l;
import c.b.c.b.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.pose.PoseAR;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: f  reason: collision with root package name */
    public static volatile boolean f31265f = true;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f31266a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f31267b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f31268c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f31269d;

    /* renamed from: e  reason: collision with root package name */
    public final SharedPreferences f31270e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1738190820, "Lc/b/c/b/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1738190820, "Lc/b/c/b/a/c;");
        }
    }

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f31269d = false;
        if (context != null && (context instanceof Application)) {
            this.f31267b = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences("anr_monitor_table", 0);
            this.f31270e = sharedPreferences;
            this.f31268c = sharedPreferences.getLong("trace_anr_happen_time", 0L);
            g.i(100, 100);
            return;
        }
        throw new IllegalArgumentException("context must not be null or not application");
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            for (i iVar : m.c().f()) {
                iVar.a(com.bytedance.tea.crash.c.f68530d, str, null);
            }
        }
    }

    public final String a(BufferedReader bufferedReader) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bufferedReader)) == null) {
            if (bufferedReader == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null || readLine.trim().length() <= 0) {
                    break;
                }
                sb.append(readLine);
                sb.append(StringUtils.LF);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public JSONObject b(String str, int i2, String str2) {
        InterceptResult invokeLIL;
        BufferedReader bufferedReader;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2, str2)) != null) {
            return (JSONObject) invokeLIL.objValue;
        }
        BufferedReader bufferedReader2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || !file.canRead()) {
            return null;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                try {
                    Pattern compile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                    Pattern compile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                    Pattern compile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
                    Pattern compile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                    boolean z = false;
                    Object[] f2 = f(bufferedReader, compile);
                    if (f2 == null) {
                        l.g.a(bufferedReader);
                        return null;
                    }
                    long parseLong = Long.parseLong(f2[1].toString().split("\\s")[2]);
                    long time = simpleDateFormat.parse(f2[1].toString().split("\\s")[4] + " " + f2[1].toString().split("\\s")[5]).getTime();
                    Object[] f3 = f(bufferedReader, compile3);
                    if (f3 == null) {
                        l.g.a(bufferedReader);
                        return null;
                    }
                    String str3 = f3[1].toString().split("\\s")[2];
                    if (parseLong == i2 && str3.equalsIgnoreCase(str2)) {
                        if (this.f31268c != 0 && Math.abs(this.f31268c - time) < 20000) {
                            l.g.a(bufferedReader);
                            return null;
                        }
                        this.f31268c = time;
                        if (this.f31270e != null) {
                            this.f31270e.edit().putLong("trace_anr_happen_time", this.f31268c).apply();
                        }
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("anrTime", time);
                        while (true) {
                            Object[] f4 = f(bufferedReader, compile2, compile4);
                            if (f4 == null || f4[0] != compile4) {
                                break;
                            }
                            Matcher matcher = Pattern.compile("\".+\"").matcher(f4[1].toString());
                            String substring = matcher.find() ? matcher.group().substring(1, matcher.group().length() - 1) : "";
                            Matcher matcher2 = Pattern.compile("tid=\\d+").matcher(f4[1].toString());
                            if (matcher2.find()) {
                                String group = matcher2.group();
                                i3 = Integer.parseInt(group.substring(group.indexOf("=") + 1));
                            } else {
                                i3 = -1;
                            }
                            String a2 = a(bufferedReader);
                            if (i3 != -1 && !TextUtils.isEmpty(substring) && !TextUtils.isEmpty(a2) && substring.equalsIgnoreCase(FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT)) {
                                jSONObject.put("mainStackFromTrace", a2);
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            l.g.a(bufferedReader);
                            return null;
                        }
                        jSONObject.put("thread_number", 1);
                        l.g.a(bufferedReader);
                        return jSONObject;
                    }
                    l.g.a(bufferedReader);
                    return null;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    l.g.a(bufferedReader);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                l.g.a(bufferedReader2);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            l.g.a(bufferedReader2);
            throw th;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f31269d) {
            return;
        }
        if (Build.VERSION.SDK_INT < 21) {
            a aVar = new a(this, "/data/anr/", 8);
            this.f31266a = aVar;
            aVar.startWatching();
        } else {
            new d(this);
        }
        this.f31269d = true;
    }

    public boolean e(int i2, String str, int i3) {
        InterceptResult invokeCommon;
        JSONObject jSONObject;
        JSONObject b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)})) == null) {
            JSONArray n = g.n();
            long uptimeMillis = SystemClock.uptimeMillis();
            JSONObject f2 = g.f(uptimeMillis);
            JSONArray e2 = g.e(100, uptimeMillis);
            try {
                jSONObject = e.b(f31265f);
            } catch (JSONException e3) {
                e3.printStackTrace();
                jSONObject = null;
            }
            String a2 = e.a(this.f31267b, i3);
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            if (i2 == 200 && (b2 = b(str, Process.myPid(), this.f31267b.getPackageName())) != null && b2.length() > 0) {
                jSONObject = b2;
            }
            if (jSONObject != null && jSONObject.length() > 0) {
                try {
                    jSONObject.put("pid", Process.myPid());
                    jSONObject.put(AsInstallService.SCHEME_PACKAGE_ADDED, this.f31267b.getPackageName());
                    jSONObject.put("is_remote_process", 0);
                    c.b.c.b.e.a aVar = new c.b.c.b.e.a(new JSONObject());
                    aVar.k("data", jSONObject.toString());
                    aVar.k("is_anr", 1);
                    aVar.k("timestamp", Long.valueOf(System.currentTimeMillis()));
                    aVar.k(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, "anr");
                    aVar.k("history_message", n);
                    aVar.k("current_message", f2);
                    aVar.k("pending_messages", e2);
                    aVar.k("anr_time", Long.valueOf(System.currentTimeMillis()));
                    aVar.k("crash_time", Long.valueOf(System.currentTimeMillis()));
                    aVar.k("anr_info", a2);
                    aVar.k("all_thread_stacks", l.n.d(null));
                    c.b.c.b.e.a a3 = c.b.c.b.h.a.e.c().a(com.bytedance.tea.crash.c.f68530d, aVar);
                    l.e.d(this.f31267b, com.bytedance.tea.crash.c.f68530d.a(), null);
                    c.b.c.b.n.a.a().c(a3.j());
                    d(a2);
                } catch (Throwable th) {
                    l.k.c(th);
                }
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final Object[] f(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, bufferedReader, patternArr)) == null) {
            if (bufferedReader != null && patternArr != null && patternArr.length > 0) {
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        int length = patternArr.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 < length) {
                                Pattern pattern = patternArr[i2];
                                if (pattern.matcher(readLine).matches()) {
                                    return new Object[]{pattern, readLine};
                                }
                                i2++;
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
            return null;
        }
        return (Object[]) invokeLL.objValue;
    }
}
