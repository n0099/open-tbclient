package c.a.s0.e1;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Debug;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ExceptionData;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.provider.ContentProviderManager;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes6.dex */
public class s0 implements Thread.UncaughtExceptionHandler {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final String f12727g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f12728e;

    /* renamed from: f  reason: collision with root package name */
    public ExceptionData f12729f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1923247399, "Lc/a/s0/e1/s0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1923247399, "Lc/a/s0/e1/s0;");
                return;
            }
        }
        f12727g = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + File.separator + "tieba" + File.separator + "oom" + File.separator;
    }

    public s0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f12728e = Thread.getDefaultUncaughtExceptionHandler();
        this.f12729f = null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x0042 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x000a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11 */
    public static String d(String str) {
        InterceptResult invokeL;
        String readLine;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = 0;
            try {
                try {
                    Process exec = Runtime.getRuntime().exec(str);
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                    while (true) {
                        try {
                            readLine = bufferedReader2.readLine();
                            if (c.a.d.f.p.m.isEmpty(readLine)) {
                                break;
                            }
                            sb.append(readLine);
                            sb.append(StringUtils.LF);
                        } catch (IOException e2) {
                            e = e2;
                            bufferedReader = bufferedReader2;
                            e.printStackTrace();
                            c.a.d.f.p.o.g(bufferedReader);
                            bufferedReader = bufferedReader;
                            return sb.toString();
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            c.a.d.f.p.o.g(bufferedReader);
                            throw th;
                        }
                    }
                    exec.destroy();
                    c.a.d.f.p.o.g(bufferedReader2);
                    bufferedReader = readLine;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e3) {
                e = e3;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static byte[] f(File file) {
        InterceptResult invokeL;
        byte[] bArr;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, file)) == null) {
            FileInputStream fileInputStream2 = null;
            byte[] bArr2 = null;
            fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Exception e2) {
                    e = e2;
                    bArr = null;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                int length = (int) file.length();
                bArr2 = new byte[length];
                int i2 = 0;
                while (i2 < length) {
                    int read = fileInputStream.read(bArr2, i2, length - i2);
                    if (read < 0) {
                        break;
                    }
                    i2 += read;
                }
                c.a.d.f.p.o.e(fileInputStream);
                return bArr2;
            } catch (Exception e3) {
                e = e3;
                bArr = bArr2;
                fileInputStream2 = fileInputStream;
                BdLog.e(e.toString());
                c.a.d.f.p.o.e(fileInputStream2);
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                c.a.d.f.p.o.e(fileInputStream2);
                throw th;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static boolean h(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, th)) == null) {
            if ("java.lang.OutOfMemoryError".equals(th.getClass().getName())) {
                return true;
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                return h(cause);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void a(FileWriter fileWriter, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, fileWriter, str, str2) == null) {
            try {
                fileWriter.append((CharSequence) str);
                if (str2 != null) {
                    fileWriter.append("=");
                    fileWriter.append((CharSequence) str2);
                }
                fileWriter.append(StringUtils.LF);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        String[] split;
        int e2;
        int e3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = 100;
            try {
                i2 = c.a.s0.s.g0.b.j().k("crash_limit_count", 100);
                if (i2 < 10) {
                    i2 = 10;
                }
            } catch (Throwable unused) {
            }
            int i3 = StringHelper.getyyyyMMddTimeForNow();
            String str = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/crash_upload_info.log";
            byte[] GetFileData = FileHelper.GetFileData(str);
            String str2 = GetFileData != null ? new String(GetFileData) : null;
            if (TextUtils.isEmpty(str2) || (split = str2.split(":")) == null || split.length != 2) {
                e3 = i3;
                e2 = 0;
            } else {
                e2 = c.a.d.f.m.b.e(split[0], 0);
                e3 = c.a.d.f.m.b.e(split[1], i3);
            }
            if (e3 != i3) {
                e2 = 0;
            }
            if (e2 > i2) {
                return true;
            }
            FileHelper.saveFileByAbsolutePath(str, ((e2 + 1) + ":" + i3).getBytes());
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                File file = new File(f12727g);
                if (!file.exists()) {
                    file.mkdir();
                }
                Debug.dumpHprofData(f12727g + System.currentTimeMillis());
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }

    public final int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? c.a.d.f.n.m.a.o().q("alert_crash", 5) : invokeV.intValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f12729f == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016301, this.f12729f));
        Map<String, String> map = this.f12729f.appendInfoMap;
        if (map != null) {
            for (String str : map.keySet()) {
                StringBuilder sb = new StringBuilder();
                ExceptionData exceptionData = this.f12729f;
                sb.append(exceptionData.info);
                sb.append(StringUtils.LF);
                sb.append(this.f12729f.appendInfoMap.get(str));
                exceptionData.info = sb.toString();
            }
        }
    }

    public final int i() {
        InterceptResult invokeV;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            String str = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/crash_hour_record.log";
            byte[] GetFileData = FileHelper.GetFileData(str);
            String str2 = GetFileData != null ? new String(GetFileData) : null;
            long j2 = com.baidu.adp.lib.util.StringUtils.getyyyyMMddHHTimeForNow();
            long j3 = 0;
            int i2 = 0;
            if (!TextUtils.isEmpty(str2) && (split = str2.split(":")) != null && split.length == 2) {
                i2 = c.a.d.f.m.b.e(split[0], 0);
                j3 = c.a.d.f.m.b.g(split[1], j2);
            }
            int i3 = j3 == j2 ? 1 + i2 : 1;
            FileHelper.saveFileByAbsolutePath(str, (i3 + ":" + j2).getBytes());
            return i3;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0157, code lost:
        if (r10 != null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x017a, code lost:
        if (r10 != null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x017c, code lost:
        r10.uncaughtException(r8, r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void j(Thread thread, Throwable th, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream;
        PrintStream printStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler2;
        PrintStream printStream2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048582, this, thread, th, z) == null) {
            if (TbConfig.getDebugSwitch() && h(th)) {
                c();
            }
            PrintStream printStream3 = null;
            if (h(th)) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append((th.getMessage() + d("cat proc/" + Process.myPid() + "/status")) + "\n===========================\n");
                    sb.append(d("cat proc/" + Process.myPid() + "/maps"));
                    Exception exc = new Exception(sb.toString());
                    this.f12729f = new ExceptionData();
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        printStream = new PrintStream(byteArrayOutputStream);
                    } catch (Exception unused) {
                        printStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        exc.printStackTrace(printStream);
                        this.f12729f.info = new String(byteArrayOutputStream.toByteArray());
                        this.f12729f.mExcep = exc;
                        k(thread, exc);
                        this.f12729f = null;
                    } catch (Exception unused2) {
                    } catch (Throwable th3) {
                        th = th3;
                        printStream3 = printStream;
                        c.a.d.f.p.o.f(printStream3);
                        c.a.d.f.p.o.f(byteArrayOutputStream);
                        throw th;
                    }
                } catch (Exception unused3) {
                    byteArrayOutputStream = null;
                    printStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayOutputStream = null;
                }
                c.a.d.f.p.o.f(printStream);
                c.a.d.f.p.o.f(byteArrayOutputStream);
            }
            int i2 = i();
            if (b()) {
                return;
            }
            try {
                byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    try {
                        printStream2 = new PrintStream(byteArrayOutputStream2);
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream2 = null;
            } catch (Throwable th6) {
                th = th6;
                byteArrayOutputStream2 = null;
            }
            try {
                th.printStackTrace(printStream2);
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                ExceptionData exceptionData = new ExceptionData();
                this.f12729f = exceptionData;
                if (z) {
                    exceptionData.info = th.getMessage();
                } else {
                    exceptionData.info = new String(byteArray);
                    this.f12729f.mExcep = th;
                }
                g();
                if (!z) {
                    k(thread, th);
                }
                SwitchManager.getInstance().crash(this.f12729f.info);
                if (!TextUtils.isEmpty(this.f12729f.info)) {
                    BdLog.e(this.f12729f.info);
                }
                BdLog.e("hourCrash = " + i2);
                if (i2 >= e()) {
                    m(thread, th);
                }
                c.a.d.f.p.o.f(printStream2);
                c.a.d.f.p.o.f(byteArrayOutputStream2);
            } catch (Exception e4) {
                e = e4;
                printStream3 = printStream2;
                e.printStackTrace();
                c.a.d.f.p.o.f(printStream3);
                c.a.d.f.p.o.f(byteArrayOutputStream2);
                if (z) {
                    return;
                }
                if (TbConfig.getDebugSwitch()) {
                    uncaughtExceptionHandler2 = this.f12728e;
                }
                Process.killProcess(Process.myPid());
            } catch (Throwable th7) {
                th = th7;
                printStream3 = printStream2;
                c.a.d.f.p.o.f(printStream3);
                c.a.d.f.p.o.f(byteArrayOutputStream2);
                if (!z) {
                    if (TbConfig.getDebugSwitch() && (uncaughtExceptionHandler = this.f12728e) != null) {
                        uncaughtExceptionHandler.uncaughtException(thread, th);
                    } else {
                        Process.killProcess(Process.myPid());
                    }
                }
                throw th;
            }
            if (z) {
                return;
            }
            if (TbConfig.getDebugSwitch()) {
                uncaughtExceptionHandler2 = this.f12728e;
            }
            Process.killProcess(Process.myPid());
        }
    }

    public final void k(Thread thread, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, thread, th) == null) || this.f12729f == null) {
            return;
        }
        l(thread, th, TbConfig.getDebugSwitch() ? TbConfig.FATAL_ERROR_DEBUG_FILE : TbConfig.FATAL_ERROR_FILE);
    }

    public final void l(Thread thread, Throwable th, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, thread, th, str) == null) || this.f12729f == null) {
            return;
        }
        FileWriter fileWriter = null;
        try {
            try {
                File CreateFileIfNotFoundAbsolutePath = FileHelper.CreateFileIfNotFoundAbsolutePath(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + str);
                if (CreateFileIfNotFoundAbsolutePath != null && CreateFileIfNotFoundAbsolutePath.length() < TbConfig.FATAL_ERROR_FILE_MAX_SIZE) {
                    FileWriter fileWriter2 = new FileWriter(CreateFileIfNotFoundAbsolutePath, true);
                    try {
                        try {
                            a(fileWriter2, StringHelper.getCurrentString(), null);
                            a(fileWriter2, "tieba_crash_new_info", null);
                            a(fileWriter2, "version", TbConfig.getVersion());
                            a(fileWriter2, "model", Build.MODEL);
                            a(fileWriter2, "android_version", Build.VERSION.RELEASE);
                            a(fileWriter2, "android_sdk", String.valueOf(Build.VERSION.SDK_INT));
                            a(fileWriter2, "from", TbConfig.getFrom());
                            a(fileWriter2, "current_from", TbConfig.getCurrentFrom());
                            a(fileWriter2, "uid", TbadkCoreApplication.getCurrentAccount());
                            a(fileWriter2, "client_id", TbadkCoreApplication.getClientId());
                            if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
                                a(fileWriter2, HttpRequest.SUBAPP_TYPE, TbConfig.getSubappType());
                            }
                            a(fileWriter2, "imei", TbadkCoreApplication.getInst().getImei());
                            a(fileWriter2, "uname", TbadkCoreApplication.getCurrentAccountName());
                            a(fileWriter2, "activity", TiebaStaticHelper.getCurrentActivityAllName());
                            a(fileWriter2, "maxMemory", String.valueOf(Runtime.getRuntime().maxMemory()));
                            a(fileWriter2, "crash_type", th.getClass().getName());
                            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) TbadkCoreApplication.getInst().getApp().getSystemService("activity")).getRunningAppProcesses();
                            int myPid = Process.myPid();
                            if (runningAppProcesses != null) {
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= runningAppProcesses.size()) {
                                        break;
                                    } else if (runningAppProcesses.get(i2).pid == myPid) {
                                        a(fileWriter2, ContentProviderManager.PLUGIN_PROCESS_NAME, runningAppProcesses.get(i2).processName);
                                        break;
                                    } else {
                                        i2++;
                                    }
                                }
                            }
                            a(fileWriter2, "error", this.f12729f.info + "\n--activityStack--" + c.a.d.a.b.g().d());
                            if (this.f12729f.info != null && this.f12729f.info.contains("java.lang.ArrayIndexOutOfBoundsException: src.length=8192 srcPos=1 dst.length=8192 dstPos=0 length=-1")) {
                                int nextInt = new Random().nextInt(100);
                                try {
                                    Field declaredField = thread.getClass().getDeclaredField("this$0");
                                    declaredField.setAccessible(true);
                                    Object obj = declaredField.get(thread);
                                    Field declaredField2 = obj.getClass().getDeclaredField("mFile");
                                    declaredField2.setAccessible(true);
                                    Object obj2 = declaredField2.get(obj);
                                    if (obj2 instanceof File) {
                                        File file = (File) obj2;
                                        if (nextInt < 5) {
                                            byte[] f2 = f(file);
                                            if (f2 == null) {
                                                a(fileWriter2, "--errorFile-", file.getAbsolutePath());
                                            } else {
                                                a(fileWriter2, "--errorFile-", file.getAbsolutePath() + " - " + c.a.d.f.p.e.j(f2));
                                            }
                                        }
                                        file.delete();
                                    }
                                } catch (Exception e2) {
                                    if (nextInt < 5) {
                                        a(fileWriter2, "--errorFile-", e2.toString());
                                    }
                                }
                            }
                            a(fileWriter2, "tieba_crash_new_info_end", null);
                            fileWriter2.append(StringUtils.LF);
                            fileWriter2.flush();
                            fileWriter = fileWriter2;
                        } catch (Exception e3) {
                            e = e3;
                            fileWriter = fileWriter2;
                            e.printStackTrace();
                            c.a.d.f.p.o.h(fileWriter);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileWriter = fileWriter2;
                        c.a.d.f.p.o.h(fileWriter);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e4) {
            e = e4;
        }
        c.a.d.f.p.o.h(fileWriter);
    }

    public final void m(Thread thread, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, thread, th) == null) {
            BdLog.i("writeToFileForAlertLog = fatal_error_alert.log");
            l(thread, th, TbConfig.FATAL_ERROR_ALERT_FILE);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, thread, th) == null) {
            String stackTraceElement = (th == null || th.getStackTrace() == null || th.getStackTrace().length <= 0) ? "" : th.getStackTrace()[0].toString();
            if (thread.getId() == Looper.getMainLooper().getThread().getId() || com.baidu.adp.lib.util.StringUtils.isNull(stackTraceElement) || th == null || com.baidu.adp.lib.util.StringUtils.isNull(th.getMessage()) || !th.getMessage().contains("Results have already been set") || !stackTraceElement.contains("com.google.android.gms")) {
                j(thread, th, false);
            }
        }
    }
}
