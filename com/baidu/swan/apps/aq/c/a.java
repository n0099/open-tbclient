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
    private final Set<b<?>> cKL = new HashSet();
    private final Set<Object> cKM = new HashSet();
    private int cKN = 0;
    private int cKO = 0;
    private int cKP = 0;
    private int cKQ = 0;
    private int cKR = -1;
    private int cKS = 0;
    private final Object[] cKT;

    private a(Object... objArr) {
        this.cKT = objArr == null ? new Object[0] : objArr;
    }

    public static a n(Object... objArr) {
        return new a(objArr);
    }

    public boolean aud() {
        return this.cKS > 0;
    }

    public a a(b<?>... bVarArr) {
        if (bVarArr != null) {
            this.cKL.addAll(Arrays.asList(bVarArr));
        }
        return this;
    }

    public a hM(int i) {
        Object[] objArr;
        if (!aud() && i > 0) {
            this.cKS = i;
            for (Object obj : this.cKT) {
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
        aue();
        this.cKS = 0;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Class<?>... clsArr) {
        return a(cKU, i, clsArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Package... packageArr) {
        return a(cKV, i, packageArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i, @NonNull Annotation... annotationArr) {
        return a(cKW, i, annotationArr);
    }

    public a a(int i, @NonNull Method... methodArr) {
        return a(cKY, i, methodArr);
    }

    public a a(int i, @NonNull Field... fieldArr) {
        return a(cKX, i, fieldArr);
    }

    public a a(int i, Constructor<?>... constructorArr) {
        return a(cKZ, i, constructorArr);
    }

    @RequiresApi(api = 26)
    public a a(int i, Parameter... parameterArr) {
        return a(cLa, i, parameterArr);
    }

    @SafeVarargs
    private final <TargeT> a a(@NonNull b<TargeT> bVar, int i, TargeT... targetArr) {
        if (!this.cKL.contains(bVar)) {
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
        this.cKN++;
        if (target == null) {
            this.cKP++;
            return false;
        } else if (this.cKM.contains(target)) {
            this.cKO++;
            return false;
        } else {
            this.cKM.add(target);
            return true;
        }
    }

    private void m(String str, int i, int i2) {
        if (DEBUG) {
            int i3 = i + 1;
            if (-1 < i3) {
                this.cKR = (this.cKR < 0 || this.cKR > i3) ? i3 : this.cKR;
                this.cKQ = i3 > this.cKQ ? i3 : this.cKQ;
            }
            int size = this.cKM.size();
            Object[] objArr = new Object[10];
            objArr[0] = str;
            if (i3 < 0) {
                i3 = this.cKS;
            }
            objArr[1] = Integer.valueOf(i3);
            objArr[2] = Integer.valueOf(this.cKR);
            objArr[3] = Integer.valueOf(this.cKQ);
            objArr[4] = Integer.valueOf(i2);
            objArr[5] = NumberFormat.getPercentInstance().format(size / this.cKN);
            objArr[6] = Integer.valueOf(size);
            objArr[7] = Integer.valueOf(this.cKP);
            objArr[8] = Integer.valueOf(this.cKO);
            objArr[9] = Integer.valueOf(this.cKN);
            Log.i("ClassWalker", String.format("load %13s => Depth:%3d[%2d/%-2d] Targets:%-7d Cached:%-7s Record:%-7d Void:%-7d Hit:%-7d Total:%-7d", objArr));
        }
    }

    private a aue() {
        if (DEBUG) {
            ArrayList<String> arrayList = new ArrayList();
            for (Object obj : this.cKM) {
                if (obj != null) {
                    arrayList.add("Cached => " + obj.getClass().getName() + " # " + obj);
                }
            }
            Collections.sort(arrayList);
            Log.i("ClassWalker", "ClassWalker report cache records:");
            for (String str : arrayList) {
                Log.i("ClassWalker", str);
            }
            m("Report", -2, this.cKT.length);
        }
        return this;
    }
}
