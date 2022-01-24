package com.baidu.searchbox.fluency.utils;

import android.text.TextUtils;
import androidx.transition.Transition;
import com.baidu.nps.main.manager.Bundle;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u0017*\u0004\b\u0000\u0010\u0001:\u0001\u0017B\u001f\u0012\f\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0004\u001a\u0004\u0018\u00018\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/fluency/utils/ReflectField;", "Type", "", Transition.MATCH_INSTANCE_STR, "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "prepare", "()V", "Ljava/lang/Class;", Bundle.EXTRA_KEY_CLAZZ, "Ljava/lang/Class;", "Ljava/lang/reflect/Field;", "field", "Ljava/lang/reflect/Field;", "", "fieldName", "Ljava/lang/String;", "", "init", "Z", "<init>", "(Ljava/lang/Class;Ljava/lang/String;)V", "Companion", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes11.dex */
public final class ReflectField<Type> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Companion Companion;
    public static final String TAG = "ReflectField";
    public transient /* synthetic */ FieldHolder $fh;
    public final Class<?> clazz;
    public Field field;
    public final String fieldName;
    public boolean init;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/fluency/utils/ReflectField$Companion;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes11.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Companion() {
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

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1343475621, "Lcom/baidu/searchbox/fluency/utils/ReflectField;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1343475621, "Lcom/baidu/searchbox/fluency/utils/ReflectField;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    public ReflectField(Class<?> cls, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.clazz = cls;
        this.fieldName = str;
    }

    private final void prepare() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || this.init || TextUtils.isEmpty(this.fieldName)) {
            return;
        }
        for (Class<?> cls = this.clazz; cls != null; cls = cls.getSuperclass()) {
            try {
                String str = this.fieldName;
                Intrinsics.checkNotNull(str);
                Field f2 = cls.getDeclaredField(str);
                Intrinsics.checkNotNullExpressionValue(f2, "f");
                f2.setAccessible(true);
                this.field = f2;
                break;
            } catch (Exception unused) {
            }
        }
        this.init = true;
    }

    public final Type get(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            prepare();
            Field field = this.field;
            if (field == null) {
                Logcat logcat = Logcat.INSTANCE;
                logcat.e(TAG, "field " + this.fieldName + " is no exists.");
                return null;
            } else if (field != null) {
                try {
                    return (Type) field.get(obj);
                } catch (Exception e2) {
                    Logcat logcat2 = Logcat.INSTANCE;
                    logcat2.e(TAG, "get field error " + e2 + '.');
                    return null;
                }
            } else {
                return null;
            }
        }
        return (Type) invokeL.objValue;
    }
}
