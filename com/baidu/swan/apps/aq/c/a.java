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
/* loaded from: classes7.dex */
public final class a implements c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Set<b<?>> cSW = new HashSet();
    private final Set<Object> cSX = new HashSet();
    private int cSY = 0;
    private int cSZ = 0;
    private int cTa = 0;
    private int cTb = 0;
    private int cTc = -1;
    private int cTd = 0;
    private final Object[] cTe;

    private a(Object... objArr) {
        this.cTe = objArr == null ? new Object[0] : objArr;
    }

    public static a n(Object... objArr) {
        return new a(objArr);
    }

    public boolean axx() {
        return this.cTd > 0;
    }

    public a a(b<?>... bVarArr) {
        if (bVarArr != null) {
            this.cSW.addAll(Arrays.asList(bVarArr));
        }
        return this;
    }

    public a ii(int i) {
        Object[] objArr;
        if (!axx() && i > 0) {
            this.cTd = i;
            for (Object obj : this.cTe) {
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
        axy();
        this.cTd = 0;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Class<?>... clsArr) {
        return a(cTf, i, clsArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Package... packageArr) {
        return a(cTg, i, packageArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Annotation... annotationArr) {
        return a(cTh, i, annotationArr);
    }

    public a a(int i, @NonNull Method... methodArr) {
        return a(cTj, i, methodArr);
    }

    public a a(int i, @NonNull Field... fieldArr) {
        return a(cTi, i, fieldArr);
    }

    public a a(int i, Constructor<?>... constructorArr) {
        return a(cTk, i, constructorArr);
    }

    @RequiresApi(api = 26)
    public a a(int i, Parameter... parameterArr) {
        return a(cTl, i, parameterArr);
    }

    @SafeVarargs
    private final <TargeT> a a(@NonNull b<TargeT> bVar, int i, TargeT... targetArr) {
        if (!this.cSW.contains(bVar)) {
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
        this.cSY++;
        if (target == null) {
            this.cTa++;
            return false;
        } else if (this.cSX.contains(target)) {
            this.cSZ++;
            return false;
        } else {
            this.cSX.add(target);
            return true;
        }
    }

    private void m(String str, int i, int i2) {
        if (DEBUG) {
            int i3 = i + 1;
            if (-1 < i3) {
                this.cTc = (this.cTc < 0 || this.cTc > i3) ? i3 : this.cTc;
                this.cTb = i3 > this.cTb ? i3 : this.cTb;
            }
            int size = this.cSX.size();
            Object[] objArr = new Object[10];
            objArr[0] = str;
            if (i3 < 0) {
                i3 = this.cTd;
            }
            objArr[1] = Integer.valueOf(i3);
            objArr[2] = Integer.valueOf(this.cTc);
            objArr[3] = Integer.valueOf(this.cTb);
            objArr[4] = Integer.valueOf(i2);
            objArr[5] = NumberFormat.getPercentInstance().format(size / this.cSY);
            objArr[6] = Integer.valueOf(size);
            objArr[7] = Integer.valueOf(this.cTa);
            objArr[8] = Integer.valueOf(this.cSZ);
            objArr[9] = Integer.valueOf(this.cSY);
            Log.i("ClassWalker", String.format("load %13s => Depth:%3d[%2d/%-2d] Targets:%-7d Cached:%-7s Record:%-7d Void:%-7d Hit:%-7d Total:%-7d", objArr));
        }
    }

    private a axy() {
        if (DEBUG) {
            ArrayList<String> arrayList = new ArrayList();
            for (Object obj : this.cSX) {
                if (obj != null) {
                    arrayList.add("Cached => " + obj.getClass().getName() + " # " + obj);
                }
            }
            Collections.sort(arrayList);
            Log.i("ClassWalker", "ClassWalker report cache records:");
            for (String str : arrayList) {
                Log.i("ClassWalker", str);
            }
            m("Report", -2, this.cTe.length);
        }
        return this;
    }
}
