package c.a.z.a.i;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static volatile b f30987f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Long f30988a;

    /* renamed from: b  reason: collision with root package name */
    public Long f30989b;

    /* renamed from: c  reason: collision with root package name */
    public RandomAccessFile f30990c;

    /* renamed from: d  reason: collision with root package name */
    public RandomAccessFile f30991d;

    /* renamed from: e  reason: collision with root package name */
    public String f30992e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-958721784, "Lc/a/z/a/i/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-958721784, "Lc/a/z/a/i/b;");
        }
    }

    public b() {
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

    public static b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f30987f == null) {
                synchronized (b.class) {
                    if (f30987f == null) {
                        f30987f = new b();
                    }
                }
            }
            return f30987f;
        }
        return (b) invokeV.objValue;
    }

    public double a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            double g2 = g();
            if (g2 <= 0.0d) {
                g2 = b();
            }
            return g2 <= 0.0d ? d() : g2;
        }
        return invokeV.doubleValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double b() {
        InterceptResult invokeV;
        double doubleValue;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
            return invokeV.doubleValue;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            String c2 = c(this.f30992e);
            if (!TextUtils.isEmpty(c2)) {
                try {
                    doubleValue = Double.valueOf(c2).doubleValue();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (doubleValue <= 0.0d) {
                    return doubleValue;
                }
                return 0.0d;
            }
            doubleValue = 0.0d;
            if (doubleValue <= 0.0d) {
            }
        } else {
            return g();
        }
    }

    public final String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) != null) {
            return (String) invokeL.objValue;
        }
        try {
            Process exec = Runtime.getRuntime().exec(new String[]{IAdRequestParam.SCREEN_HEIGHT, "-c", "top -n 1"});
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    String[] split = readLine.trim().split(" ");
                    if (str != null && str.startsWith(split[split.length - 1].substring(0, split[split.length - 1].length() - 1))) {
                        return split[16];
                    }
                } else {
                    try {
                        exec.waitFor();
                        return "";
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        return "";
                    }
                }
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            return "";
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:54:0x00a1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:86:0x0024 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:91:0x0071 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:95:0x0024 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:96:0x0024 */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0050, code lost:
        r3 = r6[2].trim();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ba A[Catch: Exception -> 0x00bd, TRY_LEAVE, TryCatch #4 {Exception -> 0x00bd, blocks: (B:63:0x00b5, B:65:0x00ba), top: B:78:0x00b5 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int d() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        String str;
        String str2;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int myPid = Process.myPid();
            Process process = 0;
            try {
                Process exec = Runtime.getRuntime().exec("top -n 1");
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            } else if (readLine.trim().startsWith(String.valueOf(myPid)) && (split = readLine.split("\\s+")) != null) {
                                if (split.length > 2 && split[2] != null && split[2].contains("%")) {
                                    break;
                                }
                                int i2 = 0;
                                while (true) {
                                    if (i2 < split.length) {
                                        if (split[i2] != null && split[i2].contains("%")) {
                                            process = split[i2].trim();
                                            break;
                                        }
                                        i2++;
                                    } else {
                                        break;
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            str = process;
                            process = exec;
                            try {
                                e.printStackTrace();
                                if (process != null) {
                                    try {
                                        process.destroy();
                                    } catch (Exception unused) {
                                        str2 = str;
                                        if (str2 != null) {
                                        }
                                        return Integer.parseInt(str2);
                                    }
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                str2 = str;
                                if (str2 != null) {
                                }
                                return Integer.parseInt(str2);
                            } catch (Throwable th) {
                                th = th;
                                if (process != null) {
                                    try {
                                        process.destroy();
                                    } catch (Exception unused2) {
                                        throw th;
                                    }
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            process = exec;
                            if (process != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            throw th;
                        }
                    }
                    if (exec != null) {
                        try {
                            exec.destroy();
                        } catch (Exception unused3) {
                            str2 = process;
                        }
                    }
                    bufferedReader.close();
                    str2 = process;
                } catch (Exception e3) {
                    e = e3;
                    bufferedReader = null;
                    process = exec;
                    str = null;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                }
            } catch (Exception e4) {
                e = e4;
                str = null;
                bufferedReader = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
            if (str2 != null) {
                String[] split2 = str2.split("%");
                if (split2.length > 0) {
                    str2 = split2[0];
                }
            }
            try {
                return Integer.parseInt(str2);
            } catch (Exception unused4) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public ActivityManager.MemoryInfo f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) c.a.z.a.b.c().getSystemService("activity")).getMemoryInfo(memoryInfo);
            return memoryInfo;
        }
        return (ActivityManager.MemoryInfo) invokeV.objValue;
    }

    public double g() {
        InterceptResult invokeV;
        long parseLong;
        long parseLong2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            double d2 = 0.0d;
            try {
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.f30990c != null && this.f30991d != null) {
                this.f30990c.seek(0L);
                this.f30991d.seek(0L);
                String readLine = this.f30990c.readLine();
                String readLine2 = this.f30991d.readLine();
                String[] split = readLine.split(" ");
                String[] split2 = readLine2.split(" ");
                parseLong = Long.parseLong(split[2]) + Long.parseLong(split[3]) + Long.parseLong(split[4]) + Long.parseLong(split[5]) + Long.parseLong(split[6]) + Long.parseLong(split[7]) + Long.parseLong(split[8]);
                parseLong2 = Long.parseLong(split2[13]) + Long.parseLong(split2[14]);
                if (this.f30988a != null && this.f30989b == null) {
                    this.f30988a = Long.valueOf(parseLong);
                    this.f30989b = Long.valueOf(parseLong2);
                    return 0.0d;
                }
                if (this.f30988a != null && this.f30989b != null) {
                    d2 = ((parseLong2 - this.f30989b.longValue()) / (parseLong - this.f30988a.longValue())) * 100.0d;
                }
                this.f30988a = Long.valueOf(parseLong);
                this.f30989b = Long.valueOf(parseLong2);
                return d2;
            }
            this.f30990c = new RandomAccessFile("/proc/stat", r.f42062a);
            this.f30991d = new RandomAccessFile("/proc/" + Process.myPid() + "/stat", r.f42062a);
            String readLine3 = this.f30990c.readLine();
            String readLine22 = this.f30991d.readLine();
            String[] split3 = readLine3.split(" ");
            String[] split22 = readLine22.split(" ");
            parseLong = Long.parseLong(split3[2]) + Long.parseLong(split3[3]) + Long.parseLong(split3[4]) + Long.parseLong(split3[5]) + Long.parseLong(split3[6]) + Long.parseLong(split3[7]) + Long.parseLong(split3[8]);
            parseLong2 = Long.parseLong(split22[13]) + Long.parseLong(split22[14]);
            if (this.f30988a != null) {
            }
            if (this.f30988a != null) {
                d2 = ((parseLong2 - this.f30989b.longValue()) / (parseLong - this.f30988a.longValue())) * 100.0d;
            }
            this.f30988a = Long.valueOf(parseLong);
            this.f30989b = Long.valueOf(parseLong2);
            return d2;
        }
        return invokeV.doubleValue;
    }
}
