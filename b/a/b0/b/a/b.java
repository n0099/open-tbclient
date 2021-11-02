package b.a.b0.b.a;

import androidx.core.view.InputDeviceCompat;
import b.a.b0.i.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b extends PathClassLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ClassLoader f1347a;

    /* renamed from: b  reason: collision with root package name */
    public Method f1348b;

    /* renamed from: c  reason: collision with root package name */
    public Method f1349c;

    /* renamed from: d  reason: collision with root package name */
    public Method f1350d;

    /* renamed from: e  reason: collision with root package name */
    public Method f1351e;

    /* renamed from: f  reason: collision with root package name */
    public Set<String> f1352f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(ClassLoader classLoader, ClassLoader classLoader2) {
        super("", "", classLoader);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {classLoader, classLoader2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1], (ClassLoader) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1352f = new HashSet();
        this.f1347a = classLoader2;
        b(classLoader2);
        c(classLoader2);
        this.f1352f.add("android.widget.ViewStub");
        this.f1352f.add("android.widget.View");
        this.f1352f.add("android.webkit.ViewStub");
        this.f1352f.add("android.webkit.View");
        this.f1352f.add("android.app.ViewStub");
        this.f1352f.add("android.app.View");
        this.f1352f.add("com.google.android.gms.net.PlayServicesCronetProvider");
        this.f1352f.add("com.google.android.gms.net.GmsCoreCronetProvider");
        this.f1352f.add("org.chromium.net.impl.JavaCronetProvider");
    }

    public final void a(String str, ClassLoader classLoader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, classLoader) == null) {
            try {
                Field a2 = h.a(classLoader.getClass(), str);
                h.g(a2);
                h.k(a2, this, h.f(a2, classLoader));
            } catch (IllegalAccessException unused) {
            }
        }
    }

    public final void b(ClassLoader classLoader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, classLoader) == null) {
            a("pathList", classLoader);
        }
    }

    public final void c(ClassLoader classLoader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, classLoader) == null) {
            Class<?> cls = classLoader.getClass();
            Method b2 = h.b(cls, "findResource", String.class);
            this.f1348b = b2;
            b2.setAccessible(true);
            Method b3 = h.b(cls, "findResources", String.class);
            this.f1349c = b3;
            b3.setAccessible(true);
            Method b4 = h.b(cls, "findLibrary", String.class);
            this.f1350d = b4;
            b4.setAccessible(true);
            Method b5 = h.b(cls, "getPackage", String.class);
            this.f1351e = b5;
            b5.setAccessible(true);
        }
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Class<?> findClass(String str) throws ClassNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? super.findClass(str) : (Class) invokeL.objValue;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public String findLibrary(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            try {
                return (String) this.f1350d.invoke(this.f1347a, str);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return super.findLibrary(str);
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
                return super.findLibrary(str);
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
                return super.findLibrary(str);
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public URL findResource(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            try {
                return (URL) this.f1348b.invoke(this.f1347a, str);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return super.findResource(str);
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
                return super.findResource(str);
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
                return super.findResource(str);
            }
        }
        return (URL) invokeL.objValue;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Enumeration<URL> findResources(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            try {
                return (Enumeration) this.f1349c.invoke(this.f1347a, str);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return super.findResources(str);
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
                return super.findResources(str);
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
                return super.findResources(str);
            }
        }
        return (Enumeration) invokeL.objValue;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Package getPackage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            Package r0 = null;
            if (str != null && !str.isEmpty()) {
                try {
                    r0 = (Package) this.f1351e.invoke(this.f1347a, str);
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (IllegalArgumentException e3) {
                    e3.printStackTrace();
                } catch (InvocationTargetException e4) {
                    e4.printStackTrace();
                }
                if (r0 == null) {
                    r0 = super.getPackage(str);
                }
                if (r0 == null) {
                    return definePackage(str, "Unknown", XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT, "Unknown", "Unknown", XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT, "Unknown", null);
                }
            }
            return r0;
        }
        return (Package) invokeL.objValue;
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        Class<?> loadComponentClass;
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, z)) == null) {
            try {
                return this.f1347a.loadClass(str);
            } catch (ClassNotFoundException unused) {
                return (this.f1352f.contains(str) || (loadComponentClass = NPSManager.getInstance().loadComponentClass(str)) == null) ? super.loadClass(str, z) : loadComponentClass;
            }
        }
        return (Class) invokeLZ.objValue;
    }

    @Override // dalvik.system.BaseDexClassLoader
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return b.class.getName() + "[mBase=" + this.f1347a.toString() + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
