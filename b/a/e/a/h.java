package b.a.e.a;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static h f1462d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Resources f1463a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<String> f1464b;

    /* renamed from: c  reason: collision with root package name */
    public HashSet<String> f1465c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1304019342, "Lb/a/e/a/h;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1304019342, "Lb/a/e/a/h;");
        }
    }

    public h() {
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
        this.f1463a = null;
        this.f1464b = null;
        this.f1465c = null;
    }

    public static h a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f1462d == null) {
                synchronized (h.class) {
                    if (f1462d == null) {
                        f1462d = new h();
                    }
                }
            }
            return f1462d;
        }
        return (h) invokeV.objValue;
    }

    public synchronized void b(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            synchronized (this) {
                if (!TextUtils.isEmpty(str2)) {
                    if (this.f1463a != null) {
                        if (!TextUtils.isEmpty(str)) {
                            if (this.f1465c == null) {
                                this.f1465c = new HashSet<>();
                            }
                            if (this.f1465c.contains(str)) {
                                b.a.e.i.h.a.b().o("plugin_load", "repeat_inject_res", str, str2);
                            }
                            this.f1465c.add(str);
                        }
                        if (this.f1464b == null) {
                            this.f1464b = new ArrayList<>();
                        }
                        if (this.f1464b.contains(str2)) {
                            return;
                        }
                        if (Build.VERSION.SDK_INT >= 20) {
                            b.a.e.i.k.d.a(this.f1463a.getAssets(), V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{str2});
                        } else {
                            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                            if (this.f1464b.size() > 0) {
                                Iterator<String> it = this.f1464b.iterator();
                                while (it.hasNext()) {
                                    b.a.e.i.k.d.a(assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{it.next()});
                                }
                            }
                            b.a.e.i.k.d.a(assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{str2});
                            b.a.e.i.k.d.a(assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                            this.f1463a = new Resources(assetManager, this.f1463a.getDisplayMetrics(), this.f1463a.getConfiguration());
                        }
                        this.f1464b.add(str2);
                        return;
                    }
                    throw new RuntimeException("hostResources is null");
                }
                throw new IllegalArgumentException("param resPath is null");
            }
        }
    }

    public synchronized void c(Resources resources) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, resources) == null) {
            synchronized (this) {
                this.f1463a = resources;
            }
        }
    }

    public synchronized Resources getResources() {
        InterceptResult invokeV;
        Resources resources;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                resources = this.f1463a;
            }
            return resources;
        }
        return (Resources) invokeV.objValue;
    }
}
