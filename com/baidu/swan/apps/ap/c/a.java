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
    private ClassLoader dqk;
    private final Object[] dqr;
    private final Set<b<?>> dqi = new HashSet();
    private final Set<Object> dqj = new HashSet();
    private int dql = 0;
    private int dqm = 0;
    private int dqn = 0;
    private int dqo = 0;
    private int dqp = -1;
    private int dqq = 0;

    private a(ClassLoader classLoader, Object... objArr) {
        this.dqk = classLoader;
        this.dqr = objArr == null ? new Object[0] : objArr;
    }

    public static a a(ClassLoader classLoader, Object... objArr) {
        return new a(classLoader, objArr);
    }

    public boolean aIZ() {
        return this.dqq > 0;
    }

    public a a(b<?>... bVarArr) {
        if (bVarArr != null) {
            this.dqi.addAll(Arrays.asList(bVarArr));
        }
        return this;
    }

    public a kY(int i) {
        Object[] objArr;
        if (!aIZ() && i > 0) {
            this.dqq = i;
            for (Object obj : this.dqr) {
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
        this.dqq = 0;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Class<?>... clsArr) {
        return a(dqs, i, clsArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Package... packageArr) {
        return a(dqt, i, packageArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Annotation... annotationArr) {
        return a(dqu, i, annotationArr);
    }

    public a a(int i, @NonNull Method... methodArr) {
        return a(dqw, i, methodArr);
    }

    public a a(int i, @NonNull Field... fieldArr) {
        return a(dqv, i, fieldArr);
    }

    public a a(int i, Constructor<?>... constructorArr) {
        return a(dqx, i, constructorArr);
    }

    @RequiresApi(api = 26)
    public a a(int i, Parameter... parameterArr) {
        return a(dqy, i, parameterArr);
    }

    @SafeVarargs
    private final <TargeT> a a(@NonNull b<TargeT> bVar, int i, TargeT... targetArr) {
        if (!this.dqi.contains(bVar)) {
            int i2 = i - 1;
            if (i > 0 && targetArr != null && targetArr.length > 0) {
                for (TargeT target : targetArr) {
                    if (ab(target)) {
                        bVar.a(this, this.dqk, i2, target);
                    }
                }
            }
        }
        return this;
    }

    private <TargeT> boolean ab(TargeT target) {
        this.dql++;
        if (target == null) {
            this.dqn++;
            return false;
        } else if (this.dqj.contains(target)) {
            this.dqm++;
            return false;
        } else {
            this.dqj.add(target);
            return true;
        }
    }
}
