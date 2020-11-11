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
/* loaded from: classes10.dex */
public final class a implements c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private ClassLoader dEC;
    private final Object[] dEJ;
    private final Set<b<?>> dEA = new HashSet();
    private final Set<Object> dEB = new HashSet();
    private int dED = 0;
    private int dEE = 0;
    private int dEF = 0;
    private int dEG = 0;
    private int dEH = -1;
    private int dEI = 0;

    private a(ClassLoader classLoader, Object... objArr) {
        this.dEC = classLoader;
        this.dEJ = objArr == null ? new Object[0] : objArr;
    }

    public static a a(ClassLoader classLoader, Object... objArr) {
        return new a(classLoader, objArr);
    }

    public boolean aNt() {
        return this.dEI > 0;
    }

    public a a(b<?>... bVarArr) {
        if (bVarArr != null) {
            this.dEA.addAll(Arrays.asList(bVarArr));
        }
        return this;
    }

    public a lt(int i) {
        Object[] objArr;
        if (!aNt() && i > 0) {
            this.dEI = i;
            for (Object obj : this.dEJ) {
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
        this.dEI = 0;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Class<?>... clsArr) {
        return a(dEK, i, clsArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Package... packageArr) {
        return a(dEL, i, packageArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Annotation... annotationArr) {
        return a(dEM, i, annotationArr);
    }

    public a a(int i, @NonNull Method... methodArr) {
        return a(dEO, i, methodArr);
    }

    public a a(int i, @NonNull Field... fieldArr) {
        return a(dEN, i, fieldArr);
    }

    public a a(int i, Constructor<?>... constructorArr) {
        return a(dEP, i, constructorArr);
    }

    @RequiresApi(api = 26)
    public a a(int i, Parameter... parameterArr) {
        return a(dEQ, i, parameterArr);
    }

    @SafeVarargs
    private final <TargeT> a a(@NonNull b<TargeT> bVar, int i, TargeT... targetArr) {
        if (!this.dEA.contains(bVar)) {
            int i2 = i - 1;
            if (i > 0 && targetArr != null && targetArr.length > 0) {
                for (TargeT target : targetArr) {
                    if (ab(target)) {
                        bVar.a(this, this.dEC, i2, target);
                    }
                }
            }
        }
        return this;
    }

    private <TargeT> boolean ab(TargeT target) {
        this.dED++;
        if (target == null) {
            this.dEF++;
            return false;
        } else if (this.dEB.contains(target)) {
            this.dEE++;
            return false;
        } else {
            this.dEB.add(target);
            return true;
        }
    }
}
