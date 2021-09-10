package c.b.c.b.h;

import android.os.Build;
import c.b.c.b.l;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public InputStream f31566e;

        /* renamed from: f  reason: collision with root package name */
        public List<String> f31567f;

        public a(InputStream inputStream, List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputStream, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31566e = inputStream;
            this.f31567f = list;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f31566e));
                int i2 = 32768;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        } else if (!readLine.startsWith("---------")) {
                            i2 -= readLine.getBytes("UTF-8").length;
                            if (i2 < 0) {
                                break;
                            }
                            this.f31567f.add(readLine);
                        }
                    } catch (IOException unused) {
                    } catch (Throwable th) {
                        l.g.a(bufferedReader);
                        throw th;
                    }
                }
                l.g.a(bufferedReader);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Process f31568e;

        /* renamed from: f  reason: collision with root package name */
        public long f31569f;

        public b(Process process, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {process, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31568e = process;
            this.f31569f = j2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Thread.sleep(this.f31569f);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                Process process = this.f31568e;
                if (process != null) {
                    process.destroy();
                }
            }
        }
    }

    public static String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) {
            return (i2 < 0 || i2 >= 6) ? "*:V" : new String[]{"*:V", "*:D", "*:I", "*:W", "*:E", "*:F"}[i2];
        }
        return (String) invokeI.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x006a, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x005e, code lost:
        if (r4 != null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<String> b(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeII = interceptable.invokeII(65537, null, i2, i3)) != null) {
            return (List) invokeII.objValue;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        String[] strArr = {"logcat", "-t", String.valueOf(i2), a(i3)};
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(strArr);
            new a(process.getInputStream(), copyOnWriteArrayList).start();
            new a(process.getErrorStream(), copyOnWriteArrayList).start();
            new b(process, 3000L).start();
            if (Build.VERSION.SDK_INT >= 26) {
                process.waitFor(3000L, TimeUnit.MILLISECONDS);
            } else {
                process.waitFor();
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
            } finally {
                if (0 != 0) {
                    process.destroy();
                }
            }
        }
    }
}
