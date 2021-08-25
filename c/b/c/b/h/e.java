package c.b.c.b.h;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import c.b.c.b.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f31456a;

    /* loaded from: classes4.dex */
    public class a implements FilenameFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, str)) == null) ? str != null && str.endsWith(".npth") : invokeLL.booleanValue;
        }
    }

    public e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31456a = context;
    }

    public final com.bytedance.tea.crash.c a(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jSONObject)) == null) {
            if (jSONObject == null && TextUtils.isEmpty(str)) {
                return null;
            }
            if (str.startsWith("launch_")) {
                return com.bytedance.tea.crash.c.f68727a;
            }
            if (str.startsWith("anr_")) {
                return com.bytedance.tea.crash.c.f68730d;
            }
            if (str.startsWith("java_")) {
                if (jSONObject.optInt("is_dart") == 1) {
                    return com.bytedance.tea.crash.c.f68733g;
                }
                if (jSONObject.optInt("isJava") == 1) {
                    return com.bytedance.tea.crash.c.f68728b;
                }
            }
            return null;
        }
        return (com.bytedance.tea.crash.c) invokeLL.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                SharedPreferences sharedPreferences = this.f31456a.getSharedPreferences("npth", 0);
                long j2 = sharedPreferences.getLong("history_time", -1L);
                if (j2 < 0) {
                    sharedPreferences.edit().putLong("history_time", System.currentTimeMillis()).apply();
                } else if (System.currentTimeMillis() - j2 > 86400000) {
                    l.e.f(l.i.c(this.f31456a));
                    sharedPreferences.edit().putLong("history_time", System.currentTimeMillis()).apply();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            b();
            if (z) {
                e();
            }
        }
    }

    @Nullable
    public final File[] d(File file, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, file, str)) == null) {
            if (file.exists()) {
                if (TextUtils.isEmpty(str)) {
                    return file.listFiles();
                }
                return file.listFiles(new a(this));
            }
            return null;
        }
        return (File[]) invokeLL.objValue;
    }

    public final void e() {
        File[] d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (d2 = d(l.i.a(this.f31456a), ".npth")) == null) {
            return;
        }
        Arrays.sort(d2, Collections.reverseOrder());
        for (int i2 = 0; i2 < d2.length && i2 < 50; i2++) {
            File file = d2[i2];
            try {
                if (c.b.c.b.c.b.a().d(file.getAbsolutePath())) {
                    l.e.f(file);
                } else {
                    c.b.c.b.e.c j2 = l.e.j(file.getAbsolutePath());
                    if (j2 != null && j2.e() != null) {
                        JSONObject e2 = j2.e();
                        a(file.getName(), e2);
                        j2.e().put("upload_scene", "launch_scan");
                        if (com.bytedance.tea.crash.upload.b.d(j2.a(), e2.toString(), j2.g()).a() && !l.e.f(file)) {
                            c.b.c.b.c.b.a().c(c.b.c.b.c.a.a.a(file.getAbsolutePath()));
                        }
                    }
                }
            } catch (Exception e3) {
                l.k.c(e3);
            }
        }
    }
}
