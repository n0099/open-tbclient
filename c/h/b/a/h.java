package c.h.b.a;

import android.os.Process;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes9.dex */
public class h extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public StringBuffer f28520d;

    /* renamed from: e  reason: collision with root package name */
    public int f28521e;

    /* renamed from: f  reason: collision with root package name */
    public long f28522f;

    /* renamed from: g  reason: collision with root package name */
    public long f28523g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(long j2) {
        super(j2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Long) newInitContext.callArgs[0]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28520d = new StringBuffer();
        this.f28521e = 0;
        this.f28522f = 0L;
        this.f28523g = 0L;
    }

    @Override // c.h.b.a.a
    public void b() {
        BufferedReader bufferedReader;
        String readLine;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f28520d.setLength(0);
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/stat")), 1000);
                    try {
                        readLine = bufferedReader3.readLine();
                        str = "";
                        if (readLine == null) {
                            readLine = "";
                        }
                        if (this.f28521e == 0) {
                            this.f28521e = Process.myPid();
                        }
                        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + this.f28521e + "/stat")), 1000);
                    } catch (Throwable unused) {
                        bufferedReader = null;
                    }
                    try {
                        String readLine2 = bufferedReader.readLine();
                        if (readLine2 != null) {
                            str = readLine2;
                        }
                        f(readLine, str);
                        bufferedReader3.close();
                    } catch (Throwable unused2) {
                        bufferedReader2 = bufferedReader3;
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                        if (bufferedReader == null) {
                            return;
                        }
                        bufferedReader.close();
                    }
                } catch (IOException unused3) {
                    return;
                }
            } catch (Throwable unused4) {
                bufferedReader = null;
            }
            bufferedReader.close();
        }
    }

    @Override // c.h.b.a.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            g();
        }
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28520d.toString() : (String) invokeV.objValue;
    }

    public final void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            String[] split = str.split(" ");
            if (split.length < 9) {
                return;
            }
            long parseLong = Long.parseLong(split[2]);
            long parseLong2 = Long.parseLong(split[3]);
            long parseLong3 = Long.parseLong(split[4]);
            long parseLong4 = Long.parseLong(split[5]);
            long parseLong5 = parseLong + parseLong2 + parseLong3 + parseLong4 + Long.parseLong(split[6]) + Long.parseLong(split[7]) + Long.parseLong(split[8]);
            if (str2.split(" ").length < 17) {
                return;
            }
            if (parseLong5 != 0) {
                long j2 = parseLong5 - this.f28523g;
                this.f28520d.append(((j2 - (parseLong4 - this.f28522f)) * 100) / j2);
            }
            this.f28522f = parseLong4;
            this.f28523g = parseLong5;
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f28522f = 0L;
            this.f28523g = 0L;
        }
    }
}
