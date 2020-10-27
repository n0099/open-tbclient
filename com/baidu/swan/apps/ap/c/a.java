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
    private ClassLoader dyK;
    private final Object[] dyR;
    private final Set<b<?>> dyI = new HashSet();
    private final Set<Object> dyJ = new HashSet();
    private int dyL = 0;
    private int dyM = 0;
    private int dyN = 0;
    private int dyO = 0;
    private int dyP = -1;
    private int dyQ = 0;

    private a(ClassLoader classLoader, Object... objArr) {
        this.dyK = classLoader;
        this.dyR = objArr == null ? new Object[0] : objArr;
    }

    public static a a(ClassLoader classLoader, Object... objArr) {
        return new a(classLoader, objArr);
    }

    public boolean aKT() {
        return this.dyQ > 0;
    }

    public a a(b<?>... bVarArr) {
        if (bVarArr != null) {
            this.dyI.addAll(Arrays.asList(bVarArr));
        }
        return this;
    }

    public a lj(int i) {
        Object[] objArr;
        if (!aKT() && i > 0) {
            this.dyQ = i;
            for (Object obj : this.dyR) {
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
        this.dyQ = 0;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Class<?>... clsArr) {
        return a(dyS, i, clsArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Package... packageArr) {
        return a(dyT, i, packageArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Annotation... annotationArr) {
        return a(dyU, i, annotationArr);
    }

    public a a(int i, @NonNull Method... methodArr) {
        return a(dyW, i, methodArr);
    }

    public a a(int i, @NonNull Field... fieldArr) {
        return a(dyV, i, fieldArr);
    }

    public a a(int i, Constructor<?>... constructorArr) {
        return a(dyX, i, constructorArr);
    }

    @RequiresApi(api = 26)
    public a a(int i, Parameter... parameterArr) {
        return a(dyY, i, parameterArr);
    }

    @SafeVarargs
    private final <TargeT> a a(@NonNull b<TargeT> bVar, int i, TargeT... targetArr) {
        if (!this.dyI.contains(bVar)) {
            int i2 = i - 1;
            if (i > 0 && targetArr != null && targetArr.length > 0) {
                for (TargeT target : targetArr) {
                    if (ab(target)) {
                        bVar.a(this, this.dyK, i2, target);
                    }
                }
            }
        }
        return this;
    }

    private <TargeT> boolean ab(TargeT target) {
        this.dyL++;
        if (target == null) {
            this.dyN++;
            return false;
        } else if (this.dyJ.contains(target)) {
            this.dyM++;
            return false;
        } else {
            this.dyJ.add(target);
            return true;
        }
    }
}
