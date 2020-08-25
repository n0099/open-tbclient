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
/* loaded from: classes8.dex */
public final class a implements c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private ClassLoader dbX;
    private final Object[] dce;
    private final Set<b<?>> dbV = new HashSet();
    private final Set<Object> dbW = new HashSet();
    private int dbY = 0;
    private int dbZ = 0;
    private int dca = 0;
    private int dcb = 0;
    private int dcc = -1;
    private int dcd = 0;

    private a(ClassLoader classLoader, Object... objArr) {
        this.dbX = classLoader;
        this.dce = objArr == null ? new Object[0] : objArr;
    }

    public static a a(ClassLoader classLoader, Object... objArr) {
        return new a(classLoader, objArr);
    }

    public boolean aFG() {
        return this.dcd > 0;
    }

    public a a(b<?>... bVarArr) {
        if (bVarArr != null) {
            this.dbV.addAll(Arrays.asList(bVarArr));
        }
        return this;
    }

    public a kq(int i) {
        Object[] objArr;
        if (!aFG() && i > 0) {
            this.dcd = i;
            for (Object obj : this.dce) {
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
        this.dcd = 0;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Class<?>... clsArr) {
        return a(dcf, i, clsArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Package... packageArr) {
        return a(dcg, i, packageArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Annotation... annotationArr) {
        return a(dch, i, annotationArr);
    }

    public a a(int i, @NonNull Method... methodArr) {
        return a(dcj, i, methodArr);
    }

    public a a(int i, @NonNull Field... fieldArr) {
        return a(dci, i, fieldArr);
    }

    public a a(int i, Constructor<?>... constructorArr) {
        return a(dck, i, constructorArr);
    }

    @RequiresApi(api = 26)
    public a a(int i, Parameter... parameterArr) {
        return a(dcl, i, parameterArr);
    }

    @SafeVarargs
    private final <TargeT> a a(@NonNull b<TargeT> bVar, int i, TargeT... targetArr) {
        if (!this.dbV.contains(bVar)) {
            int i2 = i - 1;
            if (i > 0 && targetArr != null && targetArr.length > 0) {
                for (TargeT target : targetArr) {
                    if (X(target)) {
                        bVar.a(this, this.dbX, i2, target);
                    }
                }
            }
        }
        return this;
    }

    private <TargeT> boolean X(TargeT target) {
        this.dbY++;
        if (target == null) {
            this.dca++;
            return false;
        } else if (this.dbW.contains(target)) {
            this.dbZ++;
            return false;
        } else {
            this.dbW.add(target);
            return true;
        }
    }
}
