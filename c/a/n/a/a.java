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
    public static boolean f4158d;

    /* renamed from: e  reason: collision with root package name */
    public static a f4159e;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f4160b;

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences f4161c;

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
        f4158d = AppConfig.isDebug();
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
            if (f4159e == null) {
                synchronized (a.class) {
                    if (f4159e == null) {
                        f4159e = new a();
                    }
                }
            }
            return f4159e;
        }
        return (a) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f4160b : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f4161c = AppRuntime.getAppContext().getSharedPreferences(ChannelManager.PREFS_NAME, 0);
            f();
            e();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            String g2 = g();
            this.f4160b = g2;
            if (!TextUtils.isEmpty(g2) || TextUtils.isEmpty(this.a)) {
                return;
            }
            this.f4160b = this.a;
            j();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            String i2 = i();
            this.a = i2;
            if (TextUtils.isEmpty(i2)) {
                this.a = h();
            }
        }
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f4161c.getString("channel", null) : (String) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0048, code lost:
        if (r2 == null) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String h() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Throwable th;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String str = null;
            try {
                inputStream = AppRuntime.getAppContext().getAssets().open("channel");
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    try {
                        try {
                            str = bufferedReader.readLine();
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception unused) {
                                    boolean z = f4158d;
                                }
                            }
                        } catch (Exception unused2) {
                            boolean z2 = f4158d;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception unused3) {
                                    boolean z3 = f4158d;
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception unused4) {
                                boolean z4 = f4158d;
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception unused5) {
                                boolean z5 = f4158d;
                            }
                        }
                        throw th;
                    }
                } catch (Exception unused6) {
                    bufferedReader = null;
                } catch (Throwable th3) {
                    bufferedReader = null;
                    th = th3;
                    if (inputStream != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            } catch (Exception unused7) {
                inputStream = null;
                bufferedReader = null;
            } catch (Throwable th4) {
                bufferedReader = null;
                th = th4;
                inputStream = null;
            }
            try {
                bufferedReader.close();
            } catch (Exception unused8) {
                boolean z6 = f4158d;
            }
            return str;
        }
        return (String) invokeV.objValue;
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
                        boolean z = f4158d;
                        openRawResource.close();
                        bufferedReader.close();
                    }
                } catch (Exception unused2) {
                    boolean z2 = f4158d;
                }
            } catch (Exception unused3) {
                boolean z3 = f4158d;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f4161c.edit().putString("channel", this.f4160b).apply();
        }
    }
}
