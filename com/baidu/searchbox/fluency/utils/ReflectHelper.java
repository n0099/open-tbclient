package com.baidu.searchbox.fluency.utils;

import androidx.exifinterface.media.ExifInterface;
import androidx.transition.Transition;
import com.baidu.nps.main.manager.Bundle;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J7\u0010\b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00012\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ7\u0010\u000e\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ=\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u00042\u001a\u0010\u0011\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00020\u0010\"\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/fluency/utils/ReflectHelper;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", Bundle.EXTRA_KEY_CLAZZ, "", "fieldName", "", Transition.MATCH_INSTANCE_STR, CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "name", "defaultValue", "", "isHard", "reflectField", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Z)Ljava/lang/Object;", "", "argTypes", "Ljava/lang/reflect/Method;", "reflectMethod", "(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "<init>", "()V", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class ReflectHelper {
    public static final ReflectHelper INSTANCE = new ReflectHelper();

    public final <T> T get(Class<?> cls, String str, Object obj) {
        return (T) new ReflectField(cls, str).get(obj);
    }

    public final <T> T reflectField(Object obj, String name, T t, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (obj == null) {
            return null;
        }
        if (z) {
            try {
                Object invoke = Class.class.getDeclaredMethod("getDeclaredField", String.class).invoke(obj.getClass(), name);
                if (invoke != null) {
                    Field field = (Field) invoke;
                    field.setAccessible(true);
                    return (T) field.get(obj);
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Field");
            } catch (Exception e) {
                Logcat logcat = Logcat.INSTANCE;
                logcat.e(ReflectHelperKt.TAG, "[reflectField] " + e);
            }
        } else {
            try {
                Field field2 = obj.getClass().getDeclaredField(name);
                Intrinsics.checkNotNullExpressionValue(field2, "field");
                field2.setAccessible(true);
                return (T) field2.get(obj);
            } catch (Exception e2) {
                Logcat logcat2 = Logcat.INSTANCE;
                logcat2.e(ReflectHelperKt.TAG, "[reflectField] " + e2);
            }
        }
        return t;
    }

    public final Method reflectMethod(Object obj, String name, Class<?>... argTypes) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(argTypes, "argTypes");
        if (obj == null) {
            return null;
        }
        try {
            Method method = obj.getClass().getDeclaredMethod(name, (Class[]) Arrays.copyOf(argTypes, argTypes.length));
            Intrinsics.checkNotNullExpressionValue(method, "method");
            method.setAccessible(true);
            return method;
        } catch (Exception e) {
            Logcat logcat = Logcat.INSTANCE;
            logcat.e(ReflectHelperKt.TAG, "[reflectMethod] " + e);
            return null;
        }
    }
}
