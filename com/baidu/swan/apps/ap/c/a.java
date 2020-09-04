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
    private ClassLoader dcb;
    private final Object[] dci;
    private final Set<b<?>> dbZ = new HashSet();
    private final Set<Object> dca = new HashSet();
    private int dcc = 0;
    private int dcd = 0;
    private int dce = 0;
    private int dcf = 0;
    private int dcg = -1;
    private int dch = 0;

    private a(ClassLoader classLoader, Object... objArr) {
        this.dcb = classLoader;
        this.dci = objArr == null ? new Object[0] : objArr;
    }

    public static a a(ClassLoader classLoader, Object... objArr) {
        return new a(classLoader, objArr);
    }

    public boolean aFG() {
        return this.dch > 0;
    }

    public a a(b<?>... bVarArr) {
        if (bVarArr != null) {
            this.dbZ.addAll(Arrays.asList(bVarArr));
        }
        return this;
    }

    public a kq(int i) {
        Object[] objArr;
        if (!aFG() && i > 0) {
            this.dch = i;
            for (Object obj : this.dci) {
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
        this.dch = 0;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Class<?>... clsArr) {
        return a(dcj, i, clsArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Package... packageArr) {
        return a(dck, i, packageArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Annotation... annotationArr) {
        return a(dcl, i, annotationArr);
    }

    public a a(int i, @NonNull Method... methodArr) {
        return a(dcn, i, methodArr);
    }

    public a a(int i, @NonNull Field... fieldArr) {
        return a(dcm, i, fieldArr);
    }

    public a a(int i, Constructor<?>... constructorArr) {
        return a(dco, i, constructorArr);
    }

    @RequiresApi(api = 26)
    public a a(int i, Parameter... parameterArr) {
        return a(dcp, i, parameterArr);
    }

    @SafeVarargs
    private final <TargeT> a a(@NonNull b<TargeT> bVar, int i, TargeT... targetArr) {
        if (!this.dbZ.contains(bVar)) {
            int i2 = i - 1;
            if (i > 0 && targetArr != null && targetArr.length > 0) {
                for (TargeT target : targetArr) {
                    if (X(target)) {
                        bVar.a(this, this.dcb, i2, target);
                    }
                }
            }
        }
        return this;
    }

    private <TargeT> boolean X(TargeT target) {
        this.dcc++;
        if (target == null) {
            this.dce++;
            return false;
        } else if (this.dca.contains(target)) {
            this.dcd++;
            return false;
        } else {
            this.dca.add(target);
            return true;
        }
    }
}
