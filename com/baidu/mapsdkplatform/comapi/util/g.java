package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public static volatile g a;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean b;
    public boolean c;
    public final List<f> d;
    public f e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(42760315, "Lcom/baidu/mapsdkplatform/comapi/util/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(42760315, "Lcom/baidu/mapsdkplatform/comapi/util/g;");
        }
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = false;
        this.c = true;
        this.d = new ArrayList();
        this.e = null;
    }

    public static g a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (g.class) {
                    if (a == null) {
                        a = new g();
                    }
                }
            }
            return a;
        }
        return (g) invokeV.objValue;
    }

    public f b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (f) invokeV.objValue;
    }

    private boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            boolean z = false;
            try {
                File file = new File(str + "/test.0");
                if (file.exists()) {
                    file.delete();
                }
                z = file.createNewFile();
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, context) != null) || this.b) {
            return;
        }
        this.b = true;
        try {
            this.c = false;
            this.e = new f(context);
            this.d.clear();
            this.d.add(this.e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (this.d.size() > 0) {
                f fVar = null;
                int i = 0;
                for (f fVar2 : this.d) {
                    if (new File(fVar2.b()).exists()) {
                        i++;
                        fVar = fVar2;
                    }
                }
                if (i == 0) {
                    f b = b(context);
                    this.e = b;
                    if (b == null) {
                        Iterator<f> it = this.d.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            f next = it.next();
                            if (a(context, next)) {
                                this.e = next;
                                break;
                            }
                        }
                    }
                } else if (i == 1) {
                    if (a(context, fVar)) {
                        this.e = fVar;
                    }
                } else {
                    this.e = b(context);
                }
                if (this.e == null) {
                    this.e = this.d.get(0);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            if (this.e != null && a(this.e.a())) {
                File file = new File(this.e.b());
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(this.e.c());
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                File file3 = new File(file2, ".nomedia");
                if (!file3.exists()) {
                    file3.createNewFile();
                    return;
                }
                return;
            }
            this.c = false;
            this.e = new f(context);
            this.d.clear();
            this.d.add(this.e);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public boolean a(Context context, f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, fVar)) == null) {
            String a2 = fVar.a();
            if (!a(a2)) {
                return false;
            }
            SharedPreferences.Editor edit = context.getSharedPreferences("map_pref", 0).edit();
            edit.putString("PREFFERED_SD_CARD", a2);
            return edit.commit();
        }
        return invokeLL.booleanValue;
    }

    public f b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            String string = context.getSharedPreferences("map_pref", 0).getString("PREFFERED_SD_CARD", "");
            if (string != null && string.length() > 0) {
                for (f fVar : this.d) {
                    if (fVar.a().equals(string)) {
                        return fVar;
                    }
                }
                return null;
            }
            return null;
        }
        return (f) invokeL.objValue;
    }
}
