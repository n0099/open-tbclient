package c.a.d.k;

import android.annotation.TargetApi;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static File a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void b(ClassLoader classLoader, File file) throws Throwable {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, classLoader, file) == null) {
                c.a.d.k.c.a(c.a.d.k.c.b(classLoader, "pathList").get(classLoader), "nativeLibraryDirectories", new File[]{file});
            }
        }
    }

    /* renamed from: c.a.d.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0096b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static void b(ClassLoader classLoader, File file) throws Throwable {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, classLoader, file) == null) {
                Object obj = c.a.d.k.c.b(classLoader, "pathList").get(classLoader);
                List list = (List) c.a.d.k.c.b(obj, "nativeLibraryDirectories").get(obj);
                if (list == null) {
                    list = new ArrayList(2);
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (file.equals((File) it.next()) || file.equals(b.a)) {
                        it.remove();
                        break;
                    }
                    while (it.hasNext()) {
                    }
                }
                list.add(0, file);
                Collection collection = (List) c.a.d.k.c.b(obj, "systemNativeLibraryDirectories").get(obj);
                if (collection == null) {
                    collection = new ArrayList(2);
                }
                Method c2 = c.a.d.k.c.c(obj, "makePathElements", List.class, File.class, List.class);
                ArrayList arrayList = new ArrayList();
                list.addAll(collection);
                Object[] objArr = {list, null, arrayList};
                Field b2 = c.a.d.k.c.b(obj, "nativeLibraryPathElements");
                b2.setAccessible(true);
                b2.set(obj, (Object[]) c2.invoke(obj, objArr));
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static void b(ClassLoader classLoader, File file) throws Throwable {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, classLoader, file) == null) {
                Object obj = c.a.d.k.c.b(classLoader, "pathList").get(classLoader);
                List list = (List) c.a.d.k.c.b(obj, "nativeLibraryDirectories").get(obj);
                if (list == null) {
                    list = new ArrayList(2);
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (file.equals((File) it.next()) || file.equals(b.a)) {
                        it.remove();
                        break;
                    }
                    while (it.hasNext()) {
                    }
                }
                list.add(0, file);
                Collection collection = (List) c.a.d.k.c.b(obj, "systemNativeLibraryDirectories").get(obj);
                if (collection == null) {
                    collection = new ArrayList(2);
                }
                Method c2 = c.a.d.k.c.c(obj, "makePathElements", List.class);
                list.addAll(collection);
                Object[] objArr = {list};
                Field b2 = c.a.d.k.c.b(obj, "nativeLibraryPathElements");
                b2.setAccessible(true);
                b2.set(obj, (Object[]) c2.invoke(obj, objArr));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1528864274, "Lc/a/d/k/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1528864274, "Lc/a/d/k/b;");
        }
    }

    @TargetApi(23)
    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                return Build.VERSION.PREVIEW_SDK_INT;
            } catch (Throwable unused) {
                return 1;
            }
        }
        return invokeV.intValue;
    }

    public static synchronized boolean c(ClassLoader classLoader, File file) throws Throwable {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, classLoader, file)) == null) {
            synchronized (b.class) {
                if (classLoader != null && file != null) {
                    if (file.exists()) {
                        int i2 = Build.VERSION.SDK_INT;
                        if ((i2 == 25 && b() != 0) || i2 > 25) {
                            c.b(classLoader, file);
                        } else if (i2 >= 23) {
                            C0096b.b(classLoader, file);
                        } else if (i2 >= 14) {
                            a.b(classLoader, file);
                        }
                        a = file;
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static synchronized boolean d(ClassLoader classLoader, String str) throws Throwable {
        InterceptResult invokeLL;
        boolean c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, classLoader, str)) == null) {
            synchronized (b.class) {
                c2 = c(classLoader, new File(str));
            }
            return c2;
        }
        return invokeLL.booleanValue;
    }
}
