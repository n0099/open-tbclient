package c.a.q0.c1;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.r.r.d2;
import c.a.q0.r.r.e2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import okhttp3.Response;
@ModifyClass
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public static f a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(38255436, "Lc/a/q0/c1/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(38255436, "Lc/a/q0/c1/f;");
        }
    }

    public f() {
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

    @Modify(description = "广告-热启动是否开启debug模式", type = 100)
    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public static synchronized f d() {
        InterceptResult invokeV;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new f();
                }
                fVar = a;
            }
            return fVar;
        }
        return (f) invokeV.objValue;
    }

    public static int e() {
        InterceptResult invokeV;
        int min;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            int j2 = j();
            int k = k();
            if (j2 != k && (min = Math.min(j2, k)) > 0 && min < 10000) {
                return min;
            }
            return 1000;
        }
        return invokeV.intValue;
    }

    public static int f() {
        InterceptResult invokeV;
        int max;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            int j2 = j();
            int k = k();
            if (j2 != k && (max = Math.max(j2, k)) > 0 && max < 10000) {
                return max;
            }
            return 1400;
        }
        return invokeV.intValue;
    }

    public static String g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i2)) == null) {
            if (i2 != -1) {
                return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? "PLG_Other" : "PLG_CPC" : "PLG_OperateHighly" : "PLG_OperateNormal" : "PLG_GD";
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    public static boolean h(Object obj) {
        InterceptResult invokeL;
        c.a.r0.y3.k0.n nVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, obj)) == null) {
            if (obj instanceof c.a.q0.r.r.o0) {
                return true;
            }
            if (obj instanceof d2) {
                nVar = ((d2) obj).w.M2;
            } else if (obj instanceof e2) {
                nVar = ((e2) obj).M2;
            } else {
                nVar = obj instanceof PostData ? ((PostData) obj).w0 : null;
            }
            return nVar != null;
        }
        return invokeL.booleanValue;
    }

    @Modify(description = "小熊广告-开屏是否提前初始化", type = 33)
    public static boolean i(int i2) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i2)) == null) {
            if (UbsABTestHelper.newSplashStrategy()) {
                if (n()) {
                    return c.a.g0.b.f.f.b() && l();
                }
                return l();
            }
            switch (i2) {
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            return c.a.q0.r.j0.b.k().l("splash_origin_ad_strategy_key", 1) != 0 ? c.a.g0.b.f.f.b() && z : z;
        }
        return invokeI.booleanValue;
    }

    @Modify(description = "广告-开屏广告第一次超时时间(新)", type = 100)
    public static int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? c.a.q0.r.j0.b.k().l("key_splash_new_policy_first_timeout", 1000) : invokeV.intValue;
    }

    @Modify(description = "广告-开屏广告第二次超时时间(新)", type = 100)
    public static int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? c.a.q0.r.j0.b.k().l("key_splash_new_policy_second_timeout", 1400) : invokeV.intValue;
    }

    @Modify(description = "小熊广告-开屏是否展示小熊开关(新)", type = 100)
    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? c.a.q0.r.j0.b.k().l("key_splash_new_policy_bear_enable", 0) == 1 : invokeV.booleanValue;
    }

    @Modify(description = "广告-开屏是否展示序章CPC开关(新)", type = 100)
    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? c.a.q0.r.j0.b.k().l("key_splash_new_policy_plg_cpc_enable", 0) == 1 : invokeV.booleanValue;
    }

    @Modify(description = "广告-开屏是否展示序章开关(新)", type = 100)
    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? c.a.q0.r.j0.b.k().l("key_splash_new_policy_plg_enable", 0) == 1 : invokeV.booleanValue;
    }

    public long b(File file, String str) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, str)) == null) {
            long j2 = 0;
            if (TextUtils.isEmpty(str) || file == null) {
                return 0L;
            }
            InputStream inputStream = null;
            try {
                Response executeSync = HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().url(str).build().executeSync();
                if (executeSync == null || executeSync.code() != 200) {
                    fileOutputStream = null;
                } else {
                    InputStream byteStream = executeSync.body().byteStream();
                    if (byteStream != null) {
                        try {
                            fileOutputStream = new FileOutputStream(file);
                            try {
                                j2 = FileUtils.copyStream(byteStream, fileOutputStream);
                            } catch (Exception e2) {
                                e = e2;
                                inputStream = byteStream;
                                try {
                                    TiebaStatic.log(e.toString());
                                    Closeables.closeSafely(inputStream);
                                    Closeables.closeSafely(fileOutputStream);
                                    return j2;
                                } catch (Throwable th) {
                                    th = th;
                                    Closeables.closeSafely(inputStream);
                                    Closeables.closeSafely(fileOutputStream);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream = byteStream;
                                Closeables.closeSafely(inputStream);
                                Closeables.closeSafely(fileOutputStream);
                                throw th;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            fileOutputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = null;
                        }
                    } else {
                        fileOutputStream = null;
                    }
                    inputStream = byteStream;
                }
            } catch (Exception e4) {
                e = e4;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
            }
            Closeables.closeSafely(inputStream);
            Closeables.closeSafely(fileOutputStream);
            return j2;
        }
        return invokeLL.longValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null) : (String) invokeV.objValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            String c2 = c();
            if (TextUtils.isEmpty(c2)) {
                return;
            }
            c.a.d.f.l.d.h().k(c2, 10, null, 0, 0, null, new Object[0]);
        }
    }
}
