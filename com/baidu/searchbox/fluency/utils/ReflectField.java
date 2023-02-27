package com.baidu.searchbox.fluency.utils;

import android.text.TextUtils;
import androidx.transition.Transition;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.nps.main.manager.Bundle;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u0017*\u0004\b\u0000\u0010\u0001:\u0001\u0017B\u001f\u0012\f\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0004\u001a\u0004\u0018\u00018\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/fluency/utils/ReflectField;", "Type", "", Transition.MATCH_INSTANCE_STR, "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "prepare", "()V", "Ljava/lang/Class;", Bundle.EXTRA_KEY_CLAZZ, "Ljava/lang/Class;", "Ljava/lang/reflect/Field;", "field", "Ljava/lang/reflect/Field;", "", "fieldName", "Ljava/lang/String;", "", "init", "Z", "<init>", "(Ljava/lang/Class;Ljava/lang/String;)V", "Companion", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class ReflectField<Type> {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "ReflectField";
    public final Class<?> clazz;
    public Field field;
    public final String fieldName;
    public boolean init;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/fluency/utils/ReflectField$Companion;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ReflectField(Class<?> cls, String str) {
        this.clazz = cls;
        this.fieldName = str;
    }

    private final void prepare() {
        if (this.init || TextUtils.isEmpty(this.fieldName)) {
            return;
        }
        for (Class<?> cls = this.clazz; cls != null; cls = cls.getSuperclass()) {
            try {
                String str = this.fieldName;
                Intrinsics.checkNotNull(str);
                Field f = cls.getDeclaredField(str);
                Intrinsics.checkNotNullExpressionValue(f, "f");
                f.setAccessible(true);
                this.field = f;
                break;
            } catch (Exception unused) {
            }
        }
        this.init = true;
    }

    public final Type get(Object obj) {
        prepare();
        Field field = this.field;
        if (field == null) {
            Logcat logcat = Logcat.INSTANCE;
            logcat.e(TAG, "field " + this.fieldName + " is no exists.");
            return null;
        } else if (field == null) {
            return null;
        } else {
            try {
                return (Type) field.get(obj);
            } catch (Exception e) {
                Logcat logcat2 = Logcat.INSTANCE;
                logcat2.e(TAG, "get field error " + e + IStringUtil.EXTENSION_SEPARATOR);
                return null;
            }
        }
    }
}
