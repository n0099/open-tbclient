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
    private ClassLoader dSD;
    private final Object[] dSK;
    private final Set<b<?>> dSB = new HashSet();
    private final Set<Object> dSC = new HashSet();
    private int dSE = 0;
    private int dSF = 0;
    private int dSG = 0;
    private int dSH = 0;
    private int dSI = -1;
    private int dSJ = 0;

    private a(ClassLoader classLoader, Object... objArr) {
        this.dSD = classLoader;
        this.dSK = objArr == null ? new Object[0] : objArr;
    }

    public static a a(ClassLoader classLoader, Object... objArr) {
        return new a(classLoader, objArr);
    }

    public boolean aSj() {
        return this.dSJ > 0;
    }

    public a a(b<?>... bVarArr) {
        if (bVarArr != null) {
            this.dSB.addAll(Arrays.asList(bVarArr));
        }
        return this;
    }

    public a lS(int i) {
        Object[] objArr;
        if (!aSj() && i > 0) {
            this.dSJ = i;
            for (Object obj : this.dSK) {
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
        this.dSJ = 0;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Class<?>... clsArr) {
        return a(dSL, i, clsArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Package... packageArr) {
        return a(dSM, i, packageArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Annotation... annotationArr) {
        return a(dSN, i, annotationArr);
    }

    public a a(int i, @NonNull Method... methodArr) {
        return a(dSP, i, methodArr);
    }

    public a a(int i, @NonNull Field... fieldArr) {
        return a(dSO, i, fieldArr);
    }

    public a a(int i, Constructor<?>... constructorArr) {
        return a(dSQ, i, constructorArr);
    }

    @RequiresApi(api = 26)
    public a a(int i, Parameter... parameterArr) {
        return a(dSR, i, parameterArr);
    }

    @SafeVarargs
    private final <TargeT> a a(@NonNull b<TargeT> bVar, int i, TargeT... targetArr) {
        if (!this.dSB.contains(bVar)) {
            int i2 = i - 1;
            if (i > 0 && targetArr != null && targetArr.length > 0) {
                for (TargeT target : targetArr) {
                    if (ac(target)) {
                        bVar.a(this, this.dSD, i2, target);
                    }
                }
            }
        }
        return this;
    }

    private <TargeT> boolean ac(TargeT target) {
        this.dSE++;
        if (target == null) {
            this.dSG++;
            return false;
        } else if (this.dSC.contains(target)) {
            this.dSF++;
            return false;
        } else {
            this.dSC.add(target);
            return true;
        }
    }
}
