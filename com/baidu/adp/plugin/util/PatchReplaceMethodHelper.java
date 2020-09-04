package com.baidu.adp.plugin.util;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginNative;
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
    private PatchReplaceMethodHelper() {
    }

    public static boolean loadPatch(Plugin plugin2, Context context, String str) {
        Class<?> cls;
        if (plugin2 == null || context == null) {
            return false;
        }
        PluginSetting cw = PluginPackageManager.pO().cw(plugin2.getPackageName());
        if (cw == null || TextUtils.isEmpty(cw.replaceMethodClasses)) {
            return false;
        }
        try {
            final DexFile loadDex = DexFile.loadDex(plugin2.getPluginApkFilePath(), str, 0);
            ClassLoader classLoader = new ClassLoader(context.getClassLoader()) { // from class: com.baidu.adp.plugin.util.PatchReplaceMethodHelper.1
                @Override // java.lang.ClassLoader
                protected Class<?> findClass(String str2) throws ClassNotFoundException {
                    Class<?> loadClass = loadDex.loadClass(str2, this);
                    if (loadClass == null && str2.startsWith("com.baidu.adp.plugin.PluginPatchAnnotation")) {
                        return Class.forName(str2);
                    }
                    if (loadClass == null) {
                        throw new ClassNotFoundException(str2);
                    }
                    return loadClass;
                }
            };
            Enumeration<String> entries = loadDex.entries();
            while (entries.hasMoreElements()) {
                Method[] declaredMethods = loadDex.loadClass(entries.nextElement(), classLoader).getDeclaredMethods();
                int i = 0;
                Class<?> cls2 = null;
                while (i < declaredMethods.length) {
                    Annotation[] annotations = declaredMethods[i].getAnnotations();
                    if (annotations != null) {
                        if (annotations.length == 0) {
                            cls = cls2;
                        } else {
                            PluginPatchAnnotation pluginPatchAnnotation = (PluginPatchAnnotation) declaredMethods[i].getAnnotation(PluginPatchAnnotation.class);
                            if (pluginPatchAnnotation == null) {
                                cls = cls2;
                            } else {
                                if (cls2 == null) {
                                    cls2 = Class.forName(pluginPatchAnnotation.clazz(), true, context.getClassLoader());
                                }
                                PluginNative.replaceMethod(cls2.getDeclaredMethod(pluginPatchAnnotation.method(), declaredMethods[i].getParameterTypes()), declaredMethods[i]);
                            }
                        }
                        i++;
                        cls2 = cls;
                    }
                    cls = cls2;
                    i++;
                    cls2 = cls;
                }
                setFieldsFlag(cls2);
            }
            return true;
        } catch (IOException e) {
            com.baidu.adp.plugin.b.a.py().h("plugin_load", "createClassLoader_failed", "method_patch_replace", "load_failed!" + e.getMessage());
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e2) {
            com.baidu.adp.plugin.b.a.py().h("plugin_load", "createClassLoader_failed", "method_patch_replace", "load_failed!" + e2.getMessage());
            e2.printStackTrace();
            return false;
        } catch (NoSuchMethodException e3) {
            com.baidu.adp.plugin.b.a.py().h("plugin_load", "createClassLoader_failed", "method_patch_replace", "load_failed!" + e3.getMessage());
            e3.printStackTrace();
            return false;
        }
    }

    private static void setFieldsFlag(Class<?> cls) {
        Field[] declaredFields;
        if (cls != null && (declaredFields = cls.getDeclaredFields()) != null && declaredFields.length != 0) {
            for (Field field : declaredFields) {
                PluginNative.setFieldPublicFlag(field);
            }
        }
    }
}
