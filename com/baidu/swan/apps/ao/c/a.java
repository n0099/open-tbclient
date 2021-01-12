package com.baidu.swan.apps.ao.c;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes8.dex */
public final class a implements c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private ClassLoader dNR;
    private final Object[] dNY;
    private final Set<b<?>> dNP = new HashSet();
    private final Set<Object> dNQ = new HashSet();
    private int dNS = 0;
    private int dNT = 0;
    private int dNU = 0;
    private int dNV = 0;
    private int dNW = -1;
    private int dNX = 0;

    private a(ClassLoader classLoader, Object... objArr) {
        this.dNR = classLoader;
        this.dNY = objArr == null ? new Object[0] : objArr;
    }

    public static a a(ClassLoader classLoader, Object... objArr) {
        return new a(classLoader, objArr);
    }

    public boolean aOq() {
        return this.dNX > 0;
    }

    public a a(b<?>... bVarArr) {
        if (bVarArr != null) {
            this.dNP.addAll(Arrays.asList(bVarArr));
        }
        return this;
    }

    public a km(int i) {
        Object[] objArr;
        if (!aOq() && i > 0) {
            this.dNX = i;
            for (Object obj : this.dNY) {
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
        this.dNX = 0;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Class<?>... clsArr) {
        return a(dNZ, i, clsArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Package... packageArr) {
        return a(dOa, i, packageArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Annotation... annotationArr) {
        return a(dOb, i, annotationArr);
    }

    public a a(int i, @NonNull Method... methodArr) {
        return a(dOd, i, methodArr);
    }

    public a a(int i, @NonNull Field... fieldArr) {
        return a(dOc, i, fieldArr);
    }

    public a a(int i, Constructor<?>... constructorArr) {
        return a(dOe, i, constructorArr);
    }

    @RequiresApi(api = 26)
    public a a(int i, Parameter... parameterArr) {
        return a(dOf, i, parameterArr);
    }

    @SafeVarargs
    private final <TargeT> a a(@NonNull b<TargeT> bVar, int i, TargeT... targetArr) {
        if (!this.dNP.contains(bVar)) {
            int i2 = i - 1;
            if (i > 0 && targetArr != null && targetArr.length > 0) {
                for (TargeT target : targetArr) {
                    if (ac(target)) {
                        bVar.a(this, this.dNR, i2, target);
                    }
                }
            }
        }
        return this;
    }

    private <TargeT> boolean ac(TargeT target) {
        this.dNS++;
        if (target == null) {
            this.dNU++;
            return false;
        } else if (this.dNQ.contains(target)) {
            this.dNT++;
            return false;
        } else {
            this.dNQ.add(target);
            return true;
        }
    }
}
