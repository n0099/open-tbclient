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
/* loaded from: classes9.dex */
public final class a implements c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private ClassLoader dPX;
    private final Object[] dQe;
    private final Set<b<?>> dPV = new HashSet();
    private final Set<Object> dPW = new HashSet();
    private int dPY = 0;
    private int dPZ = 0;
    private int dQa = 0;
    private int dQb = 0;
    private int dQc = -1;
    private int dQd = 0;

    private a(ClassLoader classLoader, Object... objArr) {
        this.dPX = classLoader;
        this.dQe = objArr == null ? new Object[0] : objArr;
    }

    public static a a(ClassLoader classLoader, Object... objArr) {
        return new a(classLoader, objArr);
    }

    public boolean aOJ() {
        return this.dQd > 0;
    }

    public a a(b<?>... bVarArr) {
        if (bVarArr != null) {
            this.dPV.addAll(Arrays.asList(bVarArr));
        }
        return this;
    }

    public a kp(int i) {
        Object[] objArr;
        if (!aOJ() && i > 0) {
            this.dQd = i;
            for (Object obj : this.dQe) {
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
        this.dQd = 0;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Class<?>... clsArr) {
        return a(dQf, i, clsArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Package... packageArr) {
        return a(dQg, i, packageArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Annotation... annotationArr) {
        return a(dQh, i, annotationArr);
    }

    public a a(int i, @NonNull Method... methodArr) {
        return a(dQj, i, methodArr);
    }

    public a a(int i, @NonNull Field... fieldArr) {
        return a(dQi, i, fieldArr);
    }

    public a a(int i, Constructor<?>... constructorArr) {
        return a(dQk, i, constructorArr);
    }

    @RequiresApi(api = 26)
    public a a(int i, Parameter... parameterArr) {
        return a(dQl, i, parameterArr);
    }

    @SafeVarargs
    private final <TargeT> a a(@NonNull b<TargeT> bVar, int i, TargeT... targetArr) {
        if (!this.dPV.contains(bVar)) {
            int i2 = i - 1;
            if (i > 0 && targetArr != null && targetArr.length > 0) {
                for (TargeT target : targetArr) {
                    if (ac(target)) {
                        bVar.a(this, this.dPX, i2, target);
                    }
                }
            }
        }
        return this;
    }

    private <TargeT> boolean ac(TargeT target) {
        this.dPY++;
        if (target == null) {
            this.dQa++;
            return false;
        } else if (this.dPW.contains(target)) {
            this.dPZ++;
            return false;
        } else {
            this.dPW.add(target);
            return true;
        }
    }
}
