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
/* loaded from: classes3.dex */
public final class a implements c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private ClassLoader ded;
    private final Object[] dek;
    private final Set<b<?>> deb = new HashSet();
    private final Set<Object> dec = new HashSet();
    private int dee = 0;
    private int def = 0;
    private int deg = 0;
    private int deh = 0;
    private int dei = -1;
    private int dej = 0;

    private a(ClassLoader classLoader, Object... objArr) {
        this.ded = classLoader;
        this.dek = objArr == null ? new Object[0] : objArr;
    }

    public static a a(ClassLoader classLoader, Object... objArr) {
        return new a(classLoader, objArr);
    }

    public boolean aGq() {
        return this.dej > 0;
    }

    public a a(b<?>... bVarArr) {
        if (bVarArr != null) {
            this.deb.addAll(Arrays.asList(bVarArr));
        }
        return this;
    }

    public a kB(int i) {
        Object[] objArr;
        if (!aGq() && i > 0) {
            this.dej = i;
            for (Object obj : this.dek) {
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
        this.dej = 0;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Class<?>... clsArr) {
        return a(del, i, clsArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Package... packageArr) {
        return a(dem, i, packageArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Annotation... annotationArr) {
        return a(den, i, annotationArr);
    }

    public a a(int i, @NonNull Method... methodArr) {
        return a(dep, i, methodArr);
    }

    public a a(int i, @NonNull Field... fieldArr) {
        return a(deo, i, fieldArr);
    }

    public a a(int i, Constructor<?>... constructorArr) {
        return a(deq, i, constructorArr);
    }

    @RequiresApi(api = 26)
    public a a(int i, Parameter... parameterArr) {
        return a(der, i, parameterArr);
    }

    @SafeVarargs
    private final <TargeT> a a(@NonNull b<TargeT> bVar, int i, TargeT... targetArr) {
        if (!this.deb.contains(bVar)) {
            int i2 = i - 1;
            if (i > 0 && targetArr != null && targetArr.length > 0) {
                for (TargeT target : targetArr) {
                    if (Y(target)) {
                        bVar.a(this, this.ded, i2, target);
                    }
                }
            }
        }
        return this;
    }

    private <TargeT> boolean Y(TargeT target) {
        this.dee++;
        if (target == null) {
            this.deg++;
            return false;
        } else if (this.dec.contains(target)) {
            this.def++;
            return false;
        } else {
            this.dec.add(target);
            return true;
        }
    }
}
