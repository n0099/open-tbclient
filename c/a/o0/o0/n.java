package c.a.o0.o0;

import android.os.Process;
import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.soloader.SoLoader;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.launch.utils.LaunchNativeUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes3.dex */
public final class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f13438a;

    /* renamed from: b  reason: collision with root package name */
    public long f13439b;

    public n() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13438a = -1L;
        this.f13439b = -1L;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f13438a = SystemClock.elapsedRealtime();
            Process.getElapsedCpuTime();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b() {
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            l.b().d();
            BufferedReader bufferedReader = null;
            long j3 = -1;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/self/stat")), 1000);
                try {
                    try {
                        String[] split = bufferedReader2.readLine().split(" ");
                        if (split.length > 21 && split[0].equals(String.valueOf(Process.myPid()))) {
                            String str = split[21];
                            try {
                                SoLoader.load(AppRuntime.getAppContext(), "launch_native");
                                j2 = LaunchNativeUtils.getClkTck();
                            } catch (UnsatisfiedLinkError unused) {
                                j2 = 0;
                            }
                            String str2 = "_SC_CLK_TCK " + j2;
                            if (j2 <= 0) {
                                j2 = 100;
                            }
                            j3 = (Long.parseLong(str) * 1000) / j2;
                        }
                        Closeables.closeSafely(bufferedReader2);
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        Closeables.closeSafely(bufferedReader);
                        throw th;
                    }
                } catch (FileNotFoundException | IOException | NumberFormatException unused2) {
                    bufferedReader = bufferedReader2;
                    Closeables.closeSafely(bufferedReader);
                    if (j3 <= 0) {
                    }
                }
            } catch (FileNotFoundException | IOException | NumberFormatException unused3) {
            } catch (Throwable th2) {
                th = th2;
            }
            if (j3 <= 0) {
                this.f13439b = this.f13438a - j3;
            }
        }
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f13439b == -1) {
                b();
            }
            return this.f13439b;
        }
        return invokeV.longValue;
    }
}
