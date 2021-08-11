package androidx.multidex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;
/* loaded from: classes.dex */
public final class MultiDex {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CODE_CACHE_NAME = "code_cache";
    public static final String CODE_CACHE_SECONDARY_FOLDER_NAME = "secondary-dexes";
    public static final boolean IS_VM_MULTIDEX_CAPABLE;
    public static final int MAX_SUPPORTED_SDK_VERSION = 20;
    public static final int MIN_SDK_VERSION = 4;
    public static final String NO_KEY_PREFIX = "";
    public static final String OLD_SECONDARY_FOLDER_NAME = "secondary-dexes";
    public static final String TAG = "MultiDex";
    public static final int VM_WITH_MULTIDEX_VERSION_MAJOR = 2;
    public static final int VM_WITH_MULTIDEX_VERSION_MINOR = 1;
    public static final Set<File> installedApk;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static final class V14 {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int EXTRACTED_SUFFIX_LENGTH = 4;
        public transient /* synthetic */ FieldHolder $fh;
        public final ElementConstructor elementConstructor;

        /* loaded from: classes.dex */
        public interface ElementConstructor {
            Object newInstance(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException;
        }

        /* loaded from: classes.dex */
        public static class ICSElementConstructor implements ElementConstructor {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final Constructor<?> elementConstructor;

            public ICSElementConstructor(Class<?> cls) throws SecurityException, NoSuchMethodException {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cls};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                Constructor<?> constructor = cls.getConstructor(File.class, ZipFile.class, DexFile.class);
                this.elementConstructor = constructor;
                constructor.setAccessible(true);
            }

            @Override // androidx.multidex.MultiDex.V14.ElementConstructor
            public Object newInstance(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, dexFile)) == null) ? this.elementConstructor.newInstance(file, new ZipFile(file), dexFile) : invokeLL.objValue;
            }
        }

        /* loaded from: classes.dex */
        public static class JBMR11ElementConstructor implements ElementConstructor {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final Constructor<?> elementConstructor;

            public JBMR11ElementConstructor(Class<?> cls) throws SecurityException, NoSuchMethodException {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cls};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                Constructor<?> constructor = cls.getConstructor(File.class, File.class, DexFile.class);
                this.elementConstructor = constructor;
                constructor.setAccessible(true);
            }

            @Override // androidx.multidex.MultiDex.V14.ElementConstructor
            public Object newInstance(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, dexFile)) == null) ? this.elementConstructor.newInstance(file, file, dexFile) : invokeLL.objValue;
            }
        }

        /* loaded from: classes.dex */
        public static class JBMR2ElementConstructor implements ElementConstructor {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final Constructor<?> elementConstructor;

            public JBMR2ElementConstructor(Class<?> cls) throws SecurityException, NoSuchMethodException {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cls};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                Constructor<?> constructor = cls.getConstructor(File.class, Boolean.TYPE, File.class, DexFile.class);
                this.elementConstructor = constructor;
                constructor.setAccessible(true);
            }

            @Override // androidx.multidex.MultiDex.V14.ElementConstructor
            public Object newInstance(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, dexFile)) == null) ? this.elementConstructor.newInstance(file, Boolean.FALSE, file, dexFile) : invokeLL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2036426223, "Landroidx/multidex/MultiDex$V14;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2036426223, "Landroidx/multidex/MultiDex$V14;");
            }
        }

        public V14() throws ClassNotFoundException, SecurityException, NoSuchMethodException {
            ElementConstructor jBMR2ElementConstructor;
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
            Class<?> cls = Class.forName("dalvik.system.DexPathList$Element");
            try {
                try {
                    jBMR2ElementConstructor = new ICSElementConstructor(cls);
                } catch (NoSuchMethodException unused) {
                    jBMR2ElementConstructor = new JBMR2ElementConstructor(cls);
                }
            } catch (NoSuchMethodException unused2) {
                jBMR2ElementConstructor = new JBMR11ElementConstructor(cls);
            }
            this.elementConstructor = jBMR2ElementConstructor;
        }

        public static void install(ClassLoader classLoader, List<? extends File> list) throws IOException, SecurityException, IllegalArgumentException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, classLoader, list) == null) {
                Object obj = MultiDex.findField(classLoader, "pathList").get(classLoader);
                Object[] makeDexElements = new V14().makeDexElements(list);
                try {
                    MultiDex.expandFieldArray(obj, "dexElements", makeDexElements);
                } catch (NoSuchFieldException unused) {
                    MultiDex.expandFieldArray(obj, "pathElements", makeDexElements);
                }
            }
        }

        private Object[] makeDexElements(List<? extends File> list) throws IOException, SecurityException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, list)) == null) {
                int size = list.size();
                Object[] objArr = new Object[size];
                for (int i2 = 0; i2 < size; i2++) {
                    File file = list.get(i2);
                    objArr[i2] = this.elementConstructor.newInstance(file, DexFile.loadDex(file.getPath(), optimizedPathFor(file), 0));
                }
                return objArr;
            }
            return (Object[]) invokeL.objValue;
        }

        public static String optimizedPathFor(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file)) == null) {
                File parentFile = file.getParentFile();
                String name = file.getName();
                return new File(parentFile, name.substring(0, name.length() - EXTRACTED_SUFFIX_LENGTH) + ".dex").getPath();
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class V19 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public V19() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static void install(ClassLoader classLoader, List<? extends File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
            IOException[] iOExceptionArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65537, null, classLoader, list, file) == null) {
                Object obj = MultiDex.findField(classLoader, "pathList").get(classLoader);
                ArrayList arrayList = new ArrayList();
                MultiDex.expandFieldArray(obj, "dexElements", makeDexElements(obj, new ArrayList(list), file, arrayList));
                if (arrayList.size() > 0) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        IOException iOException = (IOException) it.next();
                    }
                    Field findField = MultiDex.findField(obj, "dexElementsSuppressedExceptions");
                    IOException[] iOExceptionArr2 = (IOException[]) findField.get(obj);
                    if (iOExceptionArr2 == null) {
                        iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                    } else {
                        IOException[] iOExceptionArr3 = new IOException[arrayList.size() + iOExceptionArr2.length];
                        arrayList.toArray(iOExceptionArr3);
                        System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                        iOExceptionArr = iOExceptionArr3;
                    }
                    findField.set(obj, iOExceptionArr);
                    IOException iOException2 = new IOException("I/O exception during makeDexElement");
                    iOException2.initCause((Throwable) arrayList.get(0));
                    throw iOException2;
                }
            }
        }

        public static Object[] makeDexElements(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, obj, arrayList, file, arrayList2)) == null) ? (Object[]) MultiDex.findMethod(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class).invoke(obj, arrayList, file, arrayList2) : (Object[]) invokeLLLL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class V4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public V4() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static void install(ClassLoader classLoader, List<? extends File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, classLoader, list) == null) {
                int size = list.size();
                Field findField = MultiDex.findField(classLoader, "path");
                StringBuilder sb = new StringBuilder((String) findField.get(classLoader));
                String[] strArr = new String[size];
                File[] fileArr = new File[size];
                ZipFile[] zipFileArr = new ZipFile[size];
                DexFile[] dexFileArr = new DexFile[size];
                ListIterator<? extends File> listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    File next = listIterator.next();
                    String absolutePath = next.getAbsolutePath();
                    sb.append(':');
                    sb.append(absolutePath);
                    int previousIndex = listIterator.previousIndex();
                    strArr[previousIndex] = absolutePath;
                    fileArr[previousIndex] = next;
                    zipFileArr[previousIndex] = new ZipFile(next);
                    dexFileArr[previousIndex] = DexFile.loadDex(absolutePath, absolutePath + ".dex", 0);
                }
                findField.set(classLoader, sb.toString());
                MultiDex.expandFieldArray(classLoader, "mPaths", strArr);
                MultiDex.expandFieldArray(classLoader, "mFiles", fileArr);
                MultiDex.expandFieldArray(classLoader, "mZips", zipFileArr);
                MultiDex.expandFieldArray(classLoader, "mDexs", dexFileArr);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1810762938, "Landroidx/multidex/MultiDex;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1810762938, "Landroidx/multidex/MultiDex;");
                return;
            }
        }
        installedApk = new HashSet();
        IS_VM_MULTIDEX_CAPABLE = isVMMultidexCapable(System.getProperty("java.vm.version"));
    }

    public MultiDex() {
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

    public static void clearOldDexDir(Context context) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context) == null) {
            File file = new File(context.getFilesDir(), "secondary-dexes");
            if (file.isDirectory()) {
                r0 = "Clearing old secondary dex dir (" + file.getPath() + ").";
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    r0 = "Failed to list secondary dex dir content (" + file.getPath() + ").";
                    return;
                }
                for (File file2 : listFiles) {
                    String str = "Trying to delete old file " + file2.getPath() + " of size " + file2.length();
                    if (file2.delete()) {
                        String str2 = "Deleted old file " + file2.getPath();
                    } else {
                        String str3 = "Failed to delete old file " + file2.getPath();
                    }
                }
                if (!file.delete()) {
                    String str4 = "Failed to delete secondary dex dir " + file.getPath();
                    return;
                }
                String str5 = "Deleted old secondary dex dir " + file.getPath();
            }
        }
    }

    public static void doInstallation(Context context, File file, File file2, String str, String str2, boolean z) throws IOException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{context, file, file2, str, str2, Boolean.valueOf(z)}) == null) {
            synchronized (installedApk) {
                if (installedApk.contains(file)) {
                    return;
                }
                installedApk.add(file);
                if (Build.VERSION.SDK_INT > 20) {
                    String str3 = "MultiDex is not guaranteed to work in SDK version " + Build.VERSION.SDK_INT + ": SDK version higher than 20 should be backed by runtime with built-in multidex capabilty but it's not the case here: java.vm.version=\"" + System.getProperty("java.vm.version") + "\"";
                }
                try {
                    ClassLoader classLoader = context.getClassLoader();
                    if (classLoader == null) {
                        return;
                    }
                    try {
                        clearOldDexDir(context);
                    } catch (Throwable unused) {
                    }
                    File dexDir = getDexDir(context, file2, str);
                    MultiDexExtractor multiDexExtractor = new MultiDexExtractor(file, dexDir);
                    IOException e2 = null;
                    try {
                        installSecondaryDexes(classLoader, dexDir, multiDexExtractor.load(context, str2, false));
                    } catch (IOException e3) {
                        if (z) {
                            installSecondaryDexes(classLoader, dexDir, multiDexExtractor.load(context, str2, true));
                        } else {
                            throw e3;
                        }
                    }
                    try {
                        multiDexExtractor.close();
                    } catch (IOException e4) {
                        e2 = e4;
                    }
                    if (e2 != null) {
                        throw e2;
                    }
                } catch (RuntimeException unused2) {
                }
            }
        }
    }

    public static void expandFieldArray(Object obj, String str, Object[] objArr) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, obj, str, objArr) == null) {
            Field findField = findField(obj, str);
            Object[] objArr2 = (Object[]) findField.get(obj);
            Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
            System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
            System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
            findField.set(obj, objArr3);
        }
    }

    public static Field findField(Object obj, String str) throws NoSuchFieldException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, obj, str)) == null) {
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

    public static Method findMethod(Object obj, String str, Class<?>... clsArr) throws NoSuchMethodException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, obj, str, clsArr)) == null) {
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

    public static ApplicationInfo getApplicationInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            try {
                return context.getApplicationInfo();
            } catch (RuntimeException unused) {
                return null;
            }
        }
        return (ApplicationInfo) invokeL.objValue;
    }

    public static File getDexDir(Context context, File file, String str) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, context, file, str)) == null) {
            File file2 = new File(file, CODE_CACHE_NAME);
            try {
                mkdirChecked(file2);
            } catch (IOException unused) {
                file2 = new File(context.getFilesDir(), CODE_CACHE_NAME);
                mkdirChecked(file2);
            }
            File file3 = new File(file2, str);
            mkdirChecked(file3);
            return file3;
        }
        return (File) invokeLLL.objValue;
    }

    public static void install(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, null, context) == null) || IS_VM_MULTIDEX_CAPABLE) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 4) {
            try {
                ApplicationInfo applicationInfo = getApplicationInfo(context);
                if (applicationInfo == null) {
                    return;
                }
                doInstallation(context, new File(applicationInfo.sourceDir), new File(applicationInfo.dataDir), "secondary-dexes", "", true);
                return;
            } catch (Exception e2) {
                throw new RuntimeException("MultiDex installation failed (" + e2.getMessage() + ").");
            }
        }
        throw new RuntimeException("MultiDex installation failed. SDK " + Build.VERSION.SDK_INT + " is unsupported. Min SDK version is 4.");
    }

    public static void installInstrumentation(Context context, Context context2) {
        ApplicationInfo applicationInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65549, null, context, context2) == null) || IS_VM_MULTIDEX_CAPABLE) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 4) {
            try {
                ApplicationInfo applicationInfo2 = getApplicationInfo(context);
                if (applicationInfo2 == null || (applicationInfo = getApplicationInfo(context2)) == null) {
                    return;
                }
                String str = context.getPackageName() + ".";
                File file = new File(applicationInfo.dataDir);
                doInstallation(context2, new File(applicationInfo2.sourceDir), file, str + "secondary-dexes", str, false);
                doInstallation(context2, new File(applicationInfo.sourceDir), file, "secondary-dexes", "", false);
                return;
            } catch (Exception e2) {
                throw new RuntimeException("MultiDex installation failed (" + e2.getMessage() + ").");
            }
        }
        throw new RuntimeException("MultiDex installation failed. SDK " + Build.VERSION.SDK_INT + " is unsupported. Min SDK version is 4.");
    }

    public static void installSecondaryDexes(ClassLoader classLoader, File file, List<? extends File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException, SecurityException, ClassNotFoundException, InstantiationException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65550, null, classLoader, file, list) == null) || list.isEmpty()) {
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            V19.install(classLoader, list, file);
        } else if (i2 >= 14) {
            V14.install(classLoader, list);
        } else {
            V4.install(classLoader, list);
        }
    }

    public static boolean isVMMultidexCapable(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            boolean z = false;
            if (str != null) {
                Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
                if (matcher.matches()) {
                    try {
                        int parseInt = Integer.parseInt(matcher.group(1));
                        int parseInt2 = Integer.parseInt(matcher.group(2));
                        if (parseInt > 2 || (parseInt == 2 && parseInt2 >= 1)) {
                            z = true;
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("VM with version ");
            sb.append(str);
            sb.append(z ? " has multidex support" : " does not have multidex support");
            sb.toString();
            return z;
        }
        return invokeL.booleanValue;
    }

    public static void mkdirChecked(File file) throws IOException {
        File parentFile;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, file) == null) {
            file.mkdir();
            if (file.isDirectory()) {
                return;
            }
            if (file.getParentFile() == null) {
                r0 = "Failed to create dir " + file.getPath() + ". Parent file is null.";
            } else {
                str = "Failed to create dir " + file.getPath() + ". parent file is a dir " + parentFile.isDirectory() + ", a file " + parentFile.isFile() + ", exists " + parentFile.exists() + ", readable " + parentFile.canRead() + ", writable " + parentFile.canWrite();
            }
            throw new IOException("Failed to create directory " + file.getPath());
        }
    }
}
