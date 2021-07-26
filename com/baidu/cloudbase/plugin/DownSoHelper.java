package com.baidu.cloudbase.plugin;

import a.a.a.d.a.shuoy;
import a.a.a.d.bv;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.XAdSimpleImageLoader;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.m.d.b;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class DownSoHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f4724a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f4725b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Integer> f4726c;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static DownSoHelper f4727a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1249791635, "Lcom/baidu/cloudbase/plugin/DownSoHelper$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1249791635, "Lcom/baidu/cloudbase/plugin/DownSoHelper$a;");
                    return;
                }
            }
            f4727a = new DownSoHelper();
        }
    }

    public DownSoHelper() {
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
        this.f4726c = new HashMap();
    }

    public static DownSoHelper k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            a.f4727a.f4724a = context.getApplicationContext();
            return a.f4727a;
        }
        return (DownSoHelper) invokeL.objValue;
    }

    public final void e(b bVar, String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048576, this, bVar, str, i2, str2) == null) {
            this.f4726c.put(str, 2);
            if (bVar != null) {
                bVar.onDownloadFail(str, i2, str2);
            }
            if (this.f4725b != null) {
                for (int i3 = 0; i3 < this.f4725b.size(); i3++) {
                    this.f4725b.get(i3).onDownloadFail(str, i2, str2);
                }
            }
        }
    }

    public final void f(b bVar, String str, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bVar, str, Float.valueOf(f2)}) == null) {
            if (bVar != null) {
                bVar.onDownloadProgress(f2);
            }
            if (this.f4725b != null) {
                for (int i2 = 0; i2 < this.f4725b.size(); i2++) {
                    this.f4725b.get(i2).onDownloadProgress(f2);
                }
            }
        }
    }

    public final void g(b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bVar, str) == null) {
            if (bVar != null) {
                bVar.onDownloadStart(str);
            }
            if (this.f4725b != null) {
                for (int i2 = 0; i2 < this.f4725b.size(); i2++) {
                    this.f4725b.get(i2).onDownloadStart(str);
                }
            }
        }
    }

    public final void h(b bVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, bVar, str, str2) == null) {
            this.f4726c.put(str, 3);
            if (bVar != null) {
                bVar.onDownloadSuccess(str, str2);
            }
            if (this.f4725b != null) {
                for (int i2 = 0; i2 < this.f4725b.size(); i2++) {
                    this.f4725b.get(i2).onDownloadSuccess(str, str2);
                }
            }
        }
    }

    public final void i(String str, String str2, Looper looper, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, str, str2, looper, bVar) == null) {
            if (!m(str)) {
                d.a.m.e.a.a(new File(str2));
            }
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.f4726c.put(str, 1);
            String d2 = d.a.m.d.a.d(this.f4724a, str, str2);
            File file2 = new File(d2 + XAdSimpleImageLoader.TEMP_SUFFIX);
            File file3 = new File(d2 + ".zip");
            Log.d("RtcDownSo", "start down folder=" + str2 + "name=" + file2.getName());
            d.a.m.b.a.i().h(str, str2, file2.getName(), looper, new bv(this, bVar, str, file2, file3, d2));
        }
    }

    public void j(@NonNull String str, boolean z, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Boolean.valueOf(z), bVar}) == null) {
            String b2 = d.a.m.d.a.b(this.f4724a);
            if (TextUtils.isEmpty(str)) {
                bVar.onDownloadFail(str, 108, "download url is empty.");
            } else if (l(str, b2)) {
                if (bVar != null) {
                    bVar.onDownloadSuccess(str, d.a.m.d.a.d(this.f4724a, str, b2));
                }
            } else {
                if (z) {
                    if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                        Looper.prepare();
                        Log.d("RtcDownSo", "start down so sub thread");
                        i(str, b2, Looper.myLooper(), bVar);
                        Looper.loop();
                        return;
                    }
                    Log.d("RtcDownSo", "start down so main thread");
                }
                i(str, b2, Looper.getMainLooper(), bVar);
            }
        }
    }

    public boolean l(@NonNull String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) ? d.a.m.d.a.m(this.f4724a, str, str2) : invokeLL.booleanValue;
    }

    public final boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? d.a.m.b.a.i().l(str) : invokeL.booleanValue;
    }

    public boolean n(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            File file = new File(str);
            if (file.exists()) {
                Context context = this.f4724a;
                if (context == null ? false : shuoy.a().b(context, file)) {
                    return true;
                }
                try {
                    shuoy.a().a(this.f4724a, file);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                Context context2 = this.f4724a;
                if (context2 == null) {
                    return false;
                }
                return shuoy.a().b(context2, file);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            d.a.m.d.a.o(str);
        }
    }
}
