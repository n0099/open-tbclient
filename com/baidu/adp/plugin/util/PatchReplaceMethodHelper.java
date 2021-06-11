package com.baidu.adp.plugin.util;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginPatchAnnotation;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import dalvik.system.DexFile;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Enumeration;
/* loaded from: classes.dex */
public class PatchReplaceMethodHelper {

    /* loaded from: classes.dex */
    public static class a extends ClassLoader {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DexFile f2261a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ClassLoader classLoader, DexFile dexFile) {
            super(classLoader);
            this.f2261a = dexFile;
        }

        @Override // java.lang.ClassLoader
        public Class<?> findClass(String str) throws ClassNotFoundException {
            Class<?> loadClass = this.f2261a.loadClass(str, this);
            if (loadClass == null && str.startsWith("com.baidu.adp.plugin.PluginPatchAnnotation")) {
                return Class.forName(str);
            }
            if (loadClass != null) {
                return loadClass;
            }
            throw new ClassNotFoundException(str);
        }
    }

    public static boolean loadPatch(Plugin plugin2, Context context, String str) {
        PluginSetting P;
        PluginPatchAnnotation pluginPatchAnnotation;
        if (plugin2 != null && context != null && (P = PluginPackageManager.O().P(plugin2.getPackageName())) != null && !TextUtils.isEmpty(P.replaceMethodClasses)) {
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
                    for (int i2 = 0; i2 < declaredMethods.length; i2++) {
                        Annotation[] annotations = declaredMethods[i2].getAnnotations();
                        if (annotations != null && annotations.length != 0 && (pluginPatchAnnotation = (PluginPatchAnnotation) declaredMethods[i2].getAnnotation(PluginPatchAnnotation.class)) != null && cls == null) {
                            cls = Class.forName(pluginPatchAnnotation.clazz(), true, context.getClassLoader());
                        }
                    }
                    setFieldsFlag(cls);
                }
            } catch (IOException e2) {
                d.a.c.h.h.a b2 = d.a.c.h.h.a.b();
                b2.r("plugin_load", "createClassLoader_failed", "method_patch_replace", "load_failed!" + e2.getMessage());
                e2.printStackTrace();
            } catch (ClassNotFoundException e3) {
                d.a.c.h.h.a b3 = d.a.c.h.h.a.b();
                b3.r("plugin_load", "createClassLoader_failed", "method_patch_replace", "load_failed!" + e3.getMessage());
                e3.printStackTrace();
            }
        }
        return false;
    }

    public static void setFieldsFlag(Class<?> cls) {
        Field[] declaredFields;
        if (cls != null && (declaredFields = cls.getDeclaredFields()) != null && declaredFields.length == 0) {
        }
    }
}
