package com.baidu.swan.apps.ap.c;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public interface c {
    public static final b<Class<?>> del = new b<Class<?>>("CLASS") { // from class: com.baidu.swan.apps.ap.c.c.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.ap.c.b
        public void a(a aVar, ClassLoader classLoader, int i, Class<?> cls) {
            if (com.baidu.swan.apps.performance.b.c.awY() && classLoader != null && !TextUtils.isEmpty(cls.getName())) {
                try {
                    Class.forName(cls.getName(), true, classLoader);
                } catch (Throwable th) {
                    if (com.baidu.swan.apps.b.DEBUG) {
                        th.printStackTrace();
                    }
                }
            }
            aVar.a(i, cls.getPackage()).a(i, cls.getSuperclass()).a(i, cls.getComponentType()).a(i, cls.getDeclaringClass()).a(i, cls.getEnclosingClass()).a(i, cls.getInterfaces()).a(i, cls.getEnclosingConstructor()).a(i, cls.getEnclosingMethod()).a(i, cls.getDeclaredClasses()).a(i, cls.getDeclaredAnnotations()).a(i, cls.getDeclaredConstructors()).a(i, cls.getDeclaredFields()).a(i, cls.getDeclaredMethods());
        }
    };
    public static final b<Package> dem = new b<Package>("PACKAGE") { // from class: com.baidu.swan.apps.ap.c.c.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.ap.c.b
        public void a(a aVar, ClassLoader classLoader, int i, Package r5) {
            aVar.a(i, r5.getDeclaredAnnotations());
        }
    };
    public static final b<Annotation> den = new b<Annotation>("ANNOTATION") { // from class: com.baidu.swan.apps.ap.c.c.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.ap.c.b
        public void a(a aVar, ClassLoader classLoader, int i, Annotation annotation) {
            aVar.a(i, annotation.annotationType());
        }
    };
    public static final b<Field> deo = new b<Field>("FIELD") { // from class: com.baidu.swan.apps.ap.c.c.4
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.ap.c.b
        public void a(a aVar, ClassLoader classLoader, int i, Field field) {
            aVar.a(i, field.getType()).a(i, field.getDeclaredAnnotations()).a(i, field.getDeclaringClass());
        }
    };
    public static final b<Method> dep = new b<Method>("METHOD") { // from class: com.baidu.swan.apps.ap.c.c.5
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.ap.c.b
        public void a(a aVar, ClassLoader classLoader, int i, Method method) {
            aVar.a(i, method.getReturnType()).a(i, method.getDeclaredAnnotations()).a(i, method.getExceptionTypes()).a(i, method.getParameterTypes()).a(i, method.getDeclaringClass());
            for (Annotation[] annotationArr : method.getParameterAnnotations()) {
                aVar.a(i, annotationArr);
            }
            if (Build.VERSION.SDK_INT >= 26) {
                aVar.a(i, method.getParameters());
            }
        }
    };
    public static final b<Constructor<?>> deq = new b<Constructor<?>>("CONSTRUCTOR") { // from class: com.baidu.swan.apps.ap.c.c.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.ap.c.b
        public void a(a aVar, ClassLoader classLoader, int i, Constructor<?> constructor) {
            aVar.a(i, constructor.getDeclaringClass()).a(i, constructor.getDeclaredAnnotations()).a(i, constructor.getExceptionTypes()).a(i, constructor.getParameterTypes());
            for (Annotation[] annotationArr : constructor.getParameterAnnotations()) {
                aVar.a(i, annotationArr);
            }
            if (Build.VERSION.SDK_INT >= 26) {
                aVar.a(i, constructor.getParameters());
            }
        }
    };
    public static final b<Parameter> der = new b<Parameter>("PARAMETER") { // from class: com.baidu.swan.apps.ap.c.c.7
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.swan.apps.ap.c.b
        @RequiresApi(api = 26)
        public void a(a aVar, ClassLoader classLoader, int i, Parameter parameter) {
            aVar.a(i, parameter.getDeclaredAnnotations()).a(i, parameter.getType());
        }
    };
}
