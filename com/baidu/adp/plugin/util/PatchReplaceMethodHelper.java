package com.baidu.adp.plugin.util;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginPatchAnnotation;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bm;
import dalvik.system.DexFile;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Enumeration;
/* loaded from: classes.dex */
public class PatchReplaceMethodHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a extends ClassLoader {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DexFile a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ClassLoader classLoader, DexFile dexFile) {
            super(classLoader);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {classLoader, dexFile};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ClassLoader) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dexFile;
        }

        @Override // java.lang.ClassLoader
        public Class<?> findClass(String str) throws ClassNotFoundException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                Class<?> loadClass = this.a.loadClass(str, this);
                if (loadClass == null && str.startsWith("com.baidu.adp.plugin.PluginPatchAnnotation")) {
                    return Class.forName(str);
                }
                if (loadClass != null) {
                    return loadClass;
                }
                throw new ClassNotFoundException(str);
            }
            return (Class) invokeL.objValue;
        }
    }

    public PatchReplaceMethodHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean loadPatch(Plugin plugin2, Context context, String str) {
        InterceptResult invokeLLL;
        PluginSetting q;
        PluginPatchAnnotation pluginPatchAnnotation;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, plugin2, context, str)) == null) {
            if (plugin2 != null && context != null && (q = PluginPackageManager.p().q(plugin2.getPackageName())) != null && !TextUtils.isEmpty(q.replaceMethodClasses)) {
                try {
                    DexFile loadDex = DexFile.loadDex(plugin2.getPluginApkFilePath(), str, 0);
                    a aVar = new a(context.getClassLoader(), loadDex);
                    Enumeration<String> entries = loadDex.entries();
                    while (true) {
                        Class<?> cls = null;
                        if (!entries.hasMoreElements()) {
                            return true;
                        }
                        Method[] declaredMethods = loadDex.loadClass(entries.nextElement(), aVar).getDeclaredMethods();
                        for (int i = 0; i < declaredMethods.length; i++) {
                            Annotation[] annotations = declaredMethods[i].getAnnotations();
                            if (annotations != null && annotations.length != 0 && (pluginPatchAnnotation = (PluginPatchAnnotation) declaredMethods[i].getAnnotation(PluginPatchAnnotation.class)) != null && cls == null) {
                                cls = Class.forName(pluginPatchAnnotation.clazz(), true, context.getClassLoader());
                            }
                        }
                        setFieldsFlag(cls);
                    }
                } catch (IOException e) {
                    bm b = bm.b();
                    b.p("plugin_load", "createClassLoader_failed", "method_patch_replace", "load_failed!" + e.getMessage());
                    e.printStackTrace();
                } catch (ClassNotFoundException e2) {
                    bm b2 = bm.b();
                    b2.p("plugin_load", "createClassLoader_failed", "method_patch_replace", "load_failed!" + e2.getMessage());
                    e2.printStackTrace();
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static void setFieldsFlag(Class<?> cls) {
        Field[] declaredFields;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, cls) != null) || cls == null || (declaredFields = cls.getDeclaredFields()) == null || declaredFields.length == 0) {
        }
    }
}
