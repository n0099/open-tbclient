package com.baidu.swan.apps.aq.c;

import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.Log;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes11.dex */
public final class a implements c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Object[] cPD;
    private final Set<b<?>> cPv = new HashSet();
    private final Set<Object> cPw = new HashSet();
    private int cPx = 0;
    private int cPy = 0;
    private int cPz = 0;
    private int cPA = 0;
    private int cPB = -1;
    private int cPC = 0;

    private a(Object... objArr) {
        this.cPD = objArr == null ? new Object[0] : objArr;
    }

    public static a n(Object... objArr) {
        return new a(objArr);
    }

    public boolean avj() {
        return this.cPC > 0;
    }

    public a a(b<?>... bVarArr) {
        if (bVarArr != null) {
            this.cPv.addAll(Arrays.asList(bVarArr));
        }
        return this;
    }

    public a hX(int i) {
        Object[] objArr;
        if (!avj() && i > 0) {
            this.cPC = i;
            for (Object obj : this.cPD) {
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
        avk();
        this.cPC = 0;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Class<?>... clsArr) {
        return a(cPE, i, clsArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Package... packageArr) {
        return a(cPF, i, packageArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Annotation... annotationArr) {
        return a(cPG, i, annotationArr);
    }

    public a a(int i, @NonNull Method... methodArr) {
        return a(cPI, i, methodArr);
    }

    public a a(int i, @NonNull Field... fieldArr) {
        return a(cPH, i, fieldArr);
    }

    public a a(int i, Constructor<?>... constructorArr) {
        return a(cPJ, i, constructorArr);
    }

    @RequiresApi(api = 26)
    public a a(int i, Parameter... parameterArr) {
        return a(cPK, i, parameterArr);
    }

    @SafeVarargs
    private final <TargeT> a a(@NonNull b<TargeT> bVar, int i, TargeT... targetArr) {
        if (!this.cPv.contains(bVar)) {
            int i2 = i - 1;
            if (i > 0 && targetArr != null && targetArr.length > 0) {
                for (TargeT target : targetArr) {
                    if (U(target)) {
                        bVar.a(this, i2, target);
                    }
                }
                m(bVar.name, i2, targetArr.length);
            }
        }
        return this;
    }

    private <TargeT> boolean U(TargeT target) {
        this.cPx++;
        if (target == null) {
            this.cPz++;
            return false;
        } else if (this.cPw.contains(target)) {
            this.cPy++;
            return false;
        } else {
            this.cPw.add(target);
            return true;
        }
    }

    private void m(String str, int i, int i2) {
        if (DEBUG) {
            int i3 = i + 1;
            if (-1 < i3) {
                this.cPB = (this.cPB < 0 || this.cPB > i3) ? i3 : this.cPB;
                this.cPA = i3 > this.cPA ? i3 : this.cPA;
            }
            int size = this.cPw.size();
            Object[] objArr = new Object[10];
            objArr[0] = str;
            if (i3 < 0) {
                i3 = this.cPC;
            }
            objArr[1] = Integer.valueOf(i3);
            objArr[2] = Integer.valueOf(this.cPB);
            objArr[3] = Integer.valueOf(this.cPA);
            objArr[4] = Integer.valueOf(i2);
            objArr[5] = NumberFormat.getPercentInstance().format(size / this.cPx);
            objArr[6] = Integer.valueOf(size);
            objArr[7] = Integer.valueOf(this.cPz);
            objArr[8] = Integer.valueOf(this.cPy);
            objArr[9] = Integer.valueOf(this.cPx);
            Log.i("ClassWalker", String.format("load %13s => Depth:%3d[%2d/%-2d] Targets:%-7d Cached:%-7s Record:%-7d Void:%-7d Hit:%-7d Total:%-7d", objArr));
        }
    }

    private a avk() {
        if (DEBUG) {
            ArrayList<String> arrayList = new ArrayList();
            for (Object obj : this.cPw) {
                if (obj != null) {
                    arrayList.add("Cached => " + obj.getClass().getName() + " # " + obj);
                }
            }
            Collections.sort(arrayList);
            Log.i("ClassWalker", "ClassWalker report cache records:");
            for (String str : arrayList) {
                Log.i("ClassWalker", str);
            }
            m("Report", -2, this.cPD.length);
        }
        return this;
    }
}
