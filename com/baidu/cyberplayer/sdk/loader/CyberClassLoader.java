package com.baidu.cyberplayer.sdk.loader;

import android.os.Build;
import android.util.AndroidRuntimeException;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexFile;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Keep
/* loaded from: classes10.dex */
public class CyberClassLoader extends BaseDexClassLoader {
    public static /* synthetic */ Interceptable $ic;
    public static Class a;

    /* renamed from: b  reason: collision with root package name */
    public static Class f34644b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void b(ClassLoader classLoader, File file) throws Throwable {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, classLoader, file) == null) {
                CyberClassLoader.b(CyberClassLoader.b(classLoader, "pathList").get(classLoader), "nativeLibraryDirectories", new File[]{file});
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void b(ClassLoader classLoader, File file) throws Throwable {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, classLoader, file) == null) {
                Object obj = CyberClassLoader.b(classLoader, "pathList").get(classLoader);
                List list = (List) CyberClassLoader.b(obj, "nativeLibraryDirectories").get(obj);
                list.add(0, file);
                Method b2 = CyberClassLoader.b(obj, "makePathElements", (Class<?>[]) new Class[]{List.class, File.class, List.class});
                ArrayList arrayList = new ArrayList();
                list.addAll((List) CyberClassLoader.b(obj, "systemNativeLibraryDirectories").get(obj));
                Object[] objArr = {list, null, arrayList};
                Field b3 = CyberClassLoader.b(obj, "nativeLibraryPathElements");
                b3.setAccessible(true);
                b3.set(obj, (Object[]) b2.invoke(obj, objArr));
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void b(ClassLoader classLoader, File file) throws Throwable {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, classLoader, file) == null) {
                Object obj = CyberClassLoader.b(classLoader, "pathList").get(classLoader);
                List list = (List) CyberClassLoader.b(obj, "nativeLibraryDirectories").get(obj);
                list.add(0, file);
                Method b2 = CyberClassLoader.b(obj, "makePathElements", (Class<?>[]) new Class[]{List.class});
                list.addAll((List) CyberClassLoader.b(obj, "systemNativeLibraryDirectories").get(obj));
                Object[] objArr = {list};
                Field b3 = CyberClassLoader.b(obj, "nativeLibraryPathElements");
                b3.setAccessible(true);
                b3.set(obj, (Object[]) b2.invoke(obj, objArr));
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void b(ClassLoader classLoader, File file) throws Throwable {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, classLoader, file) == null) {
                String path = file.getPath();
                Field b2 = CyberClassLoader.b(classLoader, "libPath");
                b2.set(classLoader, ((String) b2.get(classLoader)) + ':' + path);
                Field b3 = CyberClassLoader.b(classLoader, "libraryPathElements");
                List list = (List) b3.get(classLoader);
                list.add(0, path);
                b3.set(classLoader, list);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-705816443, "Lcom/baidu/cyberplayer/sdk/loader/CyberClassLoader;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-705816443, "Lcom/baidu/cyberplayer/sdk/loader/CyberClassLoader;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CyberClassLoader(String str, File file, String str2, ClassLoader classLoader) {
        super(a(str, "super()"), file, str2, classLoader);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, file, str2, classLoader};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (File) objArr2[1], (String) objArr2[2], (ClassLoader) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 21 || !str.endsWith(".so")) {
            return;
        }
        CyberLog.d("CyberClassLoader", "makeDexElements for our package. < L");
        a(str, file, str2, classLoader);
    }

    public static Object a(Class cls, Object obj, String str) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, cls, obj, str)) == null) {
            Field declaredField = cls.getDeclaredField(str);
            boolean isAccessible = declaredField.isAccessible();
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            declaredField.setAccessible(isAccessible);
            return obj2;
        }
        return invokeLLL.objValue;
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            CyberLog.d("CyberClassLoader", str2);
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static void a() throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            if (a == null || f34644b == null) {
                Class<?> cls = Class.forName("dalvik.system.DexPathList");
                a = cls;
                Class<?>[] declaredClasses = cls.getDeclaredClasses();
                int length = declaredClasses.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    Class<?> cls2 = declaredClasses[i2];
                    if (cls2.getSimpleName().equals("Element")) {
                        f34644b = cls2;
                        break;
                    }
                    i2++;
                }
                if (f34644b == null) {
                    throw new AndroidRuntimeException("DexPathList$Element not found!");
                }
            }
        }
    }

    public static void a(Class cls, Object obj, String str, Object obj2) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65543, null, cls, obj, str, obj2) == null) {
            Field declaredField = cls.getDeclaredField(str);
            boolean isAccessible = declaredField.isAccessible();
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
            declaredField.setAccessible(isAccessible);
        }
    }

    public static void a(ClassLoader classLoader, File file) throws Throwable {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, classLoader, file) == null) {
            if (file == null || !file.exists()) {
                CyberLog.e("CyberClassLoader", "installNativeLibraryPath, folder (" + file + ") is illegal");
            } else if ((Build.VERSION.SDK_INT == 25 && Build.VERSION.PREVIEW_SDK_INT != 0) || (i2 = Build.VERSION.SDK_INT) > 25) {
                try {
                    c.b(classLoader, file);
                } catch (Throwable th) {
                    CyberLog.e("CyberClassLoader", "installNativeLibraryPath, v25 fail, sdk: " + Build.VERSION.SDK_INT + ", error: " + th.getMessage() + ", try to fallback to V23");
                }
            } else {
                if (i2 >= 23) {
                    try {
                        b.b(classLoader, file);
                        return;
                    } catch (Throwable th2) {
                        CyberLog.e("CyberClassLoader", "installNativeLibraryPath, v23 fail, sdk: " + Build.VERSION.SDK_INT + ", error: " + th2.getMessage() + ", try to fallback to V14");
                    }
                } else if (i2 < 14) {
                    d.b(classLoader, file);
                    return;
                }
                a.b(classLoader, file);
            }
        }
    }

    private void a(String str, File file, String str2, ClassLoader classLoader) {
        Object newInstance;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65546, this, str, file, str2, classLoader) == null) {
            try {
                a();
                String replace = new File(str).getName().replace(".so", ".dex");
                DexFile loadDex = DexFile.loadDex(str, file.getAbsolutePath() + File.separator + replace, 0);
                Constructor<?> constructor = f34644b.getConstructors()[0];
                int length = constructor.getParameterTypes().length;
                if (length == 4) {
                    newInstance = constructor.newInstance(new File(str), Boolean.FALSE, null, loadDex);
                } else if (length != 3) {
                    throw new Exception("Unsupported:" + constructor.toGenericString());
                } else {
                    newInstance = constructor.newInstance(new File(str), null, loadDex);
                }
                Object newInstance2 = Array.newInstance(f34644b, 1);
                Array.set(newInstance2, 0, newInstance);
                Object a2 = a(BaseDexClassLoader.class, this, "pathList");
                a(a, a2, "dexElements", newInstance2);
                if (Build.VERSION.SDK_INT >= 19) {
                    a(a, a2, "dexElementsSuppressedExceptions", (Object) null);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                throw new AndroidRuntimeException(e2);
            }
        }
    }

    public static void addNativeLibraryDirectories(ClassLoader classLoader, String[] strArr) {
        StringBuilder sb;
        String th;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, classLoader, strArr) == null) || strArr == null || strArr.length == 0) {
            return;
        }
        for (String str : strArr) {
            try {
                a(classLoader, new File(str));
            } catch (Exception e2) {
                sb = new StringBuilder();
                sb.append("addNativeLibraryDirectories:");
                th = e2.toString();
                sb.append(th);
                CyberLog.e("CyberClassLoader", sb.toString());
            } catch (Throwable th2) {
                sb = new StringBuilder();
                sb.append("addNativeLibraryDirectories:");
                th = th2.toString();
                sb.append(th);
                CyberLog.e("CyberClassLoader", sb.toString());
            }
        }
    }

    public static Field b(Object obj, String str) throws NoSuchFieldException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, obj, str)) == null) {
            for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
                try {
                    Field declaredField = cls.getDeclaredField(str);
                    if (!declaredField.isAccessible()) {
                        declaredField.setAccessible(true);
                    }
                    return declaredField;
                } catch (NoSuchFieldException unused) {
                }
            }
            throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
        }
        return (Field) invokeLL.objValue;
    }

    public static Method b(Object obj, String str, Class<?>... clsArr) throws NoSuchMethodException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, obj, str, clsArr)) == null) {
            for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                    if (!declaredMethod.isAccessible()) {
                        declaredMethod.setAccessible(true);
                    }
                    return declaredMethod;
                } catch (NoSuchMethodException unused) {
                }
            }
            throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
        }
        return (Method) invokeLLL.objValue;
    }

    public static void b(Object obj, String str, Object[] objArr) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, obj, str, objArr) == null) {
            Field b2 = b(obj, str);
            Object[] objArr2 = (Object[]) b2.get(obj);
            Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
            System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
            System.arraycopy(objArr2, 0, objArr3, objArr.length, objArr2.length);
            b2.set(obj, objArr3);
        }
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str) throws ClassNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str != null) {
                try {
                    if (str.startsWith("com.baidu.media.duplayer.") || str.startsWith("com.baidu.media.dlna.") || str.startsWith("com.baidu.media.ext.") || str.startsWith("com.baidu.media.extractor.") || str.startsWith("com.baidu.media.kernelnet.") || str.startsWith("com.baidu.media.pcdn.") || str.startsWith("com.baidu.media.recorder.") || str.startsWith("com.baidu.cybermedia.ext.rtc.") || str.startsWith("com.baidu.cloud.") || str.startsWith("com.baidu.cloudbase.") || str.startsWith("com.baidu.rtc.") || str.startsWith("org.webrtc.") || str.startsWith("tv.danmaku.ijk.media.player.") || str.startsWith("com.baidu.media.playerconfig") || str.startsWith("com.baidu.media.videodownload")) {
                        return findClass(str);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return super.loadClass(str);
        }
        return (Class) invokeL.objValue;
    }
}
