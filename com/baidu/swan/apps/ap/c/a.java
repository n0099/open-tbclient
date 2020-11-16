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
/* loaded from: classes7.dex */
public final class a implements c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private ClassLoader dCV;
    private final Object[] dDc;
    private final Set<b<?>> dCT = new HashSet();
    private final Set<Object> dCU = new HashSet();
    private int dCW = 0;
    private int dCX = 0;
    private int dCY = 0;
    private int dCZ = 0;
    private int dDa = -1;
    private int dDb = 0;

    private a(ClassLoader classLoader, Object... objArr) {
        this.dCV = classLoader;
        this.dDc = objArr == null ? new Object[0] : objArr;
    }

    public static a a(ClassLoader classLoader, Object... objArr) {
        return new a(classLoader, objArr);
    }

    public boolean aML() {
        return this.dDb > 0;
    }

    public a a(b<?>... bVarArr) {
        if (bVarArr != null) {
            this.dCT.addAll(Arrays.asList(bVarArr));
        }
        return this;
    }

    public a lp(int i) {
        Object[] objArr;
        if (!aML() && i > 0) {
            this.dDb = i;
            for (Object obj : this.dDc) {
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
        this.dDb = 0;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Class<?>... clsArr) {
        return a(dDd, i, clsArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Package... packageArr) {
        return a(dDe, i, packageArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Annotation... annotationArr) {
        return a(dDf, i, annotationArr);
    }

    public a a(int i, @NonNull Method... methodArr) {
        return a(dDh, i, methodArr);
    }

    public a a(int i, @NonNull Field... fieldArr) {
        return a(dDg, i, fieldArr);
    }

    public a a(int i, Constructor<?>... constructorArr) {
        return a(dDi, i, constructorArr);
    }

    @RequiresApi(api = 26)
    public a a(int i, Parameter... parameterArr) {
        return a(dDj, i, parameterArr);
    }

    @SafeVarargs
    private final <TargeT> a a(@NonNull b<TargeT> bVar, int i, TargeT... targetArr) {
        if (!this.dCT.contains(bVar)) {
            int i2 = i - 1;
            if (i > 0 && targetArr != null && targetArr.length > 0) {
                for (TargeT target : targetArr) {
                    if (ab(target)) {
                        bVar.a(this, this.dCV, i2, target);
                    }
                }
            }
        }
        return this;
    }

    private <TargeT> boolean ab(TargeT target) {
        this.dCW++;
        if (target == null) {
            this.dCY++;
            return false;
        } else if (this.dCU.contains(target)) {
            this.dCX++;
            return false;
        } else {
            this.dCU.add(target);
            return true;
        }
    }
}
