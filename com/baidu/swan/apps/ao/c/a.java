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
    private final Object[] dRF;
    private ClassLoader dRy;
    private final Set<b<?>> dRw = new HashSet();
    private final Set<Object> dRx = new HashSet();
    private int dRz = 0;
    private int dRA = 0;
    private int dRB = 0;
    private int dRC = 0;
    private int dRD = -1;
    private int dRE = 0;

    private a(ClassLoader classLoader, Object... objArr) {
        this.dRy = classLoader;
        this.dRF = objArr == null ? new Object[0] : objArr;
    }

    public static a a(ClassLoader classLoader, Object... objArr) {
        return new a(classLoader, objArr);
    }

    public boolean aOM() {
        return this.dRE > 0;
    }

    public a a(b<?>... bVarArr) {
        if (bVarArr != null) {
            this.dRw.addAll(Arrays.asList(bVarArr));
        }
        return this;
    }

    public a kq(int i) {
        Object[] objArr;
        if (!aOM() && i > 0) {
            this.dRE = i;
            for (Object obj : this.dRF) {
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
        this.dRE = 0;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Class<?>... clsArr) {
        return a(dRG, i, clsArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Package... packageArr) {
        return a(dRH, i, packageArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Annotation... annotationArr) {
        return a(dRI, i, annotationArr);
    }

    public a a(int i, @NonNull Method... methodArr) {
        return a(dRK, i, methodArr);
    }

    public a a(int i, @NonNull Field... fieldArr) {
        return a(dRJ, i, fieldArr);
    }

    public a a(int i, Constructor<?>... constructorArr) {
        return a(dRL, i, constructorArr);
    }

    @RequiresApi(api = 26)
    public a a(int i, Parameter... parameterArr) {
        return a(dRM, i, parameterArr);
    }

    @SafeVarargs
    private final <TargeT> a a(@NonNull b<TargeT> bVar, int i, TargeT... targetArr) {
        if (!this.dRw.contains(bVar)) {
            int i2 = i - 1;
            if (i > 0 && targetArr != null && targetArr.length > 0) {
                for (TargeT target : targetArr) {
                    if (ae(target)) {
                        bVar.a(this, this.dRy, i2, target);
                    }
                }
            }
        }
        return this;
    }

    private <TargeT> boolean ae(TargeT target) {
        this.dRz++;
        if (target == null) {
            this.dRB++;
            return false;
        } else if (this.dRx.contains(target)) {
            this.dRA++;
            return false;
        } else {
            this.dRx.add(target);
            return true;
        }
    }
}
