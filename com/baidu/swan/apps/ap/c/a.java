package com.baidu.swan.apps.ap.c;

import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes25.dex */
public final class a implements c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private ClassLoader dJT;
    private final Object[] dKa;
    private final Set<b<?>> dJR = new HashSet();
    private final Set<Object> dJS = new HashSet();
    private int dJU = 0;
    private int dJV = 0;
    private int dJW = 0;
    private int dJX = 0;
    private int dJY = -1;
    private int dJZ = 0;

    private a(ClassLoader classLoader, Object... objArr) {
        this.dJT = classLoader;
        this.dKa = objArr == null ? new Object[0] : objArr;
    }

    public static a a(ClassLoader classLoader, Object... objArr) {
        return new a(classLoader, objArr);
    }

    public boolean aPR() {
        return this.dJZ > 0;
    }

    public a a(b<?>... bVarArr) {
        if (bVarArr != null) {
            this.dJR.addAll(Arrays.asList(bVarArr));
        }
        return this;
    }

    public a lN(int i) {
        Object[] objArr;
        if (!aPR() && i > 0) {
            this.dJZ = i;
            for (Object obj : this.dKa) {
                if (obj instanceof Class) {
                    a(i, (Class) obj);
                } else if (obj instanceof Annotation) {
                    a(i, (Annotation) obj);
                } else if (obj instanceof Method) {
                    a(i, (Method) obj);
                } else if (obj instanceof Field) {
                    a(i, (Field) obj);
                } else if (obj instanceof Constructor) {
                    a(i, (Constructor) obj);
                } else if (obj != null) {
                    a(i, obj.getClass());
                }
            }
        }
        this.dJZ = 0;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Class<?>... clsArr) {
        return a(dKb, i, clsArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Package... packageArr) {
        return a(dKc, i, packageArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Annotation... annotationArr) {
        return a(dKd, i, annotationArr);
    }

    public a a(int i, @NonNull Method... methodArr) {
        return a(dKf, i, methodArr);
    }

    public a a(int i, @NonNull Field... fieldArr) {
        return a(dKe, i, fieldArr);
    }

    public a a(int i, Constructor<?>... constructorArr) {
        return a(dKg, i, constructorArr);
    }

    @RequiresApi(api = 26)
    public a a(int i, Parameter... parameterArr) {
        return a(dKh, i, parameterArr);
    }

    @SafeVarargs
    private final <TargeT> a a(@NonNull b<TargeT> bVar, int i, TargeT... targetArr) {
        if (!this.dJR.contains(bVar)) {
            int i2 = i - 1;
            if (i > 0 && targetArr != null && targetArr.length > 0) {
                for (TargeT target : targetArr) {
                    if (ab(target)) {
                        bVar.a(this, this.dJT, i2, target);
                    }
                }
            }
        }
        return this;
    }

    private <TargeT> boolean ab(TargeT target) {
        this.dJU++;
        if (target == null) {
            this.dJW++;
            return false;
        } else if (this.dJS.contains(target)) {
            this.dJV++;
            return false;
        } else {
            this.dJS.add(target);
            return true;
        }
    }
}
