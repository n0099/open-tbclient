package c.a.n.a;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.n.c.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.logsystem.basic.upload.identity.ChannelManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f4060d;

    /* renamed from: e  reason: collision with root package name */
    public static a f4061e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f4062a;

    /* renamed from: b  reason: collision with root package name */
    public String f4063b;

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences f4064c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1242870705, "Lc/a/n/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1242870705, "Lc/a/n/a/a;");
                return;
            }
        }
        f4060d = AppConfig.isDebug();
    }

    public a() {
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
        d();
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f4061e == null) {
                synchronized (a.class) {
                    if (f4061e == null) {
                        f4061e = new a();
                    }
                }
            }
            return f4061e;
        }
        return (a) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f4063b : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f4062a : (String) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f4064c = AppRuntime.getAppContext().getSharedPreferences(ChannelManager.PREFS_NAME, 0);
            f();
            e();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            String g2 = g();
            this.f4063b = g2;
            if (!TextUtils.isEmpty(g2) || TextUtils.isEmpty(this.f4062a)) {
                return;
            }
            this.f4063b = this.f4062a;
            j();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            String i2 = i();
            this.f4062a = i2;
            if (TextUtils.isEmpty(i2)) {
                this.f4062a = h();
            }
        }
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f4064c.getString("channel", null) : (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x006e A[Catch: Exception -> 0x006a, TRY_LEAVE, TryCatch #3 {Exception -> 0x006a, blocks: (B:36:0x0066, B:39:0x006e), top: B:51:0x0066 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String h() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Throwable th;
        InputStream inputStream;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048582, this)) != null) {
            return (String) invokeV.objValue;
        }
        InputStream inputStream2 = null;
        String str2 = null;
        try {
            inputStream = AppRuntime.getAppContext().getAssets().open("channel");
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                try {
                    str2 = bufferedReader.readLine();
                    inputStream.close();
                    bufferedReader.close();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                            boolean z = f4060d;
                            return str2;
                        }
                    }
                    bufferedReader.close();
                    return str2;
                } catch (Exception unused2) {
                    String str3 = str2;
                    inputStream2 = inputStream;
                    str = str3;
                    try {
                        boolean z2 = f4060d;
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Exception unused3) {
                                boolean z3 = f4060d;
                                return str;
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return str;
                    } catch (Throwable th2) {
                        InputStream inputStream3 = inputStream2;
                        th = th2;
                        inputStream = inputStream3;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception unused4) {
                                boolean z4 = f4060d;
                                throw th;
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (inputStream != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            } catch (Exception unused5) {
                bufferedReader = null;
                inputStream2 = inputStream;
                str = null;
            } catch (Throwable th4) {
                bufferedReader = null;
                th = th4;
            }
        } catch (Exception unused6) {
            str = null;
            bufferedReader = null;
        } catch (Throwable th5) {
            bufferedReader = null;
            th = th5;
            inputStream = null;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0028 -> B:28:0x0043). Please submit an issue!!! */
    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String str = null;
            try {
                InputStream openRawResource = AppRuntime.getAppContext().getResources().openRawResource(g.tnconfig);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openRawResource));
                try {
                    try {
                        str = bufferedReader.readLine();
                        openRawResource.close();
                        bufferedReader.close();
                    } catch (Exception unused) {
                        boolean z = f4060d;
                        openRawResource.close();
                        bufferedReader.close();
                    }
                } catch (Exception unused2) {
                    boolean z2 = f4060d;
                }
            } catch (Exception unused3) {
                boolean z3 = f4060d;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f4064c.edit().putString("channel", this.f4063b).apply();
        }
    }
}
